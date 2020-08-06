package com.august.mypetclinic.services.map;

import com.august.mypetclinic.model.Visit;
import com.august.mypetclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Visit save(Visit visit) {
        if (
                visit == null
                || visit.getPet() == null
                || visit.getPet().getId() == null
                || visit.getPet().getOwner() == null
                || visit.getPet().getOwner().getId() == null
        )
            throw new RuntimeException("One or more fields are null");
        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }
}
