package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.concurrent.CountDownLatch;

public final class BlockingIgnoringReceiver extends CountDownLatch implements Consumer<Throwable>, Action {
    public Throwable s;

    public BlockingIgnoringReceiver() {
        super(1);
    }

    /* renamed from: a */
    public void accept(Throwable th) {
        this.s = th;
        countDown();
    }

    public void run() {
        countDown();
    }
}
