package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.MyRepeatedTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class PersonRepeatedTest implements MyRepeatedTest {

    @DisplayName("Repeated test")
    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - totalRepetitions")
    void repeatedMethod() {
    }

    @DisplayName("RepeatedTest complex")
    @RepeatedTest(value = 5, name = "{displayName}")
    void repeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + " : " + repetitionInfo.getCurrentRepetition());
    }

    @DisplayName("AssignmentTest")
    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - totalRepetitions")
    void assignmentTest() {

    }
}
