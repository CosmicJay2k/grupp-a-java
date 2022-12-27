package com.example.gruppajava.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.example.gruppajava.repository.ParkSlotRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ParkSlotController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ParkSlotControllerTest {
  
  @MockBean
  ParkSlotRepository parkslotRepository;

//  @MockBean
//  ParkPriceZoneRepository parkpricezoneRepository;

  @Autowired
  private MockMvc mvc;

  @Test
  void getParkSlotShouldReturn200OK() throws Exception {
      mvc.perform(get("/api/parkslot"))
        .andExpect(status().isOk());
  }

  @Test
  void getParkSlotShouldGiveListOfParkSlots() throws Exception{
    mvc.perform(get("/api/parkslot"))
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(content().json("[]"));
  }



  public static String asJsonString(final Object obj) {
    try {
        return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
  }
  
}

