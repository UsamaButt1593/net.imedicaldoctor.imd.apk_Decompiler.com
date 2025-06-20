package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.pdf.PdfReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class PdfTextExtractor {
    private PdfTextExtractor() {
    }

    public static String a(PdfReader pdfReader, int i2) throws IOException {
        return b(pdfReader, i2, new LocationTextExtractionStrategy());
    }

    public static String b(PdfReader pdfReader, int i2, TextExtractionStrategy textExtractionStrategy) throws IOException {
        return c(pdfReader, i2, textExtractionStrategy, new HashMap());
    }

    public static String c(PdfReader pdfReader, int i2, TextExtractionStrategy textExtractionStrategy, Map<String, ContentOperator> map) throws IOException {
        return ((TextExtractionStrategy) new PdfReaderContentParser(pdfReader).b(i2, textExtractionStrategy, map)).g();
    }
}
