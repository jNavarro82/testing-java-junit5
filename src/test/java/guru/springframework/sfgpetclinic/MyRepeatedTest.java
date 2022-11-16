package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("RepeatedTest")
public interface MyRepeatedTest {
    /**
     * RepetitionInfo only available for repeated test
     * @param testInfo
     * @param repetitionInfo
     */
    @BeforeEach
    default void beforeEachConsoleOuPut(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("Running default method" + testInfo.getDisplayName() + " - " +
                repetitionInfo.getCurrentRepetition() + " - " + repetitionInfo.getTotalRepetitions());
    }
}
