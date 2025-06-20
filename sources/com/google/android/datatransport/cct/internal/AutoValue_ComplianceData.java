package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.ComplianceData;

final class AutoValue_ComplianceData extends ComplianceData {

    /* renamed from: a  reason: collision with root package name */
    private final ExternalPrivacyContext f19324a;

    /* renamed from: b  reason: collision with root package name */
    private final ComplianceData.ProductIdOrigin f19325b;

    static final class Builder extends ComplianceData.Builder {

        /* renamed from: a  reason: collision with root package name */
        private ExternalPrivacyContext f19326a;

        /* renamed from: b  reason: collision with root package name */
        private ComplianceData.ProductIdOrigin f19327b;

        Builder() {
        }

        public ComplianceData a() {
            return new AutoValue_ComplianceData(this.f19326a, this.f19327b);
        }

        public ComplianceData.Builder b(@Nullable ExternalPrivacyContext externalPrivacyContext) {
            this.f19326a = externalPrivacyContext;
            return this;
        }

        public ComplianceData.Builder c(@Nullable ComplianceData.ProductIdOrigin productIdOrigin) {
            this.f19327b = productIdOrigin;
            return this;
        }
    }

    private AutoValue_ComplianceData(@Nullable ExternalPrivacyContext externalPrivacyContext, @Nullable ComplianceData.ProductIdOrigin productIdOrigin) {
        this.f19324a = externalPrivacyContext;
        this.f19325b = productIdOrigin;
    }

    @Nullable
    public ExternalPrivacyContext b() {
        return this.f19324a;
    }

    @Nullable
    public ComplianceData.ProductIdOrigin c() {
        return this.f19325b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ComplianceData)) {
            return false;
        }
        ComplianceData complianceData = (ComplianceData) obj;
        ExternalPrivacyContext externalPrivacyContext = this.f19324a;
        if (externalPrivacyContext != null ? externalPrivacyContext.equals(complianceData.b()) : complianceData.b() == null) {
            ComplianceData.ProductIdOrigin productIdOrigin = this.f19325b;
            ComplianceData.ProductIdOrigin c2 = complianceData.c();
            if (productIdOrigin == null) {
                if (c2 == null) {
                    return true;
                }
            } else if (productIdOrigin.equals(c2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        ExternalPrivacyContext externalPrivacyContext = this.f19324a;
        int i2 = 0;
        int hashCode = ((externalPrivacyContext == null ? 0 : externalPrivacyContext.hashCode()) ^ 1000003) * 1000003;
        ComplianceData.ProductIdOrigin productIdOrigin = this.f19325b;
        if (productIdOrigin != null) {
            i2 = productIdOrigin.hashCode();
        }
        return hashCode ^ i2;
    }

    public String toString() {
        return "ComplianceData{privacyContext=" + this.f19324a + ", productIdOrigin=" + this.f19325b + "}";
    }
}
