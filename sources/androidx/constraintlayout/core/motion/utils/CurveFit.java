package androidx.constraintlayout.core.motion.utils;

public abstract class CurveFit {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3752a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f3753b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3754c = 2;

    static class Constant extends CurveFit {

        /* renamed from: d  reason: collision with root package name */
        double f3755d;

        /* renamed from: e  reason: collision with root package name */
        double[] f3756e;

        Constant(double d2, double[] dArr) {
            this.f3755d = d2;
            this.f3756e = dArr;
        }

        public double c(double d2, int i2) {
            return this.f3756e[i2];
        }

        public void d(double d2, double[] dArr) {
            double[] dArr2 = this.f3756e;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        public void e(double d2, float[] fArr) {
            int i2 = 0;
            while (true) {
                double[] dArr = this.f3756e;
                if (i2 < dArr.length) {
                    fArr[i2] = (float) dArr[i2];
                    i2++;
                } else {
                    return;
                }
            }
        }

        public double f(double d2, int i2) {
            return 0.0d;
        }

        public void g(double d2, double[] dArr) {
            for (int i2 = 0; i2 < this.f3756e.length; i2++) {
                dArr[i2] = 0.0d;
            }
        }

        public double[] h() {
            return new double[]{this.f3755d};
        }
    }

    public static CurveFit a(int i2, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i2 = 2;
        }
        if (i2 != 0) {
            return i2 != 2 ? new LinearCurveFit(dArr, dArr2) : new Constant(dArr[0], dArr2[0]);
        }
        return new MonotonicCurveFit(dArr, dArr2);
    }

    public static CurveFit b(int[] iArr, double[] dArr, double[][] dArr2) {
        return new ArcCurveFit(iArr, dArr, dArr2);
    }

    public abstract double c(double d2, int i2);

    public abstract void d(double d2, double[] dArr);

    public abstract void e(double d2, float[] fArr);

    public abstract double f(double d2, int i2);

    public abstract void g(double d2, double[] dArr);

    public abstract double[] h();
}
