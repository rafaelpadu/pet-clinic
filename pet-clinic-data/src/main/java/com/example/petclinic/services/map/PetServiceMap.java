package com.example.petclinic.services.map;

import com.example.petclinic.model.Pet;
import com.example.petclinic.services.CrudService;
import com.example.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"default", "map"})
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService{

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }
}
