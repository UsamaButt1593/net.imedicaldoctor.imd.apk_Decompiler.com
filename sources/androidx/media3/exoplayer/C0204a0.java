package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.exoplayer.a0  reason: case insensitive filesystem */
public final /* synthetic */ class C0204a0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f10489a;

    public /* synthetic */ C0204a0(PlaybackInfo playbackInfo) {
        this.f10489a = playbackInfo;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).j0(this.f10489a.f10309f);
    }
}
