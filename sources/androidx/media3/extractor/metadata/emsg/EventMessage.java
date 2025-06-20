package androidx.media3.extractor.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.Format;
import androidx.media3.common.G;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.Arrays;

@UnstableApi
public final class EventMessage implements Metadata.Entry {
    public static final Parcelable.Creator<EventMessage> CREATOR = new Parcelable.Creator<EventMessage>() {
        /* renamed from: a */
        public EventMessage createFromParcel(Parcel parcel) {
            return new EventMessage(parcel);
        }

        /* renamed from: b */
        public EventMessage[] newArray(int i2) {
            return new EventMessage[i2];
        }
    };
    @VisibleForTesting
    public static final String Z2 = "https://aomedia.org/emsg/ID3";
    private static final String a3 = "https://developer.apple.com/streaming/emsg-id3";
    @VisibleForTesting
    public static final String b3 = "urn:scte:scte35:2014:bin";
    private static final Format c3 = new Format.Builder().k0(MimeTypes.v0).I();
    private static final Format d3 = new Format.Builder().k0(MimeTypes.G0).I();
    public final String X;
    public final byte[] X2;
    public final long Y;
    private int Y2;
    public final long Z;
    public final String s;

    EventMessage(Parcel parcel) {
        this.s = (String) Util.o(parcel.readString());
        this.X = (String) Util.o(parcel.readString());
        this.Y = parcel.readLong();
        this.Z = parcel.readLong();
        this.X2 = (byte[]) Util.o(parcel.createByteArray());
    }

    @Nullable
    public byte[] J() {
        if (n() != null) {
            return this.X2;
        }
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || EventMessage.class != obj.getClass()) {
            return false;
        }
        EventMessage eventMessage = (EventMessage) obj;
        return this.Y == eventMessage.Y && this.Z == eventMessage.Z && Util.g(this.s, eventMessage.s) && Util.g(this.X, eventMessage.X) && Arrays.equals(this.X2, eventMessage.X2);
    }

    public int hashCode() {
        if (this.Y2 == 0) {
            String str = this.s;
            int i2 = 0;
            int hashCode = (MetaDo.w + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.X;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            long j2 = this.Y;
            long j3 = this.Z;
            this.Y2 = ((((((hashCode + i2) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + Arrays.hashCode(this.X2);
        }
        return this.Y2;
    }

    @Nullable
    public Format n() {
        String str = this.s;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1468477611:
                if (str.equals(b3)) {
                    c2 = 0;
                    break;
                }
                break;
            case -795945609:
                if (str.equals(Z2)) {
                    c2 = 1;
                    break;
                }
                break;
            case 1303648457:
                if (str.equals(a3)) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return d3;
            case 1:
            case 2:
                return c3;
            default:
                return null;
        }
    }

    public /* synthetic */ void q(MediaMetadata.Builder builder) {
        G.c(this, builder);
    }

    public String toString() {
        return "EMSG: scheme=" + this.s + ", id=" + this.Z + ", durationMs=" + this.Y + ", value=" + this.X;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.s);
        parcel.writeString(this.X);
        parcel.writeLong(this.Y);
        parcel.writeLong(this.Z);
        parcel.writeByteArray(this.X2);
    }

    public EventMessage(String str, String str2, long j2, long j3, byte[] bArr) {
        this.s = str;
        this.X = str2;
        this.Y = j2;
        this.Z = j3;
        this.X2 = bArr;
    }
}
