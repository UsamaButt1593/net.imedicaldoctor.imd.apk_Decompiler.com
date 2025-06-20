package androidx.media3.exoplayer.source;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

@UnstableApi
public interface MediaSourceEventListener {

    public static class EventDispatcher {

        /* renamed from: a  reason: collision with root package name */
        public final int f12168a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public final MediaSource.MediaPeriodId f12169b;

        /* renamed from: c  reason: collision with root package name */
        private final CopyOnWriteArrayList<ListenerAndHandler> f12170c;

        private static final class ListenerAndHandler {

            /* renamed from: a  reason: collision with root package name */
            public Handler f12171a;

            /* renamed from: b  reason: collision with root package name */
            public MediaSourceEventListener f12172b;

            public ListenerAndHandler(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
                this.f12171a = handler;
                this.f12172b = mediaSourceEventListener;
            }
        }

        public EventDispatcher() {
            this(new CopyOnWriteArrayList(), 0, (MediaSource.MediaPeriodId) null);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void j(MediaSourceEventListener mediaSourceEventListener, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.Q(this.f12168a, this.f12169b, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void k(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.x0(this.f12168a, this.f12169b, loadEventInfo, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void l(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.O(this.f12168a, this.f12169b, loadEventInfo, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
            mediaSourceEventListener.q0(this.f12168a, this.f12169b, loadEventInfo, mediaLoadData, iOException, z);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void n(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.V(this.f12168a, this.f12169b, loadEventInfo, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void o(MediaSourceEventListener mediaSourceEventListener, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            mediaSourceEventListener.A(this.f12168a, mediaPeriodId, mediaLoadData);
        }

        public void A(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it2 = this.f12170c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.T1(next.f12171a, new s(this, next.f12172b, loadEventInfo, mediaLoadData));
            }
        }

        public void B(MediaSourceEventListener mediaSourceEventListener) {
            Iterator<ListenerAndHandler> it2 = this.f12170c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                if (next.f12172b == mediaSourceEventListener) {
                    this.f12170c.remove(next);
                }
            }
        }

        public void C(int i2, long j2, long j3) {
            D(new MediaLoadData(1, i2, (Format) null, 3, (Object) null, Util.H2(j2), Util.H2(j3)));
        }

        public void D(MediaLoadData mediaLoadData) {
            MediaSource.MediaPeriodId mediaPeriodId = (MediaSource.MediaPeriodId) Assertions.g(this.f12169b);
            Iterator<ListenerAndHandler> it2 = this.f12170c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.T1(next.f12171a, new w(this, next.f12172b, mediaPeriodId, mediaLoadData));
            }
        }

        @CheckResult
        public EventDispatcher E(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            return new EventDispatcher(this.f12170c, i2, mediaPeriodId);
        }

        @CheckResult
        @Deprecated
        public EventDispatcher F(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, long j2) {
            return new EventDispatcher(this.f12170c, i2, mediaPeriodId);
        }

        public void g(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
            Assertions.g(handler);
            Assertions.g(mediaSourceEventListener);
            this.f12170c.add(new ListenerAndHandler(handler, mediaSourceEventListener));
        }

        public void h(int i2, @Nullable Format format, int i3, @Nullable Object obj, long j2) {
            i(new MediaLoadData(1, i2, format, i3, obj, Util.H2(j2), C.f9084b));
        }

        public void i(MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it2 = this.f12170c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.T1(next.f12171a, new r(this, next.f12172b, mediaLoadData));
            }
        }

        public void p(LoadEventInfo loadEventInfo, int i2) {
            q(loadEventInfo, i2, -1, (Format) null, 0, (Object) null, C.f9084b, C.f9084b);
        }

        public void q(LoadEventInfo loadEventInfo, int i2, int i3, @Nullable Format format, int i4, @Nullable Object obj, long j2, long j3) {
            MediaLoadData mediaLoadData = new MediaLoadData(i2, i3, format, i4, obj, Util.H2(j2), Util.H2(j3));
            LoadEventInfo loadEventInfo2 = loadEventInfo;
            r(loadEventInfo, mediaLoadData);
        }

        public void r(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it2 = this.f12170c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.T1(next.f12171a, new v(this, next.f12172b, loadEventInfo, mediaLoadData));
            }
        }

        public void s(LoadEventInfo loadEventInfo, int i2) {
            t(loadEventInfo, i2, -1, (Format) null, 0, (Object) null, C.f9084b, C.f9084b);
        }

        public void t(LoadEventInfo loadEventInfo, int i2, int i3, @Nullable Format format, int i4, @Nullable Object obj, long j2, long j3) {
            MediaLoadData mediaLoadData = new MediaLoadData(i2, i3, format, i4, obj, Util.H2(j2), Util.H2(j3));
            LoadEventInfo loadEventInfo2 = loadEventInfo;
            u(loadEventInfo, mediaLoadData);
        }

        public void u(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it2 = this.f12170c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.T1(next.f12171a, new t(this, next.f12172b, loadEventInfo, mediaLoadData));
            }
        }

        public void v(LoadEventInfo loadEventInfo, int i2, int i3, @Nullable Format format, int i4, @Nullable Object obj, long j2, long j3, IOException iOException, boolean z) {
            MediaLoadData mediaLoadData = new MediaLoadData(i2, i3, format, i4, obj, Util.H2(j2), Util.H2(j3));
            LoadEventInfo loadEventInfo2 = loadEventInfo;
            x(loadEventInfo, mediaLoadData, iOException, z);
        }

        public void w(LoadEventInfo loadEventInfo, int i2, IOException iOException, boolean z) {
            v(loadEventInfo, i2, -1, (Format) null, 0, (Object) null, C.f9084b, C.f9084b, iOException, z);
        }

        public void x(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
            Iterator<ListenerAndHandler> it2 = this.f12170c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.T1(next.f12171a, new u(this, next.f12172b, loadEventInfo, mediaLoadData, iOException, z));
            }
        }

        public void y(LoadEventInfo loadEventInfo, int i2) {
            z(loadEventInfo, i2, -1, (Format) null, 0, (Object) null, C.f9084b, C.f9084b);
        }

        public void z(LoadEventInfo loadEventInfo, int i2, int i3, @Nullable Format format, int i4, @Nullable Object obj, long j2, long j3) {
            MediaLoadData mediaLoadData = new MediaLoadData(i2, i3, format, i4, obj, Util.H2(j2), Util.H2(j3));
            LoadEventInfo loadEventInfo2 = loadEventInfo;
            A(loadEventInfo, mediaLoadData);
        }

        private EventDispatcher(CopyOnWriteArrayList<ListenerAndHandler> copyOnWriteArrayList, int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            this.f12170c = copyOnWriteArrayList;
            this.f12168a = i2;
            this.f12169b = mediaPeriodId;
        }
    }

    void A(int i2, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData);

    void O(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void Q(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData);

    void V(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void q0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z);

    void x0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);
}
