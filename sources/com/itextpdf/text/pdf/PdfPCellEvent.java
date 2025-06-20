package com.itextpdf.text.pdf;

import com.itextpdf.text.Rectangle;

public interface PdfPCellEvent {
    void a(PdfPCell pdfPCell, Rectangle rectangle, PdfContentByte[] pdfContentByteArr);
}
