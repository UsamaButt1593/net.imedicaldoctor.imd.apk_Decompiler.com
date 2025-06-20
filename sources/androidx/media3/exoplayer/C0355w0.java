package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;
import java.util.List;

/* renamed from: androidx.media3.exoplayer.w0  reason: case insensitive filesystem */
public final /* synthetic */ class C0355w0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f12866a;

    public /* synthetic */ C0355w0(List list) {
        this.f12866a = list;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).s(this.f12866a);
    }
}
