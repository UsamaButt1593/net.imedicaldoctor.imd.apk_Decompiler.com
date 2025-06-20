package com.itextpdf.text.pdf.internal;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.pdf.OutputStreamCounter;
import com.itextpdf.text.pdf.PdfDeveloperExtension;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.interfaces.PdfVersion;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

public class PdfVersionImp implements PdfVersion {
    public static final byte[][] Z2 = {DocWriter.E(StringUtils.LF), DocWriter.E("%PDF-"), DocWriter.E("\n%âãÏÓ\n")};
    protected boolean X = false;
    protected char X2 = PdfWriter.r4;
    protected char Y = PdfWriter.r4;
    protected PdfDictionary Y2 = null;
    protected PdfName Z = null;
    protected boolean s = false;

    public void a(PdfDictionary pdfDictionary) {
        PdfName pdfName = this.Z;
        if (pdfName != null) {
            pdfDictionary.V0(PdfName.ph, pdfName);
        }
        PdfDictionary pdfDictionary2 = this.Y2;
        if (pdfDictionary2 != null) {
            pdfDictionary.V0(PdfName.z7, pdfDictionary2);
        }
    }

    public char b() {
        return this.X2;
    }

    public byte[] c(char c2) {
        return DocWriter.E(d(c2).toString().substring(1));
    }

    public PdfName d(char c2) {
        switch (c2) {
            case '2':
                return PdfWriter.v4;
            case '3':
                return PdfWriter.w4;
            case '4':
                return PdfWriter.x4;
            case '5':
                return PdfWriter.y4;
            case '6':
                return PdfWriter.z4;
            case '7':
                return PdfWriter.A4;
            default:
                return PdfWriter.x4;
        }
    }

    public void e(char c2) {
        if (c2 > this.Y) {
            q(c2);
        }
    }

    public void f(boolean z) {
        this.X = z;
    }

    public void g(OutputStreamCounter outputStreamCounter) throws IOException {
        if (this.X) {
            outputStreamCounter.write(Z2[0]);
            return;
        }
        byte[][] bArr = Z2;
        outputStreamCounter.write(bArr[1]);
        outputStreamCounter.write(c(this.Y));
        outputStreamCounter.write(bArr[2]);
        this.s = true;
    }

    public void q(char c2) {
        this.X2 = c2;
        if (this.s || this.X) {
            x(d(c2));
        } else {
            this.Y = c2;
        }
    }

    public void w(PdfDeveloperExtension pdfDeveloperExtension) {
        PdfDictionary pdfDictionary = this.Y2;
        if (pdfDictionary == null) {
            this.Y2 = new PdfDictionary();
        } else {
            PdfDictionary j0 = pdfDictionary.j0(pdfDeveloperExtension.d());
            if (j0 != null && (pdfDeveloperExtension.a().compareTo(j0.p0(PdfName.m4)) < 0 || pdfDeveloperExtension.c() - j0.q0(PdfName.A7).e0() <= 0)) {
                return;
            }
        }
        this.Y2.V0(pdfDeveloperExtension.d(), pdfDeveloperExtension.b());
    }

    public void x(PdfName pdfName) {
        PdfName pdfName2 = this.Z;
        if (pdfName2 == null || pdfName2.compareTo(pdfName) < 0) {
            this.Z = pdfName;
        }
    }
}
