package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.exoplayer.k0  reason: case insensitive filesystem */
public final /* synthetic */ class C0316k0 implements ListenerSet.Event {
    public final void f(Object obj) {
        ((Player.Listener) obj).p0(ExoPlaybackException.o(new ExoTimeoutException(1), 1003));
    }
}
