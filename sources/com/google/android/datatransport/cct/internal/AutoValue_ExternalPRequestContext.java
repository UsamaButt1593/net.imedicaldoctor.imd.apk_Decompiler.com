package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.ExternalPRequestContext;

final class AutoValue_ExternalPRequestContext extends ExternalPRequestContext {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f19332a;

    static final class Builder extends ExternalPRequestContext.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Integer f19333a;

        Builder() {
        }

        public ExternalPRequestContext a() {
            return new AutoValue_ExternalPRequestContext(this.f19333a);
        }

        public ExternalPRequestContext.Builder b(@Nullable Integer num) {
            this.f19333a = num;
            return this;
        }
    }

    private AutoValue_ExternalPRequestContext(@Nullable Integer num) {
        this.f19332a = num;
    }

    @Nullable
    public Integer b() {
        return this.f19332a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExternalPRequestContext)) {
            return false;
        }
        Integer num = this.f19332a;
        Integer b2 = ((ExternalPRequestContext) obj).b();
        return num == null ? b2 == null : num.equals(b2);
    }

    public int hashCode() {
        Integer num = this.f19332a;
        return (num == null ? 0 : num.hashCode()) ^ 1000003;
    }

    public String toString() {
        return "ExternalPRequestContext{originAssociatedProductId=" + this.f19332a + "}";
    }
}
