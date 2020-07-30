package com.august.mypetclinic.bootstrap;

import com.august.mypetclinic.model.Owner;
import com.august.mypetclinic.model.Vet;
import com.august.mypetclinic.services.OwnerService;
import com.august.mypetclinic.services.VetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataBootstrap implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataBootstrap(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

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
