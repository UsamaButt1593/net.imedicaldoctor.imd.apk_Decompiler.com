package com.google.firebase.installations.local;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.stats.CodePackage;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;
import com.itextpdf.text.pdf.security.SecurityConstants;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

public class IidStore {

    /* renamed from: c  reason: collision with root package name */
    private static final String f24550c = "com.google.android.gms.appid";

    /* renamed from: d  reason: collision with root package name */
    private static final String f24551d = "|S||P|";

    /* renamed from: e  reason: collision with root package name */
    private static final String f24552e = "|S|id";

    /* renamed from: f  reason: collision with root package name */
    private static final String f24553f = "|T|";

    /* renamed from: g  reason: collision with root package name */
    private static final String f24554g = "|";

    /* renamed from: h  reason: collision with root package name */
    private static final String f24555h = "token";

    /* renamed from: i  reason: collision with root package name */
    private static final String f24556i = "{";

    /* renamed from: j  reason: collision with root package name */
    private static final String[] f24557j = {"*", FirebaseMessaging.q, CodePackage.p, ""};
    @GuardedBy("iidPrefs")

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f24558a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24559b;

    @VisibleForTesting
    public IidStore(@NonNull SharedPreferences sharedPreferences, @Nullable String str) {
        this.f24558a = sharedPreferences;
        this.f24559b = str;
    }

    private String a(@NonNull String str, @NonNull String str2) {
        return f24553f + str + f24554g + str2;
    }

    private static String b(FirebaseApp firebaseApp) {
        String m2 = firebaseApp.s().m();
        if (m2 != null) {
            return m2;
        }
        String j2 = firebaseApp.s().j();
        if (!j2.startsWith("1:") && !j2.startsWith("2:")) {
            return j2;
        }
        String[] split = j2.split(":");
        if (split.length != 4) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    @Nullable
    private static String c(@NonNull PublicKey publicKey) {
        try {
            byte[] digest = MessageDigest.getInstance(SecurityConstants.o).digest(publicKey.getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + 112) & 255);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            Log.w("ContentValues", "Unexpected error, device missing required algorithms");
            return null;
        }
    }

    private String d(String str) {
        try {
            return new JSONObject(str).getString(f24555h);
        } catch (JSONException unused) {
            return null;
        }
    }

    @Nullable
    private PublicKey e(String str) {
        try {
            return KeyFactory.getInstance(SecurityConstants.f27341n).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 8)));
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException e2) {
            Log.w("ContentValues", "Invalid key stored " + e2);
            return null;
        }
    }

    @Nullable
    private String g() {
        String string;
        synchronized (this.f24558a) {
            string = this.f24558a.getString(f24552e, (String) null);
        }
        return string;
    }

    @Nullable
    private String h() {
        synchronized (this.f24558a) {
            try {
                String string = this.f24558a.getString(f24551d, (String) null);
                if (string == null) {
                    return null;
                }
                PublicKey e2 = e(string);
                if (e2 == null) {
                    return null;
                }
                String c2 = c(e2);
                return c2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public String f() {
        synchronized (this.f24558a) {
            try {
                String g2 = g();
                if (g2 != null) {
                    return g2;
                }
                String h2 = h();
                return h2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0030, code lost:
        return r4;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String i() {
        /*
            r7 = this;
            android.content.SharedPreferences r0 = r7.f24558a
            monitor-enter(r0)
            java.lang.String[] r1 = f24557j     // Catch:{ all -> 0x002d }
            int r2 = r1.length     // Catch:{ all -> 0x002d }
            r3 = 0
        L_0x0007:
            r4 = 0
            if (r3 >= r2) goto L_0x0034
            r5 = r1[r3]     // Catch:{ all -> 0x002d }
            java.lang.String r6 = r7.f24559b     // Catch:{ all -> 0x002d }
            java.lang.String r5 = r7.a(r6, r5)     // Catch:{ all -> 0x002d }
            android.content.SharedPreferences r6 = r7.f24558a     // Catch:{ all -> 0x002d }
            java.lang.String r4 = r6.getString(r5, r4)     // Catch:{ all -> 0x002d }
            if (r4 == 0) goto L_0x0031
            boolean r5 = r4.isEmpty()     // Catch:{ all -> 0x002d }
            if (r5 != 0) goto L_0x0031
            java.lang.String r1 = "{"
            boolean r1 = r4.startsWith(r1)     // Catch:{ all -> 0x002d }
            if (r1 == 0) goto L_0x002f
            java.lang.String r4 = r7.d(r4)     // Catch:{ all -> 0x002d }
            goto L_0x002f
        L_0x002d:
            r1 = move-exception
            goto L_0x0036
        L_0x002f:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return r4
        L_0x0031:
            int r3 = r3 + 1
            goto L_0x0007
        L_0x0034:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return r4
        L_0x0036:
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.local.IidStore.i():java.lang.String");
    }

    public IidStore(@NonNull FirebaseApp firebaseApp) {
        this.f24558a = firebaseApp.n().getSharedPreferences(f24550c, 0);
        this.f24559b = b(firebaseApp);
    }
}
