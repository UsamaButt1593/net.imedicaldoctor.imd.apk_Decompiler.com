package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.common.i0  reason: case insensitive filesystem */
public final /* synthetic */ class C0152i0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f9445a;

    public /* synthetic */ C0152i0(SimpleBasePlayer.State state) {
        this.f9445a = state;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).j0(this.f9445a.f9312f);
    }
}
