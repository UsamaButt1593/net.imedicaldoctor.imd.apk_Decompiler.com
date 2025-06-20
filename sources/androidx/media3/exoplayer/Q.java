package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class Q implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImpl f10332a;

    public /* synthetic */ Q(ExoPlayerImpl exoPlayerImpl) {
        this.f10332a = exoPlayerImpl;
    }

    public final void f(Object obj) {
        this.f10332a.A4((Player.Listener) obj);
    }
}
