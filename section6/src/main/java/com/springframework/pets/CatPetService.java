package com.springframework.pets;

public class CatPetService implements PetService {

    @Override
    public String getPetType() {
        return "고양이 타입입니다.";
    }
}
