package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.exoplayer.c0  reason: case insensitive filesystem */
public final /* synthetic */ class C0284c0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f10952a;

    public /* synthetic */ C0284c0(PlaybackInfo playbackInfo) {
        this.f10952a = playbackInfo;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).f0(this.f10952a.f10312i.f12419d);
    }
}
