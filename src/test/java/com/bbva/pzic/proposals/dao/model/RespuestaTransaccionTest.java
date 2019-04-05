package com.bbva.pzic.proposals.dao.model;

import com.bbva.jee.arq.spring.core.host.RespuestaTransaccion;
import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.affirm.Affirm;
import org.junit.Test;

import java.util.List;

public class RespuestaTransaccionTest {

    @Test
    public void annotationRespuestaTransaccionTest() {
        final StringBuilder result = new StringBuilder();

        List<PojoClass> responses = PojoClassFactory
                .getPojoClassesRecursively(this.getClass().getPackage().getName(),
                        new FilterTestAndRooClasses());

        for (PojoClass response : responses) {
            RespuestaTransaccion respuestaTransaccion = response.getClazz().getAnnotation(RespuestaTransaccion.class);
            if (respuestaTransaccion == null) {
                result.append(String.format("\n%s not contain @RespuestaTransaccion annotation",
                        response.getClazz().getName()));
            }
        }

        Affirm.affirmTrue(result.toString(), result.toString().isEmpty());
    }

    private static class FilterTestAndRooClasses implements PojoClassFilter {
        public boolean include(PojoClass pojoClass) {
            return
                    !pojoClass.getSourcePath().contains("/test-classes/") &&
                            (pojoClass.getClazz().getSimpleName().startsWith("RespuestaTransaccion")
                                    && !pojoClass.getClazz().getSimpleName().contains("_Roo_"));
        }
    }


}
