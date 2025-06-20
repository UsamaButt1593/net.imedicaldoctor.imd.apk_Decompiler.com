package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.io.File;

class BenchmarkOperation {

    @RequiresApi(api = 21)
    private static class Api21ContextHelper {
        private Api21ContextHelper() {
        }

        static File a(Context context) {
            return context.getCodeCacheDir();
        }
    }

    @RequiresApi(api = 24)
    private static class Api24ContextHelper {
        private Api24ContextHelper() {
        }

        static File a(Context context) {
            return context.createDeviceProtectedStorageContext().getCodeCacheDir();
        }
    }

    private BenchmarkOperation() {
    }

    static boolean a(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return false;
            }
            int length = listFiles.length;
            boolean z = true;
            for (int i2 = 0; i2 < length; i2++) {
                z = a(listFiles[i2]) && z;
            }
            return z;
        }
        file.delete();
        return true;
    }

    static void b(@NonNull Context context, @NonNull ProfileInstallReceiver.ResultDiagnostics resultDiagnostics) {
        int i2 = Build.VERSION.SDK_INT;
        resultDiagnostics.b(a(i2 >= 24 ? Api24ContextHelper.a(context) : i2 >= 23 ? Api21ContextHelper.a(context) : context.getCacheDir()) ? 14 : 15, (Object) null);
    }
}
