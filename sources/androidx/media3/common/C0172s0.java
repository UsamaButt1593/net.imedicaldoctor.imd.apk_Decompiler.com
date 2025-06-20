package androidx.media3.common;

import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.Size;
import com.google.common.base.Supplier;

/* renamed from: androidx.media3.common.s0  reason: case insensitive filesystem */
public final /* synthetic */ class C0172s0 implements Supplier {
    public final /* synthetic */ SimpleBasePlayer.State s;

    public /* synthetic */ C0172s0(SimpleBasePlayer.State state) {
        this.s = state;
    }

    public final Object get() {
        return this.s.a().t0(Size.f9620c).O();
    }
}
