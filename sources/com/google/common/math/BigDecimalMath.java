package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.math.BigDecimal;
import java.math.RoundingMode;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public class BigDecimalMath {

    private static class BigDecimalToDoubleRounder extends ToDoubleRounder<BigDecimal> {

        /* renamed from: a  reason: collision with root package name */
        static final BigDecimalToDoubleRounder f22807a = new BigDecimalToDoubleRounder();

        private BigDecimalToDoubleRounder() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public BigDecimal a(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            return bigDecimal.subtract(bigDecimal2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public double c(BigDecimal bigDecimal) {
            return bigDecimal.doubleValue();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public int d(BigDecimal bigDecimal) {
            return bigDecimal.signum();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public BigDecimal e(double d2, RoundingMode roundingMode) {
            return new BigDecimal(d2);
        }
    }

    private BigDecimalMath() {
    }

    public static double a(BigDecimal bigDecimal, RoundingMode roundingMode) {
        return BigDecimalToDoubleRounder.f22807a.b(bigDecimal, roundingMode);
    }
}
