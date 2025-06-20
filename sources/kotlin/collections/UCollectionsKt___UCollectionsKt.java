package kotlin.collections;

import java.util.Collection;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.WasExperimental;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0007\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001c\u0010\u0007\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00050\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001c\u0010\u000b\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\t0\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\u000f\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\r0\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001c\u0010\u0012\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001c\u0010\u0014\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\t0\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001c\u0010\u0016\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00010\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0013\u001a\u001c\u0010\u0017\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\r0\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"", "Lkotlin/UByte;", "Lkotlin/UByteArray;", "e", "(Ljava/util/Collection;)[B", "Lkotlin/UInt;", "Lkotlin/UIntArray;", "f", "(Ljava/util/Collection;)[I", "Lkotlin/ULong;", "Lkotlin/ULongArray;", "g", "(Ljava/util/Collection;)[J", "Lkotlin/UShort;", "Lkotlin/UShortArray;", "h", "(Ljava/util/Collection;)[S", "", "b", "(Ljava/lang/Iterable;)I", "c", "(Ljava/lang/Iterable;)J", "a", "d", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/collections/UCollectionsKt")
class UCollectionsKt___UCollectionsKt {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUByte")
    public static final int a(@NotNull Iterable<UByte> iterable) {
        Intrinsics.p(iterable, "<this>");
        int i2 = 0;
        for (UByte r0 : iterable) {
            i2 = UInt.i(i2 + UInt.i(r0.r0() & 255));
        }
        return i2;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUInt")
    public static final int b(@NotNull Iterable<UInt> iterable) {
        Intrinsics.p(iterable, "<this>");
        int i2 = 0;
        for (UInt v0 : iterable) {
            i2 = UInt.i(i2 + v0.v0());
        }
        return i2;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfULong")
    public static final long c(@NotNull Iterable<ULong> iterable) {
        Intrinsics.p(iterable, "<this>");
        long j2 = 0;
        for (ULong v0 : iterable) {
            j2 = ULong.i(j2 + v0.v0());
        }
        return j2;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUShort")
    public static final int d(@NotNull Iterable<UShort> iterable) {
        Intrinsics.p(iterable, "<this>");
        int i2 = 0;
        for (UShort r0 : iterable) {
            i2 = UInt.i(i2 + UInt.i(r0.r0() & UShort.Z));
        }
        return i2;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final byte[] e(@NotNull Collection<UByte> collection) {
        Intrinsics.p(collection, "<this>");
        byte[] d2 = UByteArray.d(collection.size());
        int i2 = 0;
        for (UByte r0 : collection) {
            UByteArray.D(d2, i2, r0.r0());
            i2++;
        }
        return d2;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final int[] f(@NotNull Collection<UInt> collection) {
        Intrinsics.p(collection, "<this>");
        int[] d2 = UIntArray.d(collection.size());
        int i2 = 0;
        for (UInt v0 : collection) {
            UIntArray.D(d2, i2, v0.v0());
            i2++;
        }
        return d2;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final long[] g(@NotNull Collection<ULong> collection) {
        Intrinsics.p(collection, "<this>");
        long[] d2 = ULongArray.d(collection.size());
        int i2 = 0;
        for (ULong v0 : collection) {
            ULongArray.D(d2, i2, v0.v0());
            i2++;
        }
        return d2;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final short[] h(@NotNull Collection<UShort> collection) {
        Intrinsics.p(collection, "<this>");
        short[] d2 = UShortArray.d(collection.size());
        int i2 = 0;
        for (UShort r0 : collection) {
            UShortArray.D(d2, i2, r0.r0());
            i2++;
        }
        return d2;
    }
}
