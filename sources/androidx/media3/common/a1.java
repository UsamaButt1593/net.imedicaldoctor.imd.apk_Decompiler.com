package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class a1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f9371a;

    public /* synthetic */ a1(SimpleBasePlayer.State state) {
        this.f9371a = state;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).k(this.f9371a.f9319m);
    }
}
