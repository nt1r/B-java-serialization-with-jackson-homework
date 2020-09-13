package com.thoughtworks.capability.gtb.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.thoughtworks.capability.gtb.vo.EventType;

import java.io.IOException;

public class EventTypeDeserializer extends StdDeserializer<EventType> {
    protected EventTypeDeserializer() {
        super(EventType.class);
    }

    @Override
    public EventType deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
        return EventType.createFromCode(parser.getText());
    }
}
