package androidx.media3.container;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.G;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import com.google.common.primitives.Floats;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;

@UnstableApi
public final class Mp4LocationData implements Metadata.Entry {
    public static final Parcelable.Creator<Mp4LocationData> CREATOR = new Parcelable.Creator<Mp4LocationData>() {
        /* renamed from: a */
        public Mp4LocationData createFromParcel(Parcel parcel) {
            return new Mp4LocationData(parcel);
        }

        /* renamed from: b */
        public Mp4LocationData[] newArray(int i2) {
            return new Mp4LocationData[i2];
        }
    };
    public final float X;
    public final float s;

    public Mp4LocationData(@FloatRange(from = -90.0d, to = 90.0d) float f2, @FloatRange(from = -180.0d, to = 180.0d) float f3) {
        Assertions.b(f2 >= -90.0f && f2 <= 90.0f && f3 >= -180.0f && f3 <= 180.0f, "Invalid latitude or longitude");
        this.s = f2;
        this.X = f3;
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
        if (obj == null || Mp4LocationData.class != obj.getClass()) {
            return false;
        }
        Mp4LocationData mp4LocationData = (Mp4LocationData) obj;
        return this.s == mp4LocationData.s && this.X == mp4LocationData.X;
    }

    public int hashCode() {
        return ((MetaDo.w + Floats.i(this.s)) * 31) + Floats.i(this.X);
    }

    public /* synthetic */ Format n() {
        return G.b(this);
    }

    public /* synthetic */ void q(MediaMetadata.Builder builder) {
        G.c(this, builder);
    }

    public String toString() {
        return "xyz: latitude=" + this.s + ", longitude=" + this.X;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.s);
        parcel.writeFloat(this.X);
    }

    private Mp4LocationData(Parcel parcel) {
        this.s = parcel.readFloat();
        this.X = parcel.readFloat();
    }
}
