package com.google.android.gms.common.api.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.Objects;

final class zabs {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ApiKey<?> f20109a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Feature f20110b;

    /* synthetic */ zabs(ApiKey apiKey, Feature feature, zabr zabr) {
        this.f20109a = apiKey;
        this.f20110b = feature;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj != null && (obj instanceof zabs)) {
            zabs zabs = (zabs) obj;
            return Objects.b(this.f20109a, zabs.f20109a) && Objects.b(this.f20110b, zabs.f20110b);
        }
    }

    public final int hashCode() {
        return Objects.c(this.f20109a, this.f20110b);
    }

    public final String toString() {
        return Objects.d(this).a("key", this.f20109a).a("feature", this.f20110b).toString();
    }
}
