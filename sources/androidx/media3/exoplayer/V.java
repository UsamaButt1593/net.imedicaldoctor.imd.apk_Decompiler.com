package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class V implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f10469a;

    public /* synthetic */ V(PlaybackInfo playbackInfo) {
        this.f10469a = playbackInfo;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).y0(this.f10469a.n());
    }
}
