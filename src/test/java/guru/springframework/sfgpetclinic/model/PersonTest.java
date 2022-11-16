package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTest;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest implements ModelTest {

    @Test
    void groupedAssertion() {
        // given
        Person person = new Person(1L, "Joe", "Black");

        //then
        assertAll("Test props set",
                () -> assertEquals("Joe", person.getFirstName()),
                () -> assertEquals("Black", person.getLastName()));
    }

    @Test
    void groupedAssertionMsg() {
        // given
        Person person = new Person(1L, "Joe", "Black");

        //then
        assertAll("Test props set",
                () -> assertEquals("Joe", person.getFirstName(), "First name fails"),
                () -> assertEquals("Black", person.getLastName(), "Last name fails"));
    }

}