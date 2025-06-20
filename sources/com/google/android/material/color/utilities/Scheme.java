package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import com.dd.plist.ASCIIPropertyListParser;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;

@CheckReturnValue
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class Scheme {
    private int A;
    private int B;
    private int C;

    /* renamed from: a  reason: collision with root package name */
    private int f21246a;

    /* renamed from: b  reason: collision with root package name */
    private int f21247b;

    /* renamed from: c  reason: collision with root package name */
    private int f21248c;

    /* renamed from: d  reason: collision with root package name */
    private int f21249d;

    /* renamed from: e  reason: collision with root package name */
    private int f21250e;

    /* renamed from: f  reason: collision with root package name */
    private int f21251f;

    /* renamed from: g  reason: collision with root package name */
    private int f21252g;

    /* renamed from: h  reason: collision with root package name */
    private int f21253h;

    /* renamed from: i  reason: collision with root package name */
    private int f21254i;

    /* renamed from: j  reason: collision with root package name */
    private int f21255j;

    /* renamed from: k  reason: collision with root package name */
    private int f21256k;

    /* renamed from: l  reason: collision with root package name */
    private int f21257l;

    /* renamed from: m  reason: collision with root package name */
    private int f21258m;

    /* renamed from: n  reason: collision with root package name */
    private int f21259n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public Scheme() {
    }

    public static Scheme G(int i2) {
        return I(CorePalette.b(i2));
    }

    public static Scheme H(int i2) {
        return I(CorePalette.a(i2));
    }

    private static Scheme I(CorePalette corePalette) {
        return new Scheme().F0(corePalette.f21172a.i(40)).v0(corePalette.f21172a.i(100)).G0(corePalette.f21172a.i(90)).w0(corePalette.f21172a.i(10)).I0(corePalette.f21173b.i(40)).x0(corePalette.f21173b.i(100)).J0(corePalette.f21173b.i(90)).y0(corePalette.f21173b.i(10)).N0(corePalette.f21174c.i(40)).B0(corePalette.f21174c.i(100)).O0(corePalette.f21174c.i(90)).C0(corePalette.f21174c.i(10)).n0(corePalette.f21177f.i(40)).t0(corePalette.f21177f.i(100)).o0(corePalette.f21177f.i(90)).u0(corePalette.f21177f.i(10)).m0(corePalette.f21175d.i(99)).s0(corePalette.f21175d.i(10)).L0(corePalette.f21175d.i(99)).z0(corePalette.f21175d.i(10)).M0(corePalette.f21176e.i(90)).A0(corePalette.f21176e.i(30)).D0(corePalette.f21176e.i(50)).E0(corePalette.f21176e.i(80)).K0(corePalette.f21175d.i(0)).H0(corePalette.f21175d.i(0)).r0(corePalette.f21175d.i(20)).p0(corePalette.f21175d.i(95)).q0(corePalette.f21172a.i(80));
    }

    public static Scheme a(int i2) {
        return c(CorePalette.b(i2));
    }

    public static Scheme b(int i2) {
        return c(CorePalette.a(i2));
    }

    private static Scheme c(CorePalette corePalette) {
        return new Scheme().F0(corePalette.f21172a.i(80)).v0(corePalette.f21172a.i(20)).G0(corePalette.f21172a.i(30)).w0(corePalette.f21172a.i(90)).I0(corePalette.f21173b.i(80)).x0(corePalette.f21173b.i(20)).J0(corePalette.f21173b.i(30)).y0(corePalette.f21173b.i(90)).N0(corePalette.f21174c.i(80)).B0(corePalette.f21174c.i(20)).O0(corePalette.f21174c.i(30)).C0(corePalette.f21174c.i(90)).n0(corePalette.f21177f.i(80)).t0(corePalette.f21177f.i(20)).o0(corePalette.f21177f.i(30)).u0(corePalette.f21177f.i(80)).m0(corePalette.f21175d.i(10)).s0(corePalette.f21175d.i(90)).L0(corePalette.f21175d.i(10)).z0(corePalette.f21175d.i(90)).M0(corePalette.f21176e.i(30)).A0(corePalette.f21176e.i(80)).D0(corePalette.f21176e.i(60)).E0(corePalette.f21176e.i(30)).K0(corePalette.f21175d.i(0)).H0(corePalette.f21175d.i(0)).r0(corePalette.f21175d.i(90)).p0(corePalette.f21175d.i(20)).q0(corePalette.f21172a.i(40));
    }

    public int A() {
        return this.f21252g;
    }

    @CanIgnoreReturnValue
    public Scheme A0(int i2) {
        this.v = i2;
        return this;
    }

    public int B() {
        return this.y;
    }

    @CanIgnoreReturnValue
    public Scheme B0(int i2) {
        this.f21255j = i2;
        return this;
    }

    public int C() {
        return this.s;
    }

    @CanIgnoreReturnValue
    public Scheme C0(int i2) {
        this.f21257l = i2;
        return this;
    }

    public int D() {
        return this.u;
    }

    @CanIgnoreReturnValue
    public Scheme D0(int i2) {
        this.w = i2;
        return this;
    }

    public int E() {
        return this.f21254i;
    }

    @CanIgnoreReturnValue
    public Scheme E0(int i2) {
        this.x = i2;
        return this;
    }

    public int F() {
        return this.f21256k;
    }

    @CanIgnoreReturnValue
    public Scheme F0(int i2) {
        this.f21246a = i2;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme G0(int i2) {
        this.f21248c = i2;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme H0(int i2) {
        this.z = i2;
        return this;
    }

    @CanIgnoreReturnValue
    public Scheme I0(int i2) {
        this.f21250e = i2;
        return this;
    }

    public void J(int i2) {
        this.q = i2;
    }

    @CanIgnoreReturnValue
    public Scheme J0(int i2) {
        this.f21252g = i2;
        return this;
    }

    public void K(int i2) {
        this.f21258m = i2;
    }

    @CanIgnoreReturnValue
    public Scheme K0(int i2) {
        this.y = i2;
        return this;
    }

    public void L(int i2) {
        this.o = i2;
    }

    @CanIgnoreReturnValue
    public Scheme L0(int i2) {
        this.s = i2;
        return this;
    }

    public void M(int i2) {
        this.B = i2;
    }

    @CanIgnoreReturnValue
    public Scheme M0(int i2) {
        this.u = i2;
        return this;
    }

    public void N(int i2) {
        this.C = i2;
    }

    @CanIgnoreReturnValue
    public Scheme N0(int i2) {
        this.f21254i = i2;
        return this;
    }

    public void O(int i2) {
        this.A = i2;
    }

    @CanIgnoreReturnValue
    public Scheme O0(int i2) {
        this.f21256k = i2;
        return this;
    }

    public void P(int i2) {
        this.r = i2;
    }

    public void Q(int i2) {
        this.f21259n = i2;
    }

    public void R(int i2) {
        this.p = i2;
    }

    public void S(int i2) {
        this.f21247b = i2;
    }

    public void T(int i2) {
        this.f21249d = i2;
    }

    public void U(int i2) {
        this.f21251f = i2;
    }

    public void V(int i2) {
        this.f21253h = i2;
    }

    public void W(int i2) {
        this.t = i2;
    }

    public void X(int i2) {
        this.v = i2;
    }

    public void Y(int i2) {
        this.f21255j = i2;
    }

    public void Z(int i2) {
        this.f21257l = i2;
    }

    public void a0(int i2) {
        this.w = i2;
    }

    public void b0(int i2) {
        this.x = i2;
    }

    public void c0(int i2) {
        this.f21246a = i2;
    }

    public int d() {
        return this.q;
    }

    public void d0(int i2) {
        this.f21248c = i2;
    }

    public int e() {
        return this.f21258m;
    }

    public void e0(int i2) {
        this.z = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scheme) || !super.equals(obj)) {
            return false;
        }
        Scheme scheme = (Scheme) obj;
        return this.f21246a == scheme.f21246a && this.f21247b == scheme.f21247b && this.f21248c == scheme.f21248c && this.f21249d == scheme.f21249d && this.f21250e == scheme.f21250e && this.f21251f == scheme.f21251f && this.f21252g == scheme.f21252g && this.f21253h == scheme.f21253h && this.f21254i == scheme.f21254i && this.f21255j == scheme.f21255j && this.f21256k == scheme.f21256k && this.f21257l == scheme.f21257l && this.f21258m == scheme.f21258m && this.f21259n == scheme.f21259n && this.o == scheme.o && this.p == scheme.p && this.q == scheme.q && this.r == scheme.r && this.s == scheme.s && this.t == scheme.t && this.u == scheme.u && this.v == scheme.v && this.w == scheme.w && this.x == scheme.x && this.y == scheme.y && this.z == scheme.z && this.A == scheme.A && this.B == scheme.B && this.C == scheme.C;
    }

    public int f() {
        return this.o;
    }

    public void f0(int i2) {
        this.f21250e = i2;
    }

    public int g() {
        return this.B;
    }

    public void g0(int i2) {
        this.f21252g = i2;
    }

    public int h() {
        return this.C;
    }

    public void h0(int i2) {
        this.y = i2;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((super.hashCode() * 31) + this.f21246a) * 31) + this.f21247b) * 31) + this.f21248c) * 31) + this.f21249d) * 31) + this.f21250e) * 31) + this.f21251f) * 31) + this.f21252g) * 31) + this.f21253h) * 31) + this.f21254i) * 31) + this.f21255j) * 31) + this.f21256k) * 31) + this.f21257l) * 31) + this.f21258m) * 31) + this.f21259n) * 31) + this.o) * 31) + this.p) * 31) + this.q) * 31) + this.r) * 31) + this.s) * 31) + this.t) * 31) + this.u) * 31) + this.v) * 31) + this.w) * 31) + this.x) * 31) + this.y) * 31) + this.z) * 31) + this.A) * 31) + this.B) * 31) + this.C;
    }

    public int i() {
        return this.A;
    }

    public void i0(int i2) {
        this.s = i2;
    }

    public int j() {
        return this.r;
    }

    public void j0(int i2) {
        this.u = i2;
    }

    public int k() {
        return this.f21259n;
    }

    public void k0(int i2) {
        this.f21254i = i2;
    }

    public int l() {
        return this.p;
    }

    public void l0(int i2) {
        this.f21256k = i2;
    }

    public int m() {
        return this.f21247b;
    }

    @CanIgnoreReturnValue
    public Scheme m0(int i2) {
        this.q = i2;
        return this;
    }

    public int n() {
        return this.f21249d;
    }

    @CanIgnoreReturnValue
    public Scheme n0(int i2) {
        this.f21258m = i2;
        return this;
    }

    public int o() {
        return this.f21251f;
    }

    @CanIgnoreReturnValue
    public Scheme o0(int i2) {
        this.o = i2;
        return this;
    }

    public int p() {
        return this.f21253h;
    }

    @CanIgnoreReturnValue
    public Scheme p0(int i2) {
        this.B = i2;
        return this;
    }

    public int q() {
        return this.t;
    }

    @CanIgnoreReturnValue
    public Scheme q0(int i2) {
        this.C = i2;
        return this;
    }

    public int r() {
        return this.v;
    }

    @CanIgnoreReturnValue
    public Scheme r0(int i2) {
        this.A = i2;
        return this;
    }

    public int s() {
        return this.f21255j;
    }

    @CanIgnoreReturnValue
    public Scheme s0(int i2) {
        this.r = i2;
        return this;
    }

    public int t() {
        return this.f21257l;
    }

    @CanIgnoreReturnValue
    public Scheme t0(int i2) {
        this.f21259n = i2;
        return this;
    }

    public String toString() {
        return "Scheme{primary=" + this.f21246a + ", onPrimary=" + this.f21247b + ", primaryContainer=" + this.f21248c + ", onPrimaryContainer=" + this.f21249d + ", secondary=" + this.f21250e + ", onSecondary=" + this.f21251f + ", secondaryContainer=" + this.f21252g + ", onSecondaryContainer=" + this.f21253h + ", tertiary=" + this.f21254i + ", onTertiary=" + this.f21255j + ", tertiaryContainer=" + this.f21256k + ", onTertiaryContainer=" + this.f21257l + ", error=" + this.f21258m + ", onError=" + this.f21259n + ", errorContainer=" + this.o + ", onErrorContainer=" + this.p + ", background=" + this.q + ", onBackground=" + this.r + ", surface=" + this.s + ", onSurface=" + this.t + ", surfaceVariant=" + this.u + ", onSurfaceVariant=" + this.v + ", outline=" + this.w + ", outlineVariant=" + this.x + ", shadow=" + this.y + ", scrim=" + this.z + ", inverseSurface=" + this.A + ", inverseOnSurface=" + this.B + ", inversePrimary=" + this.C + ASCIIPropertyListParser.f18653k;
    }

    public int u() {
        return this.w;
    }

    @CanIgnoreReturnValue
    public Scheme u0(int i2) {
        this.p = i2;
        return this;
    }

    public int v() {
        return this.x;
    }

    @CanIgnoreReturnValue
    public Scheme v0(int i2) {
        this.f21247b = i2;
        return this;
    }

    public int w() {
        return this.f21246a;
    }

    @CanIgnoreReturnValue
    public Scheme w0(int i2) {
        this.f21249d = i2;
        return this;
    }

    public int x() {
        return this.f21248c;
    }

    @CanIgnoreReturnValue
    public Scheme x0(int i2) {
        this.f21251f = i2;
        return this;
    }

    public int y() {
        return this.z;
    }

    @CanIgnoreReturnValue
    public Scheme y0(int i2) {
        this.f21253h = i2;
        return this;
    }

    public int z() {
        return this.f21250e;
    }

    @CanIgnoreReturnValue
    public Scheme z0(int i2) {
        this.t = i2;
        return this;
    }

    public Scheme(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30) {
        this.f21246a = i2;
        this.f21247b = i3;
        this.f21248c = i4;
        this.f21249d = i5;
        this.f21250e = i6;
        this.f21251f = i7;
        this.f21252g = i8;
        this.f21253h = i9;
        this.f21254i = i10;
        this.f21255j = i11;
        this.f21256k = i12;
        this.f21257l = i13;
        this.f21258m = i14;
        this.f21259n = i15;
        this.o = i16;
        this.p = i17;
        this.q = i18;
        this.r = i19;
        this.s = i20;
        this.t = i21;
        this.u = i22;
        this.v = i23;
        this.w = i24;
        this.x = i25;
        this.y = i26;
        this.z = i27;
        this.A = i28;
        this.B = i29;
        this.C = i30;
    }
}
