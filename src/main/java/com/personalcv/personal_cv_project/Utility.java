package com.personalcv.personal_cv_project;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

public class Utility {
    public JsonNode mapObjectToJson(Map mapObject) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(mapObject);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return objectMapper.readTree(json);
    }

    public JsonNode jsonFileToJsonNode(String fileName) throws IOException {

        JsonNode jsonNode = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<?, ?> map = mapper.readValue(Paths.get(fileName).toFile(), Map.class);
            String json = mapper.writeValueAsString(map);
            jsonNode = mapper.readTree(json);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return jsonNode;
    }

}
