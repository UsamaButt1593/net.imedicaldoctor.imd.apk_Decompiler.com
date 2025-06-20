package androidx.media3.exoplayer.scheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
public final class RequirementsWatcher {

    /* renamed from: a  reason: collision with root package name */
    private final Context f11880a;

    /* renamed from: b  reason: collision with root package name */
    private final Listener f11881b;

    /* renamed from: c  reason: collision with root package name */
    private final Requirements f11882c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Handler f11883d = Util.J();
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private DeviceStatusChangeReceiver f11884e;

    /* renamed from: f  reason: collision with root package name */
    private int f11885f;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public NetworkCallback f11886g;

    private class DeviceStatusChangeReceiver extends BroadcastReceiver {
        private DeviceStatusChangeReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!isInitialStickyBroadcast()) {
                RequirementsWatcher.this.e();
            }
        }
    }

    public interface Listener {
        void a(RequirementsWatcher requirementsWatcher, int i2);
    }

    @RequiresApi(24)
    private final class NetworkCallback extends ConnectivityManager.NetworkCallback {

        /* renamed from: a  reason: collision with root package name */
        private boolean f11888a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f11889b;

        private NetworkCallback() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c() {
            if (RequirementsWatcher.this.f11886g != null) {
                RequirementsWatcher.this.e();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d() {
            if (RequirementsWatcher.this.f11886g != null) {
                RequirementsWatcher.this.g();
            }
        }

        private void e() {
            RequirementsWatcher.this.f11883d.post(new e(this));
        }

        private void f() {
            RequirementsWatcher.this.f11883d.post(new f(this));
        }

        public void onAvailable(Network network) {
            e();
        }

        public void onBlockedStatusChanged(Network network, boolean z) {
            if (!z) {
                f();
            }
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            boolean hasCapability = networkCapabilities.hasCapability(16);
            if (!this.f11888a || this.f11889b != hasCapability) {
                this.f11888a = true;
                this.f11889b = hasCapability;
                e();
            } else if (hasCapability) {
                f();
            }
        }

        public void onLost(Network network) {
            e();
        }
    }

    public RequirementsWatcher(Context context, Listener listener, Requirements requirements) {
        this.f11880a = context.getApplicationContext();
        this.f11881b = listener;
        this.f11882c = requirements;
    }

    /* access modifiers changed from: private */
    public void e() {
        int d2 = this.f11882c.d(this.f11880a);
        if (this.f11885f != d2) {
            this.f11885f = d2;
            this.f11881b.a(this, d2);
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        if ((this.f11885f & 3) != 0) {
            e();
        }
    }

    @RequiresApi(24)
    private void h() {
        NetworkCallback networkCallback = new NetworkCallback();
        this.f11886g = networkCallback;
        ((ConnectivityManager) Assertions.g((ConnectivityManager) this.f11880a.getSystemService("connectivity"))).registerDefaultNetworkCallback(networkCallback);
    }

    @RequiresApi(24)
    private void k() {
        ((ConnectivityManager) Assertions.g((ConnectivityManager) this.f11880a.getSystemService("connectivity"))).unregisterNetworkCallback((ConnectivityManager.NetworkCallback) Assertions.g(this.f11886g));
        this.f11886g = null;
    }

    public Requirements f() {
        return this.f11882c;
    }

    public int i() {
        String str;
        this.f11885f = this.f11882c.d(this.f11880a);
        IntentFilter intentFilter = new IntentFilter();
        if (this.f11882c.p()) {
            if (Util.f9646a >= 24) {
                h();
            } else {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
        }
        if (this.f11882c.j()) {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        if (this.f11882c.m()) {
            if (Util.f9646a >= 23) {
                str = "android.os.action.DEVICE_IDLE_MODE_CHANGED";
            } else {
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                str = "android.intent.action.SCREEN_OFF";
            }
            intentFilter.addAction(str);
        }
        if (this.f11882c.v()) {
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        }
        DeviceStatusChangeReceiver deviceStatusChangeReceiver = new DeviceStatusChangeReceiver();
        this.f11884e = deviceStatusChangeReceiver;
        this.f11880a.registerReceiver(deviceStatusChangeReceiver, intentFilter, (String) null, this.f11883d);
        return this.f11885f;
    }

    public void j() {
        this.f11880a.unregisterReceiver((BroadcastReceiver) Assertions.g(this.f11884e));
        this.f11884e = null;
        if (Util.f9646a >= 24 && this.f11886g != null) {
            k();
        }
    }
}
