package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_Session_Event_Application_ProcessDetails extends CrashlyticsReport.Session.Event.Application.ProcessDetails {

    /* renamed from: a  reason: collision with root package name */
    private final String f24112a;

    /* renamed from: b  reason: collision with root package name */
    private final int f24113b;

    /* renamed from: c  reason: collision with root package name */
    private final int f24114c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f24115d;

    static final class Builder extends CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f24116a;

        /* renamed from: b  reason: collision with root package name */
        private int f24117b;

        /* renamed from: c  reason: collision with root package name */
        private int f24118c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f24119d;

        /* renamed from: e  reason: collision with root package name */
        private byte f24120e;

        Builder() {
        }

        public CrashlyticsReport.Session.Event.Application.ProcessDetails a() {
            String str;
            if (this.f24120e == 7 && (str = this.f24116a) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_ProcessDetails(str, this.f24117b, this.f24118c, this.f24119d);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f24116a == null) {
                sb.append(" processName");
            }
            if ((this.f24120e & 1) == 0) {
                sb.append(" pid");
            }
            if ((this.f24120e & 2) == 0) {
                sb.append(" importance");
            }
            if ((this.f24120e & 4) == 0) {
                sb.append(" defaultProcess");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder b(boolean z) {
            this.f24119d = z;
            this.f24120e = (byte) (this.f24120e | 4);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder c(int i2) {
            this.f24118c = i2;
            this.f24120e = (byte) (this.f24120e | 2);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder d(int i2) {
            this.f24117b = i2;
            this.f24120e = (byte) (this.f24120e | 1);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder e(String str) {
            if (str != null) {
                this.f24116a = str;
                return this;
            }
            throw new NullPointerException("Null processName");
        }
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_ProcessDetails(String str, int i2, int i3, boolean z) {
        this.f24112a = str;
        this.f24113b = i2;
        this.f24114c = i3;
        this.f24115d = z;
    }

    public int b() {
        return this.f24114c;
    }

    public int c() {
        return this.f24113b;
    }

    @NonNull
    public String d() {
        return this.f24112a;
    }

    public boolean e() {
        return this.f24115d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.ProcessDetails)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.ProcessDetails processDetails = (CrashlyticsReport.Session.Event.Application.ProcessDetails) obj;
        return this.f24112a.equals(processDetails.d()) && this.f24113b == processDetails.c() && this.f24114c == processDetails.b() && this.f24115d == processDetails.e();
    }

    public int hashCode() {
        return ((((((this.f24112a.hashCode() ^ 1000003) * 1000003) ^ this.f24113b) * 1000003) ^ this.f24114c) * 1000003) ^ (this.f24115d ? 1231 : 1237);
    }

    public String toString() {
        return "ProcessDetails{processName=" + this.f24112a + ", pid=" + this.f24113b + ", importance=" + this.f24114c + ", defaultProcess=" + this.f24115d + "}";
    }
}
