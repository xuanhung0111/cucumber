package com.zinio.zenith.util;

import com.zinio.zenith.converter.*;
import cucumber.deps.com.thoughtworks.xstream.converters.*;
import cucumber.deps.com.thoughtworks.xstream.io.HierarchicalStreamReader;
import cucumber.deps.com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import cucumber.deps.com.thoughtworks.xstream.mapper.Mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ducnguyen on 9/18/16.
 */
public class EntityConverter implements ConverterMatcher, Converter {
    private final Mapper mapper;
    private static final Map<Class, Converter> NULLABLE_CONVERTER_MAP = new HashMap<Class, Converter>() {{
        put(Integer.class, new SingleValueConverterWrapper(new NullableIntConverter()));
        put(String.class, new SingleValueConverterWrapper(new NullableStringConverter()));
        put(Timestamp.class, new SingleValueConverterWrapper(new NullableSqlTimestampConverter()));
        put(Date.class, new SingleValueConverterWrapper(new NullableSqlDateConverter()));
        put(Short.class, new SingleValueConverterWrapper(new NullableShortCoverter()));
        put(Long.class, new SingleValueConverterWrapper(new NullableLongConverter()));
        put(Double.class, new SingleValueConverterWrapper(new NullableDoubleConverter()));
    }};

    public EntityConverter(Mapper mapper) {
        this.mapper = mapper;
//        ((AnnotationMapper) this.mapper).autodetectAnnotations(true);
    }

    public Mapper mapper() {
        return mapper;
    }

    @Override
    public boolean canConvert(Class aClass) {
        return UpdatedPropertyInterface.class.isAssignableFrom(aClass);
    }

    @Override
    public void marshal(Object o, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        try {
            Object o = unmarshallingContext.getRequiredType().newInstance();
            Class baseClass = o.getClass().getSuperclass();
            setField(hierarchicalStreamReader, unmarshallingContext, o, baseClass);
            return o;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    private Converter getConverter(HierarchicalStreamReader reader, Class baseClass, Class type) {
        Converter converter = this.mapper.getLocalConverter(baseClass, reader.getNodeName());
        if (null == converter && NULLABLE_CONVERTER_MAP.containsKey(type)) {
            converter = NULLABLE_CONVERTER_MAP.get(type);
        }
        return converter;
    }

    private Object readItem(HierarchicalStreamReader reader, UnmarshallingContext context, Object current, Class baseClass, Class type) {
        Converter converter = this.getConverter(reader, baseClass, type);
        return context.convertAnother(current, type, converter);
    }

    private Object setField(HierarchicalStreamReader hierarchicalStreamReader,
                            UnmarshallingContext unmarshallingContext,
                            Object o,
                            Class baseClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        while (hierarchicalStreamReader.hasMoreChildren()) {
            hierarchicalStreamReader.moveDown();
            String fieldName = hierarchicalStreamReader.getNodeName();
            fieldName = PropertyConverter.convertFieldToProperty(fieldName);
            Class fieldType = getFieldType(baseClass, fieldName);
            Object fieldValue = readItem(hierarchicalStreamReader, unmarshallingContext, o, baseClass, fieldType);
            setFieldValue(o, baseClass, fieldName, fieldValue, fieldType);
            hierarchicalStreamReader.moveUp();
        }
        return o;
    }

    private Class getFieldType(Class baseClass, String fieldName) throws NoSuchFieldException {
        Field field = baseClass.getDeclaredField(fieldName);
        Class<?> type = field.getType();
        return type;
    }

    private Object setFieldValue(Object o, Class baseClass, String fieldName, Object fieldValue, Class fieldType) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method setMethod = baseClass.getDeclaredMethod("set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1), fieldType);
        setMethod.invoke(o, fieldValue);
        return o;
    }
}
