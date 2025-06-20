package net.imedicaldoctor.imd;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatDelegate;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import net.imedicaldoctor.imd.Data.CompressHelper;
import net.imedicaldoctor.imd.Fragments.downloadFragment;

public class iMD extends Application {
    private static Application f3;
    public LocalServer X;
    public String X2;
    public HashSet<String> Y;
    public int Y2;
    public String Z;
    public int Z2;
    public CompressHelper a3;
    public VBHelper b3;
    public downloadFragment c3;
    private Timer d3;
    public Handler e3 = new Handler() {
        public void handleMessage(Message message) {
            iMD.this.b();
        }
    };
    public ArrayList<Bundle> s;

    public static boolean a() {
        return false;
    }

    public static Application c() {
        return f3;
    }

    public static Context d() {
        return c().getApplicationContext();
    }

    private void g() {
        try {
            Locale locale = new Locale("en");
            Locale.setDefault(locale);
            Configuration configuration = new Configuration();
            configuration.locale = locale;
            if (Build.VERSION.SDK_INT >= 24) {
                configuration.setLocale(locale);
            } else {
                configuration.locale = locale;
            }
            getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:1|2|(1:4)|7|(1:9)|10|11|12|13|14) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r4 = this;
            java.lang.String r0 = "iMD"
            java.lang.String r1 = "Checking Activation Code"
            net.imedicaldoctor.imd.iMDLogger.j(r0, r1)     // Catch:{ Exception -> 0x0013 }
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r4.a3     // Catch:{ Exception -> 0x0013 }
            if (r0 != 0) goto L_0x0015
            net.imedicaldoctor.imd.Data.CompressHelper r0 = new net.imedicaldoctor.imd.Data.CompressHelper     // Catch:{ Exception -> 0x0013 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x0013 }
            r4.a3 = r0     // Catch:{ Exception -> 0x0013 }
            goto L_0x0015
        L_0x0013:
            r0 = move-exception
            goto L_0x0077
        L_0x0015:
            net.imedicaldoctor.imd.VBHelper r0 = r4.b3     // Catch:{ Exception -> 0x0013 }
            if (r0 != 0) goto L_0x0020
            net.imedicaldoctor.imd.VBHelper r0 = new net.imedicaldoctor.imd.VBHelper     // Catch:{ Exception -> 0x0013 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x0013 }
            r4.b3 = r0     // Catch:{ Exception -> 0x0013 }
        L_0x0020:
            r0 = 0
            android.content.pm.PackageManager r1 = r4.getPackageManager()     // Catch:{ Exception -> 0x002f }
            java.lang.String r2 = r4.getPackageName()     // Catch:{ Exception -> 0x002f }
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r2, r0)     // Catch:{ Exception -> 0x002f }
            int r0 = r1.versionCode     // Catch:{ Exception -> 0x002f }
        L_0x002f:
            net.imedicaldoctor.imd.Data.CompressHelper r1 = r4.a3     // Catch:{ Exception -> 0x0013 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0013 }
            r2.<init>()     // Catch:{ Exception -> 0x0013 }
            java.lang.String r3 = "ActivationCode|||||"
            r2.append(r3)     // Catch:{ Exception -> 0x0013 }
            net.imedicaldoctor.imd.VBHelper r3 = r4.b3     // Catch:{ Exception -> 0x0013 }
            java.lang.String r3 = r3.m()     // Catch:{ Exception -> 0x0013 }
            r2.append(r3)     // Catch:{ Exception -> 0x0013 }
            java.lang.String r3 = "|||||android-"
            r2.append(r3)     // Catch:{ Exception -> 0x0013 }
            r2.append(r0)     // Catch:{ Exception -> 0x0013 }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0013 }
            io.reactivex.rxjava3.core.Observable r0 = r1.o0(r0)     // Catch:{ Exception -> 0x0013 }
            io.reactivex.rxjava3.core.Scheduler r1 = io.reactivex.rxjava3.schedulers.Schedulers.e()     // Catch:{ Exception -> 0x0013 }
            io.reactivex.rxjava3.core.Observable r0 = r0.h6(r1)     // Catch:{ Exception -> 0x0013 }
            io.reactivex.rxjava3.core.Scheduler r1 = io.reactivex.rxjava3.android.schedulers.AndroidSchedulers.e()     // Catch:{ Exception -> 0x0013 }
            io.reactivex.rxjava3.core.Observable r0 = r0.s4(r1)     // Catch:{ Exception -> 0x0013 }
            net.imedicaldoctor.imd.iMD$2 r1 = new net.imedicaldoctor.imd.iMD$2     // Catch:{ Exception -> 0x0013 }
            r1.<init>()     // Catch:{ Exception -> 0x0013 }
            net.imedicaldoctor.imd.iMD$3 r2 = new net.imedicaldoctor.imd.iMD$3     // Catch:{ Exception -> 0x0013 }
            r2.<init>()     // Catch:{ Exception -> 0x0013 }
            net.imedicaldoctor.imd.iMD$4 r3 = new net.imedicaldoctor.imd.iMD$4     // Catch:{ Exception -> 0x0013 }
            r3.<init>()     // Catch:{ Exception -> 0x0013 }
            r0.f6(r1, r2, r3)     // Catch:{ Exception -> 0x0013 }
            goto L_0x007e
        L_0x0077:
            com.google.firebase.crashlytics.FirebaseCrashlytics r1 = com.google.firebase.crashlytics.FirebaseCrashlytics.d()
            r1.g(r0)
        L_0x007e:
            net.imedicaldoctor.imd.Data.CompressHelper r0 = r4.a3
            r0.V0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.iMD.b():void");
    }

    public Bundle e(ArrayList<Bundle> arrayList) {
        try {
            return arrayList.get(new Random().nextInt(arrayList.size()));
        } catch (Exception e2) {
            FirebaseCrashlytics.d().g(e2);
            return null;
        }
    }

    public boolean f(String str) {
        String string = getSharedPreferences("default_preferences", 0).getString("ActivationCode", "");
        VBHelper vBHelper = this.b3;
        String[] split = TextUtils.split(vBHelper.decryptString(string, vBHelper.m()).replace("||", "::"), "::");
        VBHelper vBHelper2 = this.b3;
        String[] split2 = TextUtils.split(vBHelper2.decryptString(str, vBHelper2.m()).replace("||", "::"), "::");
        int[] iArr = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = iArr[i2];
            if (!split[i3].equals(split2[i3])) {
                return true;
            }
        }
        return false;
    }

    public void onCreate() {
        try {
            if (d().getSharedPreferences("default_preferences", 0).getBoolean("dark", false)) {
                AppCompatDelegate.c0(2);
            } else {
                AppCompatDelegate.c0(1);
            }
        } catch (Exception unused) {
        }
        if (a()) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().detectCustomSlowCalls().penaltyLog().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog().build());
        }
        super.onCreate();
        FirebaseCrashlytics.d().c();
        Timer timer = new Timer();
        this.d3 = timer;
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                iMD.this.e3.obtainMessage(1).sendToTarget();
            }
        }, 30000, 600000);
        g();
        f3 = this;
    }
}
