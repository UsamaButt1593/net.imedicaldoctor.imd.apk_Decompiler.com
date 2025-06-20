package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.common.g0  reason: case insensitive filesystem */
public final /* synthetic */ class C0148g0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediaItem f9442a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f9443b;

    public /* synthetic */ C0148g0(MediaItem mediaItem, int i2) {
        this.f9442a = mediaItem;
        this.f9443b = i2;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).h0(this.f9442a, this.f9443b);
    }
}
