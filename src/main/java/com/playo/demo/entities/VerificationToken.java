package com.playo.demo.entities;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class VerificationToken {
    @Id
    @GeneratedValue
    private Long id;
    private String token;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Credential credential;

    protected VerificationToken() {}

    public VerificationToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public Credential getCredential() {
        return credential;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VerificationToken)) return false;
        VerificationToken that = (VerificationToken) o;
        return Objects.equals(id, that.id) && Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, token);
    }

    @Override
    public String toString() {
        return "VerificationToken{" +
                "id=" + id +
                ", token='" + token + '\'' +
                '}';
    }
}
