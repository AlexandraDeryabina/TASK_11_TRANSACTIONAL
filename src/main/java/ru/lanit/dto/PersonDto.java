package ru.lanit.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonDto {
    private int id;
    private String fullName;
    private LocalDate date;
    private List<AddressDto> addressList;

    public PersonDto(int id, String fullName, LocalDate date) {
        this.id = id;
        this.fullName = fullName;
        this.date = date;
        this.addressList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getDate() {
        return date;
    }

    public List<AddressDto> getAddressList() {
        return addressList;
    }
}
