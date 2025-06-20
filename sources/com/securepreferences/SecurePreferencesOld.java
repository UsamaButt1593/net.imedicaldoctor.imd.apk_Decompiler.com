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
import androidx.media3.extractor.ts.PsExtractor;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

@Deprecated
public class SecurePreferencesOld implements SharedPreferences {

    /* renamed from: a  reason: collision with root package name */
    private static final int f28176a = 256;

    /* renamed from: b  reason: collision with root package name */
    private static final String f28177b = "AES";

    /* renamed from: c  reason: collision with root package name */
    private static final String f28178c = "BC";

    /* renamed from: d  reason: collision with root package name */
    private static final String f28179d = "PBKDF2WithHmacSHA1";

    /* renamed from: e  reason: collision with root package name */
    private static final String f28180e = "PBEWithMD5AndDES";

    /* renamed from: f  reason: collision with root package name */
    private static final int f28181f = 2000;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static SharedPreferences f28182g = null;

    /* renamed from: h  reason: collision with root package name */
    private static byte[] f28183h = null;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f28184i = false;

    /* renamed from: j  reason: collision with root package name */
    private static HashMap<SharedPreferences.OnSharedPreferenceChangeListener, SharedPreferences.OnSharedPreferenceChangeListener> f28185j = null;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final String f28186k = "com.securepreferences.SecurePreferencesOld";

    public static class Editor implements SharedPreferences.Editor {

        /* renamed from: a  reason: collision with root package name */
        private SharedPreferences.Editor f28190a;

        private Editor() {
            this.f28190a = SecurePreferencesOld.f28182g.edit();
        }

        public SharedPreferences.Editor a(String str, String str2) {
            this.f28190a.putString(SecurePreferencesOld.i(str), str2);
            return this;
        }

        @TargetApi(9)
        public void apply() {
            this.f28190a.apply();
        }

        public SharedPreferences.Editor clear() {
            this.f28190a.clear();
            return this;
        }

        public boolean commit() {
            return this.f28190a.commit();
        }

        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            this.f28190a.putString(SecurePreferencesOld.i(str), SecurePreferencesOld.i(Boolean.toString(z)));
            return this;
        }

        public SharedPreferences.Editor putFloat(String str, float f2) {
            this.f28190a.putString(SecurePreferencesOld.i(str), SecurePreferencesOld.i(Float.toString(f2)));
            return this;
        }

        public SharedPreferences.Editor putInt(String str, int i2) {
            this.f28190a.putString(SecurePreferencesOld.i(str), SecurePreferencesOld.i(Integer.toString(i2)));
            return this;
        }

        public SharedPreferences.Editor putLong(String str, long j2) {
            this.f28190a.putString(SecurePreferencesOld.i(str), SecurePreferencesOld.i(Long.toString(j2)));
            return this;
        }

        public SharedPreferences.Editor putString(String str, String str2) {
            this.f28190a.putString(SecurePreferencesOld.i(str), SecurePreferencesOld.i(str2));
            return this;
        }

        @TargetApi(11)
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            HashSet hashSet = new HashSet(set.size());
            for (String b2 : set) {
                hashSet.add(SecurePreferencesOld.i(b2));
            }
            this.f28190a.putStringSet(SecurePreferencesOld.i(str), hashSet);
            return this;
        }

        public SharedPreferences.Editor remove(String str) {
            this.f28190a.remove(SecurePreferencesOld.i(str));
            return this;
        }
    }

    public SecurePreferencesOld(Context context) {
        if (f28182g == null) {
            f28182g = PreferenceManager.getDefaultSharedPreferences(context);
        }
        try {
            String j2 = j(context);
            String string = f28182g.getString(j2, (String) null);
            if (string == null) {
                string = k();
                f28182g.edit().putString(j2, string).commit();
            }
            f28183h = e(string);
            f28185j = new HashMap<>(10);
        } catch (Exception e2) {
            if (f28184i) {
                String str = f28186k;
                Log.e(str, "Error init:" + e2.getMessage());
            }
            throw new IllegalStateException(e2);
        }
    }

    private static byte[] e(String str) {
        return Base64.decode(str, 3);
    }

    /* access modifiers changed from: private */
    @Deprecated
    public static String f(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        try {
            Cipher instance = Cipher.getInstance(f28177b, f28178c);
            instance.init(2, new SecretKeySpec(f28183h, f28177b));
            return new String(instance.doFinal(e(str)), "UTF-8");
        } catch (Exception e2) {
            if (f28184i) {
                Log.w(f28186k, "decrypt", e2);
            }
            return null;
        }
    }

    private static String h(byte[] bArr) {
        return Base64.encodeToString(bArr, 3);
    }

    /* access modifiers changed from: private */
    @Deprecated
    public static String i(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        try {
            Cipher instance = Cipher.getInstance(f28177b, f28178c);
            instance.init(1, new SecretKeySpec(f28183h, f28177b));
            return h(instance.doFinal(str.getBytes("UTF-8")));
        } catch (Exception e2) {
            if (f28184i) {
                Log.w(f28186k, "encrypt", e2);
            }
            return null;
        }
    }

    private static String j(Context context) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchProviderException {
        SecretKey secretKey;
        char[] charArray = context.getPackageName().toCharArray();
        byte[] bytes = m(context).getBytes();
        try {
            secretKey = l(charArray, bytes, f28179d, 2000, 256);
        } catch (NoSuchAlgorithmException unused) {
            secretKey = l(charArray, bytes, f28180e, 2000, 256);
        }
        return h(secretKey.getEncoded());
    }

    @Deprecated
    private static String k() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = new SecureRandom();
        KeyGenerator instance = KeyGenerator.getInstance(f28177b);
        try {
            instance.init(256, secureRandom);
        } catch (Exception unused) {
            try {
                instance.init(PsExtractor.x, secureRandom);
            } catch (Exception unused2) {
                instance.init(128, secureRandom);
            }
        }
        return h(instance.generateKey().getEncoded());
    }

    @Deprecated
    private static SecretKey l(char[] cArr, byte[] bArr, String str, int i2, int i3) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchProviderException {
        if (i2 == 0) {
            i2 = 1000;
        }
        return SecretKeyFactory.getInstance(str, f28178c).generateSecret(new PBEKeySpec(cArr, bArr, i2, i3));
    }

    private static String m(Context context) {
        try {
            String str = (String) Build.class.getField("SERIAL").get((Object) null);
            return TextUtils.isEmpty(str) ? Settings.Secure.getString(context.getContentResolver(), "android_id") : str;
        } catch (Exception unused) {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        }
    }

    public static boolean o() {
        return f28184i;
    }

    public static void q(boolean z) {
        f28184i = z;
    }

    public boolean contains(String str) {
        return f28182g.contains(i(str));
    }

    /* renamed from: g */
    public Editor edit() {
        return new Editor();
    }

    public Map<String, String> getAll() {
        Map<String, ?> all = f28182g.getAll();
        HashMap hashMap = new HashMap(all.size());
        for (Map.Entry next : all.entrySet()) {
            try {
                hashMap.put(f((String) next.getKey()), f(next.getValue().toString()));
            } catch (Exception unused) {
            }
        }
        return hashMap;
    }

    public boolean getBoolean(String str, boolean z) {
        String string = f28182g.getString(i(str), (String) null);
        if (string == null) {
            return z;
        }
        try {
            return Boolean.parseBoolean(f(string));
        } catch (NumberFormatException e2) {
            throw new ClassCastException(e2.getMessage());
        }
    }

    public float getFloat(String str, float f2) {
        String string = f28182g.getString(i(str), (String) null);
        if (string == null) {
            return f2;
        }
        try {
            return Float.parseFloat(f(string));
        } catch (NumberFormatException e2) {
            throw new ClassCastException(e2.getMessage());
        }
    }

    public int getInt(String str, int i2) {
        String string = f28182g.getString(i(str), (String) null);
        if (string == null) {
            return i2;
        }
        try {
            return Integer.parseInt(f(string));
        } catch (NumberFormatException e2) {
            throw new ClassCastException(e2.getMessage());
        }
    }

    public long getLong(String str, long j2) {
        String string = f28182g.getString(i(str), (String) null);
        if (string == null) {
            return j2;
        }
        try {
            return Long.parseLong(f(string));
        } catch (NumberFormatException e2) {
            throw new ClassCastException(e2.getMessage());
        }
    }

    public String getString(String str, String str2) {
        String string = f28182g.getString(i(str), (String) null);
        return string != null ? f(string) : str2;
    }

    @TargetApi(11)
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> stringSet = f28182g.getStringSet(i(str), (Set) null);
        if (stringSet == null) {
            return set;
        }
        HashSet hashSet = new HashSet(stringSet.size());
        for (String f2 : stringSet) {
            hashSet.add(f(f2));
        }
        return hashSet;
    }

    public String n(String str, String str2) {
        String string = f28182g.getString(i(str), (String) null);
        return string != null ? string : str2;
    }

    public void p(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener, boolean z) {
        if (!z) {
            registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            return;
        }
        AnonymousClass1 r3 = new SharedPreferences.OnSharedPreferenceChangeListener(onSharedPreferenceChangeListener) {

            /* renamed from: a  reason: collision with root package name */
            private SharedPreferences.OnSharedPreferenceChangeListener f28187a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ SharedPreferences.OnSharedPreferenceChangeListener f28188b;

            {
                this.f28188b = r2;
                this.f28187a = r2;
            }

            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                try {
                    String c2 = SecurePreferencesOld.f(str);
                    if (c2 != null) {
                        this.f28187a.onSharedPreferenceChanged(sharedPreferences, c2);
                    }
                } catch (Exception unused) {
                    String d2 = SecurePreferencesOld.f28186k;
                    Log.w(d2, "Unable to decrypt key: " + str);
                }
            }
        };
        f28185j.put(onSharedPreferenceChangeListener, r3);
        f28182g.registerOnSharedPreferenceChangeListener(r3);
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        f28182g.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (f28185j.containsKey(onSharedPreferenceChangeListener)) {
            onSharedPreferenceChangeListener = f28185j.remove(onSharedPreferenceChangeListener);
        }
        f28182g.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
