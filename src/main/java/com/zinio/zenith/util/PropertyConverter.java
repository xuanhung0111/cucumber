package com.zinio.zenith.util;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by trongnguyen on 9/21/16.
 */
public class PropertyConverter {
    public static String convertFieldToProperty(@NotNull String name) {
        String fieldName = Arrays
                .stream(name.split("_"))
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .collect(Collectors.joining(""));
        fieldName = fieldName.substring(0, 1).toLowerCase() + fieldName.substring(1);
        return fieldName;
    }
}
