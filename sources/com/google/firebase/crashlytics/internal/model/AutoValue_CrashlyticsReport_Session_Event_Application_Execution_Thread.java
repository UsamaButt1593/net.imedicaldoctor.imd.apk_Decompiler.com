package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread extends CrashlyticsReport.Session.Event.Application.Execution.Thread {

    /* renamed from: a  reason: collision with root package name */
    private final String f24094a;

    /* renamed from: b  reason: collision with root package name */
    private final int f24095b;

    /* renamed from: c  reason: collision with root package name */
    private final List<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> f24096c;

    static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f24097a;

        /* renamed from: b  reason: collision with root package name */
        private int f24098b;

        /* renamed from: c  reason: collision with root package name */
        private List<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> f24099c;

        /* renamed from: d  reason: collision with root package name */
        private byte f24100d;

        Builder() {
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread a() {
            String str;
            List<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> list;
            if (this.f24100d == 1 && (str = this.f24097a) != null && (list = this.f24099c) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread(str, this.f24098b, list);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f24097a == null) {
                sb.append(" name");
            }
            if ((1 & this.f24100d) == 0) {
                sb.append(" importance");
            }
            if (this.f24099c == null) {
                sb.append(" frames");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder b(List<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> list) {
            if (list != null) {
                this.f24099c = list;
                return this;
            }
            throw new NullPointerException("Null frames");
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder c(int i2) {
            this.f24098b = i2;
            this.f24100d = (byte) (this.f24100d | 1);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder d(String str) {
            if (str != null) {
                this.f24097a = str;
                return this;
            }
            throw new NullPointerException("Null name");
        }
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread(String str, int i2, List<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> list) {
        this.f24094a = str;
        this.f24095b = i2;
        this.f24096c = list;
    }

    @NonNull
    public List<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> b() {
        return this.f24096c;
    }

    public int c() {
        return this.f24095b;
    }

    @NonNull
    public String d() {
        return this.f24094a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Thread)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Thread thread = (CrashlyticsReport.Session.Event.Application.Execution.Thread) obj;
        return this.f24094a.equals(thread.d()) && this.f24095b == thread.c() && this.f24096c.equals(thread.b());
    }

    public int hashCode() {
        return ((((this.f24094a.hashCode() ^ 1000003) * 1000003) ^ this.f24095b) * 1000003) ^ this.f24096c.hashCode();
    }

    public String toString() {
        return "Thread{name=" + this.f24094a + ", importance=" + this.f24095b + ", frames=" + this.f24096c + "}";
    }
}
