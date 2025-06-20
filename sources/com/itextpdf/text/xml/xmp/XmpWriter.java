package com.itextpdf.text.xml.xmp;

import com.itextpdf.text.Version;
import com.itextpdf.text.pdf.PdfDate;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfString;
import com.itextpdf.xmp.XMPConst;
import com.itextpdf.xmp.XMPException;
import com.itextpdf.xmp.XMPMeta;
import com.itextpdf.xmp.XMPMetaFactory;
import com.itextpdf.xmp.XMPUtils;
import com.itextpdf.xmp.options.PropertyOptions;
import com.itextpdf.xmp.options.SerializeOptions;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

public class XmpWriter {

    /* renamed from: d  reason: collision with root package name */
    public static final String f27438d = "UTF-8";

    /* renamed from: e  reason: collision with root package name */
    public static final String f27439e = "UTF-16";

    /* renamed from: f  reason: collision with root package name */
    public static final String f27440f = "UTF-16BE";

    /* renamed from: g  reason: collision with root package name */
    public static final String f27441g = "UTF-16LE";

    /* renamed from: a  reason: collision with root package name */
    protected XMPMeta f27442a;

    /* renamed from: b  reason: collision with root package name */
    protected OutputStream f27443b;

    /* renamed from: c  reason: collision with root package name */
    protected SerializeOptions f27444c;

    public XmpWriter(OutputStream outputStream) throws IOException {
        this(outputStream, "UTF-8", 2000);
    }

    public void a(Object obj, String str) throws XMPException {
        XMPMeta xMPMeta;
        String str2;
        XMPMeta xMPMeta2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (obj instanceof String) {
            obj = new PdfName((String) obj);
        }
        if (PdfName.ig.equals(obj)) {
            xMPMeta2 = this.f27442a;
            str3 = "x-default";
            str4 = "x-default";
            str5 = "http://purl.org/dc/elements/1.1/";
            str6 = "title";
        } else if (PdfName.g4.equals(obj)) {
            this.f27442a.U0("http://purl.org/dc/elements/1.1/", DublinCoreProperties.f27397c, new PropertyOptions(1024), str, (PropertyOptions) null);
            return;
        } else if (PdfName.Af.equals(obj)) {
            xMPMeta2 = this.f27442a;
            str3 = "x-default";
            str4 = "x-default";
            str5 = "http://purl.org/dc/elements/1.1/";
            str6 = DublinCoreProperties.f27399e;
        } else {
            String str7 = "http://ns.adobe.com/pdf/1.3/";
            if (PdfName.ha.equals(obj)) {
                for (String str8 : str.split(",|;")) {
                    if (str8.trim().length() > 0) {
                        this.f27442a.U0("http://purl.org/dc/elements/1.1/", "subject", new PropertyOptions(512), str8.trim(), (PropertyOptions) null);
                    }
                }
                xMPMeta = this.f27442a;
                str2 = PdfProperties.f27409a;
            } else if (PdfName.sd.equals(obj)) {
                xMPMeta = this.f27442a;
                str2 = PdfProperties.f27411c;
            } else {
                str7 = "http://ns.adobe.com/xap/1.0/";
                if (PdfName.V5.equals(obj)) {
                    xMPMeta = this.f27442a;
                    str2 = XmpBasicProperties.f27416d;
                } else {
                    if (PdfName.U5.equals(obj)) {
                        xMPMeta = this.f27442a;
                        str2 = XmpBasicProperties.f27415c;
                    } else if (PdfName.ib.equals(obj)) {
                        xMPMeta = this.f27442a;
                        str2 = XmpBasicProperties.f27419g;
                    } else {
                        return;
                    }
                    str = PdfDate.x0(str);
                }
            }
            xMPMeta.R2(str7, str2, str);
            return;
        }
        xMPMeta2.d0(str5, str6, str3, str4, str);
    }

    @Deprecated
    public void b(XmpSchema xmpSchema) throws IOException {
        try {
            XMPUtils.a(XMPMetaFactory.i("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"><rdf:Description rdf:about=\"" + this.f27442a.p1() + "\" " + xmpSchema.c() + ">" + xmpSchema.toString() + "</rdf:Description></rdf:RDF>\n"), this.f27442a, true, true);
        } catch (XMPException e2) {
            throw new IOException(e2.getMessage());
        }
    }

    @Deprecated
    public void c(String str, String str2) throws IOException {
        try {
            XMPUtils.a(XMPMetaFactory.i("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"><rdf:Description rdf:about=\"" + this.f27442a.p1() + "\" " + str + ">" + str2 + "</rdf:Description></rdf:RDF>\n"), this.f27442a, true, true);
        } catch (XMPException e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public void d(String str, String str2, String str3) throws XMPException {
        this.f27442a.U0(str, str2, new PropertyOptions(2048), str3, (PropertyOptions) null);
    }

    public void e(String str, String str2, String str3) throws XMPException {
        this.f27442a.U0(str, str2, new PropertyOptions(512), str3, (PropertyOptions) null);
    }

    public void f(String str, String str2, String str3) throws XMPException {
        this.f27442a.U0(str, str2, new PropertyOptions(1024), str3, (PropertyOptions) null);
    }

    public void g() throws IOException {
        OutputStream outputStream = this.f27443b;
        if (outputStream != null) {
            try {
                XMPMetaFactory.m(this.f27442a, outputStream, this.f27444c);
                this.f27443b = null;
            } catch (XMPException e2) {
                throw new IOException(e2.getMessage());
            }
        }
    }

    public XMPMeta h() {
        return this.f27442a;
    }

    public void i(OutputStream outputStream) throws XMPException {
        XMPMetaFactory.m(this.f27442a, outputStream, this.f27444c);
    }

    public void j(String str) {
        this.f27442a.K1(str);
    }

    public void k(String str, String str2, Object obj) throws XMPException {
        this.f27442a.R2(str, str2, obj);
    }

    public void l() {
        this.f27444c.P(true);
    }

    public XmpWriter(OutputStream outputStream, PdfDictionary pdfDictionary) throws IOException {
        this(outputStream);
        if (pdfDictionary != null) {
            for (PdfName next : pdfDictionary.G0()) {
                PdfObject d0 = pdfDictionary.d0(next);
                if (d0 != null && d0.N()) {
                    try {
                        a(next, ((PdfString) d0).m0());
                    } catch (XMPException e2) {
                        throw new IOException(e2.getMessage());
                    }
                }
            }
        }
    }

    public XmpWriter(OutputStream outputStream, String str, int i2) throws IOException {
        this.f27443b = outputStream;
        this.f27444c = new SerializeOptions();
        if ("UTF-16BE".equals(str) || "UTF-16".equals(str)) {
            this.f27444c.G(true);
        } else if ("UTF-16LE".equals(str)) {
            this.f27444c.H(true);
        }
        this.f27444c.O(i2);
        XMPMeta b2 = XMPMetaFactory.b();
        this.f27442a = b2;
        b2.K1(XMPConst.t2);
        this.f27442a.K1("");
        try {
            this.f27442a.R2("http://purl.org/dc/elements/1.1/", DublinCoreProperties.f27400f, "application/pdf");
            this.f27442a.R2("http://ns.adobe.com/pdf/1.3/", PdfProperties.f27411c, Version.a().e());
        } catch (XMPException unused) {
        }
    }

    public XmpWriter(OutputStream outputStream, Map<String, String> map) throws IOException {
        this(outputStream);
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                String str2 = (String) next.getValue();
                if (str2 != null) {
                    try {
                        a(str, str2);
                    } catch (XMPException e2) {
                        throw new IOException(e2.getMessage());
                    }
                }
            }
        }
    }
}
