package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Arrays;

final class AutoValue_CrashlyticsReport_FilesPayload_File extends CrashlyticsReport.FilesPayload.File {

    /* renamed from: a  reason: collision with root package name */
    private final String f23965a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f23966b;

    static final class Builder extends CrashlyticsReport.FilesPayload.File.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f23967a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f23968b;

        Builder() {
        }

        public CrashlyticsReport.FilesPayload.File a() {
            byte[] bArr;
            String str = this.f23967a;
            if (str != null && (bArr = this.f23968b) != null) {
                return new AutoValue_CrashlyticsReport_FilesPayload_File(str, bArr);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f23967a == null) {
                sb.append(" filename");
            }
            if (this.f23968b == null) {
                sb.append(" contents");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public CrashlyticsReport.FilesPayload.File.Builder b(byte[] bArr) {
            if (bArr != null) {
                this.f23968b = bArr;
                return this;
            }
            throw new NullPointerException("Null contents");
        }

        public CrashlyticsReport.FilesPayload.File.Builder c(String str) {
            if (str != null) {
                this.f23967a = str;
                return this;
            }
            throw new NullPointerException("Null filename");
        }
    }

    private AutoValue_CrashlyticsReport_FilesPayload_File(String str, byte[] bArr) {
        this.f23965a = str;
        this.f23966b = bArr;
    }

    @NonNull
    public byte[] b() {
        return this.f23966b;
    }

    @NonNull
    public String c() {
        return this.f23965a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.FilesPayload.File)) {
            return false;
        }
        CrashlyticsReport.FilesPayload.File file = (CrashlyticsReport.FilesPayload.File) obj;
        if (this.f23965a.equals(file.c())) {
            if (Arrays.equals(this.f23966b, file instanceof AutoValue_CrashlyticsReport_FilesPayload_File ? ((AutoValue_CrashlyticsReport_FilesPayload_File) file).f23966b : file.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f23965a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f23966b);
    }

    public String toString() {
        return "File{filename=" + this.f23965a + ", contents=" + Arrays.toString(this.f23966b) + "}";
    }
}
