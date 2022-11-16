package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest implements ControllerTest {

    private IndexController underTest;

    @BeforeEach
    void setUp() {
        underTest = new IndexController();
    }

    @Test
    @DisplayName("Testing controller unit test")
    void index() {
        assertEquals("index", underTest.index());
        assertEquals("index", underTest.index(), "Wrong view returned");
        assertTrue("index".equals(underTest.index()), () -> "Another expensive message to build");
        assertThat(underTest.index()).isEqualTo("index");
    }

    @Test
    @DisplayName("Testing oupsHandler method")
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, () -> underTest.oupsHandler());
    }

    @Test
    @Disabled
    void testTimeout() {
        assertTimeout(Duration.ofMillis(2000), () -> {
            Thread.sleep(2000);
            System.out.println("Hey there...");
        });
    }

    @Test
    @Disabled(value = "testAssumptions")
    void testAssumptionTrue() {
        assumeTrue("guru".equalsIgnoreCase(System.getenv("GURU")));
    }

    @Test
    void testAssumptionIsTrue() {
        assumeTrue("guru".equalsIgnoreCase("GURU"));
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testMeOnWindows() {
        assertEquals("one", "one");
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void testMeOnMac() {
        assertEquals("one", "one");
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "USER", matches = "janavarro.ortega")
    void testMeIf() {
        assertEquals("one", "one");
    }
}