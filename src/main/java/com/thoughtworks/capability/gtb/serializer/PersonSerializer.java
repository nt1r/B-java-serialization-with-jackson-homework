package com.thoughtworks.capability.gtb.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.thoughtworks.capability.gtb.vo.PersonVo;

import java.io.IOException;

public class PersonSerializer extends StdSerializer<PersonVo> {
    protected PersonSerializer() {
        super(PersonVo.class);
    }

    @Override
    public void serialize(PersonVo personVo, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeStartObject();
        generator.writeStringField("id", personVo.getId());
        if (personVo.getAge() == null) {
            generator.writeNumberField("age", 0);
        } else {
            generator.writeNumberField("age", personVo.getAge());
        }
        generator.writeStringField("name", personVo.getName());
        if (personVo.getHobby() != null) {
            generator.writeStringField("hobby", personVo.getHobby());
        }
        generator.writeEndObject();
    }
}
