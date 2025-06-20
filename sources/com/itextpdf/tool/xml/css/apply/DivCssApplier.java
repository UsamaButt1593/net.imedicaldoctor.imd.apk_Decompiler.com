package com.itextpdf.tool.xml.css.apply;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.PdfDiv;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.html.CssApplier;

public class DivCssApplier implements CssApplier<PdfDiv> {

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f27526b = LoggerFactory.b(ListStyleTypeCssApplier.class);

    /* renamed from: a  reason: collision with root package name */
    private final CssUtils f27527a = CssUtils.g();

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0113  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.pdf.PdfDiv a(com.itextpdf.text.pdf.PdfDiv r8, com.itextpdf.tool.xml.Tag r9, com.itextpdf.tool.xml.css.apply.MarginMemory r10, com.itextpdf.tool.xml.css.apply.PageSizeContainable r11, com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext r12) {
        /*
            r7 = this;
            r0 = 1
            java.util.Map r1 = r9.g()
            com.itextpdf.tool.xml.css.FontSizeTranslator r2 = com.itextpdf.tool.xml.css.FontSizeTranslator.b()
            float r2 = r2.c(r9)
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x0015
            r2 = 1094713344(0x41400000, float:12.0)
        L_0x0015:
            java.util.Map r3 = r9.d()
            java.lang.String r4 = "align"
            boolean r3 = r3.containsKey(r4)
            if (r3 == 0) goto L_0x002c
            java.util.Map r3 = r9.d()
            java.lang.Object r3 = r3.get(r4)
        L_0x0029:
            java.lang.String r3 = (java.lang.String) r3
            goto L_0x003a
        L_0x002c:
            java.lang.String r3 = "text-align"
            boolean r4 = r1.containsKey(r3)
            if (r4 == 0) goto L_0x0039
            java.lang.Object r3 = r1.get(r3)
            goto L_0x0029
        L_0x0039:
            r3 = 0
        L_0x003a:
            if (r3 == 0) goto L_0x0043
            int r3 = com.itextpdf.tool.xml.css.CSS.a(r3)
            r8.q0(r3)
        L_0x0043:
            java.lang.String r3 = "width"
            java.lang.Object r4 = r1.get(r3)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 != 0) goto L_0x0058
            java.util.Map r4 = r9.d()
            java.lang.Object r3 = r4.get(r3)
            r4 = r3
            java.lang.String r4 = (java.lang.String) r4
        L_0x0058:
            r3 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r5 = "%"
            if (r4 == 0) goto L_0x00ac
            com.itextpdf.text.Rectangle r11 = r11.getPageSize()
            float r11 = r11.a0()
            com.itextpdf.tool.xml.css.CssUtils r6 = r7.f27527a
            boolean r6 = r6.j(r4)
            if (r6 != 0) goto L_0x00a5
            com.itextpdf.tool.xml.css.CssUtils r6 = r7.f27527a
            boolean r6 = r6.i(r4)
            if (r6 == 0) goto L_0x0077
            goto L_0x00a5
        L_0x0077:
            com.itextpdf.tool.xml.css.CssUtils r6 = r7.f27527a
            boolean r6 = r6.k(r4)
            if (r6 == 0) goto L_0x00ac
            boolean r6 = r4.contains(r5)
            if (r6 == 0) goto L_0x0093
            com.itextpdf.tool.xml.css.CssUtils r11 = r7.f27527a
            float r11 = r11.r(r4, r3)
            java.lang.Float r11 = java.lang.Float.valueOf(r11)
            r8.m0(r11)
            goto L_0x00ac
        L_0x0093:
            com.itextpdf.tool.xml.css.CssUtils r6 = r7.f27527a
            float r4 = r6.r(r4, r2)
        L_0x0099:
            float r11 = java.lang.Math.min(r11, r4)
            java.lang.Float r11 = java.lang.Float.valueOf(r11)
            r8.s0(r11)
            goto L_0x00ac
        L_0x00a5:
            com.itextpdf.tool.xml.css.CssUtils r6 = r7.f27527a
            float r4 = r6.p(r4)
            goto L_0x0099
        L_0x00ac:
            java.lang.String r11 = "height"
            java.lang.Object r4 = r1.get(r11)
            java.lang.String r4 = (java.lang.String) r4
            if (r4 != 0) goto L_0x00c1
            java.util.Map r9 = r9.d()
            java.lang.Object r9 = r9.get(r11)
            r4 = r9
            java.lang.String r4 = (java.lang.String) r4
        L_0x00c1:
            if (r4 == 0) goto L_0x0105
            com.itextpdf.tool.xml.css.CssUtils r9 = r7.f27527a
            boolean r9 = r9.j(r4)
            if (r9 != 0) goto L_0x00fe
            com.itextpdf.tool.xml.css.CssUtils r9 = r7.f27527a
            boolean r9 = r9.i(r4)
            if (r9 == 0) goto L_0x00d4
            goto L_0x00fe
        L_0x00d4:
            com.itextpdf.tool.xml.css.CssUtils r9 = r7.f27527a
            boolean r9 = r9.k(r4)
            if (r9 == 0) goto L_0x0105
            boolean r9 = r4.contains(r5)
            if (r9 == 0) goto L_0x00f0
            com.itextpdf.tool.xml.css.CssUtils r9 = r7.f27527a
            float r9 = r9.r(r4, r3)
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            r8.l0(r9)
            goto L_0x0105
        L_0x00f0:
            com.itextpdf.tool.xml.css.CssUtils r9 = r7.f27527a
            float r9 = r9.r(r4, r2)
        L_0x00f6:
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            r8.e0(r9)
            goto L_0x0105
        L_0x00fe:
            com.itextpdf.tool.xml.css.CssUtils r9 = r7.f27527a
            float r9 = r9.p(r4)
            goto L_0x00f6
        L_0x0105:
            java.util.Set r9 = r1.entrySet()
            java.util.Iterator r9 = r9.iterator()
        L_0x010d:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x03dc
            java.lang.Object r11 = r9.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.Object r1 = r11.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r11 = r11.getValue()
            java.lang.String r11 = (java.lang.String) r11
            java.lang.String r3 = "left"
            boolean r4 = r1.equalsIgnoreCase(r3)
            if (r4 == 0) goto L_0x013b
            com.itextpdf.tool.xml.css.CssUtils r1 = r7.f27527a
            float r11 = r1.s(r11, r2)
            java.lang.Float r11 = java.lang.Float.valueOf(r11)
            r8.g0(r11)
            goto L_0x010d
        L_0x013b:
            java.lang.String r4 = "right"
            boolean r5 = r1.equalsIgnoreCase(r4)
            if (r5 == 0) goto L_0x015d
            java.lang.Float r1 = r8.N()
            if (r1 == 0) goto L_0x014f
            java.lang.Float r1 = r8.v()
            if (r1 != 0) goto L_0x010d
        L_0x014f:
            com.itextpdf.tool.xml.css.CssUtils r1 = r7.f27527a
            float r11 = r1.s(r11, r2)
            java.lang.Float r11 = java.lang.Float.valueOf(r11)
            r8.o0(r11)
            goto L_0x010d
        L_0x015d:
            java.lang.String r5 = "top"
            boolean r5 = r1.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0173
            com.itextpdf.tool.xml.css.CssUtils r1 = r7.f27527a
            float r11 = r1.s(r11, r2)
            java.lang.Float r11 = java.lang.Float.valueOf(r11)
            r8.r0(r11)
            goto L_0x010d
        L_0x0173:
            java.lang.String r5 = "bottom"
            boolean r5 = r1.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0196
            java.lang.Float r1 = r8.s()
            if (r1 == 0) goto L_0x0187
            java.lang.Float r1 = r8.J()
            if (r1 != 0) goto L_0x010d
        L_0x0187:
            com.itextpdf.tool.xml.css.CssUtils r1 = r7.f27527a
            float r11 = r1.s(r11, r2)
            java.lang.Float r11 = java.lang.Float.valueOf(r11)
            r8.W(r11)
            goto L_0x010d
        L_0x0196:
            java.lang.String r5 = "background-color"
            boolean r5 = r1.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x01a7
            com.itextpdf.text.BaseColor r11 = com.itextpdf.text.html.HtmlUtilities.b(r11)
            r8.Q(r11)
            goto L_0x010d
        L_0x01a7:
            java.lang.String r5 = "background-image"
            boolean r5 = r1.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x01ee
            com.itextpdf.tool.xml.css.CssUtils r1 = r7.f27527a
            java.lang.String r11 = r1.f(r11)
            com.itextpdf.tool.xml.net.ImageRetrieve r1 = new com.itextpdf.tool.xml.net.ImageRetrieve     // Catch:{ NoImageException -> 0x01cb }
            java.lang.String r3 = r12.s()     // Catch:{ NoImageException -> 0x01cb }
            com.itextpdf.tool.xml.pipeline.html.ImageProvider r4 = r12.p()     // Catch:{ NoImageException -> 0x01cb }
            r1.<init>(r3, r4)     // Catch:{ NoImageException -> 0x01cb }
            com.itextpdf.text.Image r1 = r1.b(r11)     // Catch:{ NoImageException -> 0x01cb }
            r8.R(r1)     // Catch:{ NoImageException -> 0x01cb }
            goto L_0x010d
        L_0x01cb:
            r1 = move-exception
            com.itextpdf.text.log.Logger r3 = f27526b
            com.itextpdf.text.log.Level r4 = com.itextpdf.text.log.Level.ERROR
            boolean r4 = r3.b(r4)
            if (r4 == 0) goto L_0x010d
            com.itextpdf.tool.xml.exceptions.LocaleMessages r4 = com.itextpdf.tool.xml.exceptions.LocaleMessages.a()
            java.lang.String r5 = "html.tag.img.failed"
            java.lang.String r4 = r4.b(r5)
            java.lang.Object[] r5 = new java.lang.Object[r0]
            r6 = 0
            r5[r6] = r11
            java.lang.String r11 = java.lang.String.format(r4, r5)
            r3.i(r11, r1)
            goto L_0x010d
        L_0x01ee:
            java.lang.String r5 = "padding-left"
            boolean r5 = r1.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0201
            com.itextpdf.tool.xml.css.CssUtils r1 = r7.f27527a
            float r11 = r1.s(r11, r2)
            r8.i0(r11)
            goto L_0x010d
        L_0x0201:
            java.lang.String r5 = "padding-right"
            boolean r5 = r1.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0214
            com.itextpdf.tool.xml.css.CssUtils r1 = r7.f27527a
            float r11 = r1.s(r11, r2)
            r8.j0(r11)
            goto L_0x010d
        L_0x0214:
            java.lang.String r5 = "padding-top"
            boolean r5 = r1.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0227
            com.itextpdf.tool.xml.css.CssUtils r1 = r7.f27527a
            float r11 = r1.s(r11, r2)
            r8.M(r11)
            goto L_0x010d
        L_0x0227:
            java.lang.String r5 = "padding-bottom"
            boolean r5 = r1.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x023a
            com.itextpdf.tool.xml.css.CssUtils r1 = r7.f27527a
            float r11 = r1.s(r11, r2)
            r8.h0(r11)
            goto L_0x010d
        L_0x023a:
            java.lang.String r5 = "margin-top"
            boolean r5 = r1.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0249
            com.itextpdf.tool.xml.css.CssUtils r1 = r7.f27527a
            r1.b(r11, r2, r10)
            goto L_0x010d
        L_0x0249:
            java.lang.String r5 = "margin-bottom"
            boolean r5 = r1.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0258
            com.itextpdf.tool.xml.css.CssUtils r1 = r7.f27527a
            r1.s(r11, r2)
            goto L_0x010d
        L_0x0258:
            java.lang.String r5 = "float"
            boolean r5 = r1.equalsIgnoreCase(r5)
            if (r5 == 0) goto L_0x0276
            boolean r1 = r11.equalsIgnoreCase(r3)
            if (r1 == 0) goto L_0x026d
            com.itextpdf.text.pdf.PdfDiv$FloatType r11 = com.itextpdf.text.pdf.PdfDiv.FloatType.LEFT
        L_0x0268:
            r8.d0(r11)
            goto L_0x010d
        L_0x026d:
            boolean r11 = r11.equalsIgnoreCase(r4)
            if (r11 == 0) goto L_0x010d
            com.itextpdf.text.pdf.PdfDiv$FloatType r11 = com.itextpdf.text.pdf.PdfDiv.FloatType.RIGHT
            goto L_0x0268
        L_0x0276:
            java.lang.String r3 = "position"
            boolean r3 = r1.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x02a3
            java.lang.String r1 = "absolute"
            boolean r1 = r11.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x028d
            com.itextpdf.text.pdf.PdfDiv$PositionType r11 = com.itextpdf.text.pdf.PdfDiv.PositionType.ABSOLUTE
        L_0x0288:
            r8.n0(r11)
            goto L_0x010d
        L_0x028d:
            java.lang.String r1 = "fixed"
            boolean r1 = r11.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0298
            com.itextpdf.text.pdf.PdfDiv$PositionType r11 = com.itextpdf.text.pdf.PdfDiv.PositionType.FIXED
            goto L_0x0288
        L_0x0298:
            java.lang.String r1 = "relative"
            boolean r11 = r11.equalsIgnoreCase(r1)
            if (r11 == 0) goto L_0x010d
            com.itextpdf.text.pdf.PdfDiv$PositionType r11 = com.itextpdf.text.pdf.PdfDiv.PositionType.RELATIVE
            goto L_0x0288
        L_0x02a3:
            java.lang.String r3 = "display"
            boolean r3 = r1.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x0363
            java.lang.String r1 = "block"
            boolean r1 = r11.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x02ba
            com.itextpdf.text.pdf.PdfDiv$DisplayType r11 = com.itextpdf.text.pdf.PdfDiv.DisplayType.BLOCK
        L_0x02b5:
            r8.c0(r11)
            goto L_0x010d
        L_0x02ba:
            java.lang.String r1 = "inline"
            boolean r1 = r11.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x02c5
            com.itextpdf.text.pdf.PdfDiv$DisplayType r11 = com.itextpdf.text.pdf.PdfDiv.DisplayType.INLINE
            goto L_0x02b5
        L_0x02c5:
            java.lang.String r1 = "inline-block"
            boolean r1 = r11.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x02d0
            com.itextpdf.text.pdf.PdfDiv$DisplayType r11 = com.itextpdf.text.pdf.PdfDiv.DisplayType.INLINE_BLOCK
            goto L_0x02b5
        L_0x02d0:
            java.lang.String r1 = "inline-table"
            boolean r1 = r11.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x02db
            com.itextpdf.text.pdf.PdfDiv$DisplayType r11 = com.itextpdf.text.pdf.PdfDiv.DisplayType.INLINE_TABLE
            goto L_0x02b5
        L_0x02db:
            java.lang.String r1 = "list-item"
            boolean r1 = r11.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x02e6
            com.itextpdf.text.pdf.PdfDiv$DisplayType r11 = com.itextpdf.text.pdf.PdfDiv.DisplayType.LIST_ITEM
            goto L_0x02b5
        L_0x02e6:
            java.lang.String r1 = "none"
            boolean r1 = r11.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x02f1
            com.itextpdf.text.pdf.PdfDiv$DisplayType r11 = com.itextpdf.text.pdf.PdfDiv.DisplayType.NONE
            goto L_0x02b5
        L_0x02f1:
            java.lang.String r1 = "run-in"
            boolean r1 = r11.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x02fc
            com.itextpdf.text.pdf.PdfDiv$DisplayType r11 = com.itextpdf.text.pdf.PdfDiv.DisplayType.RUN_IN
            goto L_0x02b5
        L_0x02fc:
            java.lang.String r1 = "table"
            boolean r1 = r11.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0307
            com.itextpdf.text.pdf.PdfDiv$DisplayType r11 = com.itextpdf.text.pdf.PdfDiv.DisplayType.TABLE
            goto L_0x02b5
        L_0x0307:
            java.lang.String r1 = "table-caption"
            boolean r1 = r11.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0312
            com.itextpdf.text.pdf.PdfDiv$DisplayType r11 = com.itextpdf.text.pdf.PdfDiv.DisplayType.TABLE_CAPTION
            goto L_0x02b5
        L_0x0312:
            java.lang.String r1 = "table-cell"
            boolean r1 = r11.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x031d
            com.itextpdf.text.pdf.PdfDiv$DisplayType r11 = com.itextpdf.text.pdf.PdfDiv.DisplayType.TABLE_CELL
            goto L_0x02b5
        L_0x031d:
            java.lang.String r1 = "table-column-group"
            boolean r1 = r11.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0328
            com.itextpdf.text.pdf.PdfDiv$DisplayType r11 = com.itextpdf.text.pdf.PdfDiv.DisplayType.TABLE_COLUMN_GROUP
            goto L_0x02b5
        L_0x0328:
            java.lang.String r1 = "table-column"
            boolean r1 = r11.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0333
            com.itextpdf.text.pdf.PdfDiv$DisplayType r11 = com.itextpdf.text.pdf.PdfDiv.DisplayType.TABLE_COLUMN
            goto L_0x02b5
        L_0x0333:
            java.lang.String r1 = "table-footer-group"
            boolean r1 = r11.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x033f
            com.itextpdf.text.pdf.PdfDiv$DisplayType r11 = com.itextpdf.text.pdf.PdfDiv.DisplayType.TABLE_FOOTER_GROUP
            goto L_0x02b5
        L_0x033f:
            java.lang.String r1 = "table-header-group"
            boolean r1 = r11.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x034b
            com.itextpdf.text.pdf.PdfDiv$DisplayType r11 = com.itextpdf.text.pdf.PdfDiv.DisplayType.TABLE_HEADER_GROUP
            goto L_0x02b5
        L_0x034b:
            java.lang.String r1 = "table-row"
            boolean r1 = r11.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0357
            com.itextpdf.text.pdf.PdfDiv$DisplayType r11 = com.itextpdf.text.pdf.PdfDiv.DisplayType.TABLE_ROW
            goto L_0x02b5
        L_0x0357:
            java.lang.String r1 = "table-row-group"
            boolean r11 = r11.equalsIgnoreCase(r1)
            if (r11 == 0) goto L_0x010d
            com.itextpdf.text.pdf.PdfDiv$DisplayType r11 = com.itextpdf.text.pdf.PdfDiv.DisplayType.TABLE_ROW_GROUP
            goto L_0x02b5
        L_0x0363:
            java.lang.String r3 = "border-top-style"
            boolean r3 = r1.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x03c7
            java.lang.String r1 = "dotted"
            boolean r1 = r11.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x037a
            com.itextpdf.text.pdf.PdfDiv$BorderTopStyle r11 = com.itextpdf.text.pdf.PdfDiv.BorderTopStyle.DOTTED
        L_0x0375:
            r8.T(r11)
            goto L_0x010d
        L_0x037a:
            java.lang.String r1 = "dashed"
            boolean r1 = r11.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0385
            com.itextpdf.text.pdf.PdfDiv$BorderTopStyle r11 = com.itextpdf.text.pdf.PdfDiv.BorderTopStyle.DASHED
            goto L_0x0375
        L_0x0385:
            java.lang.String r1 = "solid"
            boolean r1 = r11.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x0390
            com.itextpdf.text.pdf.PdfDiv$BorderTopStyle r11 = com.itextpdf.text.pdf.PdfDiv.BorderTopStyle.SOLID
            goto L_0x0375
        L_0x0390:
            java.lang.String r1 = "double"
            boolean r1 = r11.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x039b
            com.itextpdf.text.pdf.PdfDiv$BorderTopStyle r11 = com.itextpdf.text.pdf.PdfDiv.BorderTopStyle.DOUBLE
            goto L_0x0375
        L_0x039b:
            java.lang.String r1 = "groove"
            boolean r1 = r11.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x03a6
            com.itextpdf.text.pdf.PdfDiv$BorderTopStyle r11 = com.itextpdf.text.pdf.PdfDiv.BorderTopStyle.GROOVE
            goto L_0x0375
        L_0x03a6:
            java.lang.String r1 = "ridge"
            boolean r1 = r11.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x03b1
            com.itextpdf.text.pdf.PdfDiv$BorderTopStyle r11 = com.itextpdf.text.pdf.PdfDiv.BorderTopStyle.RIDGE
            goto L_0x0375
        L_0x03b1:
            java.lang.String r1 = "inset"
            boolean r1 = r11.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x03bc
            com.itextpdf.text.pdf.PdfDiv$BorderTopStyle r11 = com.itextpdf.text.pdf.PdfDiv.BorderTopStyle.INSET
            goto L_0x0375
        L_0x03bc:
            java.lang.String r1 = "outset"
            boolean r11 = r11.equalsIgnoreCase(r1)
            if (r11 == 0) goto L_0x010d
            com.itextpdf.text.pdf.PdfDiv$BorderTopStyle r11 = com.itextpdf.text.pdf.PdfDiv.BorderTopStyle.OUTSET
            goto L_0x0375
        L_0x03c7:
            java.lang.String r3 = "page-break-inside"
            boolean r1 = r1.equalsIgnoreCase(r3)
            if (r1 == 0) goto L_0x010d
            java.lang.String r1 = "avoid"
            boolean r11 = r11.equalsIgnoreCase(r1)
            if (r11 == 0) goto L_0x010d
            r8.f0(r0)
            goto L_0x010d
        L_0x03dc:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.tool.xml.css.apply.DivCssApplier.a(com.itextpdf.text.pdf.PdfDiv, com.itextpdf.tool.xml.Tag, com.itextpdf.tool.xml.css.apply.MarginMemory, com.itextpdf.tool.xml.css.apply.PageSizeContainable, com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext):com.itextpdf.text.pdf.PdfDiv");
    }
}
