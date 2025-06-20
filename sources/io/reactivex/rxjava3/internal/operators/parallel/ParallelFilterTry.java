package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.parallel.ParallelFailureHandling;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelFilterTry<T> extends ParallelFlowable<T> {

    /* renamed from: a  reason: collision with root package name */
    final ParallelFlowable<T> f28429a;

    /* renamed from: b  reason: collision with root package name */
    final Predicate<? super T> f28430b;

    /* renamed from: c  reason: collision with root package name */
    final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> f28431c;

    /* renamed from: io.reactivex.rxjava3.internal.operators.parallel.ParallelFilterTry$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28432a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                io.reactivex.rxjava3.parallel.ParallelFailureHandling[] r0 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f28432a = r0
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r1 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.RETRY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f28432a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r1 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.SKIP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f28432a     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r1 = io.reactivex.rxjava3.parallel.ParallelFailureHandling.STOP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelFilterTry.AnonymousClass1.<clinit>():void");
        }
    }

    static abstract class BaseFilterSubscriber<T> implements ConditionalSubscriber<T>, Subscription {
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> X;
        Subscription Y;
        boolean Z;
        final Predicate<? super T> s;

        BaseFilterSubscriber(Predicate<? super T> predicate, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.s = predicate;
            this.X = biFunction;
        }

        public final void cancel() {
            this.Y.cancel();
        }

        public final void onNext(T t) {
            if (!o(t) && !this.Z) {
                this.Y.request(1);
            }
        }

        public final void request(long j2) {
            this.Y.request(j2);
        }
    }

    static final class ParallelFilterConditionalSubscriber<T> extends BaseFilterSubscriber<T> {
        final ConditionalSubscriber<? super T> X2;

        ParallelFilterConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Predicate<? super T> predicate, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            super(predicate, biFunction);
            this.X2 = conditionalSubscriber;
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Y, subscription)) {
                this.Y = subscription;
                this.X2.h(this);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0040  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean o(T r10) {
            /*
                r9 = this;
                r0 = 2
                r1 = 1
                boolean r2 = r9.Z
                r3 = 0
                if (r2 != 0) goto L_0x0063
                r4 = 0
            L_0x0009:
                io.reactivex.rxjava3.functions.Predicate<? super T> r2 = r9.s     // Catch:{ all -> 0x001c }
                boolean r0 = r2.test(r10)     // Catch:{ all -> 0x001c }
                if (r0 == 0) goto L_0x001a
                io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber<? super T> r0 = r9.X2
                boolean r10 = r0.o(r10)
                if (r10 == 0) goto L_0x001a
                goto L_0x001b
            L_0x001a:
                r1 = 0
            L_0x001b:
                return r1
            L_0x001c:
                r2 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.b(r2)
                io.reactivex.rxjava3.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.rxjava3.parallel.ParallelFailureHandling> r6 = r9.X     // Catch:{ all -> 0x004e }
                r7 = 1
                long r4 = r4 + r7
                java.lang.Long r7 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x004e }
                java.lang.Object r6 = r6.apply(r7, r2)     // Catch:{ all -> 0x004e }
                java.lang.String r7 = "The errorHandler returned a null ParallelFailureHandling"
                java.util.Objects.requireNonNull(r6, r7)     // Catch:{ all -> 0x004e }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r6 = (io.reactivex.rxjava3.parallel.ParallelFailureHandling) r6     // Catch:{ all -> 0x004e }
                int[] r7 = io.reactivex.rxjava3.internal.operators.parallel.ParallelFilterTry.AnonymousClass1.f28432a
                int r6 = r6.ordinal()
                r6 = r7[r6]
                if (r6 == r1) goto L_0x0009
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
            L_0x0063:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelFilterTry.ParallelFilterConditionalSubscriber.o(java.lang.Object):boolean");
        }

        public void onComplete() {
            if (!this.Z) {
                this.Z = true;
                this.X2.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.Z) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Z = true;
            this.X2.onError(th);
        }
    }

    static final class ParallelFilterSubscriber<T> extends BaseFilterSubscriber<T> {
        final Subscriber<? super T> X2;

        ParallelFilterSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            super(predicate, biFunction);
            this.X2 = subscriber;
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Y, subscription)) {
                this.Y = subscription;
                this.X2.h(this);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x003c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean o(T r10) {
            /*
                r9 = this;
                r0 = 2
                r1 = 1
                boolean r2 = r9.Z
                r3 = 0
                if (r2 != 0) goto L_0x005f
                r4 = 0
            L_0x0009:
                io.reactivex.rxjava3.functions.Predicate<? super T> r2 = r9.s     // Catch:{ all -> 0x0018 }
                boolean r0 = r2.test(r10)     // Catch:{ all -> 0x0018 }
                if (r0 == 0) goto L_0x0017
                org.reactivestreams.Subscriber<? super T> r0 = r9.X2
                r0.onNext(r10)
                return r1
            L_0x0017:
                return r3
            L_0x0018:
                r2 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.b(r2)
                io.reactivex.rxjava3.functions.BiFunction<? super java.lang.Long, ? super java.lang.Throwable, io.reactivex.rxjava3.parallel.ParallelFailureHandling> r6 = r9.X     // Catch:{ all -> 0x004a }
                r7 = 1
                long r4 = r4 + r7
                java.lang.Long r7 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x004a }
                java.lang.Object r6 = r6.apply(r7, r2)     // Catch:{ all -> 0x004a }
                java.lang.String r7 = "The errorHandler returned a null ParallelFailureHandling"
                java.util.Objects.requireNonNull(r6, r7)     // Catch:{ all -> 0x004a }
                io.reactivex.rxjava3.parallel.ParallelFailureHandling r6 = (io.reactivex.rxjava3.parallel.ParallelFailureHandling) r6     // Catch:{ all -> 0x004a }
                int[] r7 = io.reactivex.rxjava3.internal.operators.parallel.ParallelFilterTry.AnonymousClass1.f28432a
                int r6 = r6.ordinal()
                r6 = r7[r6]
                if (r6 == r1) goto L_0x0009
                if (r6 == r0) goto L_0x0049
                r10 = 3
                r9.cancel()
                if (r6 == r10) goto L_0x0046
                r9.onError(r2)
                return r3
            L_0x0046:
                r9.onComplete()
            L_0x0049:
                return r3
            L_0x004a:
                r10 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.b(r10)
                r9.cancel()
                io.reactivex.rxjava3.exceptions.CompositeException r4 = new io.reactivex.rxjava3.exceptions.CompositeException
                java.lang.Throwable[] r0 = new java.lang.Throwable[r0]
                r0[r3] = r2
                r0[r1] = r10
                r4.<init>((java.lang.Throwable[]) r0)
                r9.onError(r4)
            L_0x005f:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.parallel.ParallelFilterTry.ParallelFilterSubscriber.o(java.lang.Object):boolean");
        }

        public void onComplete() {
            if (!this.Z) {
                this.Z = true;
                this.X2.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.Z) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Z = true;
            this.X2.onError(th);
        }
    }

    public ParallelFilterTry(ParallelFlowable<T> parallelFlowable, Predicate<? super T> predicate, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        this.f28429a = parallelFlowable;
        this.f28430b = predicate;
        this.f28431c = biFunction;
    }

    public int M() {
        return this.f28429a.M();
    }

    public void X(Subscriber<? super T>[] subscriberArr) {
        if (b0(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i2 = 0; i2 < length; i2++) {
                ConditionalSubscriber conditionalSubscriber = subscriberArr[i2];
                if (conditionalSubscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i2] = new ParallelFilterConditionalSubscriber(conditionalSubscriber, this.f28430b, this.f28431c);
                } else {
                    subscriberArr2[i2] = new ParallelFilterSubscriber(conditionalSubscriber, this.f28430b, this.f28431c);
                }
            }
            this.f28429a.X(subscriberArr2);
        }
    }
}
