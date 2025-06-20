package com.itextpdf.text.pdf.events;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPCellEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class PdfPCellEventForwarder implements PdfPCellEvent {

    /* renamed from: a  reason: collision with root package name */
    protected ArrayList<PdfPCellEvent> f26796a = new ArrayList<>();

    public void a(PdfPCell pdfPCell, Rectangle rectangle, PdfContentByte[] pdfContentByteArr) {
        Iterator<PdfPCellEvent> it2 = this.f26796a.iterator();
        while (it2.hasNext()) {
            it2.next().a(pdfPCell, rectangle, pdfContentByteArr);
        }
    }

    public void b(PdfPCellEvent pdfPCellEvent) {
        this.f26796a.add(pdfPCellEvent);
    }
}
