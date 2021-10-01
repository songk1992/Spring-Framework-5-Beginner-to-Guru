package com.springframework.pets;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

public class CatPetService implements PetService {

    @Override
    public String getPetType() {
        return "고양이 타입입니다.";
    }
}
