package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.common.f0  reason: case insensitive filesystem */
public final /* synthetic */ class C0146f0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f9441a;

    public /* synthetic */ C0146f0(SimpleBasePlayer.State state) {
        this.f9441a = state;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).q(this.f9441a.x);
    }
}
