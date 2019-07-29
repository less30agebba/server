package com.taoleg.serverweb.main.common;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.springframework.util.StreamUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@Data
public class BodyReaderHttpServletRequestWrapper extends javax.servlet.http.HttpServletRequestWrapper {
    private byte[] requestBody = null;

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request
     * @throws IllegalArgumentException if the request is null
     */
    public BodyReaderHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);

        try {
            String method = request.getMethod();
            if ("GET".equalsIgnoreCase(method)) {
                Map<String, String> map = new HashMap();
                request.getParameterMap().forEach( (k,v) -> {
                    map.put(k,v[0]);
                });
                String params =JSONObject.toJSONString(map);
                requestBody  = params.getBytes();
            }else{
                requestBody = StreamUtils.copyToByteArray(request.getInputStream());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        if (requestBody == null) {
            requestBody = new byte[0];
        }

        final ByteArrayInputStream bais = new ByteArrayInputStream(requestBody);
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() throws IOException {
                return bais.read();
            }
        };
    }
}
