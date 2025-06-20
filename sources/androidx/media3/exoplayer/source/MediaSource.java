package androidx.media3.exoplayer.source;

import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.extractor.text.SubtitleParser;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.io.IOException;

public interface MediaSource {

    public interface Factory {
        @UnstableApi

        /* renamed from: a  reason: collision with root package name */
        public static final Factory f12162a = MediaSourceFactory.f12173b;

        @UnstableApi
        Factory a(SubtitleParser.Factory factory);

        @UnstableApi
        Factory b(boolean z);

        @UnstableApi
        MediaSource c(MediaItem mediaItem);

        @UnstableApi
        Factory d(LoadErrorHandlingPolicy loadErrorHandlingPolicy);

        @UnstableApi
        Factory e(DrmSessionManagerProvider drmSessionManagerProvider);

        @UnstableApi
        int[] f();

        @UnstableApi
        Factory g(CmcdConfiguration.Factory factory);
    }

    @UnstableApi
    public static final class MediaPeriodId {

        /* renamed from: a  reason: collision with root package name */
        public final Object f12163a;

        /* renamed from: b  reason: collision with root package name */
        public final int f12164b;

        /* renamed from: c  reason: collision with root package name */
        public final int f12165c;

        /* renamed from: d  reason: collision with root package name */
        public final long f12166d;

        /* renamed from: e  reason: collision with root package name */
        public final int f12167e;

        public MediaPeriodId(Object obj) {
            this(obj, -1);
        }

        public MediaPeriodId a(Object obj) {
            if (this.f12163a.equals(obj)) {
                return this;
            }
            return new MediaPeriodId(obj, this.f12164b, this.f12165c, this.f12166d, this.f12167e);
        }

        public MediaPeriodId b(long j2) {
            if (this.f12166d == j2) {
                return this;
            }
            return new MediaPeriodId(this.f12163a, this.f12164b, this.f12165c, j2, this.f12167e);
        }

        public boolean c() {
            return this.f12164b != -1;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MediaPeriodId)) {
                return false;
            }
            MediaPeriodId mediaPeriodId = (MediaPeriodId) obj;
            return this.f12163a.equals(mediaPeriodId.f12163a) && this.f12164b == mediaPeriodId.f12164b && this.f12165c == mediaPeriodId.f12165c && this.f12166d == mediaPeriodId.f12166d && this.f12167e == mediaPeriodId.f12167e;
        }

        public int hashCode() {
            return ((((((((MetaDo.w + this.f12163a.hashCode()) * 31) + this.f12164b) * 31) + this.f12165c) * 31) + ((int) this.f12166d)) * 31) + this.f12167e;
        }

        public MediaPeriodId(Object obj, int i2, int i3, long j2) {
            this(obj, i2, i3, j2, -1);
        }

        private MediaPeriodId(Object obj, int i2, int i3, long j2, int i4) {
            this.f12163a = obj;
            this.f12164b = i2;
            this.f12165c = i3;
            this.f12166d = j2;
            this.f12167e = i4;
        }

        public MediaPeriodId(Object obj, long j2) {
            this(obj, -1, -1, j2, -1);
        }

        public MediaPeriodId(Object obj, long j2, int i2) {
            this(obj, -1, -1, j2, i2);
        }
    }

    @UnstableApi
    public interface MediaSourceCaller {
        void W(MediaSource mediaSource, Timeline timeline);
    }

    @UnstableApi
    void D(MediaSourceCaller mediaSourceCaller);

    @UnstableApi
    MediaPeriod E(MediaPeriodId mediaPeriodId, Allocator allocator, long j2);

    @UnstableApi
    MediaItem H();

    @UnstableApi
    void I() throws IOException;

    @UnstableApi
    boolean K();

    @UnstableApi
    @Nullable
    Timeline L();

    @UnstableApi
    @Deprecated
    void M(MediaSourceCaller mediaSourceCaller, @Nullable TransferListener transferListener);

    @UnstableApi
    void P(Handler handler, DrmSessionEventListener drmSessionEventListener);

    @UnstableApi
    boolean S(MediaItem mediaItem);

    @UnstableApi
    void U(DrmSessionEventListener drmSessionEventListener);

    @UnstableApi
    void X(MediaPeriod mediaPeriod);

    @UnstableApi
    void Y(MediaSourceCaller mediaSourceCaller, @Nullable TransferListener transferListener, PlayerId playerId);

    @UnstableApi
    void c(Handler handler, MediaSourceEventListener mediaSourceEventListener);

    @UnstableApi
    void e(MediaSourceCaller mediaSourceCaller);

    @UnstableApi
    void k(MediaItem mediaItem);

    @UnstableApi
    void q(MediaSourceEventListener mediaSourceEventListener);

    @UnstableApi
    void x(MediaSourceCaller mediaSourceCaller);
}
