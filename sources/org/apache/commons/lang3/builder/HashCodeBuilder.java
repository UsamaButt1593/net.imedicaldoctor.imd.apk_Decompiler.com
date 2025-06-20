package org.apache.commons.lang3.builder;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class HashCodeBuilder implements Builder<Integer> {
    private static final ThreadLocal<Set<IDKey>> REGISTRY = new ThreadLocal<>();
    private final int iConstant;
    private int iTotal;

    public HashCodeBuilder() {
        this.iConstant = 37;
        this.iTotal = 17;
    }

    static Set<IDKey> getRegistry() {
        return REGISTRY.get();
    }

    static boolean isRegistered(Object obj) {
        Set<IDKey> registry = getRegistry();
        return registry != null && registry.contains(new IDKey(obj));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:18|19|20|21|22) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0050 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void reflectionAppend(java.lang.Object r5, java.lang.Class<?> r6, org.apache.commons.lang3.builder.HashCodeBuilder r7, boolean r8, java.lang.String[] r9) {
        /*
            boolean r0 = isRegistered(r5)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            register(r5)     // Catch:{ all -> 0x003c }
            java.lang.reflect.Field[] r6 = r6.getDeclaredFields()     // Catch:{ all -> 0x003c }
            r0 = 1
            java.lang.reflect.AccessibleObject.setAccessible(r6, r0)     // Catch:{ all -> 0x003c }
            int r0 = r6.length     // Catch:{ all -> 0x003c }
            r1 = 0
        L_0x0014:
            if (r1 >= r0) goto L_0x005b
            r2 = r6[r1]     // Catch:{ all -> 0x003c }
            java.lang.String r3 = r2.getName()     // Catch:{ all -> 0x003c }
            boolean r3 = org.apache.commons.lang3.ArrayUtils.contains((java.lang.Object[]) r9, (java.lang.Object) r3)     // Catch:{ all -> 0x003c }
            if (r3 != 0) goto L_0x0058
            java.lang.String r3 = r2.getName()     // Catch:{ all -> 0x003c }
            r4 = 36
            int r3 = r3.indexOf(r4)     // Catch:{ all -> 0x003c }
            r4 = -1
            if (r3 != r4) goto L_0x0058
            if (r8 != 0) goto L_0x003e
            int r3 = r2.getModifiers()     // Catch:{ all -> 0x003c }
            boolean r3 = java.lang.reflect.Modifier.isTransient(r3)     // Catch:{ all -> 0x003c }
            if (r3 != 0) goto L_0x0058
            goto L_0x003e
        L_0x003c:
            r6 = move-exception
            goto L_0x005f
        L_0x003e:
            int r3 = r2.getModifiers()     // Catch:{ all -> 0x003c }
            boolean r3 = java.lang.reflect.Modifier.isStatic(r3)     // Catch:{ all -> 0x003c }
            if (r3 != 0) goto L_0x0058
            java.lang.Object r2 = r2.get(r5)     // Catch:{ IllegalAccessException -> 0x0050 }
            r7.append((java.lang.Object) r2)     // Catch:{ IllegalAccessException -> 0x0050 }
            goto L_0x0058
        L_0x0050:
            java.lang.InternalError r6 = new java.lang.InternalError     // Catch:{ all -> 0x003c }
            java.lang.String r7 = "Unexpected IllegalAccessException"
            r6.<init>(r7)     // Catch:{ all -> 0x003c }
            throw r6     // Catch:{ all -> 0x003c }
        L_0x0058:
            int r1 = r1 + 1
            goto L_0x0014
        L_0x005b:
            unregister(r5)
            return
        L_0x005f:
            unregister(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.builder.HashCodeBuilder.reflectionAppend(java.lang.Object, java.lang.Class, org.apache.commons.lang3.builder.HashCodeBuilder, boolean, java.lang.String[]):void");
    }

    public static int reflectionHashCode(int i2, int i3, Object obj) {
        return reflectionHashCode(i2, i3, obj, false, (Class) null, new String[0]);
    }

    static void register(Object obj) {
        synchronized (HashCodeBuilder.class) {
            try {
                if (getRegistry() == null) {
                    REGISTRY.set(new HashSet());
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        getRegistry().add(new IDKey(obj));
    }

    static void unregister(Object obj) {
        Set<IDKey> registry = getRegistry();
        if (registry != null) {
            registry.remove(new IDKey(obj));
            synchronized (HashCodeBuilder.class) {
                try {
                    Set<IDKey> registry2 = getRegistry();
                    if (registry2 != null && registry2.isEmpty()) {
                        REGISTRY.remove();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public HashCodeBuilder append(byte b2) {
        this.iTotal = (this.iTotal * this.iConstant) + b2;
        return this;
    }

    public HashCodeBuilder appendSuper(int i2) {
        this.iTotal = (this.iTotal * this.iConstant) + i2;
        return this;
    }

    public Integer build() {
        return Integer.valueOf(toHashCode());
    }

    public int hashCode() {
        return toHashCode();
    }

    public int toHashCode() {
        return this.iTotal;
    }

    public HashCodeBuilder(int i2, int i3) {
        this.iTotal = 0;
        if (i2 % 2 == 0) {
            throw new IllegalArgumentException("HashCodeBuilder requires an odd initial value");
        } else if (i3 % 2 != 0) {
            this.iConstant = i3;
            this.iTotal = i2;
        } else {
            throw new IllegalArgumentException("HashCodeBuilder requires an odd multiplier");
        }
    }

    public static int reflectionHashCode(int i2, int i3, Object obj, boolean z) {
        return reflectionHashCode(i2, i3, obj, z, (Class) null, new String[0]);
    }

    public HashCodeBuilder append(char c2) {
        this.iTotal = (this.iTotal * this.iConstant) + c2;
        return this;
    }

    public static <T> int reflectionHashCode(int i2, int i3, T t, boolean z, Class<? super T> cls, String... strArr) {
        if (t != null) {
            HashCodeBuilder hashCodeBuilder = new HashCodeBuilder(i2, i3);
            Class cls2 = t.getClass();
            while (true) {
                reflectionAppend(t, cls2, hashCodeBuilder, z, strArr);
                if (cls2.getSuperclass() != null && cls2 != cls) {
                    cls2 = cls2.getSuperclass();
                }
            }
            return hashCodeBuilder.toHashCode();
        }
        throw new IllegalArgumentException("The object to build a hash code for must not be null");
    }

    public HashCodeBuilder append(double d2) {
        return append(Double.doubleToLongBits(d2));
    }

    public static int reflectionHashCode(Object obj, Collection<String> collection) {
        return reflectionHashCode(obj, ReflectionToStringBuilder.toNoNullStringArray(collection));
    }

    public HashCodeBuilder append(float f2) {
        this.iTotal = (this.iTotal * this.iConstant) + Float.floatToIntBits(f2);
        return this;
    }

    public static int reflectionHashCode(Object obj, boolean z) {
        return reflectionHashCode(17, 37, obj, z, (Class) null, new String[0]);
    }

    public HashCodeBuilder append(int i2) {
        this.iTotal = (this.iTotal * this.iConstant) + i2;
        return this;
    }

    public static int reflectionHashCode(Object obj, String... strArr) {
        return reflectionHashCode(17, 37, obj, false, (Class) null, strArr);
    }

    public HashCodeBuilder append(long j2) {
        this.iTotal = (this.iTotal * this.iConstant) + ((int) (j2 ^ (j2 >> 32)));
        return this;
    }

    public HashCodeBuilder append(Object obj) {
        if (obj == null) {
            this.iTotal *= this.iConstant;
        } else if (!obj.getClass().isArray()) {
            this.iTotal = (this.iTotal * this.iConstant) + obj.hashCode();
        } else if (obj instanceof long[]) {
            append((long[]) obj);
        } else if (obj instanceof int[]) {
            append((int[]) obj);
        } else if (obj instanceof short[]) {
            append((short[]) obj);
        } else if (obj instanceof char[]) {
            append((char[]) obj);
        } else if (obj instanceof byte[]) {
            append((byte[]) obj);
        } else if (obj instanceof double[]) {
            append((double[]) obj);
        } else if (obj instanceof float[]) {
            append((float[]) obj);
        } else if (obj instanceof boolean[]) {
            append((boolean[]) obj);
        } else {
            append((Object[]) obj);
        }
        return this;
    }

    public HashCodeBuilder append(short s) {
        this.iTotal = (this.iTotal * this.iConstant) + s;
        return this;
    }

    public HashCodeBuilder append(boolean z) {
        this.iTotal = (this.iTotal * this.iConstant) + (z ^ true ? 1 : 0);
        return this;
    }

    public HashCodeBuilder append(byte[] bArr) {
        if (bArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (byte append : bArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(char[] cArr) {
        if (cArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (char append : cArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(double[] dArr) {
        if (dArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (double append : dArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(float[] fArr) {
        if (fArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (float append : fArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(int[] iArr) {
        if (iArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (int append : iArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(long[] jArr) {
        if (jArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (long append : jArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(Object[] objArr) {
        if (objArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (Object append : objArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(short[] sArr) {
        if (sArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (short append : sArr) {
                append(append);
            }
        }
        return this;
    }

    public HashCodeBuilder append(boolean[] zArr) {
        if (zArr == null) {
            this.iTotal *= this.iConstant;
        } else {
            for (boolean append : zArr) {
                append(append);
            }
        }
        return this;
    }
}
