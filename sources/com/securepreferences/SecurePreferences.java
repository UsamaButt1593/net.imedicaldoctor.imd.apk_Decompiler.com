package com.securepreferences;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.tozny.crypto.android.AesCbcWithIntegrity;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SecurePreferences implements SharedPreferences {

    /* renamed from: d  reason: collision with root package name */
    private static boolean f28169d = false;

    /* renamed from: e  reason: collision with root package name */
    private static final String f28170e = "com.securepreferences.SecurePreferences";
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f28171a;

    /* renamed from: b  reason: collision with root package name */
    private AesCbcWithIntegrity.SecretKeys f28172b;

    /* renamed from: c  reason: collision with root package name */
    private String f28173c;

    public class Editor implements SharedPreferences.Editor {

        /* renamed from: a  reason: collision with root package name */
        private SharedPreferences.Editor f28174a;

        private Editor() {
            this.f28174a = SecurePreferences.this.f28171a.edit();
        }

        public SharedPreferences.Editor a(String str, String str2) {
            this.f28174a.putString(SecurePreferences.l(str), str2);
            return this;
        }

        @TargetApi(9)
        public void apply() {
            this.f28174a.apply();
        }

        public SharedPreferences.Editor clear() {
            this.f28174a.clear();
            return this;
        }

        public boolean commit() {
            return this.f28174a.commit();
        }

        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            this.f28174a.putString(SecurePreferences.l(str), SecurePreferences.this.f(Boolean.toString(z)));
            return this;
        }

        public SharedPreferences.Editor putFloat(String str, float f2) {
            this.f28174a.putString(SecurePreferences.l(str), SecurePreferences.this.f(Float.toString(f2)));
            return this;
        }

        public SharedPreferences.Editor putInt(String str, int i2) {
            this.f28174a.putString(SecurePreferences.l(str), SecurePreferences.this.f(Integer.toString(i2)));
            return this;
        }

        public SharedPreferences.Editor putLong(String str, long j2) {
            this.f28174a.putString(SecurePreferences.l(str), SecurePreferences.this.f(Long.toString(j2)));
            return this;
        }

        public SharedPreferences.Editor putString(String str, String str2) {
            this.f28174a.putString(SecurePreferences.l(str), SecurePreferences.this.f(str2));
            return this;
        }

        @TargetApi(11)
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            HashSet hashSet = new HashSet(set.size());
            for (String b2 : set) {
                hashSet.add(SecurePreferences.this.f(b2));
            }
            this.f28174a.putStringSet(SecurePreferences.l(str), hashSet);
            return this;
        }

        public SharedPreferences.Editor remove(String str) {
            this.f28174a.remove(SecurePreferences.l(str));
            return this;
        }
    }

    public SecurePreferences(Context context) {
        this(context, "", (String) null);
    }

    private String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return AesCbcWithIntegrity.d(new AesCbcWithIntegrity.CipherTextIvMac(str), this.f28172b);
        } catch (GeneralSecurityException e2) {
            e = e2;
            if (!f28169d) {
                return null;
            }
            Log.w(f28170e, "decrypt", e);
            return null;
        } catch (UnsupportedEncodingException e3) {
            e = e3;
            if (!f28169d) {
                return null;
            }
            Log.w(f28170e, "decrypt", e);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return AesCbcWithIntegrity.f(str, this.f28172b).toString();
        } catch (GeneralSecurityException e2) {
            if (f28169d) {
                Log.w(f28170e, "encrypt", e2);
            }
            return null;
        } catch (UnsupportedEncodingException e3) {
            if (f28169d) {
                Log.w(f28170e, "encrypt", e3);
            }
            return null;
        }
    }

    private static String g(Context context) throws GeneralSecurityException {
        AesCbcWithIntegrity.SecretKeys n2 = AesCbcWithIntegrity.n(context.getPackageName(), h(context).getBytes());
        if (n2 != null) {
            return l(n2.toString());
        }
        throw new GeneralSecurityException("Key not generated");
    }

    private static String h(Context context) {
        try {
            String str = (String) Build.class.getField("SERIAL").get((Object) null);
            return TextUtils.isEmpty(str) ? Settings.Secure.getString(context.getContentResolver(), "android_id") : str;
        } catch (Exception unused) {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        }
    }

    private SharedPreferences i(Context context, String str) {
        this.f28173c = this.f28173c;
        return TextUtils.isEmpty(str) ? PreferenceManager.getDefaultSharedPreferences(context) : context.getSharedPreferences(str, 0);
    }

    public static String l(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            byte[] bytes = str.getBytes("UTF-8");
            instance.update(bytes, 0, bytes.length);
            return Base64.encodeToString(instance.digest(), 2);
        } catch (NoSuchAlgorithmException e2) {
            e = e2;
            if (!f28169d) {
                return null;
            }
            Log.w(f28170e, "Problem generating hash", e);
            return null;
        } catch (UnsupportedEncodingException e3) {
            e = e3;
            if (!f28169d) {
                return null;
            }
            Log.w(f28170e, "Problem generating hash", e);
            return null;
        }
    }

    public static boolean m() {
        return f28169d;
    }

    public static void o(boolean z) {
        f28169d = z;
    }

    public boolean contains(String str) {
        return this.f28171a.contains(l(str));
    }

    public void d() {
        this.f28172b = null;
    }

    /* renamed from: e */
    public Editor edit() {
        return new Editor();
    }

    public Map<String, String> getAll() {
        Map<String, ?> all = this.f28171a.getAll();
        HashMap hashMap = new HashMap(all.size());
        for (Map.Entry next : all.entrySet()) {
            try {
                Object value = next.getValue();
                if (value != null && !value.equals(this.f28172b.toString())) {
                    hashMap.put(next.getKey(), c(value.toString()));
                }
            } catch (Exception e2) {
                if (f28169d) {
                    Log.w(f28170e, "error during getAll", e2);
                }
                hashMap.put(next.getKey(), next.getValue().toString());
            }
        }
        return hashMap;
    }

    public boolean getBoolean(String str, boolean z) {
        String string = this.f28171a.getString(l(str), (String) null);
        if (string == null) {
            return z;
        }
        try {
            return Boolean.parseBoolean(c(string));
        } catch (NumberFormatException e2) {
            throw new ClassCastException(e2.getMessage());
        }
    }

    public float getFloat(String str, float f2) {
        String string = this.f28171a.getString(l(str), (String) null);
        if (string == null) {
            return f2;
        }
        try {
            return Float.parseFloat(c(string));
        } catch (NumberFormatException e2) {
            throw new ClassCastException(e2.getMessage());
        }
    }

    public int getInt(String str, int i2) {
        String string = this.f28171a.getString(l(str), (String) null);
        if (string == null) {
            return i2;
        }
        try {
            return Integer.parseInt(c(string));
        } catch (NumberFormatException e2) {
            throw new ClassCastException(e2.getMessage());
        }
    }

    public long getLong(String str, long j2) {
        String string = this.f28171a.getString(l(str), (String) null);
        if (string == null) {
            return j2;
        }
        try {
            return Long.parseLong(c(string));
        } catch (NumberFormatException e2) {
            throw new ClassCastException(e2.getMessage());
        }
    }

    public String getString(String str, String str2) {
        String string = this.f28171a.getString(l(str), (String) null);
        return string != null ? c(string) : str2;
    }

    @TargetApi(11)
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> stringSet = this.f28171a.getStringSet(l(str), (Set) null);
        if (stringSet == null) {
            return set;
        }
        HashSet hashSet = new HashSet(stringSet.size());
        for (String c2 : stringSet) {
            hashSet.add(c(c2));
        }
        return hashSet;
    }

    public String j(String str, String str2) {
        String string = this.f28171a.getString(l(str), (String) null);
        return string != null ? string : str2;
    }

    public void k(String str, Context context) throws GeneralSecurityException {
        AesCbcWithIntegrity.SecretKeys l2 = AesCbcWithIntegrity.l(str, h(context));
        Map<String, ?> all = this.f28171a.getAll();
        HashMap hashMap = new HashMap(all.size());
        for (String next : all.keySet()) {
            Object obj = all.get(next);
            if (obj instanceof String) {
                hashMap.put(next, c((String) obj));
            }
        }
        d();
        SharedPreferences.Editor edit = this.f28171a.edit();
        edit.clear();
        edit.commit();
        this.f28171a = null;
        SharedPreferences i2 = i(context, this.f28173c);
        this.f28171a = i2;
        this.f28172b = l2;
        SharedPreferences.Editor edit2 = i2.edit();
        for (String str2 : hashMap.keySet()) {
            edit2.putString(str2, f((String) hashMap.get(str2)));
        }
        edit2.commit();
    }

    public void n(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener, boolean z) {
        if (!z) {
            registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f28171a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f28171a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public SecurePreferences(Context context, AesCbcWithIntegrity.SecretKeys secretKeys, String str) {
        this(context, secretKeys, (String) null, str);
    }

    private SecurePreferences(Context context, AesCbcWithIntegrity.SecretKeys secretKeys, String str, String str2) {
        if (this.f28171a == null) {
            this.f28171a = i(context, str2);
        }
        if (secretKeys != null) {
            this.f28172b = secretKeys;
        } else if (TextUtils.isEmpty(str)) {
            try {
                String g2 = g(context);
                String string = this.f28171a.getString(g2, (String) null);
                if (string == null) {
                    this.f28172b = AesCbcWithIntegrity.k();
                    if (!this.f28171a.edit().putString(g2, this.f28172b.toString()).commit()) {
                        Log.w(f28170e, "Key not committed to prefs");
                    }
                } else {
                    this.f28172b = AesCbcWithIntegrity.s(string);
                }
                if (this.f28172b == null) {
                    throw new GeneralSecurityException("Problem generating Key");
                }
            } catch (GeneralSecurityException e2) {
                if (f28169d) {
                    String str3 = f28170e;
                    Log.e(str3, "Error init:" + e2.getMessage());
                }
                throw new IllegalStateException(e2);
            }
        } else {
            try {
                AesCbcWithIntegrity.SecretKeys l2 = AesCbcWithIntegrity.l(str, h(context));
                this.f28172b = l2;
                if (l2 == null) {
                    throw new GeneralSecurityException("Problem generating Key From Password");
                }
            } catch (GeneralSecurityException e3) {
                if (f28169d) {
                    String str4 = f28170e;
                    Log.e(str4, "Error init using user password:" + e3.getMessage());
                }
                throw new IllegalStateException(e3);
            }
        }
    }

    public SecurePreferences(Context context, String str, String str2) {
        this(context, (AesCbcWithIntegrity.SecretKeys) null, str, str2);
    }
}
