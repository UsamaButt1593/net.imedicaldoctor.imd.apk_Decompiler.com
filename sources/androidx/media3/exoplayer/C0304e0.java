package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.exoplayer.e0  reason: case insensitive filesystem */
public final /* synthetic */ class C0304e0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f11358a;

    public /* synthetic */ C0304e0(PlaybackInfo playbackInfo) {
        this.f11358a = playbackInfo;
    }

    public final void f(Object obj) {
        ExoPlayerImpl.I4(this.f11358a, (Player.Listener) obj);
    }
}
