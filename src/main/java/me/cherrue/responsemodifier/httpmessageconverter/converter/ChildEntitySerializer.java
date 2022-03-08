package me.cherrue.responsemodifier.httpmessageconverter.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import me.cherrue.responsemodifier.ChildEntity;

import java.io.IOException;

public class ChildEntitySerializer extends StdSerializer<ChildEntity> {
    public ChildEntitySerializer(Class<ChildEntity> childEntityClass) {
        super(childEntityClass);
    }

    @Override
    public void serialize(ChildEntity childEntity, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();

        jsonGenerator.writeStringField("data1", childEntity.getData1());

        jsonGenerator.writeEndObject();
    }
}
