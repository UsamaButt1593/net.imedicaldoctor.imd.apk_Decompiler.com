package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ TransportContext X;
    public final /* synthetic */ TransportScheduleCallback Y;
    public final /* synthetic */ EventInternal Z;
    public final /* synthetic */ DefaultScheduler s;

    public /* synthetic */ a(DefaultScheduler defaultScheduler, TransportContext transportContext, TransportScheduleCallback transportScheduleCallback, EventInternal eventInternal) {
        this.s = defaultScheduler;
        this.X = transportContext;
        this.Y = transportScheduleCallback;
        this.Z = eventInternal;
    }

    public final void run() {
        this.s.e(this.X, this.Y, this.Z);
    }
}
