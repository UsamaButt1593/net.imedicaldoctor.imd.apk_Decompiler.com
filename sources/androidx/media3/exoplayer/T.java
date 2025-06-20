package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class T implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f10466a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f10467b;

    public /* synthetic */ T(PlaybackInfo playbackInfo, int i2) {
        this.f10466a = playbackInfo;
        this.f10467b = i2;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).l0(this.f10466a.f10315l, this.f10467b);
    }
}
