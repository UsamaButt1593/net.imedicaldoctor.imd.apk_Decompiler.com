package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class WithinAppServiceConnection implements ServiceConnection {
    private final Intent X;
    @Nullable
    private WithinAppServiceBinder X2;
    private final ScheduledExecutorService Y;
    @GuardedBy("this")
    private boolean Y2;
    private final Queue<BindRequest> Z;
    private final Context s;

    static class BindRequest {

        /* renamed from: a  reason: collision with root package name */
        final Intent f24907a;

        /* renamed from: b  reason: collision with root package name */
        private final TaskCompletionSource<Void> f24908b = new TaskCompletionSource<>();

        BindRequest(Intent intent) {
            this.f24907a = intent;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f() {
            Log.w(Constants.f24670a, "Service took too long to process intent: " + this.f24907a.getAction() + " finishing.");
            d();
        }

        /* access modifiers changed from: package-private */
        public void c(ScheduledExecutorService scheduledExecutorService) {
            e().f(scheduledExecutorService, new M(scheduledExecutorService.schedule(new L(this), 20, TimeUnit.SECONDS)));
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f24908b.e(null);
        }

        /* access modifiers changed from: package-private */
        public Task<Void> e() {
            return this.f24908b.a();
        }
    }

    @SuppressLint({"ThreadPoolCreation"})
    WithinAppServiceConnection(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    @GuardedBy("this")
    private void a() {
        while (!this.Z.isEmpty()) {
            this.Z.poll().d();
        }
    }

    private synchronized void b() {
        try {
            if (Log.isLoggable(Constants.f24670a, 3)) {
                Log.d(Constants.f24670a, "flush queue called");
            }
            while (!this.Z.isEmpty()) {
                if (Log.isLoggable(Constants.f24670a, 3)) {
                    Log.d(Constants.f24670a, "found intent to be delivered");
                }
                WithinAppServiceBinder withinAppServiceBinder = this.X2;
                if (withinAppServiceBinder == null || !withinAppServiceBinder.isBinderAlive()) {
                    d();
                    return;
                }
                if (Log.isLoggable(Constants.f24670a, 3)) {
                    Log.d(Constants.f24670a, "binder is alive, sending the intent.");
                }
                this.X2.c(this.Z.poll());
            }
        } finally {
            while (true) {
            }
        }
    }

    @GuardedBy("this")
    private void d() {
        if (Log.isLoggable(Constants.f24670a, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("binder is dead. start connection? ");
            sb.append(!this.Y2);
            Log.d(Constants.f24670a, sb.toString());
        }
        if (!this.Y2) {
            this.Y2 = true;
            try {
                if (!ConnectionTracker.b().a(this.s, this.X, this, 65)) {
                    Log.e(Constants.f24670a, "binding to the service failed");
                    this.Y2 = false;
                    a();
                }
            } catch (SecurityException e2) {
                Log.e(Constants.f24670a, "Exception while binding the service", e2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public synchronized Task<Void> c(Intent intent) {
        BindRequest bindRequest;
        try {
            if (Log.isLoggable(Constants.f24670a, 3)) {
                Log.d(Constants.f24670a, "new intent queued in the bind-strategy delivery");
            }
            bindRequest = new BindRequest(intent);
            bindRequest.c(this.Y);
            this.Z.add(bindRequest);
            b();
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return bindRequest.e();
    }

    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            if (Log.isLoggable(Constants.f24670a, 3)) {
                Log.d(Constants.f24670a, "onServiceConnected: " + componentName);
            }
            this.Y2 = false;
            if (!(iBinder instanceof WithinAppServiceBinder)) {
                Log.e(Constants.f24670a, "Invalid service connection: " + iBinder);
                a();
                return;
            }
            this.X2 = (WithinAppServiceBinder) iBinder;
            b();
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable(Constants.f24670a, 3)) {
            Log.d(Constants.f24670a, "onServiceDisconnected: " + componentName);
        }
        b();
    }

    @VisibleForTesting
    WithinAppServiceConnection(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.Z = new ArrayDeque();
        this.Y2 = false;
        Context applicationContext = context.getApplicationContext();
        this.s = applicationContext;
        this.X = new Intent(str).setPackage(applicationContext.getPackageName());
        this.Y = scheduledExecutorService;
    }
}
