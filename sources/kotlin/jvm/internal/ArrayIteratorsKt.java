package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.collections.BooleanIterator;
import kotlin.collections.ByteIterator;
import kotlin.collections.CharIterator;
import kotlin.collections.DoubleIterator;
import kotlin.collections.FloatIterator;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.collections.ShortIterator;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000b\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\f\u001a\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0001\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0015\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0001\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0015\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0001\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0015\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0001\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"", "array", "Lkotlin/collections/ByteIterator;", "b", "([B)Lkotlin/collections/ByteIterator;", "", "Lkotlin/collections/CharIterator;", "c", "([C)Lkotlin/collections/CharIterator;", "", "Lkotlin/collections/ShortIterator;", "h", "([S)Lkotlin/collections/ShortIterator;", "", "Lkotlin/collections/IntIterator;", "f", "([I)Lkotlin/collections/IntIterator;", "", "Lkotlin/collections/LongIterator;", "g", "([J)Lkotlin/collections/LongIterator;", "", "Lkotlin/collections/FloatIterator;", "e", "([F)Lkotlin/collections/FloatIterator;", "", "Lkotlin/collections/DoubleIterator;", "d", "([D)Lkotlin/collections/DoubleIterator;", "", "Lkotlin/collections/BooleanIterator;", "a", "([Z)Lkotlin/collections/BooleanIterator;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
public final class ArrayIteratorsKt {
    @NotNull
    public static final BooleanIterator a(@NotNull boolean[] zArr) {
        Intrinsics.p(zArr, "array");
        return new ArrayBooleanIterator(zArr);
    }

    @NotNull
    public static final ByteIterator b(@NotNull byte[] bArr) {
        Intrinsics.p(bArr, "array");
        return new ArrayByteIterator(bArr);
    }

    @NotNull
    public static final CharIterator c(@NotNull char[] cArr) {
        Intrinsics.p(cArr, "array");
        return new ArrayCharIterator(cArr);
    }

    @NotNull
    public static final DoubleIterator d(@NotNull double[] dArr) {
        Intrinsics.p(dArr, "array");
        return new ArrayDoubleIterator(dArr);
    }

    @NotNull
    public static final FloatIterator e(@NotNull float[] fArr) {
        Intrinsics.p(fArr, "array");
        return new ArrayFloatIterator(fArr);
    }

    @NotNull
    public static final IntIterator f(@NotNull int[] iArr) {
        Intrinsics.p(iArr, "array");
        return new ArrayIntIterator(iArr);
    }

    @NotNull
    public static final LongIterator g(@NotNull long[] jArr) {
        Intrinsics.p(jArr, "array");
        return new ArrayLongIterator(jArr);
    }

    @NotNull
    public static final ShortIterator h(@NotNull short[] sArr) {
        Intrinsics.p(sArr, "array");
        return new ArrayShortIterator(sArr);
    }
}
