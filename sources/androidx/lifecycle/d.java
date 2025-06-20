package androidx.lifecycle;

public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ Runnable X;
    public final /* synthetic */ DispatchQueue s;

    public /* synthetic */ d(DispatchQueue dispatchQueue, Runnable runnable) {
        this.s = dispatchQueue;
        this.X = runnable;
    }

    public final void run() {
        DispatchQueue.d(this.s, this.X);
    }
}
