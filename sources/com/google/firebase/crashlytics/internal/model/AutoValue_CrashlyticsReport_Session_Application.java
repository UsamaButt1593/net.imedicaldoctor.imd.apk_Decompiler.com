package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_Session_Application extends CrashlyticsReport.Session.Application {

    /* renamed from: a  reason: collision with root package name */
    private final String f23994a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23995b;

    /* renamed from: c  reason: collision with root package name */
    private final String f23996c;

    /* renamed from: d  reason: collision with root package name */
    private final CrashlyticsReport.Session.Application.Organization f23997d;

    /* renamed from: e  reason: collision with root package name */
    private final String f23998e;

    /* renamed from: f  reason: collision with root package name */
    private final String f23999f;

    /* renamed from: g  reason: collision with root package name */
    private final String f24000g;

    static final class Builder extends CrashlyticsReport.Session.Application.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f24001a;

        /* renamed from: b  reason: collision with root package name */
        private String f24002b;

        /* renamed from: c  reason: collision with root package name */
        private String f24003c;

        /* renamed from: d  reason: collision with root package name */
        private CrashlyticsReport.Session.Application.Organization f24004d;

        /* renamed from: e  reason: collision with root package name */
        private String f24005e;

        /* renamed from: f  reason: collision with root package name */
        private String f24006f;

        /* renamed from: g  reason: collision with root package name */
        private String f24007g;

        Builder() {
        }

        public CrashlyticsReport.Session.Application a() {
            String str;
            String str2 = this.f24001a;
            if (str2 != null && (str = this.f24002b) != null) {
                return new AutoValue_CrashlyticsReport_Session_Application(str2, str, this.f24003c, this.f24004d, this.f24005e, this.f24006f, this.f24007g);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f24001a == null) {
                sb.append(" identifier");
            }
            if (this.f24002b == null) {
                sb.append(" version");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public CrashlyticsReport.Session.Application.Builder b(@Nullable String str) {
            this.f24006f = str;
            return this;
        }

        public CrashlyticsReport.Session.Application.Builder c(@Nullable String str) {
            this.f24007g = str;
            return this;
        }

        public CrashlyticsReport.Session.Application.Builder d(String str) {
            this.f24003c = str;
            return this;
        }

        public CrashlyticsReport.Session.Application.Builder e(String str) {
            if (str != null) {
                this.f24001a = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }

        public CrashlyticsReport.Session.Application.Builder f(String str) {
            this.f24005e = str;
            return this;
        }

        public CrashlyticsReport.Session.Application.Builder g(CrashlyticsReport.Session.Application.Organization organization) {
            this.f24004d = organization;
            return this;
        }

        public CrashlyticsReport.Session.Application.Builder h(String str) {
            if (str != null) {
                this.f24002b = str;
                return this;
            }
            throw new NullPointerException("Null version");
        }

        private Builder(CrashlyticsReport.Session.Application application) {
            this.f24001a = application.e();
            this.f24002b = application.h();
            this.f24003c = application.d();
            this.f24004d = application.g();
            this.f24005e = application.f();
            this.f24006f = application.b();
            this.f24007g = application.c();
        }
    }

    private AutoValue_CrashlyticsReport_Session_Application(String str, String str2, @Nullable String str3, @Nullable CrashlyticsReport.Session.Application.Organization organization, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        this.f23994a = str;
        this.f23995b = str2;
        this.f23996c = str3;
        this.f23997d = organization;
        this.f23998e = str4;
        this.f23999f = str5;
        this.f24000g = str6;
    }

    @Nullable
    public String b() {
        return this.f23999f;
    }

    @Nullable
    public String c() {
        return this.f24000g;
    }

    @Nullable
    public String d() {
        return this.f23996c;
    }

    @NonNull
    public String e() {
        return this.f23994a;
    }

    public boolean equals(Object obj) {
        String str;
        CrashlyticsReport.Session.Application.Organization organization;
        String str2;
        String str3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Application)) {
            return false;
        }
        CrashlyticsReport.Session.Application application = (CrashlyticsReport.Session.Application) obj;
        if (this.f23994a.equals(application.e()) && this.f23995b.equals(application.h()) && ((str = this.f23996c) != null ? str.equals(application.d()) : application.d() == null) && ((organization = this.f23997d) != null ? organization.equals(application.g()) : application.g() == null) && ((str2 = this.f23998e) != null ? str2.equals(application.f()) : application.f() == null) && ((str3 = this.f23999f) != null ? str3.equals(application.b()) : application.b() == null)) {
            String str4 = this.f24000g;
            String c2 = application.c();
            if (str4 == null) {
                if (c2 == null) {
                    return true;
                }
            } else if (str4.equals(c2)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public String f() {
        return this.f23998e;
    }

    @Nullable
    public CrashlyticsReport.Session.Application.Organization g() {
        return this.f23997d;
    }

    @NonNull
    public String h() {
        return this.f23995b;
    }

    public int hashCode() {
        int hashCode = (((this.f23994a.hashCode() ^ 1000003) * 1000003) ^ this.f23995b.hashCode()) * 1000003;
        String str = this.f23996c;
        int i2 = 0;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        CrashlyticsReport.Session.Application.Organization organization = this.f23997d;
        int hashCode3 = (hashCode2 ^ (organization == null ? 0 : organization.hashCode())) * 1000003;
        String str2 = this.f23998e;
        int hashCode4 = (hashCode3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f23999f;
        int hashCode5 = (hashCode4 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f24000g;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode5 ^ i2;
    }

    /* access modifiers changed from: protected */
    public CrashlyticsReport.Session.Application.Builder i() {
        return new Builder(this);
    }

    public String toString() {
        return "Application{identifier=" + this.f23994a + ", version=" + this.f23995b + ", displayVersion=" + this.f23996c + ", organization=" + this.f23997d + ", installationUuid=" + this.f23998e + ", developmentPlatform=" + this.f23999f + ", developmentPlatformVersion=" + this.f24000g + "}";
    }
}
