package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandomKt;
import kotlin.ranges.UIntProgression;
import kotlin.ranges.ULongProgression;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0016\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0016\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0018\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0018\u0010\n\u001a\u0004\u0018\u00010\u0005*\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0016\u0010\f\u001a\u00020\u0001*\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0003\u001a\u0016\u0010\r\u001a\u00020\u0005*\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0007\u001a\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\t\u001a\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u0005*\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u000b\u001a\u0017\u0010\u0011\u001a\u00020\u0001*\u00020\u0010H\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0017\u0010\u0014\u001a\u00020\u0005*\u00020\u0013H\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001e\u0010\u0018\u001a\u00020\u0001*\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001e\u0010\u001a\u001a\u00020\u0005*\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u0001*\u00020\u0010H\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u0005*\u00020\u0013H\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a \u0010 \u001a\u0004\u0018\u00010\u0001*\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a \u0010\"\u001a\u0004\u0018\u00010\u0005*\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a!\u0010&\u001a\u00020%*\u00020\u00102\b\u0010$\u001a\u0004\u0018\u00010\u0001H\nø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a!\u0010(\u001a\u00020%*\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010\u0005H\nø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a\u001f\u0010,\u001a\u00020%*\u00020\u00102\u0006\u0010+\u001a\u00020*H\u0002ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a\u001f\u0010.\u001a\u00020%*\u00020\u00132\u0006\u0010+\u001a\u00020*H\u0002ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a\u001f\u00100\u001a\u00020%*\u00020\u00132\u0006\u0010+\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a\u001f\u00102\u001a\u00020%*\u00020\u00102\u0006\u0010+\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a\u001f\u00105\u001a\u00020%*\u00020\u00102\u0006\u0010+\u001a\u000204H\u0002ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a\u001f\u00107\u001a\u00020%*\u00020\u00132\u0006\u0010+\u001a\u000204H\u0002ø\u0001\u0000¢\u0006\u0004\b7\u00108\u001a\u001f\u0010:\u001a\u00020\u0000*\u00020*2\u0006\u00109\u001a\u00020*H\u0004ø\u0001\u0000¢\u0006\u0004\b:\u0010;\u001a\u001f\u0010<\u001a\u00020\u0000*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0004ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a\u001f\u0010>\u001a\u00020\u0004*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0004ø\u0001\u0000¢\u0006\u0004\b>\u0010?\u001a\u001f\u0010@\u001a\u00020\u0000*\u0002042\u0006\u00109\u001a\u000204H\u0004ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a\u0013\u0010B\u001a\u00020\u0000*\u00020\u0000H\u0007¢\u0006\u0004\bB\u0010C\u001a\u0013\u0010D\u001a\u00020\u0004*\u00020\u0004H\u0007¢\u0006\u0004\bD\u0010E\u001a\u001c\u0010H\u001a\u00020\u0000*\u00020\u00002\u0006\u0010G\u001a\u00020FH\u0004¢\u0006\u0004\bH\u0010I\u001a\u001c\u0010K\u001a\u00020\u0004*\u00020\u00042\u0006\u0010G\u001a\u00020JH\u0004¢\u0006\u0004\bK\u0010L\u001a\u001f\u0010M\u001a\u00020\u0010*\u00020*2\u0006\u00109\u001a\u00020*H\u0004ø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a\u001f\u0010O\u001a\u00020\u0010*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0004ø\u0001\u0000¢\u0006\u0004\bO\u0010P\u001a\u001f\u0010Q\u001a\u00020\u0013*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0004ø\u0001\u0000¢\u0006\u0004\bQ\u0010R\u001a\u001f\u0010S\u001a\u00020\u0010*\u0002042\u0006\u00109\u001a\u000204H\u0004ø\u0001\u0000¢\u0006\u0004\bS\u0010T\u001a\u001e\u0010V\u001a\u00020\u0001*\u00020\u00012\u0006\u0010U\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\bV\u0010W\u001a\u001e\u0010X\u001a\u00020\u0005*\u00020\u00052\u0006\u0010U\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\bX\u0010Y\u001a\u001e\u0010Z\u001a\u00020**\u00020*2\u0006\u0010U\u001a\u00020*H\u0007ø\u0001\u0000¢\u0006\u0004\bZ\u0010[\u001a\u001e\u0010\\\u001a\u000204*\u0002042\u0006\u0010U\u001a\u000204H\u0007ø\u0001\u0000¢\u0006\u0004\b\\\u0010]\u001a\u001e\u0010_\u001a\u00020\u0001*\u00020\u00012\u0006\u0010^\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b_\u0010W\u001a\u001e\u0010`\u001a\u00020\u0005*\u00020\u00052\u0006\u0010^\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b`\u0010Y\u001a\u001e\u0010a\u001a\u00020**\u00020*2\u0006\u0010^\u001a\u00020*H\u0007ø\u0001\u0000¢\u0006\u0004\ba\u0010[\u001a\u001e\u0010b\u001a\u000204*\u0002042\u0006\u0010^\u001a\u000204H\u0007ø\u0001\u0000¢\u0006\u0004\bb\u0010]\u001a&\u0010c\u001a\u00020\u0001*\u00020\u00012\u0006\u0010U\u001a\u00020\u00012\u0006\u0010^\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\bc\u0010d\u001a&\u0010e\u001a\u00020\u0005*\u00020\u00052\u0006\u0010U\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\be\u0010f\u001a&\u0010g\u001a\u00020**\u00020*2\u0006\u0010U\u001a\u00020*2\u0006\u0010^\u001a\u00020*H\u0007ø\u0001\u0000¢\u0006\u0004\bg\u0010h\u001a&\u0010i\u001a\u000204*\u0002042\u0006\u0010U\u001a\u0002042\u0006\u0010^\u001a\u000204H\u0007ø\u0001\u0000¢\u0006\u0004\bi\u0010j\u001a$\u0010m\u001a\u00020\u0001*\u00020\u00012\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00010kH\u0007ø\u0001\u0000¢\u0006\u0004\bm\u0010n\u001a$\u0010o\u001a\u00020\u0005*\u00020\u00052\f\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00050kH\u0007ø\u0001\u0000¢\u0006\u0004\bo\u0010p\u0002\u0004\n\u0002\b\u0019¨\u0006q"}, d2 = {"Lkotlin/ranges/UIntProgression;", "Lkotlin/UInt;", "A", "(Lkotlin/ranges/UIntProgression;)I", "Lkotlin/ranges/ULongProgression;", "Lkotlin/ULong;", "B", "(Lkotlin/ranges/ULongProgression;)J", "C", "(Lkotlin/ranges/UIntProgression;)Lkotlin/UInt;", "D", "(Lkotlin/ranges/ULongProgression;)Lkotlin/ULong;", "E", "F", "G", "H", "Lkotlin/ranges/UIntRange;", "I", "(Lkotlin/ranges/UIntRange;)I", "Lkotlin/ranges/ULongRange;", "K", "(Lkotlin/ranges/ULongRange;)J", "Lkotlin/random/Random;", "random", "J", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "L", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "M", "(Lkotlin/ranges/UIntRange;)Lkotlin/UInt;", "O", "(Lkotlin/ranges/ULongRange;)Lkotlin/ULong;", "N", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)Lkotlin/UInt;", "P", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)Lkotlin/ULong;", "element", "", "t", "(Lkotlin/ranges/UIntRange;Lkotlin/UInt;)Z", "p", "(Lkotlin/ranges/ULongRange;Lkotlin/ULong;)Z", "Lkotlin/UByte;", "value", "o", "(Lkotlin/ranges/UIntRange;B)Z", "r", "(Lkotlin/ranges/ULongRange;B)Z", "q", "(Lkotlin/ranges/ULongRange;I)Z", "u", "(Lkotlin/ranges/UIntRange;J)Z", "Lkotlin/UShort;", "s", "(Lkotlin/ranges/UIntRange;S)Z", "v", "(Lkotlin/ranges/ULongRange;S)Z", "to", "y", "(BB)Lkotlin/ranges/UIntProgression;", "x", "(II)Lkotlin/ranges/UIntProgression;", "z", "(JJ)Lkotlin/ranges/ULongProgression;", "w", "(SS)Lkotlin/ranges/UIntProgression;", "Q", "(Lkotlin/ranges/UIntProgression;)Lkotlin/ranges/UIntProgression;", "R", "(Lkotlin/ranges/ULongProgression;)Lkotlin/ranges/ULongProgression;", "", "step", "S", "(Lkotlin/ranges/UIntProgression;I)Lkotlin/ranges/UIntProgression;", "", "T", "(Lkotlin/ranges/ULongProgression;J)Lkotlin/ranges/ULongProgression;", "W", "(BB)Lkotlin/ranges/UIntRange;", "V", "(II)Lkotlin/ranges/UIntRange;", "X", "(JJ)Lkotlin/ranges/ULongRange;", "U", "(SS)Lkotlin/ranges/UIntRange;", "minimumValue", "b", "(II)I", "d", "(JJ)J", "c", "(BB)B", "a", "(SS)S", "maximumValue", "f", "h", "g", "e", "k", "(III)I", "m", "(JJJ)J", "l", "(BBB)B", "j", "(SSS)S", "Lkotlin/ranges/ClosedRange;", "range", "n", "(ILkotlin/ranges/ClosedRange;)I", "i", "(JLkotlin/ranges/ClosedRange;)J", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/ranges/URangesKt")
class URangesKt___URangesKt {
    @SinceKotlin(version = "1.7")
    public static final int A(@NotNull UIntProgression uIntProgression) {
        Intrinsics.p(uIntProgression, "<this>");
        if (!uIntProgression.isEmpty()) {
            return uIntProgression.j();
        }
        throw new NoSuchElementException("Progression " + uIntProgression + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    public static final long B(@NotNull ULongProgression uLongProgression) {
        Intrinsics.p(uLongProgression, "<this>");
        if (!uLongProgression.isEmpty()) {
            return uLongProgression.j();
        }
        throw new NoSuchElementException("Progression " + uLongProgression + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final UInt C(@NotNull UIntProgression uIntProgression) {
        Intrinsics.p(uIntProgression, "<this>");
        if (uIntProgression.isEmpty()) {
            return null;
        }
        return UInt.b(uIntProgression.j());
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final ULong D(@NotNull ULongProgression uLongProgression) {
        Intrinsics.p(uLongProgression, "<this>");
        if (uLongProgression.isEmpty()) {
            return null;
        }
        return ULong.b(uLongProgression.j());
    }

    @SinceKotlin(version = "1.7")
    public static final int E(@NotNull UIntProgression uIntProgression) {
        Intrinsics.p(uIntProgression, "<this>");
        if (!uIntProgression.isEmpty()) {
            return uIntProgression.k();
        }
        throw new NoSuchElementException("Progression " + uIntProgression + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    public static final long F(@NotNull ULongProgression uLongProgression) {
        Intrinsics.p(uLongProgression, "<this>");
        if (!uLongProgression.isEmpty()) {
            return uLongProgression.k();
        }
        throw new NoSuchElementException("Progression " + uLongProgression + " is empty.");
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final UInt G(@NotNull UIntProgression uIntProgression) {
        Intrinsics.p(uIntProgression, "<this>");
        if (uIntProgression.isEmpty()) {
            return null;
        }
        return UInt.b(uIntProgression.k());
    }

    @SinceKotlin(version = "1.7")
    @Nullable
    public static final ULong H(@NotNull ULongProgression uLongProgression) {
        Intrinsics.p(uLongProgression, "<this>");
        if (uLongProgression.isEmpty()) {
            return null;
        }
        return ULong.b(uLongProgression.k());
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final int I(UIntRange uIntRange) {
        Intrinsics.p(uIntRange, "<this>");
        return J(uIntRange, Random.s);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int J(@NotNull UIntRange uIntRange, @NotNull Random random) {
        Intrinsics.p(uIntRange, "<this>");
        Intrinsics.p(random, "random");
        try {
            return URandomKt.h(random, uIntRange);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final long K(ULongRange uLongRange) {
        Intrinsics.p(uLongRange, "<this>");
        return L(uLongRange, Random.s);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long L(@NotNull ULongRange uLongRange, @NotNull Random random) {
        Intrinsics.p(uLongRange, "<this>");
        Intrinsics.p(random, "random");
        try {
            return URandomKt.l(random, uLongRange);
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    private static final UInt M(UIntRange uIntRange) {
        Intrinsics.p(uIntRange, "<this>");
        return N(uIntRange, Random.s);
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    public static final UInt N(@NotNull UIntRange uIntRange, @NotNull Random random) {
        Intrinsics.p(uIntRange, "<this>");
        Intrinsics.p(random, "random");
        if (uIntRange.isEmpty()) {
            return null;
        }
        return UInt.b(URandomKt.h(random, uIntRange));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    private static final ULong O(ULongRange uLongRange) {
        Intrinsics.p(uLongRange, "<this>");
        return P(uLongRange, Random.s);
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    public static final ULong P(@NotNull ULongRange uLongRange, @NotNull Random random) {
        Intrinsics.p(uLongRange, "<this>");
        Intrinsics.p(random, "random");
        if (uLongRange.isEmpty()) {
            return null;
        }
        return ULong.b(URandomKt.l(random, uLongRange));
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UIntProgression Q(@NotNull UIntProgression uIntProgression) {
        Intrinsics.p(uIntProgression, "<this>");
        return UIntProgression.Z.a(uIntProgression.k(), uIntProgression.j(), -uIntProgression.m());
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final ULongProgression R(@NotNull ULongProgression uLongProgression) {
        Intrinsics.p(uLongProgression, "<this>");
        return ULongProgression.Z.a(uLongProgression.k(), uLongProgression.j(), -uLongProgression.m());
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UIntProgression S(@NotNull UIntProgression uIntProgression, int i2) {
        Intrinsics.p(uIntProgression, "<this>");
        RangesKt__RangesKt.a(i2 > 0, Integer.valueOf(i2));
        UIntProgression.Companion companion = UIntProgression.Z;
        int j2 = uIntProgression.j();
        int k2 = uIntProgression.k();
        if (uIntProgression.m() <= 0) {
            i2 = -i2;
        }
        return companion.a(j2, k2, i2);
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final ULongProgression T(@NotNull ULongProgression uLongProgression, long j2) {
        Intrinsics.p(uLongProgression, "<this>");
        RangesKt__RangesKt.a(j2 > 0, Long.valueOf(j2));
        ULongProgression.Companion companion = ULongProgression.Z;
        long j3 = uLongProgression.j();
        long k2 = uLongProgression.k();
        if (uLongProgression.m() <= 0) {
            j2 = -j2;
        }
        return companion.a(j3, k2, j2);
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UIntRange U(short s, short s2) {
        short s3 = s2 & UShort.Z;
        return Intrinsics.t(s3, 0) <= 0 ? UIntRange.X2.a() : new UIntRange(UInt.i(s & UShort.Z), UInt.i(UInt.i(s3) - 1), (DefaultConstructorMarker) null);
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static UIntRange V(int i2, int i3) {
        return Integer.compare(i3 ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE) <= 0 ? UIntRange.X2.a() : new UIntRange(i2, UInt.i(i3 - 1), (DefaultConstructorMarker) null);
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UIntRange W(byte b2, byte b3) {
        byte b4 = b3 & 255;
        return Intrinsics.t(b4, 0) <= 0 ? UIntRange.X2.a() : new UIntRange(UInt.i(b2 & 255), UInt.i(UInt.i(b4) - 1), (DefaultConstructorMarker) null);
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static ULongRange X(long j2, long j3) {
        if (Long.compare(j3 ^ Long.MIN_VALUE, 0 ^ Long.MIN_VALUE) <= 0) {
            return ULongRange.X2.a();
        }
        return new ULongRange(j2, ULong.i(j3 - ULong.i(((long) 1) & InternalZipConstants.f30717k)), (DefaultConstructorMarker) null);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final short a(short s, short s2) {
        return Intrinsics.t(s & UShort.Z, 65535 & s2) < 0 ? s2 : s;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int b(int i2, int i3) {
        return Integer.compare(i2 ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE) < 0 ? i3 : i2;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final byte c(byte b2, byte b3) {
        return Intrinsics.t(b2 & 255, b3 & 255) < 0 ? b3 : b2;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long d(long j2, long j3) {
        return Long.compare(j2 ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE) < 0 ? j3 : j2;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final short e(short s, short s2) {
        return Intrinsics.t(s & UShort.Z, 65535 & s2) > 0 ? s2 : s;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int f(int i2, int i3) {
        return Integer.compare(i2 ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE) > 0 ? i3 : i2;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final byte g(byte b2, byte b3) {
        return Intrinsics.t(b2 & 255, b3 & 255) > 0 ? b3 : b2;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long h(long j2, long j3) {
        return Long.compare(j2 ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE) > 0 ? j3 : j2;
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [kotlin.ranges.ClosedRange<kotlin.ULong>, java.lang.Object, kotlin.ranges.ClosedRange] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.5")
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long i(long r2, @org.jetbrains.annotations.NotNull kotlin.ranges.ClosedRange<kotlin.ULong> r4) {
        /*
            java.lang.String r0 = "range"
            kotlin.jvm.internal.Intrinsics.p(r4, r0)
            boolean r0 = r4 instanceof kotlin.ranges.ClosedFloatingPointRange
            if (r0 == 0) goto L_0x001a
            kotlin.ULong r2 = kotlin.ULong.b(r2)
            kotlin.ranges.ClosedFloatingPointRange r4 = (kotlin.ranges.ClosedFloatingPointRange) r4
            java.lang.Comparable r2 = kotlin.ranges.RangesKt___RangesKt.N(r2, r4)
            kotlin.ULong r2 = (kotlin.ULong) r2
            long r2 = r2.v0()
            return r2
        L_0x001a:
            boolean r0 = r4.isEmpty()
            if (r0 != 0) goto L_0x0051
            java.lang.Comparable r0 = r4.c()
            kotlin.ULong r0 = (kotlin.ULong) r0
            long r0 = r0.v0()
            int r0 = java.lang.Long.compare(r2 ^ Long.MIN_VALUE, r0 ^ Long.MIN_VALUE)
            if (r0 >= 0) goto L_0x003b
            java.lang.Comparable r2 = r4.c()
        L_0x0034:
            kotlin.ULong r2 = (kotlin.ULong) r2
            long r2 = r2.v0()
            goto L_0x0050
        L_0x003b:
            java.lang.Comparable r0 = r4.h()
            kotlin.ULong r0 = (kotlin.ULong) r0
            long r0 = r0.v0()
            int r0 = java.lang.Long.compare(r2 ^ Long.MIN_VALUE, r0 ^ Long.MIN_VALUE)
            if (r0 <= 0) goto L_0x0050
            java.lang.Comparable r2 = r4.h()
            goto L_0x0034
        L_0x0050:
            return r2
        L_0x0051:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "Cannot coerce value to an empty range: "
            r3.append(r0)
            r3.append(r4)
            r4 = 46
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.URangesKt___URangesKt.i(long, kotlin.ranges.ClosedRange):long");
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final short j(short s, short s2, short s3) {
        short s4 = s2 & UShort.Z;
        short s5 = s3 & UShort.Z;
        if (Intrinsics.t(s4, s5) <= 0) {
            short s6 = 65535 & s;
            if (Intrinsics.t(s6, s4) < 0) {
                return s2;
            }
            return Intrinsics.t(s6, s5) > 0 ? s3 : s;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UShort.j0(s3) + " is less than minimum " + UShort.j0(s2) + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int k(int i2, int i3, int i4) {
        if (Integer.compare(i3 ^ Integer.MIN_VALUE, i4 ^ Integer.MIN_VALUE) > 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UInt.m0(i4) + " is less than minimum " + UInt.m0(i3) + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        } else if (Integer.compare(i2 ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE) < 0) {
            return i3;
        } else {
            return Integer.compare(i2 ^ Integer.MIN_VALUE, i4 ^ Integer.MIN_VALUE) > 0 ? i4 : i2;
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final byte l(byte b2, byte b3, byte b4) {
        byte b5 = b3 & 255;
        byte b6 = b4 & 255;
        if (Intrinsics.t(b5, b6) <= 0) {
            byte b7 = b2 & 255;
            if (Intrinsics.t(b7, b5) < 0) {
                return b3;
            }
            return Intrinsics.t(b7, b6) > 0 ? b4 : b2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + UByte.j0(b4) + " is less than minimum " + UByte.j0(b3) + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long m(long j2, long j3, long j4) {
        if (Long.compare(j3 ^ Long.MIN_VALUE, j4 ^ Long.MIN_VALUE) > 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ULong.m0(j4) + " is less than minimum " + ULong.m0(j3) + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        } else if (Long.compare(j2 ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE) < 0) {
            return j3;
        } else {
            return Long.compare(j2 ^ Long.MIN_VALUE, j4 ^ Long.MIN_VALUE) > 0 ? j4 : j2;
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [kotlin.ranges.ClosedRange<kotlin.UInt>, java.lang.Object, kotlin.ranges.ClosedRange] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.5")
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int n(int r2, @org.jetbrains.annotations.NotNull kotlin.ranges.ClosedRange<kotlin.UInt> r3) {
        /*
            java.lang.String r0 = "range"
            kotlin.jvm.internal.Intrinsics.p(r3, r0)
            boolean r0 = r3 instanceof kotlin.ranges.ClosedFloatingPointRange
            if (r0 == 0) goto L_0x001a
            kotlin.UInt r2 = kotlin.UInt.b(r2)
            kotlin.ranges.ClosedFloatingPointRange r3 = (kotlin.ranges.ClosedFloatingPointRange) r3
            java.lang.Comparable r2 = kotlin.ranges.RangesKt___RangesKt.N(r2, r3)
            kotlin.UInt r2 = (kotlin.UInt) r2
            int r2 = r2.v0()
            return r2
        L_0x001a:
            boolean r0 = r3.isEmpty()
            if (r0 != 0) goto L_0x0051
            java.lang.Comparable r0 = r3.c()
            kotlin.UInt r0 = (kotlin.UInt) r0
            int r0 = r0.v0()
            int r0 = java.lang.Integer.compare(r2 ^ Integer.MIN_VALUE, r0 ^ Integer.MIN_VALUE)
            if (r0 >= 0) goto L_0x003b
            java.lang.Comparable r2 = r3.c()
        L_0x0034:
            kotlin.UInt r2 = (kotlin.UInt) r2
            int r2 = r2.v0()
            goto L_0x0050
        L_0x003b:
            java.lang.Comparable r0 = r3.h()
            kotlin.UInt r0 = (kotlin.UInt) r0
            int r0 = r0.v0()
            int r0 = java.lang.Integer.compare(r2 ^ Integer.MIN_VALUE, r0 ^ Integer.MIN_VALUE)
            if (r0 <= 0) goto L_0x0050
            java.lang.Comparable r2 = r3.h()
            goto L_0x0034
        L_0x0050:
            return r2
        L_0x0051:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot coerce value to an empty range: "
            r0.append(r1)
            r0.append(r3)
            r3 = 46
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.URangesKt___URangesKt.n(int, kotlin.ranges.ClosedRange):int");
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final boolean o(@NotNull UIntRange uIntRange, byte b2) {
        Intrinsics.p(uIntRange, "$this$contains");
        return uIntRange.o(UInt.i(b2 & 255));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final boolean p(ULongRange uLongRange, ULong uLong) {
        Intrinsics.p(uLongRange, "$this$contains");
        return uLong != null && uLongRange.o(uLong.v0());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final boolean q(@NotNull ULongRange uLongRange, int i2) {
        Intrinsics.p(uLongRange, "$this$contains");
        return uLongRange.o(ULong.i(((long) i2) & InternalZipConstants.f30717k));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final boolean r(@NotNull ULongRange uLongRange, byte b2) {
        Intrinsics.p(uLongRange, "$this$contains");
        return uLongRange.o(ULong.i(((long) b2) & 255));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final boolean s(@NotNull UIntRange uIntRange, short s) {
        Intrinsics.p(uIntRange, "$this$contains");
        return uIntRange.o(UInt.i(s & UShort.Z));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final boolean t(UIntRange uIntRange, UInt uInt) {
        Intrinsics.p(uIntRange, "$this$contains");
        return uInt != null && uIntRange.o(uInt.v0());
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final boolean u(@NotNull UIntRange uIntRange, long j2) {
        Intrinsics.p(uIntRange, "$this$contains");
        return ULong.i(j2 >>> 32) == 0 && uIntRange.o(UInt.i((int) j2));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final boolean v(@NotNull ULongRange uLongRange, short s) {
        Intrinsics.p(uLongRange, "$this$contains");
        return uLongRange.o(ULong.i(((long) s) & 65535));
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UIntProgression w(short s, short s2) {
        return UIntProgression.Z.a(UInt.i(s & UShort.Z), UInt.i(s2 & UShort.Z), -1);
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UIntProgression x(int i2, int i3) {
        return UIntProgression.Z.a(i2, i3, -1);
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UIntProgression y(byte b2, byte b3) {
        return UIntProgression.Z.a(UInt.i(b2 & 255), UInt.i(b3 & 255), -1);
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final ULongProgression z(long j2, long j3) {
        return ULongProgression.Z.a(j2, j3, -1);
    }
}
