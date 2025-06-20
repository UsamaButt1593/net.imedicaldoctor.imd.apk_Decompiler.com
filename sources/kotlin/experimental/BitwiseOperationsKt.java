package kotlin.experimental;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0005\n\u0002\b\u0007\n\u0002\u0010\n\n\u0002\b\u0007\u001a\u001c\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\f¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001c\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\f¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u001c\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\f¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0014\u0010\u0006\u001a\u00020\u0000*\u00020\u0000H\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001c\u0010\t\u001a\u00020\b*\u00020\b2\u0006\u0010\u0001\u001a\u00020\bH\f¢\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\u000b\u001a\u00020\b*\u00020\b2\u0006\u0010\u0001\u001a\u00020\bH\f¢\u0006\u0004\b\u000b\u0010\n\u001a\u001c\u0010\f\u001a\u00020\b*\u00020\b2\u0006\u0010\u0001\u001a\u00020\bH\f¢\u0006\u0004\b\f\u0010\n\u001a\u0014\u0010\r\u001a\u00020\b*\u00020\bH\b¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"", "other", "a", "(BB)B", "e", "g", "c", "(B)B", "", "b", "(SS)S", "f", "h", "d", "(S)S", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
public final class BitwiseOperationsKt {
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte a(byte b2, byte b3) {
        return (byte) (b2 & b3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short b(short s, short s2) {
        return (short) (s & s2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte c(byte b2) {
        return (byte) (~b2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short d(short s) {
        return (short) (~s);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte e(byte b2, byte b3) {
        return (byte) (b2 | b3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short f(short s, short s2) {
        return (short) (s | s2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte g(byte b2, byte b3) {
        return (byte) (b2 ^ b3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short h(short s, short s2) {
        return (short) (s ^ s2);
    }
}
