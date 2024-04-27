package com.balsan.petstore.management.pet.repository;

import com.balsan.petstore.management.pet.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetsRepository extends JpaRepository<Pet, Integer> {
}
