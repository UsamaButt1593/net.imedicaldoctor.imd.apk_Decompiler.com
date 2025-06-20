package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class Z0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f9370a;

    public /* synthetic */ Z0(SimpleBasePlayer.State state) {
        this.f9370a = state;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).y0(SimpleBasePlayer.T4(this.f9370a));
    }
}
