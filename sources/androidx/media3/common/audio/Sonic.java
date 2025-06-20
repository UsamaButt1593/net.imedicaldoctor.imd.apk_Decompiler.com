package androidx.media3.common.audio;

import androidx.media3.common.util.Assertions;
import java.nio.ShortBuffer;
import java.util.Arrays;

final class Sonic {
    private static final int w = 65;
    private static final int x = 400;
    private static final int y = 4000;
    private static final int z = 2;

    /* renamed from: a  reason: collision with root package name */
    private final int f9400a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9401b;

    /* renamed from: c  reason: collision with root package name */
    private final float f9402c;

    /* renamed from: d  reason: collision with root package name */
    private final float f9403d;

    /* renamed from: e  reason: collision with root package name */
    private final float f9404e;

    /* renamed from: f  reason: collision with root package name */
    private final int f9405f;

    /* renamed from: g  reason: collision with root package name */
    private final int f9406g;

    /* renamed from: h  reason: collision with root package name */
    private final int f9407h;

    /* renamed from: i  reason: collision with root package name */
    private final short[] f9408i;

    /* renamed from: j  reason: collision with root package name */
    private short[] f9409j;

    /* renamed from: k  reason: collision with root package name */
    private int f9410k;

    /* renamed from: l  reason: collision with root package name */
    private short[] f9411l;

    /* renamed from: m  reason: collision with root package name */
    private int f9412m;

    /* renamed from: n  reason: collision with root package name */
    private short[] f9413n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;

    public Sonic(int i2, int i3, float f2, float f3, int i4) {
        this.f9400a = i2;
        this.f9401b = i3;
        this.f9402c = f2;
        this.f9403d = f3;
        this.f9404e = ((float) i2) / ((float) i4);
        this.f9405f = i2 / 400;
        int i5 = i2 / 65;
        this.f9406g = i5;
        int i6 = i5 * 2;
        this.f9407h = i6;
        this.f9408i = new short[i6];
        this.f9409j = new short[(i6 * i3)];
        this.f9411l = new short[(i6 * i3)];
        this.f9413n = new short[(i6 * i3)];
    }

    private void a(float f2, int i2) {
        int i3;
        int i4;
        if (this.f9412m != i2) {
            int i5 = this.f9400a;
            int i6 = (int) (((float) i5) / f2);
            while (true) {
                if (i6 <= 16384 && i5 <= 16384) {
                    break;
                }
                i6 /= 2;
                i5 /= 2;
            }
            o(i2);
            int i7 = 0;
            while (true) {
                int i8 = this.o;
                boolean z2 = true;
                if (i7 < i8 - 1) {
                    while (true) {
                        i3 = this.p;
                        int i9 = (i3 + 1) * i6;
                        i4 = this.q;
                        if (i9 <= i4 * i5) {
                            break;
                        }
                        this.f9411l = f(this.f9411l, this.f9412m, 1);
                        int i10 = 0;
                        while (true) {
                            int i11 = this.f9401b;
                            if (i10 >= i11) {
                                break;
                            }
                            this.f9411l[(this.f9412m * i11) + i10] = n(this.f9413n, (i11 * i7) + i10, i5, i6);
                            i10++;
                        }
                        this.q++;
                        this.f9412m++;
                    }
                    int i12 = i3 + 1;
                    this.p = i12;
                    if (i12 == i5) {
                        this.p = 0;
                        if (i4 != i6) {
                            z2 = false;
                        }
                        Assertions.i(z2);
                        this.q = 0;
                    }
                    i7++;
                } else {
                    u(i8 - 1);
                    return;
                }
            }
        }
    }

    private void b(float f2) {
        int w2;
        int i2 = this.f9410k;
        if (i2 >= this.f9407h) {
            int i3 = 0;
            do {
                if (this.r > 0) {
                    w2 = c(i3);
                } else {
                    int g2 = g(this.f9409j, i3);
                    int i4 = (((double) f2) > 1.0d ? 1 : (((double) f2) == 1.0d ? 0 : -1));
                    short[] sArr = this.f9409j;
                    w2 = i4 > 0 ? g2 + w(sArr, i3, f2, g2) : m(sArr, i3, f2, g2);
                }
                i3 += w2;
            } while (this.f9407h + i3 <= i2);
            v(i3);
        }
    }

    private int c(int i2) {
        int min = Math.min(this.f9407h, this.r);
        d(this.f9409j, i2, min);
        this.r -= min;
        return min;
    }

    private void d(short[] sArr, int i2, int i3) {
        short[] f2 = f(this.f9411l, this.f9412m, i3);
        this.f9411l = f2;
        int i4 = this.f9401b;
        System.arraycopy(sArr, i2 * i4, f2, this.f9412m * i4, i4 * i3);
        this.f9412m += i3;
    }

    private void e(short[] sArr, int i2, int i3) {
        int i4 = this.f9407h / i3;
        int i5 = this.f9401b;
        int i6 = i3 * i5;
        int i7 = i2 * i5;
        for (int i8 = 0; i8 < i4; i8++) {
            int i9 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                i9 += sArr[(i8 * i6) + i7 + i10];
            }
            this.f9408i[i8] = (short) (i9 / i6);
        }
    }

    private short[] f(short[] sArr, int i2, int i3) {
        int length = sArr.length;
        int i4 = this.f9401b;
        int i5 = length / i4;
        return i2 + i3 <= i5 ? sArr : Arrays.copyOf(sArr, (((i5 * 3) / 2) + i3) * i4);
    }

    private int g(short[] sArr, int i2) {
        int i3;
        int i4 = this.f9400a;
        int i5 = i4 > y ? i4 / y : 1;
        if (this.f9401b == 1 && i5 == 1) {
            i3 = h(sArr, i2, this.f9405f, this.f9406g);
        } else {
            e(sArr, i2, i5);
            int h2 = h(this.f9408i, 0, this.f9405f / i5, this.f9406g / i5);
            if (i5 != 1) {
                int i6 = h2 * i5;
                int i7 = i5 * 4;
                int i8 = i6 - i7;
                int i9 = i6 + i7;
                int i10 = this.f9405f;
                if (i8 < i10) {
                    i8 = i10;
                }
                int i11 = this.f9406g;
                if (i9 > i11) {
                    i9 = i11;
                }
                if (this.f9401b == 1) {
                    i3 = h(sArr, i2, i8, i9);
                } else {
                    e(sArr, i2, 1);
                    i3 = h(this.f9408i, 0, i8, i9);
                }
            } else {
                i3 = h2;
            }
        }
        int i12 = q(this.u, this.v) ? this.s : i3;
        this.t = this.u;
        this.s = i3;
        return i12;
    }

    private int h(short[] sArr, int i2, int i3, int i4) {
        int i5 = i2 * this.f9401b;
        int i6 = 255;
        int i7 = 1;
        int i8 = 0;
        int i9 = 0;
        while (i3 <= i4) {
            int i10 = 0;
            for (int i11 = 0; i11 < i3; i11++) {
                i10 += Math.abs(sArr[i5 + i11] - sArr[(i5 + i3) + i11]);
            }
            if (i10 * i8 < i7 * i3) {
                i8 = i3;
                i7 = i10;
            }
            if (i10 * i6 > i9 * i3) {
                i6 = i3;
                i9 = i10;
            }
            i3++;
        }
        this.u = i7 / i8;
        this.v = i9 / i6;
        return i8;
    }

    private int m(short[] sArr, int i2, float f2, int i3) {
        int i4;
        if (f2 < 0.5f) {
            i4 = (int) ((((float) i3) * f2) / (1.0f - f2));
        } else {
            this.r = (int) ((((float) i3) * ((2.0f * f2) - 1.0f)) / (1.0f - f2));
            i4 = i3;
        }
        int i5 = i3 + i4;
        short[] f3 = f(this.f9411l, this.f9412m, i5);
        this.f9411l = f3;
        int i6 = this.f9401b;
        System.arraycopy(sArr, i2 * i6, f3, this.f9412m * i6, i6 * i3);
        p(i4, this.f9401b, this.f9411l, this.f9412m + i3, sArr, i2 + i3, sArr, i2);
        this.f9412m += i5;
        return i4;
    }

    private short n(short[] sArr, int i2, int i3, int i4) {
        short s2 = sArr[i2];
        short s3 = sArr[i2 + this.f9401b];
        int i5 = this.q * i3;
        int i6 = this.p;
        int i7 = i6 * i4;
        int i8 = (i6 + 1) * i4;
        int i9 = i8 - i5;
        int i10 = i8 - i7;
        return (short) (((s2 * i9) + ((i10 - i9) * s3)) / i10);
    }

    private void o(int i2) {
        int i3 = this.f9412m - i2;
        short[] f2 = f(this.f9413n, this.o, i3);
        this.f9413n = f2;
        short[] sArr = this.f9411l;
        int i4 = this.f9401b;
        System.arraycopy(sArr, i2 * i4, f2, this.o * i4, i4 * i3);
        this.f9412m = i2;
        this.o += i3;
    }

    private static void p(int i2, int i3, short[] sArr, int i4, short[] sArr2, int i5, short[] sArr3, int i6) {
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = (i4 * i3) + i7;
            int i9 = (i6 * i3) + i7;
            int i10 = (i5 * i3) + i7;
            for (int i11 = 0; i11 < i2; i11++) {
                sArr[i8] = (short) (((sArr2[i10] * (i2 - i11)) + (sArr3[i9] * i11)) / i2);
                i8 += i3;
                i10 += i3;
                i9 += i3;
            }
        }
    }

    private boolean q(int i2, int i3) {
        return i2 != 0 && this.s != 0 && i3 <= i2 * 3 && i2 * 2 > this.t * 3;
    }

    private void r() {
        int i2 = this.f9412m;
        float f2 = this.f9402c;
        float f3 = this.f9403d;
        float f4 = f2 / f3;
        float f5 = this.f9404e * f3;
        double d2 = (double) f4;
        if (d2 > 1.00001d || d2 < 0.99999d) {
            b(f4);
        } else {
            d(this.f9409j, 0, this.f9410k);
            this.f9410k = 0;
        }
        if (f5 != 1.0f) {
            a(f5, i2);
        }
    }

    private void u(int i2) {
        if (i2 != 0) {
            short[] sArr = this.f9413n;
            int i3 = this.f9401b;
            System.arraycopy(sArr, i2 * i3, sArr, 0, (this.o - i2) * i3);
            this.o -= i2;
        }
    }

    private void v(int i2) {
        int i3 = this.f9410k - i2;
        short[] sArr = this.f9409j;
        int i4 = this.f9401b;
        System.arraycopy(sArr, i2 * i4, sArr, 0, i4 * i3);
        this.f9410k = i3;
    }

    private int w(short[] sArr, int i2, float f2, int i3) {
        int i4;
        if (f2 >= 2.0f) {
            i4 = (int) (((float) i3) / (f2 - 1.0f));
        } else {
            this.r = (int) ((((float) i3) * (2.0f - f2)) / (f2 - 1.0f));
            i4 = i3;
        }
        short[] f3 = f(this.f9411l, this.f9412m, i4);
        this.f9411l = f3;
        p(i4, this.f9401b, f3, this.f9412m, sArr, i2, sArr, i2 + i3);
        this.f9412m += i4;
        return i4;
    }

    public void i() {
        this.f9410k = 0;
        this.f9412m = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
    }

    public void j(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.f9401b, this.f9412m);
        shortBuffer.put(this.f9411l, 0, this.f9401b * min);
        int i2 = this.f9412m - min;
        this.f9412m = i2;
        short[] sArr = this.f9411l;
        int i3 = this.f9401b;
        System.arraycopy(sArr, min * i3, sArr, 0, i2 * i3);
    }

    public int k() {
        return this.f9412m * this.f9401b * 2;
    }

    public int l() {
        return this.f9410k * this.f9401b * 2;
    }

    public void s() {
        int i2;
        int i3 = this.f9410k;
        float f2 = this.f9402c;
        float f3 = this.f9403d;
        int i4 = this.f9412m + ((int) ((((((float) i3) / (f2 / f3)) + ((float) this.o)) / (this.f9404e * f3)) + 0.5f));
        this.f9409j = f(this.f9409j, i3, (this.f9407h * 2) + i3);
        int i5 = 0;
        while (true) {
            i2 = this.f9407h;
            int i6 = this.f9401b;
            if (i5 >= i2 * 2 * i6) {
                break;
            }
            this.f9409j[(i6 * i3) + i5] = 0;
            i5++;
        }
        this.f9410k += i2 * 2;
        r();
        if (this.f9412m > i4) {
            this.f9412m = i4;
        }
        this.f9410k = 0;
        this.r = 0;
        this.o = 0;
    }

    public void t(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i2 = this.f9401b;
        int i3 = remaining / i2;
        short[] f2 = f(this.f9409j, this.f9410k, i3);
        this.f9409j = f2;
        shortBuffer.get(f2, this.f9410k * this.f9401b, ((i2 * i3) * 2) / 2);
        this.f9410k += i3;
        r();
    }
}
