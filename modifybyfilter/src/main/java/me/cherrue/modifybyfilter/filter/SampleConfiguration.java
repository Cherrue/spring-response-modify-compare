package me.cherrue.modifybyfilter.filter;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;

@Configuration
public class SampleConfiguration implements WebMvcConfigurer, WebMvcRegistrations {
    @Bean
    public FilterRegistrationBean<Filter> setFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>(new SampleFilter());
        filterRegistrationBean.addUrlPatterns("/filter");
        return filterRegistrationBean;
    }
}
