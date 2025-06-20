package androidx.media3.extractor.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

@UnstableApi
public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator<PrivateCommand> CREATOR = new Parcelable.Creator<PrivateCommand>() {
        /* renamed from: a */
        public PrivateCommand createFromParcel(Parcel parcel) {
            return new PrivateCommand(parcel);
        }

        /* renamed from: b */
        public PrivateCommand[] newArray(int i2) {
            return new PrivateCommand[i2];
        }
    };
    public final long X;
    public final byte[] Y;
    public final long s;

    private PrivateCommand(long j2, byte[] bArr, long j3) {
        this.s = j3;
        this.X = j2;
        this.Y = bArr;
    }

    static PrivateCommand a(ParsableByteArray parsableByteArray, int i2, long j2) {
        long N = parsableByteArray.N();
        int i3 = i2 - 4;
        byte[] bArr = new byte[i3];
        parsableByteArray.n(bArr, 0, i3);
        return new PrivateCommand(N, bArr, j2);
    }

    public String toString() {
        return "SCTE-35 PrivateCommand { ptsAdjustment=" + this.s + ", identifier= " + this.X + " }";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.s);
        parcel.writeLong(this.X);
        parcel.writeByteArray(this.Y);
    }

    private PrivateCommand(Parcel parcel) {
        this.s = parcel.readLong();
        this.X = parcel.readLong();
        this.Y = (byte[]) Util.o(parcel.createByteArray());
    }
}
