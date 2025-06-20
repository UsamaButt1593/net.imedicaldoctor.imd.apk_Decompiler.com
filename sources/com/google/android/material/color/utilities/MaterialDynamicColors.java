package com.google.android.material.color.utilities;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.itextpdf.tool.xml.css.CSS;
import java.util.function.Function;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialDynamicColors {
    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor A3(DynamicScheme dynamicScheme) {
        return d6();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double B2(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 80.0d : 30.0d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double B4(DynamicScheme dynamicScheme) {
        return Double.valueOf(s2(dynamicScheme) ? 70.0d : 80.0d);
    }

    private static ViewingConditions B6(DynamicScheme dynamicScheme) {
        return ViewingConditions.a(dynamicScheme.f21194d ? 30.0d : 80.0d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double C3(DynamicScheme dynamicScheme) {
        return Double.valueOf(s2(dynamicScheme) ? 25.0d : 30.0d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair C4(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(d6(), e6(), 10.0d, TonePolarity.LIGHTER, true);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double D2(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 80.0d : 40.0d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor D3(DynamicScheme dynamicScheme) {
        return e6();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair E2(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(l2(), k2(), 15.0d, TonePolarity.NEARER, false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor E3(DynamicScheme dynamicScheme) {
        return d6();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double G2(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 30.0d : 90.0d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double G3(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 90.0d : 10.0d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair H2(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(l2(), k2(), 15.0d, TonePolarity.NEARER, false);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double I3(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 80.0d : 30.0d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double I4(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 6.0d : 98.0d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double J2(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 20.0d : 95.0d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor K2(DynamicScheme dynamicScheme) {
        return q2();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double K3(DynamicScheme dynamicScheme) {
        boolean s2 = s2(dynamicScheme);
        boolean z = dynamicScheme.f21194d;
        if (s2) {
            return Double.valueOf(z ? 10.0d : 90.0d);
        }
        return Double.valueOf(z ? 20.0d : 100.0d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double K4(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 24.0d : 98.0d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor L3(DynamicScheme dynamicScheme) {
        return r6();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double M2(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 40.0d : 80.0d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double M4(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 12.0d : 94.0d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor N2(DynamicScheme dynamicScheme) {
        return q2();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Double N3(DynamicScheme dynamicScheme) {
        if (s2(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.f21194d ? 0.0d : 100.0d);
        } else if (r2(dynamicScheme)) {
            return Double.valueOf(DynamicColor.d(((Double) s6().f21183c.apply(dynamicScheme)).doubleValue(), 4.5d));
        } else {
            return Double.valueOf(dynamicScheme.f21194d ? 90.0d : 10.0d);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor O3(DynamicScheme dynamicScheme) {
        return s6();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double O4(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 17.0d : 92.0d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double P2(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 90.0d : 20.0d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double Q3(DynamicScheme dynamicScheme) {
        return Double.valueOf(s2(dynamicScheme) ? 100.0d : 10.0d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double Q4(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 22.0d : 90.0d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor R3(DynamicScheme dynamicScheme) {
        return u6();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor S3(DynamicScheme dynamicScheme) {
        return t6();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double S4(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 10.0d : 96.0d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double U3(DynamicScheme dynamicScheme) {
        return Double.valueOf(s2(dynamicScheme) ? 90.0d : 30.0d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double U4(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 4.0d : 100.0d);
    }

    static double U5(Hct hct, DynamicScheme dynamicScheme) {
        Hct f2 = hct.f(B6(dynamicScheme));
        return DynamicColor.c((!DynamicColor.n(hct.e()) || DynamicColor.m(f2.e())) ? f2.e() : hct.e());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double V2(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 90.0d : 10.0d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor V3(DynamicScheme dynamicScheme) {
        return u6();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor W2(DynamicScheme dynamicScheme) {
        return g2();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor W3(DynamicScheme dynamicScheme) {
        return t6();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double W4(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 6.0d : 87.0d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double Y2(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 20.0d : 100.0d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double Y3(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 60.0d : 50.0d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double Y4(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 80.0d : 40.0d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor Z2(DynamicScheme dynamicScheme) {
        return k2();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double a4(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 30.0d : 80.0d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double a5(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 30.0d : 90.0d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double b3(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 90.0d : 10.0d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor c3(DynamicScheme dynamicScheme) {
        return l2();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double c4(DynamicScheme dynamicScheme) {
        boolean s2 = s2(dynamicScheme);
        boolean z = dynamicScheme.f21194d;
        if (s2) {
            return Double.valueOf(z ? 100.0d : 0.0d);
        }
        return Double.valueOf(z ? 80.0d : 40.0d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double c5(DynamicScheme dynamicScheme) {
        boolean s2 = s2(dynamicScheme);
        boolean z = dynamicScheme.f21194d;
        if (s2) {
            return Double.valueOf(z ? 90.0d : 25.0d);
        }
        return Double.valueOf(z ? 80.0d : 40.0d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair d4(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(W5(), V5(), 15.0d, TonePolarity.NEARER, false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair d5(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(s6(), r6(), 15.0d, TonePolarity.NEARER, false);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double e3(DynamicScheme dynamicScheme) {
        boolean s2 = s2(dynamicScheme);
        boolean z = dynamicScheme.f21194d;
        if (s2) {
            return Double.valueOf(z ? 10.0d : 90.0d);
        }
        return Double.valueOf(z ? 20.0d : 100.0d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor f3(DynamicScheme dynamicScheme) {
        return V5();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double f4(DynamicScheme dynamicScheme) {
        if (r2(dynamicScheme)) {
            return Double.valueOf(U5(dynamicScheme.f21192b, dynamicScheme));
        }
        boolean s2 = s2(dynamicScheme);
        boolean z = dynamicScheme.f21194d;
        if (s2) {
            return Double.valueOf(z ? 85.0d : 25.0d);
        }
        return Double.valueOf(z ? 30.0d : 90.0d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double f5(DynamicScheme dynamicScheme) {
        if (s2(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.f21194d ? 60.0d : 49.0d);
        } else if (!r2(dynamicScheme)) {
            return Double.valueOf(dynamicScheme.f21194d ? 30.0d : 90.0d);
        } else {
            return Double.valueOf(DislikeAnalyzer.a(dynamicScheme.f21198h.f(U5(dynamicScheme.f21198h.f(dynamicScheme.f21192b.e()), dynamicScheme))).e());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair g4(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(W5(), V5(), 15.0d, TonePolarity.NEARER, false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair g5(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(s6(), r6(), 15.0d, TonePolarity.NEARER, false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Double h3(DynamicScheme dynamicScheme) {
        if (r2(dynamicScheme)) {
            return Double.valueOf(DynamicColor.d(((Double) W5().f21183c.apply(dynamicScheme)).doubleValue(), 4.5d));
        }
        boolean s2 = s2(dynamicScheme);
        boolean z = dynamicScheme.f21194d;
        if (s2) {
            return Double.valueOf(z ? 0.0d : 100.0d);
        }
        return Double.valueOf(z ? 90.0d : 10.0d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor i3(DynamicScheme dynamicScheme) {
        return W5();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double i4(DynamicScheme dynamicScheme) {
        return Double.valueOf(s2(dynamicScheme) ? 40.0d : 90.0d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double i5(DynamicScheme dynamicScheme) {
        return Double.valueOf(s2(dynamicScheme) ? 40.0d : 90.0d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair j4(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(X5(), Y5(), 10.0d, TonePolarity.LIGHTER, true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair j5(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(t6(), u6(), 10.0d, TonePolarity.LIGHTER, true);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double k3(DynamicScheme dynamicScheme) {
        return Double.valueOf(s2(dynamicScheme) ? 100.0d : 10.0d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor l3(DynamicScheme dynamicScheme) {
        return Y5();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double l4(DynamicScheme dynamicScheme) {
        return Double.valueOf(s2(dynamicScheme) ? 30.0d : 80.0d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double l5(DynamicScheme dynamicScheme) {
        return Double.valueOf(s2(dynamicScheme) ? 30.0d : 80.0d);
    }

    static double m2(double d2, double d3, double d4, boolean z) {
        Hct a2 = Hct.a(d2, d3, d4);
        if (a2.c() >= d3) {
            return d4;
        }
        Hct hct = a2;
        double c2 = a2.c();
        double d5 = d4;
        while (hct.c() < d3) {
            double d6 = d5 + (z ? -1.0d : 1.0d);
            Hct a3 = Hct.a(d2, d3, d6);
            if (c2 > a3.c() || Math.abs(a3.c() - d3) < 0.4d) {
                return d6;
            }
            if (Math.abs(a3.c() - d3) < Math.abs(hct.c() - d3)) {
                hct = a3;
            }
            c2 = Math.max(c2, a3.c());
            d5 = d6;
        }
        return d5;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor m3(DynamicScheme dynamicScheme) {
        return X5();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair m4(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(X5(), Y5(), 10.0d, TonePolarity.LIGHTER, true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair m5(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(t6(), u6(), 10.0d, TonePolarity.LIGHTER, true);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double o3(DynamicScheme dynamicScheme) {
        return Double.valueOf(s2(dynamicScheme) ? 90.0d : 30.0d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor p3(DynamicScheme dynamicScheme) {
        return Y5();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor q3(DynamicScheme dynamicScheme) {
        return X5();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double q5(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 10.0d : 90.0d);
    }

    private static boolean r2(DynamicScheme dynamicScheme) {
        Variant variant = dynamicScheme.f21193c;
        return variant == Variant.FIDELITY || variant == Variant.CONTENT;
    }

    private static boolean s2(DynamicScheme dynamicScheme) {
        return dynamicScheme.f21193c == Variant.MONOCHROME;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double s3(DynamicScheme dynamicScheme) {
        boolean s2 = s2(dynamicScheme);
        double d2 = 100.0d;
        boolean z = dynamicScheme.f21194d;
        if (s2) {
            if (z) {
                d2 = 10.0d;
            }
            return Double.valueOf(d2);
        }
        if (z) {
            d2 = 20.0d;
        }
        return Double.valueOf(d2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double s4(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 80.0d : 40.0d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double s5(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 10.0d : 90.0d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor t3(DynamicScheme dynamicScheme) {
        return b6();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair t4(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(c6(), b6(), 15.0d, TonePolarity.NEARER, false);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double u2(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 6.0d : 98.0d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double u5(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 10.0d : 90.0d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Double v3(DynamicScheme dynamicScheme) {
        if (r2(dynamicScheme)) {
            return Double.valueOf(DynamicColor.d(((Double) c6().f21183c.apply(dynamicScheme)).doubleValue(), 4.5d));
        }
        return Double.valueOf(dynamicScheme.f21194d ? 90.0d : 10.0d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double v4(DynamicScheme dynamicScheme) {
        double d2 = 30.0d;
        double d3 = dynamicScheme.f21194d ? 30.0d : 90.0d;
        if (s2(dynamicScheme)) {
            if (!dynamicScheme.f21194d) {
                d2 = 85.0d;
            }
            return Double.valueOf(d2);
        } else if (!r2(dynamicScheme)) {
            return Double.valueOf(d3);
        } else {
            return Double.valueOf(U5(dynamicScheme.f21197g.f(m2(dynamicScheme.f21197g.g(), dynamicScheme.f21197g.e(), d3, !dynamicScheme.f21194d)), dynamicScheme));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double w2(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 30.0d : 90.0d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor w3(DynamicScheme dynamicScheme) {
        return c6();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair w4(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(c6(), b6(), 15.0d, TonePolarity.NEARER, false);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double w5(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 30.0d : 80.0d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double y2(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 100.0d : 0.0d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double y4(DynamicScheme dynamicScheme) {
        return Double.valueOf(s2(dynamicScheme) ? 80.0d : 90.0d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double y5(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 10.0d : 90.0d);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Double z2(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.f21194d ? 0.2d : 0.12d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DynamicColor z3(DynamicScheme dynamicScheme) {
        return e6();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ToneDeltaPair z4(DynamicScheme dynamicScheme) {
        return new ToneDeltaPair(d6(), e6(), 10.0d, TonePolarity.LIGHTER, true);
    }

    @NonNull
    public DynamicColor A5() {
        return DynamicColor.f("neutral_variant_palette_key_color", new S1(), new T1());
    }

    @NonNull
    public DynamicColor A6() {
        return DynamicColor.f("text_secondary_and_tertiary_inverse_disabled", new L0(), new W0());
    }

    @NonNull
    public DynamicColor B5() {
        return new DynamicColor("on_background", new C0399e1(), new C0402f1(), false, new C0405g1(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 3.0d, 4.5d, 7.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor C5() {
        return new DynamicColor("on_error", new E1(), new F1(), false, new G1(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor D5() {
        return new DynamicColor("on_error_container", new X(), new Y(), false, new Z(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor E5() {
        return new DynamicColor("on_primary", new C0423m1(), new C0426n1(), false, new C0429o1(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor F5() {
        return new DynamicColor("on_primary_container", new J1(), new K1(this), false, new L1(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor G5() {
        return new DynamicColor("on_primary_fixed", new F(), new G(), false, new H(this), new I(this), new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor H5() {
        return new DynamicColor("on_primary_fixed_variant", new C0452w1(), new C0455x1(), false, new C0458y1(this), new C0461z1(this), new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor I5() {
        return new DynamicColor("on_secondary", new C0397e(), new C0400f(), false, new C0403g(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor J5() {
        return new DynamicColor("on_secondary_container", new C(), new D(this), false, new E(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor K5() {
        return new DynamicColor("on_secondary_fixed", new r(), new C0438s(), false, new C0441t(this), new C0444u(this), new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor L5() {
        return new DynamicColor("on_secondary_fixed_variant", new C0428o0(), new C0431p0(), false, new C0434q0(this), new C0436r0(this), new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor M5() {
        return new DynamicColor("on_surface", new O1(), new Z1(), false, new k2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor N5() {
        return new DynamicColor("on_surface_variant", new S(), new T(), false, new k2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor O5() {
        return new DynamicColor("on_tertiary", new C0408h1(), new C0440s1(), false, new D1(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor P5() {
        return new DynamicColor("on_tertiary_container", new C0456y(), new A(this), false, new B(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor Q5() {
        return new DynamicColor("on_tertiary_fixed", new N0(), new O0(), false, new P0(this), new Q0(this), new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor R5() {
        return new DynamicColor("on_tertiary_fixed_variant", new B0(), new C0(), false, new D0(this), new E0(this), new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor S5() {
        return new DynamicColor("outline", new C0421m(), new C0424n(), false, new k2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.5d, 3.0d, 4.5d, 7.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor T5() {
        return new DynamicColor("outline_variant", new C0411i1(), new C0414j1(), false, new k2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor V5() {
        return new DynamicColor("primary", new C0413j0(), new C0416k0(), true, new k2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), new C0419l0(this));
    }

    @NonNull
    public DynamicColor W5() {
        return new DynamicColor("primary_container", new X0(), new Y0(), true, new k2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new Z0(this));
    }

    @NonNull
    public DynamicColor X5() {
        return new DynamicColor("primary_fixed", new b2(), new c2(), true, new k2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new d2(this));
    }

    @NonNull
    public DynamicColor Y5() {
        return new DynamicColor("primary_fixed_dim", new e2(), new f2(), true, new k2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new g2(this));
    }

    @NonNull
    public DynamicColor Z5() {
        return DynamicColor.f("primary_palette_key_color", new C0457y0(), new C0460z0());
    }

    @NonNull
    public DynamicColor a6() {
        return new DynamicColor("scrim", new C0422m0(), new C0425n0(), false, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor b6() {
        return new DynamicColor("secondary", new C0406h(), new C0409i(), true, new k2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), new C0412j(this));
    }

    @NonNull
    public DynamicColor c6() {
        return new DynamicColor("secondary_container", new J0(), new K0(), true, new k2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new M0(this));
    }

    @NonNull
    public DynamicColor d6() {
        return new DynamicColor("secondary_fixed", new C0443t1(), new C0446u1(), true, new k2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new C0449v1(this));
    }

    @NonNull
    public DynamicColor e6() {
        return new DynamicColor("secondary_fixed_dim", new M1(), new N1(), true, new k2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new P1(this));
    }

    @NonNull
    public DynamicColor f6() {
        return DynamicColor.f("secondary_palette_key_color", new F0(), new G0());
    }

    @NonNull
    public DynamicColor g2() {
        return new DynamicColor(CSS.Property.f27458a, new C0387a1(), new C0390b1(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor g6() {
        return new DynamicColor("shadow", new W1(), new X1(), false, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor h2() {
        return DynamicColor.f("control_activated", new C0451w0(), new C0454x0());
    }

    @NonNull
    public DynamicColor h6() {
        return new DynamicColor("surface", new C0394d(), new A0(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor i2() {
        return new DynamicColor("control_highlight", new T0(), new U0(), false, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null, new V0());
    }

    @NonNull
    public DynamicColor i6() {
        return new DynamicColor("surface_bright", new C0417k1(), new C0420l1(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor j2() {
        return DynamicColor.f("control_normal", new C0407h0(), new C0439s0());
    }

    @NonNull
    public DynamicColor j6() {
        return new DynamicColor("surface_container", new P(), new Q(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor k2() {
        return new DynamicColor("error", new J(), new L(), true, new k2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), new M(this));
    }

    @NonNull
    public DynamicColor k6() {
        return new DynamicColor("surface_container_high", new C0393c1(), new C0396d1(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor l2() {
        return new DynamicColor("error_container", new C0392c0(), new C0395d0(), true, new k2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new C0398e0(this));
    }

    @NonNull
    public DynamicColor l6() {
        return new DynamicColor("surface_container_highest", new Y1(), new a2(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor m6() {
        return new DynamicColor("surface_container_low", new H0(), new I0(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor n2(@NonNull DynamicScheme dynamicScheme) {
        return dynamicScheme.f21194d ? i6() : o6();
    }

    @NonNull
    public DynamicColor n6() {
        return new DynamicColor("surface_container_lowest", new C0415k(), new C0418l(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor o2() {
        return new DynamicColor("inverse_on_surface", new C0447v(), new C0450w(), false, new C0453x(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(4.5d, 7.0d, 11.0d, 21.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor o6() {
        return new DynamicColor("surface_dim", new K(), new W(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor p2() {
        return new DynamicColor("inverse_primary", new C0432p1(), new C0435q1(), false, new C0437r1(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor p6() {
        return new DynamicColor("surface_tint", new C0430p(), new C0433q(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor q2() {
        return new DynamicColor("inverse_surface", new U(), new V(), false, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor q6() {
        return new DynamicColor("surface_variant", new Q1(), new R1(), true, (Function<DynamicScheme, DynamicColor>) null, (Function<DynamicScheme, DynamicColor>) null, (ContrastCurve) null, (Function<DynamicScheme, ToneDeltaPair>) null);
    }

    @NonNull
    public DynamicColor r6() {
        return new DynamicColor("tertiary", new C0442t0(), new C0445u0(), true, new k2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(3.0d, 4.5d, 7.0d, 11.0d), new C0448v0(this));
    }

    @NonNull
    public DynamicColor s6() {
        return new DynamicColor("tertiary_container", new h2(), new i2(), true, new k2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new j2(this));
    }

    @NonNull
    public DynamicColor t6() {
        return new DynamicColor("tertiary_fixed", new C0401f0(), new C0404g0(), true, new k2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new C0410i0(this));
    }

    @NonNull
    public DynamicColor u6() {
        return new DynamicColor("tertiary_fixed_dim", new A1(), new B1(), true, new k2(this), (Function<DynamicScheme, DynamicColor>) null, new ContrastCurve(1.0d, 1.0d, 3.0d, 7.0d), new C1(this));
    }

    @NonNull
    public DynamicColor v6() {
        return DynamicColor.f("tertiary_palette_key_color", new R0(), new S0());
    }

    @NonNull
    public DynamicColor w6() {
        return DynamicColor.f("text_hint_inverse", new U1(), new V1());
    }

    @NonNull
    public DynamicColor x6() {
        return DynamicColor.f("text_primary_inverse", new N(), new O());
    }

    @NonNull
    public DynamicColor y6() {
        return DynamicColor.f("text_primary_inverse_disable_only", new H1(), new I1());
    }

    @NonNull
    public DynamicColor z5() {
        return DynamicColor.f("neutral_palette_key_color", new C0427o(), new C0459z());
    }

    @NonNull
    public DynamicColor z6() {
        return DynamicColor.f("text_secondary_and_tertiary_inverse", new C0386a0(), new C0389b0());
    }
}
