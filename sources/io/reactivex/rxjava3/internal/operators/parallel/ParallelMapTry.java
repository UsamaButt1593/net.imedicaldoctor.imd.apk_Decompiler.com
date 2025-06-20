package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.parallel.ParallelFailureHandling;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelMapTry<T, R> extends ParallelFlowable<R> {

    /* renamed from: a  reason: collision with root package name */
    final ParallelFlowable<T> f28447a;

    /* renamed from: b  reason: collision with root package name */
    final Function<? super T, ? extends R> f28448b;

    /* renamed from: c  reason: collision with root package name */
    final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> f28449c;

    /* renamed from: io.reactivex.rxjava3.internal.operators.parallel.ParallelMapTry$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28450a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                io.reactivex.rxjava3.parallel.ParallelFailureHandling[] r0 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f28450a = r0
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r1 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.RETRY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f28450a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r1 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.SKIP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f28450a     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r1 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.STOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelMapTry.AnonymousClass1.<clinit>():void");
        }
    }

    static final class ParallelMapTryConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {
        final Function<? super T, ? extends R> X;
        boolean X2;
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> Y;
        Subscription Z;
        final ConditionalSubscriber<? super R> s;

        ParallelMapTryConditionalSubscriber(ConditionalSubscriber<? super R> conditionalSubscriber, Function<? super T, ? extends R> function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.s = conditionalSubscriber;
            this.X = function;
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

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0040  */
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
                io.reactivex.rxjava3.functions.Function<? super T, ? extends R> r2 = r9.X     // Catch:{ all -> 0x001c }
                java.lang.Object r2 = r2.apply(r10)     // Catch:{ all -> 0x001c }
                java.lang.String r6 = "The mapper returned a null value"
                java.util.Objects.requireNonNull(r2, r6)     // Catch:{ all -> 0x001c }
                io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber<? super R> r10 = r9.s
                boolean r10 = r10.o(r2)
                return r10
            L_0x001c:
                r2 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.b(r2)
                io.reactivex.rxjava3.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.rxjava3.parallel.ParallelFailureHandling> r6 = r9.Y     // Catch:{ all -> 0x004e }
                r7 = 1
                long r4 = r4 + r7
                java.lang.Long r7 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x004e }
                java.lang.Object r6 = r6.apply(r7, r2)     // Catch:{ all -> 0x004e }
                java.lang.String r7 = "The errorHandler returned a null ParallelFailureHandling"
                java.util.Objects.requireNonNull(r6, r7)     // Catch:{ all -> 0x004e }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r6 = (io.reactivex.rxjava3.parallel.ParallelFailureHandling) r6     // Catch:{ all -> 0x004e }
                int[] r7 = io.reactivex.rxjava3.internal.operators.parallel.ParallelMapTry.AnonymousClass1.f28450a
                int r6 = r6.ordinal()
                r6 = r7[r6]
                if (r6 == r1) goto L_0x000a
                if (r6 == r0) goto L_0x004d
                r10 = 3
                r9.cancel()
                if (r6 == r10) goto L_0x004a
                r9.onError(r2)
                return r3
            L_0x004a:
                r9.onComplete()
            L_0x004d:
                return r3
            L_0x004e:
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelMapTry.ParallelMapTryConditionalSubscriber.o(java.lang.Object):boolean");
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

    static final class ParallelMapTrySubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {
        final Function<? super T, ? extends R> X;
        boolean X2;
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> Y;
        Subscription Z;
        final Subscriber<? super R> s;

        ParallelMapTrySubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends R> function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.s = subscriber;
            this.X = function;
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

        /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
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
                io.reactivex.rxjava3.functions.Function<? super T, ? extends R> r2 = r9.X     // Catch:{ all -> 0x001b }
                java.lang.Object r2 = r2.apply(r10)     // Catch:{ all -> 0x001b }
                java.lang.String r6 = "The mapper returned a null value"
                java.util.Objects.requireNonNull(r2, r6)     // Catch:{ all -> 0x001b }
                org.reactivestreams.Subscriber<? super R> r10 = r9.s
                r10.onNext(r2)
                return r1
            L_0x001b:
                r2 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.b(r2)
                io.reactivex.rxjava3.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.rxjava3.parallel.ParallelFailureHandling> r6 = r9.Y     // Catch:{ all -> 0x004d }
                r7 = 1
                long r4 = r4 + r7
                java.lang.Long r7 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x004d }
                java.lang.Object r6 = r6.apply(r7, r2)     // Catch:{ all -> 0x004d }
                java.lang.String r7 = "The errorHandler returned a null ParallelFailureHandling"
                java.util.Objects.requireNonNull(r6, r7)     // Catch:{ all -> 0x004d }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r6 = (io.reactivex.rxjava3.parallel.ParallelFailureHandling) r6     // Catch:{ all -> 0x004d }
                int[] r7 = io.reactivex.rxjava3.internal.operators.parallel.ParallelMapTry.AnonymousClass1.f28450a
                int r6 = r6.ordinal()
                r6 = r7[r6]
                if (r6 == r1) goto L_0x000a
                if (r6 == r0) goto L_0x004c
                r10 = 3
                r9.cancel()
                if (r6 == r10) goto L_0x0049
                r9.onError(r2)
                return r3
            L_0x0049:
                r9.onComplete()
            L_0x004c:
                return r3
            L_0x004d:
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelMapTry.ParallelMapTrySubscriber.o(java.lang.Object):boolean");
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

    public ParallelMapTry(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends R> function, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        this.f28447a = parallelFlowable;
        this.f28448b = function;
        this.f28449c = biFunction;
    }

    public int M() {
        return this.f28447a.M();
    }

    public void X(Subscriber<? super R>[] subscriberArr) {
        if (b0(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i2 = 0; i2 < length; i2++) {
                ConditionalSubscriber conditionalSubscriber = subscriberArr[i2];
                if (conditionalSubscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i2] = new ParallelMapTryConditionalSubscriber(conditionalSubscriber, this.f28448b, this.f28449c);
                } else {
                    subscriberArr2[i2] = new ParallelMapTrySubscriber(conditionalSubscriber, this.f28448b, this.f28449c);
                }
            }
            this.f28447a.X(subscriberArr2);
        }
    }
}
