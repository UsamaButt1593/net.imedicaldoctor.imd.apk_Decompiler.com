package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.CharMatcher;
import java.util.BitSet;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
final class SmallCharMatcher extends CharMatcher.NamedFastMatcher {
    static final int Y2 = 1023;
    private static final int Z2 = -862048943;
    private static final int a3 = 461845907;
    private static final double b3 = 0.5d;
    private final long X2;
    private final char[] Y;
    private final boolean Z;

    private SmallCharMatcher(char[] cArr, long j2, boolean z, String str) {
        super(str);
        this.Y = cArr;
        this.X2 = j2;
        this.Z = z;
    }

    private boolean Y(int i2) {
        return 1 == ((this.X2 >> i2) & 1);
    }

    @VisibleForTesting
    static int Z(int i2) {
        if (i2 == 1) {
            return 2;
        }
        int highestOneBit = Integer.highestOneBit(i2 - 1) << 1;
        while (((double) highestOneBit) * 0.5d < ((double) i2)) {
            highestOneBit <<= 1;
        }
        return highestOneBit;
    }

    static CharMatcher a0(BitSet bitSet, String str) {
        int i2;
        int cardinality = bitSet.cardinality();
        boolean z = bitSet.get(0);
        int Z3 = Z(cardinality);
        char[] cArr = new char[Z3];
        int i3 = Z3 - 1;
        int nextSetBit = bitSet.nextSetBit(0);
        long j2 = 0;
        while (nextSetBit != -1) {
            long j3 = (1 << nextSetBit) | j2;
            int b0 = b0(nextSetBit);
            while (true) {
                i2 = b0 & i3;
                if (cArr[i2] == 0) {
                    break;
                }
                b0 = i2 + 1;
            }
            cArr[i2] = (char) nextSetBit;
            nextSetBit = bitSet.nextSetBit(nextSetBit + 1);
            j2 = j3;
        }
        return new SmallCharMatcher(cArr, j2, z, str);
    }

    static int b0(int i2) {
        return Integer.rotateLeft(i2 * Z2, 15) * a3;
    }

    public boolean B(char c2) {
        if (c2 == 0) {
            return this.Z;
        }
        if (!Y(c2)) {
            return false;
        }
        int length = this.Y.length - 1;
        int b0 = b0(c2) & length;
        int i2 = b0;
        do {
            char c3 = this.Y[i2];
            if (c3 == 0) {
                return false;
            }
            if (c3 == c2) {
                return true;
            }
            i2 = (i2 + 1) & length;
        } while (i2 != b0);
        return false;
    }

    /* access modifiers changed from: package-private */
    public void Q(BitSet bitSet) {
        if (this.Z) {
            bitSet.set(0);
        }
        for (char c2 : this.Y) {
            if (c2 != 0) {
                bitSet.set(c2);
            }
        }
    }
}
