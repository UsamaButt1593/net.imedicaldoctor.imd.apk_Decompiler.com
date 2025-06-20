package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution extends CrashlyticsReport.Session.Event.Application.Execution {

    /* renamed from: a  reason: collision with root package name */
    private final List<CrashlyticsReport.Session.Event.Application.Execution.Thread> f24057a;

    /* renamed from: b  reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Application.Execution.Exception f24058b;

    /* renamed from: c  reason: collision with root package name */
    private final CrashlyticsReport.ApplicationExitInfo f24059c;

    /* renamed from: d  reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Application.Execution.Signal f24060d;

    /* renamed from: e  reason: collision with root package name */
    private final List<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> f24061e;

    static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Builder {

        /* renamed from: a  reason: collision with root package name */
        private List<CrashlyticsReport.Session.Event.Application.Execution.Thread> f24062a;

        /* renamed from: b  reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Application.Execution.Exception f24063b;

        /* renamed from: c  reason: collision with root package name */
        private CrashlyticsReport.ApplicationExitInfo f24064c;

        /* renamed from: d  reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Application.Execution.Signal f24065d;

        /* renamed from: e  reason: collision with root package name */
        private List<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> f24066e;

        Builder() {
        }

        public CrashlyticsReport.Session.Event.Application.Execution a() {
            List<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> list;
            CrashlyticsReport.Session.Event.Application.Execution.Signal signal = this.f24065d;
            if (signal != null && (list = this.f24066e) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution(this.f24062a, this.f24063b, this.f24064c, signal, list);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f24065d == null) {
                sb.append(" signal");
            }
            if (this.f24066e == null) {
                sb.append(" binaries");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Builder b(CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
            this.f24064c = applicationExitInfo;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Builder c(List<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> list) {
            if (list != null) {
                this.f24066e = list;
                return this;
            }
            throw new NullPointerException("Null binaries");
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Builder d(CrashlyticsReport.Session.Event.Application.Execution.Exception exception) {
            this.f24063b = exception;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Builder e(CrashlyticsReport.Session.Event.Application.Execution.Signal signal) {
            if (signal != null) {
                this.f24065d = signal;
                return this;
            }
            throw new NullPointerException("Null signal");
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Builder f(List<CrashlyticsReport.Session.Event.Application.Execution.Thread> list) {
            this.f24062a = list;
            return this;
        }
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution(@Nullable List<CrashlyticsReport.Session.Event.Application.Execution.Thread> list, @Nullable CrashlyticsReport.Session.Event.Application.Execution.Exception exception, @Nullable CrashlyticsReport.ApplicationExitInfo applicationExitInfo, CrashlyticsReport.Session.Event.Application.Execution.Signal signal, List<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> list2) {
        this.f24057a = list;
        this.f24058b = exception;
        this.f24059c = applicationExitInfo;
        this.f24060d = signal;
        this.f24061e = list2;
    }

    @Nullable
    public CrashlyticsReport.ApplicationExitInfo b() {
        return this.f24059c;
    }

    @NonNull
    public List<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> c() {
        return this.f24061e;
    }

    @Nullable
    public CrashlyticsReport.Session.Event.Application.Execution.Exception d() {
        return this.f24058b;
    }

    @NonNull
    public CrashlyticsReport.Session.Event.Application.Execution.Signal e() {
        return this.f24060d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution execution = (CrashlyticsReport.Session.Event.Application.Execution) obj;
        List<CrashlyticsReport.Session.Event.Application.Execution.Thread> list = this.f24057a;
        if (list != null ? list.equals(execution.f()) : execution.f() == null) {
            CrashlyticsReport.Session.Event.Application.Execution.Exception exception = this.f24058b;
            if (exception != null ? exception.equals(execution.d()) : execution.d() == null) {
                CrashlyticsReport.ApplicationExitInfo applicationExitInfo = this.f24059c;
                if (applicationExitInfo != null ? applicationExitInfo.equals(execution.b()) : execution.b() == null) {
                    return this.f24060d.equals(execution.e()) && this.f24061e.equals(execution.c());
                }
            }
        }
    }

    @Nullable
    public List<CrashlyticsReport.Session.Event.Application.Execution.Thread> f() {
        return this.f24057a;
    }

    public int hashCode() {
        List<CrashlyticsReport.Session.Event.Application.Execution.Thread> list = this.f24057a;
        int i2 = 0;
        int hashCode = ((list == null ? 0 : list.hashCode()) ^ 1000003) * 1000003;
        CrashlyticsReport.Session.Event.Application.Execution.Exception exception = this.f24058b;
        int hashCode2 = (hashCode ^ (exception == null ? 0 : exception.hashCode())) * 1000003;
        CrashlyticsReport.ApplicationExitInfo applicationExitInfo = this.f24059c;
        if (applicationExitInfo != null) {
            i2 = applicationExitInfo.hashCode();
        }
        return ((((hashCode2 ^ i2) * 1000003) ^ this.f24060d.hashCode()) * 1000003) ^ this.f24061e.hashCode();
    }

    public String toString() {
        return "Execution{threads=" + this.f24057a + ", exception=" + this.f24058b + ", appExitInfo=" + this.f24059c + ", signal=" + this.f24060d + ", binaries=" + this.f24061e + "}";
    }
}
