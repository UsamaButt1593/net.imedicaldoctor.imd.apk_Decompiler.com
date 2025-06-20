package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class Y0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f9369a;

    public /* synthetic */ Y0(SimpleBasePlayer.State state) {
        this.f9369a = state;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).D(this.f9369a.f9311e);
    }
}
