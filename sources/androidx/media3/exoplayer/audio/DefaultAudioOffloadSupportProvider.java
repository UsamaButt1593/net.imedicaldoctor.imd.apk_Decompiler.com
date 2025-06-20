package androidx.media3.exoplayer.audio;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.audio.AudioOffloadSupport;
import androidx.media3.exoplayer.audio.DefaultAudioSink;

@UnstableApi
public final class DefaultAudioOffloadSupportProvider implements DefaultAudioSink.AudioOffloadSupportProvider {

    /* renamed from: c  reason: collision with root package name */
    private static final String f10828c = "offloadVariableRateSupported";
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Context f10829a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f10830b;

    @RequiresApi(29)
    private static final class Api29 {
        private Api29() {
        }

        @DoNotInline
        public static AudioOffloadSupport a(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z) {
            return !C0279y.a(audioFormat, audioAttributes) ? AudioOffloadSupport.f10770d : new AudioOffloadSupport.Builder().e(true).g(z).d();
        }
    }

    @RequiresApi(31)
    private static final class Api31 {
        private Api31() {
        }

        @DoNotInline
        public static AudioOffloadSupport a(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z) {
            int a2 = AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
            if (a2 == 0) {
                return AudioOffloadSupport.f10770d;
            }
            return new AudioOffloadSupport.Builder().e(true).f(Util.f9646a > 32 && a2 == 2).g(z).d();
        }
    }

    public DefaultAudioOffloadSupportProvider() {
        this((Context) null);
    }

    private boolean b(@Nullable Context context) {
        Boolean bool;
        AudioManager audioManager;
        Boolean bool2 = this.f10830b;
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        if (context == null || (audioManager = (AudioManager) context.getSystemService("audio")) == null) {
            bool = Boolean.FALSE;
        } else {
            String parameters = audioManager.getParameters(f10828c);
            bool = Boolean.valueOf(parameters != null && parameters.equals("offloadVariableRateSupported=1"));
        }
        this.f10830b = bool;
        return this.f10830b.booleanValue();
    }

    public AudioOffloadSupport a(Format format, androidx.media3.common.AudioAttributes audioAttributes) {
        Assertions.g(format);
        Assertions.g(audioAttributes);
        int i2 = Util.f9646a;
        if (i2 < 29 || format.t3 == -1) {
            return AudioOffloadSupport.f10770d;
        }
        boolean b2 = b(this.f10829a);
        int f2 = MimeTypes.f((String) Assertions.g(format.f3), format.c3);
        if (f2 == 0 || i2 < Util.X(f2)) {
            return AudioOffloadSupport.f10770d;
        }
        int a0 = Util.a0(format.s3);
        if (a0 == 0) {
            return AudioOffloadSupport.f10770d;
        }
        try {
            AudioFormat Z = Util.Z(format.t3, a0, f2);
            AudioAttributes audioAttributes2 = audioAttributes.c().f9067a;
            return i2 >= 31 ? Api31.a(Z, audioAttributes2, b2) : Api29.a(Z, audioAttributes2, b2);
        } catch (IllegalArgumentException unused) {
            return AudioOffloadSupport.f10770d;
        }
    }

    public DefaultAudioOffloadSupportProvider(@Nullable Context context) {
        this.f10829a = context;
    }
}
