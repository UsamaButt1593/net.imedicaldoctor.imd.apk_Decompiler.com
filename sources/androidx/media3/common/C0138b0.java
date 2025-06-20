package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.common.b0  reason: case insensitive filesystem */
public final /* synthetic */ class C0138b0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f9432a;

    public /* synthetic */ C0138b0(SimpleBasePlayer.State state) {
        this.f9432a = state;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).s0(this.f9432a.v.b(), this.f9432a.v.a());
    }
}
