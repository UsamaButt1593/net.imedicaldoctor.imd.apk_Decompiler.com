package androidx.media3.exoplayer.source;

import androidx.annotation.Nullable;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;

@UnstableApi
public abstract class WrappingMediaSource extends CompositeMediaSource<Void> {
    private static final Void e3 = null;
    protected final MediaSource d3;

    protected WrappingMediaSource(MediaSource mediaSource) {
        this.d3 = mediaSource;
    }

    public MediaPeriod E(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        return this.d3.E(mediaPeriodId, allocator, j2);
    }

    public MediaItem H() {
        return this.d3.H();
    }

    /* access modifiers changed from: protected */
    public final void J0() {
        A0(e3);
    }

    public boolean K() {
        return this.d3.K();
    }

    /* access modifiers changed from: protected */
    public final void K0() {
        B0(e3);
    }

    @Nullable
    public Timeline L() {
        return this.d3.L();
    }

    /* access modifiers changed from: protected */
    @Nullable
    public MediaSource.MediaPeriodId L0(MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId;
    }

    /* access modifiers changed from: protected */
    @Nullable
    /* renamed from: M0 */
    public final MediaSource.MediaPeriodId C0(Void voidR, MediaSource.MediaPeriodId mediaPeriodId) {
        return L0(mediaPeriodId);
    }

    /* access modifiers changed from: protected */
    public long N0(long j2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        return j2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: O0 */
    public final long D0(Void voidR, long j2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        return N0(j2, mediaPeriodId);
    }

    /* access modifiers changed from: protected */
    public int P0(int i2) {
        return i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: Q0 */
    public final int E0(Void voidR, int i2) {
        return P0(i2);
    }

    /* access modifiers changed from: protected */
    public void R0(Timeline timeline) {
        t0(timeline);
    }

    public boolean S(MediaItem mediaItem) {
        return this.d3.S(mediaItem);
    }

    /* access modifiers changed from: protected */
    /* renamed from: S0 */
    public final void G0(Void voidR, MediaSource mediaSource, Timeline timeline) {
        R0(timeline);
    }

    /* access modifiers changed from: protected */
    public final void T0() {
        H0(e3, this.d3);
    }

    /* access modifiers changed from: protected */
    public void U0() {
        T0();
    }

    /* access modifiers changed from: protected */
    public final void V0() {
        I0(e3);
    }

    public void X(MediaPeriod mediaPeriod) {
        this.d3.X(mediaPeriod);
    }

    public void k(MediaItem mediaItem) {
        this.d3.k(mediaItem);
    }

    /* access modifiers changed from: protected */
    public final void s0(@Nullable TransferListener transferListener) {
        super.s0(transferListener);
        U0();
    }
}
