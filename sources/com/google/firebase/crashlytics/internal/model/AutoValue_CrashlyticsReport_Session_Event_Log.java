package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_Session_Event_Log extends CrashlyticsReport.Session.Event.Log {

    /* renamed from: a  reason: collision with root package name */
    private final String f24134a;

    static final class Builder extends CrashlyticsReport.Session.Event.Log.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f24135a;

        Builder() {
        }

        public CrashlyticsReport.Session.Event.Log a() {
            String str = this.f24135a;
            if (str != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Log(str);
            }
            throw new IllegalStateException("Missing required properties:" + " content");
        }

        public CrashlyticsReport.Session.Event.Log.Builder b(String str) {
            if (str != null) {
                this.f24135a = str;
                return this;
            }
            throw new NullPointerException("Null content");
        }
    }

    private AutoValue_CrashlyticsReport_Session_Event_Log(String str) {
        this.f24134a = str;
    }

    @NonNull
    public String b() {
        return this.f24134a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.Event.Log) {
            return this.f24134a.equals(((CrashlyticsReport.Session.Event.Log) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f24134a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Log{content=" + this.f24134a + "}";
    }
}
