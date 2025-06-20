package androidx.media3.exoplayer.upstream;

import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.TransferListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

@UnstableApi
public interface BandwidthMeter {

    public interface EventListener {

        public static final class EventDispatcher {

            /* renamed from: a  reason: collision with root package name */
            private final CopyOnWriteArrayList<HandlerAndListener> f12433a = new CopyOnWriteArrayList<>();

            private static final class HandlerAndListener {
                /* access modifiers changed from: private */

                /* renamed from: a  reason: collision with root package name */
                public final Handler f12434a;
                /* access modifiers changed from: private */

                /* renamed from: b  reason: collision with root package name */
                public final EventListener f12435b;
                /* access modifiers changed from: private */

                /* renamed from: c  reason: collision with root package name */
                public boolean f12436c;

                public HandlerAndListener(Handler handler, EventListener eventListener) {
                    this.f12434a = handler;
                    this.f12435b = eventListener;
                }

                public void d() {
                    this.f12436c = true;
                }
            }

            public void b(Handler handler, EventListener eventListener) {
                Assertions.g(handler);
                Assertions.g(eventListener);
                e(eventListener);
                this.f12433a.add(new HandlerAndListener(handler, eventListener));
            }

            public void c(int i2, long j2, long j3) {
                Iterator<HandlerAndListener> it2 = this.f12433a.iterator();
                while (it2.hasNext()) {
                    HandlerAndListener next = it2.next();
                    if (!next.f12436c) {
                        next.f12434a.post(new b(next, i2, j2, j3));
                    }
                }
            }

            public void e(EventListener eventListener) {
                Iterator<HandlerAndListener> it2 = this.f12433a.iterator();
                while (it2.hasNext()) {
                    HandlerAndListener next = it2.next();
                    if (next.f12435b == eventListener) {
                        next.d();
                        this.f12433a.remove(next);
                    }
                }
            }
        }

        void P(int i2, long j2, long j3);
    }

    void a(EventListener eventListener);

    long b();

    void c(Handler handler, EventListener eventListener);

    @Nullable
    TransferListener f();

    long i();
}
