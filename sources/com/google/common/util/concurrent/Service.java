package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@DoNotMock("Create an AbstractIdleService")
public interface Service {

    public static abstract class Listener {
        public void a(State state, Throwable th) {
        }

        public void b() {
        }

        public void c() {
        }

        public void d(State state) {
        }

        public void e(State state) {
        }
    }

    public enum State {
        NEW,
        STARTING,
        RUNNING,
        STOPPING,
        TERMINATED,
        FAILED
    }

    void a(Listener listener, Executor executor);

    void b(long j2, TimeUnit timeUnit) throws TimeoutException;

    State c();

    void d();

    Throwable e();

    void f(long j2, TimeUnit timeUnit) throws TimeoutException;

    @CanIgnoreReturnValue
    Service g();

    void h();

    @CanIgnoreReturnValue
    Service i();

    boolean isRunning();
}
