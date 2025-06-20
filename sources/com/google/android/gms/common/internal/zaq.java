package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;

final class zaq implements PendingResultUtil.ResultConverter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Response f20293a;

    zaq(Response response) {
        this.f20293a = response;
    }

    public final /* bridge */ /* synthetic */ Object a(Result result) {
        this.f20293a.c(result);
        return this.f20293a;
    }
}
