package com.google.android.datatransport;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.AutoValue_EventContext;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class EventContext {

    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract EventContext a();

        @NonNull
        public abstract Builder b(byte[] bArr);

        @NonNull
        public abstract Builder c(byte[] bArr);

        @NonNull
        public abstract Builder d(String str);
    }

    public static Builder a() {
        return new AutoValue_EventContext.Builder();
    }

    @Nullable
    public abstract byte[] b();

    @Nullable
    public abstract byte[] c();

    @Nullable
    public abstract String d();
}
