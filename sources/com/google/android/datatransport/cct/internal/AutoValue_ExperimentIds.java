package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.ExperimentIds;
import java.util.Arrays;

final class AutoValue_ExperimentIds extends ExperimentIds {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f19328a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f19329b;

    static final class Builder extends ExperimentIds.Builder {

        /* renamed from: a  reason: collision with root package name */
        private byte[] f19330a;

        /* renamed from: b  reason: collision with root package name */
        private byte[] f19331b;

        Builder() {
        }

        public ExperimentIds a() {
            return new AutoValue_ExperimentIds(this.f19330a, this.f19331b);
        }

        public ExperimentIds.Builder b(@Nullable byte[] bArr) {
            this.f19330a = bArr;
            return this;
        }

        public ExperimentIds.Builder c(@Nullable byte[] bArr) {
            this.f19331b = bArr;
            return this;
        }
    }

    private AutoValue_ExperimentIds(@Nullable byte[] bArr, @Nullable byte[] bArr2) {
        this.f19328a = bArr;
        this.f19329b = bArr2;
    }

    @Nullable
    public byte[] b() {
        return this.f19328a;
    }

    @Nullable
    public byte[] c() {
        return this.f19329b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExperimentIds)) {
            return false;
        }
        ExperimentIds experimentIds = (ExperimentIds) obj;
        boolean z = experimentIds instanceof AutoValue_ExperimentIds;
        if (Arrays.equals(this.f19328a, z ? ((AutoValue_ExperimentIds) experimentIds).f19328a : experimentIds.b())) {
            if (Arrays.equals(this.f19329b, z ? ((AutoValue_ExperimentIds) experimentIds).f19329b : experimentIds.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((Arrays.hashCode(this.f19328a) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f19329b);
    }

    public String toString() {
        return "ExperimentIds{clearBlob=" + Arrays.toString(this.f19328a) + ", encryptedBlob=" + Arrays.toString(this.f19329b) + "}";
    }
}
