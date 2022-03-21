import org.apache.commons.codec.binary.Hex;
import org.hyperskill.hstest.testcase.TestCase;
import org.hyperskill.hstest.stage.StageTest;
import org.hyperskill.hstest.testcase.CheckResult;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
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

    OutFile(String filename, int width, int height, String hash) {
        this.filename = filename;
        this.width = width;
        this.height = height;
        this.hash = hash;
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
                .addArguments("-in", "test/small.png", "-out", "test/small-negative.png")
                .setAttach(new OutFile("test/small-negative.png",15, 10, "b25b6f88aaa616e81c04cf3bc2713946")),

            new TestCase<OutFile>()
                .addArguments("-in", "test/blue.png", "-out", "test/blue-negative.png")
                .setAttach(new OutFile("test/blue-negative.png", 500, 334, "f2f4c0ea34926b1a711a6d04bd108923")),

            new TestCase<OutFile>()
                .addArguments("-in", "test/trees.png", "-out", "test/trees-negative.png")
                .setAttach(new OutFile("test/trees-negative.png", 600, 429, "e6eaf77401b4d6d9c27368bdb11a0862"))
        );
    }

    @Override
    public CheckResult check(String reply, OutFile expectedFile) {
        try {
            expectedFile.compareActualDimensions();
            expectedFile.compareWithActualMD5();
        } catch (CheckFailException e) {
            return CheckResult.wrong(e.getMessage());
        }

        return CheckResult.correct();
    }
}
