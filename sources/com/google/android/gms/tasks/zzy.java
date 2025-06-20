package com.google.android.gms.tasks;

import com.google.android.gms.internal.tasks.zza;

public final /* synthetic */ class zzy implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ zza f20568a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f20569b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ zzb f20570c;

    public /* synthetic */ zzy(zza zza, TaskCompletionSource taskCompletionSource, zzb zzb) {
        this.f20568a = zza;
        this.f20569b = taskCompletionSource;
        this.f20570c = zzb;
    }

    public final void a(Task task) {
        this.f20568a.removeCallbacksAndMessages((Object) null);
        TaskCompletionSource taskCompletionSource = this.f20569b;
        if (task.v()) {
            taskCompletionSource.e(task.r());
        } else if (task.t()) {
            this.f20570c.c();
        } else {
            Exception q = task.q();
            q.getClass();
            taskCompletionSource.d(q);
        }
    }
}
