package androidx.media3.exoplayer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Log;

final class WakeLockManager {

    /* renamed from: e  reason: collision with root package name */
    private static final String f10471e = "WakeLockManager";

    /* renamed from: f  reason: collision with root package name */
    private static final String f10472f = "ExoPlayer:WakeLockManager";
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final PowerManager f10473a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private PowerManager.WakeLock f10474b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10475c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10476d;

    public WakeLockManager(Context context) {
        this.f10473a = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    @SuppressLint({"WakelockTimeout"})
    private void c() {
        PowerManager.WakeLock wakeLock = this.f10474b;
        if (wakeLock != null) {
            if (!this.f10475c || !this.f10476d) {
                wakeLock.release();
            } else {
                wakeLock.acquire();
            }
        }
    }

    public void a(boolean z) {
        if (z && this.f10474b == null) {
            PowerManager powerManager = this.f10473a;
            if (powerManager == null) {
                Log.n(f10471e, "PowerManager is null, therefore not creating the WakeLock.");
                return;
            }
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, f10472f);
            this.f10474b = newWakeLock;
            newWakeLock.setReferenceCounted(false);
        }
        this.f10475c = z;
        c();
    }

    public void b(boolean z) {
        this.f10476d = z;
        c();
    }
}
