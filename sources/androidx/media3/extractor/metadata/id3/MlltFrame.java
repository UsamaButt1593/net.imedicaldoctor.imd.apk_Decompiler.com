package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.Arrays;

@UnstableApi
public final class MlltFrame extends Id3Frame {
    public static final Parcelable.Creator<MlltFrame> CREATOR = new Parcelable.Creator<MlltFrame>() {
        /* renamed from: a */
        public MlltFrame createFromParcel(Parcel parcel) {
            return new MlltFrame(parcel);
        }

        /* renamed from: b */
        public MlltFrame[] newArray(int i2) {
            return new MlltFrame[i2];
        }
    };
    public static final String Z2 = "MLLT";
    public final int X;
    public final int[] X2;
    public final int Y;
    public final int[] Y2;
    public final int Z;

    public MlltFrame(int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        super(Z2);
        this.X = i2;
        this.Y = i3;
        this.Z = i4;
        this.X2 = iArr;
        this.Y2 = iArr2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MlltFrame.class != obj.getClass()) {
            return false;
        }
        MlltFrame mlltFrame = (MlltFrame) obj;
        return this.X == mlltFrame.X && this.Y == mlltFrame.Y && this.Z == mlltFrame.Z && Arrays.equals(this.X2, mlltFrame.X2) && Arrays.equals(this.Y2, mlltFrame.Y2);
    }

    public int hashCode() {
        return ((((((((MetaDo.w + this.X) * 31) + this.Y) * 31) + this.Z) * 31) + Arrays.hashCode(this.X2)) * 31) + Arrays.hashCode(this.Y2);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.X);
        parcel.writeInt(this.Y);
        parcel.writeInt(this.Z);
        parcel.writeIntArray(this.X2);
        parcel.writeIntArray(this.Y2);
    }

    MlltFrame(Parcel parcel) {
        super(Z2);
        this.X = parcel.readInt();
        this.Y = parcel.readInt();
        this.Z = parcel.readInt();
        this.X2 = (int[]) Util.o(parcel.createIntArray());
        this.Y2 = (int[]) Util.o(parcel.createIntArray());
    }
}
