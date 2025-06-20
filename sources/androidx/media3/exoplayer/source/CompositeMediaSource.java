package androidx.media3.exoplayer.source;

import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnknownNull;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.drm.C0296j;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import java.io.IOException;
import java.util.HashMap;

@UnstableApi
public abstract class CompositeMediaSource<T> extends BaseMediaSource {
    private final HashMap<T, MediaSourceAndListener<T>> a3 = new HashMap<>();
    @Nullable
    private Handler b3;
    @Nullable
    private TransferListener c3;

    private final class ForwardingEventListener implements MediaSourceEventListener, DrmSessionEventListener {
        private MediaSourceEventListener.EventDispatcher X;
        private DrmSessionEventListener.EventDispatcher Y;
        @UnknownNull
        private final T s;

        public ForwardingEventListener(@UnknownNull T t) {
            this.X = CompositeMediaSource.this.f0((MediaSource.MediaPeriodId) null);
            this.Y = CompositeMediaSource.this.b0((MediaSource.MediaPeriodId) null);
            this.s = t;
        }

        private boolean c(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            MediaSource.MediaPeriodId mediaPeriodId2;
            if (mediaPeriodId != null) {
                mediaPeriodId2 = CompositeMediaSource.this.C0(this.s, mediaPeriodId);
                if (mediaPeriodId2 == null) {
                    return false;
                }
            } else {
                mediaPeriodId2 = null;
            }
            int E0 = CompositeMediaSource.this.E0(this.s, i2);
            MediaSourceEventListener.EventDispatcher eventDispatcher = this.X;
            if (eventDispatcher.f12168a != E0 || !Util.g(eventDispatcher.f12169b, mediaPeriodId2)) {
                this.X = CompositeMediaSource.this.d0(E0, mediaPeriodId2);
            }
            DrmSessionEventListener.EventDispatcher eventDispatcher2 = this.Y;
            if (eventDispatcher2.f11294a == E0 && Util.g(eventDispatcher2.f11295b, mediaPeriodId2)) {
                return true;
            }
            this.Y = CompositeMediaSource.this.a0(E0, mediaPeriodId2);
            return true;
        }

        private MediaLoadData e(MediaLoadData mediaLoadData, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            MediaLoadData mediaLoadData2 = mediaLoadData;
            MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
            long D0 = CompositeMediaSource.this.D0(this.s, mediaLoadData2.f12154f, mediaPeriodId2);
            long D02 = CompositeMediaSource.this.D0(this.s, mediaLoadData2.f12155g, mediaPeriodId2);
            return (D0 == mediaLoadData2.f12154f && D02 == mediaLoadData2.f12155g) ? mediaLoadData2 : new MediaLoadData(mediaLoadData2.f12149a, mediaLoadData2.f12150b, mediaLoadData2.f12151c, mediaLoadData2.f12152d, mediaLoadData2.f12153e, D0, D02);
        }

        public void A(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            if (c(i2, mediaPeriodId)) {
                this.X.D(e(mediaLoadData, mediaPeriodId));
            }
        }

        public void O(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (c(i2, mediaPeriodId)) {
                this.X.u(loadEventInfo, e(mediaLoadData, mediaPeriodId));
            }
        }

        public void Q(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            if (c(i2, mediaPeriodId)) {
                this.X.i(e(mediaLoadData, mediaPeriodId));
            }
        }

        public void R(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            if (c(i2, mediaPeriodId)) {
                this.Y.j();
            }
        }

        public void V(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (c(i2, mediaPeriodId)) {
                this.X.A(loadEventInfo, e(mediaLoadData, mediaPeriodId));
            }
        }

        public void c0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            if (c(i2, mediaPeriodId)) {
                this.Y.h();
            }
        }

        public void m0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            if (c(i2, mediaPeriodId)) {
                this.Y.m();
            }
        }

        public void o0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, int i3) {
            if (c(i2, mediaPeriodId)) {
                this.Y.k(i3);
            }
        }

        public void q0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
            if (c(i2, mediaPeriodId)) {
                this.X.x(loadEventInfo, e(mediaLoadData, mediaPeriodId), iOException, z);
            }
        }

        public /* synthetic */ void r0(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            C0296j.d(this, i2, mediaPeriodId);
        }

        public void v0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            if (c(i2, mediaPeriodId)) {
                this.Y.i();
            }
        }

        public void w0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
            if (c(i2, mediaPeriodId)) {
                this.Y.l(exc);
            }
        }

        public void x0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (c(i2, mediaPeriodId)) {
                this.X.r(loadEventInfo, e(mediaLoadData, mediaPeriodId));
            }
        }
    }

    private static final class MediaSourceAndListener<T> {

        /* renamed from: a  reason: collision with root package name */
        public final MediaSource f12086a;

        /* renamed from: b  reason: collision with root package name */
        public final MediaSource.MediaSourceCaller f12087b;

        /* renamed from: c  reason: collision with root package name */
        public final CompositeMediaSource<T>.ForwardingEventListener f12088c;

        public MediaSourceAndListener(MediaSource mediaSource, MediaSource.MediaSourceCaller mediaSourceCaller, CompositeMediaSource<T>.ForwardingEventListener forwardingEventListener) {
            this.f12086a = mediaSource;
            this.f12087b = mediaSourceCaller;
            this.f12088c = forwardingEventListener;
        }
    }

    protected CompositeMediaSource() {
    }

    /* access modifiers changed from: protected */
    public final void A0(@UnknownNull T t) {
        MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) Assertions.g(this.a3.get(t));
        mediaSourceAndListener.f12086a.D(mediaSourceAndListener.f12087b);
    }

    /* access modifiers changed from: protected */
    public final void B0(@UnknownNull T t) {
        MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) Assertions.g(this.a3.get(t));
        mediaSourceAndListener.f12086a.e(mediaSourceAndListener.f12087b);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public MediaSource.MediaPeriodId C0(@UnknownNull T t, MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId;
    }

    /* access modifiers changed from: protected */
    public long D0(@UnknownNull T t, long j2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        return j2;
    }

    /* access modifiers changed from: protected */
    public int E0(@UnknownNull T t, int i2) {
        return i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: G0 */
    public abstract void F0(@UnknownNull T t, MediaSource mediaSource, Timeline timeline);

    /* access modifiers changed from: protected */
    public final void H0(@UnknownNull T t, MediaSource mediaSource) {
        Assertions.a(!this.a3.containsKey(t));
        C0335a aVar = new C0335a(this, t);
        ForwardingEventListener forwardingEventListener = new ForwardingEventListener(t);
        this.a3.put(t, new MediaSourceAndListener(mediaSource, aVar, forwardingEventListener));
        mediaSource.c((Handler) Assertions.g(this.b3), forwardingEventListener);
        mediaSource.P((Handler) Assertions.g(this.b3), forwardingEventListener);
        mediaSource.Y(aVar, this.c3, k0());
        if (!l0()) {
            mediaSource.D(aVar);
        }
    }

    @CallSuper
    public void I() throws IOException {
        for (MediaSourceAndListener<T> mediaSourceAndListener : this.a3.values()) {
            mediaSourceAndListener.f12086a.I();
        }
    }

    /* access modifiers changed from: protected */
    public final void I0(@UnknownNull T t) {
        MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) Assertions.g(this.a3.remove(t));
        mediaSourceAndListener.f12086a.x(mediaSourceAndListener.f12087b);
        mediaSourceAndListener.f12086a.q(mediaSourceAndListener.f12088c);
        mediaSourceAndListener.f12086a.U(mediaSourceAndListener.f12088c);
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void h0() {
        for (MediaSourceAndListener next : this.a3.values()) {
            next.f12086a.D(next.f12087b);
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void j0() {
        for (MediaSourceAndListener next : this.a3.values()) {
            next.f12086a.e(next.f12087b);
        }
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void s0(@Nullable TransferListener transferListener) {
        this.c3 = transferListener;
        this.b3 = Util.H();
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void u0() {
        for (MediaSourceAndListener next : this.a3.values()) {
            next.f12086a.x(next.f12087b);
            next.f12086a.q(next.f12088c);
            next.f12086a.U(next.f12088c);
        }
        this.a3.clear();
    }
}
