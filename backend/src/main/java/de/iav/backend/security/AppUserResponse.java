package de.iav.backend.security;

import de.iav.backend.model.AppUserRole;

public record AppUserResponse(
        String id,

        String userName,
        String email,
        AppUserRole role
) {
}