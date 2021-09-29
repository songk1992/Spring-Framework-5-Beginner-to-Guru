package com.springframework.pets;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("DOG")
public class DogPetService implements PetService {
    @Override
    public String getPetType() {
        return "개입니다.";
    }
}
