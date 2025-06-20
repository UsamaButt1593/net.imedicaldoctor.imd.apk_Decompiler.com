package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public final class zaad {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Map<BasePendingResult<?>, Boolean> f20043a = Collections.synchronizedMap(new WeakHashMap());
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Map<TaskCompletionSource<?>, Boolean> f20044b = Collections.synchronizedMap(new WeakHashMap());

    private final void h(boolean z, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.f20043a) {
            hashMap = new HashMap(this.f20043a);
        }
        synchronized (this.f20044b) {
            hashMap2 = new HashMap(this.f20044b);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).l(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((TaskCompletionSource) entry2.getKey()).d(new ApiException(status));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void c(BasePendingResult<? extends Result> basePendingResult, boolean z) {
        this.f20043a.put(basePendingResult, Boolean.valueOf(z));
        basePendingResult.c(new zaab(this, basePendingResult));
    }

    /* access modifiers changed from: package-private */
    public final <TResult> void d(TaskCompletionSource<TResult> taskCompletionSource, boolean z) {
        this.f20044b.put(taskCompletionSource, Boolean.valueOf(z));
        taskCompletionSource.a().e(new zaac(this, taskCompletionSource));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(int r4, @androidx.annotation.Nullable java.lang.String r5) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "The connection to Google Play services was lost"
            r0.<init>(r1)
            r1 = 1
            if (r4 != r1) goto L_0x0010
            java.lang.String r4 = " due to service disconnection."
        L_0x000c:
            r0.append(r4)
            goto L_0x0016
        L_0x0010:
            r2 = 3
            if (r4 != r2) goto L_0x0016
            java.lang.String r4 = " due to dead object exception."
            goto L_0x000c
        L_0x0016:
            if (r5 == 0) goto L_0x0020
            java.lang.String r4 = " Last reason for disconnect: "
            r0.append(r4)
            r0.append(r5)
        L_0x0020:
            com.google.android.gms.common.api.Status r4 = new com.google.android.gms.common.api.Status
            r5 = 20
            java.lang.String r0 = r0.toString()
            r4.<init>((int) r5, (java.lang.String) r0)
            r3.h(r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zaad.e(int, java.lang.String):void");
    }

    public final void f() {
        h(false, GoogleApiManager.k3);
    }

    /* access modifiers changed from: package-private */
    public final boolean g() {
        return !this.f20043a.isEmpty() || !this.f20044b.isEmpty();
    }
}
