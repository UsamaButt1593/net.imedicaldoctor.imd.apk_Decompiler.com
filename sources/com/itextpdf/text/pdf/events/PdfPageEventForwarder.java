package com.itextpdf.text.pdf.events;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPageEvent;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class PdfPageEventForwarder implements PdfPageEvent {

    /* renamed from: a  reason: collision with root package name */
    protected ArrayList<PdfPageEvent> f26798a = new ArrayList<>();

    public void a(PdfPageEvent pdfPageEvent) {
        this.f26798a.add(pdfPageEvent);
    }

    public void b(PdfWriter pdfWriter, Document document, float f2, Paragraph paragraph) {
        Iterator<PdfPageEvent> it2 = this.f26798a.iterator();
        while (it2.hasNext()) {
            it2.next().b(pdfWriter, document, f2, paragraph);
        }
    }

    public void c(PdfWriter pdfWriter, Document document) {
        Iterator<PdfPageEvent> it2 = this.f26798a.iterator();
        while (it2.hasNext()) {
            it2.next().c(pdfWriter, document);
        }
    }

    public void d(PdfWriter pdfWriter, Document document) {
        Iterator<PdfPageEvent> it2 = this.f26798a.iterator();
        while (it2.hasNext()) {
            it2.next().d(pdfWriter, document);
        }
    }

    public void e(PdfWriter pdfWriter, Document document, Rectangle rectangle, String str) {
        Iterator<PdfPageEvent> it2 = this.f26798a.iterator();
        while (it2.hasNext()) {
            it2.next().e(pdfWriter, document, rectangle, str);
        }
    }

    public void f(PdfWriter pdfWriter, Document document, float f2, int i2, Paragraph paragraph) {
        Iterator<PdfPageEvent> it2 = this.f26798a.iterator();
        while (it2.hasNext()) {
            it2.next().f(pdfWriter, document, f2, i2, paragraph);
        }
    }

    public void g(PdfWriter pdfWriter, Document document) {
        Iterator<PdfPageEvent> it2 = this.f26798a.iterator();
        while (it2.hasNext()) {
            it2.next().g(pdfWriter, document);
        }
    }

    public void h(PdfWriter pdfWriter, Document document, float f2) {
        Iterator<PdfPageEvent> it2 = this.f26798a.iterator();
        while (it2.hasNext()) {
            it2.next().h(pdfWriter, document, f2);
        }
    }

    public void i(PdfWriter pdfWriter, Document document, float f2) {
        Iterator<PdfPageEvent> it2 = this.f26798a.iterator();
        while (it2.hasNext()) {
            it2.next().i(pdfWriter, document, f2);
        }
    }

    public void j(PdfWriter pdfWriter, Document document, float f2) {
        Iterator<PdfPageEvent> it2 = this.f26798a.iterator();
        while (it2.hasNext()) {
            it2.next().j(pdfWriter, document, f2);
        }
    }

    public void k(PdfWriter pdfWriter, Document document) {
        Iterator<PdfPageEvent> it2 = this.f26798a.iterator();
        while (it2.hasNext()) {
            it2.next().k(pdfWriter, document);
        }
    }

    public void l(PdfWriter pdfWriter, Document document, float f2) {
        Iterator<PdfPageEvent> it2 = this.f26798a.iterator();
        while (it2.hasNext()) {
            it2.next().l(pdfWriter, document, f2);
        }
    }
}
