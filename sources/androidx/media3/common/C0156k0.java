package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.common.k0  reason: case insensitive filesystem */
public final /* synthetic */ class C0156k0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f9447a;

    public /* synthetic */ C0156k0(SimpleBasePlayer.State state) {
        this.f9447a = state;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).d0(this.f9447a.f9320n);
    }
}
