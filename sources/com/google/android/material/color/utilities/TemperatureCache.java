package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class TemperatureCache {

    /* renamed from: a  reason: collision with root package name */
    private final Hct f21276a;

    /* renamed from: b  reason: collision with root package name */
    private Hct f21277b;

    /* renamed from: c  reason: collision with root package name */
    private List<Hct> f21278c;

    /* renamed from: d  reason: collision with root package name */
    private List<Hct> f21279d;

    /* renamed from: e  reason: collision with root package name */
    private Map<Hct, Double> f21280e;

    private TemperatureCache() {
        throw new UnsupportedOperationException();
    }

    private Hct d() {
        return g().get(0);
    }

    private List<Hct> f() {
        List<Hct> list = this.f21279d;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (double d2 = 0.0d; d2 <= 360.0d; d2 += 1.0d) {
            arrayList.add(Hct.a(d2, this.f21276a.c(), this.f21276a.e()));
        }
        List<Hct> unmodifiableList = Collections.unmodifiableList(arrayList);
        this.f21279d = unmodifiableList;
        return unmodifiableList;
    }

    private List<Hct> g() {
        List<Hct> list = this.f21278c;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList(f());
        arrayList.add(this.f21276a);
        Collections.sort(arrayList, Comparator.comparing(new m2(this), new n2()));
        this.f21278c = arrayList;
        return arrayList;
    }

    private Map<Hct, Double> i() {
        Map<Hct, Double> map = this.f21280e;
        if (map != null) {
            return map;
        }
        ArrayList<Hct> arrayList = new ArrayList<>(f());
        arrayList.add(this.f21276a);
        HashMap hashMap = new HashMap();
        for (Hct hct : arrayList) {
            hashMap.put(hct, Double.valueOf(m(hct)));
        }
        this.f21280e = hashMap;
        return hashMap;
    }

    private Hct j() {
        return g().get(g().size() - 1);
    }

    private static boolean k(double d2, double d3, double d4) {
        return d3 < d4 ? d3 <= d2 && d2 <= d4 : d3 <= d2 || d2 <= d4;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Double l(Hct hct) {
        return i().get(hct);
    }

    public static double m(Hct hct) {
        double[] l2 = ColorUtils.l(hct.k());
        return ((Math.pow(Math.hypot(l2[1], l2[2]), 1.07d) * 0.02d) * Math.cos(Math.toRadians(MathUtils.g(MathUtils.g(Math.toDegrees(Math.atan2(l2[2], l2[1]))) - 50.0d)))) - 8.0d;
    }

    public List<Hct> b() {
        return c(5, 12);
    }

    public List<Hct> c(int i2, int i3) {
        int size;
        int size2;
        int i4 = i2;
        int i5 = i3;
        int round = (int) Math.round(this.f21276a.d());
        Hct hct = f().get(round);
        double h2 = h(hct);
        ArrayList arrayList = new ArrayList();
        arrayList.add(hct);
        double d2 = 0.0d;
        double d3 = 0.0d;
        int i6 = 0;
        while (i6 < 360) {
            double h3 = h(f().get(MathUtils.h(round + i6)));
            d3 += Math.abs(h3 - h2);
            i6++;
            h2 = h3;
        }
        double d4 = d3 / ((double) i5);
        double h4 = h(hct);
        int i7 = 1;
        while (true) {
            if (arrayList.size() >= i5) {
                break;
            }
            Hct hct2 = f().get(MathUtils.h(round + i7));
            double h5 = h(hct2);
            d2 += Math.abs(h5 - h4);
            boolean z = d2 >= ((double) arrayList.size()) * d4;
            int i8 = 1;
            while (z && arrayList.size() < i5) {
                arrayList.add(hct2);
                z = d2 >= ((double) (arrayList.size() + i8)) * d4;
                i8++;
            }
            i7++;
            if (i7 > 360) {
                while (arrayList.size() < i5) {
                    arrayList.add(hct2);
                }
            } else {
                h4 = h5;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.f21276a);
        int floor = (int) Math.floor((((double) i4) - 1.0d) / 2.0d);
        for (int i9 = 1; i9 < floor + 1; i9++) {
            int i10 = 0 - i9;
            while (true) {
                size2 = arrayList.size();
                if (i10 >= 0) {
                    break;
                }
                i10 += size2;
            }
            if (i10 >= size2) {
                i10 %= arrayList.size();
            }
            arrayList2.add(0, (Hct) arrayList.get(i10));
        }
        int i11 = i4 - floor;
        for (int i12 = 1; i12 < i11; i12++) {
            int i13 = i12;
            while (true) {
                size = arrayList.size();
                if (i13 >= 0) {
                    break;
                }
                i13 += size;
            }
            if (i13 >= size) {
                i13 %= arrayList.size();
            }
            arrayList2.add((Hct) arrayList.get(i13));
        }
        return arrayList2;
    }

    public Hct e() {
        Hct hct = this.f21277b;
        if (hct != null) {
            return hct;
        }
        double d2 = d().d();
        double doubleValue = i().get(d()).doubleValue();
        double d3 = j().d();
        double doubleValue2 = i().get(j()).doubleValue() - doubleValue;
        boolean k2 = k(this.f21276a.d(), d2, d3);
        double d4 = k2 ? d3 : d2;
        if (!k2) {
            d2 = d3;
        }
        Hct hct2 = f().get((int) Math.round(this.f21276a.d()));
        double h2 = 1.0d - h(this.f21276a);
        double d5 = 1000.0d;
        for (double d6 = 0.0d; d6 <= 360.0d; d6 += 1.0d) {
            double g2 = MathUtils.g(d4 + (1.0d * d6));
            if (k(g2, d4, d2)) {
                Hct hct3 = f().get((int) Math.round(g2));
                double abs = Math.abs(h2 - ((i().get(hct3).doubleValue() - doubleValue) / doubleValue2));
                if (abs < d5) {
                    hct2 = hct3;
                    d5 = abs;
                }
            }
        }
        this.f21277b = hct2;
        return hct2;
    }

    public double h(Hct hct) {
        double doubleValue = i().get(j()).doubleValue() - i().get(d()).doubleValue();
        double doubleValue2 = i().get(hct).doubleValue() - i().get(d()).doubleValue();
        if (doubleValue == 0.0d) {
            return 0.5d;
        }
        return doubleValue2 / doubleValue;
    }

    public TemperatureCache(Hct hct) {
        this.f21276a = hct;
    }
}
