package com.github.mikephil.charting.utils;

import android.os.Parcel;
import android.os.Parcelable;
import com.github.mikephil.charting.utils.ObjectPool;
import java.util.List;

public class MPPointF extends ObjectPool.Poolable {
    private static ObjectPool<MPPointF> X2;
    public static final Parcelable.Creator<MPPointF> Y2 = new Parcelable.Creator<MPPointF>() {
        /* renamed from: a */
        public MPPointF createFromParcel(Parcel parcel) {
            MPPointF mPPointF = new MPPointF(0.0f, 0.0f);
            mPPointF.g(parcel);
            return mPPointF;
        }

        /* renamed from: b */
        public MPPointF[] newArray(int i2) {
            return new MPPointF[i2];
        }
    };
    public float Y;
    public float Z;

    static {
        ObjectPool<MPPointF> a2 = ObjectPool.a(32, new MPPointF(0.0f, 0.0f));
        X2 = a2;
        a2.l(0.5f);
    }

    public MPPointF() {
    }

    public static MPPointF b() {
        return X2.b();
    }

    public static MPPointF c(float f2, float f3) {
        MPPointF b2 = X2.b();
        b2.Y = f2;
        b2.Z = f3;
        return b2;
    }

    public static MPPointF d(MPPointF mPPointF) {
        MPPointF b2 = X2.b();
        b2.Y = mPPointF.Y;
        b2.Z = mPPointF.Z;
        return b2;
    }

    public static void h(MPPointF mPPointF) {
        X2.g(mPPointF);
    }

    public static void i(List<MPPointF> list) {
        X2.h(list);
    }

    /* access modifiers changed from: protected */
    public ObjectPool.Poolable a() {
        return new MPPointF(0.0f, 0.0f);
    }

    public float e() {
        return this.Y;
    }

    public float f() {
        return this.Z;
    }

    public void g(Parcel parcel) {
        this.Y = parcel.readFloat();
        this.Z = parcel.readFloat();
    }

    public MPPointF(float f2, float f3) {
        this.Y = f2;
        this.Z = f3;
    }
}
