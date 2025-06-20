package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.common.d0  reason: case insensitive filesystem */
public final /* synthetic */ class C0142d0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f9438a;

    public /* synthetic */ C0142d0(SimpleBasePlayer.State state) {
        this.f9438a = state;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).W(this.f9438a.t, this.f9438a.u);
    }
}
