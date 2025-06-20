package androidx.media3.exoplayer;

import androidx.media3.common.Metadata;
import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.exoplayer.u0  reason: case insensitive filesystem */
public final /* synthetic */ class C0351u0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Metadata f12430a;

    public /* synthetic */ C0351u0(Metadata metadata) {
        this.f12430a = metadata;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).q(this.f12430a);
    }
}
