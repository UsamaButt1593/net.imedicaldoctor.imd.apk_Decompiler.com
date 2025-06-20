package okhttp3.internal;

public abstract class NamedRunnable implements Runnable {
    protected final String s;

    public NamedRunnable(String str, Object... objArr) {
        this.s = Util.s(str, objArr);
    }

    /* access modifiers changed from: protected */
    public abstract void l();

    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.s);
        try {
            l();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
