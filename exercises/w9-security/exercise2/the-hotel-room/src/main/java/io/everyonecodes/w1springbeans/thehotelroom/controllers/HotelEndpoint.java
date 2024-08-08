package io.everyonecodes.w1springbeans.thehotelroom.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HotelEndpoint {


    @GetMapping
    public String getGeneralAnswer() {
        return "Welcome to the hotel!";
    }

    @GetMapping("/room")
    @Secured({"ROLE_CUSTOMER"})
    public String getRoomUserAnswer() {
        return "Welcome to your room!";
    }

    @GetMapping("/office")
    @Secured({"ROLE_ADMIN"})
    public String getOfficeAdminAnswer() {
        return "Welcome to your office!";
    }





}
