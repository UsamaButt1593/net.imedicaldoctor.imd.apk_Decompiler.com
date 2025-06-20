package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.util.concurrent.NumberedThreadFactory;
import com.google.android.gms.internal.base.zap;
import java.util.concurrent.ExecutorService;

public final class zaco {

    /* renamed from: a  reason: collision with root package name */
    private static final ExecutorService f20137a = zap.zaa().zaa(new NumberedThreadFactory("GAC_Transform"), 1);

    public static ExecutorService a() {
        return f20137a;
    }
}
