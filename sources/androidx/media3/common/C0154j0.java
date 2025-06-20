package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Util;

/* renamed from: androidx.media3.common.j0  reason: case insensitive filesystem */
public final /* synthetic */ class C0154j0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f9446a;

    public /* synthetic */ C0154j0(SimpleBasePlayer.State state) {
        this.f9446a = state;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).p0((PlaybackException) Util.o(this.f9446a.f9312f));
    }
}
