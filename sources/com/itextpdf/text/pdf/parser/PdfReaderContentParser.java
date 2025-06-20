package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PdfReaderContentParser {

    /* renamed from: a  reason: collision with root package name */
    private final PdfReader f27042a;

    public PdfReaderContentParser(PdfReader pdfReader) {
        this.f27042a = pdfReader;
    }

    public <E extends RenderListener> E a(int i2, E e2) throws IOException {
        return b(i2, e2, new HashMap());
    }

    public <E extends RenderListener> E b(int i2, E e2, Map<String, ContentOperator> map) throws IOException {
        PdfDictionary j0 = this.f27042a.h0(i2).j0(PdfName.Wd);
        PdfContentStreamProcessor pdfContentStreamProcessor = new PdfContentStreamProcessor(e2);
        for (Map.Entry next : map.entrySet()) {
            pdfContentStreamProcessor.R((String) next.getKey(), (ContentOperator) next.getValue());
        }
        pdfContentStreamProcessor.Q(ContentByteUtils.a(this.f27042a, i2), j0);
        return e2;
    }
}
