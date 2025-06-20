package androidx.media3.exoplayer.source;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

@UnstableApi
public abstract class BaseMediaSource implements MediaSource {
    private final HashSet<MediaSource.MediaSourceCaller> X = new HashSet<>(1);
    @Nullable
    private Looper X2;
    private final MediaSourceEventListener.EventDispatcher Y = new MediaSourceEventListener.EventDispatcher();
    @Nullable
    private Timeline Y2;
    private final DrmSessionEventListener.EventDispatcher Z = new DrmSessionEventListener.EventDispatcher();
    @Nullable
    private PlayerId Z2;
    private final ArrayList<MediaSource.MediaSourceCaller> s = new ArrayList<>(1);

    public final void D(MediaSource.MediaSourceCaller mediaSourceCaller) {
        boolean z = !this.X.isEmpty();
        this.X.remove(mediaSourceCaller);
        if (z && this.X.isEmpty()) {
            h0();
        }
    }

    public /* synthetic */ boolean K() {
        return o.c(this);
    }

    public /* synthetic */ Timeline L() {
        return o.b(this);
    }

    public final void M(MediaSource.MediaSourceCaller mediaSourceCaller, @Nullable TransferListener transferListener) {
        Y(mediaSourceCaller, transferListener, PlayerId.f10613b);
    }

    public final void P(Handler handler, DrmSessionEventListener drmSessionEventListener) {
        Assertions.g(handler);
        Assertions.g(drmSessionEventListener);
        this.Z.g(handler, drmSessionEventListener);
    }

    public /* synthetic */ boolean S(MediaItem mediaItem) {
        return o.a(this, mediaItem);
    }

    public final void U(DrmSessionEventListener drmSessionEventListener) {
        this.Z.t(drmSessionEventListener);
    }

    public final void Y(MediaSource.MediaSourceCaller mediaSourceCaller, @Nullable TransferListener transferListener, PlayerId playerId) {
        Looper myLooper = Looper.myLooper();
        Looper looper = this.X2;
        Assertions.a(looper == null || looper == myLooper);
        this.Z2 = playerId;
        Timeline timeline = this.Y2;
        this.s.add(mediaSourceCaller);
        if (this.X2 == null) {
            this.X2 = myLooper;
            this.X.add(mediaSourceCaller);
            s0(transferListener);
        } else if (timeline != null) {
            e(mediaSourceCaller);
            mediaSourceCaller.W(this, timeline);
        }
    }

    /* access modifiers changed from: protected */
    public final DrmSessionEventListener.EventDispatcher a0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        return this.Z.u(i2, mediaPeriodId);
    }

    /* access modifiers changed from: protected */
    public final DrmSessionEventListener.EventDispatcher b0(@Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        return this.Z.u(0, mediaPeriodId);
    }

    public final void c(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
        Assertions.g(handler);
        Assertions.g(mediaSourceEventListener);
        this.Y.g(handler, mediaSourceEventListener);
    }

    /* access modifiers changed from: protected */
    public final MediaSourceEventListener.EventDispatcher d0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        return this.Y.E(i2, mediaPeriodId);
    }

    public final void e(MediaSource.MediaSourceCaller mediaSourceCaller) {
        Assertions.g(this.X2);
        boolean isEmpty = this.X.isEmpty();
        this.X.add(mediaSourceCaller);
        if (isEmpty) {
            j0();
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public final MediaSourceEventListener.EventDispatcher e0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, long j2) {
        return this.Y.E(i2, mediaPeriodId);
    }

    /* access modifiers changed from: protected */
    public final MediaSourceEventListener.EventDispatcher f0(@Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        return this.Y.E(0, mediaPeriodId);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public final MediaSourceEventListener.EventDispatcher g0(MediaSource.MediaPeriodId mediaPeriodId, long j2) {
        Assertions.g(mediaPeriodId);
        return this.Y.E(0, mediaPeriodId);
    }

    /* access modifiers changed from: protected */
    public void h0() {
    }

    /* access modifiers changed from: protected */
    public void j0() {
    }

    public /* synthetic */ void k(MediaItem mediaItem) {
        o.e(this, mediaItem);
    }

    /* access modifiers changed from: protected */
    public final PlayerId k0() {
        return (PlayerId) Assertions.k(this.Z2);
    }

    /* access modifiers changed from: protected */
    public final boolean l0() {
        return !this.X.isEmpty();
    }

    /* access modifiers changed from: protected */
    public final boolean p0() {
        return !this.s.isEmpty();
    }

    public final void q(MediaSourceEventListener mediaSourceEventListener) {
        this.Y.B(mediaSourceEventListener);
    }

    /* access modifiers changed from: protected */
    public abstract void s0(@Nullable TransferListener transferListener);

    /* access modifiers changed from: protected */
    public final void t0(Timeline timeline) {
        this.Y2 = timeline;
        Iterator<MediaSource.MediaSourceCaller> it2 = this.s.iterator();
        while (it2.hasNext()) {
            it2.next().W(this, timeline);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void u0();

    public final void x(MediaSource.MediaSourceCaller mediaSourceCaller) {
        this.s.remove(mediaSourceCaller);
        if (this.s.isEmpty()) {
            this.X2 = null;
            this.Y2 = null;
            this.Z2 = null;
            this.X.clear();
            u0();
            return;
        }
        D(mediaSourceCaller);
    }

    /* access modifiers changed from: protected */
    public final void y0(PlayerId playerId) {
        this.Z2 = playerId;
    }
}
