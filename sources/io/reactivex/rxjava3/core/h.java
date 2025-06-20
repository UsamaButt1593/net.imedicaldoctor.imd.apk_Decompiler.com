package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.disposables.Disposable;

public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ Disposable s;

    public /* synthetic */ h(Disposable disposable) {
        this.s = disposable;
    }

    public final void run() {
        this.s.m();
    }
}
