package com.google.android.datatransport;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ProductData {
    public static ProductData b(@Nullable Integer num) {
        return new AutoValue_ProductData(num);
    }

    @Nullable
    public abstract Integer a();
}
