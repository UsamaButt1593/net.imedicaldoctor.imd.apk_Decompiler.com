package io.reactivex.rxjava3.processors;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import org.reactivestreams.Processor;

public abstract class FlowableProcessor<T> extends Flowable<T> implements Processor<T, T>, FlowableSubscriber<T> {
    @CheckReturnValue
    @Nullable
    public abstract Throwable j9();

    @CheckReturnValue
    public abstract boolean k9();

    @CheckReturnValue
    public abstract boolean l9();

    @CheckReturnValue
    public abstract boolean m9();

    @NonNull
    @CheckReturnValue
    public final FlowableProcessor<T> n9() {
        return this instanceof SerializedProcessor ? this : new SerializedProcessor(this);
    }
}
