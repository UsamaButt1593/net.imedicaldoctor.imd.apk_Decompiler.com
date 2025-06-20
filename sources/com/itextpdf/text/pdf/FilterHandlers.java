package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.UnsupportedPdfException;
import com.itextpdf.text.pdf.codec.TIFFFaxDecoder;
import com.itextpdf.text.pdf.codec.TIFFFaxDecompressor;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class FilterHandlers {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<PdfName, FilterHandler> f26038a;

    public interface FilterHandler {
        byte[] a(byte[] bArr, PdfName pdfName, PdfObject pdfObject, PdfDictionary pdfDictionary) throws IOException;
    }

    private static class Filter_ASCII85DECODE implements FilterHandler {
        private Filter_ASCII85DECODE() {
        }

        public byte[] a(byte[] bArr, PdfName pdfName, PdfObject pdfObject, PdfDictionary pdfDictionary) throws IOException {
            return PdfReader.b(bArr);
        }
    }

    private static class Filter_ASCIIHEXDECODE implements FilterHandler {
        private Filter_ASCIIHEXDECODE() {
        }

        public byte[] a(byte[] bArr, PdfName pdfName, PdfObject pdfObject, PdfDictionary pdfDictionary) throws IOException {
            return PdfReader.c(bArr);
        }
    }

    private static class Filter_CCITTFAXDECODE implements FilterHandler {
        private Filter_CCITTFAXDECODE() {
        }

        public byte[] a(byte[] bArr, PdfName pdfName, PdfObject pdfObject, PdfDictionary pdfDictionary) throws IOException {
            int i2;
            boolean z;
            boolean z2;
            PdfNumber pdfNumber = (PdfNumber) PdfReader.w0(pdfDictionary.d0(PdfName.Jh));
            PdfNumber pdfNumber2 = (PdfNumber) PdfReader.w0(pdfDictionary.d0(PdfName.h9));
            if (pdfNumber == null || pdfNumber2 == null) {
                throw new UnsupportedPdfException(MessageLocalization.b("filter.ccittfaxdecode.is.only.supported.for.images", new Object[0]));
            }
            int e0 = pdfNumber.e0();
            int e02 = pdfNumber2.e0();
            PdfDictionary pdfDictionary2 = pdfObject instanceof PdfDictionary ? (PdfDictionary) pdfObject : null;
            if (pdfDictionary2 != null) {
                PdfNumber q0 = pdfDictionary2.q0(PdfName.ga);
                i2 = q0 != null ? q0.e0() : 0;
                PdfBoolean i0 = pdfDictionary2.i0(PdfName.x4);
                boolean Z = i0 != null ? i0.Z() : false;
                PdfBoolean i02 = pdfDictionary2.i0(PdfName.l7);
                if (i02 != null) {
                    z = i02.Z();
                    z2 = Z;
                } else {
                    z2 = Z;
                    z = false;
                }
            } else {
                z = false;
                i2 = 0;
                z2 = false;
            }
            int i3 = ((e0 + 7) / 8) * e02;
            byte[] bArr2 = new byte[i3];
            TIFFFaxDecompressor tIFFFaxDecompressor = new TIFFFaxDecompressor();
            if (i2 == 0 || i2 > 0) {
                int i4 = (z ? 4 : 0) | (i2 > 0 ? 1 : 0);
                tIFFFaxDecompressor.a(1, 3, i4, 0);
                tIFFFaxDecompressor.e(bArr2, bArr, e0, e02);
                int i5 = tIFFFaxDecompressor.f26680e;
                if (i5 > 0) {
                    byte[] bArr3 = new byte[i3];
                    tIFFFaxDecompressor.a(1, 2, i4, 0);
                    tIFFFaxDecompressor.e(bArr3, bArr, e0, e02);
                    if (tIFFFaxDecompressor.f26680e < i5) {
                        bArr2 = bArr3;
                    }
                }
            } else {
                new TIFFFaxDecoder(1, e0, e02).f(bArr2, bArr, 0, e02, 0);
            }
            if (!z2) {
                int length = bArr2.length;
                for (int i6 = 0; i6 < length; i6++) {
                    bArr2[i6] = (byte) (bArr2[i6] ^ 255);
                }
            }
            return bArr2;
        }
    }

    private static class Filter_DoNothing implements FilterHandler {
        private Filter_DoNothing() {
        }

        public byte[] a(byte[] bArr, PdfName pdfName, PdfObject pdfObject, PdfDictionary pdfDictionary) throws IOException {
            return bArr;
        }
    }

    private static class Filter_FLATEDECODE implements FilterHandler {
        private Filter_FLATEDECODE() {
        }

        public byte[] a(byte[] bArr, PdfName pdfName, PdfObject pdfObject, PdfDictionary pdfDictionary) throws IOException {
            return PdfReader.s(PdfReader.d(bArr), pdfObject);
        }
    }

    private static class Filter_LZWDECODE implements FilterHandler {
        private Filter_LZWDECODE() {
        }

        public byte[] a(byte[] bArr, PdfName pdfName, PdfObject pdfObject, PdfDictionary pdfDictionary) throws IOException {
            return PdfReader.s(PdfReader.f(bArr), pdfObject);
        }
    }

    private static class Filter_RUNLENGTHDECODE implements FilterHandler {
        private Filter_RUNLENGTHDECODE() {
        }

        public byte[] a(byte[] bArr, PdfName pdfName, PdfObject pdfObject, PdfDictionary pdfDictionary) throws IOException {
            byte b2;
            int i2;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i3 = 0;
            while (i3 < bArr.length && (b2 = bArr[i3]) != Byte.MIN_VALUE) {
                if (b2 < 0 || b2 > Byte.MAX_VALUE) {
                    i2 = i3 + 1;
                    for (int i4 = 0; i4 < 1 - b2; i4++) {
                        byteArrayOutputStream.write(bArr[i2]);
                    }
                } else {
                    int i5 = b2 + 1;
                    byteArrayOutputStream.write(bArr, i3, i5);
                    i2 = i3 + i5;
                }
                i3 = i2 + 1;
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(PdfName.j8, new Filter_FLATEDECODE());
        hashMap.put(PdfName.f8, new Filter_FLATEDECODE());
        hashMap.put(PdfName.b4, new Filter_ASCIIHEXDECODE());
        hashMap.put(PdfName.F3, new Filter_ASCIIHEXDECODE());
        hashMap.put(PdfName.a4, new Filter_ASCII85DECODE());
        hashMap.put(PdfName.l3, new Filter_ASCII85DECODE());
        hashMap.put(PdfName.Ma, new Filter_LZWDECODE());
        hashMap.put(PdfName.X4, new Filter_CCITTFAXDECODE());
        hashMap.put(PdfName.a6, new Filter_DoNothing());
        hashMap.put(PdfName.Ae, new Filter_RUNLENGTHDECODE());
        f26038a = Collections.unmodifiableMap(hashMap);
    }

    public static Map<PdfName, FilterHandler> a() {
        return f26038a;
    }
}
