package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.common.n0  reason: case insensitive filesystem */
public final /* synthetic */ class C0162n0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediaMetadata f9449a;

    public /* synthetic */ C0162n0(MediaMetadata mediaMetadata) {
        this.f9449a = mediaMetadata;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).Z(this.f9449a);
    }
}
