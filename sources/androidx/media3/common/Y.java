package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class Y implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f9368a;

    public /* synthetic */ Y(SimpleBasePlayer.State state) {
        this.f9368a = state;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).a0(this.f9368a.A);
    }
}
