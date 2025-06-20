package androidx.media3.exoplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;

final class StreamVolumeManager {

    /* renamed from: i  reason: collision with root package name */
    private static final String f10455i = "StreamVolumeManager";

    /* renamed from: j  reason: collision with root package name */
    private static final String f10456j = "android.media.VOLUME_CHANGED_ACTION";

    /* renamed from: a  reason: collision with root package name */
    private final Context f10457a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Handler f10458b;

    /* renamed from: c  reason: collision with root package name */
    private final Listener f10459c;

    /* renamed from: d  reason: collision with root package name */
    private final AudioManager f10460d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private VolumeChangeReceiver f10461e;

    /* renamed from: f  reason: collision with root package name */
    private int f10462f = 3;

    /* renamed from: g  reason: collision with root package name */
    private int f10463g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10464h;

    public interface Listener {
        void I(int i2, boolean z);

        void x(int i2);
    }

    private final class VolumeChangeReceiver extends BroadcastReceiver {
        private VolumeChangeReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            StreamVolumeManager.this.f10458b.post(new Y0(StreamVolumeManager.this));
        }
    }

    public StreamVolumeManager(Context context, Handler handler, Listener listener) {
        Context applicationContext = context.getApplicationContext();
        this.f10457a = applicationContext;
        this.f10458b = handler;
        this.f10459c = listener;
        AudioManager audioManager = (AudioManager) Assertions.k((AudioManager) applicationContext.getSystemService("audio"));
        this.f10460d = audioManager;
        this.f10463g = h(audioManager, 3);
        this.f10464h = f(audioManager, this.f10462f);
        VolumeChangeReceiver volumeChangeReceiver = new VolumeChangeReceiver();
        try {
            applicationContext.registerReceiver(volumeChangeReceiver, new IntentFilter(f10456j));
            this.f10461e = volumeChangeReceiver;
        } catch (RuntimeException e2) {
            Log.o(f10455i, "Error registering stream volume receiver", e2);
        }
    }

    private static boolean f(AudioManager audioManager, int i2) {
        if (Util.f9646a >= 23) {
            return audioManager.isStreamMute(i2);
        }
        return h(audioManager, i2) == 0;
    }

    private static int h(AudioManager audioManager, int i2) {
        try {
            return audioManager.getStreamVolume(i2);
        } catch (RuntimeException e2) {
            Log.o(f10455i, "Could not retrieve stream volume for stream type " + i2, e2);
            return audioManager.getStreamMaxVolume(i2);
        }
    }

    /* access modifiers changed from: private */
    public void o() {
        int h2 = h(this.f10460d, this.f10462f);
        boolean f2 = f(this.f10460d, this.f10462f);
        if (this.f10463g != h2 || this.f10464h != f2) {
            this.f10463g = h2;
            this.f10464h = f2;
            this.f10459c.I(h2, f2);
        }
    }

    public void c(int i2) {
        if (this.f10463g > e()) {
            this.f10460d.adjustStreamVolume(this.f10462f, -1, i2);
            o();
        }
    }

    public int d() {
        return this.f10460d.getStreamMaxVolume(this.f10462f);
    }

    public int e() {
        if (Util.f9646a >= 28) {
            return this.f10460d.getStreamMinVolume(this.f10462f);
        }
        return 0;
    }

    public int g() {
        return this.f10463g;
    }

    public void i(int i2) {
        if (this.f10463g < d()) {
            this.f10460d.adjustStreamVolume(this.f10462f, 1, i2);
            o();
        }
    }

    public boolean j() {
        return this.f10464h;
    }

    public void k() {
        VolumeChangeReceiver volumeChangeReceiver = this.f10461e;
        if (volumeChangeReceiver != null) {
            try {
                this.f10457a.unregisterReceiver(volumeChangeReceiver);
            } catch (RuntimeException e2) {
                Log.o(f10455i, "Error unregistering stream volume receiver", e2);
            }
            this.f10461e = null;
        }
    }

    public void l(boolean z, int i2) {
        if (Util.f9646a >= 23) {
            this.f10460d.adjustStreamVolume(this.f10462f, z ? -100 : 100, i2);
        } else {
            this.f10460d.setStreamMute(this.f10462f, z);
        }
        o();
    }

    public void m(int i2) {
        if (this.f10462f != i2) {
            this.f10462f = i2;
            o();
            this.f10459c.x(i2);
        }
    }

    public void n(int i2, int i3) {
        if (i2 >= e() && i2 <= d()) {
            this.f10460d.setStreamVolume(this.f10462f, i2, i3);
            o();
        }
    }
}
