package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.io.IOException;

public final /* synthetic */ class zzaa implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ zzaa f19820a = new zzaa();

    private /* synthetic */ zzaa() {
    }

    public final Object a(Task task) {
        if (task.v()) {
            return (Bundle) task.r();
        }
        if (Log.isLoggable("Rpc", 3)) {
            Log.d("Rpc", "Error making request: ".concat(String.valueOf(task.q())));
        }
        throw new IOException("SERVICE_NOT_AVAILABLE", task.q());
    }
}
