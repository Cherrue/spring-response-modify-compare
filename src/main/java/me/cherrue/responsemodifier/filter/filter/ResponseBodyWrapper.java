package me.cherrue.responsemodifier.filter.filter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;

public class ResponseBodyWrapper extends HttpServletResponseWrapper {
    ByteArrayOutputStream output;
    FilterServletOutputStream filterOutput;

    public ResponseBodyWrapper(HttpServletResponse response) {
        super(response);
        output = new ByteArrayOutputStream();
    }

    public ServletOutputStream getOutputStream() {
        if (filterOutput == null) {
            filterOutput = new FilterServletOutputStream(output);
        }
        return filterOutput;
    }

    public byte[] getDataStream() {
        return output.toByteArray();
    }
}
