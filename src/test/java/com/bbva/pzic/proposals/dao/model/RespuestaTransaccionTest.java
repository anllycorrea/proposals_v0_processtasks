package com.bbva.pzic.proposals.dao.model;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.RespuestaTransaccion;
import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;
import com.openpojo.reflection.PojoField;
import com.openpojo.reflection.impl.PojoClassFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author Entelgy
 */
public class RespuestaTransaccionTest {

    @Test
    public void annotationRespuestaTransaccionTest() {
        final StringBuilder result = new StringBuilder();

        List<PojoClass> classes = PojoClassFactory
                .getPojoClassesRecursively(this.getClass().getPackage().getName(),
                        new FilterRespuestaTransaccionTestAndRooClasses());

        classes.forEach(cs -> {
            RespuestaTransaccion respuestaTransaccion = cs.getClazz().getAnnotation(RespuestaTransaccion.class);
            if (respuestaTransaccion == null) {
                result.append(String.format("\n%s not contain @RespuestaTransaccion annotation",
                        cs.getClazz().getName()));
            }
        });

        assertTrue(result.toString(), result.toString().isEmpty());
    }

    @Test
    public void apxOrderFieldsTest() {
        final StringBuilder result = new StringBuilder();

        List<PojoClass> classes = PojoClassFactory
                .getPojoClassesRecursively(this.getClass().getPackage().getName(),
                        new FilterApxTransactionsClasses());

        classes.forEach(cs -> {
            if (!haveFieldsOrder(cs.getPojoFields())) {
                result.append(String.format("\n%s fields have not a correct order",
                        cs.getClazz().getName()));
            }
        });

        assertTrue(result.toString(), result.toString().isEmpty());
    }

    private boolean haveFieldsOrder(final List<PojoField> pojoFields) {
        int fieldIndex = 1;
        boolean result = Boolean.TRUE;
        for (PojoField pojoField : pojoFields) {
            if (!pojoField.isStatic()) {
                if (fieldIndex != pojoField.getAnnotation(Campo.class).indice()) {
                    result = Boolean.FALSE;
                } else {
                    ++fieldIndex;
                }
            }
        }

        return result;
    }

    private static class FilterRespuestaTransaccionTestAndRooClasses implements PojoClassFilter {
        public boolean include(PojoClass pojoClass) {
            return !pojoClass.getSourcePath().contains("/test-classes/") &&
                    (pojoClass.getClazz().getSimpleName().startsWith("RespuestaTransaccion")
                            && !pojoClass.getClazz().getSimpleName().contains("_Roo_"));
        }
    }

    private static class FilterApxTransactionsClasses implements PojoClassFilter {

        private static final String APX_MODEL_CLASS_REGEX = ".*[a-zA-Z]{4}[t]\\w{3}[_]\\d{1}$.*";
        private static final String APX_TRANSACCION_CLASS_REGEX = ".*[Transaccion][a-zA-Z]{4}[t]\\w{3}[_]\\d{1}$.*";

        public boolean include(PojoClass pojoClass) {
            return !pojoClass.getSourcePath().contains("/test-classes/") &&
                    (pojoClass.getClazz().getPackage().getName().matches(APX_MODEL_CLASS_REGEX)
                            && !pojoClass.getClazz().getSimpleName().matches(APX_TRANSACCION_CLASS_REGEX)
                            && !pojoClass.getClazz().getSimpleName().startsWith("RespuestaTransaccion")
                            && !pojoClass.getClazz().getSimpleName().startsWith("PeticionTransaccion")
                            && !pojoClass.getClazz().getSimpleName().contains("_Roo_"));
        }
    }
}
