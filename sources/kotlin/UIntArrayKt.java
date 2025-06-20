package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a2\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001f\u0010\t\u001a\u00020\u00052\n\u0010\b\u001a\u00020\u0005\"\u00020\u0003H\bø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u0002\u000b\n\u0005\b20\u0001\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"", "size", "Lkotlin/Function1;", "Lkotlin/UInt;", "init", "Lkotlin/UIntArray;", "a", "(ILkotlin/jvm/functions/Function1;)[I", "elements", "b", "([I)[I", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
public final class UIntArrayKt {
    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final int[] a(int i2, Function1<? super Integer, UInt> function1) {
        Intrinsics.p(function1, "init");
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = function1.f(Integer.valueOf(i3)).v0();
        }
        return UIntArray.g(iArr);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final int[] b(int... iArr) {
        Intrinsics.p(iArr, "elements");
        return iArr;
    }
}
