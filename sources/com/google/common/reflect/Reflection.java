package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@ElementTypesAreNonnullByDefault
public final class Reflection {
    private Reflection() {
    }

    public static String a(Class<?> cls) {
        return b(cls.getName());
    }

    public static String b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf < 0 ? "" : str.substring(0, lastIndexOf);
    }

    public static void c(Class<?>... clsArr) {
        int length = clsArr.length;
        int i2 = 0;
        while (i2 < length) {
            Class<?> cls = clsArr[i2];
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                i2++;
            } catch (ClassNotFoundException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public static <T> T d(Class<T> cls, InvocationHandler invocationHandler) {
        Preconditions.E(invocationHandler);
        Preconditions.u(cls.isInterface(), "%s is not an interface", cls);
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler));
    }
}
