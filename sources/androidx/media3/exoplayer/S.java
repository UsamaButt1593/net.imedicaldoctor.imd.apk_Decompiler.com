package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class S implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f10445a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f10446b;

    public /* synthetic */ S(PlaybackInfo playbackInfo, int i2) {
        this.f10445a = playbackInfo;
        this.f10446b = i2;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).S(this.f10445a.f10304a, this.f10446b);
    }
}
