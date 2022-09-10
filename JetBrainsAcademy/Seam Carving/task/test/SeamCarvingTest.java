import org.apache.commons.codec.binary.Hex;
import org.hyperskill.hstest.testcase.TestCase;
import org.hyperskill.hstest.stage.StageTest;
import org.hyperskill.hstest.testcase.CheckResult;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

class CheckFailException extends Exception {
    public CheckFailException(String s) {
        super(s);
    }
}

class OutFile {
    String hash;
    String filename;
    int width;
    int height;
    String goodImgPath;

    OutFile(String filename, int width, int height, String hash, String goodImgPath) {
        this.filename = filename;
        this.width = width;
        this.height = height;
        this.hash = hash;
        this.goodImgPath = goodImgPath;
    }

    public boolean compareWithActualMD5() throws CheckFailException {
        try {
            File imgPath = new File(filename);
            BufferedImage sourceImage = ImageIO.read(imgPath);

            BufferedImage rgbImage =
                new BufferedImage(sourceImage.getWidth(), sourceImage.getHeight(), BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < sourceImage.getWidth(); i++) {
                for (int j = 0; j < sourceImage.getHeight(); j++) {
                    rgbImage.setRGB(i, j, sourceImage.getRGB(i, j));
                }
            }

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(rgbImage, "bmp", baos);

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(baos.toByteArray());
            byte[] digest = md.digest();
            String actualHash = Hex.encodeHexString(digest);
            if (!actualHash.equalsIgnoreCase(hash)) {
                throw new CheckFailException(
                    String.format(
                        "Hash sum of your image (%s) does not match expected value",
                        actualHash));
            }
        } catch (IOException e) {
            throw new CheckFailException(
                String.format(
                    "Could not read output file '%s'. Please check you produce output file",
                    filename));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new CheckFailException("Internal test error. please report to Hyperskill team");
        }

        return true;
    }

    public boolean comparePixels() throws CheckFailException{
        try {
            File imgPath = new File(filename);
            BufferedImage sourceImage = ImageIO.read(imgPath);

            File goodImgFilePath = new File(goodImgPath);
            BufferedImage goodImage = ImageIO.read(goodImgFilePath);

            final double maxDiff = 20.0; //Experimentally determined; larger for looser match
            int windowSize = 20; // Window for color averaging
            for (int x = 0; x < sourceImage.getWidth() - windowSize; x+=windowSize){
                for (int y = 0; y < sourceImage.getHeight() - windowSize; y+=windowSize){

                    long sourceColorSumRed, sourceColorSumGreen, sourceColorSumBlue;
                    sourceColorSumRed = sourceColorSumGreen = sourceColorSumBlue = 0;
                    long goodColorSumRed, goodColorSumGreen, goodColorSumBlue;
                    goodColorSumRed = goodColorSumGreen = goodColorSumBlue = 0;
                    for (int i = x; i < x + windowSize; i++){
                        for (int j = y; j < y + windowSize; j++){
                            Color sourceColor = new Color(sourceImage.getRGB(i, j));
                            Color goodColor = new Color(goodImage.getRGB(i, j));

                            sourceColorSumRed += sourceColor.getRed();
                            sourceColorSumGreen += sourceColor.getGreen();
                            sourceColorSumBlue += sourceColor.getBlue();

                            goodColorSumRed += goodColor.getRed();
                            goodColorSumGreen += goodColor.getGreen();
                            goodColorSumBlue += goodColor.getBlue();
                        }
                    }
                    float sampleSize = (float)windowSize * windowSize;

                    //Find average colors for the zone
                    Color sourceColor = new Color((int)(sourceColorSumRed / sampleSize), (int)(sourceColorSumGreen / sampleSize), (int)(sourceColorSumBlue / sampleSize));
                    Color goodColor = new Color((int)(goodColorSumRed / sampleSize), (int)(goodColorSumGreen / sampleSize), (int)(goodColorSumBlue / sampleSize));

                    //See how far apart colors are in color-space
                    double colorDistance = Math.sqrt(Math.pow(sourceColor.getRed() - goodColor.getRed(), 2.0) +
                            Math.pow(sourceColor.getBlue() - goodColor.getBlue(), 2.0) +
                            Math.pow(sourceColor.getGreen() - goodColor.getGreen(), 2.0));


                    if (colorDistance > maxDiff){
                        throw new CheckFailException(
                                String.format(
                                        "Average pixel color of the zone (%d, %d)-(%d, %d) in your image does not match expected value." +
                                                " Color space difference: %f. \n" +
                                                "Output: (%d, %d, %d) vs Reference: (%d, %d, %d)",
                                        x, y, x + windowSize, y + windowSize, colorDistance, sourceColor.getRed(), sourceColor.getGreen(), sourceColor.getBlue(),
                                        goodColor.getRed(),goodColor.getGreen(),goodColor.getBlue()));
                    }
                }
            }

        } catch (IOException e) {
            throw new CheckFailException(
                    String.format(
                            "Could not read output file '%s'. Please check you produce output file",
                            filename));
        }

        return true;
    }

    public boolean compareActualDimensions() throws CheckFailException {
        try {
            BufferedImage image = ImageIO.read(new File(filename));

            if (image == null) {
                throw new CheckFailException(
                    String.format(
                        "File format error. Looks like your output '%s' is not a valid image file.",
                        filename));
            }

            if (image.getWidth() != width) {
                throw new CheckFailException(
                    String.format(
                        "Dimensions mismatch. Output image width: %d; expected width: %d",
                        image.getWidth(), width));
            }

            if (image.getHeight() != height) {
                throw new CheckFailException(
                    String.format(
                        "Dimensions mismatch. Output image height: %d; expected height: %d",
                        image.getHeight(), height));
            }

        } catch (IOException e) {
            throw new CheckFailException(
                String.format(
                    "Could not read output file '%s'. Please check you produce output file",
                    filename));
        }

        return true;
    }
}

public class SeamCarvingTest extends StageTest<OutFile> {

    @Override
    public List<TestCase<OutFile>> generate() {

        return Arrays.asList(
            new TestCase<OutFile>()
                .addArguments(
                    "-in", "test/small.png",
                    "-out", "test/small-reduced.png",
                    "-width", "1",
                    "-height", "1")
                .setAttach(new OutFile(
                    "test/small-reduced.png", 14, 9,
                    "3e0266a991347682591a4955c9b2dd8e", "test/small-pass.png"))
                .setTimeLimit(2 * 60 * 1000),

            new TestCase<OutFile>()
                .addArguments(
                    "-in", "test/blue.png",
                    "-out", "test/blue-reduced.png",
                    "-width", "125",
                    "-height", "50")
                .setAttach(new OutFile(
                    "test/blue-reduced.png", 375, 284,
                    "e73c04ad79d30ebef82b27f35b71dd92", "test/blue-pass.png"))
                .setTimeLimit(2 * 60 * 1000),

            new TestCase<OutFile>()
                .addArguments(
                    "-in", "test/trees.png",
                    "-out", "test/trees-reduced.png",
                    "-width", "100",
                    "-height", "30")
                .setAttach(new OutFile(
                    "test/trees-reduced.png", 500, 399,
                    "65603cba81d3ee6dedeeb5777d6665c5", "test/trees-pass.png"))
                .setTimeLimit(2 * 60 * 1000)
        );
    }

    @Override
    public CheckResult check(String reply, OutFile expectedFile) {
        try {
            expectedFile.compareActualDimensions();
            //expectedFile.compareWithActualMD5();
            expectedFile.comparePixels();
        } catch (CheckFailException e) {
            return CheckResult.wrong(e.getMessage());
        }

        return CheckResult.correct();
    }
}
