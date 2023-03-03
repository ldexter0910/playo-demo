package com.playo.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


import java.util.Objects;

@Entity
public class Format {
    @Id
    @GeneratedValue
    private Long id;
    private String format;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name="sport_id",referencedColumnName = "id",nullable = false, updatable = false)
    private Sport sport;

    protected Format() {}

    public Format(String format) {
        this.format = format;
    }

    public Long getId() {
        return id;
    }

    public String getFormat() {
        return format;
    }

    public Sport getSport() {
        return sport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Format)) return false;
        Format format1 = (Format) o;
        return id == format1.id && format.equals(format1.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, format);
    }

    @Override
    public String toString() {
        return "Format{" +
                "id=" + id +
                ", format='" + format + '\'' +
                '}';
    }
}
