package io.reactivex.rxjava3.subscribers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class SerializedSubscriber<T> implements FlowableSubscriber<T>, Subscription {
    static final int Z2 = 4;
    final boolean X;
    AppendOnlyLinkedArrayList<Object> X2;
    Subscription Y;
    volatile boolean Y2;
    boolean Z;
    final Subscriber<? super T> s;

    public SerializedSubscriber(Subscriber<? super T> subscriber) {
        this(subscriber, false);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        do {
            synchronized (this) {
                try {
                    appendOnlyLinkedArrayList = this.X2;
                    if (appendOnlyLinkedArrayList == null) {
                        this.Z = false;
                        return;
                    }
                    this.X2 = null;
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        } while (!appendOnlyLinkedArrayList.b(this.s));
    }

    public void cancel() {
        this.Y.cancel();
    }

    public void h(@NonNull Subscription subscription) {
        if (SubscriptionHelper.l(this.Y, subscription)) {
            this.Y = subscription;
            this.s.h(this);
        }
    }

    public void onComplete() {
        if (!this.Y2) {
            synchronized (this) {
                try {
                    if (!this.Y2) {
                        if (this.Z) {
                            AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.X2;
                            if (appendOnlyLinkedArrayList == null) {
                                appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                                this.X2 = appendOnlyLinkedArrayList;
                            }
                            appendOnlyLinkedArrayList.c(NotificationLite.f());
                            return;
                        }
                        this.Y2 = true;
                        this.Z = true;
                        this.s.onComplete();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003b, code lost:
        if (r1 == false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003d, code lost:
        io.reactivex.rxjava3.plugins.RxJavaPlugins.Y(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0040, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0041, code lost:
        r2.s.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.Y2
            if (r0 == 0) goto L_0x0008
            io.reactivex.rxjava3.plugins.RxJavaPlugins.Y(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.Y2     // Catch:{ all -> 0x0022 }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x003a
        L_0x000f:
            boolean r0 = r2.Z     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0035
            r2.Y2 = r1     // Catch:{ all -> 0x0022 }
            io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.X2     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x0024
            io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0022 }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x0022 }
            r2.X2 = r0     // Catch:{ all -> 0x0022 }
            goto L_0x0024
        L_0x0022:
            r3 = move-exception
            goto L_0x0047
        L_0x0024:
            java.lang.Object r3 = io.reactivex.rxjava3.internal.util.NotificationLite.h(r3)     // Catch:{ all -> 0x0022 }
            boolean r1 = r2.X     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x0030
            r0.c(r3)     // Catch:{ all -> 0x0022 }
            goto L_0x0033
        L_0x0030:
            r0.f(r3)     // Catch:{ all -> 0x0022 }
        L_0x0033:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return
        L_0x0035:
            r2.Y2 = r1     // Catch:{ all -> 0x0022 }
            r2.Z = r1     // Catch:{ all -> 0x0022 }
            r1 = 0
        L_0x003a:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x0041
            io.reactivex.rxjava3.plugins.RxJavaPlugins.Y(r3)
            return
        L_0x0041:
            org.reactivestreams.Subscriber<? super T> r0 = r2.s
            r0.onError(r3)
            return
        L_0x0047:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.subscribers.SerializedSubscriber.onError(java.lang.Throwable):void");
    }

    public void onNext(@NonNull T t) {
        if (!this.Y2) {
            if (t == null) {
                this.Y.cancel();
                onError(ExceptionHelper.b("onNext called with a null value."));
                return;
            }
            synchronized (this) {
                try {
                    if (!this.Y2) {
                        if (this.Z) {
                            AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.X2;
                            if (appendOnlyLinkedArrayList == null) {
                                appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                                this.X2 = appendOnlyLinkedArrayList;
                            }
                            appendOnlyLinkedArrayList.c(NotificationLite.q(t));
                            return;
                        }
                        this.Z = true;
                        this.s.onNext(t);
                        a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
    }

    public void request(long j2) {
        this.Y.request(j2);
    }

    public SerializedSubscriber(@NonNull Subscriber<? super T> subscriber, boolean z) {
        this.s = subscriber;
        this.X = z;
    }
}
