package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.source.ShuffleOrder;

@UnstableApi
public abstract class AbstractConcatenatedTimeline extends Timeline {
    private final int Y2;
    private final ShuffleOrder Z2;
    private final boolean a3;

    public AbstractConcatenatedTimeline(boolean z, ShuffleOrder shuffleOrder) {
        this.a3 = z;
        this.Z2 = shuffleOrder;
        this.Y2 = shuffleOrder.getLength();
    }

    public static Object C(Object obj) {
        return ((Pair) obj).second;
    }

    public static Object D(Object obj) {
        return ((Pair) obj).first;
    }

    public static Object F(Object obj, Object obj2) {
        return Pair.create(obj, obj2);
    }

    private int I(int i2, boolean z) {
        if (z) {
            return this.Z2.d(i2);
        }
        if (i2 < this.Y2 - 1) {
            return i2 + 1;
        }
        return -1;
    }

    private int J(int i2, boolean z) {
        if (z) {
            return this.Z2.c(i2);
        }
        if (i2 > 0) {
            return i2 - 1;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public abstract int A(int i2);

    /* access modifiers changed from: protected */
    public abstract int B(int i2);

    /* access modifiers changed from: protected */
    public abstract Object E(int i2);

    /* access modifiers changed from: protected */
    public abstract int G(int i2);

    /* access modifiers changed from: protected */
    public abstract int H(int i2);

    /* access modifiers changed from: protected */
    public abstract Timeline K(int i2);

    public int f(boolean z) {
        if (this.Y2 == 0) {
            return -1;
        }
        int i2 = 0;
        if (this.a3) {
            z = false;
        }
        if (z) {
            i2 = this.Z2.b();
        }
        while (K(i2).x()) {
            i2 = I(i2, z);
            if (i2 == -1) {
                return -1;
            }
        }
        return H(i2) + K(i2).f(z);
    }

    public final int g(Object obj) {
        int g2;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Object D = D(obj);
        Object C = C(obj);
        int z = z(D);
        if (z == -1 || (g2 = K(z).g(C)) == -1) {
            return -1;
        }
        return G(z) + g2;
    }

    public int h(boolean z) {
        int i2 = this.Y2;
        if (i2 == 0) {
            return -1;
        }
        if (this.a3) {
            z = false;
        }
        int f2 = z ? this.Z2.f() : i2 - 1;
        while (K(f2).x()) {
            f2 = J(f2, z);
            if (f2 == -1) {
                return -1;
            }
        }
        return H(f2) + K(f2).h(z);
    }

    public int j(int i2, int i3, boolean z) {
        int i4 = 0;
        if (this.a3) {
            if (i3 == 1) {
                i3 = 2;
            }
            z = false;
        }
        int B = B(i2);
        int H = H(B);
        Timeline K = K(B);
        int i5 = i2 - H;
        if (i3 != 2) {
            i4 = i3;
        }
        int j2 = K.j(i5, i4, z);
        if (j2 != -1) {
            return H + j2;
        }
        int I = I(B, z);
        while (I != -1 && K(I).x()) {
            I = I(I, z);
        }
        if (I != -1) {
            return H(I) + K(I).f(z);
        }
        if (i3 == 2) {
            return f(z);
        }
        return -1;
    }

    public final Timeline.Period l(int i2, Timeline.Period period, boolean z) {
        int A = A(i2);
        int H = H(A);
        K(A).l(i2 - G(A), period, z);
        period.Y += H;
        if (z) {
            period.X = F(E(A), Assertions.g(period.X));
        }
        return period;
    }

    public final Timeline.Period m(Object obj, Timeline.Period period) {
        Object D = D(obj);
        Object C = C(obj);
        int z = z(D);
        int H = H(z);
        K(z).m(C, period);
        period.Y += H;
        period.X = obj;
        return period;
    }

    public int s(int i2, int i3, boolean z) {
        int i4 = 0;
        if (this.a3) {
            if (i3 == 1) {
                i3 = 2;
            }
            z = false;
        }
        int B = B(i2);
        int H = H(B);
        Timeline K = K(B);
        int i5 = i2 - H;
        if (i3 != 2) {
            i4 = i3;
        }
        int s = K.s(i5, i4, z);
        if (s != -1) {
            return H + s;
        }
        int J = J(B, z);
        while (J != -1 && K(J).x()) {
            J = J(J, z);
        }
        if (J != -1) {
            return H(J) + K(J).h(z);
        }
        if (i3 == 2) {
            return h(z);
        }
        return -1;
    }

    public final Object t(int i2) {
        int A = A(i2);
        return F(E(A), K(A).t(i2 - G(A)));
    }

    public final Timeline.Window v(int i2, Timeline.Window window, long j2) {
        int B = B(i2);
        int H = H(B);
        int G = G(B);
        K(B).v(i2 - H, window, j2);
        Object E = E(B);
        if (!Timeline.Window.k3.equals(window.s)) {
            E = F(E, window.s);
        }
        window.s = E;
        window.h3 += G;
        window.i3 += G;
        return window;
    }

    /* access modifiers changed from: protected */
    public abstract int z(Object obj);
}
