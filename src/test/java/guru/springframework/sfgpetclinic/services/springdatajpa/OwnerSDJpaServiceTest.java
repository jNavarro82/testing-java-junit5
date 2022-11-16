package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled(value = "Disabled entire test class")
class OwnerSDJpaServiceTest {

    private OwnerSDJpaService underTest;

    @BeforeEach
    void setUp() {
        underTest = new OwnerSDJpaService(null, null, null);
    }

    @Test
    @Disabled(value = "Disabled test method")
    void findByLastName() {
        Owner actualOwner = underTest.findByLastName("Black");
    }

    @Test
    void findAllByLastNameLike() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}