package com.august.mypetclinic.services.map;

import com.august.mypetclinic.model.Specialty;
import com.august.mypetclinic.services.SpecialtyService;

import java.util.Set;

public class SpecialtyServiceImpl extends AbstractMapService<Specialty, Long> implements SpecialtyService {
    @Override
    public Specialty save(Specialty specialty) {
        return super.save(specialty);
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Specialty> finAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Specialty specialty) {
        super.delete(specialty);
    }
}