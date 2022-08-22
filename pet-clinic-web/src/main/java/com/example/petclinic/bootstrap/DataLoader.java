package com.example.petclinic.bootstrap;

import com.example.petclinic.model.*;
import com.example.petclinic.services.OwnerService;
import com.example.petclinic.services.PetTypeService;
import com.example.petclinic.services.SpecialtyService;
import com.example.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if(count == 0){
            loadData();
        }
    }


    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded PetTypes...\n");


        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setCity("Miami");
        owner1.setAddress("1234 Baker St.");

        Pet mikesPet = new Pet();
        mikesPet.setName("Pluto");
        mikesPet.setPetType(savedCatPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setCity("Miami");
        owner2.setAddress("2234 Stop St.");
        owner2.setTelephone("1224589098787");

        Pet fionasPet = new Pet();
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setPetType(savedCatPetType);
        fionasPet.setName("Kitten");
        fionasPet.setOwner(owner2);
        owner2.getPets().add(fionasPet);
        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Speciality savedRadiology = saveSpecialty("Radiology");
        Speciality savedSurgery = saveSpecialty("Surgery");
        Speciality savedDentistry = saveSpecialty("Dentistry");

        loadVets(savedRadiology, savedSurgery, savedDentistry);
    }

    private Speciality saveSpecialty(String radiology) {
        Speciality speciality = new Speciality();
        speciality.setDescription(radiology);
        Speciality savedSpeciality = specialtyService.save(speciality);
        return savedSpeciality;
    }

    private void loadVets(Speciality savedRadiology, Speciality savedSurgery, Speciality savedDentistry) {
        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Achel");
        vet1.getSpecialities().add(savedDentistry);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Wilson");
        vet2.getSpecialities().add(savedRadiology);
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
