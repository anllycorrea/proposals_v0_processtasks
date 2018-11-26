package com.bbva.pzic.proposals.util.validation;

import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.pzic.proposals.util.Errors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.*;

/**
 * @author Entelgy
 */
@Component
public class DefaultValidator implements Validator {

    private static final Log LOG = LogFactory.getLog(DefaultValidator.class);

    private javax.validation.Validator validator;

    public DefaultValidator() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> void validate(T object, Class<?>... groups) {
        if (object == null) {
            throw new BusinessServiceException(Errors.MANDATORY_PARAMETERS_MISSING);
        }
        Set<ConstraintViolation<T>> constraintViolations = new HashSet<ConstraintViolation<T>>();
        if (object instanceof Collection<?>) {
            for (T element : (Collection<T>) object) {
                constraintViolations.addAll(this.validator.validate(element, groups));
            }
        } else {
            constraintViolations.addAll(this.validator.validate(object, groups));
        }
        if (!constraintViolations.isEmpty()) {
            final Iterator<ConstraintViolation<T>> constraintViolationIterator = constraintViolations.iterator();
            // SOLAMENTE se recupera la primera validación fallida
            // TODO lo ideal sería armar un "mensaje" con todos los errores encontrados, recorriendo la lista constraintViolationList
            final ConstraintViolation<T> constraintViolation = constraintViolationIterator.next();
            final String propertyPath = constraintViolation.getPropertyPath().toString();
            final String message = propertyPath.concat(" ").concat(constraintViolation.getMessage());
            LOG.error(String.format("Error en validación de campo %s. Mensaje: %s.", propertyPath, message));
            List<?> constraintValidatorClasses =
                    constraintViolation.getConstraintDescriptor().getConstraintValidatorClasses();
            if (!constraintValidatorClasses.isEmpty() &&
                    constraintValidatorClasses.get(0) == org.hibernate.validator.internal.constraintvalidators.bv.NotNullValidator.class) {
                throw new BusinessServiceException(Errors.MANDATORY_PARAMETERS_MISSING, message);
            } else {
                throw new BusinessServiceException(Errors.WRONG_PARAMETERS, message);
            }
        }
    }
}