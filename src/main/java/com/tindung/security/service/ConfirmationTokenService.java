package com.nhutin.electric_project.security.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tindung.service.*;
import com.tindung.repository.*;
import com.tindung.model.*;
import com.tindung.ServiceImpl.*;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationCodeDAO confirmationCodeDAO;

    public void saveConfirmationToken(ConfirmationCode token) {
        confirmationCodeDAO.save(token);
    }

    public Optional<ConfirmationCode> getToken(String token) {
        return confirmationCodeDAO.findByOTPCode(token);
    }

    public int setConfirmedAt(String token) {
        return confirmationCodeDAO.updateConfirmed(
                token, true);
    }
}
