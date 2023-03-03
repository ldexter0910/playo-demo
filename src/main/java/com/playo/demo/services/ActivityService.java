package com.playo.demo.services;

import com.playo.demo.dtos.ActivityDetailsDto;
import com.playo.demo.dtos.ActivityMetadataDto;
import com.playo.demo.dtos.CreateActivityRequest;
import com.playo.demo.entities.Activity;
import com.playo.demo.entities.Format;
import com.playo.demo.entities.Player;
import com.playo.demo.entities.Sport;
import com.playo.demo.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ActivityService {
    @Autowired
    private PlayerService playerService;

    @Autowired
    private SportService sportService;

    @Autowired
    private FormatService formatService;

    @Autowired
    private ActivityRepository activityRepository;

    public ActivityDetailsDto create(CreateActivityRequest request) throws Exception {
        Sport sport = this.sportService.getSportDetails(request.getSportId());
        Format format = this.formatService.findById(request.getFormatId());
        Player createdBy = this.playerService.getPlayerDetails(request.getCreatedById());
        LocalDateTime startTime = LocalDateTime.parse(request.getStartTime(), DateTimeFormatter.ISO_DATE_TIME);
        LocalDateTime endTime = LocalDateTime.parse(request.getEndTime(), DateTimeFormatter.ISO_DATE_TIME);
        LocalDate date = LocalDate.parse(request.getDate(), DateTimeFormatter.ISO_DATE);

        Activity activity = new Activity(
                sport,
                format,
                date,
                startTime,
                endTime,
                request.getLatitude(),
                request.getLongitude(),
                createdBy
        );

        this.activityRepository.save(activity);

        return new ActivityDetailsDto(activity);
    }

    public ActivityDetailsDto getActivityDetails(Long id) throws Exception {
        Activity activity = this.activityRepository.findById(id).orElseThrow(() -> new Exception("Not Found"));
        return new ActivityDetailsDto(activity);
    }

    public Activity findById(Long id) throws Exception {
        return this.activityRepository.findById(id).orElseThrow(() -> new Exception("Not Found"));
    }

    public List<ActivityMetadataDto> getNearbyActivityList(Double latitude, Double longitude) throws Exception {
        LocalDateTime now = LocalDateTime.now();
        List<Activity> activities = this.activityRepository.findByStartTimeGreaterThan(now);

        Collections.sort(activities, (a,b) -> {
            if(a.getStartTime().equals(b.getStartTime())) {
                Double aDist = Math.abs(latitude-a.getLatitude()) + Math.abs(longitude - a.getLongitude());
                Double bDist = Math.abs(latitude-b.getLatitude()) + Math.abs(longitude - b.getLongitude());
                return aDist < bDist ? -1 : 1;
            }

            return a.getStartTime().compareTo(b.getStartTime());
        });

        return activities.stream().map(x -> new ActivityMetadataDto(x)).collect(Collectors.toList());
    }
}
