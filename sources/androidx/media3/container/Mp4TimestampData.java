package androidx.media3.container;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.G;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;
import com.google.common.primitives.Longs;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;

@UnstableApi
public final class Mp4TimestampData implements Metadata.Entry {
    public static final Parcelable.Creator<Mp4TimestampData> CREATOR = new Parcelable.Creator<Mp4TimestampData>() {
        /* renamed from: a */
        public Mp4TimestampData createFromParcel(Parcel parcel) {
            return new Mp4TimestampData(parcel);
        }

        /* renamed from: b */
        public Mp4TimestampData[] newArray(int i2) {
            return new Mp4TimestampData[i2];
        }
    };
    public static final int Z = -1;
    public final long X;
    public final long Y;
    public final long s;

    public Mp4TimestampData(long j2) {
        this.s = j2;
        this.X = C.f9084b;
        this.Y = -1;
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
        if (!(obj instanceof Mp4TimestampData)) {
            return false;
        }
        Mp4TimestampData mp4TimestampData = (Mp4TimestampData) obj;
        return this.s == mp4TimestampData.s && this.X == mp4TimestampData.X && this.Y == mp4TimestampData.Y;
    }

    public int hashCode() {
        return ((((MetaDo.w + Longs.l(this.s)) * 31) + Longs.l(this.X)) * 31) + Longs.l(this.Y);
    }

    public /* synthetic */ Format n() {
        return G.b(this);
    }

    public /* synthetic */ void q(MediaMetadata.Builder builder) {
        G.c(this, builder);
    }

    public String toString() {
        return "Mp4Timestamp: creation time=" + this.s + ", modification time=" + this.X + ", timescale=" + this.Y;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.s);
        parcel.writeLong(this.X);
        parcel.writeLong(this.Y);
    }

    public Mp4TimestampData(long j2, long j3, long j4) {
        this.s = j2;
        this.X = j3;
        this.Y = j4;
    }

    private Mp4TimestampData(Parcel parcel) {
        this.s = parcel.readLong();
        this.X = parcel.readLong();
        this.Y = parcel.readLong();
    }
}
