package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_Session_Application_Organization extends CrashlyticsReport.Session.Application.Organization {

    /* renamed from: a  reason: collision with root package name */
    private final String f24008a;

    static final class Builder extends CrashlyticsReport.Session.Application.Organization.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f24009a;

        Builder() {
        }

        public CrashlyticsReport.Session.Application.Organization a() {
            String str = this.f24009a;
            if (str != null) {
                return new AutoValue_CrashlyticsReport_Session_Application_Organization(str);
            }
            throw new IllegalStateException("Missing required properties:" + " clsId");
        }

        public CrashlyticsReport.Session.Application.Organization.Builder b(String str) {
            if (str != null) {
                this.f24009a = str;
                return this;
            }
            throw new NullPointerException("Null clsId");
        }

        private Builder(CrashlyticsReport.Session.Application.Organization organization) {
            this.f24009a = organization.b();
        }
    }

    private AutoValue_CrashlyticsReport_Session_Application_Organization(String str) {
        this.f24008a = str;
    }

    @NonNull
    public String b() {
        return this.f24008a;
    }

    /* access modifiers changed from: protected */
    public CrashlyticsReport.Session.Application.Organization.Builder c() {
        return new Builder(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Application.Organization) {
            return this.f24008a.equals(((CrashlyticsReport.Session.Application.Organization) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f24008a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Organization{clsId=" + this.f24008a + "}";
    }
}
