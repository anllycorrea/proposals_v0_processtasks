package com.bbva.pzic.proposals.util.validation;

/**
 * @author Entelgy
 */
public interface Validator {

    <T> void validate(T object, Class<?>... groups);

}