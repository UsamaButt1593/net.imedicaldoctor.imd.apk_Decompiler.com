package androidx.media3.common;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

@UnstableApi
public final class PriorityTaskManager {

    /* renamed from: a  reason: collision with root package name */
    private final Object f9263a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final PriorityQueue<Integer> f9264b = new PriorityQueue<>(10, Collections.reverseOrder());

    /* renamed from: c  reason: collision with root package name */
    private int f9265c = Integer.MIN_VALUE;

    public static class PriorityTooLowException extends IOException {
        public PriorityTooLowException(int i2, int i3) {
            super("Priority too low [priority=" + i2 + ", highest=" + i3 + "]");
        }
    }

    public void a(int i2) {
        synchronized (this.f9263a) {
            this.f9264b.add(Integer.valueOf(i2));
            this.f9265c = Math.max(this.f9265c, i2);
        }
    }

    public void b(int i2) throws InterruptedException {
        synchronized (this.f9263a) {
            while (this.f9265c != i2) {
                try {
                    this.f9263a.wait();
                } finally {
                }
            }
        }
    }

    public boolean c(int i2) {
        boolean z;
        synchronized (this.f9263a) {
            z = this.f9265c == i2;
        }
        return z;
    }

    public void d(int i2) throws PriorityTooLowException {
        synchronized (this.f9263a) {
            try {
                if (this.f9265c != i2) {
                    throw new PriorityTooLowException(i2, this.f9265c);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e(int i2) {
        synchronized (this.f9263a) {
            this.f9264b.remove(Integer.valueOf(i2));
            this.f9265c = this.f9264b.isEmpty() ? Integer.MIN_VALUE : ((Integer) Util.o(this.f9264b.peek())).intValue();
            this.f9263a.notifyAll();
        }
    }
}
