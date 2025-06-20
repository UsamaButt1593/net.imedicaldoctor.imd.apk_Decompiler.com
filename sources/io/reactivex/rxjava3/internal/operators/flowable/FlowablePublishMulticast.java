package io.reactivex.rxjava3.internal.operators.flowable;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowablePublishMulticast<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final boolean X2;
    final Function<? super Flowable<T>, ? extends Publisher<? extends R>> Y;
    final int Z;

    static final class MulticastProcessor<T> extends Flowable<T> implements FlowableSubscriber<T> {
        static final MulticastSubscription[] f3 = new MulticastSubscription[0];
        static final MulticastSubscription[] g3 = new MulticastSubscription[0];
        final AtomicInteger X = new AtomicInteger();
        final int X2;
        final AtomicReference<MulticastSubscription<T>[]> Y = new AtomicReference<>(f3);
        final boolean Y2;
        final int Z;
        final AtomicReference<Subscription> Z2 = new AtomicReference<>();
        volatile SimpleQueue<T> a3;
        int b3;
        volatile boolean c3;
        Throwable d3;
        int e3;

        MulticastProcessor(int i2, boolean z) {
            this.Z = i2;
            this.X2 = i2 - (i2 >> 2);
            this.Y2 = z;
        }

        /* access modifiers changed from: protected */
        public void K6(Subscriber<? super T> subscriber) {
            MulticastSubscription multicastSubscription = new MulticastSubscription(subscriber, this);
            subscriber.h(multicastSubscription);
            if (!j9(multicastSubscription)) {
                Throwable th = this.d3;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onComplete();
                }
            } else if (multicastSubscription.a()) {
                n9(multicastSubscription);
            } else {
                l9();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean g() {
            return this.Z2.get() == SubscriptionHelper.CANCELLED;
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.i(this.Z2, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int r = queueSubscription.r(3);
                    if (r == 1) {
                        this.b3 = r;
                        this.a3 = queueSubscription;
                        this.c3 = true;
                        l9();
                        return;
                    } else if (r == 2) {
                        this.b3 = r;
                        this.a3 = queueSubscription;
                        QueueDrainHelper.j(subscription, this.Z);
                        return;
                    }
                }
                this.a3 = QueueDrainHelper.c(this.Z);
                QueueDrainHelper.j(subscription, this.Z);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean j9(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription[] multicastSubscriptionArr;
            MulticastSubscription[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = (MulticastSubscription[]) this.Y.get();
                if (multicastSubscriptionArr == g3) {
                    return false;
                }
                int length = multicastSubscriptionArr.length;
                multicastSubscriptionArr2 = new MulticastSubscription[(length + 1)];
                System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
                multicastSubscriptionArr2[length] = multicastSubscription;
            } while (!g.a(this.Y, multicastSubscriptionArr, multicastSubscriptionArr2));
            return true;
        }

        /* access modifiers changed from: package-private */
        public void k9() {
            for (MulticastSubscription multicastSubscription : (MulticastSubscription[]) this.Y.getAndSet(g3)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.s.onComplete();
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:125:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x00fd, code lost:
            if (r7 != 0) goto L_0x012f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x0103, code lost:
            if (g() == false) goto L_0x0109;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x0105, code lost:
            r0.clear();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x0108, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x0109, code lost:
            r5 = r1.c3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x010b, code lost:
            if (r5 == false) goto L_0x0119;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x010f, code lost:
            if (r1.Y2 != false) goto L_0x0119;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x0111, code lost:
            r6 = r1.d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x0113, code lost:
            if (r6 == null) goto L_0x0119;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x0115, code lost:
            m9(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x0118, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:0x0119, code lost:
            if (r5 == false) goto L_0x012f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x011f, code lost:
            if (r0.isEmpty() == false) goto L_0x012f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x0121, code lost:
            r0 = r1.d3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x0123, code lost:
            if (r0 == null) goto L_0x0129;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x0125, code lost:
            m9(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x0129, code lost:
            k9();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void l9() {
            /*
                r24 = this;
                r1 = r24
                java.util.concurrent.atomic.AtomicInteger r0 = r1.X
                int r0 = r0.getAndIncrement()
                if (r0 == 0) goto L_0x000b
                return
            L_0x000b:
                io.reactivex.rxjava3.internal.fuseable.SimpleQueue<T> r0 = r1.a3
                int r2 = r1.e3
                int r3 = r1.X2
                int r4 = r1.b3
                r6 = 1
                if (r4 == r6) goto L_0x0018
                r4 = 1
                goto L_0x0019
            L_0x0018:
                r4 = 0
            L_0x0019:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription<T>[]> r7 = r1.Y
                java.lang.Object r8 = r7.get()
                io.reactivex.rxjava3.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription[] r8 = (io.reactivex.rxjava3.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[]) r8
                r9 = 1
            L_0x0022:
                int r10 = r8.length
                if (r0 == 0) goto L_0x012d
                if (r10 == 0) goto L_0x012d
                int r11 = r8.length
                r12 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r15 = r12
                r14 = 0
            L_0x002f:
                r17 = -9223372036854775808
                if (r14 >= r11) goto L_0x0052
                r5 = r8[r14]
                long r19 = r5.get()
                r21 = r7
                long r6 = r5.Y
                long r19 = r19 - r6
                int r5 = (r19 > r17 ? 1 : (r19 == r17 ? 0 : -1))
                if (r5 == 0) goto L_0x004a
                int r5 = (r15 > r19 ? 1 : (r15 == r19 ? 0 : -1))
                if (r5 <= 0) goto L_0x004c
                r15 = r19
                goto L_0x004c
            L_0x004a:
                int r10 = r10 + -1
            L_0x004c:
                int r14 = r14 + 1
                r7 = r21
                r6 = 1
                goto L_0x002f
            L_0x0052:
                r21 = r7
                r5 = 0
                if (r10 != 0) goto L_0x0059
                r15 = r5
            L_0x0059:
                int r7 = (r15 > r5 ? 1 : (r15 == r5 ? 0 : -1))
                if (r7 == 0) goto L_0x00fd
                boolean r10 = r24.g()
                if (r10 == 0) goto L_0x0067
                r0.clear()
                return
            L_0x0067:
                boolean r10 = r1.c3
                if (r10 == 0) goto L_0x0077
                boolean r11 = r1.Y2
                if (r11 != 0) goto L_0x0077
                java.lang.Throwable r11 = r1.d3
                if (r11 == 0) goto L_0x0077
                r1.m9(r11)
                return
            L_0x0077:
                java.lang.Object r11 = r0.poll()     // Catch:{ all -> 0x00ef }
                if (r11 != 0) goto L_0x007f
                r14 = 1
                goto L_0x0080
            L_0x007f:
                r14 = 0
            L_0x0080:
                if (r10 == 0) goto L_0x0090
                if (r14 == 0) goto L_0x0090
                java.lang.Throwable r0 = r1.d3
                if (r0 == 0) goto L_0x008c
                r1.m9(r0)
                goto L_0x008f
            L_0x008c:
                r24.k9()
            L_0x008f:
                return
            L_0x0090:
                if (r14 == 0) goto L_0x0094
                goto L_0x00fd
            L_0x0094:
                int r7 = r8.length
                r10 = 0
                r14 = 0
            L_0x0097:
                r19 = 1
                if (r10 >= r7) goto L_0x00c0
                r5 = r8[r10]
                long r22 = r5.get()
                int r6 = (r22 > r17 ? 1 : (r22 == r17 ? 0 : -1))
                if (r6 == 0) goto L_0x00b5
                int r6 = (r22 > r12 ? 1 : (r22 == r12 ? 0 : -1))
                if (r6 == 0) goto L_0x00af
                long r12 = r5.Y
                long r12 = r12 + r19
                r5.Y = r12
            L_0x00af:
                org.reactivestreams.Subscriber<? super T> r5 = r5.s
                r5.onNext(r11)
                goto L_0x00b6
            L_0x00b5:
                r14 = 1
            L_0x00b6:
                int r10 = r10 + 1
                r5 = 0
                r12 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                goto L_0x0097
            L_0x00c0:
                long r15 = r15 - r19
                if (r4 == 0) goto L_0x00d5
                int r2 = r2 + 1
                if (r2 != r3) goto L_0x00d5
                java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> r2 = r1.Z2
                java.lang.Object r2 = r2.get()
                org.reactivestreams.Subscription r2 = (org.reactivestreams.Subscription) r2
                long r5 = (long) r3
                r2.request(r5)
                r2 = 0
            L_0x00d5:
                java.lang.Object r5 = r21.get()
                io.reactivex.rxjava3.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription[] r5 = (io.reactivex.rxjava3.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[]) r5
                if (r14 != 0) goto L_0x00e9
                if (r5 == r8) goto L_0x00e0
                goto L_0x00e9
            L_0x00e0:
                r5 = 0
                r12 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                goto L_0x0059
            L_0x00e9:
                r8 = r5
            L_0x00ea:
                r7 = r21
                r6 = 1
                goto L_0x0022
            L_0x00ef:
                r0 = move-exception
                r2 = r0
                io.reactivex.rxjava3.exceptions.Exceptions.b(r2)
                java.util.concurrent.atomic.AtomicReference<org.reactivestreams.Subscription> r0 = r1.Z2
                io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper.a(r0)
                r1.m9(r2)
                return
            L_0x00fd:
                if (r7 != 0) goto L_0x012f
                boolean r5 = r24.g()
                if (r5 == 0) goto L_0x0109
                r0.clear()
                return
            L_0x0109:
                boolean r5 = r1.c3
                if (r5 == 0) goto L_0x0119
                boolean r6 = r1.Y2
                if (r6 != 0) goto L_0x0119
                java.lang.Throwable r6 = r1.d3
                if (r6 == 0) goto L_0x0119
                r1.m9(r6)
                return
            L_0x0119:
                if (r5 == 0) goto L_0x012f
                boolean r5 = r0.isEmpty()
                if (r5 == 0) goto L_0x012f
                java.lang.Throwable r0 = r1.d3
                if (r0 == 0) goto L_0x0129
                r1.m9(r0)
                goto L_0x012c
            L_0x0129:
                r24.k9()
            L_0x012c:
                return
            L_0x012d:
                r21 = r7
            L_0x012f:
                r1.e3 = r2
                java.util.concurrent.atomic.AtomicInteger r5 = r1.X
                int r6 = -r9
                int r9 = r5.addAndGet(r6)
                if (r9 != 0) goto L_0x013b
                return
            L_0x013b:
                if (r0 != 0) goto L_0x013f
                io.reactivex.rxjava3.internal.fuseable.SimpleQueue<T> r0 = r1.a3
            L_0x013f:
                java.lang.Object r5 = r21.get()
                r8 = r5
                io.reactivex.rxjava3.internal.operators.flowable.FlowablePublishMulticast$MulticastSubscription[] r8 = (io.reactivex.rxjava3.internal.operators.flowable.FlowablePublishMulticast.MulticastSubscription[]) r8
                goto L_0x00ea
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowablePublishMulticast.MulticastProcessor.l9():void");
        }

        /* access modifiers changed from: package-private */
        public void m() {
            SimpleQueue<T> simpleQueue;
            if (!this.c3) {
                SubscriptionHelper.a(this.Z2);
                if (this.X.getAndIncrement() == 0 && (simpleQueue = this.a3) != null) {
                    simpleQueue.clear();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void m9(Throwable th) {
            for (MulticastSubscription multicastSubscription : (MulticastSubscription[]) this.Y.getAndSet(g3)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.s.onError(th);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void n9(MulticastSubscription<T> multicastSubscription) {
            MulticastSubscription<T>[] multicastSubscriptionArr;
            MulticastSubscription[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = (MulticastSubscription[]) this.Y.get();
                int length = multicastSubscriptionArr.length;
                if (length != 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            i2 = -1;
                            break;
                        } else if (multicastSubscriptionArr[i2] == multicastSubscription) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 >= 0) {
                        if (length == 1) {
                            multicastSubscriptionArr2 = f3;
                        } else {
                            MulticastSubscription[] multicastSubscriptionArr3 = new MulticastSubscription[(length - 1)];
                            System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr3, 0, i2);
                            System.arraycopy(multicastSubscriptionArr, i2 + 1, multicastSubscriptionArr3, i2, (length - i2) - 1);
                            multicastSubscriptionArr2 = multicastSubscriptionArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!g.a(this.Y, multicastSubscriptionArr, multicastSubscriptionArr2));
        }

        public void onComplete() {
            if (!this.c3) {
                this.c3 = true;
                l9();
            }
        }

        public void onError(Throwable th) {
            if (this.c3) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.d3 = th;
            this.c3 = true;
            l9();
        }

        public void onNext(T t) {
            if (!this.c3) {
                if (this.b3 != 0 || this.a3.offer(t)) {
                    l9();
                    return;
                }
                this.Z2.get().cancel();
                onError(new MissingBackpressureException());
            }
        }
    }

    static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long Z = 8664815189257569791L;
        final MulticastProcessor<T> X;
        long Y;
        final Subscriber<? super T> s;

        MulticastSubscription(Subscriber<? super T> subscriber, MulticastProcessor<T> multicastProcessor) {
            this.s = subscriber;
            this.X = multicastProcessor;
        }

        public boolean a() {
            return get() == Long.MIN_VALUE;
        }

        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.X.n9(this);
                this.X.l9();
            }
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.b(this, j2);
                this.X.l9();
            }
        }
    }

    static final class OutputCanceller<R> implements FlowableSubscriber<R>, Subscription {
        final MulticastProcessor<?> X;
        Subscription Y;
        final Subscriber<? super R> s;

        OutputCanceller(Subscriber<? super R> subscriber, MulticastProcessor<?> multicastProcessor) {
            this.s = subscriber;
            this.X = multicastProcessor;
        }

        public void cancel() {
            this.Y.cancel();
            this.X.m();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Y, subscription)) {
                this.Y = subscription;
                this.s.h(this);
            }
        }

        public void onComplete() {
            this.s.onComplete();
            this.X.m();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
            this.X.m();
        }

        public void onNext(R r) {
            this.s.onNext(r);
        }

        public void request(long j2) {
            this.Y.request(j2);
        }
    }

    public FlowablePublishMulticast(Flowable<T> flowable, Function<? super Flowable<T>, ? extends Publisher<? extends R>> function, int i2, boolean z) {
        super(flowable);
        this.Y = function;
        this.Z = i2;
        this.X2 = z;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super R> subscriber) {
        MulticastProcessor multicastProcessor = new MulticastProcessor(this.Z, this.X2);
        try {
            Object apply = this.Y.apply(multicastProcessor);
            Objects.requireNonNull(apply, "selector returned a null Publisher");
            ((Publisher) apply).e(new OutputCanceller(subscriber, multicastProcessor));
            this.X.J6(multicastProcessor);
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptySubscription.b(th, subscriber);
        }
    }
}
