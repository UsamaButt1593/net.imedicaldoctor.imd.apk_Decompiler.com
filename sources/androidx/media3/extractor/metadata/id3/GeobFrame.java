package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.Arrays;

@UnstableApi
public final class GeobFrame extends Id3Frame {
    public static final Parcelable.Creator<GeobFrame> CREATOR = new Parcelable.Creator<GeobFrame>() {
        /* renamed from: a */
        public GeobFrame createFromParcel(Parcel parcel) {
            return new GeobFrame(parcel);
        }

        /* renamed from: b */
        public GeobFrame[] newArray(int i2) {
            return new GeobFrame[i2];
        }
    };
    public static final String Y2 = "GEOB";
    public final String X;
    public final byte[] X2;
    public final String Y;
    public final String Z;

    GeobFrame(Parcel parcel) {
        super(Y2);
        this.X = (String) Util.o(parcel.readString());
        this.Y = (String) Util.o(parcel.readString());
        this.Z = (String) Util.o(parcel.readString());
        this.X2 = (byte[]) Util.o(parcel.createByteArray());
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GeobFrame.class != obj.getClass()) {
            return false;
        }
        GeobFrame geobFrame = (GeobFrame) obj;
        return Util.g(this.X, geobFrame.X) && Util.g(this.Y, geobFrame.Y) && Util.g(this.Z, geobFrame.Z) && Arrays.equals(this.X2, geobFrame.X2);
    }

    public int hashCode() {
        String str = this.X;
        int i2 = 0;
        int hashCode = (MetaDo.w + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.Y;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.Z;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return ((hashCode2 + i2) * 31) + Arrays.hashCode(this.X2);
    }

    public String toString() {
        return this.s + ": mimeType=" + this.X + ", filename=" + this.Y + ", description=" + this.Z;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.X);
        parcel.writeString(this.Y);
        parcel.writeString(this.Z);
        parcel.writeByteArray(this.X2);
    }

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super(Y2);
        this.X = str;
        this.Y = str2;
        this.Z = str3;
        this.X2 = bArr;
    }
}
