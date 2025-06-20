package androidx.media3.exoplayer;

import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class Z implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediaItem f10487a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f10488b;

    public /* synthetic */ Z(MediaItem mediaItem, int i2) {
        this.f10487a = mediaItem;
        this.f10488b = i2;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).h0(this.f10487a, this.f10488b);
    }
}
