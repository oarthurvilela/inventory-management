package com.example.inventorymanagement.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.inventorymanagement.model.Address;
import com.example.inventorymanagement.repository.AddressRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AddressService {
    
    private final AddressRepository addressRepository;

    @Transactional
    public void saveAddress(Address address) {
        addressRepository.save(address);
    }

    public Optional<Address> findByIdAddress(UUID id) {
        Optional<Address> address = addressRepository.findById(id);
        return address;
    }

    public List<Address> findAllAddresses() {
        List<Address> addresses = addressRepository.findAll();
        return addresses;
    }

    @Transactional
    public void deleteByIdAddress(UUID id) {
        addressRepository.deleteById(id);
    }
 
}
