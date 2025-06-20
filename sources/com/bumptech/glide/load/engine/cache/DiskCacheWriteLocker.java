package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.util.Preconditions;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class DiskCacheWriteLocker {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, WriteLock> f18031a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final WriteLockPool f18032b = new WriteLockPool();

    private static class WriteLock {

        /* renamed from: a  reason: collision with root package name */
        final Lock f18033a = new ReentrantLock();

        /* renamed from: b  reason: collision with root package name */
        int f18034b;

        WriteLock() {
        }
    }

    private static class WriteLockPool {

        /* renamed from: b  reason: collision with root package name */
        private static final int f18035b = 10;

        /* renamed from: a  reason: collision with root package name */
        private final Queue<WriteLock> f18036a = new ArrayDeque();

        WriteLockPool() {
        }

        /* access modifiers changed from: package-private */
        public WriteLock a() {
            WriteLock poll;
            synchronized (this.f18036a) {
                poll = this.f18036a.poll();
            }
            return poll == null ? new WriteLock() : poll;
        }

        /* access modifiers changed from: package-private */
        public void b(WriteLock writeLock) {
            synchronized (this.f18036a) {
                try {
                    if (this.f18036a.size() < 10) {
                        this.f18036a.offer(writeLock);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    DiskCacheWriteLocker() {
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        WriteLock writeLock;
        synchronized (this) {
            try {
                writeLock = this.f18031a.get(str);
                if (writeLock == null) {
                    writeLock = this.f18032b.a();
                    this.f18031a.put(str, writeLock);
                }
                writeLock.f18034b++;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        writeLock.f18033a.lock();
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        WriteLock writeLock;
        synchronized (this) {
            try {
                writeLock = (WriteLock) Preconditions.d(this.f18031a.get(str));
                int i2 = writeLock.f18034b;
                if (i2 >= 1) {
                    int i3 = i2 - 1;
                    writeLock.f18034b = i3;
                    if (i3 == 0) {
                        WriteLock remove = this.f18031a.remove(str);
                        if (remove.equals(writeLock)) {
                            this.f18032b.b(remove);
                        } else {
                            throw new IllegalStateException("Removed the wrong lock, expected to remove: " + writeLock + ", but actually removed: " + remove + ", safeKey: " + str);
                        }
                    }
                } else {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + writeLock.f18034b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        writeLock.f18033a.unlock();
    }
}
