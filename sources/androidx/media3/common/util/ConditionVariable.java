package androidx.media3.common.util;

@UnstableApi
public class ConditionVariable {

    /* renamed from: a  reason: collision with root package name */
    private final Clock f9515a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f9516b;

    public ConditionVariable() {
        this(Clock.f9502a);
    }

    public synchronized void a() throws InterruptedException {
        while (!this.f9516b) {
            wait();
        }
    }

    public synchronized boolean b(long j2) throws InterruptedException {
        if (j2 <= 0) {
            return this.f9516b;
        }
        long b2 = this.f9515a.b();
        long j3 = j2 + b2;
        if (j3 < b2) {
            a();
        } else {
            while (!this.f9516b && b2 < j3) {
                wait(j3 - b2);
                b2 = this.f9515a.b();
            }
        }
        return this.f9516b;
    }

    public synchronized void c() {
        boolean z = false;
        while (!this.f9516b) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized boolean d() {
        boolean z;
        z = this.f9516b;
        this.f9516b = false;
        return z;
    }

    public synchronized boolean e() {
        return this.f9516b;
    }

    public synchronized boolean f() {
        if (this.f9516b) {
            return false;
        }
        this.f9516b = true;
        notifyAll();
        return true;
    }

    public ConditionVariable(Clock clock) {
        this.f9515a = clock;
    }
}
