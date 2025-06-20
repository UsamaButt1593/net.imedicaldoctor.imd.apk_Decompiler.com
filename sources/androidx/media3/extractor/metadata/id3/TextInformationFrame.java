package androidx.media3.extractor.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.InlineMe;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.util.ArrayList;
import java.util.List;

@UnstableApi
public final class TextInformationFrame extends Id3Frame {
    public static final Parcelable.Creator<TextInformationFrame> CREATOR = new Parcelable.Creator<TextInformationFrame>() {
        /* renamed from: a */
        public TextInformationFrame createFromParcel(Parcel parcel) {
            return new TextInformationFrame(parcel);
        }

        /* renamed from: b */
        public TextInformationFrame[] newArray(int i2) {
            return new TextInformationFrame[i2];
        }
    };
    @Nullable
    public final String X;
    @Deprecated
    public final String Y;
    public final ImmutableList<String> Z;

    private TextInformationFrame(Parcel parcel) {
        this((String) Assertions.g(parcel.readString()), parcel.readString(), (List<String>) ImmutableList.D((String[]) Assertions.g(parcel.createStringArray())));
    }

    private static List<Integer> a(String str) {
        int parseInt;
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                parseInt = Integer.parseInt(str.substring(8, 10));
            } else if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                parseInt = Integer.parseInt(str.substring(5, 7));
            } else {
                if (str.length() >= 4) {
                    parseInt = Integer.parseInt(str.substring(0, 4));
                }
                return arrayList;
            }
            arrayList.add(Integer.valueOf(parseInt));
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TextInformationFrame.class != obj.getClass()) {
            return false;
        }
        TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
        return Util.g(this.s, textInformationFrame.s) && Util.g(this.X, textInformationFrame.X) && this.Z.equals(textInformationFrame.Z);
    }

    public int hashCode() {
        int hashCode = (MetaDo.w + this.s.hashCode()) * 31;
        String str = this.X;
        return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.Z.hashCode();
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void q(androidx.media3.common.MediaMetadata.Builder r9) {
        /*
            r8 = this;
            r0 = 4
            java.lang.String r1 = r8.s
            r1.hashCode()
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            r6 = -1
            int r7 = r1.hashCode()
            switch(r7) {
                case 82815: goto L_0x0125;
                case 82878: goto L_0x011a;
                case 82897: goto L_0x010f;
                case 83253: goto L_0x0104;
                case 83254: goto L_0x00f9;
                case 83255: goto L_0x00ee;
                case 83341: goto L_0x00e3;
                case 83378: goto L_0x00d8;
                case 83536: goto L_0x00ca;
                case 83552: goto L_0x00bc;
                case 2567331: goto L_0x00ae;
                case 2569357: goto L_0x00a0;
                case 2569891: goto L_0x0092;
                case 2570401: goto L_0x0084;
                case 2570410: goto L_0x0076;
                case 2571565: goto L_0x0068;
                case 2575251: goto L_0x005a;
                case 2581512: goto L_0x004c;
                case 2581513: goto L_0x003e;
                case 2581514: goto L_0x0030;
                case 2583398: goto L_0x0022;
                case 2590194: goto L_0x0014;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x012f
        L_0x0014:
            java.lang.String r7 = "TYER"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x001e
            goto L_0x012f
        L_0x001e:
            r6 = 21
            goto L_0x012f
        L_0x0022:
            java.lang.String r7 = "TRCK"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x002c
            goto L_0x012f
        L_0x002c:
            r6 = 20
            goto L_0x012f
        L_0x0030:
            java.lang.String r7 = "TPE3"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x003a
            goto L_0x012f
        L_0x003a:
            r6 = 19
            goto L_0x012f
        L_0x003e:
            java.lang.String r7 = "TPE2"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x0048
            goto L_0x012f
        L_0x0048:
            r6 = 18
            goto L_0x012f
        L_0x004c:
            java.lang.String r7 = "TPE1"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x0056
            goto L_0x012f
        L_0x0056:
            r6 = 17
            goto L_0x012f
        L_0x005a:
            java.lang.String r7 = "TIT2"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x0064
            goto L_0x012f
        L_0x0064:
            r6 = 16
            goto L_0x012f
        L_0x0068:
            java.lang.String r7 = "TEXT"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x0072
            goto L_0x012f
        L_0x0072:
            r6 = 15
            goto L_0x012f
        L_0x0076:
            java.lang.String r7 = "TDRL"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x0080
            goto L_0x012f
        L_0x0080:
            r6 = 14
            goto L_0x012f
        L_0x0084:
            java.lang.String r7 = "TDRC"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x008e
            goto L_0x012f
        L_0x008e:
            r6 = 13
            goto L_0x012f
        L_0x0092:
            java.lang.String r7 = "TDAT"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x009c
            goto L_0x012f
        L_0x009c:
            r6 = 12
            goto L_0x012f
        L_0x00a0:
            java.lang.String r7 = "TCOM"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x00aa
            goto L_0x012f
        L_0x00aa:
            r6 = 11
            goto L_0x012f
        L_0x00ae:
            java.lang.String r7 = "TALB"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x00b8
            goto L_0x012f
        L_0x00b8:
            r6 = 10
            goto L_0x012f
        L_0x00bc:
            java.lang.String r7 = "TYE"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x00c6
            goto L_0x012f
        L_0x00c6:
            r6 = 9
            goto L_0x012f
        L_0x00ca:
            java.lang.String r7 = "TXT"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x00d4
            goto L_0x012f
        L_0x00d4:
            r6 = 8
            goto L_0x012f
        L_0x00d8:
            java.lang.String r7 = "TT2"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x00e1
            goto L_0x012f
        L_0x00e1:
            r6 = 7
            goto L_0x012f
        L_0x00e3:
            java.lang.String r7 = "TRK"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x00ec
            goto L_0x012f
        L_0x00ec:
            r6 = 6
            goto L_0x012f
        L_0x00ee:
            java.lang.String r7 = "TP3"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x00f7
            goto L_0x012f
        L_0x00f7:
            r6 = 5
            goto L_0x012f
        L_0x00f9:
            java.lang.String r7 = "TP2"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x0102
            goto L_0x012f
        L_0x0102:
            r6 = 4
            goto L_0x012f
        L_0x0104:
            java.lang.String r7 = "TP1"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x010d
            goto L_0x012f
        L_0x010d:
            r6 = 3
            goto L_0x012f
        L_0x010f:
            java.lang.String r7 = "TDA"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x0118
            goto L_0x012f
        L_0x0118:
            r6 = 2
            goto L_0x012f
        L_0x011a:
            java.lang.String r7 = "TCM"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x0123
            goto L_0x012f
        L_0x0123:
            r6 = 1
            goto L_0x012f
        L_0x0125:
            java.lang.String r7 = "TAL"
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x012e
            goto L_0x012f
        L_0x012e:
            r6 = 0
        L_0x012f:
            switch(r6) {
                case 0: goto L_0x0254;
                case 1: goto L_0x0248;
                case 2: goto L_0x0220;
                case 3: goto L_0x0214;
                case 4: goto L_0x0208;
                case 5: goto L_0x01fc;
                case 6: goto L_0x01cd;
                case 7: goto L_0x01c0;
                case 8: goto L_0x01b3;
                case 9: goto L_0x019e;
                case 10: goto L_0x0254;
                case 11: goto L_0x0248;
                case 12: goto L_0x0220;
                case 13: goto L_0x0169;
                case 14: goto L_0x0134;
                case 15: goto L_0x01b3;
                case 16: goto L_0x01c0;
                case 17: goto L_0x0214;
                case 18: goto L_0x0208;
                case 19: goto L_0x01fc;
                case 20: goto L_0x01cd;
                case 21: goto L_0x019e;
                default: goto L_0x0132;
            }
        L_0x0132:
            goto L_0x025f
        L_0x0134:
            com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.Z
            java.lang.Object r0 = r0.get(r5)
            java.lang.String r0 = (java.lang.String) r0
            java.util.List r0 = a(r0)
            int r1 = r0.size()
            if (r1 == r4) goto L_0x015e
            if (r1 == r3) goto L_0x0155
            if (r1 == r2) goto L_0x014c
            goto L_0x025f
        L_0x014c:
            java.lang.Object r1 = r0.get(r3)
            java.lang.Integer r1 = (java.lang.Integer) r1
            r9.i0(r1)
        L_0x0155:
            java.lang.Object r1 = r0.get(r4)
            java.lang.Integer r1 = (java.lang.Integer) r1
            r9.j0(r1)
        L_0x015e:
            java.lang.Object r0 = r0.get(r5)
            java.lang.Integer r0 = (java.lang.Integer) r0
            r9.k0(r0)
            goto L_0x025f
        L_0x0169:
            com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.Z
            java.lang.Object r0 = r0.get(r5)
            java.lang.String r0 = (java.lang.String) r0
            java.util.List r0 = a(r0)
            int r1 = r0.size()
            if (r1 == r4) goto L_0x0193
            if (r1 == r3) goto L_0x018a
            if (r1 == r2) goto L_0x0181
            goto L_0x025f
        L_0x0181:
            java.lang.Object r1 = r0.get(r3)
            java.lang.Integer r1 = (java.lang.Integer) r1
            r9.f0(r1)
        L_0x018a:
            java.lang.Object r1 = r0.get(r4)
            java.lang.Integer r1 = (java.lang.Integer) r1
            r9.g0(r1)
        L_0x0193:
            java.lang.Object r0 = r0.get(r5)
            java.lang.Integer r0 = (java.lang.Integer) r0
            r9.h0(r0)
            goto L_0x025f
        L_0x019e:
            com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.Z     // Catch:{  }
            java.lang.Object r0 = r0.get(r5)     // Catch:{  }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{  }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{  }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{  }
            r9.h0(r0)     // Catch:{  }
            goto L_0x025f
        L_0x01b3:
            com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.Z
            java.lang.Object r0 = r0.get(r5)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.s0(r0)
            goto L_0x025f
        L_0x01c0:
            com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.Z
            java.lang.Object r0 = r0.get(r5)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.n0(r0)
            goto L_0x025f
        L_0x01cd:
            com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.Z
            java.lang.Object r0 = r0.get(r5)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "/"
            java.lang.String[] r0 = androidx.media3.common.util.Util.p2(r0, r1)
            r1 = r0[r5]     // Catch:{  }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{  }
            int r2 = r0.length     // Catch:{  }
            if (r2 <= r4) goto L_0x01ef
            r0 = r0[r4]     // Catch:{  }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{  }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{  }
            goto L_0x01f0
        L_0x01ef:
            r0 = 0
        L_0x01f0:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{  }
            androidx.media3.common.MediaMetadata$Builder r9 = r9.q0(r1)     // Catch:{  }
            r9.p0(r0)     // Catch:{  }
            goto L_0x025f
        L_0x01fc:
            com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.Z
            java.lang.Object r0 = r0.get(r5)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.U(r0)
            goto L_0x025f
        L_0x0208:
            com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.Z
            java.lang.Object r0 = r0.get(r5)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.M(r0)
            goto L_0x025f
        L_0x0214:
            com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.Z
            java.lang.Object r0 = r0.get(r5)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.O(r0)
            goto L_0x025f
        L_0x0220:
            com.google.common.collect.ImmutableList<java.lang.String> r1 = r8.Z     // Catch:{ NumberFormatException -> 0x025f }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ NumberFormatException -> 0x025f }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ NumberFormatException -> 0x025f }
            java.lang.String r0 = r1.substring(r3, r0)     // Catch:{ NumberFormatException -> 0x025f }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x025f }
            java.lang.String r1 = r1.substring(r5, r3)     // Catch:{ NumberFormatException -> 0x025f }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x025f }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x025f }
            androidx.media3.common.MediaMetadata$Builder r9 = r9.g0(r0)     // Catch:{ NumberFormatException -> 0x025f }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x025f }
            r9.f0(r0)     // Catch:{ NumberFormatException -> 0x025f }
            goto L_0x025f
        L_0x0248:
            com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.Z
            java.lang.Object r0 = r0.get(r5)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.T(r0)
            goto L_0x025f
        L_0x0254:
            com.google.common.collect.ImmutableList<java.lang.String> r0 = r8.Z
            java.lang.Object r0 = r0.get(r5)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.N(r0)
        L_0x025f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.metadata.id3.TextInformationFrame.q(androidx.media3.common.MediaMetadata$Builder):void");
    }

    public String toString() {
        return this.s + ": description=" + this.X + ": values=" + this.Z;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.s);
        parcel.writeString(this.X);
        parcel.writeStringArray((String[]) this.Z.toArray(new String[0]));
    }

    @InlineMe(imports = {"com.google.common.collect.ImmutableList"}, replacement = "this(id, description, ImmutableList.of(value))")
    @Deprecated
    public TextInformationFrame(String str, @Nullable String str2, String str3) {
        this(str, str2, (List<String>) ImmutableList.K(str3));
    }

    public TextInformationFrame(String str, @Nullable String str2, List<String> list) {
        super(str);
        Assertions.a(!list.isEmpty());
        this.X = str2;
        ImmutableList<String> B = ImmutableList.B(list);
        this.Z = B;
        this.Y = B.get(0);
    }
}
