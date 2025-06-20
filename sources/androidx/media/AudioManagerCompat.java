package androidx.media;

import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class AudioManagerCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8894a = "AudioManCompat";

    /* renamed from: b  reason: collision with root package name */
    public static final int f8895b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f8896c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f8897d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static final int f8898e = 4;

    @RequiresApi(21)
    private static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static boolean a(AudioManager audioManager) {
            return audioManager.isVolumeFixed();
        }
    }

    @RequiresApi(26)
    private static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static int a(AudioManager audioManager, AudioFocusRequest audioFocusRequest) {
            return audioManager.abandonAudioFocusRequest(audioFocusRequest);
        }

        @DoNotInline
        static int b(AudioManager audioManager, AudioFocusRequest audioFocusRequest) {
            return audioManager.requestAudioFocus(audioFocusRequest);
        }
    }

    @RequiresApi(28)
    private static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static int a(AudioManager audioManager, int i2) {
            return audioManager.getStreamMinVolume(i2);
        }
    }

    private AudioManagerCompat() {
    }

    public static int a(@NonNull AudioManager audioManager, @NonNull AudioFocusRequestCompat audioFocusRequestCompat) {
        if (audioManager == null) {
            throw new IllegalArgumentException("AudioManager must not be null");
        } else if (audioFocusRequestCompat != null) {
            return Build.VERSION.SDK_INT >= 26 ? Api26Impl.a(audioManager, audioFocusRequestCompat.c()) : audioManager.abandonAudioFocus(audioFocusRequestCompat.f());
        } else {
            throw new IllegalArgumentException("AudioFocusRequestCompat must not be null");
        }
    }

    @IntRange(from = 0)
    public static int b(@NonNull AudioManager audioManager, int i2) {
        return audioManager.getStreamMaxVolume(i2);
    }

    @IntRange(from = 0)
    public static int c(@NonNull AudioManager audioManager, int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.a(audioManager, i2);
        }
        return 0;
    }

    public static boolean d(@NonNull AudioManager audioManager) {
        return Api21Impl.a(audioManager);
    }

    public static int e(@NonNull AudioManager audioManager, @NonNull AudioFocusRequestCompat audioFocusRequestCompat) {
        if (audioManager == null) {
            throw new IllegalArgumentException("AudioManager must not be null");
        } else if (audioFocusRequestCompat != null) {
            return Build.VERSION.SDK_INT >= 26 ? Api26Impl.b(audioManager, audioFocusRequestCompat.c()) : audioManager.requestAudioFocus(audioFocusRequestCompat.f(), audioFocusRequestCompat.b().e(), audioFocusRequestCompat.e());
        } else {
            throw new IllegalArgumentException("AudioFocusRequestCompat must not be null");
        }
    }
}
