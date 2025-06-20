package androidx.media3.exoplayer.smoothstreaming;

import android.net.Uri;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.UriUtil;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.smoothstreaming.SsChunkSource;
import androidx.media3.exoplayer.smoothstreaming.manifest.SsManifest;
import androidx.media3.exoplayer.source.BehindLiveWindowException;
import androidx.media3.exoplayer.source.chunk.BaseMediaChunkIterator;
import androidx.media3.exoplayer.source.chunk.BundledChunkExtractor;
import androidx.media3.exoplayer.source.chunk.Chunk;
import androidx.media3.exoplayer.source.chunk.ChunkExtractor;
import androidx.media3.exoplayer.source.chunk.ChunkHolder;
import androidx.media3.exoplayer.source.chunk.ContainerMediaChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunkIterator;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.TrackSelectionUtil;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoaderErrorThrower;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.mp4.FragmentedMp4Extractor;
import androidx.media3.extractor.mp4.Track;
import androidx.media3.extractor.mp4.TrackEncryptionBox;
import androidx.media3.extractor.text.DefaultSubtitleParserFactory;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

@UnstableApi
public class DefaultSsChunkSource implements SsChunkSource {

    /* renamed from: a  reason: collision with root package name */
    private final LoaderErrorThrower f11894a;

    /* renamed from: b  reason: collision with root package name */
    private final int f11895b;

    /* renamed from: c  reason: collision with root package name */
    private final ChunkExtractor[] f11896c;

    /* renamed from: d  reason: collision with root package name */
    private final DataSource f11897d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final CmcdConfiguration f11898e;

    /* renamed from: f  reason: collision with root package name */
    private ExoTrackSelection f11899f;

    /* renamed from: g  reason: collision with root package name */
    private SsManifest f11900g;

    /* renamed from: h  reason: collision with root package name */
    private int f11901h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private IOException f11902i;

    /* renamed from: j  reason: collision with root package name */
    private long f11903j = C.f9084b;

    public static final class Factory implements SsChunkSource.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final DataSource.Factory f11904a;

        /* renamed from: b  reason: collision with root package name */
        private SubtitleParser.Factory f11905b = new DefaultSubtitleParserFactory();

        /* renamed from: c  reason: collision with root package name */
        private boolean f11906c;

        public Factory(DataSource.Factory factory) {
            this.f11904a = factory;
        }

        public Format c(Format format) {
            String str;
            if (!this.f11906c || !this.f11905b.b(format)) {
                return format;
            }
            Format.Builder Q = format.c().k0(MimeTypes.O0).Q(this.f11905b.a(format));
            StringBuilder sb = new StringBuilder();
            sb.append(format.f3);
            if (format.c3 != null) {
                str = StringUtils.SPACE + format.c3;
            } else {
                str = "";
            }
            sb.append(str);
            return Q.M(sb.toString()).o0(Long.MAX_VALUE).I();
        }

        public SsChunkSource d(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int i2, ExoTrackSelection exoTrackSelection, @Nullable TransferListener transferListener, @Nullable CmcdConfiguration cmcdConfiguration) {
            TransferListener transferListener2 = transferListener;
            DataSource a2 = this.f11904a.a();
            if (transferListener2 != null) {
                a2.e(transferListener2);
            }
            return new DefaultSsChunkSource(loaderErrorThrower, ssManifest, i2, exoTrackSelection, a2, cmcdConfiguration, this.f11905b, this.f11906c);
        }

        @CanIgnoreReturnValue
        /* renamed from: e */
        public Factory b(boolean z) {
            this.f11906c = z;
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: f */
        public Factory a(SubtitleParser.Factory factory) {
            this.f11905b = factory;
            return this;
        }
    }

    private static final class StreamElementIterator extends BaseMediaChunkIterator {

        /* renamed from: e  reason: collision with root package name */
        private final SsManifest.StreamElement f11907e;

        /* renamed from: f  reason: collision with root package name */
        private final int f11908f;

        public StreamElementIterator(SsManifest.StreamElement streamElement, int i2, int i3) {
            super((long) i3, (long) (streamElement.f12036k - 1));
            this.f11907e = streamElement;
            this.f11908f = i2;
        }

        public long a() {
            e();
            return this.f11907e.e((int) f());
        }

        public DataSpec b() {
            e();
            return new DataSpec(this.f11907e.a(this.f11908f, (int) f()));
        }

        public long d() {
            return a() + this.f11907e.c((int) f());
        }
    }

    public DefaultSsChunkSource(LoaderErrorThrower loaderErrorThrower, SsManifest ssManifest, int i2, ExoTrackSelection exoTrackSelection, DataSource dataSource, @Nullable CmcdConfiguration cmcdConfiguration, SubtitleParser.Factory factory, boolean z) {
        SsManifest ssManifest2 = ssManifest;
        int i3 = i2;
        ExoTrackSelection exoTrackSelection2 = exoTrackSelection;
        this.f11894a = loaderErrorThrower;
        this.f11900g = ssManifest2;
        this.f11895b = i3;
        this.f11899f = exoTrackSelection2;
        this.f11897d = dataSource;
        this.f11898e = cmcdConfiguration;
        SsManifest.StreamElement streamElement = ssManifest2.f12020f[i3];
        this.f11896c = new ChunkExtractor[exoTrackSelection.length()];
        for (int i4 = 0; i4 < this.f11896c.length; i4++) {
            int k2 = exoTrackSelection2.k(i4);
            Format format = streamElement.f12035j[k2];
            TrackEncryptionBox[] trackEncryptionBoxArr = format.i3 != null ? ((SsManifest.ProtectionElement) Assertions.g(ssManifest2.f12019e)).f12025c : null;
            int i5 = streamElement.f12026a;
            this.f11896c[i4] = new BundledChunkExtractor(new FragmentedMp4Extractor(factory, !z ? 35 : 3, (TimestampAdjuster) null, new Track(k2, i5, streamElement.f12028c, C.f9084b, ssManifest2.f12021g, format, 0, trackEncryptionBoxArr, i5 == 2 ? 4 : 0, (long[]) null, (long[]) null), ImmutableList.I(), (TrackOutput) null), streamElement.f12026a, format);
        }
    }

    private static MediaChunk l(Format format, DataSource dataSource, Uri uri, int i2, long j2, long j3, long j4, int i3, @Nullable Object obj, ChunkExtractor chunkExtractor, @Nullable CmcdData.Factory factory) {
        DataSpec a2 = new DataSpec.Builder().j(uri).a();
        if (factory != null) {
            a2 = factory.a().a(a2);
        }
        return new ContainerMediaChunk(dataSource, a2, format, i3, obj, j2, j3, j4, C.f9084b, (long) i2, 1, j2, chunkExtractor);
    }

    private long m(long j2) {
        SsManifest ssManifest = this.f11900g;
        if (!ssManifest.f12018d) {
            return C.f9084b;
        }
        SsManifest.StreamElement streamElement = ssManifest.f12020f[this.f11895b];
        int i2 = streamElement.f12036k - 1;
        return (streamElement.e(i2) + streamElement.c(i2)) - j2;
    }

    public void a() {
        for (ChunkExtractor a2 : this.f11896c) {
            a2.a();
        }
    }

    public void b() throws IOException {
        IOException iOException = this.f11902i;
        if (iOException == null) {
            this.f11894a.b();
            return;
        }
        throw iOException;
    }

    public void c(ExoTrackSelection exoTrackSelection) {
        this.f11899f = exoTrackSelection;
    }

    public void d(Chunk chunk) {
    }

    public final void e(LoadingInfo loadingInfo, long j2, List<? extends MediaChunk> list, ChunkHolder chunkHolder) {
        int i2;
        CmcdData.Factory factory;
        LoadingInfo loadingInfo2 = loadingInfo;
        long j3 = j2;
        ChunkHolder chunkHolder2 = chunkHolder;
        if (this.f11902i == null) {
            SsManifest ssManifest = this.f11900g;
            SsManifest.StreamElement streamElement = ssManifest.f12020f[this.f11895b];
            if (streamElement.f12036k == 0) {
                chunkHolder2.f12288b = !ssManifest.f12018d;
                return;
            }
            if (list.isEmpty()) {
                i2 = streamElement.d(j3);
                List<? extends MediaChunk> list2 = list;
            } else {
                i2 = (int) (((MediaChunk) list.get(list.size() - 1)).g() - ((long) this.f11901h));
                if (i2 < 0) {
                    this.f11902i = new BehindLiveWindowException();
                    return;
                }
            }
            if (i2 >= streamElement.f12036k) {
                chunkHolder2.f12288b = !this.f11900g.f12018d;
                return;
            }
            long j4 = loadingInfo2.f10228a;
            long j5 = j3 - j4;
            long m2 = m(j4);
            int length = this.f11899f.length();
            MediaChunkIterator[] mediaChunkIteratorArr = new MediaChunkIterator[length];
            int i3 = 0;
            while (i3 < length) {
                mediaChunkIteratorArr[i3] = new StreamElementIterator(streamElement, this.f11899f.k(i3), i2);
                i3++;
                long j6 = j2;
            }
            long j7 = j5;
            this.f11899f.m(j4, j5, m2, list, mediaChunkIteratorArr);
            long e2 = streamElement.e(i2);
            long c2 = e2 + streamElement.c(i2);
            long j8 = list.isEmpty() ? j2 : -9223372036854775807L;
            int i4 = i2 + this.f11901h;
            int e3 = this.f11899f.e();
            ChunkExtractor chunkExtractor = this.f11896c[e3];
            int k2 = this.f11899f.k(e3);
            Uri a2 = streamElement.a(k2, i2);
            if (this.f11898e != null) {
                factory = new CmcdData.Factory(this.f11898e, this.f11899f, Math.max(0, j7), loadingInfo2.f10229b, "s", this.f11900g.f12018d, loadingInfo2.b(this.f11903j), list.isEmpty()).d(c2 - e2).g(CmcdData.Factory.c(this.f11899f));
                int i5 = i2 + 1;
                if (i5 < streamElement.f12036k) {
                    factory.e(UriUtil.a(a2, streamElement.a(k2, i5)));
                }
            } else {
                factory = null;
            }
            CmcdData.Factory factory2 = factory;
            this.f11903j = SystemClock.elapsedRealtime();
            chunkHolder.f12287a = l(this.f11899f.o(), this.f11897d, a2, i4, e2, c2, j8, this.f11899f.p(), this.f11899f.s(), chunkExtractor, factory2);
        }
    }

    public long f(long j2, SeekParameters seekParameters) {
        SsManifest.StreamElement streamElement = this.f11900g.f12020f[this.f11895b];
        int d2 = streamElement.d(j2);
        long e2 = streamElement.e(d2);
        return seekParameters.a(j2, e2, (e2 >= j2 || d2 >= streamElement.f12036k + -1) ? e2 : streamElement.e(d2 + 1));
    }

    public boolean g(Chunk chunk, boolean z, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        LoadErrorHandlingPolicy.FallbackSelection d2 = loadErrorHandlingPolicy.d(TrackSelectionUtil.c(this.f11899f), loadErrorInfo);
        if (z && d2 != null && d2.f12563a == 2) {
            ExoTrackSelection exoTrackSelection = this.f11899f;
            if (exoTrackSelection.q(exoTrackSelection.c(chunk.f12281d), d2.f12564b)) {
                return true;
            }
        }
        return false;
    }

    public void h(SsManifest ssManifest) {
        SsManifest.StreamElement[] streamElementArr = this.f11900g.f12020f;
        int i2 = this.f11895b;
        SsManifest.StreamElement streamElement = streamElementArr[i2];
        int i3 = streamElement.f12036k;
        SsManifest.StreamElement streamElement2 = ssManifest.f12020f[i2];
        if (!(i3 == 0 || streamElement2.f12036k == 0)) {
            int i4 = i3 - 1;
            long e2 = streamElement.e(i4) + streamElement.c(i4);
            long e3 = streamElement2.e(0);
            if (e2 > e3) {
                this.f11901h += streamElement.d(e3);
                this.f11900g = ssManifest;
            }
        }
        this.f11901h += i3;
        this.f11900g = ssManifest;
    }

    public int j(long j2, List<? extends MediaChunk> list) {
        return (this.f11902i != null || this.f11899f.length() < 2) ? list.size() : this.f11899f.l(j2, list);
    }

    public boolean k(long j2, Chunk chunk, List<? extends MediaChunk> list) {
        if (this.f11902i != null) {
            return false;
        }
        return this.f11899f.f(j2, chunk, list);
    }
}
