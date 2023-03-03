package com.playo.demo.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CreateActivityRequest {
    @NotNull
    private Long sportId;
    @NotNull
    private Long formatId;
    @NotNull
    private String date;
    @NotNull
    private String startTime;
    @NotNull
    private String endTime;

    @NotNull
    @Min(-90)
    @Max(90)
    private Double latitude;

    @Min(-180)
    @Max(180)
    @NotNull
    private Double longitude;
    @NotNull
    private Long createdById;

    public CreateActivityRequest(
            Long sportId,
            Long formatId,
            String date,
            String startTime,
            String endTime,
            Double latitude,
            Double longitude,
            Long createdById
    ) {
        this.sportId = sportId;
        this.formatId = formatId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createdById = createdById;
    }

    public Long getSportId() {
        return sportId;
    }

    public Long getFormatId() {
        return formatId;
    }

    public String getDate() {
        return date;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Long getCreatedById() {
        return createdById;
    }
}
