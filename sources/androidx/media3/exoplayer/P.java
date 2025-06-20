package androidx.media3.exoplayer;

import androidx.media3.common.Player;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.util.ListenerSet;

public final /* synthetic */ class P implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TrackSelectionParameters f10303a;

    public /* synthetic */ P(TrackSelectionParameters trackSelectionParameters) {
        this.f10303a = trackSelectionParameters;
    }

    public final void f(Object obj) {
        ((Player.Listener) obj).d0(this.f10303a);
    }
}
