package com.balsan.petstore.management.pet.service;

import com.balsan.petstore.management.pet.entity.Pet;
import com.balsan.petstore.management.pet.model.PetDTO;
import com.balsan.petstore.management.pet.repository.PetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService implements IPetService {

    @Autowired
    private PetsRepository petsRepository;
    @Override
    public List<PetDTO> getAllPets() {
        List<Pet> pets = petsRepository.findAll();
        return pets.stream().map(p -> convertToDTO(p)).toList();
    }

    @Override
    public Optional<PetDTO> getPetById(Integer petId) {
        Optional<Pet> pets = petsRepository.findById(petId);

        if(pets.isPresent()){
            return Optional.of(convertToDTO(pets.get()));
        }
        else{
            return Optional.empty();
        }
    }

    @Override
    public PetDTO createPet(PetDTO petDTO) {
        Pet pet = convertToEntity(petDTO);
        return convertToDTO(petsRepository.save(pet));
    }

    @Override
    public PetDTO updatePet(PetDTO petDTO) {
        return null;
    }

    @Override
    public void deletePet(Integer id) {

    }

    private PetDTO convertToDTO(Pet pet) {
        PetDTO PetDTO = new PetDTO();
        PetDTO.setId(pet.getId());
        PetDTO.setName(pet.getName());
        PetDTO.setSex(pet.getSex());
        PetDTO.setDob(pet.getDob());
        PetDTO.setApproximateAge(pet.getApproximateAge());
        return PetDTO;
    }

    private Pet convertToEntity(PetDTO PetDTO) {
        Pet pet = new Pet();
        pet.setName(PetDTO.getName());
        pet.setSex(PetDTO.getSex());
        pet.setDob(PetDTO.getDob());
        pet.setApproximateAge(PetDTO.getApproximateAge());
        return pet;
    }
}
