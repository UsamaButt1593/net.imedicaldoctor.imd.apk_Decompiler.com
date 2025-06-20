package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.util.concurrent.NumberedThreadFactory;
import com.google.android.gms.internal.base.zap;
import java.util.concurrent.ExecutorService;

public final class zabj {

    /* renamed from: a  reason: collision with root package name */
    private static final ExecutorService f20103a = zap.zaa().zac(2, new NumberedThreadFactory("GAC_Executor"), 2);

    public static ExecutorService a() {
        return f20103a;
    }
}
