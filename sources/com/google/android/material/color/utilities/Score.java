package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Score {

    /* renamed from: a  reason: collision with root package name */
    private static final double f21266a = 48.0d;

    /* renamed from: b  reason: collision with root package name */
    private static final double f21267b = 0.7d;

    /* renamed from: c  reason: collision with root package name */
    private static final double f21268c = 0.3d;

    /* renamed from: d  reason: collision with root package name */
    private static final double f21269d = 0.1d;

    /* renamed from: e  reason: collision with root package name */
    private static final double f21270e = 5.0d;

    /* renamed from: f  reason: collision with root package name */
    private static final double f21271f = 0.01d;

    /* renamed from: g  reason: collision with root package name */
    private static final int f21272g = -12417548;

    /* renamed from: h  reason: collision with root package name */
    private static final int f21273h = 4;

    private static class ScoredComparator implements Comparator<ScoredHCT> {
        /* renamed from: a */
        public int compare(ScoredHCT scoredHCT, ScoredHCT scoredHCT2) {
            return Double.compare(scoredHCT2.f21275b, scoredHCT.f21275b);
        }
    }

    private static class ScoredHCT {

        /* renamed from: a  reason: collision with root package name */
        public final Hct f21274a;

        /* renamed from: b  reason: collision with root package name */
        public final double f21275b;

        public ScoredHCT(Hct hct, double d2) {
            this.f21274a = hct;
            this.f21275b = d2;
        }
    }

    private Score() {
    }

    public static List<Integer> a(Map<Integer, Integer> map) {
        return d(map, 4, f21272g, true);
    }

    public static List<Integer> b(Map<Integer, Integer> map, int i2) {
        return d(map, i2, f21272g, true);
    }

    public static List<Integer> c(Map<Integer, Integer> map, int i2, int i3) {
        return d(map, i2, i3, true);
    }

    public static List<Integer> d(Map<Integer, Integer> map, int i2, int i3, boolean z) {
        ArrayList<Hct> arrayList = new ArrayList<>();
        int[] iArr = new int[360];
        double d2 = 0.0d;
        for (Map.Entry next : map.entrySet()) {
            Hct b2 = Hct.b(((Integer) next.getKey()).intValue());
            arrayList.add(b2);
            int floor = (int) Math.floor(b2.d());
            int intValue = ((Integer) next.getValue()).intValue();
            iArr[floor] = iArr[floor] + intValue;
            d2 += (double) intValue;
        }
        double[] dArr = new double[360];
        for (int i4 = 0; i4 < 360; i4++) {
            double d3 = ((double) iArr[i4]) / d2;
            for (int i5 = i4 - 14; i5 < i4 + 16; i5++) {
                int h2 = MathUtils.h(i5);
                dArr[h2] = dArr[h2] + d3;
            }
        }
        ArrayList<ScoredHCT> arrayList2 = new ArrayList<>();
        for (Hct hct : arrayList) {
            double d4 = dArr[MathUtils.h((int) Math.round(hct.d()))];
            if (!z || (hct.c() >= f21270e && d4 > f21271f)) {
                arrayList2.add(new ScoredHCT(hct, (d4 * 100.0d * f21267b) + ((hct.c() - f21266a) * (hct.c() < f21266a ? f21269d : f21268c))));
            }
        }
        Collections.sort(arrayList2, new ScoredComparator());
        ArrayList<Hct> arrayList3 = new ArrayList<>();
        for (int i6 = 90; i6 >= 15; i6--) {
            arrayList3.clear();
            for (ScoredHCT scoredHCT : arrayList2) {
                Hct hct2 = scoredHCT.f21274a;
                Iterator it2 = arrayList3.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (MathUtils.c(hct2.d(), ((Hct) it2.next()).d()) < ((double) i6)) {
                            break;
                        }
                    } else {
                        arrayList3.add(hct2);
                        break;
                    }
                }
                if (arrayList3.size() >= i2) {
                    break;
                }
            }
            if (arrayList3.size() >= i2) {
                break;
            }
        }
        ArrayList arrayList4 = new ArrayList();
        if (arrayList3.isEmpty()) {
            arrayList4.add(Integer.valueOf(i3));
            return arrayList4;
        }
        for (Hct k2 : arrayList3) {
            arrayList4.add(Integer.valueOf(k2.k()));
        }
        return arrayList4;
    }
}
