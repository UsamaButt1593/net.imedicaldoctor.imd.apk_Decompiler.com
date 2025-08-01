package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.observers.LambdaObserver;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.BlockingIgnoringReceiver;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.Objects;

public final class ObservableBlockingSubscribe {
    private ObservableBlockingSubscribe() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> void a(ObservableSource<? extends T> observableSource) {
        BlockingIgnoringReceiver blockingIgnoringReceiver = new BlockingIgnoringReceiver();
        LambdaObserver lambdaObserver = new LambdaObserver(Functions.h(), blockingIgnoringReceiver, blockingIgnoringReceiver, Functions.h());
        observableSource.a(lambdaObserver);
        BlockingHelper.a(blockingIgnoringReceiver, lambdaObserver);
        Throwable th = blockingIgnoringReceiver.s;
        if (th != null) {
            throw ExceptionHelper.i(th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> void b(io.reactivex.rxjava3.core.ObservableSource<? extends T> r3, io.reactivex.rxjava3.core.Observer<? super T> r4) {
        /*
            java.util.concurrent.LinkedBlockingQueue r0 = new java.util.concurrent.LinkedBlockingQueue
            r0.<init>()
            io.reactivex.rxjava3.internal.observers.BlockingObserver r1 = new io.reactivex.rxjava3.internal.observers.BlockingObserver
            r1.<init>(r0)
            r4.b(r1)
            r3.a(r1)
        L_0x0010:
            boolean r3 = r1.g()
            if (r3 == 0) goto L_0x0017
            goto L_0x003a
        L_0x0017:
            java.lang.Object r3 = r0.poll()
            if (r3 != 0) goto L_0x002a
            java.lang.Object r3 = r0.take()     // Catch:{ InterruptedException -> 0x0022 }
            goto L_0x002a
        L_0x0022:
            r3 = move-exception
            r1.m()
            r4.onError(r3)
            return
        L_0x002a:
            boolean r2 = r1.g()
            if (r2 != 0) goto L_0x003a
            java.lang.Object r2 = io.reactivex.rxjava3.internal.observers.BlockingObserver.Y
            if (r3 == r2) goto L_0x003a
            boolean r3 = io.reactivex.rxjava3.internal.util.NotificationLite.c(r3, r4)
            if (r3 == 0) goto L_0x0010
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableBlockingSubscribe.b(io.reactivex.rxjava3.core.ObservableSource, io.reactivex.rxjava3.core.Observer):void");
    }

    public static <T> void c(ObservableSource<? extends T> observableSource, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        Objects.requireNonNull(consumer, "onNext is null");
        Objects.requireNonNull(consumer2, "onError is null");
        Objects.requireNonNull(action, "onComplete is null");
        b(observableSource, new LambdaObserver(consumer, consumer2, action, Functions.h()));
    }
}
