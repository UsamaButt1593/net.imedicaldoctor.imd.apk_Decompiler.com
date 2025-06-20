package androidx.media;

import android.media.AudioAttributes;
import android.os.Build;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.media.AudioAttributesImpl;
import androidx.media.AudioAttributesImplApi21;
import androidx.media.AudioAttributesImplApi26;
import androidx.media.AudioAttributesImplBase;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AudioAttributesCompat implements VersionedParcelable {
    private static final SparseIntArray A;
    static boolean B = false;
    private static final int[] C = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};
    public static final int D = 1;
    static final int E = 2;
    static final int F = 4;
    static final int G = 8;
    public static final int H = 16;
    static final int I = 32;
    static final int J = 64;
    static final int K = 128;
    static final int L = 256;
    static final int M = 512;
    static final int N = 1023;
    static final int O = 273;
    static final int P = -1;

    /* renamed from: b  reason: collision with root package name */
    static final String f8852b = "AudioAttributesCompat";

    /* renamed from: c  reason: collision with root package name */
    public static final int f8853c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static final int f8854d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static final int f8855e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static final int f8856f = 3;

    /* renamed from: g  reason: collision with root package name */
    public static final int f8857g = 4;

    /* renamed from: h  reason: collision with root package name */
    public static final int f8858h = 0;

    /* renamed from: i  reason: collision with root package name */
    public static final int f8859i = 1;

    /* renamed from: j  reason: collision with root package name */
    public static final int f8860j = 2;

    /* renamed from: k  reason: collision with root package name */
    public static final int f8861k = 3;

    /* renamed from: l  reason: collision with root package name */
    public static final int f8862l = 4;

    /* renamed from: m  reason: collision with root package name */
    public static final int f8863m = 5;

    /* renamed from: n  reason: collision with root package name */
    public static final int f8864n = 6;
    public static final int o = 7;
    public static final int p = 8;
    public static final int q = 9;
    public static final int r = 10;
    public static final int s = 11;
    public static final int t = 12;
    public static final int u = 13;
    public static final int v = 14;
    static final int w = 15;
    public static final int x = 16;
    private static final int y = 1;
    private static final int z = 2;
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: a  reason: collision with root package name */
    public AudioAttributesImpl f8865a;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AttributeContentType {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AttributeUsage {
    }

    static abstract class AudioManagerHidden {

        /* renamed from: a  reason: collision with root package name */
        public static final int f8866a = 6;

        /* renamed from: b  reason: collision with root package name */
        public static final int f8867b = 7;

        /* renamed from: c  reason: collision with root package name */
        public static final int f8868c = 9;

        /* renamed from: d  reason: collision with root package name */
        public static final int f8869d = 10;

        private AudioManagerHidden() {
        }
    }

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        final AudioAttributesImpl.Builder f8870a;

        public Builder() {
            this.f8870a = AudioAttributesCompat.B ? new AudioAttributesImplBase.Builder() : Build.VERSION.SDK_INT >= 26 ? new AudioAttributesImplApi26.Builder() : new AudioAttributesImplApi21.Builder();
        }

        public AudioAttributesCompat a() {
            return new AudioAttributesCompat(this.f8870a.build());
        }

        public Builder b(int i2) {
            this.f8870a.b(i2);
            return this;
        }

        public Builder c(int i2) {
            this.f8870a.c(i2);
            return this;
        }

        public Builder d(int i2) {
            this.f8870a.a(i2);
            return this;
        }

        public Builder e(int i2) {
            this.f8870a.d(i2);
            return this;
        }

        public Builder(AudioAttributesCompat audioAttributesCompat) {
            this.f8870a = AudioAttributesCompat.B ? new AudioAttributesImplBase.Builder(audioAttributesCompat) : Build.VERSION.SDK_INT >= 26 ? new AudioAttributesImplApi26.Builder(audioAttributesCompat.c()) : new AudioAttributesImplApi21.Builder(audioAttributesCompat.c());
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        A = sparseIntArray;
        sparseIntArray.put(5, 1);
        sparseIntArray.put(6, 2);
        sparseIntArray.put(7, 2);
        sparseIntArray.put(8, 1);
        sparseIntArray.put(9, 1);
        sparseIntArray.put(10, 1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public AudioAttributesCompat() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void a(boolean z2) {
        B = z2;
    }

    static int b(boolean z2, int i2, int i3) {
        if ((i2 & 1) == 1) {
            return z2 ? 1 : 7;
        }
        if ((i2 & 4) == 4) {
            return z2 ? 0 : 6;
        }
        switch (i3) {
            case 0:
            case 1:
            case 12:
            case 14:
            case 16:
                return 3;
            case 2:
                return 0;
            case 3:
                return z2 ? 0 : 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 11:
                return 10;
            case 13:
                return 1;
            default:
                if (!z2) {
                    return 3;
                }
                throw new IllegalArgumentException("Unknown usage value " + i3 + " in audio attributes");
        }
    }

    static String i(int i2) {
        switch (i2) {
            case 0:
                return "USAGE_UNKNOWN";
            case 1:
                return "USAGE_MEDIA";
            case 2:
                return "USAGE_VOICE_COMMUNICATION";
            case 3:
                return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
            case 4:
                return "USAGE_ALARM";
            case 5:
                return "USAGE_NOTIFICATION";
            case 6:
                return "USAGE_NOTIFICATION_RINGTONE";
            case 7:
                return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
            case 8:
                return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
            case 9:
                return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
            case 10:
                return "USAGE_NOTIFICATION_EVENT";
            case 11:
                return "USAGE_ASSISTANCE_ACCESSIBILITY";
            case 12:
                return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
            case 13:
                return "USAGE_ASSISTANCE_SONIFICATION";
            case 14:
                return "USAGE_GAME";
            case 16:
                return "USAGE_ASSISTANT";
            default:
                return "unknown usage " + i2;
        }
    }

    @Nullable
    public static AudioAttributesCompat k(@NonNull Object obj) {
        if (B) {
            return null;
        }
        return Build.VERSION.SDK_INT >= 26 ? new AudioAttributesCompat(new AudioAttributesImplApi26((AudioAttributes) obj)) : new AudioAttributesCompat(new AudioAttributesImplApi21((AudioAttributes) obj));
    }

    @Nullable
    public Object c() {
        return this.f8865a.d();
    }

    public int e() {
        return this.f8865a.e();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesCompat)) {
            return false;
        }
        AudioAttributesImpl audioAttributesImpl = this.f8865a;
        AudioAttributesImpl audioAttributesImpl2 = ((AudioAttributesCompat) obj).f8865a;
        return audioAttributesImpl == null ? audioAttributesImpl2 == null : audioAttributesImpl.equals(audioAttributesImpl2);
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f8865a.f();
    }

    public int g() {
        return this.f8865a.g();
    }

    public int getContentType() {
        return this.f8865a.getContentType();
    }

    public int h() {
        return this.f8865a.h();
    }

    public int hashCode() {
        return this.f8865a.hashCode();
    }

    public int j() {
        return this.f8865a.j();
    }

    public String toString() {
        return this.f8865a.toString();
    }

    AudioAttributesCompat(AudioAttributesImpl audioAttributesImpl) {
        this.f8865a = audioAttributesImpl;
    }
}
