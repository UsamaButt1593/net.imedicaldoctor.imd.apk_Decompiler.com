package com.itextpdf.text.pdf;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.fonts.FontsResourceAnchor;
import java.io.IOException;
import java.util.HashMap;

class Type1Font extends BaseFont {
    private static FontsResourceAnchor V4;
    private static final int[] W4 = {1, 2, 1};
    private String A4 = "";
    private float B4 = 0.0f;
    private boolean C4 = false;
    private String D4;
    private int E4 = -50;
    private int F4 = -200;
    private int G4 = 1000;
    private int H4 = TypedValues.Custom.f3957j;
    private int I4 = -100;
    private int J4 = 50;
    private String K4 = "FontSpecific";
    private int L4 = TypedValues.TransitionType.f4033j;
    private int M4 = 480;
    private int N4 = 800;
    private int O4 = -200;
    private int P4;
    private int Q4 = 80;
    private HashMap<Object, Object[]> R4 = new HashMap<>();
    private HashMap<String, Object[]> S4 = new HashMap<>();
    private String T4;
    private boolean U4 = false;
    protected byte[] w4;
    private String x4;
    private String y4;
    private String z4;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: com.itextpdf.text.pdf.RandomAccessFileOrArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: com.itextpdf.text.pdf.RandomAccessFileOrArray} */
    /* JADX WARNING: type inference failed for: r2v5, types: [com.itextpdf.text.pdf.RandomAccessFileOrArray] */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v14, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r2v17 */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:20|21|(2:22|(1:102)(2:44|45))|24|25|26|27|28|29|30|31|32) */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d9, code lost:
        r5 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x00c6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00dc A[SYNTHETIC, Splitter:B:38:0x00dc] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00fe A[SYNTHETIC, Splitter:B:49:0x00fe] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0199 A[SYNTHETIC, Splitter:B:96:0x0199] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    Type1Font(java.lang.String r5, java.lang.String r6, boolean r7, byte[] r8, byte[] r9, boolean r10) throws com.itextpdf.text.DocumentException, java.io.IOException {
        /*
            r4 = this;
            r0 = 1
            r4.<init>()
            java.lang.String r1 = ""
            r4.A4 = r1
            r1 = 0
            r4.B4 = r1
            r1 = 0
            r4.C4 = r1
            r2 = -50
            r4.E4 = r2
            r2 = -200(0xffffffffffffff38, float:NaN)
            r4.F4 = r2
            r3 = 1000(0x3e8, float:1.401E-42)
            r4.G4 = r3
            r3 = 900(0x384, float:1.261E-42)
            r4.H4 = r3
            r3 = -100
            r4.I4 = r3
            r3 = 50
            r4.J4 = r3
            java.lang.String r3 = "FontSpecific"
            r4.K4 = r3
            r3 = 700(0x2bc, float:9.81E-43)
            r4.L4 = r3
            r3 = 480(0x1e0, float:6.73E-43)
            r4.M4 = r3
            r3 = 800(0x320, float:1.121E-42)
            r4.N4 = r3
            r4.O4 = r2
            r2 = 80
            r4.Q4 = r2
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r4.R4 = r2
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r4.S4 = r2
            r4.U4 = r1
            if (r7 == 0) goto L_0x0061
            if (r8 == 0) goto L_0x0061
            if (r9 == 0) goto L_0x0053
            goto L_0x0061
        L_0x0053:
            com.itextpdf.text.DocumentException r5 = new com.itextpdf.text.DocumentException
            java.lang.String r6 = "two.byte.arrays.are.needed.if.the.type1.font.is.embedded"
            java.lang.Object[] r7 = new java.lang.Object[r1]
            java.lang.String r6 = com.itextpdf.text.error_messages.MessageLocalization.b(r6, r7)
            r5.<init>((java.lang.String) r6)
            throw r5
        L_0x0061:
            if (r7 == 0) goto L_0x0067
            if (r8 == 0) goto L_0x0067
            r4.w4 = r9
        L_0x0067:
            r4.Z2 = r6
            r4.a3 = r7
            r4.T4 = r5
            r4.X = r1
            java.util.HashMap<java.lang.String, com.itextpdf.text.pdf.PdfName> r7 = com.itextpdf.text.pdf.BaseFont.v4
            boolean r7 = r7.containsKey(r5)
            java.lang.String r9 = ".afm"
            r2 = 0
            if (r7 == 0) goto L_0x0102
            r4.a3 = r1
            r4.U4 = r0
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r7]
            com.itextpdf.text.pdf.fonts.FontsResourceAnchor r8 = V4     // Catch:{ all -> 0x008e }
            if (r8 != 0) goto L_0x0090
            com.itextpdf.text.pdf.fonts.FontsResourceAnchor r8 = new com.itextpdf.text.pdf.fonts.FontsResourceAnchor     // Catch:{ all -> 0x008e }
            r8.<init>()     // Catch:{ all -> 0x008e }
            V4 = r8     // Catch:{ all -> 0x008e }
            goto L_0x0090
        L_0x008e:
            r5 = move-exception
            goto L_0x00fc
        L_0x0090:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x008e }
            r8.<init>()     // Catch:{ all -> 0x008e }
            java.lang.String r10 = "com/itextpdf/text/pdf/fonts/"
            r8.append(r10)     // Catch:{ all -> 0x008e }
            r8.append(r5)     // Catch:{ all -> 0x008e }
            r8.append(r9)     // Catch:{ all -> 0x008e }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x008e }
            com.itextpdf.text.pdf.fonts.FontsResourceAnchor r9 = V4     // Catch:{ all -> 0x008e }
            java.lang.Class r9 = r9.getClass()     // Catch:{ all -> 0x008e }
            java.lang.ClassLoader r9 = r9.getClassLoader()     // Catch:{ all -> 0x008e }
            java.io.InputStream r8 = com.itextpdf.text.io.StreamUtil.c(r8, r9)     // Catch:{ all -> 0x008e }
            if (r8 == 0) goto L_0x00e7
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x00e0 }
            r5.<init>()     // Catch:{ all -> 0x00e0 }
        L_0x00b9:
            int r9 = r8.read(r7)     // Catch:{ all -> 0x00e0 }
            if (r9 >= 0) goto L_0x00e3
            byte[] r5 = r5.toByteArray()     // Catch:{ all -> 0x00e0 }
            r8.close()     // Catch:{ Exception -> 0x00c6 }
        L_0x00c6:
            com.itextpdf.text.pdf.RandomAccessFileOrArray r7 = new com.itextpdf.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x00d9 }
            r7.<init>((byte[]) r5)     // Catch:{ all -> 0x00d9 }
            r4.w0(r7)     // Catch:{ all -> 0x00d6 }
            r7.close()     // Catch:{ Exception -> 0x00d3 }
            goto L_0x0165
        L_0x00d3:
            goto L_0x0165
        L_0x00d6:
            r5 = move-exception
            r2 = r7
            goto L_0x00da
        L_0x00d9:
            r5 = move-exception
        L_0x00da:
            if (r2 == 0) goto L_0x00df
            r2.close()     // Catch:{ Exception -> 0x00df }
        L_0x00df:
            throw r5
        L_0x00e0:
            r5 = move-exception
            r2 = r8
            goto L_0x00fc
        L_0x00e3:
            r5.write(r7, r1, r9)     // Catch:{ all -> 0x00e0 }
            goto L_0x00b9
        L_0x00e7:
            java.lang.String r6 = "1.not.found.as.resource"
            java.lang.Object[] r7 = new java.lang.Object[r0]     // Catch:{ all -> 0x00e0 }
            r7[r1] = r5     // Catch:{ all -> 0x00e0 }
            java.lang.String r5 = com.itextpdf.text.error_messages.MessageLocalization.b(r6, r7)     // Catch:{ all -> 0x00e0 }
            java.io.PrintStream r6 = java.lang.System.err     // Catch:{ all -> 0x00e0 }
            r6.println(r5)     // Catch:{ all -> 0x00e0 }
            com.itextpdf.text.DocumentException r6 = new com.itextpdf.text.DocumentException     // Catch:{ all -> 0x00e0 }
            r6.<init>((java.lang.String) r5)     // Catch:{ all -> 0x00e0 }
            throw r6     // Catch:{ all -> 0x00e0 }
        L_0x00fc:
            if (r2 == 0) goto L_0x0101
            r2.close()     // Catch:{ Exception -> 0x0101 }
        L_0x0101:
            throw r5
        L_0x0102:
            java.lang.String r7 = r5.toLowerCase()
            boolean r7 = r7.endsWith(r9)
            if (r7 == 0) goto L_0x012c
            if (r8 != 0) goto L_0x0119
            com.itextpdf.text.pdf.RandomAccessFileOrArray r7 = new com.itextpdf.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x0117 }
            boolean r8 = com.itextpdf.text.Document.m3     // Catch:{ all -> 0x0117 }
            r7.<init>(r5, r10, r8)     // Catch:{ all -> 0x0117 }
            r2 = r7
            goto L_0x011f
        L_0x0117:
            r5 = move-exception
            goto L_0x0126
        L_0x0119:
            com.itextpdf.text.pdf.RandomAccessFileOrArray r5 = new com.itextpdf.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x0117 }
            r5.<init>((byte[]) r8)     // Catch:{ all -> 0x0117 }
            r2 = r5
        L_0x011f:
            r4.w0(r2)     // Catch:{ all -> 0x0117 }
            r2.close()     // Catch:{ Exception -> 0x00d3 }
            goto L_0x0165
        L_0x0126:
            if (r2 == 0) goto L_0x012b
            r2.close()     // Catch:{ Exception -> 0x012b }
        L_0x012b:
            throw r5
        L_0x012c:
            java.lang.String r7 = r5.toLowerCase()
            java.lang.String r9 = ".pfm"
            boolean r7 = r7.endsWith(r9)
            if (r7 == 0) goto L_0x019d
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0148 }
            r7.<init>()     // Catch:{ all -> 0x0148 }
            if (r8 != 0) goto L_0x014a
            com.itextpdf.text.pdf.RandomAccessFileOrArray r8 = new com.itextpdf.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x0148 }
            boolean r9 = com.itextpdf.text.Document.m3     // Catch:{ all -> 0x0148 }
            r8.<init>(r5, r10, r9)     // Catch:{ all -> 0x0148 }
            r2 = r8
            goto L_0x0150
        L_0x0148:
            r5 = move-exception
            goto L_0x0197
        L_0x014a:
            com.itextpdf.text.pdf.RandomAccessFileOrArray r5 = new com.itextpdf.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x0148 }
            r5.<init>((byte[]) r8)     // Catch:{ all -> 0x0148 }
            r2 = r5
        L_0x0150:
            com.itextpdf.text.pdf.Pfm2afm.a(r2, r7)     // Catch:{ all -> 0x0148 }
            r2.close()     // Catch:{ all -> 0x0148 }
            com.itextpdf.text.pdf.RandomAccessFileOrArray r5 = new com.itextpdf.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x0148 }
            byte[] r7 = r7.toByteArray()     // Catch:{ all -> 0x0148 }
            r5.<init>((byte[]) r7)     // Catch:{ all -> 0x0148 }
            r4.w0(r5)     // Catch:{ all -> 0x0194 }
            r5.close()     // Catch:{ Exception -> 0x00d3 }
        L_0x0165:
            java.lang.String r5 = r4.K4
            java.lang.String r5 = r5.trim()
            r4.K4 = r5
            java.lang.String r7 = "AdobeStandardEncoding"
            boolean r5 = r5.equals(r7)
            if (r5 != 0) goto L_0x017f
            java.lang.String r5 = r4.K4
            java.lang.String r7 = "StandardEncoding"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0181
        L_0x017f:
            r4.c3 = r1
        L_0x0181:
            java.lang.String r5 = r4.Z2
            java.lang.String r7 = "#"
            boolean r5 = r5.startsWith(r7)
            if (r5 != 0) goto L_0x0190
            java.lang.String r5 = " "
            com.itextpdf.text.pdf.PdfEncodings.c(r5, r6)
        L_0x0190:
            r4.g()
            return
        L_0x0194:
            r6 = move-exception
            r2 = r5
            r5 = r6
        L_0x0197:
            if (r2 == 0) goto L_0x019c
            r2.close()     // Catch:{ Exception -> 0x019c }
        L_0x019c:
            throw r5
        L_0x019d:
            com.itextpdf.text.DocumentException r6 = new com.itextpdf.text.DocumentException
            java.lang.String r7 = "1.is.not.an.afm.or.pfm.font.file"
            java.lang.Object[] r8 = new java.lang.Object[r0]
            r8[r1] = r5
            java.lang.String r5 = com.itextpdf.text.error_messages.MessageLocalization.b(r7, r8)
            r6.<init>((java.lang.String) r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.Type1Font.<init>(java.lang.String, java.lang.String, boolean, byte[], byte[], boolean):void");
    }

    private PdfDictionary u0(PdfIndirectReference pdfIndirectReference, int i2, int i3, byte[] bArr) {
        PdfName pdfName;
        PdfObject pdfObject;
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.l8);
        pdfDictionary.V0(PdfName.Cf, PdfName.Mg);
        pdfDictionary.V0(PdfName.l4, new PdfName(this.x4));
        boolean z = this.Z2.equals("Cp1252") || this.Z2.equals(BaseFont.g4);
        if (!this.c3 || this.h3 != null) {
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
            if (z) {
                pdfName = PdfName.m7;
                pdfObject = this.Z2.equals("Cp1252") ? PdfName.Mh : PdfName.Sa;
            } else {
                PdfDictionary pdfDictionary2 = new PdfDictionary(PdfName.m7);
                PdfArray pdfArray = new PdfArray();
                boolean z2 = true;
                for (int i5 = i2; i5 <= i3; i5++) {
                    if (bArr[i5] != 0) {
                        if (z2) {
                            pdfArray.a0(new PdfNumber(i5));
                            z2 = false;
                        }
                        pdfArray.a0(new PdfName(this.Z[i5]));
                    } else {
                        z2 = true;
                    }
                }
                pdfDictionary2.V0(PdfName.F6, pdfArray);
                pdfName = PdfName.m7;
                pdfObject = pdfDictionary2;
            }
            pdfDictionary.V0(pdfName, pdfObject);
        }
        if (this.h3 != null || this.d3 || !this.U4 || (!this.c3 && !z)) {
            pdfDictionary.V0(PdfName.V7, new PdfNumber(i2));
            pdfDictionary.V0(PdfName.pa, new PdfNumber(i3));
            PdfArray pdfArray2 = new PdfArray();
            while (i2 <= i3) {
                pdfArray2.a0(bArr[i2] == 0 ? new PdfNumber(0) : new PdfNumber(this.Y[i2]));
                i2++;
            }
            pdfDictionary.V0(PdfName.Kh, pdfArray2);
        }
        if (!this.U4 && pdfIndirectReference != null) {
            pdfDictionary.V0(PdfName.n8, pdfIndirectReference);
        }
        return pdfDictionary;
    }

    private PdfDictionary v0(PdfIndirectReference pdfIndirectReference) {
        if (this.U4) {
            return null;
        }
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.n8);
        pdfDictionary.V0(PdfName.Y3, new PdfNumber(this.N4));
        pdfDictionary.V0(PdfName.R4, new PdfNumber(this.L4));
        pdfDictionary.V0(PdfName.w6, new PdfNumber(this.O4));
        pdfDictionary.V0(PdfName.m8, new PdfRectangle((float) this.E4, (float) this.F4, (float) this.G4, (float) this.H4));
        pdfDictionary.V0(PdfName.t8, new PdfName(this.x4));
        pdfDictionary.V0(PdfName.X9, new PdfNumber(this.B4));
        pdfDictionary.V0(PdfName.qf, new PdfNumber(this.Q4));
        if (pdfIndirectReference != null) {
            pdfDictionary.V0(PdfName.p8, pdfIndirectReference);
        }
        boolean z = this.C4 | (this.c3 ? 4 : ' ');
        if (this.B4 < 0.0f) {
            z |= true;
        }
        if (this.x4.indexOf("Caps") >= 0 || this.x4.endsWith("SC")) {
            z |= true;
        }
        if (this.A4.equals("Bold")) {
            z |= true;
        }
        pdfDictionary.V0(PdfName.g8, new PdfNumber(z ? 1 : 0));
        return pdfDictionary;
    }

    public String[][] H() {
        return new String[][]{new String[]{"", "", "", this.z4}};
    }

    public float I(int i2, float f2) {
        int i3;
        switch (i2) {
            case 1:
            case 9:
                i3 = this.N4;
                break;
            case 2:
                i3 = this.L4;
                break;
            case 3:
            case 10:
                i3 = this.O4;
                break;
            case 4:
                return this.B4;
            case 5:
                i3 = this.E4;
                break;
            case 6:
                i3 = this.F4;
                break;
            case 7:
                i3 = this.G4;
                break;
            case 8:
                i3 = this.H4;
                break;
            case 12:
                i3 = this.G4 - this.E4;
                break;
            case 13:
                i3 = this.I4;
                break;
            case 14:
                i3 = this.J4;
                break;
            default:
                return 0.0f;
        }
        return (((float) i3) * f2) / 1000.0f;
    }

    public String[][] L() {
        return new String[][]{new String[]{"", "", "", this.y4}};
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.itextpdf.text.pdf.PdfStream, com.itextpdf.text.pdf.RandomAccessFileOrArray] */
    public PdfStream N() throws DocumentException {
        ? r3 = 0;
        if (this.U4 || !this.a3) {
            return r3;
        }
        try {
            StringBuilder sb = new StringBuilder();
            String str = this.T4;
            sb.append(str.substring(0, str.length() - 3));
            sb.append("pfb");
            String sb2 = sb.toString();
            byte[] bArr = this.w4;
            RandomAccessFileOrArray randomAccessFileOrArray = bArr == null ? new RandomAccessFileOrArray(sb2, true, Document.m3) : new RandomAccessFileOrArray(bArr);
            byte[] bArr2 = new byte[(((int) randomAccessFileOrArray.e()) - 18)];
            int[] iArr = new int[3];
            int i2 = 0;
            int i3 = 0;
            while (i2 < 3) {
                if (randomAccessFileOrArray.read() != 128) {
                    throw new DocumentException(MessageLocalization.b("start.marker.missing.in.1", sb2));
                } else if (randomAccessFileOrArray.read() == W4[i2]) {
                    int read = randomAccessFileOrArray.read() + (randomAccessFileOrArray.read() << 8) + (randomAccessFileOrArray.read() << 16) + (randomAccessFileOrArray.read() << 24);
                    iArr[i2] = read;
                    while (read != 0) {
                        int read2 = randomAccessFileOrArray.read(bArr2, i3, read);
                        if (read2 >= 0) {
                            i3 += read2;
                            read -= read2;
                        } else {
                            throw new DocumentException(MessageLocalization.b("premature.end.in.1", sb2));
                        }
                    }
                    i2++;
                } else {
                    throw new DocumentException(MessageLocalization.b("incorrect.segment.type.in.1", sb2));
                }
            }
            BaseFont.StreamFont streamFont = new BaseFont.StreamFont(bArr2, iArr, this.b3);
            try {
                randomAccessFileOrArray.close();
            } catch (Exception unused) {
            }
            return streamFont;
        } catch (Exception e2) {
            throw new DocumentException(e2);
        } catch (Throwable th) {
            if (r3 != 0) {
                try {
                    r3.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    public int O(int i2, int i3) {
        String b2;
        Object[] objArr;
        String b3 = GlyphList.b(i2);
        if (b3 == null || (b2 = GlyphList.b(i3)) == null || (objArr = this.S4.get(b3)) == null) {
            return 0;
        }
        for (int i4 = 0; i4 < objArr.length; i4 += 2) {
            if (b2.equals(objArr[i4])) {
                return ((Integer) objArr[i4 + 1]).intValue();
            }
        }
        return 0;
    }

    public String P() {
        return this.x4;
    }

    /* access modifiers changed from: protected */
    public int[] Q(int i2, String str) {
        Object obj;
        if (str == null) {
            obj = this.R4.get(Integer.valueOf(i2));
        } else if (str.equals(BaseFont.t4)) {
            return null;
        } else {
            obj = this.R4.get(str);
        }
        Object[] objArr = (Object[]) obj;
        if (objArr != null) {
            return (int[]) objArr[3];
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int R(int i2, String str) {
        Object obj;
        if (str == null) {
            obj = this.R4.get(Integer.valueOf(i2));
        } else if (str.equals(BaseFont.t4)) {
            return 0;
        } else {
            obj = this.R4.get(str);
        }
        Object[] objArr = (Object[]) obj;
        if (objArr != null) {
            return ((Integer) objArr[1]).intValue();
        }
        return 0;
    }

    public boolean c0() {
        return !this.S4.isEmpty();
    }

    public void o0(int i2, float f2) {
        if (i2 != 1) {
            if (i2 != 3) {
                if (i2 != 9) {
                    if (i2 != 10) {
                        return;
                    }
                }
            }
            this.O4 = (int) f2;
            return;
        }
        this.N4 = (int) f2;
    }

    public boolean q0(int i2, int i3, int i4) {
        String b2;
        String b3 = GlyphList.b(i2);
        if (b3 == null || (b2 = GlyphList.b(i3)) == null) {
            return false;
        }
        Object[] objArr = this.S4.get(b3);
        if (objArr == null) {
            this.S4.put(b3, new Object[]{b2, Integer.valueOf(i4)});
            return true;
        }
        for (int i5 = 0; i5 < objArr.length; i5 += 2) {
            if (b2.equals(objArr[i5])) {
                objArr[i5 + 1] = Integer.valueOf(i4);
                return true;
            }
        }
        int length = objArr.length;
        Object[] objArr2 = new Object[(2 + length)];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        objArr2[length] = b2;
        objArr2[length + 1] = Integer.valueOf(i4);
        this.S4.put(b3, objArr2);
        return true;
    }

    public void r0(String str) {
        this.x4 = str;
    }

    public String[][] s() {
        return new String[][]{new String[]{"4", "", "", "", this.y4}};
    }

    /* access modifiers changed from: package-private */
    public void t0(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, Object[] objArr) throws DocumentException, IOException {
        int i2 = 0;
        int intValue = objArr[0].intValue();
        int intValue2 = objArr[1].intValue();
        byte[] bArr = objArr[2];
        if (!objArr[3].booleanValue() || !this.f3 || !this.a3) {
            intValue2 = bArr.length - 1;
            for (int i3 = 0; i3 < bArr.length; i3++) {
                bArr[i3] = 1;
            }
        } else {
            i2 = intValue;
        }
        PdfStream N = N();
        PdfIndirectReference a2 = N != null ? pdfWriter.v0(N).a() : null;
        PdfDictionary v0 = v0(a2);
        if (v0 != null) {
            a2 = pdfWriter.v0(v0).a();
        }
        pdfWriter.y0(u0(a2, i2, intValue2, bArr), pdfIndirectReference);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void w0(com.itextpdf.text.pdf.RandomAccessFileOrArray r15) throws com.itextpdf.text.DocumentException, java.io.IOException {
        /*
            r14 = this;
            r0 = 3
            r1 = 4
            r2 = 2
            r3 = 0
            r4 = 1
        L_0x0005:
            java.lang.String r5 = r15.readLine()
            if (r5 == 0) goto L_0x01a4
            java.util.StringTokenizer r6 = new java.util.StringTokenizer
            java.lang.String r7 = " ,\n\r\t\f"
            r6.<init>(r5, r7)
            boolean r5 = r6.hasMoreTokens()
            if (r5 != 0) goto L_0x0019
            goto L_0x0005
        L_0x0019:
            java.lang.String r5 = r6.nextToken()
            java.lang.String r7 = "FontName"
            boolean r7 = r5.equals(r7)
            java.lang.String r8 = "ÿ"
            if (r7 == 0) goto L_0x0032
            java.lang.String r5 = r6.nextToken(r8)
            java.lang.String r5 = r5.substring(r4)
            r14.x4 = r5
            goto L_0x0005
        L_0x0032:
            java.lang.String r7 = "FullName"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L_0x0045
            java.lang.String r5 = r6.nextToken(r8)
            java.lang.String r5 = r5.substring(r4)
            r14.y4 = r5
            goto L_0x0005
        L_0x0045:
            java.lang.String r7 = "FamilyName"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L_0x0058
            java.lang.String r5 = r6.nextToken(r8)
            java.lang.String r5 = r5.substring(r4)
            r14.z4 = r5
            goto L_0x0005
        L_0x0058:
            java.lang.String r7 = "Weight"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L_0x006b
            java.lang.String r5 = r6.nextToken(r8)
            java.lang.String r5 = r5.substring(r4)
            r14.A4 = r5
            goto L_0x0005
        L_0x006b:
            java.lang.String r7 = "ItalicAngle"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L_0x007e
            java.lang.String r5 = r6.nextToken()
            float r5 = java.lang.Float.parseFloat(r5)
            r14.B4 = r5
            goto L_0x0005
        L_0x007e:
            java.lang.String r7 = "IsFixedPitch"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L_0x0094
            java.lang.String r5 = r6.nextToken()
            java.lang.String r6 = "true"
            boolean r5 = r5.equals(r6)
            r14.C4 = r5
            goto L_0x0005
        L_0x0094:
            java.lang.String r7 = "CharacterSet"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L_0x00a8
            java.lang.String r5 = r6.nextToken(r8)
            java.lang.String r5 = r5.substring(r4)
            r14.D4 = r5
            goto L_0x0005
        L_0x00a8:
            java.lang.String r7 = "FontBBox"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L_0x00de
            java.lang.String r5 = r6.nextToken()
            float r5 = java.lang.Float.parseFloat(r5)
            int r5 = (int) r5
            r14.E4 = r5
            java.lang.String r5 = r6.nextToken()
            float r5 = java.lang.Float.parseFloat(r5)
            int r5 = (int) r5
            r14.F4 = r5
            java.lang.String r5 = r6.nextToken()
            float r5 = java.lang.Float.parseFloat(r5)
            int r5 = (int) r5
            r14.G4 = r5
            java.lang.String r5 = r6.nextToken()
            float r5 = java.lang.Float.parseFloat(r5)
            int r5 = (int) r5
            r14.H4 = r5
            goto L_0x0005
        L_0x00de:
            java.lang.String r7 = "UnderlinePosition"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L_0x00f3
            java.lang.String r5 = r6.nextToken()
            float r5 = java.lang.Float.parseFloat(r5)
            int r5 = (int) r5
            r14.I4 = r5
            goto L_0x0005
        L_0x00f3:
            java.lang.String r7 = "UnderlineThickness"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L_0x0108
            java.lang.String r5 = r6.nextToken()
            float r5 = java.lang.Float.parseFloat(r5)
            int r5 = (int) r5
            r14.J4 = r5
            goto L_0x0005
        L_0x0108:
            java.lang.String r7 = "EncodingScheme"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L_0x011c
            java.lang.String r5 = r6.nextToken(r8)
            java.lang.String r5 = r5.substring(r4)
            r14.K4 = r5
            goto L_0x0005
        L_0x011c:
            java.lang.String r7 = "CapHeight"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L_0x0131
            java.lang.String r5 = r6.nextToken()
            float r5 = java.lang.Float.parseFloat(r5)
            int r5 = (int) r5
            r14.L4 = r5
            goto L_0x0005
        L_0x0131:
            java.lang.String r7 = "XHeight"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L_0x0146
            java.lang.String r5 = r6.nextToken()
            float r5 = java.lang.Float.parseFloat(r5)
            int r5 = (int) r5
            r14.M4 = r5
            goto L_0x0005
        L_0x0146:
            java.lang.String r7 = "Ascender"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L_0x015b
            java.lang.String r5 = r6.nextToken()
            float r5 = java.lang.Float.parseFloat(r5)
            int r5 = (int) r5
            r14.N4 = r5
            goto L_0x0005
        L_0x015b:
            java.lang.String r7 = "Descender"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L_0x0170
            java.lang.String r5 = r6.nextToken()
            float r5 = java.lang.Float.parseFloat(r5)
            int r5 = (int) r5
            r14.O4 = r5
            goto L_0x0005
        L_0x0170:
            java.lang.String r7 = "StdHW"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L_0x0185
            java.lang.String r5 = r6.nextToken()
            float r5 = java.lang.Float.parseFloat(r5)
            int r5 = (int) r5
            r14.P4 = r5
            goto L_0x0005
        L_0x0185:
            java.lang.String r7 = "StdVW"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L_0x019a
            java.lang.String r5 = r6.nextToken()
            float r5 = java.lang.Float.parseFloat(r5)
            int r5 = (int) r5
            r14.Q4 = r5
            goto L_0x0005
        L_0x019a:
            java.lang.String r6 = "StartCharMetrics"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0005
            r5 = 1
            goto L_0x01a5
        L_0x01a4:
            r5 = 0
        L_0x01a5:
            if (r5 == 0) goto L_0x0363
        L_0x01a7:
            java.lang.String r6 = r15.readLine()
            if (r6 == 0) goto L_0x027b
            java.util.StringTokenizer r7 = new java.util.StringTokenizer
            r7.<init>(r6)
            boolean r8 = r7.hasMoreTokens()
            if (r8 != 0) goto L_0x01b9
            goto L_0x01a7
        L_0x01b9:
            java.lang.String r7 = r7.nextToken()
            java.lang.String r8 = "EndCharMetrics"
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x01c8
            r5 = 0
            goto L_0x027b
        L_0x01c8:
            r7 = -1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r8 = 250(0xfa, float:3.5E-43)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.util.StringTokenizer r9 = new java.util.StringTokenizer
            java.lang.String r10 = ";"
            r9.<init>(r6, r10)
            java.lang.String r6 = ""
            r10 = 0
        L_0x01dd:
            boolean r11 = r9.hasMoreTokens()
            if (r11 == 0) goto L_0x025f
            java.util.StringTokenizer r11 = new java.util.StringTokenizer
            java.lang.String r12 = r9.nextToken()
            r11.<init>(r12)
            boolean r12 = r11.hasMoreTokens()
            if (r12 != 0) goto L_0x01f3
            goto L_0x01dd
        L_0x01f3:
            java.lang.String r12 = r11.nextToken()
            java.lang.String r13 = "C"
            boolean r13 = r12.equals(r13)
            if (r13 == 0) goto L_0x0208
            java.lang.String r7 = r11.nextToken()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x01dd
        L_0x0208:
            java.lang.String r13 = "WX"
            boolean r13 = r12.equals(r13)
            if (r13 == 0) goto L_0x021e
            java.lang.String r8 = r11.nextToken()
            float r8 = java.lang.Float.parseFloat(r8)
            int r8 = (int) r8
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L_0x01dd
        L_0x021e:
            java.lang.String r13 = "N"
            boolean r13 = r12.equals(r13)
            if (r13 == 0) goto L_0x022b
            java.lang.String r6 = r11.nextToken()
            goto L_0x01dd
        L_0x022b:
            java.lang.String r13 = "B"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x01dd
            int[] r10 = new int[r1]
            java.lang.String r12 = r11.nextToken()
            int r12 = java.lang.Integer.parseInt(r12)
            r10[r3] = r12
            java.lang.String r12 = r11.nextToken()
            int r12 = java.lang.Integer.parseInt(r12)
            r10[r4] = r12
            java.lang.String r12 = r11.nextToken()
            int r12 = java.lang.Integer.parseInt(r12)
            r10[r2] = r12
            java.lang.String r11 = r11.nextToken()
            int r11 = java.lang.Integer.parseInt(r11)
            r10[r0] = r11
            goto L_0x01dd
        L_0x025f:
            java.lang.Object[] r9 = new java.lang.Object[r1]
            r9[r3] = r7
            r9[r4] = r8
            r9[r2] = r6
            r9[r0] = r10
            int r8 = r7.intValue()
            if (r8 < 0) goto L_0x0274
            java.util.HashMap<java.lang.Object, java.lang.Object[]> r8 = r14.R4
            r8.put(r7, r9)
        L_0x0274:
            java.util.HashMap<java.lang.Object, java.lang.Object[]> r7 = r14.R4
            r7.put(r6, r9)
            goto L_0x01a7
        L_0x027b:
            if (r5 != 0) goto L_0x0351
            java.util.HashMap<java.lang.Object, java.lang.Object[]> r0 = r14.R4
            java.lang.String r1 = "nonbreakingspace"
            boolean r0 = r0.containsKey(r1)
            if (r0 != 0) goto L_0x0298
            java.util.HashMap<java.lang.Object, java.lang.Object[]> r0 = r14.R4
            java.lang.String r6 = "space"
            java.lang.Object r0 = r0.get(r6)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            if (r0 == 0) goto L_0x0298
            java.util.HashMap<java.lang.Object, java.lang.Object[]> r6 = r14.R4
            r6.put(r1, r0)
        L_0x0298:
            java.lang.String r0 = r15.readLine()
            if (r0 == 0) goto L_0x02c0
            java.util.StringTokenizer r1 = new java.util.StringTokenizer
            r1.<init>(r0)
            boolean r0 = r1.hasMoreTokens()
            if (r0 != 0) goto L_0x02aa
            goto L_0x0298
        L_0x02aa:
            java.lang.String r0 = r1.nextToken()
            java.lang.String r1 = "EndFontMetrics"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x02b7
            return
        L_0x02b7:
            java.lang.String r1 = "StartKernPairs"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0298
            r5 = 1
        L_0x02c0:
            if (r5 == 0) goto L_0x033f
        L_0x02c2:
            java.lang.String r0 = r15.readLine()
            if (r0 == 0) goto L_0x0327
            java.util.StringTokenizer r1 = new java.util.StringTokenizer
            r1.<init>(r0)
            boolean r0 = r1.hasMoreTokens()
            if (r0 != 0) goto L_0x02d4
            goto L_0x02c2
        L_0x02d4:
            java.lang.String r0 = r1.nextToken()
            java.lang.String r6 = "KPX"
            boolean r6 = r0.equals(r6)
            if (r6 == 0) goto L_0x031e
            java.lang.String r0 = r1.nextToken()
            java.lang.String r6 = r1.nextToken()
            java.lang.String r1 = r1.nextToken()
            float r1 = java.lang.Float.parseFloat(r1)
            int r1 = (int) r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.util.HashMap<java.lang.String, java.lang.Object[]> r7 = r14.S4
            java.lang.Object r7 = r7.get(r0)
            java.lang.Object[] r7 = (java.lang.Object[]) r7
            if (r7 != 0) goto L_0x030b
            java.util.HashMap<java.lang.String, java.lang.Object[]> r7 = r14.S4
            java.lang.Object[] r8 = new java.lang.Object[r2]
            r8[r3] = r6
            r8[r4] = r1
            r7.put(r0, r8)
            goto L_0x02c2
        L_0x030b:
            int r8 = r7.length
            int r9 = r8 + 2
            java.lang.Object[] r9 = new java.lang.Object[r9]
            java.lang.System.arraycopy(r7, r3, r9, r3, r8)
            r9[r8] = r6
            int r8 = r8 + r4
            r9[r8] = r1
            java.util.HashMap<java.lang.String, java.lang.Object[]> r1 = r14.S4
            r1.put(r0, r9)
            goto L_0x02c2
        L_0x031e:
            java.lang.String r1 = "EndKernPairs"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x02c2
            r5 = 0
        L_0x0327:
            if (r5 != 0) goto L_0x032d
            r15.close()
            return
        L_0x032d:
            com.itextpdf.text.DocumentException r15 = new com.itextpdf.text.DocumentException
            java.lang.String r0 = r14.T4
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r1[r3] = r0
            java.lang.String r0 = "missing.endkernpairs.in.1"
            java.lang.String r0 = com.itextpdf.text.error_messages.MessageLocalization.b(r0, r1)
            r15.<init>((java.lang.String) r0)
            throw r15
        L_0x033f:
            com.itextpdf.text.DocumentException r15 = new com.itextpdf.text.DocumentException
            java.lang.String r0 = r14.T4
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r1[r3] = r0
            java.lang.String r0 = "missing.endfontmetrics.in.1"
            java.lang.String r0 = com.itextpdf.text.error_messages.MessageLocalization.b(r0, r1)
            r15.<init>((java.lang.String) r0)
            throw r15
        L_0x0351:
            com.itextpdf.text.DocumentException r15 = new com.itextpdf.text.DocumentException
            java.lang.String r0 = r14.T4
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r1[r3] = r0
            java.lang.String r0 = "missing.endcharmetrics.in.1"
            java.lang.String r0 = com.itextpdf.text.error_messages.MessageLocalization.b(r0, r1)
            r15.<init>((java.lang.String) r0)
            throw r15
        L_0x0363:
            com.itextpdf.text.DocumentException r15 = new com.itextpdf.text.DocumentException
            java.lang.String r0 = r14.T4
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r1[r3] = r0
            java.lang.String r0 = "missing.startcharmetrics.in.1"
            java.lang.String r0 = com.itextpdf.text.error_messages.MessageLocalization.b(r0, r1)
            r15.<init>((java.lang.String) r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.Type1Font.w0(com.itextpdf.text.pdf.RandomAccessFileOrArray):void");
    }
}
