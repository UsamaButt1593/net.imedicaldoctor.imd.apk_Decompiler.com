package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment_RolloutVariant extends CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant {

    /* renamed from: a  reason: collision with root package name */
    private final String f24145a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24146b;

    static final class Builder extends CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f24147a;

        /* renamed from: b  reason: collision with root package name */
        private String f24148b;

        Builder() {
        }

        public CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant a() {
            String str;
            String str2 = this.f24147a;
            if (str2 != null && (str = this.f24148b) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment_RolloutVariant(str2, str);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f24147a == null) {
                sb.append(" rolloutId");
            }
            if (this.f24148b == null) {
                sb.append(" variantId");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant.Builder b(String str) {
            if (str != null) {
                this.f24147a = str;
                return this;
            }
            throw new NullPointerException("Null rolloutId");
        }

        public CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant.Builder c(String str) {
            if (str != null) {
                this.f24148b = str;
                return this;
            }
            throw new NullPointerException("Null variantId");
        }
    }

    private AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment_RolloutVariant(String str, String str2) {
        this.f24145a = str;
        this.f24146b = str2;
    }

    @NonNull
    public String b() {
        return this.f24145a;
    }

    @NonNull
    public String c() {
        return this.f24146b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant)) {
            return false;
        }
        CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant rolloutVariant = (CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant) obj;
        return this.f24145a.equals(rolloutVariant.b()) && this.f24146b.equals(rolloutVariant.c());
    }

    public int hashCode() {
        return ((this.f24145a.hashCode() ^ 1000003) * 1000003) ^ this.f24146b.hashCode();
    }

    public String toString() {
        return "RolloutVariant{rolloutId=" + this.f24145a + ", variantId=" + this.f24146b + "}";
    }
}
