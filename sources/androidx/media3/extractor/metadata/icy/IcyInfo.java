package androidx.media3.extractor.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.G;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import java.util.Arrays;

@UnstableApi
public final class IcyInfo implements Metadata.Entry {
    public static final Parcelable.Creator<IcyInfo> CREATOR = new Parcelable.Creator<IcyInfo>() {
        /* renamed from: a */
        public IcyInfo createFromParcel(Parcel parcel) {
            return new IcyInfo(parcel);
        }

        /* renamed from: b */
        public IcyInfo[] newArray(int i2) {
            return new IcyInfo[i2];
        }
    };
    @Nullable
    public final String X;
    @Nullable
    public final String Y;
    public final byte[] s;

    IcyInfo(Parcel parcel) {
        this.s = (byte[]) Assertions.g(parcel.createByteArray());
        this.X = parcel.readString();
        this.Y = parcel.readString();
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
        if (obj == null || IcyInfo.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.s, ((IcyInfo) obj).s);
    }

    public int hashCode() {
        return Arrays.hashCode(this.s);
    }

    public /* synthetic */ Format n() {
        return G.b(this);
    }

    public void q(MediaMetadata.Builder builder) {
        String str = this.X;
        if (str != null) {
            builder.n0(str);
        }
    }

    public String toString() {
        return String.format("ICY: title=\"%s\", url=\"%s\", rawMetadata.length=\"%s\"", new Object[]{this.X, this.Y, Integer.valueOf(this.s.length)});
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByteArray(this.s);
        parcel.writeString(this.X);
        parcel.writeString(this.Y);
    }

    public IcyInfo(byte[] bArr, @Nullable String str, @Nullable String str2) {
        this.s = bArr;
        this.X = str;
        this.Y = str2;
    }
}
