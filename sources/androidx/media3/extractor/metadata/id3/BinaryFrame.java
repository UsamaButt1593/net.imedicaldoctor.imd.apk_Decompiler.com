package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.Arrays;

@UnstableApi
public final class BinaryFrame extends Id3Frame {
    public static final Parcelable.Creator<BinaryFrame> CREATOR = new Parcelable.Creator<BinaryFrame>() {
        /* renamed from: a */
        public BinaryFrame createFromParcel(Parcel parcel) {
            return new BinaryFrame(parcel);
        }

        /* renamed from: b */
        public BinaryFrame[] newArray(int i2) {
            return new BinaryFrame[i2];
        }
    };
    public final byte[] X;

    BinaryFrame(Parcel parcel) {
        super((String) Util.o(parcel.readString()));
        this.X = (byte[]) Util.o(parcel.createByteArray());
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || BinaryFrame.class != obj.getClass()) {
            return false;
        }
        BinaryFrame binaryFrame = (BinaryFrame) obj;
        return this.s.equals(binaryFrame.s) && Arrays.equals(this.X, binaryFrame.X);
    }

    public int hashCode() {
        return ((MetaDo.w + this.s.hashCode()) * 31) + Arrays.hashCode(this.X);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.s);
        parcel.writeByteArray(this.X);
    }

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.X = bArr;
    }
}
