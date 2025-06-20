package kotlin.sequences;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.WasExperimental;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0002\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001c\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00040\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001c\u0010\b\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00070\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0003\u001a\u001c\u0010\n\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\t0\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0003\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lkotlin/sequences/Sequence;", "Lkotlin/UInt;", "b", "(Lkotlin/sequences/Sequence;)I", "Lkotlin/ULong;", "c", "(Lkotlin/sequences/Sequence;)J", "Lkotlin/UByte;", "a", "Lkotlin/UShort;", "d", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/sequences/USequencesKt")
class USequencesKt___USequencesKt {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUByte")
    public static final int a(@NotNull Sequence<UByte> sequence) {
        Intrinsics.p(sequence, "<this>");
        int i2 = 0;
        for (UByte r0 : sequence) {
            i2 = UInt.i(i2 + UInt.i(r0.r0() & 255));
        }
        return i2;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUInt")
    public static final int b(@NotNull Sequence<UInt> sequence) {
        Intrinsics.p(sequence, "<this>");
        int i2 = 0;
        for (UInt v0 : sequence) {
            i2 = UInt.i(i2 + v0.v0());
        }
        return i2;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfULong")
    public static final long c(@NotNull Sequence<ULong> sequence) {
        Intrinsics.p(sequence, "<this>");
        long j2 = 0;
        for (ULong v0 : sequence) {
            j2 = ULong.i(j2 + v0.v0());
        }
        return j2;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @JvmName(name = "sumOfUShort")
    public static final int d(@NotNull Sequence<UShort> sequence) {
        Intrinsics.p(sequence, "<this>");
        int i2 = 0;
        for (UShort r0 : sequence) {
            i2 = UInt.i(i2 + UInt.i(r0.r0() & UShort.Z));
        }
        return i2;
    }
}
