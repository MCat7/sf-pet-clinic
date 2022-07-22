package by.iba.sfpetclinic.bootstrap;


import by.iba.sfpetclinic.model.Owner;
import by.iba.sfpetclinic.model.Vet;
import by.iba.sfpetclinic.services.OwnerService;
import by.iba.sfpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoad implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoad(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner ownerA = new Owner();
        ownerA.setFirstName("Olga");
        ownerA.setLastName("Star");
        ownerService.save(ownerA);
        System.out.println(ownerService.findAll().size());
        Vet vetA = new Vet();
        vetA.setFirstName("Dina");
        vetA.setLastName("Big");
        vetService.save(vetA);
        System.out.println(ownerService.findAll().size());
    }
}
