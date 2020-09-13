package com.thoughtworks.capability.gtb.converter;

import com.thoughtworks.capability.gtb.dto.EventDto;
import com.thoughtworks.capability.gtb.vo.EventVo;
import com.thoughtworks.capability.gtb.vo.UserVo;

public class Converter {
    public static EventVo eventDto2EventVo(EventDto eventDto) {
        return new EventVo(
                eventDto.getId(),
                eventDto.getName(),
                eventDto.getType(),
                eventDto.getTime(),
                new UserVo(eventDto.getUserId(), eventDto.getUserName()));
    }
}
