package kotlin;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\u001a\u001c\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001c\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u001c\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u001c\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u001c\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0014\u0010\b\u001a\u00020\u0000*\u00020\u0000H\n¢\u0006\u0004\b\b\u0010\t\u001a\u0014\u0010\n\u001a\u00020\u0000*\u00020\u0000H\n¢\u0006\u0004\b\n\u0010\t\u001a\u0014\u0010\u000b\u001a\u00020\u0000*\u00020\u0000H\n¢\u0006\u0004\b\u000b\u0010\t\u001a\u0014\u0010\r\u001a\u00020\u0000*\u00020\fH\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u0011\u001a\u00020\u0000*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0014\u0010\u0014\u001a\u00020\u0000*\u00020\u0013H\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001c\u0010\u0016\u001a\u00020\u0000*\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000fH\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0014\u0010\u0019\u001a\u00020\u0000*\u00020\u0018H\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001c\u0010\u001b\u001a\u00020\u0000*\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u000fH\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0014\u0010\u001e\u001a\u00020\u0000*\u00020\u001dH\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001c\u0010 \u001a\u00020\u0000*\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u000fH\b¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Ljava/math/BigDecimal;", "other", "e", "(Ljava/math/BigDecimal;Ljava/math/BigDecimal;)Ljava/math/BigDecimal;", "d", "g", "b", "f", "p", "(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;", "c", "a", "", "l", "(I)Ljava/math/BigDecimal;", "Ljava/math/MathContext;", "mathContext", "m", "(ILjava/math/MathContext;)Ljava/math/BigDecimal;", "", "n", "(J)Ljava/math/BigDecimal;", "o", "(JLjava/math/MathContext;)Ljava/math/BigDecimal;", "", "j", "(F)Ljava/math/BigDecimal;", "k", "(FLjava/math/MathContext;)Ljava/math/BigDecimal;", "", "h", "(D)Ljava/math/BigDecimal;", "i", "(DLjava/math/MathContext;)Ljava/math/BigDecimal;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/NumbersKt")
class NumbersKt__BigDecimalsKt {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal a(BigDecimal bigDecimal) {
        Intrinsics.p(bigDecimal, "<this>");
        BigDecimal subtract = bigDecimal.subtract(BigDecimal.ONE);
        Intrinsics.o(subtract, "this.subtract(BigDecimal.ONE)");
        return subtract;
    }

    @InlineOnly
    private static final BigDecimal b(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.p(bigDecimal, "<this>");
        Intrinsics.p(bigDecimal2, "other");
        BigDecimal divide = bigDecimal.divide(bigDecimal2, RoundingMode.HALF_EVEN);
        Intrinsics.o(divide, "this.divide(other, RoundingMode.HALF_EVEN)");
        return divide;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal c(BigDecimal bigDecimal) {
        Intrinsics.p(bigDecimal, "<this>");
        BigDecimal add = bigDecimal.add(BigDecimal.ONE);
        Intrinsics.o(add, "this.add(BigDecimal.ONE)");
        return add;
    }

    @InlineOnly
    private static final BigDecimal d(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.p(bigDecimal, "<this>");
        Intrinsics.p(bigDecimal2, "other");
        BigDecimal subtract = bigDecimal.subtract(bigDecimal2);
        Intrinsics.o(subtract, "this.subtract(other)");
        return subtract;
    }

    @InlineOnly
    private static final BigDecimal e(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.p(bigDecimal, "<this>");
        Intrinsics.p(bigDecimal2, "other");
        BigDecimal add = bigDecimal.add(bigDecimal2);
        Intrinsics.o(add, "this.add(other)");
        return add;
    }

    @InlineOnly
    private static final BigDecimal f(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.p(bigDecimal, "<this>");
        Intrinsics.p(bigDecimal2, "other");
        BigDecimal remainder = bigDecimal.remainder(bigDecimal2);
        Intrinsics.o(remainder, "this.remainder(other)");
        return remainder;
    }

    @InlineOnly
    private static final BigDecimal g(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        Intrinsics.p(bigDecimal, "<this>");
        Intrinsics.p(bigDecimal2, "other");
        BigDecimal multiply = bigDecimal.multiply(bigDecimal2);
        Intrinsics.o(multiply, "this.multiply(other)");
        return multiply;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal h(double d2) {
        return new BigDecimal(String.valueOf(d2));
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal i(double d2, MathContext mathContext) {
        Intrinsics.p(mathContext, "mathContext");
        return new BigDecimal(String.valueOf(d2), mathContext);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal j(float f2) {
        return new BigDecimal(String.valueOf(f2));
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal k(float f2, MathContext mathContext) {
        Intrinsics.p(mathContext, "mathContext");
        return new BigDecimal(String.valueOf(f2), mathContext);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal l(int i2) {
        BigDecimal valueOf = BigDecimal.valueOf((long) i2);
        Intrinsics.o(valueOf, "valueOf(this.toLong())");
        return valueOf;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal m(int i2, MathContext mathContext) {
        Intrinsics.p(mathContext, "mathContext");
        return new BigDecimal(i2, mathContext);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal n(long j2) {
        BigDecimal valueOf = BigDecimal.valueOf(j2);
        Intrinsics.o(valueOf, "valueOf(this)");
        return valueOf;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal o(long j2, MathContext mathContext) {
        Intrinsics.p(mathContext, "mathContext");
        return new BigDecimal(j2, mathContext);
    }

    @InlineOnly
    private static final BigDecimal p(BigDecimal bigDecimal) {
        Intrinsics.p(bigDecimal, "<this>");
        BigDecimal negate = bigDecimal.negate();
        Intrinsics.o(negate, "this.negate()");
        return negate;
    }
}
