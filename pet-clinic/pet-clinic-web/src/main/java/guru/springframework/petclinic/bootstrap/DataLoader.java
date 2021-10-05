package guru.springframework.petclinic.bootstrap;

import guru.springframework.petclinic.model.Owner;
import guru.springframework.petclinic.model.Pet;
import guru.springframework.petclinic.model.PetType;
import guru.springframework.petclinic.model.Vet;
import guru.springframework.petclinic.services.OwnerService;
import guru.springframework.petclinic.services.PetTypeService;
import guru.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);



        Owner owner1 = new Owner();
        owner1.setFirstName("JOHN");
        owner1.setLastName("DOH");
        owner1.setAddress("JohnsonApt");
        owner1.setCity("JohnCity");
        owner1.setTelephone("01011112222");

        Pet johnsPet = new Pet();
        johnsPet.setPetType(savedDogPetType);
        johnsPet.setOwner(owner1);
        johnsPet.setBirthDate(LocalDate.now());
        johnsPet.setName("Dog1");
        owner1.getPets().add(johnsPet);

        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("C");
        owner2.setLastName("Kim");
        owner1.setAddress("KimCMansion");
        owner2.setCity("JohnCity");
        owner2.setTelephone("01011112222");

        Pet songsPet = new Pet();
        songsPet.setPetType(savedCatPetType);
        songsPet.setOwner(owner2);
        songsPet.setBirthDate(LocalDate.now());
        songsPet.setName("Cat1");
        owner2.getPets().add(songsPet);
        ownerService.save(owner2);

        System.out.println("Loaded Owners........");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("수의사");
        vet2.setLastName("김");
        vetService.save(vet2);

        System.out.println("Loaded Vets........");
    }
}
