package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.exoplayer.m0  reason: case insensitive filesystem */
public final /* synthetic */ class C0320m0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f11629a;

    public /* synthetic */ C0320m0(int i2) {
        this.f11629a = i2;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).x(this.f11629a);
    }
}
