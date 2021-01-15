package com.lera.springbootswaggerapp.controller;

import com.lera.springbootswaggerapp.model.Contact;
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
    public Contact getContact(@PathVariable Integer contactId) {
        return contacts.get(contactId);
    }

    @PostMapping("/")
    public Contact addContact(@RequestBody Contact contact) {
        contacts.put(contact.getContactId(), contact);
        return contact;
    }
}
