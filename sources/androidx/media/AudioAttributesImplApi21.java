package androidx.media;

import android.annotation.SuppressLint;
import android.media.AudioAttributes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.media.AudioAttributesImpl;

@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AudioAttributesImplApi21 implements AudioAttributesImpl {
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: a  reason: collision with root package name */
    public AudioAttributes f8871a;
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: b  reason: collision with root package name */
    public int f8872b;

    @RequiresApi(21)
    static class Builder implements AudioAttributesImpl.Builder {

        /* renamed from: a  reason: collision with root package name */
        final AudioAttributes.Builder f8873a;

        Builder() {
            this.f8873a = new AudioAttributes.Builder();
        }

        @NonNull
        public AudioAttributesImpl build() {
            return new AudioAttributesImplApi21(this.f8873a.build());
        }

        @NonNull
        /* renamed from: e */
        public Builder b(int i2) {
            this.f8873a.setContentType(i2);
            return this;
        }

        @NonNull
        /* renamed from: f */
        public Builder c(int i2) {
            this.f8873a.setFlags(i2);
            return this;
        }

        @NonNull
        /* renamed from: g */
        public Builder a(int i2) {
            this.f8873a.setLegacyStreamType(i2);
            return this;
        }

        @SuppressLint({"WrongConstant"})
        @NonNull
        /* renamed from: h */
        public Builder d(int i2) {
            if (i2 == 16) {
                i2 = 12;
            }
            this.f8873a.setUsage(i2);
            return this;
        }

        Builder(Object obj) {
            this.f8873a = new AudioAttributes.Builder((AudioAttributes) obj);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public AudioAttributesImplApi21() {
        this.f8872b = -1;
    }

    @Nullable
    public Object d() {
        return this.f8871a;
    }

    public int e() {
        int i2 = this.f8872b;
        return i2 != -1 ? i2 : AudioAttributesCompat.b(false, j(), g());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplApi21)) {
            return false;
        }
        return this.f8871a.equals(((AudioAttributesImplApi21) obj).f8871a);
    }

    public int f() {
        return this.f8872b;
    }

    public int g() {
        return this.f8871a.getUsage();
    }

    public int getContentType() {
        return this.f8871a.getContentType();
    }

    public int h() {
        return AudioAttributesCompat.b(true, j(), g());
    }

    public int hashCode() {
        return this.f8871a.hashCode();
    }

    public int j() {
        return this.f8871a.getFlags();
    }

    @NonNull
    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f8871a;
    }

    AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this(audioAttributes, -1);
    }

    AudioAttributesImplApi21(AudioAttributes audioAttributes, int i2) {
        this.f8871a = audioAttributes;
        this.f8872b = i2;
    }
}
