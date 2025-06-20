package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;

public final class FlowableDoOnEach<T> extends AbstractFlowableWithUpstream<T, T> {
    final Action X2;
    final Consumer<? super T> Y;
    final Action Y2;
    final Consumer<? super Throwable> Z;

    static final class DoOnEachConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {
        final Consumer<? super T> Y2;
        final Consumer<? super Throwable> Z2;
        final Action a3;
        final Action b3;

        DoOnEachConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
            super(conditionalSubscriber);
            this.Y2 = consumer;
            this.Z2 = consumer2;
            this.a3 = action;
            this.b3 = action2;
        }

        public boolean o(T t) {
            if (this.Z) {
                return false;
            }
            try {
                this.Y2.accept(t);
                return this.s.o(t);
            } catch (Throwable th) {
                c(th);
                return false;
            }
        }

        public void onComplete() {
            if (!this.Z) {
                try {
                    this.a3.run();
                    this.Z = true;
                    this.s.onComplete();
                    try {
                        this.b3.run();
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        RxJavaPlugins.Y(th);
                    }
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.Z) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Z = true;
            try {
                this.Z2.accept(th);
                this.s.onError(th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.s.onError(new CompositeException(th, th2));
            }
            try {
                this.b3.run();
            } catch (Throwable th3) {
                Exceptions.b(th3);
                RxJavaPlugins.Y(th3);
            }
        }

        public void onNext(T t) {
            if (!this.Z) {
                if (this.X2 != 0) {
                    this.s.onNext(null);
                    return;
                }
                try {
                    this.Y2.accept(t);
                    this.s.onNext(t);
                } catch (Throwable th) {
                    c(th);
                }
            }
        }

        /* JADX INFO: finally extract failed */
        @Nullable
        public T poll() throws Throwable {
            try {
                T poll = this.Y.poll();
                if (poll != null) {
                    try {
                        this.Y2.accept(poll);
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        throw new CompositeException(th, th);
                    }
                } else {
                    if (this.X2 == 1) {
                        this.a3.run();
                    }
                    return poll;
                }
                this.b3.run();
                return poll;
            } catch (Throwable th2) {
                Exceptions.b(th2);
                throw new CompositeException(th, th2);
            }
        }

        public int r(int i2) {
            return d(i2);
        }
    }

    static final class DoOnEachSubscriber<T> extends BasicFuseableSubscriber<T, T> {
        final Consumer<? super T> Y2;
        final Consumer<? super Throwable> Z2;
        final Action a3;
        final Action b3;

        DoOnEachSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
            super(subscriber);
            this.Y2 = consumer;
            this.Z2 = consumer2;
            this.a3 = action;
            this.b3 = action2;
        }

        public void onComplete() {
            if (!this.Z) {
                try {
                    this.a3.run();
                    this.Z = true;
                    this.s.onComplete();
                    try {
                        this.b3.run();
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        RxJavaPlugins.Y(th);
                    }
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.Z) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Z = true;
            try {
                this.Z2.accept(th);
                this.s.onError(th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.s.onError(new CompositeException(th, th2));
            }
            try {
                this.b3.run();
            } catch (Throwable th3) {
                Exceptions.b(th3);
                RxJavaPlugins.Y(th3);
            }
        }

        public void onNext(T t) {
            if (!this.Z) {
                if (this.X2 != 0) {
                    this.s.onNext(null);
                    return;
                }
                try {
                    this.Y2.accept(t);
                    this.s.onNext(t);
                } catch (Throwable th) {
                    c(th);
                }
            }
        }

        /* JADX INFO: finally extract failed */
        @Nullable
        public T poll() throws Throwable {
            try {
                T poll = this.Y.poll();
                if (poll != null) {
                    try {
                        this.Y2.accept(poll);
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        throw new CompositeException(th, th);
                    }
                } else {
                    if (this.X2 == 1) {
                        this.a3.run();
                    }
                    return poll;
                }
                this.b3.run();
                return poll;
            } catch (Throwable th2) {
                Exceptions.b(th2);
                throw new CompositeException(th, th2);
            }
        }

        public int r(int i2) {
            return d(i2);
        }
    }

    public FlowableDoOnEach(Flowable<T> flowable, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        super(flowable);
        this.Y = consumer;
        this.Z = consumer2;
        this.X2 = action;
        this.Y2 = action2;
    }

    /* JADX WARNING: type inference failed for: r7v1, types: [io.reactivex.rxjava3.core.FlowableSubscriber] */
    /* JADX WARNING: type inference failed for: r1v2, types: [io.reactivex.rxjava3.internal.operators.flowable.FlowableDoOnEach$DoOnEachSubscriber] */
    /* JADX WARNING: type inference failed for: r1v3, types: [io.reactivex.rxjava3.internal.operators.flowable.FlowableDoOnEach$DoOnEachConditionalSubscriber] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void K6(org.reactivestreams.Subscriber<? super T> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber
            if (r0 == 0) goto L_0x001b
            io.reactivex.rxjava3.core.Flowable<T> r0 = r8.X
            io.reactivex.rxjava3.internal.operators.flowable.FlowableDoOnEach$DoOnEachConditionalSubscriber r7 = new io.reactivex.rxjava3.internal.operators.flowable.FlowableDoOnEach$DoOnEachConditionalSubscriber
            r2 = r9
            io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber r2 = (io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber) r2
            io.reactivex.rxjava3.functions.Consumer<? super T> r3 = r8.Y
            io.reactivex.rxjava3.functions.Consumer<? super java.lang.Throwable> r4 = r8.Z
            io.reactivex.rxjava3.functions.Action r5 = r8.X2
            io.reactivex.rxjava3.functions.Action r6 = r8.Y2
            r1 = r7
            r1.<init>(r2, r3, r4, r5, r6)
        L_0x0017:
            r0.J6(r7)
            goto L_0x002d
        L_0x001b:
            io.reactivex.rxjava3.core.Flowable<T> r0 = r8.X
            io.reactivex.rxjava3.internal.operators.flowable.FlowableDoOnEach$DoOnEachSubscriber r7 = new io.reactivex.rxjava3.internal.operators.flowable.FlowableDoOnEach$DoOnEachSubscriber
            io.reactivex.rxjava3.functions.Consumer<? super T> r3 = r8.Y
            io.reactivex.rxjava3.functions.Consumer<? super java.lang.Throwable> r4 = r8.Z
            io.reactivex.rxjava3.functions.Action r5 = r8.X2
            io.reactivex.rxjava3.functions.Action r6 = r8.Y2
            r1 = r7
            r2 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x0017
        L_0x002d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableDoOnEach.K6(org.reactivestreams.Subscriber):void");
    }
}
