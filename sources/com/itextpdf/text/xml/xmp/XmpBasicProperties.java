package com.itextpdf.text.xml.xmp;

import com.itextpdf.xmp.XMPException;
import com.itextpdf.xmp.XMPMeta;
import com.itextpdf.xmp.XMPUtils;
import com.itextpdf.xmp.options.PropertyOptions;

public class XmpBasicProperties {

    /* renamed from: a  reason: collision with root package name */
    public static final String f27413a = "Advisory";

    /* renamed from: b  reason: collision with root package name */
    public static final String f27414b = "BaseURL";

    /* renamed from: c  reason: collision with root package name */
    public static final String f27415c = "CreateDate";

    /* renamed from: d  reason: collision with root package name */
    public static final String f27416d = "CreatorTool";

    /* renamed from: e  reason: collision with root package name */
    public static final String f27417e = "Identifier";

    /* renamed from: f  reason: collision with root package name */
    public static final String f27418f = "MetadataDate";

    /* renamed from: g  reason: collision with root package name */
    public static final String f27419g = "ModifyDate";

    /* renamed from: h  reason: collision with root package name */
    public static final String f27420h = "Nickname";

    /* renamed from: i  reason: collision with root package name */
    public static final String f27421i = "Thumbnails";

    public static void a(XMPMeta xMPMeta, String str) throws XMPException {
        xMPMeta.R2("http://ns.adobe.com/xap/1.0/", f27415c, str);
    }

    public static void b(XMPMeta xMPMeta, String str) throws XMPException {
        xMPMeta.R2("http://ns.adobe.com/xap/1.0/", f27416d, str);
    }

    public static void c(XMPMeta xMPMeta, String[] strArr) throws XMPException {
        XMPUtils.p(xMPMeta, "http://purl.org/dc/elements/1.1/", f27417e, true, true);
        for (String U0 : strArr) {
            xMPMeta.U0("http://purl.org/dc/elements/1.1/", f27417e, new PropertyOptions(512), U0, (PropertyOptions) null);
        }
    }

    public static void d(XMPMeta xMPMeta, String str) throws XMPException {
        xMPMeta.R2("http://ns.adobe.com/xap/1.0/", f27418f, str);
    }

    public static void e(XMPMeta xMPMeta, String str) throws XMPException {
        xMPMeta.R2("http://ns.adobe.com/xap/1.0/", f27419g, str);
    }

    public static void f(XMPMeta xMPMeta, String str) throws XMPException {
        xMPMeta.R2("http://ns.adobe.com/xap/1.0/", f27420h, str);
    }
}
