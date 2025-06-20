package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Verify;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Uninterruptibles {
    private Uninterruptibles() {
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static void a(ExecutorService executorService) {
        Verify.a(b(executorService, Long.MAX_VALUE, TimeUnit.NANOSECONDS));
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static boolean b(ExecutorService executorService, long j2, TimeUnit timeUnit) {
        long nanos;
        boolean awaitTermination;
        boolean z = false;
        try {
            nanos = timeUnit.toNanos(j2);
            while (true) {
                awaitTermination = executorService.awaitTermination(nanos, TimeUnit.NANOSECONDS);
                break;
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            return awaitTermination;
        } catch (InterruptedException unused) {
            z = true;
            nanos = (System.nanoTime() + nanos) - System.nanoTime();
        } catch (Throwable th) {
            if (z) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static void c(CountDownLatch countDownLatch) {
        boolean z = false;
        while (true) {
            try {
                countDownLatch.await();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static boolean d(CountDownLatch countDownLatch, long j2, TimeUnit timeUnit) {
        long nanos;
        boolean await;
        boolean z = false;
        try {
            nanos = timeUnit.toNanos(j2);
            while (true) {
                await = countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
                break;
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            return await;
        } catch (InterruptedException unused) {
            z = true;
            nanos = (System.nanoTime() + nanos) - System.nanoTime();
        } catch (Throwable th) {
            if (z) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static boolean e(Condition condition, long j2, TimeUnit timeUnit) {
        long nanos;
        boolean await;
        boolean z = false;
        try {
            nanos = timeUnit.toNanos(j2);
            while (true) {
                await = condition.await(nanos, TimeUnit.NANOSECONDS);
                break;
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            return await;
        } catch (InterruptedException unused) {
            z = true;
            nanos = (System.nanoTime() + nanos) - System.nanoTime();
        } catch (Throwable th) {
            if (z) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public static <V> V f(Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    @J2ktIncompatible
    @GwtIncompatible
    @CanIgnoreReturnValue
    @ParametricNullness
    public static <V> V g(Future<V> future, long j2, TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        long nanos;
        V v;
        boolean z = false;
        try {
            nanos = timeUnit.toNanos(j2);
            while (true) {
                v = future.get(nanos, TimeUnit.NANOSECONDS);
                break;
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            return v;
        } catch (InterruptedException unused) {
            z = true;
            nanos = (System.nanoTime() + nanos) - System.nanoTime();
        } catch (Throwable th) {
            if (z) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static void h(Thread thread) {
        boolean z = false;
        while (true) {
            try {
                thread.join();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static void i(Thread thread, long j2, TimeUnit timeUnit) {
        long nanos;
        long nanoTime;
        Preconditions.E(thread);
        boolean z = false;
        try {
            nanos = timeUnit.toNanos(j2);
            nanoTime = System.nanoTime() + nanos;
            while (true) {
                TimeUnit.NANOSECONDS.timedJoin(thread, nanos);
                break;
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        } catch (InterruptedException unused) {
            z = true;
            nanos = nanoTime - System.nanoTime();
        } catch (Throwable th) {
            if (z) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <E> void j(BlockingQueue<E> blockingQueue, E e2) {
        boolean z = false;
        while (true) {
            try {
                blockingQueue.put(e2);
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static void k(long j2, TimeUnit timeUnit) {
        long nanos;
        long nanoTime;
        boolean z = false;
        try {
            nanos = timeUnit.toNanos(j2);
            nanoTime = System.nanoTime() + nanos;
            while (true) {
                TimeUnit.NANOSECONDS.sleep(nanos);
                break;
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        } catch (InterruptedException unused) {
            z = true;
            nanos = nanoTime - System.nanoTime();
        } catch (Throwable th) {
            if (z) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <E> E l(BlockingQueue<E> blockingQueue) {
        E take;
        boolean z = false;
        while (true) {
            try {
                take = blockingQueue.take();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return take;
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static boolean m(Semaphore semaphore, int i2, long j2, TimeUnit timeUnit) {
        long nanos;
        boolean tryAcquire;
        boolean z = false;
        try {
            nanos = timeUnit.toNanos(j2);
            while (true) {
                tryAcquire = semaphore.tryAcquire(i2, nanos, TimeUnit.NANOSECONDS);
                break;
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            return tryAcquire;
        } catch (InterruptedException unused) {
            z = true;
            nanos = (System.nanoTime() + nanos) - System.nanoTime();
        } catch (Throwable th) {
            if (z) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static boolean n(Semaphore semaphore, long j2, TimeUnit timeUnit) {
        return m(semaphore, 1, j2, timeUnit);
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static boolean o(Lock lock, long j2, TimeUnit timeUnit) {
        long nanos;
        boolean tryLock;
        boolean z = false;
        try {
            nanos = timeUnit.toNanos(j2);
            while (true) {
                tryLock = lock.tryLock(nanos, TimeUnit.NANOSECONDS);
                break;
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            return tryLock;
        } catch (InterruptedException unused) {
            z = true;
            nanos = (System.nanoTime() + nanos) - System.nanoTime();
        } catch (Throwable th) {
            if (z) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }
}
