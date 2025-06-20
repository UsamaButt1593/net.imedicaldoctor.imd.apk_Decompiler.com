package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamite.DynamiteModule;
import java.lang.reflect.Method;

public class ProviderInstaller {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public static final String f20487a = "GmsCore_OpenSSL";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final GoogleApiAvailabilityLight f20488b = GoogleApiAvailabilityLight.i();

    /* renamed from: c  reason: collision with root package name */
    private static final Object f20489c = new Object();
    @GuardedBy("ProviderInstaller.lock")

    /* renamed from: d  reason: collision with root package name */
    private static Method f20490d = null;
    @GuardedBy("ProviderInstaller.lock")

    /* renamed from: e  reason: collision with root package name */
    private static Method f20491e = null;

    public interface ProviderInstallListener {
        void a();

        void b(int i2, @Nullable Intent intent);
    }

    public static void a(@NonNull Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        Context context2;
        Preconditions.s(context, "Context must not be null");
        f20488b.p(context, 11925000);
        synchronized (f20489c) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                context2 = DynamiteModule.e(context, DynamiteModule.f20474j, "com.google.android.gms.providerinstaller.dynamite").b();
            } catch (DynamiteModule.LoadingException e2) {
                Log.w("ProviderInstaller", "Failed to load providerinstaller module: ".concat(String.valueOf(e2.getMessage())));
                context2 = null;
            }
            if (context2 != null) {
                e(context2, context, "com.google.android.gms.providerinstaller.ProviderInstallerImpl");
                return;
            }
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            Context i2 = GooglePlayServicesUtilLight.i(context);
            if (i2 != null) {
                try {
                    if (f20491e == null) {
                        Class cls = Long.TYPE;
                        f20491e = d(i2, "com.google.android.gms.common.security.ProviderInstallerImpl", "reportRequestStats", new Class[]{Context.class, cls, cls});
                    }
                    f20491e.invoke((Object) null, new Object[]{context, Long.valueOf(elapsedRealtime), Long.valueOf(elapsedRealtime2)});
                } catch (Exception e3) {
                    Log.w("ProviderInstaller", "Failed to report request stats: ".concat(String.valueOf(e3.getMessage())));
                }
            }
            if (i2 != null) {
                e(i2, context, "com.google.android.gms.common.security.ProviderInstallerImpl");
            } else {
                Log.e("ProviderInstaller", "Failed to get remote context");
                throw new GooglePlayServicesNotAvailableException(8);
            }
        }
    }

    public static void b(@NonNull Context context, @NonNull ProviderInstallListener providerInstallListener) {
        Preconditions.s(context, "Context must not be null");
        Preconditions.s(providerInstallListener, "Listener must not be null");
        Preconditions.k("Must be called on the UI thread");
        new zza(context, providerInstallListener).execute(new Void[0]);
    }

    private static Method d(Context context, String str, String str2, Class[] clsArr) throws ClassNotFoundException, NoSuchMethodException {
        return context.getClassLoader().loadClass(str).getMethod(str2, clsArr);
    }

    @GuardedBy("ProviderInstaller.lock")
    private static void e(Context context, Context context2, String str) throws GooglePlayServicesNotAvailableException {
        try {
            if (f20490d == null) {
                f20490d = d(context, str, "insertProvider", new Class[]{Context.class});
            }
            f20490d.invoke((Object) null, new Object[]{context});
        } catch (Exception e2) {
            Throwable cause = e2.getCause();
            if (Log.isLoggable("ProviderInstaller", 6)) {
                Log.e("ProviderInstaller", "Failed to install provider: ".concat(String.valueOf(cause == null ? e2.getMessage() : cause.getMessage())));
            }
            throw new GooglePlayServicesNotAvailableException(8);
        }
    }
}
