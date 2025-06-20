package androidx.media3.extractor.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.G;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;
import com.google.common.primitives.Floats;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;

@UnstableApi
public final class SmtaMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<SmtaMetadataEntry> CREATOR = new Parcelable.Creator<SmtaMetadataEntry>() {
        /* renamed from: a */
        public SmtaMetadataEntry createFromParcel(Parcel parcel) {
            return new SmtaMetadataEntry(parcel);
        }

        /* renamed from: b */
        public SmtaMetadataEntry[] newArray(int i2) {
            return new SmtaMetadataEntry[i2];
        }
    };
    public final int X;
    public final float s;

    public SmtaMetadataEntry(float f2, int i2) {
        this.s = f2;
        this.X = i2;
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
        if (obj == null || SmtaMetadataEntry.class != obj.getClass()) {
            return false;
        }
        SmtaMetadataEntry smtaMetadataEntry = (SmtaMetadataEntry) obj;
        return this.s == smtaMetadataEntry.s && this.X == smtaMetadataEntry.X;
    }

    public int hashCode() {
        return ((MetaDo.w + Floats.i(this.s)) * 31) + this.X;
    }

    public /* synthetic */ Format n() {
        return G.b(this);
    }

    public /* synthetic */ void q(MediaMetadata.Builder builder) {
        G.c(this, builder);
    }

    public String toString() {
        return "smta: captureFrameRate=" + this.s + ", svcTemporalLayerCount=" + this.X;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.s);
        parcel.writeInt(this.X);
    }

    private SmtaMetadataEntry(Parcel parcel) {
        this.s = parcel.readFloat();
        this.X = parcel.readInt();
    }
}
