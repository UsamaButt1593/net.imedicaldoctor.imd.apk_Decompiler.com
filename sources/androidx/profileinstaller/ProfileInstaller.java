package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.media3.exoplayer.dash.offline.a;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

public class ProfileInstaller {
    public static final int A = 14;
    public static final int B = 15;
    public static final int C = 16;

    /* renamed from: a  reason: collision with root package name */
    private static final String f15096a = "ProfileInstaller";

    /* renamed from: b  reason: collision with root package name */
    private static final String f15097b = "/data/misc/profiles/cur/0";

    /* renamed from: c  reason: collision with root package name */
    private static final String f15098c = "primary.prof";

    /* renamed from: d  reason: collision with root package name */
    private static final String f15099d = "dexopt/baseline.prof";

    /* renamed from: e  reason: collision with root package name */
    private static final String f15100e = "dexopt/baseline.profm";

    /* renamed from: f  reason: collision with root package name */
    private static final String f15101f = "profileinstaller_profileWrittenFor_lastUpdateTime.dat";

    /* renamed from: g  reason: collision with root package name */
    private static final DiagnosticsCallback f15102g = new DiagnosticsCallback() {
        public void a(int i2, @Nullable Object obj) {
        }

        public void b(int i2, @Nullable Object obj) {
        }
    };
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    static final DiagnosticsCallback f15103h = new DiagnosticsCallback() {

        /* renamed from: a  reason: collision with root package name */
        static final String f15110a = "ProfileInstaller";

        public void a(int i2, @Nullable Object obj) {
            Log.d(f15110a, i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "" : "DIAGNOSTIC_PROFILE_IS_COMPRESSED" : "DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST" : "DIAGNOSTIC_REF_PROFILE_EXISTS" : "DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST" : "DIAGNOSTIC_CURRENT_PROFILE_EXISTS");
        }

        public void b(int i2, @Nullable Object obj) {
            String str;
            switch (i2) {
                case 1:
                    str = "RESULT_INSTALL_SUCCESS";
                    break;
                case 2:
                    str = "RESULT_ALREADY_INSTALLED";
                    break;
                case 3:
                    str = "RESULT_UNSUPPORTED_ART_VERSION";
                    break;
                case 4:
                    str = "RESULT_NOT_WRITABLE";
                    break;
                case 5:
                    str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                    break;
                case 6:
                    str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                    break;
                case 7:
                    str = "RESULT_IO_EXCEPTION";
                    break;
                case 8:
                    str = "RESULT_PARSE_EXCEPTION";
                    break;
                case 10:
                    str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                    break;
                case 11:
                    str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                    break;
                default:
                    str = "";
                    break;
            }
            if (i2 == 6 || i2 == 7 || i2 == 8) {
                Log.e(f15110a, str, (Throwable) obj);
            } else {
                Log.d(f15110a, str);
            }
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public static final int f15104i = 1;

    /* renamed from: j  reason: collision with root package name */
    public static final int f15105j = 2;

    /* renamed from: k  reason: collision with root package name */
    public static final int f15106k = 3;

    /* renamed from: l  reason: collision with root package name */
    public static final int f15107l = 4;

    /* renamed from: m  reason: collision with root package name */
    public static final int f15108m = 5;

    /* renamed from: n  reason: collision with root package name */
    public static final int f15109n = 1;
    public static final int o = 2;
    public static final int p = 3;
    public static final int q = 4;
    public static final int r = 5;
    public static final int s = 6;
    public static final int t = 7;
    public static final int u = 8;
    public static final int v = 9;
    public static final int w = 10;
    public static final int x = 11;
    public static final int y = 12;
    public static final int z = 13;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DiagnosticCode {
    }

    public interface DiagnosticsCallback {
        void a(int i2, @Nullable Object obj);

        void b(int i2, @Nullable Object obj);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ResultCode {
    }

    private ProfileInstaller() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static boolean c(@NonNull File file) {
        return new File(file, f15101f).delete();
    }

    @WorkerThread
    static void d(@NonNull Context context, @NonNull Executor executor, @NonNull DiagnosticsCallback diagnosticsCallback) {
        c(context.getFilesDir());
        j(executor, diagnosticsCallback, 11, (Object) null);
    }

    static void e(@NonNull Executor executor, @NonNull DiagnosticsCallback diagnosticsCallback, int i2, @Nullable Object obj) {
        executor.execute(new d(diagnosticsCallback, i2, obj));
    }

    @WorkerThread
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static boolean f(PackageInfo packageInfo, File file, DiagnosticsCallback diagnosticsCallback) {
        DataInputStream dataInputStream;
        File file2 = new File(file, f15101f);
        boolean z2 = false;
        if (!file2.exists()) {
            return false;
        }
        try {
            dataInputStream = new DataInputStream(new FileInputStream(file2));
            long readLong = dataInputStream.readLong();
            dataInputStream.close();
            if (readLong == packageInfo.lastUpdateTime) {
                z2 = true;
            }
            if (z2) {
                diagnosticsCallback.b(2, (Object) null);
            }
            return z2;
        } catch (IOException unused) {
            return false;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static void i(@NonNull PackageInfo packageInfo, @NonNull File file) {
        DataOutputStream dataOutputStream;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, f15101f)));
            dataOutputStream.writeLong(packageInfo.lastUpdateTime);
            dataOutputStream.close();
            return;
        } catch (IOException unused) {
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    static void j(@NonNull Executor executor, @NonNull DiagnosticsCallback diagnosticsCallback, int i2, @Nullable Object obj) {
        executor.execute(new c(diagnosticsCallback, i2, obj));
    }

    private static boolean k(@NonNull AssetManager assetManager, @NonNull String str, @NonNull PackageInfo packageInfo, @NonNull File file, @NonNull String str2, @NonNull Executor executor, @NonNull DiagnosticsCallback diagnosticsCallback) {
        DeviceProfileWriter deviceProfileWriter = new DeviceProfileWriter(assetManager, executor, diagnosticsCallback, str2, f15099d, f15100e, new File(new File(f15097b, str), f15098c));
        if (!deviceProfileWriter.e()) {
            return false;
        }
        boolean n2 = deviceProfileWriter.i().m().n();
        if (n2) {
            i(packageInfo, file);
        }
        return n2;
    }

    @WorkerThread
    public static void l(@NonNull Context context) {
        m(context, new a(), f15102g);
    }

    @WorkerThread
    public static void m(@NonNull Context context, @NonNull Executor executor, @NonNull DiagnosticsCallback diagnosticsCallback) {
        n(context, executor, diagnosticsCallback, false);
    }

    @WorkerThread
    static void n(@NonNull Context context, @NonNull Executor executor, @NonNull DiagnosticsCallback diagnosticsCallback, boolean z2) {
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        boolean z3 = false;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (z2 || !f(packageInfo, filesDir, diagnosticsCallback)) {
                Log.d(f15096a, "Installing profile for " + context.getPackageName());
                if (k(assets, packageName, packageInfo, filesDir, name, executor, diagnosticsCallback) && z2) {
                    z3 = true;
                }
            } else {
                Log.d(f15096a, "Skipping profile installation for " + context.getPackageName());
            }
            ProfileVerifier.e(context, z3);
        } catch (PackageManager.NameNotFoundException e2) {
            diagnosticsCallback.b(7, e2);
            ProfileVerifier.e(context, false);
        }
    }

    @WorkerThread
    static void o(@NonNull Context context, @NonNull Executor executor, @NonNull DiagnosticsCallback diagnosticsCallback) {
        try {
            i(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
            j(executor, diagnosticsCallback, 10, (Object) null);
        } catch (PackageManager.NameNotFoundException e2) {
            j(executor, diagnosticsCallback, 7, e2);
        }
    }
}
