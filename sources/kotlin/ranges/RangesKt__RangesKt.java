package kotlin.ranges;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000N\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a2\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a2\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\n*\u00020\t2\u0006\u0010\u0002\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0006*\u00020\t2\u0006\u0010\u0002\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\n*\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006*\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001aB\u0010\u0019\u001a\u00020\u0018\"\b\b\u0000\u0010\u0001*\u00020\u0014\"\u0018\b\u0001\u0010\u0016*\b\u0012\u0004\u0012\u00028\u00000\u0003*\b\u0012\u0004\u0012\u00028\u00000\u0015*\u00028\u00012\b\u0010\u0017\u001a\u0004\u0018\u00018\u0000H\n¢\u0006\u0004\b\u0019\u0010\u001a\u001aB\u0010\u001b\u001a\u00020\u0018\"\b\b\u0000\u0010\u0001*\u00020\u0014\"\u0018\b\u0001\u0010\u0016*\b\u0012\u0004\u0012\u00028\u00000\u0006*\b\u0012\u0004\u0012\u00028\u00000\u0015*\u00028\u00012\b\u0010\u0017\u001a\u0004\u0018\u00018\u0000H\n¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001f\u0010!\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001eH\u0000¢\u0006\u0004\b!\u0010\"¨\u0006#"}, d2 = {"", "T", "that", "Lkotlin/ranges/ClosedRange;", "f", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/ClosedRange;", "Lkotlin/ranges/OpenEndRange;", "i", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/OpenEndRange;", "", "Lkotlin/ranges/ClosedFloatingPointRange;", "d", "(DD)Lkotlin/ranges/ClosedFloatingPointRange;", "g", "(DD)Lkotlin/ranges/OpenEndRange;", "", "e", "(FF)Lkotlin/ranges/ClosedFloatingPointRange;", "h", "(FF)Lkotlin/ranges/OpenEndRange;", "", "", "R", "element", "", "b", "(Lkotlin/ranges/ClosedRange;Ljava/lang/Object;)Z", "c", "(Lkotlin/ranges/OpenEndRange;Ljava/lang/Object;)Z", "isPositive", "", "step", "", "a", "(ZLjava/lang/Number;)V", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/ranges/RangesKt")
class RangesKt__RangesKt {
    public static final void a(boolean z, @NotNull Number number) {
        Intrinsics.p(number, "step");
        if (!z) {
            throw new IllegalArgumentException("Step must be positive, was: " + number + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T, R extends ClosedRange<T> & Iterable<? extends T>> boolean b(R r, T t) {
        Intrinsics.p(r, "<this>");
        return t != null && r.b((Comparable) t);
    }

    @SinceKotlin(version = "1.9")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final <T, R extends OpenEndRange<T> & Iterable<? extends T>> boolean c(R r, T t) {
        Intrinsics.p(r, "<this>");
        return t != null && r.b((Comparable) t);
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static final ClosedFloatingPointRange<Double> d(double d2, double d3) {
        return new ClosedDoubleRange(d2, d3);
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static final ClosedFloatingPointRange<Float> e(float f2, float f3) {
        return new ClosedFloatRange(f2, f3);
    }

    @NotNull
    public static final <T extends Comparable<? super T>> ClosedRange<T> f(@NotNull T t, @NotNull T t2) {
        Intrinsics.p(t, "<this>");
        Intrinsics.p(t2, "that");
        return new ComparableRange(t, t2);
    }

    @SinceKotlin(version = "1.9")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final OpenEndRange<Double> g(double d2, double d3) {
        return new OpenEndDoubleRange(d2, d3);
    }

    @SinceKotlin(version = "1.9")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final OpenEndRange<Float> h(float f2, float f3) {
        return new OpenEndFloatRange(f2, f3);
    }

    @SinceKotlin(version = "1.9")
    @NotNull
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T extends Comparable<? super T>> OpenEndRange<T> i(@NotNull T t, @NotNull T t2) {
        Intrinsics.p(t, "<this>");
        Intrinsics.p(t2, "that");
        return new ComparableOpenEndRange(t, t2);
    }
}
