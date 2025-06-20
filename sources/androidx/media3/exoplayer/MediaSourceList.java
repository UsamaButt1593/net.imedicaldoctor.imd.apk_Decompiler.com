package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.C0296j;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MaskingMediaPeriod;
import androidx.media3.exoplayer.source.MaskingMediaSource;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.ShuffleOrder;
import androidx.media3.exoplayer.upstream.Allocator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class MediaSourceList {

    /* renamed from: m  reason: collision with root package name */
    private static final String f10272m = "MediaSourceList";

    /* renamed from: a  reason: collision with root package name */
    private final PlayerId f10273a;

    /* renamed from: b  reason: collision with root package name */
    private final List<MediaSourceHolder> f10274b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final IdentityHashMap<MediaPeriod, MediaSourceHolder> f10275c = new IdentityHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private final Map<Object, MediaSourceHolder> f10276d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final MediaSourceListInfoRefreshListener f10277e;

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<MediaSourceHolder, MediaSourceAndListener> f10278f;

    /* renamed from: g  reason: collision with root package name */
    private final Set<MediaSourceHolder> f10279g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final AnalyticsCollector f10280h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final HandlerWrapper f10281i;

    /* renamed from: j  reason: collision with root package name */
    private ShuffleOrder f10282j = new ShuffleOrder.DefaultShuffleOrder(0);

    /* renamed from: k  reason: collision with root package name */
    private boolean f10283k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private TransferListener f10284l;

    private final class ForwardingEventListener implements MediaSourceEventListener, DrmSessionEventListener {
        private final MediaSourceHolder s;

        public ForwardingEventListener(MediaSourceHolder mediaSourceHolder) {
            this.s = mediaSourceHolder;
        }

        @Nullable
        private Pair<Integer, MediaSource.MediaPeriodId> K(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            MediaSource.MediaPeriodId mediaPeriodId2 = null;
            if (mediaPeriodId != null) {
                MediaSource.MediaPeriodId c2 = MediaSourceList.o(this.s, mediaPeriodId);
                if (c2 == null) {
                    return null;
                }
                mediaPeriodId2 = c2;
            }
            return Pair.create(Integer.valueOf(MediaSourceList.t(this.s, i2)), mediaPeriodId2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void L(Pair pair, MediaLoadData mediaLoadData) {
            MediaSourceList.this.f10280h.Q(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void M(Pair pair) {
            MediaSourceList.this.f10280h.c0(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void N(Pair pair) {
            MediaSourceList.this.f10280h.v0(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void P(Pair pair) {
            MediaSourceList.this.f10280h.R(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void S(Pair pair, int i2) {
            MediaSourceList.this.f10280h.o0(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, i2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void U(Pair pair, Exception exc) {
            MediaSourceList.this.f10280h.w0(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, exc);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void W(Pair pair) {
            MediaSourceList.this.f10280h.m0(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void X(Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            MediaSourceList.this.f10280h.x0(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void Y(Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            MediaSourceList.this.f10280h.O(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void Z(Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
            MediaSourceList.this.f10280h.q0(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData, iOException, z);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a0(Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            MediaSourceList.this.f10280h.V(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b0(Pair pair, MediaLoadData mediaLoadData) {
            MediaSourceList.this.f10280h.A(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) Assertions.g((MediaSource.MediaPeriodId) pair.second), mediaLoadData);
        }

        public void A(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            Pair<Integer, MediaSource.MediaPeriodId> K = K(i2, mediaPeriodId);
            if (K != null) {
                MediaSourceList.this.f10281i.e(new I0(this, K, mediaLoadData));
            }
        }

        public void O(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Pair<Integer, MediaSource.MediaPeriodId> K = K(i2, mediaPeriodId);
            if (K != null) {
                MediaSourceList.this.f10281i.e(new S0(this, K, loadEventInfo, mediaLoadData));
            }
        }

        public void Q(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            Pair<Integer, MediaSource.MediaPeriodId> K = K(i2, mediaPeriodId);
            if (K != null) {
                MediaSourceList.this.f10281i.e(new P0(this, K, mediaLoadData));
            }
        }

        public void R(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            Pair<Integer, MediaSource.MediaPeriodId> K = K(i2, mediaPeriodId);
            if (K != null) {
                MediaSourceList.this.f10281i.e(new Q0(this, K));
            }
        }

        public void V(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Pair<Integer, MediaSource.MediaPeriodId> K = K(i2, mediaPeriodId);
            if (K != null) {
                MediaSourceList.this.f10281i.e(new O0(this, K, loadEventInfo, mediaLoadData));
            }
        }

        public void c0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            Pair<Integer, MediaSource.MediaPeriodId> K = K(i2, mediaPeriodId);
            if (K != null) {
                MediaSourceList.this.f10281i.e(new J0(this, K));
            }
        }

        public void m0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            Pair<Integer, MediaSource.MediaPeriodId> K = K(i2, mediaPeriodId);
            if (K != null) {
                MediaSourceList.this.f10281i.e(new R0(this, K));
            }
        }

        public void o0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, int i3) {
            Pair<Integer, MediaSource.MediaPeriodId> K = K(i2, mediaPeriodId);
            if (K != null) {
                MediaSourceList.this.f10281i.e(new T0(this, K, i3));
            }
        }

        public void q0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
            Pair<Integer, MediaSource.MediaPeriodId> K = K(i2, mediaPeriodId);
            if (K != null) {
                MediaSourceList.this.f10281i.e(new K0(this, K, loadEventInfo, mediaLoadData, iOException, z));
            }
        }

        public /* synthetic */ void r0(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            C0296j.d(this, i2, mediaPeriodId);
        }

        public void v0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            Pair<Integer, MediaSource.MediaPeriodId> K = K(i2, mediaPeriodId);
            if (K != null) {
                MediaSourceList.this.f10281i.e(new M0(this, K));
            }
        }

        public void w0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
            Pair<Integer, MediaSource.MediaPeriodId> K = K(i2, mediaPeriodId);
            if (K != null) {
                MediaSourceList.this.f10281i.e(new N0(this, K, exc));
            }
        }

        public void x0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Pair<Integer, MediaSource.MediaPeriodId> K = K(i2, mediaPeriodId);
            if (K != null) {
                MediaSourceList.this.f10281i.e(new L0(this, K, loadEventInfo, mediaLoadData));
            }
        }
    }

    private static final class MediaSourceAndListener {

        /* renamed from: a  reason: collision with root package name */
        public final MediaSource f10285a;

        /* renamed from: b  reason: collision with root package name */
        public final MediaSource.MediaSourceCaller f10286b;

        /* renamed from: c  reason: collision with root package name */
        public final ForwardingEventListener f10287c;

        public MediaSourceAndListener(MediaSource mediaSource, MediaSource.MediaSourceCaller mediaSourceCaller, ForwardingEventListener forwardingEventListener) {
            this.f10285a = mediaSource;
            this.f10286b = mediaSourceCaller;
            this.f10287c = forwardingEventListener;
        }
    }

    static final class MediaSourceHolder implements MediaSourceInfoHolder {

        /* renamed from: a  reason: collision with root package name */
        public final MaskingMediaSource f10288a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f10289b = new Object();

        /* renamed from: c  reason: collision with root package name */
        public final List<MediaSource.MediaPeriodId> f10290c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        public int f10291d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f10292e;

        public MediaSourceHolder(MediaSource mediaSource, boolean z) {
            this.f10288a = new MaskingMediaSource(mediaSource, z);
        }

        public Timeline a() {
            return this.f10288a.Z0();
        }

        public Object b() {
            return this.f10289b;
        }

        public void c(int i2) {
            this.f10291d = i2;
            this.f10292e = false;
            this.f10290c.clear();
        }
    }

    public interface MediaSourceListInfoRefreshListener {
        void d();
    }

    public MediaSourceList(MediaSourceListInfoRefreshListener mediaSourceListInfoRefreshListener, AnalyticsCollector analyticsCollector, HandlerWrapper handlerWrapper, PlayerId playerId) {
        this.f10273a = playerId;
        this.f10277e = mediaSourceListInfoRefreshListener;
        this.f10280h = analyticsCollector;
        this.f10281i = handlerWrapper;
        this.f10278f = new HashMap<>();
        this.f10279g = new HashSet();
    }

    private void A(MediaSourceHolder mediaSourceHolder) {
        MaskingMediaSource maskingMediaSource = mediaSourceHolder.f10288a;
        H0 h0 = new H0(this);
        ForwardingEventListener forwardingEventListener = new ForwardingEventListener(mediaSourceHolder);
        this.f10278f.put(mediaSourceHolder, new MediaSourceAndListener(maskingMediaSource, h0, forwardingEventListener));
        maskingMediaSource.c(Util.J(), forwardingEventListener);
        maskingMediaSource.P(Util.J(), forwardingEventListener);
        maskingMediaSource.Y(h0, this.f10284l, this.f10273a);
    }

    private void E(int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            MediaSourceHolder remove = this.f10274b.remove(i4);
            this.f10276d.remove(remove.f10289b);
            h(i4, -remove.f10288a.Z0().w());
            remove.f10292e = true;
            if (this.f10283k) {
                w(remove);
            }
        }
    }

    private void h(int i2, int i3) {
        while (i2 < this.f10274b.size()) {
            this.f10274b.get(i2).f10291d += i3;
            i2++;
        }
    }

    private void k(MediaSourceHolder mediaSourceHolder) {
        MediaSourceAndListener mediaSourceAndListener = this.f10278f.get(mediaSourceHolder);
        if (mediaSourceAndListener != null) {
            mediaSourceAndListener.f10285a.D(mediaSourceAndListener.f10286b);
        }
    }

    private void l() {
        Iterator<MediaSourceHolder> it2 = this.f10279g.iterator();
        while (it2.hasNext()) {
            MediaSourceHolder next = it2.next();
            if (next.f10290c.isEmpty()) {
                k(next);
                it2.remove();
            }
        }
    }

    private void m(MediaSourceHolder mediaSourceHolder) {
        this.f10279g.add(mediaSourceHolder);
        MediaSourceAndListener mediaSourceAndListener = this.f10278f.get(mediaSourceHolder);
        if (mediaSourceAndListener != null) {
            mediaSourceAndListener.f10285a.e(mediaSourceAndListener.f10286b);
        }
    }

    private static Object n(Object obj) {
        return AbstractConcatenatedTimeline.C(obj);
    }

    /* access modifiers changed from: private */
    @Nullable
    public static MediaSource.MediaPeriodId o(MediaSourceHolder mediaSourceHolder, MediaSource.MediaPeriodId mediaPeriodId) {
        for (int i2 = 0; i2 < mediaSourceHolder.f10290c.size(); i2++) {
            if (mediaSourceHolder.f10290c.get(i2).f12166d == mediaPeriodId.f12166d) {
                return mediaPeriodId.a(q(mediaSourceHolder, mediaPeriodId.f12163a));
            }
        }
        return null;
    }

    private static Object p(Object obj) {
        return AbstractConcatenatedTimeline.D(obj);
    }

    private static Object q(MediaSourceHolder mediaSourceHolder, Object obj) {
        return AbstractConcatenatedTimeline.F(mediaSourceHolder.f10289b, obj);
    }

    /* access modifiers changed from: private */
    public static int t(MediaSourceHolder mediaSourceHolder, int i2) {
        return i2 + mediaSourceHolder.f10291d;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v(MediaSource mediaSource, Timeline timeline) {
        this.f10277e.d();
    }

    private void w(MediaSourceHolder mediaSourceHolder) {
        if (mediaSourceHolder.f10292e && mediaSourceHolder.f10290c.isEmpty()) {
            MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) Assertions.g(this.f10278f.remove(mediaSourceHolder));
            mediaSourceAndListener.f10285a.x(mediaSourceAndListener.f10286b);
            mediaSourceAndListener.f10285a.q(mediaSourceAndListener.f10287c);
            mediaSourceAndListener.f10285a.U(mediaSourceAndListener.f10287c);
            this.f10279g.remove(mediaSourceHolder);
        }
    }

    public void B() {
        for (MediaSourceAndListener next : this.f10278f.values()) {
            try {
                next.f10285a.x(next.f10286b);
            } catch (RuntimeException e2) {
                Log.e(f10272m, "Failed to release child source.", e2);
            }
            next.f10285a.q(next.f10287c);
            next.f10285a.U(next.f10287c);
        }
        this.f10278f.clear();
        this.f10279g.clear();
        this.f10283k = false;
    }

    public void C(MediaPeriod mediaPeriod) {
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) Assertions.g(this.f10275c.remove(mediaPeriod));
        mediaSourceHolder.f10288a.X(mediaPeriod);
        mediaSourceHolder.f10290c.remove(((MaskingMediaPeriod) mediaPeriod).s);
        if (!this.f10275c.isEmpty()) {
            l();
        }
        w(mediaSourceHolder);
    }

    public Timeline D(int i2, int i3, ShuffleOrder shuffleOrder) {
        Assertions.a(i2 >= 0 && i2 <= i3 && i3 <= s());
        this.f10282j = shuffleOrder;
        E(i2, i3);
        return j();
    }

    public Timeline F(List<MediaSourceHolder> list, ShuffleOrder shuffleOrder) {
        E(0, this.f10274b.size());
        return f(this.f10274b.size(), list, shuffleOrder);
    }

    public Timeline G(ShuffleOrder shuffleOrder) {
        int s = s();
        if (shuffleOrder.getLength() != s) {
            shuffleOrder = shuffleOrder.g().e(0, s);
        }
        this.f10282j = shuffleOrder;
        return j();
    }

    public Timeline H(int i2, int i3, List<MediaItem> list) {
        boolean z = false;
        Assertions.a(i2 >= 0 && i2 <= i3 && i3 <= s());
        if (list.size() == i3 - i2) {
            z = true;
        }
        Assertions.a(z);
        for (int i4 = i2; i4 < i3; i4++) {
            this.f10274b.get(i4).f10288a.k(list.get(i4 - i2));
        }
        return j();
    }

    public Timeline f(int i2, List<MediaSourceHolder> list, ShuffleOrder shuffleOrder) {
        int i3;
        if (!list.isEmpty()) {
            this.f10282j = shuffleOrder;
            for (int i4 = i2; i4 < list.size() + i2; i4++) {
                MediaSourceHolder mediaSourceHolder = list.get(i4 - i2);
                if (i4 > 0) {
                    MediaSourceHolder mediaSourceHolder2 = this.f10274b.get(i4 - 1);
                    i3 = mediaSourceHolder2.f10291d + mediaSourceHolder2.f10288a.Z0().w();
                } else {
                    i3 = 0;
                }
                mediaSourceHolder.c(i3);
                h(i4, mediaSourceHolder.f10288a.Z0().w());
                this.f10274b.add(i4, mediaSourceHolder);
                this.f10276d.put(mediaSourceHolder.f10289b, mediaSourceHolder);
                if (this.f10283k) {
                    A(mediaSourceHolder);
                    if (this.f10275c.isEmpty()) {
                        this.f10279g.add(mediaSourceHolder);
                    } else {
                        k(mediaSourceHolder);
                    }
                }
            }
        }
        return j();
    }

    public Timeline g(@Nullable ShuffleOrder shuffleOrder) {
        if (shuffleOrder == null) {
            shuffleOrder = this.f10282j.g();
        }
        this.f10282j = shuffleOrder;
        E(0, s());
        return j();
    }

    public MediaPeriod i(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        Object p = p(mediaPeriodId.f12163a);
        MediaSource.MediaPeriodId a2 = mediaPeriodId.a(n(mediaPeriodId.f12163a));
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) Assertions.g(this.f10276d.get(p));
        m(mediaSourceHolder);
        mediaSourceHolder.f10290c.add(a2);
        MaskingMediaPeriod W0 = mediaSourceHolder.f10288a.E(a2, allocator, j2);
        this.f10275c.put(W0, mediaSourceHolder);
        l();
        return W0;
    }

    public Timeline j() {
        if (this.f10274b.isEmpty()) {
            return Timeline.s;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f10274b.size(); i3++) {
            MediaSourceHolder mediaSourceHolder = this.f10274b.get(i3);
            mediaSourceHolder.f10291d = i2;
            i2 += mediaSourceHolder.f10288a.Z0().w();
        }
        return new PlaylistTimeline(this.f10274b, this.f10282j);
    }

    public ShuffleOrder r() {
        return this.f10282j;
    }

    public int s() {
        return this.f10274b.size();
    }

    public boolean u() {
        return this.f10283k;
    }

    public Timeline x(int i2, int i3, ShuffleOrder shuffleOrder) {
        return y(i2, i2 + 1, i3, shuffleOrder);
    }

    public Timeline y(int i2, int i3, int i4, ShuffleOrder shuffleOrder) {
        Assertions.a(i2 >= 0 && i2 <= i3 && i3 <= s() && i4 >= 0);
        this.f10282j = shuffleOrder;
        if (i2 == i3 || i2 == i4) {
            return j();
        }
        int min = Math.min(i2, i4);
        int max = Math.max(((i3 - i2) + i4) - 1, i3 - 1);
        int i5 = this.f10274b.get(min).f10291d;
        Util.H1(this.f10274b, i2, i3, i4);
        while (min <= max) {
            MediaSourceHolder mediaSourceHolder = this.f10274b.get(min);
            mediaSourceHolder.f10291d = i5;
            i5 += mediaSourceHolder.f10288a.Z0().w();
            min++;
        }
        return j();
    }

    public void z(@Nullable TransferListener transferListener) {
        Assertions.i(!this.f10283k);
        this.f10284l = transferListener;
        for (int i2 = 0; i2 < this.f10274b.size(); i2++) {
            MediaSourceHolder mediaSourceHolder = this.f10274b.get(i2);
            A(mediaSourceHolder);
            this.f10279g.add(mediaSourceHolder);
        }
        this.f10283k = true;
    }
}
