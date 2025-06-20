package io.reactivex.rxjava3.internal.subscriptions;

import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public class SubscriptionArbiter extends AtomicInteger implements Subscription {
    private static final long b3 = -2189523197179400958L;
    long X;
    final AtomicLong X2 = new AtomicLong();
    final AtomicReference<Subscription> Y = new AtomicReference<>();
    final boolean Y2;
    final AtomicLong Z = new AtomicLong();
    volatile boolean Z2;
    protected boolean a3;
    Subscription s;

    public SubscriptionArbiter(boolean z) {
        this.Y2 = z;
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        if (getAndIncrement() == 0) {
            d();
        }
    }

    public void cancel() {
        if (!this.Z2) {
            this.Z2 = true;
            b();
        }
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        int i2 = 1;
        long j2 = 0;
        Subscription subscription = null;
        do {
            Subscription subscription2 = this.Y.get();
            if (subscription2 != null) {
                subscription2 = this.Y.getAndSet((Object) null);
            }
            long j3 = this.Z.get();
            if (j3 != 0) {
                j3 = this.Z.getAndSet(0);
            }
            long j4 = this.X2.get();
            if (j4 != 0) {
                j4 = this.X2.getAndSet(0);
            }
            Subscription subscription3 = this.s;
            if (this.Z2) {
                if (subscription3 != null) {
                    subscription3.cancel();
                    this.s = null;
                }
                if (subscription2 != null) {
                    subscription2.cancel();
                }
            } else {
                long j5 = this.X;
                if (j5 != Long.MAX_VALUE) {
                    j5 = BackpressureHelper.c(j5, j3);
                    if (j5 != Long.MAX_VALUE) {
                        j5 -= j4;
                        if (j5 < 0) {
                            SubscriptionHelper.f(j5);
                            j5 = 0;
                        }
                    }
                    this.X = j5;
                }
                if (subscription2 != null) {
                    if (subscription3 != null && this.Y2) {
                        subscription3.cancel();
                    }
                    this.s = subscription2;
                    if (j5 != 0) {
                        j2 = BackpressureHelper.c(j2, j5);
                        subscription = subscription2;
                    }
                } else if (!(subscription3 == null || j3 == 0)) {
                    j2 = BackpressureHelper.c(j2, j3);
                    subscription = subscription3;
                }
            }
            i2 = addAndGet(-i2);
        } while (i2 != 0);
        if (j2 != 0) {
            subscription.request(j2);
        }
    }

    public final boolean e() {
        return this.Z2;
    }

    public final boolean f() {
        return this.a3;
    }

    public final void g(long j2) {
        if (!this.a3) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                BackpressureHelper.a(this.X2, j2);
                b();
                return;
            }
            long j3 = this.X;
            if (j3 != Long.MAX_VALUE) {
                long j4 = j3 - j2;
                if (j4 < 0) {
                    SubscriptionHelper.f(j4);
                    j4 = 0;
                }
                this.X = j4;
            }
            if (decrementAndGet() != 0) {
                d();
            }
        }
    }

    public final void i(Subscription subscription) {
        if (this.Z2) {
            subscription.cancel();
            return;
        }
        Objects.requireNonNull(subscription, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            Subscription andSet = this.Y.getAndSet(subscription);
            if (andSet != null && this.Y2) {
                andSet.cancel();
            }
            b();
            return;
        }
        Subscription subscription2 = this.s;
        if (subscription2 != null && this.Y2) {
            subscription2.cancel();
        }
        this.s = subscription;
        long j2 = this.X;
        if (decrementAndGet() != 0) {
            d();
        }
        if (j2 != 0) {
            subscription.request(j2);
        }
    }

    public final void request(long j2) {
        if (SubscriptionHelper.k(j2) && !this.a3) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                BackpressureHelper.a(this.Z, j2);
                b();
                return;
            }
            long j3 = this.X;
            if (j3 != Long.MAX_VALUE) {
                long c2 = BackpressureHelper.c(j3, j2);
                this.X = c2;
                if (c2 == Long.MAX_VALUE) {
                    this.a3 = true;
                }
            }
            Subscription subscription = this.s;
            if (decrementAndGet() != 0) {
                d();
            }
            if (subscription != null) {
                subscription.request(j2);
            }
        }
    }
}
