package androidx.media3.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@UnstableApi
public final class DrmInitData implements Comparator<SchemeData>, Parcelable {
    public static final Parcelable.Creator<DrmInitData> CREATOR = new Parcelable.Creator<DrmInitData>() {
        /* renamed from: a */
        public DrmInitData createFromParcel(Parcel parcel) {
            return new DrmInitData(parcel);
        }

        /* renamed from: b */
        public DrmInitData[] newArray(int i2) {
            return new DrmInitData[i2];
        }
    };
    private int X;
    @Nullable
    public final String Y;
    public final int Z;
    private final SchemeData[] s;

    public static final class SchemeData implements Parcelable {
        public static final Parcelable.Creator<SchemeData> CREATOR = new Parcelable.Creator<SchemeData>() {
            /* renamed from: a */
            public SchemeData createFromParcel(Parcel parcel) {
                return new SchemeData(parcel);
            }

            /* renamed from: b */
            public SchemeData[] newArray(int i2) {
                return new SchemeData[i2];
            }
        };
        public final UUID X;
        @Nullable
        public final byte[] X2;
        @Nullable
        public final String Y;
        public final String Z;
        private int s;

        SchemeData(Parcel parcel) {
            this.X = new UUID(parcel.readLong(), parcel.readLong());
            this.Y = parcel.readString();
            this.Z = (String) Util.o(parcel.readString());
            this.X2 = parcel.createByteArray();
        }

        public boolean a(SchemeData schemeData) {
            return c() && !schemeData.c() && d(schemeData.X);
        }

        @CheckResult
        public SchemeData b(@Nullable byte[] bArr) {
            return new SchemeData(this.X, this.Y, this.Z, bArr);
        }

        public boolean c() {
            return this.X2 != null;
        }

        public boolean d(UUID uuid) {
            return C.h2.equals(this.X) || uuid.equals(this.X);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            SchemeData schemeData = (SchemeData) obj;
            return Util.g(this.Y, schemeData.Y) && Util.g(this.Z, schemeData.Z) && Util.g(this.X, schemeData.X) && Arrays.equals(this.X2, schemeData.X2);
        }

        public int hashCode() {
            if (this.s == 0) {
                int hashCode = this.X.hashCode() * 31;
                String str = this.Y;
                this.s = ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.Z.hashCode()) * 31) + Arrays.hashCode(this.X2);
            }
            return this.s;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeLong(this.X.getMostSignificantBits());
            parcel.writeLong(this.X.getLeastSignificantBits());
            parcel.writeString(this.Y);
            parcel.writeString(this.Z);
            parcel.writeByteArray(this.X2);
        }

        public SchemeData(UUID uuid, @Nullable String str, String str2, @Nullable byte[] bArr) {
            this.X = (UUID) Assertions.g(uuid);
            this.Y = str;
            this.Z = MimeTypes.u((String) Assertions.g(str2));
            this.X2 = bArr;
        }

        public SchemeData(UUID uuid, String str, @Nullable byte[] bArr) {
            this(uuid, (String) null, str, bArr);
        }
    }

    DrmInitData(Parcel parcel) {
        this.Y = parcel.readString();
        SchemeData[] schemeDataArr = (SchemeData[]) Util.o((SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR));
        this.s = schemeDataArr;
        this.Z = schemeDataArr.length;
    }

    private static boolean b(ArrayList<SchemeData> arrayList, int i2, UUID uuid) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (arrayList.get(i3).X.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static DrmInitData d(@Nullable DrmInitData drmInitData, @Nullable DrmInitData drmInitData2) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (drmInitData != null) {
            str = drmInitData.Y;
            for (SchemeData schemeData : drmInitData.s) {
                if (schemeData.c()) {
                    arrayList.add(schemeData);
                }
            }
        } else {
            str = null;
        }
        if (drmInitData2 != null) {
            if (str == null) {
                str = drmInitData2.Y;
            }
            int size = arrayList.size();
            for (SchemeData schemeData2 : drmInitData2.s) {
                if (schemeData2.c() && !b(arrayList, size, schemeData2.X)) {
                    arrayList.add(schemeData2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new DrmInitData(str, (List<SchemeData>) arrayList);
    }

    /* renamed from: a */
    public int compare(SchemeData schemeData, SchemeData schemeData2) {
        UUID uuid = C.h2;
        if (uuid.equals(schemeData.X)) {
            return uuid.equals(schemeData2.X) ? 0 : 1;
        }
        return schemeData.X.compareTo(schemeData2.X);
    }

    @CheckResult
    public DrmInitData c(@Nullable String str) {
        return Util.g(this.Y, str) ? this : new DrmInitData(str, false, this.s);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DrmInitData.class != obj.getClass()) {
            return false;
        }
        DrmInitData drmInitData = (DrmInitData) obj;
        return Util.g(this.Y, drmInitData.Y) && Arrays.equals(this.s, drmInitData.s);
    }

    public SchemeData g(int i2) {
        return this.s[i2];
    }

    public int hashCode() {
        if (this.X == 0) {
            String str = this.Y;
            this.X = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.s);
        }
        return this.X;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r3.Y;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.media3.common.DrmInitData j(androidx.media3.common.DrmInitData r3) {
        /*
            r2 = this;
            java.lang.String r0 = r2.Y
            if (r0 == 0) goto L_0x0011
            java.lang.String r1 = r3.Y
            if (r1 == 0) goto L_0x0011
            boolean r0 = android.text.TextUtils.equals(r0, r1)
            if (r0 == 0) goto L_0x000f
            goto L_0x0011
        L_0x000f:
            r0 = 0
            goto L_0x0012
        L_0x0011:
            r0 = 1
        L_0x0012:
            androidx.media3.common.util.Assertions.i(r0)
            java.lang.String r0 = r2.Y
            if (r0 == 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            java.lang.String r0 = r3.Y
        L_0x001c:
            androidx.media3.common.DrmInitData$SchemeData[] r1 = r2.s
            androidx.media3.common.DrmInitData$SchemeData[] r3 = r3.s
            java.lang.Object[] r3 = androidx.media3.common.util.Util.N1(r1, r3)
            androidx.media3.common.DrmInitData$SchemeData[] r3 = (androidx.media3.common.DrmInitData.SchemeData[]) r3
            androidx.media3.common.DrmInitData r1 = new androidx.media3.common.DrmInitData
            r1.<init>((java.lang.String) r0, (androidx.media3.common.DrmInitData.SchemeData[]) r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.DrmInitData.j(androidx.media3.common.DrmInitData):androidx.media3.common.DrmInitData");
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.Y);
        parcel.writeTypedArray(this.s, 0);
    }

    public DrmInitData(@Nullable String str, List<SchemeData> list) {
        this(str, false, (SchemeData[]) list.toArray(new SchemeData[0]));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: androidx.media3.common.DrmInitData$SchemeData[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private DrmInitData(@androidx.annotation.Nullable java.lang.String r1, boolean r2, androidx.media3.common.DrmInitData.SchemeData... r3) {
        /*
            r0 = this;
            r0.<init>()
            r0.Y = r1
            if (r2 == 0) goto L_0x000e
            java.lang.Object r1 = r3.clone()
            r3 = r1
            androidx.media3.common.DrmInitData$SchemeData[] r3 = (androidx.media3.common.DrmInitData.SchemeData[]) r3
        L_0x000e:
            r0.s = r3
            int r1 = r3.length
            r0.Z = r1
            java.util.Arrays.sort(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.DrmInitData.<init>(java.lang.String, boolean, androidx.media3.common.DrmInitData$SchemeData[]):void");
    }

    public DrmInitData(@Nullable String str, SchemeData... schemeDataArr) {
        this(str, true, schemeDataArr);
    }

    public DrmInitData(List<SchemeData> list) {
        this((String) null, false, (SchemeData[]) list.toArray(new SchemeData[0]));
    }

    public DrmInitData(SchemeData... schemeDataArr) {
        this((String) null, schemeDataArr);
    }
}
