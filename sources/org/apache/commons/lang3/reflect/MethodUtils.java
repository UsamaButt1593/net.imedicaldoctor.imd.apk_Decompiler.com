package org.apache.commons.lang3.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.Validate;

public class MethodUtils {
    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return getAccessibleMethod(cls.getMethod(str, clsArr));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static Method getAccessibleMethodFromInterfaceNest(Class<?> cls, String str, Class<?>... clsArr) {
        Class<? super Object> cls2;
        while (cls2 != null) {
            Class[] interfaces = cls2.getInterfaces();
            for (int i2 = 0; i2 < interfaces.length; i2++) {
                if (Modifier.isPublic(interfaces[i2].getModifiers())) {
                    try {
                        return interfaces[i2].getDeclaredMethod(str, clsArr);
                    } catch (NoSuchMethodException unused) {
                        Method accessibleMethodFromInterfaceNest = getAccessibleMethodFromInterfaceNest(interfaces[i2], str, clsArr);
                        if (accessibleMethodFromInterfaceNest != null) {
                            return accessibleMethodFromInterfaceNest;
                        }
                    }
                }
            }
            Class<? super Object> superclass = cls2.getSuperclass();
            cls2 = cls;
            cls2 = superclass;
        }
        return null;
    }

    private static Method getAccessibleMethodFromSuperclass(Class<?> cls, String str, Class<?>... clsArr) {
        Class<? super Object> superclass;
        boolean isPublic;
        do {
            superclass = r2.getSuperclass();
            Class<? super Object> cls2 = cls;
            if (superclass == null) {
                return null;
            }
            isPublic = Modifier.isPublic(superclass.getModifiers());
            cls2 = superclass;
        } while (!isPublic);
        try {
            return superclass.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
        }
    }

    public static Method getMatchingAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Method accessibleMethod;
        try {
            Method method = cls.getMethod(str, clsArr);
            MemberUtils.setAccessibleWorkaround(method);
            return method;
        } catch (NoSuchMethodException unused) {
            Method method2 = null;
            for (Method method3 : cls.getMethods()) {
                if (method3.getName().equals(str) && ClassUtils.isAssignable(clsArr, (Class<?>[]) method3.getParameterTypes(), true) && (accessibleMethod = getAccessibleMethod(method3)) != null && (method2 == null || MemberUtils.compareParameterTypes(accessibleMethod.getParameterTypes(), method2.getParameterTypes(), clsArr) < 0)) {
                    method2 = accessibleMethod;
                }
            }
            if (method2 != null) {
                MemberUtils.setAccessibleWorkaround(method2);
            }
            return method2;
        }
    }

    public static Set<Method> getOverrideHierarchy(Method method, ClassUtils.Interfaces interfaces) {
        Validate.notNull(method);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(method);
        Class[] parameterTypes = method.getParameterTypes();
        Class<?> declaringClass = method.getDeclaringClass();
        Iterator<Class<?>> it2 = ClassUtils.hierarchy(declaringClass, interfaces).iterator();
        it2.next();
        while (it2.hasNext()) {
            Method matchingAccessibleMethod = getMatchingAccessibleMethod(it2.next(), method.getName(), parameterTypes);
            if (matchingAccessibleMethod != null) {
                if (!Arrays.equals(matchingAccessibleMethod.getParameterTypes(), parameterTypes)) {
                    Map<TypeVariable<?>, Type> typeArguments = TypeUtils.getTypeArguments(declaringClass, matchingAccessibleMethod.getDeclaringClass());
                    int i2 = 0;
                    while (true) {
                        if (i2 >= parameterTypes.length) {
                            break;
                        } else if (!TypeUtils.equals(TypeUtils.unrollVariables(typeArguments, method.getGenericParameterTypes()[i2]), TypeUtils.unrollVariables(typeArguments, matchingAccessibleMethod.getGenericParameterTypes()[i2]))) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                linkedHashSet.add(matchingAccessibleMethod);
            }
        }
        return linkedHashSet;
    }

    public static Object invokeExactMethod(Object obj, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeExactMethod(obj, str, nullToEmpty, ClassUtils.toClass(nullToEmpty));
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeExactStaticMethod(cls, str, nullToEmpty, ClassUtils.toClass(nullToEmpty));
    }

    public static Object invokeMethod(Object obj, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeMethod(obj, str, nullToEmpty, ClassUtils.toClass(nullToEmpty));
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return invokeStaticMethod(cls, str, nullToEmpty, ClassUtils.toClass(nullToEmpty));
    }

    public static Method getAccessibleMethod(Method method) {
        if (!MemberUtils.isAccessible(method)) {
            return null;
        }
        Class<?> declaringClass = method.getDeclaringClass();
        if (Modifier.isPublic(declaringClass.getModifiers())) {
            return method;
        }
        String name = method.getName();
        Class[] parameterTypes = method.getParameterTypes();
        Method accessibleMethodFromInterfaceNest = getAccessibleMethodFromInterfaceNest(declaringClass, name, parameterTypes);
        return accessibleMethodFromInterfaceNest == null ? getAccessibleMethodFromSuperclass(declaringClass, name, parameterTypes) : accessibleMethodFromInterfaceNest;
    }

    public static Object invokeExactMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        Method accessibleMethod = getAccessibleMethod(obj.getClass(), str, ArrayUtils.nullToEmpty(clsArr));
        if (accessibleMethod != null) {
            return accessibleMethod.invoke(obj, nullToEmpty);
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + obj.getClass().getName());
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        Method accessibleMethod = getAccessibleMethod(cls, str, ArrayUtils.nullToEmpty(clsArr));
        if (accessibleMethod != null) {
            return accessibleMethod.invoke((Object) null, nullToEmpty);
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on class: " + cls.getName());
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class[] nullToEmpty = ArrayUtils.nullToEmpty(clsArr);
        Object[] nullToEmpty2 = ArrayUtils.nullToEmpty(objArr);
        Method matchingAccessibleMethod = getMatchingAccessibleMethod(obj.getClass(), str, nullToEmpty);
        if (matchingAccessibleMethod != null) {
            return matchingAccessibleMethod.invoke(obj, nullToEmpty2);
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + obj.getClass().getName());
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        Method matchingAccessibleMethod = getMatchingAccessibleMethod(cls, str, ArrayUtils.nullToEmpty(clsArr));
        if (matchingAccessibleMethod != null) {
            return matchingAccessibleMethod.invoke((Object) null, nullToEmpty);
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on class: " + cls.getName());
    }
}
