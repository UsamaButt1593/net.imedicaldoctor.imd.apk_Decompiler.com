package androidx.media3.exoplayer;

import android.content.Context;
import android.net.wifi.WifiManager;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Log;

final class WifiLockManager {

    /* renamed from: e  reason: collision with root package name */
    private static final String f10477e = "WifiLockManager";

    /* renamed from: f  reason: collision with root package name */
    private static final String f10478f = "ExoPlayer:WifiLockManager";
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final WifiManager f10479a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private WifiManager.WifiLock f10480b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10481c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10482d;

    public WifiLockManager(Context context) {
        this.f10479a = (WifiManager) context.getApplicationContext().getSystemService("wifi");
    }

    private void c() {
        WifiManager.WifiLock wifiLock = this.f10480b;
        if (wifiLock != null) {
            if (!this.f10481c || !this.f10482d) {
                wifiLock.release();
            } else {
                wifiLock.acquire();
            }
        }
    }

    public void a(boolean z) {
        if (z && this.f10480b == null) {
            WifiManager wifiManager = this.f10479a;
            if (wifiManager == null) {
                Log.n(f10477e, "WifiManager is null, therefore not creating the WifiLock.");
                return;
            }
            WifiManager.WifiLock createWifiLock = wifiManager.createWifiLock(3, f10478f);
            this.f10480b = createWifiLock;
            createWifiLock.setReferenceCounted(false);
        }
        this.f10481c = z;
        c();
    }

    public void b(boolean z) {
        this.f10482d = z;
        c();
    }
}
