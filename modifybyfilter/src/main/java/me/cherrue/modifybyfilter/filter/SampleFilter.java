package me.cherrue.modifybyfilter.filter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.cherrue.modifybyfilter.entity.ParentEntity;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class SampleFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 1. 원래 response 대신 wrapper 를 컨트롤러에 보낸다.
        ResponseBodyWrapper responseBodyWrapper = new ResponseBodyWrapper((HttpServletResponse) servletResponse);
        filterChain.doFilter(servletRequest, responseBodyWrapper);
        // 2. 요청이 끝난 후 wrapper 에 담긴 응답을 꺼낸다
        String oldResponseMessage = new String(responseBodyWrapper.getDataStream(), StandardCharsets.UTF_8);

        // 3. jackson 으로 부모 형식으로 변환
        ObjectMapper objectMapper = objectMapper();
        ParentEntity parentEntity = objectMapper.readValue(oldResponseMessage, ParentEntity.class);
        String newResponseMessage = objectMapper.writeValueAsString(parentEntity);

        servletResponse.getOutputStream().write(newResponseMessage.getBytes());

    }
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }
}
