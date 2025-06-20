package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class H0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f9155a;

    public /* synthetic */ H0(SimpleBasePlayer.State state) {
        this.f9155a = state;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).M(this.f9155a.f9310d);
    }
}
