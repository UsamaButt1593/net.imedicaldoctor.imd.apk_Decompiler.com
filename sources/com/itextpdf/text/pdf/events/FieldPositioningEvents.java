package com.itextpdf.text.pdf.events;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfFormField;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPCellEvent;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfRectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.TextField;
import java.io.IOException;
import java.util.HashMap;

public class FieldPositioningEvents extends PdfPageEventHelper implements PdfPCellEvent {

    /* renamed from: a  reason: collision with root package name */
    protected HashMap<String, PdfFormField> f26780a;

    /* renamed from: b  reason: collision with root package name */
    protected PdfFormField f26781b;

    /* renamed from: c  reason: collision with root package name */
    protected PdfWriter f26782c;

    /* renamed from: d  reason: collision with root package name */
    protected PdfFormField f26783d;

    /* renamed from: e  reason: collision with root package name */
    public float f26784e;

    public FieldPositioningEvents() {
        this.f26780a = new HashMap<>();
        this.f26781b = null;
        this.f26782c = null;
        this.f26783d = null;
    }

    public void a(PdfPCell pdfPCell, Rectangle rectangle, PdfContentByte[] pdfContentByteArr) {
        PdfFormField pdfFormField = this.f26781b;
        if (pdfFormField == null || (this.f26782c == null && this.f26783d == null)) {
            throw new IllegalArgumentException(MessageLocalization.b("you.have.used.the.wrong.constructor.for.this.fieldpositioningevents.class", new Object[0]));
        }
        pdfFormField.V0(PdfName.Nd, new PdfRectangle(rectangle.P(this.f26784e), rectangle.I(this.f26784e), rectangle.R(this.f26784e), rectangle.W(this.f26784e)));
        PdfFormField pdfFormField2 = this.f26783d;
        if (pdfFormField2 == null) {
            this.f26782c.u(this.f26781b);
        } else {
            pdfFormField2.L2(this.f26781b);
        }
    }

    public void e(PdfWriter pdfWriter, Document document, Rectangle rectangle, String str) {
        rectangle.u0(rectangle.H() - 3.0f);
        PdfFormField pdfFormField = this.f26780a.get(str);
        if (pdfFormField == null) {
            TextField textField = new TextField(pdfWriter, new Rectangle(rectangle.P(this.f26784e), rectangle.I(this.f26784e), rectangle.R(this.f26784e), rectangle.W(this.f26784e)), str);
            textField.F(14.0f);
            try {
                pdfFormField = textField.f0();
            } catch (Exception e2) {
                throw new ExceptionConverter(e2);
            }
        } else {
            pdfFormField.V0(PdfName.Nd, new PdfRectangle(rectangle.P(this.f26784e), rectangle.I(this.f26784e), rectangle.R(this.f26784e), rectangle.W(this.f26784e)));
        }
        PdfFormField pdfFormField2 = this.f26783d;
        if (pdfFormField2 == null) {
            pdfWriter.u(pdfFormField);
        } else {
            pdfFormField2.L2(pdfFormField);
        }
    }

    public void m(String str, PdfFormField pdfFormField) {
        this.f26780a.put(str, pdfFormField);
    }

    public void n(float f2) {
        this.f26784e = f2;
    }

    public void o(PdfFormField pdfFormField) {
        this.f26783d = pdfFormField;
    }

    public FieldPositioningEvents(PdfFormField pdfFormField, PdfFormField pdfFormField2) {
        this.f26780a = new HashMap<>();
        this.f26782c = null;
        this.f26781b = pdfFormField2;
        this.f26783d = pdfFormField;
    }

    public FieldPositioningEvents(PdfWriter pdfWriter, PdfFormField pdfFormField) {
        this.f26780a = new HashMap<>();
        this.f26783d = null;
        this.f26781b = pdfFormField;
        this.f26782c = pdfWriter;
    }

    public FieldPositioningEvents(PdfWriter pdfWriter, PdfFormField pdfFormField, String str) throws IOException, DocumentException {
        this.f26780a = new HashMap<>();
        this.f26781b = null;
        this.f26782c = null;
        this.f26783d = pdfFormField;
        TextField textField = new TextField(pdfWriter, new Rectangle(0.0f, 0.0f), str);
        textField.F(14.0f);
        this.f26781b = textField.f0();
    }

    public FieldPositioningEvents(PdfWriter pdfWriter, String str) throws IOException, DocumentException {
        this.f26780a = new HashMap<>();
        this.f26781b = null;
        this.f26783d = null;
        this.f26782c = pdfWriter;
        TextField textField = new TextField(pdfWriter, new Rectangle(0.0f, 0.0f), str);
        textField.F(14.0f);
        this.f26781b = textField.f0();
    }
}
