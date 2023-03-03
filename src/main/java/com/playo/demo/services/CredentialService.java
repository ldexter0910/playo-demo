package com.playo.demo.services;

import com.playo.demo.entities.Credential;
import com.playo.demo.repositories.CredentialRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CredentialService {
    @Autowired
    private CredentialRepository credentialRepository;

    public Credential findByUserName(String userName) throws UsernameNotFoundException {
        return this.credentialRepository.findByUsernameIgnoreCase(userName)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Credential with username %s not found", userName))
        );
    }

    public Credential save(Credential credential) throws Exception {
        return this.credentialRepository.save(credential);
    }
}
