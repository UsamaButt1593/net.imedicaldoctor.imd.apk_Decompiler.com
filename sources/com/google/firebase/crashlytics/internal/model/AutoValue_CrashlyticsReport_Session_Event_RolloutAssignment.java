package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment extends CrashlyticsReport.Session.Event.RolloutAssignment {

    /* renamed from: a  reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant f24136a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24137b;

    /* renamed from: c  reason: collision with root package name */
    private final String f24138c;

    /* renamed from: d  reason: collision with root package name */
    private final long f24139d;

    static final class Builder extends CrashlyticsReport.Session.Event.RolloutAssignment.Builder {

        /* renamed from: a  reason: collision with root package name */
        private CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant f24140a;

        /* renamed from: b  reason: collision with root package name */
        private String f24141b;

        /* renamed from: c  reason: collision with root package name */
        private String f24142c;

        /* renamed from: d  reason: collision with root package name */
        private long f24143d;

        /* renamed from: e  reason: collision with root package name */
        private byte f24144e;

        Builder() {
        }

        public CrashlyticsReport.Session.Event.RolloutAssignment a() {
            CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant rolloutVariant;
            String str;
            String str2;
            if (this.f24144e == 1 && (rolloutVariant = this.f24140a) != null && (str = this.f24141b) != null && (str2 = this.f24142c) != null) {
                return new AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment(rolloutVariant, str, str2, this.f24143d);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f24140a == null) {
                sb.append(" rolloutVariant");
            }
            if (this.f24141b == null) {
                sb.append(" parameterKey");
            }
            if (this.f24142c == null) {
                sb.append(" parameterValue");
            }
            if ((1 & this.f24144e) == 0) {
                sb.append(" templateVersion");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public CrashlyticsReport.Session.Event.RolloutAssignment.Builder b(String str) {
            if (str != null) {
                this.f24141b = str;
                return this;
            }
            throw new NullPointerException("Null parameterKey");
        }

        public CrashlyticsReport.Session.Event.RolloutAssignment.Builder c(String str) {
            if (str != null) {
                this.f24142c = str;
                return this;
            }
            throw new NullPointerException("Null parameterValue");
        }

        public CrashlyticsReport.Session.Event.RolloutAssignment.Builder d(CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant rolloutVariant) {
            if (rolloutVariant != null) {
                this.f24140a = rolloutVariant;
                return this;
            }
            throw new NullPointerException("Null rolloutVariant");
        }

        public CrashlyticsReport.Session.Event.RolloutAssignment.Builder e(long j2) {
            this.f24143d = j2;
            this.f24144e = (byte) (this.f24144e | 1);
            return this;
        }
    }

    private AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment(CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant rolloutVariant, String str, String str2, long j2) {
        this.f24136a = rolloutVariant;
        this.f24137b = str;
        this.f24138c = str2;
        this.f24139d = j2;
    }

    @NonNull
    public String b() {
        return this.f24137b;
    }

    @NonNull
    public String c() {
        return this.f24138c;
    }

    @NonNull
    public CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant d() {
        return this.f24136a;
    }

    @NonNull
    public long e() {
        return this.f24139d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.RolloutAssignment)) {
            return false;
        }
        CrashlyticsReport.Session.Event.RolloutAssignment rolloutAssignment = (CrashlyticsReport.Session.Event.RolloutAssignment) obj;
        return this.f24136a.equals(rolloutAssignment.d()) && this.f24137b.equals(rolloutAssignment.b()) && this.f24138c.equals(rolloutAssignment.c()) && this.f24139d == rolloutAssignment.e();
    }

    public int hashCode() {
        long j2 = this.f24139d;
        return ((((((this.f24136a.hashCode() ^ 1000003) * 1000003) ^ this.f24137b.hashCode()) * 1000003) ^ this.f24138c.hashCode()) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "RolloutAssignment{rolloutVariant=" + this.f24136a + ", parameterKey=" + this.f24137b + ", parameterValue=" + this.f24138c + ", templateVersion=" + this.f24139d + "}";
    }
}
