package androidx.media;

import android.media.AudioAttributes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.media.AudioAttributesImplApi21;

@RequiresApi(26)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AudioAttributesImplApi26 extends AudioAttributesImplApi21 {

    @RequiresApi(26)
    static class Builder extends AudioAttributesImplApi21.Builder {
        Builder() {
        }

        @NonNull
        public AudioAttributesImpl build() {
            return new AudioAttributesImplApi26(this.f8873a.build());
        }

        @NonNull
        /* renamed from: i */
        public Builder h(int i2) {
            this.f8873a.setUsage(i2);
            return this;
        }

        Builder(Object obj) {
            super(obj);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public AudioAttributesImplApi26() {
    }

    public int h() {
        return this.f8871a.getVolumeControlStream();
    }

    AudioAttributesImplApi26(AudioAttributes audioAttributes) {
        super(audioAttributes, -1);
    }
}
