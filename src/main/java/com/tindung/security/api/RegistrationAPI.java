package com.tindung.security.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tindung.service.*;
import com.tindung.repository.*;
import com.tindung.model.*;
import com.tindung.ServiceImpl.*;
import com.tindung.security.service.*;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api/registration")
@AllArgsConstructor
public class RegistrationAPI {

    private RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
