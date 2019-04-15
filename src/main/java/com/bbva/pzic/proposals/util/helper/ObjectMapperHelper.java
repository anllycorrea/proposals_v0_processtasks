package com.bbva.pzic.proposals.util.helper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

/**
 * @author Entelgy
 */
public final class ObjectMapperHelper {

    private static final ObjectMapperHelper INSTANCE = new ObjectMapperHelper();
    private ObjectMapper mapper;

    private ObjectMapperHelper() {
        this.mapper = new ObjectMapper();
        this.mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        this.mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static ObjectMapperHelper getInstance() {
        return INSTANCE;
    }

    public String writeValueAsString(final Object value) throws JsonProcessingException {
        return mapper.writeValueAsString(value);
    }

    public <T> T convertValue(Object fromValue, Class<T> toValueType) {
        return mapper.convertValue(fromValue, toValueType);
    }

    public <T> T readValue(final String content, final Class<T> valueType) throws IOException {
        return mapper.readValue(content, valueType);
    }

    public <T> T readValue(final InputStream src, final Class<T> valueType) throws IOException {
        return mapper.readValue(src, valueType);
    }

    public <T> T readValue(final InputStream src, final TypeReference valueTypeRef) throws IOException {
        return mapper.readValue(src, valueTypeRef);
    }

    public <T> T readValue(final String content, final TypeReference valueTypeRef) throws IOException {
        return mapper.readValue(content, valueTypeRef);
    }
}
