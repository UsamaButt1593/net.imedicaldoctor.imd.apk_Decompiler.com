package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class b1 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f9433a;

    public /* synthetic */ b1(SimpleBasePlayer.State state) {
        this.f9433a = state;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).x(this.f9433a.f9313g);
    }
}
