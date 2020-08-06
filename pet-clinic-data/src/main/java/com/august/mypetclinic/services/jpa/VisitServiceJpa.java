package com.august.mypetclinic.services.jpa;

import com.august.mypetclinic.model.Visit;
import com.august.mypetclinic.repositories.VisitRepository;
import com.august.mypetclinic.services.VisitService;

import java.util.HashSet;
import java.util.Set;

public class VisitServiceJpa implements VisitService {

    private final VisitRepository visitRepository;

    public VisitServiceJpa(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Visit save(Visit visit) {
        return  visitRepository.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }

    @Override
    public void delete(Visit visit) {
        visitRepository.delete(visit);
    }
}
