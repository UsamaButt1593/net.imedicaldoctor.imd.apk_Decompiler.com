package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

final class zaab implements PendingResult.StatusListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BasePendingResult f20039a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zaad f20040b;

    zaab(zaad zaad, BasePendingResult basePendingResult) {
        this.f20040b = zaad;
        this.f20039a = basePendingResult;
    }

    public final void a(Status status) {
        this.f20040b.f20043a.remove(this.f20039a);
    }
}
