package de.iav.backend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "usersold")
public class User  {
    @MongoId
    String id;
    String userName;
    String email;
    String password;
    String role;
    List<Bag> listOfBags;



    public User withId(String newId) {
        //return new User(newId, this.firstName, this.lastName, this.email, this.password, this.portfolio, this.moneyAccount);
        return new User(newId, this.userName, this.email, this.password, this.role, this.listOfBags);

    }
/*
    public NewAppUser getNewAppUser() {
                return new NewAppUser(null, this.firstName, this.lastName, this.email, this.password);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }*/
}
