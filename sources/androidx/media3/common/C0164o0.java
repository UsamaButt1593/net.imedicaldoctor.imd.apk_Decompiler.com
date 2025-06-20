package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.common.o0  reason: case insensitive filesystem */
public final /* synthetic */ class C0164o0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f9450a;

    public /* synthetic */ C0164o0(SimpleBasePlayer.State state) {
        this.f9450a = state;
    }

    public final void f(Object obj) {
        SimpleBasePlayer.I5(this.f9450a, (Player.Listener) obj);
    }
}
