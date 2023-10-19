package de.iav.backend.controller;

import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.iav.backend.model.Bag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WithMockUser(username = "user")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
@AutoConfigureMockMvc
class BagControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private final static String BASE_URL = "/api/bags";
    private final ObjectMapper objectMapper = new ObjectMapper();
    Bag bag1 = new Bag("1","lunchbox","500", "Coach");
    Bag bag2 = new Bag("2","MediumTote","250", "KS");
    @BeforeEach
    void insertTestStudents() throws Exception {
        mockMvc.perform(post(BASE_URL)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(bag1))
        );
        mockMvc.perform(post(BASE_URL)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(bag2))
        );
    }
    @Test
    void getAllBags_shouldReturnAllEntries_whenTwoEntriesAreSavedAndNoSearchParamsAreDefined() throws Exception {
        mockMvc.perform(get(BASE_URL))
                .andExpect(jsonPath("[0].id").isNotEmpty())
                .andExpect(jsonPath("[0].type").value(bag1.type()))
                .andExpect(jsonPath("[1].id").isNotEmpty())
                .andExpect(jsonPath("[1].type").value(bag2.type()));
    }
    //@Test
//    void getAllBagsByType_shouldReturnOneEntry_whenOneFittingEntryExists() throws Exception {
//
//        mockMvc.perform(get(BASE_URL + "/type/" + bag1.type()))
//                .andExpect(jsonPath("$[0].type").value(bag1.type()))
//                .andExpect(jsonPath("$", hasSize(1)));
//    }

}