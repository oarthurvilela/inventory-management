package com.example.inventorymanagement.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.inventorymanagement.dto.AddressDTO;
import com.example.inventorymanagement.model.Address;

@Mapper
public interface AddressMapper {
    
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressDTO addressToAddressDTO (Address address);
    
    Address addressDTOToAddress (AddressDTO addressDTO);

    List<AddressDTO> listAddressToListAddressDTO (List<Address> addresses);
}
