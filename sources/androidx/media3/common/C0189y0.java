package androidx.media3.common;

import androidx.media3.common.SimpleBasePlayer;
import com.google.common.base.Supplier;

/* renamed from: androidx.media3.common.y0  reason: case insensitive filesystem */
public final /* synthetic */ class C0189y0 implements Supplier {
    public final /* synthetic */ boolean X;
    public final /* synthetic */ SimpleBasePlayer.State s;

    public /* synthetic */ C0189y0(SimpleBasePlayer.State state, boolean z) {
        this.s = state;
        this.X = z;
    }

    public final Object get() {
        return this.s.a().s0(this.X).O();
    }
}
