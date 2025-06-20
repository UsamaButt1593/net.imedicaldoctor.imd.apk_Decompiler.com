package com.nineoldandroids.animation;

import android.util.Log;
import com.nineoldandroids.util.FloatProperty;
import com.nineoldandroids.util.IntProperty;
import com.nineoldandroids.util.Property;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PropertyValuesHolder implements Cloneable {
    private static final TypeEvaluator d3 = new IntEvaluator();
    private static final TypeEvaluator e3 = new FloatEvaluator();
    private static Class[] f3;
    private static Class[] g3;
    private static Class[] h3;
    private static final HashMap<Class, HashMap<String, Method>> i3 = new HashMap<>();
    private static final HashMap<Class, HashMap<String, Method>> j3 = new HashMap<>();
    protected Property X;
    Class X2;
    Method Y;
    KeyframeSet Y2;
    private Method Z;
    final ReentrantReadWriteLock Z2;
    final Object[] a3;
    private TypeEvaluator b3;
    private Object c3;
    String s;

    static class FloatPropertyValuesHolder extends PropertyValuesHolder {
        private FloatProperty k3;
        FloatKeyframeSet l3;
        float m3;

        public FloatPropertyValuesHolder(Property property, FloatKeyframeSet floatKeyframeSet) {
            super(property);
            this.X2 = Float.TYPE;
            this.Y2 = floatKeyframeSet;
            this.l3 = floatKeyframeSet;
            if (property instanceof FloatProperty) {
                this.k3 = (FloatProperty) this.X;
            }
        }

        /* access modifiers changed from: package-private */
        public void B(Class cls) {
            if (this.X == null) {
                PropertyValuesHolder.super.B(cls);
            }
        }

        /* renamed from: J */
        public FloatPropertyValuesHolder clone() {
            FloatPropertyValuesHolder floatPropertyValuesHolder = (FloatPropertyValuesHolder) PropertyValuesHolder.super.clone();
            floatPropertyValuesHolder.l3 = (FloatKeyframeSet) floatPropertyValuesHolder.Y2;
            return floatPropertyValuesHolder;
        }

        /* access modifiers changed from: package-private */
        public void a(float f2) {
            this.m3 = this.l3.i(f2);
        }

        /* access modifiers changed from: package-private */
        public Object c() {
            return Float.valueOf(this.m3);
        }

        /* access modifiers changed from: package-private */
        public void r(Object obj) {
            FloatProperty floatProperty = this.k3;
            if (floatProperty != null) {
                floatProperty.h(obj, this.m3);
                return;
            }
            Property property = this.X;
            if (property != null) {
                property.f(obj, Float.valueOf(this.m3));
            } else if (this.Y != null) {
                try {
                    this.a3[0] = Float.valueOf(this.m3);
                    this.Y.invoke(obj, this.a3);
                } catch (IllegalAccessException | InvocationTargetException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                }
            }
        }

        public void t(float... fArr) {
            PropertyValuesHolder.super.t(fArr);
            this.l3 = (FloatKeyframeSet) this.Y2;
        }

        public FloatPropertyValuesHolder(Property property, float... fArr) {
            super(property);
            t(fArr);
            if (property instanceof FloatProperty) {
                this.k3 = (FloatProperty) this.X;
            }
        }

        public FloatPropertyValuesHolder(String str, FloatKeyframeSet floatKeyframeSet) {
            super(str);
            this.X2 = Float.TYPE;
            this.Y2 = floatKeyframeSet;
            this.l3 = floatKeyframeSet;
        }

        public FloatPropertyValuesHolder(String str, float... fArr) {
            super(str);
            t(fArr);
        }
    }

    static class IntPropertyValuesHolder extends PropertyValuesHolder {
        private IntProperty k3;
        IntKeyframeSet l3;
        int m3;

        public IntPropertyValuesHolder(Property property, IntKeyframeSet intKeyframeSet) {
            super(property);
            this.X2 = Integer.TYPE;
            this.Y2 = intKeyframeSet;
            this.l3 = intKeyframeSet;
            if (property instanceof IntProperty) {
                this.k3 = (IntProperty) this.X;
            }
        }

        /* access modifiers changed from: package-private */
        public void B(Class cls) {
            if (this.X == null) {
                PropertyValuesHolder.super.B(cls);
            }
        }

        /* renamed from: J */
        public IntPropertyValuesHolder clone() {
            IntPropertyValuesHolder intPropertyValuesHolder = (IntPropertyValuesHolder) PropertyValuesHolder.super.clone();
            intPropertyValuesHolder.l3 = (IntKeyframeSet) intPropertyValuesHolder.Y2;
            return intPropertyValuesHolder;
        }

        /* access modifiers changed from: package-private */
        public void a(float f2) {
            this.m3 = this.l3.i(f2);
        }

        /* access modifiers changed from: package-private */
        public Object c() {
            return Integer.valueOf(this.m3);
        }

        /* access modifiers changed from: package-private */
        public void r(Object obj) {
            IntProperty intProperty = this.k3;
            if (intProperty != null) {
                intProperty.h(obj, this.m3);
                return;
            }
            Property property = this.X;
            if (property != null) {
                property.f(obj, Integer.valueOf(this.m3));
            } else if (this.Y != null) {
                try {
                    this.a3[0] = Integer.valueOf(this.m3);
                    this.Y.invoke(obj, this.a3);
                } catch (IllegalAccessException | InvocationTargetException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                }
            }
        }

        public void u(int... iArr) {
            PropertyValuesHolder.super.u(iArr);
            this.l3 = (IntKeyframeSet) this.Y2;
        }

        public IntPropertyValuesHolder(Property property, int... iArr) {
            super(property);
            u(iArr);
            if (property instanceof IntProperty) {
                this.k3 = (IntProperty) this.X;
            }
        }

        public IntPropertyValuesHolder(String str, IntKeyframeSet intKeyframeSet) {
            super(str);
            this.X2 = Integer.TYPE;
            this.Y2 = intKeyframeSet;
            this.l3 = intKeyframeSet;
        }

        public IntPropertyValuesHolder(String str, int... iArr) {
            super(str);
            u(iArr);
        }
    }

    static {
        Class cls = Float.TYPE;
        Class cls2 = Double.TYPE;
        Class cls3 = Integer.TYPE;
        Class<Float> cls4 = Float.class;
        Class<Double> cls5 = Double.class;
        Class<Integer> cls6 = Integer.class;
        f3 = new Class[]{cls, cls4, cls2, cls3, cls5, cls6};
        g3 = new Class[]{cls3, cls6, cls, cls2, cls4, cls5};
        h3 = new Class[]{cls2, cls5, cls, cls3, cls4, cls6};
    }

    private PropertyValuesHolder(Property property) {
        this.Y = null;
        this.Z = null;
        this.Y2 = null;
        this.Z2 = new ReentrantReadWriteLock();
        this.a3 = new Object[1];
        this.X = property;
        if (property != null) {
            this.s = property.b();
        }
    }

    private void A(Class cls) {
        this.Z = E(cls, j3, "get", (Class) null);
    }

    private Method E(Class cls, HashMap<Class, HashMap<String, Method>> hashMap, String str, Class cls2) {
        try {
            this.Z2.writeLock().lock();
            HashMap hashMap2 = hashMap.get(cls);
            Method method = hashMap2 != null ? (Method) hashMap2.get(this.s) : null;
            if (method == null) {
                method = e(cls, str, cls2);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap();
                    hashMap.put(cls, hashMap2);
                }
                hashMap2.put(this.s, method);
            }
            this.Z2.writeLock().unlock();
            return method;
        } catch (Throwable th) {
            this.Z2.writeLock().unlock();
            throw th;
        }
    }

    private void G(Object obj, Keyframe keyframe) {
        Property property = this.X;
        if (property != null) {
            keyframe.q(property.a(obj));
        }
        try {
            if (this.Z == null) {
                A(obj.getClass());
            }
            keyframe.q(this.Z.invoke(obj, (Object[]) null));
        } catch (InvocationTargetException e2) {
            e = e2;
            Log.e("PropertyValuesHolder", e.toString());
        } catch (IllegalAccessException e4) {
            e = e4;
            Log.e("PropertyValuesHolder", e.toString());
        }
    }

    static String d(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        char upperCase = Character.toUpperCase(str2.charAt(0));
        String substring = str2.substring(1);
        return str + upperCase + substring;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:21|22|23|25|26|34|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0072, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007d, code lost:
        r5 = r5 + 1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0073 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.reflect.Method e(java.lang.Class r9, java.lang.String r10, java.lang.Class r11) {
        /*
            r8 = this;
            r0 = 0
            java.lang.String r1 = r8.s
            java.lang.String r10 = d(r10, r1)
            java.lang.String r1 = "PropertyValuesHolder"
            r2 = 1
            r3 = 0
            if (r11 != 0) goto L_0x0035
            java.lang.reflect.Method r9 = r9.getMethod(r10, r3)     // Catch:{ NoSuchMethodException -> 0x0013 }
            goto L_0x00a0
        L_0x0013:
            r11 = move-exception
            java.lang.reflect.Method r3 = r9.getDeclaredMethod(r10, r3)     // Catch:{ NoSuchMethodException -> 0x001d }
            r3.setAccessible(r2)     // Catch:{ NoSuchMethodException -> 0x001d }
            goto L_0x009f
        L_0x001d:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Couldn't find no-arg method for property "
            r9.append(r10)
            java.lang.String r10 = r8.s
            r9.append(r10)
            java.lang.String r10 = ": "
            r9.append(r10)
            r9.append(r11)
            goto L_0x0098
        L_0x0035:
            java.lang.Class r11 = r8.X2
            java.lang.Class<java.lang.Float> r4 = java.lang.Float.class
            boolean r11 = r11.equals(r4)
            if (r11 == 0) goto L_0x0042
            java.lang.Class[] r11 = f3
            goto L_0x0062
        L_0x0042:
            java.lang.Class r11 = r8.X2
            java.lang.Class<java.lang.Integer> r4 = java.lang.Integer.class
            boolean r11 = r11.equals(r4)
            if (r11 == 0) goto L_0x004f
            java.lang.Class[] r11 = g3
            goto L_0x0062
        L_0x004f:
            java.lang.Class r11 = r8.X2
            java.lang.Class<java.lang.Double> r4 = java.lang.Double.class
            boolean r11 = r11.equals(r4)
            if (r11 == 0) goto L_0x005c
            java.lang.Class[] r11 = h3
            goto L_0x0062
        L_0x005c:
            java.lang.Class[] r11 = new java.lang.Class[r2]
            java.lang.Class r4 = r8.X2
            r11[r0] = r4
        L_0x0062:
            int r4 = r11.length
            r5 = 0
        L_0x0064:
            if (r5 >= r4) goto L_0x007f
            r6 = r11[r5]
            java.lang.Class[] r7 = new java.lang.Class[r2]
            r7[r0] = r6
            java.lang.reflect.Method r3 = r9.getMethod(r10, r7)     // Catch:{ NoSuchMethodException -> 0x0073 }
            r8.X2 = r6     // Catch:{ NoSuchMethodException -> 0x0073 }
            return r3
        L_0x0073:
            java.lang.reflect.Method r3 = r9.getDeclaredMethod(r10, r7)     // Catch:{ NoSuchMethodException -> 0x007d }
            r3.setAccessible(r2)     // Catch:{ NoSuchMethodException -> 0x007d }
            r8.X2 = r6     // Catch:{ NoSuchMethodException -> 0x007d }
            return r3
        L_0x007d:
            int r5 = r5 + r2
            goto L_0x0064
        L_0x007f:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Couldn't find setter/getter for property "
            r9.append(r10)
            java.lang.String r10 = r8.s
            r9.append(r10)
            java.lang.String r10 = " with value type "
            r9.append(r10)
            java.lang.Class r10 = r8.X2
            r9.append(r10)
        L_0x0098:
            java.lang.String r9 = r9.toString()
            android.util.Log.e(r1, r9)
        L_0x009f:
            r9 = r3
        L_0x00a0:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nineoldandroids.animation.PropertyValuesHolder.e(java.lang.Class, java.lang.String, java.lang.Class):java.lang.reflect.Method");
    }

    public static PropertyValuesHolder h(Property<?, Float> property, float... fArr) {
        return new FloatPropertyValuesHolder((Property) property, fArr);
    }

    public static PropertyValuesHolder i(String str, float... fArr) {
        return new FloatPropertyValuesHolder(str, fArr);
    }

    public static PropertyValuesHolder l(Property<?, Integer> property, int... iArr) {
        return new IntPropertyValuesHolder((Property) property, iArr);
    }

    public static PropertyValuesHolder m(String str, int... iArr) {
        return new IntPropertyValuesHolder(str, iArr);
    }

    public static PropertyValuesHolder n(Property property, Keyframe... keyframeArr) {
        KeyframeSet e2 = KeyframeSet.e(keyframeArr);
        if (e2 instanceof IntKeyframeSet) {
            return new IntPropertyValuesHolder(property, (IntKeyframeSet) e2);
        }
        if (e2 instanceof FloatKeyframeSet) {
            return new FloatPropertyValuesHolder(property, (FloatKeyframeSet) e2);
        }
        PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(property);
        propertyValuesHolder.Y2 = e2;
        propertyValuesHolder.X2 = keyframeArr[0].d();
        return propertyValuesHolder;
    }

    public static PropertyValuesHolder o(String str, Keyframe... keyframeArr) {
        KeyframeSet e2 = KeyframeSet.e(keyframeArr);
        if (e2 instanceof IntKeyframeSet) {
            return new IntPropertyValuesHolder(str, (IntKeyframeSet) e2);
        }
        if (e2 instanceof FloatKeyframeSet) {
            return new FloatPropertyValuesHolder(str, (FloatKeyframeSet) e2);
        }
        PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(str);
        propertyValuesHolder.Y2 = e2;
        propertyValuesHolder.X2 = keyframeArr[0].d();
        return propertyValuesHolder;
    }

    public static <V> PropertyValuesHolder p(Property property, TypeEvaluator<V> typeEvaluator, V... vArr) {
        PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(property);
        propertyValuesHolder.w(vArr);
        propertyValuesHolder.s(typeEvaluator);
        return propertyValuesHolder;
    }

    public static PropertyValuesHolder q(String str, TypeEvaluator typeEvaluator, Object... objArr) {
        PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(str);
        propertyValuesHolder.w(objArr);
        propertyValuesHolder.s(typeEvaluator);
        return propertyValuesHolder;
    }

    /* access modifiers changed from: package-private */
    public void B(Class cls) {
        this.Y = E(cls, i3, "set", this.X2);
    }

    /* access modifiers changed from: package-private */
    public void D(Object obj) {
        Property property = this.X;
        if (property != null) {
            try {
                property.a(obj);
                Iterator<Keyframe> it2 = this.Y2.f27885e.iterator();
                while (it2.hasNext()) {
                    Keyframe next = it2.next();
                    if (!next.f()) {
                        next.q(this.X.a(obj));
                    }
                }
                return;
            } catch (ClassCastException unused) {
                Log.e("PropertyValuesHolder", "No such property (" + this.X.b() + ") on target object " + obj + ". Trying reflection instead");
                this.X = null;
            }
        }
        Class<?> cls = obj.getClass();
        if (this.Y == null) {
            B(cls);
        }
        Iterator<Keyframe> it3 = this.Y2.f27885e.iterator();
        while (it3.hasNext()) {
            Keyframe next2 = it3.next();
            if (!next2.f()) {
                if (this.Z == null) {
                    A(cls);
                }
                try {
                    next2.q(this.Z.invoke(obj, (Object[]) null));
                } catch (IllegalAccessException | InvocationTargetException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void F(Object obj) {
        G(obj, this.Y2.f27885e.get(0));
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        this.c3 = this.Y2.b(f2);
    }

    /* renamed from: b */
    public PropertyValuesHolder clone() {
        try {
            PropertyValuesHolder propertyValuesHolder = (PropertyValuesHolder) super.clone();
            propertyValuesHolder.s = this.s;
            propertyValuesHolder.X = this.X;
            propertyValuesHolder.Y2 = this.Y2.clone();
            propertyValuesHolder.b3 = this.b3;
            return propertyValuesHolder;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public Object c() {
        return this.c3;
    }

    public String f() {
        return this.s;
    }

    /* access modifiers changed from: package-private */
    public void g() {
        if (this.b3 == null) {
            Class<Float> cls = this.X2;
            this.b3 = cls == Integer.class ? d3 : cls == Float.class ? e3 : null;
        }
        TypeEvaluator typeEvaluator = this.b3;
        if (typeEvaluator != null) {
            this.Y2.g(typeEvaluator);
        }
    }

    /* access modifiers changed from: package-private */
    public void r(Object obj) {
        Property property = this.X;
        if (property != null) {
            property.f(obj, c());
        }
        if (this.Y != null) {
            try {
                this.a3[0] = c();
                this.Y.invoke(obj, this.a3);
            } catch (IllegalAccessException | InvocationTargetException e2) {
                Log.e("PropertyValuesHolder", e2.toString());
            }
        }
    }

    public void s(TypeEvaluator typeEvaluator) {
        this.b3 = typeEvaluator;
        this.Y2.g(typeEvaluator);
    }

    public void t(float... fArr) {
        this.X2 = Float.TYPE;
        this.Y2 = KeyframeSet.c(fArr);
    }

    public String toString() {
        return this.s + ": " + this.Y2.toString();
    }

    public void u(int... iArr) {
        this.X2 = Integer.TYPE;
        this.Y2 = KeyframeSet.d(iArr);
    }

    public void v(Keyframe... keyframeArr) {
        int length = keyframeArr.length;
        Keyframe[] keyframeArr2 = new Keyframe[Math.max(length, 2)];
        this.X2 = keyframeArr[0].d();
        for (int i2 = 0; i2 < length; i2++) {
            keyframeArr2[i2] = keyframeArr[i2];
        }
        this.Y2 = new KeyframeSet(keyframeArr2);
    }

    public void w(Object... objArr) {
        this.X2 = objArr[0].getClass();
        this.Y2 = KeyframeSet.f(objArr);
    }

    public void x(Property property) {
        this.X = property;
    }

    public void y(String str) {
        this.s = str;
    }

    /* access modifiers changed from: package-private */
    public void z(Object obj) {
        ArrayList<Keyframe> arrayList = this.Y2.f27885e;
        G(obj, arrayList.get(arrayList.size() - 1));
    }

    private PropertyValuesHolder(String str) {
        this.Y = null;
        this.Z = null;
        this.Y2 = null;
        this.Z2 = new ReentrantReadWriteLock();
        this.a3 = new Object[1];
        this.s = str;
    }
}
