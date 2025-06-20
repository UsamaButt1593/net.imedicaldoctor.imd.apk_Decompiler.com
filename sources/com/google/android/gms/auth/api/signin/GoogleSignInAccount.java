package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AccountType;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "GoogleSignInAccountCreator")
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zab();
    @NonNull
    @VisibleForTesting
    public static Clock g3 = DefaultClock.e();
    @SafeParcelable.Field(getter = "getId", id = 2)
    @Nullable
    private String X;
    @SafeParcelable.Field(getter = "getDisplayName", id = 5)
    @Nullable
    private String X2;
    @SafeParcelable.Field(getter = "getIdToken", id = 3)
    @Nullable
    private String Y;
    @SafeParcelable.Field(getter = "getPhotoUrl", id = 6)
    @Nullable
    private Uri Y2;
    @SafeParcelable.Field(getter = "getEmail", id = 4)
    @Nullable
    private String Z;
    @SafeParcelable.Field(getter = "getServerAuthCode", id = 7)
    @Nullable
    private String Z2;
    @SafeParcelable.Field(getter = "getExpirationTimeSecs", id = 8)
    private long a3;
    @SafeParcelable.Field(getter = "getObfuscatedIdentifier", id = 9)
    private String b3;
    @SafeParcelable.Field(id = 10)
    List<Scope> c3;
    @SafeParcelable.Field(getter = "getGivenName", id = 11)
    @Nullable
    private String d3;
    @SafeParcelable.Field(getter = "getFamilyName", id = 12)
    @Nullable
    private String e3;
    private Set<Scope> f3 = new HashSet();
    @SafeParcelable.VersionField(id = 1)
    final int s;

    @SafeParcelable.Constructor
    GoogleSignInAccount(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) @Nullable String str, @SafeParcelable.Param(id = 3) @Nullable String str2, @SafeParcelable.Param(id = 4) @Nullable String str3, @SafeParcelable.Param(id = 5) @Nullable String str4, @SafeParcelable.Param(id = 6) @Nullable Uri uri, @SafeParcelable.Param(id = 7) @Nullable String str5, @SafeParcelable.Param(id = 8) long j2, @SafeParcelable.Param(id = 9) String str6, @SafeParcelable.Param(id = 10) List<Scope> list, @SafeParcelable.Param(id = 11) @Nullable String str7, @SafeParcelable.Param(id = 12) @Nullable String str8) {
        this.s = i2;
        this.X = str;
        this.Y = str2;
        this.Z = str3;
        this.X2 = str4;
        this.Y2 = uri;
        this.Z2 = str5;
        this.a3 = j2;
        this.b3 = str6;
        this.c3 = list;
        this.d3 = str7;
        this.e3 = str8;
    }

    @NonNull
    @KeepForSdk
    public static GoogleSignInAccount C() {
        return i0(new Account("<<default account>>", AccountType.f20215a), new HashSet());
    }

    @NonNull
    @KeepForSdk
    public static GoogleSignInAccount H(@NonNull Account account) {
        return i0(account, new ArraySet());
    }

    @NonNull
    public static GoogleSignInAccount d0(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Uri uri, @Nullable Long l2, @NonNull String str7, @NonNull Set<Scope> set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, (String) null, l2.longValue(), Preconditions.l(str7), new ArrayList((Collection) Preconditions.r(set)), str5, str6);
    }

    @Nullable
    public static GoogleSignInAccount e0(@Nullable String str) throws JSONException {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl");
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        GoogleSignInAccount d0 = d0(jSONObject.optString("id"), jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null, jSONObject.has("email") ? jSONObject.optString("email") : null, jSONObject.has("displayName") ? jSONObject.optString("displayName") : null, jSONObject.has("givenName") ? jSONObject.optString("givenName") : null, jSONObject.has("familyName") ? jSONObject.optString("familyName") : null, parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        if (jSONObject.has("serverAuthCode")) {
            str2 = jSONObject.optString("serverAuthCode");
        }
        d0.Z2 = str2;
        return d0;
    }

    private static GoogleSignInAccount i0(Account account, Set<Scope> set) {
        return d0((String) null, (String) null, account.name, (String) null, (String) null, (String) null, (Uri) null, 0L, account.name, set);
    }

    @Nullable
    public String I() {
        return this.X2;
    }

    @Nullable
    public String N() {
        return this.Z;
    }

    @Nullable
    public String O() {
        return this.e3;
    }

    @Nullable
    public String P() {
        return this.d3;
    }

    @NonNull
    public Set<Scope> Q() {
        return new HashSet(this.c3);
    }

    @Nullable
    public String R() {
        return this.X;
    }

    @Nullable
    public String S() {
        return this.Y;
    }

    @Nullable
    public Uri T() {
        return this.Y2;
    }

    @NonNull
    @KeepForSdk
    public Set<Scope> W() {
        HashSet hashSet = new HashSet(this.c3);
        hashSet.addAll(this.f3);
        return hashSet;
    }

    @Nullable
    public String Z() {
        return this.Z2;
    }

    @KeepForSdk
    public boolean a0() {
        return g3.a() / 1000 >= this.a3 + -300;
    }

    @NonNull
    @KeepForSdk
    public GoogleSignInAccount c0(@NonNull Scope... scopeArr) {
        if (scopeArr != null) {
            Collections.addAll(this.f3, scopeArr);
        }
        return this;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.b3.equals(this.b3) && googleSignInAccount.W().equals(W());
    }

    @NonNull
    public final String g0() {
        return this.b3;
    }

    @NonNull
    public final String h0() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (R() != null) {
                jSONObject.put("id", R());
            }
            if (S() != null) {
                jSONObject.put("tokenId", S());
            }
            if (N() != null) {
                jSONObject.put("email", N());
            }
            if (I() != null) {
                jSONObject.put("displayName", I());
            }
            if (P() != null) {
                jSONObject.put("givenName", P());
            }
            if (O() != null) {
                jSONObject.put("familyName", O());
            }
            Uri T = T();
            if (T != null) {
                jSONObject.put("photoUrl", T.toString());
            }
            if (Z() != null) {
                jSONObject.put("serverAuthCode", Z());
            }
            jSONObject.put("expirationTime", this.a3);
            jSONObject.put("obfuscatedIdentifier", this.b3);
            JSONArray jSONArray = new JSONArray();
            List<Scope> list = this.c3;
            Scope[] scopeArr = (Scope[]) list.toArray(new Scope[list.size()]);
            Arrays.sort(scopeArr, zaa.s);
            for (Scope C : scopeArr) {
                jSONArray.put(C.C());
            }
            jSONObject.put("grantedScopes", jSONArray);
            jSONObject.remove("serverAuthCode");
            return jSONObject.toString();
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    public int hashCode() {
        return ((this.b3.hashCode() + MetaDo.w) * 31) + W().hashCode();
    }

    @Nullable
    public Account v() {
        String str = this.Z;
        if (str == null) {
            return null;
        }
        return new Account(str, AccountType.f20215a);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.F(parcel, 1, this.s);
        SafeParcelWriter.Y(parcel, 2, R(), false);
        SafeParcelWriter.Y(parcel, 3, S(), false);
        SafeParcelWriter.Y(parcel, 4, N(), false);
        SafeParcelWriter.Y(parcel, 5, I(), false);
        SafeParcelWriter.S(parcel, 6, T(), i2, false);
        SafeParcelWriter.Y(parcel, 7, Z(), false);
        SafeParcelWriter.K(parcel, 8, this.a3);
        SafeParcelWriter.Y(parcel, 9, this.b3, false);
        SafeParcelWriter.d0(parcel, 10, this.c3, false);
        SafeParcelWriter.Y(parcel, 11, P(), false);
        SafeParcelWriter.Y(parcel, 12, O(), false);
        SafeParcelWriter.b(parcel, a2);
    }
}
