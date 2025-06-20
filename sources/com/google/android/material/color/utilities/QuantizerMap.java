package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.LinkedHashMap;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class QuantizerMap implements Quantizer {

    /* renamed from: a  reason: collision with root package name */
    Map<Integer, Integer> f21222a;

    public QuantizerResult a(int[] iArr, int i2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i3 : iArr) {
            Integer num = (Integer) linkedHashMap.get(Integer.valueOf(i3));
            int i4 = 1;
            if (num != null) {
                i4 = 1 + num.intValue();
            }
            linkedHashMap.put(Integer.valueOf(i3), Integer.valueOf(i4));
        }
        this.f21222a = linkedHashMap;
        return new QuantizerResult(linkedHashMap);
    }

    public Map<Integer, Integer> b() {
        return this.f21222a;
    }
}
