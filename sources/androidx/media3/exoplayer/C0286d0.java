package androidx.media3.exoplayer;

import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

/* renamed from: androidx.media3.exoplayer.d0  reason: case insensitive filesystem */
public final /* synthetic */ class C0286d0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediaMetadata f10953a;

    public /* synthetic */ C0286d0(MediaMetadata mediaMetadata) {
        this.f10953a = mediaMetadata;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).Z(this.f10953a);
    }
}
