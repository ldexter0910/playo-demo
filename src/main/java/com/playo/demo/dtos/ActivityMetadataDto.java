package com.playo.demo.dtos;

import com.playo.demo.entities.Activity;
import com.playo.demo.entities.Format;
import com.playo.demo.entities.Player;
import com.playo.demo.entities.Sport;
import com.playo.demo.utils.enums.RequestStatusEnum;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.format.DateTimeFormatter;

public class ActivityMetadataDto {
    private Sport sport;
    private Format format;
    private String date;
    private String startTime;
    private String endTime;

    @NotNull
    @Min(-90)
    @Max(90)
    private Double latitude;

    @Min(-180)
    @Max(180)
    @NotNull
    private Double longitude;
    private Player createdBy;
    private Long approvedPlayersCount;

    public ActivityMetadataDto(Activity activity) {
        this.sport = activity.getSport();
        this.format = activity.getFormat();
        this.date = activity.getDate().format(DateTimeFormatter.ISO_DATE);
        this.startTime = activity.getStartTime().format(DateTimeFormatter.ISO_DATE_TIME);
        this.endTime = activity.getEndTime().format(DateTimeFormatter.ISO_DATE_TIME);
        this.latitude = activity.getLatitude();
        this.longitude = activity.getLongitude();
        this.createdBy = activity.getCreatedBy();
        this.approvedPlayersCount = 1 + activity.getRequests().stream().filter(x -> x.getStatus() == RequestStatusEnum.APPROVED).count();
    }

    public Sport getSport() {
        return sport;
    }

    public Format getFormat() {
        return format;
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

    public Player getCreatedBy() {
        return createdBy;
    }

    public Long getApprovedPlayersCount() {
        return approvedPlayersCount;
    }
}
