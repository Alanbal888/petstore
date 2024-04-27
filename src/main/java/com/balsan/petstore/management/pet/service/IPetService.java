package com.balsan.petstore.management.pet.service;

import com.balsan.petstore.management.pet.model.PetDTO;

import java.util.List;
import java.util.Optional;

public interface IPetService {

    public List<PetDTO> getAllPets();
    public Optional<PetDTO> getPetById(Integer petId);

    public PetDTO createPet(PetDTO petDTO);

    public PetDTO updatePet(PetDTO petDTO);

    public void deletePet(Integer id);

}
