package com.august.mypetclinic.services.map;

import com.august.mypetclinic.model.Vet;
import com.august.mypetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(), vet);
    }

    @Override
    public Set<Vet> finAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
