package androidx.appcompat.app;

import androidx.appcompat.app.AppCompatDelegate;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ Runnable X;
    public final /* synthetic */ AppCompatDelegate.SerialExecutor s;

    public /* synthetic */ c(AppCompatDelegate.SerialExecutor serialExecutor, Runnable runnable) {
        this.s = serialExecutor;
        this.X = runnable;
    }

    public final void run() {
        this.s.b(this.X);
    }
}
