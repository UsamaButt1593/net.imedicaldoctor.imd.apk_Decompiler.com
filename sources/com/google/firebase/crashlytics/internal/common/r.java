package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class r implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SessionReportingCoordinator f23689a;

    public /* synthetic */ r(SessionReportingCoordinator sessionReportingCoordinator) {
        this.f23689a = sessionReportingCoordinator;
    }

    public final Object a(Task task) {
        return Boolean.valueOf(this.f23689a.v(task));
    }
}
