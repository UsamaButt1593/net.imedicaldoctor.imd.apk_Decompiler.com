package com.google.firebase.messaging;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.WithinAppServiceConnection;

public final /* synthetic */ class K implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WithinAppServiceConnection.BindRequest f24791a;

    public /* synthetic */ K(WithinAppServiceConnection.BindRequest bindRequest) {
        this.f24791a = bindRequest;
    }

    public final void a(Task task) {
        this.f24791a.d();
    }
}
