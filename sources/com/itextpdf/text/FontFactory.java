package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;
import java.util.Set;

public final class FontFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final String f25688a = "Courier";

    /* renamed from: b  reason: collision with root package name */
    public static final String f25689b = "Courier-Bold";

    /* renamed from: c  reason: collision with root package name */
    public static final String f25690c = "Courier-Oblique";

    /* renamed from: d  reason: collision with root package name */
    public static final String f25691d = "Courier-BoldOblique";

    /* renamed from: e  reason: collision with root package name */
    public static final String f25692e = "Helvetica";

    /* renamed from: f  reason: collision with root package name */
    public static final String f25693f = "Helvetica-Bold";

    /* renamed from: g  reason: collision with root package name */
    public static final String f25694g = "Helvetica-Oblique";

    /* renamed from: h  reason: collision with root package name */
    public static final String f25695h = "Helvetica-BoldOblique";

    /* renamed from: i  reason: collision with root package name */
    public static final String f25696i = "Symbol";

    /* renamed from: j  reason: collision with root package name */
    public static final String f25697j = "Times";

    /* renamed from: k  reason: collision with root package name */
    public static final String f25698k = "Times-Roman";

    /* renamed from: l  reason: collision with root package name */
    public static final String f25699l = "Times-Bold";

    /* renamed from: m  reason: collision with root package name */
    public static final String f25700m = "Times-Italic";

    /* renamed from: n  reason: collision with root package name */
    public static final String f25701n = "Times-BoldItalic";
    public static final String o = "ZapfDingbats";
    private static FontFactoryImp p = new FontFactoryImp();
    public static String q = "Cp1252";
    public static boolean r = false;

    private FontFactory() {
    }

    public static boolean a(String str) {
        return p.b(str);
    }

    public static Font b(String str) {
        return n(str, q, r, -1.0f, -1, (BaseColor) null);
    }

    public static Font c(String str, float f2) {
        return n(str, q, r, f2, -1, (BaseColor) null);
    }

    public static Font d(String str, float f2, int i2) {
        return n(str, q, r, f2, i2, (BaseColor) null);
    }

    public static Font e(String str, float f2, int i2, BaseColor baseColor) {
        return n(str, q, r, f2, i2, baseColor);
    }

    public static Font f(String str, float f2, BaseColor baseColor) {
        return n(str, q, r, f2, -1, baseColor);
    }

    public static Font g(String str, String str2) {
        return n(str, str2, r, -1.0f, -1, (BaseColor) null);
    }

    public static Font h(String str, String str2, float f2) {
        return n(str, str2, r, f2, -1, (BaseColor) null);
    }

    public static Font i(String str, String str2, float f2, int i2) {
        return n(str, str2, r, f2, i2, (BaseColor) null);
    }

    public static Font j(String str, String str2, float f2, int i2, BaseColor baseColor) {
        return n(str, str2, r, f2, i2, baseColor);
    }

    public static Font k(String str, String str2, boolean z) {
        return n(str, str2, z, -1.0f, -1, (BaseColor) null);
    }

    public static Font l(String str, String str2, boolean z, float f2) {
        return n(str, str2, z, f2, -1, (BaseColor) null);
    }

    public static Font m(String str, String str2, boolean z, float f2, int i2) {
        return n(str, str2, z, f2, i2, (BaseColor) null);
    }

    public static Font n(String str, String str2, boolean z, float f2, int i2, BaseColor baseColor) {
        return p.a(str, str2, z, f2, i2, baseColor);
    }

    public static Font o(String str, String str2, boolean z, float f2, int i2, BaseColor baseColor, boolean z2) {
        return p.p(str, str2, z, f2, i2, baseColor, z2);
    }

    public static FontFactoryImp p() {
        return p;
    }

    public static Set<String> q() {
        return p.q();
    }

    public static Set<String> r() {
        return p.r();
    }

    public static boolean s(String str) {
        return p.b(str);
    }

    public static void t(String str) {
        u(str, (String) null);
    }

    public static void u(String str, String str2) {
        p.t(str, str2);
    }

    public static int v() {
        return p.u();
    }

    public static int w(String str) {
        return p.v(str);
    }

    public static int x(String str, boolean z) {
        return p.w(str, z);
    }

    public static void y(String str, String str2, String str3) {
        p.x(str, str2, str3);
    }

    public static void z(FontFactoryImp fontFactoryImp) {
        if (fontFactoryImp != null) {
            p = fontFactoryImp;
            return;
        }
        throw new NullPointerException(MessageLocalization.b("fontfactoryimp.cannot.be.null", new Object[0]));
    }
}
