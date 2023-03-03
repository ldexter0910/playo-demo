package com.playo.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Sport {
    @Id
    @GeneratedValue
    private Long id;
    private String type;

    @OneToMany(mappedBy = "sport")
    private List<Format> formats = new ArrayList<>();

    protected Sport() {
    }

    public Sport(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public List<Format> getFormats() {
        return formats;
    }

    public void addFormat(Format format) {
        this.formats.add(format);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sport)) return false;
        Sport sport = (Sport) o;
        return Objects.equals(id, sport.id) && Objects.equals(type, sport.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    @Override
    public String toString() {
        return "Sport{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
