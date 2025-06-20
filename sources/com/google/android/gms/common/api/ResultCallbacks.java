package com.google.android.gms.common.api;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;

public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    @KeepForSdk
    public final void a(@NonNull R r) {
        Status d2 = r.d();
        if (d2.R()) {
            c(r);
            return;
        }
        b(d2);
        if (r instanceof Releasable) {
            try {
                ((Releasable) r).a();
            } catch (RuntimeException e2) {
                Log.w("ResultCallbacks", "Unable to release ".concat(String.valueOf(r)), e2);
            }
        }
    }

    public abstract void b(@NonNull Status status);

    public abstract void c(@NonNull R r);
}
