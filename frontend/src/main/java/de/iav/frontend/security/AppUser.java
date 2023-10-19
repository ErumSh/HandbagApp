package de.iav.frontend.security;


public record AppUser(
        String id,
        String firstName,
        String lastName,
        String email,
        String password

) {
}
