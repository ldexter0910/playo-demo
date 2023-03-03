package com.playo.demo.services;

import com.playo.demo.entities.Credential;
import com.playo.demo.entities.VerificationToken;
import com.playo.demo.repositories.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class VerificationTokenService {
    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    public boolean existsByToken(String token) {
        return this.verificationTokenRepository.existsByToken(token);
    }

    public VerificationToken findByToken(String token) throws Exception {
        return this.verificationTokenRepository.findByToken(token).orElseThrow(() -> new Exception("Not Found"));
    }

    public void deleteByToken(String token) {
        this.verificationTokenRepository.deleteByToken(token);
    }

    public VerificationToken save(VerificationToken token) throws Exception {
        return this.verificationTokenRepository.save(token);
    }
}
