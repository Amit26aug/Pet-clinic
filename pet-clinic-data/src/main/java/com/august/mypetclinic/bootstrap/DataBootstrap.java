package com.august.mypetclinic.bootstrap;

import com.august.mypetclinic.model.*;
import com.august.mypetclinic.services.OwnerService;
import com.august.mypetclinic.services.PetTypeService;
import com.august.mypetclinic.services.SpecialtyService;
import com.august.mypetclinic.services.VetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Slf4j
@Component
public class DataBootstrap implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataBootstrap(OwnerService ownerService, VetService vetService,
                         PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType petTypeSpider = new PetType();
        petTypeSpider.setName("Spider");
        PetType savedPetTypeSpider = petTypeService.save(petTypeSpider);

        PetType petTypeDog = new PetType();
        petTypeDog.setName("Dog");
        PetType savedPetTypeDog = petTypeService.save(petTypeDog);


        Owner peterParker = new Owner();
        peterParker.setFirstName("Peter");
        peterParker.setLastName("Parker");
        peterParker.setCity("Queens");
        peterParker.setAddress("21 Jump Street!");
        peterParker.setTelephone("1234567890");

        Pet spider = new Pet();
        spider.setPetType(savedPetTypeSpider);
        spider.setName("Web-maker");
        spider.setBirthDate(LocalDate.now());
        spider.setOwner(peterParker);
        peterParker.getPets().add(spider);

        Owner johnWick = new Owner();
        johnWick.setFirstName("John");
        johnWick.setLastName("Wick");
        johnWick.setCity("New York");
        johnWick.setAddress("113 Death House");
        johnWick.setTelephone("1234567890");

        Pet johnWicksDog = new Pet();
        johnWicksDog.setOwner(johnWick);
        johnWicksDog.setBirthDate(LocalDate.now());
        johnWicksDog.setName("Messy");
        johnWicksDog.setPetType(petTypeDog);
        johnWick.getPets().add(johnWicksDog);

        ownerService.save(peterParker);
        ownerService.save(johnWick);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Vet stephenStrange = new Vet();
        stephenStrange.setFirstName("Stephen");
        stephenStrange.setLastName("Strange");
        stephenStrange.getSpecialties().add(savedSurgery);
        stephenStrange.getSpecialties().add(savedRadiology);

        vetService.save(stephenStrange);

        log.info("Vets and Owners saved!");
    }

}
