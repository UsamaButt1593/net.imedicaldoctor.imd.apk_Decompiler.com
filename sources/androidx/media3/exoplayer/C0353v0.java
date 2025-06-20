package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.exoplayer.v0  reason: case insensitive filesystem */
public final /* synthetic */ class C0353v0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f12715a;

    public /* synthetic */ C0353v0(boolean z) {
        this.f12715a = z;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).e(this.f12715a);
    }
}
