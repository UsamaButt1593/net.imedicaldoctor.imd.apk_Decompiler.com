package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.Arrays;

@UnstableApi
public final class ChapterFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterFrame> CREATOR = new Parcelable.Creator<ChapterFrame>() {
        /* renamed from: a */
        public ChapterFrame createFromParcel(Parcel parcel) {
            return new ChapterFrame(parcel);
        }

        /* renamed from: b */
        public ChapterFrame[] newArray(int i2) {
            return new ChapterFrame[i2];
        }
    };
    public static final String a3 = "CHAP";
    public final String X;
    public final long X2;
    public final int Y;
    public final long Y2;
    public final int Z;
    private final Id3Frame[] Z2;

    ChapterFrame(Parcel parcel) {
        super(a3);
        this.X = (String) Util.o(parcel.readString());
        this.Y = parcel.readInt();
        this.Z = parcel.readInt();
        this.X2 = parcel.readLong();
        this.Y2 = parcel.readLong();
        int readInt = parcel.readInt();
        this.Z2 = new Id3Frame[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            this.Z2[i2] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public Id3Frame a(int i2) {
        return this.Z2[i2];
    }

    public int b() {
        return this.Z2.length;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChapterFrame.class != obj.getClass()) {
            return false;
        }
        ChapterFrame chapterFrame = (ChapterFrame) obj;
        return this.Y == chapterFrame.Y && this.Z == chapterFrame.Z && this.X2 == chapterFrame.X2 && this.Y2 == chapterFrame.Y2 && Util.g(this.X, chapterFrame.X) && Arrays.equals(this.Z2, chapterFrame.Z2);
    }

    public int hashCode() {
        int i2 = (((((((MetaDo.w + this.Y) * 31) + this.Z) * 31) + ((int) this.X2)) * 31) + ((int) this.Y2)) * 31;
        String str = this.X;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.X);
        parcel.writeInt(this.Y);
        parcel.writeInt(this.Z);
        parcel.writeLong(this.X2);
        parcel.writeLong(this.Y2);
        parcel.writeInt(this.Z2.length);
        for (Id3Frame writeParcelable : this.Z2) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }

    public ChapterFrame(String str, int i2, int i3, long j2, long j3, Id3Frame[] id3FrameArr) {
        super(a3);
        this.X = str;
        this.Y = i2;
        this.Z = i3;
        this.X2 = j2;
        this.Y2 = j3;
        this.Z2 = id3FrameArr;
    }
}
