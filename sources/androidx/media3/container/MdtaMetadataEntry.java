package androidx.media3.container;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.G;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.Arrays;

@UnstableApi
public final class MdtaMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<MdtaMetadataEntry> CREATOR = new Parcelable.Creator<MdtaMetadataEntry>() {
        /* renamed from: a */
        public MdtaMetadataEntry createFromParcel(Parcel parcel) {
            return new MdtaMetadataEntry(parcel);
        }

        /* renamed from: b */
        public MdtaMetadataEntry[] newArray(int i2) {
            return new MdtaMetadataEntry[i2];
        }
    };
    public static final String X2 = "com.android.capture.fps";
    public static final int Y2 = 1;
    public static final int Z2 = 23;
    public static final int a3 = 67;
    public final byte[] X;
    public final int Y;
    public final int Z;
    public final String s;

    private MdtaMetadataEntry(Parcel parcel) {
        this.s = (String) Util.o(parcel.readString());
        this.X = (byte[]) Util.o(parcel.createByteArray());
        this.Y = parcel.readInt();
        this.Z = parcel.readInt();
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
        if (obj == null || MdtaMetadataEntry.class != obj.getClass()) {
            return false;
        }
        MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) obj;
        return this.s.equals(mdtaMetadataEntry.s) && Arrays.equals(this.X, mdtaMetadataEntry.X) && this.Y == mdtaMetadataEntry.Y && this.Z == mdtaMetadataEntry.Z;
    }

    public int hashCode() {
        return ((((((MetaDo.w + this.s.hashCode()) * 31) + Arrays.hashCode(this.X)) * 31) + this.Y) * 31) + this.Z;
    }

    public /* synthetic */ Format n() {
        return G.b(this);
    }

    public /* synthetic */ void q(MediaMetadata.Builder builder) {
        G.c(this, builder);
    }

    public String toString() {
        int i2 = this.Z;
        String B2 = i2 != 1 ? i2 != 23 ? i2 != 67 ? Util.B2(this.X) : String.valueOf(Util.C2(this.X)) : String.valueOf(Util.A2(this.X)) : Util.T(this.X);
        return "mdta: key=" + this.s + ", value=" + B2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.s);
        parcel.writeByteArray(this.X);
        parcel.writeInt(this.Y);
        parcel.writeInt(this.Z);
    }

    public MdtaMetadataEntry(String str, byte[] bArr, int i2, int i3) {
        this.s = str;
        this.X = bArr;
        this.Y = i2;
        this.Z = i3;
    }
}
