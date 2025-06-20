package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
public abstract class AbstractExecutionThreadService implements Service {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Logger f23029b = Logger.getLogger(AbstractExecutionThreadService.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final Service f23030a = new AbstractService() {
        /* access modifiers changed from: private */
        public /* synthetic */ String B() {
            return AbstractExecutionThreadService.this.o();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void C() {
            try {
                AbstractExecutionThreadService.this.q();
                v();
                if (isRunning()) {
                    AbstractExecutionThreadService.this.n();
                }
                AbstractExecutionThreadService.this.p();
                w();
            } catch (Throwable th) {
                Platform.b(th);
                u(th);
            }
        }

        /* access modifiers changed from: protected */
        public final void n() {
            MoreExecutors.q(AbstractExecutionThreadService.this.l(), new C0473b(this)).execute(new C0474c(this));
        }

        /* access modifiers changed from: protected */
        public void o() {
            AbstractExecutionThreadService.this.r();
        }

        public String toString() {
            return AbstractExecutionThreadService.this.toString();
        }
    };

    protected AbstractExecutionThreadService() {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(Runnable runnable) {
        MoreExecutors.n(o(), runnable).start();
    }

    public final void a(Service.Listener listener, Executor executor) {
        this.f23030a.a(listener, executor);
    }

    public final void b(long j2, TimeUnit timeUnit) throws TimeoutException {
        this.f23030a.b(j2, timeUnit);
    }

    public final Service.State c() {
        return this.f23030a.c();
    }

    public final void d() {
        this.f23030a.d();
    }

    public final Throwable e() {
        return this.f23030a.e();
    }

    public final void f(long j2, TimeUnit timeUnit) throws TimeoutException {
        this.f23030a.f(j2, timeUnit);
    }

    @CanIgnoreReturnValue
    public final Service g() {
        this.f23030a.g();
        return this;
    }

    public final void h() {
        this.f23030a.h();
    }

    @CanIgnoreReturnValue
    public final Service i() {
        this.f23030a.i();
        return this;
    }

    public final boolean isRunning() {
        return this.f23030a.isRunning();
    }

    /* access modifiers changed from: protected */
    public Executor l() {
        return new C0472a(this);
    }

    /* access modifiers changed from: protected */
    public abstract void n() throws Exception;

    /* access modifiers changed from: protected */
    public String o() {
        return getClass().getSimpleName();
    }

    /* access modifiers changed from: protected */
    public void p() throws Exception {
    }

    /* access modifiers changed from: protected */
    public void q() throws Exception {
    }

    /* access modifiers changed from: protected */
    public void r() {
    }

    public String toString() {
        return o() + " [" + c() + "]";
    }
}
