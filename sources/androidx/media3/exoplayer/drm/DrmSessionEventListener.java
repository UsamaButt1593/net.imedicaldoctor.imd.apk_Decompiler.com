package androidx.media3.exoplayer.drm;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

@UnstableApi
public interface DrmSessionEventListener {

    public static class EventDispatcher {

        /* renamed from: a  reason: collision with root package name */
        public final int f11294a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public final MediaSource.MediaPeriodId f11295b;

        /* renamed from: c  reason: collision with root package name */
        private final CopyOnWriteArrayList<ListenerAndHandler> f11296c;

        private static final class ListenerAndHandler {

            /* renamed from: a  reason: collision with root package name */
            public Handler f11297a;

            /* renamed from: b  reason: collision with root package name */
            public DrmSessionEventListener f11298b;

            public ListenerAndHandler(Handler handler, DrmSessionEventListener drmSessionEventListener) {
                this.f11297a = handler;
                this.f11298b = drmSessionEventListener;
            }
        }

        public EventDispatcher() {
            this(new CopyOnWriteArrayList(), 0, (MediaSource.MediaPeriodId) null);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void n(DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.c0(this.f11294a, this.f11295b);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void o(DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.v0(this.f11294a, this.f11295b);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void p(DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.R(this.f11294a, this.f11295b);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void q(DrmSessionEventListener drmSessionEventListener, int i2) {
            drmSessionEventListener.r0(this.f11294a, this.f11295b);
            drmSessionEventListener.o0(this.f11294a, this.f11295b, i2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void r(DrmSessionEventListener drmSessionEventListener, Exception exc) {
            drmSessionEventListener.w0(this.f11294a, this.f11295b, exc);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void s(DrmSessionEventListener drmSessionEventListener) {
            drmSessionEventListener.m0(this.f11294a, this.f11295b);
        }

        public void g(Handler handler, DrmSessionEventListener drmSessionEventListener) {
            Assertions.g(handler);
            Assertions.g(drmSessionEventListener);
            this.f11296c.add(new ListenerAndHandler(handler, drmSessionEventListener));
        }

        public void h() {
            Iterator<ListenerAndHandler> it2 = this.f11296c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.T1(next.f11297a, new C0301o(this, next.f11298b));
            }
        }

        public void i() {
            Iterator<ListenerAndHandler> it2 = this.f11296c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.T1(next.f11297a, new C0298l(this, next.f11298b));
            }
        }

        public void j() {
            Iterator<ListenerAndHandler> it2 = this.f11296c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.T1(next.f11297a, new C0299m(this, next.f11298b));
            }
        }

        public void k(int i2) {
            Iterator<ListenerAndHandler> it2 = this.f11296c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.T1(next.f11297a, new C0300n(this, next.f11298b, i2));
            }
        }

        public void l(Exception exc) {
            Iterator<ListenerAndHandler> it2 = this.f11296c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.T1(next.f11297a, new C0297k(this, next.f11298b, exc));
            }
        }

        public void m() {
            Iterator<ListenerAndHandler> it2 = this.f11296c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                Util.T1(next.f11297a, new C0302p(this, next.f11298b));
            }
        }

        public void t(DrmSessionEventListener drmSessionEventListener) {
            Iterator<ListenerAndHandler> it2 = this.f11296c.iterator();
            while (it2.hasNext()) {
                ListenerAndHandler next = it2.next();
                if (next.f11298b == drmSessionEventListener) {
                    this.f11296c.remove(next);
                }
            }
        }

        @CheckResult
        public EventDispatcher u(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            return new EventDispatcher(this.f11296c, i2, mediaPeriodId);
        }

        private EventDispatcher(CopyOnWriteArrayList<ListenerAndHandler> copyOnWriteArrayList, int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            this.f11296c = copyOnWriteArrayList;
            this.f11294a = i2;
            this.f11295b = mediaPeriodId;
        }
    }

    void R(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId);

    void c0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId);

    void m0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId);

    void o0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, int i3);

    @Deprecated
    void r0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId);

    void v0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId);

    void w0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, Exception exc);
}
