package com.trello.lifecycle4.android.lifecycle;

import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.trello.rxlifecycle4.LifecycleProvider;
import com.trello.rxlifecycle4.LifecycleTransformer;
import com.trello.rxlifecycle4.RxLifecycle;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

public final class AndroidLifecycle implements LifecycleProvider<Lifecycle.Event>, LifecycleObserver {
    private final BehaviorSubject<Lifecycle.Event> s = BehaviorSubject.J8();

    private AndroidLifecycle(LifecycleOwner lifecycleOwner) {
        lifecycleOwner.a().a(this);
    }

    public static LifecycleProvider<Lifecycle.Event> l(LifecycleOwner lifecycleOwner) {
        return new AndroidLifecycle(lifecycleOwner);
    }

    @CheckResult
    @NonNull
    public Observable<Lifecycle.Event> a() {
        return this.s.q3();
    }

    @CheckResult
    @NonNull
    public <T> LifecycleTransformer<T> i() {
        return RxLifecycleAndroidLifecycle.a(this.s);
    }

    @CheckResult
    @NonNull
    /* renamed from: k */
    public <T> LifecycleTransformer<T> h(@NonNull Lifecycle.Event event) {
        return RxLifecycle.c(this.s, event);
    }

    /* access modifiers changed from: package-private */
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void onEvent(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.s.onNext(event);
        if (event == Lifecycle.Event.ON_DESTROY) {
            lifecycleOwner.a().d(this);
        }
    }
}
