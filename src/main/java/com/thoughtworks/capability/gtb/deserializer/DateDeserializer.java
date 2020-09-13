package com.thoughtworks.capability.gtb.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Date;

public class DateDeserializer extends StdDeserializer<Date> {
    protected DateDeserializer() {
        super(Date.class);
    }

    @Override
    public Date deserialize(JsonParser parser, DeserializationContext context) throws IOException, JsonProcessingException {
        /*JsonNode node = parser.getCodec().readTree(parser);
        Long milliseconds = node.get("time").longValue();
        return new Date(milliseconds);*/
        return new Date(parser.getLongValue());
    }
}
