package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.Comparable;
import java.math.BigInteger;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class DiscreteDomain<C extends Comparable> {
    final boolean s;

    private static final class BigIntegerDomain extends DiscreteDomain<BigInteger> implements Serializable {
        /* access modifiers changed from: private */
        public static final BigIntegerDomain X = new BigIntegerDomain();
        private static final long X2 = 0;
        private static final BigInteger Y = BigInteger.valueOf(Long.MIN_VALUE);
        private static final BigInteger Z = BigInteger.valueOf(Long.MAX_VALUE);

        BigIntegerDomain() {
            super(true);
        }

        private Object o() {
            return X;
        }

        /* renamed from: k */
        public long b(BigInteger bigInteger, BigInteger bigInteger2) {
            return bigInteger2.subtract(bigInteger).max(Y).min(Z).longValue();
        }

        /* renamed from: l */
        public BigInteger g(BigInteger bigInteger) {
            return bigInteger.add(BigInteger.ONE);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: m */
        public BigInteger h(BigInteger bigInteger, long j2) {
            CollectPreconditions.c(j2, "distance");
            return bigInteger.add(BigInteger.valueOf(j2));
        }

        /* renamed from: n */
        public BigInteger i(BigInteger bigInteger) {
            return bigInteger.subtract(BigInteger.ONE);
        }

        public String toString() {
            return "DiscreteDomain.bigIntegers()";
        }
    }

    private static final class IntegerDomain extends DiscreteDomain<Integer> implements Serializable {
        /* access modifiers changed from: private */
        public static final IntegerDomain X = new IntegerDomain();
        private static final long Y = 0;

        IntegerDomain() {
            super(true);
        }

        private Object q() {
            return X;
        }

        /* renamed from: k */
        public long b(Integer num, Integer num2) {
            return ((long) num2.intValue()) - ((long) num.intValue());
        }

        /* renamed from: l */
        public Integer e() {
            return Integer.MAX_VALUE;
        }

        /* renamed from: m */
        public Integer f() {
            return Integer.MIN_VALUE;
        }

        @CheckForNull
        /* renamed from: n */
        public Integer g(Integer num) {
            int intValue = num.intValue();
            if (intValue == Integer.MAX_VALUE) {
                return null;
            }
            return Integer.valueOf(intValue + 1);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o */
        public Integer h(Integer num, long j2) {
            CollectPreconditions.c(j2, "distance");
            return Integer.valueOf(Ints.d(num.longValue() + j2));
        }

        @CheckForNull
        /* renamed from: p */
        public Integer i(Integer num) {
            int intValue = num.intValue();
            if (intValue == Integer.MIN_VALUE) {
                return null;
            }
            return Integer.valueOf(intValue - 1);
        }

        public String toString() {
            return "DiscreteDomain.integers()";
        }
    }

    private static final class LongDomain extends DiscreteDomain<Long> implements Serializable {
        /* access modifiers changed from: private */
        public static final LongDomain X = new LongDomain();
        private static final long Y = 0;

        LongDomain() {
            super(true);
        }

        private Object q() {
            return X;
        }

        /* renamed from: k */
        public long b(Long l2, Long l3) {
            long longValue = l3.longValue() - l2.longValue();
            if (l3.longValue() > l2.longValue() && longValue < 0) {
                return Long.MAX_VALUE;
            }
            if (l3.longValue() >= l2.longValue() || longValue <= 0) {
                return longValue;
            }
            return Long.MIN_VALUE;
        }

        /* renamed from: l */
        public Long e() {
            return Long.MAX_VALUE;
        }

        /* renamed from: m */
        public Long f() {
            return Long.MIN_VALUE;
        }

        @CheckForNull
        /* renamed from: n */
        public Long g(Long l2) {
            long longValue = l2.longValue();
            if (longValue == Long.MAX_VALUE) {
                return null;
            }
            return Long.valueOf(longValue + 1);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o */
        public Long h(Long l2, long j2) {
            CollectPreconditions.c(j2, "distance");
            long longValue = l2.longValue() + j2;
            if (longValue < 0) {
                Preconditions.e(l2.longValue() < 0, "overflow");
            }
            return Long.valueOf(longValue);
        }

        @CheckForNull
        /* renamed from: p */
        public Long i(Long l2) {
            long longValue = l2.longValue();
            if (longValue == Long.MIN_VALUE) {
                return null;
            }
            return Long.valueOf(longValue - 1);
        }

        public String toString() {
            return "DiscreteDomain.longs()";
        }
    }

    protected DiscreteDomain() {
        this(false);
    }

    public static DiscreteDomain<BigInteger> a() {
        return BigIntegerDomain.X;
    }

    public static DiscreteDomain<Integer> c() {
        return IntegerDomain.X;
    }

    public static DiscreteDomain<Long> d() {
        return LongDomain.X;
    }

    public abstract long b(C c2, C c3);

    @CanIgnoreReturnValue
    public C e() {
        throw new NoSuchElementException();
    }

    @CanIgnoreReturnValue
    public C f() {
        throw new NoSuchElementException();
    }

    @CheckForNull
    public abstract C g(C c2);

    /* access modifiers changed from: package-private */
    public C h(C c2, long j2) {
        CollectPreconditions.c(j2, "distance");
        long j3 = 0;
        C c3 = c2;
        while (j3 < j2) {
            c3 = g(c3);
            if (c3 != null) {
                j3++;
            } else {
                throw new IllegalArgumentException("overflowed computing offset(" + c2 + ", " + j2 + ")");
            }
        }
        return c3;
    }

    @CheckForNull
    public abstract C i(C c2);

    private DiscreteDomain(boolean z) {
        this.s = z;
    }
}
