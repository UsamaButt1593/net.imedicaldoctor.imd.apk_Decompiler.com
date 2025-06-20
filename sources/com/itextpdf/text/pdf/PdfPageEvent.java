package com.itextpdf.text.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;

public interface PdfPageEvent {
    void b(PdfWriter pdfWriter, Document document, float f2, Paragraph paragraph);

    void c(PdfWriter pdfWriter, Document document);

    void d(PdfWriter pdfWriter, Document document);

    void e(PdfWriter pdfWriter, Document document, Rectangle rectangle, String str);

    void f(PdfWriter pdfWriter, Document document, float f2, int i2, Paragraph paragraph);

    void g(PdfWriter pdfWriter, Document document);

    void h(PdfWriter pdfWriter, Document document, float f2);

    void i(PdfWriter pdfWriter, Document document, float f2);

    void j(PdfWriter pdfWriter, Document document, float f2);

    void k(PdfWriter pdfWriter, Document document);

    void l(PdfWriter pdfWriter, Document document, float f2);
}
