package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.Monotonic;
import com.google.android.datatransport.runtime.time.WallTime;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.inject.Inject;

public class Uploader {

    /* renamed from: j  reason: collision with root package name */
    private static final String f19578j = "Uploader";

    /* renamed from: k  reason: collision with root package name */
    private static final String f19579k = "GDT_CLIENT_METRICS";

    /* renamed from: a  reason: collision with root package name */
    private final Context f19580a;

    /* renamed from: b  reason: collision with root package name */
    private final BackendRegistry f19581b;

    /* renamed from: c  reason: collision with root package name */
    private final EventStore f19582c;

    /* renamed from: d  reason: collision with root package name */
    private final WorkScheduler f19583d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f19584e;

    /* renamed from: f  reason: collision with root package name */
    private final SynchronizationGuard f19585f;

    /* renamed from: g  reason: collision with root package name */
    private final Clock f19586g;

    /* renamed from: h  reason: collision with root package name */
    private final Clock f19587h;

    /* renamed from: i  reason: collision with root package name */
    private final ClientHealthMetricsStore f19588i;

    @Inject
    public Uploader(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, @WallTime Clock clock, @Monotonic Clock clock2, ClientHealthMetricsStore clientHealthMetricsStore) {
        this.f19580a = context;
        this.f19581b = backendRegistry;
        this.f19582c = eventStore;
        this.f19583d = workScheduler;
        this.f19584e = executor;
        this.f19585f = synchronizationGuard;
        this.f19586g = clock;
        this.f19587h = clock2;
        this.f19588i = clientHealthMetricsStore;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean l(TransportContext transportContext) {
        return Boolean.valueOf(this.f19582c.u2(transportContext));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Iterable m(TransportContext transportContext) {
        return this.f19582c.X(transportContext);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object n(Iterable iterable, TransportContext transportContext, long j2) {
        this.f19582c.B2(iterable);
        this.f19582c.f0(transportContext, this.f19586g.a() + j2);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object o(Iterable iterable) {
        this.f19582c.D(iterable);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object p() {
        this.f19588i.b();
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object q(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            this.f19588i.e((long) ((Integer) entry.getValue()).intValue(), LogEventDropped.Reason.INVALID_PAYLOD, (String) entry.getKey());
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object r(TransportContext transportContext, long j2) {
        this.f19582c.f0(transportContext, this.f19586g.a() + j2);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object s(TransportContext transportContext, int i2) {
        this.f19583d.a(transportContext, i2 + 1);
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
        r6.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0020, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r3.f19583d.a(r4, r5 + 1);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0029 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void t(com.google.android.datatransport.runtime.TransportContext r4, int r5, java.lang.Runnable r6) {
        /*
            r3 = this;
            com.google.android.datatransport.runtime.synchronization.SynchronizationGuard r0 = r3.f19585f     // Catch:{ SynchronizationException -> 0x0029 }
            com.google.android.datatransport.runtime.scheduling.persistence.EventStore r1 = r3.f19582c     // Catch:{ SynchronizationException -> 0x0029 }
            java.util.Objects.requireNonNull(r1)     // Catch:{ SynchronizationException -> 0x0029 }
            com.google.android.datatransport.runtime.scheduling.jobscheduling.c r2 = new com.google.android.datatransport.runtime.scheduling.jobscheduling.c     // Catch:{ SynchronizationException -> 0x0029 }
            r2.<init>(r1)     // Catch:{ SynchronizationException -> 0x0029 }
            r0.c(r2)     // Catch:{ SynchronizationException -> 0x0029 }
            boolean r0 = r3.k()     // Catch:{ SynchronizationException -> 0x0029 }
            if (r0 != 0) goto L_0x0022
            com.google.android.datatransport.runtime.synchronization.SynchronizationGuard r0 = r3.f19585f     // Catch:{ SynchronizationException -> 0x0029 }
            com.google.android.datatransport.runtime.scheduling.jobscheduling.e r1 = new com.google.android.datatransport.runtime.scheduling.jobscheduling.e     // Catch:{ SynchronizationException -> 0x0029 }
            r1.<init>(r3, r4, r5)     // Catch:{ SynchronizationException -> 0x0029 }
            r0.c(r1)     // Catch:{ SynchronizationException -> 0x0029 }
            goto L_0x0025
        L_0x0020:
            r4 = move-exception
            goto L_0x0032
        L_0x0022:
            r3.u(r4, r5)     // Catch:{ SynchronizationException -> 0x0029 }
        L_0x0025:
            r6.run()
            goto L_0x0031
        L_0x0029:
            com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler r0 = r3.f19583d     // Catch:{ all -> 0x0020 }
            int r5 = r5 + 1
            r0.a(r4, r5)     // Catch:{ all -> 0x0020 }
            goto L_0x0025
        L_0x0031:
            return
        L_0x0032:
            r6.run()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader.t(com.google.android.datatransport.runtime.TransportContext, int, java.lang.Runnable):void");
    }

    @VisibleForTesting
    public EventInternal j(TransportBackend transportBackend) {
        SynchronizationGuard synchronizationGuard = this.f19585f;
        ClientHealthMetricsStore clientHealthMetricsStore = this.f19588i;
        Objects.requireNonNull(clientHealthMetricsStore);
        return transportBackend.b(EventInternal.a().i(this.f19586g.a()).o(this.f19587h.a()).n(f19579k).h(new EncodedPayload(Encoding.b("proto"), ((ClientMetrics) synchronizationGuard.c(new g(clientHealthMetricsStore))).i())).d());
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f19580a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @CanIgnoreReturnValue
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public BackendResponse u(TransportContext transportContext, int i2) {
        BackendResponse a2;
        TransportBackend i3 = this.f19581b.i(transportContext.b());
        long j2 = 0;
        BackendResponse e2 = BackendResponse.e(0);
        while (true) {
            long j3 = j2;
            while (((Boolean) this.f19585f.c(new h(this, transportContext))).booleanValue()) {
                Iterable<PersistedEvent> iterable = (Iterable) this.f19585f.c(new i(this, transportContext));
                if (!iterable.iterator().hasNext()) {
                    return e2;
                }
                if (i3 == null) {
                    Logging.c(f19578j, "Unknown backend for %s, deleting event batch for it...", transportContext);
                    a2 = BackendResponse.a();
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (PersistedEvent b2 : iterable) {
                        arrayList.add(b2.b());
                    }
                    if (transportContext.e()) {
                        arrayList.add(j(i3));
                    }
                    a2 = i3.a(BackendRequest.a().b(arrayList).c(transportContext.c()).a());
                }
                e2 = a2;
                if (e2.c() == BackendResponse.Status.TRANSIENT_ERROR) {
                    this.f19585f.c(new j(this, iterable, transportContext, j3));
                    this.f19583d.b(transportContext, i2 + 1, true);
                    return e2;
                }
                this.f19585f.c(new k(this, iterable));
                if (e2.c() == BackendResponse.Status.OK) {
                    j2 = Math.max(j3, e2.b());
                    if (transportContext.e()) {
                        this.f19585f.c(new l(this));
                    }
                } else if (e2.c() == BackendResponse.Status.INVALID_PAYLOAD) {
                    HashMap hashMap = new HashMap();
                    for (PersistedEvent b3 : iterable) {
                        String p = b3.b().p();
                        hashMap.put(p, !hashMap.containsKey(p) ? 1 : Integer.valueOf(((Integer) hashMap.get(p)).intValue() + 1));
                    }
                    this.f19585f.c(new m(this, hashMap));
                }
            }
            this.f19585f.c(new d(this, transportContext, j3));
            return e2;
        }
    }

    public void v(TransportContext transportContext, int i2, Runnable runnable) {
        this.f19584e.execute(new f(this, transportContext, i2, runnable));
    }
}
