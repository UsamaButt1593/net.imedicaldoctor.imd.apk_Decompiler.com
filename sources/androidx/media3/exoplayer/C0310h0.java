package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.exoplayer.h0  reason: case insensitive filesystem */
public final /* synthetic */ class C0310h0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ float f11361a;

    public /* synthetic */ C0310h0(float f2) {
        this.f11361a = f2;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).K(this.f11361a);
    }
}
