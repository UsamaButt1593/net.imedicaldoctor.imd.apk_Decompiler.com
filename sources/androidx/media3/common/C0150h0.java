package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.common.h0  reason: case insensitive filesystem */
public final /* synthetic */ class C0150h0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f9444a;

    public /* synthetic */ C0150h0(SimpleBasePlayer.State state) {
        this.f9444a = state;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).t0(this.f9444a.f9307a);
    }
}
