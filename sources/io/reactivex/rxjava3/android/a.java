package io.reactivex.rxjava3.android;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ MainThreadDisposable s;

    public /* synthetic */ a(MainThreadDisposable mainThreadDisposable) {
        this.s = mainThreadDisposable;
    }

    public final void run() {
        this.s.a();
    }
}
