package com.google.android.gms.common;

import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
public final class zzd {
    static int a(int i2) {
        int[] iArr = {1, 2, 3};
        int i3 = 0;
        while (i3 < 3) {
            int i4 = iArr[i3];
            int i5 = i4 - 1;
            if (i4 == 0) {
                throw null;
            } else if (i5 == i2) {
                return i4;
            } else {
                i3++;
            }
        }
        return 1;
    }
}
