package kotlin.collections;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a*\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a*\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a*\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a*\u0010\r\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a*\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a*\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a*\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a*\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a*\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\t\u001a*\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u000e\u001a*\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0013\u001a*\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002H\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0018\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lkotlin/UByteArray;", "array", "", "left", "right", "b", "([BII)I", "", "f", "([BII)V", "Lkotlin/UShortArray;", "c", "([SII)I", "g", "([SII)V", "Lkotlin/UIntArray;", "d", "([III)I", "h", "([III)V", "Lkotlin/ULongArray;", "a", "([JII)I", "e", "([JII)V", "fromIndex", "toIndex", "j", "k", "l", "i", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
public final class UArraySortingKt {
    @ExperimentalUnsignedTypes
    private static final int a(long[] jArr, int i2, int i3) {
        long o = ULongArray.o(jArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (Long.compare(ULongArray.o(jArr, i2) ^ Long.MIN_VALUE, o ^ Long.MIN_VALUE) < 0) {
                i2++;
            }
            while (Long.compare(ULongArray.o(jArr, i3) ^ Long.MIN_VALUE, o ^ Long.MIN_VALUE) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                long o2 = ULongArray.o(jArr, i2);
                ULongArray.D(jArr, i2, ULongArray.o(jArr, i3));
                ULongArray.D(jArr, i3, o2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @ExperimentalUnsignedTypes
    private static final int b(byte[] bArr, int i2, int i3) {
        byte b2;
        byte o = UByteArray.o(bArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (true) {
                b2 = o & 255;
                if (Intrinsics.t(UByteArray.o(bArr, i2) & 255, b2) >= 0) {
                    break;
                }
                i2++;
            }
            while (Intrinsics.t(UByteArray.o(bArr, i3) & 255, b2) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                byte o2 = UByteArray.o(bArr, i2);
                UByteArray.D(bArr, i2, UByteArray.o(bArr, i3));
                UByteArray.D(bArr, i3, o2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @ExperimentalUnsignedTypes
    private static final int c(short[] sArr, int i2, int i3) {
        short s;
        short o = UShortArray.o(sArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (true) {
                short o2 = UShortArray.o(sArr, i2) & UShort.Z;
                s = o & UShort.Z;
                if (Intrinsics.t(o2, s) >= 0) {
                    break;
                }
                i2++;
            }
            while (Intrinsics.t(UShortArray.o(sArr, i3) & UShort.Z, s) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                short o3 = UShortArray.o(sArr, i2);
                UShortArray.D(sArr, i2, UShortArray.o(sArr, i3));
                UShortArray.D(sArr, i3, o3);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @ExperimentalUnsignedTypes
    private static final int d(int[] iArr, int i2, int i3) {
        int o = UIntArray.o(iArr, (i2 + i3) / 2);
        while (i2 <= i3) {
            while (Integer.compare(UIntArray.o(iArr, i2) ^ Integer.MIN_VALUE, o ^ Integer.MIN_VALUE) < 0) {
                i2++;
            }
            while (Integer.compare(UIntArray.o(iArr, i3) ^ Integer.MIN_VALUE, o ^ Integer.MIN_VALUE) > 0) {
                i3--;
            }
            if (i2 <= i3) {
                int o2 = UIntArray.o(iArr, i2);
                UIntArray.D(iArr, i2, UIntArray.o(iArr, i3));
                UIntArray.D(iArr, i3, o2);
                i2++;
                i3--;
            }
        }
        return i2;
    }

    @ExperimentalUnsignedTypes
    private static final void e(long[] jArr, int i2, int i3) {
        int a2 = a(jArr, i2, i3);
        int i4 = a2 - 1;
        if (i2 < i4) {
            e(jArr, i2, i4);
        }
        if (a2 < i3) {
            e(jArr, a2, i3);
        }
    }

    @ExperimentalUnsignedTypes
    private static final void f(byte[] bArr, int i2, int i3) {
        int b2 = b(bArr, i2, i3);
        int i4 = b2 - 1;
        if (i2 < i4) {
            f(bArr, i2, i4);
        }
        if (b2 < i3) {
            f(bArr, b2, i3);
        }
    }

    @ExperimentalUnsignedTypes
    private static final void g(short[] sArr, int i2, int i3) {
        int c2 = c(sArr, i2, i3);
        int i4 = c2 - 1;
        if (i2 < i4) {
            g(sArr, i2, i4);
        }
        if (c2 < i3) {
            g(sArr, c2, i3);
        }
    }

    @ExperimentalUnsignedTypes
    private static final void h(int[] iArr, int i2, int i3) {
        int d2 = d(iArr, i2, i3);
        int i4 = d2 - 1;
        if (i2 < i4) {
            h(iArr, i2, i4);
        }
        if (d2 < i3) {
            h(iArr, d2, i3);
        }
    }

    @ExperimentalUnsignedTypes
    public static final void i(@NotNull long[] jArr, int i2, int i3) {
        Intrinsics.p(jArr, "array");
        e(jArr, i2, i3 - 1);
    }

    @ExperimentalUnsignedTypes
    public static final void j(@NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.p(bArr, "array");
        f(bArr, i2, i3 - 1);
    }

    @ExperimentalUnsignedTypes
    public static final void k(@NotNull short[] sArr, int i2, int i3) {
        Intrinsics.p(sArr, "array");
        g(sArr, i2, i3 - 1);
    }

    @ExperimentalUnsignedTypes
    public static final void l(@NotNull int[] iArr, int i2, int i3) {
        Intrinsics.p(iArr, "array");
        h(iArr, i2, i3 - 1);
    }
}
