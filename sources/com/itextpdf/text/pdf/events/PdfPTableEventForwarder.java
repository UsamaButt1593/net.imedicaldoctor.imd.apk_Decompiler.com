package com.itextpdf.text.pdf.events;

import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPTableEvent;
import com.itextpdf.text.pdf.PdfPTableEventAfterSplit;
import com.itextpdf.text.pdf.PdfPTableEventSplit;
import java.util.ArrayList;
import java.util.Iterator;

public class PdfPTableEventForwarder implements PdfPTableEventAfterSplit {

    /* renamed from: a  reason: collision with root package name */
    protected ArrayList<PdfPTableEvent> f26797a = new ArrayList<>();

    public void a(PdfPTable pdfPTable, PdfPRow pdfPRow, int i2) {
        Iterator<PdfPTableEvent> it2 = this.f26797a.iterator();
        while (it2.hasNext()) {
            PdfPTableEvent next = it2.next();
            if (next instanceof PdfPTableEventAfterSplit) {
                ((PdfPTableEventAfterSplit) next).a(pdfPTable, pdfPRow, i2);
            }
        }
    }

    public void b(PdfPTable pdfPTable, float[][] fArr, float[] fArr2, int i2, int i3, PdfContentByte[] pdfContentByteArr) {
        Iterator<PdfPTableEvent> it2 = this.f26797a.iterator();
        while (it2.hasNext()) {
            it2.next().b(pdfPTable, fArr, fArr2, i2, i3, pdfContentByteArr);
        }
    }

    public void c(PdfPTable pdfPTable) {
        Iterator<PdfPTableEvent> it2 = this.f26797a.iterator();
        while (it2.hasNext()) {
            PdfPTableEvent next = it2.next();
            if (next instanceof PdfPTableEventSplit) {
                ((PdfPTableEventSplit) next).c(pdfPTable);
            }
        }
    }

    public void d(PdfPTableEvent pdfPTableEvent) {
        this.f26797a.add(pdfPTableEvent);
    }
}
