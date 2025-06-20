package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch extends CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch {

    /* renamed from: a  reason: collision with root package name */
    private final String f23951a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23952b;

    /* renamed from: c  reason: collision with root package name */
    private final String f23953c;

    static final class Builder extends CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f23954a;

        /* renamed from: b  reason: collision with root package name */
        private String f23955b;

        /* renamed from: c  reason: collision with root package name */
        private String f23956c;

        Builder() {
        }

        public CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch a() {
            String str;
            String str2;
            String str3 = this.f23954a;
            if (str3 != null && (str = this.f23955b) != null && (str2 = this.f23956c) != null) {
                return new AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch(str3, str, str2);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f23954a == null) {
                sb.append(" arch");
            }
            if (this.f23955b == null) {
                sb.append(" libraryName");
            }
            if (this.f23956c == null) {
                sb.append(" buildId");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.Builder b(String str) {
            if (str != null) {
                this.f23954a = str;
                return this;
            }
            throw new NullPointerException("Null arch");
        }

        public CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.Builder c(String str) {
            if (str != null) {
                this.f23956c = str;
                return this;
            }
            throw new NullPointerException("Null buildId");
        }

        public CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.Builder d(String str) {
            if (str != null) {
                this.f23955b = str;
                return this;
            }
            throw new NullPointerException("Null libraryName");
        }
    }

    private AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch(String str, String str2, String str3) {
        this.f23951a = str;
        this.f23952b = str2;
        this.f23953c = str3;
    }

    @NonNull
    public String b() {
        return this.f23951a;
    }

    @NonNull
    public String c() {
        return this.f23953c;
    }

    @NonNull
    public String d() {
        return this.f23952b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch)) {
            return false;
        }
        CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch buildIdMappingForArch = (CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch) obj;
        return this.f23951a.equals(buildIdMappingForArch.b()) && this.f23952b.equals(buildIdMappingForArch.d()) && this.f23953c.equals(buildIdMappingForArch.c());
    }

    public int hashCode() {
        return ((((this.f23951a.hashCode() ^ 1000003) * 1000003) ^ this.f23952b.hashCode()) * 1000003) ^ this.f23953c.hashCode();
    }

    public String toString() {
        return "BuildIdMappingForArch{arch=" + this.f23951a + ", libraryName=" + this.f23952b + ", buildId=" + this.f23953c + "}";
    }
}
