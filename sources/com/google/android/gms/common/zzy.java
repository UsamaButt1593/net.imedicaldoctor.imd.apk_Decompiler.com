package com.google.android.gms.common;

final class zzy {
    static int a(int i2) {
        int[] iArr = {1, 2, 3, 4, 5, 6};
        int i3 = 0;
        while (i3 < 6) {
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
