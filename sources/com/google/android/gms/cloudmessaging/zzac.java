package com.google.android.gms.cloudmessaging;

import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;

public final /* synthetic */ class zzac implements Runnable {
    public final /* synthetic */ TaskCompletionSource s;

    public /* synthetic */ zzac(TaskCompletionSource taskCompletionSource) {
        this.s = taskCompletionSource;
    }

    public final void run() {
        if (this.s.d(new IOException("TIMEOUT"))) {
            Log.w("Rpc", "No response");
        }
    }
}
