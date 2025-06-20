package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class X implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f10483a;

    public /* synthetic */ X(boolean z) {
        this.f10483a = z;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).e(this.f10483a);
    }
}
