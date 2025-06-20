package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool.Poolable;
import java.util.List;

public class ObjectPool<T extends Poolable> {

    /* renamed from: g  reason: collision with root package name */
    private static int f19145g;

    /* renamed from: a  reason: collision with root package name */
    private int f19146a;

    /* renamed from: b  reason: collision with root package name */
    private int f19147b;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f19148c;

    /* renamed from: d  reason: collision with root package name */
    private int f19149d;

    /* renamed from: e  reason: collision with root package name */
    private T f19150e;

    /* renamed from: f  reason: collision with root package name */
    private float f19151f;

    public static abstract class Poolable {
        public static int X = -1;
        int s = X;

        /* access modifiers changed from: protected */
        public abstract Poolable a();
    }

    private ObjectPool(int i2, T t) {
        if (i2 > 0) {
            this.f19147b = i2;
            this.f19148c = new Object[i2];
            this.f19149d = 0;
            this.f19150e = t;
            this.f19151f = 1.0f;
            i();
            return;
        }
        throw new IllegalArgumentException("Object Pool must be instantiated with a capacity greater than 0!");
    }

    public static synchronized ObjectPool a(int i2, Poolable poolable) {
        ObjectPool objectPool;
        synchronized (ObjectPool.class) {
            objectPool = new ObjectPool(i2, poolable);
            int i3 = f19145g;
            objectPool.f19146a = i3;
            f19145g = i3 + 1;
        }
        return objectPool;
    }

    private void i() {
        j(this.f19151f);
    }

    private void j(float f2) {
        int i2 = this.f19147b;
        int i3 = (int) (((float) i2) * f2);
        if (i3 < 1) {
            i2 = 1;
        } else if (i3 <= i2) {
            i2 = i3;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            this.f19148c[i4] = this.f19150e.a();
        }
        this.f19149d = i2 - 1;
    }

    private void k() {
        int i2 = this.f19147b;
        int i3 = i2 * 2;
        this.f19147b = i3;
        Object[] objArr = new Object[i3];
        for (int i4 = 0; i4 < i2; i4++) {
            objArr[i4] = this.f19148c[i4];
        }
        this.f19148c = objArr;
    }

    public synchronized T b() {
        T t;
        try {
            if (this.f19149d == -1 && this.f19151f > 0.0f) {
                i();
            }
            T[] tArr = this.f19148c;
            int i2 = this.f19149d;
            t = (Poolable) tArr[i2];
            t.s = Poolable.X;
            this.f19149d = i2 - 1;
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return t;
    }

    public int c() {
        return this.f19148c.length;
    }

    public int d() {
        return this.f19149d + 1;
    }

    public int e() {
        return this.f19146a;
    }

    public float f() {
        return this.f19151f;
    }

    public synchronized void g(T t) {
        try {
            int i2 = t.s;
            if (i2 == Poolable.X) {
                int i3 = this.f19149d + 1;
                this.f19149d = i3;
                if (i3 >= this.f19148c.length) {
                    k();
                }
                t.s = this.f19146a;
                this.f19148c[this.f19149d] = t;
            } else if (i2 == this.f19146a) {
                throw new IllegalArgumentException("The object passed is already stored in this pool!");
            } else {
                throw new IllegalArgumentException("The object to recycle already belongs to poolId " + t.s + ".  Object cannot belong to two different pool instances simultaneously!");
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public synchronized void h(List<T> list) {
        while (list.size() + this.f19149d + 1 > this.f19147b) {
            try {
                k();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            Poolable poolable = (Poolable) list.get(i2);
            int i3 = poolable.s;
            if (i3 == Poolable.X) {
                poolable.s = this.f19146a;
                this.f19148c[this.f19149d + 1 + i2] = poolable;
                i2++;
            } else if (i3 == this.f19146a) {
                throw new IllegalArgumentException("The object passed is already stored in this pool!");
            } else {
                throw new IllegalArgumentException("The object to recycle already belongs to poolId " + poolable.s + ".  Object cannot belong to two different pool instances simultaneously!");
            }
        }
        this.f19149d += size;
    }

    public void l(float f2) {
        if (f2 > 1.0f) {
            f2 = 1.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.f19151f = f2;
    }
}
