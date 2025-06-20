package io.reactivex.rxjava3.disposables;

public final /* synthetic */ class a implements AutoCloseable {
    public final /* synthetic */ Disposable s;

    public /* synthetic */ a(Disposable disposable) {
        this.s = disposable;
    }

    public final void close() {
        this.s.m();
    }
}
