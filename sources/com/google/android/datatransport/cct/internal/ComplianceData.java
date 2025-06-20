package com.google.android.datatransport.cct.internal;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.AutoValue_ComplianceData;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ComplianceData {

    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract ComplianceData a();

        @NonNull
        public abstract Builder b(@Nullable ExternalPrivacyContext externalPrivacyContext);

        @NonNull
        public abstract Builder c(@Nullable ProductIdOrigin productIdOrigin);
    }

    public enum ProductIdOrigin {
        NOT_SET(0),
        EVENT_OVERRIDE(5);
        
        private static final SparseArray<ProductIdOrigin> Z = null;
        private final int s;

        static {
            ProductIdOrigin productIdOrigin;
            ProductIdOrigin productIdOrigin2;
            SparseArray<ProductIdOrigin> sparseArray = new SparseArray<>();
            Z = sparseArray;
            sparseArray.put(0, productIdOrigin);
            sparseArray.put(5, productIdOrigin2);
        }

        private ProductIdOrigin(int i2) {
            this.s = i2;
        }

        @Nullable
        public static ProductIdOrigin a(int i2) {
            return Z.get(i2);
        }

        public int b() {
            return this.s;
        }
    }

    @NonNull
    public static Builder a() {
        return new AutoValue_ComplianceData.Builder();
    }

    @Nullable
    public abstract ExternalPrivacyContext b();

    @Nullable
    public abstract ProductIdOrigin c();
}
