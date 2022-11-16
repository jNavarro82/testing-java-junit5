package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTest;
import guru.springframework.sfgpetclinic.dummy.ModelMapImpl;
import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class VetControllerTest implements ControllerTest {

    private VetController underTest;

    private VetMapService service;

    private SpecialityMapService specialityMapService;

    @BeforeEach
    void setUp() {
        specialityMapService = new SpecialityMapService();
        service = new VetMapService(specialityMapService);
        underTest = new VetController(service);

        Vet vet = new Vet(1L, "Joe", "Black", null);
        Vet anotherVet = new Vet(2L, "Jimmy", "Falcon", null);
        service.save(vet);
        service.save(anotherVet);
    }

    @Test
    void listVets() {
        Model givenModel = new ModelMapImpl();
        String actualList = underTest.listVets(givenModel);

        assertThat("vets/index").isEqualTo(actualList);
        Set vets = (Set) ((ModelMapImpl) givenModel).getMap().get("vets");
        assertThat(vets.size()).isEqualTo(2);
    }
}