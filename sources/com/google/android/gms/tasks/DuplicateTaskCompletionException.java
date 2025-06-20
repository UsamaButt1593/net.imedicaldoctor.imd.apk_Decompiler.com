package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class DuplicateTaskCompletionException extends IllegalStateException {
    private DuplicateTaskCompletionException(String str, @Nullable Throwable th) {
        super(str, th);
    }

    @NonNull
    public static IllegalStateException a(@NonNull Task<?> task) {
        if (!task.u()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception q = task.q();
        return new DuplicateTaskCompletionException("Complete with: ".concat(q != null ? "failure" : task.v() ? "result ".concat(String.valueOf(task.r())) : task.t() ? "cancellation" : "unknown issue"), q);
    }
}
