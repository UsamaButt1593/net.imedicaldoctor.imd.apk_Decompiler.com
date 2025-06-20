package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class S implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f9268a;

    public /* synthetic */ S(SimpleBasePlayer.State state) {
        this.f9268a = state;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).b0(this.f9268a.f9317k);
    }
}
