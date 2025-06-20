package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.errorprone.annotations.CheckReturnValue;
import java.security.MessageDigest;

@CheckReturnValue
final class zzn {

    /* renamed from: a  reason: collision with root package name */
    static final zzl f20426a = new zzf(zzj.f("0\u0005È0\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010e\bsù/Qí"));

    /* renamed from: b  reason: collision with root package name */
    static final zzl f20427b = new zzg(zzj.f("0\u0006\u00040\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²­×árÊkì"));

    /* renamed from: c  reason: collision with root package name */
    static final zzl f20428c = new zzh(zzj.f("0\u0004C0\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000ÂàFdJ00"));

    /* renamed from: d  reason: collision with root package name */
    static final zzl f20429d = new zzi(zzj.f("0\u0004¨0\u0003 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ¸l}ÓNõ0"));

    /* renamed from: e  reason: collision with root package name */
    private static volatile zzag f20430e;

    /* renamed from: f  reason: collision with root package name */
    private static final Object f20431f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static Context f20432g;

    static zzx a(String str, zzj zzj, boolean z, boolean z2) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return h(str, zzj, z, z2);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    static zzx b(String str, boolean z, boolean z2, boolean z3) {
        return i(str, z, false, false, true);
    }

    static zzx c(String str, boolean z, boolean z2, boolean z3) {
        return i(str, z, false, false, false);
    }

    static /* synthetic */ String d(boolean z, String str, zzj zzj) throws Exception {
        String str2 = (z || !h(str, zzj, true, false).f20435a) ? "not allowed" : "debug cert rejected";
        MessageDigest b2 = AndroidUtilsLight.b("SHA-256");
        Preconditions.r(b2);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", new Object[]{str2, str, Hex.a(b2.digest(zzj.z())), Boolean.valueOf(z), "12451000.false"});
    }

    static synchronized void e(Context context) {
        synchronized (zzn.class) {
            if (f20432g != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                f20432g = context.getApplicationContext();
            }
        }
    }

    static boolean f() {
        boolean z;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            j();
            z = f20430e.c();
        } catch (RemoteException | DynamiteModule.LoadingException e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            z = false;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return z;
    }

    static boolean g() {
        boolean z;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            j();
            z = f20430e.a();
        } catch (RemoteException | DynamiteModule.LoadingException e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            z = false;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return z;
    }

    private static zzx h(String str, zzj zzj, boolean z, boolean z2) {
        try {
            j();
            Preconditions.r(f20432g);
            try {
                return f20430e.F(new zzs(str, zzj, z, z2), ObjectWrapper.z(f20432g.getPackageManager())) ? zzx.b() : new zzv(new zze(z, str, zzj), (zzu) null);
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                return zzx.d("module call", e2);
            }
        } catch (DynamiteModule.LoadingException e3) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
            return zzx.d("module init: ".concat(String.valueOf(e3.getMessage())), e3);
        }
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [com.google.android.gms.dynamic.IObjectWrapper, android.os.IBinder] */
    private static zzx i(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        zzx zzx;
        String str2;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            Preconditions.r(f20432g);
            try {
                j();
                zzo zzo = new zzo(str, z, false, ObjectWrapper.z(f20432g), false, true);
                zzq t0 = z4 ? f20430e.t0(zzo) : f20430e.B0(zzo);
                if (t0.H()) {
                    zzx = zzx.f(t0.I());
                } else {
                    String C = t0.C();
                    PackageManager.NameNotFoundException nameNotFoundException = t0.N() == 4 ? new PackageManager.NameNotFoundException() : null;
                    if (C == null) {
                        C = "error checking package certificate";
                    }
                    zzx = zzx.g(t0.I(), t0.N(), C, nameNotFoundException);
                }
            } catch (DynamiteModule.LoadingException e2) {
                e = e2;
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                str2 = "module init: ".concat(String.valueOf(e.getMessage()));
                zzx = zzx.d(str2, e);
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return zzx;
            }
        } catch (RemoteException e3) {
            e = e3;
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            str2 = "module call";
            zzx = zzx.d(str2, e);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return zzx;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return zzx;
    }

    private static void j() throws DynamiteModule.LoadingException {
        if (f20430e == null) {
            Preconditions.r(f20432g);
            synchronized (f20431f) {
                try {
                    if (f20430e == null) {
                        f20430e = zzaf.e(DynamiteModule.e(f20432g, DynamiteModule.f20474j, "com.google.android.gms.googlecertificates").d("com.google.android.gms.common.GoogleCertificatesImpl"));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
