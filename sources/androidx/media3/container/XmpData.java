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
import java.util.Arrays;

@UnstableApi
public final class XmpData implements Metadata.Entry {
    public static final Parcelable.Creator<XmpData> CREATOR = new Parcelable.Creator<XmpData>() {
        /* renamed from: a */
        public XmpData createFromParcel(Parcel parcel) {
            return new XmpData(parcel);
        }

        /* renamed from: b */
        public XmpData[] newArray(int i2) {
            return new XmpData[i2];
        }
    };
    public final byte[] s;

    private XmpData(Parcel parcel) {
        this.s = (byte[]) Util.o(parcel.createByteArray());
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
        if (obj == null || XmpData.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.s, ((XmpData) obj).s);
    }

    public int hashCode() {
        return Arrays.hashCode(this.s);
    }

    public /* synthetic */ Format n() {
        return G.b(this);
    }

    public /* synthetic */ void q(MediaMetadata.Builder builder) {
        G.c(this, builder);
    }

    public String toString() {
        return "XMP: " + Util.B2(this.s);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByteArray(this.s);
    }

    public XmpData(byte[] bArr) {
        this.s = bArr;
    }
}
