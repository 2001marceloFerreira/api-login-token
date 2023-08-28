package br.com.clientes.apiclientes.commons;


import br.com.clientes.apiclientes.config.JacksonConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectExtensions {

    private static final ObjectMapper objectMapper = JacksonConfiguration.ObjectToObjectMapperBuild();

    public static <T> T toObject(Object object, Class<T> valueType) {
        try {
            return objectMapper.convertValue(object, valueType);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter o objeto" + object.getClass().getName() + " para o tipo " + valueType.getName(), e);
        }

    }

    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter o objeto"
                    + object.getClass().getName() + " para string Json", e);
        }

    }

}

