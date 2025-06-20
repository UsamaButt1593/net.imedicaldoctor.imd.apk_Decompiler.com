package com.google.firebase.crashlytics;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

public class CustomKeysAndValues {

    /* renamed from: a  reason: collision with root package name */
    final Map<String, String> f23479a;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public Map<String, String> f23480a = new HashMap();

        @NonNull
        public CustomKeysAndValues b() {
            return new CustomKeysAndValues(this);
        }

        @NonNull
        public Builder c(@NonNull String str, boolean z) {
            this.f23480a.put(str, Boolean.toString(z));
            return this;
        }

        @NonNull
        public Builder d(@NonNull String str, double d2) {
            this.f23480a.put(str, Double.toString(d2));
            return this;
        }

        @NonNull
        public Builder e(@NonNull String str, float f2) {
            this.f23480a.put(str, Float.toString(f2));
            return this;
        }

        @NonNull
        public Builder f(@NonNull String str, int i2) {
            this.f23480a.put(str, Integer.toString(i2));
            return this;
        }

        @NonNull
        public Builder g(@NonNull String str, long j2) {
            this.f23480a.put(str, Long.toString(j2));
            return this;
        }

        @NonNull
        public Builder h(@NonNull String str, @NonNull String str2) {
            this.f23480a.put(str, str2);
            return this;
        }
    }

    CustomKeysAndValues(@NonNull Builder builder) {
        this.f23479a = builder.f23480a;
    }
}
