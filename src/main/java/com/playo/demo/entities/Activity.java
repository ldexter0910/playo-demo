package com.playo.demo.entities;

import javax.persistence.*;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Activity {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name="sport_id", referencedColumnName = "id", nullable = false, updatable = false)
    private Sport sport;

    @OneToOne
    @JoinColumn(name="format_id", referencedColumnName = "id", nullable = false, updatable = false)
    private Format format;

    private LocalDate date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double latitude;
    private Double longitude;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id",nullable = false, updatable = false)
    private Player createdBy;

    @OneToMany(mappedBy = "activity")
    private List<Request> requests = new ArrayList<>();

    protected Activity() {
    }

    public Activity(
            Sport sport,
            Format format,
            LocalDate date,
            LocalDateTime startTime,
            LocalDateTime endTime,
            Double latitude,
            Double longitude,
            Player createdBy
    ) {
        this.sport = sport;
        this.format = format;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createdBy = createdBy;
    }

    public Long getId() {
        return id;
    }

    public Sport getSport() {
        return sport;
    }

    public Format getFormat() {
        return format;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Player getCreatedBy() {
        return createdBy;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void addRequest(Request request) {
        this.requests.add(request);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Activity)) return false;
        Activity activity = (Activity) o;
        return Objects.equals(id, activity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", sport=" + sport +
                ", format=" + format +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
