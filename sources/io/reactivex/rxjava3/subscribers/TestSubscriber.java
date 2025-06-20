package io.reactivex.rxjava3.subscribers;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.observers.BaseTestConsumer;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class TestSubscriber<T> extends BaseTestConsumer<T, TestSubscriber<T>> implements FlowableSubscriber<T>, Subscription {
    private final Subscriber<? super T> b3;
    private volatile boolean c3;
    private final AtomicReference<Subscription> d3;
    private final AtomicLong e3;

    enum EmptySubscriber implements FlowableSubscriber<Object> {
        INSTANCE;

        public void h(Subscription subscription) {
        }

        public void onComplete() {
        }

        public void onError(Throwable th) {
        }

        public void onNext(Object obj) {
        }
    }

    public TestSubscriber() {
        this(EmptySubscriber.INSTANCE, Long.MAX_VALUE);
    }

    @NonNull
    public static <T> TestSubscriber<T> I() {
        return new TestSubscriber<>();
    }

    @NonNull
    public static <T> TestSubscriber<T> J(long j2) {
        return new TestSubscriber<>(j2);
    }

    public static <T> TestSubscriber<T> K(@NonNull Subscriber<? super T> subscriber) {
        return new TestSubscriber<>(subscriber);
    }

    /* access modifiers changed from: protected */
    /* renamed from: H */
    public final TestSubscriber<T> q() {
        if (this.d3.get() != null) {
            return this;
        }
        throw D("Not subscribed!");
    }

    public final boolean L() {
        return this.d3.get() != null;
    }

    public final boolean M() {
        return this.c3;
    }

    /* access modifiers changed from: protected */
    public void N() {
    }

    public final TestSubscriber<T> O(long j2) {
        request(j2);
        return this;
    }

    public final void cancel() {
        if (!this.c3) {
            this.c3 = true;
            SubscriptionHelper.a(this.d3);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean g() {
        return this.c3;
    }

    public void h(@NonNull Subscription subscription) {
        this.X2 = Thread.currentThread();
        if (subscription == null) {
            this.Y.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (!g.a(this.d3, (Object) null, subscription)) {
            subscription.cancel();
            if (this.d3.get() != SubscriptionHelper.CANCELLED) {
                List<Throwable> list = this.Y;
                list.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + subscription));
            }
        } else {
            this.b3.h(subscription);
            long andSet = this.e3.getAndSet(0);
            if (andSet != 0) {
                subscription.request(andSet);
            }
            N();
        }
    }

    /* access modifiers changed from: protected */
    public final void m() {
        cancel();
    }

    public void onComplete() {
        if (!this.Y2) {
            this.Y2 = true;
            if (this.d3.get() == null) {
                this.Y.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.X2 = Thread.currentThread();
            this.Z++;
            this.b3.onComplete();
        } finally {
            this.s.countDown();
        }
    }

    public void onError(@NonNull Throwable th) {
        if (!this.Y2) {
            this.Y2 = true;
            if (this.d3.get() == null) {
                this.Y.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.X2 = Thread.currentThread();
            if (th == null) {
                this.Y.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.Y.add(th);
            }
            this.b3.onError(th);
            this.s.countDown();
        } catch (Throwable th2) {
            this.s.countDown();
            throw th2;
        }
    }

    public void onNext(@NonNull T t) {
        if (!this.Y2) {
            this.Y2 = true;
            if (this.d3.get() == null) {
                this.Y.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.X2 = Thread.currentThread();
        this.X.add(t);
        if (t == null) {
            this.Y.add(new NullPointerException("onNext received a null value"));
        }
        this.b3.onNext(t);
    }

    public final void request(long j2) {
        SubscriptionHelper.b(this.d3, this.e3, j2);
    }

    public TestSubscriber(long j2) {
        this(EmptySubscriber.INSTANCE, j2);
    }

    public TestSubscriber(@NonNull Subscriber<? super T> subscriber) {
        this(subscriber, Long.MAX_VALUE);
    }

    public TestSubscriber(@NonNull Subscriber<? super T> subscriber, long j2) {
        if (j2 >= 0) {
            this.b3 = subscriber;
            this.d3 = new AtomicReference<>();
            this.e3 = new AtomicLong(j2);
            return;
        }
        throw new IllegalArgumentException("Negative initial request not allowed");
    }
}
