package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_Session_User extends CrashlyticsReport.Session.User {

    /* renamed from: a  reason: collision with root package name */
    private final String f24160a;

    static final class Builder extends CrashlyticsReport.Session.User.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f24161a;

        Builder() {
        }

        public CrashlyticsReport.Session.User a() {
            String str = this.f24161a;
            if (str != null) {
                return new AutoValue_CrashlyticsReport_Session_User(str);
            }
            throw new IllegalStateException("Missing required properties:" + " identifier");
        }

        public CrashlyticsReport.Session.User.Builder b(String str) {
            if (str != null) {
                this.f24161a = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }
    }

    private AutoValue_CrashlyticsReport_Session_User(String str) {
        this.f24160a = str;
    }

    @NonNull
    public String b() {
        return this.f24160a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.User) {
            return this.f24160a.equals(((CrashlyticsReport.Session.User) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f24160a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "User{identifier=" + this.f24160a + "}";
    }
}
