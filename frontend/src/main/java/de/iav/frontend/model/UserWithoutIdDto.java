package de.iav.frontend.model;


import java.util.List;

public record UserWithoutIdDto(
        String userName,

        String email,
        String password,
        List<Bag>listOfBags
) {
}
