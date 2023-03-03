package com.playo.demo.controllers;

import com.playo.demo.dtos.LoginRequest;
import com.playo.demo.dtos.LoginResponse;
import com.playo.demo.dtos.SignupRequest;
import com.playo.demo.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.playo.demo.utils.constants.AppConstant.API_CONTEXT_V0;

@RestController
@RequestMapping(API_CONTEXT_V0+"/player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @PostMapping("/signup")
    public ResponseEntity<LoginResponse> login(@RequestBody SignupRequest request) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.playerService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.playerService.login(request));
    }
}
