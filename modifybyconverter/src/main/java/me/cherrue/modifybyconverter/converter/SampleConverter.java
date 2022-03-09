package me.cherrue.modifybyconverter.converter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import me.cherrue.modifybyconverter.entity.ChildEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

public class SampleConverter {
    public HttpMessageConverter<?> sampleConverter() {
        ObjectMapper objectMapper = objectMapper();

        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(ChildEntity.class, new ChildEntitySerializer(ChildEntity.class));
        objectMapper.registerModule(simpleModule);

        MappingJackson2HttpMessageConverter sampleConverter = new MappingJackson2HttpMessageConverter();
        sampleConverter.setObjectMapper(objectMapper);

        return sampleConverter;
    }

    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }
}
