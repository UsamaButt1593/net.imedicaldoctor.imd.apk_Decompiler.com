package androidx.media3.extractor.metadata.dvbsi;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.Format;
import androidx.media3.common.G;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public final class AppInfoTable implements Metadata.Entry {
    public static final Parcelable.Creator<AppInfoTable> CREATOR = new Parcelable.Creator<AppInfoTable>() {
        /* renamed from: a */
        public AppInfoTable createFromParcel(Parcel parcel) {
            return new AppInfoTable(parcel.readInt(), (String) Assertions.g(parcel.readString()));
        }

        /* renamed from: b */
        public AppInfoTable[] newArray(int i2) {
            return new AppInfoTable[i2];
        }
    };
    public static final int Y = 1;
    public static final int Z = 2;
    public final String X;
    public final int s;

    public AppInfoTable(int i2, String str) {
        this.s = i2;
        this.X = str;
    }

    public /* synthetic */ byte[] J() {
        return G.a(this);
    }

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ Format n() {
        return G.b(this);
    }

    public /* synthetic */ void q(MediaMetadata.Builder builder) {
        G.c(this, builder);
    }

    public String toString() {
        return "Ait(controlCode=" + this.s + ",url=" + this.X + ")";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.X);
        parcel.writeInt(this.s);
    }
}
