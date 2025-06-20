package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.File;

final class AutoValue_CrashlyticsReportWithSessionId extends CrashlyticsReportWithSessionId {

    /* renamed from: a  reason: collision with root package name */
    private final CrashlyticsReport f23536a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23537b;

    /* renamed from: c  reason: collision with root package name */
    private final File f23538c;

    AutoValue_CrashlyticsReportWithSessionId(CrashlyticsReport crashlyticsReport, String str, File file) {
        if (crashlyticsReport != null) {
            this.f23536a = crashlyticsReport;
            if (str != null) {
                this.f23537b = str;
                if (file != null) {
                    this.f23538c = file;
                    return;
                }
                throw new NullPointerException("Null reportFile");
            }
            throw new NullPointerException("Null sessionId");
        }
        throw new NullPointerException("Null report");
    }

    public CrashlyticsReport b() {
        return this.f23536a;
    }

    public File c() {
        return this.f23538c;
    }

    public String d() {
        return this.f23537b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReportWithSessionId)) {
            return false;
        }
        CrashlyticsReportWithSessionId crashlyticsReportWithSessionId = (CrashlyticsReportWithSessionId) obj;
        return this.f23536a.equals(crashlyticsReportWithSessionId.b()) && this.f23537b.equals(crashlyticsReportWithSessionId.d()) && this.f23538c.equals(crashlyticsReportWithSessionId.c());
    }

    public int hashCode() {
        return ((((this.f23536a.hashCode() ^ 1000003) * 1000003) ^ this.f23537b.hashCode()) * 1000003) ^ this.f23538c.hashCode();
    }

    public String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.f23536a + ", sessionId=" + this.f23537b + ", reportFile=" + this.f23538c + "}";
    }
}
