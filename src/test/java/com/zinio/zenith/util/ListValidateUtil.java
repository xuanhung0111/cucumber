package com.zinio.zenith.util;

import org.hamcrest.Matchers;
import org.joor.Reflect;
import org.junit.Assert;

import javax.validation.constraints.NotNull;
import java.util.function.Function;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by trongnguyen on 9/19/16.
 */
public class ListValidateUtil {
    public static <T> void validateList(@NotNull List<T> actualItems, @NotNull List<?> expectedItems) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Assert.assertThat(actualItems.size(), Matchers.equalTo(expectedItems.size()));
        int size = expectedItems.size();
        Map<String, Method> getFieldMethodMap = new HashMap<>();
        Class baseClass = null;
        for (int i = 0; i < size; i++) {
            T actualItem = actualItems.get(i);
            T expectedItem = (T) expectedItems.get(i);
            if (null == baseClass) {
                baseClass = actualItem.getClass();
            }
            String errMessage = String.format("Test %s " + i + " at field: ", actualItem.getClass().getCanonicalName());
            validateItem(getFieldMethodMap, baseClass, errMessage, actualItem, expectedItem);
        }

    }

    public static <T> void validateSet(@NotNull List<T> actualItems, @NotNull List<?> expectedItems, @NotNull Function<T, ?> getIdProducer) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Map<?, T> itemMap = actualItems
                .stream()
                .collect(Collectors.toMap(item -> getIdProducer.apply(item), item -> item));
        Assert.assertThat(actualItems.size(), Matchers.equalTo(expectedItems.size()));
        int size = expectedItems.size();
        Map<String, Method> getFieldMethodMap = new HashMap<>();
        Class baseClass = null;
        for (int i = 0; i < size; i++) {
            T expectedItem = (T) expectedItems.get(i);
            Object id = getIdProducer.apply(expectedItem);
            T actualItem = itemMap.get(id);
            if (null == baseClass) {
                baseClass = actualItem.getClass();
            }
            String errMessage = String.format("Test item with id: %s " + id + " at field: ", actualItem.getClass().getCanonicalName());
            validateItem(getFieldMethodMap, baseClass, errMessage, actualItem, expectedItem);
        }

    }

    private static <T> void validateItem(Map<String, Method> getFieldMethodMap, Class baseClass, String errMessage, T actualItem, Object expectedItem) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        UpdatedPropertyInterface updatedPropertyInterface = (UpdatedPropertyInterface) expectedItem;
        assert null != baseClass;
        for (String getPropName : updatedPropertyInterface.getChangedProperties()) {
            Method getMethod = getFieldMethodMap.get(getPropName);
            if (null == getMethod) {
                getMethod = baseClass.getMethod(getPropName);
                getFieldMethodMap.put(getPropName, getMethod);
            }
            Object actualValue = getMethod.invoke(actualItem);
            Object expectedValue = getMethod.invoke(expectedItem);
            if (null != actualValue && null != expectedValue) {
                if (actualValue instanceof Date) {
                    Assert.assertThat(errMessage + " " + getPropName, ((Date) actualValue).toLocalDate(), Matchers.equalTo(((Date) expectedValue).toLocalDate()));
                } else if (actualValue instanceof Timestamp) {
                    Assert.assertThat(errMessage + " " + getPropName, ((Timestamp) actualValue).toLocalDateTime(), Matchers.equalTo(((Timestamp) expectedValue).toLocalDateTime()));
                } else {
                    Assert.assertThat(errMessage + " " + getPropName, actualValue, Matchers.equalTo(expectedValue));
                }
            } else {
                Assert.assertThat(errMessage + " " + getPropName, actualValue, Matchers.equalTo(expectedValue));
            }

        }
    }

    public static <T> void validateItem(T actualItem, UpdatedPropertyInterface updatedPropertyInterface) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        ListValidateUtil.validateItem(
                new HashMap<>(),
                actualItem.getClass(),
                String.format("Test %s at field: ", actualItem.getClass().getCanonicalName()),
                actualItem,
                updatedPropertyInterface
        );
    }

}
