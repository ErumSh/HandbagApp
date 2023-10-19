package de.iav.frontend.model;


import java.util.List;

public record User(
        String id,
        String userName,
        String email,
        String password,
        String role,
        List<Bag>listOfBags

) {
}
