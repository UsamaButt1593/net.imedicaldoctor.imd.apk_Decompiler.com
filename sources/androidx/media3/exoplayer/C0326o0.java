package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.exoplayer.o0  reason: case insensitive filesystem */
public final /* synthetic */ class C0326o0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f11738a;

    public /* synthetic */ C0326o0(boolean z) {
        this.f11738a = z;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).U(this.f11738a);
    }
}
