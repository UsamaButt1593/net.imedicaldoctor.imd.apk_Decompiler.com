package com.itextpdf.text.api;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

public interface WriterOperation {
    void a(PdfWriter pdfWriter, Document document) throws DocumentException;
}
