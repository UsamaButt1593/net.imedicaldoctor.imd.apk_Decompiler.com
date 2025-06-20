package com.google.android.datatransport.cct;

import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.runtime.retries.RetryStrategy;

public final /* synthetic */ class b implements RetryStrategy {
    public final Object a(Object obj, Object obj2) {
        return CctTransportBackend.m((CctTransportBackend.HttpRequest) obj, (CctTransportBackend.HttpResponse) obj2);
    }
}
