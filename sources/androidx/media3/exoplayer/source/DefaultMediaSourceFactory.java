package androidx.media3.exoplayer.source;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.media3.common.AdViewProvider;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.source.ExternallyLoadedMediaSource;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import androidx.media3.exoplayer.source.SingleSampleMediaSource;
import androidx.media3.exoplayer.source.ads.AdsLoader;
import androidx.media3.exoplayer.source.ads.AdsMediaSource;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.extractor.DefaultExtractorsFactory;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.d;
import androidx.media3.extractor.text.DefaultSubtitleParserFactory;
import androidx.media3.extractor.text.SubtitleExtractor;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class DefaultMediaSourceFactory implements MediaSourceFactory {
    private static final String q = "DMediaSourceFactory";

    /* renamed from: c  reason: collision with root package name */
    private final DelegateFactoryLoader f12109c;

    /* renamed from: d  reason: collision with root package name */
    private DataSource.Factory f12110d;

    /* renamed from: e  reason: collision with root package name */
    private SubtitleParser.Factory f12111e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private MediaSource.Factory f12112f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private ExternalLoader f12113g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private AdsLoader.Provider f12114h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private AdViewProvider f12115i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private LoadErrorHandlingPolicy f12116j;

    /* renamed from: k  reason: collision with root package name */
    private long f12117k;

    /* renamed from: l  reason: collision with root package name */
    private long f12118l;

    /* renamed from: m  reason: collision with root package name */
    private long f12119m;

    /* renamed from: n  reason: collision with root package name */
    private float f12120n;
    private float o;
    private boolean p;

    @UnstableApi
    @Deprecated
    public interface AdsLoaderProvider extends AdsLoader.Provider {
    }

    private static final class DelegateFactoryLoader {

        /* renamed from: a  reason: collision with root package name */
        private final ExtractorsFactory f12121a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<Integer, Supplier<MediaSource.Factory>> f12122b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        private final Set<Integer> f12123c = new HashSet();

        /* renamed from: d  reason: collision with root package name */
        private final Map<Integer, MediaSource.Factory> f12124d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        private DataSource.Factory f12125e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f12126f;

        /* renamed from: g  reason: collision with root package name */
        private SubtitleParser.Factory f12127g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        private CmcdConfiguration.Factory f12128h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        private DrmSessionManagerProvider f12129i;
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        private LoadErrorHandlingPolicy f12130j;

        public DelegateFactoryLoader(ExtractorsFactory extractorsFactory, SubtitleParser.Factory factory) {
            this.f12121a = extractorsFactory;
            this.f12127g = factory;
        }

        private void f() {
            n(0);
            n(1);
            n(2);
            n(3);
            n(4);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ MediaSource.Factory m(DataSource.Factory factory) {
            return new ProgressiveMediaSource.Factory(factory, this.f12121a);
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x007c  */
        @androidx.annotation.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private com.google.common.base.Supplier<androidx.media3.exoplayer.source.MediaSource.Factory> n(int r5) {
            /*
                r4 = this;
                java.util.Map<java.lang.Integer, com.google.common.base.Supplier<androidx.media3.exoplayer.source.MediaSource$Factory>> r0 = r4.f12122b
                java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
                boolean r0 = r0.containsKey(r1)
                if (r0 == 0) goto L_0x0019
                java.util.Map<java.lang.Integer, com.google.common.base.Supplier<androidx.media3.exoplayer.source.MediaSource$Factory>> r0 = r4.f12122b
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r5 = r0.get(r5)
                com.google.common.base.Supplier r5 = (com.google.common.base.Supplier) r5
                return r5
            L_0x0019:
                androidx.media3.datasource.DataSource$Factory r0 = r4.f12125e
                java.lang.Object r0 = androidx.media3.common.util.Assertions.g(r0)
                androidx.media3.datasource.DataSource$Factory r0 = (androidx.media3.datasource.DataSource.Factory) r0
                java.lang.Class<androidx.media3.exoplayer.source.MediaSource$Factory> r1 = androidx.media3.exoplayer.source.MediaSource.Factory.class
                r2 = 0
                if (r5 == 0) goto L_0x0065
                r3 = 1
                if (r5 == r3) goto L_0x0059
                r3 = 2
                if (r5 == r3) goto L_0x004c
                r3 = 3
                if (r5 == r3) goto L_0x003c
                r1 = 4
                if (r5 == r1) goto L_0x0033
                goto L_0x0071
            L_0x0033:
                androidx.media3.exoplayer.source.i r1 = new androidx.media3.exoplayer.source.i     // Catch:{ ClassNotFoundException -> 0x003a }
                r1.<init>(r4, r0)     // Catch:{ ClassNotFoundException -> 0x003a }
            L_0x0038:
                r2 = r1
                goto L_0x0071
            L_0x003a:
                goto L_0x0071
            L_0x003c:
                java.lang.String r0 = "androidx.media3.exoplayer.rtsp.RtspMediaSource$Factory"
                java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x003a }
                java.lang.Class r0 = r0.asSubclass(r1)     // Catch:{ ClassNotFoundException -> 0x003a }
                androidx.media3.exoplayer.source.h r1 = new androidx.media3.exoplayer.source.h     // Catch:{ ClassNotFoundException -> 0x003a }
                r1.<init>(r0)     // Catch:{ ClassNotFoundException -> 0x003a }
                goto L_0x0038
            L_0x004c:
                java.lang.Class<androidx.media3.exoplayer.hls.HlsMediaSource$Factory> r3 = androidx.media3.exoplayer.hls.HlsMediaSource.Factory.class
                java.lang.Class r1 = r3.asSubclass(r1)     // Catch:{ ClassNotFoundException -> 0x003a }
                androidx.media3.exoplayer.source.g r3 = new androidx.media3.exoplayer.source.g     // Catch:{ ClassNotFoundException -> 0x003a }
                r3.<init>(r1, r0)     // Catch:{ ClassNotFoundException -> 0x003a }
            L_0x0057:
                r2 = r3
                goto L_0x0071
            L_0x0059:
                java.lang.Class<androidx.media3.exoplayer.smoothstreaming.SsMediaSource$Factory> r3 = androidx.media3.exoplayer.smoothstreaming.SsMediaSource.Factory.class
                java.lang.Class r1 = r3.asSubclass(r1)     // Catch:{ ClassNotFoundException -> 0x003a }
                androidx.media3.exoplayer.source.f r3 = new androidx.media3.exoplayer.source.f     // Catch:{ ClassNotFoundException -> 0x003a }
                r3.<init>(r1, r0)     // Catch:{ ClassNotFoundException -> 0x003a }
                goto L_0x0057
            L_0x0065:
                java.lang.Class<androidx.media3.exoplayer.dash.DashMediaSource$Factory> r3 = androidx.media3.exoplayer.dash.DashMediaSource.Factory.class
                java.lang.Class r1 = r3.asSubclass(r1)     // Catch:{ ClassNotFoundException -> 0x003a }
                androidx.media3.exoplayer.source.e r3 = new androidx.media3.exoplayer.source.e     // Catch:{ ClassNotFoundException -> 0x003a }
                r3.<init>(r1, r0)     // Catch:{ ClassNotFoundException -> 0x003a }
                goto L_0x0057
            L_0x0071:
                java.util.Map<java.lang.Integer, com.google.common.base.Supplier<androidx.media3.exoplayer.source.MediaSource$Factory>> r0 = r4.f12122b
                java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
                r0.put(r1, r2)
                if (r2 == 0) goto L_0x0085
                java.util.Set<java.lang.Integer> r0 = r4.f12123c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                r0.add(r5)
            L_0x0085:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.DefaultMediaSourceFactory.DelegateFactoryLoader.n(int):com.google.common.base.Supplier");
        }

        @Nullable
        public MediaSource.Factory g(int i2) {
            MediaSource.Factory factory = this.f12124d.get(Integer.valueOf(i2));
            if (factory != null) {
                return factory;
            }
            Supplier<MediaSource.Factory> n2 = n(i2);
            if (n2 == null) {
                return null;
            }
            MediaSource.Factory factory2 = n2.get();
            CmcdConfiguration.Factory factory3 = this.f12128h;
            if (factory3 != null) {
                factory2.g(factory3);
            }
            DrmSessionManagerProvider drmSessionManagerProvider = this.f12129i;
            if (drmSessionManagerProvider != null) {
                factory2.e(drmSessionManagerProvider);
            }
            LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f12130j;
            if (loadErrorHandlingPolicy != null) {
                factory2.d(loadErrorHandlingPolicy);
            }
            factory2.a(this.f12127g);
            factory2.b(this.f12126f);
            this.f12124d.put(Integer.valueOf(i2), factory2);
            return factory2;
        }

        public int[] h() {
            f();
            return Ints.D(this.f12123c);
        }

        public void o(CmcdConfiguration.Factory factory) {
            this.f12128h = factory;
            for (MediaSource.Factory g2 : this.f12124d.values()) {
                g2.g(factory);
            }
        }

        public void p(DataSource.Factory factory) {
            if (factory != this.f12125e) {
                this.f12125e = factory;
                this.f12122b.clear();
                this.f12124d.clear();
            }
        }

        public void q(DrmSessionManagerProvider drmSessionManagerProvider) {
            this.f12129i = drmSessionManagerProvider;
            for (MediaSource.Factory e2 : this.f12124d.values()) {
                e2.e(drmSessionManagerProvider);
            }
        }

        public void r(int i2) {
            ExtractorsFactory extractorsFactory = this.f12121a;
            if (extractorsFactory instanceof DefaultExtractorsFactory) {
                ((DefaultExtractorsFactory) extractorsFactory).q(i2);
            }
        }

        public void s(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f12130j = loadErrorHandlingPolicy;
            for (MediaSource.Factory d2 : this.f12124d.values()) {
                d2.d(loadErrorHandlingPolicy);
            }
        }

        public void t(boolean z) {
            this.f12126f = z;
            this.f12121a.c(z);
            for (MediaSource.Factory b2 : this.f12124d.values()) {
                b2.b(z);
            }
        }

        public void u(SubtitleParser.Factory factory) {
            this.f12127g = factory;
            this.f12121a.a(factory);
            for (MediaSource.Factory a2 : this.f12124d.values()) {
                a2.a(factory);
            }
        }
    }

    private static final class UnknownSubtitlesExtractor implements Extractor {

        /* renamed from: d  reason: collision with root package name */
        private final Format f12131d;

        public UnknownSubtitlesExtractor(Format format) {
            this.f12131d = format;
        }

        public void a() {
        }

        public void c(long j2, long j3) {
        }

        public void d(ExtractorOutput extractorOutput) {
            TrackOutput d2 = extractorOutput.d(0, 3);
            extractorOutput.j(new SeekMap.Unseekable(C.f9084b));
            extractorOutput.o();
            d2.e(this.f12131d.c().k0(MimeTypes.o0).M(this.f12131d.f3).I());
        }

        public /* synthetic */ Extractor e() {
            return d.a(this);
        }

        public boolean h(ExtractorInput extractorInput) {
            return true;
        }

        public int i(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
            return extractorInput.b(Integer.MAX_VALUE) == -1 ? -1 : 0;
        }
    }

    public DefaultMediaSourceFactory(Context context) {
        this((DataSource.Factory) new DefaultDataSource.Factory(context));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Extractor[] m(Format format) {
        return new Extractor[]{this.f12111e.b(format) ? new SubtitleExtractor(this.f12111e.c(format), format) : new UnknownSubtitlesExtractor(format)};
    }

    private static MediaSource n(MediaItem mediaItem, MediaSource mediaSource) {
        MediaItem.ClippingConfiguration clippingConfiguration = mediaItem.Y2;
        if (clippingConfiguration.X == 0 && clippingConfiguration.Z == Long.MIN_VALUE && !clippingConfiguration.Y2) {
            return mediaSource;
        }
        MediaItem.ClippingConfiguration clippingConfiguration2 = mediaItem.Y2;
        return new ClippingMediaSource(mediaSource, clippingConfiguration2.X, clippingConfiguration2.Z, !clippingConfiguration2.Z2, clippingConfiguration2.X2, clippingConfiguration2.Y2);
    }

    private MediaSource o(MediaItem mediaItem, MediaSource mediaSource) {
        String str;
        Assertions.g(mediaItem.X);
        MediaItem.AdsConfiguration adsConfiguration = mediaItem.X.Z;
        if (adsConfiguration == null) {
            return mediaSource;
        }
        AdsLoader.Provider provider = this.f12114h;
        AdViewProvider adViewProvider = this.f12115i;
        if (provider == null || adViewProvider == null) {
            str = "Playing media without ads. Configure ad support by calling setAdsLoaderProvider and setAdViewProvider.";
        } else {
            AdsLoader a2 = provider.a(adsConfiguration);
            if (a2 == null) {
                str = "Playing media without ads, as no AdsLoader was provided.";
            } else {
                DataSpec dataSpec = new DataSpec(adsConfiguration.s);
                Object obj = adsConfiguration.X;
                return new AdsMediaSource(mediaSource, dataSpec, obj != null ? obj : ImmutableList.M(mediaItem.s, mediaItem.X.s, adsConfiguration.s), this, a2, adViewProvider);
            }
        }
        Log.n(q, str);
        return mediaSource;
    }

    /* access modifiers changed from: private */
    public static MediaSource.Factory p(Class<? extends MediaSource.Factory> cls) {
        try {
            return (MediaSource.Factory) cls.getConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    /* access modifiers changed from: private */
    public static MediaSource.Factory q(Class<? extends MediaSource.Factory> cls, DataSource.Factory factory) {
        try {
            return (MediaSource.Factory) cls.getConstructor(new Class[]{DataSource.Factory.class}).newInstance(new Object[]{factory});
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    @UnstableApi
    @CanIgnoreReturnValue
    public DefaultMediaSourceFactory A(float f2) {
        this.f12120n = f2;
        return this;
    }

    @UnstableApi
    @CanIgnoreReturnValue
    public DefaultMediaSourceFactory B(long j2) {
        this.f12117k = j2;
        return this;
    }

    @UnstableApi
    @CanIgnoreReturnValue
    /* renamed from: C */
    public DefaultMediaSourceFactory d(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        this.f12116j = (LoadErrorHandlingPolicy) Assertions.h(loadErrorHandlingPolicy, "MediaSource.Factory#setLoadErrorHandlingPolicy no longer handles null by instantiating a new DefaultLoadErrorHandlingPolicy. Explicitly construct and pass an instance in order to retain the old behavior.");
        this.f12109c.s(loadErrorHandlingPolicy);
        return this;
    }

    @CanIgnoreReturnValue
    public DefaultMediaSourceFactory D(AdsLoader.Provider provider, AdViewProvider adViewProvider) {
        this.f12114h = (AdsLoader.Provider) Assertions.g(provider);
        this.f12115i = (AdViewProvider) Assertions.g(adViewProvider);
        return this;
    }

    @UnstableApi
    @CanIgnoreReturnValue
    public DefaultMediaSourceFactory E(@Nullable MediaSource.Factory factory) {
        this.f12112f = factory;
        return this;
    }

    @UnstableApi
    @CanIgnoreReturnValue
    /* renamed from: F */
    public DefaultMediaSourceFactory a(SubtitleParser.Factory factory) {
        this.f12111e = (SubtitleParser.Factory) Assertions.g(factory);
        this.f12109c.u(factory);
        return this;
    }

    @UnstableApi
    public MediaSource c(MediaItem mediaItem) {
        Assertions.g(mediaItem.X);
        String scheme = mediaItem.X.s.getScheme();
        if (scheme != null && scheme.equals(C.p)) {
            return ((MediaSource.Factory) Assertions.g(this.f12112f)).c(mediaItem);
        }
        if (Objects.equals(mediaItem.X.X, MimeTypes.P0)) {
            return new ExternallyLoadedMediaSource.Factory(Util.I1(mediaItem.X.c3), (ExternalLoader) Assertions.g(this.f12113g)).c(mediaItem);
        }
        MediaItem.LocalConfiguration localConfiguration = mediaItem.X;
        int b1 = Util.b1(localConfiguration.s, localConfiguration.X);
        if (mediaItem.X.c3 != C.f9084b) {
            this.f12109c.r(1);
        }
        MediaSource.Factory g2 = this.f12109c.g(b1);
        Assertions.l(g2, "No suitable media source factory found for content type: " + b1);
        MediaItem.LiveConfiguration.Builder b2 = mediaItem.Z.b();
        if (mediaItem.Z.s == C.f9084b) {
            b2.k(this.f12117k);
        }
        if (mediaItem.Z.Z == -3.4028235E38f) {
            b2.j(this.f12120n);
        }
        if (mediaItem.Z.X2 == -3.4028235E38f) {
            b2.h(this.o);
        }
        if (mediaItem.Z.X == C.f9084b) {
            b2.i(this.f12118l);
        }
        if (mediaItem.Z.Y == C.f9084b) {
            b2.g(this.f12119m);
        }
        MediaItem.LiveConfiguration f2 = b2.f();
        if (!f2.equals(mediaItem.Z)) {
            mediaItem = mediaItem.b().y(f2).a();
        }
        MediaSource c2 = g2.c(mediaItem);
        ImmutableList<MediaItem.SubtitleConfiguration> immutableList = ((MediaItem.LocalConfiguration) Util.o(mediaItem.X)).Z2;
        if (!immutableList.isEmpty()) {
            MediaSource[] mediaSourceArr = new MediaSource[(immutableList.size() + 1)];
            mediaSourceArr[0] = c2;
            for (int i2 = 0; i2 < immutableList.size(); i2++) {
                if (this.p) {
                    ProgressiveMediaSource.Factory factory = new ProgressiveMediaSource.Factory(this.f12110d, (ExtractorsFactory) new C0338d(this, new Format.Builder().k0(immutableList.get(i2).X).b0(immutableList.get(i2).Y).m0(immutableList.get(i2).Z).i0(immutableList.get(i2).X2).Z(immutableList.get(i2).Y2).X(immutableList.get(i2).Z2).I()));
                    LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.f12116j;
                    if (loadErrorHandlingPolicy != null) {
                        factory.d(loadErrorHandlingPolicy);
                    }
                    mediaSourceArr[i2 + 1] = factory.c(MediaItem.e(immutableList.get(i2).s.toString()));
                } else {
                    SingleSampleMediaSource.Factory factory2 = new SingleSampleMediaSource.Factory(this.f12110d);
                    LoadErrorHandlingPolicy loadErrorHandlingPolicy2 = this.f12116j;
                    if (loadErrorHandlingPolicy2 != null) {
                        factory2.b(loadErrorHandlingPolicy2);
                    }
                    mediaSourceArr[i2 + 1] = factory2.a(immutableList.get(i2), C.f9084b);
                }
            }
            c2 = new MergingMediaSource(mediaSourceArr);
        }
        return o(mediaItem, n(mediaItem, c2));
    }

    @UnstableApi
    public int[] f() {
        return this.f12109c.h();
    }

    @CanIgnoreReturnValue
    public DefaultMediaSourceFactory k() {
        this.f12114h = null;
        this.f12115i = null;
        return this;
    }

    @UnstableApi
    @CanIgnoreReturnValue
    /* renamed from: l */
    public DefaultMediaSourceFactory b(boolean z) {
        this.p = z;
        this.f12109c.t(z);
        return this;
    }

    @UnstableApi
    @CanIgnoreReturnValue
    @Deprecated
    public DefaultMediaSourceFactory r(@Nullable AdViewProvider adViewProvider) {
        this.f12115i = adViewProvider;
        return this;
    }

    @UnstableApi
    @CanIgnoreReturnValue
    @Deprecated
    public DefaultMediaSourceFactory s(@Nullable AdsLoader.Provider provider) {
        this.f12114h = provider;
        return this;
    }

    @UnstableApi
    @CanIgnoreReturnValue
    /* renamed from: t */
    public DefaultMediaSourceFactory g(CmcdConfiguration.Factory factory) {
        this.f12109c.o((CmcdConfiguration.Factory) Assertions.g(factory));
        return this;
    }

    @CanIgnoreReturnValue
    public DefaultMediaSourceFactory u(DataSource.Factory factory) {
        this.f12110d = factory;
        this.f12109c.p(factory);
        return this;
    }

    @UnstableApi
    @CanIgnoreReturnValue
    /* renamed from: v */
    public DefaultMediaSourceFactory e(DrmSessionManagerProvider drmSessionManagerProvider) {
        this.f12109c.q((DrmSessionManagerProvider) Assertions.h(drmSessionManagerProvider, "MediaSource.Factory#setDrmSessionManagerProvider no longer handles null by instantiating a new DefaultDrmSessionManagerProvider. Explicitly construct and pass an instance in order to retain the old behavior."));
        return this;
    }

    @UnstableApi
    @CanIgnoreReturnValue
    public DefaultMediaSourceFactory w(@Nullable ExternalLoader externalLoader) {
        this.f12113g = externalLoader;
        return this;
    }

    @UnstableApi
    @CanIgnoreReturnValue
    public DefaultMediaSourceFactory x(long j2) {
        this.f12119m = j2;
        return this;
    }

    @UnstableApi
    @CanIgnoreReturnValue
    public DefaultMediaSourceFactory y(float f2) {
        this.o = f2;
        return this;
    }

    @UnstableApi
    @CanIgnoreReturnValue
    public DefaultMediaSourceFactory z(long j2) {
        this.f12118l = j2;
        return this;
    }

    @UnstableApi
    public DefaultMediaSourceFactory(Context context, ExtractorsFactory extractorsFactory) {
        this((DataSource.Factory) new DefaultDataSource.Factory(context), extractorsFactory);
    }

    @UnstableApi
    public DefaultMediaSourceFactory(DataSource.Factory factory) {
        this(factory, (ExtractorsFactory) new DefaultExtractorsFactory());
    }

    @UnstableApi
    public DefaultMediaSourceFactory(DataSource.Factory factory, ExtractorsFactory extractorsFactory) {
        this.f12110d = factory;
        DefaultSubtitleParserFactory defaultSubtitleParserFactory = new DefaultSubtitleParserFactory();
        this.f12111e = defaultSubtitleParserFactory;
        DelegateFactoryLoader delegateFactoryLoader = new DelegateFactoryLoader(extractorsFactory, defaultSubtitleParserFactory);
        this.f12109c = delegateFactoryLoader;
        delegateFactoryLoader.p(factory);
        this.f12117k = C.f9084b;
        this.f12118l = C.f9084b;
        this.f12119m = C.f9084b;
        this.f12120n = -3.4028235E38f;
        this.o = -3.4028235E38f;
    }
}
