package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.collection.ArraySet;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@KeepForSdk
@VisibleForTesting
public final class ClientSettings {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Account f20220a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Scope> f20221b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Scope> f20222c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Api<?>, zab> f20223d;

    /* renamed from: e  reason: collision with root package name */
    private final int f20224e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final View f20225f;

    /* renamed from: g  reason: collision with root package name */
    private final String f20226g;

    /* renamed from: h  reason: collision with root package name */
    private final String f20227h;

    /* renamed from: i  reason: collision with root package name */
    private final SignInOptions f20228i;

    /* renamed from: j  reason: collision with root package name */
    private Integer f20229j;

    @KeepForSdk
    public static final class Builder {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private Account f20230a;

        /* renamed from: b  reason: collision with root package name */
        private ArraySet<Scope> f20231b;

        /* renamed from: c  reason: collision with root package name */
        private String f20232c;

        /* renamed from: d  reason: collision with root package name */
        private String f20233d;

        /* renamed from: e  reason: collision with root package name */
        private SignInOptions f20234e = SignInOptions.c3;

        @NonNull
        @KeepForSdk
        public ClientSettings a() {
            return new ClientSettings(this.f20230a, this.f20231b, (Map<Api<?>, zab>) null, 0, (View) null, this.f20232c, this.f20233d, this.f20234e, false);
        }

        @NonNull
        @KeepForSdk
        public Builder b(@NonNull String str) {
            this.f20232c = str;
            return this;
        }

        @NonNull
        public final Builder c(@NonNull Collection<Scope> collection) {
            if (this.f20231b == null) {
                this.f20231b = new ArraySet<>();
            }
            this.f20231b.addAll(collection);
            return this;
        }

        @NonNull
        public final Builder d(@Nullable Account account) {
            this.f20230a = account;
            return this;
        }

        @NonNull
        public final Builder e(@NonNull String str) {
            this.f20233d = str;
            return this;
        }
    }

    @KeepForSdk
    public ClientSettings(@NonNull Account account, @NonNull Set<Scope> set, @NonNull Map<Api<?>, zab> map, int i2, @Nullable View view, @NonNull String str, @NonNull String str2, @Nullable SignInOptions signInOptions) {
        this(account, set, map, i2, view, str, str2, signInOptions, false);
    }

    @NonNull
    @KeepForSdk
    public static ClientSettings a(@NonNull Context context) {
        return new GoogleApiClient.Builder(context).p();
    }

    @KeepForSdk
    @androidx.annotation.Nullable
    public Account b() {
        return this.f20220a;
    }

    @KeepForSdk
    @Deprecated
    @androidx.annotation.Nullable
    public String c() {
        Account account = this.f20220a;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    @NonNull
    @KeepForSdk
    public Account d() {
        Account account = this.f20220a;
        return account != null ? account : new Account("<<default account>>", AccountType.f20215a);
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> e() {
        return this.f20222c;
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> f(@NonNull Api<?> api) {
        zab zab = this.f20223d.get(api);
        if (zab == null || zab.f20282a.isEmpty()) {
            return this.f20221b;
        }
        HashSet hashSet = new HashSet(this.f20221b);
        hashSet.addAll(zab.f20282a);
        return hashSet;
    }

    @KeepForSdk
    public int g() {
        return this.f20224e;
    }

    @NonNull
    @KeepForSdk
    public String h() {
        return this.f20226g;
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> i() {
        return this.f20221b;
    }

    @KeepForSdk
    @androidx.annotation.Nullable
    public View j() {
        return this.f20225f;
    }

    @NonNull
    public final SignInOptions k() {
        return this.f20228i;
    }

    @androidx.annotation.Nullable
    public final Integer l() {
        return this.f20229j;
    }

    @androidx.annotation.Nullable
    public final String m() {
        return this.f20227h;
    }

    @NonNull
    public final Map<Api<?>, zab> n() {
        return this.f20223d;
    }

    public final void o(@NonNull Integer num) {
        this.f20229j = num;
    }

    public ClientSettings(@Nullable Account account, @NonNull Set<Scope> set, @NonNull Map<Api<?>, zab> map, int i2, @Nullable View view, @NonNull String str, @NonNull String str2, @Nullable SignInOptions signInOptions, boolean z) {
        this.f20220a = account;
        Set<Scope> emptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f20221b = emptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.f20223d = map;
        this.f20225f = view;
        this.f20224e = i2;
        this.f20226g = str;
        this.f20227h = str2;
        this.f20228i = signInOptions == null ? SignInOptions.c3 : signInOptions;
        HashSet hashSet = new HashSet(emptySet);
        for (zab zab : map.values()) {
            hashSet.addAll(zab.f20282a);
        }
        this.f20222c = Collections.unmodifiableSet(hashSet);
    }
}
