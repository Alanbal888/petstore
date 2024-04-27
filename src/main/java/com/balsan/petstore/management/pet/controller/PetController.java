package com.balsan.petstore.management.pet.controller;

import com.balsan.petstore.management.pet.model.PetDTO;
import com.balsan.petstore.management.pet.service.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pets")
public class PetController {
    @Autowired
    private IPetService petService;

    @GetMapping
    public ResponseEntity<List<PetDTO>> getAllPets() {
        List<PetDTO> pets = petService.getAllPets();
        return ResponseEntity.ok(pets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetDTO> getPetById(@PathVariable Integer id) {
        Optional<PetDTO> petOptional = petService.getPetById(id);
        if (petOptional.isPresent()) {
            PetDTO PetDTO = petOptional.get();
            return ResponseEntity.ok(PetDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<PetDTO> createPet(@RequestBody PetDTO petDTO) {
        PetDTO savedPet = petService.createPet(petDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPet);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetDTO> updatePet(@PathVariable Integer id, @RequestBody PetDTO petDTO) {
        PetDTO updatedPet = petService.updatePet(petDTO);
        return ResponseEntity.ok(updatedPet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Integer id) {
        petService.deletePet(id);
        return ResponseEntity.noContent().build();
    }
}
