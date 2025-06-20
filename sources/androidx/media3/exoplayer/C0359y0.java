package androidx.media3.exoplayer;

import androidx.media3.common.DeviceInfo;
import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.exoplayer.y0  reason: case insensitive filesystem */
public final /* synthetic */ class C0359y0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceInfo f12868a;

    public /* synthetic */ C0359y0(DeviceInfo deviceInfo) {
        this.f12868a = deviceInfo;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).g0(this.f12868a);
    }
}
