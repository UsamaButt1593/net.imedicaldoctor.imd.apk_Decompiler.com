package com.itextpdf.text.pdf;

import com.itextpdf.text.log.Counter;
import com.itextpdf.text.log.CounterFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;

public class FdfReader extends PdfReader {
    protected static Counter U3 = CounterFactory.b(FdfReader.class);
    HashMap<String, PdfDictionary> R3;
    String S3;
    PdfName T3;

    public FdfReader(InputStream inputStream) throws IOException {
        super(inputStream);
    }

    /* access modifiers changed from: protected */
    public Counter H() {
        return U3;
    }

    public byte[] L1(String str) throws IOException {
        PdfDictionary pdfDictionary = this.R3.get(str);
        return pdfDictionary != null ? PdfReader.D0((PRStream) s0(((PRIndirectReference) ((PdfDictionary) s0(((PRIndirectReference) pdfDictionary.d0(PdfName.kh)).d())).j0(PdfName.e7).d0(PdfName.F7)).d())) : new byte[0];
    }

    public PdfDictionary M1(String str) {
        return this.R3.get(str);
    }

    public String N1(String str) {
        PdfObject t0;
        PdfDictionary pdfDictionary = this.R3.get(str);
        if (pdfDictionary == null || (t0 = PdfReader.t0(pdfDictionary.d0(PdfName.kh))) == null) {
            return null;
        }
        if (t0.E()) {
            return PdfName.a0(((PdfName) t0).toString());
        }
        if (!t0.N()) {
            return null;
        }
        PdfString pdfString = (PdfString) t0;
        if (this.T3 == null || pdfString.a0() != null) {
            return pdfString.m0();
        }
        byte[] k2 = pdfString.k();
        if (k2.length >= 2 && k2[0] == -2 && k2[1] == -1) {
            return pdfString.m0();
        }
        try {
            if (this.T3.equals(PdfName.Oe)) {
                return new String(k2, "SJIS");
            }
            if (this.T3.equals(PdfName.Rg)) {
                return new String(k2, "MS949");
            }
            if (this.T3.equals(PdfName.I8)) {
                return new String(k2, "GBK");
            }
            if (this.T3.equals(PdfName.r4)) {
                return new String(k2, "Big5");
            }
            if (this.T3.equals(PdfName.jh)) {
                return new String(k2, "UTF8");
            }
            return pdfString.m0();
        } catch (Exception unused) {
        }
    }

    public HashMap<String, PdfDictionary> O1() {
        return this.R3;
    }

    public String P1() {
        return this.S3;
    }

    /* access modifiers changed from: protected */
    public void Q1(PdfDictionary pdfDictionary, String str) {
        String str2;
        PdfName pdfName = PdfName.ia;
        PdfArray e0 = pdfDictionary.e0(pdfName);
        if (e0 == null || e0.isEmpty()) {
            if (str.length() > 0) {
                str = str.substring(1);
            }
            this.R3.put(str, pdfDictionary);
            return;
        }
        pdfDictionary.a1(pdfName);
        for (int i2 = 0; i2 < e0.size(); i2++) {
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            pdfDictionary2.T0(pdfDictionary);
            PdfDictionary B0 = e0.B0(i2);
            PdfName pdfName2 = PdfName.If;
            PdfString A0 = B0.A0(pdfName2);
            if (A0 != null) {
                str2 = str + "." + A0.m0();
            } else {
                str2 = str;
            }
            pdfDictionary2.T0(B0);
            pdfDictionary2.a1(pdfName2);
            Q1(pdfDictionary2, str2);
        }
    }

    /* access modifiers changed from: protected */
    public void R1() {
        PdfDictionary j0 = this.a3.j0(PdfName.se);
        this.b3 = j0;
        PdfDictionary j02 = j0.j0(PdfName.K7);
        if (j02 != null) {
            PdfString A0 = j02.A0(PdfName.F7);
            if (A0 != null) {
                this.S3 = A0.m0();
            }
            PdfArray e0 = j02.e0(PdfName.P7);
            if (e0 != null) {
                this.T3 = j02.p0(PdfName.m7);
                PdfDictionary pdfDictionary = new PdfDictionary();
                pdfDictionary.V0(PdfName.ia, e0);
                Q1(pdfDictionary, "");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void i1() throws IOException {
        this.R3 = new HashMap<>();
        this.s.b();
        o1();
        c1();
        R1();
    }

    public FdfReader(String str) throws IOException {
        super(str);
    }

    public FdfReader(URL url) throws IOException {
        super(url);
    }

    public FdfReader(byte[] bArr) throws IOException {
        super(bArr);
    }
}
