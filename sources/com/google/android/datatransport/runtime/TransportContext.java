package com.google.android.datatransport.runtime;

import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class TransportContext {

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract TransportContext a();

        public abstract Builder b(String str);

        public abstract Builder c(@Nullable byte[] bArr);

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public abstract Builder d(Priority priority);
    }

    public static Builder a() {
        return new AutoValue_TransportContext.Builder().d(Priority.DEFAULT);
    }

    public abstract String b();

    @Nullable
    public abstract byte[] c();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract Priority d();

    public boolean e() {
        return c() != null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public TransportContext f(Priority priority) {
        return a().b(b()).d(priority).c(c()).a();
    }

    public final String toString() {
        return String.format("TransportContext(%s, %s, %s)", new Object[]{b(), d(), c() == null ? "" : Base64.encodeToString(c(), 2)});
    }
}
