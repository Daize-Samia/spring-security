package com.ensao.springsecurityproject.service;

import com.ensao.springsecurityproject.controller.ChangePasswordRequest;
import com.ensao.springsecurityproject.model.User;
import com.ensao.springsecurityproject.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {
        var user = ((User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal());

        //check if the current password is correct
        if(!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())){
            throw new IllegalStateException("Wrong password !");
        }
        //check if the 2 new passwords are the same
        if(!request.getNewPassword().equals(request.getConfirmationPassword())){
            throw new IllegalStateException("Password are not the same");
        }
        //update the password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepo.save(user);



    }
}
