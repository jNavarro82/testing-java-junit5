package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.CustomArgsProvider;
import guru.springframework.sfgpetclinic.ModelTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerTest implements ModelTest {

    public static Stream<Arguments> givenArgs() {
        return Stream.of(
                Arguments.of("John", 9, 9),
                Arguments.of("Joe", 8, 8),
                Arguments.of("Ed", 7, 7)
        );
    }

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1L, "Joe", "Black");
        owner.setCity("Madrid");
        owner.setTelephone("9999999999");

        assertAll("Properties test",
                () -> assertAll("Person properties",
                        () -> assertEquals("Joe", owner.getFirstName(), "First name did not match"),
                        () -> assertEquals("Black", owner.getLastName())
                ),
                () -> assertAll("Person properties",
                        () -> assertEquals("Madrid", owner.getCity(), "City did not match"),
                        () -> assertEquals("9999999999", owner.getTelephone())
                )
        );

        assertThat(owner.getCity(), is("Madrid"));
    }

    @DisplayName("Value source ")
    @ValueSource(strings = {"Spring", "Framework", "Guru"})
    @ParameterizedTest(name = "{displayName} - [{index}] {argumentsWithNames}")
    void customParametrizedTest(String args) {
        System.out.println(args);
    }

    @EnumSource(OwnerType.class)
    @DisplayName("Enum source ")
    @ParameterizedTest(name = "{displayName} - [{index}] {argumentsWithNames}")
    void enumTest(OwnerType ownerType) {
        System.out.println(ownerType);
    }

    @CsvSource({"Jack, 1, 1", "Peter, 2, 2", "John, 3, 3 "})
    @DisplayName("CSV source ")
    @ParameterizedTest(name = "{displayName} - [{index}] {argumentsWithNames}")
    void csvTest(String name, int arg, int secondArg) {
        System.out.println(name + " : " + arg + " : " + secondArg);
    }

    @DisplayName("CsvFileSource ")
    @CsvFileSource(resources = "/input.csv")
    @ParameterizedTest(name = "{displayName} - [{index}] {argumentsWithNames}")
    void csvInputFileTest(String name, int arg, int secondArg) {
        System.out.println(name + " : " + arg + " : " + secondArg);
    }

    @DisplayName("MethodSource ")
    @MethodSource("givenArgs")
    @ParameterizedTest(name = "{displayName} - [{index}] {argumentsWithNames}")
    void methodSourceTest(String name, int arg, int secondArg) {
        System.out.println(name + " : " + arg + " : " + secondArg);
    }

    @DisplayName("ArgumentsSource ")
    @ArgumentsSource(CustomArgsProvider.class)
    @ParameterizedTest(name = "{displayName} - [{index}] {argumentsWithNames}")
    void argumentsSourceTest(String name, int arg, int secondArg) {
        System.out.println(name + " : " + arg + " : " + secondArg);
    }
}