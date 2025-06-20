package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zacu implements RemoteCall {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BiConsumer f20142a;

    public /* synthetic */ zacu(BiConsumer biConsumer) {
        this.f20142a = biConsumer;
    }

    public final void accept(Object obj, Object obj2) {
        this.f20142a.accept((Api.AnyClient) obj, (TaskCompletionSource) obj2);
    }
}
