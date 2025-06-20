package androidx.media3.common;

import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.Size;
import com.google.common.base.Supplier;

/* renamed from: androidx.media3.common.l0  reason: case insensitive filesystem */
public final /* synthetic */ class C0158l0 implements Supplier {
    public final /* synthetic */ Size X;
    public final /* synthetic */ SimpleBasePlayer.State s;

    public /* synthetic */ C0158l0(SimpleBasePlayer.State state, Size size) {
        this.s = state;
        this.X = size;
    }

    public final Object get() {
        return this.s.a().t0(this.X).O();
    }
}
