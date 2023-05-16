package be.technifutur.debiluseventmanager.util;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN("ROLE_ADMIN"),
    OFFICER("ROLE_OFFICER"),
    USER("ROLE_USER");

    private final String role;

    Role(String role) {
        this.role = role;
    }
}
