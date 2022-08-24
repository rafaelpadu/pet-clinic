package com.example.petclinic.services.springdatajpa;

import com.example.petclinic.model.Speciality;
import com.example.petclinic.repositories.SpecialityRepository;
import com.example.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialtyService {

    private final SpecialityRepository specialityRepository;

    public SpecialitySDJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialitySet = new HashSet<>();
        specialityRepository.findAll().forEach(specialitySet::add);

        return specialitySet;
    }

    @Override
    public Speciality findById(Long id) {
        Optional<Speciality> speciality = specialityRepository.findById(id);
        return null;
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public void delete(Speciality speciality) {
        specialityRepository.delete(speciality);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }
}
