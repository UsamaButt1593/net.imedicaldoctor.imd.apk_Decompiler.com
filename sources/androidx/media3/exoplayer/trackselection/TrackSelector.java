package androidx.media3.exoplayer.trackselection;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.upstream.BandwidthMeter;

@UnstableApi
public abstract class TrackSelector {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private InvalidationListener f12414a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private BandwidthMeter f12415b;

    public interface InvalidationListener {
        void a(Renderer renderer);

        void c();
    }

    /* access modifiers changed from: protected */
    public final BandwidthMeter b() {
        return (BandwidthMeter) Assertions.k(this.f12415b);
    }

    public TrackSelectionParameters c() {
        return TrackSelectionParameters.v3;
    }

    @Nullable
    public RendererCapabilities.Listener d() {
        return null;
    }

    @CallSuper
    public void e(InvalidationListener invalidationListener, BandwidthMeter bandwidthMeter) {
        this.f12414a = invalidationListener;
        this.f12415b = bandwidthMeter;
    }

    /* access modifiers changed from: protected */
    public final void f() {
        InvalidationListener invalidationListener = this.f12414a;
        if (invalidationListener != null) {
            invalidationListener.c();
        }
    }

    /* access modifiers changed from: protected */
    public final void g(Renderer renderer) {
        InvalidationListener invalidationListener = this.f12414a;
        if (invalidationListener != null) {
            invalidationListener.a(renderer);
        }
    }

    public boolean h() {
        return false;
    }

    public abstract void i(@Nullable Object obj);

    @CallSuper
    public void j() {
        this.f12414a = null;
        this.f12415b = null;
    }

    public abstract TrackSelectorResult k(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) throws ExoPlaybackException;

    public void l(AudioAttributes audioAttributes) {
    }

    public void m(TrackSelectionParameters trackSelectionParameters) {
    }
}
