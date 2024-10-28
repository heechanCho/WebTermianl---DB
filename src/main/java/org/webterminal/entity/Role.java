package org.webterminal.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    ADMIN("ROLE_ADMIN", "admin"),
    USER("ROLE_USER", "user");

    private final String key;
    private final String user;
}
