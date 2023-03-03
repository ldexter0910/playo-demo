package com.playo.demo.entities;

import com.playo.demo.utils.enums.UserRoleBasedAuthority;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Credential {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private final UserRoleBasedAuthority userRoleBasedAuthority = UserRoleBasedAuthority.USER;

    @Column(name = "is_enabled", nullable = false)
    private final Boolean isEnabled = true;

    @Column(name = "is_account_non_expired", nullable = false)
    private final Boolean isAccountNonExpired = true;

    @Column(name = "is_account_non_locked", nullable = false)
    private final Boolean isAccountNonLocked = true;

    @Column(name = "is_credentials_non_expired", nullable = false)
    private final Boolean isCredentialsNonExpired = true;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "credential")
    private Player player;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "credential")
    private List<VerificationToken> verificationTokens = new ArrayList<>();

    protected Credential() { }

    public Credential(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserRoleBasedAuthority getUserRoleBasedAuthority() {
        return userRoleBasedAuthority;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public Boolean getAccountNonExpired() {
        return isAccountNonExpired;
    }

    public Boolean getAccountNonLocked() {
        return isAccountNonLocked;
    }

    public Boolean getCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public Player getPlayer() {
        return player;
    }

    public List<VerificationToken> getVerificationTokens() {
        return verificationTokens;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addVerificationToken(VerificationToken token) { this.verificationTokens.add(token); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Credential)) return false;
        Credential that = (Credential) o;
        return Objects.equals(id, that.id) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }

    @Override
    public String toString() {
        return "Credential{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
