package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

class Store {

    /* renamed from: b  reason: collision with root package name */
    private static final String f24860b = "|T|";

    /* renamed from: c  reason: collision with root package name */
    private static final String f24861c = "*";

    /* renamed from: d  reason: collision with root package name */
    static final String f24862d = "com.google.android.gms.appid";

    /* renamed from: e  reason: collision with root package name */
    static final String f24863e = "com.google.android.gms.appid-no-backup";

    /* renamed from: a  reason: collision with root package name */
    final SharedPreferences f24864a;

    static class Token {

        /* renamed from: d  reason: collision with root package name */
        private static final String f24865d = "token";

        /* renamed from: e  reason: collision with root package name */
        private static final String f24866e = "appVersion";

        /* renamed from: f  reason: collision with root package name */
        private static final String f24867f = "timestamp";

        /* renamed from: g  reason: collision with root package name */
        private static final long f24868g = TimeUnit.DAYS.toMillis(7);

        /* renamed from: a  reason: collision with root package name */
        final String f24869a;

        /* renamed from: b  reason: collision with root package name */
        final String f24870b;

        /* renamed from: c  reason: collision with root package name */
        final long f24871c;

        private Token(String str, String str2, long j2) {
            this.f24869a = str;
            this.f24870b = str2;
            this.f24871c = j2;
        }

        static String a(String str, String str2, long j2) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(f24865d, str);
                jSONObject.put(f24866e, str2);
                jSONObject.put(f24867f, j2);
                return jSONObject.toString();
            } catch (JSONException e2) {
                Log.w(Constants.f24670a, "Failed to encode token: " + e2);
                return null;
            }
        }

        static Token c(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("{")) {
                return new Token(str, (String) null, 0);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new Token(jSONObject.getString(f24865d), jSONObject.getString(f24866e), jSONObject.getLong(f24867f));
            } catch (JSONException e2) {
                Log.w(Constants.f24670a, "Failed to parse token: " + e2);
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(String str) {
            return System.currentTimeMillis() > this.f24871c + f24868g || !str.equals(this.f24870b);
        }
    }

    public Store(Context context) {
        this.f24864a = context.getSharedPreferences(f24862d, 0);
        a(context, f24863e);
    }

    private void a(Context context, String str) {
        File file = new File(ContextCompat.p(context), str);
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !f()) {
                    Log.i(Constants.f24670a, "App restored, clearing state");
                    c();
                }
            } catch (IOException e2) {
                if (Log.isLoggable(Constants.f24670a, 3)) {
                    Log.d(Constants.f24670a, "Error creating file in no backup dir: " + e2.getMessage());
                }
            }
        }
    }

    private String b(String str, String str2) {
        return str + f24860b + str2 + "|" + f24861c;
    }

    public synchronized void c() {
        this.f24864a.edit().clear().commit();
    }

    public synchronized void d(String str, String str2) {
        String b2 = b(str, str2);
        SharedPreferences.Editor edit = this.f24864a.edit();
        edit.remove(b2);
        edit.commit();
    }

    public synchronized Token e(String str, String str2) {
        return Token.c(this.f24864a.getString(b(str, str2), (String) null));
    }

    public synchronized boolean f() {
        return this.f24864a.getAll().isEmpty();
    }

    public synchronized void g(String str, String str2, String str3, String str4) {
        String a2 = Token.a(str3, str4, System.currentTimeMillis());
        if (a2 != null) {
            SharedPreferences.Editor edit = this.f24864a.edit();
            edit.putString(b(str, str2), a2);
            edit.commit();
        }
    }
}
