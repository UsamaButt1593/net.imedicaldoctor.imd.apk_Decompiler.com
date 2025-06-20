package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.exoplayer.i0  reason: case insensitive filesystem */
public final /* synthetic */ class C0312i0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f11617a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f11618b;

    public /* synthetic */ C0312i0(int i2, int i3) {
        this.f11617a = i2;
        this.f11618b = i3;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).s0(this.f11617a, this.f11618b);
    }
}
