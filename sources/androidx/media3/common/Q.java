package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class Q implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f9266a;

    public /* synthetic */ Q(SimpleBasePlayer.State state) {
        this.f9266a = state;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).Y(this.f9266a.f9316j);
    }
}
