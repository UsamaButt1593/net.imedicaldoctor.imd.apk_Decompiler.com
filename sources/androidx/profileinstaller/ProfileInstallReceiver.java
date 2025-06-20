package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.media3.exoplayer.dash.offline.a;
import androidx.profileinstaller.ProfileInstaller;

public class ProfileInstallReceiver extends BroadcastReceiver {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public static final String f15086a = "androidx.profileinstaller.action.INSTALL_PROFILE";
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public static final String f15087b = "androidx.profileinstaller.action.SAVE_PROFILE";
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public static final String f15088c = "androidx.profileinstaller.action.SKIP_FILE";
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public static final String f15089d = "androidx.profileinstaller.action.BENCHMARK_OPERATION";
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private static final String f15090e = "EXTRA_SKIP_FILE_OPERATION";
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private static final String f15091f = "WRITE_SKIP_FILE";
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private static final String f15092g = "DELETE_SKIP_FILE";
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private static final String f15093h = "EXTRA_BENCHMARK_OPERATION";
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private static final String f15094i = "DROP_SHADER_CACHE";

    class ResultDiagnostics implements ProfileInstaller.DiagnosticsCallback {
        ResultDiagnostics() {
        }

        public void a(int i2, @Nullable Object obj) {
            ProfileInstaller.f15103h.a(i2, obj);
        }

        public void b(int i2, @Nullable Object obj) {
            ProfileInstaller.f15103h.b(i2, obj);
            ProfileInstallReceiver.this.setResultCode(i2);
        }
    }

    static void a(@NonNull ProfileInstaller.DiagnosticsCallback diagnosticsCallback) {
        int i2;
        if (Build.VERSION.SDK_INT >= 24) {
            Process.sendSignal(Process.myPid(), 10);
            i2 = 12;
        } else {
            i2 = 13;
        }
        diagnosticsCallback.b(i2, (Object) null);
    }

    public void onReceive(@NonNull Context context, @Nullable Intent intent) {
        Bundle extras;
        if (intent != null) {
            String action = intent.getAction();
            if (f15086a.equals(action)) {
                ProfileInstaller.n(context, new a(), new ResultDiagnostics(), true);
            } else if (f15088c.equals(action)) {
                Bundle extras2 = intent.getExtras();
                if (extras2 != null) {
                    String string = extras2.getString(f15090e);
                    if (f15091f.equals(string)) {
                        ProfileInstaller.o(context, new a(), new ResultDiagnostics());
                    } else if (f15092g.equals(string)) {
                        ProfileInstaller.d(context, new a(), new ResultDiagnostics());
                    }
                }
            } else if (f15087b.equals(action)) {
                a(new ResultDiagnostics());
            } else if (f15089d.equals(action) && (extras = intent.getExtras()) != null) {
                String string2 = extras.getString(f15093h);
                ResultDiagnostics resultDiagnostics = new ResultDiagnostics();
                if (f15094i.equals(string2)) {
                    BenchmarkOperation.b(context, resultDiagnostics);
                } else {
                    resultDiagnostics.b(16, (Object) null);
                }
            }
        }
    }
}
