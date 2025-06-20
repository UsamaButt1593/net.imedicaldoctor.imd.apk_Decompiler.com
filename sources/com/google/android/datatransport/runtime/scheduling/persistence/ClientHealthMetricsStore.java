package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;

public interface ClientHealthMetricsStore {
    void b();

    ClientMetrics d();

    void e(long j2, LogEventDropped.Reason reason, String str);
}
