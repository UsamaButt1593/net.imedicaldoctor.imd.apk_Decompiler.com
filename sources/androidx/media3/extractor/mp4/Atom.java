package androidx.media3.extractor.mp4;

import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.media3.common.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Atom {
    public static final int A = 1211250227;
    public static final int A0 = 1936289382;
    public static final int A1 = 1682927731;
    public static final int B = 1681012275;
    public static final int B0 = 1935894637;
    public static final int B1 = 1716281667;
    public static final int C = 1835295092;
    public static final int C0 = 1935894633;
    public static final int C1 = 1684425825;
    public static final int D = 1836069985;
    public static final int D0 = 1952804451;
    public static final int D1 = 1953984371;
    public static final int E = 778924082;
    public static final int E0 = 1701733238;
    public static final int E1 = 1668050025;
    public static final int F = 778924083;
    public static final int F0 = 1701733217;
    public static final int F1 = 1835295606;
    public static final int G = 1835557169;
    public static final int G0 = 1718775137;
    public static final int H = 1835560241;
    public static final int H0 = 1935763834;
    public static final int I = 1835557187;
    public static final int I0 = 1935763823;
    public static final int J = 1835557200;
    public static final int J0 = 1935828848;
    public static final int K = 2002876005;
    public static final int K0 = 1936158820;
    public static final int L = 1819304813;
    public static final int L0 = 1970628964;
    public static final int M = 1936684916;
    public static final int M0 = 1936027235;
    public static final int N = 1633889587;
    public static final int N0 = 1885434736;
    public static final int O = 1684103987;
    public static final int O0 = 1414810956;
    public static final int P = 1700998451;
    public static final int P0 = 1831958048;
    public static final int Q = 1684366131;
    public static final int Q0 = 1836070006;
    public static final int R = 1633889588;
    public static final int R0 = 1937011827;
    public static final int S = 1684103988;
    public static final int S0 = 1937011571;
    public static final int T = 1835823201;
    public static final int T0 = 1668576371;
    public static final int U = 1684892784;
    public static final int U0 = 1937011555;
    public static final int V = 1685353315;
    public static final int V0 = 1937011578;
    public static final int W = 1685353320;
    public static final int W0 = 1937013298;
    public static final int X = 1685353324;
    public static final int X0 = 1937007471;
    public static final int Y = 1685353317;
    public static final int Y0 = 1668232756;
    public static final int Z = 1685353336;
    public static final int Z0 = 1954034535;
    public static final int a0 = 1684305011;
    public static final int a1 = 2004251764;

    /* renamed from: b  reason: collision with root package name */
    public static final int f13497b = 8;
    public static final int b0 = 1969517683;
    public static final int b1 = 1937010800;

    /* renamed from: c  reason: collision with root package name */
    public static final int f13498c = 12;
    public static final int c0 = 1952867444;
    public static final int c1 = 1664495672;

    /* renamed from: d  reason: collision with root package name */
    public static final int f13499d = 16;
    public static final int d0 = 1952868452;
    public static final int d1 = 1935764850;

    /* renamed from: e  reason: collision with root package name */
    public static final int f13500e = 1;
    public static final int e0 = 1953654136;
    public static final int e1 = 1935767394;

    /* renamed from: f  reason: collision with root package name */
    public static final int f13501f = 0;
    public static final int f0 = 1953658222;
    public static final int f1 = 1969517665;

    /* renamed from: g  reason: collision with root package name */
    public static final int f13502g = 1718909296;
    public static final int g0 = 1936286840;
    public static final int g1 = 1835365473;

    /* renamed from: h  reason: collision with root package name */
    public static final int f13503h = 1635148593;
    public static final int h0 = 1836019574;
    public static final int h1 = -1451722374;

    /* renamed from: i  reason: collision with root package name */
    public static final int f13504i = 1635148595;
    public static final int i0 = 1836086884;
    public static final int i1 = 1936553057;

    /* renamed from: j  reason: collision with root package name */
    public static final int f13505j = 1635148611;
    public static final int j0 = 1836476516;
    public static final int j1 = 1935766900;

    /* renamed from: k  reason: collision with root package name */
    public static final int f13506k = 1752589105;
    public static final int k0 = 1953653099;
    public static final int k1 = 1936877170;

    /* renamed from: l  reason: collision with root package name */
    public static final int f13507l = 1751479857;
    public static final int l0 = 1835297121;
    public static final int l1 = 1801812339;

    /* renamed from: m  reason: collision with root package name */
    public static final int f13508m = 1752589123;
    public static final int m0 = 1835626086;
    public static final int m1 = 1768715124;

    /* renamed from: n  reason: collision with root package name */
    public static final int f13509n = 1987063864;
    public static final int n0 = 1937007212;
    public static final int n1 = 1835360622;
    public static final int o = 1987063865;
    public static final int o0 = 1702061171;
    public static final int o1 = 1851878757;
    public static final int p = 1987076931;
    public static final int p0 = 1836019558;
    public static final int p1 = 1684108385;
    public static final int q = 1635135537;
    public static final int q0 = 1953653094;
    public static final int q1 = 1701671783;
    public static final int r = 1635135811;
    public static final int r0 = 1836475768;
    public static final int r1 = 1936995172;
    public static final int s = 1668246642;
    public static final int s0 = 1835362404;
    public static final int s1 = 1937126244;
    public static final int t = 1685479798;
    public static final int t0 = 1953196132;
    public static final int t1 = 1886547818;
    public static final int u = 1685479729;
    public static final int u0 = 1701082227;
    public static final int u1 = 1667329389;
    public static final int v = 1685481573;
    public static final int v0 = 1701606260;
    public static final int v1 = 1835365492;
    public static final int w = 1685481521;
    public static final int w0 = 1835296868;
    public static final int w1 = 1634492771;
    public static final int x = 1685480259;
    public static final int x0 = 1751411826;
    public static final int x1 = 1634492791;
    public static final int y = 1685485123;
    public static final int y0 = 1937011556;
    public static final int y1 = 1970037111;
    public static final int z = 1932670515;
    public static final int z0 = 1886614376;
    public static final int z1 = 1332770163;

    /* renamed from: a  reason: collision with root package name */
    public final int f13510a;

    static final class ContainerAtom extends Atom {
        public final long G1;
        public final List<LeafAtom> H1 = new ArrayList();
        public final List<ContainerAtom> I1 = new ArrayList();

        public ContainerAtom(int i2, long j2) {
            super(i2);
            this.G1 = j2;
        }

        public void d(ContainerAtom containerAtom) {
            this.I1.add(containerAtom);
        }

        public void e(LeafAtom leafAtom) {
            this.H1.add(leafAtom);
        }

        public int f(int i2) {
            int size = this.H1.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                if (this.H1.get(i4).f13510a == i2) {
                    i3++;
                }
            }
            int size2 = this.I1.size();
            for (int i5 = 0; i5 < size2; i5++) {
                if (this.I1.get(i5).f13510a == i2) {
                    i3++;
                }
            }
            return i3;
        }

        @Nullable
        public ContainerAtom g(int i2) {
            int size = this.I1.size();
            for (int i3 = 0; i3 < size; i3++) {
                ContainerAtom containerAtom = this.I1.get(i3);
                if (containerAtom.f13510a == i2) {
                    return containerAtom;
                }
            }
            return null;
        }

        @Nullable
        public LeafAtom h(int i2) {
            int size = this.H1.size();
            for (int i3 = 0; i3 < size; i3++) {
                LeafAtom leafAtom = this.H1.get(i3);
                if (leafAtom.f13510a == i2) {
                    return leafAtom;
                }
            }
            return null;
        }

        public String toString() {
            return Atom.a(this.f13510a) + " leaves: " + Arrays.toString(this.H1.toArray()) + " containers: " + Arrays.toString(this.I1.toArray());
        }
    }

    static final class LeafAtom extends Atom {
        public final ParsableByteArray G1;

        public LeafAtom(int i2, ParsableByteArray parsableByteArray) {
            super(i2);
            this.G1 = parsableByteArray;
        }
    }

    public Atom(int i2) {
        this.f13510a = i2;
    }

    public static String a(int i2) {
        return "" + ((char) ((i2 >> 24) & 255)) + ((char) ((i2 >> 16) & 255)) + ((char) ((i2 >> 8) & 255)) + ((char) (i2 & 255));
    }

    public static int b(int i2) {
        return i2 & ViewCompat.x;
    }

    public static int c(int i2) {
        return (i2 >> 24) & 255;
    }

    public String toString() {
        return a(this.f13510a);
    }
}
