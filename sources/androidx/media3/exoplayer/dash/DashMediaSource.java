package androidx.media3.exoplayer.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.StreamKey;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import androidx.media3.exoplayer.dash.DashChunkSource;
import androidx.media3.exoplayer.dash.DefaultDashChunkSource;
import androidx.media3.exoplayer.dash.PlayerEmsgHandler;
import androidx.media3.exoplayer.dash.manifest.AdaptationSet;
import androidx.media3.exoplayer.dash.manifest.DashManifest;
import androidx.media3.exoplayer.dash.manifest.DashManifestParser;
import androidx.media3.exoplayer.dash.manifest.Period;
import androidx.media3.exoplayer.dash.manifest.Representation;
import androidx.media3.exoplayer.dash.manifest.UtcTimingElement;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManagerProvider;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.offline.FilteringManifestParser;
import androidx.media3.exoplayer.source.BaseMediaSource;
import androidx.media3.exoplayer.source.CompositeSequenceableLoaderFactory;
import androidx.media3.exoplayer.source.DefaultCompositeSequenceableLoaderFactory;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.MediaSourceFactory;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.upstream.LoaderErrorThrower;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import androidx.media3.exoplayer.util.SntpClient;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.common.base.Charsets;
import com.google.common.math.LongMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@UnstableApi
public final class DashMediaSource extends BaseMediaSource {
    public static final long K3 = 30000;
    @Deprecated
    public static final long L3 = 30000;
    public static final String M3 = "DashMediaSource";
    public static final long N3 = 5000000;
    private static final long O3 = 5000;
    private static final String P3 = "DashMediaSource";
    private Uri A3;
    private DashManifest B3;
    private boolean C3;
    private long D3;
    private long E3;
    private long F3;
    private int G3;
    private long H3;
    private int I3;
    @GuardedBy("this")
    private MediaItem J3;
    private final boolean a3;
    private final DataSource.Factory b3;
    private final DashChunkSource.Factory c3;
    private final CompositeSequenceableLoaderFactory d3;
    @Nullable
    private final CmcdConfiguration e3;
    private final DrmSessionManager f3;
    private final LoadErrorHandlingPolicy g3;
    private final BaseUrlExclusionList h3;
    private final long i3;
    private final long j3;
    private final MediaSourceEventListener.EventDispatcher k3;
    private final ParsingLoadable.Parser<? extends DashManifest> l3;
    private final ManifestCallback m3;
    private final Object n3;
    private final SparseArray<DashMediaPeriod> o3;
    private final Runnable p3;
    private final Runnable q3;
    private final PlayerEmsgHandler.PlayerEmsgCallback r3;
    private final LoaderErrorThrower s3;
    private DataSource t3;
    /* access modifiers changed from: private */
    public Loader u3;
    @Nullable
    private TransferListener v3;
    /* access modifiers changed from: private */
    public IOException w3;
    private Handler x3;
    private MediaItem.LiveConfiguration y3;
    private Uri z3;

    private static final class DashTimeline extends Timeline {
        private final long Y2;
        private final long Z2;
        private final long a3;
        private final int b3;
        private final long c3;
        private final long d3;
        private final long e3;
        private final DashManifest f3;
        private final MediaItem g3;
        @Nullable
        private final MediaItem.LiveConfiguration h3;

        public DashTimeline(long j2, long j3, long j4, int i2, long j5, long j6, long j7, DashManifest dashManifest, MediaItem mediaItem, @Nullable MediaItem.LiveConfiguration liveConfiguration) {
            DashManifest dashManifest2 = dashManifest;
            MediaItem.LiveConfiguration liveConfiguration2 = liveConfiguration;
            Assertions.i(dashManifest2.f11134d == (liveConfiguration2 != null));
            this.Y2 = j2;
            this.Z2 = j3;
            this.a3 = j4;
            this.b3 = i2;
            this.c3 = j5;
            this.d3 = j6;
            this.e3 = j7;
            this.f3 = dashManifest2;
            this.g3 = mediaItem;
            this.h3 = liveConfiguration2;
        }

        private static boolean A(DashManifest dashManifest) {
            return dashManifest.f11134d && dashManifest.f11135e != C.f9084b && dashManifest.f11132b == C.f9084b;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0050, code lost:
            r4 = r4.f11169c.get(r8).f11120c.get(0).l();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private long z(long r11) {
            /*
                r10 = this;
                long r0 = r10.e3
                androidx.media3.exoplayer.dash.manifest.DashManifest r2 = r10.f3
                boolean r2 = A(r2)
                if (r2 != 0) goto L_0x000b
                return r0
            L_0x000b:
                r2 = 0
                int r4 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
                if (r4 <= 0) goto L_0x001e
                long r0 = r0 + r11
                long r11 = r10.d3
                int r4 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
                if (r4 <= 0) goto L_0x001e
                r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                return r11
            L_0x001e:
                long r11 = r10.c3
                long r11 = r11 + r0
                androidx.media3.exoplayer.dash.manifest.DashManifest r4 = r10.f3
                r5 = 0
                long r6 = r4.g(r5)
                r4 = 0
            L_0x0029:
                androidx.media3.exoplayer.dash.manifest.DashManifest r8 = r10.f3
                int r8 = r8.e()
                int r8 = r8 + -1
                if (r4 >= r8) goto L_0x0041
                int r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r8 < 0) goto L_0x0041
                long r11 = r11 - r6
                int r4 = r4 + 1
                androidx.media3.exoplayer.dash.manifest.DashManifest r6 = r10.f3
                long r6 = r6.g(r4)
                goto L_0x0029
            L_0x0041:
                androidx.media3.exoplayer.dash.manifest.DashManifest r8 = r10.f3
                androidx.media3.exoplayer.dash.manifest.Period r4 = r8.d(r4)
                r8 = 2
                int r8 = r4.a(r8)
                r9 = -1
                if (r8 != r9) goto L_0x0050
                return r0
            L_0x0050:
                java.util.List<androidx.media3.exoplayer.dash.manifest.AdaptationSet> r4 = r4.f11169c
                java.lang.Object r4 = r4.get(r8)
                androidx.media3.exoplayer.dash.manifest.AdaptationSet r4 = (androidx.media3.exoplayer.dash.manifest.AdaptationSet) r4
                java.util.List<androidx.media3.exoplayer.dash.manifest.Representation> r4 = r4.f11120c
                java.lang.Object r4 = r4.get(r5)
                androidx.media3.exoplayer.dash.manifest.Representation r4 = (androidx.media3.exoplayer.dash.manifest.Representation) r4
                androidx.media3.exoplayer.dash.DashSegmentIndex r4 = r4.l()
                if (r4 == 0) goto L_0x0079
                long r8 = r4.j(r6)
                int r5 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r5 != 0) goto L_0x006f
                goto L_0x0079
            L_0x006f:
                long r2 = r4.g(r11, r6)
                long r2 = r4.b(r2)
                long r0 = r0 + r2
                long r0 = r0 - r11
            L_0x0079:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.DashMediaSource.DashTimeline.z(long):long");
        }

        public int g(Object obj) {
            int intValue;
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue() - this.b3) >= 0 && intValue < n()) {
                return intValue;
            }
            return -1;
        }

        public Timeline.Period l(int i2, Timeline.Period period, boolean z) {
            Assertions.c(i2, 0, n());
            Integer num = null;
            String str = z ? this.f3.d(i2).f11167a : null;
            if (z) {
                num = Integer.valueOf(this.b3 + i2);
            }
            return period.x(str, num, 0, this.f3.g(i2), Util.I1(this.f3.d(i2).f11168b - this.f3.d(0).f11168b) - this.c3);
        }

        public int n() {
            return this.f3.e();
        }

        public Object t(int i2) {
            Assertions.c(i2, 0, n());
            return Integer.valueOf(this.b3 + i2);
        }

        public Timeline.Window v(int i2, Timeline.Window window, long j2) {
            Assertions.c(i2, 0, 1);
            long z = z(j2);
            Object obj = Timeline.Window.k3;
            MediaItem mediaItem = this.g3;
            DashManifest dashManifest = this.f3;
            return window.k(obj, mediaItem, dashManifest, this.Y2, this.Z2, this.a3, true, A(dashManifest), this.h3, z, this.d3, 0, n() - 1, this.c3);
        }

        public int w() {
            return 1;
        }
    }

    private final class DefaultPlayerEmsgCallback implements PlayerEmsgHandler.PlayerEmsgCallback {
        private DefaultPlayerEmsgCallback() {
        }

        public void a() {
            DashMediaSource.this.O0();
        }

        public void b(long j2) {
            DashMediaSource.this.N0(j2);
        }
    }

    public static final class Factory implements MediaSourceFactory {

        /* renamed from: c  reason: collision with root package name */
        private final DashChunkSource.Factory f10974c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private final DataSource.Factory f10975d;

        /* renamed from: e  reason: collision with root package name */
        private CmcdConfiguration.Factory f10976e;

        /* renamed from: f  reason: collision with root package name */
        private DrmSessionManagerProvider f10977f;

        /* renamed from: g  reason: collision with root package name */
        private CompositeSequenceableLoaderFactory f10978g;

        /* renamed from: h  reason: collision with root package name */
        private LoadErrorHandlingPolicy f10979h;

        /* renamed from: i  reason: collision with root package name */
        private long f10980i;

        /* renamed from: j  reason: collision with root package name */
        private long f10981j;
        @Nullable

        /* renamed from: k  reason: collision with root package name */
        private ParsingLoadable.Parser<? extends DashManifest> f10982k;

        public Factory(DataSource.Factory factory) {
            this(new DefaultDashChunkSource.Factory(factory), factory);
        }

        public int[] f() {
            return new int[]{0};
        }

        /* renamed from: h */
        public DashMediaSource c(MediaItem mediaItem) {
            MediaItem mediaItem2 = mediaItem;
            Assertions.g(mediaItem2.X);
            ParsingLoadable.Parser parser = this.f10982k;
            if (parser == null) {
                parser = new DashManifestParser();
            }
            List<StreamKey> list = mediaItem2.X.X2;
            FilteringManifestParser filteringManifestParser = !list.isEmpty() ? new FilteringManifestParser(parser, list) : parser;
            CmcdConfiguration.Factory factory = this.f10976e;
            return new DashMediaSource(mediaItem, (DashManifest) null, this.f10975d, filteringManifestParser, this.f10974c, this.f10978g, factory == null ? null : factory.a(mediaItem2), this.f10977f.a(mediaItem2), this.f10979h, this.f10980i, this.f10981j);
        }

        public DashMediaSource i(DashManifest dashManifest) {
            return j(dashManifest, new MediaItem.Builder().M(Uri.EMPTY).E("DashMediaSource").G(MimeTypes.s0).a());
        }

        public DashMediaSource j(DashManifest dashManifest, MediaItem mediaItem) {
            Assertions.a(!dashManifest.f11134d);
            MediaItem.Builder G = mediaItem.b().G(MimeTypes.s0);
            if (mediaItem.X == null) {
                G.M(Uri.EMPTY);
            }
            MediaItem a2 = G.a();
            CmcdConfiguration.Factory factory = this.f10976e;
            return new DashMediaSource(a2, dashManifest, (DataSource.Factory) null, (ParsingLoadable.Parser) null, this.f10974c, this.f10978g, factory == null ? null : factory.a(a2), this.f10977f.a(a2), this.f10979h, this.f10980i, this.f10981j);
        }

        @CanIgnoreReturnValue
        /* renamed from: k */
        public Factory b(boolean z) {
            this.f10974c.b(z);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: l */
        public Factory g(CmcdConfiguration.Factory factory) {
            this.f10976e = (CmcdConfiguration.Factory) Assertions.g(factory);
            return this;
        }

        @CanIgnoreReturnValue
        public Factory m(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory) {
            this.f10978g = (CompositeSequenceableLoaderFactory) Assertions.h(compositeSequenceableLoaderFactory, "DashMediaSource.Factory#setCompositeSequenceableLoaderFactory no longer handles null by instantiating a new DefaultCompositeSequenceableLoaderFactory. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: n */
        public Factory e(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.f10977f = (DrmSessionManagerProvider) Assertions.h(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @CanIgnoreReturnValue
        public Factory o(long j2) {
            this.f10980i = j2;
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: p */
        public Factory d(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f10979h = (LoadErrorHandlingPolicy) Assertions.h(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
            return this;
        }

        @CanIgnoreReturnValue
        public Factory q(@Nullable ParsingLoadable.Parser<? extends DashManifest> parser) {
            this.f10982k = parser;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory r(long j2) {
            this.f10981j = j2;
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: s */
        public Factory a(SubtitleParser.Factory factory) {
            this.f10974c.a((SubtitleParser.Factory) Assertions.g(factory));
            return this;
        }

        public Factory(DashChunkSource.Factory factory, @Nullable DataSource.Factory factory2) {
            this.f10974c = (DashChunkSource.Factory) Assertions.g(factory);
            this.f10975d = factory2;
            this.f10977f = new DefaultDrmSessionManagerProvider();
            this.f10979h = new DefaultLoadErrorHandlingPolicy();
            this.f10980i = 30000;
            this.f10981j = DashMediaSource.N3;
            this.f10978g = new DefaultCompositeSequenceableLoaderFactory();
        }
    }

    static final class Iso8601Parser implements ParsingLoadable.Parser<Long> {

        /* renamed from: a  reason: collision with root package name */
        private static final Pattern f10983a = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

        Iso8601Parser() {
        }

        /* renamed from: b */
        public Long a(Uri uri, InputStream inputStream) throws IOException {
            String readLine = new BufferedReader(new InputStreamReader(inputStream, Charsets.f22255c)).readLine();
            try {
                Matcher matcher = f10983a.matcher(readLine);
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                    long time = simpleDateFormat.parse(group).getTime();
                    if (!"Z".equals(matcher.group(2))) {
                        long j2 = "+".equals(matcher.group(4)) ? 1 : -1;
                        long parseLong = Long.parseLong(matcher.group(5));
                        String group2 = matcher.group(7);
                        time -= j2 * (((parseLong * 60) + (TextUtils.isEmpty(group2) ? 0 : Long.parseLong(group2))) * 60000);
                    }
                    return Long.valueOf(time);
                }
                throw ParserException.c("Couldn't parse timestamp: " + readLine, (Throwable) null);
            } catch (ParseException e2) {
                throw ParserException.c((String) null, e2);
            }
        }
    }

    private final class ManifestCallback implements Loader.Callback<ParsingLoadable<DashManifest>> {
        private ManifestCallback() {
        }

        /* renamed from: a */
        public void Z(ParsingLoadable<DashManifest> parsingLoadable, long j2, long j3, boolean z) {
            DashMediaSource.this.P0(parsingLoadable, j2, j3);
        }

        /* renamed from: b */
        public void N(ParsingLoadable<DashManifest> parsingLoadable, long j2, long j3) {
            DashMediaSource.this.Q0(parsingLoadable, j2, j3);
        }

        /* renamed from: c */
        public Loader.LoadErrorAction p(ParsingLoadable<DashManifest> parsingLoadable, long j2, long j3, IOException iOException, int i2) {
            return DashMediaSource.this.R0(parsingLoadable, j2, j3, iOException, i2);
        }
    }

    final class ManifestLoadErrorThrower implements LoaderErrorThrower {
        ManifestLoadErrorThrower() {
        }

        private void c() throws IOException {
            if (DashMediaSource.this.w3 != null) {
                throw DashMediaSource.this.w3;
            }
        }

        public void a(int i2) throws IOException {
            DashMediaSource.this.u3.a(i2);
            c();
        }

        public void b() throws IOException {
            DashMediaSource.this.u3.b();
            c();
        }
    }

    private final class UtcTimestampCallback implements Loader.Callback<ParsingLoadable<Long>> {
        private UtcTimestampCallback() {
        }

        /* renamed from: a */
        public void Z(ParsingLoadable<Long> parsingLoadable, long j2, long j3, boolean z) {
            DashMediaSource.this.P0(parsingLoadable, j2, j3);
        }

        /* renamed from: b */
        public void N(ParsingLoadable<Long> parsingLoadable, long j2, long j3) {
            DashMediaSource.this.S0(parsingLoadable, j2, j3);
        }

        /* renamed from: c */
        public Loader.LoadErrorAction p(ParsingLoadable<Long> parsingLoadable, long j2, long j3, IOException iOException, int i2) {
            return DashMediaSource.this.T0(parsingLoadable, j2, j3, iOException);
        }
    }

    private static final class XsDateTimeParser implements ParsingLoadable.Parser<Long> {
        private XsDateTimeParser() {
        }

        /* renamed from: b */
        public Long a(Uri uri, InputStream inputStream) throws IOException {
            return Long.valueOf(Util.R1(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }
    }

    static {
        MediaLibraryInfo.a("media3.exoplayer.dash");
    }

    private DashMediaSource(MediaItem mediaItem, @Nullable DashManifest dashManifest, @Nullable DataSource.Factory factory, @Nullable ParsingLoadable.Parser<? extends DashManifest> parser, DashChunkSource.Factory factory2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, @Nullable CmcdConfiguration cmcdConfiguration, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j2, long j4) {
        this.J3 = mediaItem;
        this.y3 = mediaItem.Z;
        this.z3 = ((MediaItem.LocalConfiguration) Assertions.g(mediaItem.X)).s;
        this.A3 = mediaItem.X.s;
        this.B3 = dashManifest;
        this.b3 = factory;
        this.l3 = parser;
        this.c3 = factory2;
        this.e3 = cmcdConfiguration;
        this.f3 = drmSessionManager;
        this.g3 = loadErrorHandlingPolicy;
        this.i3 = j2;
        this.j3 = j4;
        this.d3 = compositeSequenceableLoaderFactory;
        this.h3 = new BaseUrlExclusionList();
        boolean z = dashManifest != null;
        this.a3 = z;
        this.k3 = f0((MediaSource.MediaPeriodId) null);
        this.n3 = new Object();
        this.o3 = new SparseArray<>();
        this.r3 = new DefaultPlayerEmsgCallback();
        this.H3 = C.f9084b;
        this.F3 = C.f9084b;
        if (z) {
            Assertions.i(true ^ dashManifest.f11134d);
            this.m3 = null;
            this.p3 = null;
            this.q3 = null;
            this.s3 = new LoaderErrorThrower.Placeholder();
            return;
        }
        this.m3 = new ManifestCallback();
        this.s3 = new ManifestLoadErrorThrower();
        this.p3 = new d(this);
        this.q3 = new e(this);
    }

    private static long F0(Period period, long j2, long j4) {
        Period period2 = period;
        long j5 = j2;
        long j6 = j4;
        long I1 = Util.I1(period2.f11168b);
        boolean J0 = J0(period);
        long j7 = Long.MAX_VALUE;
        for (int i2 = 0; i2 < period2.f11169c.size(); i2++) {
            AdaptationSet adaptationSet = period2.f11169c.get(i2);
            List<Representation> list = adaptationSet.f11120c;
            int i4 = adaptationSet.f11119b;
            boolean z = true;
            if (i4 == 1 || i4 == 2) {
                z = false;
            }
            if ((!J0 || !z) && !list.isEmpty()) {
                DashSegmentIndex l2 = list.get(0).l();
                if (l2 == null) {
                    return I1 + j5;
                }
                long k2 = l2.k(j5, j6);
                if (k2 == 0) {
                    return I1;
                }
                long d2 = (l2.d(j5, j6) + k2) - 1;
                j7 = Math.min(j7, l2.c(d2, j5) + l2.b(d2) + I1);
            }
        }
        return j7;
    }

    private static long G0(Period period, long j2, long j4) {
        Period period2 = period;
        long j5 = j2;
        long j6 = j4;
        long I1 = Util.I1(period2.f11168b);
        boolean J0 = J0(period);
        long j7 = I1;
        for (int i2 = 0; i2 < period2.f11169c.size(); i2++) {
            AdaptationSet adaptationSet = period2.f11169c.get(i2);
            List<Representation> list = adaptationSet.f11120c;
            int i4 = adaptationSet.f11119b;
            boolean z = true;
            if (i4 == 1 || i4 == 2) {
                z = false;
            }
            if ((!J0 || !z) && !list.isEmpty()) {
                DashSegmentIndex l2 = list.get(0).l();
                if (l2 == null || l2.k(j5, j6) == 0) {
                    return I1;
                }
                j7 = Math.max(j7, l2.b(l2.d(j5, j6)) + I1);
            }
        }
        return j7;
    }

    private static long H0(DashManifest dashManifest, long j2) {
        DashSegmentIndex l2;
        DashManifest dashManifest2 = dashManifest;
        int e2 = dashManifest.e() - 1;
        Period d2 = dashManifest2.d(e2);
        long I1 = Util.I1(d2.f11168b);
        long g2 = dashManifest2.g(e2);
        long I12 = Util.I1(j2);
        long I13 = Util.I1(dashManifest2.f11131a);
        long I14 = Util.I1(5000);
        for (int i2 = 0; i2 < d2.f11169c.size(); i2++) {
            List<Representation> list = d2.f11169c.get(i2).f11120c;
            if (!list.isEmpty() && (l2 = list.get(0).l()) != null) {
                long e4 = ((I13 + I1) + l2.e(g2, I12)) - I12;
                if (e4 < I14 - SilenceSkippingAudioProcessor.A || (e4 > I14 && e4 < I14 + SilenceSkippingAudioProcessor.A)) {
                    I14 = e4;
                }
            }
        }
        return LongMath.g(I14, 1000, RoundingMode.CEILING);
    }

    private long I0() {
        return (long) Math.min((this.G3 - 1) * 1000, 5000);
    }

    private static boolean J0(Period period) {
        for (int i2 = 0; i2 < period.f11169c.size(); i2++) {
            int i4 = period.f11169c.get(i2).f11119b;
            if (i4 == 1 || i4 == 2) {
                return true;
            }
        }
        return false;
    }

    private static boolean K0(Period period) {
        for (int i2 = 0; i2 < period.f11169c.size(); i2++) {
            DashSegmentIndex l2 = period.f11169c.get(i2).f11120c.get(0).l();
            if (l2 == null || l2.h()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L0() {
        W0(false);
    }

    private void M0() {
        SntpClient.j(this.u3, new SntpClient.InitializationCallback() {
            public void a(IOException iOException) {
                DashMediaSource.this.U0(iOException);
            }

            public void b() {
                DashMediaSource.this.V0(SntpClient.h());
            }
        });
    }

    /* access modifiers changed from: private */
    public void U0(IOException iOException) {
        Log.e("DashMediaSource", "Failed to resolve time offset.", iOException);
        W0(true);
    }

    /* access modifiers changed from: private */
    public void V0(long j2) {
        this.F3 = j2;
        W0(true);
    }

    private void W0(boolean z) {
        long j2;
        long j4;
        Period period;
        for (int i2 = 0; i2 < this.o3.size(); i2++) {
            int keyAt = this.o3.keyAt(i2);
            if (keyAt >= this.I3) {
                this.o3.valueAt(i2).Q(this.B3, keyAt - this.I3);
            }
        }
        Period d2 = this.B3.d(0);
        int e2 = this.B3.e() - 1;
        Period d4 = this.B3.d(e2);
        long g2 = this.B3.g(e2);
        long I1 = Util.I1(Util.B0(this.F3));
        long G0 = G0(d2, this.B3.g(0), I1);
        long F0 = F0(d4, g2, I1);
        boolean z2 = this.B3.f11134d && !K0(d4);
        if (z2) {
            long j5 = this.B3.f11136f;
            if (j5 != C.f9084b) {
                G0 = Math.max(G0, F0 - Util.I1(j5));
            }
        }
        long j6 = F0 - G0;
        DashManifest dashManifest = this.B3;
        Period period2 = d2;
        if (dashManifest.f11134d) {
            Assertions.i(dashManifest.f11131a != C.f9084b);
            long I12 = (I1 - Util.I1(this.B3.f11131a)) - G0;
            e1(I12, j6);
            long H2 = this.B3.f11131a + Util.H2(G0);
            long I13 = I12 - Util.I1(this.y3.s);
            long min = Math.min(this.j3, j6 / 2);
            j4 = H2;
            j2 = I13 < min ? min : I13;
            period = period2;
        } else {
            period = period2;
            j4 = C.f9084b;
            j2 = 0;
        }
        long I14 = G0 - Util.I1(period.f11168b);
        DashManifest dashManifest2 = this.B3;
        t0(new DashTimeline(dashManifest2.f11131a, j4, this.F3, this.I3, I14, j6, j2, dashManifest2, H(), this.B3.f11134d ? this.y3 : null));
        if (!this.a3) {
            this.x3.removeCallbacks(this.q3);
            if (z2) {
                this.x3.postDelayed(this.q3, H0(this.B3, Util.B0(this.F3)));
            }
            if (this.C3) {
                d1();
            } else if (z) {
                DashManifest dashManifest3 = this.B3;
                if (dashManifest3.f11134d) {
                    long j7 = dashManifest3.f11135e;
                    if (j7 != C.f9084b) {
                        if (j7 == 0) {
                            j7 = 5000;
                        }
                        b1(Math.max(0, (this.D3 + j7) - SystemClock.elapsedRealtime()));
                    }
                }
            }
        }
    }

    private void Y0(UtcTimingElement utcTimingElement) {
        ParsingLoadable.Parser iso8601Parser;
        String str = utcTimingElement.f11231a;
        if (Util.g(str, "urn:mpeg:dash:utc:direct:2014") || Util.g(str, "urn:mpeg:dash:utc:direct:2012")) {
            Z0(utcTimingElement);
            return;
        }
        if (Util.g(str, "urn:mpeg:dash:utc:http-iso:2014") || Util.g(str, "urn:mpeg:dash:utc:http-iso:2012")) {
            iso8601Parser = new Iso8601Parser();
        } else if (Util.g(str, "urn:mpeg:dash:utc:http-xsdate:2014") || Util.g(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
            iso8601Parser = new XsDateTimeParser();
        } else if (Util.g(str, "urn:mpeg:dash:utc:ntp:2014") || Util.g(str, "urn:mpeg:dash:utc:ntp:2012")) {
            M0();
            return;
        } else {
            U0(new IOException("Unsupported UTC timing scheme"));
            return;
        }
        a1(utcTimingElement, iso8601Parser);
    }

    private void Z0(UtcTimingElement utcTimingElement) {
        try {
            V0(Util.R1(utcTimingElement.f11232b) - this.E3);
        } catch (ParserException e2) {
            U0(e2);
        }
    }

    private void a1(UtcTimingElement utcTimingElement, ParsingLoadable.Parser<Long> parser) {
        c1(new ParsingLoadable(this.t3, Uri.parse(utcTimingElement.f11232b), 5, parser), new UtcTimestampCallback(), 1);
    }

    private void b1(long j2) {
        this.x3.postDelayed(this.p3, j2);
    }

    private <T> void c1(ParsingLoadable<T> parsingLoadable, Loader.Callback<ParsingLoadable<T>> callback, int i2) {
        this.k3.y(new LoadEventInfo(parsingLoadable.f12583a, parsingLoadable.f12584b, this.u3.n(parsingLoadable, callback, i2)), parsingLoadable.f12585c);
    }

    /* access modifiers changed from: private */
    public void d1() {
        Uri uri;
        this.x3.removeCallbacks(this.p3);
        if (!this.u3.j()) {
            if (this.u3.k()) {
                this.C3 = true;
                return;
            }
            synchronized (this.n3) {
                uri = this.z3;
            }
            this.C3 = false;
            c1(new ParsingLoadable(this.t3, uri, 4, this.l3), this.m3, this.g3.c(4));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005f, code lost:
        if (r2 != androidx.media3.common.C.f9084b) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0027, code lost:
        if (r2 != androidx.media3.common.C.f9084b) goto L_0x0017;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e1(long r19, long r21) {
        /*
            r18 = this;
            r0 = r18
            androidx.media3.common.MediaItem r1 = r18.H()
            androidx.media3.common.MediaItem$LiveConfiguration r1 = r1.Z
            long r6 = androidx.media3.common.util.Util.H2(r19)
            long r2 = r1.Y
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x001d
        L_0x0017:
            long r2 = java.lang.Math.min(r6, r2)
            r10 = r2
            goto L_0x002b
        L_0x001d:
            androidx.media3.exoplayer.dash.manifest.DashManifest r2 = r0.B3
            androidx.media3.exoplayer.dash.manifest.ServiceDescriptionElement r2 = r2.f11140j
            if (r2 == 0) goto L_0x002a
            long r2 = r2.f11214c
            int r4 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x002a
            goto L_0x0017
        L_0x002a:
            r10 = r6
        L_0x002b:
            long r2 = r19 - r21
            long r2 = androidx.media3.common.util.Util.H2(r2)
            r4 = 0
            int r12 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r12 >= 0) goto L_0x003c
            int r12 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r12 <= 0) goto L_0x003c
            r2 = r4
        L_0x003c:
            androidx.media3.exoplayer.dash.manifest.DashManifest r4 = r0.B3
            long r4 = r4.f11133c
            int r12 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r12 == 0) goto L_0x0049
            long r2 = r2 + r4
            long r2 = java.lang.Math.min(r2, r6)
        L_0x0049:
            r4 = r2
            long r2 = r1.X
            int r12 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r12 == 0) goto L_0x0055
        L_0x0050:
            long r4 = androidx.media3.common.util.Util.x(r2, r4, r6)
            goto L_0x0062
        L_0x0055:
            androidx.media3.exoplayer.dash.manifest.DashManifest r2 = r0.B3
            androidx.media3.exoplayer.dash.manifest.ServiceDescriptionElement r2 = r2.f11140j
            if (r2 == 0) goto L_0x0062
            long r2 = r2.f11213b
            int r12 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r12 == 0) goto L_0x0062
            goto L_0x0050
        L_0x0062:
            int r2 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r2 <= 0) goto L_0x0067
            r10 = r4
        L_0x0067:
            androidx.media3.common.MediaItem$LiveConfiguration r2 = r0.y3
            long r2 = r2.s
            int r6 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x0070
            goto L_0x0087
        L_0x0070:
            androidx.media3.exoplayer.dash.manifest.DashManifest r2 = r0.B3
            androidx.media3.exoplayer.dash.manifest.ServiceDescriptionElement r3 = r2.f11140j
            if (r3 == 0) goto L_0x007e
            long r6 = r3.f11212a
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 == 0) goto L_0x007e
            r2 = r6
            goto L_0x0087
        L_0x007e:
            long r2 = r2.f11137g
            int r6 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x0085
            goto L_0x0087
        L_0x0085:
            long r2 = r0.i3
        L_0x0087:
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x008c
            r2 = r4
        L_0x008c:
            int r6 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r6 <= 0) goto L_0x00a7
            long r2 = r0.j3
            r6 = 2
            long r6 = r21 / r6
            long r2 = java.lang.Math.min(r2, r6)
            long r2 = r19 - r2
            long r12 = androidx.media3.common.util.Util.H2(r2)
            r14 = r4
            r16 = r10
            long r2 = androidx.media3.common.util.Util.x(r12, r14, r16)
        L_0x00a7:
            float r6 = r1.Z
            r7 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r12 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r12 == 0) goto L_0x00b1
            goto L_0x00bd
        L_0x00b1:
            androidx.media3.exoplayer.dash.manifest.DashManifest r6 = r0.B3
            androidx.media3.exoplayer.dash.manifest.ServiceDescriptionElement r6 = r6.f11140j
            if (r6 == 0) goto L_0x00ba
            float r6 = r6.f11215d
            goto L_0x00bd
        L_0x00ba:
            r6 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
        L_0x00bd:
            float r1 = r1.X2
            int r12 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r12 == 0) goto L_0x00c4
            goto L_0x00d0
        L_0x00c4:
            androidx.media3.exoplayer.dash.manifest.DashManifest r1 = r0.B3
            androidx.media3.exoplayer.dash.manifest.ServiceDescriptionElement r1 = r1.f11140j
            if (r1 == 0) goto L_0x00cd
            float r1 = r1.f11216e
            goto L_0x00d0
        L_0x00cd:
            r1 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
        L_0x00d0:
            int r12 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r12 != 0) goto L_0x00e8
            int r7 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r7 != 0) goto L_0x00e8
            androidx.media3.exoplayer.dash.manifest.DashManifest r7 = r0.B3
            androidx.media3.exoplayer.dash.manifest.ServiceDescriptionElement r7 = r7.f11140j
            if (r7 == 0) goto L_0x00e4
            long r12 = r7.f11212a
            int r7 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r7 != 0) goto L_0x00e8
        L_0x00e4:
            r6 = 1065353216(0x3f800000, float:1.0)
            r1 = 1065353216(0x3f800000, float:1.0)
        L_0x00e8:
            androidx.media3.common.MediaItem$LiveConfiguration$Builder r7 = new androidx.media3.common.MediaItem$LiveConfiguration$Builder
            r7.<init>()
            androidx.media3.common.MediaItem$LiveConfiguration$Builder r2 = r7.k(r2)
            androidx.media3.common.MediaItem$LiveConfiguration$Builder r2 = r2.i(r4)
            androidx.media3.common.MediaItem$LiveConfiguration$Builder r2 = r2.g(r10)
            androidx.media3.common.MediaItem$LiveConfiguration$Builder r2 = r2.j(r6)
            androidx.media3.common.MediaItem$LiveConfiguration$Builder r1 = r2.h(r1)
            androidx.media3.common.MediaItem$LiveConfiguration r1 = r1.f()
            r0.y3 = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.DashMediaSource.e1(long, long):void");
    }

    public MediaPeriod E(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        int intValue = ((Integer) mediaPeriodId.f12163a).intValue() - this.I3;
        int i2 = intValue;
        MediaSourceEventListener.EventDispatcher f0 = f0(mediaPeriodId);
        DrmSessionEventListener.EventDispatcher b0 = b0(mediaPeriodId);
        DashMediaPeriod dashMediaPeriod = new DashMediaPeriod(intValue + this.I3, this.B3, this.h3, i2, this.c3, this.v3, this.e3, this.f3, b0, this.g3, f0, this.F3, this.s3, allocator, this.d3, this.r3, k0());
        this.o3.put(dashMediaPeriod.s, dashMediaPeriod);
        return dashMediaPeriod;
    }

    public synchronized MediaItem H() {
        return this.J3;
    }

    public void I() throws IOException {
        this.s3.b();
    }

    /* access modifiers changed from: package-private */
    public void N0(long j2) {
        long j4 = this.H3;
        if (j4 == C.f9084b || j4 < j2) {
            this.H3 = j2;
        }
    }

    /* access modifiers changed from: package-private */
    public void O0() {
        this.x3.removeCallbacks(this.q3);
        d1();
    }

    /* access modifiers changed from: package-private */
    public void P0(ParsingLoadable<?> parsingLoadable, long j2, long j4) {
        ParsingLoadable<?> parsingLoadable2 = parsingLoadable;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f12583a, parsingLoadable2.f12584b, parsingLoadable.f(), parsingLoadable.d(), j2, j4, parsingLoadable.b());
        this.g3.b(parsingLoadable2.f12583a);
        this.k3.p(loadEventInfo, parsingLoadable2.f12585c);
    }

    /* access modifiers changed from: package-private */
    public void Q0(ParsingLoadable<DashManifest> parsingLoadable, long j2, long j4) {
        ParsingLoadable<DashManifest> parsingLoadable2 = parsingLoadable;
        long j5 = j2;
        LoadEventInfo loadEventInfo = r2;
        LoadEventInfo loadEventInfo2 = new LoadEventInfo(parsingLoadable2.f12583a, parsingLoadable2.f12584b, parsingLoadable.f(), parsingLoadable.d(), j2, j4, parsingLoadable.b());
        this.g3.b(parsingLoadable2.f12583a);
        this.k3.s(loadEventInfo, parsingLoadable2.f12585c);
        DashManifest e2 = parsingLoadable.e();
        DashManifest dashManifest = this.B3;
        int e4 = dashManifest == null ? 0 : dashManifest.e();
        long j6 = e2.d(0).f11168b;
        int i2 = 0;
        while (i2 < e4 && this.B3.d(i2).f11168b < j6) {
            i2++;
        }
        if (e2.f11134d) {
            if (e4 - i2 > e2.e()) {
                Log.n("DashMediaSource", "Loaded out of sync manifest");
            } else {
                long j7 = this.H3;
                if (j7 == C.f9084b || e2.f11138h * 1000 > j7) {
                    this.G3 = 0;
                } else {
                    Log.n("DashMediaSource", "Loaded stale dynamic manifest: " + e2.f11138h + ", " + this.H3);
                }
            }
            int i4 = this.G3;
            this.G3 = i4 + 1;
            if (i4 < this.g3.c(parsingLoadable2.f12585c)) {
                b1(I0());
                return;
            } else {
                this.w3 = new DashManifestStaleException();
                return;
            }
        }
        this.B3 = e2;
        this.C3 = e2.f11134d & this.C3;
        long j8 = j2;
        this.D3 = j8 - j4;
        this.E3 = j8;
        synchronized (this.n3) {
            try {
                if (parsingLoadable2.f12584b.f9779a == this.z3) {
                    Uri uri = this.B3.f11141k;
                    if (uri == null) {
                        uri = parsingLoadable.f();
                    }
                    this.z3 = uri;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (e4 == 0) {
            DashManifest dashManifest2 = this.B3;
            if (dashManifest2.f11134d) {
                UtcTimingElement utcTimingElement = dashManifest2.f11139i;
                if (utcTimingElement != null) {
                    Y0(utcTimingElement);
                    return;
                } else {
                    M0();
                    return;
                }
            }
        } else {
            this.I3 += i2;
        }
        W0(true);
    }

    /* access modifiers changed from: package-private */
    public Loader.LoadErrorAction R0(ParsingLoadable<DashManifest> parsingLoadable, long j2, long j4, IOException iOException, int i2) {
        ParsingLoadable<DashManifest> parsingLoadable2 = parsingLoadable;
        IOException iOException2 = iOException;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f12583a, parsingLoadable2.f12584b, parsingLoadable.f(), parsingLoadable.d(), j2, j4, parsingLoadable.b());
        long a2 = this.g3.a(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(parsingLoadable2.f12585c), iOException2, i2));
        Loader.LoadErrorAction i4 = a2 == C.f9084b ? Loader.f12577l : Loader.i(false, a2);
        boolean z = !i4.c();
        this.k3.w(loadEventInfo, parsingLoadable2.f12585c, iOException2, z);
        if (z) {
            this.g3.b(parsingLoadable2.f12583a);
        }
        return i4;
    }

    public boolean S(MediaItem mediaItem) {
        MediaItem H = H();
        MediaItem.LocalConfiguration localConfiguration = (MediaItem.LocalConfiguration) Assertions.g(H.X);
        MediaItem.LocalConfiguration localConfiguration2 = mediaItem.X;
        return localConfiguration2 != null && localConfiguration2.s.equals(localConfiguration.s) && localConfiguration2.X2.equals(localConfiguration.X2) && Util.g(localConfiguration2.Y, localConfiguration.Y) && H.Z.equals(mediaItem.Z);
    }

    /* access modifiers changed from: package-private */
    public void S0(ParsingLoadable<Long> parsingLoadable, long j2, long j4) {
        ParsingLoadable<Long> parsingLoadable2 = parsingLoadable;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f12583a, parsingLoadable2.f12584b, parsingLoadable.f(), parsingLoadable.d(), j2, j4, parsingLoadable.b());
        this.g3.b(parsingLoadable2.f12583a);
        this.k3.s(loadEventInfo, parsingLoadable2.f12585c);
        V0(parsingLoadable.e().longValue() - j2);
    }

    /* access modifiers changed from: package-private */
    public Loader.LoadErrorAction T0(ParsingLoadable<Long> parsingLoadable, long j2, long j4, IOException iOException) {
        ParsingLoadable<Long> parsingLoadable2 = parsingLoadable;
        IOException iOException2 = iOException;
        MediaSourceEventListener.EventDispatcher eventDispatcher = this.k3;
        LoadEventInfo loadEventInfo = r4;
        LoadEventInfo loadEventInfo2 = new LoadEventInfo(parsingLoadable2.f12583a, parsingLoadable2.f12584b, parsingLoadable.f(), parsingLoadable.d(), j2, j4, parsingLoadable.b());
        eventDispatcher.w(loadEventInfo, parsingLoadable2.f12585c, iOException2, true);
        this.g3.b(parsingLoadable2.f12583a);
        U0(iOException2);
        return Loader.f12576k;
    }

    public void X(MediaPeriod mediaPeriod) {
        DashMediaPeriod dashMediaPeriod = (DashMediaPeriod) mediaPeriod;
        dashMediaPeriod.M();
        this.o3.remove(dashMediaPeriod.s);
    }

    public void X0(Uri uri) {
        synchronized (this.n3) {
            this.z3 = uri;
            this.A3 = uri;
        }
    }

    public synchronized void k(MediaItem mediaItem) {
        this.J3 = mediaItem;
    }

    /* access modifiers changed from: protected */
    public void s0(@Nullable TransferListener transferListener) {
        this.v3 = transferListener;
        this.f3.b(Looper.myLooper(), k0());
        this.f3.k();
        if (this.a3) {
            W0(false);
            return;
        }
        this.t3 = this.b3.a();
        this.u3 = new Loader("DashMediaSource");
        this.x3 = Util.H();
        d1();
    }

    /* access modifiers changed from: protected */
    public void u0() {
        this.C3 = false;
        this.t3 = null;
        Loader loader = this.u3;
        if (loader != null) {
            loader.l();
            this.u3 = null;
        }
        this.D3 = 0;
        this.E3 = 0;
        this.B3 = this.a3 ? this.B3 : null;
        this.z3 = this.A3;
        this.w3 = null;
        Handler handler = this.x3;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.x3 = null;
        }
        this.F3 = C.f9084b;
        this.G3 = 0;
        this.H3 = C.f9084b;
        this.o3.clear();
        this.h3.i();
        this.f3.a();
    }
}
