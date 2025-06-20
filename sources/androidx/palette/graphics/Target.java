package androidx.palette.graphics;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;

public final class Target {
    public static final Target A;
    public static final Target B;
    public static final Target C;
    public static final Target D;

    /* renamed from: e  reason: collision with root package name */
    private static final float f15005e = 0.26f;

    /* renamed from: f  reason: collision with root package name */
    private static final float f15006f = 0.45f;

    /* renamed from: g  reason: collision with root package name */
    private static final float f15007g = 0.55f;

    /* renamed from: h  reason: collision with root package name */
    private static final float f15008h = 0.74f;

    /* renamed from: i  reason: collision with root package name */
    private static final float f15009i = 0.3f;

    /* renamed from: j  reason: collision with root package name */
    private static final float f15010j = 0.5f;

    /* renamed from: k  reason: collision with root package name */
    private static final float f15011k = 0.7f;

    /* renamed from: l  reason: collision with root package name */
    private static final float f15012l = 0.3f;

    /* renamed from: m  reason: collision with root package name */
    private static final float f15013m = 0.4f;

    /* renamed from: n  reason: collision with root package name */
    private static final float f15014n = 1.0f;
    private static final float o = 0.35f;
    private static final float p = 0.24f;
    private static final float q = 0.52f;
    private static final float r = 0.24f;
    static final int s = 0;
    static final int t = 1;
    static final int u = 2;
    static final int v = 0;
    static final int w = 1;
    static final int x = 2;
    public static final Target y;
    public static final Target z;

    /* renamed from: a  reason: collision with root package name */
    final float[] f15015a;

    /* renamed from: b  reason: collision with root package name */
    final float[] f15016b;

    /* renamed from: c  reason: collision with root package name */
    final float[] f15017c;

    /* renamed from: d  reason: collision with root package name */
    boolean f15018d;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final Target f15019a;

        public Builder() {
            this.f15019a = new Target();
        }

        @NonNull
        public Target a() {
            return this.f15019a;
        }

        @NonNull
        public Builder b(boolean z) {
            this.f15019a.f15018d = z;
            return this;
        }

        @NonNull
        public Builder c(@FloatRange(from = 0.0d) float f2) {
            this.f15019a.f15017c[1] = f2;
            return this;
        }

        @NonNull
        public Builder d(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
            this.f15019a.f15016b[2] = f2;
            return this;
        }

        @NonNull
        public Builder e(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
            this.f15019a.f15015a[2] = f2;
            return this;
        }

        @NonNull
        public Builder f(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
            this.f15019a.f15016b[0] = f2;
            return this;
        }

        @NonNull
        public Builder g(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
            this.f15019a.f15015a[0] = f2;
            return this;
        }

        @NonNull
        public Builder h(@FloatRange(from = 0.0d) float f2) {
            this.f15019a.f15017c[2] = f2;
            return this;
        }

        @NonNull
        public Builder i(@FloatRange(from = 0.0d) float f2) {
            this.f15019a.f15017c[0] = f2;
            return this;
        }

        @NonNull
        public Builder j(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
            this.f15019a.f15016b[1] = f2;
            return this;
        }

        @NonNull
        public Builder k(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
            this.f15019a.f15015a[1] = f2;
            return this;
        }

        public Builder(@NonNull Target target) {
            this.f15019a = new Target(target);
        }
    }

    static {
        Target target = new Target();
        y = target;
        m(target);
        p(target);
        Target target2 = new Target();
        z = target2;
        o(target2);
        p(target2);
        Target target3 = new Target();
        A = target3;
        l(target3);
        p(target3);
        Target target4 = new Target();
        B = target4;
        m(target4);
        n(target4);
        Target target5 = new Target();
        C = target5;
        o(target5);
        n(target5);
        Target target6 = new Target();
        D = target6;
        l(target6);
        n(target6);
    }

    Target() {
        float[] fArr = new float[3];
        this.f15015a = fArr;
        float[] fArr2 = new float[3];
        this.f15016b = fArr2;
        this.f15017c = new float[3];
        this.f15018d = true;
        r(fArr);
        r(fArr2);
        q();
    }

    private static void l(Target target) {
        float[] fArr = target.f15016b;
        fArr[1] = 0.26f;
        fArr[2] = 0.45f;
    }

    private static void m(Target target) {
        float[] fArr = target.f15016b;
        fArr[0] = 0.55f;
        fArr[1] = 0.74f;
    }

    private static void n(Target target) {
        float[] fArr = target.f15015a;
        fArr[1] = 0.3f;
        fArr[2] = 0.4f;
    }

    private static void o(Target target) {
        float[] fArr = target.f15016b;
        fArr[0] = 0.3f;
        fArr[1] = 0.5f;
        fArr[2] = 0.7f;
    }

    private static void p(Target target) {
        float[] fArr = target.f15015a;
        fArr[0] = 0.35f;
        fArr[1] = 1.0f;
    }

    private void q() {
        float[] fArr = this.f15017c;
        fArr[0] = 0.24f;
        fArr[1] = 0.52f;
        fArr[2] = 0.24f;
    }

    private static void r(float[] fArr) {
        fArr[0] = 0.0f;
        fArr[1] = 0.5f;
        fArr[2] = 1.0f;
    }

    public float a() {
        return this.f15017c[1];
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float b() {
        return this.f15016b[2];
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float c() {
        return this.f15015a[2];
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float d() {
        return this.f15016b[0];
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float e() {
        return this.f15015a[0];
    }

    public float f() {
        return this.f15017c[2];
    }

    public float g() {
        return this.f15017c[0];
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float h() {
        return this.f15016b[1];
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float i() {
        return this.f15015a[1];
    }

    public boolean j() {
        return this.f15018d;
    }

    /* access modifiers changed from: package-private */
    public void k() {
        float f2 = 0.0f;
        for (float f3 : this.f15017c) {
            if (f3 > 0.0f) {
                f2 += f3;
            }
        }
        if (f2 != 0.0f) {
            int length = this.f15017c.length;
            for (int i2 = 0; i2 < length; i2++) {
                float[] fArr = this.f15017c;
                float f4 = fArr[i2];
                if (f4 > 0.0f) {
                    fArr[i2] = f4 / f2;
                }
            }
        }
    }

    Target(@NonNull Target target) {
        float[] fArr = new float[3];
        this.f15015a = fArr;
        float[] fArr2 = new float[3];
        this.f15016b = fArr2;
        float[] fArr3 = new float[3];
        this.f15017c = fArr3;
        this.f15018d = true;
        System.arraycopy(target.f15015a, 0, fArr, 0, fArr.length);
        System.arraycopy(target.f15016b, 0, fArr2, 0, fArr2.length);
        System.arraycopy(target.f15017c, 0, fArr3, 0, fArr3.length);
    }
}
