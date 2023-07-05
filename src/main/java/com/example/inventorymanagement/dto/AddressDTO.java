package com.example.inventorymanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

    private String country;

    private String state;

    private String city;

    private String district;

    private String street;

    private int number;

    private String complement;
}
