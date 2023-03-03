package com.playo.demo.services;

import com.playo.demo.dtos.LoginRequest;
import com.playo.demo.dtos.LoginResponse;
import com.playo.demo.dtos.SignupRequest;
import com.playo.demo.dtos.UserDetailsImpl;
import com.playo.demo.entities.Credential;
import com.playo.demo.entities.Player;
import com.playo.demo.entities.VerificationToken;
import com.playo.demo.repositories.PlayerRepository;
import com.playo.demo.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PlayerService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CredentialService credentialService;
    @Autowired
    private VerificationTokenService verificationTokenService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PlayerRepository playerRepository;

    public LoginResponse login(LoginRequest request) throws Exception {
        try {
            this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        }
        catch (BadCredentialsException e) {
            throw new Exception("Bad credentials");
        }

        final var credential = this.credentialService.findByUserName(request.getUsername().toLowerCase());
        final String jwtToken = this.jwtUtil.generateToken(new UserDetailsImpl(credential));
        final var verificationToken = new VerificationToken(jwtToken);
        credential.addVerificationToken(verificationToken);
        this.verificationTokenService.save(verificationToken);
        this.credentialService.save(credential);

        return new LoginResponse(credential.getPlayer().getId(), credential.getUsername(), jwtToken);
    }

    public LoginResponse signup(SignupRequest request) throws Exception {
        final Credential credential = new Credential(request.getEmailId(), passwordEncoder.encode(request.getPassword()));
        final String jwtToken = this.jwtUtil.generateToken(new UserDetailsImpl(credential));
        final VerificationToken verificationToken = new VerificationToken(jwtToken);
        credential.addVerificationToken(verificationToken);
        this.verificationTokenService.save(verificationToken);
        this.credentialService.save(credential);

        final Player player = new Player(request.getFirstName(), request.getLastName(), credential);
        this.playerRepository.save(player);

        return new LoginResponse(credential.getPlayer().getId(), credential.getUsername(), jwtToken);
    }

    public Player getPlayerDetails(Long id) throws Exception {
        return this.playerRepository.findById(id).orElseThrow(() -> new Exception("Player not found"));
    }
}
