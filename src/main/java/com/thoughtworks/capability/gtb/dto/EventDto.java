package com.thoughtworks.capability.gtb.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.thoughtworks.capability.gtb.deserializer.DateDeserializer;
import com.thoughtworks.capability.gtb.deserializer.EventTypeDeserializer;
import com.thoughtworks.capability.gtb.vo.EventType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
    private String id;
    private String name;

    @JsonDeserialize(using = EventTypeDeserializer.class)
    private EventType type;

    @JsonDeserialize(using = DateDeserializer.class)
    private Date time;

    private String userId;
    private String userName;
}
