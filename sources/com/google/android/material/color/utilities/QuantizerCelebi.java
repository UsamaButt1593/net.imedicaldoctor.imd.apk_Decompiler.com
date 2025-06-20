package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.Map;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class QuantizerCelebi {
    private QuantizerCelebi() {
    }

    public static Map<Integer, Integer> a(int[] iArr, int i2) {
        Set<Integer> keySet = new QuantizerWu().a(iArr, i2).f21223a.keySet();
        int[] iArr2 = new int[keySet.size()];
        int i3 = 0;
        for (Integer intValue : keySet) {
            iArr2[i3] = intValue.intValue();
            i3++;
        }
        return QuantizerWsmeans.a(iArr, iArr2, i2);
    }
}
