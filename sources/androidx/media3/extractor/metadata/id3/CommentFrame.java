package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;

@UnstableApi
public final class CommentFrame extends Id3Frame {
    public static final Parcelable.Creator<CommentFrame> CREATOR = new Parcelable.Creator<CommentFrame>() {
        /* renamed from: a */
        public CommentFrame createFromParcel(Parcel parcel) {
            return new CommentFrame(parcel);
        }

        /* renamed from: b */
        public CommentFrame[] newArray(int i2) {
            return new CommentFrame[i2];
        }
    };
    public static final String X2 = "COMM";
    public final String X;
    public final String Y;
    public final String Z;

    CommentFrame(Parcel parcel) {
        super(X2);
        this.X = (String) Util.o(parcel.readString());
        this.Y = (String) Util.o(parcel.readString());
        this.Z = (String) Util.o(parcel.readString());
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CommentFrame.class != obj.getClass()) {
            return false;
        }
        CommentFrame commentFrame = (CommentFrame) obj;
        return Util.g(this.Y, commentFrame.Y) && Util.g(this.X, commentFrame.X) && Util.g(this.Z, commentFrame.Z);
    }

    public int hashCode() {
        String str = this.X;
        int i2 = 0;
        int hashCode = (MetaDo.w + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.Y;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.Z;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return this.s + ": language=" + this.X + ", description=" + this.Y;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.s);
        parcel.writeString(this.X);
        parcel.writeString(this.Z);
    }

    public CommentFrame(String str, String str2, String str3) {
        super(X2);
        this.X = str;
        this.Y = str2;
        this.Z = str3;
    }
}
