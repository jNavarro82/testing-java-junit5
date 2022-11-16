package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("model-tests")
public interface ModelTest {


    @BeforeEach
    default void beforeEachConsoleOuPut(TestInfo testInfo) {
        System.out.println("Running default method" + testInfo.getDisplayName());
    }
}
