package androidx.media3.exoplayer;

import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class O implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AudioAttributes f10302a;

    public /* synthetic */ O(AudioAttributes audioAttributes) {
        this.f10302a = audioAttributes;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).N(this.f10302a);
    }
}
