package com.playo.demo.controllers;

import com.playo.demo.dtos.ActivityDetailsDto;
import com.playo.demo.dtos.ActivityMetadataDto;
import com.playo.demo.dtos.CreateActivityRequest;
import com.playo.demo.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.playo.demo.utils.constants.AppConstant.API_CONTEXT_V0;

@RestController
@RequestMapping(API_CONTEXT_V0+"/activity")
public class ActivityController {
    @Autowired
    public ActivityService activityService;

    @PostMapping("/")
    public ResponseEntity<ActivityDetailsDto> createActivity(@Valid @RequestBody CreateActivityRequest activityDetailsDto) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.activityService.create(activityDetailsDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<ActivityMetadataDto>> getNearbyActivityList(@RequestParam Double latitude, @RequestParam Double longitude) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.activityService.getNearbyActivityList(latitude, longitude));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityDetailsDto> getActivityDetails(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.activityService.getActivityDetails(id));
    }
}
