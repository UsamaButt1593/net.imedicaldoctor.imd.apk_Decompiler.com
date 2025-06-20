package androidx.constraintlayout.core.motion.utils;

import org.apache.commons.lang3.StringUtils;

public class StopLogicEngine implements StopEngine {
    private static final float p = 1.0E-5f;

    /* renamed from: a  reason: collision with root package name */
    private float f3885a;

    /* renamed from: b  reason: collision with root package name */
    private float f3886b;

    /* renamed from: c  reason: collision with root package name */
    private float f3887c;

    /* renamed from: d  reason: collision with root package name */
    private float f3888d;

    /* renamed from: e  reason: collision with root package name */
    private float f3889e;

    /* renamed from: f  reason: collision with root package name */
    private float f3890f;

    /* renamed from: g  reason: collision with root package name */
    private float f3891g;

    /* renamed from: h  reason: collision with root package name */
    private float f3892h;

    /* renamed from: i  reason: collision with root package name */
    private float f3893i;

    /* renamed from: j  reason: collision with root package name */
    private int f3894j;

    /* renamed from: k  reason: collision with root package name */
    private String f3895k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f3896l = false;

    /* renamed from: m  reason: collision with root package name */
    private float f3897m;

    /* renamed from: n  reason: collision with root package name */
    private float f3898n;
    private boolean o = false;

    private float e(float f2) {
        this.o = false;
        float f3 = this.f3888d;
        if (f2 <= f3) {
            float f4 = this.f3885a;
            return (f4 * f2) + ((((this.f3886b - f4) * f2) * f2) / (f3 * 2.0f));
        }
        int i2 = this.f3894j;
        if (i2 == 1) {
            return this.f3891g;
        }
        float f5 = f2 - f3;
        float f6 = this.f3889e;
        if (f5 < f6) {
            float f7 = this.f3891g;
            float f8 = this.f3886b;
            return f7 + (f8 * f5) + ((((this.f3887c - f8) * f5) * f5) / (f6 * 2.0f));
        } else if (i2 == 2) {
            return this.f3892h;
        } else {
            float f9 = f5 - f6;
            float f10 = this.f3890f;
            if (f9 <= f10) {
                float f11 = this.f3892h;
                float f12 = this.f3887c;
                return (f11 + (f12 * f9)) - (((f12 * f9) * f9) / (f10 * 2.0f));
            }
            this.o = true;
            return this.f3893i;
        }
    }

    private void g(float f2, float f3, float f4, float f5, float f6) {
        this.o = false;
        if (f2 == 0.0f) {
            f2 = 1.0E-4f;
        }
        this.f3885a = f2;
        float f7 = f2 / f4;
        float f8 = (f7 * f2) / 2.0f;
        if (f2 < 0.0f) {
            float sqrt = (float) Math.sqrt((double) ((f3 - ((((-f2) / f4) * f2) / 2.0f)) * f4));
            if (sqrt < f5) {
                this.f3895k = "backward accelerate, decelerate";
                this.f3894j = 2;
                this.f3885a = f2;
                this.f3886b = sqrt;
                this.f3887c = 0.0f;
                float f9 = (sqrt - f2) / f4;
                this.f3888d = f9;
                this.f3889e = sqrt / f4;
                this.f3891g = ((f2 + sqrt) * f9) / 2.0f;
                this.f3892h = f3;
                this.f3893i = f3;
                return;
            }
            this.f3895k = "backward accelerate cruse decelerate";
            this.f3894j = 3;
            this.f3885a = f2;
            this.f3886b = f5;
            this.f3887c = f5;
            float f10 = (f5 - f2) / f4;
            this.f3888d = f10;
            float f11 = f5 / f4;
            this.f3890f = f11;
            float f12 = ((f2 + f5) * f10) / 2.0f;
            float f13 = (f11 * f5) / 2.0f;
            this.f3889e = ((f3 - f12) - f13) / f5;
            this.f3891g = f12;
            this.f3892h = f3 - f13;
            this.f3893i = f3;
        } else if (f8 >= f3) {
            this.f3895k = "hard stop";
            this.f3894j = 1;
            this.f3885a = f2;
            this.f3886b = 0.0f;
            this.f3891g = f3;
            this.f3888d = (2.0f * f3) / f2;
        } else {
            float f14 = f3 - f8;
            float f15 = f14 / f2;
            if (f15 + f7 < f6) {
                this.f3895k = "cruse decelerate";
                this.f3894j = 2;
                this.f3885a = f2;
                this.f3886b = f2;
                this.f3887c = 0.0f;
                this.f3891g = f14;
                this.f3892h = f3;
                this.f3888d = f15;
                this.f3889e = f7;
                return;
            }
            float sqrt2 = (float) Math.sqrt((double) ((f4 * f3) + ((f2 * f2) / 2.0f)));
            float f16 = (sqrt2 - f2) / f4;
            this.f3888d = f16;
            float f17 = sqrt2 / f4;
            this.f3889e = f17;
            if (sqrt2 < f5) {
                this.f3895k = "accelerate decelerate";
                this.f3894j = 2;
                this.f3885a = f2;
                this.f3886b = sqrt2;
                this.f3887c = 0.0f;
                this.f3888d = f16;
                this.f3889e = f17;
                this.f3891g = ((f2 + sqrt2) * f16) / 2.0f;
                this.f3892h = f3;
                return;
            }
            this.f3895k = "accelerate cruse decelerate";
            this.f3894j = 3;
            this.f3885a = f2;
            this.f3886b = f5;
            this.f3887c = f5;
            float f18 = (f5 - f2) / f4;
            this.f3888d = f18;
            float f19 = f5 / f4;
            this.f3890f = f19;
            float f20 = ((f2 + f5) * f18) / 2.0f;
            float f21 = (f19 * f5) / 2.0f;
            this.f3889e = ((f3 - f20) - f21) / f5;
            this.f3891g = f20;
            this.f3892h = f3 - f21;
            this.f3893i = f3;
        }
    }

    public float a() {
        return this.f3896l ? -c(this.f3898n) : c(this.f3898n);
    }

    public String b(String str, float f2) {
        StringBuilder sb;
        String str2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str + " ===== " + this.f3895k + StringUtils.LF);
        sb2.append(str);
        sb2.append(this.f3896l ? "backwards" : "forward ");
        sb2.append(" time = ");
        sb2.append(f2);
        sb2.append("  stages ");
        sb2.append(this.f3894j);
        sb2.append(StringUtils.LF);
        String str3 = sb2.toString() + str + " dur " + this.f3888d + " vel " + this.f3885a + " pos " + this.f3891g + StringUtils.LF;
        if (this.f3894j > 1) {
            str3 = str3 + str + " dur " + this.f3889e + " vel " + this.f3886b + " pos " + this.f3892h + StringUtils.LF;
        }
        if (this.f3894j > 2) {
            str3 = str3 + str + " dur " + this.f3890f + " vel " + this.f3887c + " pos " + this.f3893i + StringUtils.LF;
        }
        float f3 = this.f3888d;
        if (f2 <= f3) {
            sb = new StringBuilder();
            sb.append(str3);
            sb.append(str);
            str2 = "stage 0\n";
        } else {
            int i2 = this.f3894j;
            if (i2 == 1) {
                sb = new StringBuilder();
                sb.append(str3);
                sb.append(str);
                str2 = "end stage 0\n";
            } else {
                float f4 = f2 - f3;
                float f5 = this.f3889e;
                if (f4 < f5) {
                    sb = new StringBuilder();
                    sb.append(str3);
                    sb.append(str);
                    str2 = " stage 1\n";
                } else if (i2 == 2) {
                    sb = new StringBuilder();
                    sb.append(str3);
                    sb.append(str);
                    str2 = "end stage 1\n";
                } else if (f4 - f5 < this.f3890f) {
                    sb = new StringBuilder();
                    sb.append(str3);
                    sb.append(str);
                    str2 = " stage 2\n";
                } else {
                    sb = new StringBuilder();
                    sb.append(str3);
                    sb.append(str);
                    str2 = " end stage 2\n";
                }
            }
        }
        sb.append(str2);
        return sb.toString();
    }

    public float c(float f2) {
        float f3 = this.f3888d;
        if (f2 <= f3) {
            float f4 = this.f3885a;
            return f4 + (((this.f3886b - f4) * f2) / f3);
        }
        int i2 = this.f3894j;
        if (i2 == 1) {
            return 0.0f;
        }
        float f5 = f2 - f3;
        float f6 = this.f3889e;
        if (f5 < f6) {
            float f7 = this.f3886b;
            return f7 + (((this.f3887c - f7) * f5) / f6);
        } else if (i2 == 2) {
            return this.f3892h;
        } else {
            float f8 = f5 - f6;
            float f9 = this.f3890f;
            if (f8 >= f9) {
                return this.f3893i;
            }
            float f10 = this.f3887c;
            return f10 - ((f8 * f10) / f9);
        }
    }

    public boolean d() {
        return a() < p && Math.abs(this.f3893i - this.f3898n) < p;
    }

    public void f(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8;
        StopLogicEngine stopLogicEngine;
        float f9;
        boolean z = false;
        this.o = false;
        this.f3897m = f2;
        if (f2 > f3) {
            z = true;
        }
        this.f3896l = z;
        if (z) {
            f9 = -f4;
            f8 = f2 - f3;
            stopLogicEngine = this;
        } else {
            f8 = f3 - f2;
            stopLogicEngine = this;
            f9 = f4;
        }
        stopLogicEngine.g(f9, f8, f6, f7, f5);
    }

    public float getInterpolation(float f2) {
        float e2 = e(f2);
        this.f3898n = f2;
        return this.f3896l ? this.f3897m - e2 : this.f3897m + e2;
    }
}
