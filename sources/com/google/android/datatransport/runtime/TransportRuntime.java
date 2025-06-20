package com.google.android.datatransport.runtime;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.EventContext;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.Monotonic;
import com.google.android.datatransport.runtime.time.WallTime;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TransportRuntime implements TransportInternal {

    /* renamed from: e  reason: collision with root package name */
    private static volatile TransportRuntimeComponent f19451e;

    /* renamed from: a  reason: collision with root package name */
    private final Clock f19452a;

    /* renamed from: b  reason: collision with root package name */
    private final Clock f19453b;

    /* renamed from: c  reason: collision with root package name */
    private final Scheduler f19454c;

    /* renamed from: d  reason: collision with root package name */
    private final Uploader f19455d;

    @Inject
    TransportRuntime(@WallTime Clock clock, @Monotonic Clock clock2, Scheduler scheduler, Uploader uploader, WorkInitializer workInitializer) {
        this.f19452a = clock;
        this.f19453b = clock2;
        this.f19454c = scheduler;
        this.f19455d = uploader;
        workInitializer.c();
    }

    private EventInternal b(SendRequest sendRequest) {
        EventInternal.Builder g2 = EventInternal.a().i(this.f19452a.a()).o(this.f19453b.a()).n(sendRequest.g()).h(new EncodedPayload(sendRequest.b(), sendRequest.d())).g(sendRequest.c().a());
        if (!(sendRequest.c().e() == null || sendRequest.c().e().a() == null)) {
            g2.l(sendRequest.c().e().a());
        }
        if (sendRequest.c().b() != null) {
            EventContext b2 = sendRequest.c().b();
            if (b2.d() != null) {
                g2.m(b2.d());
            }
            if (b2.b() != null) {
                g2.j(b2.b());
            }
            if (b2.c() != null) {
                g2.k(b2.c());
            }
        }
        return g2.d();
    }

    public static TransportRuntime c() {
        TransportRuntimeComponent transportRuntimeComponent = f19451e;
        if (transportRuntimeComponent != null) {
            return transportRuntimeComponent.c();
        }
        throw new IllegalStateException("Not initialized!");
    }

    private static Set<Encoding> d(Destination destination) {
        return destination instanceof EncodedDestination ? Collections.unmodifiableSet(((EncodedDestination) destination).a()) : Collections.singleton(Encoding.b("proto"));
    }

    public static void f(Context context) {
        if (f19451e == null) {
            synchronized (TransportRuntime.class) {
                try {
                    if (f19451e == null) {
                        f19451e = DaggerTransportRuntimeComponent.a().a(context).build();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    @VisibleForTesting
    static void i(TransportRuntimeComponent transportRuntimeComponent, Callable<Void> callable) throws Throwable {
        TransportRuntimeComponent transportRuntimeComponent2;
        synchronized (TransportRuntime.class) {
            transportRuntimeComponent2 = f19451e;
            f19451e = transportRuntimeComponent;
        }
        try {
            callable.call();
            synchronized (TransportRuntime.class) {
                f19451e = transportRuntimeComponent2;
            }
        } catch (Throwable th) {
            synchronized (TransportRuntime.class) {
                f19451e = transportRuntimeComponent2;
                throw th;
            }
        }
    }

    public void a(SendRequest sendRequest, TransportScheduleCallback transportScheduleCallback) {
        this.f19454c.a(sendRequest.f().f(sendRequest.c().d()), b(sendRequest), transportScheduleCallback);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Uploader e() {
        return this.f19455d;
    }

    public TransportFactory g(Destination destination) {
        return new TransportFactoryImpl(d(destination), TransportContext.a().b(destination.getName()).c(destination.getExtras()).a(), this);
    }

    @Deprecated
    public TransportFactory h(String str) {
        return new TransportFactoryImpl(d((Destination) null), TransportContext.a().b(str).a(), this);
    }
}
