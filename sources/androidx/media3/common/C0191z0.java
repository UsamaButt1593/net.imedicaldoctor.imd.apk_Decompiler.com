package androidx.media3.common;

import androidx.media3.common.SimpleBasePlayer;
import com.google.common.base.Supplier;

/* renamed from: androidx.media3.common.z0  reason: case insensitive filesystem */
public final /* synthetic */ class C0191z0 implements Supplier {
    public final /* synthetic */ int X;
    public final /* synthetic */ SimpleBasePlayer.State s;

    public /* synthetic */ C0191z0(SimpleBasePlayer.State state, int i2) {
        this.s = state;
        this.X = i2;
    }

    public final Object get() {
        return this.s.a().c0(this.X).O();
    }
}
