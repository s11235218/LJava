package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

public class JSONUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    public static <T> T read(InputStream is, Class<T> tClass) {
        try {
            return MAPPER.readValue(is, tClass);
        } catch (IOException e) {
            throw new RuntimeException("JSON反序列化失败！", e);
        }
    }

    public static String write(Object o) {
        try {
            return MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON序列化失败！", e);
        }
    }
}
