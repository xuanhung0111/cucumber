package com.zinio.zenith.models.dao;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.metamodel.EntityType;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by ducnguyen on 9/23/16.
 */
public interface EntityDao<T> {
    void create(T t);

    void delete(T t);

    List<T> getAll();

    List<T> getAllByJPQL(@NotNull String jpqlQuery);

    List<T> getAllByJPQLByIds(@NotNull List<?> ids);

    List<T> getAllByJPQL(@NotNull String jpqlQuery, int start, int amount);

    List<T> getAllBy(@NotNull CriteriaQuery<T> criteriaQuery);



    T getOne();

    T getOneByJPQL(@NotNull String jpqlQuery);

    T getOneBy(@NotNull CriteriaQuery<T> criteriaQuery);

    long getCount();

    long getCountByJPQL(@NotNull String jpqlQuery);

//    CriteriaQuery<Long> createCountCriteriaQuery();

    T getById(Object id);

    void update(T t);

    //    EntityType<T> getEntityType();
//
//    EntityManager getEntityManager();
    String getEntityClassName();
}
