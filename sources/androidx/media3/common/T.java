package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class T implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f9339a;

    public /* synthetic */ T(SimpleBasePlayer.State state) {
        this.f9339a = state;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).k0(this.f9339a.f9318l);
    }
}
