package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.common.e0  reason: case insensitive filesystem */
public final /* synthetic */ class C0144e0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f9440a;

    public /* synthetic */ C0144e0(SimpleBasePlayer.State state) {
        this.f9440a = state;
    }

    public final void f(Object obj) {
        SimpleBasePlayer.b6(this.f9440a, (Player.Listener) obj);
    }
}
