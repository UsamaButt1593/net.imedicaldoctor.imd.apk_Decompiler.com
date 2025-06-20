package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.AutoValue_ClientInfo;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ClientInfo {

    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract ClientInfo a();

        @NonNull
        public abstract Builder b(@Nullable AndroidClientInfo androidClientInfo);

        @NonNull
        public abstract Builder c(@Nullable ClientType clientType);
    }

    public enum ClientType {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);
        
        private final int s;

        private ClientType(int i2) {
            this.s = i2;
        }
    }

    @NonNull
    public static Builder a() {
        return new AutoValue_ClientInfo.Builder();
    }

    @Nullable
    public abstract AndroidClientInfo b();

    @Nullable
    public abstract ClientType c();
}
