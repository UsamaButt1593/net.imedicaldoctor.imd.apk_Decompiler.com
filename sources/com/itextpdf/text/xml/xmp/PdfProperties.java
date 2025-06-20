package com.itextpdf.text.xml.xmp;

import com.itextpdf.xmp.XMPException;
import com.itextpdf.xmp.XMPMeta;

public class PdfProperties {

    /* renamed from: a  reason: collision with root package name */
    public static final String f27409a = "Keywords";

    /* renamed from: b  reason: collision with root package name */
    public static final String f27410b = "PDFVersion";

    /* renamed from: c  reason: collision with root package name */
    public static final String f27411c = "Producer";

    /* renamed from: d  reason: collision with root package name */
    public static final String f27412d = "part";

    public static void a(XMPMeta xMPMeta, String str) throws XMPException {
        xMPMeta.R2("http://ns.adobe.com/pdf/1.3/", f27409a, str);
    }

    public static void b(XMPMeta xMPMeta, String str) throws XMPException {
        xMPMeta.R2("http://ns.adobe.com/pdf/1.3/", f27411c, str);
    }

    public static void c(XMPMeta xMPMeta, String str) throws XMPException {
        xMPMeta.R2("http://ns.adobe.com/pdf/1.3/", f27410b, str);
    }
}
