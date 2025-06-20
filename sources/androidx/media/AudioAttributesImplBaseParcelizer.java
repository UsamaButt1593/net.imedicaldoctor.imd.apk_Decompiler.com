package androidx.media;

import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcel;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(VersionedParcel versionedParcel) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f8874a = versionedParcel.M(audioAttributesImplBase.f8874a, 1);
        audioAttributesImplBase.f8875b = versionedParcel.M(audioAttributesImplBase.f8875b, 2);
        audioAttributesImplBase.f8876c = versionedParcel.M(audioAttributesImplBase.f8876c, 3);
        audioAttributesImplBase.f8877d = versionedParcel.M(audioAttributesImplBase.f8877d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, VersionedParcel versionedParcel) {
        versionedParcel.j0(false, false);
        versionedParcel.M0(audioAttributesImplBase.f8874a, 1);
        versionedParcel.M0(audioAttributesImplBase.f8875b, 2);
        versionedParcel.M0(audioAttributesImplBase.f8876c, 3);
        versionedParcel.M0(audioAttributesImplBase.f8877d, 4);
    }
}
