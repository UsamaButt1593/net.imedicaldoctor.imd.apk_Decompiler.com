package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

final class AutoValue_CrashlyticsReport_Session_Event_Application extends CrashlyticsReport.Session.Event.Application {

    /* renamed from: a  reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Application.Execution f24042a;

    /* renamed from: b  reason: collision with root package name */
    private final List<CrashlyticsReport.CustomAttribute> f24043b;

    /* renamed from: c  reason: collision with root package name */
    private final List<CrashlyticsReport.CustomAttribute> f24044c;

    /* renamed from: d  reason: collision with root package name */
    private final Boolean f24045d;

    /* renamed from: e  reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Application.ProcessDetails f24046e;

    /* renamed from: f  reason: collision with root package name */
    private final List<CrashlyticsReport.Session.Event.Application.ProcessDetails> f24047f;

    /* renamed from: g  reason: collision with root package name */
    private final int f24048g;

    static final class Builder extends CrashlyticsReport.Session.Event.Application.Builder {

        /* renamed from: a  reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Application.Execution f24049a;

        /* renamed from: b  reason: collision with root package name */
        private List<CrashlyticsReport.CustomAttribute> f24050b;

        /* renamed from: c  reason: collision with root package name */
        private List<CrashlyticsReport.CustomAttribute> f24051c;

        /* renamed from: d  reason: collision with root package name */
        private Boolean f24052d;

        /* renamed from: e  reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Application.ProcessDetails f24053e;

        /* renamed from: f  reason: collision with root package name */
        private List<CrashlyticsReport.Session.Event.Application.ProcessDetails> f24054f;

        /* renamed from: g  reason: collision with root package name */
        private int f24055g;

        /* renamed from: h  reason: collision with root package name */
        private byte f24056h;

        Builder() {
        }

        public CrashlyticsReport.Session.Event.Application a() {
            CrashlyticsReport.Session.Event.Application.Execution execution;
            if (this.f24056h == 1 && (execution = this.f24049a) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application(execution, this.f24050b, this.f24051c, this.f24052d, this.f24053e, this.f24054f, this.f24055g);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f24049a == null) {
                sb.append(" execution");
            }
            if ((1 & this.f24056h) == 0) {
                sb.append(" uiOrientation");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public CrashlyticsReport.Session.Event.Application.Builder b(@Nullable List<CrashlyticsReport.Session.Event.Application.ProcessDetails> list) {
            this.f24054f = list;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Builder c(@Nullable Boolean bool) {
            this.f24052d = bool;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Builder d(@Nullable CrashlyticsReport.Session.Event.Application.ProcessDetails processDetails) {
            this.f24053e = processDetails;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Builder e(List<CrashlyticsReport.CustomAttribute> list) {
            this.f24050b = list;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Builder f(CrashlyticsReport.Session.Event.Application.Execution execution) {
            if (execution != null) {
                this.f24049a = execution;
                return this;
            }
            throw new NullPointerException("Null execution");
        }

        public CrashlyticsReport.Session.Event.Application.Builder g(List<CrashlyticsReport.CustomAttribute> list) {
            this.f24051c = list;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Builder h(int i2) {
            this.f24055g = i2;
            this.f24056h = (byte) (this.f24056h | 1);
            return this;
        }

        private Builder(CrashlyticsReport.Session.Event.Application application) {
            this.f24049a = application.f();
            this.f24050b = application.e();
            this.f24051c = application.g();
            this.f24052d = application.c();
            this.f24053e = application.d();
            this.f24054f = application.b();
            this.f24055g = application.h();
            this.f24056h = 1;
        }
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application(CrashlyticsReport.Session.Event.Application.Execution execution, @Nullable List<CrashlyticsReport.CustomAttribute> list, @Nullable List<CrashlyticsReport.CustomAttribute> list2, @Nullable Boolean bool, @Nullable CrashlyticsReport.Session.Event.Application.ProcessDetails processDetails, @Nullable List<CrashlyticsReport.Session.Event.Application.ProcessDetails> list3, int i2) {
        this.f24042a = execution;
        this.f24043b = list;
        this.f24044c = list2;
        this.f24045d = bool;
        this.f24046e = processDetails;
        this.f24047f = list3;
        this.f24048g = i2;
    }

    @Nullable
    public List<CrashlyticsReport.Session.Event.Application.ProcessDetails> b() {
        return this.f24047f;
    }

    @Nullable
    public Boolean c() {
        return this.f24045d;
    }

    @Nullable
    public CrashlyticsReport.Session.Event.Application.ProcessDetails d() {
        return this.f24046e;
    }

    @Nullable
    public List<CrashlyticsReport.CustomAttribute> e() {
        return this.f24043b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        r1 = r4.f24044c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
        r1 = r4.f24045d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0056, code lost:
        r1 = r4.f24046e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006b, code lost:
        r1 = r4.f24047f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r1 = r4.f24043b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
            r2 = 0
            if (r1 == 0) goto L_0x008b
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application r5 = (com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application) r5
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution r1 = r4.f24042a
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution r3 = r5.f()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0089
            java.util.List<com.google.firebase.crashlytics.internal.model.CrashlyticsReport$CustomAttribute> r1 = r4.f24043b
            if (r1 != 0) goto L_0x0022
            java.util.List r1 = r5.e()
            if (r1 != 0) goto L_0x0089
            goto L_0x002c
        L_0x0022:
            java.util.List r3 = r5.e()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0089
        L_0x002c:
            java.util.List<com.google.firebase.crashlytics.internal.model.CrashlyticsReport$CustomAttribute> r1 = r4.f24044c
            if (r1 != 0) goto L_0x0037
            java.util.List r1 = r5.g()
            if (r1 != 0) goto L_0x0089
            goto L_0x0041
        L_0x0037:
            java.util.List r3 = r5.g()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0089
        L_0x0041:
            java.lang.Boolean r1 = r4.f24045d
            if (r1 != 0) goto L_0x004c
            java.lang.Boolean r1 = r5.c()
            if (r1 != 0) goto L_0x0089
            goto L_0x0056
        L_0x004c:
            java.lang.Boolean r3 = r5.c()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0089
        L_0x0056:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$ProcessDetails r1 = r4.f24046e
            if (r1 != 0) goto L_0x0061
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$ProcessDetails r1 = r5.d()
            if (r1 != 0) goto L_0x0089
            goto L_0x006b
        L_0x0061:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$ProcessDetails r3 = r5.d()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0089
        L_0x006b:
            java.util.List<com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$ProcessDetails> r1 = r4.f24047f
            if (r1 != 0) goto L_0x0076
            java.util.List r1 = r5.b()
            if (r1 != 0) goto L_0x0089
            goto L_0x0080
        L_0x0076:
            java.util.List r3 = r5.b()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0089
        L_0x0080:
            int r1 = r4.f24048g
            int r5 = r5.h()
            if (r1 != r5) goto L_0x0089
            goto L_0x008a
        L_0x0089:
            r0 = 0
        L_0x008a:
            return r0
        L_0x008b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application.equals(java.lang.Object):boolean");
    }

    @NonNull
    public CrashlyticsReport.Session.Event.Application.Execution f() {
        return this.f24042a;
    }

    @Nullable
    public List<CrashlyticsReport.CustomAttribute> g() {
        return this.f24044c;
    }

    public int h() {
        return this.f24048g;
    }

    public int hashCode() {
        int hashCode = (this.f24042a.hashCode() ^ 1000003) * 1000003;
        List<CrashlyticsReport.CustomAttribute> list = this.f24043b;
        int i2 = 0;
        int hashCode2 = (hashCode ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List<CrashlyticsReport.CustomAttribute> list2 = this.f24044c;
        int hashCode3 = (hashCode2 ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        Boolean bool = this.f24045d;
        int hashCode4 = (hashCode3 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        CrashlyticsReport.Session.Event.Application.ProcessDetails processDetails = this.f24046e;
        int hashCode5 = (hashCode4 ^ (processDetails == null ? 0 : processDetails.hashCode())) * 1000003;
        List<CrashlyticsReport.Session.Event.Application.ProcessDetails> list3 = this.f24047f;
        if (list3 != null) {
            i2 = list3.hashCode();
        }
        return ((hashCode5 ^ i2) * 1000003) ^ this.f24048g;
    }

    public CrashlyticsReport.Session.Event.Application.Builder i() {
        return new Builder(this);
    }

    public String toString() {
        return "Application{execution=" + this.f24042a + ", customAttributes=" + this.f24043b + ", internalKeys=" + this.f24044c + ", background=" + this.f24045d + ", currentProcessDetails=" + this.f24046e + ", appProcessDetails=" + this.f24047f + ", uiOrientation=" + this.f24048g + "}";
    }
}
