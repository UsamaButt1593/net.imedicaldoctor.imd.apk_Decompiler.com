package com.google.firebase.messaging;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledFuture;

public final /* synthetic */ class M implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScheduledFuture f24792a;

    public /* synthetic */ M(ScheduledFuture scheduledFuture) {
        this.f24792a = scheduledFuture;
    }

    public final void a(Task task) {
        this.f24792a.cancel(false);
    }
}
