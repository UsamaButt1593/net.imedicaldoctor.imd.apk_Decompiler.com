package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class J implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Intent f24790a;

    public /* synthetic */ J(Intent intent) {
        this.f24790a = intent;
    }

    public final void a(Task task) {
        WakeLockHolder.d(this.f24790a);
    }
}
