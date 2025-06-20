package androidx.media3.extractor.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.G;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;

@UnstableApi
public final class IcyHeaders implements Metadata.Entry {
    public static final Parcelable.Creator<IcyHeaders> CREATOR = new Parcelable.Creator<IcyHeaders>() {
        /* renamed from: a */
        public IcyHeaders createFromParcel(Parcel parcel) {
            return new IcyHeaders(parcel);
        }

        /* renamed from: b */
        public IcyHeaders[] newArray(int i2) {
            return new IcyHeaders[i2];
        }
    };
    public static final String Z2 = "Icy-MetaData";
    public static final String a3 = "1";
    private static final String b3 = "IcyHeaders";
    private static final String c3 = "icy-br";
    private static final String d3 = "icy-genre";
    private static final String e3 = "icy-name";
    private static final String f3 = "icy-url";
    private static final String g3 = "icy-pub";
    private static final String h3 = "icy-metaint";
    @Nullable
    public final String X;
    public final boolean X2;
    @Nullable
    public final String Y;
    public final int Y2;
    @Nullable
    public final String Z;
    public final int s;

    public IcyHeaders(int i2, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z, int i3) {
        Assertions.a(i3 == -1 || i3 > 0);
        this.s = i2;
        this.X = str;
        this.Y = str2;
        this.Z = str3;
        this.X2 = z;
        this.Y2 = i3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.media3.extractor.metadata.icy.IcyHeaders a(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r13) {
        /*
            java.lang.String r0 = "Invalid metadata interval: "
            java.lang.String r1 = "icy-br"
            java.lang.Object r1 = r13.get(r1)
            java.util.List r1 = (java.util.List) r1
            java.lang.String r2 = "IcyHeaders"
            r3 = 1
            r4 = 0
            r5 = -1
            if (r1 == 0) goto L_0x0051
            java.lang.Object r1 = r1.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            int r6 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0039 }
            int r6 = r6 * 1000
            if (r6 <= 0) goto L_0x0021
            r1 = 1
            goto L_0x0037
        L_0x0021:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x003a }
            r7.<init>()     // Catch:{ NumberFormatException -> 0x003a }
            java.lang.String r8 = "Invalid bitrate: "
            r7.append(r8)     // Catch:{ NumberFormatException -> 0x003a }
            r7.append(r1)     // Catch:{ NumberFormatException -> 0x003a }
            java.lang.String r7 = r7.toString()     // Catch:{ NumberFormatException -> 0x003a }
            androidx.media3.common.util.Log.n(r2, r7)     // Catch:{ NumberFormatException -> 0x003a }
            r1 = 0
            r6 = -1
        L_0x0037:
            r7 = r6
            goto L_0x0053
        L_0x0039:
            r6 = -1
        L_0x003a:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Invalid bitrate header: "
            r7.append(r8)
            r7.append(r1)
            java.lang.String r1 = r7.toString()
            androidx.media3.common.util.Log.n(r2, r1)
            r7 = r6
            r1 = 0
            goto L_0x0053
        L_0x0051:
            r1 = 0
            r7 = -1
        L_0x0053:
            java.lang.String r6 = "icy-genre"
            java.lang.Object r6 = r13.get(r6)
            java.util.List r6 = (java.util.List) r6
            r8 = 0
            if (r6 == 0) goto L_0x0067
            java.lang.Object r1 = r6.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            r9 = r1
            r1 = 1
            goto L_0x0068
        L_0x0067:
            r9 = r8
        L_0x0068:
            java.lang.String r6 = "icy-name"
            java.lang.Object r6 = r13.get(r6)
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L_0x007b
            java.lang.Object r1 = r6.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            r10 = r1
            r1 = 1
            goto L_0x007c
        L_0x007b:
            r10 = r8
        L_0x007c:
            java.lang.String r6 = "icy-url"
            java.lang.Object r6 = r13.get(r6)
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L_0x008f
            java.lang.Object r1 = r6.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            r11 = r1
            r1 = 1
            goto L_0x0090
        L_0x008f:
            r11 = r8
        L_0x0090:
            java.lang.String r6 = "icy-pub"
            java.lang.Object r6 = r13.get(r6)
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L_0x00a9
            java.lang.Object r1 = r6.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r6 = "1"
            boolean r1 = r1.equals(r6)
            r12 = r1
            r1 = 1
            goto L_0x00aa
        L_0x00a9:
            r12 = 0
        L_0x00aa:
            java.lang.String r6 = "icy-metaint"
            java.lang.Object r13 = r13.get(r6)
            java.util.List r13 = (java.util.List) r13
            if (r13 == 0) goto L_0x00ea
            java.lang.Object r13 = r13.get(r4)
            java.lang.String r13 = (java.lang.String) r13
            int r4 = java.lang.Integer.parseInt(r13)     // Catch:{ NumberFormatException -> 0x00d8 }
            if (r4 <= 0) goto L_0x00c2
            r5 = r4
            goto L_0x00d5
        L_0x00c2:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x00d7 }
            r3.<init>()     // Catch:{ NumberFormatException -> 0x00d7 }
            r3.append(r0)     // Catch:{ NumberFormatException -> 0x00d7 }
            r3.append(r13)     // Catch:{ NumberFormatException -> 0x00d7 }
            java.lang.String r3 = r3.toString()     // Catch:{ NumberFormatException -> 0x00d7 }
            androidx.media3.common.util.Log.n(r2, r3)     // Catch:{ NumberFormatException -> 0x00d7 }
            r3 = r1
        L_0x00d5:
            r1 = r3
            goto L_0x00ea
        L_0x00d7:
            r5 = r4
        L_0x00d8:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r3.append(r13)
            java.lang.String r13 = r3.toString()
            androidx.media3.common.util.Log.n(r2, r13)
        L_0x00ea:
            if (r1 == 0) goto L_0x00f8
            androidx.media3.extractor.metadata.icy.IcyHeaders r13 = new androidx.media3.extractor.metadata.icy.IcyHeaders
            r6 = r13
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r5
            r6.<init>(r7, r8, r9, r10, r11, r12)
            r8 = r13
        L_0x00f8:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.metadata.icy.IcyHeaders.a(java.util.Map):androidx.media3.extractor.metadata.icy.IcyHeaders");
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
        if (obj == null || IcyHeaders.class != obj.getClass()) {
            return false;
        }
        IcyHeaders icyHeaders = (IcyHeaders) obj;
        return this.s == icyHeaders.s && Util.g(this.X, icyHeaders.X) && Util.g(this.Y, icyHeaders.Y) && Util.g(this.Z, icyHeaders.Z) && this.X2 == icyHeaders.X2 && this.Y2 == icyHeaders.Y2;
    }

    public int hashCode() {
        int i2 = (MetaDo.w + this.s) * 31;
        String str = this.X;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.Y;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.Z;
        if (str3 != null) {
            i3 = str3.hashCode();
        }
        return ((((hashCode2 + i3) * 31) + (this.X2 ? 1 : 0)) * 31) + this.Y2;
    }

    public /* synthetic */ Format n() {
        return G.b(this);
    }

    public void q(MediaMetadata.Builder builder) {
        String str = this.Y;
        if (str != null) {
            builder.l0(str);
        }
        String str2 = this.X;
        if (str2 != null) {
            builder.a0(str2);
        }
    }

    public String toString() {
        return "IcyHeaders: name=\"" + this.Y + "\", genre=\"" + this.X + "\", bitrate=" + this.s + ", metadataInterval=" + this.Y2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.s);
        parcel.writeString(this.X);
        parcel.writeString(this.Y);
        parcel.writeString(this.Z);
        Util.I2(parcel, this.X2);
        parcel.writeInt(this.Y2);
    }

    IcyHeaders(Parcel parcel) {
        this.s = parcel.readInt();
        this.X = parcel.readString();
        this.Y = parcel.readString();
        this.Z = parcel.readString();
        this.X2 = Util.V1(parcel);
        this.Y2 = parcel.readInt();
    }
}
