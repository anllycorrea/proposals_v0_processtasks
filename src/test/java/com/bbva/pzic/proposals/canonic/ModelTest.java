package com.bbva.pzic.proposals.canonic;

import com.bbva.pzic.utilTest.TestUtils;
import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.filters.FilterChain;
import com.openpojo.reflection.filters.FilterEnum;
import com.openpojo.reflection.filters.FilterNestedClasses;
import com.openpojo.reflection.filters.FilterPackageInfo;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.affirm.Affirm;
import org.junit.Test;

import java.util.List;

/**
 * Created on 05/12/2016.
 *
 * @author Entelgy
 */
public class ModelTest {

    // Configured for expectation, so we know when a class gets added or removed.
    private static final int EXPECTED_CLASS_COUNT = 43;

    // The packages to test
    private static final String POJO_PACKAGE = "com.bbva.pzic.proposals.canonic";

    @Test
    public void testPojos() {
        // OpenPojo validator
        Validator validator = TestUtils.setUpPojoValidator();
        List<PojoClass> pojoClasses = PojoClassFactory.getPojoClasses(POJO_PACKAGE,
                new FilterChain(new FilterPackageInfo(), new FilterEnum(), new FilterNestedClasses()));

        Affirm.affirmEquals("Classes added / removed?", EXPECTED_CLASS_COUNT, pojoClasses.size());

        validator.validate(POJO_PACKAGE, new FilterPackageInfo());
        TestUtils.testToString(pojoClasses);
    }
}
