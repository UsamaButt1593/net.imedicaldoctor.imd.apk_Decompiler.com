package com.itextpdf.tool.xml.css.apply;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.html.CssApplier;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;

public class ListStyleTypeCssApplier implements CssApplier<List> {

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f27529b = LoggerFactory.b(ListStyleTypeCssApplier.class);

    /* renamed from: a  reason: collision with root package name */
    private final CssUtils f27530a = CssUtils.g();

    private void e(List list, float f2, BaseColor baseColor) {
        list.R(12.0f);
        Font k2 = list.l().k();
        k2.y(f2);
        k2.w(baseColor);
    }

    private void f(float f2, List list, BaseColor baseColor) {
        Font k2 = list.l().k();
        k2.y(f2);
        k2.w(baseColor);
        list.R(f2);
    }

    public Element b(List list, Tag tag) {
        return a(list, tag, (MarginMemory) null, (PageSizeContainable) null, (HtmlPipelineContext) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x01d1 A[Catch:{ NoImageException -> 0x01e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0235  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x024c  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x026a A[SYNTHETIC, Splitter:B:88:0x026a] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.List a(com.itextpdf.text.List r10, com.itextpdf.tool.xml.Tag r11, com.itextpdf.tool.xml.css.apply.MarginMemory r12, com.itextpdf.tool.xml.css.apply.PageSizeContainable r13, com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext r14) {
        /*
            r9 = this;
            r12 = 1
            r13 = 0
            com.itextpdf.tool.xml.css.FontSizeTranslator r0 = com.itextpdf.tool.xml.css.FontSizeTranslator.b()
            float r0 = r0.a(r11)
            java.util.Map r1 = r11.g()
            java.lang.String r2 = "list-style-type"
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "color"
            java.lang.Object r3 = r1.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            com.itextpdf.text.BaseColor r3 = com.itextpdf.text.html.HtmlUtilities.b(r3)
            if (r3 != 0) goto L_0x0026
            com.itextpdf.text.BaseColor r3 = com.itextpdf.text.BaseColor.f25677f
        L_0x0026:
            java.lang.String r4 = "none"
            if (r2 == 0) goto L_0x0132
            boolean r5 = r2.equalsIgnoreCase(r4)
            if (r5 == 0) goto L_0x003d
            r10.J(r13)
            r10.O(r13)
            java.lang.String r2 = ""
            r10.M(r2)
            goto L_0x0181
        L_0x003d:
            java.lang.String r5 = "decimal"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x004c
            com.itextpdf.text.List r10 = new com.itextpdf.text.List
            r10.<init>((boolean) r12)
            goto L_0x0181
        L_0x004c:
            java.lang.String r5 = "disc"
            boolean r5 = r5.equalsIgnoreCase(r2)
            r6 = 1083179008(0x40900000, float:4.5)
            r7 = 1069547520(0x3fc00000, float:1.5)
            r8 = 1089994752(0x40f80000, float:7.75)
            if (r5 == 0) goto L_0x007a
            com.itextpdf.text.ZapfDingbatsList r10 = new com.itextpdf.text.ZapfDingbatsList
            r2 = 108(0x6c, float:1.51E-43)
            r10.<init>(r2)
            r10.H(r13)
            r10.R(r8)
            com.itextpdf.text.Chunk r2 = r10.l()
            r2.f0(r7)
            com.itextpdf.text.Font r2 = r2.k()
            r2.y(r6)
            r2.w(r3)
            goto L_0x0181
        L_0x007a:
            java.lang.String r5 = "square"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x008e
            com.itextpdf.text.ZapfDingbatsList r10 = new com.itextpdf.text.ZapfDingbatsList
            r2 = 110(0x6e, float:1.54E-43)
            r10.<init>(r2)
        L_0x0089:
            r9.e(r10, r0, r3)
            goto L_0x0181
        L_0x008e:
            java.lang.String r5 = "circle"
            boolean r5 = r5.equalsIgnoreCase(r2)
            if (r5 == 0) goto L_0x00b3
            com.itextpdf.text.ZapfDingbatsList r10 = new com.itextpdf.text.ZapfDingbatsList
            r2 = 109(0x6d, float:1.53E-43)
            r10.<init>(r2)
            r10.H(r13)
            r10.R(r8)
            com.itextpdf.text.Chunk r2 = r10.l()
            r2.f0(r7)
            com.itextpdf.text.Font r2 = r2.k()
            r2.y(r6)
            goto L_0x0181
        L_0x00b3:
            java.lang.String r5 = "lower-roman"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x00c8
            com.itextpdf.text.RomanList r10 = new com.itextpdf.text.RomanList
            r10.<init>(r12, r13)
        L_0x00c0:
            r9.f(r0, r10, r3)
        L_0x00c3:
            r10.H(r12)
            goto L_0x0181
        L_0x00c8:
            java.lang.String r5 = "upper-roman"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x00dd
            com.itextpdf.text.RomanList r10 = new com.itextpdf.text.RomanList
            r10.<init>(r13, r13)
            r10.H(r12)
            r9.f(r0, r10, r3)
            goto L_0x0181
        L_0x00dd:
            java.lang.String r5 = "lower-greek"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x00eb
            com.itextpdf.text.GreekList r10 = new com.itextpdf.text.GreekList
            r10.<init>(r12, r13)
            goto L_0x00c0
        L_0x00eb:
            java.lang.String r5 = "upper-greek"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x00f9
            com.itextpdf.text.GreekList r10 = new com.itextpdf.text.GreekList
            r10.<init>(r13, r13)
            goto L_0x00c0
        L_0x00f9:
            java.lang.String r5 = "lower-alpha"
            boolean r5 = r5.equals(r2)
            if (r5 != 0) goto L_0x0126
            java.lang.String r5 = "lower-latin"
            boolean r5 = r5.equals(r2)
            if (r5 == 0) goto L_0x010a
            goto L_0x0126
        L_0x010a:
            java.lang.String r5 = "upper-alpha"
            boolean r5 = r5.equals(r2)
            if (r5 != 0) goto L_0x011a
            java.lang.String r5 = "upper-latin"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0181
        L_0x011a:
            com.itextpdf.text.List r10 = new com.itextpdf.text.List
            r10.<init>((boolean) r12, (boolean) r12)
            r9.f(r0, r10, r3)
            r10.N(r13)
            goto L_0x00c3
        L_0x0126:
            com.itextpdf.text.List r10 = new com.itextpdf.text.List
            r10.<init>((boolean) r12, (boolean) r12)
            r9.f(r0, r10, r3)
            r10.N(r12)
            goto L_0x00c3
        L_0x0132:
            java.lang.String r2 = r11.o()
            java.lang.String r5 = "ol"
            boolean r2 = r2.equalsIgnoreCase(r5)
            if (r2 == 0) goto L_0x016e
            com.itextpdf.text.List r10 = new com.itextpdf.text.List
            r10.<init>((boolean) r12)
            java.util.Map r2 = r11.d()
            java.lang.String r5 = "type"
            java.lang.Object r2 = r2.get(r5)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x00c0
            java.lang.String r5 = "A"
            boolean r5 = r2.equals(r5)
            if (r5 == 0) goto L_0x015e
            r10.J(r12)
            goto L_0x00c0
        L_0x015e:
            java.lang.String r5 = "a"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x00c0
            r10.J(r12)
            r10.N(r12)
            goto L_0x00c0
        L_0x016e:
            java.lang.String r2 = r11.o()
            java.lang.String r5 = "ul"
            boolean r2 = r2.equalsIgnoreCase(r5)
            if (r2 == 0) goto L_0x0181
            com.itextpdf.text.List r10 = new com.itextpdf.text.List
            r10.<init>((boolean) r13)
            goto L_0x0089
        L_0x0181:
            java.lang.String r2 = "list-style-image"
            java.lang.Object r3 = r1.get(r2)
            r5 = 0
            if (r3 == 0) goto L_0x020f
            java.lang.Object r3 = r1.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 != 0) goto L_0x020f
            com.itextpdf.text.List r10 = new com.itextpdf.text.List
            r10.<init>()
            com.itextpdf.tool.xml.css.CssUtils r3 = r9.f27530a
            java.lang.Object r2 = r1.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r3.f(r2)
            com.itextpdf.tool.xml.net.ImageRetrieve r3 = new com.itextpdf.tool.xml.net.ImageRetrieve     // Catch:{ NoImageException -> 0x01e7 }
            java.lang.String r4 = r14.s()     // Catch:{ NoImageException -> 0x01e7 }
            com.itextpdf.tool.xml.pipeline.html.ImageProvider r14 = r14.p()     // Catch:{ NoImageException -> 0x01e7 }
            r3.<init>(r4, r14)     // Catch:{ NoImageException -> 0x01e7 }
            com.itextpdf.text.Image r14 = r3.b(r2)     // Catch:{ NoImageException -> 0x01e7 }
            com.itextpdf.text.Chunk r3 = new com.itextpdf.text.Chunk     // Catch:{ NoImageException -> 0x01e7 }
            r3.<init>(r14, r5, r5, r13)     // Catch:{ NoImageException -> 0x01e7 }
            r10.K(r3)     // Catch:{ NoImageException -> 0x01e7 }
            float r14 = r14.a0()     // Catch:{ NoImageException -> 0x01e7 }
            r10.R(r14)     // Catch:{ NoImageException -> 0x01e7 }
            com.itextpdf.text.log.Logger r14 = f27529b     // Catch:{ NoImageException -> 0x01e7 }
            com.itextpdf.text.log.Level r3 = com.itextpdf.text.log.Level.TRACE     // Catch:{ NoImageException -> 0x01e7 }
            boolean r3 = r14.b(r3)     // Catch:{ NoImageException -> 0x01e7 }
            if (r3 == 0) goto L_0x020c
            com.itextpdf.tool.xml.exceptions.LocaleMessages r3 = com.itextpdf.tool.xml.exceptions.LocaleMessages.a()     // Catch:{ NoImageException -> 0x01e7 }
            java.lang.String r4 = "html.tag.list"
            java.lang.String r3 = r3.b(r4)     // Catch:{ NoImageException -> 0x01e7 }
            java.lang.Object[] r4 = new java.lang.Object[r12]     // Catch:{ NoImageException -> 0x01e7 }
            r4[r13] = r2     // Catch:{ NoImageException -> 0x01e7 }
            java.lang.String r3 = java.lang.String.format(r3, r4)     // Catch:{ NoImageException -> 0x01e7 }
            r14.h(r3)     // Catch:{ NoImageException -> 0x01e7 }
            goto L_0x020c
        L_0x01e7:
            r10 = move-exception
            com.itextpdf.text.log.Logger r14 = f27529b
            com.itextpdf.text.log.Level r3 = com.itextpdf.text.log.Level.ERROR
            boolean r3 = r14.b(r3)
            if (r3 == 0) goto L_0x0207
            com.itextpdf.tool.xml.exceptions.LocaleMessages r3 = com.itextpdf.tool.xml.exceptions.LocaleMessages.a()
            java.lang.String r4 = "html.tag.img.failed"
            java.lang.String r3 = r3.b(r4)
            java.lang.Object[] r12 = new java.lang.Object[r12]
            r12[r13] = r2
            java.lang.String r12 = java.lang.String.format(r3, r12)
            r14.i(r12, r10)
        L_0x0207:
            com.itextpdf.text.List r10 = new com.itextpdf.text.List
            r10.<init>((boolean) r13)
        L_0x020c:
            r10.H(r13)
        L_0x020f:
            r10.G(r13)
            java.lang.String r12 = "list-style-position"
            java.lang.Object r13 = r1.get(r12)
            if (r13 == 0) goto L_0x022b
            java.lang.Object r12 = r1.get(r12)
            java.lang.String r12 = (java.lang.String) r12
            java.lang.String r13 = "inside"
            boolean r12 = r12.equalsIgnoreCase(r13)
            if (r12 == 0) goto L_0x022b
            r12 = 1106247680(0x41f00000, float:30.0)
            goto L_0x022d
        L_0x022b:
            r12 = 1097859072(0x41700000, float:15.0)
        L_0x022d:
            java.lang.String r13 = "margin-left"
            java.lang.Object r14 = r1.get(r13)
            if (r14 == 0) goto L_0x0242
            com.itextpdf.tool.xml.css.CssUtils r14 = r9.f27530a
            java.lang.Object r13 = r1.get(r13)
            java.lang.String r13 = (java.lang.String) r13
            float r13 = r14.s(r13, r0)
            goto L_0x0243
        L_0x0242:
            r13 = 0
        L_0x0243:
            float r12 = r12 + r13
            java.lang.String r13 = "padding-left"
            java.lang.Object r14 = r1.get(r13)
            if (r14 == 0) goto L_0x0258
            com.itextpdf.tool.xml.css.CssUtils r14 = r9.f27530a
            java.lang.Object r13 = r1.get(r13)
            java.lang.String r13 = (java.lang.String) r13
            float r5 = r14.s(r13, r0)
        L_0x0258:
            float r12 = r12 + r5
            r10.g(r12)
            java.util.Map r11 = r11.d()
            java.lang.String r12 = "start"
            java.lang.Object r11 = r11.get(r12)
            java.lang.String r11 = (java.lang.String) r11
            if (r11 == 0) goto L_0x0271
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ NumberFormatException -> 0x0271 }
            r10.I(r11)     // Catch:{ NumberFormatException -> 0x0271 }
        L_0x0271:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.tool.xml.css.apply.ListStyleTypeCssApplier.a(com.itextpdf.text.List, com.itextpdf.tool.xml.Tag, com.itextpdf.tool.xml.css.apply.MarginMemory, com.itextpdf.tool.xml.css.apply.PageSizeContainable, com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext):com.itextpdf.text.List");
    }

    public List d(List list, Tag tag, HtmlPipelineContext htmlPipelineContext) {
        return a(list, tag, (MarginMemory) null, (PageSizeContainable) null, htmlPipelineContext);
    }
}
