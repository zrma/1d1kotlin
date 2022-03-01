import org.hyperskill.hstest.stage.StageTest;
import org.hyperskill.hstest.testcase.CheckResult;
import org.hyperskill.hstest.testcase.TestCase;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MinesweeperTest extends StageTest {

    @Override
    public List<TestCase> generate() {
        return Arrays.asList(
            new TestCase<>()
        );
    }

    @Override
    public CheckResult check(String reply, Object attach) {
        List<String> lines =
            Arrays.stream(reply.split("\n"))
                .map(String::trim)
                .collect(Collectors.toList());

        if (lines.isEmpty()) {
            return CheckResult.wrong(
                "Looks like you didn't output a single line!"
            );
        }

        int firstLineLength = lines.get(0).length();

        if (lines.size() < 2) {
            return CheckResult.wrong("Your game field should contain at least 2 lines.");
        }

        Set<Character> symbols = new TreeSet<>();

        for (String line : lines) {
            int currLineLength = line.length();

            if (currLineLength != firstLineLength) {
                return CheckResult.wrong(
                    "You have lines with different lengths!\n" +
                        "Found lines with " + currLineLength + " and " +
                        firstLineLength + " length."
                );
            }

            for (char c : line.toCharArray()) {
                symbols.add(c);

                if (symbols.size() == 3) {
                    Character[] ch = symbols.toArray(new Character[0]);
                    char first = ch[0];
                    char second = ch[1];
                    char third = ch[2];

                    return CheckResult.wrong(
                        "There are three different symbols, " +
                            "but there must be two - " +
                            "one for mines, one for safe zones. " +
                            "Symbols found: " +
                            "\'" + first + "\', " +
                            "\'" + second + "\', " +
                            "\'" + third + "\'."
                    );
                }
            }
        }
        if (symbols.size() < 2) {
            return CheckResult.wrong("Your field should contain 2 different symbols: " +
                "one for mines, one for safe zones.");
        }

        return CheckResult.correct();
    }
}
