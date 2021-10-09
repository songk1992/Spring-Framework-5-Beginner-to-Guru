package guru.springframework.petclinic.bootstrap;

import guru.springframework.petclinic.model.*;
import guru.springframework.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0){
            loadDate();
        }
    }

    private void loadDate() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("");
        Specialty savedDentistry = specialtyService.save(dentistry);

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
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("수의사");
        vet2.setLastName("김");
        vet2.getSpecialties().add(savedDentistry);
        vetService.save(vet2);


        System.out.println("Loaded Vets........");


        Visit catVisit  = new Visit();
        catVisit.setPet(songsPet);
        catVisit.setDate(LocalDate.of(2021,10,9));
        catVisit.setDescription("고양이가 방문하였다.");
        visitService.save(catVisit);

        System.out.println("Loaded Visits........");
    }
}
