package com.google.firebase.messaging;

import android.content.Intent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.firebase.messaging.b  reason: case insensitive filesystem */
public final /* synthetic */ class C0486b implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EnhancedIntentService f24909a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f24910b;

    public /* synthetic */ C0486b(EnhancedIntentService enhancedIntentService, Intent intent) {
        this.f24909a = enhancedIntentService;
        this.f24910b = intent;
    }

    public final void a(Task task) {
        this.f24909a.h(this.f24910b, task);
    }
}
