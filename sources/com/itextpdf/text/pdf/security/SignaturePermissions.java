package com.itextpdf.text.pdf.security;

import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import java.util.ArrayList;
import java.util.List;

public class SignaturePermissions {

    /* renamed from: a  reason: collision with root package name */
    boolean f27355a = false;

    /* renamed from: b  reason: collision with root package name */
    boolean f27356b = true;

    /* renamed from: c  reason: collision with root package name */
    boolean f27357c = true;

    /* renamed from: d  reason: collision with root package name */
    List<FieldLock> f27358d = new ArrayList();

    public class FieldLock {

        /* renamed from: a  reason: collision with root package name */
        PdfName f27359a;

        /* renamed from: b  reason: collision with root package name */
        PdfArray f27360b;

        public FieldLock(PdfName pdfName, PdfArray pdfArray) {
            this.f27359a = pdfName;
            this.f27360b = pdfArray;
        }

        public PdfName a() {
            return this.f27359a;
        }

        public PdfArray b() {
            return this.f27360b;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f27359a.toString());
            PdfArray pdfArray = this.f27360b;
            sb.append(pdfArray == null ? "" : pdfArray.toString());
            return sb.toString();
        }
    }

    public SignaturePermissions(PdfDictionary pdfDictionary, SignaturePermissions signaturePermissions) {
        if (signaturePermissions != null) {
            this.f27357c &= signaturePermissions.b();
            this.f27356b &= signaturePermissions.d();
            this.f27358d.addAll(signaturePermissions.a());
        }
        PdfArray e0 = pdfDictionary.e0(PdfName.Pd);
        if (e0 != null) {
            for (int i2 = 0; i2 < e0.size(); i2++) {
                PdfDictionary B0 = e0.B0(i2);
                PdfDictionary j0 = B0.j0(PdfName.tg);
                if (PdfName.M6.equals(B0.p0(PdfName.ug))) {
                    this.f27355a = true;
                }
                PdfName p0 = j0.p0(PdfName.q3);
                if (p0 != null) {
                    this.f27358d.add(new FieldLock(p0, j0.e0(PdfName.P7)));
                }
                PdfNumber q0 = j0.q0(PdfName.tc);
                if (q0 != null) {
                    int e02 = q0.e0();
                    if (e02 == 1) {
                        this.f27356b = false;
                    } else if (e02 != 2) {
                    }
                    this.f27357c = false;
                }
            }
        }
    }

    public List<FieldLock> a() {
        return this.f27358d;
    }

    public boolean b() {
        return this.f27357c;
    }

    public boolean c() {
        return this.f27355a;
    }

    public boolean d() {
        return this.f27356b;
    }
}
