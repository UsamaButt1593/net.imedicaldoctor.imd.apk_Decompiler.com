package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@KeepForSdk
public class BlockingServiceConnection implements ServiceConnection {
    private final BlockingQueue X = new LinkedBlockingQueue();
    boolean s = false;

    @ResultIgnorabilityUnspecified
    @NonNull
    @KeepForSdk
    public IBinder a() throws InterruptedException {
        Preconditions.q("BlockingServiceConnection.getService() called on main thread");
        if (!this.s) {
            this.s = true;
            return (IBinder) this.X.take();
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }

    @ResultIgnorabilityUnspecified
    @NonNull
    @KeepForSdk
    public IBinder b(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        Preconditions.q("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (!this.s) {
            this.s = true;
            IBinder iBinder = (IBinder) this.X.poll(j2, timeUnit);
            if (iBinder != null) {
                return iBinder;
            }
            throw new TimeoutException("Timed out waiting for the service connection");
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }

    public final void onServiceConnected(@NonNull ComponentName componentName, @NonNull IBinder iBinder) {
        this.X.add(iBinder);
    }

    public final void onServiceDisconnected(@NonNull ComponentName componentName) {
    }
}
