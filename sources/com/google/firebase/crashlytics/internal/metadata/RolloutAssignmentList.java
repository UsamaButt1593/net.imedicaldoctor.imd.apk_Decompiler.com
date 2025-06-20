package com.google.firebase.crashlytics.internal.metadata;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RolloutAssignmentList {

    /* renamed from: c  reason: collision with root package name */
    static final String f23738c = "rolloutsState";

    /* renamed from: a  reason: collision with root package name */
    private final List<RolloutAssignment> f23739a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final int f23740b;

    public RolloutAssignmentList(int i2) {
        this.f23740b = i2;
    }

    public List<CrashlyticsReport.Session.Event.RolloutAssignment> a() {
        List<RolloutAssignment> b2 = b();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < b2.size(); i2++) {
            arrayList.add(b2.get(i2).h());
        }
        return arrayList;
    }

    public synchronized List<RolloutAssignment> b() {
        return Collections.unmodifiableList(new ArrayList(this.f23739a));
    }

    @CanIgnoreReturnValue
    public synchronized boolean c(List<RolloutAssignment> list) {
        this.f23739a.clear();
        if (list.size() > this.f23740b) {
            Logger f2 = Logger.f();
            f2.m("Ignored " + 0 + " entries when adding rollout assignments. Maximum allowable: " + this.f23740b);
            return this.f23739a.addAll(list.subList(0, this.f23740b));
        }
        return this.f23739a.addAll(list);
    }
}
