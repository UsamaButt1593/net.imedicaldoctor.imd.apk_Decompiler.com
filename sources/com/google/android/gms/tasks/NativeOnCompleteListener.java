package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class NativeOnCompleteListener implements OnCompleteListener<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final long f20520a;

    @KeepForSdk
    public NativeOnCompleteListener(long j2) {
        this.f20520a = j2;
    }

    @KeepForSdk
    public static void b(@NonNull Task<Object> task, long j2) {
        task.e(new NativeOnCompleteListener(j2));
    }

    @KeepForSdk
    public void a(@NonNull Task<Object> task) {
        String str;
        Object obj;
        Exception q;
        if (task.v()) {
            obj = task.r();
            str = null;
        } else if (task.t() || (q = task.q()) == null) {
            obj = null;
            str = null;
        } else {
            str = q.getMessage();
            obj = null;
        }
        nativeOnComplete(this.f20520a, obj, task.v(), task.t(), str);
    }

    @KeepForSdk
    public native void nativeOnComplete(long j2, @Nullable Object obj, boolean z, boolean z2, @Nullable String str);
}
