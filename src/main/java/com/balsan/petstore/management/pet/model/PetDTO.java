package com.balsan.petstore.management.pet.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetDTO {
    private Integer id;
    private String name;
    private String sex;
    private java.sql.Date dob;
    private Integer approximateAge;
}
