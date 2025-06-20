package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.subscribers.BoundedSubscriber;
import io.reactivex.rxjava3.internal.subscribers.LambdaSubscriber;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.BlockingIgnoringReceiver;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.Objects;
import org.reactivestreams.Publisher;

public final class FlowableBlockingSubscribe {
    private FlowableBlockingSubscribe() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> void a(Publisher<? extends T> publisher) {
        BlockingIgnoringReceiver blockingIgnoringReceiver = new BlockingIgnoringReceiver();
        LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(Functions.h(), blockingIgnoringReceiver, blockingIgnoringReceiver, Functions.f28382k);
        publisher.e(lambdaSubscriber);
        BlockingHelper.a(blockingIgnoringReceiver, lambdaSubscriber);
        Throwable th = blockingIgnoringReceiver.s;
        if (th != null) {
            throw ExceptionHelper.i(th);
        }
    }

    public static <T> void b(Publisher<? extends T> publisher, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        Objects.requireNonNull(consumer, "onNext is null");
        Objects.requireNonNull(consumer2, "onError is null");
        Objects.requireNonNull(action, "onComplete is null");
        d(publisher, new LambdaSubscriber(consumer, consumer2, action, Functions.f28382k));
    }

    public static <T> void c(Publisher<? extends T> publisher, Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, int i2) {
        Objects.requireNonNull(consumer, "onNext is null");
        Objects.requireNonNull(consumer2, "onError is null");
        Objects.requireNonNull(action, "onComplete is null");
        ObjectHelper.b(i2, "number > 0 required");
        d(publisher, new BoundedSubscriber(consumer, consumer2, action, Functions.d(i2), i2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0013 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0014 A[Catch:{ InterruptedException -> 0x0029 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> void d(org.reactivestreams.Publisher<? extends T> r3, org.reactivestreams.Subscriber<? super T> r4) {
        /*
            java.util.concurrent.LinkedBlockingQueue r0 = new java.util.concurrent.LinkedBlockingQueue
            r0.<init>()
            io.reactivex.rxjava3.internal.subscribers.BlockingSubscriber r1 = new io.reactivex.rxjava3.internal.subscribers.BlockingSubscriber
            r1.<init>(r0)
            r3.e(r1)
        L_0x000d:
            boolean r3 = r1.a()     // Catch:{ InterruptedException -> 0x0029 }
            if (r3 == 0) goto L_0x0014
            goto L_0x0043
        L_0x0014:
            java.lang.Object r3 = r0.poll()     // Catch:{ InterruptedException -> 0x0029 }
            if (r3 != 0) goto L_0x002b
            boolean r3 = r1.a()     // Catch:{ InterruptedException -> 0x0029 }
            if (r3 == 0) goto L_0x0021
            goto L_0x0043
        L_0x0021:
            io.reactivex.rxjava3.internal.util.BlockingHelper.b()     // Catch:{ InterruptedException -> 0x0029 }
            java.lang.Object r3 = r0.take()     // Catch:{ InterruptedException -> 0x0029 }
            goto L_0x002b
        L_0x0029:
            r3 = move-exception
            goto L_0x003d
        L_0x002b:
            boolean r2 = r1.a()     // Catch:{ InterruptedException -> 0x0029 }
            if (r2 == 0) goto L_0x0032
            goto L_0x0043
        L_0x0032:
            java.lang.Object r2 = io.reactivex.rxjava3.internal.subscribers.BlockingSubscriber.Y     // Catch:{ InterruptedException -> 0x0029 }
            if (r3 == r2) goto L_0x0043
            boolean r3 = io.reactivex.rxjava3.internal.util.NotificationLite.e(r3, r4)     // Catch:{ InterruptedException -> 0x0029 }
            if (r3 == 0) goto L_0x000d
            goto L_0x0043
        L_0x003d:
            r1.cancel()
            r4.onError(r3)
        L_0x0043:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableBlockingSubscribe.d(org.reactivestreams.Publisher, org.reactivestreams.Subscriber):void");
    }
}
