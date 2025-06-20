package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.InstallIdProvider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

public class IdManager implements InstallIdProvider {

    /* renamed from: g  reason: collision with root package name */
    public static final String f23655g = "0.0";

    /* renamed from: h  reason: collision with root package name */
    static final String f23656h = "crashlytics.advertising.id";

    /* renamed from: i  reason: collision with root package name */
    static final String f23657i = "crashlytics.installation.id";

    /* renamed from: j  reason: collision with root package name */
    static final String f23658j = "firebase.installation.id";

    /* renamed from: k  reason: collision with root package name */
    static final String f23659k = "crashlytics.installation.id";

    /* renamed from: l  reason: collision with root package name */
    private static final Pattern f23660l = Pattern.compile("[^\\p{Alnum}]");

    /* renamed from: m  reason: collision with root package name */
    private static final String f23661m = "SYN_";

    /* renamed from: n  reason: collision with root package name */
    private static final String f23662n = Pattern.quote("/");

    /* renamed from: a  reason: collision with root package name */
    private final InstallerPackageNameProvider f23663a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f23664b;

    /* renamed from: c  reason: collision with root package name */
    private final String f23665c;

    /* renamed from: d  reason: collision with root package name */
    private final FirebaseInstallationsApi f23666d;

    /* renamed from: e  reason: collision with root package name */
    private final DataCollectionArbiter f23667e;

    /* renamed from: f  reason: collision with root package name */
    private InstallIdProvider.InstallIds f23668f;

    public IdManager(Context context, String str, FirebaseInstallationsApi firebaseInstallationsApi, DataCollectionArbiter dataCollectionArbiter) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        } else if (str != null) {
            this.f23664b = context;
            this.f23665c = str;
            this.f23666d = firebaseInstallationsApi;
            this.f23667e = dataCollectionArbiter;
            this.f23663a = new InstallerPackageNameProvider();
        } else {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
    }

    @NonNull
    private synchronized String b(String str, SharedPreferences sharedPreferences) {
        String e2;
        e2 = e(UUID.randomUUID().toString());
        Logger f2 = Logger.f();
        f2.k("Created new Crashlytics installation ID: " + e2 + " for FID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", e2).putString(f23658j, str).apply();
        return e2;
    }

    static String c() {
        return f23661m + UUID.randomUUID().toString();
    }

    @NonNull
    private static String e(@NonNull String str) {
        return f23660l.matcher(str).replaceAll("").toLowerCase(Locale.US);
    }

    static boolean k(String str) {
        return str != null && str.startsWith(f23661m);
    }

    private String l(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("crashlytics.installation.id", (String) null);
    }

    private String m(String str) {
        return str.replaceAll(f23662n, "");
    }

    private boolean n() {
        InstallIdProvider.InstallIds installIds = this.f23668f;
        return installIds == null || (installIds.e() == null && this.f23667e.d());
    }

    @NonNull
    public synchronized InstallIdProvider.InstallIds a() {
        InstallIdProvider.InstallIds b2;
        if (!n()) {
            return this.f23668f;
        }
        Logger.f().k("Determining Crashlytics installation ID...");
        SharedPreferences r = CommonUtils.r(this.f23664b);
        String string = r.getString(f23658j, (String) null);
        Logger f2 = Logger.f();
        f2.k("Cached Firebase Installation ID: " + string);
        if (this.f23667e.d()) {
            FirebaseInstallationId d2 = d(false);
            Logger f3 = Logger.f();
            f3.k("Fetched Firebase Installation ID: " + d2.f());
            if (d2.f() == null) {
                d2 = new FirebaseInstallationId(string == null ? c() : string, (String) null);
            }
            b2 = Objects.equals(d2.f(), string) ? InstallIdProvider.InstallIds.a(l(r), d2) : InstallIdProvider.InstallIds.a(b(d2.f(), r), d2);
        } else {
            b2 = k(string) ? InstallIdProvider.InstallIds.b(l(r)) : InstallIdProvider.InstallIds.b(b(c(), r));
        }
        this.f23668f = b2;
        Logger f4 = Logger.f();
        f4.k("Install IDs: " + this.f23668f);
        return this.f23668f;
    }

    @NonNull
    public FirebaseInstallationId d(boolean z) {
        String str;
        String str2 = null;
        if (z) {
            try {
                str = ((InstallationTokenResult) Utils.f(this.f23666d.c(false))).b();
            } catch (Exception e2) {
                Logger.f().n("Error getting Firebase authentication token.", e2);
            }
            str2 = (String) Utils.f(this.f23666d.getId());
            return new FirebaseInstallationId(str2, str);
        }
        str = null;
        try {
            str2 = (String) Utils.f(this.f23666d.getId());
        } catch (Exception e3) {
            Logger.f().n("Error getting Firebase installation id.", e3);
        }
        return new FirebaseInstallationId(str2, str);
    }

    public String f() {
        return this.f23665c;
    }

    public String g() {
        return this.f23663a.a(this.f23664b);
    }

    public String h() {
        return String.format(Locale.US, "%s/%s", new Object[]{m(Build.MANUFACTURER), m(Build.MODEL)});
    }

    public String i() {
        return m(Build.VERSION.INCREMENTAL);
    }

    public String j() {
        return m(Build.VERSION.RELEASE);
    }
}
