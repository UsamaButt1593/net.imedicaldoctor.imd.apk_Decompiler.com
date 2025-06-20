package com.itextpdf.text.pdf;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.BaseFont;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.lang3.StringUtils;

class TrueTypeFont extends BaseFont {
    static final String[] a5 = {"1252 Latin 1", "1250 Latin 2: Eastern Europe", "1251 Cyrillic", "1253 Greek", "1254 Turkish", "1255 Hebrew", "1256 Arabic", "1257 Windows Baltic", "1258 Vietnamese", null, null, null, null, null, null, null, "874 Thai", "932 JIS/Japan", "936 Chinese: Simplified chars--PRC and Singapore", "949 Korean Wansung", "950 Chinese: Traditional chars--Taiwan and Hong Kong", "1361 Korean Johab", null, null, null, null, null, null, null, "Macintosh Character Set (US Roman)", "OEM Character Set", "Symbol Character Set", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "869 IBM Greek", "866 MS-DOS Russian", "865 MS-DOS Nordic", "864 Arabic", "863 MS-DOS Canadian French", "862 Hebrew", "861 MS-DOS Icelandic", "860 MS-DOS Portuguese", "857 IBM Turkish", "855 IBM Cyrillic; primarily Russian", "852 Latin 2", "775 MS-DOS Baltic", "737 Greek; former 437 G", "708 Arabic; ASMO 708", "850 WE/Latin 1", "437 US"};
    protected boolean A4 = false;
    protected int B4;
    protected int C4;
    protected int D4;
    protected String E4;
    protected String F4 = "";
    protected FontHeader G4 = new FontHeader();
    protected HorizontalHeader H4 = new HorizontalHeader();
    protected WindowsMetrics I4 = new WindowsMetrics();
    protected int[] J4;
    protected int[][] K4;
    protected HashMap<Integer, int[]> L4;
    protected HashMap<Integer, int[]> M4;
    protected HashMap<Integer, int[]> N4;
    protected int[] O4;
    protected int P4;
    protected IntHashtable Q4 = new IntHashtable();
    protected String R4;
    protected String[][] S4;
    protected String[][] T4;
    protected String[][] U4;
    protected String[][] V4;
    protected double W4;
    protected boolean X4 = false;
    protected int Y4;
    protected int Z4;
    protected boolean w4 = false;
    protected HashMap<String, int[]> x4;
    protected RandomAccessFileOrArray y4;
    protected String z4;

    protected static class FontHeader {

        /* renamed from: a  reason: collision with root package name */
        int f26418a;

        /* renamed from: b  reason: collision with root package name */
        int f26419b;

        /* renamed from: c  reason: collision with root package name */
        short f26420c;

        /* renamed from: d  reason: collision with root package name */
        short f26421d;

        /* renamed from: e  reason: collision with root package name */
        short f26422e;

        /* renamed from: f  reason: collision with root package name */
        short f26423f;

        /* renamed from: g  reason: collision with root package name */
        int f26424g;

        protected FontHeader() {
        }
    }

    protected static class HorizontalHeader {

        /* renamed from: a  reason: collision with root package name */
        short f26425a;

        /* renamed from: b  reason: collision with root package name */
        short f26426b;

        /* renamed from: c  reason: collision with root package name */
        short f26427c;

        /* renamed from: d  reason: collision with root package name */
        int f26428d;

        /* renamed from: e  reason: collision with root package name */
        short f26429e;

        /* renamed from: f  reason: collision with root package name */
        short f26430f;

        /* renamed from: g  reason: collision with root package name */
        short f26431g;

        /* renamed from: h  reason: collision with root package name */
        short f26432h;

        /* renamed from: i  reason: collision with root package name */
        short f26433i;

        /* renamed from: j  reason: collision with root package name */
        int f26434j;

        protected HorizontalHeader() {
        }
    }

    protected static class WindowsMetrics {
        int A;
        int B;

        /* renamed from: a  reason: collision with root package name */
        short f26435a;

        /* renamed from: b  reason: collision with root package name */
        int f26436b;

        /* renamed from: c  reason: collision with root package name */
        int f26437c;

        /* renamed from: d  reason: collision with root package name */
        short f26438d;

        /* renamed from: e  reason: collision with root package name */
        short f26439e;

        /* renamed from: f  reason: collision with root package name */
        short f26440f;

        /* renamed from: g  reason: collision with root package name */
        short f26441g;

        /* renamed from: h  reason: collision with root package name */
        short f26442h;

        /* renamed from: i  reason: collision with root package name */
        short f26443i;

        /* renamed from: j  reason: collision with root package name */
        short f26444j;

        /* renamed from: k  reason: collision with root package name */
        short f26445k;

        /* renamed from: l  reason: collision with root package name */
        short f26446l;

        /* renamed from: m  reason: collision with root package name */
        short f26447m;

        /* renamed from: n  reason: collision with root package name */
        short f26448n;
        short o;
        byte[] p = new byte[10];
        byte[] q = new byte[4];
        int r;
        int s;
        int t;
        short u;
        short v;
        short w;
        int x;
        int y;
        int z;

        protected WindowsMetrics() {
        }
    }

    protected TrueTypeFont() {
    }

    protected static String I0(String str) {
        int indexOf = str.toLowerCase().indexOf(".ttc,");
        return indexOf < 0 ? str : str.substring(0, indexOf + 4);
    }

    private void K0() throws DocumentException, IOException {
        int[] iArr;
        int i2 = 0;
        int[] iArr2 = this.x4.get("head");
        if (iArr2 != null) {
            this.y4.r((long) (iArr2[0] + 51));
            boolean z = this.y4.readUnsignedShort() == 0;
            int[] iArr3 = this.x4.get("loca");
            if (iArr3 != null) {
                this.y4.r((long) iArr3[0]);
                if (z) {
                    int i3 = iArr3[1] / 2;
                    iArr = new int[i3];
                    for (int i4 = 0; i4 < i3; i4++) {
                        iArr[i4] = this.y4.readUnsignedShort() * 2;
                    }
                } else {
                    int i5 = iArr3[1] / 4;
                    iArr = new int[i5];
                    for (int i6 = 0; i6 < i5; i6++) {
                        iArr[i6] = this.y4.readInt();
                    }
                }
                int[] iArr4 = this.x4.get("glyf");
                if (iArr4 != null) {
                    int i7 = iArr4[0];
                    this.K4 = new int[(iArr.length - 1)][];
                    while (i2 < iArr.length - 1) {
                        int i8 = iArr[i2];
                        int i9 = i2 + 1;
                        if (i8 != iArr[i9]) {
                            this.y4.r((long) (i8 + i7 + 2));
                            this.K4[i2] = new int[]{(this.y4.readShort() * 1000) / this.G4.f26419b, (this.y4.readShort() * 1000) / this.G4.f26419b, (this.y4.readShort() * 1000) / this.G4.f26419b, (this.y4.readShort() * 1000) / this.G4.f26419b};
                        }
                        i2 = i9;
                    }
                    return;
                }
                throw new DocumentException(MessageLocalization.b("table.1.does.not.exist.in.2", "glyf", this.z4 + this.F4));
            }
            return;
        }
        throw new DocumentException(MessageLocalization.b("table.1.does.not.exist.in.2", "head", this.z4 + this.F4));
    }

    protected static int[] x0(ArrayList<int[]> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            int[] iArr = arrayList.get(i2);
            for (int i3 = 0; i3 < iArr.length; i3 += 2) {
                int i4 = i3 + 1;
                arrayList2.add(new int[]{Math.max(0, Math.min(iArr[i3], iArr[i4])), Math.min(65535, Math.max(iArr[i3], iArr[i4]))});
            }
        }
        int i5 = 0;
        while (i5 < arrayList2.size() - 1) {
            int i6 = i5 + 1;
            int i7 = i6;
            while (i7 < arrayList2.size()) {
                int[] iArr2 = (int[]) arrayList2.get(i5);
                int[] iArr3 = (int[]) arrayList2.get(i7);
                int i8 = iArr2[0];
                int i9 = iArr3[0];
                if ((i8 >= i9 && i8 <= iArr3[1]) || (iArr2[1] >= i9 && i8 <= iArr3[1])) {
                    iArr2[0] = Math.min(i8, i9);
                    iArr2[1] = Math.max(iArr2[1], iArr3[1]);
                    arrayList2.remove(i7);
                    i7--;
                }
                i7++;
            }
            i5 = i6;
        }
        int[] iArr4 = new int[(arrayList2.size() * 2)];
        for (int i10 = 0; i10 < arrayList2.size(); i10++) {
            int[] iArr5 = (int[]) arrayList2.get(i10);
            int i11 = i10 * 2;
            iArr4[i11] = iArr5[0];
            iArr4[i11 + 1] = iArr5[1];
        }
        return iArr4;
    }

    /* access modifiers changed from: package-private */
    public String A0() throws DocumentException, IOException {
        int[] iArr = this.x4.get("name");
        if (iArr != null) {
            this.y4.r((long) (iArr[0] + 2));
            int readUnsignedShort = this.y4.readUnsignedShort();
            int readUnsignedShort2 = this.y4.readUnsignedShort();
            for (int i2 = 0; i2 < readUnsignedShort; i2++) {
                int readUnsignedShort3 = this.y4.readUnsignedShort();
                this.y4.readUnsignedShort();
                this.y4.readUnsignedShort();
                int readUnsignedShort4 = this.y4.readUnsignedShort();
                int readUnsignedShort5 = this.y4.readUnsignedShort();
                int readUnsignedShort6 = this.y4.readUnsignedShort();
                if (readUnsignedShort4 == 6) {
                    this.y4.r((long) (iArr[0] + readUnsignedShort2 + readUnsignedShort6));
                    return (readUnsignedShort3 == 0 || readUnsignedShort3 == 3) ? U0(readUnsignedShort5) : T0(readUnsignedShort5);
                }
            }
            return new File(this.z4).getName().replace(' ', '-');
        }
        throw new DocumentException(MessageLocalization.b("table.1.does.not.exist.in.2", "name", this.z4 + this.F4));
    }

    /* access modifiers changed from: protected */
    public PdfDictionary B0(PdfIndirectReference pdfIndirectReference, String str, int i2, int i3, byte[] bArr) {
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.l8);
        if (this.A4) {
            pdfDictionary.V0(PdfName.Cf, PdfName.Mg);
            PdfName pdfName = PdfName.l4;
            pdfDictionary.V0(pdfName, new PdfName(this.R4 + this.F4));
        } else {
            pdfDictionary.V0(PdfName.Cf, PdfName.Ag);
            PdfName pdfName2 = PdfName.l4;
            pdfDictionary.V0(pdfName2, new PdfName(str + this.R4 + this.F4));
        }
        if (!this.c3) {
            int i4 = i2;
            while (true) {
                if (i4 > i3) {
                    break;
                } else if (!this.Z[i4].equals(BaseFont.t4)) {
                    i2 = i4;
                    break;
                } else {
                    i4++;
                }
            }
            if (this.Z2.equals("Cp1252") || this.Z2.equals(BaseFont.g4)) {
                pdfDictionary.V0(PdfName.m7, this.Z2.equals("Cp1252") ? PdfName.Mh : PdfName.Sa);
            } else {
                PdfDictionary pdfDictionary2 = new PdfDictionary(PdfName.m7);
                PdfArray pdfArray = new PdfArray();
                boolean z = true;
                for (int i5 = i2; i5 <= i3; i5++) {
                    if (bArr[i5] != 0) {
                        if (z) {
                            pdfArray.a0(new PdfNumber(i5));
                            z = false;
                        }
                        pdfArray.a0(new PdfName(this.Z[i5]));
                    } else {
                        z = true;
                    }
                }
                pdfDictionary2.V0(PdfName.F6, pdfArray);
                pdfDictionary.V0(PdfName.m7, pdfDictionary2);
            }
        }
        pdfDictionary.V0(PdfName.V7, new PdfNumber(i2));
        pdfDictionary.V0(PdfName.pa, new PdfNumber(i3));
        PdfArray pdfArray2 = new PdfArray();
        while (i2 <= i3) {
            pdfArray2.a0(bArr[i2] == 0 ? new PdfNumber(0) : new PdfNumber(this.Y[i2]));
            i2++;
        }
        pdfDictionary.V0(PdfName.Kh, pdfArray2);
        if (pdfIndirectReference != null) {
            pdfDictionary.V0(PdfName.n8, pdfIndirectReference);
        }
        return pdfDictionary;
    }

    /* access modifiers changed from: protected */
    public PdfDictionary C0(PdfIndirectReference pdfIndirectReference, String str, PdfIndirectReference pdfIndirectReference2) {
        PdfName pdfName;
        PdfName pdfName2;
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.n8);
        pdfDictionary.V0(PdfName.Y3, new PdfNumber((this.I4.u * 1000) / this.G4.f26419b));
        pdfDictionary.V0(PdfName.R4, new PdfNumber((this.I4.B * 1000) / this.G4.f26419b));
        pdfDictionary.V0(PdfName.w6, new PdfNumber((this.I4.v * 1000) / this.G4.f26419b));
        PdfName pdfName3 = PdfName.m8;
        FontHeader fontHeader = this.G4;
        int i2 = fontHeader.f26419b;
        pdfDictionary.V0(pdfName3, new PdfRectangle((float) ((fontHeader.f26420c * 1000) / i2), (float) ((fontHeader.f26421d * 1000) / i2), (float) ((fontHeader.f26422e * 1000) / i2), (float) ((fontHeader.f26423f * 1000) / i2)));
        if (pdfIndirectReference2 != null) {
            pdfDictionary.V0(PdfName.k5, pdfIndirectReference2);
        }
        if (!this.A4) {
            pdfName = PdfName.t8;
            pdfName2 = new PdfName(str + this.R4 + this.F4);
        } else if (this.Z2.startsWith("Identity-")) {
            pdfName = PdfName.t8;
            pdfName2 = new PdfName(str + this.R4 + "-" + this.Z2);
        } else {
            pdfName = PdfName.t8;
            pdfName2 = new PdfName(str + this.R4 + this.F4);
        }
        pdfDictionary.V0(pdfName, pdfName2);
        pdfDictionary.V0(PdfName.X9, new PdfNumber(this.W4));
        pdfDictionary.V0(PdfName.qf, new PdfNumber(80));
        if (pdfIndirectReference != null) {
            pdfDictionary.V0(this.A4 ? PdfName.r8 : PdfName.q8, pdfIndirectReference);
        }
        boolean z = this.X4 | (this.c3 ? 4 : ' ');
        int i3 = this.G4.f26424g;
        if ((i3 & 2) != 0) {
            z |= true;
        }
        if ((i3 & 1) != 0) {
            z |= true;
        }
        pdfDictionary.V0(PdfName.g8, new PdfNumber(z ? 1 : 0));
        return pdfDictionary;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0021 A[SYNTHETIC, Splitter:B:13:0x0021] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] D0() throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
            com.itextpdf.text.pdf.RandomAccessFileOrArray r1 = new com.itextpdf.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x001b }
            com.itextpdf.text.pdf.RandomAccessFileOrArray r2 = r5.y4     // Catch:{ all -> 0x001b }
            r1.<init>((com.itextpdf.text.pdf.RandomAccessFileOrArray) r2)     // Catch:{ all -> 0x001b }
            r1.g()     // Catch:{ all -> 0x0019 }
            long r2 = r1.e()     // Catch:{ all -> 0x0019 }
            int r0 = (int) r2     // Catch:{ all -> 0x0019 }
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0019 }
            r1.readFully(r0)     // Catch:{ all -> 0x0019 }
            r1.close()     // Catch:{ Exception -> 0x0018 }
        L_0x0018:
            return r0
        L_0x0019:
            r0 = move-exception
            goto L_0x001f
        L_0x001b:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x001f:
            if (r1 == 0) goto L_0x0024
            r1.close()     // Catch:{ Exception -> 0x0024 }
        L_0x0024:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.TrueTypeFont.D0():byte[]");
    }

    /* access modifiers changed from: protected */
    public int E0(int i2) {
        int[] iArr = this.J4;
        if (i2 >= iArr.length) {
            i2 = iArr.length - 1;
        }
        return iArr[i2];
    }

    public int[] F0(int i2) {
        HashMap hashMap;
        Object obj;
        HashMap hashMap2 = this.N4;
        if (hashMap2 == null) {
            boolean z = this.c3;
            if (!z && (hashMap = this.M4) != null) {
                obj = hashMap.get(Integer.valueOf(i2));
                return (int[]) obj;
            } else if ((!z || (hashMap2 = this.L4) == null) && (hashMap2 = this.M4) == null && (hashMap2 = this.L4) == null) {
                return null;
            }
        }
        obj = hashMap2.get(Integer.valueOf(i2));
        return (int[]) obj;
    }

    /* access modifiers changed from: package-private */
    public String[][] G0(int i2) throws DocumentException, IOException {
        int[] iArr;
        int[] iArr2 = this.x4.get("name");
        if (iArr2 != null) {
            this.y4.r((long) (iArr2[0] + 2));
            int readUnsignedShort = this.y4.readUnsignedShort();
            int readUnsignedShort2 = this.y4.readUnsignedShort();
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            while (i3 < readUnsignedShort) {
                int readUnsignedShort3 = this.y4.readUnsignedShort();
                int readUnsignedShort4 = this.y4.readUnsignedShort();
                int readUnsignedShort5 = this.y4.readUnsignedShort();
                int readUnsignedShort6 = this.y4.readUnsignedShort();
                int readUnsignedShort7 = this.y4.readUnsignedShort();
                int readUnsignedShort8 = this.y4.readUnsignedShort();
                if (readUnsignedShort6 == i2) {
                    int d2 = (int) this.y4.d();
                    iArr = iArr2;
                    this.y4.r((long) (iArr2[0] + readUnsignedShort2 + readUnsignedShort8));
                    arrayList.add(new String[]{String.valueOf(readUnsignedShort3), String.valueOf(readUnsignedShort4), String.valueOf(readUnsignedShort5), (readUnsignedShort3 == 0 || readUnsignedShort3 == 3 || (readUnsignedShort3 == 2 && readUnsignedShort4 == 1)) ? U0(readUnsignedShort7) : T0(readUnsignedShort7)});
                    this.y4.r((long) d2);
                } else {
                    iArr = iArr2;
                }
                i3++;
                iArr2 = iArr;
            }
            String[][] strArr = new String[arrayList.size()][];
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                strArr[i4] = (String[]) arrayList.get(i4);
            }
            return strArr;
        }
        throw new DocumentException(MessageLocalization.b("table.1.does.not.exist.in.2", "name", this.z4 + this.F4));
    }

    public String[][] H() {
        return this.V4;
    }

    /* access modifiers changed from: protected */
    public synchronized byte[] H0(HashSet hashSet, boolean z) throws IOException, DocumentException {
        return new TrueTypeFontSubSet(this.z4, new RandomAccessFileOrArray(this.y4), hashSet, this.D4, true, !z).h();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0087, code lost:
        r3 = r3 * ((float) r2);
        r2 = r1.G4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0090, code lost:
        return r3 / ((float) r2.f26419b);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a4, code lost:
        r3 = r3 * ((float) r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public float I(int r2, float r3) {
        /*
            r1 = this;
            switch(r2) {
                case 1: goto L_0x00d7;
                case 2: goto L_0x00c9;
                case 3: goto L_0x00bb;
                case 4: goto L_0x00b7;
                case 5: goto L_0x00b2;
                case 6: goto L_0x00ad;
                case 7: goto L_0x00a8;
                case 8: goto L_0x00a0;
                case 9: goto L_0x009b;
                case 10: goto L_0x0096;
                case 11: goto L_0x0091;
                case 12: goto L_0x0083;
                case 13: goto L_0x0072;
                case 14: goto L_0x0066;
                case 15: goto L_0x0058;
                case 16: goto L_0x004a;
                case 17: goto L_0x003c;
                case 18: goto L_0x002d;
                case 19: goto L_0x001f;
                case 20: goto L_0x0011;
                case 21: goto L_0x000b;
                case 22: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r2 = 0
            return r2
        L_0x0005:
            com.itextpdf.text.pdf.TrueTypeFont$WindowsMetrics r2 = r1.I4
            int r2 = r2.f26437c
            float r2 = (float) r2
            return r2
        L_0x000b:
            com.itextpdf.text.pdf.TrueTypeFont$WindowsMetrics r2 = r1.I4
            int r2 = r2.f26436b
            float r2 = (float) r2
            return r2
        L_0x0011:
            com.itextpdf.text.pdf.TrueTypeFont$WindowsMetrics r2 = r1.I4
            short r2 = r2.f26446l
            float r2 = (float) r2
            float r2 = r2 * r3
            com.itextpdf.text.pdf.TrueTypeFont$FontHeader r3 = r1.G4
            int r3 = r3.f26419b
            float r3 = (float) r3
            float r2 = r2 / r3
            return r2
        L_0x001f:
            com.itextpdf.text.pdf.TrueTypeFont$WindowsMetrics r2 = r1.I4
            short r2 = r2.f26444j
            float r2 = (float) r2
            float r2 = r2 * r3
            com.itextpdf.text.pdf.TrueTypeFont$FontHeader r3 = r1.G4
            int r3 = r3.f26419b
            float r3 = (float) r3
            float r2 = r2 / r3
            return r2
        L_0x002d:
            com.itextpdf.text.pdf.TrueTypeFont$WindowsMetrics r2 = r1.I4
            short r2 = r2.f26442h
            int r2 = -r2
            float r2 = (float) r2
            float r2 = r2 * r3
            com.itextpdf.text.pdf.TrueTypeFont$FontHeader r3 = r1.G4
            int r3 = r3.f26419b
            float r3 = (float) r3
            float r2 = r2 / r3
            return r2
        L_0x003c:
            com.itextpdf.text.pdf.TrueTypeFont$WindowsMetrics r2 = r1.I4
            short r2 = r2.f26440f
            float r2 = (float) r2
            float r2 = r2 * r3
            com.itextpdf.text.pdf.TrueTypeFont$FontHeader r3 = r1.G4
            int r3 = r3.f26419b
            float r3 = (float) r3
            float r2 = r2 / r3
            return r2
        L_0x004a:
            com.itextpdf.text.pdf.TrueTypeFont$WindowsMetrics r2 = r1.I4
            short r2 = r2.f26447m
            float r2 = (float) r2
            float r2 = r2 * r3
            com.itextpdf.text.pdf.TrueTypeFont$FontHeader r3 = r1.G4
            int r3 = r3.f26419b
            float r3 = (float) r3
            float r2 = r2 / r3
            return r2
        L_0x0058:
            com.itextpdf.text.pdf.TrueTypeFont$WindowsMetrics r2 = r1.I4
            short r2 = r2.f26448n
            float r2 = (float) r2
            float r2 = r2 * r3
            com.itextpdf.text.pdf.TrueTypeFont$FontHeader r3 = r1.G4
            int r3 = r3.f26419b
            float r3 = (float) r3
            float r2 = r2 / r3
            return r2
        L_0x0066:
            int r2 = r1.Z4
            float r2 = (float) r2
            float r2 = r2 * r3
            com.itextpdf.text.pdf.TrueTypeFont$FontHeader r3 = r1.G4
            int r3 = r3.f26419b
            float r3 = (float) r3
            float r2 = r2 / r3
            return r2
        L_0x0072:
            int r2 = r1.Y4
            int r0 = r1.Z4
            int r0 = r0 / 2
            int r2 = r2 - r0
            float r2 = (float) r2
            float r2 = r2 * r3
            com.itextpdf.text.pdf.TrueTypeFont$FontHeader r3 = r1.G4
            int r3 = r3.f26419b
            float r3 = (float) r3
            float r2 = r2 / r3
            return r2
        L_0x0083:
            com.itextpdf.text.pdf.TrueTypeFont$HorizontalHeader r2 = r1.H4
            int r2 = r2.f26428d
        L_0x0087:
            float r2 = (float) r2
            float r3 = r3 * r2
            com.itextpdf.text.pdf.TrueTypeFont$FontHeader r2 = r1.G4
        L_0x008c:
            int r2 = r2.f26419b
            float r2 = (float) r2
            float r3 = r3 / r2
            return r3
        L_0x0091:
            com.itextpdf.text.pdf.TrueTypeFont$HorizontalHeader r2 = r1.H4
            short r2 = r2.f26427c
            goto L_0x0087
        L_0x0096:
            com.itextpdf.text.pdf.TrueTypeFont$HorizontalHeader r2 = r1.H4
            short r2 = r2.f26426b
            goto L_0x0087
        L_0x009b:
            com.itextpdf.text.pdf.TrueTypeFont$HorizontalHeader r2 = r1.H4
            short r2 = r2.f26425a
            goto L_0x0087
        L_0x00a0:
            com.itextpdf.text.pdf.TrueTypeFont$FontHeader r2 = r1.G4
            short r0 = r2.f26423f
        L_0x00a4:
            float r0 = (float) r0
            float r3 = r3 * r0
            goto L_0x008c
        L_0x00a8:
            com.itextpdf.text.pdf.TrueTypeFont$FontHeader r2 = r1.G4
            short r0 = r2.f26422e
            goto L_0x00a4
        L_0x00ad:
            com.itextpdf.text.pdf.TrueTypeFont$FontHeader r2 = r1.G4
            short r0 = r2.f26421d
            goto L_0x00a4
        L_0x00b2:
            com.itextpdf.text.pdf.TrueTypeFont$FontHeader r2 = r1.G4
            short r0 = r2.f26420c
            goto L_0x00a4
        L_0x00b7:
            double r2 = r1.W4
            float r2 = (float) r2
            return r2
        L_0x00bb:
            com.itextpdf.text.pdf.TrueTypeFont$WindowsMetrics r2 = r1.I4
            short r2 = r2.v
            float r2 = (float) r2
            float r2 = r2 * r3
            com.itextpdf.text.pdf.TrueTypeFont$FontHeader r3 = r1.G4
            int r3 = r3.f26419b
            float r3 = (float) r3
            float r2 = r2 / r3
            return r2
        L_0x00c9:
            com.itextpdf.text.pdf.TrueTypeFont$WindowsMetrics r2 = r1.I4
            int r2 = r2.B
            float r2 = (float) r2
            float r2 = r2 * r3
            com.itextpdf.text.pdf.TrueTypeFont$FontHeader r3 = r1.G4
            int r3 = r3.f26419b
            float r3 = (float) r3
            float r2 = r2 / r3
            return r2
        L_0x00d7:
            com.itextpdf.text.pdf.TrueTypeFont$WindowsMetrics r2 = r1.I4
            short r2 = r2.u
            float r2 = (float) r2
            float r2 = r2 * r3
            com.itextpdf.text.pdf.TrueTypeFont$FontHeader r3 = r1.G4
            int r3 = r3.f26419b
            float r3 = (float) r3
            float r2 = r2 / r3
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.TrueTypeFont.I(int, float):float");
    }

    /* access modifiers changed from: package-private */
    public void J0(byte[] bArr, boolean z) throws DocumentException, IOException {
        this.x4 = new HashMap<>();
        if (bArr == null) {
            this.y4 = new RandomAccessFileOrArray(this.z4, z, Document.m3);
        } else {
            this.y4 = new RandomAccessFileOrArray(bArr);
        }
        try {
            if (this.E4.length() > 0) {
                int parseInt = Integer.parseInt(this.E4);
                if (parseInt < 0) {
                    throw new DocumentException(MessageLocalization.b("the.font.index.for.1.must.be.positive", this.z4));
                } else if (T0(4).equals("ttcf")) {
                    this.y4.skipBytes(4);
                    int readInt = this.y4.readInt();
                    if (parseInt < readInt) {
                        this.y4.skipBytes(parseInt * 4);
                        this.D4 = this.y4.readInt();
                    } else {
                        throw new DocumentException(MessageLocalization.b("the.font.index.for.1.must.be.between.0.and.2.it.was.3", this.z4, String.valueOf(readInt - 1), String.valueOf(parseInt)));
                    }
                } else {
                    throw new DocumentException(MessageLocalization.b("1.is.not.a.valid.ttc.file", this.z4));
                }
            }
            this.y4.r((long) this.D4);
            int readInt2 = this.y4.readInt();
            if (readInt2 != 65536) {
                if (readInt2 != 1330926671) {
                    throw new DocumentException(MessageLocalization.b("1.is.not.a.valid.ttf.or.otf.file", this.z4));
                }
            }
            int readUnsignedShort = this.y4.readUnsignedShort();
            this.y4.skipBytes(6);
            for (int i2 = 0; i2 < readUnsignedShort; i2++) {
                String T0 = T0(4);
                this.y4.skipBytes(4);
                this.x4.put(T0, new int[]{this.y4.readInt(), this.y4.readInt()});
            }
            w0();
            this.R4 = A0();
            this.T4 = G0(4);
            String[][] G0 = G0(16);
            if (G0.length > 0) {
                this.V4 = G0;
            } else {
                this.V4 = G0(1);
            }
            String[][] G02 = G0(17);
            if (G0.length > 0) {
                this.S4 = G02;
            } else {
                this.S4 = G0(2);
            }
            this.U4 = z0();
            if (!this.w4) {
                y0();
                R0();
                L0();
                S0();
                K0();
            }
            if (!this.a3) {
                this.y4.close();
                this.y4 = null;
            }
        } catch (Throwable th) {
            if (!this.a3) {
                this.y4.close();
                this.y4 = null;
            }
            throw th;
        }
    }

    public String[][] L() {
        return this.T4;
    }

    /* access modifiers changed from: package-private */
    public void L0() throws DocumentException, IOException {
        HashMap<Integer, int[]> N0;
        HashMap<Integer, int[]> N02;
        int[] iArr = this.x4.get("cmap");
        if (iArr != null) {
            this.y4.r((long) iArr[0]);
            this.y4.skipBytes(2);
            int readUnsignedShort = this.y4.readUnsignedShort();
            this.c3 = false;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < readUnsignedShort; i6++) {
                int readUnsignedShort2 = this.y4.readUnsignedShort();
                int readUnsignedShort3 = this.y4.readUnsignedShort();
                int readInt = this.y4.readInt();
                if (readUnsignedShort2 == 3 && readUnsignedShort3 == 0) {
                    this.c3 = true;
                    i4 = readInt;
                } else if (readUnsignedShort2 == 3 && readUnsignedShort3 == 1) {
                    i3 = readInt;
                } else if (readUnsignedShort2 == 3 && readUnsignedShort3 == 10) {
                    i5 = readInt;
                }
                if (readUnsignedShort2 == 1 && readUnsignedShort3 == 0) {
                    i2 = readInt;
                }
            }
            if (i2 > 0) {
                this.y4.r((long) (iArr[0] + i2));
                int readUnsignedShort4 = this.y4.readUnsignedShort();
                if (readUnsignedShort4 == 0) {
                    N02 = N0();
                } else if (readUnsignedShort4 == 4) {
                    N02 = P0();
                } else if (readUnsignedShort4 == 6) {
                    N02 = Q0();
                }
                this.L4 = N02;
            }
            if (i3 > 0) {
                this.y4.r((long) (iArr[0] + i3));
                if (this.y4.readUnsignedShort() == 4) {
                    this.M4 = P0();
                }
            }
            if (i4 > 0) {
                this.y4.r((long) (iArr[0] + i4));
                if (this.y4.readUnsignedShort() == 4) {
                    this.L4 = P0();
                }
            }
            if (i5 > 0) {
                this.y4.r((long) (iArr[0] + i5));
                int readUnsignedShort5 = this.y4.readUnsignedShort();
                if (readUnsignedShort5 == 0) {
                    N0 = N0();
                } else if (readUnsignedShort5 == 4) {
                    N0 = P0();
                } else if (readUnsignedShort5 == 6) {
                    N0 = Q0();
                } else if (readUnsignedShort5 == 12) {
                    N0 = O0();
                } else {
                    return;
                }
                this.N4 = N0;
                return;
            }
            return;
        }
        throw new DocumentException(MessageLocalization.b("table.1.does.not.exist.in.2", "cmap", this.z4 + this.F4));
    }

    /* access modifiers changed from: protected */
    public byte[] M0() throws IOException {
        RandomAccessFileOrArray randomAccessFileOrArray = new RandomAccessFileOrArray(this.y4);
        byte[] bArr = new byte[this.C4];
        try {
            randomAccessFileOrArray.g();
            randomAccessFileOrArray.r((long) this.B4);
            randomAccessFileOrArray.readFully(bArr);
            return bArr;
        } finally {
            try {
                randomAccessFileOrArray.close();
            } catch (Exception unused) {
            }
        }
    }

    public PdfStream N() throws IOException, DocumentException {
        if (this.A4) {
            return new BaseFont.StreamFont(M0(), "Type1C", this.b3);
        }
        byte[] D0 = D0();
        return new BaseFont.StreamFont(D0, new int[]{D0.length}, this.b3);
    }

    /* access modifiers changed from: package-private */
    public HashMap<Integer, int[]> N0() throws IOException {
        HashMap<Integer, int[]> hashMap = new HashMap<>();
        this.y4.skipBytes(4);
        for (int i2 = 0; i2 < 256; i2++) {
            int readUnsignedByte = this.y4.readUnsignedByte();
            hashMap.put(Integer.valueOf(i2), new int[]{readUnsignedByte, E0(readUnsignedByte)});
        }
        return hashMap;
    }

    public int O(int i2, int i3) {
        int[] F0 = F0(i2);
        if (F0 == null) {
            return 0;
        }
        int i4 = F0[0];
        int[] F02 = F0(i3);
        if (F02 == null) {
            return 0;
        }
        return this.Q4.e((i4 << 16) + F02[0]);
    }

    /* access modifiers changed from: package-private */
    public HashMap<Integer, int[]> O0() throws IOException {
        HashMap<Integer, int[]> hashMap = new HashMap<>();
        this.y4.skipBytes(2);
        this.y4.readInt();
        this.y4.skipBytes(4);
        int readInt = this.y4.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            int readInt2 = this.y4.readInt();
            int readInt3 = this.y4.readInt();
            for (int readInt4 = this.y4.readInt(); readInt4 <= readInt2; readInt4++) {
                hashMap.put(Integer.valueOf(readInt4), new int[]{readInt3, E0(readInt3)});
                readInt3++;
            }
        }
        return hashMap;
    }

    public String P() {
        return this.R4;
    }

    /* access modifiers changed from: package-private */
    public HashMap<Integer, int[]> P0() throws IOException {
        int i2;
        HashMap<Integer, int[]> hashMap = new HashMap<>();
        int readUnsignedShort = this.y4.readUnsignedShort();
        this.y4.skipBytes(2);
        int readUnsignedShort2 = this.y4.readUnsignedShort() / 2;
        this.y4.skipBytes(6);
        int[] iArr = new int[readUnsignedShort2];
        for (int i3 = 0; i3 < readUnsignedShort2; i3++) {
            iArr[i3] = this.y4.readUnsignedShort();
        }
        this.y4.skipBytes(2);
        int[] iArr2 = new int[readUnsignedShort2];
        for (int i4 = 0; i4 < readUnsignedShort2; i4++) {
            iArr2[i4] = this.y4.readUnsignedShort();
        }
        int[] iArr3 = new int[readUnsignedShort2];
        for (int i5 = 0; i5 < readUnsignedShort2; i5++) {
            iArr3[i5] = this.y4.readUnsignedShort();
        }
        int[] iArr4 = new int[readUnsignedShort2];
        for (int i6 = 0; i6 < readUnsignedShort2; i6++) {
            iArr4[i6] = this.y4.readUnsignedShort();
        }
        int i7 = ((readUnsignedShort / 2) - 8) - (readUnsignedShort2 * 4);
        int[] iArr5 = new int[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            iArr5[i8] = this.y4.readUnsignedShort();
        }
        for (int i9 = 0; i9 < readUnsignedShort2; i9++) {
            int i10 = iArr2[i9];
            while (i10 <= iArr[i9] && i10 != 65535) {
                int i11 = iArr4[i9];
                if (i11 == 0) {
                    i2 = iArr3[i9] + i10;
                } else {
                    int i12 = ((((i11 / 2) + i9) - readUnsignedShort2) + i10) - iArr2[i9];
                    if (i12 >= i7) {
                        i10++;
                    } else {
                        i2 = iArr5[i12] + iArr3[i9];
                    }
                }
                int i13 = 65535 & i2;
                hashMap.put(Integer.valueOf((!this.c3 || (65280 & i10) != 61440) ? i10 : i10 & 255), new int[]{i13, E0(i13)});
                i10++;
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public int[] Q(int i2, String str) {
        HashMap<Integer, int[]> hashMap;
        int[] iArr;
        int[][] iArr2;
        if (str == null || (hashMap = this.M4) == null) {
            hashMap = this.L4;
        }
        if (hashMap == null || (iArr = hashMap.get(Integer.valueOf(i2))) == null || (iArr2 = this.K4) == null) {
            return null;
        }
        return iArr2[iArr[0]];
    }

    /* access modifiers changed from: package-private */
    public HashMap<Integer, int[]> Q0() throws IOException {
        HashMap<Integer, int[]> hashMap = new HashMap<>();
        this.y4.skipBytes(4);
        int readUnsignedShort = this.y4.readUnsignedShort();
        int readUnsignedShort2 = this.y4.readUnsignedShort();
        for (int i2 = 0; i2 < readUnsignedShort2; i2++) {
            int readUnsignedShort3 = this.y4.readUnsignedShort();
            hashMap.put(Integer.valueOf(i2 + readUnsignedShort), new int[]{readUnsignedShort3, E0(readUnsignedShort3)});
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public int R(int i2, String str) {
        int[] F0 = F0(i2);
        if (F0 == null) {
            return 0;
        }
        return F0[1];
    }

    /* access modifiers changed from: protected */
    public void R0() throws DocumentException, IOException {
        int[] iArr = this.x4.get("hmtx");
        if (iArr != null) {
            this.y4.r((long) iArr[0]);
            this.J4 = new int[this.H4.f26434j];
            for (int i2 = 0; i2 < this.H4.f26434j; i2++) {
                this.J4[i2] = (this.y4.readUnsignedShort() * 1000) / this.G4.f26419b;
                int readShort = (this.y4.readShort() * 1000) / this.G4.f26419b;
            }
            return;
        }
        throw new DocumentException(MessageLocalization.b("table.1.does.not.exist.in.2", "hmtx", this.z4 + this.F4));
    }

    public String S() {
        String[][] strArr = this.S4;
        return (strArr == null || strArr.length <= 0) ? super.S() : strArr[0][3];
    }

    /* access modifiers changed from: package-private */
    public void S0() throws IOException {
        int[] iArr = this.x4.get("kern");
        if (iArr != null) {
            this.y4.r((long) (iArr[0] + 2));
            int readUnsignedShort = this.y4.readUnsignedShort();
            int i2 = iArr[0] + 4;
            int i3 = 0;
            for (int i4 = 0; i4 < readUnsignedShort; i4++) {
                i2 += i3;
                this.y4.r((long) i2);
                this.y4.skipBytes(2);
                i3 = this.y4.readUnsignedShort();
                if ((this.y4.readUnsignedShort() & 65527) == 1) {
                    int readUnsignedShort2 = this.y4.readUnsignedShort();
                    this.y4.skipBytes(6);
                    for (int i5 = 0; i5 < readUnsignedShort2; i5++) {
                        this.Q4.l(this.y4.readInt(), (this.y4.readShort() * 1000) / this.G4.f26419b);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public String T0(int i2) throws IOException {
        return this.y4.n(i2, "Cp1252");
    }

    /* access modifiers changed from: protected */
    public String U0(int i2) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i2 / 2;
        for (int i4 = 0; i4 < i3; i4++) {
            stringBuffer.append(this.y4.readChar());
        }
        return stringBuffer.toString();
    }

    public boolean c0() {
        return this.Q4.o() > 0;
    }

    public boolean q0(int i2, int i3, int i4) {
        int[] F0 = F0(i2);
        if (F0 == null) {
            return false;
        }
        int i5 = F0[0];
        int[] F02 = F0(i3);
        if (F02 == null) {
            return false;
        }
        this.Q4.l((i5 << 16) + F02[0], i4);
        return true;
    }

    public void r0(String str) {
        this.R4 = str;
    }

    public String[][] s() {
        return this.U4;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v18, resolved type: char} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00a1 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void t0(com.itextpdf.text.pdf.PdfWriter r12, com.itextpdf.text.pdf.PdfIndirectReference r13, java.lang.Object[] r14) throws com.itextpdf.text.DocumentException, java.io.IOException {
        /*
            r11 = this;
            r0 = 0
            r1 = r14[r0]
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r2 = 1
            r3 = r14[r2]
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r4 = 2
            r4 = r14[r4]
            r10 = r4
            byte[] r10 = (byte[]) r10
            r4 = 3
            r14 = r14[r4]
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x0029
            boolean r14 = r11.f3
            if (r14 == 0) goto L_0x0029
            r14 = 1
            goto L_0x002a
        L_0x0029:
            r14 = 0
        L_0x002a:
            if (r14 != 0) goto L_0x003b
            int r1 = r10.length
            int r3 = r1 + -1
            r1 = 0
        L_0x0030:
            int r4 = r10.length
            if (r1 >= r4) goto L_0x0038
            r10[r1] = r2
            int r1 = r1 + 1
            goto L_0x0030
        L_0x0038:
            r9 = r3
            r8 = 0
            goto L_0x003d
        L_0x003b:
            r8 = r1
            r9 = r3
        L_0x003d:
            boolean r1 = r11.a3
            r2 = 0
            java.lang.String r3 = ""
            if (r1 == 0) goto L_0x00d1
            boolean r1 = r11.A4
            if (r1 == 0) goto L_0x0060
            com.itextpdf.text.pdf.BaseFont$StreamFont r14 = new com.itextpdf.text.pdf.BaseFont$StreamFont
            byte[] r0 = r11.M0()
            java.lang.String r1 = "Type1C"
            int r4 = r11.b3
            r14.<init>((byte[]) r0, (java.lang.String) r1, (int) r4)
            com.itextpdf.text.pdf.PdfIndirectObject r14 = r12.v0(r14)
        L_0x0059:
            com.itextpdf.text.pdf.PdfIndirectReference r14 = r14.a()
        L_0x005d:
            r7 = r3
            goto L_0x00d3
        L_0x0060:
            if (r14 == 0) goto L_0x0066
            java.lang.String r3 = com.itextpdf.text.pdf.BaseFont.o()
        L_0x0066:
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            r4 = r8
        L_0x006c:
            if (r4 > r9) goto L_0x00a4
            byte r5 = r10[r4]
            if (r5 == 0) goto L_0x00a1
            com.itextpdf.text.pdf.IntHashtable r5 = r11.h3
            if (r5 == 0) goto L_0x0085
            java.lang.String[] r5 = r11.Z
            r5 = r5[r4]
            int[] r5 = com.itextpdf.text.pdf.GlyphList.a(r5)
            if (r5 == 0) goto L_0x0083
            r5 = r5[r0]
            goto L_0x0092
        L_0x0083:
            r5 = r2
            goto L_0x0096
        L_0x0085:
            boolean r5 = r11.c3
            if (r5 == 0) goto L_0x008e
            int[] r5 = r11.F0(r4)
            goto L_0x0096
        L_0x008e:
            char[] r5 = r11.X2
            char r5 = r5[r4]
        L_0x0092:
            int[] r5 = r11.F0(r5)
        L_0x0096:
            if (r5 == 0) goto L_0x00a1
            r5 = r5[r0]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r1.add(r5)
        L_0x00a1:
            int r4 = r4 + 1
            goto L_0x006c
        L_0x00a4:
            r11.v0(r1, r14)
            if (r14 != 0) goto L_0x00b7
            int r0 = r11.D4
            if (r0 != 0) goto L_0x00b7
            java.util.ArrayList<int[]> r0 = r11.s
            if (r0 == 0) goto L_0x00b2
            goto L_0x00b7
        L_0x00b2:
            byte[] r14 = r11.D0()
            goto L_0x00c0
        L_0x00b7:
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>(r1)
            byte[] r14 = r11.H0(r0, r14)
        L_0x00c0:
            int r0 = r14.length
            int[] r0 = new int[]{r0}
            com.itextpdf.text.pdf.BaseFont$StreamFont r1 = new com.itextpdf.text.pdf.BaseFont$StreamFont
            int r4 = r11.b3
            r1.<init>((byte[]) r14, (int[]) r0, (int) r4)
            com.itextpdf.text.pdf.PdfIndirectObject r14 = r12.v0(r1)
            goto L_0x0059
        L_0x00d1:
            r14 = r2
            goto L_0x005d
        L_0x00d3:
            com.itextpdf.text.pdf.PdfDictionary r0 = r11.C0(r14, r7, r2)
            if (r0 == 0) goto L_0x00e1
            com.itextpdf.text.pdf.PdfIndirectObject r14 = r12.v0(r0)
            com.itextpdf.text.pdf.PdfIndirectReference r14 = r14.a()
        L_0x00e1:
            r6 = r14
            r5 = r11
            com.itextpdf.text.pdf.PdfDictionary r14 = r5.B0(r6, r7, r8, r9, r10)
            r12.y0(r14, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.TrueTypeFont.t0(com.itextpdf.text.pdf.PdfWriter, com.itextpdf.text.pdf.PdfIndirectReference, java.lang.Object[]):void");
    }

    /* access modifiers changed from: protected */
    public void u0(HashMap<Integer, int[]> hashMap, boolean z, boolean z2) {
        HashMap<Integer, int[]> hashMap2;
        if (!z2) {
            ArrayList<int[]> arrayList = this.s;
            if (arrayList != null || this.D4 > 0) {
                int[] x0 = (arrayList != null || this.D4 <= 0) ? x0(arrayList) : new int[]{0, 65535};
                boolean z3 = this.c3;
                if ((z3 || (hashMap2 = this.M4) == null) && ((!z3 || (hashMap2 = this.L4) == null) && (hashMap2 = this.M4) == null)) {
                    hashMap2 = this.L4;
                }
                for (Map.Entry next : hashMap2.entrySet()) {
                    int[] iArr = (int[]) next.getValue();
                    Integer valueOf = Integer.valueOf(iArr[0]);
                    if (!hashMap.containsKey(valueOf)) {
                        int intValue = ((Integer) next.getKey()).intValue();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= x0.length) {
                                break;
                            } else if (intValue < x0[i2] || intValue > x0[i2 + 1]) {
                                i2 += 2;
                            } else {
                                hashMap.put(valueOf, z ? new int[]{iArr[0], iArr[1], intValue} : null);
                            }
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void v0(HashSet<Integer> hashSet, boolean z) {
        HashMap<Integer, int[]> hashMap;
        if (!z) {
            ArrayList<int[]> arrayList = this.s;
            if (arrayList != null || this.D4 > 0) {
                int[] x0 = (arrayList != null || this.D4 <= 0) ? x0(arrayList) : new int[]{0, 65535};
                boolean z2 = this.c3;
                if ((z2 || (hashMap = this.M4) == null) && ((!z2 || (hashMap = this.L4) == null) && (hashMap = this.M4) == null)) {
                    hashMap = this.L4;
                }
                for (Map.Entry next : hashMap.entrySet()) {
                    Integer valueOf = Integer.valueOf(((int[]) next.getValue())[0]);
                    if (!hashSet.contains(valueOf)) {
                        int intValue = ((Integer) next.getKey()).intValue();
                        int i2 = 0;
                        while (true) {
                            if (i2 < x0.length) {
                                if (intValue >= x0[i2] && intValue <= x0[i2 + 1]) {
                                    hashSet.add(valueOf);
                                    break;
                                }
                                i2 += 2;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void w0() {
        int[] iArr = this.x4.get("CFF ");
        if (iArr != null) {
            this.A4 = true;
            this.B4 = iArr[0];
            this.C4 = iArr[1];
        }
    }

    /* access modifiers changed from: package-private */
    public void y0() throws DocumentException, IOException {
        int readUnsignedShort;
        int i2;
        WindowsMetrics windowsMetrics;
        WindowsMetrics windowsMetrics2;
        int i3;
        boolean z = true;
        int[] iArr = this.x4.get("head");
        if (iArr != null) {
            this.y4.r((long) (iArr[0] + 16));
            this.G4.f26418a = this.y4.readUnsignedShort();
            this.G4.f26419b = this.y4.readUnsignedShort();
            this.y4.skipBytes(16);
            this.G4.f26420c = this.y4.readShort();
            this.G4.f26421d = this.y4.readShort();
            this.G4.f26422e = this.y4.readShort();
            this.G4.f26423f = this.y4.readShort();
            this.G4.f26424g = this.y4.readUnsignedShort();
            int[] iArr2 = this.x4.get("hhea");
            if (iArr2 != null) {
                this.y4.r((long) (iArr2[0] + 4));
                this.H4.f26425a = this.y4.readShort();
                this.H4.f26426b = this.y4.readShort();
                this.H4.f26427c = this.y4.readShort();
                this.H4.f26428d = this.y4.readUnsignedShort();
                this.H4.f26429e = this.y4.readShort();
                this.H4.f26430f = this.y4.readShort();
                this.H4.f26431g = this.y4.readShort();
                this.H4.f26432h = this.y4.readShort();
                this.H4.f26433i = this.y4.readShort();
                this.y4.skipBytes(12);
                this.H4.f26434j = this.y4.readUnsignedShort();
                int[] iArr3 = this.x4.get("OS/2");
                if (iArr3 != null) {
                    this.y4.r((long) iArr3[0]);
                    int readUnsignedShort2 = this.y4.readUnsignedShort();
                    this.I4.f26435a = this.y4.readShort();
                    this.I4.f26436b = this.y4.readUnsignedShort();
                    this.I4.f26437c = this.y4.readUnsignedShort();
                    this.I4.f26438d = this.y4.readShort();
                    this.I4.f26439e = this.y4.readShort();
                    this.I4.f26440f = this.y4.readShort();
                    this.I4.f26441g = this.y4.readShort();
                    this.I4.f26442h = this.y4.readShort();
                    this.I4.f26443i = this.y4.readShort();
                    this.I4.f26444j = this.y4.readShort();
                    this.I4.f26445k = this.y4.readShort();
                    this.I4.f26446l = this.y4.readShort();
                    this.I4.f26447m = this.y4.readShort();
                    this.I4.f26448n = this.y4.readShort();
                    this.I4.o = this.y4.readShort();
                    this.y4.readFully(this.I4.p);
                    this.y4.skipBytes(16);
                    this.y4.readFully(this.I4.q);
                    this.I4.r = this.y4.readUnsignedShort();
                    this.I4.s = this.y4.readUnsignedShort();
                    this.I4.t = this.y4.readUnsignedShort();
                    this.I4.u = this.y4.readShort();
                    this.I4.v = this.y4.readShort();
                    WindowsMetrics windowsMetrics3 = this.I4;
                    short s = windowsMetrics3.v;
                    if (s > 0) {
                        windowsMetrics3.v = (short) (-s);
                    }
                    windowsMetrics3.w = this.y4.readShort();
                    this.I4.x = this.y4.readUnsignedShort();
                    this.I4.y = this.y4.readUnsignedShort();
                    WindowsMetrics windowsMetrics4 = this.I4;
                    windowsMetrics4.z = 0;
                    windowsMetrics4.A = 0;
                    if (readUnsignedShort2 > 0) {
                        windowsMetrics4.z = this.y4.readInt();
                        this.I4.A = this.y4.readInt();
                    }
                    if (readUnsignedShort2 > 1) {
                        this.y4.skipBytes(2);
                        windowsMetrics2 = this.I4;
                        i3 = this.y4.readShort();
                    } else {
                        windowsMetrics2 = this.I4;
                        i3 = (int) (((double) this.G4.f26419b) * 0.7d);
                    }
                    windowsMetrics2.B = i3;
                } else if (!(this.x4.get("hhea") == null || this.x4.get("head") == null)) {
                    int i4 = this.G4.f26424g;
                    int i5 = 5;
                    if (i4 == 0) {
                        windowsMetrics = this.I4;
                        i2 = TypedValues.TransitionType.f4033j;
                    } else {
                        i2 = 400;
                        if (i4 == 5) {
                            windowsMetrics = this.I4;
                            windowsMetrics.f26436b = 400;
                            i5 = 3;
                        } else if (i4 == 6) {
                            windowsMetrics = this.I4;
                            windowsMetrics.f26436b = 400;
                            i5 = 7;
                        } else {
                            windowsMetrics = this.I4;
                        }
                        windowsMetrics.f26437c = i5;
                        WindowsMetrics windowsMetrics5 = this.I4;
                        windowsMetrics5.f26438d = 0;
                        windowsMetrics5.f26440f = 0;
                        windowsMetrics5.f26442h = 0;
                        windowsMetrics5.f26444j = 0;
                        windowsMetrics5.f26446l = 0;
                        windowsMetrics5.f26447m = 0;
                        windowsMetrics5.f26448n = 0;
                        HorizontalHeader horizontalHeader = this.H4;
                        short s2 = horizontalHeader.f26425a;
                        windowsMetrics5.u = (short) ((int) (((double) s2) - (((double) s2) * 0.21d)));
                        windowsMetrics5.v = (short) ((int) (-(((double) Math.abs(horizontalHeader.f26426b)) - (((double) Math.abs(this.H4.f26426b)) * 0.07d))));
                        WindowsMetrics windowsMetrics6 = this.I4;
                        HorizontalHeader horizontalHeader2 = this.H4;
                        windowsMetrics6.w = (short) (horizontalHeader2.f26427c * 2);
                        windowsMetrics6.x = horizontalHeader2.f26425a;
                        windowsMetrics6.y = horizontalHeader2.f26426b;
                        windowsMetrics6.z = 0;
                        windowsMetrics6.A = 0;
                        windowsMetrics6.B = (int) (((double) this.G4.f26419b) * 0.7d);
                    }
                    windowsMetrics.f26436b = i2;
                    windowsMetrics.f26437c = i5;
                    WindowsMetrics windowsMetrics52 = this.I4;
                    windowsMetrics52.f26438d = 0;
                    windowsMetrics52.f26440f = 0;
                    windowsMetrics52.f26442h = 0;
                    windowsMetrics52.f26444j = 0;
                    windowsMetrics52.f26446l = 0;
                    windowsMetrics52.f26447m = 0;
                    windowsMetrics52.f26448n = 0;
                    HorizontalHeader horizontalHeader3 = this.H4;
                    short s22 = horizontalHeader3.f26425a;
                    windowsMetrics52.u = (short) ((int) (((double) s22) - (((double) s22) * 0.21d)));
                    windowsMetrics52.v = (short) ((int) (-(((double) Math.abs(horizontalHeader3.f26426b)) - (((double) Math.abs(this.H4.f26426b)) * 0.07d))));
                    WindowsMetrics windowsMetrics62 = this.I4;
                    HorizontalHeader horizontalHeader22 = this.H4;
                    windowsMetrics62.w = (short) (horizontalHeader22.f26427c * 2);
                    windowsMetrics62.x = horizontalHeader22.f26425a;
                    windowsMetrics62.y = horizontalHeader22.f26426b;
                    windowsMetrics62.z = 0;
                    windowsMetrics62.A = 0;
                    windowsMetrics62.B = (int) (((double) this.G4.f26419b) * 0.7d);
                }
                int[] iArr4 = this.x4.get("post");
                if (iArr4 == null) {
                    HorizontalHeader horizontalHeader4 = this.H4;
                    this.W4 = ((-Math.atan2((double) horizontalHeader4.f26433i, (double) horizontalHeader4.f26432h)) * 180.0d) / 3.141592653589793d;
                } else {
                    this.y4.r((long) (iArr4[0] + 4));
                    this.W4 = ((double) this.y4.readShort()) + (((double) this.y4.readUnsignedShort()) / 16384.0d);
                    this.Y4 = this.y4.readShort();
                    this.Z4 = this.y4.readShort();
                    if (this.y4.readInt() == 0) {
                        z = false;
                    }
                    this.X4 = z;
                }
                int[] iArr5 = this.x4.get("maxp");
                if (iArr5 == null) {
                    readUnsignedShort = 65536;
                } else {
                    this.y4.r((long) (iArr5[0] + 4));
                    readUnsignedShort = this.y4.readUnsignedShort();
                }
                this.P4 = readUnsignedShort;
                return;
            }
            throw new DocumentException(MessageLocalization.b("table.1.does.not.exist.in.2", "hhea", this.z4 + this.F4));
        }
        throw new DocumentException(MessageLocalization.b("table.1.does.not.exist.in.2", "head", this.z4 + this.F4));
    }

    public String[] z() {
        String str;
        WindowsMetrics windowsMetrics = this.I4;
        long j2 = (((long) windowsMetrics.A) << 32) + (((long) windowsMetrics.z) & InternalZipConstants.f30717k);
        long j3 = 1;
        int i2 = 0;
        for (int i3 = 0; i3 < 64; i3++) {
            if (!((j2 & j3) == 0 || a5[i3] == null)) {
                i2++;
            }
            j3 <<= 1;
        }
        String[] strArr = new String[i2];
        long j4 = 1;
        int i4 = 0;
        for (int i5 = 0; i5 < 64; i5++) {
            if (!((j2 & j4) == 0 || (str = a5[i5]) == null)) {
                strArr[i4] = str;
                i4++;
            }
            j4 <<= 1;
        }
        return strArr;
    }

    /* access modifiers changed from: package-private */
    public String[][] z0() throws DocumentException, IOException {
        int[] iArr = this.x4.get("name");
        if (iArr != null) {
            this.y4.r((long) (iArr[0] + 2));
            int readUnsignedShort = this.y4.readUnsignedShort();
            int readUnsignedShort2 = this.y4.readUnsignedShort();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < readUnsignedShort; i2++) {
                int readUnsignedShort3 = this.y4.readUnsignedShort();
                int readUnsignedShort4 = this.y4.readUnsignedShort();
                int readUnsignedShort5 = this.y4.readUnsignedShort();
                int readUnsignedShort6 = this.y4.readUnsignedShort();
                int readUnsignedShort7 = this.y4.readUnsignedShort();
                int readUnsignedShort8 = this.y4.readUnsignedShort();
                int d2 = (int) this.y4.d();
                this.y4.r((long) (iArr[0] + readUnsignedShort2 + readUnsignedShort8));
                arrayList.add(new String[]{String.valueOf(readUnsignedShort6), String.valueOf(readUnsignedShort3), String.valueOf(readUnsignedShort4), String.valueOf(readUnsignedShort5), (readUnsignedShort3 == 0 || readUnsignedShort3 == 3 || (readUnsignedShort3 == 2 && readUnsignedShort4 == 1)) ? U0(readUnsignedShort7) : T0(readUnsignedShort7)});
                this.y4.r((long) d2);
            }
            String[][] strArr = new String[arrayList.size()][];
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                strArr[i3] = (String[]) arrayList.get(i3);
            }
            return strArr;
        }
        throw new DocumentException(MessageLocalization.b("table.1.does.not.exist.in.2", "name", this.z4 + this.F4));
    }

    TrueTypeFont(String str, String str2, boolean z, byte[] bArr, boolean z2, boolean z3) throws DocumentException, IOException {
        this.w4 = z2;
        String w = BaseFont.w(str);
        String I0 = I0(w);
        if (w.length() < str.length()) {
            this.F4 = str.substring(w.length());
        }
        this.Z2 = str2;
        this.a3 = z;
        this.z4 = I0;
        this.X = 1;
        this.E4 = "";
        if (I0.length() < w.length()) {
            this.E4 = w.substring(I0.length() + 1);
        }
        if (this.z4.toLowerCase().endsWith(".ttf") || this.z4.toLowerCase().endsWith(".otf") || this.z4.toLowerCase().endsWith(".ttc")) {
            J0(bArr, z3);
            if (z2 || !this.a3 || this.I4.f26438d != 2) {
                if (!this.Z2.startsWith("#")) {
                    PdfEncodings.c(StringUtils.SPACE, str2);
                }
                g();
                return;
            }
            throw new DocumentException(MessageLocalization.b("1.cannot.be.embedded.due.to.licensing.restrictions", this.z4 + this.F4));
        }
        throw new DocumentException(MessageLocalization.b("1.is.not.a.ttf.otf.or.ttc.font.file", this.z4 + this.F4));
    }
}
