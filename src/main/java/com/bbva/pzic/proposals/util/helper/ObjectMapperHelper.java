package com.bbva.pzic.proposals.util.helper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created on 23/06/2016.
 *
 * @author Entelgy
 */
@Component
public class ObjectMapperHelper {

    private ObjectMapper mapper;

    @PostConstruct
    private void init() {
        mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public String writeValueAsString(final Object value) throws JsonProcessingException {
        return mapper.writeValueAsString(value);
    }

    public <T> T readValue(final String content, final Class<T> valueType) throws IOException {
        return mapper.readValue(content, valueType);
    }

    public <T> T readValue(final byte[] src, final Class<T> valueType) throws IOException {
        return mapper.readValue(src, valueType);
    }

    public <T> T readValues(final InputStream is, final TypeReference valueTypeRef) throws IOException {
        return mapper.readValue(is, valueTypeRef);
    }

    public <T> T readValues(final String content, final TypeReference valueTypeRef) throws IOException {
        return mapper.readValue(content, valueTypeRef);
    }
}
