package com.lera.springbootswaggerapp.model;

import lombok.Data;

@Data
public class Contact {
    private Integer contactId;
    private String name;
    private String phoneNumber;
}
