package androidx.media;

import android.media.AudioAttributes;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(VersionedParcel versionedParcel) {
        AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26();
        audioAttributesImplApi26.f8871a = (AudioAttributes) versionedParcel.W(audioAttributesImplApi26.f8871a, 1);
        audioAttributesImplApi26.f8872b = versionedParcel.M(audioAttributesImplApi26.f8872b, 2);
        return audioAttributesImplApi26;
    }

    public static void write(AudioAttributesImplApi26 audioAttributesImplApi26, VersionedParcel versionedParcel) {
        versionedParcel.j0(false, false);
        versionedParcel.X0(audioAttributesImplApi26.f8871a, 1);
        versionedParcel.M0(audioAttributesImplApi26.f8872b, 2);
    }
}
