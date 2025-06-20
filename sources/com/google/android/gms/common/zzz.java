package com.google.android.gms.common;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.common.zzag;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.List;

final class zzz {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f20439a = null;

    /* renamed from: b  reason: collision with root package name */
    private long f20440b = -1;

    /* renamed from: c  reason: collision with root package name */
    private zzag f20441c = zzag.zzl();

    /* renamed from: d  reason: collision with root package name */
    private zzag f20442d = zzag.zzl();

    zzz() {
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public final zzz a(long j2) {
        this.f20440b = j2;
        return this;
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public final zzz b(List list) {
        Preconditions.r(list);
        this.f20442d = zzag.zzk(list);
        return this;
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public final zzz c(List list) {
        Preconditions.r(list);
        this.f20441c = zzag.zzk(list);
        return this;
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public final zzz d(String str) {
        this.f20439a = str;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final zzab e() {
        if (this.f20439a == null) {
            throw new IllegalStateException("packageName must be defined");
        } else if (this.f20440b < 0) {
            throw new IllegalStateException("minimumStampedVersionNumber must be greater than or equal to 0");
        } else if (!this.f20441c.isEmpty() || !this.f20442d.isEmpty()) {
            return new zzab(this.f20439a, this.f20440b, this.f20441c, this.f20442d, (zzaa) null);
        } else {
            throw new IllegalStateException("Either orderedTestCerts or orderedProdCerts must have at least one cert");
        }
    }
}
