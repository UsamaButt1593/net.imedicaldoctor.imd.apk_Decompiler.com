package com.google.android.material.color;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import com.google.android.material.color.utilities.DynamicColor;
import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialColorUtilitiesHelper {

    /* renamed from: a  reason: collision with root package name */
    private static final MaterialDynamicColors f21126a;

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Integer, DynamicColor> f21127b;

    static {
        MaterialDynamicColors materialDynamicColors = new MaterialDynamicColors();
        f21126a = materialDynamicColors;
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf(R.color.Db), materialDynamicColors.V5());
        hashMap.put(Integer.valueOf(R.color.sb), materialDynamicColors.E5());
        hashMap.put(Integer.valueOf(R.color.Fb), materialDynamicColors.p2());
        hashMap.put(Integer.valueOf(R.color.Eb), materialDynamicColors.W5());
        hashMap.put(Integer.valueOf(R.color.tb), materialDynamicColors.F5());
        hashMap.put(Integer.valueOf(R.color.Ib), materialDynamicColors.b6());
        hashMap.put(Integer.valueOf(R.color.ub), materialDynamicColors.I5());
        hashMap.put(Integer.valueOf(R.color.Jb), materialDynamicColors.c6());
        hashMap.put(Integer.valueOf(R.color.vb), materialDynamicColors.J5());
        hashMap.put(Integer.valueOf(R.color.Wb), materialDynamicColors.r6());
        hashMap.put(Integer.valueOf(R.color.zb), materialDynamicColors.O5());
        hashMap.put(Integer.valueOf(R.color.Xb), materialDynamicColors.s6());
        hashMap.put(Integer.valueOf(R.color.Ab), materialDynamicColors.P5());
        hashMap.put(Integer.valueOf(R.color.jb), materialDynamicColors.g2());
        hashMap.put(Integer.valueOf(R.color.pb), materialDynamicColors.B5());
        hashMap.put(Integer.valueOf(R.color.Mb), materialDynamicColors.h6());
        hashMap.put(Integer.valueOf(R.color.wb), materialDynamicColors.M5());
        hashMap.put(Integer.valueOf(R.color.Vb), materialDynamicColors.q6());
        hashMap.put(Integer.valueOf(R.color.yb), materialDynamicColors.N5());
        hashMap.put(Integer.valueOf(R.color.Ub), materialDynamicColors.q2());
        hashMap.put(Integer.valueOf(R.color.xb), materialDynamicColors.o2());
        hashMap.put(Integer.valueOf(R.color.Nb), materialDynamicColors.i6());
        hashMap.put(Integer.valueOf(R.color.Tb), materialDynamicColors.o6());
        hashMap.put(Integer.valueOf(R.color.Ob), materialDynamicColors.j6());
        hashMap.put(Integer.valueOf(R.color.Rb), materialDynamicColors.m6());
        hashMap.put(Integer.valueOf(R.color.Pb), materialDynamicColors.k6());
        hashMap.put(Integer.valueOf(R.color.Sb), materialDynamicColors.n6());
        hashMap.put(Integer.valueOf(R.color.Qb), materialDynamicColors.l6());
        hashMap.put(Integer.valueOf(R.color.Bb), materialDynamicColors.S5());
        hashMap.put(Integer.valueOf(R.color.Cb), materialDynamicColors.T5());
        hashMap.put(Integer.valueOf(R.color.nb), materialDynamicColors.k2());
        hashMap.put(Integer.valueOf(R.color.qb), materialDynamicColors.C5());
        hashMap.put(Integer.valueOf(R.color.ob), materialDynamicColors.l2());
        hashMap.put(Integer.valueOf(R.color.rb), materialDynamicColors.D5());
        hashMap.put(Integer.valueOf(R.color.kb), materialDynamicColors.h2());
        hashMap.put(Integer.valueOf(R.color.mb), materialDynamicColors.j2());
        hashMap.put(Integer.valueOf(R.color.lb), materialDynamicColors.i2());
        hashMap.put(Integer.valueOf(R.color.Zb), materialDynamicColors.x6());
        hashMap.put(Integer.valueOf(R.color.bc), materialDynamicColors.z6());
        hashMap.put(Integer.valueOf(R.color.cc), materialDynamicColors.A6());
        hashMap.put(Integer.valueOf(R.color.ac), materialDynamicColors.y6());
        hashMap.put(Integer.valueOf(R.color.Yb), materialDynamicColors.w6());
        f21127b = Collections.unmodifiableMap(hashMap);
    }

    private MaterialColorUtilitiesHelper() {
    }

    @NonNull
    public static Map<Integer, Integer> a(@NonNull DynamicScheme dynamicScheme) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : f21127b.entrySet()) {
            hashMap.put((Integer) next.getKey(), Integer.valueOf(((DynamicColor) next.getValue()).h(dynamicScheme)));
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
