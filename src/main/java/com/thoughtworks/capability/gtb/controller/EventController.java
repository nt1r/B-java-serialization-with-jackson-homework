package com.thoughtworks.capability.gtb.controller;

import com.thoughtworks.capability.gtb.converter.Converter;
import com.thoughtworks.capability.gtb.dto.EventDto;
import com.thoughtworks.capability.gtb.vo.EventType;
import com.thoughtworks.capability.gtb.vo.EventVo;
import com.thoughtworks.capability.gtb.vo.UserVo;

import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class EventController {

  @GetMapping("/events/{id}")
  public EventVo getEventById(@PathVariable("id") String id) {
    UserVo user = new UserVo("3", "张三");
    return new EventVo(id, "下载文件", EventType.DOWNLOAD, new Date(), user);
  }

  @PostMapping("/events")
  public EventVo createEvent(@RequestBody EventDto eventDto) {
    // log.info("create event: {}", eventVo);
    // System.out.println(Converter.eventDto2EventVo(eventDto));
    return Converter.eventDto2EventVo(eventDto);
  }
}
