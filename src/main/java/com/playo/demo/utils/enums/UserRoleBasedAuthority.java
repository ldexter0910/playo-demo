package com.playo.demo.utils.enums;

public enum UserRoleBasedAuthority {
    USER ("USER");

    private final String role;
    private UserRoleBasedAuthority(String role) {
        this.role = role;
    }
    public String getRole() {
        return this.role;
    }

}
