package androidx.media3.exoplayer.source;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.AbstractConcatenatedTimeline;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ShuffleOrder;
import androidx.media3.exoplayer.upstream.Allocator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@UnstableApi
@Deprecated
public final class ConcatenatingMediaSource extends CompositeMediaSource<MediaSourceHolder> {
    private static final int p3 = 0;
    private static final int q3 = 1;
    private static final int r3 = 2;
    private static final int s3 = 3;
    private static final int t3 = 4;
    private static final int u3 = 5;
    /* access modifiers changed from: private */
    public static final MediaItem v3 = new MediaItem.Builder().M(Uri.EMPTY).a();
    @GuardedBy("this")
    private final List<MediaSourceHolder> d3;
    @GuardedBy("this")
    private final Set<HandlerAndRunnable> e3;
    @GuardedBy("this")
    @Nullable
    private Handler f3;
    private final List<MediaSourceHolder> g3;
    private final IdentityHashMap<MediaPeriod, MediaSourceHolder> h3;
    private final Map<Object, MediaSourceHolder> i3;
    private final Set<MediaSourceHolder> j3;
    private final boolean k3;
    private final boolean l3;
    private boolean m3;
    private Set<HandlerAndRunnable> n3;
    private ShuffleOrder o3;

    private static final class ConcatenatedTimeline extends AbstractConcatenatedTimeline {
        private final int b3;
        private final int c3;
        private final int[] d3;
        private final int[] e3;
        private final Timeline[] f3;
        private final Object[] g3;
        private final HashMap<Object, Integer> h3 = new HashMap<>();

        public ConcatenatedTimeline(Collection<MediaSourceHolder> collection, ShuffleOrder shuffleOrder, boolean z) {
            super(z, shuffleOrder);
            int size = collection.size();
            this.d3 = new int[size];
            this.e3 = new int[size];
            this.f3 = new Timeline[size];
            this.g3 = new Object[size];
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            for (MediaSourceHolder next : collection) {
                this.f3[i4] = next.f12091a.Z0();
                this.e3[i4] = i2;
                this.d3[i4] = i3;
                i2 += this.f3[i4].w();
                i3 += this.f3[i4].n();
                Object[] objArr = this.g3;
                Object obj = next.f12092b;
                objArr[i4] = obj;
                this.h3.put(obj, Integer.valueOf(i4));
                i4++;
            }
            this.b3 = i2;
            this.c3 = i3;
        }

        /* access modifiers changed from: protected */
        public int A(int i2) {
            return Util.m(this.d3, i2 + 1, false, false);
        }

        /* access modifiers changed from: protected */
        public int B(int i2) {
            return Util.m(this.e3, i2 + 1, false, false);
        }

        /* access modifiers changed from: protected */
        public Object E(int i2) {
            return this.g3[i2];
        }

        /* access modifiers changed from: protected */
        public int G(int i2) {
            return this.d3[i2];
        }

        /* access modifiers changed from: protected */
        public int H(int i2) {
            return this.e3[i2];
        }

        /* access modifiers changed from: protected */
        public Timeline K(int i2) {
            return this.f3[i2];
        }

        public int n() {
            return this.c3;
        }

        public int w() {
            return this.b3;
        }

        /* access modifiers changed from: protected */
        public int z(Object obj) {
            Integer num = this.h3.get(obj);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }
    }

    private static final class FakeMediaSource extends BaseMediaSource {
        private FakeMediaSource() {
        }

        public MediaPeriod E(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
            throw new UnsupportedOperationException();
        }

        public MediaItem H() {
            return ConcatenatingMediaSource.v3;
        }

        public void I() {
        }

        public void X(MediaPeriod mediaPeriod) {
        }

        /* access modifiers changed from: protected */
        public void s0(@Nullable TransferListener transferListener) {
        }

        /* access modifiers changed from: protected */
        public void u0() {
        }
    }

    private static final class HandlerAndRunnable {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f12089a;

        /* renamed from: b  reason: collision with root package name */
        private final Runnable f12090b;

        public HandlerAndRunnable(Handler handler, Runnable runnable) {
            this.f12089a = handler;
            this.f12090b = runnable;
        }

        public void a() {
            this.f12089a.post(this.f12090b);
        }
    }

    static final class MediaSourceHolder {

        /* renamed from: a  reason: collision with root package name */
        public final MaskingMediaSource f12091a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f12092b = new Object();

        /* renamed from: c  reason: collision with root package name */
        public final List<MediaSource.MediaPeriodId> f12093c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        public int f12094d;

        /* renamed from: e  reason: collision with root package name */
        public int f12095e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f12096f;

        public MediaSourceHolder(MediaSource mediaSource, boolean z) {
            this.f12091a = new MaskingMediaSource(mediaSource, z);
        }

        public void a(int i2, int i3) {
            this.f12094d = i2;
            this.f12095e = i3;
            this.f12096f = false;
            this.f12093c.clear();
        }
    }

    private static final class MessageData<T> {

        /* renamed from: a  reason: collision with root package name */
        public final int f12097a;

        /* renamed from: b  reason: collision with root package name */
        public final T f12098b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public final HandlerAndRunnable f12099c;

        public MessageData(int i2, T t, @Nullable HandlerAndRunnable handlerAndRunnable) {
            this.f12097a = i2;
            this.f12098b = t;
            this.f12099c = handlerAndRunnable;
        }
    }

    public ConcatenatingMediaSource(boolean z, ShuffleOrder shuffleOrder, MediaSource... mediaSourceArr) {
        this(z, false, shuffleOrder, mediaSourceArr);
    }

    @GuardedBy("this")
    private void A1(ShuffleOrder shuffleOrder, @Nullable Handler handler, @Nullable Runnable runnable) {
        boolean z = true;
        if ((handler == null) != (runnable == null)) {
            z = false;
        }
        Assertions.a(z);
        Handler handler2 = this.f3;
        if (handler2 != null) {
            int j1 = j1();
            if (shuffleOrder.getLength() != j1) {
                shuffleOrder = shuffleOrder.g().e(0, j1);
            }
            handler2.obtainMessage(3, new MessageData(0, shuffleOrder, Z0(handler, runnable))).sendToTarget();
            return;
        }
        if (shuffleOrder.getLength() > 0) {
            shuffleOrder = shuffleOrder.g();
        }
        this.o3 = shuffleOrder;
        if (runnable != null && handler != null) {
            handler.post(runnable);
        }
    }

    private void D1(MediaSourceHolder mediaSourceHolder, Timeline timeline) {
        int w;
        if (mediaSourceHolder.f12094d + 1 < this.g3.size() && (w = timeline.w() - (this.g3.get(mediaSourceHolder.f12094d + 1).f12095e - mediaSourceHolder.f12095e)) != 0) {
            Y0(mediaSourceHolder.f12094d + 1, 0, w);
        }
        y1();
    }

    private void E1() {
        this.m3 = false;
        Set<HandlerAndRunnable> set = this.n3;
        this.n3 = new HashSet();
        t0(new ConcatenatedTimeline(this.g3, this.o3, this.k3));
        i1().obtainMessage(5, set).sendToTarget();
    }

    private void P0(int i2, MediaSourceHolder mediaSourceHolder) {
        int i4;
        if (i2 > 0) {
            MediaSourceHolder mediaSourceHolder2 = this.g3.get(i2 - 1);
            i4 = mediaSourceHolder2.f12095e + mediaSourceHolder2.f12091a.Z0().w();
        } else {
            i4 = 0;
        }
        mediaSourceHolder.a(i2, i4);
        Y0(i2, 1, mediaSourceHolder.f12091a.Z0().w());
        this.g3.add(i2, mediaSourceHolder);
        this.i3.put(mediaSourceHolder.f12092b, mediaSourceHolder);
        H0(mediaSourceHolder, mediaSourceHolder.f12091a);
        if (!l0() || !this.h3.isEmpty()) {
            A0(mediaSourceHolder);
        } else {
            this.j3.add(mediaSourceHolder);
        }
    }

    private void U0(int i2, Collection<MediaSourceHolder> collection) {
        for (MediaSourceHolder P0 : collection) {
            P0(i2, P0);
            i2++;
        }
    }

    @GuardedBy("this")
    private void V0(int i2, Collection<MediaSource> collection, @Nullable Handler handler, @Nullable Runnable runnable) {
        boolean z = true;
        if ((handler == null) != (runnable == null)) {
            z = false;
        }
        Assertions.a(z);
        Handler handler2 = this.f3;
        for (MediaSource g2 : collection) {
            Assertions.g(g2);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (MediaSource mediaSourceHolder : collection) {
            arrayList.add(new MediaSourceHolder(mediaSourceHolder, this.l3));
        }
        this.d3.addAll(i2, arrayList);
        if (handler2 != null && !collection.isEmpty()) {
            handler2.obtainMessage(0, new MessageData(i2, arrayList, Z0(handler, runnable))).sendToTarget();
        } else if (runnable != null && handler != null) {
            handler.post(runnable);
        }
    }

    private void Y0(int i2, int i4, int i5) {
        while (i2 < this.g3.size()) {
            MediaSourceHolder mediaSourceHolder = this.g3.get(i2);
            mediaSourceHolder.f12094d += i4;
            mediaSourceHolder.f12095e += i5;
            i2++;
        }
    }

    @GuardedBy("this")
    @Nullable
    private HandlerAndRunnable Z0(@Nullable Handler handler, @Nullable Runnable runnable) {
        if (handler == null || runnable == null) {
            return null;
        }
        HandlerAndRunnable handlerAndRunnable = new HandlerAndRunnable(handler, runnable);
        this.e3.add(handlerAndRunnable);
        return handlerAndRunnable;
    }

    private void a1() {
        Iterator<MediaSourceHolder> it2 = this.j3.iterator();
        while (it2.hasNext()) {
            MediaSourceHolder next = it2.next();
            if (next.f12093c.isEmpty()) {
                A0(next);
                it2.remove();
            }
        }
    }

    private synchronized void b1(Set<HandlerAndRunnable> set) {
        try {
            for (HandlerAndRunnable a2 : set) {
                a2.a();
            }
            this.e3.removeAll(set);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    private void c1(MediaSourceHolder mediaSourceHolder) {
        this.j3.add(mediaSourceHolder);
        B0(mediaSourceHolder);
    }

    private static Object d1(Object obj) {
        return AbstractConcatenatedTimeline.C(obj);
    }

    private static Object g1(Object obj) {
        return AbstractConcatenatedTimeline.D(obj);
    }

    private static Object h1(MediaSourceHolder mediaSourceHolder, Object obj) {
        return AbstractConcatenatedTimeline.F(mediaSourceHolder.f12092b, obj);
    }

    private Handler i1() {
        return (Handler) Assertions.g(this.f3);
    }

    /* access modifiers changed from: private */
    public boolean l1(Message message) {
        MessageData messageData;
        int i2 = message.what;
        if (i2 == 0) {
            messageData = (MessageData) Util.o(message.obj);
            this.o3 = this.o3.e(messageData.f12097a, ((Collection) messageData.f12098b).size());
            U0(messageData.f12097a, (Collection) messageData.f12098b);
        } else if (i2 == 1) {
            messageData = (MessageData) Util.o(message.obj);
            int i4 = messageData.f12097a;
            int intValue = ((Integer) messageData.f12098b).intValue();
            this.o3 = (i4 == 0 && intValue == this.o3.getLength()) ? this.o3.g() : this.o3.a(i4, intValue);
            for (int i5 = intValue - 1; i5 >= i4; i5--) {
                u1(i5);
            }
        } else if (i2 == 2) {
            messageData = (MessageData) Util.o(message.obj);
            ShuffleOrder shuffleOrder = this.o3;
            int i6 = messageData.f12097a;
            ShuffleOrder a2 = shuffleOrder.a(i6, i6 + 1);
            this.o3 = a2;
            this.o3 = a2.e(((Integer) messageData.f12098b).intValue(), 1);
            p1(messageData.f12097a, ((Integer) messageData.f12098b).intValue());
        } else if (i2 != 3) {
            if (i2 == 4) {
                E1();
            } else if (i2 == 5) {
                b1((Set) Util.o(message.obj));
            } else {
                throw new IllegalStateException();
            }
            return true;
        } else {
            messageData = (MessageData) Util.o(message.obj);
            this.o3 = (ShuffleOrder) messageData.f12098b;
        }
        z1(messageData.f12099c);
        return true;
    }

    private void m1(MediaSourceHolder mediaSourceHolder) {
        if (mediaSourceHolder.f12096f && mediaSourceHolder.f12093c.isEmpty()) {
            this.j3.remove(mediaSourceHolder);
            I0(mediaSourceHolder);
        }
    }

    private void p1(int i2, int i4) {
        int min = Math.min(i2, i4);
        int max = Math.max(i2, i4);
        int i5 = this.g3.get(min).f12095e;
        List<MediaSourceHolder> list = this.g3;
        list.add(i4, list.remove(i2));
        while (min <= max) {
            MediaSourceHolder mediaSourceHolder = this.g3.get(min);
            mediaSourceHolder.f12094d = min;
            mediaSourceHolder.f12095e = i5;
            i5 += mediaSourceHolder.f12091a.Z0().w();
            min++;
        }
    }

    @GuardedBy("this")
    private void q1(int i2, int i4, @Nullable Handler handler, @Nullable Runnable runnable) {
        boolean z = false;
        if ((handler == null) == (runnable == null)) {
            z = true;
        }
        Assertions.a(z);
        Handler handler2 = this.f3;
        List<MediaSourceHolder> list = this.d3;
        list.add(i4, list.remove(i2));
        if (handler2 != null) {
            handler2.obtainMessage(2, new MessageData(i2, Integer.valueOf(i4), Z0(handler, runnable))).sendToTarget();
        } else if (runnable != null && handler != null) {
            handler.post(runnable);
        }
    }

    private void u1(int i2) {
        MediaSourceHolder remove = this.g3.remove(i2);
        this.i3.remove(remove.f12092b);
        Y0(i2, -1, -remove.f12091a.Z0().w());
        remove.f12096f = true;
        m1(remove);
    }

    @GuardedBy("this")
    private void x1(int i2, int i4, @Nullable Handler handler, @Nullable Runnable runnable) {
        boolean z = false;
        if ((handler == null) == (runnable == null)) {
            z = true;
        }
        Assertions.a(z);
        Handler handler2 = this.f3;
        Util.Y1(this.d3, i2, i4);
        if (handler2 != null) {
            handler2.obtainMessage(1, new MessageData(i2, Integer.valueOf(i4), Z0(handler, runnable))).sendToTarget();
        } else if (runnable != null && handler != null) {
            handler.post(runnable);
        }
    }

    private void y1() {
        z1((HandlerAndRunnable) null);
    }

    private void z1(@Nullable HandlerAndRunnable handlerAndRunnable) {
        if (!this.m3) {
            i1().obtainMessage(4).sendToTarget();
            this.m3 = true;
        }
        if (handlerAndRunnable != null) {
            this.n3.add(handlerAndRunnable);
        }
    }

    public synchronized void B1(ShuffleOrder shuffleOrder) {
        A1(shuffleOrder, (Handler) null, (Runnable) null);
    }

    public synchronized void C1(ShuffleOrder shuffleOrder, Handler handler, Runnable runnable) {
        A1(shuffleOrder, handler, runnable);
    }

    public MediaPeriod E(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        Object g1 = g1(mediaPeriodId.f12163a);
        MediaSource.MediaPeriodId a2 = mediaPeriodId.a(d1(mediaPeriodId.f12163a));
        MediaSourceHolder mediaSourceHolder = this.i3.get(g1);
        if (mediaSourceHolder == null) {
            mediaSourceHolder = new MediaSourceHolder(new FakeMediaSource(), this.l3);
            mediaSourceHolder.f12096f = true;
            H0(mediaSourceHolder, mediaSourceHolder.f12091a);
        }
        c1(mediaSourceHolder);
        mediaSourceHolder.f12093c.add(a2);
        MaskingMediaPeriod W0 = mediaSourceHolder.f12091a.E(a2, allocator, j2);
        this.h3.put(W0, mediaSourceHolder);
        a1();
        return W0;
    }

    public MediaItem H() {
        return v3;
    }

    public boolean K() {
        return false;
    }

    public synchronized Timeline L() {
        try {
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return new ConcatenatedTimeline(this.d3, this.o3.getLength() != this.d3.size() ? this.o3.g().e(0, this.d3.size()) : this.o3, this.k3);
    }

    public synchronized void L0(int i2, MediaSource mediaSource) {
        V0(i2, Collections.singletonList(mediaSource), (Handler) null, (Runnable) null);
    }

    public synchronized void M0(int i2, MediaSource mediaSource, Handler handler, Runnable runnable) {
        V0(i2, Collections.singletonList(mediaSource), handler, runnable);
    }

    public synchronized void N0(MediaSource mediaSource) {
        L0(this.d3.size(), mediaSource);
    }

    public synchronized void O0(MediaSource mediaSource, Handler handler, Runnable runnable) {
        M0(this.d3.size(), mediaSource, handler, runnable);
    }

    public synchronized void Q0(int i2, Collection<MediaSource> collection) {
        V0(i2, collection, (Handler) null, (Runnable) null);
    }

    public synchronized void R0(int i2, Collection<MediaSource> collection, Handler handler, Runnable runnable) {
        V0(i2, collection, handler, runnable);
    }

    public synchronized void S0(Collection<MediaSource> collection) {
        V0(this.d3.size(), collection, (Handler) null, (Runnable) null);
    }

    public synchronized void T0(Collection<MediaSource> collection, Handler handler, Runnable runnable) {
        V0(this.d3.size(), collection, handler, runnable);
    }

    public synchronized void W0() {
        v1(0, j1());
    }

    public void X(MediaPeriod mediaPeriod) {
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) Assertions.g(this.h3.remove(mediaPeriod));
        mediaSourceHolder.f12091a.X(mediaPeriod);
        mediaSourceHolder.f12093c.remove(((MaskingMediaPeriod) mediaPeriod).s);
        if (!this.h3.isEmpty()) {
            a1();
        }
        m1(mediaSourceHolder);
    }

    public synchronized void X0(Handler handler, Runnable runnable) {
        w1(0, j1(), handler, runnable);
    }

    /* access modifiers changed from: protected */
    @Nullable
    /* renamed from: e1 */
    public MediaSource.MediaPeriodId C0(MediaSourceHolder mediaSourceHolder, MediaSource.MediaPeriodId mediaPeriodId) {
        for (int i2 = 0; i2 < mediaSourceHolder.f12093c.size(); i2++) {
            if (mediaSourceHolder.f12093c.get(i2).f12166d == mediaPeriodId.f12166d) {
                return mediaPeriodId.a(h1(mediaSourceHolder, mediaPeriodId.f12163a));
            }
        }
        return null;
    }

    public synchronized MediaSource f1(int i2) {
        return this.d3.get(i2).f12091a;
    }

    /* access modifiers changed from: protected */
    public void h0() {
        super.h0();
        this.j3.clear();
    }

    /* access modifiers changed from: protected */
    public void j0() {
    }

    public synchronized int j1() {
        return this.d3.size();
    }

    /* access modifiers changed from: protected */
    /* renamed from: k1 */
    public int E0(MediaSourceHolder mediaSourceHolder, int i2) {
        return i2 + mediaSourceHolder.f12095e;
    }

    public synchronized void n1(int i2, int i4) {
        q1(i2, i4, (Handler) null, (Runnable) null);
    }

    public synchronized void o1(int i2, int i4, Handler handler, Runnable runnable) {
        q1(i2, i4, handler, runnable);
    }

    /* access modifiers changed from: protected */
    /* renamed from: r1 */
    public void G0(MediaSourceHolder mediaSourceHolder, MediaSource mediaSource, Timeline timeline) {
        D1(mediaSourceHolder, timeline);
    }

    /* access modifiers changed from: protected */
    public synchronized void s0(@Nullable TransferListener transferListener) {
        try {
            super.s0(transferListener);
            this.f3 = new Handler(new C0336b(this));
            if (this.d3.isEmpty()) {
                E1();
            } else {
                this.o3 = this.o3.e(0, this.d3.size());
                U0(0, this.d3);
                y1();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public synchronized MediaSource s1(int i2) {
        MediaSource f1;
        f1 = f1(i2);
        x1(i2, i2 + 1, (Handler) null, (Runnable) null);
        return f1;
    }

    public synchronized MediaSource t1(int i2, Handler handler, Runnable runnable) {
        MediaSource f1;
        f1 = f1(i2);
        x1(i2, i2 + 1, handler, runnable);
        return f1;
    }

    /* access modifiers changed from: protected */
    public synchronized void u0() {
        try {
            super.u0();
            this.g3.clear();
            this.j3.clear();
            this.i3.clear();
            this.o3 = this.o3.g();
            Handler handler = this.f3;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
                this.f3 = null;
            }
            this.m3 = false;
            this.n3.clear();
            b1(this.e3);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public synchronized void v1(int i2, int i4) {
        x1(i2, i4, (Handler) null, (Runnable) null);
    }

    public synchronized void w1(int i2, int i4, Handler handler, Runnable runnable) {
        x1(i2, i4, handler, runnable);
    }

    public ConcatenatingMediaSource(boolean z, boolean z2, ShuffleOrder shuffleOrder, MediaSource... mediaSourceArr) {
        for (MediaSource g2 : mediaSourceArr) {
            Assertions.g(g2);
        }
        this.o3 = shuffleOrder.getLength() > 0 ? shuffleOrder.g() : shuffleOrder;
        this.h3 = new IdentityHashMap<>();
        this.i3 = new HashMap();
        this.d3 = new ArrayList();
        this.g3 = new ArrayList();
        this.n3 = new HashSet();
        this.e3 = new HashSet();
        this.j3 = new HashSet();
        this.k3 = z;
        this.l3 = z2;
        S0(Arrays.asList(mediaSourceArr));
    }

    public ConcatenatingMediaSource(boolean z, MediaSource... mediaSourceArr) {
        this(z, new ShuffleOrder.DefaultShuffleOrder(0), mediaSourceArr);
    }

    public ConcatenatingMediaSource(MediaSource... mediaSourceArr) {
        this(false, mediaSourceArr);
    }
}
