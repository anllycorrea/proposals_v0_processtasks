package com.bbva.pzic.proposals.util;

import com.bbva.jee.arq.spring.core.servicing.configuration.ConfigurationManager;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
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
public class PropertyReader {

    private static final Log LOG = LogFactory.getLog(PropertyReader.class);

    private static final String INPUT_ENUMERATOR_PROPERTY_PREFIX = "servicing.enum.input.";
    private static final String OUTPUT_ENUMERATOR_PROPERTY_PREFIX = "servicing.enum.output.";

    @Autowired
    private ConfigurationManager configurationManager;

    public String getInputEnumPropertyValue(final String field, final String value) {
        if (value == null) {
            return null;
        }
        return getProperty(INPUT_ENUMERATOR_PROPERTY_PREFIX.concat(field).concat(".").concat(value));
    }

    public String getOutputEnumPropertyValue(final String field, final String value) {
        if (value == null) {
            return null;
        }
        return getProperty(OUTPUT_ENUMERATOR_PROPERTY_PREFIX.concat(field).concat(".").concat(value));
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
