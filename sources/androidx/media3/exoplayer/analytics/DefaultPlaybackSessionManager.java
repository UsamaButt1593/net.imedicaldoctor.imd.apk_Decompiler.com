package androidx.media3.exoplayer.analytics;

import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.PlaybackSessionManager;
import androidx.media3.exoplayer.source.MediaSource;
import com.google.common.base.Supplier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public final class DefaultPlaybackSessionManager implements PlaybackSessionManager {

    /* renamed from: i  reason: collision with root package name */
    public static final Supplier<String> f10532i = new C0247v0();

    /* renamed from: j  reason: collision with root package name */
    private static final Random f10533j = new Random();

    /* renamed from: k  reason: collision with root package name */
    private static final int f10534k = 12;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Timeline.Window f10535a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Timeline.Period f10536b;

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, SessionDescriptor> f10537c;

    /* renamed from: d  reason: collision with root package name */
    private final Supplier<String> f10538d;

    /* renamed from: e  reason: collision with root package name */
    private PlaybackSessionManager.Listener f10539e;

    /* renamed from: f  reason: collision with root package name */
    private Timeline f10540f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private String f10541g;

    /* renamed from: h  reason: collision with root package name */
    private long f10542h;

    private final class SessionDescriptor {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f10543a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f10544b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public long f10545c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public MediaSource.MediaPeriodId f10546d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public boolean f10547e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public boolean f10548f;

        public SessionDescriptor(String str, int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            this.f10543a = str;
            this.f10544b = i2;
            this.f10545c = mediaPeriodId == null ? -1 : mediaPeriodId.f12166d;
            if (mediaPeriodId != null && mediaPeriodId.c()) {
                this.f10546d = mediaPeriodId;
            }
        }

        private int l(Timeline timeline, Timeline timeline2, int i2) {
            if (i2 < timeline.w()) {
                timeline.u(i2, DefaultPlaybackSessionManager.this.f10535a);
                for (int i3 = DefaultPlaybackSessionManager.this.f10535a.h3; i3 <= DefaultPlaybackSessionManager.this.f10535a.i3; i3++) {
                    int g2 = timeline2.g(timeline.t(i3));
                    if (g2 != -1) {
                        return timeline2.k(g2, DefaultPlaybackSessionManager.this.f10536b).Y;
                    }
                }
                return -1;
            } else if (i2 < timeline2.w()) {
                return i2;
            } else {
                return -1;
            }
        }

        public boolean i(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            if (mediaPeriodId == null) {
                return i2 == this.f10544b;
            }
            MediaSource.MediaPeriodId mediaPeriodId2 = this.f10546d;
            return mediaPeriodId2 == null ? !mediaPeriodId.c() && mediaPeriodId.f12166d == this.f10545c : mediaPeriodId.f12166d == mediaPeriodId2.f12166d && mediaPeriodId.f12164b == mediaPeriodId2.f12164b && mediaPeriodId.f12165c == mediaPeriodId2.f12165c;
        }

        public boolean j(AnalyticsListener.EventTime eventTime) {
            MediaSource.MediaPeriodId mediaPeriodId = eventTime.f10509d;
            if (mediaPeriodId == null) {
                return this.f10544b != eventTime.f10508c;
            }
            long j2 = this.f10545c;
            if (j2 == -1) {
                return false;
            }
            if (mediaPeriodId.f12166d > j2) {
                return true;
            }
            if (this.f10546d == null) {
                return false;
            }
            int g2 = eventTime.f10507b.g(mediaPeriodId.f12163a);
            int g3 = eventTime.f10507b.g(this.f10546d.f12163a);
            MediaSource.MediaPeriodId mediaPeriodId2 = eventTime.f10509d;
            if (mediaPeriodId2.f12166d < this.f10546d.f12166d || g2 < g3) {
                return false;
            }
            if (g2 > g3) {
                return true;
            }
            boolean c2 = mediaPeriodId2.c();
            MediaSource.MediaPeriodId mediaPeriodId3 = eventTime.f10509d;
            if (c2) {
                int i2 = mediaPeriodId3.f12164b;
                int i3 = mediaPeriodId3.f12165c;
                MediaSource.MediaPeriodId mediaPeriodId4 = this.f10546d;
                int i4 = mediaPeriodId4.f12164b;
                if (i2 <= i4) {
                    return i2 == i4 && i3 > mediaPeriodId4.f12165c;
                }
                return true;
            }
            int i5 = mediaPeriodId3.f12167e;
            return i5 == -1 || i5 > this.f10546d.f12164b;
        }

        public void k(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            if (this.f10545c == -1 && i2 == this.f10544b && mediaPeriodId != null && mediaPeriodId.f12166d >= DefaultPlaybackSessionManager.this.o()) {
                this.f10545c = mediaPeriodId.f12166d;
            }
        }

        public boolean m(Timeline timeline, Timeline timeline2) {
            int l2 = l(timeline, timeline2, this.f10544b);
            this.f10544b = l2;
            if (l2 == -1) {
                return false;
            }
            MediaSource.MediaPeriodId mediaPeriodId = this.f10546d;
            return mediaPeriodId == null || timeline2.g(mediaPeriodId.f12163a) != -1;
        }
    }

    public DefaultPlaybackSessionManager() {
        this(f10532i);
    }

    private void m(SessionDescriptor sessionDescriptor) {
        if (sessionDescriptor.f10545c != -1) {
            this.f10542h = sessionDescriptor.f10545c;
        }
        this.f10541g = null;
    }

    /* access modifiers changed from: private */
    public static String n() {
        byte[] bArr = new byte[12];
        f10533j.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    /* access modifiers changed from: private */
    public long o() {
        SessionDescriptor sessionDescriptor = this.f10537c.get(this.f10541g);
        return (sessionDescriptor == null || sessionDescriptor.f10545c == -1) ? this.f10542h + 1 : sessionDescriptor.f10545c;
    }

    private SessionDescriptor p(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        int i3;
        SessionDescriptor sessionDescriptor = null;
        long j2 = Long.MAX_VALUE;
        for (SessionDescriptor next : this.f10537c.values()) {
            next.k(i2, mediaPeriodId);
            if (next.i(i2, mediaPeriodId)) {
                long b2 = next.f10545c;
                if (b2 == -1 || b2 < j2) {
                    sessionDescriptor = next;
                    j2 = b2;
                } else if (!(i3 != 0 || ((SessionDescriptor) Util.o(sessionDescriptor)).f10546d == null || next.f10546d == null)) {
                    sessionDescriptor = next;
                }
            }
        }
        if (sessionDescriptor != null) {
            return sessionDescriptor;
        }
        String str = this.f10538d.get();
        SessionDescriptor sessionDescriptor2 = new SessionDescriptor(str, i2, mediaPeriodId);
        this.f10537c.put(str, sessionDescriptor2);
        return sessionDescriptor2;
    }

    @RequiresNonNull({"listener"})
    private void q(AnalyticsListener.EventTime eventTime) {
        if (eventTime.f10507b.x()) {
            String str = this.f10541g;
            if (str != null) {
                m((SessionDescriptor) Assertions.g(this.f10537c.get(str)));
                return;
            }
            return;
        }
        SessionDescriptor sessionDescriptor = this.f10537c.get(this.f10541g);
        SessionDescriptor p = p(eventTime.f10508c, eventTime.f10509d);
        this.f10541g = p.f10543a;
        b(eventTime);
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.f10509d;
        if (mediaPeriodId != null && mediaPeriodId.c()) {
            if (sessionDescriptor == null || sessionDescriptor.f10545c != eventTime.f10509d.f12166d || sessionDescriptor.f10546d == null || sessionDescriptor.f10546d.f12164b != eventTime.f10509d.f12164b || sessionDescriptor.f10546d.f12165c != eventTime.f10509d.f12165c) {
                MediaSource.MediaPeriodId mediaPeriodId2 = eventTime.f10509d;
                this.f10539e.i(eventTime, p(eventTime.f10508c, new MediaSource.MediaPeriodId(mediaPeriodId2.f12163a, mediaPeriodId2.f12166d)).f10543a, p.f10543a);
            }
        }
    }

    public synchronized void a(AnalyticsListener.EventTime eventTime) {
        PlaybackSessionManager.Listener listener;
        try {
            String str = this.f10541g;
            if (str != null) {
                m((SessionDescriptor) Assertions.g(this.f10537c.get(str)));
            }
            Iterator<SessionDescriptor> it2 = this.f10537c.values().iterator();
            while (it2.hasNext()) {
                SessionDescriptor next = it2.next();
                it2.remove();
                if (next.f10547e && (listener = this.f10539e) != null) {
                    listener.N(eventTime, next.f10543a, false);
                }
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0114, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b(androidx.media3.exoplayer.analytics.AnalyticsListener.EventTime r25) {
        /*
            r24 = this;
            r1 = r24
            r0 = r25
            monitor-enter(r24)
            androidx.media3.exoplayer.analytics.PlaybackSessionManager$Listener r2 = r1.f10539e     // Catch:{ all -> 0x0044 }
            androidx.media3.common.util.Assertions.g(r2)     // Catch:{ all -> 0x0044 }
            androidx.media3.common.Timeline r2 = r0.f10507b     // Catch:{ all -> 0x0044 }
            boolean r2 = r2.x()     // Catch:{ all -> 0x0044 }
            if (r2 == 0) goto L_0x0014
            monitor-exit(r24)
            return
        L_0x0014:
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r2 = r0.f10509d     // Catch:{ all -> 0x0044 }
            if (r2 == 0) goto L_0x0047
            long r2 = r2.f12166d     // Catch:{ all -> 0x0044 }
            long r4 = r24.o()     // Catch:{ all -> 0x0044 }
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0024
            monitor-exit(r24)
            return
        L_0x0024:
            java.util.HashMap<java.lang.String, androidx.media3.exoplayer.analytics.DefaultPlaybackSessionManager$SessionDescriptor> r2 = r1.f10537c     // Catch:{ all -> 0x0044 }
            java.lang.String r3 = r1.f10541g     // Catch:{ all -> 0x0044 }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x0044 }
            androidx.media3.exoplayer.analytics.DefaultPlaybackSessionManager$SessionDescriptor r2 = (androidx.media3.exoplayer.analytics.DefaultPlaybackSessionManager.SessionDescriptor) r2     // Catch:{ all -> 0x0044 }
            if (r2 == 0) goto L_0x0047
            long r3 = r2.f10545c     // Catch:{ all -> 0x0044 }
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0047
            int r2 = r2.f10544b     // Catch:{ all -> 0x0044 }
            int r3 = r0.f10508c     // Catch:{ all -> 0x0044 }
            if (r2 == r3) goto L_0x0047
            monitor-exit(r24)
            return
        L_0x0044:
            r0 = move-exception
            goto L_0x0115
        L_0x0047:
            int r2 = r0.f10508c     // Catch:{ all -> 0x0044 }
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r3 = r0.f10509d     // Catch:{ all -> 0x0044 }
            androidx.media3.exoplayer.analytics.DefaultPlaybackSessionManager$SessionDescriptor r2 = r1.p(r2, r3)     // Catch:{ all -> 0x0044 }
            java.lang.String r3 = r1.f10541g     // Catch:{ all -> 0x0044 }
            if (r3 != 0) goto L_0x0059
            java.lang.String r3 = r2.f10543a     // Catch:{ all -> 0x0044 }
            r1.f10541g = r3     // Catch:{ all -> 0x0044 }
        L_0x0059:
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r3 = r0.f10509d     // Catch:{ all -> 0x0044 }
            r4 = 1
            if (r3 == 0) goto L_0x00d6
            boolean r3 = r3.c()     // Catch:{ all -> 0x0044 }
            if (r3 == 0) goto L_0x00d6
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r10 = new androidx.media3.exoplayer.source.MediaSource$MediaPeriodId     // Catch:{ all -> 0x0044 }
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r3 = r0.f10509d     // Catch:{ all -> 0x0044 }
            java.lang.Object r5 = r3.f12163a     // Catch:{ all -> 0x0044 }
            long r6 = r3.f12166d     // Catch:{ all -> 0x0044 }
            int r3 = r3.f12164b     // Catch:{ all -> 0x0044 }
            r10.<init>(r5, r6, r3)     // Catch:{ all -> 0x0044 }
            int r3 = r0.f10508c     // Catch:{ all -> 0x0044 }
            androidx.media3.exoplayer.analytics.DefaultPlaybackSessionManager$SessionDescriptor r3 = r1.p(r3, r10)     // Catch:{ all -> 0x0044 }
            boolean r5 = r3.f10547e     // Catch:{ all -> 0x0044 }
            if (r5 != 0) goto L_0x00d6
            boolean unused = r3.f10547e = r4     // Catch:{ all -> 0x0044 }
            androidx.media3.common.Timeline r5 = r0.f10507b     // Catch:{ all -> 0x0044 }
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r6 = r0.f10509d     // Catch:{ all -> 0x0044 }
            java.lang.Object r6 = r6.f12163a     // Catch:{ all -> 0x0044 }
            androidx.media3.common.Timeline$Period r7 = r1.f10536b     // Catch:{ all -> 0x0044 }
            r5.m(r6, r7)     // Catch:{ all -> 0x0044 }
            androidx.media3.common.Timeline$Period r5 = r1.f10536b     // Catch:{ all -> 0x0044 }
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r6 = r0.f10509d     // Catch:{ all -> 0x0044 }
            int r6 = r6.f12164b     // Catch:{ all -> 0x0044 }
            long r5 = r5.i(r6)     // Catch:{ all -> 0x0044 }
            long r5 = androidx.media3.common.util.Util.H2(r5)     // Catch:{ all -> 0x0044 }
            androidx.media3.common.Timeline$Period r7 = r1.f10536b     // Catch:{ all -> 0x0044 }
            long r7 = r7.r()     // Catch:{ all -> 0x0044 }
            long r5 = r5 + r7
            r7 = 0
            long r11 = java.lang.Math.max(r7, r5)     // Catch:{ all -> 0x0044 }
            androidx.media3.exoplayer.analytics.AnalyticsListener$EventTime r15 = new androidx.media3.exoplayer.analytics.AnalyticsListener$EventTime     // Catch:{ all -> 0x0044 }
            long r6 = r0.f10506a     // Catch:{ all -> 0x0044 }
            androidx.media3.common.Timeline r8 = r0.f10507b     // Catch:{ all -> 0x0044 }
            int r9 = r0.f10508c     // Catch:{ all -> 0x0044 }
            androidx.media3.common.Timeline r13 = r0.f10511f     // Catch:{ all -> 0x0044 }
            int r14 = r0.f10512g     // Catch:{ all -> 0x0044 }
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r5 = r0.f10513h     // Catch:{ all -> 0x0044 }
            r16 = r5
            long r4 = r0.f10514i     // Catch:{ all -> 0x0044 }
            r20 = r2
            r21 = r3
            long r2 = r0.f10515j     // Catch:{ all -> 0x0044 }
            r22 = r4
            r4 = r16
            r16 = r22
            r5 = r15
            r0 = r15
            r15 = r4
            r18 = r2
            r5.<init>(r6, r8, r9, r10, r11, r13, r14, r15, r16, r18)     // Catch:{ all -> 0x0044 }
            androidx.media3.exoplayer.analytics.PlaybackSessionManager$Listener r2 = r1.f10539e     // Catch:{ all -> 0x0044 }
            java.lang.String r3 = r21.f10543a     // Catch:{ all -> 0x0044 }
            r2.k0(r0, r3)     // Catch:{ all -> 0x0044 }
            goto L_0x00d8
        L_0x00d6:
            r20 = r2
        L_0x00d8:
            boolean r0 = r20.f10547e     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x00f0
            r0 = r20
            r2 = 1
            boolean unused = r0.f10547e = r2     // Catch:{ all -> 0x0044 }
            androidx.media3.exoplayer.analytics.PlaybackSessionManager$Listener r2 = r1.f10539e     // Catch:{ all -> 0x0044 }
            java.lang.String r3 = r0.f10543a     // Catch:{ all -> 0x0044 }
            r4 = r25
            r2.k0(r4, r3)     // Catch:{ all -> 0x0044 }
            goto L_0x00f4
        L_0x00f0:
            r4 = r25
            r0 = r20
        L_0x00f4:
            java.lang.String r2 = r0.f10543a     // Catch:{ all -> 0x0044 }
            java.lang.String r3 = r1.f10541g     // Catch:{ all -> 0x0044 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0044 }
            if (r2 == 0) goto L_0x0113
            boolean r2 = r0.f10548f     // Catch:{ all -> 0x0044 }
            if (r2 != 0) goto L_0x0113
            r2 = 1
            boolean unused = r0.f10548f = r2     // Catch:{ all -> 0x0044 }
            androidx.media3.exoplayer.analytics.PlaybackSessionManager$Listener r2 = r1.f10539e     // Catch:{ all -> 0x0044 }
            java.lang.String r0 = r0.f10543a     // Catch:{ all -> 0x0044 }
            r2.s0(r4, r0)     // Catch:{ all -> 0x0044 }
        L_0x0113:
            monitor-exit(r24)
            return
        L_0x0115:
            monitor-exit(r24)     // Catch:{ all -> 0x0044 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.analytics.DefaultPlaybackSessionManager.b(androidx.media3.exoplayer.analytics.AnalyticsListener$EventTime):void");
    }

    @Nullable
    public synchronized String c() {
        return this.f10541g;
    }

    public void d(PlaybackSessionManager.Listener listener) {
        this.f10539e = listener;
    }

    public synchronized String e(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        return p(timeline.m(mediaPeriodId.f12163a, this.f10536b).Y, mediaPeriodId).f10543a;
    }

    public synchronized boolean f(AnalyticsListener.EventTime eventTime, String str) {
        SessionDescriptor sessionDescriptor = this.f10537c.get(str);
        if (sessionDescriptor == null) {
            return false;
        }
        sessionDescriptor.k(eventTime.f10508c, eventTime.f10509d);
        return sessionDescriptor.i(eventTime.f10508c, eventTime.f10509d);
    }

    public synchronized void g(AnalyticsListener.EventTime eventTime, int i2) {
        try {
            Assertions.g(this.f10539e);
            boolean z = i2 == 0;
            Iterator<SessionDescriptor> it2 = this.f10537c.values().iterator();
            while (it2.hasNext()) {
                SessionDescriptor next = it2.next();
                if (next.j(eventTime)) {
                    it2.remove();
                    if (next.f10547e) {
                        boolean equals = next.f10543a.equals(this.f10541g);
                        boolean z2 = z && equals && next.f10548f;
                        if (equals) {
                            m(next);
                        }
                        this.f10539e.N(eventTime, next.f10543a, z2);
                    }
                }
            }
            q(eventTime);
        } finally {
            while (true) {
            }
        }
    }

    public synchronized void h(AnalyticsListener.EventTime eventTime) {
        try {
            Assertions.g(this.f10539e);
            Timeline timeline = this.f10540f;
            this.f10540f = eventTime.f10507b;
            Iterator<SessionDescriptor> it2 = this.f10537c.values().iterator();
            while (it2.hasNext()) {
                SessionDescriptor next = it2.next();
                if (next.m(timeline, this.f10540f)) {
                    if (next.j(eventTime)) {
                    }
                }
                it2.remove();
                if (next.f10547e) {
                    if (next.f10543a.equals(this.f10541g)) {
                        m(next);
                    }
                    this.f10539e.N(eventTime, next.f10543a, false);
                }
            }
            q(eventTime);
        } finally {
            while (true) {
            }
        }
    }

    public DefaultPlaybackSessionManager(Supplier<String> supplier) {
        this.f10538d = supplier;
        this.f10535a = new Timeline.Window();
        this.f10536b = new Timeline.Period();
        this.f10537c = new HashMap<>();
        this.f10540f = Timeline.s;
        this.f10542h = -1;
    }
}
