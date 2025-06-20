package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.exoplayer.j0  reason: case insensitive filesystem */
public final /* synthetic */ class C0314j0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f11628a;

    public /* synthetic */ C0314j0(int i2) {
        this.f11628a = i2;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).L(this.f11628a);
    }
}
