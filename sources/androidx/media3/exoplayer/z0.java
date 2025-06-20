package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class z0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f12869a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f12870b;

    public /* synthetic */ z0(int i2, boolean z) {
        this.f12869a = i2;
        this.f12870b = z;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).W(this.f12869a, this.f12870b);
    }
}
