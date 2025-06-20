package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame {

    /* renamed from: a  reason: collision with root package name */
    private final long f24101a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24102b;

    /* renamed from: c  reason: collision with root package name */
    private final String f24103c;

    /* renamed from: d  reason: collision with root package name */
    private final long f24104d;

    /* renamed from: e  reason: collision with root package name */
    private final int f24105e;

    static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder {

        /* renamed from: a  reason: collision with root package name */
        private long f24106a;

        /* renamed from: b  reason: collision with root package name */
        private String f24107b;

        /* renamed from: c  reason: collision with root package name */
        private String f24108c;

        /* renamed from: d  reason: collision with root package name */
        private long f24109d;

        /* renamed from: e  reason: collision with root package name */
        private int f24110e;

        /* renamed from: f  reason: collision with root package name */
        private byte f24111f;

        Builder() {
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame a() {
            String str;
            if (this.f24111f == 7 && (str = this.f24107b) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(this.f24106a, str, this.f24108c, this.f24109d, this.f24110e);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f24111f & 1) == 0) {
                sb.append(" pc");
            }
            if (this.f24107b == null) {
                sb.append(" symbol");
            }
            if ((this.f24111f & 2) == 0) {
                sb.append(" offset");
            }
            if ((this.f24111f & 4) == 0) {
                sb.append(" importance");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder b(String str) {
            this.f24108c = str;
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder c(int i2) {
            this.f24110e = i2;
            this.f24111f = (byte) (this.f24111f | 4);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder d(long j2) {
            this.f24109d = j2;
            this.f24111f = (byte) (this.f24111f | 2);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder e(long j2) {
            this.f24106a = j2;
            this.f24111f = (byte) (this.f24111f | 1);
            return this;
        }

        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder f(String str) {
            if (str != null) {
                this.f24107b = str;
                return this;
            }
            throw new NullPointerException("Null symbol");
        }
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(long j2, String str, @Nullable String str2, long j3, int i2) {
        this.f24101a = j2;
        this.f24102b = str;
        this.f24103c = str2;
        this.f24104d = j3;
        this.f24105e = i2;
    }

    @Nullable
    public String b() {
        return this.f24103c;
    }

    public int c() {
        return this.f24105e;
    }

    public long d() {
        return this.f24104d;
    }

    public long e() {
        return this.f24101a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        r1 = r7.f24103c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame
            r2 = 0
            if (r1 == 0) goto L_0x004b
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame r8 = (com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame) r8
            long r3 = r7.f24101a
            long r5 = r8.e()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0049
            java.lang.String r1 = r7.f24102b
            java.lang.String r3 = r8.f()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0049
            java.lang.String r1 = r7.f24103c
            if (r1 != 0) goto L_0x002c
            java.lang.String r1 = r8.b()
            if (r1 != 0) goto L_0x0049
            goto L_0x0036
        L_0x002c:
            java.lang.String r3 = r8.b()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0049
        L_0x0036:
            long r3 = r7.f24104d
            long r5 = r8.d()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0049
            int r1 = r7.f24105e
            int r8 = r8.c()
            if (r1 != r8) goto L_0x0049
            goto L_0x004a
        L_0x0049:
            r0 = 0
        L_0x004a:
            return r0
        L_0x004b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.equals(java.lang.Object):boolean");
    }

    @NonNull
    public String f() {
        return this.f24102b;
    }

    public int hashCode() {
        long j2 = this.f24101a;
        int hashCode = (((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ this.f24102b.hashCode()) * 1000003;
        String str = this.f24103c;
        int hashCode2 = str == null ? 0 : str.hashCode();
        long j3 = this.f24104d;
        return this.f24105e ^ ((((hashCode ^ hashCode2) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003);
    }

    public String toString() {
        return "Frame{pc=" + this.f24101a + ", symbol=" + this.f24102b + ", file=" + this.f24103c + ", offset=" + this.f24104d + ", importance=" + this.f24105e + "}";
    }
}
