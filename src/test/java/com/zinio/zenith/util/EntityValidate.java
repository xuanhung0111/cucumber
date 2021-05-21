package com.zinio.zenith.util;

import com.zinio.zenith.models.dao.EntityDao;
import org.hamcrest.Matchers;
import org.joor.Reflect;
import org.junit.Assert;

import javax.validation.constraints.NotNull;

/**
 * Created by trongnguyen on 9/21/16.
 */
public class EntityValidate {
    public static <T> void validateEntityExisted(@NotNull EntityDao<T> dao, Object id) {
        Object entity = dao.getById(id);
        Assert.assertThat(entity, Matchers.notNullValue());
    }
    public static void validateFieldData(Object entityDTO, String name, String expectedValue) {
        if ("NULL".equals(expectedValue)) {
            expectedValue = null;
        }
        String fieldName = PropertyConverter.convertFieldToProperty(name);
        Object actualValue = Reflect.on(entityDTO).get(fieldName);
        if (null != actualValue && null != expectedValue) {
            Assert.assertThat(actualValue.toString(), Matchers.equalTo(expectedValue.toString()));
        } else {
            Assert.fail("The " + name + " is not has value as " + expectedValue);
        }
    }
}
