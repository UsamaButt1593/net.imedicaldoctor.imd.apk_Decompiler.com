package com.itextpdf.tool.xml.css.apply;

import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.css.FontSizeTranslator;
import java.util.List;

public final class MaxLeadingAndSize {

    /* renamed from: a  reason: collision with root package name */
    private final CssUtils f27531a = CssUtils.g();

    /* renamed from: b  reason: collision with root package name */
    private final FontSizeTranslator f27532b = FontSizeTranslator.b();

    /* renamed from: c  reason: collision with root package name */
    private float f27533c;

    /* renamed from: d  reason: collision with root package name */
    private float f27534d;

    private float e(List<Tag> list) {
        float f2 = 0.0f;
        for (Tag next : list) {
            Float a2 = a(next);
            if (a2.floatValue() > f2) {
                f2 = a2.floatValue();
            }
            e(next.k());
        }
        return f2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004b, code lost:
        if (r0 == 0.0f) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Float a(com.itextpdf.tool.xml.Tag r5) {
        /*
            r4 = this;
            java.util.Map r0 = r5.g()
            com.itextpdf.tool.xml.css.FontSizeTranslator r1 = r4.f27532b
            float r5 = r1.a(r5)
            java.lang.String r1 = "line-height"
            java.lang.Object r2 = r0.get(r1)
            r3 = 1069547520(0x3fc00000, float:1.5)
            if (r2 == 0) goto L_0x004d
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            com.itextpdf.tool.xml.css.CssUtils r1 = r4.f27531a
            boolean r1 = r1.j(r0)
            r2 = 0
            if (r1 == 0) goto L_0x002a
            float r0 = java.lang.Float.parseFloat(r0)
            float r0 = r0 * r5
            goto L_0x0049
        L_0x002a:
            com.itextpdf.tool.xml.css.CssUtils r1 = r4.f27531a
            boolean r1 = r1.k(r0)
            if (r1 == 0) goto L_0x0039
            com.itextpdf.tool.xml.css.CssUtils r1 = r4.f27531a
            float r0 = r1.r(r0, r5)
            goto L_0x0049
        L_0x0039:
            com.itextpdf.tool.xml.css.CssUtils r1 = r4.f27531a
            boolean r1 = r1.i(r0)
            if (r1 == 0) goto L_0x0048
            com.itextpdf.tool.xml.css.CssUtils r1 = r4.f27531a
            float r0 = r1.p(r0)
            goto L_0x0049
        L_0x0048:
            r0 = 0
        L_0x0049:
            int r1 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x004f
        L_0x004d:
            float r0 = r5 * r3
        L_0x004f:
            java.lang.Float r5 = java.lang.Float.valueOf(r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.tool.xml.css.apply.MaxLeadingAndSize.a(com.itextpdf.tool.xml.Tag):java.lang.Float");
    }

    public float b() {
        return this.f27534d;
    }

    public float c(List<Tag> list) {
        float f2 = 12.0f;
        for (Tag a2 : list) {
            float a3 = this.f27532b.a(a2);
            if (a3 > f2) {
                f2 = a3;
            }
        }
        return f2;
    }

    public float d() {
        return this.f27533c;
    }

    public void f(Tag tag) {
        this.f27533c = a(tag).floatValue();
    }

    public void g(Tag tag) {
        float a2 = this.f27532b.a(tag);
        float c2 = c(tag.k());
        if (a2 <= c2) {
            a2 = c2;
        }
        this.f27534d = a2;
        float floatValue = a(tag).floatValue();
        float e2 = e(tag.k());
        if (floatValue <= e2) {
            floatValue = e2;
        }
        this.f27533c = floatValue;
    }
}
