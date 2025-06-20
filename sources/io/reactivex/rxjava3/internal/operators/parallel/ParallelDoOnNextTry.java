package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.parallel.ParallelFailureHandling;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelDoOnNextTry<T> extends ParallelFlowable<T> {

    /* renamed from: a  reason: collision with root package name */
    final ParallelFlowable<T> f28423a;

    /* renamed from: b  reason: collision with root package name */
    final Consumer<? super T> f28424b;

    /* renamed from: c  reason: collision with root package name */
    final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> f28425c;

    /* renamed from: io.reactivex.rxjava3.internal.operators.parallel.ParallelDoOnNextTry$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28426a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                io.reactivex.rxjava3.parallel.ParallelFailureHandling[] r0 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f28426a = r0
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r1 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.RETRY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f28426a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r1 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.SKIP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f28426a     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r1 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.STOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelDoOnNextTry.AnonymousClass1.<clinit>():void");
        }
    }

    static final class ParallelDoOnNextConditionalSubscriber<T> implements ConditionalSubscriber<T>, Subscription {
        final Consumer<? super T> X;
        boolean X2;
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> Y;
        Subscription Z;
        final ConditionalSubscriber<? super T> s;

        ParallelDoOnNextConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Consumer<? super T> consumer, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.s = conditionalSubscriber;
            this.X = consumer;
            this.Y = biFunction;
        }

        public void cancel() {
            this.Z.cancel();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Z, subscription)) {
                this.Z = subscription;
                this.s.h(this);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x003a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean o(T r10) {
            /*
                r9 = this;
                r0 = 2
                r1 = 1
                boolean r2 = r9.X2
                r3 = 0
                if (r2 == 0) goto L_0x0008
                return r3
            L_0x0008:
                r4 = 0
            L_0x000a:
                io.reactivex.rxjava3.functions.Consumer<? super T> r2 = r9.X     // Catch:{ all -> 0x0016 }
                r2.accept(r10)     // Catch:{ all -> 0x0016 }
                io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber<? super T> r0 = r9.s
                boolean r10 = r0.o(r10)
                return r10
            L_0x0016:
                r2 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.b(r2)
                io.reactivex.rxjava3.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.rxjava3.parallel.ParallelFailureHandling> r6 = r9.Y     // Catch:{ all -> 0x0048 }
                r7 = 1
                long r4 = r4 + r7
                java.lang.Long r7 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0048 }
                java.lang.Object r6 = r6.apply(r7, r2)     // Catch:{ all -> 0x0048 }
                java.lang.String r7 = "The errorHandler returned a null ParallelFailureHandling"
                java.util.Objects.requireNonNull(r6, r7)     // Catch:{ all -> 0x0048 }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r6 = (io.reactivex.rxjava3.parallel.ParallelFailureHandling) r6     // Catch:{ all -> 0x0048 }
                int[] r7 = io.reactivex.rxjava3.internal.operators.parallel.ParallelDoOnNextTry.AnonymousClass1.f28426a
                int r6 = r6.ordinal()
                r6 = r7[r6]
                if (r6 == r1) goto L_0x000a
                if (r6 == r0) goto L_0x0047
                r10 = 3
                r9.cancel()
                if (r6 == r10) goto L_0x0044
                r9.onError(r2)
                return r3
            L_0x0044:
                r9.onComplete()
            L_0x0047:
                return r3
            L_0x0048:
                r10 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.b(r10)
                r9.cancel()
                io.reactivex.rxjava3.exceptions.CompositeException r4 = new io.reactivex.rxjava3.exceptions.CompositeException
                java.lang.Throwable[] r0 = new java.lang.Throwable[r0]
                r0[r3] = r2
                r0[r1] = r10
                r4.<init>((java.lang.Throwable[]) r0)
                r9.onError(r4)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelDoOnNextTry.ParallelDoOnNextConditionalSubscriber.o(java.lang.Object):boolean");
        }

        public void onComplete() {
            if (!this.X2) {
                this.X2 = true;
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.X2) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.X2 = true;
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!o(t) && !this.X2) {
                this.Z.request(1);
            }
        }

        public void request(long j2) {
            this.Z.request(j2);
        }
    }

    static final class ParallelDoOnNextSubscriber<T> implements ConditionalSubscriber<T>, Subscription {
        final Consumer<? super T> X;
        boolean X2;
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> Y;
        Subscription Z;
        final Subscriber<? super T> s;

        ParallelDoOnNextSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.s = subscriber;
            this.X = consumer;
            this.Y = biFunction;
        }

        public void cancel() {
            this.Z.cancel();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Z, subscription)) {
                this.Z = subscription;
                this.s.h(this);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean o(T r10) {
            /*
                r9 = this;
                r0 = 2
                r1 = 1
                boolean r2 = r9.X2
                r3 = 0
                if (r2 == 0) goto L_0x0008
                return r3
            L_0x0008:
                r4 = 0
            L_0x000a:
                io.reactivex.rxjava3.functions.Consumer<? super T> r2 = r9.X     // Catch:{ all -> 0x0015 }
                r2.accept(r10)     // Catch:{ all -> 0x0015 }
                org.reactivestreams.Subscriber<? super T> r0 = r9.s
                r0.onNext(r10)
                return r1
            L_0x0015:
                r2 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.b(r2)
                io.reactivex.rxjava3.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.rxjava3.parallel.ParallelFailureHandling> r6 = r9.Y     // Catch:{ all -> 0x0047 }
                r7 = 1
                long r4 = r4 + r7
                java.lang.Long r7 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0047 }
                java.lang.Object r6 = r6.apply(r7, r2)     // Catch:{ all -> 0x0047 }
                java.lang.String r7 = "The errorHandler returned a null ParallelFailureHandling"
                java.util.Objects.requireNonNull(r6, r7)     // Catch:{ all -> 0x0047 }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r6 = (io.reactivex.rxjava3.parallel.ParallelFailureHandling) r6     // Catch:{ all -> 0x0047 }
                int[] r7 = io.reactivex.rxjava3.internal.operators.parallel.ParallelDoOnNextTry.AnonymousClass1.f28426a
                int r6 = r6.ordinal()
                r6 = r7[r6]
                if (r6 == r1) goto L_0x000a
                if (r6 == r0) goto L_0x0046
                r10 = 3
                r9.cancel()
                if (r6 == r10) goto L_0x0043
                r9.onError(r2)
                return r3
            L_0x0043:
                r9.onComplete()
            L_0x0046:
                return r3
            L_0x0047:
                r10 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.b(r10)
                r9.cancel()
                io.reactivex.rxjava3.exceptions.CompositeException r4 = new io.reactivex.rxjava3.exceptions.CompositeException
                java.lang.Throwable[] r0 = new java.lang.Throwable[r0]
                r0[r3] = r2
                r0[r1] = r10
                r4.<init>((java.lang.Throwable[]) r0)
                r9.onError(r4)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelDoOnNextTry.ParallelDoOnNextSubscriber.o(java.lang.Object):boolean");
        }

        public void onComplete() {
            if (!this.X2) {
                this.X2 = true;
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.X2) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.X2 = true;
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!o(t)) {
                this.Z.request(1);
            }
        }

        public void request(long j2) {
            this.Z.request(j2);
        }
    }

    public ParallelDoOnNextTry(ParallelFlowable<T> parallelFlowable, Consumer<? super T> consumer, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        this.f28423a = parallelFlowable;
        this.f28424b = consumer;
        this.f28425c = biFunction;
    }

    public int M() {
        return this.f28423a.M();
    }

    public void X(Subscriber<? super T>[] subscriberArr) {
        if (b0(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i2 = 0; i2 < length; i2++) {
                ConditionalSubscriber conditionalSubscriber = subscriberArr[i2];
                if (conditionalSubscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i2] = new ParallelDoOnNextConditionalSubscriber(conditionalSubscriber, this.f28424b, this.f28425c);
                } else {
                    subscriberArr2[i2] = new ParallelDoOnNextSubscriber(conditionalSubscriber, this.f28424b, this.f28425c);
                }
            }
            this.f28423a.X(subscriberArr2);
        }
    }
}
