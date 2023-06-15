package com.gridpro.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.gridpro.api.payloads.Payload;

public class PostAPIBuilder {

    public static Map<String, Object> postRequestBody(String fileName, Object... values) {
        String requestJson = new String(fileName);
        Map<String, Object> requestBody = new HashMap<>();
        try {
            requestBody = JsonUtil.asMap(Payload.getRequest(requestJson, values));
        } catch (final IOException e) {

        }
        return requestBody;
    }
}
