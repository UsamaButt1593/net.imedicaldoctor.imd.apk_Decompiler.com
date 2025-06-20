package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception extends CrashlyticsReport.Session.Event.Application.Execution.Exception {

    /* renamed from: a  reason: collision with root package name */
    private final String f24076a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24077b;

    /* renamed from: c  reason: collision with root package name */
    private final List<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> f24078c;

    /* renamed from: d  reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Application.Execution.Exception f24079d;

    /* renamed from: e  reason: collision with root package name */
    private final int f24080e;

    static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f24081a;

        /* renamed from: b  reason: collision with root package name */
        private String f24082b;

        /* renamed from: c  reason: collision with root package name */
        private List<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> f24083c;

        /* renamed from: d  reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Application.Execution.Exception f24084d;

        /* renamed from: e  reason: collision with root package name */
        private int f24085e;

        /* renamed from: f  reason: collision with root package name */
        private byte f24086f;

        Builder() {
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Exception a() {
            String str;
            List<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> list;
            if (this.f24086f == 1 && (str = this.f24081a) != null && (list = this.f24083c) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(str, this.f24082b, list, this.f24084d, this.f24085e);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f24081a == null) {
                sb.append(" type");
            }
            if (this.f24083c == null) {
                sb.append(" frames");
            }
            if ((1 & this.f24086f) == 0) {
                sb.append(" overflowCount");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder b(CrashlyticsReport.Session.Event.Application.Execution.Exception exception) {
            this.f24084d = exception;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder c(List<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> list) {
            if (list != null) {
                this.f24083c = list;
                return this;
            }
            throw new NullPointerException("Null frames");
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder d(int i2) {
            this.f24085e = i2;
            this.f24086f = (byte) (this.f24086f | 1);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder e(String str) {
            this.f24082b = str;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder f(String str) {
            if (str != null) {
                this.f24081a = str;
                return this;
            }
            throw new NullPointerException("Null type");
        }
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(String str, @Nullable String str2, List<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> list, @Nullable CrashlyticsReport.Session.Event.Application.Execution.Exception exception, int i2) {
        this.f24076a = str;
        this.f24077b = str2;
        this.f24078c = list;
        this.f24079d = exception;
        this.f24080e = i2;
    }

    @Nullable
    public CrashlyticsReport.Session.Event.Application.Execution.Exception b() {
        return this.f24079d;
    }

    @NonNull
    public List<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> c() {
        return this.f24078c;
    }

    public int d() {
        return this.f24080e;
    }

    @Nullable
    public String e() {
        return this.f24077b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        r1 = r4.f24079d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
        r1 = r4.f24077b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception
            r2 = 0
            if (r1 == 0) goto L_0x0058
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception r5 = (com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception) r5
            java.lang.String r1 = r4.f24076a
            java.lang.String r3 = r5.f()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0056
            java.lang.String r1 = r4.f24077b
            if (r1 != 0) goto L_0x0022
            java.lang.String r1 = r5.e()
            if (r1 != 0) goto L_0x0056
            goto L_0x002c
        L_0x0022:
            java.lang.String r3 = r5.e()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0056
        L_0x002c:
            java.util.List<com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame> r1 = r4.f24078c
            java.util.List r3 = r5.c()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0056
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception r1 = r4.f24079d
            if (r1 != 0) goto L_0x0043
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception r1 = r5.b()
            if (r1 != 0) goto L_0x0056
            goto L_0x004d
        L_0x0043:
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception r3 = r5.b()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0056
        L_0x004d:
            int r1 = r4.f24080e
            int r5 = r5.d()
            if (r1 != r5) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r0 = 0
        L_0x0057:
            return r0
        L_0x0058:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.equals(java.lang.Object):boolean");
    }

    @NonNull
    public String f() {
        return this.f24076a;
    }

    public int hashCode() {
        int hashCode = (this.f24076a.hashCode() ^ 1000003) * 1000003;
        String str = this.f24077b;
        int i2 = 0;
        int hashCode2 = (((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f24078c.hashCode()) * 1000003;
        CrashlyticsReport.Session.Event.Application.Execution.Exception exception = this.f24079d;
        if (exception != null) {
            i2 = exception.hashCode();
        }
        return ((hashCode2 ^ i2) * 1000003) ^ this.f24080e;
    }

    public String toString() {
        return "Exception{type=" + this.f24076a + ", reason=" + this.f24077b + ", frames=" + this.f24078c + ", causedBy=" + this.f24079d + ", overflowCount=" + this.f24080e + "}";
    }
}
