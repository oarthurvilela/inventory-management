package com.example.inventorymanagement.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.inventorymanagement.dto.AddressDTO;
import com.example.inventorymanagement.exception.ResourceNotFoundException;
import com.example.inventorymanagement.mapper.AddressMapper;
import com.example.inventorymanagement.model.Address;
import com.example.inventorymanagement.repository.AddressRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Transactional
    public void saveAddress(AddressDTO addressDTO) {
        Address address = AddressMapper.INSTANCE.addressDTOToAddress(addressDTO);
        addressRepository.save(address);
    }

    public AddressDTO findByIdAddress(UUID id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address with id [%s] not found".formatted(id)));

        AddressDTO addressDTO = AddressMapper.INSTANCE.addressToAddressDTO(address);

        return addressDTO;
    }

    public List<AddressDTO> findAllAddresses() {
        List<Address> addresses = addressRepository.findAll();
        List<AddressDTO> addressesDTO = AddressMapper.INSTANCE.listAddressToListAddressDTO(addresses);

        return addressesDTO;
    }

    @Transactional
    public void deleteByIdAddress(UUID id) {
        checkIfAddressExistsOrThrow(id);
        addressRepository.deleteById(id);
    }

    private void checkIfAddressExistsOrThrow(UUID id) {
        Optional<Address> address = addressRepository.findById(id);

        if (!address.isPresent()) {
            throw new ResourceNotFoundException(
                    "Address with id [%s] not found".formatted(id));
        }
    }
}
