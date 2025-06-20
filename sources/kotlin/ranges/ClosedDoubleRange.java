package kotlin.ranges;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u0004\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010 ¨\u0006\""}, d2 = {"Lkotlin/ranges/ClosedDoubleRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "start", "endInclusive", "<init>", "(DD)V", "a", "b", "", "g", "(DD)Z", "value", "(D)Z", "isEmpty", "()Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "s", "D", "_start", "X", "_endInclusive", "f", "()Ljava/lang/Double;", "e", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
final class ClosedDoubleRange implements ClosedFloatingPointRange<Double> {
    private final double X;
    private final double s;

    public ClosedDoubleRange(double d2, double d3) {
        this.s = d2;
        this.X = d3;
    }

    public boolean a(double d2) {
        return d2 >= this.s && d2 <= this.X;
    }

    public /* bridge */ /* synthetic */ boolean b(Comparable comparable) {
        return a(((Number) comparable).doubleValue());
    }

    public /* bridge */ /* synthetic */ boolean d(Comparable comparable, Comparable comparable2) {
        return g(((Number) comparable).doubleValue(), ((Number) comparable2).doubleValue());
    }

    @NotNull
    /* renamed from: e */
    public Double h() {
        return Double.valueOf(this.X);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ClosedDoubleRange) {
            if (!isEmpty() || !((ClosedDoubleRange) obj).isEmpty()) {
                ClosedDoubleRange closedDoubleRange = (ClosedDoubleRange) obj;
                if (!(this.s == closedDoubleRange.s && this.X == closedDoubleRange.X)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f */
    public Double c() {
        return Double.valueOf(this.s);
    }

    public boolean g(double d2, double d3) {
        return d2 <= d3;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.doubleToLongBits(this.s) * 31) + Double.doubleToLongBits(this.X);
    }

    public boolean isEmpty() {
        return this.s > this.X;
    }

    @NotNull
    public String toString() {
        return this.s + ".." + this.X;
    }
}
