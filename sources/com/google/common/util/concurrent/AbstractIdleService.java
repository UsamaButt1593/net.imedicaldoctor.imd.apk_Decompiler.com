package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.commons.lang3.StringUtils;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public abstract class AbstractIdleService implements Service {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Supplier<String> f23055a = new ThreadNameSupplier();

    /* renamed from: b  reason: collision with root package name */
    private final Service f23056b = new DelegateService();

    private final class DelegateService extends AbstractService {
        private DelegateService() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void B() {
            try {
                AbstractIdleService.this.p();
                v();
            } catch (Throwable th) {
                Platform.b(th);
                u(th);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void C() {
            try {
                AbstractIdleService.this.o();
                w();
            } catch (Throwable th) {
                Platform.b(th);
                u(th);
            }
        }

        /* access modifiers changed from: protected */
        public final void n() {
            MoreExecutors.q(AbstractIdleService.this.l(), AbstractIdleService.this.f23055a).execute(new C0478g(this));
        }

        /* access modifiers changed from: protected */
        public final void o() {
            MoreExecutors.q(AbstractIdleService.this.l(), AbstractIdleService.this.f23055a).execute(new C0477f(this));
        }

        public String toString() {
            return AbstractIdleService.this.toString();
        }
    }

    private final class ThreadNameSupplier implements Supplier<String> {
        private ThreadNameSupplier() {
        }

        /* renamed from: a */
        public String get() {
            return AbstractIdleService.this.n() + StringUtils.SPACE + AbstractIdleService.this.c();
        }
    }

    protected AbstractIdleService() {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(Runnable runnable) {
        MoreExecutors.n(this.f23055a.get(), runnable).start();
    }

    public final void a(Service.Listener listener, Executor executor) {
        this.f23056b.a(listener, executor);
    }

    public final void b(long j2, TimeUnit timeUnit) throws TimeoutException {
        this.f23056b.b(j2, timeUnit);
    }

    public final Service.State c() {
        return this.f23056b.c();
    }

    public final void d() {
        this.f23056b.d();
    }

    public final Throwable e() {
        return this.f23056b.e();
    }

    public final void f(long j2, TimeUnit timeUnit) throws TimeoutException {
        this.f23056b.f(j2, timeUnit);
    }

    @CanIgnoreReturnValue
    public final Service g() {
        this.f23056b.g();
        return this;
    }

    public final void h() {
        this.f23056b.h();
    }

    @CanIgnoreReturnValue
    public final Service i() {
        this.f23056b.i();
        return this;
    }

    public final boolean isRunning() {
        return this.f23056b.isRunning();
    }

    /* access modifiers changed from: protected */
    public Executor l() {
        return new C0476e(this);
    }

    /* access modifiers changed from: protected */
    public String n() {
        return getClass().getSimpleName();
    }

    /* access modifiers changed from: protected */
    public abstract void o() throws Exception;

    /* access modifiers changed from: protected */
    public abstract void p() throws Exception;

    public String toString() {
        return n() + " [" + c() + "]";
    }
}
