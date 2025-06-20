package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.Arrays;

@UnstableApi
public final class PrivFrame extends Id3Frame {
    public static final Parcelable.Creator<PrivFrame> CREATOR = new Parcelable.Creator<PrivFrame>() {
        /* renamed from: a */
        public PrivFrame createFromParcel(Parcel parcel) {
            return new PrivFrame(parcel);
        }

        /* renamed from: b */
        public PrivFrame[] newArray(int i2) {
            return new PrivFrame[i2];
        }
    };
    public static final String Z = "PRIV";
    public final String X;
    public final byte[] Y;

    PrivFrame(Parcel parcel) {
        super(Z);
        this.X = (String) Util.o(parcel.readString());
        this.Y = (byte[]) Util.o(parcel.createByteArray());
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PrivFrame.class != obj.getClass()) {
            return false;
        }
        PrivFrame privFrame = (PrivFrame) obj;
        return Util.g(this.X, privFrame.X) && Arrays.equals(this.Y, privFrame.Y);
    }

    public int hashCode() {
        String str = this.X;
        return ((MetaDo.w + (str != null ? str.hashCode() : 0)) * 31) + Arrays.hashCode(this.Y);
    }

    public String toString() {
        return this.s + ": owner=" + this.X;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.X);
        parcel.writeByteArray(this.Y);
    }

    public PrivFrame(String str, byte[] bArr) {
        super(Z);
        this.X = str;
        this.Y = bArr;
    }
}
