package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.exoplayer.g0  reason: case insensitive filesystem */
public final /* synthetic */ class C0308g0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f11360a;

    public /* synthetic */ C0308g0(PlaybackInfo playbackInfo) {
        this.f11360a = playbackInfo;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).M(this.f11360a.f10308e);
    }
}
