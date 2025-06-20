package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal extends CrashlyticsReport.Session.Event.Application.Execution.Signal {

    /* renamed from: a  reason: collision with root package name */
    private final String f24087a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24088b;

    /* renamed from: c  reason: collision with root package name */
    private final long f24089c;

    static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f24090a;

        /* renamed from: b  reason: collision with root package name */
        private String f24091b;

        /* renamed from: c  reason: collision with root package name */
        private long f24092c;

        /* renamed from: d  reason: collision with root package name */
        private byte f24093d;

        Builder() {
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Signal a() {
            String str;
            String str2;
            if (this.f24093d == 1 && (str = this.f24090a) != null && (str2 = this.f24091b) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal(str, str2, this.f24092c);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f24090a == null) {
                sb.append(" name");
            }
            if (this.f24091b == null) {
                sb.append(" code");
            }
            if ((1 & this.f24093d) == 0) {
                sb.append(" address");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder b(long j2) {
            this.f24092c = j2;
            this.f24093d = (byte) (this.f24093d | 1);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder c(String str) {
            if (str != null) {
                this.f24091b = str;
                return this;
            }
            throw new NullPointerException("Null code");
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder d(String str) {
            if (str != null) {
                this.f24090a = str;
                return this;
            }
            throw new NullPointerException("Null name");
        }
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal(String str, String str2, long j2) {
        this.f24087a = str;
        this.f24088b = str2;
        this.f24089c = j2;
    }

    @NonNull
    public long b() {
        return this.f24089c;
    }

    @NonNull
    public String c() {
        return this.f24088b;
    }

    @NonNull
    public String d() {
        return this.f24087a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Signal)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Signal signal = (CrashlyticsReport.Session.Event.Application.Execution.Signal) obj;
        return this.f24087a.equals(signal.d()) && this.f24088b.equals(signal.c()) && this.f24089c == signal.b();
    }

    public int hashCode() {
        long j2 = this.f24089c;
        return ((((this.f24087a.hashCode() ^ 1000003) * 1000003) ^ this.f24088b.hashCode()) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "Signal{name=" + this.f24087a + ", code=" + this.f24088b + ", address=" + this.f24089c + "}";
    }
}
