package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.schedulers.NonBlockingThread;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.CountDownLatch;

public final class BlockingHelper {
    private BlockingHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static void a(CountDownLatch countDownLatch, Disposable disposable) {
        if (countDownLatch.getCount() != 0) {
            try {
                b();
                countDownLatch.await();
            } catch (InterruptedException e2) {
                disposable.m();
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e2);
            }
        }
    }

    public static void b() {
        if (!RxJavaPlugins.L()) {
            return;
        }
        if ((Thread.currentThread() instanceof NonBlockingThread) || RxJavaPlugins.W()) {
            throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
        }
    }
}
