package androidx.core.content;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;

class UnusedAppRestrictionsBackportServiceConnection implements ServiceConnection {
    @NonNull
    ResolvableFuture<Integer> X;
    private final Context Y;
    private boolean Z = false;
    @VisibleForTesting
    @Nullable
    IUnusedAppRestrictionsBackportService s = null;

    UnusedAppRestrictionsBackportServiceConnection(@NonNull Context context) {
        this.Y = context;
    }

    private IUnusedAppRestrictionsBackportCallback c() {
        return new IUnusedAppRestrictionsBackportCallback.Stub() {
            public void R0(boolean z, boolean z2) throws RemoteException {
                if (z) {
                    UnusedAppRestrictionsBackportServiceConnection.this.X.q(Integer.valueOf(z2 ? 3 : 2));
                    return;
                }
                UnusedAppRestrictionsBackportServiceConnection.this.X.q(0);
                Log.e(PackageManagerCompat.f5676a, "Unable to retrieve the permission revocation setting from the backport");
            }
        };
    }

    public void a(@NonNull ResolvableFuture<Integer> resolvableFuture) {
        if (!this.Z) {
            this.Z = true;
            this.X = resolvableFuture;
            this.Y.bindService(new Intent(UnusedAppRestrictionsBackportService.X).setPackage(PackageManagerCompat.b(this.Y.getPackageManager())), this, 1);
            return;
        }
        throw new IllegalStateException("Each UnusedAppRestrictionsBackportServiceConnection can only be bound once.");
    }

    public void b() {
        if (this.Z) {
            this.Z = false;
            this.Y.unbindService(this);
            return;
        }
        throw new IllegalStateException("bindService must be called before unbind");
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        IUnusedAppRestrictionsBackportService e2 = IUnusedAppRestrictionsBackportService.Stub.e(iBinder);
        this.s = e2;
        try {
            e2.e0(c());
        } catch (RemoteException unused) {
            this.X.q(0);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.s = null;
    }
}
