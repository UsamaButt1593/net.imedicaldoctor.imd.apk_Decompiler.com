package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.List;

final class AutoValue_CrashlyticsReport_FilesPayload extends CrashlyticsReport.FilesPayload {

    /* renamed from: a  reason: collision with root package name */
    private final List<CrashlyticsReport.FilesPayload.File> f23961a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23962b;

    static final class Builder extends CrashlyticsReport.FilesPayload.Builder {

        /* renamed from: a  reason: collision with root package name */
        private List<CrashlyticsReport.FilesPayload.File> f23963a;

        /* renamed from: b  reason: collision with root package name */
        private String f23964b;

        Builder() {
        }

        public CrashlyticsReport.FilesPayload a() {
            List<CrashlyticsReport.FilesPayload.File> list = this.f23963a;
            if (list != null) {
                return new AutoValue_CrashlyticsReport_FilesPayload(list, this.f23964b);
            }
            throw new IllegalStateException("Missing required properties:" + " files");
        }

        public CrashlyticsReport.FilesPayload.Builder b(List<CrashlyticsReport.FilesPayload.File> list) {
            if (list != null) {
                this.f23963a = list;
                return this;
            }
            throw new NullPointerException("Null files");
        }

        public CrashlyticsReport.FilesPayload.Builder c(String str) {
            this.f23964b = str;
            return this;
        }

        private Builder(CrashlyticsReport.FilesPayload filesPayload) {
            this.f23963a = filesPayload.b();
            this.f23964b = filesPayload.c();
        }
    }

    private AutoValue_CrashlyticsReport_FilesPayload(List<CrashlyticsReport.FilesPayload.File> list, @Nullable String str) {
        this.f23961a = list;
        this.f23962b = str;
    }

    @NonNull
    public List<CrashlyticsReport.FilesPayload.File> b() {
        return this.f23961a;
    }

    @Nullable
    public String c() {
        return this.f23962b;
    }

    /* access modifiers changed from: package-private */
    public CrashlyticsReport.FilesPayload.Builder d() {
        return new Builder(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.FilesPayload)) {
            return false;
        }
        CrashlyticsReport.FilesPayload filesPayload = (CrashlyticsReport.FilesPayload) obj;
        if (this.f23961a.equals(filesPayload.b())) {
            String str = this.f23962b;
            String c2 = filesPayload.c();
            if (str == null) {
                if (c2 == null) {
                    return true;
                }
            } else if (str.equals(c2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.f23961a.hashCode() ^ 1000003) * 1000003;
        String str = this.f23962b;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "FilesPayload{files=" + this.f23961a + ", orgId=" + this.f23962b + "}";
    }
}
