package com.bbva.pzic.proposals.util.mappers;

import com.bbva.jee.arq.spring.core.servicing.configuration.ConfigurationManager;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.proposals.util.Errors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created on 12/12/2016.
 *
 * @author Entelgy
 */
@Component
public class EnumMapper {

    private static final Log LOG = LogFactory.getLog(EnumMapper.class);

    private static final String PROPERTY_INPUT_ENUMS = "servicing.enum.input.";
    private static final String PROPERTY_OUTPUT_ENUMS = "servicing.enum.output.";

    @Autowired
    private ConfigurationManager configurationManager;

    public String getBackendValue(final String field, final String enumValue) {
        if (enumValue == null) {
            return null;
        }

        String key = PROPERTY_INPUT_ENUMS.concat(field).concat(".").concat(enumValue);

        return getProperty(key);
    }

    public String getEnumValue(final String field, final String backendValue) {
        if (backendValue == null) {
            return null;
        }

        String key = PROPERTY_OUTPUT_ENUMS.concat(field).concat(".").concat(backendValue);

        return getProperty(key);
    }

    private String getProperty(final String key) {
        String value = configurationManager.getProperty(key);

        if (value == null) {
            LOG.error(String.format("Property key '%s' is not defined", key));

            throw new BusinessServiceException(Errors.WRONG_PARAMETERS);
        }
        return value;
    }
}
