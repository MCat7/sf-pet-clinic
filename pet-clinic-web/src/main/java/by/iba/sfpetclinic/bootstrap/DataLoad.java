package by.iba.sfpetclinic.bootstrap;

import by.iba.sfpetclinic.model.*;
import by.iba.sfpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoad implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoad(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogType = petTypeService.save(dog);
        Speciality radiology = new Speciality();
        radiology.setDescription("radiololgy");
        Speciality savedRadiology = specialityService.save(radiology);
        Speciality dentistry = new Speciality();
        radiology.setDescription("dentistry");
        Speciality savedDentisty = specialityService.save(dentistry);
        Owner ownerA = new Owner();
        ownerA.setId(1L);
        ownerA.setFirstName("Olga");
        ownerA.setLastName("Star");
        ownerA.setAddress("Scorini, 55");
        ownerA.setCity("Minsk");
        ownerA.setTelephone("+37529152432");
        Owner ownerB = new Owner();
        ownerB.setId(2L);
        ownerB.setFirstName("Andrew");
        ownerB.setLastName("Dufresne");
        ownerB.setAddress("Scorini, 55");
        ownerB.setCity("Minsk");
        ownerB.setTelephone("+375291234567");
        Pet newPet = new Pet();
        newPet.setPetType(savedDogType);
        newPet.setBirthDate(LocalDate.now());
        newPet.setName("Roki");
        ownerA.getPets().add(newPet);
        ownerService.save(ownerA);
        ownerService.save(ownerB);
        Visit dogVisit = new Visit();
        dogVisit.setPet(newPet);
        dogVisit.setDate(LocalDate.now());
        dogVisit.setDescription("bad mind");
        System.out.println(ownerService.findAll().size());
        Vet vetA = new Vet();
        vetA.setFirstName("Dina");
        vetA.setLastName("Big");
        vetA.getSpecialities().add(savedRadiology);
        vetA.getSpecialities().add(savedDentisty);
        vetService.save(vetA);
        Vet vetB = new Vet();
        vetB.setFirstName("Paul");
        vetB.setLastName("Small");
        vetA.getSpecialities().add(savedRadiology);
        vetA.getSpecialities().add(savedDentisty);
        vetService.save(vetB);

        System.out.println(vetService.findAll().size());

    }
}

