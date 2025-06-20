package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenerCallQueue;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public abstract class AbstractService implements Service {

    /* renamed from: h  reason: collision with root package name */
    private static final ListenerCallQueue.Event<Service.Listener> f23071h = new ListenerCallQueue.Event<Service.Listener>() {
        /* renamed from: b */
        public void a(Service.Listener listener) {
            listener.c();
        }

        public String toString() {
            return "starting()";
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private static final ListenerCallQueue.Event<Service.Listener> f23072i = new ListenerCallQueue.Event<Service.Listener>() {
        /* renamed from: b */
        public void a(Service.Listener listener) {
            listener.b();
        }

        public String toString() {
            return "running()";
        }
    };

    /* renamed from: j  reason: collision with root package name */
    private static final ListenerCallQueue.Event<Service.Listener> f23073j;

    /* renamed from: k  reason: collision with root package name */
    private static final ListenerCallQueue.Event<Service.Listener> f23074k;

    /* renamed from: l  reason: collision with root package name */
    private static final ListenerCallQueue.Event<Service.Listener> f23075l = y(Service.State.NEW);

    /* renamed from: m  reason: collision with root package name */
    private static final ListenerCallQueue.Event<Service.Listener> f23076m;

    /* renamed from: n  reason: collision with root package name */
    private static final ListenerCallQueue.Event<Service.Listener> f23077n;
    private static final ListenerCallQueue.Event<Service.Listener> o = y(Service.State.STOPPING);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Monitor f23078a = new Monitor();

    /* renamed from: b  reason: collision with root package name */
    private final Monitor.Guard f23079b = new IsStartableGuard();

    /* renamed from: c  reason: collision with root package name */
    private final Monitor.Guard f23080c = new IsStoppableGuard();

    /* renamed from: d  reason: collision with root package name */
    private final Monitor.Guard f23081d = new HasReachedRunningGuard();

    /* renamed from: e  reason: collision with root package name */
    private final Monitor.Guard f23082e = new IsStoppedGuard();

    /* renamed from: f  reason: collision with root package name */
    private final ListenerCallQueue<Service.Listener> f23083f = new ListenerCallQueue<>();

    /* renamed from: g  reason: collision with root package name */
    private volatile StateSnapshot f23084g = new StateSnapshot(Service.State.NEW);

    /* renamed from: com.google.common.util.concurrent.AbstractService$6  reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23089a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.common.util.concurrent.Service$State[] r0 = com.google.common.util.concurrent.Service.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23089a = r0
                com.google.common.util.concurrent.Service$State r1 = com.google.common.util.concurrent.Service.State.NEW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23089a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.common.util.concurrent.Service$State r1 = com.google.common.util.concurrent.Service.State.STARTING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f23089a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.common.util.concurrent.Service$State r1 = com.google.common.util.concurrent.Service.State.RUNNING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f23089a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.common.util.concurrent.Service$State r1 = com.google.common.util.concurrent.Service.State.STOPPING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f23089a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.common.util.concurrent.Service$State r1 = com.google.common.util.concurrent.Service.State.TERMINATED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f23089a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.common.util.concurrent.Service$State r1 = com.google.common.util.concurrent.Service.State.FAILED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractService.AnonymousClass6.<clinit>():void");
        }
    }

    private final class HasReachedRunningGuard extends Monitor.Guard {
        HasReachedRunningGuard() {
            super(AbstractService.this.f23078a);
        }

        public boolean a() {
            return AbstractService.this.c().compareTo(Service.State.RUNNING) >= 0;
        }
    }

    private final class IsStartableGuard extends Monitor.Guard {
        IsStartableGuard() {
            super(AbstractService.this.f23078a);
        }

        public boolean a() {
            return AbstractService.this.c() == Service.State.NEW;
        }
    }

    private final class IsStoppableGuard extends Monitor.Guard {
        IsStoppableGuard() {
            super(AbstractService.this.f23078a);
        }

        public boolean a() {
            return AbstractService.this.c().compareTo(Service.State.RUNNING) <= 0;
        }
    }

    private final class IsStoppedGuard extends Monitor.Guard {
        IsStoppedGuard() {
            super(AbstractService.this.f23078a);
        }

        public boolean a() {
            return AbstractService.this.c().compareTo(Service.State.TERMINATED) >= 0;
        }
    }

    private static final class StateSnapshot {

        /* renamed from: a  reason: collision with root package name */
        final Service.State f23094a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f23095b;
        @CheckForNull

        /* renamed from: c  reason: collision with root package name */
        final Throwable f23096c;

        StateSnapshot(Service.State state) {
            this(state, false, (Throwable) null);
        }

        /* access modifiers changed from: package-private */
        public Service.State a() {
            return (!this.f23095b || this.f23094a != Service.State.STARTING) ? this.f23094a : Service.State.STOPPING;
        }

        /* access modifiers changed from: package-private */
        public Throwable b() {
            Service.State state = this.f23094a;
            Preconditions.x0(state == Service.State.FAILED, "failureCause() is only valid if the service has failed, service is %s", state);
            Throwable th = this.f23096c;
            Objects.requireNonNull(th);
            return th;
        }

        StateSnapshot(Service.State state, boolean z, @CheckForNull Throwable th) {
            boolean z2 = true;
            Preconditions.u(!z || state == Service.State.STARTING, "shutdownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", state);
            Preconditions.y((th != null) != (state == Service.State.FAILED) ? false : z2, "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", state, th);
            this.f23094a = state;
            this.f23095b = z;
            this.f23096c = th;
        }
    }

    static {
        Service.State state = Service.State.STARTING;
        f23073j = x(state);
        Service.State state2 = Service.State.RUNNING;
        f23074k = x(state2);
        f23076m = y(state);
        f23077n = y(state2);
    }

    protected AbstractService() {
    }

    @GuardedBy("monitor")
    private void k(Service.State state) {
        Service.State c2 = c();
        if (c2 == state) {
            return;
        }
        if (c2 == Service.State.FAILED) {
            throw new IllegalStateException("Expected the service " + this + " to be " + state + ", but the service has FAILED", e());
        }
        throw new IllegalStateException("Expected the service " + this + " to be " + state + ", but was " + c2);
    }

    private void l() {
        if (!this.f23078a.B()) {
            this.f23083f.c();
        }
    }

    private void p(final Service.State state, final Throwable th) {
        this.f23083f.d(new ListenerCallQueue.Event<Service.Listener>(this) {
            /* renamed from: b */
            public void a(Service.Listener listener) {
                listener.a(state, th);
            }

            public String toString() {
                return "failed({from = " + state + ", cause = " + th + "})";
            }
        });
    }

    private void q() {
        this.f23083f.d(f23072i);
    }

    private void r() {
        this.f23083f.d(f23071h);
    }

    private void s(Service.State state) {
        ListenerCallQueue<Service.Listener> listenerCallQueue;
        ListenerCallQueue.Event<Service.Listener> event;
        if (state == Service.State.STARTING) {
            listenerCallQueue = this.f23083f;
            event = f23073j;
        } else if (state == Service.State.RUNNING) {
            listenerCallQueue = this.f23083f;
            event = f23074k;
        } else {
            throw new AssertionError();
        }
        listenerCallQueue.d(event);
    }

    private void t(Service.State state) {
        ListenerCallQueue<Service.Listener> listenerCallQueue;
        ListenerCallQueue.Event<Service.Listener> event;
        switch (AnonymousClass6.f23089a[state.ordinal()]) {
            case 1:
                listenerCallQueue = this.f23083f;
                event = f23075l;
                break;
            case 2:
                listenerCallQueue = this.f23083f;
                event = f23076m;
                break;
            case 3:
                listenerCallQueue = this.f23083f;
                event = f23077n;
                break;
            case 4:
                listenerCallQueue = this.f23083f;
                event = o;
                break;
            case 5:
            case 6:
                throw new AssertionError();
            default:
                return;
        }
        listenerCallQueue.d(event);
    }

    private static ListenerCallQueue.Event<Service.Listener> x(final Service.State state) {
        return new ListenerCallQueue.Event<Service.Listener>() {
            /* renamed from: b */
            public void a(Service.Listener listener) {
                listener.d(Service.State.this);
            }

            public String toString() {
                return "stopping({from = " + Service.State.this + "})";
            }
        };
    }

    private static ListenerCallQueue.Event<Service.Listener> y(final Service.State state) {
        return new ListenerCallQueue.Event<Service.Listener>() {
            /* renamed from: b */
            public void a(Service.Listener listener) {
                listener.e(Service.State.this);
            }

            public String toString() {
                return "terminated({from = " + Service.State.this + "})";
            }
        };
    }

    public final void a(Service.Listener listener, Executor executor) {
        this.f23083f.b(listener, executor);
    }

    public final void b(long j2, TimeUnit timeUnit) throws TimeoutException {
        if (this.f23078a.r(this.f23081d, j2, timeUnit)) {
            try {
                k(Service.State.RUNNING);
            } finally {
                this.f23078a.D();
            }
        } else {
            throw new TimeoutException("Timed out waiting for " + this + " to reach the RUNNING state.");
        }
    }

    public final Service.State c() {
        return this.f23084g.a();
    }

    public final void d() {
        this.f23078a.q(this.f23081d);
        try {
            k(Service.State.RUNNING);
        } finally {
            this.f23078a.D();
        }
    }

    public final Throwable e() {
        return this.f23084g.b();
    }

    public final void f(long j2, TimeUnit timeUnit) throws TimeoutException {
        if (this.f23078a.r(this.f23082e, j2, timeUnit)) {
            try {
                k(Service.State.TERMINATED);
            } finally {
                this.f23078a.D();
            }
        } else {
            throw new TimeoutException("Timed out waiting for " + this + " to reach a terminal state. Current state: " + c());
        }
    }

    @CanIgnoreReturnValue
    public final Service g() {
        if (this.f23078a.i(this.f23080c)) {
            try {
                Service.State c2 = c();
                switch (AnonymousClass6.f23089a[c2.ordinal()]) {
                    case 1:
                        this.f23084g = new StateSnapshot(Service.State.TERMINATED);
                        t(Service.State.NEW);
                        break;
                    case 2:
                        Service.State state = Service.State.STARTING;
                        this.f23084g = new StateSnapshot(state, true, (Throwable) null);
                        s(state);
                        m();
                        break;
                    case 3:
                        this.f23084g = new StateSnapshot(Service.State.STOPPING);
                        s(Service.State.RUNNING);
                        o();
                        break;
                    case 4:
                    case 5:
                    case 6:
                        throw new AssertionError("isStoppable is incorrectly implemented, saw: " + c2);
                }
            } catch (Throwable th) {
                this.f23078a.D();
                l();
                throw th;
            }
            this.f23078a.D();
            l();
        }
        return this;
    }

    public final void h() {
        this.f23078a.q(this.f23082e);
        try {
            k(Service.State.TERMINATED);
        } finally {
            this.f23078a.D();
        }
    }

    @CanIgnoreReturnValue
    public final Service i() {
        if (this.f23078a.i(this.f23079b)) {
            try {
                this.f23084g = new StateSnapshot(Service.State.STARTING);
                r();
                n();
            } catch (Throwable th) {
                this.f23078a.D();
                l();
                throw th;
            }
            this.f23078a.D();
            l();
            return this;
        }
        throw new IllegalStateException("Service " + this + " has already been started");
    }

    public final boolean isRunning() {
        return c() == Service.State.RUNNING;
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public void m() {
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public abstract void n();

    /* access modifiers changed from: protected */
    @ForOverride
    public abstract void o();

    public String toString() {
        return getClass().getSimpleName() + " [" + c() + "]";
    }

    /* access modifiers changed from: protected */
    public final void u(Throwable th) {
        Preconditions.E(th);
        this.f23078a.g();
        try {
            Service.State c2 = c();
            int i2 = AnonymousClass6.f23089a[c2.ordinal()];
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3 || i2 == 4) {
                    this.f23084g = new StateSnapshot(Service.State.FAILED, false, th);
                    p(c2, th);
                } else if (i2 != 5) {
                }
                return;
            }
            throw new IllegalStateException("Failed while in state:" + c2, th);
        } finally {
            this.f23078a.D();
            l();
        }
    }

    /* access modifiers changed from: protected */
    public final void v() {
        this.f23078a.g();
        try {
            if (this.f23084g.f23094a == Service.State.STARTING) {
                if (this.f23084g.f23095b) {
                    this.f23084g = new StateSnapshot(Service.State.STOPPING);
                    o();
                } else {
                    this.f23084g = new StateSnapshot(Service.State.RUNNING);
                    q();
                }
                return;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Cannot notifyStarted() when the service is " + this.f23084g.f23094a);
            u(illegalStateException);
            throw illegalStateException;
        } finally {
            this.f23078a.D();
            l();
        }
    }

    /* access modifiers changed from: protected */
    public final void w() {
        this.f23078a.g();
        try {
            Service.State c2 = c();
            switch (AnonymousClass6.f23089a[c2.ordinal()]) {
                case 1:
                case 5:
                case 6:
                    throw new IllegalStateException("Cannot notifyStopped() when the service is " + c2);
                case 2:
                case 3:
                case 4:
                    this.f23084g = new StateSnapshot(Service.State.TERMINATED);
                    t(c2);
                    break;
            }
        } finally {
            this.f23078a.D();
            l();
        }
    }
}
