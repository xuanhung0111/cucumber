package com.zinio.zenith.models.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DaoFactory implements ApplicationContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(DaoFactory.class);
    private static ApplicationContext context;
    @Autowired
    private GenericDao genericDao;

    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

    public <T> EntityDao<T> create(@NotNull Class<T> entityClass) {
        String beanName = entityClass.getSimpleName() + "Dao";
        EntityDao<T> baseDao = null;
        try {
            baseDao = (EntityDao<T>) context.getBean(beanName);
        } catch (NoSuchBeanDefinitionException e) {
            LOGGER.info("Create DAO : " + beanName);
            baseDao = createEntityDao(entityClass);
            ((ConfigurableApplicationContext) context).getBeanFactory().registerSingleton(beanName, baseDao);
        }
        return baseDao;
    }

    private <T> EntityDao<T> createEntityDao(@NotNull Class<T> entityClass) {
        return new BaseDao(genericDao, entityClass);
    }

    public static class BaseDao<T> implements EntityDao<T> {


        private final Class<T> genericType;
        private GenericDao genericDao;
        // ------------------------
        // PUBLIC METHODS
        // ------------------------

        public BaseDao(@NotNull GenericDao genericDao, @NotNull Class<T> genericType) {
            this.genericType = genericType;
            this.genericDao = genericDao;
        }


        /**
         * Save the t in the database.
         */
        @Override
        @Transactional
        public void create(T t) {
            this.genericDao.create(t);
        }

        /**
         * Delete the t from the database.
         */
        @Override
        public void delete(T t) {
            this.genericDao.delete(t);
        }

        /**
         * Return all the T records stored in the database.
         */
        @Override
        @SuppressWarnings("unchecked")
        public List<T> getAll() {
            return this.genericDao.getAll(this.genericType);
        }

        @Override
        public List<T> getAllByJPQL(@NotNull String jpqlQuery) {
            return this.genericDao.getAllByJPQL(this.genericType, jpqlQuery);
        }

        @Override
        public List<T> getAllByJPQLByIds(@NotNull List<?> ids) {
            return this.genericDao.getAllByJPQLByIds(this.genericType, ids);
        }

        @Override
        public List<T> getAllByJPQL(@NotNull String jpqlQuery, int start, int amount) {
            return this.genericDao.getAllByJPQL(this.genericType, jpqlQuery, start, amount);
        }

        @Override
        public List<T> getAllBy(@NotNull CriteriaQuery<T> criteriaQuery) {
            return this.genericDao.getAllBy(criteriaQuery);
        }

        @Override
        public T getOne() {
            return this.genericDao.getOne(this.genericType);
        }

        @Override
        public T getOneByJPQL(@NotNull String jpqlQuery) {
            return this.genericDao.getOneByJPQL(this.genericType, jpqlQuery);
        }

        @Override
        public T getOneBy(@NotNull CriteriaQuery<T> criteriaQuery) {
            return this.genericDao.getOneBy(criteriaQuery);
        }

        /**
         * Return the total the users stored in the database.
         */
        @Override
        @SuppressWarnings("unchecked")
        public long getCount() {
            return this.genericDao.getCount(this.genericType);
        }

        @Override
        public long getCountByJPQL(@NotNull String jpqlQuery) {
            return this.genericDao.getCountByJPQL(jpqlQuery);
        }

        public long getCountBy(@NotNull CriteriaQuery<Long> criteriaQuery) {
            return this.genericDao.getCountBy(criteriaQuery);
        }

        /**
         * Return the user having the passed id.
         */
        @Override
        public T getById(Object id) {
            return this.genericDao.getById(this.genericType, id);
        }

        /**
         * Update the passed t in the database.
         */
        @Override
        public void update(T t) {
            this.genericDao.update(t);
        }

        // ------------------------
        // PRIVATE FIELDS
        // ------------------------


        @Override
        public String getEntityClassName() {
            return this.genericType.getName();
        }
    }

    @Repository
    @Transactional
    public static class GenericDao {
        // ------------------------
        // PUBLIC METHODS
        // ------------------------


        /**
         * Save the t in the database.
         */
        @Transactional
        public <T> void create(T t) {
            entityManager.persist(t);
        }

        /**
         * Delete the t from the database.
         */
        public <T> void delete(T t) {
            if (entityManager.contains(t))
                entityManager.remove(t);
            else
                entityManager.remove(entityManager.merge(t));
            return;
        }

        /**
         * Return all the T records stored in the database.
         */
        @SuppressWarnings("unchecked")
        public <T> List<T> getAll(@NotNull Class<T> genericType) {
//            CriteriaQuery<T> selectCriteriaQuery = this.createSelectCriteriaQuery(genericType);
//            return entityManager.createQuery(selectCriteriaQuery).getResultList();
            return entityManager.createQuery(
                    String.format(
                            "SELECT COUNT(t) FROM %s t",
                            genericType.getName()
                    )
                    , genericType).getResultList();
        }

        public <T> List<T> getAllByJPQL(@NotNull Class<T> genericType, @NotNull String jpqlQuery) {
            return entityManager.createQuery(jpqlQuery, genericType).getResultList();
        }

        public <T> List<T> getAllByJPQL(@NotNull Class<T> genericType, @NotNull String jpqlQuery, int start, int amount) {
            return entityManager
                    .createQuery(jpqlQuery, genericType)
                    .setFirstResult(start)
                    .setMaxResults(amount)
                    .getResultList();
        }

        public <T> List<T> getAllBy(@NotNull CriteriaQuery<T> criteriaQuery) {
            return entityManager.createQuery(criteriaQuery).getResultList();
        }

        protected <T> CriteriaQuery<T> createSelectCriteriaQuery(@NotNull Class<T> genericType) {
            CriteriaBuilder qb = entityManager.getCriteriaBuilder();
            CriteriaQuery<T> cq = qb.createQuery(genericType);
            return cq;
        }

        public <T> T getOne(@NotNull Class<T> genericType) {
//        return entityManager.createQuery(this.FIND_ALL_HQL).getResultList();
            CriteriaQuery<T> selectCriteriaQuery = this.createSelectCriteriaQuery(genericType);
            return entityManager.createQuery(selectCriteriaQuery).getSingleResult();
        }

        public <T> T getOneByJPQL(@NotNull Class<T> genericType, @NotNull String jpqlQuery) {
            return entityManager.createQuery(jpqlQuery, genericType).getSingleResult();
        }

        public <T> T getOneBy(@NotNull CriteriaQuery<T> criteriaQuery) {
            return entityManager.createQuery(criteriaQuery).getSingleResult();
        }

        /**
         * Return the total the users stored in the database.
         */
        @SuppressWarnings("unchecked")
        public <T> long getCount(@NotNull Class<T> genericType) {
            CriteriaQuery<Long> cq = this.createCountCriteriaQuery(genericType);
            return this.getCountBy(cq);
        }

        public long getCountByJPQL(@NotNull String jpqlQuery) {
            TypedQuery<Long> query = entityManager.createQuery(jpqlQuery, Long.class);
            return query.getSingleResult();
        }

        public long getCountBy(@NotNull CriteriaQuery<Long> criteriaQuery) {
            long count = entityManager.createQuery(criteriaQuery).getSingleResult();
            return count;
        }

        public <T> CriteriaQuery<Long> createCountCriteriaQuery(@NotNull Class<T> genericType) {
            CriteriaBuilder qb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Long> cq = qb.createQuery(Long.class);
            cq.select(qb.count(cq.from(genericType)));
            return cq;
        }


        /**
         * Return the user having the passed id.
         */
        public <T> T getById(@NotNull Class<T> genericType, Object id) {
            return entityManager.find(genericType, id);
        }

        /**
         * Update the passed t in the database.
         */
        public <T> void update(T t) {
            entityManager.merge(t);
            return;
        }

        public <T> EntityType<T> getEntityType(@NotNull Class<T> genericType) {
            Metamodel m = this.entityManager.getMetamodel();
            EntityType<T> type = m.entity(genericType);
            return type;
        }

        // ------------------------
        // PRIVATE FIELDS
        // ------------------------

        // An EntityManager will be automatically injected from entityManagerFactory
        // setup on DatabaseConfig class.
        @PersistenceContext
        private EntityManager entityManager;

        public EntityManager getEntityManager() {
            return entityManager;
        }

        public <T> List<T> getAllByJPQLByIds(Class<T> genericType, List<?> ids) {
            if (ids.isEmpty()) {
                return this.getAll(genericType);
            } else {
                Class<?> idClass = this.getEntityIdClass(genericType);
                String idGroup = ids
                        .stream()
                        .map(id -> this.convertIdToSqlConstant(idClass, id))
                        .collect(Collectors.joining(",", "(", ")"));
                String jpqlQuery = this.buildJPQL4SelectAll(genericType) + " WHERE id in " + idGroup;
                return this.getAllByJPQL(genericType, jpqlQuery);
            }
        }

        private <T> String buildJPQL4SelectAll(Class<T> genericType) {
            return String.format(
                    "SELECT t FROM %s t",
                    genericType.getName()
            );
        }

        private <T> Class<?> getEntityIdClass(@NotNull Class<T> genericType) {
            if (genericType.isAnnotationPresent(IdClass.class)) {
                throw new UnsupportedOperationException("Don't support compound key entity.");
            } else {
                Field[] fieldList = genericType.getDeclaredFields();
                List<Field> idFields = Arrays
                        .stream(fieldList)
                        .filter(field -> field.isAnnotationPresent(Id.class))
                        .collect(Collectors.toList());
                if (idFields.isEmpty()) {
                    Method[] getMethodList = genericType.getDeclaredMethods();
                    List<Method> getIdMethods = Arrays
                            .stream(getMethodList)
                            .filter(method -> method.isAnnotationPresent(Id.class))
                            .collect(Collectors.toList());
                    if (getIdMethods.isEmpty()) {
                        throw new UnsupportedOperationException("Don't support non id entity.");
                    } else if (1 < getIdMethods.size()) {
                        throw new UnsupportedOperationException("Don't support compound key entity.");
                    } else {
                        return getIdMethods.get(0).getReturnType();
                    }
                } else if (1 < idFields.size()) {
                    throw new UnsupportedOperationException("Don't support compound key entity.");
                } else {
                    return idFields.get(0).getType();
                }
            }
        }

        private String convertIdToSqlConstant(@NotNull Class<?> idClass, @NotNull Object id) {
            if (Number.class.isAssignableFrom(idClass)) {
                return id.toString();
            } else {
                return "'" + id.toString() + "'";
            }
        }
    }

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
