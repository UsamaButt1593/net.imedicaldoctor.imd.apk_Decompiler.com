package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;

@KeepForSdk
public class Storage {

    /* renamed from: c  reason: collision with root package name */
    private static final Lock f19734c = new ReentrantLock();
    @GuardedBy("sLk")
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private static Storage f19735d;

    /* renamed from: a  reason: collision with root package name */
    private final Lock f19736a = new ReentrantLock();
    @GuardedBy("mLk")

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f19737b;

    @VisibleForTesting
    Storage(Context context) {
        this.f19737b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    @NonNull
    @KeepForSdk
    public static Storage b(@NonNull Context context) {
        Preconditions.r(context);
        Lock lock = f19734c;
        lock.lock();
        try {
            if (f19735d == null) {
                f19735d = new Storage(context.getApplicationContext());
            }
            Storage storage = f19735d;
            lock.unlock();
            return storage;
        } catch (Throwable th) {
            f19734c.unlock();
            throw th;
        }
    }

    private static final String k(String str, String str2) {
        StringBuilder sb = new StringBuilder(str.length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return sb.toString();
    }

    @KeepForSdk
    public void a() {
        this.f19736a.lock();
        try {
            this.f19737b.edit().clear().apply();
        } finally {
            this.f19736a.unlock();
        }
    }

    @KeepForSdk
    @Nullable
    public GoogleSignInAccount c() {
        String g2;
        String g3 = g("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(g3) || (g2 = g(k("googleSignInAccount", g3))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.e0(g2);
        } catch (JSONException unused) {
            return null;
        }
    }

    @KeepForSdk
    @Nullable
    public GoogleSignInOptions d() {
        String g2;
        String g3 = g("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(g3) || (g2 = g(k("googleSignInOptions", g3))) == null) {
            return null;
        }
        try {
            return GoogleSignInOptions.T(g2);
        } catch (JSONException unused) {
            return null;
        }
    }

    @KeepForSdk
    @Nullable
    public String e() {
        return g("refreshToken");
    }

    @KeepForSdk
    public void f(@NonNull GoogleSignInAccount googleSignInAccount, @NonNull GoogleSignInOptions googleSignInOptions) {
        Preconditions.r(googleSignInAccount);
        Preconditions.r(googleSignInOptions);
        j("defaultGoogleSignInAccount", googleSignInAccount.g0());
        Preconditions.r(googleSignInAccount);
        Preconditions.r(googleSignInOptions);
        String g0 = googleSignInAccount.g0();
        j(k("googleSignInAccount", g0), googleSignInAccount.h0());
        j(k("googleSignInOptions", g0), googleSignInOptions.c0());
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final String g(@NonNull String str) {
        this.f19736a.lock();
        try {
            return this.f19737b.getString(str, (String) null);
        } finally {
            this.f19736a.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public final void h(@NonNull String str) {
        this.f19736a.lock();
        try {
            this.f19737b.edit().remove(str).apply();
        } finally {
            this.f19736a.unlock();
        }
    }

    public final void i() {
        String g2 = g("defaultGoogleSignInAccount");
        h("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(g2)) {
            h(k("googleSignInAccount", g2));
            h(k("googleSignInOptions", g2));
        }
    }

    /* access modifiers changed from: protected */
    public final void j(@NonNull String str, @NonNull String str2) {
        this.f19736a.lock();
        try {
            this.f19737b.edit().putString(str, str2).apply();
        } finally {
            this.f19736a.unlock();
        }
    }
}
