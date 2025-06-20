package com.itextpdf.tool.xml.css;

import com.itextpdf.tool.xml.Tag;
import java.util.List;

public class CssSelector {

    /* renamed from: a  reason: collision with root package name */
    private List<CssSelectorItem> f27494a;

    public CssSelector(List<CssSelectorItem> list) {
        this.f27494a = list;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x009e, code lost:
        r1 = r5.r().k().indexOf(r5) - 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c(com.itextpdf.tool.xml.Tag r5, int r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.util.Stack r1 = new java.util.Stack
            r1.<init>()
        L_0x0009:
            if (r6 < 0) goto L_0x0026
            java.util.List<com.itextpdf.tool.xml.css.CssSelectorItem> r2 = r4.f27494a
            java.lang.Object r2 = r2.get(r6)
            com.itextpdf.tool.xml.css.CssSelectorItem r2 = (com.itextpdf.tool.xml.css.CssSelectorItem) r2
            char r2 = r2.c()
            if (r2 == 0) goto L_0x001a
            goto L_0x0026
        L_0x001a:
            java.util.List<com.itextpdf.tool.xml.css.CssSelectorItem> r2 = r4.f27494a
            java.lang.Object r2 = r2.get(r6)
            r1.push(r2)
            int r6 = r6 + -1
            goto L_0x0009
        L_0x0026:
            boolean r2 = r1.empty()
            if (r2 != 0) goto L_0x0039
            java.lang.Object r2 = r1.pop()
            com.itextpdf.tool.xml.css.CssSelectorItem r2 = (com.itextpdf.tool.xml.css.CssSelectorItem) r2
            boolean r2 = r2.a(r5)
            if (r2 != 0) goto L_0x0026
            return r0
        L_0x0039:
            r1 = -1
            r2 = 1
            if (r6 != r1) goto L_0x003e
            return r2
        L_0x003e:
            java.util.List<com.itextpdf.tool.xml.css.CssSelectorItem> r3 = r4.f27494a
            java.lang.Object r3 = r3.get(r6)
            com.itextpdf.tool.xml.css.CssSelectorItem r3 = (com.itextpdf.tool.xml.css.CssSelectorItem) r3
            char r3 = r3.c()
            if (r3 != 0) goto L_0x004d
            return r0
        L_0x004d:
            int r6 = r6 + r1
            r1 = 32
            if (r3 == r1) goto L_0x00c3
            r1 = 43
            if (r3 == r1) goto L_0x0097
            r1 = 62
            if (r3 == r1) goto L_0x008e
            r1 = 126(0x7e, float:1.77E-43)
            if (r3 == r1) goto L_0x005f
            return r0
        L_0x005f:
            boolean r1 = r5.C()
            if (r1 != 0) goto L_0x0066
            return r0
        L_0x0066:
            com.itextpdf.tool.xml.Tag r1 = r5.r()
            java.util.List r1 = r1.k()
            int r1 = r1.indexOf(r5)
            int r1 = r1 - r2
        L_0x0073:
            if (r1 < 0) goto L_0x008d
            com.itextpdf.tool.xml.Tag r3 = r5.r()
            java.util.List r3 = r3.k()
            java.lang.Object r3 = r3.get(r1)
            com.itextpdf.tool.xml.Tag r3 = (com.itextpdf.tool.xml.Tag) r3
            boolean r3 = r4.c(r3, r6)
            if (r3 == 0) goto L_0x008a
            return r2
        L_0x008a:
            int r1 = r1 + -1
            goto L_0x0073
        L_0x008d:
            return r0
        L_0x008e:
            com.itextpdf.tool.xml.Tag r5 = r5.r()
            boolean r5 = r4.c(r5, r6)
            return r5
        L_0x0097:
            boolean r1 = r5.C()
            if (r1 != 0) goto L_0x009e
            return r0
        L_0x009e:
            com.itextpdf.tool.xml.Tag r1 = r5.r()
            java.util.List r1 = r1.k()
            int r1 = r1.indexOf(r5)
            int r1 = r1 - r2
            if (r1 < 0) goto L_0x00c2
            com.itextpdf.tool.xml.Tag r5 = r5.r()
            java.util.List r5 = r5.k()
            java.lang.Object r5 = r5.get(r1)
            com.itextpdf.tool.xml.Tag r5 = (com.itextpdf.tool.xml.Tag) r5
            boolean r5 = r4.c(r5, r6)
            if (r5 == 0) goto L_0x00c2
            r0 = 1
        L_0x00c2:
            return r0
        L_0x00c3:
            if (r5 == 0) goto L_0x00d5
            com.itextpdf.tool.xml.Tag r1 = r5.r()
            boolean r1 = r4.c(r1, r6)
            if (r1 == 0) goto L_0x00d0
            return r2
        L_0x00d0:
            com.itextpdf.tool.xml.Tag r5 = r5.r()
            goto L_0x00c3
        L_0x00d5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.tool.xml.css.CssSelector.c(com.itextpdf.tool.xml.Tag, int):boolean");
    }

    public int a() {
        int i2 = 0;
        for (CssSelectorItem b2 : this.f27494a) {
            i2 += b2.b();
        }
        return i2;
    }

    public boolean b(Tag tag) {
        return c(tag, this.f27494a.size() - 1);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (CssSelectorItem obj : this.f27494a) {
            stringBuffer.append(obj.toString());
        }
        return stringBuffer.toString();
    }
}
