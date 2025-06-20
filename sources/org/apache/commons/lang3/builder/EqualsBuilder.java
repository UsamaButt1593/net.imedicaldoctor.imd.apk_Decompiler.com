package org.apache.commons.lang3.builder;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.tuple.Pair;

public class EqualsBuilder implements Builder<Boolean> {
    private static final ThreadLocal<Set<Pair<IDKey, IDKey>>> REGISTRY = new ThreadLocal<>();
    private boolean isEquals = true;

    static Pair<IDKey, IDKey> getRegisterPair(Object obj, Object obj2) {
        return Pair.of(new IDKey(obj), new IDKey(obj2));
    }

    static Set<Pair<IDKey, IDKey>> getRegistry() {
        return REGISTRY.get();
    }

    static boolean isRegistered(Object obj, Object obj2) {
        Set<Pair<IDKey, IDKey>> registry = getRegistry();
        Pair<IDKey, IDKey> registerPair = getRegisterPair(obj, obj2);
        return registry != null && (registry.contains(registerPair) || registry.contains(Pair.of(registerPair.getLeft(), registerPair.getRight())));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:21|22|23|24|25) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void reflectionAppend(java.lang.Object r4, java.lang.Object r5, java.lang.Class<?> r6, org.apache.commons.lang3.builder.EqualsBuilder r7, boolean r8, java.lang.String[] r9) {
        /*
            boolean r0 = isRegistered(r4, r5)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            register(r4, r5)     // Catch:{ all -> 0x0040 }
            java.lang.reflect.Field[] r6 = r6.getDeclaredFields()     // Catch:{ all -> 0x0040 }
            r0 = 1
            java.lang.reflect.AccessibleObject.setAccessible(r6, r0)     // Catch:{ all -> 0x0040 }
            r0 = 0
        L_0x0013:
            int r1 = r6.length     // Catch:{ all -> 0x0040 }
            if (r0 >= r1) goto L_0x0063
            boolean r1 = r7.isEquals     // Catch:{ all -> 0x0040 }
            if (r1 == 0) goto L_0x0063
            r1 = r6[r0]     // Catch:{ all -> 0x0040 }
            java.lang.String r2 = r1.getName()     // Catch:{ all -> 0x0040 }
            boolean r2 = org.apache.commons.lang3.ArrayUtils.contains((java.lang.Object[]) r9, (java.lang.Object) r2)     // Catch:{ all -> 0x0040 }
            if (r2 != 0) goto L_0x0060
            java.lang.String r2 = r1.getName()     // Catch:{ all -> 0x0040 }
            r3 = 36
            int r2 = r2.indexOf(r3)     // Catch:{ all -> 0x0040 }
            r3 = -1
            if (r2 != r3) goto L_0x0060
            if (r8 != 0) goto L_0x0042
            int r2 = r1.getModifiers()     // Catch:{ all -> 0x0040 }
            boolean r2 = java.lang.reflect.Modifier.isTransient(r2)     // Catch:{ all -> 0x0040 }
            if (r2 != 0) goto L_0x0060
            goto L_0x0042
        L_0x0040:
            r6 = move-exception
            goto L_0x0067
        L_0x0042:
            int r2 = r1.getModifiers()     // Catch:{ all -> 0x0040 }
            boolean r2 = java.lang.reflect.Modifier.isStatic(r2)     // Catch:{ all -> 0x0040 }
            if (r2 != 0) goto L_0x0060
            java.lang.Object r2 = r1.get(r4)     // Catch:{ IllegalAccessException -> 0x0058 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ IllegalAccessException -> 0x0058 }
            r7.append((java.lang.Object) r2, (java.lang.Object) r1)     // Catch:{ IllegalAccessException -> 0x0058 }
            goto L_0x0060
        L_0x0058:
            java.lang.InternalError r6 = new java.lang.InternalError     // Catch:{ all -> 0x0040 }
            java.lang.String r7 = "Unexpected IllegalAccessException"
            r6.<init>(r7)     // Catch:{ all -> 0x0040 }
            throw r6     // Catch:{ all -> 0x0040 }
        L_0x0060:
            int r0 = r0 + 1
            goto L_0x0013
        L_0x0063:
            unregister(r4, r5)
            return
        L_0x0067:
            unregister(r4, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.builder.EqualsBuilder.reflectionAppend(java.lang.Object, java.lang.Object, java.lang.Class, org.apache.commons.lang3.builder.EqualsBuilder, boolean, java.lang.String[]):void");
    }

    public static boolean reflectionEquals(Object obj, Object obj2, Collection<String> collection) {
        return reflectionEquals(obj, obj2, ReflectionToStringBuilder.toNoNullStringArray(collection));
    }

    static void register(Object obj, Object obj2) {
        synchronized (EqualsBuilder.class) {
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
        getRegistry().add(getRegisterPair(obj, obj2));
    }

    static void unregister(Object obj, Object obj2) {
        Set<Pair<IDKey, IDKey>> registry = getRegistry();
        if (registry != null) {
            registry.remove(getRegisterPair(obj, obj2));
            synchronized (EqualsBuilder.class) {
                try {
                    Set<Pair<IDKey, IDKey>> registry2 = getRegistry();
                    if (registry2 != null && registry2.isEmpty()) {
                        REGISTRY.remove();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public EqualsBuilder append(byte b2, byte b3) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = b2 == b3;
        return this;
    }

    public EqualsBuilder appendSuper(boolean z) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = z;
        return this;
    }

    public Boolean build() {
        return Boolean.valueOf(isEquals());
    }

    public boolean isEquals() {
        return this.isEquals;
    }

    public void reset() {
        this.isEquals = true;
    }

    /* access modifiers changed from: protected */
    public void setEquals(boolean z) {
        this.isEquals = z;
    }

    public static boolean reflectionEquals(Object obj, Object obj2, boolean z) {
        return reflectionEquals(obj, obj2, z, (Class<?>) null, new String[0]);
    }

    public EqualsBuilder append(char c2, char c3) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = c2 == c3;
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        if (r1.isInstance(r12) == false) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
        if (r2.isInstance(r11) == false) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean reflectionEquals(java.lang.Object r11, java.lang.Object r12, boolean r13, java.lang.Class<?> r14, java.lang.String... r15) {
        /*
            if (r11 != r12) goto L_0x0004
            r11 = 1
            return r11
        L_0x0004:
            r0 = 0
            if (r11 == 0) goto L_0x0061
            if (r12 != 0) goto L_0x000b
            goto L_0x0061
        L_0x000b:
            java.lang.Class r1 = r11.getClass()
            java.lang.Class r2 = r12.getClass()
            boolean r3 = r1.isInstance(r12)
            if (r3 == 0) goto L_0x0020
            boolean r3 = r2.isInstance(r11)
            if (r3 != 0) goto L_0x002e
            goto L_0x002d
        L_0x0020:
            boolean r3 = r2.isInstance(r11)
            if (r3 == 0) goto L_0x0061
            boolean r3 = r1.isInstance(r12)
            if (r3 != 0) goto L_0x002d
            goto L_0x002e
        L_0x002d:
            r1 = r2
        L_0x002e:
            org.apache.commons.lang3.builder.EqualsBuilder r10 = new org.apache.commons.lang3.builder.EqualsBuilder
            r10.<init>()
            boolean r2 = r1.isArray()     // Catch:{ IllegalArgumentException -> 0x0061 }
            if (r2 == 0) goto L_0x003d
            r10.append((java.lang.Object) r11, (java.lang.Object) r12)     // Catch:{ IllegalArgumentException -> 0x0061 }
            goto L_0x005c
        L_0x003d:
            r4 = r11
            r5 = r12
            r6 = r1
            r7 = r10
            r8 = r13
            r9 = r15
            reflectionAppend(r4, r5, r6, r7, r8, r9)     // Catch:{ IllegalArgumentException -> 0x0061 }
        L_0x0046:
            java.lang.Class r2 = r1.getSuperclass()     // Catch:{ IllegalArgumentException -> 0x0061 }
            if (r2 == 0) goto L_0x005c
            if (r1 == r14) goto L_0x005c
            java.lang.Class r1 = r1.getSuperclass()     // Catch:{ IllegalArgumentException -> 0x0061 }
            r2 = r11
            r3 = r12
            r4 = r1
            r5 = r10
            r6 = r13
            r7 = r15
            reflectionAppend(r2, r3, r4, r5, r6, r7)     // Catch:{ IllegalArgumentException -> 0x0061 }
            goto L_0x0046
        L_0x005c:
            boolean r11 = r10.isEquals()
            return r11
        L_0x0061:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals(java.lang.Object, java.lang.Object, boolean, java.lang.Class, java.lang.String[]):boolean");
    }

    public EqualsBuilder append(double d2, double d3) {
        return !this.isEquals ? this : append(Double.doubleToLongBits(d2), Double.doubleToLongBits(d3));
    }

    public static boolean reflectionEquals(Object obj, Object obj2, String... strArr) {
        return reflectionEquals(obj, obj2, false, (Class<?>) null, strArr);
    }

    public EqualsBuilder append(float f2, float f3) {
        return !this.isEquals ? this : append(Float.floatToIntBits(f2), Float.floatToIntBits(f3));
    }

    public EqualsBuilder append(int i2, int i3) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = i2 == i3;
        return this;
    }

    public EqualsBuilder append(long j2, long j3) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = j2 == j3;
        return this;
    }

    public EqualsBuilder append(Object obj, Object obj2) {
        if (!this.isEquals || obj == obj2) {
            return this;
        }
        if (obj == null || obj2 == null) {
            setEquals(false);
            return this;
        }
        if (!obj.getClass().isArray()) {
            this.isEquals = obj.equals(obj2);
        } else if (obj.getClass() != obj2.getClass()) {
            setEquals(false);
        } else if (obj instanceof long[]) {
            append((long[]) obj, (long[]) obj2);
        } else if (obj instanceof int[]) {
            append((int[]) obj, (int[]) obj2);
        } else if (obj instanceof short[]) {
            append((short[]) obj, (short[]) obj2);
        } else if (obj instanceof char[]) {
            append((char[]) obj, (char[]) obj2);
        } else if (obj instanceof byte[]) {
            append((byte[]) obj, (byte[]) obj2);
        } else if (obj instanceof double[]) {
            append((double[]) obj, (double[]) obj2);
        } else if (obj instanceof float[]) {
            append((float[]) obj, (float[]) obj2);
        } else if (obj instanceof boolean[]) {
            append((boolean[]) obj, (boolean[]) obj2);
        } else {
            append((Object[]) obj, (Object[]) obj2);
        }
        return this;
    }

    public EqualsBuilder append(short s, short s2) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = s == s2;
        return this;
    }

    public EqualsBuilder append(boolean z, boolean z2) {
        if (!this.isEquals) {
            return this;
        }
        this.isEquals = z == z2;
        return this;
    }

    public EqualsBuilder append(byte[] bArr, byte[] bArr2) {
        if (!this.isEquals || bArr == bArr2) {
            return this;
        }
        if (bArr == null || bArr2 == null) {
            setEquals(false);
            return this;
        } else if (bArr.length != bArr2.length) {
            setEquals(false);
            return this;
        } else {
            for (int i2 = 0; i2 < bArr.length && this.isEquals; i2++) {
                append(bArr[i2], bArr2[i2]);
            }
            return this;
        }
    }

    public EqualsBuilder append(char[] cArr, char[] cArr2) {
        if (!this.isEquals || cArr == cArr2) {
            return this;
        }
        if (cArr == null || cArr2 == null) {
            setEquals(false);
            return this;
        } else if (cArr.length != cArr2.length) {
            setEquals(false);
            return this;
        } else {
            for (int i2 = 0; i2 < cArr.length && this.isEquals; i2++) {
                append(cArr[i2], cArr2[i2]);
            }
            return this;
        }
    }

    public EqualsBuilder append(double[] dArr, double[] dArr2) {
        if (!this.isEquals || dArr == dArr2) {
            return this;
        }
        if (dArr == null || dArr2 == null) {
            setEquals(false);
            return this;
        } else if (dArr.length != dArr2.length) {
            setEquals(false);
            return this;
        } else {
            for (int i2 = 0; i2 < dArr.length && this.isEquals; i2++) {
                append(dArr[i2], dArr2[i2]);
            }
            return this;
        }
    }

    public EqualsBuilder append(float[] fArr, float[] fArr2) {
        if (!this.isEquals || fArr == fArr2) {
            return this;
        }
        if (fArr == null || fArr2 == null) {
            setEquals(false);
            return this;
        } else if (fArr.length != fArr2.length) {
            setEquals(false);
            return this;
        } else {
            for (int i2 = 0; i2 < fArr.length && this.isEquals; i2++) {
                append(fArr[i2], fArr2[i2]);
            }
            return this;
        }
    }

    public EqualsBuilder append(int[] iArr, int[] iArr2) {
        if (!this.isEquals || iArr == iArr2) {
            return this;
        }
        if (iArr == null || iArr2 == null) {
            setEquals(false);
            return this;
        } else if (iArr.length != iArr2.length) {
            setEquals(false);
            return this;
        } else {
            for (int i2 = 0; i2 < iArr.length && this.isEquals; i2++) {
                append(iArr[i2], iArr2[i2]);
            }
            return this;
        }
    }

    public EqualsBuilder append(long[] jArr, long[] jArr2) {
        if (!this.isEquals || jArr == jArr2) {
            return this;
        }
        if (jArr == null || jArr2 == null) {
            setEquals(false);
            return this;
        } else if (jArr.length != jArr2.length) {
            setEquals(false);
            return this;
        } else {
            for (int i2 = 0; i2 < jArr.length && this.isEquals; i2++) {
                append(jArr[i2], jArr2[i2]);
            }
            return this;
        }
    }

    public EqualsBuilder append(Object[] objArr, Object[] objArr2) {
        if (!this.isEquals || objArr == objArr2) {
            return this;
        }
        if (objArr == null || objArr2 == null) {
            setEquals(false);
            return this;
        } else if (objArr.length != objArr2.length) {
            setEquals(false);
            return this;
        } else {
            for (int i2 = 0; i2 < objArr.length && this.isEquals; i2++) {
                append(objArr[i2], objArr2[i2]);
            }
            return this;
        }
    }

    public EqualsBuilder append(short[] sArr, short[] sArr2) {
        if (!this.isEquals || sArr == sArr2) {
            return this;
        }
        if (sArr == null || sArr2 == null) {
            setEquals(false);
            return this;
        } else if (sArr.length != sArr2.length) {
            setEquals(false);
            return this;
        } else {
            for (int i2 = 0; i2 < sArr.length && this.isEquals; i2++) {
                append(sArr[i2], sArr2[i2]);
            }
            return this;
        }
    }

    public EqualsBuilder append(boolean[] zArr, boolean[] zArr2) {
        if (!this.isEquals || zArr == zArr2) {
            return this;
        }
        if (zArr == null || zArr2 == null) {
            setEquals(false);
            return this;
        } else if (zArr.length != zArr2.length) {
            setEquals(false);
            return this;
        } else {
            for (int i2 = 0; i2 < zArr.length && this.isEquals; i2++) {
                append(zArr[i2], zArr2[i2]);
            }
            return this;
        }
    }
}
