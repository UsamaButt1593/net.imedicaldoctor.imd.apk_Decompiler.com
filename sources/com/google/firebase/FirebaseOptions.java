package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Strings;

public final class FirebaseOptions {

    /* renamed from: h  reason: collision with root package name */
    private static final String f23321h = "google_api_key";

    /* renamed from: i  reason: collision with root package name */
    private static final String f23322i = "google_app_id";

    /* renamed from: j  reason: collision with root package name */
    private static final String f23323j = "firebase_database_url";

    /* renamed from: k  reason: collision with root package name */
    private static final String f23324k = "ga_trackingId";

    /* renamed from: l  reason: collision with root package name */
    private static final String f23325l = "gcm_defaultSenderId";

    /* renamed from: m  reason: collision with root package name */
    private static final String f23326m = "google_storage_bucket";

    /* renamed from: n  reason: collision with root package name */
    private static final String f23327n = "project_id";
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f23328a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f23329b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final String f23330c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final String f23331d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final String f23332e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final String f23333f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final String f23334g;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f23335a;

        /* renamed from: b  reason: collision with root package name */
        private String f23336b;

        /* renamed from: c  reason: collision with root package name */
        private String f23337c;

        /* renamed from: d  reason: collision with root package name */
        private String f23338d;

        /* renamed from: e  reason: collision with root package name */
        private String f23339e;

        /* renamed from: f  reason: collision with root package name */
        private String f23340f;

        /* renamed from: g  reason: collision with root package name */
        private String f23341g;

        public Builder() {
        }

        @NonNull
        public FirebaseOptions a() {
            return new FirebaseOptions(this.f23336b, this.f23335a, this.f23337c, this.f23338d, this.f23339e, this.f23340f, this.f23341g);
        }

        @NonNull
        public Builder b(@NonNull String str) {
            this.f23335a = Preconditions.m(str, "ApiKey must be set.");
            return this;
        }

        @NonNull
        public Builder c(@NonNull String str) {
            this.f23336b = Preconditions.m(str, "ApplicationId must be set.");
            return this;
        }

        @NonNull
        public Builder d(@Nullable String str) {
            this.f23337c = str;
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder e(@Nullable String str) {
            this.f23338d = str;
            return this;
        }

        @NonNull
        public Builder f(@Nullable String str) {
            this.f23339e = str;
            return this;
        }

        @NonNull
        public Builder g(@Nullable String str) {
            this.f23341g = str;
            return this;
        }

        @NonNull
        public Builder h(@Nullable String str) {
            this.f23340f = str;
            return this;
        }

        public Builder(@NonNull FirebaseOptions firebaseOptions) {
            this.f23336b = firebaseOptions.f23329b;
            this.f23335a = firebaseOptions.f23328a;
            this.f23337c = firebaseOptions.f23330c;
            this.f23338d = firebaseOptions.f23331d;
            this.f23339e = firebaseOptions.f23332e;
            this.f23340f = firebaseOptions.f23333f;
            this.f23341g = firebaseOptions.f23334g;
        }
    }

    private FirebaseOptions(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        Preconditions.y(!Strings.b(str), "ApplicationId must be set.");
        this.f23329b = str;
        this.f23328a = str2;
        this.f23330c = str3;
        this.f23331d = str4;
        this.f23332e = str5;
        this.f23333f = str6;
        this.f23334g = str7;
    }

    @Nullable
    public static FirebaseOptions h(@NonNull Context context) {
        StringResourceValueReader stringResourceValueReader = new StringResourceValueReader(context);
        String a2 = stringResourceValueReader.a(f23322i);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        return new FirebaseOptions(a2, stringResourceValueReader.a(f23321h), stringResourceValueReader.a(f23323j), stringResourceValueReader.a(f23324k), stringResourceValueReader.a(f23325l), stringResourceValueReader.a(f23326m), stringResourceValueReader.a(f23327n));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseOptions)) {
            return false;
        }
        FirebaseOptions firebaseOptions = (FirebaseOptions) obj;
        return Objects.b(this.f23329b, firebaseOptions.f23329b) && Objects.b(this.f23328a, firebaseOptions.f23328a) && Objects.b(this.f23330c, firebaseOptions.f23330c) && Objects.b(this.f23331d, firebaseOptions.f23331d) && Objects.b(this.f23332e, firebaseOptions.f23332e) && Objects.b(this.f23333f, firebaseOptions.f23333f) && Objects.b(this.f23334g, firebaseOptions.f23334g);
    }

    public int hashCode() {
        return Objects.c(this.f23329b, this.f23328a, this.f23330c, this.f23331d, this.f23332e, this.f23333f, this.f23334g);
    }

    @NonNull
    public String i() {
        return this.f23328a;
    }

    @NonNull
    public String j() {
        return this.f23329b;
    }

    @Nullable
    public String k() {
        return this.f23330c;
    }

    @KeepForSdk
    @Nullable
    public String l() {
        return this.f23331d;
    }

    @Nullable
    public String m() {
        return this.f23332e;
    }

    @Nullable
    public String n() {
        return this.f23334g;
    }

    @Nullable
    public String o() {
        return this.f23333f;
    }

    public String toString() {
        return Objects.d(this).a("applicationId", this.f23329b).a("apiKey", this.f23328a).a("databaseUrl", this.f23330c).a("gcmSenderId", this.f23332e).a("storageBucket", this.f23333f).a("projectId", this.f23334g).toString();
    }
}
