package androidx.media3.exoplayer;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

final class AudioFocusManager {

    /* renamed from: j  reason: collision with root package name */
    public static final int f10080j = -1;

    /* renamed from: k  reason: collision with root package name */
    public static final int f10081k = 0;

    /* renamed from: l  reason: collision with root package name */
    public static final int f10082l = 1;

    /* renamed from: m  reason: collision with root package name */
    private static final int f10083m = 0;

    /* renamed from: n  reason: collision with root package name */
    private static final int f10084n = 1;
    private static final int o = 2;
    private static final int p = 3;
    private static final int q = 0;
    private static final int r = 1;
    private static final int s = 2;
    private static final int t = 3;
    private static final int u = 4;
    private static final String v = "AudioFocusManager";
    private static final float w = 0.2f;
    private static final float x = 1.0f;

    /* renamed from: a  reason: collision with root package name */
    private final AudioManager f10085a;

    /* renamed from: b  reason: collision with root package name */
    private final AudioFocusListener f10086b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private PlayerControl f10087c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private AudioAttributes f10088d;

    /* renamed from: e  reason: collision with root package name */
    private int f10089e;

    /* renamed from: f  reason: collision with root package name */
    private int f10090f;

    /* renamed from: g  reason: collision with root package name */
    private float f10091g = 1.0f;

    /* renamed from: h  reason: collision with root package name */
    private AudioFocusRequest f10092h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10093i;

    private class AudioFocusListener implements AudioManager.OnAudioFocusChangeListener {
        private final Handler s;

        public AudioFocusListener(Handler handler) {
            this.s = handler;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(int i2) {
            AudioFocusManager.this.i(i2);
        }

        public void onAudioFocusChange(int i2) {
            this.s.post(new C0313j(this, i2));
        }
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlayerCommand {
    }

    public interface PlayerControl {
        void D(float f2);

        void E(int i2);
    }

    public AudioFocusManager(Context context, Handler handler, PlayerControl playerControl) {
        this.f10085a = (AudioManager) Assertions.g((AudioManager) context.getApplicationContext().getSystemService("audio"));
        this.f10087c = playerControl;
        this.f10086b = new AudioFocusListener(handler);
        this.f10089e = 0;
    }

    private void a() {
        this.f10085a.abandonAudioFocus(this.f10086b);
    }

    private void b() {
        if (this.f10089e != 0) {
            if (Util.f9646a >= 26) {
                c();
            } else {
                a();
            }
            o(0);
        }
    }

    @RequiresApi(26)
    private void c() {
        AudioFocusRequest audioFocusRequest = this.f10092h;
        if (audioFocusRequest != null) {
            int unused = this.f10085a.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    private static int e(@Nullable AudioAttributes audioAttributes) {
        if (audioAttributes == null) {
            return 0;
        }
        switch (audioAttributes.Y) {
            case 0:
                Log.n(v, "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
                return 1;
            case 1:
            case 14:
                return 1;
            case 2:
            case 4:
                return 2;
            case 3:
                return 0;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
                break;
            case 11:
                if (audioAttributes.s == 1) {
                    return 2;
                }
                break;
            case 16:
                return Util.f9646a >= 19 ? 4 : 2;
            default:
                Log.n(v, "Unidentified audio usage: " + audioAttributes.Y);
                return 0;
        }
        return 3;
    }

    private void f(int i2) {
        PlayerControl playerControl = this.f10087c;
        if (playerControl != null) {
            playerControl.E(i2);
        }
    }

    /* access modifiers changed from: private */
    public void i(int i2) {
        int i3;
        if (i2 == -3 || i2 == -2) {
            if (i2 == -2 || r()) {
                f(0);
                i3 = 2;
            } else {
                i3 = 3;
            }
            o(i3);
        } else if (i2 == -1) {
            f(-1);
            b();
        } else if (i2 != 1) {
            Log.n(v, "Unknown focus change type: " + i2);
        } else {
            o(1);
            f(1);
        }
    }

    private int k() {
        if (this.f10089e == 1) {
            return 1;
        }
        if ((Util.f9646a >= 26 ? m() : l()) == 1) {
            o(1);
            return 1;
        }
        o(0);
        return -1;
    }

    private int l() {
        return this.f10085a.requestAudioFocus(this.f10086b, Util.J0(((AudioAttributes) Assertions.g(this.f10088d)).Y), this.f10090f);
    }

    @RequiresApi(26)
    private int m() {
        AudioFocusRequest audioFocusRequest = this.f10092h;
        if (audioFocusRequest == null || this.f10093i) {
            C0311i.a();
            this.f10092h = (audioFocusRequest == null ? C0307g.a(this.f10090f) : C0309h.a(this.f10092h)).setAudioAttributes(((AudioAttributes) Assertions.g(this.f10088d)).c().f9067a).setWillPauseWhenDucked(r()).setOnAudioFocusChangeListener(this.f10086b).build();
            this.f10093i = false;
        }
        return this.f10085a.requestAudioFocus(this.f10092h);
    }

    private void o(int i2) {
        if (this.f10089e != i2) {
            this.f10089e = i2;
            float f2 = i2 == 3 ? 0.2f : 1.0f;
            if (this.f10091g != f2) {
                this.f10091g = f2;
                PlayerControl playerControl = this.f10087c;
                if (playerControl != null) {
                    playerControl.D(f2);
                }
            }
        }
    }

    private boolean p(int i2) {
        return i2 == 1 || this.f10090f != 1;
    }

    private boolean r() {
        AudioAttributes audioAttributes = this.f10088d;
        return audioAttributes != null && audioAttributes.s == 1;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public AudioManager.OnAudioFocusChangeListener g() {
        return this.f10086b;
    }

    public float h() {
        return this.f10091g;
    }

    public void j() {
        this.f10087c = null;
        b();
    }

    public void n(@Nullable AudioAttributes audioAttributes) {
        if (!Util.g(this.f10088d, audioAttributes)) {
            this.f10088d = audioAttributes;
            int e2 = e(audioAttributes);
            this.f10090f = e2;
            boolean z = true;
            if (!(e2 == 1 || e2 == 0)) {
                z = false;
            }
            Assertions.b(z, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
        }
    }

    public int q(boolean z, int i2) {
        if (p(i2)) {
            b();
            return z ? 1 : -1;
        } else if (z) {
            return k();
        } else {
            return -1;
        }
    }
}
