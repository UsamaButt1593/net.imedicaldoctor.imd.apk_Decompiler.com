package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public final class zadc {

    /* renamed from: c  reason: collision with root package name */
    public static final Status f20156c = new Status(8, "The connection to Google Play services was lost");
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    final Set<BasePendingResult<?>> f20157a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    /* renamed from: b  reason: collision with root package name */
    private final zadb f20158b = new zadb(this);

    /* access modifiers changed from: package-private */
    public final void a(BasePendingResult<? extends Result> basePendingResult) {
        this.f20157a.add(basePendingResult);
        basePendingResult.v(this.f20158b);
    }

    public final void b() {
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.f20157a.toArray(new BasePendingResult[0])) {
            basePendingResult.v((zadb) null);
            if (basePendingResult.u()) {
                this.f20157a.remove(basePendingResult);
            }
        }
    }
}
