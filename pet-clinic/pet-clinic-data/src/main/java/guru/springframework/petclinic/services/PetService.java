package guru.springframework.petclinic.services;

import guru.springframework.petclinic.model.Pet;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface PetService extends CrudService<Pet, Long>{

}
