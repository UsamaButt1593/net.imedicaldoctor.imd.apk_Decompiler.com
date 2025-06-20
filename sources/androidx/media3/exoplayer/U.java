package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class U implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f10468a;

    public /* synthetic */ U(PlaybackInfo playbackInfo) {
        this.f10468a = playbackInfo;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).D(this.f10468a.f10316m);
    }
}
