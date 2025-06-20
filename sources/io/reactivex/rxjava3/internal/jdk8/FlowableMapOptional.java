package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.fuseable.ConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.rxjava3.internal.subscribers.BasicFuseableSubscriber;
import java.util.Objects;
import java.util.Optional;
import org.reactivestreams.Subscriber;

public final class FlowableMapOptional<T, R> extends Flowable<R> {
    final Flowable<T> X;
    final Function<? super T, Optional<? extends R>> Y;

    static final class MapOptionalConditionalSubscriber<T, R> extends BasicFuseableConditionalSubscriber<T, R> {
        final Function<? super T, Optional<? extends R>> Y2;

        MapOptionalConditionalSubscriber(ConditionalSubscriber<? super R> conditionalSubscriber, Function<? super T, Optional<? extends R>> function) {
            super(conditionalSubscriber);
            this.Y2 = function;
        }

        public boolean o(T t) {
            if (this.Z) {
                return true;
            }
            if (this.X2 != 0) {
                this.s.onNext(null);
                return true;
            }
            try {
                Optional<? extends R> apply = this.Y2.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null Optional");
                Optional a2 = k.a(apply);
                if (a2.isPresent()) {
                    return this.s.o(a2.get());
                }
                return false;
            } catch (Throwable th) {
                c(th);
                return true;
            }
        }

        public void onNext(T t) {
            if (!o(t)) {
                this.X.request(1);
            }
        }

        public R poll() throws Throwable {
            while (true) {
                T poll = this.Y.poll();
                if (poll == null) {
                    return null;
                }
                Optional<? extends R> apply = this.Y2.apply(poll);
                Objects.requireNonNull(apply, "The mapper returned a null Optional");
                Optional a2 = k.a(apply);
                if (a2.isPresent()) {
                    return a2.get();
                }
                if (this.X2 == 2) {
                    this.Y.request(1);
                }
            }
        }

        public int r(int i2) {
            return d(i2);
        }
    }

    static final class MapOptionalSubscriber<T, R> extends BasicFuseableSubscriber<T, R> implements ConditionalSubscriber<T> {
        final Function<? super T, Optional<? extends R>> Y2;

        MapOptionalSubscriber(Subscriber<? super R> subscriber, Function<? super T, Optional<? extends R>> function) {
            super(subscriber);
            this.Y2 = function;
        }

        public boolean o(T t) {
            if (this.Z) {
                return true;
            }
            if (this.X2 != 0) {
                this.s.onNext(null);
                return true;
            }
            try {
                Optional<? extends R> apply = this.Y2.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null Optional");
                Optional a2 = k.a(apply);
                if (!a2.isPresent()) {
                    return false;
                }
                this.s.onNext(a2.get());
                return true;
            } catch (Throwable th) {
                c(th);
                return true;
            }
        }

        public void onNext(T t) {
            if (!o(t)) {
                this.X.request(1);
            }
        }

        public R poll() throws Throwable {
            while (true) {
                T poll = this.Y.poll();
                if (poll == null) {
                    return null;
                }
                Optional<? extends R> apply = this.Y2.apply(poll);
                Objects.requireNonNull(apply, "The mapper returned a null Optional");
                Optional a2 = k.a(apply);
                if (a2.isPresent()) {
                    return a2.get();
                }
                if (this.X2 == 2) {
                    this.Y.request(1);
                }
            }
        }

        public int r(int i2) {
            return d(i2);
        }
    }

    public FlowableMapOptional(Flowable<T> flowable, Function<? super T, Optional<? extends R>> function) {
        this.X = flowable;
        this.Y = function;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super R> subscriber) {
        Flowable<T> flowable;
        FlowableSubscriber mapOptionalSubscriber;
        if (subscriber instanceof ConditionalSubscriber) {
            flowable = this.X;
            mapOptionalSubscriber = new MapOptionalConditionalSubscriber((ConditionalSubscriber) subscriber, this.Y);
        } else {
            flowable = this.X;
            mapOptionalSubscriber = new MapOptionalSubscriber(subscriber, this.Y);
        }
        flowable.J6(mapOptionalSubscriber);
    }
}
