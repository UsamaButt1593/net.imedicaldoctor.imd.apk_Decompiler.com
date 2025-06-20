package androidx.core.content;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;

public abstract class UnusedAppRestrictionsBackportService extends Service {
    @SuppressLint({"ActionValue"})
    public static final String X = "android.support.unusedapprestrictions.action.CustomUnusedAppRestrictionsBackportService";
    private IUnusedAppRestrictionsBackportService.Stub s = new IUnusedAppRestrictionsBackportService.Stub() {
        public void e0(@Nullable IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) throws RemoteException {
            if (iUnusedAppRestrictionsBackportCallback != null) {
                UnusedAppRestrictionsBackportService.this.a(new UnusedAppRestrictionsBackportCallback(iUnusedAppRestrictionsBackportCallback));
            }
        }
    };

    /* access modifiers changed from: protected */
    public abstract void a(@NonNull UnusedAppRestrictionsBackportCallback unusedAppRestrictionsBackportCallback);

    @Nullable
    public IBinder onBind(@Nullable Intent intent) {
        return this.s;
    }
}
