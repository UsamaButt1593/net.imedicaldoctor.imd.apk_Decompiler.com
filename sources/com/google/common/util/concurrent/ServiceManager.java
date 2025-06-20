package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.ListenerCallQueue;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class ServiceManager implements ServiceManagerBridge {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final Logger f23203c = Logger.getLogger(ServiceManager.class.getName());
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final ListenerCallQueue.Event<Listener> f23204d = new ListenerCallQueue.Event<Listener>() {
        /* renamed from: b */
        public void a(Listener listener) {
            listener.b();
        }

        public String toString() {
            return "healthy()";
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final ListenerCallQueue.Event<Listener> f23205e = new ListenerCallQueue.Event<Listener>() {
        /* renamed from: b */
        public void a(Listener listener) {
            listener.c();
        }

        public String toString() {
            return "stopped()";
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final ServiceManagerState f23206a;

    /* renamed from: b  reason: collision with root package name */
    private final ImmutableList<Service> f23207b;

    private static final class EmptyServiceManagerWarning extends Throwable {
        private EmptyServiceManagerWarning() {
        }
    }

    public static abstract class Listener {
        public void a(Service service) {
        }

        public void b() {
        }

        public void c() {
        }
    }

    private static final class NoOpService extends AbstractService {
        private NoOpService() {
        }

        /* access modifiers changed from: protected */
        public void n() {
            v();
        }

        /* access modifiers changed from: protected */
        public void o() {
            w();
        }
    }

    private static final class ServiceListener extends Service.Listener {

        /* renamed from: a  reason: collision with root package name */
        final Service f23208a;

        /* renamed from: b  reason: collision with root package name */
        final WeakReference<ServiceManagerState> f23209b;

        ServiceListener(Service service, WeakReference<ServiceManagerState> weakReference) {
            this.f23208a = service;
            this.f23209b = weakReference;
        }

        public void a(Service.State state, Throwable th) {
            ServiceManagerState serviceManagerState = this.f23209b.get();
            if (serviceManagerState != null) {
                if (!(this.f23208a instanceof NoOpService)) {
                    Logger b2 = ServiceManager.f23203c;
                    Level level = Level.SEVERE;
                    b2.log(level, "Service " + this.f23208a + " has failed in the " + state + " state.", th);
                }
                serviceManagerState.n(this.f23208a, state, Service.State.FAILED);
            }
        }

        public void b() {
            ServiceManagerState serviceManagerState = this.f23209b.get();
            if (serviceManagerState != null) {
                serviceManagerState.n(this.f23208a, Service.State.STARTING, Service.State.RUNNING);
            }
        }

        public void c() {
            ServiceManagerState serviceManagerState = this.f23209b.get();
            if (serviceManagerState != null) {
                serviceManagerState.n(this.f23208a, Service.State.NEW, Service.State.STARTING);
                if (!(this.f23208a instanceof NoOpService)) {
                    ServiceManager.f23203c.log(Level.FINE, "Starting {0}.", this.f23208a);
                }
            }
        }

        public void d(Service.State state) {
            ServiceManagerState serviceManagerState = this.f23209b.get();
            if (serviceManagerState != null) {
                serviceManagerState.n(this.f23208a, state, Service.State.STOPPING);
            }
        }

        public void e(Service.State state) {
            ServiceManagerState serviceManagerState = this.f23209b.get();
            if (serviceManagerState != null) {
                if (!(this.f23208a instanceof NoOpService)) {
                    ServiceManager.f23203c.log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[]{this.f23208a, state});
                }
                serviceManagerState.n(this.f23208a, state, Service.State.TERMINATED);
            }
        }
    }

    private static final class ServiceManagerState {

        /* renamed from: a  reason: collision with root package name */
        final Monitor f23210a = new Monitor();
        @GuardedBy("monitor")

        /* renamed from: b  reason: collision with root package name */
        final SetMultimap<Service.State, Service> f23211b;
        @GuardedBy("monitor")

        /* renamed from: c  reason: collision with root package name */
        final Multiset<Service.State> f23212c;
        @GuardedBy("monitor")

        /* renamed from: d  reason: collision with root package name */
        final Map<Service, Stopwatch> f23213d;
        @GuardedBy("monitor")

        /* renamed from: e  reason: collision with root package name */
        boolean f23214e;
        @GuardedBy("monitor")

        /* renamed from: f  reason: collision with root package name */
        boolean f23215f;

        /* renamed from: g  reason: collision with root package name */
        final int f23216g;

        /* renamed from: h  reason: collision with root package name */
        final Monitor.Guard f23217h;

        /* renamed from: i  reason: collision with root package name */
        final Monitor.Guard f23218i;

        /* renamed from: j  reason: collision with root package name */
        final ListenerCallQueue<Listener> f23219j;

        final class AwaitHealthGuard extends Monitor.Guard {
            AwaitHealthGuard() {
                super(ServiceManagerState.this.f23210a);
            }

            @GuardedBy("ServiceManagerState.this.monitor")
            public boolean a() {
                int l1 = ServiceManagerState.this.f23212c.l1(Service.State.RUNNING);
                ServiceManagerState serviceManagerState = ServiceManagerState.this;
                return l1 == serviceManagerState.f23216g || serviceManagerState.f23212c.contains(Service.State.STOPPING) || ServiceManagerState.this.f23212c.contains(Service.State.TERMINATED) || ServiceManagerState.this.f23212c.contains(Service.State.FAILED);
            }
        }

        final class StoppedGuard extends Monitor.Guard {
            StoppedGuard() {
                super(ServiceManagerState.this.f23210a);
            }

            @GuardedBy("ServiceManagerState.this.monitor")
            public boolean a() {
                return ServiceManagerState.this.f23212c.l1(Service.State.TERMINATED) + ServiceManagerState.this.f23212c.l1(Service.State.FAILED) == ServiceManagerState.this.f23216g;
            }
        }

        ServiceManagerState(ImmutableCollection<Service> immutableCollection) {
            SetMultimap<K, V> j2 = MultimapBuilder.c(Service.State.class).g().a();
            this.f23211b = j2;
            this.f23212c = j2.d0();
            this.f23213d = Maps.b0();
            this.f23217h = new AwaitHealthGuard();
            this.f23218i = new StoppedGuard();
            this.f23219j = new ListenerCallQueue<>();
            this.f23216g = immutableCollection.size();
            j2.T0(Service.State.NEW, immutableCollection);
        }

        /* access modifiers changed from: package-private */
        public void a(Listener listener, Executor executor) {
            this.f23219j.b(listener, executor);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f23210a.q(this.f23217h);
            try {
                f();
            } finally {
                this.f23210a.D();
            }
        }

        /* access modifiers changed from: package-private */
        public void c(long j2, TimeUnit timeUnit) throws TimeoutException {
            this.f23210a.g();
            try {
                if (this.f23210a.N(this.f23217h, j2, timeUnit)) {
                    f();
                    return;
                }
                throw new TimeoutException("Timeout waiting for the services to become healthy. The following services have not started: " + Multimaps.n(this.f23211b, Predicates.n(ImmutableSet.M(Service.State.NEW, Service.State.STARTING))));
            } finally {
                this.f23210a.D();
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f23210a.q(this.f23218i);
            this.f23210a.D();
        }

        /* access modifiers changed from: package-private */
        public void e(long j2, TimeUnit timeUnit) throws TimeoutException {
            this.f23210a.g();
            try {
                if (!this.f23210a.N(this.f23218i, j2, timeUnit)) {
                    throw new TimeoutException("Timeout waiting for the services to stop. The following services have not stopped: " + Multimaps.n(this.f23211b, Predicates.q(Predicates.n(EnumSet.of(Service.State.TERMINATED, Service.State.FAILED)))));
                }
            } finally {
                this.f23210a.D();
            }
        }

        /* access modifiers changed from: package-private */
        @GuardedBy("monitor")
        public void f() {
            Multiset<Service.State> multiset = this.f23212c;
            Service.State state = Service.State.RUNNING;
            if (multiset.l1(state) != this.f23216g) {
                throw new IllegalStateException("Expected to be healthy after starting. The following services are not running: " + Multimaps.n(this.f23211b, Predicates.q(Predicates.m(state))));
            }
        }

        /* access modifiers changed from: package-private */
        public void g() {
            Preconditions.h0(!this.f23210a.B(), "It is incorrect to execute listeners with the monitor held.");
            this.f23219j.c();
        }

        /* access modifiers changed from: package-private */
        public void h(final Service service) {
            this.f23219j.d(new ListenerCallQueue.Event<Listener>(this) {
                /* renamed from: b */
                public void a(Listener listener) {
                    listener.a(service);
                }

                public String toString() {
                    return "failed({service=" + service + "})";
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void i() {
            this.f23219j.d(ServiceManager.f23204d);
        }

        /* access modifiers changed from: package-private */
        public void j() {
            this.f23219j.d(ServiceManager.f23205e);
        }

        /* access modifiers changed from: package-private */
        public void k() {
            this.f23210a.g();
            try {
                if (!this.f23215f) {
                    this.f23214e = true;
                    return;
                }
                ArrayList q = Lists.q();
                UnmodifiableIterator<Service> k2 = l().values().iterator();
                while (k2.hasNext()) {
                    Service next = k2.next();
                    if (next.c() != Service.State.NEW) {
                        q.add(next);
                    }
                }
                throw new IllegalArgumentException("Services started transitioning asynchronously before the ServiceManager was constructed: " + q);
            } finally {
                this.f23210a.D();
            }
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: package-private */
        public ImmutableSetMultimap<Service.State, Service> l() {
            ImmutableSetMultimap.Builder L = ImmutableSetMultimap.L();
            this.f23210a.g();
            try {
                for (Map.Entry entry : this.f23211b.j()) {
                    if (!(entry.getValue() instanceof NoOpService)) {
                        L.g(entry);
                    }
                }
                this.f23210a.D();
                return L.a();
            } catch (Throwable th) {
                this.f23210a.D();
                throw th;
            }
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: package-private */
        public ImmutableMap<Service, Long> m() {
            this.f23210a.g();
            try {
                ArrayList u = Lists.u(this.f23213d.size());
                for (Map.Entry next : this.f23213d.entrySet()) {
                    Service service = (Service) next.getKey();
                    Stopwatch stopwatch = (Stopwatch) next.getValue();
                    if (!stopwatch.i() && !(service instanceof NoOpService)) {
                        u.add(Maps.O(service, Long.valueOf(stopwatch.g(TimeUnit.MILLISECONDS))));
                    }
                }
                this.f23210a.D();
                Collections.sort(u, Ordering.z().D(new Function<Map.Entry<Service, Long>, Long>(this) {
                    /* renamed from: a */
                    public Long apply(Map.Entry<Service, Long> entry) {
                        return entry.getValue();
                    }
                }));
                return ImmutableMap.f(u);
            } catch (Throwable th) {
                this.f23210a.D();
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        public void n(Service service, Service.State state, Service.State state2) {
            Preconditions.E(service);
            Preconditions.d(state != state2);
            this.f23210a.g();
            try {
                this.f23215f = true;
                if (!this.f23214e) {
                    this.f23210a.D();
                    g();
                    return;
                }
                Preconditions.B0(this.f23211b.remove(state, service), "Service %s not at the expected location in the state map %s", service, state);
                Preconditions.B0(this.f23211b.put(state2, service), "Service %s in the state map unexpectedly at %s", service, state2);
                Stopwatch stopwatch = this.f23213d.get(service);
                if (stopwatch == null) {
                    stopwatch = Stopwatch.c();
                    this.f23213d.put(service, stopwatch);
                }
                Service.State state3 = Service.State.RUNNING;
                if (state2.compareTo(state3) >= 0 && stopwatch.i()) {
                    stopwatch.l();
                    if (!(service instanceof NoOpService)) {
                        ServiceManager.f23203c.log(Level.FINE, "Started {0} in {1}.", new Object[]{service, stopwatch});
                    }
                }
                Service.State state4 = Service.State.FAILED;
                if (state2 == state4) {
                    h(service);
                }
                if (this.f23212c.l1(state3) == this.f23216g) {
                    i();
                } else if (this.f23212c.l1(Service.State.TERMINATED) + this.f23212c.l1(state4) == this.f23216g) {
                    j();
                }
            } finally {
                this.f23210a.D();
                g();
            }
        }

        /* access modifiers changed from: package-private */
        public void o(Service service) {
            this.f23210a.g();
            try {
                if (this.f23213d.get(service) == null) {
                    this.f23213d.put(service, Stopwatch.c());
                }
            } finally {
                this.f23210a.D();
            }
        }
    }

    public ServiceManager(Iterable<? extends Service> iterable) {
        ImmutableList<E> z = ImmutableList.z(iterable);
        if (z.isEmpty()) {
            f23203c.log(Level.WARNING, "ServiceManager configured with no services.  Is your application configured properly?", new EmptyServiceManagerWarning());
            z = ImmutableList.K(new NoOpService());
        }
        ServiceManagerState serviceManagerState = new ServiceManagerState(z);
        this.f23206a = serviceManagerState;
        this.f23207b = z;
        WeakReference weakReference = new WeakReference(serviceManagerState);
        UnmodifiableIterator<E> k2 = z.iterator();
        while (k2.hasNext()) {
            Service service = (Service) k2.next();
            service.a(new ServiceListener(service, weakReference), MoreExecutors.c());
            Preconditions.u(service.c() == Service.State.NEW, "Can only manage NEW services, %s", service);
        }
        this.f23206a.k();
    }

    public void e(Listener listener, Executor executor) {
        this.f23206a.a(listener, executor);
    }

    public void f() {
        this.f23206a.b();
    }

    public void g(long j2, TimeUnit timeUnit) throws TimeoutException {
        this.f23206a.c(j2, timeUnit);
    }

    public void h() {
        this.f23206a.d();
    }

    public void i(long j2, TimeUnit timeUnit) throws TimeoutException {
        this.f23206a.e(j2, timeUnit);
    }

    public boolean j() {
        UnmodifiableIterator<Service> k2 = this.f23207b.iterator();
        while (k2.hasNext()) {
            if (!k2.next().isRunning()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: k */
    public ImmutableSetMultimap<Service.State, Service> a() {
        return this.f23206a.l();
    }

    @CanIgnoreReturnValue
    public ServiceManager l() {
        UnmodifiableIterator<Service> k2 = this.f23207b.iterator();
        while (k2.hasNext()) {
            Preconditions.x0(k2.next().c() == Service.State.NEW, "Not all services are NEW, cannot start %s", this);
        }
        UnmodifiableIterator<Service> k3 = this.f23207b.iterator();
        while (k3.hasNext()) {
            Service next = k3.next();
            try {
                this.f23206a.o(next);
                next.i();
            } catch (IllegalStateException e2) {
                Logger logger = f23203c;
                Level level = Level.WARNING;
                logger.log(level, "Unable to start Service " + next, e2);
            }
        }
        return this;
    }

    public ImmutableMap<Service, Long> m() {
        return this.f23206a.m();
    }

    @CanIgnoreReturnValue
    public ServiceManager n() {
        UnmodifiableIterator<Service> k2 = this.f23207b.iterator();
        while (k2.hasNext()) {
            k2.next().g();
        }
        return this;
    }

    public String toString() {
        return MoreObjects.b(ServiceManager.class).f("services", Collections2.d(this.f23207b, Predicates.q(Predicates.o(NoOpService.class)))).toString();
    }
}
