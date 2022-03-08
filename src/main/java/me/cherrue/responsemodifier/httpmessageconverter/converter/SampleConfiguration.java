package me.cherrue.responsemodifier.httpmessageconverter.converter;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
public class SampleConfiguration extends WebMvcConfigurationSupport {
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new SampleConverter().sampleConverter());
        super.configureMessageConverters(converters);
    }
}
