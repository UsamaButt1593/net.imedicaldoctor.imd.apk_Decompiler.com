package kotlin;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001c\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001c\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u001c\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u001c\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u001c\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0014\u0010\b\u001a\u00020\u0000*\u00020\u0000H\n¢\u0006\u0004\b\b\u0010\t\u001a\u0014\u0010\n\u001a\u00020\u0000*\u00020\u0000H\n¢\u0006\u0004\b\n\u0010\t\u001a\u0014\u0010\u000b\u001a\u00020\u0000*\u00020\u0000H\n¢\u0006\u0004\b\u000b\u0010\t\u001a\u0014\u0010\f\u001a\u00020\u0000*\u00020\u0000H\b¢\u0006\u0004\b\f\u0010\t\u001a\u001c\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\f¢\u0006\u0004\b\r\u0010\u0003\u001a\u001c\u0010\u000e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\f¢\u0006\u0004\b\u000e\u0010\u0003\u001a\u001c\u0010\u000f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\f¢\u0006\u0004\b\u000f\u0010\u0003\u001a\u001c\u0010\u0012\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\f¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001c\u0010\u0014\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\f¢\u0006\u0004\b\u0014\u0010\u0013\u001a\u0014\u0010\u0015\u001a\u00020\u0000*\u00020\u0010H\b¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0014\u0010\u0018\u001a\u00020\u0000*\u00020\u0017H\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0014\u0010\u001b\u001a\u00020\u001a*\u00020\u0000H\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a(\u0010 \u001a\u00020\u001a*\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u00102\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\b¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Ljava/math/BigInteger;", "other", "x", "(Ljava/math/BigInteger;Ljava/math/BigInteger;)Ljava/math/BigInteger;", "v", "B", "s", "y", "H", "(Ljava/math/BigInteger;)Ljava/math/BigInteger;", "t", "r", "u", "q", "w", "I", "", "n", "z", "(Ljava/math/BigInteger;I)Ljava/math/BigInteger;", "A", "F", "(I)Ljava/math/BigInteger;", "", "G", "(J)Ljava/math/BigInteger;", "Ljava/math/BigDecimal;", "C", "(Ljava/math/BigInteger;)Ljava/math/BigDecimal;", "scale", "Ljava/math/MathContext;", "mathContext", "D", "(Ljava/math/BigInteger;ILjava/math/MathContext;)Ljava/math/BigDecimal;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/NumbersKt")
class NumbersKt__BigIntegersKt extends NumbersKt__BigDecimalsKt {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger A(BigInteger bigInteger, int i2) {
        Intrinsics.p(bigInteger, "<this>");
        BigInteger shiftRight = bigInteger.shiftRight(i2);
        Intrinsics.o(shiftRight, "this.shiftRight(n)");
        return shiftRight;
    }

    @InlineOnly
    private static final BigInteger B(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.p(bigInteger, "<this>");
        Intrinsics.p(bigInteger2, "other");
        BigInteger multiply = bigInteger.multiply(bigInteger2);
        Intrinsics.o(multiply, "this.multiply(other)");
        return multiply;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal C(BigInteger bigInteger) {
        Intrinsics.p(bigInteger, "<this>");
        return new BigDecimal(bigInteger);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal D(BigInteger bigInteger, int i2, MathContext mathContext) {
        Intrinsics.p(bigInteger, "<this>");
        Intrinsics.p(mathContext, "mathContext");
        return new BigDecimal(bigInteger, i2, mathContext);
    }

    static /* synthetic */ BigDecimal E(BigInteger bigInteger, int i2, MathContext mathContext, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        if ((i3 & 2) != 0) {
            mathContext = MathContext.UNLIMITED;
            Intrinsics.o(mathContext, "UNLIMITED");
        }
        Intrinsics.p(bigInteger, "<this>");
        Intrinsics.p(mathContext, "mathContext");
        return new BigDecimal(bigInteger, i2, mathContext);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger F(int i2) {
        BigInteger valueOf = BigInteger.valueOf((long) i2);
        Intrinsics.o(valueOf, "valueOf(this.toLong())");
        return valueOf;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger G(long j2) {
        BigInteger valueOf = BigInteger.valueOf(j2);
        Intrinsics.o(valueOf, "valueOf(this)");
        return valueOf;
    }

    @InlineOnly
    private static final BigInteger H(BigInteger bigInteger) {
        Intrinsics.p(bigInteger, "<this>");
        BigInteger negate = bigInteger.negate();
        Intrinsics.o(negate, "this.negate()");
        return negate;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger I(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.p(bigInteger, "<this>");
        Intrinsics.p(bigInteger2, "other");
        BigInteger xor = bigInteger.xor(bigInteger2);
        Intrinsics.o(xor, "this.xor(other)");
        return xor;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger q(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.p(bigInteger, "<this>");
        Intrinsics.p(bigInteger2, "other");
        BigInteger and = bigInteger.and(bigInteger2);
        Intrinsics.o(and, "this.and(other)");
        return and;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger r(BigInteger bigInteger) {
        Intrinsics.p(bigInteger, "<this>");
        BigInteger subtract = bigInteger.subtract(BigInteger.ONE);
        Intrinsics.o(subtract, "this.subtract(BigInteger.ONE)");
        return subtract;
    }

    @InlineOnly
    private static final BigInteger s(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.p(bigInteger, "<this>");
        Intrinsics.p(bigInteger2, "other");
        BigInteger divide = bigInteger.divide(bigInteger2);
        Intrinsics.o(divide, "this.divide(other)");
        return divide;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger t(BigInteger bigInteger) {
        Intrinsics.p(bigInteger, "<this>");
        BigInteger add = bigInteger.add(BigInteger.ONE);
        Intrinsics.o(add, "this.add(BigInteger.ONE)");
        return add;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger u(BigInteger bigInteger) {
        Intrinsics.p(bigInteger, "<this>");
        BigInteger not = bigInteger.not();
        Intrinsics.o(not, "this.not()");
        return not;
    }

    @InlineOnly
    private static final BigInteger v(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.p(bigInteger, "<this>");
        Intrinsics.p(bigInteger2, "other");
        BigInteger subtract = bigInteger.subtract(bigInteger2);
        Intrinsics.o(subtract, "this.subtract(other)");
        return subtract;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger w(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.p(bigInteger, "<this>");
        Intrinsics.p(bigInteger2, "other");
        BigInteger or = bigInteger.or(bigInteger2);
        Intrinsics.o(or, "this.or(other)");
        return or;
    }

    @InlineOnly
    private static final BigInteger x(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.p(bigInteger, "<this>");
        Intrinsics.p(bigInteger2, "other");
        BigInteger add = bigInteger.add(bigInteger2);
        Intrinsics.o(add, "this.add(other)");
        return add;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final BigInteger y(BigInteger bigInteger, BigInteger bigInteger2) {
        Intrinsics.p(bigInteger, "<this>");
        Intrinsics.p(bigInteger2, "other");
        BigInteger remainder = bigInteger.remainder(bigInteger2);
        Intrinsics.o(remainder, "this.remainder(other)");
        return remainder;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger z(BigInteger bigInteger, int i2) {
        Intrinsics.p(bigInteger, "<this>");
        BigInteger shiftLeft = bigInteger.shiftLeft(i2);
        Intrinsics.o(shiftLeft, "this.shiftLeft(n)");
        return shiftLeft;
    }
}
