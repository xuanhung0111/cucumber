package com.zinio.zenith.util;

import cucumber.api.DataTable;
import javassist.CannotCompileException;
import javassist.NotFoundException;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by trongnguyen on 9/22/16.
 */
public class DataTableHelper {
    public static <T> List<T> convertToList(@NotNull DataTable dataTable, @NotNull Class<T> elementType) throws NotFoundException, CannotCompileException {
        return dataTable.asList(TableRowEntityMapper.createProxyClass(elementType));
    }
}
