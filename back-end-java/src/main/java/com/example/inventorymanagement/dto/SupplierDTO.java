package com.example.inventorymanagement.dto;

import java.util.List;

import com.example.inventorymanagement.model.Address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SupplierDTO {
    
    private String name;
    
    private String email;

    private String phone;

    private String description;

    private List<Address> address;
}
