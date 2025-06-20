package com.itextpdf.text.xml.xmp;

import com.itextpdf.xmp.XMPException;
import com.itextpdf.xmp.XMPMeta;
import com.itextpdf.xmp.XMPUtils;
import com.itextpdf.xmp.options.PropertyOptions;

public class DublinCoreProperties {

    /* renamed from: a  reason: collision with root package name */
    public static final String f27395a = "contributor";

    /* renamed from: b  reason: collision with root package name */
    public static final String f27396b = "coverage";

    /* renamed from: c  reason: collision with root package name */
    public static final String f27397c = "creator";

    /* renamed from: d  reason: collision with root package name */
    public static final String f27398d = "date";

    /* renamed from: e  reason: collision with root package name */
    public static final String f27399e = "description";

    /* renamed from: f  reason: collision with root package name */
    public static final String f27400f = "format";

    /* renamed from: g  reason: collision with root package name */
    public static final String f27401g = "identifier";

    /* renamed from: h  reason: collision with root package name */
    public static final String f27402h = "language";

    /* renamed from: i  reason: collision with root package name */
    public static final String f27403i = "publisher";

    /* renamed from: j  reason: collision with root package name */
    public static final String f27404j = "relation";

    /* renamed from: k  reason: collision with root package name */
    public static final String f27405k = "rights";

    /* renamed from: l  reason: collision with root package name */
    public static final String f27406l = "source";

    /* renamed from: m  reason: collision with root package name */
    public static final String f27407m = "subject";

    /* renamed from: n  reason: collision with root package name */
    public static final String f27408n = "title";
    public static final String o = "type";

    public static void a(XMPMeta xMPMeta, String str) throws XMPException {
        xMPMeta.U0("http://purl.org/dc/elements/1.1/", f27397c, new PropertyOptions(1024), str, (PropertyOptions) null);
    }

    public static void b(XMPMeta xMPMeta, String str) throws XMPException {
        xMPMeta.U0("http://purl.org/dc/elements/1.1/", f27399e, new PropertyOptions(2048), str, (PropertyOptions) null);
    }

    public static void c(XMPMeta xMPMeta, String str) throws XMPException {
        xMPMeta.U0("http://purl.org/dc/elements/1.1/", f27403i, new PropertyOptions(1024), str, (PropertyOptions) null);
    }

    public static void d(XMPMeta xMPMeta, String str) throws XMPException {
        xMPMeta.U0("http://purl.org/dc/elements/1.1/", "subject", new PropertyOptions(512), str, (PropertyOptions) null);
    }

    public static void e(XMPMeta xMPMeta, String str) throws XMPException {
        xMPMeta.U0("http://purl.org/dc/elements/1.1/", "title", new PropertyOptions(2048), str, (PropertyOptions) null);
    }

    public static void f(XMPMeta xMPMeta, String[] strArr) throws XMPException {
        XMPUtils.p(xMPMeta, "http://purl.org/dc/elements/1.1/", f27397c, true, true);
        for (String U0 : strArr) {
            xMPMeta.U0("http://purl.org/dc/elements/1.1/", f27397c, new PropertyOptions(1024), U0, (PropertyOptions) null);
        }
    }

    public static void g(XMPMeta xMPMeta, String str, String str2, String str3) throws XMPException {
        xMPMeta.d0("http://purl.org/dc/elements/1.1/", f27399e, str2, str3, str);
    }

    public static void h(XMPMeta xMPMeta, String[] strArr) throws XMPException {
        XMPUtils.p(xMPMeta, "http://purl.org/dc/elements/1.1/", f27403i, true, true);
        for (String U0 : strArr) {
            xMPMeta.U0("http://purl.org/dc/elements/1.1/", f27403i, new PropertyOptions(1024), U0, (PropertyOptions) null);
        }
    }

    public static void i(XMPMeta xMPMeta, String[] strArr) throws XMPException {
        XMPUtils.p(xMPMeta, "http://purl.org/dc/elements/1.1/", "subject", true, true);
        for (String U0 : strArr) {
            xMPMeta.U0("http://purl.org/dc/elements/1.1/", "subject", new PropertyOptions(512), U0, (PropertyOptions) null);
        }
    }

    public static void j(XMPMeta xMPMeta, String str, String str2, String str3) throws XMPException {
        xMPMeta.d0("http://purl.org/dc/elements/1.1/", "title", str2, str3, str);
    }
}
