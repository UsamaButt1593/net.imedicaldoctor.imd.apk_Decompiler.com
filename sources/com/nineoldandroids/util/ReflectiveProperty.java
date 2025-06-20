package com.nineoldandroids.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ReflectiveProperty<T, V> extends Property<T, V> {

    /* renamed from: f  reason: collision with root package name */
    private static final String f27903f = "get";

    /* renamed from: g  reason: collision with root package name */
    private static final String f27904g = "is";

    /* renamed from: h  reason: collision with root package name */
    private static final String f27905h = "set";

    /* renamed from: c  reason: collision with root package name */
    private Method f27906c;

    /* renamed from: d  reason: collision with root package name */
    private Method f27907d;

    /* renamed from: e  reason: collision with root package name */
    private Field f27908e;

    /* JADX WARNING: Can't wrap try/catch for region: R(3:19|20|(1:22)(2:23|24)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:6|5|7|8|9|10) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r11 = r11.getField(r13);
        r10.f27908e = r11;
        r11 = r11.getType();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00c6, code lost:
        if (g(r12, r11) != false) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00c8, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00e9, code lost:
        throw new com.nineoldandroids.util.NoSuchPropertyException("Underlying type (" + r11 + ") " + "does not match Property type (" + r12 + ")");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x00b8 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0041 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0063 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ReflectiveProperty(java.lang.Class<T> r11, java.lang.Class<V> r12, java.lang.String r13) {
        /*
            r10 = this;
            java.lang.String r0 = ")"
            java.lang.String r1 = "does not match Property type ("
            java.lang.String r2 = ") "
            java.lang.String r3 = "Underlying type ("
            r10.<init>(r12, r13)
            r4 = 0
            char r5 = r13.charAt(r4)
            char r5 = java.lang.Character.toUpperCase(r5)
            r6 = 1
            java.lang.String r7 = r13.substring(r6)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r5)
            r8.append(r7)
            java.lang.String r5 = r8.toString()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "get"
            r7.append(r8)
            r7.append(r5)
            java.lang.String r7 = r7.toString()
            r8 = 0
            java.lang.reflect.Method r9 = r11.getMethod(r7, r8)     // Catch:{ NoSuchMethodException -> 0x0041 }
            r10.f27907d = r9     // Catch:{ NoSuchMethodException -> 0x0041 }
            goto L_0x006c
        L_0x0041:
            java.lang.reflect.Method r7 = r11.getDeclaredMethod(r7, r8)     // Catch:{ NoSuchMethodException -> 0x004b }
            r10.f27907d = r7     // Catch:{ NoSuchMethodException -> 0x004b }
            r7.setAccessible(r6)     // Catch:{ NoSuchMethodException -> 0x004b }
            goto L_0x006c
        L_0x004b:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = "is"
            r7.append(r9)
            r7.append(r5)
            java.lang.String r7 = r7.toString()
            java.lang.reflect.Method r9 = r11.getMethod(r7, r8)     // Catch:{ NoSuchMethodException -> 0x0063 }
            r10.f27907d = r9     // Catch:{ NoSuchMethodException -> 0x0063 }
            goto L_0x006c
        L_0x0063:
            java.lang.reflect.Method r7 = r11.getDeclaredMethod(r7, r8)     // Catch:{ NoSuchMethodException -> 0x00b8 }
            r10.f27907d = r7     // Catch:{ NoSuchMethodException -> 0x00b8 }
            r7.setAccessible(r6)     // Catch:{ NoSuchMethodException -> 0x00b8 }
        L_0x006c:
            java.lang.reflect.Method r13 = r10.f27907d
            java.lang.Class r13 = r13.getReturnType()
            boolean r7 = r10.g(r12, r13)
            if (r7 == 0) goto L_0x0097
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "set"
            r12.append(r0)
            r12.append(r5)
            java.lang.String r12 = r12.toString()
            java.lang.Class[] r0 = new java.lang.Class[r6]     // Catch:{ NoSuchMethodException -> 0x0096 }
            r0[r4] = r13     // Catch:{ NoSuchMethodException -> 0x0096 }
            java.lang.reflect.Method r11 = r11.getDeclaredMethod(r12, r0)     // Catch:{ NoSuchMethodException -> 0x0096 }
            r10.f27906c = r11     // Catch:{ NoSuchMethodException -> 0x0096 }
            r11.setAccessible(r6)     // Catch:{ NoSuchMethodException -> 0x0096 }
        L_0x0096:
            return
        L_0x0097:
            com.nineoldandroids.util.NoSuchPropertyException r11 = new com.nineoldandroids.util.NoSuchPropertyException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            r4.append(r13)
            r4.append(r2)
            r4.append(r1)
            r4.append(r12)
            r4.append(r0)
            java.lang.String r12 = r4.toString()
            r11.<init>(r12)
            throw r11
        L_0x00b8:
            java.lang.reflect.Field r11 = r11.getField(r13)     // Catch:{ NoSuchFieldException -> 0x00ea }
            r10.f27908e = r11     // Catch:{ NoSuchFieldException -> 0x00ea }
            java.lang.Class r11 = r11.getType()     // Catch:{ NoSuchFieldException -> 0x00ea }
            boolean r4 = r10.g(r12, r11)     // Catch:{ NoSuchFieldException -> 0x00ea }
            if (r4 == 0) goto L_0x00c9
            return
        L_0x00c9:
            com.nineoldandroids.util.NoSuchPropertyException r4 = new com.nineoldandroids.util.NoSuchPropertyException     // Catch:{ NoSuchFieldException -> 0x00ea }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ NoSuchFieldException -> 0x00ea }
            r5.<init>()     // Catch:{ NoSuchFieldException -> 0x00ea }
            r5.append(r3)     // Catch:{ NoSuchFieldException -> 0x00ea }
            r5.append(r11)     // Catch:{ NoSuchFieldException -> 0x00ea }
            r5.append(r2)     // Catch:{ NoSuchFieldException -> 0x00ea }
            r5.append(r1)     // Catch:{ NoSuchFieldException -> 0x00ea }
            r5.append(r12)     // Catch:{ NoSuchFieldException -> 0x00ea }
            r5.append(r0)     // Catch:{ NoSuchFieldException -> 0x00ea }
            java.lang.String r11 = r5.toString()     // Catch:{ NoSuchFieldException -> 0x00ea }
            r4.<init>(r11)     // Catch:{ NoSuchFieldException -> 0x00ea }
            throw r4     // Catch:{ NoSuchFieldException -> 0x00ea }
        L_0x00ea:
            com.nineoldandroids.util.NoSuchPropertyException r11 = new com.nineoldandroids.util.NoSuchPropertyException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "No accessor method or field found for property with name "
            r12.append(r0)
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nineoldandroids.util.ReflectiveProperty.<init>(java.lang.Class, java.lang.Class, java.lang.String):void");
    }

    private boolean g(Class<V> cls, Class cls2) {
        if (cls2 == cls) {
            return true;
        }
        if (!cls2.isPrimitive()) {
            return false;
        }
        if (cls2 == Float.TYPE && cls == Float.class) {
            return true;
        }
        if (cls2 == Integer.TYPE && cls == Integer.class) {
            return true;
        }
        if (cls2 == Boolean.TYPE && cls == Boolean.class) {
            return true;
        }
        if (cls2 == Long.TYPE && cls == Long.class) {
            return true;
        }
        if (cls2 == Double.TYPE && cls == Double.class) {
            return true;
        }
        if (cls2 == Short.TYPE && cls == Short.class) {
            return true;
        }
        if (cls2 == Byte.TYPE && cls == Byte.class) {
            return true;
        }
        return cls2 == Character.TYPE && cls == Character.class;
    }

    public V a(T t) {
        Method method = this.f27907d;
        if (method != null) {
            try {
                return method.invoke(t, (Object[]) null);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        } else {
            Field field = this.f27908e;
            if (field != null) {
                try {
                    return field.get(t);
                } catch (IllegalAccessException unused2) {
                    throw new AssertionError();
                }
            } else {
                throw new AssertionError();
            }
        }
    }

    public boolean d() {
        return this.f27906c == null && this.f27908e == null;
    }

    public void f(T t, V v) {
        Method method = this.f27906c;
        if (method != null) {
            try {
                method.invoke(t, new Object[]{v});
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        } else {
            Field field = this.f27908e;
            if (field != null) {
                try {
                    field.set(t, v);
                } catch (IllegalAccessException unused2) {
                    throw new AssertionError();
                }
            } else {
                throw new UnsupportedOperationException("Property " + b() + " is read-only");
            }
        }
    }
}
