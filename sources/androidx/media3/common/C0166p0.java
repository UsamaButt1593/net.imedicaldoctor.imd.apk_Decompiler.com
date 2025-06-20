package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.common.p0  reason: case insensitive filesystem */
public final /* synthetic */ class C0166p0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f9451a;

    public /* synthetic */ C0166p0(SimpleBasePlayer.State state) {
        this.f9451a = state;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).X(this.f9451a.f9308b, this.f9451a.f9310d);
    }
}
