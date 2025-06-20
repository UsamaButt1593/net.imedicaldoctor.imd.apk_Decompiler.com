package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.exoplayer.s0  reason: case insensitive filesystem */
public final /* synthetic */ class C0334s0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CueGroup f11871a;

    public /* synthetic */ C0334s0(CueGroup cueGroup) {
        this.f11871a = cueGroup;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).p(this.f11871a);
    }
}
