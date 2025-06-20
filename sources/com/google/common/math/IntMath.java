package com.google.common.math;

import androidx.media3.extractor.AacUtil;
import com.airbnb.lottie.utils.Utils;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class IntMath {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    static final int f22829a = 1073741824;
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    static final int f22830b = -1257966797;
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    static final byte[] f22831c = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};
    @VisibleForTesting

    /* renamed from: d  reason: collision with root package name */
    static final int[] f22832d = {1, 10, 100, 1000, 10000, AacUtil.f12876f, 1000000, 10000000, 100000000, Utils.f17347a};
    @VisibleForTesting

    /* renamed from: e  reason: collision with root package name */
    static final int[] f22833e = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    static final int f22834f = 46340;

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f22835g = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};
    @VisibleForTesting

    /* renamed from: h  reason: collision with root package name */
    static int[] f22836h = {Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    /* renamed from: com.google.common.math.IntMath$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22837a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                java.math.RoundingMode[] r0 = java.math.RoundingMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22837a = r0
                java.math.RoundingMode r1 = java.math.RoundingMode.UNNECESSARY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22837a     // Catch:{ NoSuchFieldError -> 0x001d }
                java.math.RoundingMode r1 = java.math.RoundingMode.DOWN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f22837a     // Catch:{ NoSuchFieldError -> 0x0028 }
                java.math.RoundingMode r1 = java.math.RoundingMode.FLOOR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f22837a     // Catch:{ NoSuchFieldError -> 0x0033 }
                java.math.RoundingMode r1 = java.math.RoundingMode.UP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f22837a     // Catch:{ NoSuchFieldError -> 0x003e }
                java.math.RoundingMode r1 = java.math.RoundingMode.CEILING     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f22837a     // Catch:{ NoSuchFieldError -> 0x0049 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_DOWN     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f22837a     // Catch:{ NoSuchFieldError -> 0x0054 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_UP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f22837a     // Catch:{ NoSuchFieldError -> 0x0060 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_EVEN     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.IntMath.AnonymousClass1.<clinit>():void");
        }
    }

    private IntMath() {
    }

    public static int a(int i2, int i3) {
        MathPreconditions.e("n", i2);
        MathPreconditions.e("k", i3);
        int i4 = 0;
        Preconditions.m(i3 <= i2, "k (%s) > n (%s)", i3, i2);
        if (i3 > (i2 >> 1)) {
            i3 = i2 - i3;
        }
        int[] iArr = f22836h;
        if (i3 >= iArr.length || i2 > iArr[i3]) {
            return Integer.MAX_VALUE;
        }
        if (i3 == 0) {
            return 1;
        }
        if (i3 == 1) {
            return i2;
        }
        long j2 = 1;
        while (i4 < i3) {
            i4++;
            j2 = (j2 * ((long) (i2 - i4))) / ((long) i4);
        }
        return (int) j2;
    }

    public static int b(int i2) {
        MathPreconditions.h("x", i2);
        if (i2 <= 1073741824) {
            return 1 << (-Integer.numberOfLeadingZeros(i2 - 1));
        }
        throw new ArithmeticException("ceilingPowerOfTwo(" + i2 + ") not representable as an int");
    }

    public static int c(int i2, int i3) {
        long j2 = ((long) i2) + ((long) i3);
        int i4 = (int) j2;
        MathPreconditions.b(j2 == ((long) i4), "checkedAdd", i2, i3);
        return i4;
    }

    public static int d(int i2, int i3) {
        long j2 = ((long) i2) * ((long) i3);
        int i4 = (int) j2;
        MathPreconditions.b(j2 == ((long) i4), "checkedMultiply", i2, i3);
        return i4;
    }

    public static int e(int i2, int i3) {
        MathPreconditions.e("exponent", i3);
        boolean z = false;
        if (i2 == -2) {
            if (i3 < 32) {
                z = true;
            }
            MathPreconditions.b(z, "checkedPow", i2, i3);
            return (i3 & 1) == 0 ? 1 << i3 : -1 << i3;
        } else if (i2 == -1) {
            return (i3 & 1) == 0 ? 1 : -1;
        } else {
            if (i2 == 0) {
                return i3 == 0 ? 1 : 0;
            }
            if (i2 == 1) {
                return 1;
            }
            if (i2 != 2) {
                int i4 = 1;
                while (i3 != 0) {
                    if (i3 == 1) {
                        return d(i4, i2);
                    }
                    if ((i3 & 1) != 0) {
                        i4 = d(i4, i2);
                    }
                    i3 >>= 1;
                    if (i3 > 0) {
                        MathPreconditions.b((-46340 <= i2) & (i2 <= f22834f), "checkedPow", i2, i3);
                        i2 *= i2;
                    }
                }
                return i4;
            }
            if (i3 < 31) {
                z = true;
            }
            MathPreconditions.b(z, "checkedPow", i2, i3);
            return 1 << i3;
        }
    }

    public static int f(int i2, int i3) {
        long j2 = ((long) i2) - ((long) i3);
        int i4 = (int) j2;
        MathPreconditions.b(j2 == ((long) i4), "checkedSubtract", i2, i3);
        return i4;
    }

    public static int g(int i2, int i3, RoundingMode roundingMode) {
        Preconditions.E(roundingMode);
        if (i3 != 0) {
            int i4 = i2 / i3;
            int i5 = i2 - (i3 * i4);
            if (i5 == 0) {
                return i4;
            }
            boolean z = true;
            int i6 = ((i2 ^ i3) >> 31) | 1;
            switch (AnonymousClass1.f22837a[roundingMode.ordinal()]) {
                case 1:
                    if (i5 != 0) {
                        z = false;
                    }
                    MathPreconditions.k(z);
                    return i4;
                case 2:
                    return i4;
                case 3:
                    if (i6 >= 0) {
                        return i4;
                    }
                    break;
                case 4:
                    break;
                case 5:
                    if (i6 <= 0) {
                        return i4;
                    }
                    break;
                case 6:
                case 7:
                case 8:
                    int abs = Math.abs(i5);
                    int abs2 = abs - (Math.abs(i3) - abs);
                    if (abs2 == 0) {
                        if (roundingMode != RoundingMode.HALF_UP) {
                            boolean z2 = roundingMode == RoundingMode.HALF_EVEN;
                            if ((i4 & 1) == 0) {
                                z = false;
                            }
                            if (!z2 || !z) {
                                return i4;
                            }
                        }
                    } else if (abs2 <= 0) {
                        return i4;
                    }
                    break;
                default:
                    throw new AssertionError();
            }
            return i4 + i6;
        }
        throw new ArithmeticException("/ by zero");
    }

    public static int h(int i2) {
        MathPreconditions.e("n", i2);
        int[] iArr = f22835g;
        if (i2 < iArr.length) {
            return iArr[i2];
        }
        return Integer.MAX_VALUE;
    }

    public static int i(int i2) {
        MathPreconditions.h("x", i2);
        return Integer.highestOneBit(i2);
    }

    public static int j(int i2, int i3) {
        MathPreconditions.e("a", i2);
        MathPreconditions.e("b", i3);
        if (i2 == 0) {
            return i3;
        }
        if (i3 == 0) {
            return i2;
        }
        int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i2);
        int i4 = i2 >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Integer.numberOfTrailingZeros(i3);
        int i5 = i3 >> numberOfTrailingZeros2;
        while (i4 != i5) {
            int i6 = i4 - i5;
            int i7 = (i6 >> 31) & i6;
            int i8 = (i6 - i7) - i7;
            i5 += i7;
            i4 = i8 >> Integer.numberOfTrailingZeros(i8);
        }
        return i4 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    public static boolean k(int i2) {
        boolean z = false;
        boolean z2 = i2 > 0;
        if ((i2 & (i2 - 1)) == 0) {
            z = true;
        }
        return z2 & z;
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static boolean l(int i2) {
        return LongMath.m((long) i2);
    }

    @VisibleForTesting
    static int m(int i2, int i3) {
        return (~(~(i2 - i3))) >>> 31;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0027, code lost:
        return r0 + r3;
     */
    @com.google.common.annotations.GwtIncompatible
    @com.google.common.annotations.J2ktIncompatible
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int n(int r3, java.math.RoundingMode r4) {
        /*
            java.lang.String r0 = "x"
            com.google.common.math.MathPreconditions.h(r0, r3)
            int r0 = o(r3)
            int[] r1 = f22832d
            r1 = r1[r0]
            int[] r2 = com.google.common.math.IntMath.AnonymousClass1.f22837a
            int r4 = r4.ordinal()
            r4 = r2[r4]
            switch(r4) {
                case 1: goto L_0x002d;
                case 2: goto L_0x0035;
                case 3: goto L_0x0035;
                case 4: goto L_0x0028;
                case 5: goto L_0x0028;
                case 6: goto L_0x001e;
                case 7: goto L_0x001e;
                case 8: goto L_0x001e;
                default: goto L_0x0018;
            }
        L_0x0018:
            java.lang.AssertionError r3 = new java.lang.AssertionError
            r3.<init>()
            throw r3
        L_0x001e:
            int[] r4 = f22833e
            r4 = r4[r0]
            int r3 = m(r4, r3)
        L_0x0026:
            int r0 = r0 + r3
            return r0
        L_0x0028:
            int r3 = m(r1, r3)
            goto L_0x0026
        L_0x002d:
            if (r3 != r1) goto L_0x0031
            r3 = 1
            goto L_0x0032
        L_0x0031:
            r3 = 0
        L_0x0032:
            com.google.common.math.MathPreconditions.k(r3)
        L_0x0035:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.IntMath.n(int, java.math.RoundingMode):int");
    }

    private static int o(int i2) {
        byte b2 = f22831c[Integer.numberOfLeadingZeros(i2)];
        return b2 - m(i2, f22832d[b2]);
    }

    public static int p(int i2, RoundingMode roundingMode) {
        MathPreconditions.h("x", i2);
        switch (AnonymousClass1.f22837a[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.k(k(i2));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i2 - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i2);
                return (31 - numberOfLeadingZeros) + m(f22830b >>> numberOfLeadingZeros, i2);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i2);
    }

    public static int q(int i2, int i3) {
        return (i2 & i3) + ((i2 ^ i3) >> 1);
    }

    public static int r(int i2, int i3) {
        if (i3 > 0) {
            int i4 = i2 % i3;
            return i4 >= 0 ? i4 : i4 + i3;
        }
        throw new ArithmeticException("Modulus " + i3 + " must be > 0");
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static int s(int i2, int i3) {
        MathPreconditions.e("exponent", i3);
        if (i2 != -2) {
            if (i2 == -1) {
                return (i3 & 1) == 0 ? 1 : -1;
            }
            if (i2 == 0) {
                return i3 == 0 ? 1 : 0;
            }
            if (i2 == 1) {
                return 1;
            }
            if (i2 != 2) {
                int i4 = 1;
                while (i3 != 0) {
                    if (i3 == 1) {
                        return i2 * i4;
                    }
                    i4 *= (i3 & 1) == 0 ? 1 : i2;
                    i2 *= i2;
                    i3 >>= 1;
                }
                return i4;
            } else if (i3 < 32) {
                return 1 << i3;
            } else {
                return 0;
            }
        } else if (i3 < 32) {
            return (i3 & 1) == 0 ? 1 << i3 : -(1 << i3);
        } else {
            return 0;
        }
    }

    public static int t(int i2, int i3) {
        return Ints.z(((long) i2) + ((long) i3));
    }

    public static int u(int i2, int i3) {
        return Ints.z(((long) i2) * ((long) i3));
    }

    public static int v(int i2, int i3) {
        MathPreconditions.e("exponent", i3);
        if (i2 != -2) {
            if (i2 == -1) {
                return (i3 & 1) == 0 ? 1 : -1;
            }
            if (i2 == 0) {
                return i3 == 0 ? 1 : 0;
            }
            if (i2 == 1) {
                return 1;
            }
            if (i2 != 2) {
                int i4 = ((i2 >>> 31) & i3 & 1) + Integer.MAX_VALUE;
                int i5 = 1;
                while (i3 != 0) {
                    if (i3 == 1) {
                        return u(i5, i2);
                    }
                    if ((i3 & 1) != 0) {
                        i5 = u(i5, i2);
                    }
                    i3 >>= 1;
                    if (i3 > 0) {
                        if ((-46340 > i2) || (i2 > f22834f)) {
                            return i4;
                        }
                        i2 *= i2;
                    }
                }
                return i5;
            } else if (i3 >= 31) {
                return Integer.MAX_VALUE;
            } else {
                return 1 << i3;
            }
        } else if (i3 >= 32) {
            return (i3 & 1) + Integer.MAX_VALUE;
        } else {
            return (i3 & 1) == 0 ? 1 << i3 : -1 << i3;
        }
    }

    public static int w(int i2, int i3) {
        return Ints.z(((long) i2) - ((long) i3));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0030, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0022, code lost:
        return r0 + m(r3, r2);
     */
    @com.google.common.annotations.GwtIncompatible
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int x(int r2, java.math.RoundingMode r3) {
        /*
            java.lang.String r0 = "x"
            com.google.common.math.MathPreconditions.e(r0, r2)
            int r0 = y(r2)
            int[] r1 = com.google.common.math.IntMath.AnonymousClass1.f22837a
            int r3 = r3.ordinal()
            r3 = r1[r3]
            switch(r3) {
                case 1: goto L_0x0026;
                case 2: goto L_0x0030;
                case 3: goto L_0x0030;
                case 4: goto L_0x0023;
                case 5: goto L_0x0023;
                case 6: goto L_0x001a;
                case 7: goto L_0x001a;
                case 8: goto L_0x001a;
                default: goto L_0x0014;
            }
        L_0x0014:
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>()
            throw r2
        L_0x001a:
            int r3 = r0 * r0
            int r3 = r3 + r0
        L_0x001d:
            int r2 = m(r3, r2)
            int r0 = r0 + r2
            return r0
        L_0x0023:
            int r3 = r0 * r0
            goto L_0x001d
        L_0x0026:
            int r3 = r0 * r0
            if (r3 != r2) goto L_0x002c
            r2 = 1
            goto L_0x002d
        L_0x002c:
            r2 = 0
        L_0x002d:
            com.google.common.math.MathPreconditions.k(r2)
        L_0x0030:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.IntMath.x(int, java.math.RoundingMode):int");
    }

    private static int y(int i2) {
        return (int) Math.sqrt((double) i2);
    }
}
