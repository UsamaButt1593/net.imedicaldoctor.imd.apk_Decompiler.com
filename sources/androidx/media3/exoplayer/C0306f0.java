package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.exoplayer.f0  reason: case insensitive filesystem */
public final /* synthetic */ class C0306f0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f11359a;

    public /* synthetic */ C0306f0(PlaybackInfo playbackInfo) {
        this.f11359a = playbackInfo;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).X(this.f11359a.f10315l, this.f11359a.f10308e);
    }
}
