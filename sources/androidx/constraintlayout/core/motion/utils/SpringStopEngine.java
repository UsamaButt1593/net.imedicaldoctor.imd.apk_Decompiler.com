package androidx.constraintlayout.core.motion.utils;

import java.io.PrintStream;

public class SpringStopEngine implements StopEngine {

    /* renamed from: l  reason: collision with root package name */
    private static final double f3873l = Double.MAX_VALUE;

    /* renamed from: a  reason: collision with root package name */
    double f3874a = 0.5d;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3875b = false;

    /* renamed from: c  reason: collision with root package name */
    private double f3876c;

    /* renamed from: d  reason: collision with root package name */
    private double f3877d;

    /* renamed from: e  reason: collision with root package name */
    private double f3878e;

    /* renamed from: f  reason: collision with root package name */
    private float f3879f;

    /* renamed from: g  reason: collision with root package name */
    private float f3880g;

    /* renamed from: h  reason: collision with root package name */
    private float f3881h;

    /* renamed from: i  reason: collision with root package name */
    private float f3882i;

    /* renamed from: j  reason: collision with root package name */
    private float f3883j;

    /* renamed from: k  reason: collision with root package name */
    private int f3884k = 0;

    private void e(double d2) {
        double d3 = this.f3876c;
        double d4 = this.f3874a;
        int sqrt = (int) ((9.0d / ((Math.sqrt(d3 / ((double) this.f3882i)) * d2) * 4.0d)) + 1.0d);
        double d5 = d2 / ((double) sqrt);
        int i2 = 0;
        while (i2 < sqrt) {
            float f2 = this.f3880g;
            double d6 = this.f3877d;
            float f3 = this.f3881h;
            double d7 = d3;
            float f4 = this.f3882i;
            double d8 = d4;
            double d9 = ((double) f3) + ((((((-d3) * (((double) f2) - d6)) - (((double) f3) * d4)) / ((double) f4)) * d5) / 2.0d);
            double d10 = ((((-((((double) f2) + ((d5 * d9) / 2.0d)) - d6)) * d7) - (d9 * d8)) / ((double) f4)) * d5;
            float f5 = (float) (((double) f3) + d10);
            this.f3881h = f5;
            float f6 = (float) (((double) f2) + ((((double) f3) + (d10 / 2.0d)) * d5));
            this.f3880g = f6;
            int i3 = this.f3884k;
            if (i3 > 0) {
                if (f6 < 0.0f && (i3 & 1) == 1) {
                    this.f3880g = -f6;
                    this.f3881h = -f5;
                }
                float f7 = this.f3880g;
                if (f7 > 1.0f && (i3 & 2) == 2) {
                    this.f3880g = 2.0f - f7;
                    this.f3881h = -this.f3881h;
                }
            }
            i2++;
            d3 = d7;
            d4 = d8;
        }
    }

    public float a() {
        return 0.0f;
    }

    public String b(String str, float f2) {
        return null;
    }

    public float c(float f2) {
        return this.f3881h;
    }

    public boolean d() {
        double d2 = ((double) this.f3880g) - this.f3877d;
        double d3 = this.f3876c;
        double d4 = (double) this.f3881h;
        return Math.sqrt((((d4 * d4) * ((double) this.f3882i)) + ((d3 * d2) * d2)) / d3) <= ((double) this.f3883j);
    }

    public float f() {
        double d2 = this.f3876c;
        return ((float) (((-d2) * (((double) this.f3880g) - this.f3877d)) - (this.f3874a * ((double) this.f3881h)))) / this.f3882i;
    }

    /* access modifiers changed from: package-private */
    public void g(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        PrintStream printStream = System.out;
        printStream.println((".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "() ") + str);
    }

    public float getInterpolation(float f2) {
        e((double) (f2 - this.f3879f));
        this.f3879f = f2;
        return this.f3880g;
    }

    public void h(float f2, float f3, float f4, float f5, float f6, float f7, float f8, int i2) {
        this.f3877d = (double) f3;
        this.f3874a = (double) f7;
        this.f3875b = false;
        this.f3880g = f2;
        this.f3878e = (double) f4;
        this.f3876c = (double) f6;
        this.f3882i = f5;
        this.f3883j = f8;
        this.f3884k = i2;
        this.f3879f = 0.0f;
    }
}
