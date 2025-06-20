package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zaac implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f20041a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zaad f20042b;

    zaac(zaad zaad, TaskCompletionSource taskCompletionSource) {
        this.f20042b = zaad;
        this.f20041a = taskCompletionSource;
    }

    public final void a(@NonNull Task task) {
        this.f20042b.f20044b.remove(this.f20041a);
    }
}
