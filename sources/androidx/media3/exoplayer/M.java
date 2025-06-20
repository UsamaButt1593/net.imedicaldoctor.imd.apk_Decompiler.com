package androidx.media3.exoplayer;

import androidx.media3.common.FlagSet;
import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class M implements ListenerSet.IterationFinishedEvent {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImpl f10234a;

    public /* synthetic */ M(ExoPlayerImpl exoPlayerImpl) {
        this.f10234a = exoPlayerImpl;
    }

    public final void a(Object obj, FlagSet flagSet) {
        this.f10234a.o4((Player.Listener) obj, flagSet);
    }
}
