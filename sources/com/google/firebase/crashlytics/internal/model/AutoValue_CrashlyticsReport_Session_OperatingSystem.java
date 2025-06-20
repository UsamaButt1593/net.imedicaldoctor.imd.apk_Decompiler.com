package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_Session_OperatingSystem extends CrashlyticsReport.Session.OperatingSystem {

    /* renamed from: a  reason: collision with root package name */
    private final int f24151a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24152b;

    /* renamed from: c  reason: collision with root package name */
    private final String f24153c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f24154d;

    static final class Builder extends CrashlyticsReport.Session.OperatingSystem.Builder {

        /* renamed from: a  reason: collision with root package name */
        private int f24155a;

        /* renamed from: b  reason: collision with root package name */
        private String f24156b;

        /* renamed from: c  reason: collision with root package name */
        private String f24157c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f24158d;

        /* renamed from: e  reason: collision with root package name */
        private byte f24159e;

        Builder() {
        }

        public CrashlyticsReport.Session.OperatingSystem a() {
            String str;
            String str2;
            if (this.f24159e == 3 && (str = this.f24156b) != null && (str2 = this.f24157c) != null) {
                return new AutoValue_CrashlyticsReport_Session_OperatingSystem(this.f24155a, str, str2, this.f24158d);
            }
            StringBuilder sb = new StringBuilder();
            if ((this.f24159e & 1) == 0) {
                sb.append(" platform");
            }
            if (this.f24156b == null) {
                sb.append(" version");
            }
            if (this.f24157c == null) {
                sb.append(" buildVersion");
            }
            if ((this.f24159e & 2) == 0) {
                sb.append(" jailbroken");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public CrashlyticsReport.Session.OperatingSystem.Builder b(String str) {
            if (str != null) {
                this.f24157c = str;
                return this;
            }
            throw new NullPointerException("Null buildVersion");
        }

        public CrashlyticsReport.Session.OperatingSystem.Builder c(boolean z) {
            this.f24158d = z;
            this.f24159e = (byte) (this.f24159e | 2);
            return this;
        }

        public CrashlyticsReport.Session.OperatingSystem.Builder d(int i2) {
            this.f24155a = i2;
            this.f24159e = (byte) (this.f24159e | 1);
            return this;
        }

        public CrashlyticsReport.Session.OperatingSystem.Builder e(String str) {
            if (str != null) {
                this.f24156b = str;
                return this;
            }
            throw new NullPointerException("Null version");
        }
    }

    private AutoValue_CrashlyticsReport_Session_OperatingSystem(int i2, String str, String str2, boolean z) {
        this.f24151a = i2;
        this.f24152b = str;
        this.f24153c = str2;
        this.f24154d = z;
    }

    @NonNull
    public String b() {
        return this.f24153c;
    }

    public int c() {
        return this.f24151a;
    }

    @NonNull
    public String d() {
        return this.f24152b;
    }

    public boolean e() {
        return this.f24154d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.OperatingSystem)) {
            return false;
        }
        CrashlyticsReport.Session.OperatingSystem operatingSystem = (CrashlyticsReport.Session.OperatingSystem) obj;
        return this.f24151a == operatingSystem.c() && this.f24152b.equals(operatingSystem.d()) && this.f24153c.equals(operatingSystem.b()) && this.f24154d == operatingSystem.e();
    }

    public int hashCode() {
        return ((((((this.f24151a ^ 1000003) * 1000003) ^ this.f24152b.hashCode()) * 1000003) ^ this.f24153c.hashCode()) * 1000003) ^ (this.f24154d ? 1231 : 1237);
    }

    public String toString() {
        return "OperatingSystem{platform=" + this.f24151a + ", version=" + this.f24152b + ", buildVersion=" + this.f24153c + ", jailbroken=" + this.f24154d + "}";
    }
}
