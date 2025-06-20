package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.HashAccumulator;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AccountType;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "GoogleSignInOptionsCreator")
public class GoogleSignInOptions extends AbstractSafeParcelable implements Api.ApiOptions.Optional, ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new zae();
    @NonNull
    public static final GoogleSignInOptions e3;
    @NonNull
    public static final GoogleSignInOptions f3;
    @NonNull
    @VisibleForTesting
    public static final Scope g3 = new Scope(Scopes.f19906a);
    @NonNull
    @VisibleForTesting
    public static final Scope h3 = new Scope("email");
    @NonNull
    @VisibleForTesting
    public static final Scope i3 = new Scope(Scopes.f19908c);
    @NonNull
    @VisibleForTesting
    public static final Scope j3;
    @NonNull
    @VisibleForTesting
    public static final Scope k3 = new Scope(Scopes.f19913h);
    private static Comparator<Scope> l3 = new zac();
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getScopes", id = 2)
    public final ArrayList<Scope> X;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "isServerAuthCodeRequested", id = 5)
    public final boolean X2;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getAccount", id = 3)
    @Nullable
    public Account Y;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "isForceCodeForRefreshToken", id = 6)
    public final boolean Y2;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "isIdTokenRequested", id = 4)
    public boolean Z;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getServerClientId", id = 7)
    @Nullable
    public String Z2;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getHostedDomain", id = 8)
    @Nullable
    public String a3;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getExtensions", id = 9)
    public ArrayList<GoogleSignInOptionsExtensionParcelable> b3;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getLogSessionId", id = 10)
    @Nullable
    public String c3;
    private Map<Integer, GoogleSignInOptionsExtensionParcelable> d3;
    @SafeParcelable.VersionField(id = 1)
    final int s;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private Set<Scope> f19721a = new HashSet();

        /* renamed from: b  reason: collision with root package name */
        private boolean f19722b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f19723c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f19724d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private String f19725e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private Account f19726f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private String f19727g;

        /* renamed from: h  reason: collision with root package name */
        private Map<Integer, GoogleSignInOptionsExtensionParcelable> f19728h = new HashMap();
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        private String f19729i;

        public Builder() {
        }

        private final String m(String str) {
            Preconditions.l(str);
            String str2 = this.f19725e;
            boolean z = true;
            if (str2 != null && !str2.equals(str)) {
                z = false;
            }
            Preconditions.b(z, "two different server client ids provided");
            return str;
        }

        @NonNull
        public Builder a(@NonNull GoogleSignInOptionsExtension googleSignInOptionsExtension) {
            if (!this.f19728h.containsKey(Integer.valueOf(googleSignInOptionsExtension.b()))) {
                List<Scope> c2 = googleSignInOptionsExtension.c();
                if (c2 != null) {
                    this.f19721a.addAll(c2);
                }
                this.f19728h.put(Integer.valueOf(googleSignInOptionsExtension.b()), new GoogleSignInOptionsExtensionParcelable(googleSignInOptionsExtension));
                return this;
            }
            throw new IllegalStateException("Only one extension per type may be added");
        }

        @NonNull
        public GoogleSignInOptions b() {
            if (this.f19721a.contains(GoogleSignInOptions.k3)) {
                Set<Scope> set = this.f19721a;
                Scope scope = GoogleSignInOptions.j3;
                if (set.contains(scope)) {
                    this.f19721a.remove(scope);
                }
            }
            if (this.f19724d && (this.f19726f == null || !this.f19721a.isEmpty())) {
                d();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.f19721a), this.f19726f, this.f19724d, this.f19722b, this.f19723c, this.f19725e, this.f19727g, this.f19728h, this.f19729i, (zad) null);
        }

        @NonNull
        public Builder c() {
            this.f19721a.add(GoogleSignInOptions.h3);
            return this;
        }

        @NonNull
        public Builder d() {
            this.f19721a.add(GoogleSignInOptions.i3);
            return this;
        }

        @NonNull
        public Builder e(@NonNull String str) {
            this.f19724d = true;
            m(str);
            this.f19725e = str;
            return this;
        }

        @NonNull
        public Builder f() {
            this.f19721a.add(GoogleSignInOptions.g3);
            return this;
        }

        @NonNull
        public Builder g(@NonNull Scope scope, @NonNull Scope... scopeArr) {
            this.f19721a.add(scope);
            this.f19721a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        @NonNull
        public Builder h(@NonNull String str) {
            i(str, false);
            return this;
        }

        @NonNull
        public Builder i(@NonNull String str, boolean z) {
            this.f19722b = true;
            m(str);
            this.f19725e = str;
            this.f19723c = z;
            return this;
        }

        @NonNull
        public Builder j(@NonNull String str) {
            this.f19726f = new Account(Preconditions.l(str), AccountType.f20215a);
            return this;
        }

        @NonNull
        public Builder k(@NonNull String str) {
            this.f19727g = Preconditions.l(str);
            return this;
        }

        @NonNull
        @KeepForSdk
        public Builder l(@NonNull String str) {
            this.f19729i = str;
            return this;
        }

        public Builder(@NonNull GoogleSignInOptions googleSignInOptions) {
            Preconditions.r(googleSignInOptions);
            this.f19721a = new HashSet(googleSignInOptions.X);
            this.f19722b = googleSignInOptions.X2;
            this.f19723c = googleSignInOptions.Y2;
            this.f19724d = googleSignInOptions.Z;
            this.f19725e = googleSignInOptions.Z2;
            this.f19726f = googleSignInOptions.Y;
            this.f19727g = googleSignInOptions.a3;
            this.f19728h = GoogleSignInOptions.k0(googleSignInOptions.b3);
            this.f19729i = googleSignInOptions.c3;
        }
    }

    static {
        Scope scope = new Scope(Scopes.f19914i);
        j3 = scope;
        Builder builder = new Builder();
        builder.d();
        builder.f();
        e3 = builder.b();
        Builder builder2 = new Builder();
        builder2.g(scope, new Scope[0]);
        f3 = builder2.b();
    }

    @SafeParcelable.Constructor
    GoogleSignInOptions(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) ArrayList<Scope> arrayList, @SafeParcelable.Param(id = 3) @Nullable Account account, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) boolean z3, @SafeParcelable.Param(id = 7) @Nullable String str, @SafeParcelable.Param(id = 8) @Nullable String str2, @SafeParcelable.Param(id = 9) ArrayList<GoogleSignInOptionsExtensionParcelable> arrayList2, @SafeParcelable.Param(id = 10) @Nullable String str3) {
        this(i2, arrayList, account, z, z2, z3, str, str2, k0(arrayList2), str3);
    }

    @Nullable
    public static GoogleSignInOptions T(@Nullable String str) throws JSONException {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        String optString = jSONObject.has("accountName") ? jSONObject.optString("accountName") : null;
        Account account = !TextUtils.isEmpty(optString) ? new Account(optString, AccountType.f20215a) : null;
        ArrayList arrayList = new ArrayList(hashSet);
        boolean z = jSONObject.getBoolean("idTokenRequested");
        boolean z2 = jSONObject.getBoolean("serverAuthRequested");
        boolean z3 = jSONObject.getBoolean("forceCodeForRefreshToken");
        String optString2 = jSONObject.has("serverClientId") ? jSONObject.optString("serverClientId") : null;
        if (jSONObject.has("hostedDomain")) {
            str2 = jSONObject.optString("hostedDomain");
        }
        return new GoogleSignInOptions(3, (ArrayList<Scope>) arrayList, account, z, z2, z3, optString2, str2, (Map<Integer, GoogleSignInOptionsExtensionParcelable>) new HashMap(), (String) null);
    }

    /* access modifiers changed from: private */
    public static Map<Integer, GoogleSignInOptionsExtensionParcelable> k0(@Nullable List<GoogleSignInOptionsExtensionParcelable> list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (GoogleSignInOptionsExtensionParcelable next : list) {
            hashMap.put(Integer.valueOf(next.C()), next);
        }
        return hashMap;
    }

    @NonNull
    @KeepForSdk
    public ArrayList<GoogleSignInOptionsExtensionParcelable> C() {
        return this.b3;
    }

    @KeepForSdk
    @Nullable
    public String H() {
        return this.c3;
    }

    @NonNull
    public Scope[] I() {
        ArrayList<Scope> arrayList = this.X;
        return (Scope[]) arrayList.toArray(new Scope[arrayList.size()]);
    }

    @NonNull
    @KeepForSdk
    public ArrayList<Scope> N() {
        return new ArrayList<>(this.X);
    }

    @KeepForSdk
    @Nullable
    public String O() {
        return this.Z2;
    }

    @KeepForSdk
    public boolean P() {
        return this.Y2;
    }

    @KeepForSdk
    public boolean Q() {
        return this.Z;
    }

    @KeepForSdk
    public boolean R() {
        return this.X2;
    }

    @NonNull
    public final String c0() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.X, l3);
            Iterator<Scope> it2 = this.X.iterator();
            while (it2.hasNext()) {
                jSONArray.put(it2.next().C());
            }
            jSONObject.put("scopes", jSONArray);
            Account account = this.Y;
            if (account != null) {
                jSONObject.put("accountName", account.name);
            }
            jSONObject.put("idTokenRequested", this.Z);
            jSONObject.put("forceCodeForRefreshToken", this.Y2);
            jSONObject.put("serverAuthRequested", this.X2);
            if (!TextUtils.isEmpty(this.Z2)) {
                jSONObject.put("serverClientId", this.Z2);
            }
            if (!TextUtils.isEmpty(this.a3)) {
                jSONObject.put("hostedDomain", this.a3);
            }
            return jSONObject.toString();
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        if (r1.equals(r4.v()) != false) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(@androidx.annotation.Nullable java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4     // Catch:{ ClassCastException -> 0x0090 }
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r3.b3     // Catch:{ ClassCastException -> 0x0090 }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 > 0) goto L_0x0090
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r4.b3     // Catch:{ ClassCastException -> 0x0090 }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 <= 0) goto L_0x0018
            goto L_0x0090
        L_0x0018:
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.X     // Catch:{ ClassCastException -> 0x0090 }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x0090 }
            java.util.ArrayList r2 = r4.N()     // Catch:{ ClassCastException -> 0x0090 }
            int r2 = r2.size()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != r2) goto L_0x0090
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.X     // Catch:{ ClassCastException -> 0x0090 }
            java.util.ArrayList r2 = r4.N()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = r1.containsAll(r2)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != 0) goto L_0x0035
            goto L_0x0090
        L_0x0035:
            android.accounts.Account r1 = r3.Y     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != 0) goto L_0x0040
            android.accounts.Account r1 = r4.v()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != 0) goto L_0x0090
            goto L_0x004a
        L_0x0040:
            android.accounts.Account r2 = r4.v()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = r1.equals(r2)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 == 0) goto L_0x0090
        L_0x004a:
            java.lang.String r1 = r3.Z2     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 == 0) goto L_0x005d
            java.lang.String r1 = r4.O()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 == 0) goto L_0x0090
            goto L_0x006a
        L_0x005d:
            java.lang.String r1 = r3.Z2     // Catch:{ ClassCastException -> 0x0090 }
            java.lang.String r2 = r4.O()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = r1.equals(r2)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != 0) goto L_0x006a
            goto L_0x0090
        L_0x006a:
            boolean r1 = r3.Y2     // Catch:{ ClassCastException -> 0x0090 }
            boolean r2 = r4.P()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != r2) goto L_0x0090
            boolean r1 = r3.Z     // Catch:{ ClassCastException -> 0x0090 }
            boolean r2 = r4.Q()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != r2) goto L_0x0090
            boolean r1 = r3.X2     // Catch:{ ClassCastException -> 0x0090 }
            boolean r2 = r4.R()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != r2) goto L_0x0090
            java.lang.String r1 = r3.c3     // Catch:{ ClassCastException -> 0x0090 }
            java.lang.String r4 = r4.H()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r4 = android.text.TextUtils.equals(r1, r4)     // Catch:{ ClassCastException -> 0x0090 }
            if (r4 == 0) goto L_0x0090
            r4 = 1
            return r4
        L_0x0090:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList<Scope> arrayList2 = this.X;
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(arrayList2.get(i2).C());
        }
        Collections.sort(arrayList);
        HashAccumulator hashAccumulator = new HashAccumulator();
        hashAccumulator.a(arrayList);
        hashAccumulator.a(this.Y);
        hashAccumulator.a(this.Z2);
        hashAccumulator.c(this.Y2);
        hashAccumulator.c(this.Z);
        hashAccumulator.c(this.X2);
        hashAccumulator.a(this.c3);
        return hashAccumulator.b();
    }

    @KeepForSdk
    @Nullable
    public Account v() {
        return this.Y;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.F(parcel, 1, this.s);
        SafeParcelWriter.d0(parcel, 2, N(), false);
        SafeParcelWriter.S(parcel, 3, v(), i2, false);
        SafeParcelWriter.g(parcel, 4, Q());
        SafeParcelWriter.g(parcel, 5, R());
        SafeParcelWriter.g(parcel, 6, P());
        SafeParcelWriter.Y(parcel, 7, O(), false);
        SafeParcelWriter.Y(parcel, 8, this.a3, false);
        SafeParcelWriter.d0(parcel, 9, C(), false);
        SafeParcelWriter.Y(parcel, 10, H(), false);
        SafeParcelWriter.b(parcel, a2);
    }

    private GoogleSignInOptions(int i2, ArrayList<Scope> arrayList, @Nullable Account account, boolean z, boolean z2, boolean z3, @Nullable String str, @Nullable String str2, Map<Integer, GoogleSignInOptionsExtensionParcelable> map, @Nullable String str3) {
        this.s = i2;
        this.X = arrayList;
        this.Y = account;
        this.Z = z;
        this.X2 = z2;
        this.Y2 = z3;
        this.Z2 = str;
        this.a3 = str2;
        this.b3 = new ArrayList<>(map.values());
        this.d3 = map;
        this.c3 = str3;
    }

    /* synthetic */ GoogleSignInOptions(int i2, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map, String str3, zad zad) {
        this(3, (ArrayList<Scope>) arrayList, account, z, z2, z3, str, str2, (Map<Integer, GoogleSignInOptionsExtensionParcelable>) map, str3);
    }
}
