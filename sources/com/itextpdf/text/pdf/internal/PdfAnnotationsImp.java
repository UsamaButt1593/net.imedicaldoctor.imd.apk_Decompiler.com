package com.itextpdf.text.pdf.internal;

import com.itextpdf.text.Annotation;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfAcroForm;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfAnnotation;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfFileSpecification;
import com.itextpdf.text.pdf.PdfFormField;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfRectangle;
import com.itextpdf.text.pdf.PdfString;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;

public class PdfAnnotationsImp {

    /* renamed from: a  reason: collision with root package name */
    protected PdfAcroForm f26860a;

    /* renamed from: b  reason: collision with root package name */
    protected ArrayList<PdfAnnotation> f26861b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    protected ArrayList<PdfAnnotation> f26862c = new ArrayList<>();

    public PdfAnnotationsImp(PdfWriter pdfWriter) {
        this.f26860a = new PdfAcroForm(pdfWriter);
    }

    public static PdfAnnotation e(PdfWriter pdfWriter, Annotation annotation, Rectangle rectangle) throws IOException {
        switch (annotation.a()) {
            case 1:
                return pdfWriter.K0(annotation.f(), annotation.h(), annotation.l(), annotation.n(), new PdfAction((URL) annotation.c().get("url")), (PdfName) null);
            case 2:
                return pdfWriter.K0(annotation.f(), annotation.h(), annotation.l(), annotation.n(), new PdfAction((String) annotation.c().get(Annotation.k3)), (PdfName) null);
            case 3:
                return pdfWriter.K0(annotation.f(), annotation.h(), annotation.l(), annotation.n(), new PdfAction((String) annotation.c().get(Annotation.k3), (String) annotation.c().get(Annotation.l3)), (PdfName) null);
            case 4:
                return pdfWriter.K0(annotation.f(), annotation.h(), annotation.l(), annotation.n(), new PdfAction((String) annotation.c().get(Annotation.k3), ((Integer) annotation.c().get(Annotation.m3)).intValue()), (PdfName) null);
            case 5:
                return pdfWriter.K0(annotation.f(), annotation.h(), annotation.l(), annotation.n(), new PdfAction(((Integer) annotation.c().get(Annotation.n3)).intValue()), (PdfName) null);
            case 6:
                return pdfWriter.K0(annotation.f(), annotation.h(), annotation.l(), annotation.n(), new PdfAction((String) annotation.c().get("application"), (String) annotation.c().get(Annotation.p3), (String) annotation.c().get(Annotation.q3), (String) annotation.c().get(Annotation.r3)), (PdfName) null);
            case 7:
                boolean[] zArr = (boolean[]) annotation.c().get(Annotation.p3);
                String str = (String) annotation.c().get(Annotation.k3);
                return PdfAnnotation.G1(pdfWriter, new Rectangle(annotation.f(), annotation.h(), annotation.l(), annotation.n()), str, zArr[0] ? PdfFileSpecification.m1(pdfWriter, str, str, (byte[]) null) : PdfFileSpecification.s1(pdfWriter, str), (String) annotation.c().get(Annotation.w3), zArr[1]);
            default:
                return pdfWriter.L0(rectangle.O(), rectangle.H(), rectangle.Q(), rectangle.T(), new PdfString(annotation.k(), PdfObject.h3), new PdfString(annotation.e(), PdfObject.h3), (PdfName) null);
        }
    }

    public void a(PdfAnnotation pdfAnnotation) {
        if (pdfAnnotation.W1()) {
            PdfFormField pdfFormField = (PdfFormField) pdfAnnotation;
            if (pdfFormField.a3() == null) {
                c(pdfFormField);
                return;
            }
            return;
        }
        this.f26861b.add(pdfAnnotation);
    }

    public void b(PdfFormField pdfFormField) {
        this.f26860a.f1(pdfFormField);
    }

    /* access modifiers changed from: package-private */
    public void c(PdfFormField pdfFormField) {
        this.f26861b.add(pdfFormField);
        ArrayList<PdfFormField> Z2 = pdfFormField.Z2();
        if (Z2 != null) {
            for (int i2 = 0; i2 < Z2.size(); i2++) {
                PdfFormField pdfFormField2 = Z2.get(i2);
                if (!pdfFormField2.X1()) {
                    c(pdfFormField2);
                }
            }
        }
    }

    public void d(PdfAnnotation pdfAnnotation) {
        this.f26861b.add(pdfAnnotation);
    }

    public PdfAcroForm f() {
        return this.f26860a;
    }

    public boolean g() {
        return !this.f26861b.isEmpty();
    }

    public boolean h() {
        return this.f26860a.Z1();
    }

    public void i() {
        this.f26861b = this.f26862c;
        this.f26862c = new ArrayList<>();
    }

    public PdfArray j(PdfWriter pdfWriter, Rectangle rectangle) {
        PdfRectangle pdfRectangle;
        HashSet<PdfTemplate> Q1;
        PdfArray pdfArray = new PdfArray();
        int S = rectangle.S() % 360;
        int e1 = pdfWriter.e1();
        for (int i2 = 0; i2 < this.f26861b.size(); i2++) {
            PdfAnnotation pdfAnnotation = this.f26861b.get(i2);
            if (pdfAnnotation.P1() > e1) {
                this.f26862c.add(pdfAnnotation);
            } else {
                if (pdfAnnotation.W1()) {
                    if (!pdfAnnotation.X1() && (Q1 = pdfAnnotation.Q1()) != null) {
                        this.f26860a.p1(Q1);
                    }
                    PdfFormField pdfFormField = (PdfFormField) pdfAnnotation;
                    if (pdfFormField.a3() == null) {
                        this.f26860a.o1(pdfFormField.L1());
                    }
                }
                if (pdfAnnotation.V1()) {
                    pdfArray.a0(pdfAnnotation.L1());
                    if (!pdfAnnotation.X1()) {
                        PdfName pdfName = PdfName.Nd;
                        PdfArray e0 = pdfAnnotation.e0(pdfName);
                        PdfRectangle pdfRectangle2 = e0.size() == 4 ? new PdfRectangle(e0.J0(0).a0(), e0.J0(1).a0(), e0.J0(2).a0(), e0.J0(3).a0()) : new PdfRectangle(e0.J0(0).a0(), e0.J0(1).a0());
                        if (S == 90) {
                            pdfRectangle = new PdfRectangle(rectangle.T() - pdfRectangle2.X0(), pdfRectangle2.i1(), rectangle.T() - pdfRectangle2.q1(), pdfRectangle2.n1());
                        } else if (S == 180) {
                            pdfRectangle = new PdfRectangle(rectangle.Q() - pdfRectangle2.i1(), rectangle.T() - pdfRectangle2.X0(), rectangle.Q() - pdfRectangle2.n1(), rectangle.T() - pdfRectangle2.q1());
                        } else if (S == 270) {
                            pdfRectangle = new PdfRectangle(pdfRectangle2.X0(), rectangle.Q() - pdfRectangle2.i1(), pdfRectangle2.q1(), rectangle.Q() - pdfRectangle2.n1());
                        }
                        pdfAnnotation.V0(pdfName, pdfRectangle);
                    }
                }
                if (!pdfAnnotation.X1()) {
                    pdfAnnotation.K2();
                    try {
                        pdfWriter.y0(pdfAnnotation, pdfAnnotation.L1());
                    } catch (IOException e2) {
                        throw new ExceptionConverter(e2);
                    }
                }
            }
        }
        return pdfArray;
    }

    public void k(int i2) {
        this.f26860a.k2(i2);
    }
}
