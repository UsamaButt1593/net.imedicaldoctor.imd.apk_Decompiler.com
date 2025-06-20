package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.Arrays;

@UnstableApi
public final class ChapterTocFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterTocFrame> CREATOR = new Parcelable.Creator<ChapterTocFrame>() {
        /* renamed from: a */
        public ChapterTocFrame createFromParcel(Parcel parcel) {
            return new ChapterTocFrame(parcel);
        }

        /* renamed from: b */
        public ChapterTocFrame[] newArray(int i2) {
            return new ChapterTocFrame[i2];
        }
    };
    public static final String Z2 = "CTOC";
    public final String X;
    public final String[] X2;
    public final boolean Y;
    private final Id3Frame[] Y2;
    public final boolean Z;

    ChapterTocFrame(Parcel parcel) {
        super(Z2);
        this.X = (String) Util.o(parcel.readString());
        boolean z = true;
        this.Y = parcel.readByte() != 0;
        this.Z = parcel.readByte() == 0 ? false : z;
        this.X2 = (String[]) Util.o(parcel.createStringArray());
        int readInt = parcel.readInt();
        this.Y2 = new Id3Frame[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            this.Y2[i2] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public Id3Frame a(int i2) {
        return this.Y2[i2];
    }

    public int b() {
        return this.Y2.length;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ChapterTocFrame.class != obj.getClass()) {
            return false;
        }
        ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
        return this.Y == chapterTocFrame.Y && this.Z == chapterTocFrame.Z && Util.g(this.X, chapterTocFrame.X) && Arrays.equals(this.X2, chapterTocFrame.X2) && Arrays.equals(this.Y2, chapterTocFrame.Y2);
    }

    public int hashCode() {
        int i2 = (((MetaDo.w + (this.Y ? 1 : 0)) * 31) + (this.Z ? 1 : 0)) * 31;
        String str = this.X;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.X);
        parcel.writeByte(this.Y ? (byte) 1 : 0);
        parcel.writeByte(this.Z ? (byte) 1 : 0);
        parcel.writeStringArray(this.X2);
        parcel.writeInt(this.Y2.length);
        for (Id3Frame writeParcelable : this.Y2) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }

    public ChapterTocFrame(String str, boolean z, boolean z2, String[] strArr, Id3Frame[] id3FrameArr) {
        super(Z2);
        this.X = str;
        this.Y = z;
        this.Z = z2;
        this.X2 = strArr;
        this.Y2 = id3FrameArr;
    }
}
