package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.util.Comparator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ComparisonChain {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final ComparisonChain f22375a = new ComparisonChain() {
        public ComparisonChain d(double d2, double d3) {
            return o(Double.compare(d2, d3));
        }

        public ComparisonChain e(float f2, float f3) {
            return o(Float.compare(f2, f3));
        }

        public ComparisonChain f(int i2, int i3) {
            return o(Ints.e(i2, i3));
        }

        public ComparisonChain g(long j2, long j3) {
            return o(Longs.e(j2, j3));
        }

        public ComparisonChain i(Comparable<?> comparable, Comparable<?> comparable2) {
            return o(comparable.compareTo(comparable2));
        }

        public <T> ComparisonChain j(@ParametricNullness T t, @ParametricNullness T t2, Comparator<T> comparator) {
            return o(comparator.compare(t, t2));
        }

        public ComparisonChain k(boolean z, boolean z2) {
            return o(Booleans.d(z, z2));
        }

        public ComparisonChain l(boolean z, boolean z2) {
            return o(Booleans.d(z2, z));
        }

        public int m() {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public ComparisonChain o(int i2) {
            if (i2 < 0) {
                return ComparisonChain.f22376b;
            }
            return i2 > 0 ? ComparisonChain.f22377c : ComparisonChain.f22375a;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final ComparisonChain f22376b = new InactiveComparisonChain(-1);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final ComparisonChain f22377c = new InactiveComparisonChain(1);

    private static final class InactiveComparisonChain extends ComparisonChain {

        /* renamed from: d  reason: collision with root package name */
        final int f22378d;

        InactiveComparisonChain(int i2) {
            super();
            this.f22378d = i2;
        }

        public ComparisonChain d(double d2, double d3) {
            return this;
        }

        public ComparisonChain e(float f2, float f3) {
            return this;
        }

        public ComparisonChain f(int i2, int i3) {
            return this;
        }

        public ComparisonChain g(long j2, long j3) {
            return this;
        }

        public ComparisonChain i(Comparable<?> comparable, Comparable<?> comparable2) {
            return this;
        }

        public <T> ComparisonChain j(@ParametricNullness T t, @ParametricNullness T t2, Comparator<T> comparator) {
            return this;
        }

        public ComparisonChain k(boolean z, boolean z2) {
            return this;
        }

        public ComparisonChain l(boolean z, boolean z2) {
            return this;
        }

        public int m() {
            return this.f22378d;
        }
    }

    private ComparisonChain() {
    }

    public static ComparisonChain n() {
        return f22375a;
    }

    public abstract ComparisonChain d(double d2, double d3);

    public abstract ComparisonChain e(float f2, float f3);

    public abstract ComparisonChain f(int i2, int i3);

    public abstract ComparisonChain g(long j2, long j3);

    @Deprecated
    public final ComparisonChain h(Boolean bool, Boolean bool2) {
        return k(bool.booleanValue(), bool2.booleanValue());
    }

    public abstract ComparisonChain i(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract <T> ComparisonChain j(@ParametricNullness T t, @ParametricNullness T t2, Comparator<T> comparator);

    public abstract ComparisonChain k(boolean z, boolean z2);

    public abstract ComparisonChain l(boolean z, boolean z2);

    public abstract int m();
}
