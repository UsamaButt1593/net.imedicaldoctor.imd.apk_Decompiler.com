package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.Version;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.exceptions.UnsupportedPdfException;
import com.itextpdf.text.pdf.FilterHandlers;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfString;
import com.itextpdf.text.pdf.codec.PngWriter;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import com.itextpdf.text.pdf.codec.TiffWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class PdfImageObject {

    /* renamed from: a  reason: collision with root package name */
    private PdfDictionary f27029a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f27030b;

    /* renamed from: c  reason: collision with root package name */
    private PdfDictionary f27031c;

    /* renamed from: d  reason: collision with root package name */
    private int f27032d;

    /* renamed from: e  reason: collision with root package name */
    private int f27033e;

    /* renamed from: f  reason: collision with root package name */
    private int f27034f;

    /* renamed from: g  reason: collision with root package name */
    private int f27035g;

    /* renamed from: h  reason: collision with root package name */
    private int f27036h;

    /* renamed from: i  reason: collision with root package name */
    private byte[] f27037i;

    /* renamed from: j  reason: collision with root package name */
    private byte[] f27038j;

    /* renamed from: k  reason: collision with root package name */
    private int f27039k;

    /* renamed from: l  reason: collision with root package name */
    private ImageBytesType f27040l;

    public enum ImageBytesType {
        PNG("png"),
        JPG("jpg"),
        JP2("jp2"),
        CCITT("tif"),
        JBIG2("jbig2");
        
        private final String s;

        private ImageBytesType(String str) {
            this.s = str;
        }

        public String a() {
            return this.s;
        }
    }

    private static class TrackingFilter implements FilterHandlers.FilterHandler {

        /* renamed from: a  reason: collision with root package name */
        public PdfName f27041a;

        private TrackingFilter() {
            this.f27041a = null;
        }

        public byte[] a(byte[] bArr, PdfName pdfName, PdfObject pdfObject, PdfDictionary pdfDictionary) throws IOException {
            this.f27041a = pdfName;
            return bArr;
        }
    }

    public PdfImageObject(PRStream pRStream) throws IOException {
        this(pRStream, PdfReader.F0(pRStream), (PdfDictionary) null);
    }

    private void a() throws IOException {
        PdfDictionary pdfDictionary;
        PdfObject B0;
        if (this.f27040l == null) {
            this.f27032d = -1;
            PdfArray e0 = this.f27029a.e0(PdfName.n6);
            this.f27034f = this.f27029a.q0(PdfName.Jh).e0();
            this.f27035g = this.f27029a.q0(PdfName.h9).e0();
            int e02 = this.f27029a.q0(PdfName.u4).e0();
            this.f27036h = e02;
            this.f27033e = e02;
            PdfObject B02 = this.f27029a.B0(PdfName.w5);
            if (!(!(B02 instanceof PdfName) || (pdfDictionary = this.f27031c) == null || (B0 = pdfDictionary.B0((PdfName) B02)) == null)) {
                B02 = B0;
            }
            this.f27037i = null;
            this.f27038j = null;
            this.f27039k = 0;
            b(B02, true);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (this.f27032d >= 0) {
                PngWriter pngWriter = new PngWriter(byteArrayOutputStream);
                if (e0 != null && this.f27033e == 1 && e0.J0(0).e0() == 1 && e0.J0(1).e0() == 0) {
                    int length = this.f27030b.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        byte[] bArr = this.f27030b;
                        bArr[i2] = (byte) (bArr[i2] ^ 255);
                    }
                }
                pngWriter.j(this.f27034f, this.f27035g, this.f27033e, this.f27032d);
                byte[] bArr2 = this.f27038j;
                if (bArr2 != null) {
                    pngWriter.k(bArr2);
                }
                byte[] bArr3 = this.f27037i;
                if (bArr3 != null) {
                    pngWriter.l(bArr3);
                }
                pngWriter.h(this.f27030b, this.f27039k);
                pngWriter.i();
                this.f27040l = ImageBytesType.PNG;
                this.f27030b = byteArrayOutputStream.toByteArray();
            } else if (this.f27036h == 8) {
                if (!PdfName.C6.equals(B02)) {
                    if (B02 instanceof PdfArray) {
                        PdfArray pdfArray = (PdfArray) B02;
                        if (PdfName.z9.equals(pdfArray.Q0(0))) {
                            PRStream pRStream = (PRStream) pdfArray.Q0(1);
                            int e03 = pRStream.q0(PdfName.kb).e0();
                            if (e03 == 4) {
                                this.f27038j = PdfReader.D0(pRStream);
                            } else {
                                throw new UnsupportedPdfException(MessageLocalization.a("N.value.1.is.not.supported", e03));
                            }
                        } else {
                            throw new UnsupportedPdfException(MessageLocalization.b("the.color.space.1.is.not.supported", B02));
                        }
                    } else {
                        throw new UnsupportedPdfException(MessageLocalization.b("the.color.space.1.is.not.supported", B02));
                    }
                }
                this.f27039k = this.f27034f * 4;
                TiffWriter tiffWriter = new TiffWriter();
                tiffWriter.a(new TiffWriter.FieldShort((int) TIFFConstants.r0, 4));
                tiffWriter.a(new TiffWriter.FieldShort(258, new int[]{8, 8, 8, 8}));
                tiffWriter.a(new TiffWriter.FieldShort(262, 5));
                tiffWriter.a(new TiffWriter.FieldLong(256, this.f27034f));
                tiffWriter.a(new TiffWriter.FieldLong(257, this.f27035g));
                tiffWriter.a(new TiffWriter.FieldShort(259, 5));
                tiffWriter.a(new TiffWriter.FieldShort(317, 2));
                tiffWriter.a(new TiffWriter.FieldLong((int) TIFFConstants.s0, this.f27035g));
                tiffWriter.a(new TiffWriter.FieldRational((int) TIFFConstants.w0, new int[]{300, 1}));
                tiffWriter.a(new TiffWriter.FieldRational((int) TIFFConstants.x0, new int[]{300, 1}));
                tiffWriter.a(new TiffWriter.FieldShort((int) TIFFConstants.T0, 2));
                tiffWriter.a(new TiffWriter.FieldAscii(305, Version.a().e()));
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                TiffWriter.b(byteArrayOutputStream2, 2, this.f27030b, this.f27035g, 4, this.f27039k);
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                tiffWriter.a(new TiffWriter.FieldImage(byteArray));
                tiffWriter.a(new TiffWriter.FieldLong((int) TIFFConstants.t0, byteArray.length));
                byte[] bArr4 = this.f27038j;
                if (bArr4 != null) {
                    tiffWriter.a(new TiffWriter.FieldUndefined(TIFFConstants.T2, bArr4));
                }
                tiffWriter.d(byteArrayOutputStream);
                this.f27040l = ImageBytesType.CCITT;
                this.f27030b = byteArrayOutputStream.toByteArray();
            } else {
                throw new UnsupportedPdfException(MessageLocalization.a("the.color.depth.1.is.not.supported", this.f27036h));
            }
        } else {
            throw new IllegalStateException(MessageLocalization.b("Decoding.can't.happen.on.this.type.of.stream.(.1.)", this.f27040l));
        }
    }

    private void b(PdfObject pdfObject, boolean z) throws IOException {
        int i2;
        int i3;
        int i4;
        if (pdfObject == null && (i4 = this.f27036h) == 1) {
            i3 = this.f27034f * i4;
        } else {
            if (!PdfName.A6.equals(pdfObject)) {
                if (PdfName.B6.equals(pdfObject)) {
                    i2 = this.f27036h;
                    if (!(i2 == 8 || i2 == 16)) {
                        return;
                    }
                } else if (pdfObject instanceof PdfArray) {
                    PdfArray pdfArray = (PdfArray) pdfObject;
                    PdfObject Q0 = pdfArray.Q0(0);
                    if (!PdfName.P4.equals(Q0)) {
                        if (PdfName.Q4.equals(Q0)) {
                            i2 = this.f27036h;
                            if (!(i2 == 8 || i2 == 16)) {
                                return;
                            }
                        } else if (PdfName.z9.equals(Q0)) {
                            PRStream pRStream = (PRStream) pdfArray.Q0(1);
                            int e0 = pRStream.q0(PdfName.kb).e0();
                            if (e0 == 1) {
                                this.f27039k = ((this.f27034f * this.f27036h) + 7) / 8;
                                this.f27032d = 0;
                                this.f27038j = PdfReader.D0(pRStream);
                                return;
                            } else if (e0 == 3) {
                                this.f27039k = (((this.f27034f * this.f27036h) * 3) + 7) / 8;
                                this.f27032d = 2;
                                this.f27038j = PdfReader.D0(pRStream);
                                return;
                            } else {
                                return;
                            }
                        } else if (z && PdfName.N9.equals(Q0)) {
                            b(pdfArray.Q0(1), false);
                            if (this.f27032d == 2) {
                                PdfObject Q02 = pdfArray.Q0(3);
                                if (Q02 instanceof PdfString) {
                                    this.f27037i = ((PdfString) Q02).k();
                                } else if (Q02 instanceof PRStream) {
                                    this.f27037i = PdfReader.D0((PRStream) Q02);
                                }
                                this.f27039k = ((this.f27034f * this.f27036h) + 7) / 8;
                                this.f27032d = 3;
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                } else {
                    return;
                }
                this.f27039k = (((this.f27034f * i2) * 3) + 7) / 8;
                this.f27032d = 2;
                return;
            }
            i3 = this.f27034f * this.f27036h;
        }
        this.f27039k = (i3 + 7) / 8;
        this.f27032d = 0;
    }

    public PdfObject c(PdfName pdfName) {
        return this.f27029a.d0(pdfName);
    }

    public PdfDictionary d() {
        return this.f27029a;
    }

    public String e() {
        return this.f27040l.a();
    }

    public byte[] f() {
        return this.f27030b;
    }

    public ImageBytesType g() {
        return this.f27040l;
    }

    public PdfImageObject(PRStream pRStream, PdfDictionary pdfDictionary) throws IOException {
        this(pRStream, PdfReader.F0(pRStream), pdfDictionary);
    }

    protected PdfImageObject(PdfDictionary pdfDictionary, byte[] bArr, PdfDictionary pdfDictionary2) throws IOException {
        ImageBytesType imageBytesType;
        this.f27032d = -1;
        this.f27040l = null;
        this.f27029a = pdfDictionary;
        this.f27031c = pdfDictionary2;
        TrackingFilter trackingFilter = new TrackingFilter();
        HashMap hashMap = new HashMap(FilterHandlers.a());
        PdfName pdfName = PdfName.ba;
        hashMap.put(pdfName, trackingFilter);
        PdfName pdfName2 = PdfName.k6;
        hashMap.put(pdfName2, trackingFilter);
        PdfName pdfName3 = PdfName.da;
        hashMap.put(pdfName3, trackingFilter);
        this.f27030b = PdfReader.r(bArr, pdfDictionary, hashMap);
        PdfName pdfName4 = trackingFilter.f27041a;
        if (pdfName4 != null) {
            if (pdfName.equals(pdfName4)) {
                imageBytesType = ImageBytesType.JBIG2;
            } else if (pdfName2.equals(trackingFilter.f27041a)) {
                imageBytesType = ImageBytesType.JPG;
            } else if (pdfName3.equals(trackingFilter.f27041a)) {
                imageBytesType = ImageBytesType.JP2;
            } else {
                return;
            }
            this.f27040l = imageBytesType;
            return;
        }
        a();
    }
}
