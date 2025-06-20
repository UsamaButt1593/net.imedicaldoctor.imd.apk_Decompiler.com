package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool;
import java.util.List;

public class MPPointD extends ObjectPool.Poolable {
    private static ObjectPool<MPPointD> X2;
    public double Y;
    public double Z;

    static {
        ObjectPool<MPPointD> a2 = ObjectPool.a(64, new MPPointD(0.0d, 0.0d));
        X2 = a2;
        a2.l(0.5f);
    }

    private MPPointD(double d2, double d3) {
        this.Y = d2;
        this.Z = d3;
    }

    public static MPPointD b(double d2, double d3) {
        MPPointD b2 = X2.b();
        b2.Y = d2;
        b2.Z = d3;
        return b2;
    }

    public static void c(MPPointD mPPointD) {
        X2.g(mPPointD);
    }

    public static void d(List<MPPointD> list) {
        X2.h(list);
    }

    /* access modifiers changed from: protected */
    public ObjectPool.Poolable a() {
        return new MPPointD(0.0d, 0.0d);
    }

    public String toString() {
        return "MPPointD, x: " + this.Y + ", y: " + this.Z;
    }
}
