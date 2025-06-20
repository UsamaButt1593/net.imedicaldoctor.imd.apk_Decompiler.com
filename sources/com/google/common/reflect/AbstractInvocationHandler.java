package com.google.common.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class AbstractInvocationHandler implements InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    private static final Object[] f22978a = new Object[0];

    private static boolean b(Object obj, Class<?> cls) {
        return cls.isInstance(obj) || (Proxy.isProxyClass(obj.getClass()) && Arrays.equals(obj.getClass().getInterfaces(), cls.getInterfaces()));
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public abstract Object a(Object obj, Method method, Object[] objArr) throws Throwable;

    public boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    @CheckForNull
    public final Object invoke(Object obj, Method method, @CheckForNull Object[] objArr) throws Throwable {
        if (objArr == null) {
            objArr = f22978a;
        }
        if (objArr.length == 0 && method.getName().equals("hashCode")) {
            return Integer.valueOf(hashCode());
        }
        boolean z = true;
        if (objArr.length != 1 || !method.getName().equals("equals") || method.getParameterTypes()[0] != Object.class) {
            return (objArr.length != 0 || !method.getName().equals("toString")) ? a(obj, method, objArr) : toString();
        }
        Object obj2 = objArr[0];
        if (obj2 == null) {
            return Boolean.FALSE;
        }
        if (obj == obj2) {
            return Boolean.TRUE;
        }
        if (!b(obj2, obj.getClass()) || !equals(Proxy.getInvocationHandler(obj2))) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public String toString() {
        return super.toString();
    }
}
