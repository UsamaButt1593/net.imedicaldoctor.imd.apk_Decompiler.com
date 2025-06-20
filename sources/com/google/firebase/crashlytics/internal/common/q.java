package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Comparator;

public final /* synthetic */ class q implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return ((CrashlyticsReport.CustomAttribute) obj).b().compareTo(((CrashlyticsReport.CustomAttribute) obj2).b());
    }
}
