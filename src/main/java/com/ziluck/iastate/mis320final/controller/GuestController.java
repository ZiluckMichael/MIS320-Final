package com.ziluck.iastate.mis320final.controller;

import com.ziluck.iastate.mis320final.model.Guest;
import com.ziluck.iastate.mis320final.repository.GuestRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guest")
public class GuestController {
    private final GuestRepository guestRepository;

    public GuestController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @GetMapping
    public Guest getGuestById(long personId) {
        return guestRepository.findById(personId).get();
    }
}
