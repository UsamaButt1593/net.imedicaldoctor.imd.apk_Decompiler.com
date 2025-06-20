package androidx.media3.extractor.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.G;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.base.Ascii;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;

@UnstableApi
@Deprecated
public class VorbisComment implements Metadata.Entry {
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
    public final String X;
    public final String s;

    protected VorbisComment(Parcel parcel) {
        this.s = (String) Util.o(parcel.readString());
        this.X = (String) Util.o(parcel.readString());
    }

    public /* synthetic */ byte[] J() {
        return G.a(this);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VorbisComment vorbisComment = (VorbisComment) obj;
        return this.s.equals(vorbisComment.s) && this.X.equals(vorbisComment.X);
    }

    public int hashCode() {
        return ((MetaDo.w + this.s.hashCode()) * 31) + this.X.hashCode();
    }

    public /* synthetic */ Format n() {
        return G.b(this);
    }

    public void q(MediaMetadata.Builder builder) {
        String str = this.s;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 62359119:
                if (str.equals("ALBUM")) {
                    c2 = 0;
                    break;
                }
                break;
            case 79833656:
                if (str.equals("TITLE")) {
                    c2 = 1;
                    break;
                }
                break;
            case 428414940:
                if (str.equals("DESCRIPTION")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1746739798:
                if (str.equals("ALBUMARTIST")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1939198791:
                if (str.equals("ARTIST")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                builder.N(this.X);
                return;
            case 1:
                builder.n0(this.X);
                return;
            case 2:
                builder.V(this.X);
                return;
            case 3:
                builder.M(this.X);
                return;
            case 4:
                builder.O(this.X);
                return;
            default:
                return;
        }
    }

    public String toString() {
        return "VC: " + this.s + "=" + this.X;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.s);
        parcel.writeString(this.X);
    }

    public VorbisComment(String str, String str2) {
        this.s = Ascii.j(str);
        this.X = str2;
    }
}
