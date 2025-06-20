package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.common.m0  reason: case insensitive filesystem */
public final /* synthetic */ class C0160m0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Tracks f9448a;

    public /* synthetic */ C0160m0(Tracks tracks) {
        this.f9448a = tracks;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).f0(this.f9448a);
    }
}
