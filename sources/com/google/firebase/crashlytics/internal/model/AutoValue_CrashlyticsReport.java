package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport extends CrashlyticsReport {

    /* renamed from: b  reason: collision with root package name */
    private final String f23907b;

    /* renamed from: c  reason: collision with root package name */
    private final String f23908c;

    /* renamed from: d  reason: collision with root package name */
    private final int f23909d;

    /* renamed from: e  reason: collision with root package name */
    private final String f23910e;

    /* renamed from: f  reason: collision with root package name */
    private final String f23911f;

    /* renamed from: g  reason: collision with root package name */
    private final String f23912g;

    /* renamed from: h  reason: collision with root package name */
    private final String f23913h;

    /* renamed from: i  reason: collision with root package name */
    private final String f23914i;

    /* renamed from: j  reason: collision with root package name */
    private final String f23915j;

    /* renamed from: k  reason: collision with root package name */
    private final CrashlyticsReport.Session f23916k;

    /* renamed from: l  reason: collision with root package name */
    private final CrashlyticsReport.FilesPayload f23917l;

    /* renamed from: m  reason: collision with root package name */
    private final CrashlyticsReport.ApplicationExitInfo f23918m;

    static final class Builder extends CrashlyticsReport.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f23919a;

        /* renamed from: b  reason: collision with root package name */
        private String f23920b;

        /* renamed from: c  reason: collision with root package name */
        private int f23921c;

        /* renamed from: d  reason: collision with root package name */
        private String f23922d;

        /* renamed from: e  reason: collision with root package name */
        private String f23923e;

        /* renamed from: f  reason: collision with root package name */
        private String f23924f;

        /* renamed from: g  reason: collision with root package name */
        private String f23925g;

        /* renamed from: h  reason: collision with root package name */
        private String f23926h;

        /* renamed from: i  reason: collision with root package name */
        private String f23927i;

        /* renamed from: j  reason: collision with root package name */
        private CrashlyticsReport.Session f23928j;

        /* renamed from: k  reason: collision with root package name */
        private CrashlyticsReport.FilesPayload f23929k;

        /* renamed from: l  reason: collision with root package name */
        private CrashlyticsReport.ApplicationExitInfo f23930l;

        /* renamed from: m  reason: collision with root package name */
        private byte f23931m;

        Builder() {
        }

        public CrashlyticsReport a() {
            if (this.f23931m == 1 && this.f23919a != null && this.f23920b != null && this.f23922d != null && this.f23926h != null && this.f23927i != null) {
                return new AutoValue_CrashlyticsReport(this.f23919a, this.f23920b, this.f23921c, this.f23922d, this.f23923e, this.f23924f, this.f23925g, this.f23926h, this.f23927i, this.f23928j, this.f23929k, this.f23930l);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f23919a == null) {
                sb.append(" sdkVersion");
            }
            if (this.f23920b == null) {
                sb.append(" gmpAppId");
            }
            if ((1 & this.f23931m) == 0) {
                sb.append(" platform");
            }
            if (this.f23922d == null) {
                sb.append(" installationUuid");
            }
            if (this.f23926h == null) {
                sb.append(" buildVersion");
            }
            if (this.f23927i == null) {
                sb.append(" displayVersion");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public CrashlyticsReport.Builder b(CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
            this.f23930l = applicationExitInfo;
            return this;
        }

        public CrashlyticsReport.Builder c(@Nullable String str) {
            this.f23925g = str;
            return this;
        }

        public CrashlyticsReport.Builder d(String str) {
            if (str != null) {
                this.f23926h = str;
                return this;
            }
            throw new NullPointerException("Null buildVersion");
        }

        public CrashlyticsReport.Builder e(String str) {
            if (str != null) {
                this.f23927i = str;
                return this;
            }
            throw new NullPointerException("Null displayVersion");
        }

        public CrashlyticsReport.Builder f(@Nullable String str) {
            this.f23924f = str;
            return this;
        }

        public CrashlyticsReport.Builder g(@Nullable String str) {
            this.f23923e = str;
            return this;
        }

        public CrashlyticsReport.Builder h(String str) {
            if (str != null) {
                this.f23920b = str;
                return this;
            }
            throw new NullPointerException("Null gmpAppId");
        }

        public CrashlyticsReport.Builder i(String str) {
            if (str != null) {
                this.f23922d = str;
                return this;
            }
            throw new NullPointerException("Null installationUuid");
        }

        public CrashlyticsReport.Builder j(CrashlyticsReport.FilesPayload filesPayload) {
            this.f23929k = filesPayload;
            return this;
        }

        public CrashlyticsReport.Builder k(int i2) {
            this.f23921c = i2;
            this.f23931m = (byte) (this.f23931m | 1);
            return this;
        }

        public CrashlyticsReport.Builder l(String str) {
            if (str != null) {
                this.f23919a = str;
                return this;
            }
            throw new NullPointerException("Null sdkVersion");
        }

        public CrashlyticsReport.Builder m(CrashlyticsReport.Session session) {
            this.f23928j = session;
            return this;
        }

        private Builder(CrashlyticsReport crashlyticsReport) {
            this.f23919a = crashlyticsReport.m();
            this.f23920b = crashlyticsReport.i();
            this.f23921c = crashlyticsReport.l();
            this.f23922d = crashlyticsReport.j();
            this.f23923e = crashlyticsReport.h();
            this.f23924f = crashlyticsReport.g();
            this.f23925g = crashlyticsReport.d();
            this.f23926h = crashlyticsReport.e();
            this.f23927i = crashlyticsReport.f();
            this.f23928j = crashlyticsReport.n();
            this.f23929k = crashlyticsReport.k();
            this.f23930l = crashlyticsReport.c();
            this.f23931m = 1;
        }
    }

    private AutoValue_CrashlyticsReport(String str, String str2, int i2, String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, String str7, String str8, @Nullable CrashlyticsReport.Session session, @Nullable CrashlyticsReport.FilesPayload filesPayload, @Nullable CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        this.f23907b = str;
        this.f23908c = str2;
        this.f23909d = i2;
        this.f23910e = str3;
        this.f23911f = str4;
        this.f23912g = str5;
        this.f23913h = str6;
        this.f23914i = str7;
        this.f23915j = str8;
        this.f23916k = session;
        this.f23917l = filesPayload;
        this.f23918m = applicationExitInfo;
    }

    @Nullable
    public CrashlyticsReport.ApplicationExitInfo c() {
        return this.f23918m;
    }

    @Nullable
    public String d() {
        return this.f23913h;
    }

    @NonNull
    public String e() {
        return this.f23914i;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        CrashlyticsReport.Session session;
        CrashlyticsReport.FilesPayload filesPayload;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport)) {
            return false;
        }
        CrashlyticsReport crashlyticsReport = (CrashlyticsReport) obj;
        if (this.f23907b.equals(crashlyticsReport.m()) && this.f23908c.equals(crashlyticsReport.i()) && this.f23909d == crashlyticsReport.l() && this.f23910e.equals(crashlyticsReport.j()) && ((str = this.f23911f) != null ? str.equals(crashlyticsReport.h()) : crashlyticsReport.h() == null) && ((str2 = this.f23912g) != null ? str2.equals(crashlyticsReport.g()) : crashlyticsReport.g() == null) && ((str3 = this.f23913h) != null ? str3.equals(crashlyticsReport.d()) : crashlyticsReport.d() == null) && this.f23914i.equals(crashlyticsReport.e()) && this.f23915j.equals(crashlyticsReport.f()) && ((session = this.f23916k) != null ? session.equals(crashlyticsReport.n()) : crashlyticsReport.n() == null) && ((filesPayload = this.f23917l) != null ? filesPayload.equals(crashlyticsReport.k()) : crashlyticsReport.k() == null)) {
            CrashlyticsReport.ApplicationExitInfo applicationExitInfo = this.f23918m;
            CrashlyticsReport.ApplicationExitInfo c2 = crashlyticsReport.c();
            if (applicationExitInfo == null) {
                if (c2 == null) {
                    return true;
                }
            } else if (applicationExitInfo.equals(c2)) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public String f() {
        return this.f23915j;
    }

    @Nullable
    public String g() {
        return this.f23912g;
    }

    @Nullable
    public String h() {
        return this.f23911f;
    }

    public int hashCode() {
        int hashCode = (((((((this.f23907b.hashCode() ^ 1000003) * 1000003) ^ this.f23908c.hashCode()) * 1000003) ^ this.f23909d) * 1000003) ^ this.f23910e.hashCode()) * 1000003;
        String str = this.f23911f;
        int i2 = 0;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f23912g;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f23913h;
        int hashCode4 = (((((hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003) ^ this.f23914i.hashCode()) * 1000003) ^ this.f23915j.hashCode()) * 1000003;
        CrashlyticsReport.Session session = this.f23916k;
        int hashCode5 = (hashCode4 ^ (session == null ? 0 : session.hashCode())) * 1000003;
        CrashlyticsReport.FilesPayload filesPayload = this.f23917l;
        int hashCode6 = (hashCode5 ^ (filesPayload == null ? 0 : filesPayload.hashCode())) * 1000003;
        CrashlyticsReport.ApplicationExitInfo applicationExitInfo = this.f23918m;
        if (applicationExitInfo != null) {
            i2 = applicationExitInfo.hashCode();
        }
        return hashCode6 ^ i2;
    }

    @NonNull
    public String i() {
        return this.f23908c;
    }

    @NonNull
    public String j() {
        return this.f23910e;
    }

    @Nullable
    public CrashlyticsReport.FilesPayload k() {
        return this.f23917l;
    }

    public int l() {
        return this.f23909d;
    }

    @NonNull
    public String m() {
        return this.f23907b;
    }

    @Nullable
    public CrashlyticsReport.Session n() {
        return this.f23916k;
    }

    /* access modifiers changed from: protected */
    public CrashlyticsReport.Builder p() {
        return new Builder(this);
    }

    public String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.f23907b + ", gmpAppId=" + this.f23908c + ", platform=" + this.f23909d + ", installationUuid=" + this.f23910e + ", firebaseInstallationId=" + this.f23911f + ", firebaseAuthenticationToken=" + this.f23912g + ", appQualitySessionId=" + this.f23913h + ", buildVersion=" + this.f23914i + ", displayVersion=" + this.f23915j + ", session=" + this.f23916k + ", ndkPayload=" + this.f23917l + ", appExitInfo=" + this.f23918m + "}";
    }
}
