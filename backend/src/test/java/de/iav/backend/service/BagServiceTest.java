package de.iav.backend.service;

import de.iav.backend.exception.UserNotFoundException;
import de.iav.backend.model.Bag;
import de.iav.backend.model.User;
import de.iav.backend.repository.BagRepository;

import de.iav.backend.repository.UserRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class BagServiceTest {
    BagRepository bagRepository = mock(BagRepository.class);
    BagService bagService = new BagService(bagRepository);
    @Test
    void getBagById_whenExistingId_thenReturnBag() {
        //GIVEN
        String expectedBagId = "1";
        Bag expectedBag = new Bag("1","lunchbox","500", "Coach");

        // Wie soll sich das "gemockte" Repository verhalten?
        // Der Dummy soll das expectedProduct liefern, wenn ein Aufruf von getProductById
        // mit der ID expectedProductId kommt
        when(bagRepository.findById(expectedBagId)).thenReturn(Optional.of(expectedBag));


        //WHEN
        Optional<Bag> actualBag = bagService.getBagById(expectedBagId);

        //THEN
        assertEquals(expectedBag, actualBag.get());
        // Sicherstellen, dass getProductById auch WIRKLICH aufgerufen wurde
        verify(bagRepository).findById(any());
    }

//    @Test
//    void updateUserById_whenNonExistingId_thenThrowUserNotFoundException() {
//        User user = new User("userId",  "Erum", "Schuakat", "erum.schaukat@iav.de", "12345");
//        //GIVEN
//        when(userRepository.findById("nonExistingId")).thenThrow(UserNotFoundException.class);
//
//        //WHEN + THEN
//        assertThrows(UserNotFoundException.class, () -> userService.updateUser("nonExistingId",user));
//    }

}