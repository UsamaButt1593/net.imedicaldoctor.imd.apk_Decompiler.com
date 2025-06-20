package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class W implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f10470a;

    public /* synthetic */ W(PlaybackInfo playbackInfo) {
        this.f10470a = playbackInfo;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).k(this.f10470a.f10317n);
    }
}
