package com.thoughtworks.capability.gtb.vo;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.thoughtworks.capability.gtb.serializer.DateSerializer;
import com.thoughtworks.capability.gtb.serializer.EventTypeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventVo {

  private String id;
  private String name;

  @JsonSerialize(using = EventTypeSerializer.class)
  private EventType type;

  @JsonSerialize(using = DateSerializer.class)
  private Date time;

  @JsonUnwrapped
  private UserVo user;
}
