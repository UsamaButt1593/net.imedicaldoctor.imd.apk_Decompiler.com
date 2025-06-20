package org.reactivestreams;

import java.util.Objects;
import java.util.concurrent.Flow;

public final class FlowAdapters {

    static final class FlowPublisherFromReactive<T> implements Flow.Publisher<T> {

        /* renamed from: a  reason: collision with root package name */
        final Publisher<? extends T> f31766a;

        public FlowPublisherFromReactive(Publisher<? extends T> publisher) {
            this.f31766a = publisher;
        }

        public void subscribe(Flow.Subscriber<? super T> subscriber) {
            this.f31766a.e(subscriber == null ? null : new ReactiveToFlowSubscriber(subscriber));
        }
    }

    static final class FlowToReactiveProcessor<T, U> implements Flow.Processor<T, U> {

        /* renamed from: a  reason: collision with root package name */
        final Processor<? super T, ? extends U> f31767a;

        public FlowToReactiveProcessor(Processor<? super T, ? extends U> processor) {
            this.f31767a = processor;
        }

        public void onComplete() {
            this.f31767a.onComplete();
        }

        public void onError(Throwable th) {
            this.f31767a.onError(th);
        }

        public void onNext(T t) {
            this.f31767a.onNext(t);
        }

        public void onSubscribe(Flow.Subscription subscription) {
            this.f31767a.h(subscription == null ? null : new ReactiveToFlowSubscription(subscription));
        }

        public void subscribe(Flow.Subscriber<? super U> subscriber) {
            this.f31767a.e(subscriber == null ? null : new ReactiveToFlowSubscriber(subscriber));
        }
    }

    static final class FlowToReactiveSubscriber<T> implements Flow.Subscriber<T> {

        /* renamed from: a  reason: collision with root package name */
        final Subscriber<? super T> f31768a;

        public FlowToReactiveSubscriber(Subscriber<? super T> subscriber) {
            this.f31768a = subscriber;
        }

        public void onComplete() {
            this.f31768a.onComplete();
        }

        public void onError(Throwable th) {
            this.f31768a.onError(th);
        }

        public void onNext(T t) {
            this.f31768a.onNext(t);
        }

        public void onSubscribe(Flow.Subscription subscription) {
            this.f31768a.h(subscription == null ? null : new ReactiveToFlowSubscription(subscription));
        }
    }

    static final class FlowToReactiveSubscription implements Flow.Subscription {

        /* renamed from: a  reason: collision with root package name */
        final Subscription f31769a;

        public FlowToReactiveSubscription(Subscription subscription) {
            this.f31769a = subscription;
        }

        public void cancel() {
            this.f31769a.cancel();
        }

        public void request(long j2) {
            this.f31769a.request(j2);
        }
    }

    static final class ReactivePublisherFromFlow<T> implements Publisher<T> {
        final Flow.Publisher<? extends T> s;

        public ReactivePublisherFromFlow(Flow.Publisher<? extends T> publisher) {
            this.s = publisher;
        }

        public void e(Subscriber<? super T> subscriber) {
            this.s.subscribe(subscriber == null ? null : new FlowToReactiveSubscriber(subscriber));
        }
    }

    static final class ReactiveToFlowProcessor<T, U> implements Processor<T, U> {
        final Flow.Processor<? super T, ? extends U> s;

        public ReactiveToFlowProcessor(Flow.Processor<? super T, ? extends U> processor) {
            this.s = processor;
        }

        public void e(Subscriber<? super U> subscriber) {
            this.s.subscribe(subscriber == null ? null : new FlowToReactiveSubscriber(subscriber));
        }

        public void h(Subscription subscription) {
            this.s.onSubscribe(subscription == null ? null : new FlowToReactiveSubscription(subscription));
        }

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
            this.s.onNext(t);
        }
    }

    static final class ReactiveToFlowSubscriber<T> implements Subscriber<T> {
        final Flow.Subscriber<? super T> s;

        public ReactiveToFlowSubscriber(Flow.Subscriber<? super T> subscriber) {
            this.s = subscriber;
        }

        public void h(Subscription subscription) {
            this.s.onSubscribe(subscription == null ? null : new FlowToReactiveSubscription(subscription));
        }

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
            this.s.onNext(t);
        }
    }

    static final class ReactiveToFlowSubscription implements Subscription {
        final Flow.Subscription s;

        public ReactiveToFlowSubscription(Flow.Subscription subscription) {
            this.s = subscription;
        }

        public void cancel() {
            this.s.cancel();
        }

        public void request(long j2) {
            this.s.request(j2);
        }
    }

    private FlowAdapters() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, U> Flow.Processor<T, U> a(Processor<? super T, ? extends U> processor) {
        Objects.requireNonNull(processor, "reactiveStreamsProcessor");
        if (processor instanceof ReactiveToFlowProcessor) {
            return ((ReactiveToFlowProcessor) processor).s;
        }
        return e.a(processor) ? f.a(processor) : new FlowToReactiveProcessor<>(processor);
    }

    public static <T> Flow.Publisher<T> b(Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "reactiveStreamsPublisher");
        if (publisher instanceof ReactivePublisherFromFlow) {
            return ((ReactivePublisherFromFlow) publisher).s;
        }
        return a.a(publisher) ? b.a(publisher) : new FlowPublisherFromReactive<>(publisher);
    }

    public static <T> Flow.Subscriber<T> c(Subscriber<T> subscriber) {
        Objects.requireNonNull(subscriber, "reactiveStreamsSubscriber");
        if (subscriber instanceof ReactiveToFlowSubscriber) {
            return ((ReactiveToFlowSubscriber) subscriber).s;
        }
        return c.a(subscriber) ? d.a(subscriber) : new FlowToReactiveSubscriber<>(subscriber);
    }

    public static <T, U> Processor<T, U> d(Flow.Processor<? super T, ? extends U> processor) {
        Objects.requireNonNull(processor, "flowProcessor");
        if (processor instanceof FlowToReactiveProcessor) {
            return ((FlowToReactiveProcessor) processor).f31767a;
        }
        return processor instanceof Processor ? (Processor) processor : new ReactiveToFlowProcessor(processor);
    }

    public static <T> Publisher<T> e(Flow.Publisher<? extends T> publisher) {
        Objects.requireNonNull(publisher, "flowPublisher");
        if (publisher instanceof FlowPublisherFromReactive) {
            return ((FlowPublisherFromReactive) publisher).f31766a;
        }
        return publisher instanceof Publisher ? (Publisher) publisher : new ReactivePublisherFromFlow(publisher);
    }

    public static <T> Subscriber<T> f(Flow.Subscriber<T> subscriber) {
        Objects.requireNonNull(subscriber, "flowSubscriber");
        if (subscriber instanceof FlowToReactiveSubscriber) {
            return ((FlowToReactiveSubscriber) subscriber).f31768a;
        }
        return subscriber instanceof Subscriber ? (Subscriber) subscriber : new ReactiveToFlowSubscriber(subscriber);
    }
}
