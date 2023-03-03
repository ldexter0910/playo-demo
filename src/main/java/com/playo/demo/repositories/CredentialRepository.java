package com.playo.demo.repositories;

import com.playo.demo.entities.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredentialRepository extends JpaRepository<Credential, Long> {
    public Optional<Credential> findByUsernameIgnoreCase(final String username);
}
