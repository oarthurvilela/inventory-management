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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "api/v1/addresses", produces = { "application/json" })
@AllArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @Operation(summary = "Create Address", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Address created")
    })
    @PostMapping
    public ResponseEntity<Object> saveAddress(@Valid @RequestBody AddressDTO addressDTO) {
        addressService.saveAddress(addressDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Address created.");
    }

    @Operation(summary = "Find Address by ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Address found"),
            @ApiResponse(responseCode = "404", description = "Address not found")
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findByIdAddress(
            @PathVariable(value = "id") @Parameter(name = "id", description = "Address id", example = "85419402-8372-4008-b378-04c79a61b407") UUID id) {
        AddressDTO addressDTO = addressService.findByIdAddress(id);
        return ResponseEntity.status(HttpStatus.OK).body(addressDTO);
    }

    @Operation(summary = "Find all Addresses", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of Addresses found")
    })
    @GetMapping
    public ResponseEntity<Object> findAllAddresses() {
        List<AddressDTO> addressesDTO = addressService.findAllAddresses();
        return ResponseEntity.status(HttpStatus.OK).body(addressesDTO);
    }

    @Operation(summary = "Delete Address by ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Address deleted"),
            @ApiResponse(responseCode = "404", description = "Address not found")
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteByIdAddress(
            @PathVariable(value = "id") @Parameter(name = "id", description = "Address id", example = "85419402-8372-4008-b378-04c79a61b407") UUID id) {
        addressService.deleteByIdAddress(id);
        return ResponseEntity.status(HttpStatus.OK).body("Address deleted successfully.");
    }
}
