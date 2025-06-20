package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public abstract class LinearTransformation {

    public static final class LinearTransformationBuilder {

        /* renamed from: a  reason: collision with root package name */
        private final double f22838a;

        /* renamed from: b  reason: collision with root package name */
        private final double f22839b;

        private LinearTransformationBuilder(double d2, double d3) {
            this.f22838a = d2;
            this.f22839b = d3;
        }

        public LinearTransformation a(double d2, double d3) {
            boolean z = false;
            Preconditions.d(DoubleUtils.d(d2) && DoubleUtils.d(d3));
            double d4 = this.f22838a;
            if (d2 != d4) {
                return b((d3 - this.f22839b) / (d2 - d4));
            }
            if (d3 != this.f22839b) {
                z = true;
            }
            Preconditions.d(z);
            return new VerticalLinearTransformation(this.f22838a);
        }

        public LinearTransformation b(double d2) {
            Preconditions.d(!Double.isNaN(d2));
            return DoubleUtils.d(d2) ? new RegularLinearTransformation(d2, this.f22839b - (this.f22838a * d2)) : new VerticalLinearTransformation(this.f22838a);
        }
    }

    private static final class NaNLinearTransformation extends LinearTransformation {

        /* renamed from: a  reason: collision with root package name */
        static final NaNLinearTransformation f22840a = new NaNLinearTransformation();

        private NaNLinearTransformation() {
        }

        public LinearTransformation c() {
            return this;
        }

        public boolean d() {
            return false;
        }

        public boolean e() {
            return false;
        }

        public double g() {
            return Double.NaN;
        }

        public double h(double d2) {
            return Double.NaN;
        }

        public String toString() {
            return "NaN";
        }
    }

    private static final class RegularLinearTransformation extends LinearTransformation {

        /* renamed from: a  reason: collision with root package name */
        final double f22841a;

        /* renamed from: b  reason: collision with root package name */
        final double f22842b;
        @CheckForNull
        @LazyInit

        /* renamed from: c  reason: collision with root package name */
        LinearTransformation f22843c;

        RegularLinearTransformation(double d2, double d3) {
            this.f22841a = d2;
            this.f22842b = d3;
            this.f22843c = null;
        }

        private LinearTransformation j() {
            double d2 = this.f22841a;
            return d2 != 0.0d ? new RegularLinearTransformation(1.0d / d2, (this.f22842b * -1.0d) / d2, this) : new VerticalLinearTransformation(this.f22842b, this);
        }

        public LinearTransformation c() {
            LinearTransformation linearTransformation = this.f22843c;
            if (linearTransformation != null) {
                return linearTransformation;
            }
            LinearTransformation j2 = j();
            this.f22843c = j2;
            return j2;
        }

        public boolean d() {
            return this.f22841a == 0.0d;
        }

        public boolean e() {
            return false;
        }

        public double g() {
            return this.f22841a;
        }

        public double h(double d2) {
            return (d2 * this.f22841a) + this.f22842b;
        }

        public String toString() {
            return String.format("y = %g * x + %g", new Object[]{Double.valueOf(this.f22841a), Double.valueOf(this.f22842b)});
        }

        RegularLinearTransformation(double d2, double d3, LinearTransformation linearTransformation) {
            this.f22841a = d2;
            this.f22842b = d3;
            this.f22843c = linearTransformation;
        }
    }

    private static final class VerticalLinearTransformation extends LinearTransformation {

        /* renamed from: a  reason: collision with root package name */
        final double f22844a;
        @CheckForNull
        @LazyInit

        /* renamed from: b  reason: collision with root package name */
        LinearTransformation f22845b;

        VerticalLinearTransformation(double d2) {
            this.f22844a = d2;
            this.f22845b = null;
        }

        private LinearTransformation j() {
            return new RegularLinearTransformation(0.0d, this.f22844a, this);
        }

        public LinearTransformation c() {
            LinearTransformation linearTransformation = this.f22845b;
            if (linearTransformation != null) {
                return linearTransformation;
            }
            LinearTransformation j2 = j();
            this.f22845b = j2;
            return j2;
        }

        public boolean d() {
            return false;
        }

        public boolean e() {
            return true;
        }

        public double g() {
            throw new IllegalStateException();
        }

        public double h(double d2) {
            throw new IllegalStateException();
        }

        public String toString() {
            return String.format("x = %g", new Object[]{Double.valueOf(this.f22844a)});
        }

        VerticalLinearTransformation(double d2, LinearTransformation linearTransformation) {
            this.f22844a = d2;
            this.f22845b = linearTransformation;
        }
    }

    public static LinearTransformation a() {
        return NaNLinearTransformation.f22840a;
    }

    public static LinearTransformation b(double d2) {
        Preconditions.d(DoubleUtils.d(d2));
        return new RegularLinearTransformation(0.0d, d2);
    }

    public static LinearTransformationBuilder f(double d2, double d3) {
        Preconditions.d(DoubleUtils.d(d2) && DoubleUtils.d(d3));
        return new LinearTransformationBuilder(d2, d3);
    }

    public static LinearTransformation i(double d2) {
        Preconditions.d(DoubleUtils.d(d2));
        return new VerticalLinearTransformation(d2);
    }

    public abstract LinearTransformation c();

    public abstract boolean d();

    public abstract boolean e();

    public abstract double g();

    public abstract double h(double d2);
}
