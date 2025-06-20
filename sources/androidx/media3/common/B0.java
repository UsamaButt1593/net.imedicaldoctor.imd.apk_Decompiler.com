package androidx.media3.common;

import androidx.media3.common.Player;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class B0 implements ListenerSet.IterationFinishedEvent {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleBasePlayer f9076a;

    public /* synthetic */ B0(SimpleBasePlayer simpleBasePlayer) {
        this.f9076a = simpleBasePlayer;
    }

    public final void a(Object obj, FlagSet flagSet) {
        this.f9076a.c5((Player.Listener) obj, flagSet);
    }
}
