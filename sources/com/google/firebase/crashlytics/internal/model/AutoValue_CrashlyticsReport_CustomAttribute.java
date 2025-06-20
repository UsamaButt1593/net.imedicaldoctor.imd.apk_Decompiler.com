package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

final class AutoValue_CrashlyticsReport_CustomAttribute extends CrashlyticsReport.CustomAttribute {

    /* renamed from: a  reason: collision with root package name */
    private final String f23957a;

    /* renamed from: b  reason: collision with root package name */
    private final String f23958b;

    static final class Builder extends CrashlyticsReport.CustomAttribute.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f23959a;

        /* renamed from: b  reason: collision with root package name */
        private String f23960b;

        Builder() {
        }

        public CrashlyticsReport.CustomAttribute a() {
            String str;
            String str2 = this.f23959a;
            if (str2 != null && (str = this.f23960b) != null) {
                return new AutoValue_CrashlyticsReport_CustomAttribute(str2, str);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f23959a == null) {
                sb.append(" key");
            }
            if (this.f23960b == null) {
                sb.append(" value");
            }
            throw new IllegalStateException("Missing required properties:" + sb);
        }

        public CrashlyticsReport.CustomAttribute.Builder b(String str) {
            if (str != null) {
                this.f23959a = str;
                return this;
            }
            throw new NullPointerException("Null key");
        }

        public CrashlyticsReport.CustomAttribute.Builder c(String str) {
            if (str != null) {
                this.f23960b = str;
                return this;
            }
            throw new NullPointerException("Null value");
        }
    }

    private AutoValue_CrashlyticsReport_CustomAttribute(String str, String str2) {
        this.f23957a = str;
        this.f23958b = str2;
    }

    @NonNull
    public String b() {
        return this.f23957a;
    }

    @NonNull
    public String c() {
        return this.f23958b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.CustomAttribute)) {
            return false;
        }
        CrashlyticsReport.CustomAttribute customAttribute = (CrashlyticsReport.CustomAttribute) obj;
        return this.f23957a.equals(customAttribute.b()) && this.f23958b.equals(customAttribute.c());
    }

    public int hashCode() {
        return ((this.f23957a.hashCode() ^ 1000003) * 1000003) ^ this.f23958b.hashCode();
    }

    public String toString() {
        return "CustomAttribute{key=" + this.f23957a + ", value=" + this.f23958b + "}";
    }
}
