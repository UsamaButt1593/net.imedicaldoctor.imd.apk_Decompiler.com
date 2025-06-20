package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import java.lang.Comparable;
import java.lang.Number;
import java.math.RoundingMode;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
abstract class ToDoubleRounder<X extends Number & Comparable<X>> {

    /* renamed from: com.google.common.math.ToDoubleRounder$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22871a;

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
                f22871a = r0
                java.math.RoundingMode r1 = java.math.RoundingMode.DOWN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22871a     // Catch:{ NoSuchFieldError -> 0x001d }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_EVEN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f22871a     // Catch:{ NoSuchFieldError -> 0x0028 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_DOWN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f22871a     // Catch:{ NoSuchFieldError -> 0x0033 }
                java.math.RoundingMode r1 = java.math.RoundingMode.HALF_UP     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f22871a     // Catch:{ NoSuchFieldError -> 0x003e }
                java.math.RoundingMode r1 = java.math.RoundingMode.FLOOR     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f22871a     // Catch:{ NoSuchFieldError -> 0x0049 }
                java.math.RoundingMode r1 = java.math.RoundingMode.CEILING     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f22871a     // Catch:{ NoSuchFieldError -> 0x0054 }
                java.math.RoundingMode r1 = java.math.RoundingMode.UP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f22871a     // Catch:{ NoSuchFieldError -> 0x0060 }
                java.math.RoundingMode r1 = java.math.RoundingMode.UNNECESSARY     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.ToDoubleRounder.AnonymousClass1.<clinit>():void");
        }
    }

    ToDoubleRounder() {
    }

    /* access modifiers changed from: package-private */
    public abstract X a(X x, X x2);

    /* access modifiers changed from: package-private */
    public final double b(X x, RoundingMode roundingMode) {
        Number number;
        double d2;
        Preconditions.F(x, "x");
        Preconditions.F(roundingMode, "mode");
        double c2 = c(x);
        if (Double.isInfinite(c2)) {
            switch (AnonymousClass1.f22871a[roundingMode.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    return ((double) d(x)) * Double.MAX_VALUE;
                case 5:
                    return c2 == Double.POSITIVE_INFINITY ? Double.MAX_VALUE : Double.NEGATIVE_INFINITY;
                case 6:
                    return c2 == Double.POSITIVE_INFINITY ? Double.POSITIVE_INFINITY : -1.7976931348623157E308d;
                case 7:
                    return c2;
                case 8:
                    throw new ArithmeticException(x + " cannot be represented precisely as a double");
            }
        }
        Number e2 = e(c2, RoundingMode.UNNECESSARY);
        int compareTo = ((Comparable) x).compareTo(e2);
        int[] iArr = AnonymousClass1.f22871a;
        switch (iArr[roundingMode.ordinal()]) {
            case 1:
                return d(x) >= 0 ? compareTo >= 0 ? c2 : DoubleUtils.f(c2) : compareTo <= 0 ? c2 : Math.nextUp(c2);
            case 2:
            case 3:
            case 4:
                if (compareTo >= 0) {
                    d2 = Math.nextUp(c2);
                    if (d2 == Double.POSITIVE_INFINITY) {
                        return c2;
                    }
                    number = e(d2, RoundingMode.CEILING);
                } else {
                    double f2 = DoubleUtils.f(c2);
                    if (f2 == Double.NEGATIVE_INFINITY) {
                        return c2;
                    }
                    Number e3 = e(f2, RoundingMode.FLOOR);
                    double d3 = f2;
                    number = e2;
                    e2 = e3;
                    d2 = c2;
                    c2 = d3;
                }
                int compareTo2 = ((Comparable) a(x, e2)).compareTo(a(number, x));
                if (compareTo2 < 0) {
                    return c2;
                }
                if (compareTo2 > 0) {
                    return d2;
                }
                int i2 = iArr[roundingMode.ordinal()];
                if (i2 == 2) {
                    return (Double.doubleToRawLongBits(c2) & 1) == 0 ? c2 : d2;
                }
                if (i2 == 3) {
                    return d(x) >= 0 ? c2 : d2;
                }
                if (i2 == 4) {
                    return d(x) >= 0 ? d2 : c2;
                }
                throw new AssertionError("impossible");
            case 5:
                return compareTo >= 0 ? c2 : DoubleUtils.f(c2);
            case 6:
                return compareTo <= 0 ? c2 : Math.nextUp(c2);
            case 7:
                return d(x) >= 0 ? compareTo <= 0 ? c2 : Math.nextUp(c2) : compareTo >= 0 ? c2 : DoubleUtils.f(c2);
            case 8:
                MathPreconditions.k(compareTo == 0);
                return c2;
            default:
                throw new AssertionError("impossible");
        }
    }

    /* access modifiers changed from: package-private */
    public abstract double c(X x);

    /* access modifiers changed from: package-private */
    public abstract int d(X x);

    /* access modifiers changed from: package-private */
    public abstract X e(double d2, RoundingMode roundingMode);
}
