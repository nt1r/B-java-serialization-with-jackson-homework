package com.thoughtworks.capability.gtb.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.capability.gtb.dto.EventDto;
import com.thoughtworks.capability.gtb.vo.EventType;
import com.thoughtworks.capability.gtb.vo.EventVo;
import com.thoughtworks.capability.gtb.vo.UserVo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EventControllerTest {
    private final String GET_EVENT_BY_ID_URL = "/events/%d";
    private final String CREATE_EVENT_URL = "/events";



    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void loadContext() { }

    @Test
    public void shouldSerializeSuccess() throws Exception {
        mockMvc.perform(get(String.format(GET_EVENT_BY_ID_URL, 1)).accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8"))
                .andExpect(jsonPath("$.id", is("1")))
                .andExpect(jsonPath("$.name", is("下载文件")))
                .andExpect(jsonPath("$.type", is("D")))
                .andExpect(jsonPath("$", hasKey("time")))
                .andExpect(jsonPath("$.userId", is("3")))
                .andExpect(jsonPath("$.userName", is("张三")))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeserializeSuccess() throws Exception {
        EventDto eventDto = new EventDto("1", "上传文件", EventType.UPLOAD, new Date(), "3", "张三");

        mockMvc.perform(post(CREATE_EVENT_URL).accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(eventDto)))
                .andExpect(jsonPath("$.id", is("1")))
                .andExpect(jsonPath("$.name", is("上传文件")))
                .andExpect(jsonPath("$.type", is("U")))
                .andExpect(jsonPath("$", hasKey("time")))
                .andExpect(jsonPath("$.userId", is("3")))
                .andExpect(jsonPath("$.userName", is("张三")))
                .andExpect(status().isOk());
    }
}