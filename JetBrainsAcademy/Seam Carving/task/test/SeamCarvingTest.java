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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CheckFailException extends Exception {
    public CheckFailException(String s) {
        super(s);
    }
}

class Image {
    private BufferedImage image;

    Image(String filename) throws IOException {
        image = ImageIO.read(new File(filename));
    }

    private int dx2(int x, int y) {
        if (x == 0) {
            return dx2(x + 1, y);
        }
        else if (x == image.getWidth() - 1) {
            return dx2(x - 1, y);
        }
        else {
            Color l = new Color(image.getRGB(x - 1, y));
            Color r = new Color(image.getRGB(x + 1, y));
            return (l.getRed() - r.getRed()) * (l.getRed() - r.getRed()) +
                (l.getGreen() - r.getGreen()) * (l.getGreen() - r.getGreen()) +
                (l.getBlue() - r.getBlue()) * (l.getBlue() - r.getBlue());
        }
    }

    private int dy2(int x, int y) {
        if (y == 0) {
            return dy2(x, y + 1);
        }
        else if (y == image.getHeight() - 1) {
            return dy2(x, y - 1);
        }
        else {
            Color t = new Color(image.getRGB(x, y - 1));
            Color b = new Color(image.getRGB(x, y + 1));
            return (t.getRed() - b.getRed()) * (t.getRed() - b.getRed()) +
                (t.getGreen() - b.getGreen()) * (t.getGreen() - b.getGreen()) +
                (t.getBlue() - b.getBlue()) * (t.getBlue() - b.getBlue());
        }
    }

    public double pixelEnergy(int x, int y) {
        return Math.sqrt((double)dx2(x, y) + (double)dy2(x, y));
    }

    public List<Integer> findHorizontalSeam() throws CheckFailException {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int x = 0; x < image.getWidth(); x++) {
            boolean found = false;

            for (int y = 0; y < image.getHeight(); y++) {
                Color c = new Color(image.getRGB(x, y));
                if (c.equals(Color.RED)) {
                    result.add(y);
                    found = true;
                    break;
                }
            }

            if (!found)
                throw new CheckFailException(String.format("Could not find seam pixel in column (%d)", x));
        }
        return result;
    }
}

class OutFile {
    String hash;
    String inFileName;
    String outFilename;
    int width;
    int height;

    Double seamSum;

    OutFile(String inFileName, String outFilename, int width, int height, String hash, Double sum) {
        this.inFileName = inFileName;
        this.outFilename = outFilename;
        this.width = width;
        this.height = height;
        this.hash = hash;
        this.seamSum = sum;
    }

    public void checkSum() throws CheckFailException {
        try {
            double delta = 0.00001;

            Image input = new Image(inFileName);
            Image output = new Image(outFilename);

            double actualSum = 0;
            List<Integer> seam = output.findHorizontalSeam();
            for (int x = 0; x < seam.size(); x++) {
                int y = seam.get(x);
                actualSum += input.pixelEnergy(x, y);
            }

            if (actualSum < seamSum - delta || actualSum > seamSum + delta) {
                throw new CheckFailException(
                    String.format(
                        "Total energy of your seam (%f) does not match expected value (%f +/- %f)",
                        actualSum, seamSum, delta));
            }

        } catch (IOException e) {
            throw new CheckFailException(
                String.format(
                    "Could not read output file '%s'. Please check you produce output file",
                    outFilename));
        }
    }

    public boolean compareWithActualMD5() throws CheckFailException {
        try {
            File imgPath = new File(outFilename);
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
                    outFilename));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new CheckFailException("Internal test error. please report to Hyperskill team");
        }

        return true;
    }

    public boolean compareActualDimensions() throws CheckFailException {
        try {
            BufferedImage image = ImageIO.read(new File(outFilename));

            if (image == null) {
                throw new CheckFailException(
                    String.format(
                        "File format error. Looks like your output '%s' is not a valid image file.",
                        outFilename));
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
                    outFilename));
        }

        return true;
    }
}

public class SeamCarvingTest extends StageTest<OutFile> {

    @Override
    public List<TestCase<OutFile>> generate() {

        return Arrays.asList(
            new TestCase<OutFile>()
                .addArguments("-in", "test/small.png", "-out", "test/small-seam-hor.png")
                .setAttach(new OutFile("test/small.png", "test/small-seam-hor.png",
                    15, 10,
                    "91d48b32789908d7826a32e1304a4ddc", 1136.850201)),

            new TestCase<OutFile>()
                .addArguments("-in", "test/blue.png", "-out", "test/blue-seam-hor.png")
                .setAttach(new OutFile("test/blue.png", "test/blue-seam-hor.png",
                    500, 334,
                    "b9070275c8a22db340162d2419fa13fe", 327.257757)),

            new TestCase<OutFile>()
                .addArguments("-in", "test/trees.png", "-out", "test/trees-seam-hor.png")
                .setAttach(new OutFile("test/trees.png", "test/trees-seam-hor.png",
                    600, 429,
                    "69ed6abd2487d46df650cbe46d577dc7", 115.903883))
        );
    }

    @Override
    public CheckResult check(String reply, OutFile expectedFile) {
        try {
            expectedFile.compareActualDimensions();
            //expectedFile.compareWithActualMD5();
            expectedFile.checkSum();
        } catch (CheckFailException e) {
            return CheckResult.wrong(e.getMessage());
        }

        return CheckResult.correct();
    }
}
