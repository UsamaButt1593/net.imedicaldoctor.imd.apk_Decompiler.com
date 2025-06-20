package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final class zacx implements Continuation<Boolean, Void> {
    zacx() {
    }

    public final /* bridge */ /* synthetic */ Object a(@NonNull Task task) throws Exception {
        if (((Boolean) task.r()).booleanValue()) {
            return null;
        }
        throw new ApiException(new Status(13, "listener already unregistered"));
    }
}
