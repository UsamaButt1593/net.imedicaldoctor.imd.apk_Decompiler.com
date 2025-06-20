package androidx.media3.exoplayer.hls;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.G;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@UnstableApi
public final class HlsTrackMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<HlsTrackMetadataEntry> CREATOR = new Parcelable.Creator<HlsTrackMetadataEntry>() {
        /* renamed from: a */
        public HlsTrackMetadataEntry createFromParcel(Parcel parcel) {
            return new HlsTrackMetadataEntry(parcel);
        }

        /* renamed from: b */
        public HlsTrackMetadataEntry[] newArray(int i2) {
            return new HlsTrackMetadataEntry[i2];
        }
    };
    @Nullable
    public final String X;
    public final List<VariantInfo> Y;
    @Nullable
    public final String s;

    public static final class VariantInfo implements Parcelable {
        public static final Parcelable.Creator<VariantInfo> CREATOR = new Parcelable.Creator<VariantInfo>() {
            /* renamed from: a */
            public VariantInfo createFromParcel(Parcel parcel) {
                return new VariantInfo(parcel);
            }

            /* renamed from: b */
            public VariantInfo[] newArray(int i2) {
                return new VariantInfo[i2];
            }
        };
        public final int X;
        @Nullable
        public final String X2;
        @Nullable
        public final String Y;
        @Nullable
        public final String Y2;
        @Nullable
        public final String Z;
        public final int s;

        public VariantInfo(int i2, int i3, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            this.s = i2;
            this.X = i3;
            this.Y = str;
            this.Z = str2;
            this.X2 = str3;
            this.Y2 = str4;
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || VariantInfo.class != obj.getClass()) {
                return false;
            }
            VariantInfo variantInfo = (VariantInfo) obj;
            return this.s == variantInfo.s && this.X == variantInfo.X && TextUtils.equals(this.Y, variantInfo.Y) && TextUtils.equals(this.Z, variantInfo.Z) && TextUtils.equals(this.X2, variantInfo.X2) && TextUtils.equals(this.Y2, variantInfo.Y2);
        }

        public int hashCode() {
            int i2 = ((this.s * 31) + this.X) * 31;
            String str = this.Y;
            int i3 = 0;
            int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.Z;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.X2;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.Y2;
            if (str4 != null) {
                i3 = str4.hashCode();
            }
            return hashCode3 + i3;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.s);
            parcel.writeInt(this.X);
            parcel.writeString(this.Y);
            parcel.writeString(this.Z);
            parcel.writeString(this.X2);
            parcel.writeString(this.Y2);
        }

        VariantInfo(Parcel parcel) {
            this.s = parcel.readInt();
            this.X = parcel.readInt();
            this.Y = parcel.readString();
            this.Z = parcel.readString();
            this.X2 = parcel.readString();
            this.Y2 = parcel.readString();
        }
    }

    HlsTrackMetadataEntry(Parcel parcel) {
        this.s = parcel.readString();
        this.X = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add((VariantInfo) parcel.readParcelable(VariantInfo.class.getClassLoader()));
        }
        this.Y = Collections.unmodifiableList(arrayList);
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
        if (obj == null || HlsTrackMetadataEntry.class != obj.getClass()) {
            return false;
        }
        HlsTrackMetadataEntry hlsTrackMetadataEntry = (HlsTrackMetadataEntry) obj;
        return TextUtils.equals(this.s, hlsTrackMetadataEntry.s) && TextUtils.equals(this.X, hlsTrackMetadataEntry.X) && this.Y.equals(hlsTrackMetadataEntry.Y);
    }

    public int hashCode() {
        String str = this.s;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.X;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((hashCode + i2) * 31) + this.Y.hashCode();
    }

    public /* synthetic */ Format n() {
        return G.b(this);
    }

    public /* synthetic */ void q(MediaMetadata.Builder builder) {
        G.c(this, builder);
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("HlsTrackMetadataEntry");
        if (this.s != null) {
            str = " [" + this.s + ", " + this.X + "]";
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.s);
        parcel.writeString(this.X);
        int size = this.Y.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeParcelable(this.Y.get(i3), 0);
        }
    }

    public HlsTrackMetadataEntry(@Nullable String str, @Nullable String str2, List<VariantInfo> list) {
        this.s = str;
        this.X = str2;
        this.Y = Collections.unmodifiableList(new ArrayList(list));
    }
}
