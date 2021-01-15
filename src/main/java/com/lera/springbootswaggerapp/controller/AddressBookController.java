package com.lera.springbootswaggerapp.controller;

import com.lera.springbootswaggerapp.model.Contact;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping("/api")
public class AddressBookController {
    ConcurrentMap<Integer, Contact> contacts = new ConcurrentHashMap<>();

    @GetMapping("/")
    public List<Contact> getAllContacts() {
        return new ArrayList<>(contacts.values());
    }

    @GetMapping("/{contactId}")
    @ApiOperation(value = "Finds Contact by contactId",
            notes = "Provide contactId to look up specific contact from the address book",
            response = Contact.class)
    public Contact getContact(@ApiParam(value = "Id value for the contact you want to retrieve") @PathVariable Integer contactId) {
        return contacts.get(contactId);
    }

    @PostMapping("/")
    public Contact addContact(@RequestBody Contact contact) {
        contacts.put(contact.getContactId(), contact);
        return contact;
    }
}
