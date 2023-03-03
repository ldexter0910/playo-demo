package com.playo.demo.controllers;

import com.playo.demo.dtos.JoinRequestDto;
import com.playo.demo.services.RequestService;
import com.playo.demo.utils.constants.AppConstant;
import com.playo.demo.utils.enums.RequestStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AppConstant.API_CONTEXT_V0 + "/joinRequest")
public class RequestController {
    @Autowired
    RequestService requestService;

    @PostMapping
    public ResponseEntity<RequestStatusEnum> addRequest(@RequestBody JoinRequestDto joinRequest) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.requestService.addRequest(joinRequest));
    }
}
