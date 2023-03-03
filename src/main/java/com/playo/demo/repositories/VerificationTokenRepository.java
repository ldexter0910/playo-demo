package com.playo.demo.repositories;

import com.playo.demo.entities.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    public boolean existsByToken(String token);
    public Optional<VerificationToken> findByToken(String token);
    public void deleteByToken(String token);
}
