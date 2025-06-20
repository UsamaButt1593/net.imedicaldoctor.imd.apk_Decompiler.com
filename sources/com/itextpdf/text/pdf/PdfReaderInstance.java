package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class PdfReaderInstance {

    /* renamed from: h  reason: collision with root package name */
    static final PdfLiteral f26294h = new PdfLiteral("[1 0 0 1 0 0]");

    /* renamed from: i  reason: collision with root package name */
    static final PdfNumber f26295i = new PdfNumber(1);

    /* renamed from: a  reason: collision with root package name */
    int[] f26296a;

    /* renamed from: b  reason: collision with root package name */
    PdfReader f26297b;

    /* renamed from: c  reason: collision with root package name */
    RandomAccessFileOrArray f26298c;

    /* renamed from: d  reason: collision with root package name */
    HashMap<Integer, PdfImportedPage> f26299d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    PdfWriter f26300e;

    /* renamed from: f  reason: collision with root package name */
    HashSet<Integer> f26301f = new HashSet<>();

    /* renamed from: g  reason: collision with root package name */
    ArrayList<Integer> f26302g = new ArrayList<>();

    PdfReaderInstance(PdfReader pdfReader, PdfWriter pdfWriter) {
        this.f26297b = pdfReader;
        this.f26300e = pdfWriter;
        this.f26298c = pdfReader.B0();
        this.f26296a = new int[pdfReader.J0()];
    }

    /* access modifiers changed from: package-private */
    public PdfStream a(int i2, int i3) throws IOException {
        byte[] bArr;
        PRStream pRStream;
        PdfDictionary i0 = this.f26297b.i0(i2);
        PdfObject w0 = PdfReader.w0(i0.d0(PdfName.N5));
        PdfDictionary pdfDictionary = new PdfDictionary();
        if (w0 == null) {
            bArr = new byte[0];
        } else if (w0.K()) {
            pdfDictionary.X0((PRStream) w0);
            bArr = null;
        } else {
            bArr = this.f26297b.f0(i2, this.f26298c);
        }
        PdfName pdfName = PdfName.Wd;
        pdfDictionary.V0(pdfName, PdfReader.w0(i0.d0(pdfName)));
        pdfDictionary.V0(PdfName.Kg, PdfName.ai);
        pdfDictionary.V0(PdfName.Cf, PdfName.w8);
        PdfImportedPage pdfImportedPage = this.f26299d.get(Integer.valueOf(i2));
        pdfDictionary.V0(PdfName.n4, new PdfRectangle(pdfImportedPage.F3()));
        PdfArray L3 = pdfImportedPage.L3();
        if (L3 == null) {
            pdfDictionary.V0(PdfName.Qa, f26294h);
        } else {
            pdfDictionary.V0(PdfName.Qa, L3);
        }
        pdfDictionary.V0(PdfName.x8, f26295i);
        if (bArr == null) {
            PRStream pRStream2 = (PRStream) w0;
        } else {
            pRStream = new PRStream(this.f26297b, bArr, i3);
            pRStream.X0(pdfDictionary);
        }
        return pRStream;
    }

    /* access modifiers changed from: package-private */
    public PdfImportedPage b(int i2) {
        if (!this.f26297b.R0()) {
            throw new IllegalArgumentException(MessageLocalization.b("pdfreader.not.opened.with.owner.password", new Object[0]));
        } else if (i2 < 1 || i2 > this.f26297b.c0()) {
            throw new IllegalArgumentException(MessageLocalization.a("invalid.page.number.1", i2));
        } else {
            Integer valueOf = Integer.valueOf(i2);
            PdfImportedPage pdfImportedPage = this.f26299d.get(valueOf);
            if (pdfImportedPage != null) {
                return pdfImportedPage;
            }
            PdfImportedPage pdfImportedPage2 = new PdfImportedPage(this, this.f26300e, i2);
            this.f26299d.put(valueOf, pdfImportedPage2);
            return pdfImportedPage2;
        }
    }

    /* access modifiers changed from: package-private */
    public int c(int i2, int i3) {
        int[] iArr = this.f26296a;
        if (iArr[i2] == 0) {
            iArr[i2] = this.f26300e.n1();
            this.f26302g.add(Integer.valueOf(i2));
        }
        return this.f26296a[i2];
    }

    /* access modifiers changed from: package-private */
    public PdfReader d() {
        return this.f26297b;
    }

    /* access modifiers changed from: package-private */
    public RandomAccessFileOrArray e() {
        return this.f26298c;
    }

    /* access modifiers changed from: package-private */
    public PdfObject f(int i2) {
        return PdfReader.w0(this.f26297b.i0(i2).d0(PdfName.Wd));
    }

    public void g() throws IOException {
        try {
            this.f26298c.g();
            for (PdfImportedPage next : this.f26299d.values()) {
                if (next.e4()) {
                    PdfWriter pdfWriter = this.f26300e;
                    pdfWriter.y0(next.G3(pdfWriter.a1()), next.J3());
                    next.f4();
                }
            }
            h();
            try {
                this.f26298c.close();
            } catch (Exception unused) {
            }
        } finally {
            try {
                this.f26298c.close();
            } catch (Exception unused2) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void h() throws IOException {
        while (!this.f26302g.isEmpty()) {
            ArrayList<Integer> arrayList = this.f26302g;
            this.f26302g = new ArrayList<>();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Integer num = arrayList.get(i2);
                if (!this.f26301f.contains(num)) {
                    this.f26301f.add(num);
                    int intValue = num.intValue();
                    this.f26300e.w0(this.f26297b.v0(intValue), this.f26296a[intValue]);
                }
            }
        }
    }
}
