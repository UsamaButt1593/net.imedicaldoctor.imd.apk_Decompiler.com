package androidx.media3.decoder;

import androidx.annotation.CallSuper;
import androidx.media3.common.C;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public abstract class Buffer {
    private int s;

    public final void f(int i2) {
        this.s = i2 | this.s;
    }

    @CallSuper
    public void g() {
        this.s = 0;
    }

    public final void h(int i2) {
        this.s = (~i2) & this.s;
    }

    /* access modifiers changed from: protected */
    public final boolean i(int i2) {
        return (this.s & i2) == i2;
    }

    public final boolean j() {
        return i(268435456);
    }

    @Deprecated
    public final boolean k() {
        return i(Integer.MIN_VALUE);
    }

    public final boolean l() {
        return i(4);
    }

    public final boolean m() {
        return i(C.S0);
    }

    public final boolean n() {
        return i(1);
    }

    public final boolean o() {
        return i(536870912);
    }

    public final void p(int i2) {
        this.s = i2;
    }
}
