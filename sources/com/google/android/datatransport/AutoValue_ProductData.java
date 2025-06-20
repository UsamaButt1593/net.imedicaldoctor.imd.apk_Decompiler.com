package com.google.android.datatransport;

import androidx.annotation.Nullable;

final class AutoValue_ProductData extends ProductData {

    /* renamed from: a  reason: collision with root package name */
    private final Integer f19202a;

    AutoValue_ProductData(@Nullable Integer num) {
        this.f19202a = num;
    }

    @Nullable
    public Integer a() {
        return this.f19202a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProductData)) {
            return false;
        }
        Integer num = this.f19202a;
        Integer a2 = ((ProductData) obj).a();
        return num == null ? a2 == null : num.equals(a2);
    }

    public int hashCode() {
        Integer num = this.f19202a;
        return (num == null ? 0 : num.hashCode()) ^ 1000003;
    }

    public String toString() {
        return "ProductData{productId=" + this.f19202a + "}";
    }
}
