package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.Arrays;

@UnstableApi
public final class ApicFrame extends Id3Frame {
    public static final Parcelable.Creator<ApicFrame> CREATOR = new Parcelable.Creator<ApicFrame>() {
        /* renamed from: a */
        public ApicFrame createFromParcel(Parcel parcel) {
            return new ApicFrame(parcel);
        }

        /* renamed from: b */
        public ApicFrame[] newArray(int i2) {
            return new ApicFrame[i2];
        }
    };
    public static final String Y2 = "APIC";
    public final String X;
    public final byte[] X2;
    @Nullable
    public final String Y;
    public final int Z;

    ApicFrame(Parcel parcel) {
        super(Y2);
        this.X = (String) Util.o(parcel.readString());
        this.Y = parcel.readString();
        this.Z = parcel.readInt();
        this.X2 = (byte[]) Util.o(parcel.createByteArray());
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ApicFrame.class != obj.getClass()) {
            return false;
        }
        ApicFrame apicFrame = (ApicFrame) obj;
        return this.Z == apicFrame.Z && Util.g(this.X, apicFrame.X) && Util.g(this.Y, apicFrame.Y) && Arrays.equals(this.X2, apicFrame.X2);
    }

    public int hashCode() {
        int i2 = (MetaDo.w + this.Z) * 31;
        String str = this.X;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.Y;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return ((hashCode + i3) * 31) + Arrays.hashCode(this.X2);
    }

    public void q(MediaMetadata.Builder builder) {
        builder.I(this.X2, this.Z);
    }

    public String toString() {
        return this.s + ": mimeType=" + this.X + ", description=" + this.Y;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.X);
        parcel.writeString(this.Y);
        parcel.writeInt(this.Z);
        parcel.writeByteArray(this.X2);
    }

    public ApicFrame(String str, @Nullable String str2, int i2, byte[] bArr) {
        super(Y2);
        this.X = str;
        this.Y = str2;
        this.Z = i2;
        this.X2 = bArr;
    }
}
