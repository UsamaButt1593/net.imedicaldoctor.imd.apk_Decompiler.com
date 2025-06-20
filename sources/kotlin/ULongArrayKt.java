package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a2\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\t\u001a\u00020\u00052\n\u0010\b\u001a\u00020\u0005\"\u00020\u0003H\bø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u0002\u000b\n\u0005\b20\u0001\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"", "size", "Lkotlin/Function1;", "Lkotlin/ULong;", "init", "Lkotlin/ULongArray;", "a", "(ILkotlin/jvm/functions/Function1;)[J", "elements", "b", "([J)[J", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
public final class ULongArrayKt {
    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final long[] a(int i2, Function1<? super Integer, ULong> function1) {
        Intrinsics.p(function1, "init");
        long[] jArr = new long[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            jArr[i3] = function1.f(Integer.valueOf(i3)).v0();
        }
        return ULongArray.g(jArr);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final long[] b(long... jArr) {
        Intrinsics.p(jArr, "elements");
        return jArr;
    }
}
