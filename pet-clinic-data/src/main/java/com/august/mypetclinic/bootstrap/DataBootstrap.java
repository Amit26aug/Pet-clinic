package com.august.mypetclinic.bootstrap;

import com.august.mypetclinic.model.Owner;
import com.august.mypetclinic.model.PetType;
import com.august.mypetclinic.model.Vet;
import com.august.mypetclinic.services.OwnerService;
import com.august.mypetclinic.services.PetTypeService;
import com.august.mypetclinic.services.VetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataBootstrap implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataBootstrap(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType petTypeDog = new PetType();
        petTypeDog.setName("Dog");
        PetType savedPetTypeDog = petTypeService.save(petTypeDog);

        PetType petTypeCat = new PetType();
        petTypeCat.setName("Cat");
        PetType savedPetTypeCat = petTypeService.save(petTypeCat);

        Owner peterParker = new Owner();
        peterParker.setFirstName("Peter");
        peterParker.setLastName("Parker");

        Owner johnWick = new Owner();
        johnWick.setFirstName("John");
        johnWick.setLastName("Wick");

        ownerService.save(peterParker);
        ownerService.save(johnWick);

        Vet stephenStrange = new Vet();
        stephenStrange.setFirstName("Stephen");
        stephenStrange.setLastName("Strange");

        vetService.save(stephenStrange);

        log.info("Vets and Owners saved!");
    }

}
