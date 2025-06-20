package org.threeten.bp.zone;

import androidx.lifecycle.g;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public abstract class ZoneRulesInitializer {

    /* renamed from: a  reason: collision with root package name */
    public static final ZoneRulesInitializer f31887a = new DoNothingZoneRulesInitializer();

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicBoolean f31888b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicReference<ZoneRulesInitializer> f31889c = new AtomicReference<>();

    static class DoNothingZoneRulesInitializer extends ZoneRulesInitializer {
        DoNothingZoneRulesInitializer() {
        }

        /* access modifiers changed from: protected */
        public void b() {
        }
    }

    static class ServiceLoaderZoneRulesInitializer extends ZoneRulesInitializer {
        ServiceLoaderZoneRulesInitializer() {
        }

        /* access modifiers changed from: protected */
        public void b() {
            Class<ZoneRulesProvider> cls = ZoneRulesProvider.class;
            Iterator<S> it2 = ServiceLoader.load(cls, cls.getClassLoader()).iterator();
            while (it2.hasNext()) {
                try {
                    ZoneRulesProvider.j((ZoneRulesProvider) it2.next());
                } catch (ServiceConfigurationError e2) {
                    if (!(e2.getCause() instanceof SecurityException)) {
                        throw e2;
                    }
                }
            }
        }
    }

    static void a() {
        if (!f31888b.getAndSet(true)) {
            AtomicReference<ZoneRulesInitializer> atomicReference = f31889c;
            g.a(atomicReference, (Object) null, new ServiceLoaderZoneRulesInitializer());
            atomicReference.get().b();
            return;
        }
        throw new IllegalStateException("Already initialized");
    }

    public static void c(ZoneRulesInitializer zoneRulesInitializer) {
        if (f31888b.get()) {
            throw new IllegalStateException("Already initialized");
        } else if (!g.a(f31889c, (Object) null, zoneRulesInitializer)) {
            throw new IllegalStateException("Initializer was already set, possibly with a default during initialization");
        }
    }

    /* access modifiers changed from: protected */
    public abstract void b();
}
