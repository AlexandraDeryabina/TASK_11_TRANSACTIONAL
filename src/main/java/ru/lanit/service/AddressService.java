package ru.lanit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lanit.model.Address;
import ru.lanit.repository.AddressRepository;

@Service
public class AddressService {
    private AddressRepository addressRepository;
    private PersonService personService;

    @Autowired
    public AddressService(AddressRepository addressRepository, PersonService personService) {
        this.addressRepository = addressRepository;
        this.personService = personService;
    }

    @Transactional
    public void save(String street, String house, String flat, String person) {
        Address address = new Address();
        address.setStreet(street != "" ? street : null);
        address.setHouse(house != "" ? house : null);
        address.setFlat(flat);

        address.setPerson(personService.
                getById(Integer.parseInt(person)));

        addressRepository.save(address);
    }
}
