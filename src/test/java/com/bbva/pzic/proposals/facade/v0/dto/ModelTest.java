package com.bbva.pzic.proposals.facade.v0.dto;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.PojoClassFilter;
import com.openpojo.reflection.PojoField;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.affirm.Affirm;
import org.junit.Test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author Entelgy
 */
public class ModelTest {

    @Test
    public void wadlRequirementsTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        final StringBuilder result = new StringBuilder();

        List<PojoClass> canonics = PojoClassFactory.getPojoClasses(this.getClass().getPackage().getName(), new FilterTestClasses());
        for (PojoClass canonic : canonics) {
            this.implementsSerializableCheck(result, canonic);
            this.fieldSerialVersionUIDCheck(result, canonic);
            this.annotationXmlRootElementCheck(result, canonic);
            this.annotationXmlTypeCheck(result, canonic);
            this.annotationXmlAccessorTypeCheck(result, canonic);
        }

        Affirm.affirmTrue(result.toString(), result.toString().isEmpty());
    }

    private void implementsSerializableCheck(StringBuilder result, PojoClass canonic) {
        boolean discriminator = false;
        for (Class i : canonic.getClazz().getInterfaces()) {
            if (i.getName().equalsIgnoreCase(Serializable.class.getName())) {
                discriminator = true;
                break;
            }
        }

        if (!discriminator) {
            result.append(String.format("\n\t%s not implement Serializable class", canonic.getClazz().getName()));
        }
    }

    private void fieldSerialVersionUIDCheck(StringBuilder result, PojoClass canonic) {
        boolean discriminator = false;
        for (PojoField field : canonic.getPojoFields()) {
            if (field.getName().equalsIgnoreCase("serialVersionUID")) {
                discriminator = true;
                break;
            }
        }

        if (!discriminator) {
            result.append(String.format("\n\t%s not contain serialVersionUID property", canonic.getClazz().getName()));
        }
    }

    private void annotationXmlRootElementCheck(StringBuilder result, PojoClass canonic) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        XmlRootElement xmlRootElement = canonic.getClazz().getAnnotation(XmlRootElement.class);
        if (xmlRootElement != null) {
            this.nameCheck(result, canonic, xmlRootElement);
            this.nameSpaceCheck(result, canonic, xmlRootElement);
        } else {
            result.append(String.format("\n\t%s not contain annotation @XmlRootElement", canonic.getClazz().getName()));
        }
    }

    private void annotationXmlTypeCheck(StringBuilder result, PojoClass canonic) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        XmlType xmlType = canonic.getClazz().getAnnotation(XmlType.class);
        if (xmlType != null) {
            this.nameCheck(result, canonic, xmlType);
            this.nameSpaceCheck(result, canonic, xmlType);
        } else {
            result.append(String.format("\n\t%s not contain annotation @XmlType", canonic.getClazz().getName()));
        }
    }

    private void annotationXmlAccessorTypeCheck(StringBuilder result, PojoClass canonic) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        XmlAccessorType xmlAccessorType = canonic.getClazz().getAnnotation(XmlAccessorType.class);
        if (xmlAccessorType != null) {
            this.valueCheck(result, canonic, xmlAccessorType);
        } else {
            result.append(String.format("\n\t%s not contain annotation @XmlAccessorType", canonic.getClazz().getName()));
        }
    }

    private void valueCheck(StringBuilder result, PojoClass canonic, XmlAccessorType xmlAccessorType) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String expected = XmlAccessType.FIELD.name();
        String actual = ((XmlAccessType) xmlAccessorType.getClass().getMethod("value").invoke(xmlAccessorType)).name();
        if (!expected.equals(actual)) {
            System.out.println(xmlAccessorType.getClass().getName());
            result.append(
                    String.format("\n\t%s invalid value in the @%s annotation, expected %s, actual %s",
                            canonic.getClazz().getName(),
                            ((Annotation) xmlAccessorType).annotationType().getSimpleName(),
                            expected, actual));
        }
    }

    private <T> void nameCheck(StringBuilder result, PojoClass canonic, T annotation) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String expect = canonic.getClazz().getSimpleName();
        String actual = (String) annotation.getClass().getMethod("name").invoke(annotation);
        if (!expect.equalsIgnoreCase(actual)) {
            System.out.println(annotation.getClass().getName());
            result.append(
                    String.format("\n\t%s invalid name in the @%s annotation",
                            canonic.getClazz().getName(),
                            ((Annotation) annotation).annotationType().getSimpleName()));
        }
    }

    private <T> void nameSpaceCheck(StringBuilder result, PojoClass canonic, T annotation) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String actual = (String) annotation.getClass().getMethod("namespace").invoke(annotation);
        String expect = "urn:".concat(canonic.getClazz().getPackage().getName().replace(".", ":"));
        if (!expect.equalsIgnoreCase(actual)) {
            result.append(
                    String.format("\n\t%s invalid namespace in the @%s annotation",
                            canonic.getClazz().getName(),
                            ((Annotation) annotation).annotationType().getSimpleName()));
        }
    }

    private static class FilterTestClasses implements PojoClassFilter {
        public boolean include(PojoClass pojoClass) {
            return !pojoClass.getSourcePath().contains("/test-classes/");
        }
    }
}
