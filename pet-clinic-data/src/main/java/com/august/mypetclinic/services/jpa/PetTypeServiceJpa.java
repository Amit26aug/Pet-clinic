package com.august.mypetclinic.services.jpa;

import com.august.mypetclinic.model.PetType;
import com.august.mypetclinic.repositories.PetTypeRepository;
import com.august.mypetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class PetTypeServiceJpa implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeServiceJpa(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public PetType save(PetType petType) {
        return petTypeRepository.save(petType);
    }

    @Override
    public PetType findById(Long id) {
        return petTypeRepository.findById(id).orElse(null);
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes= new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }

    @Override
    public void delete(PetType petType) {
        petTypeRepository.delete(petType);
    }
}
