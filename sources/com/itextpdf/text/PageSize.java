package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;

public class PageSize {
    public static final Rectangle A = new RectangleReadOnly(124.0f, 175.0f);
    public static final Rectangle B = new RectangleReadOnly(87.0f, 124.0f);
    public static final Rectangle C = new RectangleReadOnly(2592.0f, 3456.0f);
    public static final Rectangle D = new RectangleReadOnly(1728.0f, 2592.0f);
    public static final Rectangle E = new RectangleReadOnly(1296.0f, 1728.0f);
    public static final Rectangle F = new RectangleReadOnly(864.0f, 1296.0f);
    public static final Rectangle G = new RectangleReadOnly(648.0f, 864.0f);
    public static final Rectangle H = new RectangleReadOnly(612.0f, 936.0f);
    public static final Rectangle I = new RectangleReadOnly(648.0f, 936.0f);
    public static final Rectangle J = new RectangleReadOnly(396.0f, 612.0f);
    public static final Rectangle K = new RectangleReadOnly(792.0f, 1224.0f);
    public static final Rectangle L = new RectangleReadOnly(242.65f, 153.0f);
    public static final Rectangle M = new RectangleReadOnly(297.0f, 210.0f);
    public static final Rectangle N = new RectangleReadOnly(354.0f, 249.0f);
    public static final Rectangle O = new RectangleReadOnly(1224.0f, 792.0f);
    public static final Rectangle P = new RectangleReadOnly(535.0f, 697.0f);
    public static final Rectangle Q = new RectangleReadOnly(569.0f, 731.0f);
    public static final Rectangle R = new RectangleReadOnly(620.0f, 782.0f);
    public static final Rectangle S = new RectangleReadOnly(671.0f, 884.0f);
    public static final Rectangle T = new RectangleReadOnly(348.0f, 527.0f);
    public static final Rectangle U = new RectangleReadOnly(365.0f, 561.0f);
    public static final Rectangle V = new RectangleReadOnly(391.0f, 612.0f);
    public static final Rectangle W = new RectangleReadOnly(442.0f, 663.0f);
    public static final Rectangle X = new RectangleReadOnly(314.0f, 504.0f);
    public static final Rectangle Y = new RectangleReadOnly(314.0f, 513.0f);
    public static final Rectangle Z = new RectangleReadOnly(365.0f, 561.0f);

    /* renamed from: a  reason: collision with root package name */
    public static final Rectangle f25708a = new RectangleReadOnly(612.0f, 792.0f);
    public static final Rectangle a0 = new RectangleReadOnly(612.0f, 792.0f, 90);

    /* renamed from: b  reason: collision with root package name */
    public static final Rectangle f25709b = new RectangleReadOnly(540.0f, 720.0f);
    public static final Rectangle b0 = new RectangleReadOnly(612.0f, 1008.0f, 90);

    /* renamed from: c  reason: collision with root package name */
    public static final Rectangle f25710c = new RectangleReadOnly(612.0f, 1008.0f);
    public static final Rectangle c0 = new RectangleReadOnly(595.0f, 842.0f, 90);

    /* renamed from: d  reason: collision with root package name */
    public static final Rectangle f25711d = new RectangleReadOnly(792.0f, 1224.0f);

    /* renamed from: e  reason: collision with root package name */
    public static final Rectangle f25712e = new RectangleReadOnly(522.0f, 756.0f);

    /* renamed from: f  reason: collision with root package name */
    public static final Rectangle f25713f = new RectangleReadOnly(283.0f, 416.0f);

    /* renamed from: g  reason: collision with root package name */
    public static final Rectangle f25714g = new RectangleReadOnly(2384.0f, 3370.0f);

    /* renamed from: h  reason: collision with root package name */
    public static final Rectangle f25715h = new RectangleReadOnly(1684.0f, 2384.0f);

    /* renamed from: i  reason: collision with root package name */
    public static final Rectangle f25716i = new RectangleReadOnly(1191.0f, 1684.0f);

    /* renamed from: j  reason: collision with root package name */
    public static final Rectangle f25717j = new RectangleReadOnly(842.0f, 1191.0f);

    /* renamed from: k  reason: collision with root package name */
    public static final Rectangle f25718k = new RectangleReadOnly(595.0f, 842.0f);

    /* renamed from: l  reason: collision with root package name */
    public static final Rectangle f25719l = new RectangleReadOnly(420.0f, 595.0f);

    /* renamed from: m  reason: collision with root package name */
    public static final Rectangle f25720m = new RectangleReadOnly(297.0f, 420.0f);

    /* renamed from: n  reason: collision with root package name */
    public static final Rectangle f25721n = new RectangleReadOnly(210.0f, 297.0f);
    public static final Rectangle o = new RectangleReadOnly(148.0f, 210.0f);
    public static final Rectangle p = new RectangleReadOnly(105.0f, 148.0f);
    public static final Rectangle q = new RectangleReadOnly(73.0f, 105.0f);
    public static final Rectangle r = new RectangleReadOnly(2834.0f, 4008.0f);
    public static final Rectangle s = new RectangleReadOnly(2004.0f, 2834.0f);
    public static final Rectangle t = new RectangleReadOnly(1417.0f, 2004.0f);
    public static final Rectangle u = new RectangleReadOnly(1000.0f, 1417.0f);
    public static final Rectangle v = new RectangleReadOnly(708.0f, 1000.0f);
    public static final Rectangle w = new RectangleReadOnly(498.0f, 708.0f);
    public static final Rectangle x = new RectangleReadOnly(354.0f, 498.0f);
    public static final Rectangle y = new RectangleReadOnly(249.0f, 354.0f);
    public static final Rectangle z = new RectangleReadOnly(175.0f, 249.0f);

    public static Rectangle a(String str) {
        String upperCase = str.trim().toUpperCase();
        int indexOf = upperCase.indexOf(32);
        if (indexOf == -1) {
            try {
                return (Rectangle) PageSize.class.getDeclaredField(upperCase.toUpperCase()).get((Object) null);
            } catch (Exception unused) {
                throw new RuntimeException(MessageLocalization.b("can.t.find.page.size.1", upperCase));
            }
        } else {
            try {
                return new Rectangle(Float.parseFloat(upperCase.substring(0, indexOf)), Float.parseFloat(upperCase.substring(indexOf + 1)));
            } catch (Exception e2) {
                throw new RuntimeException(MessageLocalization.b("1.is.not.a.valid.page.size.format.2", upperCase, e2.getMessage()));
            }
        }
    }
}
