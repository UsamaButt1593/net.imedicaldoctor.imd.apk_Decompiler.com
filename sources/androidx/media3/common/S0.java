package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class S0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f9269a;

    public /* synthetic */ S0(SimpleBasePlayer.State state) {
        this.f9269a = state;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).l0(this.f9269a.f9308b, this.f9269a.f9309c);
    }
}
