package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;

@UnstableApi
public final class UrlLinkFrame extends Id3Frame {
    public static final Parcelable.Creator<UrlLinkFrame> CREATOR = new Parcelable.Creator<UrlLinkFrame>() {
        /* renamed from: a */
        public UrlLinkFrame createFromParcel(Parcel parcel) {
            return new UrlLinkFrame(parcel);
        }

        /* renamed from: b */
        public UrlLinkFrame[] newArray(int i2) {
            return new UrlLinkFrame[i2];
        }
    };
    @Nullable
    public final String X;
    public final String Y;

    UrlLinkFrame(Parcel parcel) {
        super((String) Util.o(parcel.readString()));
        this.X = parcel.readString();
        this.Y = (String) Util.o(parcel.readString());
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || UrlLinkFrame.class != obj.getClass()) {
            return false;
        }
        UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
        return this.s.equals(urlLinkFrame.s) && Util.g(this.X, urlLinkFrame.X) && Util.g(this.Y, urlLinkFrame.Y);
    }

    public int hashCode() {
        int hashCode = (MetaDo.w + this.s.hashCode()) * 31;
        String str = this.X;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.Y;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return this.s + ": url=" + this.Y;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.s);
        parcel.writeString(this.X);
        parcel.writeString(this.Y);
    }

    public UrlLinkFrame(String str, @Nullable String str2, String str3) {
        super(str);
        this.X = str2;
        this.Y = str3;
    }
}
