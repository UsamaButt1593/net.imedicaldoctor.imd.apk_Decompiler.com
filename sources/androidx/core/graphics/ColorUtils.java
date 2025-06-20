package androidx.core.graphics;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.res.CamColor;
import androidx.core.view.ViewCompat;
import java.util.Objects;

public final class ColorUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final double f5813a = 95.047d;

    /* renamed from: b  reason: collision with root package name */
    private static final double f5814b = 100.0d;

    /* renamed from: c  reason: collision with root package name */
    private static final double f5815c = 108.883d;

    /* renamed from: d  reason: collision with root package name */
    private static final double f5816d = 0.008856d;

    /* renamed from: e  reason: collision with root package name */
    private static final double f5817e = 903.3d;

    /* renamed from: f  reason: collision with root package name */
    private static final int f5818f = 10;

    /* renamed from: g  reason: collision with root package name */
    private static final int f5819g = 1;

    /* renamed from: h  reason: collision with root package name */
    private static final ThreadLocal<double[]> f5820h = new ThreadLocal<>();

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static Color a(Color color, Color color2) {
            if (Objects.equals(color.getModel(), color2.getModel())) {
                if (!Objects.equals(color2.getColorSpace(), color.getColorSpace())) {
                    color = color.convert(color2.getColorSpace());
                }
                float[] components = color.getComponents();
                float[] components2 = color2.getComponents();
                float alpha = color.alpha();
                float alpha2 = color2.alpha() * (1.0f - alpha);
                int componentCount = color2.getComponentCount() - 1;
                float f2 = alpha + alpha2;
                components2[componentCount] = f2;
                if (f2 > 0.0f) {
                    alpha /= f2;
                    alpha2 /= f2;
                }
                for (int i2 = 0; i2 < componentCount; i2++) {
                    components2[i2] = (components[i2] * alpha) + (components2[i2] * alpha2);
                }
                return Color.valueOf(components2, color2.getColorSpace());
            }
            throw new IllegalArgumentException("Color models must match (" + color.getModel() + " vs. " + color2.getModel() + ")");
        }
    }

    private ColorUtils() {
    }

    public static double A(@NonNull double[] dArr, @NonNull double[] dArr2) {
        return Math.sqrt(Math.pow(dArr[0] - dArr2[0], 2.0d) + Math.pow(dArr[1] - dArr2[1], 2.0d) + Math.pow(dArr[2] - dArr2[2], 2.0d));
    }

    private static double[] B() {
        ThreadLocal<double[]> threadLocal = f5820h;
        double[] dArr = threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }

    private static double C(double d2) {
        return d2 > f5816d ? Math.pow(d2, 0.3333333333333333d) : ((d2 * f5817e) + 16.0d) / 116.0d;
    }

    @ColorInt
    public static int D(@ColorInt int i2, @IntRange(from = 0, to = 255) int i3) {
        if (i3 >= 0 && i3 <= 255) {
            return (i2 & ViewCompat.x) | (i3 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x008a, code lost:
        r6 = java.lang.Math.round(r6 * 255.0f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00b2, code lost:
        return android.graphics.Color.rgb(z(r1, 0, 255), z(r3, 0, 255), z(r6, 0, 255));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0043, code lost:
        r6 = java.lang.Math.round((r5 + r6) * 255.0f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0058, code lost:
        r6 = java.lang.Math.round((r4 + r6) * 255.0f);
     */
    @androidx.annotation.ColorInt
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(@androidx.annotation.NonNull float[] r6) {
        /*
            r0 = 0
            r1 = r6[r0]
            r2 = 1
            r2 = r6[r2]
            r3 = 2
            r6 = r6[r3]
            r3 = 1073741824(0x40000000, float:2.0)
            float r4 = r6 * r3
            r5 = 1065353216(0x3f800000, float:1.0)
            float r4 = r4 - r5
            float r4 = java.lang.Math.abs(r4)
            float r4 = r5 - r4
            float r4 = r4 * r2
            r2 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 * r4
            float r6 = r6 - r2
            r2 = 1114636288(0x42700000, float:60.0)
            float r2 = r1 / r2
            float r2 = r2 % r3
            float r2 = r2 - r5
            float r2 = java.lang.Math.abs(r2)
            float r5 = r5 - r2
            float r5 = r5 * r4
            int r1 = (int) r1
            int r1 = r1 / 60
            r2 = 1132396544(0x437f0000, float:255.0)
            switch(r1) {
                case 0: goto L_0x0091;
                case 1: goto L_0x007c;
                case 2: goto L_0x006e;
                case 3: goto L_0x0060;
                case 4: goto L_0x004b;
                case 5: goto L_0x0036;
                case 6: goto L_0x0036;
                default: goto L_0x0032;
            }
        L_0x0032:
            r6 = 0
            r1 = 0
            r3 = 0
            goto L_0x00a0
        L_0x0036:
            float r4 = r4 + r6
            float r4 = r4 * r2
            int r1 = java.lang.Math.round(r4)
            float r3 = r6 * r2
            int r3 = java.lang.Math.round(r3)
        L_0x0043:
            float r5 = r5 + r6
            float r5 = r5 * r2
            int r6 = java.lang.Math.round(r5)
            goto L_0x00a0
        L_0x004b:
            float r5 = r5 + r6
            float r5 = r5 * r2
            int r1 = java.lang.Math.round(r5)
            float r3 = r6 * r2
            int r3 = java.lang.Math.round(r3)
        L_0x0058:
            float r4 = r4 + r6
            float r4 = r4 * r2
            int r6 = java.lang.Math.round(r4)
            goto L_0x00a0
        L_0x0060:
            float r1 = r6 * r2
            int r1 = java.lang.Math.round(r1)
            float r5 = r5 + r6
            float r5 = r5 * r2
            int r3 = java.lang.Math.round(r5)
            goto L_0x0058
        L_0x006e:
            float r1 = r6 * r2
            int r1 = java.lang.Math.round(r1)
            float r4 = r4 + r6
            float r4 = r4 * r2
            int r3 = java.lang.Math.round(r4)
            goto L_0x0043
        L_0x007c:
            float r5 = r5 + r6
            float r5 = r5 * r2
            int r1 = java.lang.Math.round(r5)
            float r4 = r4 + r6
            float r4 = r4 * r2
            int r3 = java.lang.Math.round(r4)
        L_0x008a:
            float r6 = r6 * r2
            int r6 = java.lang.Math.round(r6)
            goto L_0x00a0
        L_0x0091:
            float r4 = r4 + r6
            float r4 = r4 * r2
            int r1 = java.lang.Math.round(r4)
            float r5 = r5 + r6
            float r5 = r5 * r2
            int r3 = java.lang.Math.round(r5)
            goto L_0x008a
        L_0x00a0:
            r2 = 255(0xff, float:3.57E-43)
            int r1 = z(r1, r0, r2)
            int r3 = z(r3, r0, r2)
            int r6 = z(r6, r0, r2)
            int r6 = android.graphics.Color.rgb(r1, r3, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.ColorUtils.a(float[]):int");
    }

    @ColorInt
    public static int b(@FloatRange(from = 0.0d, to = 100.0d) double d2, @FloatRange(from = -128.0d, to = 127.0d) double d3, @FloatRange(from = -128.0d, to = 127.0d) double d4) {
        double[] B = B();
        c(d2, d3, d4, B);
        return h(B[0], B[1], B[2]);
    }

    public static void c(@FloatRange(from = 0.0d, to = 100.0d) double d2, @FloatRange(from = -128.0d, to = 127.0d) double d3, @FloatRange(from = -128.0d, to = 127.0d) double d4, @NonNull double[] dArr) {
        double d5 = (d2 + 16.0d) / 116.0d;
        double d6 = (d3 / 500.0d) + d5;
        double d7 = d5 - (d4 / 200.0d);
        double pow = Math.pow(d6, 3.0d);
        if (pow <= f5816d) {
            pow = ((d6 * 116.0d) - 16.0d) / f5817e;
        }
        double pow2 = d2 > 7.9996247999999985d ? Math.pow(d5, 3.0d) : d2 / f5817e;
        double pow3 = Math.pow(d7, 3.0d);
        if (pow3 <= f5816d) {
            pow3 = ((d7 * 116.0d) - 16.0d) / f5817e;
        }
        dArr[0] = pow * f5813a;
        dArr[1] = pow2 * f5814b;
        dArr[2] = pow3 * f5815c;
    }

    @ColorInt
    public static int d(@FloatRange(from = 0.0d, to = 360.0d, toInclusive = false) float f2, @FloatRange(from = 0.0d, to = Double.POSITIVE_INFINITY, toInclusive = false) float f3, @FloatRange(from = 0.0d, to = 100.0d) float f4) {
        return CamColor.q(f2, f3, f4);
    }

    public static void e(@IntRange(from = 0, to = 255) int i2, @IntRange(from = 0, to = 255) int i3, @IntRange(from = 0, to = 255) int i4, @NonNull float[] fArr) {
        float f2;
        float f3;
        float f4 = ((float) i2) / 255.0f;
        float f5 = ((float) i3) / 255.0f;
        float f6 = ((float) i4) / 255.0f;
        float max = Math.max(f4, Math.max(f5, f6));
        float min = Math.min(f4, Math.min(f5, f6));
        float f7 = max - min;
        float f8 = (max + min) / 2.0f;
        if (max == min) {
            f2 = 0.0f;
            f3 = 0.0f;
        } else {
            f2 = max == f4 ? ((f5 - f6) / f7) % 6.0f : max == f5 ? ((f6 - f4) / f7) + 2.0f : 4.0f + ((f4 - f5) / f7);
            f3 = f7 / (1.0f - Math.abs((2.0f * f8) - 1.0f));
        }
        float f9 = (f2 * 60.0f) % 360.0f;
        if (f9 < 0.0f) {
            f9 += 360.0f;
        }
        fArr[0] = y(f9, 0.0f, 360.0f);
        fArr[1] = y(f3, 0.0f, 1.0f);
        fArr[2] = y(f8, 0.0f, 1.0f);
    }

    public static void f(@IntRange(from = 0, to = 255) int i2, @IntRange(from = 0, to = 255) int i3, @IntRange(from = 0, to = 255) int i4, @NonNull double[] dArr) {
        g(i2, i3, i4, dArr);
        i(dArr[0], dArr[1], dArr[2], dArr);
    }

    public static void g(@IntRange(from = 0, to = 255) int i2, @IntRange(from = 0, to = 255) int i3, @IntRange(from = 0, to = 255) int i4, @NonNull double[] dArr) {
        double[] dArr2 = dArr;
        if (dArr2.length == 3) {
            double d2 = ((double) i2) / 255.0d;
            double pow = d2 < 0.04045d ? d2 / 12.92d : Math.pow((d2 + 0.055d) / 1.055d, 2.4d);
            double d3 = ((double) i3) / 255.0d;
            double pow2 = d3 < 0.04045d ? d3 / 12.92d : Math.pow((d3 + 0.055d) / 1.055d, 2.4d);
            double d4 = ((double) i4) / 255.0d;
            double pow3 = d4 < 0.04045d ? d4 / 12.92d : Math.pow((d4 + 0.055d) / 1.055d, 2.4d);
            dArr2[0] = ((0.4124d * pow) + (0.3576d * pow2) + (0.1805d * pow3)) * f5814b;
            dArr2[1] = ((0.2126d * pow) + (0.7152d * pow2) + (0.0722d * pow3)) * f5814b;
            dArr2[2] = ((pow * 0.0193d) + (pow2 * 0.1192d) + (pow3 * 0.9505d)) * f5814b;
            return;
        }
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    @ColorInt
    public static int h(@FloatRange(from = 0.0d, to = 95.047d) double d2, @FloatRange(from = 0.0d, to = 100.0d) double d3, @FloatRange(from = 0.0d, to = 108.883d) double d4) {
        double d5 = (((3.2406d * d2) + (-1.5372d * d3)) + (-0.4986d * d4)) / f5814b;
        double d6 = (((-0.9689d * d2) + (1.8758d * d3)) + (0.0415d * d4)) / f5814b;
        double d7 = (((0.0557d * d2) + (-0.204d * d3)) + (1.057d * d4)) / f5814b;
        return Color.rgb(z((int) Math.round((d5 > 0.0031308d ? (Math.pow(d5, 0.4166666666666667d) * 1.055d) - 0.055d : d5 * 12.92d) * 255.0d), 0, 255), z((int) Math.round((d6 > 0.0031308d ? (Math.pow(d6, 0.4166666666666667d) * 1.055d) - 0.055d : d6 * 12.92d) * 255.0d), 0, 255), z((int) Math.round((d7 > 0.0031308d ? (Math.pow(d7, 0.4166666666666667d) * 1.055d) - 0.055d : 12.92d * d7) * 255.0d), 0, 255));
    }

    public static void i(@FloatRange(from = 0.0d, to = 95.047d) double d2, @FloatRange(from = 0.0d, to = 100.0d) double d3, @FloatRange(from = 0.0d, to = 108.883d) double d4, @NonNull double[] dArr) {
        if (dArr.length == 3) {
            double C = C(d2 / f5813a);
            double C2 = C(d3 / f5814b);
            double C3 = C(d4 / f5815c);
            dArr[0] = Math.max(0.0d, (116.0d * C2) - 16.0d);
            dArr[1] = (C - C2) * 500.0d;
            dArr[2] = (C2 - C3) * 200.0d;
            return;
        }
        throw new IllegalArgumentException("outLab must have a length of 3.");
    }

    @ColorInt
    public static int j(@ColorInt int i2, @ColorInt int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((((float) Color.alpha(i2)) * f3) + (((float) Color.alpha(i3)) * f2)), (int) ((((float) Color.red(i2)) * f3) + (((float) Color.red(i3)) * f2)), (int) ((((float) Color.green(i2)) * f3) + (((float) Color.green(i3)) * f2)), (int) ((((float) Color.blue(i2)) * f3) + (((float) Color.blue(i3)) * f2)));
    }

    public static void k(@NonNull float[] fArr, @NonNull float[] fArr2, @FloatRange(from = 0.0d, to = 1.0d) float f2, @NonNull float[] fArr3) {
        if (fArr3.length == 3) {
            float f3 = 1.0f - f2;
            fArr3[0] = p(fArr[0], fArr2[0], f2);
            fArr3[1] = (fArr[1] * f3) + (fArr2[1] * f2);
            fArr3[2] = (fArr[2] * f3) + (fArr2[2] * f2);
            return;
        }
        throw new IllegalArgumentException("result must have a length of 3.");
    }

    public static void l(@NonNull double[] dArr, @NonNull double[] dArr2, @FloatRange(from = 0.0d, to = 1.0d) double d2, @NonNull double[] dArr3) {
        if (dArr3.length == 3) {
            double d3 = 1.0d - d2;
            dArr3[0] = (dArr[0] * d3) + (dArr2[0] * d2);
            dArr3[1] = (dArr[1] * d3) + (dArr2[1] * d2);
            dArr3[2] = (dArr[2] * d3) + (dArr2[2] * d2);
            return;
        }
        throw new IllegalArgumentException("outResult must have a length of 3.");
    }

    public static double m(@ColorInt int i2, @ColorInt int i3) {
        if (Color.alpha(i3) == 255) {
            if (Color.alpha(i2) < 255) {
                i2 = v(i2, i3);
            }
            double n2 = n(i2) + 0.05d;
            double n3 = n(i3) + 0.05d;
            return Math.max(n2, n3) / Math.min(n2, n3);
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i3));
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public static double n(@ColorInt int i2) {
        double[] B = B();
        t(i2, B);
        return B[1] / f5814b;
    }

    public static int o(@ColorInt int i2, @ColorInt int i3, float f2) {
        int i4 = 255;
        if (Color.alpha(i3) == 255) {
            double d2 = (double) f2;
            if (m(D(i2, 255), i3) < d2) {
                return -1;
            }
            int i5 = 0;
            for (int i6 = 0; i6 <= 10 && i4 - i5 > 1; i6++) {
                int i7 = (i5 + i4) / 2;
                if (m(D(i2, i7), i3) < d2) {
                    i5 = i7;
                } else {
                    i4 = i7;
                }
            }
            return i4;
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i3));
    }

    @VisibleForTesting
    static float p(float f2, float f3, float f4) {
        if (Math.abs(f3 - f2) > 180.0f) {
            if (f3 > f2) {
                f2 += 360.0f;
            } else {
                f3 += 360.0f;
            }
        }
        return (f2 + ((f3 - f2) * f4)) % 360.0f;
    }

    public static void q(@ColorInt int i2, @NonNull float[] fArr) {
        e(Color.red(i2), Color.green(i2), Color.blue(i2), fArr);
    }

    public static void r(@ColorInt int i2, @NonNull double[] dArr) {
        f(Color.red(i2), Color.green(i2), Color.blue(i2), dArr);
    }

    public static void s(@ColorInt int i2, @Size(3) @NonNull float[] fArr) {
        CamColor.n(i2, fArr);
    }

    public static void t(@ColorInt int i2, @NonNull double[] dArr) {
        g(Color.red(i2), Color.green(i2), Color.blue(i2), dArr);
    }

    private static int u(int i2, int i3) {
        return 255 - (((255 - i3) * (255 - i2)) / 255);
    }

    public static int v(@ColorInt int i2, @ColorInt int i3) {
        int alpha = Color.alpha(i3);
        int alpha2 = Color.alpha(i2);
        int u = u(alpha2, alpha);
        return Color.argb(u, x(Color.red(i2), alpha2, Color.red(i3), alpha, u), x(Color.green(i2), alpha2, Color.green(i3), alpha, u), x(Color.blue(i2), alpha2, Color.blue(i3), alpha, u));
    }

    @RequiresApi(26)
    @NonNull
    public static Color w(@NonNull Color color, @NonNull Color color2) {
        return Api26Impl.a(color, color2);
    }

    private static int x(int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            return 0;
        }
        return (((i2 * 255) * i3) + ((i4 * i5) * (255 - i3))) / (i6 * 255);
    }

    private static float y(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : Math.min(f2, f4);
    }

    private static int z(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : Math.min(i2, i4);
    }
}
