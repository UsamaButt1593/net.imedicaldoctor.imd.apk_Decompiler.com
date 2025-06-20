package com.itextpdf.tool.xml.css;

import com.itextpdf.tool.xml.Tag;

public class HeightCalculator {

    /* renamed from: a  reason: collision with root package name */
    private final CssUtils f27516a = CssUtils.g();

    public Float a(Tag tag, float f2) {
        float p;
        String str = tag.g().get("height");
        if (str == null) {
            str = tag.d().get("height");
        }
        Float f3 = null;
        if (str == null) {
            return null;
        }
        if (this.f27516a.j(str) || this.f27516a.i(str)) {
            p = this.f27516a.p(str);
        } else if (!this.f27516a.k(str)) {
            return null;
        } else {
            while (f3 == null && tag.r() != null) {
                tag = tag.r();
                f3 = a(tag, f2);
            }
            CssUtils cssUtils = this.f27516a;
            if (f3 != null) {
                f2 = f3.floatValue();
            }
            p = cssUtils.r(str, f2);
        }
        return Float.valueOf(p);
    }
}
