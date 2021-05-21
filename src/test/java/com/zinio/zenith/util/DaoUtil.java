package com.zinio.zenith.util;

import com.zinio.zenith.models.dao.EntityDao;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by trongnguyen on 9/21/16.
 */
public class DaoUtil {


    public static <T> void deleteExistedRecord(@NotNull EntityDao<T> dao, Map<String, Object> postParams, String sql) throws Throwable {
        List<T> entities = DaoUtil.getListBy(dao, dao.getEntityClassName(), postParams, sql);
        if (entities != null && entities.size() > 0) {
            entities.stream()
                    .forEach(entity -> dao.delete(entity));
        }

    }

    public static <T> void deleteExistedRecord(@NotNull EntityDao<T> dao, Map<String, Object> postParams) throws Throwable {
        deleteExistedRecord(dao, postParams, null);
    }


    public static <T> List<T> getListBy(@NotNull EntityDao<T> dao, @NotNull String entityClassName, Map<String, Object> params, String sql) throws Throwable {
        String query = DaoUtil.buildQuery(entityClassName, params, sql);
        if (query != "") {
            return dao.getAllByJPQL(query);
        } else {
            return null;
        }

    }

    public static <T> List<T> getListBy(@NotNull EntityDao<T> dao, @NotNull String entityClassName, Map<String, Object> params) throws Throwable {
        return getListBy(dao, entityClassName, params, null);
    }


    public static <T> Object getOneBy(@NotNull EntityDao<T> dao, @NotNull String entityClassName, Map<String, Object> params, String sql) throws Throwable {
        String query = buildQuery(entityClassName, params, sql);
        if (query != "") {
            return dao.getOneByJPQL(query);
        } else {
            return null;
        }

    }

    public static <T> Object getOneBy(@NotNull EntityDao<T> dao, @NotNull String entityClassName, Map<String, Object> params) throws Throwable {
        return getOneBy(dao, entityClassName, params, null);
    }


    /**
     * @param entityClassName
     * @param params
     * @param sql
     * @param <T>
     * @return
     */
    public static <T> String buildQuery(@NotNull String entityClassName, Map<String, Object> params, String sql) {
        String query = "";
        if (params != null) {
            String where = params
                    .entrySet()
                    .stream()
                    .filter(entry -> !"key".equals(entry.getKey()))
                    .map(entry -> String.format(
                            "i.%s%s",
                            PropertyConverter.convertFieldToProperty(entry.getKey()), BindingUtil.dynamicFormatData(entry.getValue())))
                    .collect(Collectors.joining(" AND "));
            return String.format("SELECT i FROM %s i WHERE %s", entityClassName, where);
        }
        if (sql != null) {
            return sql;
        }
        return "";
    }

    public static <T> String buildQuery(@NotNull String entityClassName, Map<String, Object> params) {
        return buildQuery(entityClassName, params, null);
    }

}
