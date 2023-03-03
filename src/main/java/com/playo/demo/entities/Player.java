package com.playo.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Player {
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;

    @JsonIgnore
    @OneToOne
    @JoinColumn(referencedColumnName = "id")
    private Credential credential;

    @JsonIgnore
    @OneToMany(mappedBy = "createdBy")
    private List<Activity> createdActivities = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "player")
    private List<Request> requestsMade = new ArrayList<>();

    protected Player() {
    }

    public Player(String firstName, String lastName, Credential credential) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.credential = credential;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Credential getCredential() {
        return credential;
    }

    public List<Activity> getCreatedActivities() {
        return createdActivities;
    }

    public List<Request> getRequestsMade() {
        return requestsMade;
    }

    public void addActivity(Activity activity) {
        this.createdActivities.add(activity);
    }

    public List<Request> getRequests() {
        return this.requestsMade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id) && Objects.equals(firstName, player.firstName) && Objects.equals(lastName, player.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
