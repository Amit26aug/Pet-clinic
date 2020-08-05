package com.august.mypetclinic.services.jpa;

import com.august.mypetclinic.model.Vet;
import com.august.mypetclinic.repositories.VetRepository;
import com.august.mypetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class VetServiceJpa implements VetService {

    private final VetRepository vetRepository;

    public VetServiceJpa(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }
}
