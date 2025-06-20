package androidx.media3.exoplayer.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.exoplayer.hls.HlsDataSourceFactory;
import androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist;
import androidx.media3.exoplayer.hls.playlist.HlsMultivariantPlaylist;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistParser;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistTracker;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.upstream.ParsingLoadable;
import com.google.common.collect.Iterables;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@UnstableApi
public final class DefaultHlsPlaylistTracker implements HlsPlaylistTracker, Loader.Callback<ParsingLoadable<HlsPlaylist>> {
    public static final HlsPlaylistTracker.Factory i3 = new a();
    public static final double j3 = 3.5d;
    /* access modifiers changed from: private */
    public final HlsPlaylistParserFactory X;
    /* access modifiers changed from: private */
    public final CopyOnWriteArrayList<HlsPlaylistTracker.PlaylistEventListener> X2;
    /* access modifiers changed from: private */
    public final LoadErrorHandlingPolicy Y;
    /* access modifiers changed from: private */
    public final double Y2;
    /* access modifiers changed from: private */
    public final HashMap<Uri, MediaPlaylistBundle> Z;
    /* access modifiers changed from: private */
    @Nullable
    public MediaSourceEventListener.EventDispatcher Z2;
    @Nullable
    private Loader a3;
    /* access modifiers changed from: private */
    @Nullable
    public Handler b3;
    @Nullable
    private HlsPlaylistTracker.PrimaryPlaylistListener c3;
    /* access modifiers changed from: private */
    @Nullable
    public HlsMultivariantPlaylist d3;
    /* access modifiers changed from: private */
    @Nullable
    public Uri e3;
    /* access modifiers changed from: private */
    @Nullable
    public HlsMediaPlaylist f3;
    private boolean g3;
    private long h3;
    /* access modifiers changed from: private */
    public final HlsDataSourceFactory s;

    private class FirstPrimaryMediaPlaylistListener implements HlsPlaylistTracker.PlaylistEventListener {
        private FirstPrimaryMediaPlaylistListener() {
        }

        public void b() {
            DefaultHlsPlaylistTracker.this.X2.remove(this);
        }

        public boolean d(Uri uri, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, boolean z) {
            MediaPlaylistBundle mediaPlaylistBundle;
            if (DefaultHlsPlaylistTracker.this.f3 == null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                List<HlsMultivariantPlaylist.Variant> list = ((HlsMultivariantPlaylist) Util.o(DefaultHlsPlaylistTracker.this.d3)).f11578e;
                int i2 = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    MediaPlaylistBundle mediaPlaylistBundle2 = (MediaPlaylistBundle) DefaultHlsPlaylistTracker.this.Z.get(list.get(i3).f11591a);
                    if (mediaPlaylistBundle2 != null && elapsedRealtime < mediaPlaylistBundle2.a3) {
                        i2++;
                    }
                }
                LoadErrorHandlingPolicy.FallbackSelection d2 = DefaultHlsPlaylistTracker.this.Y.d(new LoadErrorHandlingPolicy.FallbackOptions(1, 0, DefaultHlsPlaylistTracker.this.d3.f11578e.size(), i2), loadErrorInfo);
                if (!(d2 == null || d2.f12563a != 2 || (mediaPlaylistBundle = (MediaPlaylistBundle) DefaultHlsPlaylistTracker.this.Z.get(uri)) == null)) {
                    boolean unused = mediaPlaylistBundle.h(d2.f12564b);
                }
            }
            return false;
        }
    }

    private final class MediaPlaylistBundle implements Loader.Callback<ParsingLoadable<HlsPlaylist>> {
        private static final String e3 = "_HLS_msn";
        private static final String f3 = "_HLS_part";
        private static final String g3 = "_HLS_skip";
        private final Loader X = new Loader("DefaultHlsPlaylistTracker:MediaPlaylist");
        private long X2;
        private final DataSource Y;
        private long Y2;
        /* access modifiers changed from: private */
        @Nullable
        public HlsMediaPlaylist Z;
        private long Z2;
        /* access modifiers changed from: private */
        public long a3;
        private boolean b3;
        @Nullable
        private IOException c3;
        /* access modifiers changed from: private */
        public final Uri s;

        public MediaPlaylistBundle(Uri uri) {
            this.s = uri;
            this.Y = DefaultHlsPlaylistTracker.this.s.a(4);
        }

        /* access modifiers changed from: private */
        public boolean h(long j2) {
            this.a3 = SystemClock.elapsedRealtime() + j2;
            return this.s.equals(DefaultHlsPlaylistTracker.this.e3) && !DefaultHlsPlaylistTracker.this.J();
        }

        private Uri i() {
            HlsMediaPlaylist hlsMediaPlaylist = this.Z;
            if (hlsMediaPlaylist != null) {
                HlsMediaPlaylist.ServerControl serverControl = hlsMediaPlaylist.v;
                if (serverControl.f11571a != C.f9084b || serverControl.f11575e) {
                    Uri.Builder buildUpon = this.s.buildUpon();
                    HlsMediaPlaylist hlsMediaPlaylist2 = this.Z;
                    if (hlsMediaPlaylist2.v.f11575e) {
                        buildUpon.appendQueryParameter(e3, String.valueOf(hlsMediaPlaylist2.f11564k + ((long) hlsMediaPlaylist2.r.size())));
                        HlsMediaPlaylist hlsMediaPlaylist3 = this.Z;
                        if (hlsMediaPlaylist3.f11567n != C.f9084b) {
                            List<HlsMediaPlaylist.Part> list = hlsMediaPlaylist3.s;
                            int size = list.size();
                            if (!list.isEmpty() && ((HlsMediaPlaylist.Part) Iterables.w(list)).f3) {
                                size--;
                            }
                            buildUpon.appendQueryParameter(f3, String.valueOf(size));
                        }
                    }
                    HlsMediaPlaylist.ServerControl serverControl2 = this.Z.v;
                    if (serverControl2.f11571a != C.f9084b) {
                        buildUpon.appendQueryParameter(g3, serverControl2.f11572b ? "v2" : "YES");
                    }
                    return buildUpon.build();
                }
            }
            return this.s;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void l(Uri uri) {
            this.b3 = false;
            n(uri);
        }

        private void n(Uri uri) {
            ParsingLoadable parsingLoadable = new ParsingLoadable(this.Y, uri, 4, DefaultHlsPlaylistTracker.this.X.a(DefaultHlsPlaylistTracker.this.d3, this.Z));
            DefaultHlsPlaylistTracker.this.Z2.y(new LoadEventInfo(parsingLoadable.f12583a, parsingLoadable.f12584b, this.X.n(parsingLoadable, this, DefaultHlsPlaylistTracker.this.Y.c(parsingLoadable.f12585c))), parsingLoadable.f12585c);
        }

        /* access modifiers changed from: private */
        public void o(Uri uri) {
            this.a3 = 0;
            if (!this.b3 && !this.X.k() && !this.X.j()) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime < this.Z2) {
                    this.b3 = true;
                    DefaultHlsPlaylistTracker.this.b3.postDelayed(new b(this, uri), this.Z2 - elapsedRealtime);
                    return;
                }
                n(uri);
            }
        }

        /* access modifiers changed from: private */
        public void u(HlsMediaPlaylist hlsMediaPlaylist, LoadEventInfo loadEventInfo) {
            long j2;
            boolean z;
            HlsMediaPlaylist hlsMediaPlaylist2 = this.Z;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.X2 = elapsedRealtime;
            HlsMediaPlaylist r = DefaultHlsPlaylistTracker.this.E(hlsMediaPlaylist2, hlsMediaPlaylist);
            this.Z = r;
            IOException iOException = null;
            if (r != hlsMediaPlaylist2) {
                this.c3 = null;
                this.Y2 = elapsedRealtime;
                DefaultHlsPlaylistTracker.this.Q(this.s, r);
            } else if (!r.o) {
                HlsMediaPlaylist hlsMediaPlaylist3 = this.Z;
                if (hlsMediaPlaylist.f11564k + ((long) hlsMediaPlaylist.r.size()) < hlsMediaPlaylist3.f11564k) {
                    iOException = new HlsPlaylistTracker.PlaylistResetException(this.s);
                    z = true;
                } else {
                    z = false;
                    if (((double) (elapsedRealtime - this.Y2)) > ((double) Util.H2(hlsMediaPlaylist3.f11566m)) * DefaultHlsPlaylistTracker.this.Y2) {
                        iOException = new HlsPlaylistTracker.PlaylistStuckException(this.s);
                    }
                }
                if (iOException != null) {
                    this.c3 = iOException;
                    boolean unused = DefaultHlsPlaylistTracker.this.L(this.s, new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(4), iOException, 1), z);
                }
            }
            HlsMediaPlaylist hlsMediaPlaylist4 = this.Z;
            if (!hlsMediaPlaylist4.v.f11575e) {
                j2 = hlsMediaPlaylist4.f11566m;
                if (hlsMediaPlaylist4 == hlsMediaPlaylist2) {
                    j2 /= 2;
                }
            } else {
                j2 = 0;
            }
            this.Z2 = (elapsedRealtime + Util.H2(j2)) - loadEventInfo.f12147f;
            if ((this.Z.f11567n != C.f9084b || this.s.equals(DefaultHlsPlaylistTracker.this.e3)) && !this.Z.o) {
                o(i());
            }
        }

        @Nullable
        public HlsMediaPlaylist j() {
            return this.Z;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x001f, code lost:
            r0 = r0.f11557d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean k() {
            /*
                r10 = this;
                androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist r0 = r10.Z
                r1 = 0
                if (r0 != 0) goto L_0x0006
                return r1
            L_0x0006:
                long r2 = android.os.SystemClock.elapsedRealtime()
                androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist r0 = r10.Z
                long r4 = r0.u
                long r4 = androidx.media3.common.util.Util.H2(r4)
                r6 = 30000(0x7530, double:1.4822E-319)
                long r4 = java.lang.Math.max(r6, r4)
                androidx.media3.exoplayer.hls.playlist.HlsMediaPlaylist r0 = r10.Z
                boolean r6 = r0.o
                r7 = 1
                if (r6 != 0) goto L_0x002d
                int r0 = r0.f11557d
                r6 = 2
                if (r0 == r6) goto L_0x002d
                if (r0 == r7) goto L_0x002d
                long r8 = r10.X2
                long r8 = r8 + r4
                int r0 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r0 <= 0) goto L_0x002e
            L_0x002d:
                r1 = 1
            L_0x002e:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.playlist.DefaultHlsPlaylistTracker.MediaPlaylistBundle.k():boolean");
        }

        public void m() {
            o(this.s);
        }

        public void q() throws IOException {
            this.X.b();
            IOException iOException = this.c3;
            if (iOException != null) {
                throw iOException;
            }
        }

        /* renamed from: r */
        public void Z(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j3, boolean z) {
            ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
            LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f12583a, parsingLoadable2.f12584b, parsingLoadable.f(), parsingLoadable.d(), j2, j3, parsingLoadable.b());
            DefaultHlsPlaylistTracker.this.Y.b(parsingLoadable2.f12583a);
            DefaultHlsPlaylistTracker.this.Z2.p(loadEventInfo, 4);
        }

        /* renamed from: s */
        public void N(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j3) {
            ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
            HlsPlaylist e2 = parsingLoadable.e();
            LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f12583a, parsingLoadable2.f12584b, parsingLoadable.f(), parsingLoadable.d(), j2, j3, parsingLoadable.b());
            if (e2 instanceof HlsMediaPlaylist) {
                u((HlsMediaPlaylist) e2, loadEventInfo);
                DefaultHlsPlaylistTracker.this.Z2.s(loadEventInfo, 4);
            } else {
                this.c3 = ParserException.c("Loaded playlist has unexpected type.", (Throwable) null);
                DefaultHlsPlaylistTracker.this.Z2.w(loadEventInfo, 4, this.c3, true);
            }
            DefaultHlsPlaylistTracker.this.Y.b(parsingLoadable2.f12583a);
        }

        /* renamed from: t */
        public Loader.LoadErrorAction p(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j3, IOException iOException, int i2) {
            Loader.LoadErrorAction loadErrorAction;
            ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
            IOException iOException2 = iOException;
            LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f12583a, parsingLoadable2.f12584b, parsingLoadable.f(), parsingLoadable.d(), j2, j3, parsingLoadable.b());
            boolean z = iOException2 instanceof HlsPlaylistParser.DeltaUpdateException;
            if ((parsingLoadable.f().getQueryParameter(e3) != null) || z) {
                int i3 = iOException2 instanceof HttpDataSource.InvalidResponseCodeException ? ((HttpDataSource.InvalidResponseCodeException) iOException2).a3 : Integer.MAX_VALUE;
                if (z || i3 == 400 || i3 == 503) {
                    this.Z2 = SystemClock.elapsedRealtime();
                    m();
                    ((MediaSourceEventListener.EventDispatcher) Util.o(DefaultHlsPlaylistTracker.this.Z2)).w(loadEventInfo, parsingLoadable2.f12585c, iOException2, true);
                    return Loader.f12576k;
                }
            }
            LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo = new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(parsingLoadable2.f12585c), iOException2, i2);
            if (DefaultHlsPlaylistTracker.this.L(this.s, loadErrorInfo, false)) {
                long a2 = DefaultHlsPlaylistTracker.this.Y.a(loadErrorInfo);
                loadErrorAction = a2 != C.f9084b ? Loader.i(false, a2) : Loader.f12577l;
            } else {
                loadErrorAction = Loader.f12576k;
            }
            boolean z2 = !loadErrorAction.c();
            DefaultHlsPlaylistTracker.this.Z2.w(loadEventInfo, parsingLoadable2.f12585c, iOException2, z2);
            if (z2) {
                DefaultHlsPlaylistTracker.this.Y.b(parsingLoadable2.f12583a);
            }
            return loadErrorAction;
        }

        public void v() {
            this.X.l();
        }
    }

    public DefaultHlsPlaylistTracker(HlsDataSourceFactory hlsDataSourceFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistParserFactory hlsPlaylistParserFactory) {
        this(hlsDataSourceFactory, loadErrorHandlingPolicy, hlsPlaylistParserFactory, 3.5d);
    }

    private void C(List<Uri> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Uri uri = list.get(i2);
            this.Z.put(uri, new MediaPlaylistBundle(uri));
        }
    }

    private static HlsMediaPlaylist.Segment D(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        int i2 = (int) (hlsMediaPlaylist2.f11564k - hlsMediaPlaylist.f11564k);
        List<HlsMediaPlaylist.Segment> list = hlsMediaPlaylist.r;
        if (i2 < list.size()) {
            return list.get(i2);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public HlsMediaPlaylist E(@Nullable HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        if (!hlsMediaPlaylist2.f(hlsMediaPlaylist)) {
            return hlsMediaPlaylist2.o ? hlsMediaPlaylist.d() : hlsMediaPlaylist;
        }
        return hlsMediaPlaylist2.c(G(hlsMediaPlaylist, hlsMediaPlaylist2), F(hlsMediaPlaylist, hlsMediaPlaylist2));
    }

    private int F(@Nullable HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        HlsMediaPlaylist.Segment D;
        if (hlsMediaPlaylist2.f11562i) {
            return hlsMediaPlaylist2.f11563j;
        }
        HlsMediaPlaylist hlsMediaPlaylist3 = this.f3;
        int i2 = hlsMediaPlaylist3 != null ? hlsMediaPlaylist3.f11563j : 0;
        return (hlsMediaPlaylist == null || (D = D(hlsMediaPlaylist, hlsMediaPlaylist2)) == null) ? i2 : (hlsMediaPlaylist.f11563j + D.Z) - hlsMediaPlaylist2.r.get(0).Z;
    }

    private long G(@Nullable HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        if (hlsMediaPlaylist2.p) {
            return hlsMediaPlaylist2.f11561h;
        }
        HlsMediaPlaylist hlsMediaPlaylist3 = this.f3;
        long j2 = hlsMediaPlaylist3 != null ? hlsMediaPlaylist3.f11561h : 0;
        if (hlsMediaPlaylist == null) {
            return j2;
        }
        int size = hlsMediaPlaylist.r.size();
        HlsMediaPlaylist.Segment D = D(hlsMediaPlaylist, hlsMediaPlaylist2);
        if (D != null) {
            return hlsMediaPlaylist.f11561h + D.X2;
        }
        return ((long) size) == hlsMediaPlaylist2.f11564k - hlsMediaPlaylist.f11564k ? hlsMediaPlaylist.e() : j2;
    }

    private Uri H(Uri uri) {
        HlsMediaPlaylist.RenditionReport renditionReport;
        HlsMediaPlaylist hlsMediaPlaylist = this.f3;
        if (hlsMediaPlaylist == null || !hlsMediaPlaylist.v.f11575e || (renditionReport = hlsMediaPlaylist.t.get(uri)) == null) {
            return uri;
        }
        Uri.Builder buildUpon = uri.buildUpon();
        buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(renditionReport.f11569b));
        int i2 = renditionReport.f11570c;
        if (i2 != -1) {
            buildUpon.appendQueryParameter("_HLS_part", String.valueOf(i2));
        }
        return buildUpon.build();
    }

    private boolean I(Uri uri) {
        List<HlsMultivariantPlaylist.Variant> list = this.d3.f11578e;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (uri.equals(list.get(i2).f11591a)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean J() {
        List<HlsMultivariantPlaylist.Variant> list = this.d3.f11578e;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i2 = 0; i2 < size; i2++) {
            MediaPlaylistBundle mediaPlaylistBundle = (MediaPlaylistBundle) Assertions.g(this.Z.get(list.get(i2).f11591a));
            if (elapsedRealtime > mediaPlaylistBundle.a3) {
                Uri e2 = mediaPlaylistBundle.s;
                this.e3 = e2;
                mediaPlaylistBundle.o(H(e2));
                return true;
            }
        }
        return false;
    }

    private void K(Uri uri) {
        if (!uri.equals(this.e3) && I(uri)) {
            HlsMediaPlaylist hlsMediaPlaylist = this.f3;
            if (hlsMediaPlaylist == null || !hlsMediaPlaylist.o) {
                this.e3 = uri;
                MediaPlaylistBundle mediaPlaylistBundle = this.Z.get(uri);
                HlsMediaPlaylist g2 = mediaPlaylistBundle.Z;
                if (g2 == null || !g2.o) {
                    mediaPlaylistBundle.o(H(uri));
                    return;
                }
                this.f3 = g2;
                this.c3.s(g2);
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean L(Uri uri, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, boolean z) {
        Iterator<HlsPlaylistTracker.PlaylistEventListener> it2 = this.X2.iterator();
        boolean z2 = false;
        while (it2.hasNext()) {
            z2 |= !it2.next().d(uri, loadErrorInfo, z);
        }
        return z2;
    }

    /* access modifiers changed from: private */
    public void Q(Uri uri, HlsMediaPlaylist hlsMediaPlaylist) {
        if (uri.equals(this.e3)) {
            if (this.f3 == null) {
                this.g3 = !hlsMediaPlaylist.o;
                this.h3 = hlsMediaPlaylist.f11561h;
            }
            this.f3 = hlsMediaPlaylist;
            this.c3.s(hlsMediaPlaylist);
        }
        Iterator<HlsPlaylistTracker.PlaylistEventListener> it2 = this.X2.iterator();
        while (it2.hasNext()) {
            it2.next().b();
        }
    }

    /* renamed from: M */
    public void Z(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j4, boolean z) {
        ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f12583a, parsingLoadable2.f12584b, parsingLoadable.f(), parsingLoadable.d(), j2, j4, parsingLoadable.b());
        this.Y.b(parsingLoadable2.f12583a);
        this.Z2.p(loadEventInfo, 4);
    }

    /* renamed from: O */
    public void N(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j4) {
        ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
        HlsPlaylist e2 = parsingLoadable.e();
        boolean z = e2 instanceof HlsMediaPlaylist;
        HlsMultivariantPlaylist e4 = z ? HlsMultivariantPlaylist.e(e2.f11597a) : (HlsMultivariantPlaylist) e2;
        this.d3 = e4;
        this.e3 = e4.f11578e.get(0).f11591a;
        this.X2.add(new FirstPrimaryMediaPlaylistListener());
        C(e4.f11577d);
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f12583a, parsingLoadable2.f12584b, parsingLoadable.f(), parsingLoadable.d(), j2, j4, parsingLoadable.b());
        MediaPlaylistBundle mediaPlaylistBundle = this.Z.get(this.e3);
        if (z) {
            mediaPlaylistBundle.u((HlsMediaPlaylist) e2, loadEventInfo);
        } else {
            mediaPlaylistBundle.m();
        }
        this.Y.b(parsingLoadable2.f12583a);
        this.Z2.s(loadEventInfo, 4);
    }

    /* renamed from: P */
    public Loader.LoadErrorAction p(ParsingLoadable<HlsPlaylist> parsingLoadable, long j2, long j4, IOException iOException, int i2) {
        ParsingLoadable<HlsPlaylist> parsingLoadable2 = parsingLoadable;
        IOException iOException2 = iOException;
        LoadEventInfo loadEventInfo = new LoadEventInfo(parsingLoadable2.f12583a, parsingLoadable2.f12584b, parsingLoadable.f(), parsingLoadable.d(), j2, j4, parsingLoadable.b());
        long a2 = this.Y.a(new LoadErrorHandlingPolicy.LoadErrorInfo(loadEventInfo, new MediaLoadData(parsingLoadable2.f12585c), iOException2, i2));
        boolean z = a2 == C.f9084b;
        this.Z2.w(loadEventInfo, parsingLoadable2.f12585c, iOException2, z);
        if (z) {
            this.Y.b(parsingLoadable2.f12583a);
        }
        return z ? Loader.f12577l : Loader.i(false, a2);
    }

    public void a(Uri uri, MediaSourceEventListener.EventDispatcher eventDispatcher, HlsPlaylistTracker.PrimaryPlaylistListener primaryPlaylistListener) {
        this.b3 = Util.H();
        this.Z2 = eventDispatcher;
        this.c3 = primaryPlaylistListener;
        ParsingLoadable parsingLoadable = new ParsingLoadable(this.s.a(4), uri, 4, this.X.b());
        Assertions.i(this.a3 == null);
        Loader loader = new Loader("DefaultHlsPlaylistTracker:MultivariantPlaylist");
        this.a3 = loader;
        eventDispatcher.y(new LoadEventInfo(parsingLoadable.f12583a, parsingLoadable.f12584b, loader.n(parsingLoadable, this, this.Y.c(parsingLoadable.f12585c))), parsingLoadable.f12585c);
    }

    public boolean b(Uri uri) {
        return this.Z.get(uri).k();
    }

    public void c(Uri uri) throws IOException {
        this.Z.get(uri).q();
    }

    public void d(HlsPlaylistTracker.PlaylistEventListener playlistEventListener) {
        this.X2.remove(playlistEventListener);
    }

    public void e(HlsPlaylistTracker.PlaylistEventListener playlistEventListener) {
        Assertions.g(playlistEventListener);
        this.X2.add(playlistEventListener);
    }

    public long f() {
        return this.h3;
    }

    public boolean g() {
        return this.g3;
    }

    @Nullable
    public HlsMultivariantPlaylist h() {
        return this.d3;
    }

    public boolean i(Uri uri, long j2) {
        MediaPlaylistBundle mediaPlaylistBundle = this.Z.get(uri);
        if (mediaPlaylistBundle != null) {
            return !mediaPlaylistBundle.h(j2);
        }
        return false;
    }

    public void j() throws IOException {
        Loader loader = this.a3;
        if (loader != null) {
            loader.b();
        }
        Uri uri = this.e3;
        if (uri != null) {
            c(uri);
        }
    }

    public void k(Uri uri) {
        this.Z.get(uri).m();
    }

    @Nullable
    public HlsMediaPlaylist l(Uri uri, boolean z) {
        HlsMediaPlaylist j2 = this.Z.get(uri).j();
        if (j2 != null && z) {
            K(uri);
        }
        return j2;
    }

    public void stop() {
        this.e3 = null;
        this.f3 = null;
        this.d3 = null;
        this.h3 = C.f9084b;
        this.a3.l();
        this.a3 = null;
        for (MediaPlaylistBundle v : this.Z.values()) {
            v.v();
        }
        this.b3.removeCallbacksAndMessages((Object) null);
        this.b3 = null;
        this.Z.clear();
    }

    public DefaultHlsPlaylistTracker(HlsDataSourceFactory hlsDataSourceFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistParserFactory hlsPlaylistParserFactory, double d2) {
        this.s = hlsDataSourceFactory;
        this.X = hlsPlaylistParserFactory;
        this.Y = loadErrorHandlingPolicy;
        this.Y2 = d2;
        this.X2 = new CopyOnWriteArrayList<>();
        this.Z = new HashMap<>();
        this.h3 = C.f9084b;
    }
}
