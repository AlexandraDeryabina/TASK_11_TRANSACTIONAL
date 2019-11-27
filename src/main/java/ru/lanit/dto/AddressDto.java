package ru.lanit.dto;

public class AddressDto {
    private int id;
    private String fullAddress;

    public AddressDto(int id, String fullAddress) {
        this.id = id;
        this.fullAddress = fullAddress;
    }

    public int getId() {
        return id;
    }

    public String getFullAddress() {
        return fullAddress;
    }
}
