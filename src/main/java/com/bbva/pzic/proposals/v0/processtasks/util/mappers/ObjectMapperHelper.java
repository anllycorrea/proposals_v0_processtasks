package com.bbva.pzic.proposals.v0.processtasks.util.mappers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

/**
 * @author Entelgy
 */
public final class ObjectMapperHelper {

    private static final ObjectMapperHelper INSTANCE = new ObjectMapperHelper();
    private final ObjectMapper mapper;

    private ObjectMapperHelper() {
        this.mapper = new ObjectMapper();
        this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        this.mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    }

    public static ObjectMapperHelper getInstance() {
        return INSTANCE;
    }

    public String writeValueAsString(final Object value) throws IOException {
        return mapper.writeValueAsString(value);
    }

    public <T> T convertValue(final Object fromValue, final Class<T> toValueType) {
        return mapper.convertValue(fromValue, toValueType);
    }

    public <T> T readValue(final String content, final Class<T> valueType) throws IOException {
        return mapper.readValue(content, valueType);
    }

    public <T> T readValue(final InputStream src, final Class<T> valueType) throws IOException {
        return mapper.readValue(src, valueType);
    }

    public <T> T readValue(final String content, final TypeReference<T> valueTypeRef) throws IOException {
        return mapper.readValue(content, valueTypeRef);
    }

    public <T> T readValue(final InputStream src, final TypeReference<T> valueTypeRef) throws IOException {
        return mapper.readValue(src, valueTypeRef);
    }
}