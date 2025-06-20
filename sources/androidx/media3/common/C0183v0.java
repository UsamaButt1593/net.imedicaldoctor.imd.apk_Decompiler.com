package androidx.media3.common;

import androidx.media3.common.SimpleBasePlayer;
import com.google.common.base.Supplier;

/* renamed from: androidx.media3.common.v0  reason: case insensitive filesystem */
public final /* synthetic */ class C0183v0 implements Supplier {
    public final /* synthetic */ SimpleBasePlayer.State s;

    public /* synthetic */ C0183v0(SimpleBasePlayer.State state) {
        this.s = state;
    }

    public final Object get() {
        return this.s.a().c0(this.s.t + 1).O();
    }
}
