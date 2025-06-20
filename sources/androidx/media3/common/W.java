package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class W implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f9366a;

    public /* synthetic */ W(SimpleBasePlayer.State state) {
        this.f9366a = state;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).c(this.f9366a.q);
    }
}
