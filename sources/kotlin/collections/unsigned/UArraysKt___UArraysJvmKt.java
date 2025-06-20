package kotlin.collections.unsigned;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u001b\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001f\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\b\u001a\u00020\u0007*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001f\u0010\f\u001a\u00020\u000b*\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001f\u0010\u0010\u001a\u00020\u000f*\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012*\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012*\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012*\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012*\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a2\u0010\u001e\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a2\u0010 \u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a2\u0010\"\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a2\u0010$\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a\u0018\u0010&\u001a\u0004\u0018\u00010\u0003*\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a\u0018\u0010(\u001a\u0004\u0018\u00010\u0007*\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a\u0018\u0010*\u001a\u0004\u0018\u00010\u000b*\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a\u0018\u0010,\u001a\u0004\u0018\u00010\u000f*\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a@\u00102\u001a\u0004\u0018\u00010\u0003\"\u000e\b\u0000\u0010/*\b\u0012\u0004\u0012\u00028\u00000.*\u00020\u00002\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u000000H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a@\u00104\u001a\u0004\u0018\u00010\u0007\"\u000e\b\u0000\u0010/*\b\u0012\u0004\u0012\u00028\u00000.*\u00020\u00062\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u000000H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a@\u00106\u001a\u0004\u0018\u00010\u000b\"\u000e\b\u0000\u0010/*\b\u0012\u0004\u0012\u00028\u00000.*\u00020\n2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u000000H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u00107\u001a@\u00108\u001a\u0004\u0018\u00010\u000f\"\u000e\b\u0000\u0010/*\b\u0012\u0004\u0012\u00028\u00000.*\u00020\u000e2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00028\u000000H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001a4\u0010=\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u001a\u0010<\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00030:j\n\u0012\u0006\b\u0000\u0012\u00020\u0003`;H\u0007ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a4\u0010?\u001a\u0004\u0018\u00010\u0007*\u00020\u00062\u001a\u0010<\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00070:j\n\u0012\u0006\b\u0000\u0012\u00020\u0007`;H\u0007ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001a4\u0010A\u001a\u0004\u0018\u00010\u000b*\u00020\n2\u001a\u0010<\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000b0:j\n\u0012\u0006\b\u0000\u0012\u00020\u000b`;H\u0007ø\u0001\u0000¢\u0006\u0004\bA\u0010B\u001a4\u0010C\u001a\u0004\u0018\u00010\u000f*\u00020\u000e2\u001a\u0010<\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000f0:j\n\u0012\u0006\b\u0000\u0012\u00020\u000f`;H\u0007ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001a\u0018\u0010E\u001a\u0004\u0018\u00010\u0003*\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\bE\u0010'\u001a\u0018\u0010F\u001a\u0004\u0018\u00010\u0007*\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\bF\u0010)\u001a\u0018\u0010G\u001a\u0004\u0018\u00010\u000b*\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\bG\u0010+\u001a\u0018\u0010H\u001a\u0004\u0018\u00010\u000f*\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\bH\u0010-\u001a@\u0010I\u001a\u0004\u0018\u00010\u0003\"\u000e\b\u0000\u0010/*\b\u0012\u0004\u0012\u00028\u00000.*\u00020\u00002\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u000000H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bI\u00103\u001a@\u0010J\u001a\u0004\u0018\u00010\u0007\"\u000e\b\u0000\u0010/*\b\u0012\u0004\u0012\u00028\u00000.*\u00020\u00062\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u000000H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bJ\u00105\u001a@\u0010K\u001a\u0004\u0018\u00010\u000b\"\u000e\b\u0000\u0010/*\b\u0012\u0004\u0012\u00028\u00000.*\u00020\n2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00028\u000000H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bK\u00107\u001a@\u0010L\u001a\u0004\u0018\u00010\u000f\"\u000e\b\u0000\u0010/*\b\u0012\u0004\u0012\u00028\u00000.*\u00020\u000e2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00028\u000000H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bL\u00109\u001a4\u0010M\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u001a\u0010<\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00030:j\n\u0012\u0006\b\u0000\u0012\u00020\u0003`;H\u0007ø\u0001\u0000¢\u0006\u0004\bM\u0010>\u001a4\u0010N\u001a\u0004\u0018\u00010\u0007*\u00020\u00062\u001a\u0010<\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00070:j\n\u0012\u0006\b\u0000\u0012\u00020\u0007`;H\u0007ø\u0001\u0000¢\u0006\u0004\bN\u0010@\u001a4\u0010O\u001a\u0004\u0018\u00010\u000b*\u00020\n2\u001a\u0010<\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000b0:j\n\u0012\u0006\b\u0000\u0012\u00020\u000b`;H\u0007ø\u0001\u0000¢\u0006\u0004\bO\u0010B\u001a4\u0010P\u001a\u0004\u0018\u00010\u000f*\u00020\u000e2\u001a\u0010<\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000f0:j\n\u0012\u0006\b\u0000\u0012\u00020\u000f`;H\u0007ø\u0001\u0000¢\u0006\u0004\bP\u0010D\u001a.\u0010R\u001a\u00020Q*\u00020\u00002\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020Q00H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bR\u0010S\u001a.\u0010T\u001a\u00020Q*\u00020\u00062\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020Q00H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010U\u001a.\u0010V\u001a\u00020Q*\u00020\n2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020Q00H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bV\u0010W\u001a.\u0010/\u001a\u00020Q*\u00020\u000e2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020Q00H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u0010X\u001a.\u0010Z\u001a\u00020Y*\u00020\u00002\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020Y00H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bZ\u0010[\u001a.\u0010\\\u001a\u00020Y*\u00020\u00062\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020Y00H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\\\u0010]\u001a.\u0010^\u001a\u00020Y*\u00020\n2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020Y00H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b^\u0010_\u001a.\u0010`\u001a\u00020Y*\u00020\u000e2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020Y00H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b`\u0010a\u0002\u000b\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006b"}, d2 = {"Lkotlin/UIntArray;", "", "index", "Lkotlin/UInt;", "o", "([II)I", "Lkotlin/ULongArray;", "Lkotlin/ULong;", "p", "([JI)J", "Lkotlin/UByteArray;", "Lkotlin/UByte;", "m", "([BI)B", "Lkotlin/UShortArray;", "Lkotlin/UShort;", "n", "([SI)S", "", "a", "([I)Ljava/util/List;", "c", "([J)Ljava/util/List;", "b", "([B)Ljava/util/List;", "d", "([S)Ljava/util/List;", "element", "fromIndex", "toIndex", "e", "([IIII)I", "i", "([JJII)I", "k", "([BBII)I", "g", "([SSII)I", "q", "([I)Lkotlin/UInt;", "s", "([J)Lkotlin/ULong;", "r", "([B)Lkotlin/UByte;", "t", "([S)Lkotlin/UShort;", "", "R", "Lkotlin/Function1;", "selector", "w", "([ILkotlin/jvm/functions/Function1;)Lkotlin/UInt;", "v", "([JLkotlin/jvm/functions/Function1;)Lkotlin/ULong;", "u", "([BLkotlin/jvm/functions/Function1;)Lkotlin/UByte;", "x", "([SLkotlin/jvm/functions/Function1;)Lkotlin/UShort;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "z", "([ILjava/util/Comparator;)Lkotlin/UInt;", "B", "([JLjava/util/Comparator;)Lkotlin/ULong;", "y", "([BLjava/util/Comparator;)Lkotlin/UByte;", "A", "([SLjava/util/Comparator;)Lkotlin/UShort;", "C", "E", "D", "F", "I", "H", "G", "J", "L", "N", "K", "M", "Ljava/math/BigDecimal;", "P", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Q", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "O", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "T", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "U", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "S", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "V", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/collections/unsigned/UArraysKt")
class UArraysKt___UArraysJvmKt {
    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ UShort A(short[] sArr, Comparator comparator) {
        Intrinsics.p(sArr, "$this$maxWith");
        Intrinsics.p(comparator, "comparator");
        return UArraysKt___UArraysKt.A6(sArr, comparator);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ ULong B(long[] jArr, Comparator comparator) {
        Intrinsics.p(jArr, "$this$maxWith");
        Intrinsics.p(comparator, "comparator");
        return UArraysKt___UArraysKt.B6(jArr, comparator);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @InlineOnly
    private static final /* synthetic */ <R extends Comparable<? super R>> UByte G(byte[] bArr, Function1<? super UByte, ? extends R> function1) {
        Intrinsics.p(bArr, "$this$minBy");
        Intrinsics.p(function1, "selector");
        if (UByteArray.B(bArr)) {
            return null;
        }
        byte o = UByteArray.o(bArr, 0);
        int qe = ArraysKt.qe(bArr);
        if (qe != 0) {
            Comparable comparable = (Comparable) function1.f(UByte.b(o));
            IntIterator n2 = new IntRange(1, qe).iterator();
            while (n2.hasNext()) {
                byte o2 = UByteArray.o(bArr, n2.b());
                Comparable comparable2 = (Comparable) function1.f(UByte.b(o2));
                if (comparable.compareTo(comparable2) > 0) {
                    o = o2;
                    comparable = comparable2;
                }
            }
        }
        return UByte.b(o);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @InlineOnly
    private static final /* synthetic */ <R extends Comparable<? super R>> ULong H(long[] jArr, Function1<? super ULong, ? extends R> function1) {
        Intrinsics.p(jArr, "$this$minBy");
        Intrinsics.p(function1, "selector");
        if (ULongArray.B(jArr)) {
            return null;
        }
        long o = ULongArray.o(jArr, 0);
        int ve = ArraysKt.ve(jArr);
        if (ve != 0) {
            Comparable comparable = (Comparable) function1.f(ULong.b(o));
            IntIterator n2 = new IntRange(1, ve).iterator();
            while (n2.hasNext()) {
                long o2 = ULongArray.o(jArr, n2.b());
                Comparable comparable2 = (Comparable) function1.f(ULong.b(o2));
                if (comparable.compareTo(comparable2) > 0) {
                    o = o2;
                    comparable = comparable2;
                }
            }
        }
        return ULong.b(o);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @InlineOnly
    private static final /* synthetic */ <R extends Comparable<? super R>> UInt I(int[] iArr, Function1<? super UInt, ? extends R> function1) {
        Intrinsics.p(iArr, "$this$minBy");
        Intrinsics.p(function1, "selector");
        if (UIntArray.B(iArr)) {
            return null;
        }
        int o = UIntArray.o(iArr, 0);
        int ue = ArraysKt.ue(iArr);
        if (ue != 0) {
            Comparable comparable = (Comparable) function1.f(UInt.b(o));
            IntIterator n2 = new IntRange(1, ue).iterator();
            while (n2.hasNext()) {
                int o2 = UIntArray.o(iArr, n2.b());
                Comparable comparable2 = (Comparable) function1.f(UInt.b(o2));
                if (comparable.compareTo(comparable2) > 0) {
                    o = o2;
                    comparable = comparable2;
                }
            }
        }
        return UInt.b(o);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @InlineOnly
    private static final /* synthetic */ <R extends Comparable<? super R>> UShort J(short[] sArr, Function1<? super UShort, ? extends R> function1) {
        Intrinsics.p(sArr, "$this$minBy");
        Intrinsics.p(function1, "selector");
        if (UShortArray.B(sArr)) {
            return null;
        }
        short o = UShortArray.o(sArr, 0);
        int xe = ArraysKt.xe(sArr);
        if (xe != 0) {
            Comparable comparable = (Comparable) function1.f(UShort.b(o));
            IntIterator n2 = new IntRange(1, xe).iterator();
            while (n2.hasNext()) {
                short o2 = UShortArray.o(sArr, n2.b());
                Comparable comparable2 = (Comparable) function1.f(UShort.b(o2));
                if (comparable.compareTo(comparable2) > 0) {
                    o = o2;
                    comparable = comparable2;
                }
            }
        }
        return UShort.b(o);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ UByte K(byte[] bArr, Comparator comparator) {
        Intrinsics.p(bArr, "$this$minWith");
        Intrinsics.p(comparator, "comparator");
        return UArraysKt___UArraysKt.C7(bArr, comparator);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ UInt L(int[] iArr, Comparator comparator) {
        Intrinsics.p(iArr, "$this$minWith");
        Intrinsics.p(comparator, "comparator");
        return UArraysKt___UArraysKt.D7(iArr, comparator);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ UShort M(short[] sArr, Comparator comparator) {
        Intrinsics.p(sArr, "$this$minWith");
        Intrinsics.p(comparator, "comparator");
        return UArraysKt___UArraysKt.E7(sArr, comparator);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ ULong N(long[] jArr, Comparator comparator) {
        Intrinsics.p(jArr, "$this$minWith");
        Intrinsics.p(comparator, "comparator");
        return UArraysKt___UArraysKt.F7(jArr, comparator);
    }

    @ExperimentalUnsignedTypes
    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    private static final BigDecimal O(byte[] bArr, Function1<? super UByte, ? extends BigDecimal> function1) {
        Intrinsics.p(bArr, "$this$sumOf");
        Intrinsics.p(function1, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0);
        Intrinsics.o(valueOf, "valueOf(this.toLong())");
        int r = UByteArray.r(bArr);
        for (int i2 = 0; i2 < r; i2++) {
            valueOf = valueOf.add((BigDecimal) function1.f(UByte.b(UByteArray.o(bArr, i2))));
            Intrinsics.o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @ExperimentalUnsignedTypes
    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    private static final BigDecimal P(int[] iArr, Function1<? super UInt, ? extends BigDecimal> function1) {
        Intrinsics.p(iArr, "$this$sumOf");
        Intrinsics.p(function1, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0);
        Intrinsics.o(valueOf, "valueOf(this.toLong())");
        int r = UIntArray.r(iArr);
        for (int i2 = 0; i2 < r; i2++) {
            valueOf = valueOf.add((BigDecimal) function1.f(UInt.b(UIntArray.o(iArr, i2))));
            Intrinsics.o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @ExperimentalUnsignedTypes
    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    private static final BigDecimal Q(long[] jArr, Function1<? super ULong, ? extends BigDecimal> function1) {
        Intrinsics.p(jArr, "$this$sumOf");
        Intrinsics.p(function1, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0);
        Intrinsics.o(valueOf, "valueOf(this.toLong())");
        int r = ULongArray.r(jArr);
        for (int i2 = 0; i2 < r; i2++) {
            valueOf = valueOf.add((BigDecimal) function1.f(ULong.b(ULongArray.o(jArr, i2))));
            Intrinsics.o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @ExperimentalUnsignedTypes
    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    private static final BigDecimal R(short[] sArr, Function1<? super UShort, ? extends BigDecimal> function1) {
        Intrinsics.p(sArr, "$this$sumOf");
        Intrinsics.p(function1, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0);
        Intrinsics.o(valueOf, "valueOf(this.toLong())");
        int r = UShortArray.r(sArr);
        for (int i2 = 0; i2 < r; i2++) {
            valueOf = valueOf.add((BigDecimal) function1.f(UShort.b(UShortArray.o(sArr, i2))));
            Intrinsics.o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @ExperimentalUnsignedTypes
    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    private static final BigInteger S(byte[] bArr, Function1<? super UByte, ? extends BigInteger> function1) {
        Intrinsics.p(bArr, "$this$sumOf");
        Intrinsics.p(function1, "selector");
        BigInteger valueOf = BigInteger.valueOf(0);
        Intrinsics.o(valueOf, "valueOf(this.toLong())");
        int r = UByteArray.r(bArr);
        for (int i2 = 0; i2 < r; i2++) {
            valueOf = valueOf.add((BigInteger) function1.f(UByte.b(UByteArray.o(bArr, i2))));
            Intrinsics.o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @ExperimentalUnsignedTypes
    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    private static final BigInteger T(int[] iArr, Function1<? super UInt, ? extends BigInteger> function1) {
        Intrinsics.p(iArr, "$this$sumOf");
        Intrinsics.p(function1, "selector");
        BigInteger valueOf = BigInteger.valueOf(0);
        Intrinsics.o(valueOf, "valueOf(this.toLong())");
        int r = UIntArray.r(iArr);
        for (int i2 = 0; i2 < r; i2++) {
            valueOf = valueOf.add((BigInteger) function1.f(UInt.b(UIntArray.o(iArr, i2))));
            Intrinsics.o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @ExperimentalUnsignedTypes
    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    private static final BigInteger U(long[] jArr, Function1<? super ULong, ? extends BigInteger> function1) {
        Intrinsics.p(jArr, "$this$sumOf");
        Intrinsics.p(function1, "selector");
        BigInteger valueOf = BigInteger.valueOf(0);
        Intrinsics.o(valueOf, "valueOf(this.toLong())");
        int r = ULongArray.r(jArr);
        for (int i2 = 0; i2 < r; i2++) {
            valueOf = valueOf.add((BigInteger) function1.f(ULong.b(ULongArray.o(jArr, i2))));
            Intrinsics.o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @ExperimentalUnsignedTypes
    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    private static final BigInteger V(short[] sArr, Function1<? super UShort, ? extends BigInteger> function1) {
        Intrinsics.p(sArr, "$this$sumOf");
        Intrinsics.p(function1, "selector");
        BigInteger valueOf = BigInteger.valueOf(0);
        Intrinsics.o(valueOf, "valueOf(this.toLong())");
        int r = UShortArray.r(sArr);
        for (int i2 = 0; i2 < r; i2++) {
            valueOf = valueOf.add((BigInteger) function1.f(UShort.b(UShortArray.o(sArr, i2))));
            Intrinsics.o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final List<UInt> a(@NotNull int[] iArr) {
        Intrinsics.p(iArr, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$1(iArr);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final List<UByte> b(@NotNull byte[] bArr) {
        Intrinsics.p(bArr, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$3(bArr);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final List<ULong> c(@NotNull long[] jArr) {
        Intrinsics.p(jArr, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$2(jArr);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final List<UShort> d(@NotNull short[] sArr) {
        Intrinsics.p(sArr, "$this$asList");
        return new UArraysKt___UArraysJvmKt$asList$4(sArr);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final int e(@NotNull int[] iArr, int i2, int i3, int i4) {
        Intrinsics.p(iArr, "$this$binarySearch");
        AbstractList.s.d(i3, i4, UIntArray.r(iArr));
        int i5 = i4 - 1;
        while (i3 <= i5) {
            int i6 = (i3 + i5) >>> 1;
            int c2 = UnsignedKt.c(iArr[i6], i2);
            if (c2 < 0) {
                i3 = i6 + 1;
            } else if (c2 <= 0) {
                return i6;
            } else {
                i5 = i6 - 1;
            }
        }
        return -(i3 + 1);
    }

    public static /* synthetic */ int f(int[] iArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            i4 = UIntArray.r(iArr);
        }
        return e(iArr, i2, i3, i4);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final int g(@NotNull short[] sArr, short s, int i2, int i3) {
        Intrinsics.p(sArr, "$this$binarySearch");
        AbstractList.s.d(i2, i3, UShortArray.r(sArr));
        short s2 = s & UShort.Z;
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int c2 = UnsignedKt.c(sArr[i5], s2);
            if (c2 < 0) {
                i2 = i5 + 1;
            } else if (c2 <= 0) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static /* synthetic */ int h(short[] sArr, short s, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = UShortArray.r(sArr);
        }
        return g(sArr, s, i2, i3);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final int i(@NotNull long[] jArr, long j2, int i2, int i3) {
        Intrinsics.p(jArr, "$this$binarySearch");
        AbstractList.s.d(i2, i3, ULongArray.r(jArr));
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int g2 = UnsignedKt.g(jArr[i5], j2);
            if (g2 < 0) {
                i2 = i5 + 1;
            } else if (g2 <= 0) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static /* synthetic */ int j(long[] jArr, long j2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = ULongArray.r(jArr);
        }
        return i(jArr, j2, i2, i3);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    public static final int k(@NotNull byte[] bArr, byte b2, int i2, int i3) {
        Intrinsics.p(bArr, "$this$binarySearch");
        AbstractList.s.d(i2, i3, UByteArray.r(bArr));
        byte b3 = b2 & 255;
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int c2 = UnsignedKt.c(bArr[i5], b3);
            if (c2 < 0) {
                i2 = i5 + 1;
            } else if (c2 <= 0) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static /* synthetic */ int l(byte[] bArr, byte b2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = UByteArray.r(bArr);
        }
        return k(bArr, b2, i2, i3);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final byte m(byte[] bArr, int i2) {
        Intrinsics.p(bArr, "$this$elementAt");
        return UByteArray.o(bArr, i2);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final short n(short[] sArr, int i2) {
        Intrinsics.p(sArr, "$this$elementAt");
        return UShortArray.o(sArr, i2);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final int o(int[] iArr, int i2) {
        Intrinsics.p(iArr, "$this$elementAt");
        return UIntArray.o(iArr, i2);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final long p(long[] jArr, int i2) {
        Intrinsics.p(jArr, "$this$elementAt");
        return ULongArray.o(jArr, i2);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @InlineOnly
    private static final /* synthetic */ <R extends Comparable<? super R>> UByte u(byte[] bArr, Function1<? super UByte, ? extends R> function1) {
        Intrinsics.p(bArr, "$this$maxBy");
        Intrinsics.p(function1, "selector");
        if (UByteArray.B(bArr)) {
            return null;
        }
        byte o = UByteArray.o(bArr, 0);
        int qe = ArraysKt.qe(bArr);
        if (qe != 0) {
            Comparable comparable = (Comparable) function1.f(UByte.b(o));
            IntIterator n2 = new IntRange(1, qe).iterator();
            while (n2.hasNext()) {
                byte o2 = UByteArray.o(bArr, n2.b());
                Comparable comparable2 = (Comparable) function1.f(UByte.b(o2));
                if (comparable.compareTo(comparable2) < 0) {
                    o = o2;
                    comparable = comparable2;
                }
            }
        }
        return UByte.b(o);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @InlineOnly
    private static final /* synthetic */ <R extends Comparable<? super R>> ULong v(long[] jArr, Function1<? super ULong, ? extends R> function1) {
        Intrinsics.p(jArr, "$this$maxBy");
        Intrinsics.p(function1, "selector");
        if (ULongArray.B(jArr)) {
            return null;
        }
        long o = ULongArray.o(jArr, 0);
        int ve = ArraysKt.ve(jArr);
        if (ve != 0) {
            Comparable comparable = (Comparable) function1.f(ULong.b(o));
            IntIterator n2 = new IntRange(1, ve).iterator();
            while (n2.hasNext()) {
                long o2 = ULongArray.o(jArr, n2.b());
                Comparable comparable2 = (Comparable) function1.f(ULong.b(o2));
                if (comparable.compareTo(comparable2) < 0) {
                    o = o2;
                    comparable = comparable2;
                }
            }
        }
        return ULong.b(o);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @InlineOnly
    private static final /* synthetic */ <R extends Comparable<? super R>> UInt w(int[] iArr, Function1<? super UInt, ? extends R> function1) {
        Intrinsics.p(iArr, "$this$maxBy");
        Intrinsics.p(function1, "selector");
        if (UIntArray.B(iArr)) {
            return null;
        }
        int o = UIntArray.o(iArr, 0);
        int ue = ArraysKt.ue(iArr);
        if (ue != 0) {
            Comparable comparable = (Comparable) function1.f(UInt.b(o));
            IntIterator n2 = new IntRange(1, ue).iterator();
            while (n2.hasNext()) {
                int o2 = UIntArray.o(iArr, n2.b());
                Comparable comparable2 = (Comparable) function1.f(UInt.b(o2));
                if (comparable.compareTo(comparable2) < 0) {
                    o = o2;
                    comparable = comparable2;
                }
            }
        }
        return UInt.b(o);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @InlineOnly
    private static final /* synthetic */ <R extends Comparable<? super R>> UShort x(short[] sArr, Function1<? super UShort, ? extends R> function1) {
        Intrinsics.p(sArr, "$this$maxBy");
        Intrinsics.p(function1, "selector");
        if (UShortArray.B(sArr)) {
            return null;
        }
        short o = UShortArray.o(sArr, 0);
        int xe = ArraysKt.xe(sArr);
        if (xe != 0) {
            Comparable comparable = (Comparable) function1.f(UShort.b(o));
            IntIterator n2 = new IntRange(1, xe).iterator();
            while (n2.hasNext()) {
                short o2 = UShortArray.o(sArr, n2.b());
                Comparable comparable2 = (Comparable) function1.f(UShort.b(o2));
                if (comparable.compareTo(comparable2) < 0) {
                    o = o2;
                    comparable = comparable2;
                }
            }
        }
        return UShort.b(o);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ UByte y(byte[] bArr, Comparator comparator) {
        Intrinsics.p(bArr, "$this$maxWith");
        Intrinsics.p(comparator, "comparator");
        return UArraysKt___UArraysKt.y6(bArr, comparator);
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    public static final /* synthetic */ UInt z(int[] iArr, Comparator comparator) {
        Intrinsics.p(iArr, "$this$maxWith");
        Intrinsics.p(comparator, "comparator");
        return UArraysKt___UArraysKt.z6(iArr, comparator);
    }
}
