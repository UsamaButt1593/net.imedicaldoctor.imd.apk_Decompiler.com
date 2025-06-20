package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.common.w0  reason: case insensitive filesystem */
public final /* synthetic */ class C0185w0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer.State f9660a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f9661b;

    public /* synthetic */ C0185w0(SimpleBasePlayer.State state, int i2) {
        this.f9660a = state;
        this.f9661b = i2;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).S(this.f9660a.z, this.f9661b);
    }
}
