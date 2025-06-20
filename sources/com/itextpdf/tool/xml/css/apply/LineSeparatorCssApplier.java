package com.itextpdf.tool.xml.css.apply;

import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.html.CssApplier;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;

public class LineSeparatorCssApplier implements CssApplier<LineSeparator> {
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00d1  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.pdf.draw.LineSeparator a(com.itextpdf.text.pdf.draw.LineSeparator r3, com.itextpdf.tool.xml.Tag r4, com.itextpdf.tool.xml.css.apply.MarginMemory r5, com.itextpdf.tool.xml.css.apply.PageSizeContainable r6, com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext r7) {
        /*
            r2 = this;
            java.util.Map r5 = r4.g()
            java.util.Map r7 = r4.d()
            java.lang.String r0 = "size"
            java.lang.Object r7 = r7.get(r0)
            if (r7 == 0) goto L_0x0023
            com.itextpdf.tool.xml.css.CssUtils r7 = com.itextpdf.tool.xml.css.CssUtils.g()
            java.util.Map r1 = r4.d()
            java.lang.Object r0 = r1.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            float r7 = r7.p(r0)
            goto L_0x003c
        L_0x0023:
            java.lang.String r7 = "height"
            java.lang.Object r0 = r5.get(r7)
            if (r0 == 0) goto L_0x003a
            com.itextpdf.tool.xml.css.CssUtils r0 = com.itextpdf.tool.xml.css.CssUtils.g()
            java.lang.Object r7 = r5.get(r7)
            java.lang.String r7 = (java.lang.String) r7
            float r7 = r0.p(r7)
            goto L_0x003c
        L_0x003a:
            r7 = 1065353216(0x3f800000, float:1.0)
        L_0x003c:
            r3.o(r7)
            com.itextpdf.text.BaseColor r7 = com.itextpdf.text.BaseColor.f25677f
            java.util.Map r0 = r4.d()
            java.lang.String r1 = "color"
            java.lang.Object r0 = r0.get(r1)
            if (r0 == 0) goto L_0x005c
            java.util.Map r7 = r4.d()
            java.lang.Object r7 = r7.get(r1)
        L_0x0055:
            java.lang.String r7 = (java.lang.String) r7
            com.itextpdf.text.BaseColor r7 = com.itextpdf.text.html.HtmlUtilities.b(r7)
            goto L_0x0074
        L_0x005c:
            java.lang.Object r0 = r5.get(r1)
            if (r0 == 0) goto L_0x0067
            java.lang.Object r7 = r5.get(r1)
            goto L_0x0055
        L_0x0067:
            java.lang.String r0 = "background-color"
            java.lang.Object r1 = r5.get(r0)
            if (r1 == 0) goto L_0x0074
            java.lang.Object r7 = r5.get(r0)
            goto L_0x0055
        L_0x0074:
            r3.n(r7)
            java.lang.String r7 = "width"
            java.lang.Object r5 = r5.get(r7)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 != 0) goto L_0x008b
            java.util.Map r5 = r4.d()
            java.lang.Object r5 = r5.get(r7)
            java.lang.String r5 = (java.lang.String) r5
        L_0x008b:
            r7 = 1120403456(0x42c80000, float:100.0)
            if (r5 == 0) goto L_0x00b5
            java.lang.String r0 = "%"
            boolean r1 = r5.contains(r0)
            if (r1 == 0) goto L_0x00a2
            java.lang.String r6 = ""
            java.lang.String r5 = r5.replace(r0, r6)
            float r7 = java.lang.Float.parseFloat(r5)
            goto L_0x00b5
        L_0x00a2:
            com.itextpdf.tool.xml.css.CssUtils r0 = com.itextpdf.tool.xml.css.CssUtils.g()
            float r5 = r0.p(r5)
            com.itextpdf.text.Rectangle r6 = r6.getPageSize()
            float r6 = r6.a0()
            float r5 = r5 / r6
            float r7 = r7 * r5
        L_0x00b5:
            r3.p(r7)
            java.util.Map r4 = r4.d()
            java.lang.String r5 = "align"
            java.lang.Object r4 = r4.get(r5)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = "right"
            boolean r5 = r5.equals(r4)
            if (r5 == 0) goto L_0x00d1
            r4 = 2
        L_0x00cd:
            r3.m(r4)
            goto L_0x00e5
        L_0x00d1:
            java.lang.String r5 = "left"
            boolean r5 = r5.equals(r4)
            if (r5 == 0) goto L_0x00db
            r4 = 0
            goto L_0x00cd
        L_0x00db:
            java.lang.String r5 = "center"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x00e5
            r4 = 1
            goto L_0x00cd
        L_0x00e5:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.tool.xml.css.apply.LineSeparatorCssApplier.a(com.itextpdf.text.pdf.draw.LineSeparator, com.itextpdf.tool.xml.Tag, com.itextpdf.tool.xml.css.apply.MarginMemory, com.itextpdf.tool.xml.css.apply.PageSizeContainable, com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext):com.itextpdf.text.pdf.draw.LineSeparator");
    }

    public LineSeparator c(LineSeparator lineSeparator, Tag tag, PageSizeContainable pageSizeContainable) {
        return a(lineSeparator, tag, (MarginMemory) null, pageSizeContainable, (HtmlPipelineContext) null);
    }
}
