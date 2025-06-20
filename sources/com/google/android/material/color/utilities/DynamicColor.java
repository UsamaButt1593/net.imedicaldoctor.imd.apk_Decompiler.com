package com.google.android.material.color.utilities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.util.HashMap;
import java.util.function.Function;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class DynamicColor {

    /* renamed from: a  reason: collision with root package name */
    public final String f21181a;

    /* renamed from: b  reason: collision with root package name */
    public final Function<DynamicScheme, TonalPalette> f21182b;

    /* renamed from: c  reason: collision with root package name */
    public final Function<DynamicScheme, Double> f21183c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f21184d;

    /* renamed from: e  reason: collision with root package name */
    public final Function<DynamicScheme, DynamicColor> f21185e;

    /* renamed from: f  reason: collision with root package name */
    public final Function<DynamicScheme, DynamicColor> f21186f;

    /* renamed from: g  reason: collision with root package name */
    public final ContrastCurve f21187g;

    /* renamed from: h  reason: collision with root package name */
    public final Function<DynamicScheme, ToneDeltaPair> f21188h;

    /* renamed from: i  reason: collision with root package name */
    public final Function<DynamicScheme, Double> f21189i;

    /* renamed from: j  reason: collision with root package name */
    private final HashMap<DynamicScheme, Hct> f21190j = new HashMap<>();

    public DynamicColor(@NonNull String str, @NonNull Function<DynamicScheme, TonalPalette> function, @NonNull Function<DynamicScheme, Double> function2, boolean z, @Nullable Function<DynamicScheme, DynamicColor> function3, @Nullable Function<DynamicScheme, DynamicColor> function4, @Nullable ContrastCurve contrastCurve, @Nullable Function<DynamicScheme, ToneDeltaPair> function5) {
        this.f21181a = str;
        this.f21182b = function;
        this.f21183c = function2;
        this.f21184d = z;
        this.f21185e = function3;
        this.f21186f = function4;
        this.f21187g = contrastCurve;
        this.f21188h = function5;
        this.f21189i = null;
    }

    public static double c(double d2) {
        if (!n(d2) || m(d2)) {
            return d2;
        }
        return 49.0d;
    }

    public static double d(double d2, double d3) {
        double d4 = Contrast.d(d2, d3);
        double b2 = Contrast.b(d2, d3);
        double e2 = Contrast.e(d4, d2);
        double e3 = Contrast.e(b2, d2);
        if (!n(d2)) {
            return (e3 >= d3 || e3 >= e2) ? b2 : d4;
        }
        return (e2 >= d3 || e2 >= e3 || ((Math.abs(e2 - e3) > 0.1d ? 1 : (Math.abs(e2 - e3) == 0.1d ? 0 : -1)) < 0 && (e2 > d3 ? 1 : (e2 == d3 ? 0 : -1)) < 0 && (e3 > d3 ? 1 : (e3 == d3 ? 0 : -1)) < 0)) ? d4 : b2;
    }

    @NonNull
    public static DynamicColor e(@NonNull String str, int i2) {
        return f(str, new C0388b(TonalPalette.d(i2)), new C0391c(Hct.b(i2)));
    }

    @NonNull
    public static DynamicColor f(@NonNull String str, @NonNull Function<DynamicScheme, TonalPalette> function, @NonNull Function<DynamicScheme, Double> function2) {
        return new DynamicColor(str, function, function2, false, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public static DynamicColor g(@NonNull String str, @NonNull Function<DynamicScheme, TonalPalette> function, @NonNull Function<DynamicScheme, Double> function2, boolean z) {
        return new DynamicColor(str, function, function2, z, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ TonalPalette k(TonalPalette tonalPalette, DynamicScheme dynamicScheme) {
        return tonalPalette;
    }

    public static boolean m(double d2) {
        return Math.round(d2) <= 49;
    }

    public static boolean n(double d2) {
        return Math.round(d2) < 60;
    }

    public int h(@NonNull DynamicScheme dynamicScheme) {
        int k2 = i(dynamicScheme).k();
        Function<DynamicScheme, Double> function = this.f21189i;
        if (function == null) {
            return k2;
        }
        return (MathUtils.b(0, 255, (int) Math.round(((Double) function.apply(dynamicScheme)).doubleValue() * 255.0d)) << 24) | (k2 & ViewCompat.x);
    }

    @NonNull
    public Hct i(@NonNull DynamicScheme dynamicScheme) {
        Hct hct = this.f21190j.get(dynamicScheme);
        if (hct != null) {
            return hct;
        }
        Hct f2 = ((TonalPalette) this.f21182b.apply(dynamicScheme)).f(j(dynamicScheme));
        if (this.f21190j.size() > 4) {
            this.f21190j.clear();
        }
        this.f21190j.put(dynamicScheme, f2);
        return f2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x021b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x019b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public double j(@androidx.annotation.NonNull com.google.android.material.color.utilities.DynamicScheme r31) {
        /*
            r30 = this;
            r0 = r30
            r1 = r31
            double r2 = r1.f21195e
            r6 = 0
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x000e
            r2 = 1
            goto L_0x000f
        L_0x000e:
            r2 = 0
        L_0x000f:
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, com.google.android.material.color.utilities.ToneDeltaPair> r3 = r0.f21188h
            if (r3 == 0) goto L_0x0141
            java.lang.Object r3 = r3.apply(r1)
            com.google.android.material.color.utilities.ToneDeltaPair r3 = (com.google.android.material.color.utilities.ToneDeltaPair) r3
            com.google.android.material.color.utilities.DynamicColor r16 = r3.c()
            com.google.android.material.color.utilities.DynamicColor r17 = r3.d()
            double r18 = r3.a()
            com.google.android.material.color.utilities.TonePolarity r4 = r3.b()
            boolean r3 = r3.e()
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, com.google.android.material.color.utilities.DynamicColor> r5 = r0.f21185e
            java.lang.Object r5 = r5.apply(r1)
            com.google.android.material.color.utilities.DynamicColor r5 = (com.google.android.material.color.utilities.DynamicColor) r5
            double r10 = r5.j(r1)
            com.google.android.material.color.utilities.TonePolarity r5 = com.google.android.material.color.utilities.TonePolarity.NEARER
            if (r4 == r5) goto L_0x0050
            com.google.android.material.color.utilities.TonePolarity r5 = com.google.android.material.color.utilities.TonePolarity.LIGHTER
            if (r4 != r5) goto L_0x0045
            boolean r5 = r1.f21194d
            if (r5 == 0) goto L_0x0050
        L_0x0045:
            com.google.android.material.color.utilities.TonePolarity r5 = com.google.android.material.color.utilities.TonePolarity.DARKER
            if (r4 != r5) goto L_0x004e
            boolean r4 = r1.f21194d
            if (r4 == 0) goto L_0x004e
            goto L_0x0050
        L_0x004e:
            r4 = 0
            goto L_0x0051
        L_0x0050:
            r4 = 1
        L_0x0051:
            if (r4 == 0) goto L_0x0056
            r5 = r16
            goto L_0x0058
        L_0x0056:
            r5 = r17
        L_0x0058:
            if (r4 == 0) goto L_0x005d
            r4 = r17
            goto L_0x005f
        L_0x005d:
            r4 = r16
        L_0x005f:
            java.lang.String r12 = r0.f21181a
            java.lang.String r13 = r5.f21181a
            boolean r12 = r12.equals(r13)
            boolean r13 = r1.f21194d
            if (r13 == 0) goto L_0x006e
            r20 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            goto L_0x0070
        L_0x006e:
            r20 = -4616189618054758400(0xbff0000000000000, double:-1.0)
        L_0x0070:
            com.google.android.material.color.utilities.ContrastCurve r13 = r5.f21187g
            double r6 = r1.f21195e
            double r6 = r13.a(r6)
            com.google.android.material.color.utilities.ContrastCurve r13 = r4.f21187g
            double r14 = r1.f21195e
            double r13 = r13.a(r14)
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, java.lang.Double> r5 = r5.f21183c
            java.lang.Object r5 = r5.apply(r1)
            java.lang.Double r5 = (java.lang.Double) r5
            double r8 = r5.doubleValue()
            double r22 = com.google.android.material.color.utilities.Contrast.e(r10, r8)
            int r5 = (r22 > r6 ? 1 : (r22 == r6 ? 0 : -1))
            if (r5 < 0) goto L_0x0095
            goto L_0x0099
        L_0x0095:
            double r8 = d(r10, r6)
        L_0x0099:
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, java.lang.Double> r4 = r4.f21183c
            java.lang.Object r1 = r4.apply(r1)
            java.lang.Double r1 = (java.lang.Double) r1
            double r4 = r1.doubleValue()
            double r22 = com.google.android.material.color.utilities.Contrast.e(r10, r4)
            int r1 = (r22 > r13 ? 1 : (r22 == r13 ? 0 : -1))
            if (r1 < 0) goto L_0x00ae
            goto L_0x00b2
        L_0x00ae:
            double r4 = d(r10, r13)
        L_0x00b2:
            if (r2 == 0) goto L_0x00bc
            double r8 = d(r10, r6)
            double r4 = d(r10, r13)
        L_0x00bc:
            double r1 = r4 - r8
            double r1 = r1 * r20
            int r6 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
            if (r6 >= 0) goto L_0x00e2
            double r1 = r18 * r20
            double r28 = r8 + r1
            r24 = 0
            r26 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r4 = com.google.android.material.color.utilities.MathUtils.a(r24, r26, r28)
            double r6 = r4 - r8
            double r6 = r6 * r20
            int r10 = (r6 > r18 ? 1 : (r6 == r18 ? 0 : -1))
            if (r10 >= 0) goto L_0x00e2
            r26 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r28 = r4 - r1
            r24 = 0
            double r8 = com.google.android.material.color.utilities.MathUtils.a(r24, r26, r28)
        L_0x00e2:
            r1 = 4632233691727265792(0x4049000000000000, double:50.0)
            int r6 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            r1 = 4633641066610819072(0x404e000000000000, double:60.0)
            if (r6 > 0) goto L_0x0112
            int r6 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r6 >= 0) goto L_0x0112
            r6 = 0
            int r3 = (r20 > r6 ? 1 : (r20 == r6 ? 0 : -1))
            if (r3 <= 0) goto L_0x00ff
            double r18 = r18 * r20
            double r6 = r18 + r1
            double r3 = java.lang.Math.max(r4, r6)
            r8 = r1
            r1 = r3
            goto L_0x013d
        L_0x00ff:
            double r18 = r18 * r20
            r1 = 4632092954238910464(0x4048800000000000, double:49.0)
            double r6 = r18 + r1
            double r1 = java.lang.Math.min(r4, r6)
            r8 = 4632092954238910464(0x4048800000000000, double:49.0)
            goto L_0x013d
        L_0x0112:
            r6 = 4632233691727265792(0x4049000000000000, double:50.0)
            int r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r10 > 0) goto L_0x013c
            int r6 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r6 >= 0) goto L_0x013c
            r6 = 0
            if (r3 == 0) goto L_0x012f
            int r3 = (r20 > r6 ? 1 : (r20 == r6 ? 0 : -1))
            if (r3 <= 0) goto L_0x00ff
            double r18 = r18 * r20
            double r6 = r18 + r1
            double r1 = java.lang.Math.max(r4, r6)
            r8 = 4633641066610819072(0x404e000000000000, double:60.0)
            goto L_0x013d
        L_0x012f:
            int r1 = (r20 > r6 ? 1 : (r20 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x0136
            r1 = 4633641066610819072(0x404e000000000000, double:60.0)
            goto L_0x013d
        L_0x0136:
            r1 = 4632092954238910464(0x4048800000000000, double:49.0)
            goto L_0x013d
        L_0x013c:
            r1 = r4
        L_0x013d:
            if (r12 == 0) goto L_0x0140
            r1 = r8
        L_0x0140:
            return r1
        L_0x0141:
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, java.lang.Double> r3 = r0.f21183c
            java.lang.Object r3 = r3.apply(r1)
            java.lang.Double r3 = (java.lang.Double) r3
            double r3 = r3.doubleValue()
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, com.google.android.material.color.utilities.DynamicColor> r5 = r0.f21185e
            if (r5 != 0) goto L_0x0152
            return r3
        L_0x0152:
            java.lang.Object r5 = r5.apply(r1)
            com.google.android.material.color.utilities.DynamicColor r5 = (com.google.android.material.color.utilities.DynamicColor) r5
            double r8 = r5.j(r1)
            com.google.android.material.color.utilities.ContrastCurve r5 = r0.f21187g
            double r10 = r1.f21195e
            double r10 = r5.a(r10)
            double r12 = com.google.android.material.color.utilities.Contrast.e(r8, r3)
            int r5 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r5 < 0) goto L_0x016d
            goto L_0x0171
        L_0x016d:
            double r3 = d(r8, r10)
        L_0x0171:
            if (r2 == 0) goto L_0x0177
            double r3 = d(r8, r10)
        L_0x0177:
            boolean r2 = r0.f21184d
            if (r2 == 0) goto L_0x0196
            r12 = 4632233691727265792(0x4049000000000000, double:50.0)
            int r2 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r2 > 0) goto L_0x0196
            r12 = 4633641066610819072(0x404e000000000000, double:60.0)
            int r2 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r2 >= 0) goto L_0x0196
            r14 = 4632092954238910464(0x4048800000000000, double:49.0)
            double r2 = com.google.android.material.color.utilities.Contrast.e(r14, r8)
            int r4 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r4 < 0) goto L_0x0197
            r12 = r14
            goto L_0x0197
        L_0x0196:
            r12 = r3
        L_0x0197:
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, com.google.android.material.color.utilities.DynamicColor> r2 = r0.f21186f
            if (r2 == 0) goto L_0x021b
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, com.google.android.material.color.utilities.DynamicColor> r2 = r0.f21185e
            java.lang.Object r2 = r2.apply(r1)
            com.google.android.material.color.utilities.DynamicColor r2 = (com.google.android.material.color.utilities.DynamicColor) r2
            double r2 = r2.j(r1)
            java.util.function.Function<com.google.android.material.color.utilities.DynamicScheme, com.google.android.material.color.utilities.DynamicColor> r4 = r0.f21186f
            java.lang.Object r4 = r4.apply(r1)
            com.google.android.material.color.utilities.DynamicColor r4 = (com.google.android.material.color.utilities.DynamicColor) r4
            double r4 = r4.j(r1)
            double r8 = java.lang.Math.max(r2, r4)
            double r14 = java.lang.Math.min(r2, r4)
            double r16 = com.google.android.material.color.utilities.Contrast.e(r8, r12)
            int r1 = (r16 > r10 ? 1 : (r16 == r10 ? 0 : -1))
            if (r1 < 0) goto L_0x01cc
            double r16 = com.google.android.material.color.utilities.Contrast.e(r14, r12)
            int r1 = (r16 > r10 ? 1 : (r16 == r10 ? 0 : -1))
            if (r1 < 0) goto L_0x01cc
            return r12
        L_0x01cc:
            double r8 = com.google.android.material.color.utilities.Contrast.c(r8, r10)
            double r10 = com.google.android.material.color.utilities.Contrast.a(r14, r10)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r12 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            int r14 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r14 == 0) goto L_0x01e6
            java.lang.Double r15 = java.lang.Double.valueOf(r8)
            r1.add(r15)
        L_0x01e6:
            int r15 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r15 == 0) goto L_0x01f1
            java.lang.Double r12 = java.lang.Double.valueOf(r10)
            r1.add(r12)
        L_0x01f1:
            boolean r2 = n(r2)
            if (r2 != 0) goto L_0x0216
            boolean r2 = n(r4)
            if (r2 == 0) goto L_0x01fe
            goto L_0x0216
        L_0x01fe:
            int r2 = r1.size()
            r3 = 1
            if (r2 != r3) goto L_0x0211
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            java.lang.Double r1 = (java.lang.Double) r1
            double r1 = r1.doubleValue()
            return r1
        L_0x0211:
            if (r15 != 0) goto L_0x0214
            goto L_0x0215
        L_0x0214:
            r6 = r10
        L_0x0215:
            return r6
        L_0x0216:
            if (r14 != 0) goto L_0x021a
            r8 = 4636737291354636288(0x4059000000000000, double:100.0)
        L_0x021a:
            return r8
        L_0x021b:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.utilities.DynamicColor.j(com.google.android.material.color.utilities.DynamicScheme):double");
    }

    public DynamicColor(@NonNull String str, @NonNull Function<DynamicScheme, TonalPalette> function, @NonNull Function<DynamicScheme, Double> function2, boolean z, @Nullable Function<DynamicScheme, DynamicColor> function3, @Nullable Function<DynamicScheme, DynamicColor> function4, @Nullable ContrastCurve contrastCurve, @Nullable Function<DynamicScheme, ToneDeltaPair> function5, @Nullable Function<DynamicScheme, Double> function6) {
        this.f21181a = str;
        this.f21182b = function;
        this.f21183c = function2;
        this.f21184d = z;
        this.f21185e = function3;
        this.f21186f = function4;
        this.f21187g = contrastCurve;
        this.f21188h = function5;
        this.f21189i = function6;
    }
}
