package com.playo.demo.controllers;

import com.playo.demo.entities.Sport;
import com.playo.demo.services.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.playo.demo.utils.constants.AppConstant.API_CONTEXT_V0;

@RestController
@RequestMapping(API_CONTEXT_V0+"/sport")
public class SportController {

    @Autowired
    private final SportService sportService = null;

    @GetMapping("/")
    public ResponseEntity<List<Sport>> getSports() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.sportService.getSports());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sport> getSportDetails(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.sportService.getSportDetails(id));
    }
}
