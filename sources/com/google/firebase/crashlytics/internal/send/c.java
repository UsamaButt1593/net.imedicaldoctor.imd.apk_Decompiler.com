package com.google.firebase.crashlytics.internal.send;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;

public final /* synthetic */ class c implements TransportScheduleCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReportQueue f24243a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f24244b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f24245c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CrashlyticsReportWithSessionId f24246d;

    public /* synthetic */ c(ReportQueue reportQueue, TaskCompletionSource taskCompletionSource, boolean z, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        this.f24243a = reportQueue;
        this.f24244b = taskCompletionSource;
        this.f24245c = z;
        this.f24246d = crashlyticsReportWithSessionId;
    }

    public final void a(Exception exc) {
        this.f24243a.n(this.f24244b, this.f24245c, this.f24246d, exc);
    }
}
