package androidx.media3.extractor.metadata.vorbis;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public final class VorbisComment extends androidx.media3.extractor.metadata.flac.VorbisComment {
    public static final Parcelable.Creator<VorbisComment> CREATOR = new Parcelable.Creator<VorbisComment>() {
        /* renamed from: a */
        public VorbisComment createFromParcel(Parcel parcel) {
            return new VorbisComment(parcel);
        }

        /* renamed from: b */
        public VorbisComment[] newArray(int i2) {
            return new VorbisComment[i2];
        }
    };

    VorbisComment(Parcel parcel) {
        super(parcel);
    }

    public VorbisComment(String str, String str2) {
        super(str, str2);
    }
}
