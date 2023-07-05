package com.example.inventorymanagement.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventorymanagement.dto.AddressDTO;
import com.example.inventorymanagement.service.AddressService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "api/v1/addresses")
@AllArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<Object> saveAddress(@Valid @RequestBody AddressDTO addressDTO) {
        addressService.saveAddress(addressDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Address created.");
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findByIdAddress(@PathVariable(value = "id") UUID id) {
        AddressDTO addressDTO = addressService.findByIdAddress(id);
        return ResponseEntity.status(HttpStatus.OK).body(addressDTO);
    }

    @GetMapping
    public ResponseEntity<Object> findAllAddresses() {
        List<AddressDTO> addressesDTO = addressService.findAllAddresses();
        return ResponseEntity.status(HttpStatus.OK).body(addressesDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteByIdAddress(@PathVariable(value = "id") UUID id) {        
        addressService.deleteByIdAddress(id);
        return ResponseEntity.status(HttpStatus.OK).body("Address deleted successfully.");
    }
}
