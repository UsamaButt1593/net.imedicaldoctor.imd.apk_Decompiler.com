package com.itextpdf.text.xml.xmp;

import com.itextpdf.text.Version;

@Deprecated
public class PdfSchema extends XmpSchema {
    public static final String X2 = "http://ns.adobe.com/pdf/1.3/";
    private static final long Y = -1541148669123992185L;
    public static final String Y2 = "pdf:Keywords";
    public static final String Z = "pdf";
    public static final String Z2 = "pdf:PDFVersion";
    public static final String a3 = "pdf:Producer";

    public PdfSchema() {
        super("xmlns:pdf=\"http://ns.adobe.com/pdf/1.3/\"");
        h(Version.a().e());
    }

    public void g(String str) {
        setProperty(Y2, str);
    }

    public void h(String str) {
        setProperty(a3, str);
    }

    public void i(String str) {
        setProperty(Z2, str);
    }
}
