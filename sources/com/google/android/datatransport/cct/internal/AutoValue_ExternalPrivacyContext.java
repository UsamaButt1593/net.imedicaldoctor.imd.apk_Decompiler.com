package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.ExternalPrivacyContext;

final class AutoValue_ExternalPrivacyContext extends ExternalPrivacyContext {

    /* renamed from: a  reason: collision with root package name */
    private final ExternalPRequestContext f19334a;

    static final class Builder extends ExternalPrivacyContext.Builder {

        /* renamed from: a  reason: collision with root package name */
        private ExternalPRequestContext f19335a;

        Builder() {
        }

        public ExternalPrivacyContext a() {
            return new AutoValue_ExternalPrivacyContext(this.f19335a);
        }

        public ExternalPrivacyContext.Builder b(@Nullable ExternalPRequestContext externalPRequestContext) {
            this.f19335a = externalPRequestContext;
            return this;
        }
    }

    private AutoValue_ExternalPrivacyContext(@Nullable ExternalPRequestContext externalPRequestContext) {
        this.f19334a = externalPRequestContext;
    }

    @Nullable
    public ExternalPRequestContext b() {
        return this.f19334a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExternalPrivacyContext)) {
            return false;
        }
        ExternalPRequestContext externalPRequestContext = this.f19334a;
        ExternalPRequestContext b2 = ((ExternalPrivacyContext) obj).b();
        return externalPRequestContext == null ? b2 == null : externalPRequestContext.equals(b2);
    }

    public int hashCode() {
        ExternalPRequestContext externalPRequestContext = this.f19334a;
        return (externalPRequestContext == null ? 0 : externalPRequestContext.hashCode()) ^ 1000003;
    }

    public String toString() {
        return "ExternalPrivacyContext{prequest=" + this.f19334a + "}";
    }
}
