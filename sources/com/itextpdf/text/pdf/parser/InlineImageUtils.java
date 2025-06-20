package com.itextpdf.text.pdf.parser;

import androidx.exifinterface.media.ExifInterface;
import com.itextpdf.text.exceptions.UnsupportedPdfException;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.FilterHandlers;
import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfContentParser;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class InlineImageUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f26948a = LoggerFactory.c(InlineImageUtils.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private static final Map<PdfName, PdfName> f26949b;

    /* renamed from: c  reason: collision with root package name */
    private static final Map<PdfName, PdfName> f26950c;

    /* renamed from: d  reason: collision with root package name */
    private static final Map<PdfName, PdfName> f26951d;

    public static class InlineImageParseException extends IOException {
        private static final long s = 233760879000268548L;

        public InlineImageParseException(String str) {
            super(str);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f26949b = hashMap;
        PdfName pdfName = PdfName.u4;
        hashMap.put(pdfName, pdfName);
        PdfName pdfName2 = PdfName.w5;
        hashMap.put(pdfName2, pdfName2);
        PdfName pdfName3 = PdfName.n6;
        hashMap.put(pdfName3, pdfName3);
        PdfName pdfName4 = PdfName.o6;
        hashMap.put(pdfName4, pdfName4);
        PdfName pdfName5 = PdfName.T7;
        hashMap.put(pdfName5, pdfName5);
        PdfName pdfName6 = PdfName.h9;
        hashMap.put(pdfName6, pdfName6);
        PdfName pdfName7 = PdfName.J9;
        hashMap.put(pdfName7, pdfName7);
        PdfName pdfName8 = PdfName.T9;
        hashMap.put(pdfName8, pdfName8);
        PdfName pdfName9 = PdfName.U9;
        hashMap.put(pdfName9, pdfName9);
        PdfName pdfName10 = PdfName.Jh;
        hashMap.put(pdfName10, pdfName10);
        hashMap.put(new PdfName("BPC"), pdfName);
        hashMap.put(new PdfName("CS"), pdfName2);
        hashMap.put(new PdfName("D"), pdfName3);
        hashMap.put(new PdfName("DP"), pdfName4);
        hashMap.put(new PdfName("F"), pdfName5);
        hashMap.put(new PdfName("H"), pdfName6);
        hashMap.put(new PdfName("IM"), pdfName7);
        hashMap.put(new PdfName("I"), pdfName9);
        hashMap.put(new PdfName(ExifInterface.T4), pdfName10);
        HashMap hashMap2 = new HashMap();
        f26950c = hashMap2;
        hashMap2.put(new PdfName("G"), PdfName.A6);
        hashMap2.put(new PdfName("RGB"), PdfName.B6);
        hashMap2.put(new PdfName("CMYK"), PdfName.C6);
        hashMap2.put(new PdfName("I"), PdfName.N9);
        HashMap hashMap3 = new HashMap();
        f26951d = hashMap3;
        hashMap3.put(new PdfName("AHx"), PdfName.b4);
        hashMap3.put(new PdfName("A85"), PdfName.a4);
        hashMap3.put(new PdfName("LZW"), PdfName.Ma);
        hashMap3.put(new PdfName("Fl"), PdfName.j8);
        hashMap3.put(new PdfName("RL"), PdfName.Ae);
        hashMap3.put(new PdfName("CCF"), PdfName.X4);
        hashMap3.put(new PdfName("DCT"), PdfName.k6);
    }

    private InlineImageUtils() {
    }

    private static int a(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2) {
        PdfNumber q0 = pdfDictionary.q0(PdfName.Jh);
        PdfNumber q02 = pdfDictionary.q0(PdfName.u4);
        return (((q0.e0() * (q02 != null ? q02.e0() : 1)) * c(pdfDictionary.p0(PdfName.w5), pdfDictionary2)) + 7) / 8;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        r4 = f26950c.get(r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.itextpdf.text.pdf.PdfObject b(com.itextpdf.text.pdf.PdfName r4, com.itextpdf.text.pdf.PdfObject r5) {
        /*
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.T7
            if (r4 != r0) goto L_0x0034
            boolean r0 = r5 instanceof com.itextpdf.text.pdf.PdfName
            if (r0 == 0) goto L_0x0013
            java.util.Map<com.itextpdf.text.pdf.PdfName, com.itextpdf.text.pdf.PdfName> r4 = f26951d
            java.lang.Object r4 = r4.get(r5)
            com.itextpdf.text.pdf.PdfName r4 = (com.itextpdf.text.pdf.PdfName) r4
            if (r4 == 0) goto L_0x0043
            return r4
        L_0x0013:
            boolean r0 = r5 instanceof com.itextpdf.text.pdf.PdfArray
            if (r0 == 0) goto L_0x0043
            com.itextpdf.text.pdf.PdfArray r5 = (com.itextpdf.text.pdf.PdfArray) r5
            com.itextpdf.text.pdf.PdfArray r0 = new com.itextpdf.text.pdf.PdfArray
            r0.<init>()
            int r1 = r5.size()
            r2 = 0
        L_0x0023:
            if (r2 >= r1) goto L_0x0033
            com.itextpdf.text.pdf.PdfObject r3 = r5.T0(r2)
            com.itextpdf.text.pdf.PdfObject r3 = b(r4, r3)
            r0.a0(r3)
            int r2 = r2 + 1
            goto L_0x0023
        L_0x0033:
            return r0
        L_0x0034:
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.w5
            if (r4 != r0) goto L_0x0043
            java.util.Map<com.itextpdf.text.pdf.PdfName, com.itextpdf.text.pdf.PdfName> r4 = f26950c
            java.lang.Object r4 = r4.get(r5)
            com.itextpdf.text.pdf.PdfName r4 = (com.itextpdf.text.pdf.PdfName) r4
            if (r4 == 0) goto L_0x0043
            return r4
        L_0x0043:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.parser.InlineImageUtils.b(com.itextpdf.text.pdf.PdfName, com.itextpdf.text.pdf.PdfObject):com.itextpdf.text.pdf.PdfObject");
    }

    private static int c(PdfName pdfName, PdfDictionary pdfDictionary) {
        if (pdfName == null || pdfName.equals(PdfName.A6)) {
            return 1;
        }
        if (pdfName.equals(PdfName.B6)) {
            return 3;
        }
        if (pdfName.equals(PdfName.C6)) {
            return 4;
        }
        if (pdfDictionary != null) {
            PdfArray e0 = pdfDictionary.e0(pdfName);
            if (e0 == null) {
                PdfName p0 = pdfDictionary.p0(pdfName);
                if (p0 != null) {
                    return c(p0, pdfDictionary);
                }
            } else if (PdfName.N9.equals(e0.I0(0))) {
                return 1;
            }
        }
        throw new IllegalArgumentException("Unexpected color space " + pdfName);
    }

    private static boolean d(byte[] bArr, PdfDictionary pdfDictionary) {
        try {
            PdfReader.r(bArr, pdfDictionary, FilterHandlers.a());
            return true;
        } catch (UnsupportedPdfException e2) {
            f26948a.g(e2.getMessage());
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static InlineImageInfo e(PdfContentParser pdfContentParser, PdfDictionary pdfDictionary) throws IOException {
        PdfDictionary f2 = f(pdfContentParser);
        return new InlineImageInfo(g(f2, pdfDictionary, pdfContentParser), f2);
    }

    private static PdfDictionary f(PdfContentParser pdfContentParser) throws IOException {
        PdfDictionary pdfDictionary = new PdfDictionary();
        while (true) {
            PdfObject f2 = pdfContentParser.f();
            if (f2 == null || "ID".equals(f2.toString())) {
                int z = pdfContentParser.a().z();
            } else {
                PdfObject f3 = pdfContentParser.f();
                PdfName pdfName = f26949b.get(f2);
                if (pdfName == null) {
                    pdfName = (PdfName) f2;
                }
                pdfDictionary.V0(pdfName, b(pdfName, f3));
            }
        }
        int z2 = pdfContentParser.a().z();
        if (PRTokeniser.t(z2)) {
            return pdfDictionary;
        }
        throw new IOException("Unexpected character " + z2 + " found after ID in inline image");
    }

    private static byte[] g(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2, PdfContentParser pdfContentParser) throws IOException {
        int z;
        if (!pdfDictionary.a0(PdfName.T7)) {
            return h(pdfDictionary, pdfDictionary2, pdfContentParser);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        PRTokeniser a2 = pdfContentParser.a();
        while (true) {
            int i2 = 0;
            while (true) {
                z = a2.z();
                if (z != -1) {
                    if ((i2 != 0 || !PRTokeniser.t(z)) && !(i2 == 1 && z == 69)) {
                        if (i2 == 1 && PRTokeniser.t(z)) {
                            byteArrayOutputStream.write(byteArrayOutputStream2.toByteArray());
                            byteArrayOutputStream2.reset();
                            byteArrayOutputStream2.write(z);
                        } else if (!(i2 == 2 && z == 73)) {
                        }
                    }
                    i2++;
                    byteArrayOutputStream2.write(z);
                } else {
                    throw new InlineImageParseException("Could not find image data or EI");
                }
            }
            if (i2 != 3 || !PRTokeniser.t(z)) {
                byteArrayOutputStream.write(byteArrayOutputStream2.toByteArray());
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (d(byteArray, pdfDictionary)) {
                    return byteArray;
                }
                byteArrayOutputStream.write(byteArrayOutputStream2.toByteArray());
            }
            byteArrayOutputStream2.reset();
            byteArrayOutputStream.write(z);
        }
    }

    private static byte[] h(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2, PdfContentParser pdfContentParser) throws IOException {
        if (!pdfDictionary.a0(PdfName.T7)) {
            int a2 = a(pdfDictionary, pdfDictionary2) * pdfDictionary.q0(PdfName.h9).e0();
            byte[] bArr = new byte[a2];
            PRTokeniser a3 = pdfContentParser.a();
            int z = a3.z();
            int i2 = 0;
            if (!PRTokeniser.t(z) || z == 0) {
                bArr[0] = (byte) z;
                i2 = 1;
            }
            while (i2 < a2) {
                int z2 = a3.z();
                if (z2 != -1) {
                    bArr[i2] = (byte) z2;
                    i2++;
                } else {
                    throw new InlineImageParseException("End of content stream reached before end of image data");
                }
            }
            if (pdfContentParser.f().toString().equals("EI") || pdfContentParser.f().toString().equals("EI")) {
                return bArr;
            }
            throw new InlineImageParseException("EI not found after end of image data");
        }
        throw new IllegalArgumentException("Dictionary contains filters");
    }
}
