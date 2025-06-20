package androidx.media3.exoplayer.audio;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
public final class AudioCapabilitiesReceiver {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f10754a;

    /* renamed from: b  reason: collision with root package name */
    private final Listener f10755b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f10756c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final AudioDeviceCallbackV23 f10757d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final BroadcastReceiver f10758e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final ExternalSurroundSoundSettingObserver f10759f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private AudioCapabilities f10760g;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public AudioDeviceInfoApi23 f10761h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public AudioAttributes f10762i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10763j;

    @RequiresApi(23)
    private static final class Api23 {
        private Api23() {
        }

        @DoNotInline
        public static void a(Context context, AudioDeviceCallback audioDeviceCallback, Handler handler) {
            ((AudioManager) Assertions.g((AudioManager) context.getSystemService("audio"))).registerAudioDeviceCallback(audioDeviceCallback, handler);
        }

        @DoNotInline
        public static void b(Context context, AudioDeviceCallback audioDeviceCallback) {
            ((AudioManager) Assertions.g((AudioManager) context.getSystemService("audio"))).unregisterAudioDeviceCallback(audioDeviceCallback);
        }
    }

    @RequiresApi(23)
    private final class AudioDeviceCallbackV23 extends AudioDeviceCallback {
        private AudioDeviceCallbackV23() {
        }

        public void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
            AudioCapabilitiesReceiver audioCapabilitiesReceiver = AudioCapabilitiesReceiver.this;
            audioCapabilitiesReceiver.f(AudioCapabilities.h(audioCapabilitiesReceiver.f10754a, AudioCapabilitiesReceiver.this.f10762i, AudioCapabilitiesReceiver.this.f10761h));
        }

        public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
            if (Util.z(audioDeviceInfoArr, AudioCapabilitiesReceiver.this.f10761h)) {
                AudioDeviceInfoApi23 unused = AudioCapabilitiesReceiver.this.f10761h = null;
            }
            AudioCapabilitiesReceiver audioCapabilitiesReceiver = AudioCapabilitiesReceiver.this;
            audioCapabilitiesReceiver.f(AudioCapabilities.h(audioCapabilitiesReceiver.f10754a, AudioCapabilitiesReceiver.this.f10762i, AudioCapabilitiesReceiver.this.f10761h));
        }
    }

    private final class ExternalSurroundSoundSettingObserver extends ContentObserver {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f10765a;

        /* renamed from: b  reason: collision with root package name */
        private final Uri f10766b;

        public ExternalSurroundSoundSettingObserver(Handler handler, ContentResolver contentResolver, Uri uri) {
            super(handler);
            this.f10765a = contentResolver;
            this.f10766b = uri;
        }

        public void a() {
            this.f10765a.registerContentObserver(this.f10766b, false, this);
        }

        public void b() {
            this.f10765a.unregisterContentObserver(this);
        }

        public void onChange(boolean z) {
            AudioCapabilitiesReceiver audioCapabilitiesReceiver = AudioCapabilitiesReceiver.this;
            audioCapabilitiesReceiver.f(AudioCapabilities.h(audioCapabilitiesReceiver.f10754a, AudioCapabilitiesReceiver.this.f10762i, AudioCapabilitiesReceiver.this.f10761h));
        }
    }

    private final class HdmiAudioPlugBroadcastReceiver extends BroadcastReceiver {
        private HdmiAudioPlugBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!isInitialStickyBroadcast()) {
                AudioCapabilitiesReceiver audioCapabilitiesReceiver = AudioCapabilitiesReceiver.this;
                audioCapabilitiesReceiver.f(AudioCapabilities.g(context, intent, audioCapabilitiesReceiver.f10762i, AudioCapabilitiesReceiver.this.f10761h));
            }
        }
    }

    public interface Listener {
        void a(AudioCapabilities audioCapabilities);
    }

    @Deprecated
    public AudioCapabilitiesReceiver(Context context, Listener listener) {
        this(context, listener, AudioAttributes.Z2, C0262g.a((Object) null));
    }

    /* access modifiers changed from: private */
    public void f(AudioCapabilities audioCapabilities) {
        if (this.f10763j && !audioCapabilities.equals(this.f10760g)) {
            this.f10760g = audioCapabilities;
            this.f10755b.a(audioCapabilities);
        }
    }

    public AudioCapabilities g() {
        AudioDeviceCallbackV23 audioDeviceCallbackV23;
        if (this.f10763j) {
            return (AudioCapabilities) Assertions.g(this.f10760g);
        }
        this.f10763j = true;
        ExternalSurroundSoundSettingObserver externalSurroundSoundSettingObserver = this.f10759f;
        if (externalSurroundSoundSettingObserver != null) {
            externalSurroundSoundSettingObserver.a();
        }
        if (Util.f9646a >= 23 && (audioDeviceCallbackV23 = this.f10757d) != null) {
            Api23.a(this.f10754a, audioDeviceCallbackV23, this.f10756c);
        }
        Intent intent = null;
        if (this.f10758e != null) {
            intent = this.f10754a.registerReceiver(this.f10758e, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"), (String) null, this.f10756c);
        }
        AudioCapabilities g2 = AudioCapabilities.g(this.f10754a, intent, this.f10762i, this.f10761h);
        this.f10760g = g2;
        return g2;
    }

    public void h(AudioAttributes audioAttributes) {
        this.f10762i = audioAttributes;
        f(AudioCapabilities.h(this.f10754a, audioAttributes, this.f10761h));
    }

    @RequiresApi(23)
    public void i(@Nullable AudioDeviceInfo audioDeviceInfo) {
        AudioDeviceInfoApi23 audioDeviceInfoApi23 = this.f10761h;
        AudioDeviceInfoApi23 audioDeviceInfoApi232 = null;
        if (!Util.g(audioDeviceInfo, audioDeviceInfoApi23 == null ? null : audioDeviceInfoApi23.f10769a)) {
            if (audioDeviceInfo != null) {
                audioDeviceInfoApi232 = new AudioDeviceInfoApi23(audioDeviceInfo);
            }
            this.f10761h = audioDeviceInfoApi232;
            f(AudioCapabilities.h(this.f10754a, this.f10762i, audioDeviceInfoApi232));
        }
    }

    public void j() {
        AudioDeviceCallbackV23 audioDeviceCallbackV23;
        if (this.f10763j) {
            this.f10760g = null;
            if (Util.f9646a >= 23 && (audioDeviceCallbackV23 = this.f10757d) != null) {
                Api23.b(this.f10754a, audioDeviceCallbackV23);
            }
            BroadcastReceiver broadcastReceiver = this.f10758e;
            if (broadcastReceiver != null) {
                this.f10754a.unregisterReceiver(broadcastReceiver);
            }
            ExternalSurroundSoundSettingObserver externalSurroundSoundSettingObserver = this.f10759f;
            if (externalSurroundSoundSettingObserver != null) {
                externalSurroundSoundSettingObserver.b();
            }
            this.f10763j = false;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AudioCapabilitiesReceiver(Context context, Listener listener, AudioAttributes audioAttributes, @Nullable AudioDeviceInfo audioDeviceInfo) {
        this(context, listener, audioAttributes, (Util.f9646a < 23 || audioDeviceInfo == null) ? null : new AudioDeviceInfoApi23(audioDeviceInfo));
    }

    AudioCapabilitiesReceiver(Context context, Listener listener, AudioAttributes audioAttributes, @Nullable AudioDeviceInfoApi23 audioDeviceInfoApi23) {
        Context applicationContext = context.getApplicationContext();
        this.f10754a = applicationContext;
        this.f10755b = (Listener) Assertions.g(listener);
        this.f10762i = audioAttributes;
        this.f10761h = audioDeviceInfoApi23;
        Handler J = Util.J();
        this.f10756c = J;
        int i2 = Util.f9646a;
        ExternalSurroundSoundSettingObserver externalSurroundSoundSettingObserver = null;
        this.f10757d = i2 >= 23 ? new AudioDeviceCallbackV23() : null;
        this.f10758e = i2 >= 21 ? new HdmiAudioPlugBroadcastReceiver() : null;
        Uri l2 = AudioCapabilities.l();
        this.f10759f = l2 != null ? new ExternalSurroundSoundSettingObserver(J, applicationContext.getContentResolver(), l2) : externalSurroundSoundSettingObserver;
    }
}
