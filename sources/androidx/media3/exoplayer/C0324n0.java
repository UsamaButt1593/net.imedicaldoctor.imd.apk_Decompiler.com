package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.exoplayer.n0  reason: case insensitive filesystem */
public final /* synthetic */ class C0324n0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImpl f11737a;

    public /* synthetic */ C0324n0(ExoPlayerImpl exoPlayerImpl) {
        this.f11737a = exoPlayerImpl;
    }

    public final void f(Object obj) {
        this.f11737a.u4((Player.Listener) obj);
    }
}
