package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.AutoValue_AndroidClientInfo;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class AndroidClientInfo {

    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract AndroidClientInfo a();

        @NonNull
        public abstract Builder b(@Nullable String str);

        @NonNull
        public abstract Builder c(@Nullable String str);

        @NonNull
        public abstract Builder d(@Nullable String str);

        @NonNull
        public abstract Builder e(@Nullable String str);

        @NonNull
        public abstract Builder f(@Nullable String str);

        @NonNull
        public abstract Builder g(@Nullable String str);

        @NonNull
        public abstract Builder h(@Nullable String str);

        @NonNull
        public abstract Builder i(@Nullable String str);

        @NonNull
        public abstract Builder j(@Nullable String str);

        @NonNull
        public abstract Builder k(@Nullable String str);

        @NonNull
        public abstract Builder l(@Nullable String str);

        @NonNull
        public abstract Builder m(@Nullable Integer num);
    }

    @NonNull
    public static Builder a() {
        return new AutoValue_AndroidClientInfo.Builder();
    }

    @Nullable
    public abstract String b();

    @Nullable
    public abstract String c();

    @Nullable
    public abstract String d();

    @Nullable
    public abstract String e();

    @Nullable
    public abstract String f();

    @Nullable
    public abstract String g();

    @Nullable
    public abstract String h();

    @Nullable
    public abstract String i();

    @Nullable
    public abstract String j();

    @Nullable
    public abstract String k();

    @Nullable
    public abstract String l();

    @Nullable
    public abstract Integer m();
}
