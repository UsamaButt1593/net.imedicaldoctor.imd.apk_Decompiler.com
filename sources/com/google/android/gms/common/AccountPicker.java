package com.google.android.gms.common;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.ArrayList;
import java.util.List;

public final class AccountPicker {

    public static class AccountChooserOptions {
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public Account f19844a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f19845b;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public ArrayList f19846c;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public ArrayList f19847d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public boolean f19848e;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public String f19849f;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        public Bundle f19850g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public boolean f19851h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public int f19852i;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        public String f19853j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public boolean f19854k;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: l  reason: collision with root package name */
        public zza f19855l;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: m  reason: collision with root package name */
        public String f19856m;
        /* access modifiers changed from: private */

        /* renamed from: n  reason: collision with root package name */
        public boolean f19857n;
        /* access modifiers changed from: private */
        public boolean o;

        public static class Builder {
            @Nullable

            /* renamed from: a  reason: collision with root package name */
            private Account f19858a;
            @Nullable

            /* renamed from: b  reason: collision with root package name */
            private ArrayList f19859b;
            @Nullable

            /* renamed from: c  reason: collision with root package name */
            private ArrayList f19860c;

            /* renamed from: d  reason: collision with root package name */
            private boolean f19861d = false;
            @Nullable

            /* renamed from: e  reason: collision with root package name */
            private String f19862e;
            @Nullable

            /* renamed from: f  reason: collision with root package name */
            private Bundle f19863f;

            @NonNull
            public AccountChooserOptions a() {
                Preconditions.b(true, "We only support hostedDomain filter for account chip styled account picker");
                Preconditions.b(true, "Consent is only valid for account chip styled account picker");
                AccountChooserOptions accountChooserOptions = new AccountChooserOptions();
                accountChooserOptions.f19847d = this.f19860c;
                accountChooserOptions.f19846c = this.f19859b;
                accountChooserOptions.f19848e = this.f19861d;
                accountChooserOptions.f19855l = null;
                accountChooserOptions.f19853j = null;
                accountChooserOptions.f19850g = this.f19863f;
                accountChooserOptions.f19844a = this.f19858a;
                accountChooserOptions.f19845b = false;
                accountChooserOptions.f19851h = false;
                accountChooserOptions.f19856m = null;
                accountChooserOptions.f19852i = 0;
                accountChooserOptions.f19849f = this.f19862e;
                accountChooserOptions.f19854k = false;
                accountChooserOptions.f19857n = false;
                accountChooserOptions.o = false;
                return accountChooserOptions;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder b(@Nullable List<Account> list) {
                this.f19859b = list == null ? null : new ArrayList(list);
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder c(@Nullable List<String> list) {
                this.f19860c = list == null ? null : new ArrayList(list);
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder d(boolean z) {
                this.f19861d = z;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder e(@Nullable Bundle bundle) {
                this.f19863f = bundle;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder f(@Nullable Account account) {
                this.f19858a = account;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder g(@Nullable String str) {
                this.f19862e = str;
                return this;
            }
        }
    }

    private AccountPicker() {
    }

    @ResultIgnorabilityUnspecified
    @NonNull
    @Deprecated
    public static Intent a(@Nullable Account account, @Nullable ArrayList<Account> arrayList, @Nullable String[] strArr, boolean z, @Nullable String str, @Nullable String str2, @Nullable String[] strArr2, @Nullable Bundle bundle) {
        Intent intent = new Intent();
        Preconditions.b(true, "We only support hostedDomain filter for account chip styled account picker");
        intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("allowableAccounts", arrayList);
        intent.putExtra("allowableAccountTypes", strArr);
        intent.putExtra("addAccountOptions", bundle);
        intent.putExtra("selectedAccount", account);
        intent.putExtra("alwaysPromptForAccount", z);
        intent.putExtra("descriptionTextOverride", str);
        intent.putExtra("authTokenType", str2);
        intent.putExtra("addAccountRequiredFeatures", strArr2);
        intent.putExtra("setGmsCoreAccount", false);
        intent.putExtra("overrideTheme", 0);
        intent.putExtra("overrideCustomTheme", 0);
        intent.putExtra("hostedDomainFilter", (String) null);
        return intent;
    }

    @NonNull
    public static Intent b(@NonNull AccountChooserOptions accountChooserOptions) {
        Intent intent = new Intent();
        boolean unused = accountChooserOptions.f19854k;
        String unused2 = accountChooserOptions.f19853j;
        Preconditions.b(true, "We only support hostedDomain filter for account chip styled account picker");
        zza unused3 = accountChooserOptions.f19855l;
        Preconditions.b(true, "Consent is only valid for account chip styled account picker");
        boolean unused4 = accountChooserOptions.f19845b;
        Preconditions.b(true, "Making the selected account non-clickable is only supported for the THEME_DAY_NIGHT_GOOGLE_MATERIAL2, THEME_LIGHT_GOOGLE_MATERIAL3, THEME_DARK_GOOGLE_MATERIAL3 or THEME_DAY_NIGHT_GOOGLE_MATERIAL3 themes");
        boolean unused5 = accountChooserOptions.f19854k;
        intent.setAction("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        intent.setPackage("com.google.android.gms");
        intent.putExtra("allowableAccounts", accountChooserOptions.f19846c);
        if (accountChooserOptions.f19847d != null) {
            intent.putExtra("allowableAccountTypes", (String[]) accountChooserOptions.f19847d.toArray(new String[0]));
        }
        intent.putExtra("addAccountOptions", accountChooserOptions.f19850g);
        intent.putExtra("selectedAccount", accountChooserOptions.f19844a);
        boolean unused6 = accountChooserOptions.f19845b;
        intent.putExtra("selectedAccountIsNotClickable", false);
        intent.putExtra("alwaysPromptForAccount", accountChooserOptions.f19848e);
        intent.putExtra("descriptionTextOverride", accountChooserOptions.f19849f);
        boolean unused7 = accountChooserOptions.f19851h;
        intent.putExtra("setGmsCoreAccount", false);
        String unused8 = accountChooserOptions.f19856m;
        intent.putExtra("realClientPackage", (String) null);
        int unused9 = accountChooserOptions.f19852i;
        intent.putExtra("overrideTheme", 0);
        boolean unused10 = accountChooserOptions.f19854k;
        intent.putExtra("overrideCustomTheme", 0);
        String unused11 = accountChooserOptions.f19853j;
        intent.putExtra("hostedDomainFilter", (String) null);
        Bundle bundle = new Bundle();
        boolean unused12 = accountChooserOptions.f19854k;
        zza unused13 = accountChooserOptions.f19855l;
        boolean unused14 = accountChooserOptions.f19857n;
        boolean unused15 = accountChooserOptions.o;
        if (!bundle.isEmpty()) {
            intent.putExtra("first_party_options_bundle", bundle);
        }
        return intent;
    }
}
