package com.august.mypetclinic.services.map;

import com.august.mypetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    T save(T entity) {
        if (entity == null) {
            throw new RuntimeException("Cannot save an null entity.");
        }
        if (entity.getId() == null) {
            entity.setId(getNextId());
        }
        map.put(entity.getId(), entity);
        return entity;
    }

    T findById(ID id) {
        return map.get(id);
    }

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T entity) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(entity));
    }

    Long getNextId() {
        return map.isEmpty() ? 1L : Collections.max(map.keySet()) + 1;
    }
}
