package com.google.common.math;

import androidx.media3.common.C;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import androidx.media3.extractor.ts.TsExtractor;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import com.google.common.primitives.UnsignedLongs;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.math.RoundingMode;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.httpclient.HttpStatus;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class LongMath {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    static final long f22846a = 4611686018427387904L;
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    static final long f22847b = -5402926248376769404L;
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    static final byte[] f22848c = {19, 18, 18, 18, 18, 17, 17, 17, 16, 16, 16, 15, 15, 15, 15, 14, 14, 14, 13, 13, 13, 12, 12, 12, 12, 11, 11, 11, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};
    @GwtIncompatible
    @J2ktIncompatible
    @VisibleForTesting

    /* renamed from: d  reason: collision with root package name */
    static final long[] f22849d = {1, 10, 100, 1000, 10000, SilenceSkippingAudioProcessor.A, 1000000, 10000000, 100000000, C.f9093k, 10000000000L, 100000000000L, MediaPeriodQueue.o, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};
    @GwtIncompatible
    @J2ktIncompatible
    @VisibleForTesting

    /* renamed from: e  reason: collision with root package name */
    static final long[] f22850e = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    static final long f22851f = 3037000499L;

    /* renamed from: g  reason: collision with root package name */
    static final long[] f22852g = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};

    /* renamed from: h  reason: collision with root package name */
    static final int[] f22853h = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, TIFFConstants.Z, HttpStatus.SC_PARTIAL_CONTENT, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};
    @VisibleForTesting

    /* renamed from: i  reason: collision with root package name */
    static final int[] f22854i = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, MetaDo.O, 684, HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE, TIFFConstants.D0, 214, 169, TsExtractor.W, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};

    /* renamed from: j  reason: collision with root package name */
    private static final int f22855j = -545925251;

    /* renamed from: k  reason: collision with root package name */
    private static final long[][] f22856k = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};

    /* renamed from: com.google.common.math.LongMath$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22857a;

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
                f22857a = r0
                java.math.RoundingMode r1 = java.math.RoundingMode.UNNECESSARY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22857a     // Catch:{ NoSuchFieldError -> 0x001d }
                java.math.RoundingMode r1 = java.math.RoundingMode.DOWN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f22857a     // Catch:{ NoSuchFieldError -> 0x0028 }
                java.math.RoundingMode r1 = java.math.RoundingMode.FLOOR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f22857a     // Catch:{ NoSuchFieldError -> 0x0033 }
                java.math.RoundingMode r1 = java.math.RoundingMode.UP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f22857a     // Catch:{ NoSuchFieldError -> 0x003e }
                java.math.RoundingMode r1 = java.math.RoundingMode.CEILING     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f22857a     // Catch:{ NoSuchFieldError -> 0x0049 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_DOWN     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f22857a     // Catch:{ NoSuchFieldError -> 0x0054 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_UP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f22857a     // Catch:{ NoSuchFieldError -> 0x0060 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_EVEN     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.LongMath.AnonymousClass1.<clinit>():void");
        }
    }

    private enum MillerRabinTester {
        SMALL {
            /* access modifiers changed from: package-private */
            public long b(long j2, long j3, long j4) {
                return (j2 * j3) % j4;
            }

            /* access modifiers changed from: package-private */
            public long e(long j2, long j3) {
                return (j2 * j2) % j3;
            }
        },
        LARGE {
            private long h(long j2, long j3, long j4) {
                int i2 = (j2 > (j4 - j3) ? 1 : (j2 == (j4 - j3) ? 0 : -1));
                long j5 = j2 + j3;
                return i2 >= 0 ? j5 - j4 : j5;
            }

            private long i(long j2, long j3) {
                int i2 = 32;
                do {
                    int min = Math.min(i2, Long.numberOfLeadingZeros(j2));
                    j2 = UnsignedLongs.k(j2 << min, j3);
                    i2 -= min;
                } while (i2 > 0);
                return j2;
            }

            /* access modifiers changed from: package-private */
            public long b(long j2, long j3, long j4) {
                long j5 = j4;
                long j6 = j2 >>> 32;
                long j7 = j3 >>> 32;
                long j8 = j2 & InternalZipConstants.f30717k;
                long j9 = j3 & InternalZipConstants.f30717k;
                long i2 = i(j6 * j7, j5) + (j6 * j9);
                if (i2 < 0) {
                    i2 = UnsignedLongs.k(i2, j5);
                }
                Long.signum(j8);
                return h(i(i2 + (j7 * j8), j5), UnsignedLongs.k(j8 * j9, j5), j4);
            }

            /* access modifiers changed from: package-private */
            public long e(long j2, long j3) {
                long j4 = j2 >>> 32;
                long j5 = j2 & InternalZipConstants.f30717k;
                long i2 = i(j4 * j4, j3);
                long j6 = j4 * j5 * 2;
                if (j6 < 0) {
                    j6 = UnsignedLongs.k(j6, j3);
                }
                return h(i(i2 + j6, j3), UnsignedLongs.k(j5 * j5, j3), j3);
            }
        };

        private long c(long j2, long j3, long j4) {
            long j5 = 1;
            while (j3 != 0) {
                if ((j3 & 1) != 0) {
                    j5 = b(j5, j2, j4);
                }
                j2 = e(j2, j4);
                j3 >>= 1;
            }
            return j5;
        }

        static boolean f(long j2, long j3) {
            return (j3 <= LongMath.f22851f ? SMALL : LARGE).g(j2, j3);
        }

        private boolean g(long j2, long j3) {
            long j4 = j3;
            long j5 = j4 - 1;
            int numberOfTrailingZeros = Long.numberOfTrailingZeros(j5);
            long j6 = j5 >> numberOfTrailingZeros;
            long j7 = j2 % j4;
            if (j7 == 0) {
                return true;
            }
            long c2 = c(j7, j6, j3);
            if (c2 == 1) {
                return true;
            }
            int i2 = 0;
            while (c2 != j5) {
                i2++;
                if (i2 == numberOfTrailingZeros) {
                    return false;
                }
                c2 = e(c2, j4);
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public abstract long b(long j2, long j3, long j4);

        /* access modifiers changed from: package-private */
        public abstract long e(long j2, long j3);
    }

    private LongMath() {
    }

    public static long A(long j2, long j3) {
        long j4 = j2 - j3;
        boolean z = false;
        boolean z2 = (j3 ^ j2) >= 0;
        if ((j2 ^ j4) >= 0) {
            z = true;
        }
        return z2 | z ? j4 : ((j4 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static long B(long j2, RoundingMode roundingMode) {
        MathPreconditions.f("x", j2);
        if (i(j2)) {
            return (long) IntMath.x((int) j2, roundingMode);
        }
        long sqrt = (long) Math.sqrt((double) j2);
        long j3 = sqrt * sqrt;
        boolean z = false;
        switch (AnonymousClass1.f22857a[roundingMode.ordinal()]) {
            case 1:
                if (j3 == j2) {
                    z = true;
                }
                MathPreconditions.k(z);
                return sqrt;
            case 2:
            case 3:
                return j2 < j3 ? sqrt - 1 : sqrt;
            case 4:
            case 5:
                return j2 > j3 ? sqrt + 1 : sqrt;
            case 6:
            case 7:
            case 8:
                if (j2 < j3) {
                    z = true;
                }
                long j4 = sqrt - (z ? 1 : 0);
                return j4 + ((long) n((j4 * j4) + j4, j2));
            default:
                throw new AssertionError();
        }
    }

    public static long a(int i2, int i3) {
        MathPreconditions.e("n", i2);
        MathPreconditions.e("k", i3);
        Preconditions.m(i3 <= i2, "k (%s) > n (%s)", i3, i2);
        if (i3 > (i2 >> 1)) {
            i3 = i2 - i3;
        }
        long j2 = 1;
        if (i3 == 0) {
            return 1;
        }
        if (i3 == 1) {
            return (long) i2;
        }
        long[] jArr = f22852g;
        if (i2 < jArr.length) {
            return jArr[i2] / (jArr[i3] * jArr[i2 - i3]);
        }
        int[] iArr = f22853h;
        if (i3 >= iArr.length || i2 > iArr[i3]) {
            return Long.MAX_VALUE;
        }
        int[] iArr2 = f22854i;
        if (i3 >= iArr2.length || i2 > iArr2[i3]) {
            long j3 = (long) i2;
            int q = q(j3, RoundingMode.CEILING);
            int i4 = i2 - 1;
            int i5 = q;
            long j4 = j3;
            int i6 = 2;
            long j5 = 1;
            while (i6 <= i3) {
                i5 += q;
                if (i5 < 63) {
                    j4 *= (long) i4;
                    j5 *= (long) i6;
                } else {
                    j2 = u(j2, j4, j5);
                    j4 = (long) i4;
                    j5 = (long) i6;
                    i5 = q;
                }
                i6++;
                i4--;
            }
            return u(j2, j4, j5);
        }
        int i7 = i2 - 1;
        long j6 = (long) i2;
        for (int i8 = 2; i8 <= i3; i8++) {
            j6 = (j6 * ((long) i7)) / ((long) i8);
            i7--;
        }
        return j6;
    }

    public static long b(long j2) {
        MathPreconditions.i("x", j2);
        if (j2 <= 4611686018427387904L) {
            return 1 << (-Long.numberOfLeadingZeros(j2 - 1));
        }
        throw new ArithmeticException("ceilingPowerOfTwo(" + j2 + ") is not representable as a long");
    }

    public static long c(long j2, long j3) {
        long j4 = j2 + j3;
        boolean z = false;
        boolean z2 = (j2 ^ j3) < 0;
        if ((j2 ^ j4) >= 0) {
            z = true;
        }
        MathPreconditions.c(z2 | z, "checkedAdd", j2, j3);
        return j4;
    }

    public static long d(long j2, long j3) {
        long j4 = j2;
        long j5 = j3;
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(~j4) + Long.numberOfLeadingZeros(j3) + Long.numberOfLeadingZeros(~j5);
        if (numberOfLeadingZeros > 65) {
            return j4 * j5;
        }
        MathPreconditions.c(numberOfLeadingZeros >= 64, "checkedMultiply", j2, j3);
        int i2 = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
        MathPreconditions.c((i2 >= 0) | (j5 != Long.MIN_VALUE), "checkedMultiply", j2, j3);
        long j6 = j4 * j5;
        MathPreconditions.c(i2 == 0 || j6 / j4 == j5, "checkedMultiply", j2, j3);
        return j6;
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static long e(long j2, int i2) {
        MathPreconditions.e("exponent", i2);
        long j3 = 1;
        if ((j2 >= -2) && (j2 <= 2)) {
            int i3 = (int) j2;
            if (i3 == -2) {
                MathPreconditions.c(i2 < 64, "checkedPow", j2, (long) i2);
                return (i2 & 1) == 0 ? 1 << i2 : -1 << i2;
            } else if (i3 == -1) {
                return (i2 & 1) == 0 ? 1 : -1;
            } else {
                if (i3 == 0) {
                    return i2 == 0 ? 1 : 0;
                }
                if (i3 == 1) {
                    return 1;
                }
                if (i3 == 2) {
                    MathPreconditions.c(i2 < 63, "checkedPow", j2, (long) i2);
                    return 1 << i2;
                }
                throw new AssertionError();
            }
        } else {
            long j4 = j2;
            int i4 = i2;
            while (i4 != 0) {
                if (i4 == 1) {
                    return d(j3, j4);
                }
                long d2 = (i4 & 1) != 0 ? d(j3, j4) : j3;
                int i5 = i4 >> 1;
                if (i5 > 0) {
                    MathPreconditions.c(-3037000499L <= j4 && j4 <= f22851f, "checkedPow", j4, (long) i5);
                    j4 *= j4;
                }
                j3 = d2;
                i4 = i5;
            }
            return j3;
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static long f(long j2, long j3) {
        long j4 = j2 - j3;
        boolean z = false;
        boolean z2 = (j2 ^ j3) >= 0;
        if ((j2 ^ j4) >= 0) {
            z = true;
        }
        MathPreconditions.c(z2 | z, "checkedSubtract", j2, j3);
        return j4;
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static long g(long j2, long j3, RoundingMode roundingMode) {
        Preconditions.E(roundingMode);
        long j4 = j2 / j3;
        long j5 = j2 - (j3 * j4);
        int i2 = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
        if (i2 == 0) {
            return j4;
        }
        int i3 = (int) ((j2 ^ j3) >> 63);
        boolean z = true;
        int i4 = i3 | 1;
        switch (AnonymousClass1.f22857a[roundingMode.ordinal()]) {
            case 1:
                if (i2 != 0) {
                    z = false;
                }
                MathPreconditions.k(z);
                return j4;
            case 2:
                return j4;
            case 3:
                if (i4 >= 0) {
                    return j4;
                }
                break;
            case 4:
                break;
            case 5:
                if (i4 <= 0) {
                    return j4;
                }
                break;
            case 6:
            case 7:
            case 8:
                long abs = Math.abs(j5);
                int i5 = ((abs - (Math.abs(j3) - abs)) > 0 ? 1 : ((abs - (Math.abs(j3) - abs)) == 0 ? 0 : -1));
                if (i5 == 0) {
                    if (roundingMode != RoundingMode.HALF_UP && (roundingMode != RoundingMode.HALF_EVEN || (1 & j4) == 0)) {
                        return j4;
                    }
                } else if (i5 <= 0) {
                    return j4;
                }
                break;
            default:
                throw new AssertionError();
        }
        return j4 + ((long) i4);
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static long h(int i2) {
        MathPreconditions.e("n", i2);
        long[] jArr = f22852g;
        if (i2 < jArr.length) {
            return jArr[i2];
        }
        return Long.MAX_VALUE;
    }

    static boolean i(long j2) {
        return ((long) ((int) j2)) == j2;
    }

    public static long j(long j2) {
        MathPreconditions.i("x", j2);
        return 1 << (63 - Long.numberOfLeadingZeros(j2));
    }

    public static long k(long j2, long j3) {
        MathPreconditions.f("a", j2);
        MathPreconditions.f("b", j3);
        if (j2 == 0) {
            return j3;
        }
        if (j3 == 0) {
            return j2;
        }
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j2);
        long j4 = j2 >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j3);
        long j5 = j3 >> numberOfTrailingZeros2;
        while (j4 != j5) {
            long j6 = j4 - j5;
            long j7 = (j6 >> 63) & j6;
            long j8 = (j6 - j7) - j7;
            j5 += j7;
            j4 = j8 >> Long.numberOfTrailingZeros(j8);
        }
        return j4 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    public static boolean l(long j2) {
        boolean z = false;
        boolean z2 = j2 > 0;
        if ((j2 & (j2 - 1)) == 0) {
            z = true;
        }
        return z2 & z;
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static boolean m(long j2) {
        if (j2 < 2) {
            MathPreconditions.f("n", j2);
            return false;
        } else if (j2 < 66) {
            return ((722865708377213483 >> (((int) j2) + -2)) & 1) != 0;
        } else {
            if (((1 << ((int) (j2 % 30))) & f22855j) != 0 || j2 % 7 == 0 || j2 % 11 == 0 || j2 % 13 == 0) {
                return false;
            }
            if (j2 < 289) {
                return true;
            }
            for (long[] jArr : f22856k) {
                if (j2 <= jArr[0]) {
                    for (int i2 = 1; i2 < jArr.length; i2++) {
                        if (!MillerRabinTester.f(jArr[i2], j2)) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            throw new AssertionError();
        }
    }

    @VisibleForTesting
    static int n(long j2, long j3) {
        return (int) ((~(~(j2 - j3))) >>> 63);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0027, code lost:
        return r0 + r4;
     */
    @com.google.common.annotations.GwtIncompatible
    @com.google.common.annotations.J2ktIncompatible
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int o(long r4, java.math.RoundingMode r6) {
        /*
            java.lang.String r0 = "x"
            com.google.common.math.MathPreconditions.i(r0, r4)
            int r0 = p(r4)
            long[] r1 = f22849d
            r2 = r1[r0]
            int[] r1 = com.google.common.math.LongMath.AnonymousClass1.f22857a
            int r6 = r6.ordinal()
            r6 = r1[r6]
            switch(r6) {
                case 1: goto L_0x002d;
                case 2: goto L_0x0037;
                case 3: goto L_0x0037;
                case 4: goto L_0x0028;
                case 5: goto L_0x0028;
                case 6: goto L_0x001e;
                case 7: goto L_0x001e;
                case 8: goto L_0x001e;
                default: goto L_0x0018;
            }
        L_0x0018:
            java.lang.AssertionError r4 = new java.lang.AssertionError
            r4.<init>()
            throw r4
        L_0x001e:
            long[] r6 = f22850e
            r1 = r6[r0]
            int r4 = n(r1, r4)
        L_0x0026:
            int r0 = r0 + r4
            return r0
        L_0x0028:
            int r4 = n(r2, r4)
            goto L_0x0026
        L_0x002d:
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x0033
            r4 = 1
            goto L_0x0034
        L_0x0033:
            r4 = 0
        L_0x0034:
            com.google.common.math.MathPreconditions.k(r4)
        L_0x0037:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.LongMath.o(long, java.math.RoundingMode):int");
    }

    @GwtIncompatible
    @J2ktIncompatible
    static int p(long j2) {
        byte b2 = f22848c[Long.numberOfLeadingZeros(j2)];
        return b2 - n(j2, f22849d[b2]);
    }

    public static int q(long j2, RoundingMode roundingMode) {
        MathPreconditions.i("x", j2);
        switch (AnonymousClass1.f22857a[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.k(l(j2));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 64 - Long.numberOfLeadingZeros(j2 - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Long.numberOfLeadingZeros(j2);
                return (63 - numberOfLeadingZeros) + n(f22847b >>> numberOfLeadingZeros, j2);
            default:
                throw new AssertionError("impossible");
        }
        return 63 - Long.numberOfLeadingZeros(j2);
    }

    public static long r(long j2, long j3) {
        return (j2 & j3) + ((j2 ^ j3) >> 1);
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static int s(long j2, int i2) {
        return (int) t(j2, (long) i2);
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static long t(long j2, long j3) {
        if (j3 > 0) {
            long j4 = j2 % j3;
            return j4 >= 0 ? j4 : j4 + j3;
        }
        throw new ArithmeticException("Modulus must be positive");
    }

    static long u(long j2, long j3, long j4) {
        if (j2 == 1) {
            return j3 / j4;
        }
        long k2 = k(j2, j4);
        return (j2 / k2) * (j3 / (j4 / k2));
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static long v(long j2, int i2) {
        MathPreconditions.e("exponent", i2);
        if (-2 > j2 || j2 > 2) {
            long j3 = 1;
            while (i2 != 0) {
                if (i2 == 1) {
                    return j3 * j2;
                }
                j3 *= (i2 & 1) == 0 ? 1 : j2;
                j2 *= j2;
                i2 >>= 1;
            }
            return j3;
        }
        int i3 = (int) j2;
        if (i3 != -2) {
            if (i3 == -1) {
                return (i2 & 1) == 0 ? 1 : -1;
            }
            if (i3 == 0) {
                return i2 == 0 ? 1 : 0;
            }
            if (i3 == 1) {
                return 1;
            }
            if (i3 != 2) {
                throw new AssertionError();
            } else if (i2 < 64) {
                return 1 << i2;
            } else {
                return 0;
            }
        } else if (i2 < 64) {
            return (i2 & 1) == 0 ? 1 << i2 : -(1 << i2);
        } else {
            return 0;
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static double w(long j2, RoundingMode roundingMode) {
        double d2;
        long j3;
        long j4 = j2;
        double d3 = (double) j4;
        long j5 = (long) d3;
        int e2 = j5 == Long.MAX_VALUE ? -1 : Longs.e(j4, j5);
        int[] iArr = AnonymousClass1.f22857a;
        switch (iArr[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.k(e2 == 0);
                return d3;
            case 2:
                return j4 >= 0 ? e2 >= 0 ? d3 : DoubleUtils.f(d3) : e2 <= 0 ? d3 : Math.nextUp(d3);
            case 3:
                return e2 >= 0 ? d3 : DoubleUtils.f(d3);
            case 4:
                return j4 >= 0 ? e2 <= 0 ? d3 : Math.nextUp(d3) : e2 >= 0 ? d3 : DoubleUtils.f(d3);
            case 5:
                return e2 <= 0 ? d3 : Math.nextUp(d3);
            case 6:
            case 7:
            case 8:
                if (e2 >= 0) {
                    d2 = Math.nextUp(d3);
                    j3 = (long) Math.ceil(d2);
                } else {
                    double f2 = DoubleUtils.f(d3);
                    long j6 = j5;
                    j5 = (long) Math.floor(f2);
                    d2 = d3;
                    d3 = f2;
                    j3 = j6;
                }
                long j7 = j4 - j5;
                long j8 = j3 - j4;
                if (j3 == Long.MAX_VALUE) {
                    j8++;
                }
                int e3 = Longs.e(j7, j8);
                if (e3 < 0) {
                    return d3;
                }
                if (e3 > 0) {
                    return d2;
                }
                int i2 = iArr[roundingMode.ordinal()];
                if (i2 == 6) {
                    return j4 >= 0 ? d3 : d2;
                }
                if (i2 == 7) {
                    return j4 >= 0 ? d2 : d3;
                }
                if (i2 == 8) {
                    return (DoubleUtils.c(d3) & 1) == 0 ? d3 : d2;
                }
                throw new AssertionError("impossible");
            default:
                throw new AssertionError("impossible");
        }
    }

    public static long x(long j2, long j3) {
        long j4 = j2 + j3;
        boolean z = false;
        boolean z2 = (j3 ^ j2) < 0;
        if ((j2 ^ j4) >= 0) {
            z = true;
        }
        return z2 | z ? j4 : ((j4 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    public static long y(long j2, long j3) {
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(~j2) + Long.numberOfLeadingZeros(j3) + Long.numberOfLeadingZeros(~j3);
        if (numberOfLeadingZeros > 65) {
            return j2 * j3;
        }
        long j4 = ((j2 ^ j3) >>> 63) + Long.MAX_VALUE;
        boolean z = false;
        boolean z2 = numberOfLeadingZeros < 64;
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        boolean z3 = i2 < 0;
        if (j3 == Long.MIN_VALUE) {
            z = true;
        }
        if (z2 || (z & z3)) {
            return j4;
        }
        long j5 = j2 * j3;
        return (i2 == 0 || j5 / j2 == j3) ? j5 : j4;
    }

    public static long z(long j2, int i2) {
        MathPreconditions.e("exponent", i2);
        long j3 = 1;
        if ((j2 >= -2) && (j2 <= 2)) {
            int i3 = (int) j2;
            if (i3 != -2) {
                if (i3 == -1) {
                    return (i2 & 1) == 0 ? 1 : -1;
                }
                if (i3 == 0) {
                    return i2 == 0 ? 1 : 0;
                }
                if (i3 == 1) {
                    return 1;
                }
                if (i3 != 2) {
                    throw new AssertionError();
                } else if (i2 >= 63) {
                    return Long.MAX_VALUE;
                } else {
                    return 1 << i2;
                }
            } else if (i2 >= 64) {
                return ((long) (i2 & 1)) + Long.MAX_VALUE;
            } else {
                return (i2 & 1) == 0 ? 1 << i2 : -1 << i2;
            }
        } else {
            long j4 = ((j2 >>> 63) & ((long) (i2 & 1))) + Long.MAX_VALUE;
            while (i2 != 0) {
                if (i2 == 1) {
                    return y(j3, j2);
                }
                if ((i2 & 1) != 0) {
                    j3 = y(j3, j2);
                }
                i2 >>= 1;
                if (i2 > 0) {
                    if ((-3037000499L > j2) || (j2 > f22851f)) {
                        return j4;
                    }
                    j2 *= j2;
                }
            }
            return j3;
        }
    }
}
