package com.bbva.pzic.proposals.util;

/**
 * Created on 14/06/2016.
 *
 * @author Entelgy
 */
public final class Errors {

    /**
     * Lanzado cuando se especifican parámetros cuyos valores son incorrectos en referencia a su sintaxis, tipo de dato, etc.
     */
    public static final String WRONG_PARAMETERS = "wrongParameters";
    /**
     * Lanzado cuando se ha realizado una solicitud en la que hay parámetros obligatorios en la entrada y no se han especificado.
     */
    public static final String MANDATORY_PARAMETERS_MISSING = "mandatoryParametersMissing";
    /**
     * Lanzado cuando se realiza una solicitud con el parámetro especial "expands" y no se le asigna un valor.
     */
    public static final String EXPAND_EMPTY = "expandEmpty";
    /**
     * Lanzado cuando se realiza una solicitud con el parámetro especial "expands" y el elemento que queremos expandir no es una subentidad de la entidad reflejada en la uri.
     */
    public static final String EXPAND_ERROR = "expandError";
    /**
     * Lanzado cuando en el servicio se considera que se ha producido un error técnico.
     */
    public static final String TECHNICAL_ERROR = "technicalError";

    /**
     * Lanzado cuando, debido a restricciones en la entrada del servicio, haya parámetros no obligatorios, que se convierten en obligatorios en consecuencia del valor de otros campos.
     */
    public static final String PARAMETERS_MISSING = "parametersMissing";

    /**
     * Lanzado cuando se obtiene un error del backend.
     */
    public static final String FUNCTIONAL_ERROR = "functionalError";

    private Errors() {
        // Prevent instantiation
    }
}
