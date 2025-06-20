package com.itextpdf.tool.xml.css.apply;

import com.itextpdf.text.Image;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.html.CssApplier;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;

public class ImageCssApplier implements CssApplier<Image> {
    public Image b(Image image, Tag tag) {
        return a(image, tag, (MarginMemory) null, (PageSizeContainable) null, (HtmlPipelineContext) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0118  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.Image a(com.itextpdf.text.Image r4, com.itextpdf.tool.xml.Tag r5, com.itextpdf.tool.xml.css.apply.MarginMemory r6, com.itextpdf.tool.xml.css.apply.PageSizeContainable r7, com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext r8) {
        /*
            r3 = this;
            java.util.Map r6 = r5.g()
            java.lang.String r7 = "width"
            java.lang.Object r8 = r6.get(r7)
            java.lang.String r8 = (java.lang.String) r8
            if (r8 != 0) goto L_0x0019
            java.util.Map r8 = r5.d()
            java.lang.Object r7 = r8.get(r7)
            r8 = r7
            java.lang.String r8 = (java.lang.String) r8
        L_0x0019:
            java.lang.String r7 = "height"
            java.lang.Object r0 = r6.get(r7)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x002e
            java.util.Map r5 = r5.d()
            java.lang.Object r5 = r5.get(r7)
            r0 = r5
            java.lang.String r0 = (java.lang.String) r0
        L_0x002e:
            r5 = 0
            if (r8 != 0) goto L_0x0036
            r7 = 1
            r4.o2(r7)
            goto L_0x0039
        L_0x0036:
            r4.o2(r5)
        L_0x0039:
            r4.n2(r5)
            com.itextpdf.tool.xml.css.CssUtils r5 = com.itextpdf.tool.xml.css.CssUtils.g()
            float r7 = r5.p(r8)
            float r8 = r5.p(r0)
            r0 = 0
            int r1 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r1 <= 0) goto L_0x0055
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0055
        L_0x0051:
            r4.N1(r7, r8)
            goto L_0x0073
        L_0x0055:
            if (r1 <= 0) goto L_0x0063
            float r8 = r4.N()
            float r8 = r8 * r7
            float r1 = r4.a0()
            float r8 = r8 / r1
            goto L_0x0051
        L_0x0063:
            int r7 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r7 <= 0) goto L_0x0073
            float r7 = r4.a0()
            float r7 = r7 * r8
            float r1 = r4.N()
            float r7 = r7 / r1
            goto L_0x0051
        L_0x0073:
            java.lang.String r7 = "border-top-color"
            java.lang.Object r7 = r6.get(r7)
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x0084
            com.itextpdf.text.BaseColor r7 = com.itextpdf.text.html.HtmlUtilities.b(r7)
            r4.o0(r7)
        L_0x0084:
            java.lang.String r7 = "border-top-width"
            java.lang.Object r7 = r6.get(r7)
            java.lang.String r7 = (java.lang.String) r7
            r8 = 1065353216(0x3f800000, float:1.0)
            if (r7 == 0) goto L_0x0097
            float r7 = r5.s(r7, r8)
            r4.t0(r7)
        L_0x0097:
            java.lang.String r7 = "border-right-color"
            java.lang.Object r7 = r6.get(r7)
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x00a8
            com.itextpdf.text.BaseColor r7 = com.itextpdf.text.html.HtmlUtilities.b(r7)
            r4.n0(r7)
        L_0x00a8:
            java.lang.String r7 = "border-right-width"
            java.lang.Object r7 = r6.get(r7)
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x00b9
            float r7 = r5.s(r7, r8)
            r4.s0(r7)
        L_0x00b9:
            java.lang.String r7 = "border-bottom-color"
            java.lang.Object r7 = r6.get(r7)
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x00ca
            com.itextpdf.text.BaseColor r7 = com.itextpdf.text.html.HtmlUtilities.b(r7)
            r4.l0(r7)
        L_0x00ca:
            java.lang.String r7 = "border-bottom-width"
            java.lang.Object r7 = r6.get(r7)
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x00db
            float r7 = r5.s(r7, r8)
            r4.q0(r7)
        L_0x00db:
            java.lang.String r7 = "border-left-color"
            java.lang.Object r7 = r6.get(r7)
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x00ec
            com.itextpdf.text.BaseColor r7 = com.itextpdf.text.html.HtmlUtilities.b(r7)
            r4.m0(r7)
        L_0x00ec:
            java.lang.String r7 = "border-left-width"
            java.lang.Object r7 = r6.get(r7)
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x00fd
            float r5 = r5.s(r7, r8)
            r4.r0(r5)
        L_0x00fd:
            java.lang.String r5 = "before"
            java.lang.Object r5 = r6.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x010e
            float r5 = java.lang.Float.parseFloat(r5)
            r4.h(r5)
        L_0x010e:
            java.lang.String r5 = "after"
            java.lang.Object r5 = r6.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x011f
            float r5 = java.lang.Float.parseFloat(r5)
            r4.c(r5)
        L_0x011f:
            r4.t2(r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.tool.xml.css.apply.ImageCssApplier.a(com.itextpdf.text.Image, com.itextpdf.tool.xml.Tag, com.itextpdf.tool.xml.css.apply.MarginMemory, com.itextpdf.tool.xml.css.apply.PageSizeContainable, com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext):com.itextpdf.text.Image");
    }
}
