package com.itextpdf.text.pdf;

import com.itextpdf.text.ExceptionConverter;
import java.io.IOException;

public class PdfFunction {

    /* renamed from: a  reason: collision with root package name */
    protected PdfWriter f26224a;

    /* renamed from: b  reason: collision with root package name */
    protected PdfIndirectReference f26225b;

    /* renamed from: c  reason: collision with root package name */
    protected PdfDictionary f26226c;

    protected PdfFunction(PdfWriter pdfWriter) {
        this.f26224a = pdfWriter;
    }

    public static PdfFunction b(PdfWriter pdfWriter, float[] fArr, float[] fArr2, int[] iArr, int i2, int i3, float[] fArr3, float[] fArr4, byte[] bArr) {
        PdfFunction pdfFunction = new PdfFunction(pdfWriter);
        PdfStream pdfStream = new PdfStream(bArr);
        pdfFunction.f26226c = pdfStream;
        pdfStream.i1(pdfWriter.a1());
        pdfFunction.f26226c.V0(PdfName.G8, new PdfNumber(0));
        pdfFunction.f26226c.V0(PdfName.Q6, new PdfArray(fArr));
        pdfFunction.f26226c.V0(PdfName.Fd, new PdfArray(fArr2));
        pdfFunction.f26226c.V0(PdfName.Ve, new PdfArray(iArr));
        pdfFunction.f26226c.V0(PdfName.v4, new PdfNumber(i2));
        if (i3 != 1) {
            pdfFunction.f26226c.V0(PdfName.jc, new PdfNumber(i3));
        }
        if (fArr3 != null) {
            pdfFunction.f26226c.V0(PdfName.k7, new PdfArray(fArr3));
        }
        if (fArr4 != null) {
            pdfFunction.f26226c.V0(PdfName.n6, new PdfArray(fArr4));
        }
        return pdfFunction;
    }

    public static PdfFunction c(PdfWriter pdfWriter, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float f2) {
        PdfFunction pdfFunction = new PdfFunction(pdfWriter);
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfFunction.f26226c = pdfDictionary;
        pdfDictionary.V0(PdfName.G8, new PdfNumber(2));
        pdfFunction.f26226c.V0(PdfName.Q6, new PdfArray(fArr));
        if (fArr2 != null) {
            pdfFunction.f26226c.V0(PdfName.Fd, new PdfArray(fArr2));
        }
        if (fArr3 != null) {
            pdfFunction.f26226c.V0(PdfName.L4, new PdfArray(fArr3));
        }
        if (fArr4 != null) {
            pdfFunction.f26226c.V0(PdfName.M4, new PdfArray(fArr4));
        }
        pdfFunction.f26226c.V0(PdfName.kb, new PdfNumber(f2));
        return pdfFunction;
    }

    public static PdfFunction d(PdfWriter pdfWriter, float[] fArr, float[] fArr2, PdfFunction[] pdfFunctionArr, float[] fArr3, float[] fArr4) {
        PdfFunction pdfFunction = new PdfFunction(pdfWriter);
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfFunction.f26226c = pdfDictionary;
        pdfDictionary.V0(PdfName.G8, new PdfNumber(3));
        pdfFunction.f26226c.V0(PdfName.Q6, new PdfArray(fArr));
        if (fArr2 != null) {
            pdfFunction.f26226c.V0(PdfName.Fd, new PdfArray(fArr2));
        }
        PdfArray pdfArray = new PdfArray();
        for (PdfFunction a2 : pdfFunctionArr) {
            pdfArray.a0(a2.a());
        }
        pdfFunction.f26226c.V0(PdfName.F8, pdfArray);
        pdfFunction.f26226c.V0(PdfName.F4, new PdfArray(fArr3));
        pdfFunction.f26226c.V0(PdfName.k7, new PdfArray(fArr4));
        return pdfFunction;
    }

    public static PdfFunction e(PdfWriter pdfWriter, float[] fArr, float[] fArr2, String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = (byte) str.charAt(i2);
        }
        PdfFunction pdfFunction = new PdfFunction(pdfWriter);
        PdfStream pdfStream = new PdfStream(bArr);
        pdfFunction.f26226c = pdfStream;
        pdfStream.i1(pdfWriter.a1());
        pdfFunction.f26226c.V0(PdfName.G8, new PdfNumber(4));
        pdfFunction.f26226c.V0(PdfName.Q6, new PdfArray(fArr));
        pdfFunction.f26226c.V0(PdfName.Fd, new PdfArray(fArr2));
        return pdfFunction;
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference a() {
        try {
            if (this.f26225b == null) {
                this.f26225b = this.f26224a.v0(this.f26226c).a();
            }
            return this.f26225b;
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }
}
