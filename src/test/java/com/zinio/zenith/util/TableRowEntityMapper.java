package com.zinio.zenith.util;

import javassist.CannotCompileException;
import javassist.NotFoundException;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ducnguyen on 9/17/16.
 */
public class TableRowEntityMapper {
    public static Class createProxyClass(Class baseClass) throws NotFoundException, CannotCompileException {
        ProxyFactory factory = new ProxyFactory();
        factory.setInterfaces(new Class[]{UpdatedPropertyInterface.class});
        factory.setSuperclass(baseClass);
        factory.setHandler(new MethodHandler() {
            private Set<String> changes = new HashSet<>();

            public Object invoke(Object arg0, Method method, Method arg2, Object[] arg3) throws Throwable {
                String name = method.getName();
                if ("getChangedProperties".equals(name)) {
                    return changes;
                } else if (name.startsWith("set")) {
                    changes.add(name.replaceAll("^set", "get"));
                    return arg2.invoke(arg0, arg3);
                } else {
                    return arg2.invoke(arg0, arg3);
                }
            }
        });
        return factory.createClass();
    }

}
