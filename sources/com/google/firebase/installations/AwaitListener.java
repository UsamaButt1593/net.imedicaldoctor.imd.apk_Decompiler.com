package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class AwaitListener implements OnCompleteListener<Void> {

    /* renamed from: a  reason: collision with root package name */
    private final CountDownLatch f24403a = new CountDownLatch(1);

    AwaitListener() {
    }

    public void a(@NonNull Task<Void> task) {
        this.f24403a.countDown();
    }

    public boolean b(long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.f24403a.await(j2, timeUnit);
    }

    public void c() {
        this.f24403a.countDown();
    }
}
