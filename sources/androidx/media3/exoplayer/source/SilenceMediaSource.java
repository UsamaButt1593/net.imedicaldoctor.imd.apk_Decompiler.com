package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.List;

@UnstableApi
public final class SilenceMediaSource extends BaseMediaSource {
    public static final String c3 = "SilenceMediaSource";
    private static final int d3 = 44100;
    private static final int e3 = 2;
    private static final int f3 = 2;
    /* access modifiers changed from: private */
    public static final Format g3;
    /* access modifiers changed from: private */
    public static final MediaItem h3;
    /* access modifiers changed from: private */
    public static final byte[] i3 = new byte[(Util.F0(2, 2) * 1024)];
    private final long a3;
    @GuardedBy("this")
    private MediaItem b3;

    public static final class Factory {

        /* renamed from: a  reason: collision with root package name */
        private long f12234a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private Object f12235b;

        public SilenceMediaSource a() {
            Assertions.i(this.f12234a > 0);
            return new SilenceMediaSource(this.f12234a, SilenceMediaSource.h3.b().L(this.f12235b).a());
        }

        @CanIgnoreReturnValue
        public Factory b(@IntRange(from = 1) long j2) {
            this.f12234a = j2;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory c(@Nullable Object obj) {
            this.f12235b = obj;
            return this;
        }
    }

    private static final class SilenceMediaPeriod implements MediaPeriod {
        private static final TrackGroupArray Y = new TrackGroupArray(new TrackGroup(SilenceMediaSource.g3));
        private final ArrayList<SampleStream> X = new ArrayList<>();
        private final long s;

        public SilenceMediaPeriod(long j2) {
            this.s = j2;
        }

        private long b(long j2) {
            return Util.x(j2, 0, this.s);
        }

        public boolean a(LoadingInfo loadingInfo) {
            return false;
        }

        public boolean c() {
            return false;
        }

        public long e() {
            return Long.MIN_VALUE;
        }

        public long f(long j2, SeekParameters seekParameters) {
            return b(j2);
        }

        public long g() {
            return Long.MIN_VALUE;
        }

        public void h(long j2) {
        }

        public /* synthetic */ List k(List list) {
            return n.a(this, list);
        }

        public void l() {
        }

        public long m(long j2) {
            long b2 = b(j2);
            for (int i2 = 0; i2 < this.X.size(); i2++) {
                ((SilenceSampleStream) this.X.get(i2)).a(b2);
            }
            return b2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Object[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object[]} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long n(androidx.media3.exoplayer.trackselection.ExoTrackSelection[] r5, boolean[] r6, androidx.media3.exoplayer.source.SampleStream[] r7, boolean[] r8, long r9) {
            /*
                r4 = this;
                long r9 = r4.b(r9)
                r0 = 0
            L_0x0005:
                int r1 = r5.length
                if (r0 >= r1) goto L_0x003b
                r1 = r7[r0]
                if (r1 == 0) goto L_0x001c
                r2 = r5[r0]
                if (r2 == 0) goto L_0x0014
                boolean r2 = r6[r0]
                if (r2 != 0) goto L_0x001c
            L_0x0014:
                java.util.ArrayList<androidx.media3.exoplayer.source.SampleStream> r2 = r4.X
                r2.remove(r1)
                r1 = 0
                r7[r0] = r1
            L_0x001c:
                r1 = r7[r0]
                if (r1 != 0) goto L_0x0038
                r1 = r5[r0]
                if (r1 == 0) goto L_0x0038
                androidx.media3.exoplayer.source.SilenceMediaSource$SilenceSampleStream r1 = new androidx.media3.exoplayer.source.SilenceMediaSource$SilenceSampleStream
                long r2 = r4.s
                r1.<init>(r2)
                r1.a(r9)
                java.util.ArrayList<androidx.media3.exoplayer.source.SampleStream> r2 = r4.X
                r2.add(r1)
                r7[r0] = r1
                r1 = 1
                r8[r0] = r1
            L_0x0038:
                int r0 = r0 + 1
                goto L_0x0005
            L_0x003b:
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SilenceMediaSource.SilenceMediaPeriod.n(androidx.media3.exoplayer.trackselection.ExoTrackSelection[], boolean[], androidx.media3.exoplayer.source.SampleStream[], boolean[], long):long");
        }

        public long q() {
            return C.f9084b;
        }

        public void r(MediaPeriod.Callback callback, long j2) {
            callback.i(this);
        }

        public TrackGroupArray s() {
            return Y;
        }

        public void t(long j2, boolean z) {
        }
    }

    private static final class SilenceSampleStream implements SampleStream {
        private boolean X;
        private long Y;
        private final long s;

        public SilenceSampleStream(long j2) {
            this.s = SilenceMediaSource.E0(j2);
            a(0);
        }

        public void a(long j2) {
            this.Y = Util.x(SilenceMediaSource.E0(j2), 0, this.s);
        }

        public void b() {
        }

        public boolean d() {
            return true;
        }

        public int j(long j2) {
            long j3 = this.Y;
            a(j2);
            return (int) ((this.Y - j3) / ((long) SilenceMediaSource.i3.length));
        }

        public int o(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            if (!this.X || (i2 & 2) != 0) {
                formatHolder.f10226b = SilenceMediaSource.g3;
                this.X = true;
                return -5;
            }
            long j2 = this.s;
            long j3 = this.Y;
            long j4 = j2 - j3;
            if (j4 == 0) {
                decoderInputBuffer.f(4);
                return -4;
            }
            decoderInputBuffer.Y2 = SilenceMediaSource.F0(j3);
            decoderInputBuffer.f(1);
            int min = (int) Math.min((long) SilenceMediaSource.i3.length, j4);
            if ((i2 & 4) == 0) {
                decoderInputBuffer.r(min);
                decoderInputBuffer.Z.put(SilenceMediaSource.i3, 0, min);
            }
            if ((i2 & 1) == 0) {
                this.Y += (long) min;
            }
            return -4;
        }
    }

    static {
        Format I = new Format.Builder().k0(MimeTypes.N).L(2).l0(d3).e0(2).I();
        g3 = I;
        h3 = new MediaItem.Builder().E(c3).M(Uri.EMPTY).G(I.f3).a();
    }

    public SilenceMediaSource(long j2) {
        this(j2, h3);
    }

    /* access modifiers changed from: private */
    public static long E0(long j2) {
        return ((long) Util.F0(2, 2)) * ((j2 * 44100) / 1000000);
    }

    /* access modifiers changed from: private */
    public static long F0(long j2) {
        return ((j2 / ((long) Util.F0(2, 2))) * 1000000) / 44100;
    }

    public MediaPeriod E(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        return new SilenceMediaPeriod(this.a3);
    }

    public synchronized MediaItem H() {
        return this.b3;
    }

    public void I() {
    }

    public boolean S(MediaItem mediaItem) {
        return true;
    }

    public void X(MediaPeriod mediaPeriod) {
    }

    public synchronized void k(MediaItem mediaItem) {
        this.b3 = mediaItem;
    }

    /* access modifiers changed from: protected */
    public void s0(@Nullable TransferListener transferListener) {
        t0(new SinglePeriodTimeline(this.a3, true, false, false, (Object) null, H()));
    }

    /* access modifiers changed from: protected */
    public void u0() {
    }

    private SilenceMediaSource(long j2, MediaItem mediaItem) {
        Assertions.a(j2 >= 0);
        this.a3 = j2;
        this.b3 = mediaItem;
    }
}
