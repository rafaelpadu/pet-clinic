package com.example.petclinic.services.map;

import com.example.petclinic.model.Visit;
import com.example.petclinic.repositories.VisitRepository;
import com.example.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit,Long> implements VisitService {


    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit t) {
        super.delete(t);
    }

    @Override
    public Visit save(Visit t) {
        if(t.getPet() == null || t.getPet().getOwner() == null || t.getPet().getId() == null){
            throw new RuntimeException("Invalid Visit");
        }
        return super.save(t);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
