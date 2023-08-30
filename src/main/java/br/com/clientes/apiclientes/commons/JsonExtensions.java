package br.com.clientes.apiclientes.commons;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class JsonExtensions {

    public static JSONObject payloadToJsonObject(@NotNull String payload) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = Test.class.getResourceAsStream("/payloads/" + payload);
            JsonNode jsonNodeRequest = mapper.readTree(is);
            return new JSONObject(mapper.writeValueAsString(jsonNodeRequest));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter o payload para JsonObject:" + payload, e);
        }
    }

    public static <T> T stringJsonToObject(String jsonString, Class<T> valueType) {
        try {
            return new ObjectMapper().readValue(jsonString, valueType);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter string para o tipo " + valueType.getName());
        }
    }

    public static String objectToStringJson(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String erroMessageToString(String message) {
        String errorMessage = "";
        try {

            String responsejSON = message.substring(message.indexOf("{"), message.length());
            JSONObject jObject = new JSONObject(responsejSON);

            String error = jObject.get("errorCode").toString();
            errorMessage = jObject.get("message").toString();
            return errorMessage;

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
