package com.devsuperior.movieflix.controller;

import com.devsuperior.movieflix.dtos.UserDTO;
import com.devsuperior.movieflix.services.AuthService;
import com.devsuperior.movieflix.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devsuperior.movieflix.entities.User;

@RestController
@RequestMapping(value = "/users/profile")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private AuthService authService;

    @GetMapping()
    public ResponseEntity<UserDTO> findById(){
        User user = authService.authenticated();
        authService.validateSelfOrMemberAndVisitor(user.getId());
        UserDTO dto = service.findById(user.getId());
        return ResponseEntity.ok().body(dto);
    }

}