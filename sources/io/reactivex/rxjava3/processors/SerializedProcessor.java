package io.reactivex.rxjava3.processors;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

final class SerializedProcessor<T> extends FlowableProcessor<T> {
    final FlowableProcessor<T> X;
    volatile boolean X2;
    boolean Y;
    AppendOnlyLinkedArrayList<Object> Z;

    SerializedProcessor(FlowableProcessor<T> flowableProcessor) {
        this.X = flowableProcessor;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.e(subscriber);
    }

    public void h(Subscription subscription) {
        boolean z = true;
        if (!this.X2) {
            synchronized (this) {
                try {
                    if (!this.X2) {
                        if (this.Y) {
                            AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.Z;
                            if (appendOnlyLinkedArrayList == null) {
                                appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                                this.Z = appendOnlyLinkedArrayList;
                            }
                            appendOnlyLinkedArrayList.c(NotificationLite.r(subscription));
                            return;
                        }
                        this.Y = true;
                        z = false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (z) {
            subscription.cancel();
            return;
        }
        this.X.h(subscription);
        o9();
    }

    @Nullable
    public Throwable j9() {
        return this.X.j9();
    }

    public boolean k9() {
        return this.X.k9();
    }

    public boolean l9() {
        return this.X.l9();
    }

    public boolean m9() {
        return this.X.m9();
    }

    /* access modifiers changed from: package-private */
    public void o9() {
        AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                try {
                    appendOnlyLinkedArrayList = this.Z;
                    if (appendOnlyLinkedArrayList == null) {
                        this.Y = false;
                        return;
                    }
                    this.Z = null;
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            appendOnlyLinkedArrayList.b(this.X);
        }
    }

    public void onComplete() {
        if (!this.X2) {
            synchronized (this) {
                try {
                    if (!this.X2) {
                        this.X2 = true;
                        if (this.Y) {
                            AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.Z;
                            if (appendOnlyLinkedArrayList == null) {
                                appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                                this.Z = appendOnlyLinkedArrayList;
                            }
                            appendOnlyLinkedArrayList.c(NotificationLite.f());
                            return;
                        }
                        this.Y = true;
                        this.X.onComplete();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0031, code lost:
        if (r1 == false) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0033, code lost:
        io.reactivex.rxjava3.plugins.RxJavaPlugins.Y(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0037, code lost:
        r2.X.onError(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r3) {
        /*
            r2 = this;
            boolean r0 = r2.X2
            if (r0 == 0) goto L_0x0008
            io.reactivex.rxjava3.plugins.RxJavaPlugins.Y(r3)
            return
        L_0x0008:
            monitor-enter(r2)
            boolean r0 = r2.X2     // Catch:{ all -> 0x0022 }
            r1 = 1
            if (r0 == 0) goto L_0x000f
            goto L_0x0030
        L_0x000f:
            r2.X2 = r1     // Catch:{ all -> 0x0022 }
            boolean r0 = r2.Y     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x002d
            io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList<java.lang.Object> r0 = r2.Z     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x0024
            io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList r0 = new io.reactivex.rxjava3.internal.util.AppendOnlyLinkedArrayList     // Catch:{ all -> 0x0022 }
            r1 = 4
            r0.<init>(r1)     // Catch:{ all -> 0x0022 }
            r2.Z = r0     // Catch:{ all -> 0x0022 }
            goto L_0x0024
        L_0x0022:
            r3 = move-exception
            goto L_0x003d
        L_0x0024:
            java.lang.Object r3 = io.reactivex.rxjava3.internal.util.NotificationLite.h(r3)     // Catch:{ all -> 0x0022 }
            r0.f(r3)     // Catch:{ all -> 0x0022 }
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return
        L_0x002d:
            r2.Y = r1     // Catch:{ all -> 0x0022 }
            r1 = 0
        L_0x0030:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x0037
            io.reactivex.rxjava3.plugins.RxJavaPlugins.Y(r3)
            return
        L_0x0037:
            io.reactivex.rxjava3.processors.FlowableProcessor<T> r0 = r2.X
            r0.onError(r3)
            return
        L_0x003d:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.processors.SerializedProcessor.onError(java.lang.Throwable):void");
    }

    public void onNext(T t) {
        if (!this.X2) {
            synchronized (this) {
                try {
                    if (!this.X2) {
                        if (this.Y) {
                            AppendOnlyLinkedArrayList<Object> appendOnlyLinkedArrayList = this.Z;
                            if (appendOnlyLinkedArrayList == null) {
                                appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                                this.Z = appendOnlyLinkedArrayList;
                            }
                            appendOnlyLinkedArrayList.c(NotificationLite.q(t));
                            return;
                        }
                        this.Y = true;
                        this.X.onNext(t);
                        o9();
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }
    }
}
