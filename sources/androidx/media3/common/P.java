package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class P implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f9245a;

    public /* synthetic */ P(SimpleBasePlayer.State state) {
        this.f9245a = state;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).U(this.f9245a.f9314h);
    }
}
