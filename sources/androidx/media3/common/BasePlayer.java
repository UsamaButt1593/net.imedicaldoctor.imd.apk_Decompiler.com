package androidx.media3.common;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import java.util.List;

@UnstableApi
public abstract class BasePlayer implements Player {
    protected final Timeline.Window b1 = new Timeline.Window();

    protected BasePlayer() {
    }

    private int D2() {
        int q = q();
        if (q == 1) {
            return 0;
        }
        return q;
    }

    private void E2(int i2) {
        F2(P1(), C.f9084b, i2, true);
    }

    private void G2(long j2, int i2) {
        F2(P1(), j2, i2, false);
    }

    private void H2(int i2, int i3) {
        F2(i2, C.f9084b, i3, false);
    }

    private void I2(int i2) {
        int M1 = M1();
        if (M1 != -1) {
            if (M1 == P1()) {
                E2(i2);
            } else {
                H2(M1, i2);
            }
        }
    }

    private void J2(long j2, int i2) {
        long z2 = z2() + j2;
        long Q = Q();
        if (Q != C.f9084b) {
            z2 = Math.min(z2, Q);
        }
        G2(Math.max(z2, 0), i2);
    }

    private void K2(int i2) {
        int y0 = y0();
        if (y0 != -1) {
            if (y0 == P1()) {
                E2(i2);
            } else {
                H2(y0, i2);
            }
        }
    }

    public final long A0() {
        Timeline j2 = j2();
        return j2.x() ? C.f9084b : j2.u(P1(), this.b1).f();
    }

    public final boolean B2() {
        Timeline j2 = j2();
        return !j2.x() && j2.u(P1(), this.b1).j();
    }

    @Deprecated
    public final boolean C0() {
        return w1();
    }

    public final void D0() {
        K2(6);
    }

    public final void E0() {
        H2(P1(), 4);
    }

    public final void F1(MediaItem mediaItem) {
        h2(ImmutableList.K(mediaItem));
    }

    @VisibleForTesting(otherwise = 4)
    public abstract void F2(int i2, long j2, int i3, boolean z);

    public final void G(long j2) {
        G2(j2, 5);
    }

    public final boolean H1() {
        return M1() != -1;
    }

    public final boolean J1() {
        return i() == 3 && m0() && g2() == 0;
    }

    public final void K1(MediaItem mediaItem, long j2) {
        h1(ImmutableList.K(mediaItem), 0, j2);
    }

    public final boolean L0() {
        return y0() != -1;
    }

    public final int M1() {
        Timeline j2 = j2();
        if (j2.x()) {
            return -1;
        }
        return j2.j(P1(), D2(), m2());
    }

    @Deprecated
    public final void Q0() {
        z1();
    }

    public final boolean R1(int i2) {
        return j0().d(i2);
    }

    @Deprecated
    public final boolean S0() {
        return e2();
    }

    @Deprecated
    public final int U1() {
        return M1();
    }

    public final boolean W0() {
        return true;
    }

    public final void Y0(int i2) {
        c1(i2, i2 + 1);
    }

    public final int Z0() {
        return j2().w();
    }

    @Deprecated
    public final boolean a1() {
        return L0();
    }

    public final void a2(int i2, int i3) {
        if (i2 != i3) {
            c2(i2, i2 + 1, i3);
        }
    }

    @Deprecated
    public final boolean b2() {
        return B2();
    }

    @Deprecated
    public final int d1() {
        return P1();
    }

    public final long e0() {
        Timeline j2 = j2();
        return (!j2.x() && j2.u(P1(), this.b1).Y2 != C.f9084b) ? (this.b1.c() - this.b1.Y2) - n1() : C.f9084b;
    }

    public final boolean e2() {
        Timeline j2 = j2();
        return !j2.x() && j2.u(P1(), this.b1).b3;
    }

    public final void f0(int i2, MediaItem mediaItem) {
        q1(i2, ImmutableList.K(mediaItem));
    }

    public final void f1() {
        if (!j2().x() && !c0()) {
            boolean L0 = L0();
            if (!B2() || w1()) {
                if (!L0 || z2() > w0()) {
                    G2(0, 7);
                    return;
                }
            } else if (!L0) {
                return;
            }
            K2(7);
        }
    }

    @Deprecated
    public final boolean g0() {
        return H1();
    }

    public final void h() {
        i1(false);
    }

    public final void h2(List<MediaItem> list) {
        q1(Integer.MAX_VALUE, list);
    }

    @Deprecated
    public final boolean hasNext() {
        return H1();
    }

    @Deprecated
    public final boolean hasPrevious() {
        return L0();
    }

    public final void i0(int i2, long j2) {
        F2(i2, j2, 10, false);
    }

    public final void k1(int i2) {
        H2(i2, 10);
    }

    public final void m(float f2) {
        f(r().d(f2));
    }

    public final void n0() {
        c1(0, Integer.MAX_VALUE);
    }

    @Deprecated
    public final void next() {
        z1();
    }

    public final void o() {
        i1(true);
    }

    @Nullable
    public final MediaItem o0() {
        Timeline j2 = j2();
        if (j2.x()) {
            return null;
        }
        return j2.u(P1(), this.b1).Y;
    }

    @Deprecated
    public final void p1() {
        D0();
    }

    @Deprecated
    public final void previous() {
        D0();
    }

    public final void q2() {
        if (!j2().x() && !c0()) {
            if (H1()) {
                I2(9);
            } else if (B2() && e2()) {
                H2(P1(), 9);
            }
        }
    }

    @Deprecated
    public final int r1() {
        return y0();
    }

    public final void s2() {
        J2(l1(), 12);
    }

    public final int t0() {
        long u1 = u1();
        long Q = Q();
        if (u1 == C.f9084b || Q == C.f9084b) {
            return 0;
        }
        if (Q == 0) {
            return 100;
        }
        return Util.w((int) ((u1 * 100) / Q), 0, 100);
    }

    @Nullable
    public final Object t1() {
        Timeline j2 = j2();
        if (j2.x()) {
            return null;
        }
        return j2.u(P1(), this.b1).Z;
    }

    public final MediaItem v0(int i2) {
        return j2().u(i2, this.b1).Y;
    }

    public final void v2() {
        J2(-A2(), 11);
    }

    public final boolean w1() {
        Timeline j2 = j2();
        return !j2.x() && j2.u(P1(), this.b1).a3;
    }

    public final void x(int i2, MediaItem mediaItem) {
        F(i2, i2 + 1, ImmutableList.K(mediaItem));
    }

    public final void x1(MediaItem mediaItem, boolean z) {
        F0(ImmutableList.K(mediaItem), z);
    }

    public final int y0() {
        Timeline j2 = j2();
        if (j2.x()) {
            return -1;
        }
        return j2.s(P1(), D2(), m2());
    }

    public final void y1(MediaItem mediaItem) {
        y2(ImmutableList.K(mediaItem));
    }

    public final void y2(List<MediaItem> list) {
        F0(list, true);
    }

    public final void z1() {
        I2(8);
    }
}
