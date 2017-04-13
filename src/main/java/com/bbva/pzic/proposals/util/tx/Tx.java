package com.bbva.pzic.proposals.util.tx;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Tx {

    /**
     * The value may indicate a suggestion for a logical component name, to be turned into a Spring bean in case of an
     * autodetected component.
     *
     * @return the suggested component name, if any
     */
    String value() default "";
}
