package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.common.c0  reason: case insensitive filesystem */
public final /* synthetic */ class C0140c0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f9434a;

    public /* synthetic */ C0140c0(SimpleBasePlayer.State state) {
        this.f9434a = state;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).K(this.f9434a.p);
    }
}
