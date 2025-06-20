package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.ExoPlayerImpl;

/* renamed from: androidx.media3.exoplayer.t0  reason: case insensitive filesystem */
public final /* synthetic */ class C0345t0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImpl.ComponentListener f12342a;

    public /* synthetic */ C0345t0(ExoPlayerImpl.ComponentListener componentListener) {
        this.f12342a = componentListener;
    }

    public final void f(Object obj) {
        this.f12342a.U((Player.Listener) obj);
    }
}
