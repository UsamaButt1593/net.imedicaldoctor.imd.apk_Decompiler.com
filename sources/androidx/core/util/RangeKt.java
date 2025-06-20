package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Range;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.ranges.ClosedRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a2\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u0000H\f¢\u0006\u0004\b\u0004\u0010\u0005\u001a8\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0006\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0007\u0010\b\u001a>\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\n¢\u0006\u0004\b\n\u0010\u000b\u001a>\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\f¢\u0006\u0004\b\f\u0010\u000b\u001a/\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a/\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\b\u0012\u0004\u0012\u00028\u00000\rH\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"", "T", "that", "Landroid/util/Range;", "d", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Landroid/util/Range;", "value", "c", "(Landroid/util/Range;Ljava/lang/Comparable;)Landroid/util/Range;", "other", "b", "(Landroid/util/Range;Landroid/util/Range;)Landroid/util/Range;", "a", "Lkotlin/ranges/ClosedRange;", "e", "(Landroid/util/Range;)Lkotlin/ranges/ClosedRange;", "f", "(Lkotlin/ranges/ClosedRange;)Landroid/util/Range;", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
@SuppressLint({"ClassVerificationFailure"})
public final class RangeKt {
    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> Range<T> a(@NotNull Range<T> range, @NotNull Range<T> range2) {
        return range.intersect(range2);
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> Range<T> b(@NotNull Range<T> range, @NotNull Range<T> range2) {
        return range.extend(range2);
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> Range<T> c(@NotNull Range<T> range, @NotNull T t) {
        return range.extend(t);
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> Range<T> d(@NotNull T t, @NotNull T t2) {
        return new Range<>(t, t2);
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> ClosedRange<T> e(@NotNull Range<T> range) {
        return new RangeKt$toClosedRange$1(range);
    }

    @RequiresApi(21)
    @NotNull
    public static final <T extends Comparable<? super T>> Range<T> f(@NotNull ClosedRange<T> closedRange) {
        return new Range<>(closedRange.c(), closedRange.h());
    }
}
