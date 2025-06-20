package io.reactivex.rxjava3.subjects;

import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;

public abstract class Subject<T> extends Observable<T> implements Observer<T> {
    @CheckReturnValue
    @Nullable
    public abstract Throwable D8();

    @CheckReturnValue
    public abstract boolean E8();

    @CheckReturnValue
    public abstract boolean F8();

    @CheckReturnValue
    public abstract boolean G8();

    @NonNull
    @CheckReturnValue
    public final Subject<T> H8() {
        return this instanceof SerializedSubject ? this : new SerializedSubject(this);
    }
}
