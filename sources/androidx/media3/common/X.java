package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class X implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f9367a;

    public /* synthetic */ X(SimpleBasePlayer.State state) {
        this.f9367a = state;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).g0(this.f9367a.s);
    }
}
