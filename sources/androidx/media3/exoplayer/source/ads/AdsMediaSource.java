package androidx.media3.exoplayer.source.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.AdViewProvider;
import androidx.media3.common.C;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.source.CompositeMediaSource;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MaskingMediaPeriod;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ads.AdsLoader;
import androidx.media3.exoplayer.upstream.Allocator;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@UnstableApi
public final class AdsMediaSource extends CompositeMediaSource<MediaSource.MediaPeriodId> {
    private static final MediaSource.MediaPeriodId q3 = new MediaSource.MediaPeriodId(new Object());
    private final MediaSource d3;
    @Nullable
    final MediaItem.DrmConfiguration e3;
    private final MediaSource.Factory f3;
    /* access modifiers changed from: private */
    public final AdsLoader g3;
    private final AdViewProvider h3;
    private final DataSpec i3;
    private final Object j3;
    /* access modifiers changed from: private */
    public final Handler k3 = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final Timeline.Period l3 = new Timeline.Period();
    @Nullable
    private ComponentListener m3;
    @Nullable
    private Timeline n3;
    @Nullable
    private AdPlaybackState o3;
    private AdMediaSourceHolder[][] p3 = new AdMediaSourceHolder[0][];

    public static final class AdLoadException extends IOException {
        public static final int X = 0;
        public static final int X2 = 3;
        public static final int Y = 1;
        public static final int Z = 2;
        public final int s;

        @Documented
        @Target({ElementType.TYPE_USE})
        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
        }

        private AdLoadException(int i2, Exception exc) {
            super(exc);
            this.s = i2;
        }

        public static AdLoadException a(Exception exc) {
            return new AdLoadException(0, exc);
        }

        public static AdLoadException b(Exception exc, int i2) {
            return new AdLoadException(1, new IOException("Failed to load ad group " + i2, exc));
        }

        public static AdLoadException c(Exception exc) {
            return new AdLoadException(2, exc);
        }

        public static AdLoadException d(RuntimeException runtimeException) {
            return new AdLoadException(3, runtimeException);
        }

        public RuntimeException e() {
            Assertions.i(this.s == 3);
            return (RuntimeException) Assertions.g(getCause());
        }
    }

    private final class AdMediaSourceHolder {

        /* renamed from: a  reason: collision with root package name */
        private final MediaSource.MediaPeriodId f12248a;

        /* renamed from: b  reason: collision with root package name */
        private final List<MaskingMediaPeriod> f12249b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private MediaItem f12250c;

        /* renamed from: d  reason: collision with root package name */
        private MediaSource f12251d;

        /* renamed from: e  reason: collision with root package name */
        private Timeline f12252e;

        public AdMediaSourceHolder(MediaSource.MediaPeriodId mediaPeriodId) {
            this.f12248a = mediaPeriodId;
        }

        public MediaPeriod a(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
            MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(mediaPeriodId, allocator, j2);
            this.f12249b.add(maskingMediaPeriod);
            MediaSource mediaSource = this.f12251d;
            if (mediaSource != null) {
                maskingMediaPeriod.z(mediaSource);
                maskingMediaPeriod.A(new AdPrepareListener((MediaItem) Assertions.g(this.f12250c)));
            }
            Timeline timeline = this.f12252e;
            if (timeline != null) {
                maskingMediaPeriod.d(new MediaSource.MediaPeriodId(timeline.t(0), mediaPeriodId.f12166d));
            }
            return maskingMediaPeriod;
        }

        public long b() {
            Timeline timeline = this.f12252e;
            return timeline == null ? C.f9084b : timeline.k(0, AdsMediaSource.this.l3).o();
        }

        public void c(Timeline timeline) {
            boolean z = true;
            if (timeline.n() != 1) {
                z = false;
            }
            Assertions.a(z);
            if (this.f12252e == null) {
                Object t = timeline.t(0);
                for (int i2 = 0; i2 < this.f12249b.size(); i2++) {
                    MaskingMediaPeriod maskingMediaPeriod = this.f12249b.get(i2);
                    maskingMediaPeriod.d(new MediaSource.MediaPeriodId(t, maskingMediaPeriod.s.f12166d));
                }
            }
            this.f12252e = timeline;
        }

        public boolean d() {
            return this.f12251d != null;
        }

        public void e(MediaSource mediaSource, MediaItem mediaItem) {
            this.f12251d = mediaSource;
            this.f12250c = mediaItem;
            for (int i2 = 0; i2 < this.f12249b.size(); i2++) {
                MaskingMediaPeriod maskingMediaPeriod = this.f12249b.get(i2);
                maskingMediaPeriod.z(mediaSource);
                maskingMediaPeriod.A(new AdPrepareListener(mediaItem));
            }
            AdsMediaSource.this.H0(this.f12248a, mediaSource);
        }

        public boolean f() {
            return this.f12249b.isEmpty();
        }

        public void g() {
            if (d()) {
                AdsMediaSource.this.I0(this.f12248a);
            }
        }

        public void h(MaskingMediaPeriod maskingMediaPeriod) {
            this.f12249b.remove(maskingMediaPeriod);
            maskingMediaPeriod.y();
        }
    }

    private final class AdPrepareListener implements MaskingMediaPeriod.PrepareListener {

        /* renamed from: a  reason: collision with root package name */
        private final MediaItem f12254a;

        public AdPrepareListener(MediaItem mediaItem) {
            this.f12254a = mediaItem;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(MediaSource.MediaPeriodId mediaPeriodId) {
            AdsMediaSource.this.g3.e(AdsMediaSource.this, mediaPeriodId.f12164b, mediaPeriodId.f12165c);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(MediaSource.MediaPeriodId mediaPeriodId, IOException iOException) {
            AdsMediaSource.this.g3.d(AdsMediaSource.this, mediaPeriodId.f12164b, mediaPeriodId.f12165c, iOException);
        }

        public void a(MediaSource.MediaPeriodId mediaPeriodId, IOException iOException) {
            AdsMediaSource.this.f0(mediaPeriodId).w(new LoadEventInfo(LoadEventInfo.a(), new DataSpec(((MediaItem.LocalConfiguration) Assertions.g(this.f12254a.X)).s), SystemClock.elapsedRealtime()), 6, AdLoadException.a(iOException), true);
            AdsMediaSource.this.k3.post(new d(this, mediaPeriodId, iOException));
        }

        public void b(MediaSource.MediaPeriodId mediaPeriodId) {
            AdsMediaSource.this.k3.post(new e(this, mediaPeriodId));
        }
    }

    private final class ComponentListener implements AdsLoader.EventListener {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f12256a = Util.H();

        /* renamed from: b  reason: collision with root package name */
        private volatile boolean f12257b;

        public ComponentListener() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(AdPlaybackState adPlaybackState) {
            if (!this.f12257b) {
                AdsMediaSource.this.a1(adPlaybackState);
            }
        }

        public void a(AdPlaybackState adPlaybackState) {
            if (!this.f12257b) {
                this.f12256a.post(new f(this, adPlaybackState));
            }
        }

        public /* synthetic */ void b() {
            a.a(this);
        }

        public void c(AdLoadException adLoadException, DataSpec dataSpec) {
            if (!this.f12257b) {
                AdsMediaSource.this.f0((MediaSource.MediaPeriodId) null).w(new LoadEventInfo(LoadEventInfo.a(), dataSpec, SystemClock.elapsedRealtime()), 6, adLoadException, true);
            }
        }

        public /* synthetic */ void d() {
            a.d(this);
        }

        public void g() {
            this.f12257b = true;
            this.f12256a.removeCallbacksAndMessages((Object) null);
        }
    }

    public AdsMediaSource(MediaSource mediaSource, DataSpec dataSpec, Object obj, MediaSource.Factory factory, AdsLoader adsLoader, AdViewProvider adViewProvider) {
        this.d3 = mediaSource;
        this.e3 = ((MediaItem.LocalConfiguration) Assertions.g(mediaSource.H().X)).Y;
        this.f3 = factory;
        this.g3 = adsLoader;
        this.h3 = adViewProvider;
        this.i3 = dataSpec;
        this.j3 = obj;
        adsLoader.g(factory.f());
    }

    private long[][] T0() {
        long[][] jArr = new long[this.p3.length][];
        int i2 = 0;
        while (true) {
            AdMediaSourceHolder[][] adMediaSourceHolderArr = this.p3;
            if (i2 >= adMediaSourceHolderArr.length) {
                return jArr;
            }
            jArr[i2] = new long[adMediaSourceHolderArr[i2].length];
            int i4 = 0;
            while (true) {
                AdMediaSourceHolder[] adMediaSourceHolderArr2 = this.p3[i2];
                if (i4 >= adMediaSourceHolderArr2.length) {
                    break;
                }
                AdMediaSourceHolder adMediaSourceHolder = adMediaSourceHolderArr2[i4];
                jArr[i2][i4] = adMediaSourceHolder == null ? C.f9084b : adMediaSourceHolder.b();
                i4++;
            }
            i2++;
        }
    }

    @Nullable
    private static MediaItem.AdsConfiguration U0(MediaItem mediaItem) {
        MediaItem.LocalConfiguration localConfiguration = mediaItem.X;
        if (localConfiguration == null) {
            return null;
        }
        return localConfiguration.Z;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W0(ComponentListener componentListener) {
        this.g3.b(this, this.i3, this.j3, this.h3, componentListener);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X0(ComponentListener componentListener) {
        this.g3.c(this, componentListener);
    }

    private void Y0() {
        MediaItem mediaItem;
        AdPlaybackState adPlaybackState = this.o3;
        if (adPlaybackState != null) {
            for (int i2 = 0; i2 < this.p3.length; i2++) {
                int i4 = 0;
                while (true) {
                    AdMediaSourceHolder[] adMediaSourceHolderArr = this.p3[i2];
                    if (i4 >= adMediaSourceHolderArr.length) {
                        break;
                    }
                    AdMediaSourceHolder adMediaSourceHolder = adMediaSourceHolderArr[i4];
                    AdPlaybackState.AdGroup f2 = adPlaybackState.f(i2);
                    if (adMediaSourceHolder != null && !adMediaSourceHolder.d()) {
                        MediaItem[] mediaItemArr = f2.X2;
                        if (i4 < mediaItemArr.length && (mediaItem = mediaItemArr[i4]) != null) {
                            if (this.e3 != null) {
                                mediaItem = mediaItem.b().m(this.e3).a();
                            }
                            adMediaSourceHolder.e(this.f3.c(mediaItem), mediaItem);
                        }
                    }
                    i4++;
                }
            }
        }
    }

    private void Z0() {
        Timeline timeline = this.n3;
        AdPlaybackState adPlaybackState = this.o3;
        if (adPlaybackState != null && timeline != null) {
            if (adPlaybackState.X == 0) {
                t0(timeline);
                return;
            }
            this.o3 = adPlaybackState.n(T0());
            t0(new SinglePeriodAdTimeline(timeline, this.o3));
        }
    }

    /* access modifiers changed from: private */
    public void a1(AdPlaybackState adPlaybackState) {
        AdPlaybackState adPlaybackState2 = this.o3;
        boolean z = false;
        if (adPlaybackState2 == null) {
            AdMediaSourceHolder[][] adMediaSourceHolderArr = new AdMediaSourceHolder[adPlaybackState.X][];
            this.p3 = adMediaSourceHolderArr;
            Arrays.fill(adMediaSourceHolderArr, new AdMediaSourceHolder[0]);
        } else {
            if (adPlaybackState.X == adPlaybackState2.X) {
                z = true;
            }
            Assertions.i(z);
        }
        this.o3 = adPlaybackState;
        Y0();
        Z0();
    }

    public MediaPeriod E(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        if (((AdPlaybackState) Assertions.g(this.o3)).X <= 0 || !mediaPeriodId.c()) {
            MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(mediaPeriodId, allocator, j2);
            maskingMediaPeriod.z(this.d3);
            maskingMediaPeriod.d(mediaPeriodId);
            return maskingMediaPeriod;
        }
        int i2 = mediaPeriodId.f12164b;
        int i4 = mediaPeriodId.f12165c;
        AdMediaSourceHolder[][] adMediaSourceHolderArr = this.p3;
        AdMediaSourceHolder[] adMediaSourceHolderArr2 = adMediaSourceHolderArr[i2];
        if (adMediaSourceHolderArr2.length <= i4) {
            adMediaSourceHolderArr[i2] = (AdMediaSourceHolder[]) Arrays.copyOf(adMediaSourceHolderArr2, i4 + 1);
        }
        AdMediaSourceHolder adMediaSourceHolder = this.p3[i2][i4];
        if (adMediaSourceHolder == null) {
            adMediaSourceHolder = new AdMediaSourceHolder(mediaPeriodId);
            this.p3[i2][i4] = adMediaSourceHolder;
            Y0();
        }
        return adMediaSourceHolder.a(mediaPeriodId, allocator, j2);
    }

    public MediaItem H() {
        return this.d3.H();
    }

    public boolean S(MediaItem mediaItem) {
        return Util.g(U0(H()), U0(mediaItem)) && this.d3.S(mediaItem);
    }

    /* access modifiers changed from: protected */
    /* renamed from: V0 */
    public MediaSource.MediaPeriodId C0(MediaSource.MediaPeriodId mediaPeriodId, MediaSource.MediaPeriodId mediaPeriodId2) {
        return mediaPeriodId.c() ? mediaPeriodId : mediaPeriodId2;
    }

    public void X(MediaPeriod mediaPeriod) {
        MaskingMediaPeriod maskingMediaPeriod = (MaskingMediaPeriod) mediaPeriod;
        MediaSource.MediaPeriodId mediaPeriodId = maskingMediaPeriod.s;
        if (mediaPeriodId.c()) {
            AdMediaSourceHolder adMediaSourceHolder = (AdMediaSourceHolder) Assertions.g(this.p3[mediaPeriodId.f12164b][mediaPeriodId.f12165c]);
            adMediaSourceHolder.h(maskingMediaPeriod);
            if (adMediaSourceHolder.f()) {
                adMediaSourceHolder.g();
                this.p3[mediaPeriodId.f12164b][mediaPeriodId.f12165c] = null;
                return;
            }
            return;
        }
        maskingMediaPeriod.y();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b1 */
    public void G0(MediaSource.MediaPeriodId mediaPeriodId, MediaSource mediaSource, Timeline timeline) {
        if (mediaPeriodId.c()) {
            int i2 = mediaPeriodId.f12164b;
            ((AdMediaSourceHolder) Assertions.g(this.p3[i2][mediaPeriodId.f12165c])).c(timeline);
        } else {
            boolean z = true;
            if (timeline.n() != 1) {
                z = false;
            }
            Assertions.a(z);
            this.n3 = timeline;
        }
        Z0();
    }

    public void k(MediaItem mediaItem) {
        this.d3.k(mediaItem);
    }

    /* access modifiers changed from: protected */
    public void s0(@Nullable TransferListener transferListener) {
        super.s0(transferListener);
        ComponentListener componentListener = new ComponentListener();
        this.m3 = componentListener;
        H0(q3, this.d3);
        this.k3.post(new b(this, componentListener));
    }

    /* access modifiers changed from: protected */
    public void u0() {
        super.u0();
        ComponentListener componentListener = (ComponentListener) Assertions.g(this.m3);
        this.m3 = null;
        componentListener.g();
        this.n3 = null;
        this.o3 = null;
        this.p3 = new AdMediaSourceHolder[0][];
        this.k3.post(new c(this, componentListener));
    }
}
