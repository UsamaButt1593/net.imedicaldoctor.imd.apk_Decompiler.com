package com.itextpdf.tool.xml.css;

import com.itextpdf.tool.xml.Tag;
import java.util.List;

public class WidthCalculator {

    /* renamed from: a  reason: collision with root package name */
    private final CssUtils f27522a = CssUtils.g();

    public float a(Tag tag, List<String> list, float f2) {
        return b(tag, list, f2, -1.0f);
    }

    public float b(Tag tag, List<String> list, float f2, float f3) {
        int i2;
        String str = tag.g().get("width");
        if (str == null) {
            str = tag.d().get("width");
        }
        if (str != null) {
            if (this.f27522a.j(str) || this.f27522a.i(str)) {
                return this.f27522a.p(str);
            }
            if (this.f27522a.k(str)) {
                float f4 = 0.0f;
                while (true) {
                    i2 = (f4 > 0.0f ? 1 : (f4 == 0.0f ? 0 : -1));
                    if (i2 != 0 || tag.r() == null) {
                        CssUtils cssUtils = this.f27522a;
                    } else {
                        tag = tag.r();
                        f4 = b(tag, list, f2, f3);
                    }
                }
                CssUtils cssUtils2 = this.f27522a;
                return i2 == 0 ? cssUtils2.r(str, f2) : cssUtils2.r(str, f4);
            }
        } else if (list.contains(tag.o())) {
            return Float.compare(f3, -1.0f) == 0 ? f2 : f3;
        }
        return 0.0f;
    }
}
