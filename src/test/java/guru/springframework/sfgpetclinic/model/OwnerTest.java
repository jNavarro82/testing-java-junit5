package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerTest implements ModelTest {

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
    @ParameterizedTest(name = "{displayName} - [{index}] {argumentsWithNames}")
    @ValueSource(strings = {"Spring", "Framework", "Guru"})
    void customParametrizedTest(String args) {
        System.out.println(args);
    }
}