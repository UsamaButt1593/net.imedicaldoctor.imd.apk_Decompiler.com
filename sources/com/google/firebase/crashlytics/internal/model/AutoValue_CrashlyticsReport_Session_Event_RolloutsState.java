package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

final class AutoValue_CrashlyticsReport_Session_Event_RolloutsState extends CrashlyticsReport.Session.Event.RolloutsState {

    /* renamed from: a  reason: collision with root package name */
    private final List<CrashlyticsReport.Session.Event.RolloutAssignment> f24149a;

    static final class Builder extends CrashlyticsReport.Session.Event.RolloutsState.Builder {

        /* renamed from: a  reason: collision with root package name */
        private List<CrashlyticsReport.Session.Event.RolloutAssignment> f24150a;

        Builder() {
        }

        public CrashlyticsReport.Session.Event.RolloutsState a() {
            List<CrashlyticsReport.Session.Event.RolloutAssignment> list = this.f24150a;
            if (list != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_RolloutsState(list);
            }
            throw new IllegalStateException("Missing required properties:" + " rolloutAssignments");
        }

        public CrashlyticsReport.Session.Event.RolloutsState.Builder b(List<CrashlyticsReport.Session.Event.RolloutAssignment> list) {
            if (list != null) {
                this.f24150a = list;
                return this;
            }
            throw new NullPointerException("Null rolloutAssignments");
        }
    }

    private AutoValue_CrashlyticsReport_Session_Event_RolloutsState(List<CrashlyticsReport.Session.Event.RolloutAssignment> list) {
        this.f24149a = list;
    }

    @NonNull
    @Encodable.Field(name = "assignments")
    public List<CrashlyticsReport.Session.Event.RolloutAssignment> b() {
        return this.f24149a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Event.RolloutsState) {
            return this.f24149a.equals(((CrashlyticsReport.Session.Event.RolloutsState) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f24149a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "RolloutsState{rolloutAssignments=" + this.f24149a + "}";
    }
}
