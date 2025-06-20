package androidx.media3.exoplayer.trackselection;

import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.RandomTrackSelection;
import androidx.media3.exoplayer.trackselection.TrackSelectionUtil;

public final /* synthetic */ class C implements TrackSelectionUtil.AdaptiveTrackSelectionFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RandomTrackSelection.Factory f12370a;

    public /* synthetic */ C(RandomTrackSelection.Factory factory) {
        this.f12370a = factory;
    }

    public final ExoTrackSelection a(ExoTrackSelection.Definition definition) {
        return this.f12370a.c(definition);
    }
}
