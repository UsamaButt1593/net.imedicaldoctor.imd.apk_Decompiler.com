package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool;
import java.util.List;

public final class FSize extends ObjectPool.Poolable {
    private static ObjectPool<FSize> X2;
    public float Y;
    public float Z;

    static {
        ObjectPool<FSize> a2 = ObjectPool.a(256, new FSize(0.0f, 0.0f));
        X2 = a2;
        a2.l(0.5f);
    }

    public FSize() {
    }

    public static FSize b(float f2, float f3) {
        FSize b2 = X2.b();
        b2.Y = f2;
        b2.Z = f3;
        return b2;
    }

    public static void c(FSize fSize) {
        X2.g(fSize);
    }

    public static void d(List<FSize> list) {
        X2.h(list);
    }

    /* access modifiers changed from: protected */
    public ObjectPool.Poolable a() {
        return new FSize(0.0f, 0.0f);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FSize)) {
            return false;
        }
        FSize fSize = (FSize) obj;
        return this.Y == fSize.Y && this.Z == fSize.Z;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.Y) ^ Float.floatToIntBits(this.Z);
    }

    public String toString() {
        return this.Y + "x" + this.Z;
    }

    public FSize(float f2, float f3) {
        this.Y = f2;
        this.Z = f3;
    }
}
