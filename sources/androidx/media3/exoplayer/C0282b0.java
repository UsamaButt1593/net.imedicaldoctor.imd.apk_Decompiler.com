package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.exoplayer.b0  reason: case insensitive filesystem */
public final /* synthetic */ class C0282b0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f10951a;

    public /* synthetic */ C0282b0(PlaybackInfo playbackInfo) {
        this.f10951a = playbackInfo;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).p0(this.f10951a.f10309f);
    }
}
