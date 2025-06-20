package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.exoplayer.x0  reason: case insensitive filesystem */
public final /* synthetic */ class C0357x0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VideoSize f12867a;

    public /* synthetic */ C0357x0(VideoSize videoSize) {
        this.f12867a = videoSize;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).c(this.f12867a);
    }
}
