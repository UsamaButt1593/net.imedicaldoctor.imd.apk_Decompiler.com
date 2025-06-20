package com.itextpdf.tool.xml.exceptions;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleMessages {
    public static final String A = "html.tag.style.notparsed";
    private static LocaleMessages B = new LocaleMessages();

    /* renamed from: b  reason: collision with root package name */
    public static final String f27571b = "unsupported.charset";

    /* renamed from: c  reason: collision with root package name */
    public static final String f27572c = "tag.invalidnesting";

    /* renamed from: d  reason: collision with root package name */
    public static final String f27573d = "customcontext.404";

    /* renamed from: e  reason: collision with root package name */
    public static final String f27574e = "customcontext.404.continue";

    /* renamed from: f  reason: collision with root package name */
    public static final String f27575f = "unsupported.clone";

    /* renamed from: g  reason: collision with root package name */
    public static final String f27576g = "tag.noprocessor";

    /* renamed from: h  reason: collision with root package name */
    public static final String f27577h = "tag.nosibling";

    /* renamed from: i  reason: collision with root package name */
    public static final String f27578i = "pipeline.autodoc.missingdep";

    /* renamed from: j  reason: collision with root package name */
    public static final String f27579j = "pipeline.html.missingstack";

    /* renamed from: k  reason: collision with root package name */
    public static final String f27580k = "pipeline.owncontextmissing";

    /* renamed from: l  reason: collision with root package name */
    public static final String f27581l = "pipeline.pdfwriter.elemnotadded";

    /* renamed from: m  reason: collision with root package name */
    public static final String f27582m = "pipeline.pdfwriter.elemnotaddedexc";

    /* renamed from: n  reason: collision with root package name */
    public static final String f27583n = "exc.img.notconverted";
    public static final String o = "html.tag.img.try";
    public static final String p = "html.tag.img.failedretrieve";
    public static final String q = "html.tag.h.create";
    public static final String r = "html.tag.h.disabled";
    public static final String s = "html.tag.a.local";
    public static final String t = "html.tag.a.external";
    public static final String u = "html.tag.a.setlocal";
    public static final String v = "html.tag.a.spacehack";
    public static final String w = "html.tag.table.colspan";
    public static final String x = "html.tag.link.404";
    public static final String y = "html.tag.meta.cc";
    public static final String z = "html.tag.meta.404";

    /* renamed from: a  reason: collision with root package name */
    private final ResourceBundle f27584a;

    public LocaleMessages() {
        this.f27584a = ResourceBundle.getBundle("errors/errors", Locale.getDefault());
    }

    public static LocaleMessages a() {
        return B;
    }

    public String b(String str) {
        return this.f27584a.getString(str);
    }

    public LocaleMessages(Locale locale) {
        this.f27584a = ResourceBundle.getBundle("errors/errors", locale);
    }
}
