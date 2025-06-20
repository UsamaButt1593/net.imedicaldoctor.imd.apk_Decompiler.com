package androidx.versionedparcelable;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.NetworkOnMainThreadException;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class VersionedParcel {

    /* renamed from: d  reason: collision with root package name */
    private static final String f16406d = "VersionedParcel";

    /* renamed from: e  reason: collision with root package name */
    private static final int f16407e = -1;

    /* renamed from: f  reason: collision with root package name */
    private static final int f16408f = -2;

    /* renamed from: g  reason: collision with root package name */
    private static final int f16409g = -3;

    /* renamed from: h  reason: collision with root package name */
    private static final int f16410h = -4;

    /* renamed from: i  reason: collision with root package name */
    private static final int f16411i = -5;

    /* renamed from: j  reason: collision with root package name */
    private static final int f16412j = -6;

    /* renamed from: k  reason: collision with root package name */
    private static final int f16413k = -7;

    /* renamed from: l  reason: collision with root package name */
    private static final int f16414l = -9;

    /* renamed from: m  reason: collision with root package name */
    private static final int f16415m = 1;

    /* renamed from: n  reason: collision with root package name */
    private static final int f16416n = 2;
    private static final int o = 3;
    private static final int p = 4;
    private static final int q = 5;
    private static final int r = 7;
    private static final int s = 8;

    /* renamed from: a  reason: collision with root package name */
    protected final ArrayMap<String, Method> f16417a;

    /* renamed from: b  reason: collision with root package name */
    protected final ArrayMap<String, Method> f16418b;

    /* renamed from: c  reason: collision with root package name */
    protected final ArrayMap<String, Class> f16419c;

    public static class ParcelException extends RuntimeException {
        public ParcelException(Throwable th) {
            super(th);
        }
    }

    public VersionedParcel(ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        this.f16417a = arrayMap;
        this.f16418b = arrayMap2;
        this.f16419c = arrayMap3;
    }

    private <T> void A0(Collection<T> collection) {
        if (collection == null) {
            L0(-1);
            return;
        }
        int size = collection.size();
        L0(size);
        if (size > 0) {
            int g2 = g(collection.iterator().next());
            L0(g2);
            switch (g2) {
                case 1:
                    for (T l1 : collection) {
                        l1(l1);
                    }
                    return;
                case 2:
                    for (T W0 : collection) {
                        W0(W0);
                    }
                    return;
                case 3:
                    for (T Y0 : collection) {
                        Y0(Y0);
                    }
                    return;
                case 4:
                    for (T e1 : collection) {
                        e1(e1);
                    }
                    return;
                case 5:
                    for (T g1 : collection) {
                        g1(g1);
                    }
                    return;
                case 7:
                    for (T intValue : collection) {
                        L0(intValue.intValue());
                    }
                    return;
                case 8:
                    for (T floatValue : collection) {
                        H0(floatValue.floatValue());
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private <T> void B0(Collection<T> collection, int i2) {
        i0(i2);
        A0(collection);
    }

    private Exception C(int i2, String str) {
        return b(i2, str);
    }

    private int E() {
        return L();
    }

    private void Y0(Serializable serializable) {
        if (serializable == null) {
            e1((String) null);
            return;
        }
        String name = serializable.getClass().getName();
        e1(name);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            t0(byteArrayOutputStream.toByteArray());
        } catch (IOException e2) {
            throw new RuntimeException("VersionedParcelable encountered IOException writing serializable object (name = " + name + ")", e2);
        }
    }

    private Exception b(int i2, String str) {
        switch (i2) {
            case f16414l /*-9*/:
                return (Exception) V();
            case f16413k /*-7*/:
                return new UnsupportedOperationException(str);
            case f16412j /*-6*/:
                return new NetworkOnMainThreadException();
            case -5:
                return new IllegalStateException(str);
            case -4:
                return new NullPointerException(str);
            case -3:
                return new IllegalArgumentException(str);
            case -2:
                return new BadParcelableException(str);
            case -1:
                return new SecurityException(str);
            default:
                return new RuntimeException("Unknown exception code: " + i2 + " msg " + str);
        }
    }

    private Class d(Class<? extends VersionedParcelable> cls) throws ClassNotFoundException {
        Class cls2 = this.f16419c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", new Object[]{cls.getPackage().getName(), cls.getSimpleName()}), false, cls.getClassLoader());
        this.f16419c.put(cls.getName(), cls3);
        return cls3;
    }

    private Method e(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f16417a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Class<VersionedParcel> cls = VersionedParcel.class;
        Method declaredMethod = Class.forName(str, true, cls.getClassLoader()).getDeclaredMethod("read", new Class[]{cls});
        this.f16417a.put(str, declaredMethod);
        return declaredMethod;
    }

    @NonNull
    protected static Throwable f(@NonNull Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    private <T> int g(T t) {
        if (t instanceof String) {
            return 4;
        }
        if (t instanceof Parcelable) {
            return 2;
        }
        if (t instanceof VersionedParcelable) {
            return 1;
        }
        if (t instanceof Serializable) {
            return 3;
        }
        if (t instanceof IBinder) {
            return 5;
        }
        if (t instanceof Integer) {
            return 7;
        }
        if (t instanceof Float) {
            return 8;
        }
        throw new IllegalArgumentException(t.getClass().getName() + " cannot be VersionedParcelled");
    }

    private Method h(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f16418b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class d2 = d(cls);
        System.currentTimeMillis();
        Method declaredMethod = d2.getDeclaredMethod("write", new Class[]{cls, VersionedParcel.class});
        this.f16418b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    private void n1(VersionedParcelable versionedParcelable) {
        try {
            e1(d(versionedParcelable.getClass()).getName());
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(versionedParcelable.getClass().getSimpleName() + " does not have a Parcelizer", e2);
        }
    }

    private <T, S extends Collection<T>> S x(S s2) {
        int L = L();
        if (L < 0) {
            return null;
        }
        if (L != 0) {
            int L2 = L();
            if (L < 0) {
                return null;
            }
            if (L2 == 1) {
                while (L > 0) {
                    s2.add(g0());
                    L--;
                }
            } else if (L2 == 2) {
                while (L > 0) {
                    s2.add(V());
                    L--;
                }
            } else if (L2 == 3) {
                while (L > 0) {
                    s2.add(X());
                    L--;
                }
            } else if (L2 == 4) {
                while (L > 0) {
                    s2.add(c0());
                    L--;
                }
            } else if (L2 == 5) {
                while (L > 0) {
                    s2.add(e0());
                    L--;
                }
            }
        }
        return s2;
    }

    /* access modifiers changed from: protected */
    public double[] A() {
        int L = L();
        if (L < 0) {
            return null;
        }
        double[] dArr = new double[L];
        for (int i2 = 0; i2 < L; i2++) {
            dArr[i2] = y();
        }
        return dArr;
    }

    public double[] B(double[] dArr, int i2) {
        return !F(i2) ? dArr : A();
    }

    /* access modifiers changed from: protected */
    public abstract void C0(double d2);

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r2 = E();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Exception D(java.lang.Exception r1, int r2) {
        /*
            r0 = this;
            boolean r2 = r0.F(r2)
            if (r2 != 0) goto L_0x0007
            return r1
        L_0x0007:
            int r2 = r0.E()
            if (r2 == 0) goto L_0x0015
            java.lang.String r1 = r0.c0()
            java.lang.Exception r1 = r0.C(r2, r1)
        L_0x0015:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.versionedparcelable.VersionedParcel.D(java.lang.Exception, int):java.lang.Exception");
    }

    public void D0(double d2, int i2) {
        i0(i2);
        C0(d2);
    }

    /* access modifiers changed from: protected */
    public void E0(double[] dArr) {
        if (dArr != null) {
            L0(r0);
            for (double C0 : dArr) {
                C0(C0);
            }
            return;
        }
        L0(-1);
    }

    /* access modifiers changed from: protected */
    public abstract boolean F(int i2);

    public void F0(double[] dArr, int i2) {
        i0(i2);
        E0(dArr);
    }

    /* access modifiers changed from: protected */
    public abstract float G();

    public void G0(Exception exc, int i2) {
        i0(i2);
        if (exc == null) {
            V0();
            return;
        }
        int i3 = (!(exc instanceof Parcelable) || exc.getClass().getClassLoader() != Parcelable.class.getClassLoader()) ? exc instanceof SecurityException ? -1 : exc instanceof BadParcelableException ? -2 : exc instanceof IllegalArgumentException ? -3 : exc instanceof NullPointerException ? -4 : exc instanceof IllegalStateException ? -5 : exc instanceof NetworkOnMainThreadException ? f16412j : exc instanceof UnsupportedOperationException ? f16413k : 0 : f16414l;
        L0(i3);
        if (i3 != 0) {
            e1(exc.getMessage());
            if (i3 == f16414l) {
                W0((Parcelable) exc);
            }
        } else if (exc instanceof RuntimeException) {
            throw ((RuntimeException) exc);
        } else {
            throw new RuntimeException(exc);
        }
    }

    public float H(float f2, int i2) {
        return !F(i2) ? f2 : G();
    }

    /* access modifiers changed from: protected */
    public abstract void H0(float f2);

    /* access modifiers changed from: protected */
    public float[] I() {
        int L = L();
        if (L < 0) {
            return null;
        }
        float[] fArr = new float[L];
        for (int i2 = 0; i2 < L; i2++) {
            fArr[i2] = G();
        }
        return fArr;
    }

    public void I0(float f2, int i2) {
        i0(i2);
        H0(f2);
    }

    public float[] J(float[] fArr, int i2) {
        return !F(i2) ? fArr : I();
    }

    /* access modifiers changed from: protected */
    public void J0(float[] fArr) {
        if (fArr != null) {
            L0(r0);
            for (float H0 : fArr) {
                H0(H0);
            }
            return;
        }
        L0(-1);
    }

    /* access modifiers changed from: protected */
    public <T extends VersionedParcelable> T K(String str, VersionedParcel versionedParcel) {
        try {
            return (VersionedParcelable) e(str).invoke((Object) null, new Object[]{versionedParcel});
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e3.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        }
    }

    public void K0(float[] fArr, int i2) {
        i0(i2);
        J0(fArr);
    }

    /* access modifiers changed from: protected */
    public abstract int L();

    /* access modifiers changed from: protected */
    public abstract void L0(int i2);

    public int M(int i2, int i3) {
        return !F(i3) ? i2 : L();
    }

    public void M0(int i2, int i3) {
        i0(i3);
        L0(i2);
    }

    /* access modifiers changed from: protected */
    public int[] N() {
        int L = L();
        if (L < 0) {
            return null;
        }
        int[] iArr = new int[L];
        for (int i2 = 0; i2 < L; i2++) {
            iArr[i2] = L();
        }
        return iArr;
    }

    /* access modifiers changed from: protected */
    public void N0(int[] iArr) {
        if (iArr != null) {
            L0(r0);
            for (int L0 : iArr) {
                L0(L0);
            }
            return;
        }
        L0(-1);
    }

    public int[] O(int[] iArr, int i2) {
        return !F(i2) ? iArr : N();
    }

    public void O0(int[] iArr, int i2) {
        i0(i2);
        N0(iArr);
    }

    public <T> List<T> P(List<T> list, int i2) {
        return !F(i2) ? list : (List) x(new ArrayList());
    }

    public <T> void P0(List<T> list, int i2) {
        B0(list, i2);
    }

    /* access modifiers changed from: protected */
    public abstract long Q();

    /* access modifiers changed from: protected */
    public abstract void Q0(long j2);

    public long R(long j2, int i2) {
        return !F(i2) ? j2 : Q();
    }

    public void R0(long j2, int i2) {
        i0(i2);
        Q0(j2);
    }

    /* access modifiers changed from: protected */
    public long[] S() {
        int L = L();
        if (L < 0) {
            return null;
        }
        long[] jArr = new long[L];
        for (int i2 = 0; i2 < L; i2++) {
            jArr[i2] = Q();
        }
        return jArr;
    }

    /* access modifiers changed from: protected */
    public void S0(long[] jArr) {
        if (jArr != null) {
            L0(r0);
            for (long Q0 : jArr) {
                Q0(Q0);
            }
            return;
        }
        L0(-1);
    }

    public long[] T(long[] jArr, int i2) {
        return !F(i2) ? jArr : S();
    }

    public void T0(long[] jArr, int i2) {
        i0(i2);
        S0(jArr);
    }

    public <K, V> Map<K, V> U(Map<K, V> map, int i2) {
        if (!F(i2)) {
            return map;
        }
        int L = L();
        if (L < 0) {
            return null;
        }
        ArrayMap arrayMap = new ArrayMap();
        if (L == 0) {
            return arrayMap;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        x(arrayList);
        x(arrayList2);
        for (int i3 = 0; i3 < L; i3++) {
            arrayMap.put(arrayList.get(i3), arrayList2.get(i3));
        }
        return arrayMap;
    }

    public <K, V> void U0(Map<K, V> map, int i2) {
        i0(i2);
        if (map == null) {
            L0(-1);
            return;
        }
        int size = map.size();
        L0(size);
        if (size != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Map.Entry next : map.entrySet()) {
                arrayList.add(next.getKey());
                arrayList2.add(next.getValue());
            }
            A0(arrayList);
            A0(arrayList2);
        }
    }

    /* access modifiers changed from: protected */
    public abstract <T extends Parcelable> T V();

    /* access modifiers changed from: protected */
    public void V0() {
        L0(0);
    }

    public <T extends Parcelable> T W(T t, int i2) {
        return !F(i2) ? t : V();
    }

    /* access modifiers changed from: protected */
    public abstract void W0(Parcelable parcelable);

    /* access modifiers changed from: protected */
    public Serializable X() {
        String c0 = c0();
        if (c0 == null) {
            return null;
        }
        try {
            return (Serializable) new ObjectInputStream(new ByteArrayInputStream(s())) {
                /* access modifiers changed from: protected */
                public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
                    Class<?> cls = Class.forName(objectStreamClass.getName(), false, getClass().getClassLoader());
                    return cls != null ? cls : super.resolveClass(objectStreamClass);
                }
            }.readObject();
        } catch (IOException e2) {
            throw new RuntimeException("VersionedParcelable encountered IOException reading a Serializable object (name = " + c0 + ")", e2);
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = " + c0 + ")", e3);
        }
    }

    public void X0(Parcelable parcelable, int i2) {
        i0(i2);
        W0(parcelable);
    }

    public <T> Set<T> Y(Set<T> set, int i2) {
        return !F(i2) ? set : (Set) x(new ArraySet());
    }

    @RequiresApi(api = 21)
    public Size Z(Size size, int i2) {
        if (!F(i2)) {
            return size;
        }
        if (l()) {
            return new Size(L(), L());
        }
        return null;
    }

    public void Z0(Serializable serializable, int i2) {
        i0(i2);
        Y0(serializable);
    }

    /* access modifiers changed from: protected */
    public abstract void a();

    @RequiresApi(api = 21)
    public SizeF a0(SizeF sizeF, int i2) {
        if (!F(i2)) {
            return sizeF;
        }
        if (l()) {
            return new SizeF(G(), G());
        }
        return null;
    }

    public <T> void a1(Set<T> set, int i2) {
        B0(set, i2);
    }

    public SparseBooleanArray b0(SparseBooleanArray sparseBooleanArray, int i2) {
        if (!F(i2)) {
            return sparseBooleanArray;
        }
        int L = L();
        if (L < 0) {
            return null;
        }
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray(L);
        for (int i3 = 0; i3 < L; i3++) {
            sparseBooleanArray2.put(L(), l());
        }
        return sparseBooleanArray2;
    }

    @RequiresApi(api = 21)
    public void b1(Size size, int i2) {
        i0(i2);
        m0(size != null);
        if (size != null) {
            L0(size.getWidth());
            L0(size.getHeight());
        }
    }

    /* access modifiers changed from: protected */
    public abstract VersionedParcel c();

    /* access modifiers changed from: protected */
    public abstract String c0();

    @RequiresApi(api = 21)
    public void c1(SizeF sizeF, int i2) {
        i0(i2);
        m0(sizeF != null);
        if (sizeF != null) {
            H0(sizeF.getWidth());
            H0(sizeF.getHeight());
        }
    }

    public String d0(String str, int i2) {
        return !F(i2) ? str : c0();
    }

    public void d1(SparseBooleanArray sparseBooleanArray, int i2) {
        i0(i2);
        if (sparseBooleanArray == null) {
            L0(-1);
            return;
        }
        int size = sparseBooleanArray.size();
        L0(size);
        for (int i3 = 0; i3 < size; i3++) {
            L0(sparseBooleanArray.keyAt(i3));
            m0(sparseBooleanArray.valueAt(i3));
        }
    }

    /* access modifiers changed from: protected */
    public abstract IBinder e0();

    /* access modifiers changed from: protected */
    public abstract void e1(String str);

    public IBinder f0(IBinder iBinder, int i2) {
        return !F(i2) ? iBinder : e0();
    }

    public void f1(String str, int i2) {
        i0(i2);
        e1(str);
    }

    /* access modifiers changed from: protected */
    public <T extends VersionedParcelable> T g0() {
        String c0 = c0();
        if (c0 == null) {
            return null;
        }
        return K(c0, c());
    }

    /* access modifiers changed from: protected */
    public abstract void g1(IBinder iBinder);

    public <T extends VersionedParcelable> T h0(T t, int i2) {
        return !F(i2) ? t : g0();
    }

    public void h1(IBinder iBinder, int i2) {
        i0(i2);
        g1(iBinder);
    }

    public boolean i() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract void i0(int i2);

    /* access modifiers changed from: protected */
    public abstract void i1(IInterface iInterface);

    /* access modifiers changed from: protected */
    public <T> T[] j(T[] tArr) {
        int L = L();
        if (L < 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(L);
        if (L != 0) {
            int L2 = L();
            if (L < 0) {
                return null;
            }
            if (L2 == 1) {
                while (L > 0) {
                    arrayList.add(g0());
                    L--;
                }
            } else if (L2 == 2) {
                while (L > 0) {
                    arrayList.add(V());
                    L--;
                }
            } else if (L2 == 3) {
                while (L > 0) {
                    arrayList.add(X());
                    L--;
                }
            } else if (L2 == 4) {
                while (L > 0) {
                    arrayList.add(c0());
                    L--;
                }
            } else if (L2 == 5) {
                while (L > 0) {
                    arrayList.add(e0());
                    L--;
                }
            }
        }
        return arrayList.toArray(tArr);
    }

    public void j0(boolean z, boolean z2) {
    }

    public void j1(IInterface iInterface, int i2) {
        i0(i2);
        i1(iInterface);
    }

    public <T> T[] k(T[] tArr, int i2) {
        return !F(i2) ? tArr : j(tArr);
    }

    /* access modifiers changed from: protected */
    public <T> void k0(T[] tArr) {
        if (tArr == null) {
            L0(-1);
            return;
        }
        int length = tArr.length;
        L0(length);
        if (length > 0) {
            int i2 = 0;
            int g2 = g(tArr[0]);
            L0(g2);
            if (g2 == 1) {
                while (i2 < length) {
                    l1((VersionedParcelable) tArr[i2]);
                    i2++;
                }
            } else if (g2 == 2) {
                while (i2 < length) {
                    W0((Parcelable) tArr[i2]);
                    i2++;
                }
            } else if (g2 == 3) {
                while (i2 < length) {
                    Y0((Serializable) tArr[i2]);
                    i2++;
                }
            } else if (g2 == 4) {
                while (i2 < length) {
                    e1((String) tArr[i2]);
                    i2++;
                }
            } else if (g2 == 5) {
                while (i2 < length) {
                    g1((IBinder) tArr[i2]);
                    i2++;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public <T extends VersionedParcelable> void k1(T t, VersionedParcel versionedParcel) {
        try {
            h(t.getClass()).invoke((Object) null, new Object[]{t, versionedParcel});
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e3.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean l();

    public <T> void l0(T[] tArr, int i2) {
        i0(i2);
        k0(tArr);
    }

    /* access modifiers changed from: protected */
    public void l1(VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            e1((String) null);
            return;
        }
        n1(versionedParcelable);
        VersionedParcel c2 = c();
        k1(versionedParcelable, c2);
        c2.a();
    }

    public boolean m(boolean z, int i2) {
        return !F(i2) ? z : l();
    }

    /* access modifiers changed from: protected */
    public abstract void m0(boolean z);

    public void m1(VersionedParcelable versionedParcelable, int i2) {
        i0(i2);
        l1(versionedParcelable);
    }

    /* access modifiers changed from: protected */
    public boolean[] n() {
        int L = L();
        if (L < 0) {
            return null;
        }
        boolean[] zArr = new boolean[L];
        for (int i2 = 0; i2 < L; i2++) {
            zArr[i2] = L() != 0;
        }
        return zArr;
    }

    public void n0(boolean z, int i2) {
        i0(i2);
        m0(z);
    }

    public boolean[] o(boolean[] zArr, int i2) {
        return !F(i2) ? zArr : n();
    }

    /* access modifiers changed from: protected */
    public void o0(boolean[] zArr) {
        if (zArr != null) {
            L0(r0);
            for (boolean z : zArr) {
                L0(z ? 1 : 0);
            }
            return;
        }
        L0(-1);
    }

    /* access modifiers changed from: protected */
    public abstract Bundle p();

    public void p0(boolean[] zArr, int i2) {
        i0(i2);
        o0(zArr);
    }

    public Bundle q(Bundle bundle, int i2) {
        return !F(i2) ? bundle : p();
    }

    /* access modifiers changed from: protected */
    public abstract void q0(Bundle bundle);

    public byte r(byte b2, int i2) {
        return !F(i2) ? b2 : (byte) (L() & 255);
    }

    public void r0(Bundle bundle, int i2) {
        i0(i2);
        q0(bundle);
    }

    /* access modifiers changed from: protected */
    public abstract byte[] s();

    public void s0(byte b2, int i2) {
        i0(i2);
        L0(b2);
    }

    public byte[] t(byte[] bArr, int i2) {
        return !F(i2) ? bArr : s();
    }

    /* access modifiers changed from: protected */
    public abstract void t0(byte[] bArr);

    public char[] u(char[] cArr, int i2) {
        if (!F(i2)) {
            return cArr;
        }
        int L = L();
        if (L < 0) {
            return null;
        }
        char[] cArr2 = new char[L];
        for (int i3 = 0; i3 < L; i3++) {
            cArr2[i3] = (char) L();
        }
        return cArr2;
    }

    public void u0(byte[] bArr, int i2) {
        i0(i2);
        t0(bArr);
    }

    /* access modifiers changed from: protected */
    public abstract CharSequence v();

    /* access modifiers changed from: protected */
    public abstract void v0(byte[] bArr, int i2, int i3);

    public CharSequence w(CharSequence charSequence, int i2) {
        return !F(i2) ? charSequence : v();
    }

    public void w0(byte[] bArr, int i2, int i3, int i4) {
        i0(i4);
        v0(bArr, i2, i3);
    }

    public void x0(char[] cArr, int i2) {
        i0(i2);
        if (cArr != null) {
            L0(r4);
            for (char L0 : cArr) {
                L0(L0);
            }
            return;
        }
        L0(-1);
    }

    /* access modifiers changed from: protected */
    public abstract double y();

    /* access modifiers changed from: protected */
    public abstract void y0(CharSequence charSequence);

    public double z(double d2, int i2) {
        return !F(i2) ? d2 : y();
    }

    public void z0(CharSequence charSequence, int i2) {
        i0(i2);
        y0(charSequence);
    }
}
