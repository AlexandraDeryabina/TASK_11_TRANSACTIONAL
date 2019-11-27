package ru.lanit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lanit.dto.AddressDto;
import ru.lanit.dto.PersonDto;
import ru.lanit.model.Address;
import ru.lanit.model.Person;
import ru.lanit.repository.PersonRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    private PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<PersonDto> getList(boolean needFullFetch) {
        List<Person> personList = repository.getList();
        List<PersonDto> personDtoList = new ArrayList<>();
        for (Person person : personList) {
            PersonDto personDto = new PersonDto(
                    person.getId(),
                    person.getFullName(),
                    person.getDate());
            if (needFullFetch) {
                List<Address> addressList = person.getAddressList();
                for (Address address : addressList) {
                    AddressDto addressDto = new AddressDto(
                            address.getId(),
                            address.getFullAddress());
                    personDto.getAddressList().add(addressDto);
                }
            }
            personDtoList.add(personDto);
        }

        return personDtoList;
    }

    public List<PersonDto> getList() {
        return getList(false);
    }

    public Person getById(int id) {
        return repository.getById(id);
    }

    @Transactional
    public void save(String name, String surname, String patronymic, String dateOfBirth) {
        Person person = new Person(
                name != "" ? name : null,
                surname != "" ? surname : null,
                LocalDate.parse(dateOfBirth));
        person.setPatronymic(patronymic);
        repository.save(person);
    }
}
