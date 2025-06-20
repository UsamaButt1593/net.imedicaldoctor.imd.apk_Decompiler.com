package androidx.media3.extractor.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.G;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.base.Charsets;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.Arrays;

@UnstableApi
public final class PictureFrame implements Metadata.Entry {
    public static final Parcelable.Creator<PictureFrame> CREATOR = new Parcelable.Creator<PictureFrame>() {
        /* renamed from: a */
        public PictureFrame createFromParcel(Parcel parcel) {
            return new PictureFrame(parcel);
        }

        /* renamed from: b */
        public PictureFrame[] newArray(int i2) {
            return new PictureFrame[i2];
        }
    };
    public final String X;
    public final int X2;
    public final String Y;
    public final int Y2;
    public final int Z;
    public final int Z2;
    public final byte[] a3;
    public final int s;

    public PictureFrame(int i2, String str, String str2, int i3, int i4, int i5, int i6, byte[] bArr) {
        this.s = i2;
        this.X = str;
        this.Y = str2;
        this.Z = i3;
        this.X2 = i4;
        this.Y2 = i5;
        this.Z2 = i6;
        this.a3 = bArr;
    }

    public static PictureFrame a(ParsableByteArray parsableByteArray) {
        int s2 = parsableByteArray.s();
        String u = MimeTypes.u(parsableByteArray.J(parsableByteArray.s(), Charsets.f22253a));
        String I = parsableByteArray.I(parsableByteArray.s());
        int s3 = parsableByteArray.s();
        int s4 = parsableByteArray.s();
        int s5 = parsableByteArray.s();
        int s6 = parsableByteArray.s();
        int s7 = parsableByteArray.s();
        byte[] bArr = new byte[s7];
        parsableByteArray.n(bArr, 0, s7);
        return new PictureFrame(s2, u, I, s3, s4, s5, s6, bArr);
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
        if (obj == null || PictureFrame.class != obj.getClass()) {
            return false;
        }
        PictureFrame pictureFrame = (PictureFrame) obj;
        return this.s == pictureFrame.s && this.X.equals(pictureFrame.X) && this.Y.equals(pictureFrame.Y) && this.Z == pictureFrame.Z && this.X2 == pictureFrame.X2 && this.Y2 == pictureFrame.Y2 && this.Z2 == pictureFrame.Z2 && Arrays.equals(this.a3, pictureFrame.a3);
    }

    public int hashCode() {
        return ((((((((((((((MetaDo.w + this.s) * 31) + this.X.hashCode()) * 31) + this.Y.hashCode()) * 31) + this.Z) * 31) + this.X2) * 31) + this.Y2) * 31) + this.Z2) * 31) + Arrays.hashCode(this.a3);
    }

    public /* synthetic */ Format n() {
        return G.b(this);
    }

    public void q(MediaMetadata.Builder builder) {
        builder.I(this.a3, this.s);
    }

    public String toString() {
        return "Picture: mimeType=" + this.X + ", description=" + this.Y;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.s);
        parcel.writeString(this.X);
        parcel.writeString(this.Y);
        parcel.writeInt(this.Z);
        parcel.writeInt(this.X2);
        parcel.writeInt(this.Y2);
        parcel.writeInt(this.Z2);
        parcel.writeByteArray(this.a3);
    }

    PictureFrame(Parcel parcel) {
        this.s = parcel.readInt();
        this.X = (String) Util.o(parcel.readString());
        this.Y = (String) Util.o(parcel.readString());
        this.Z = parcel.readInt();
        this.X2 = parcel.readInt();
        this.Y2 = parcel.readInt();
        this.Z2 = parcel.readInt();
        this.a3 = (byte[]) Util.o(parcel.createByteArray());
    }
}
