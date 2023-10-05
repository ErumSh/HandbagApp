package de.iav.backend.security;
import de.iav.backend.model.AppUser;
import de.iav.backend.model.AppUserRole;
import de.iav.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppUserService implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new User(
                appUser.username(),
                appUser.password(),
                List.of(
                        new SimpleGrantedAuthority("ROLE_" + appUser.role().name())
                )
        );

    }
    public AppUserResponse createUser(AppUserRequest appUserRequest) {
        if (
                userRepository.findByUsername(appUserRequest.username()).isPresent() ||
                        userRepository.findAppUserByEmail(appUserRequest.email()).isPresent()
        ) {
            throw new UserAlreadyExistException("Username already exists");
        }

        AppUser userToSave = new AppUser(
                null,
                appUserRequest.username(),
                appUserRequest.email(),
                passwordEncoder.encode(appUserRequest.password()),
                AppUserRole.USER
        );

        AppUser savedUser = userRepository.save(userToSave);

        return new AppUserResponse(
                savedUser.id(),
                savedUser.username(),
                savedUser.email(),
                savedUser.role()
        );

    }
}