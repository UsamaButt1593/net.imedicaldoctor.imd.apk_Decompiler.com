package androidx.lifecycle;

public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ ProcessLifecycleOwner s;

    public /* synthetic */ i(ProcessLifecycleOwner processLifecycleOwner) {
        this.s = processLifecycleOwner;
    }

    public final void run() {
        ProcessLifecycleOwner.k(this.s);
    }
}
