package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@UnstableApi
public final class SingleSampleMediaSource extends BaseMediaSource {
    private final DataSpec a3;
    private final DataSource.Factory b3;
    private final Format c3;
    private final long d3;
    private final LoadErrorHandlingPolicy e3;
    private final boolean f3;
    private final Timeline g3;
    private final MediaItem h3;
    @Nullable
    private TransferListener i3;

    public static final class Factory {

        /* renamed from: a  reason: collision with root package name */
        private final DataSource.Factory f12240a;

        /* renamed from: b  reason: collision with root package name */
        private LoadErrorHandlingPolicy f12241b = new DefaultLoadErrorHandlingPolicy();

        /* renamed from: c  reason: collision with root package name */
        private boolean f12242c = true;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private Object f12243d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private String f12244e;

        public Factory(DataSource.Factory factory) {
            this.f12240a = (DataSource.Factory) Assertions.g(factory);
        }

        public SingleSampleMediaSource a(MediaItem.SubtitleConfiguration subtitleConfiguration, long j2) {
            return new SingleSampleMediaSource(this.f12244e, subtitleConfiguration, this.f12240a, j2, this.f12241b, this.f12242c, this.f12243d);
        }

        @CanIgnoreReturnValue
        public Factory b(@Nullable LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            if (loadErrorHandlingPolicy == null) {
                loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
            }
            this.f12241b = loadErrorHandlingPolicy;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory c(@Nullable Object obj) {
            this.f12243d = obj;
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Factory d(@Nullable String str) {
            this.f12244e = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory e(boolean z) {
            this.f12242c = z;
            return this;
        }
    }

    private SingleSampleMediaSource(@Nullable String str, MediaItem.SubtitleConfiguration subtitleConfiguration, DataSource.Factory factory, long j2, LoadErrorHandlingPolicy loadErrorHandlingPolicy, boolean z, @Nullable Object obj) {
        MediaItem.SubtitleConfiguration subtitleConfiguration2 = subtitleConfiguration;
        this.b3 = factory;
        this.d3 = j2;
        this.e3 = loadErrorHandlingPolicy;
        this.f3 = z;
        MediaItem a2 = new MediaItem.Builder().M(Uri.EMPTY).E(subtitleConfiguration2.s.toString()).J(ImmutableList.K(subtitleConfiguration)).L(obj).a();
        this.h3 = a2;
        Format.Builder Z = new Format.Builder().k0((String) MoreObjects.a(subtitleConfiguration2.X, MimeTypes.o0)).b0(subtitleConfiguration2.Y).m0(subtitleConfiguration2.Z).i0(subtitleConfiguration2.X2).Z(subtitleConfiguration2.Y2);
        String str2 = subtitleConfiguration2.Z2;
        this.c3 = Z.X(str2 == null ? str : str2).I();
        this.a3 = new DataSpec.Builder().j(subtitleConfiguration2.s).c(1).a();
        this.g3 = new SinglePeriodTimeline(j2, true, false, false, (Object) null, a2);
    }

    public MediaPeriod E(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        return new SingleSampleMediaPeriod(this.a3, this.b3, this.i3, this.c3, this.d3, this.e3, f0(mediaPeriodId), this.f3);
    }

    public MediaItem H() {
        return this.h3;
    }

    public void I() {
    }

    public void X(MediaPeriod mediaPeriod) {
        ((SingleSampleMediaPeriod) mediaPeriod).o();
    }

    /* access modifiers changed from: protected */
    public void s0(@Nullable TransferListener transferListener) {
        this.i3 = transferListener;
        t0(this.g3);
    }

    /* access modifiers changed from: protected */
    public void u0() {
    }
}
