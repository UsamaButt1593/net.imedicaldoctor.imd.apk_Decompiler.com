package androidx.media3.extractor.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.G;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;
import com.google.common.primitives.Longs;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;

@UnstableApi
public final class MotionPhotoMetadata implements Metadata.Entry {
    public static final Parcelable.Creator<MotionPhotoMetadata> CREATOR = new Parcelable.Creator<MotionPhotoMetadata>() {
        /* renamed from: a */
        public MotionPhotoMetadata createFromParcel(Parcel parcel) {
            return new MotionPhotoMetadata(parcel);
        }

        /* renamed from: b */
        public MotionPhotoMetadata[] newArray(int i2) {
            return new MotionPhotoMetadata[i2];
        }
    };
    public final long X;
    public final long X2;
    public final long Y;
    public final long Z;
    public final long s;

    public MotionPhotoMetadata(long j2, long j3, long j4, long j5, long j6) {
        this.s = j2;
        this.X = j3;
        this.Y = j4;
        this.Z = j5;
        this.X2 = j6;
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
        if (obj == null || MotionPhotoMetadata.class != obj.getClass()) {
            return false;
        }
        MotionPhotoMetadata motionPhotoMetadata = (MotionPhotoMetadata) obj;
        return this.s == motionPhotoMetadata.s && this.X == motionPhotoMetadata.X && this.Y == motionPhotoMetadata.Y && this.Z == motionPhotoMetadata.Z && this.X2 == motionPhotoMetadata.X2;
    }

    public int hashCode() {
        return ((((((((MetaDo.w + Longs.l(this.s)) * 31) + Longs.l(this.X)) * 31) + Longs.l(this.Y)) * 31) + Longs.l(this.Z)) * 31) + Longs.l(this.X2);
    }

    public /* synthetic */ Format n() {
        return G.b(this);
    }

    public /* synthetic */ void q(MediaMetadata.Builder builder) {
        G.c(this, builder);
    }

    public String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.s + ", photoSize=" + this.X + ", photoPresentationTimestampUs=" + this.Y + ", videoStartPosition=" + this.Z + ", videoSize=" + this.X2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.s);
        parcel.writeLong(this.X);
        parcel.writeLong(this.Y);
        parcel.writeLong(this.Z);
        parcel.writeLong(this.X2);
    }

    private MotionPhotoMetadata(Parcel parcel) {
        this.s = parcel.readLong();
        this.X = parcel.readLong();
        this.Y = parcel.readLong();
        this.Z = parcel.readLong();
        this.X2 = parcel.readLong();
    }
}
