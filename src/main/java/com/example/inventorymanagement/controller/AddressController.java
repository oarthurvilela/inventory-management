package com.example.inventorymanagement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventorymanagement.model.Address;
import com.example.inventorymanagement.service.AddressService;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "api/v1/addresses")
@AllArgsConstructor
public class AddressController {
    
    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<Object> saveAddress(@Valid @RequestBody Address address) {
        addressService.saveAddress(address);        
        return ResponseEntity.status(HttpStatus.CREATED).body("Address created.");
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findByIdAddress(@PathVariable(value = "id") UUID id) {
        Optional<Address> address = addressService.findByIdAddress(id);

        if(!address.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Address not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(address.get());

    }

    @GetMapping
    public ResponseEntity<Object> findAllAddresses() {
        List<Address> addresses = addressService.findAllAddresses();
        return ResponseEntity.status(HttpStatus.OK).body(addresses);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteByIdAddress(@PathVariable(value = "id") UUID id) {
        Optional<Address> address = addressService.findByIdAddress(id);

        if(!address.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Address not found.");
        }
        addressService.deleteByIdAddress(id);
        return ResponseEntity.status(HttpStatus.OK).body("Address deleted successfully.");
    }
    
}
