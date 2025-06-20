package kotlin;

import kotlin.internal.InlineOnly;

@Metadata(d1 = {"\u00004\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0005\u001a\u00020\u0001*\u00020\u0004H\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0017\u0010\b\u001a\u00020\u0001*\u00020\u0007H\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0017\u0010\u000b\u001a\u00020\u0001*\u00020\nH\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0017\u0010\u000e\u001a\u00020\u0001*\u00020\rH\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0017\u0010\u0011\u001a\u00020\u0001*\u00020\u0010H\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"", "Lkotlin/UInt;", "a", "(B)I", "", "f", "(S)I", "", "d", "(I)I", "", "e", "(J)I", "", "c", "(F)I", "", "b", "(D)I", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
public final class UIntKt {
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final int a(byte b2) {
        return UInt.i(b2);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final int b(double d2) {
        return UnsignedKt.a(d2);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final int c(float f2) {
        return UnsignedKt.a((double) f2);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final int d(int i2) {
        return UInt.i(i2);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final int e(long j2) {
        return UInt.i((int) j2);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final int f(short s) {
        return UInt.i(s);
    }
}
