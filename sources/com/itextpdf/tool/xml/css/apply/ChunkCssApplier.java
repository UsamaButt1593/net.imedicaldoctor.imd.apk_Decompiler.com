package com.itextpdf.tool.xml.css.apply;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.FontFactoryImp;
import com.itextpdf.text.FontProvider;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.html.CssApplier;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import java.util.Arrays;
import java.util.List;

public class ChunkCssApplier implements CssApplier<Chunk> {

    /* renamed from: c  reason: collision with root package name */
    public static final List<String> f27523c = Arrays.asList(new String[]{"bold", "bolder", "600", "700", "800", "900"});

    /* renamed from: a  reason: collision with root package name */
    protected final CssUtils f27524a;

    /* renamed from: b  reason: collision with root package name */
    protected FontProvider f27525b;

    public ChunkCssApplier() {
        this((FontProvider) null);
    }

    public Chunk b(Chunk chunk, Tag tag) {
        return a(chunk, tag, (MarginMemory) null, (PageSizeContainable) null, (HtmlPipelineContext) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:71:0x01d2  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.Chunk a(com.itextpdf.text.Chunk r17, com.itextpdf.tool.xml.Tag r18, com.itextpdf.tool.xml.css.apply.MarginMemory r19, com.itextpdf.tool.xml.css.apply.PageSizeContainable r20, com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext r21) {
        /*
            r16 = this;
            r0 = r16
            r8 = r17
            r1 = r18
            com.itextpdf.text.Font r9 = r0.d(r1)
            float r2 = r9.m()
            java.util.Map r10 = r18.g()
            java.util.Set r1 = r10.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x001a:
            boolean r3 = r1.hasNext()
            r4 = 1120403456(0x42c80000, float:100.0)
            java.lang.String r5 = ""
            java.lang.String r6 = "%"
            if (r3 == 0) goto L_0x009e
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r7 = r3.getKey()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r3 = r3.getValue()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r11 = "font-style"
            boolean r11 = r11.equalsIgnoreCase(r7)
            r12 = 0
            if (r11 == 0) goto L_0x004f
            java.lang.String r4 = "oblique"
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x001a
            r3 = 1094713344(0x41400000, float:12.0)
            r8.b0(r12, r3)
            goto L_0x001a
        L_0x004f:
            java.lang.String r11 = "letter-spacing"
            boolean r7 = r11.equalsIgnoreCase(r7)
            if (r7 == 0) goto L_0x0082
            java.lang.Object r4 = r10.get(r11)
            java.lang.String r4 = (java.lang.String) r4
            com.itextpdf.tool.xml.css.CssUtils r5 = r0.f27524a
            boolean r5 = r5.k(r3)
            if (r5 == 0) goto L_0x0070
            com.itextpdf.tool.xml.css.CssUtils r3 = r0.f27524a
            float r5 = r9.m()
            float r12 = r3.r(r4, r5)
            goto L_0x007e
        L_0x0070:
            com.itextpdf.tool.xml.css.CssUtils r5 = r0.f27524a
            boolean r3 = r5.i(r3)
            if (r3 == 0) goto L_0x007e
            com.itextpdf.tool.xml.css.CssUtils r3 = r0.f27524a
            float r12 = r3.p(r4)
        L_0x007e:
            r8.N(r12)
            goto L_0x001a
        L_0x0082:
            java.lang.String r3 = "xfa-font-horizontal-scale"
            java.lang.Object r7 = r10.get(r3)
            if (r7 == 0) goto L_0x001a
            java.lang.Object r3 = r10.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = r3.replace(r6, r5)
            float r3 = java.lang.Float.parseFloat(r3)
            float r3 = r3 / r4
            r8.Q(r3)
            goto L_0x001a
        L_0x009e:
            java.lang.String r1 = "vertical-align"
            java.lang.Object r3 = r10.get(r1)
            if (r3 == 0) goto L_0x00f5
            java.lang.Object r1 = r10.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r3 = "super"
            boolean r3 = r1.equalsIgnoreCase(r3)
            r7 = 1073741824(0x40000000, float:2.0)
            if (r3 != 0) goto L_0x00ed
            java.lang.String r3 = "top"
            boolean r3 = r1.equalsIgnoreCase(r3)
            if (r3 != 0) goto L_0x00ed
            java.lang.String r3 = "text-top"
            boolean r3 = r1.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x00c7
            goto L_0x00ed
        L_0x00c7:
            java.lang.String r3 = "sub"
            boolean r3 = r1.equalsIgnoreCase(r3)
            if (r3 != 0) goto L_0x00ea
            java.lang.String r3 = "bottom"
            boolean r3 = r1.equalsIgnoreCase(r3)
            if (r3 != 0) goto L_0x00ea
            java.lang.String r3 = "text-bottom"
            boolean r3 = r1.equalsIgnoreCase(r3)
            if (r3 == 0) goto L_0x00e0
            goto L_0x00ea
        L_0x00e0:
            com.itextpdf.tool.xml.css.CssUtils r3 = r0.f27524a
            float r1 = r3.p(r1)
        L_0x00e6:
            r8.f0(r1)
            goto L_0x00f5
        L_0x00ea:
            float r1 = -r2
            float r1 = r1 / r7
            goto L_0x00e6
        L_0x00ed:
            float r1 = r2 / r7
            double r11 = (double) r1
            r13 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r11 = r11 + r13
            float r1 = (float) r11
            goto L_0x00e6
        L_0x00f5:
            java.lang.String r1 = "xfa-font-vertical-scale"
            java.lang.Object r1 = r10.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x011c
            boolean r3 = r1.contains(r6)
            if (r3 == 0) goto L_0x011c
            java.lang.String r3 = r1.replace(r6, r5)
            float r3 = java.lang.Float.parseFloat(r3)
            float r3 = r3 / r4
            float r2 = r2 * r3
            java.lang.String r1 = r1.replace(r6, r5)
            float r1 = java.lang.Float.parseFloat(r1)
            float r4 = r4 / r1
            r8.Q(r4)
        L_0x011c:
            r11 = r2
            java.lang.String r1 = "text-decoration"
            java.lang.Object r2 = r10.get(r1)
            if (r2 == 0) goto L_0x0165
            java.lang.Object r1 = r10.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "\\s+"
            java.lang.String[] r12 = r1.split(r2)
            int r13 = r12.length
            r1 = 0
            r14 = 0
        L_0x0134:
            if (r14 >= r13) goto L_0x0165
            r15 = r12[r14]
            java.lang.String r1 = "underline"
            boolean r1 = r1.equalsIgnoreCase(r15)
            if (r1 == 0) goto L_0x014d
            r6 = -1107296256(0xffffffffbe000000, float:-0.125)
            r7 = 0
            r2 = 0
            r3 = 1061158912(0x3f400000, float:0.75)
            r4 = 0
            r5 = 0
            r1 = r17
            r1.h0(r2, r3, r4, r5, r6, r7)
        L_0x014d:
            java.lang.String r1 = "line-through"
            boolean r1 = r1.equalsIgnoreCase(r15)
            if (r1 == 0) goto L_0x0162
            r6 = 1048576000(0x3e800000, float:0.25)
            r7 = 0
            r2 = 0
            r3 = 1061158912(0x3f400000, float:0.75)
            r4 = 0
            r5 = 0
            r1 = r17
            r1.h0(r2, r3, r4, r5, r6, r7)
        L_0x0162:
            int r14 = r14 + 1
            goto L_0x0134
        L_0x0165:
            java.lang.String r1 = "background-color"
            java.lang.Object r2 = r10.get(r1)
            if (r2 == 0) goto L_0x017a
            java.lang.Object r1 = r10.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            com.itextpdf.text.BaseColor r1 = com.itextpdf.text.html.HtmlUtilities.b(r1)
            r8.K(r1)
        L_0x017a:
            r9.y(r11)
            r8.O(r9)
            java.lang.String r1 = "line-height"
            java.lang.Object r2 = r10.get(r1)
            if (r2 == 0) goto L_0x01cf
            java.lang.Object r1 = r10.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            com.itextpdf.tool.xml.css.CssUtils r2 = r0.f27524a
            boolean r2 = r2.j(r1)
            if (r2 == 0) goto L_0x01a9
            float r1 = java.lang.Float.parseFloat(r1)
            com.itextpdf.text.Font r2 = r17.k()
            float r2 = r2.m()
            float r1 = r1 * r2
        L_0x01a4:
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            goto L_0x01d0
        L_0x01a9:
            com.itextpdf.tool.xml.css.CssUtils r2 = r0.f27524a
            boolean r2 = r2.k(r1)
            if (r2 == 0) goto L_0x01c0
            com.itextpdf.tool.xml.css.CssUtils r2 = r0.f27524a
            com.itextpdf.text.Font r3 = r17.k()
            float r3 = r3.m()
            float r1 = r2.r(r1, r3)
            goto L_0x01a4
        L_0x01c0:
            com.itextpdf.tool.xml.css.CssUtils r2 = r0.f27524a
            boolean r2 = r2.i(r1)
            if (r2 == 0) goto L_0x01cf
            com.itextpdf.tool.xml.css.CssUtils r2 = r0.f27524a
            float r1 = r2.p(r1)
            goto L_0x01a4
        L_0x01cf:
            r1 = 0
        L_0x01d0:
            if (r1 == 0) goto L_0x01d9
            float r1 = r1.floatValue()
            r8.S(r1)
        L_0x01d9:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.tool.xml.css.apply.ChunkCssApplier.a(com.itextpdf.text.Chunk, com.itextpdf.tool.xml.Tag, com.itextpdf.tool.xml.css.apply.MarginMemory, com.itextpdf.tool.xml.css.apply.PageSizeContainable, com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext):com.itextpdf.text.Chunk");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006b, code lost:
        if (r11 == 1) goto L_0x004f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.Font d(com.itextpdf.tool.xml.Tag r20) {
        /*
            r19 = this;
            r0 = r19
            com.itextpdf.tool.xml.css.FontSizeTranslator r1 = com.itextpdf.tool.xml.css.FontSizeTranslator.b()
            r2 = r20
            float r1 = r1.a(r2)
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x0014
            r1 = 1094713344(0x41400000, float:12.0)
        L_0x0014:
            java.util.Map r2 = r20.g()
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
            r9 = -1
            r11 = -1
            r12 = 0
            r13 = 0
        L_0x0024:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0085
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r3 = r3.getValue()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r5 = "font-weight"
            boolean r5 = r5.equalsIgnoreCase(r4)
            r6 = 3
            r7 = 2
            r8 = 1
            if (r5 == 0) goto L_0x005b
            boolean r3 = r0.h(r3)
            if (r3 == 0) goto L_0x0053
            if (r11 != r7) goto L_0x0051
        L_0x004f:
            r11 = 3
            goto L_0x0024
        L_0x0051:
            r11 = 1
            goto L_0x0024
        L_0x0053:
            if (r11 != r6) goto L_0x0057
        L_0x0055:
            r11 = 2
            goto L_0x0024
        L_0x0057:
            if (r11 != r8) goto L_0x0024
            r11 = 0
            goto L_0x0024
        L_0x005b:
            java.lang.String r5 = "font-style"
            boolean r5 = r5.equalsIgnoreCase(r4)
            if (r5 == 0) goto L_0x006e
            java.lang.String r4 = "italic"
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x0024
            if (r11 != r8) goto L_0x0055
            goto L_0x004f
        L_0x006e:
            java.lang.String r5 = "font-family"
            boolean r5 = r5.equalsIgnoreCase(r4)
            if (r5 == 0) goto L_0x0078
            r13 = r3
            goto L_0x0024
        L_0x0078:
            java.lang.String r5 = "color"
            boolean r4 = r5.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0024
            com.itextpdf.text.BaseColor r12 = com.itextpdf.text.html.HtmlUtilities.b(r3)
            goto L_0x0024
        L_0x0085:
            java.lang.String r15 = "Cp1252"
            if (r13 == 0) goto L_0x0100
            java.lang.String r8 = ","
            boolean r2 = r13.contains(r8)
            if (r2 == 0) goto L_0x00f8
            java.lang.String[] r7 = r13.split(r8)
            int r6 = r7.length
            r5 = 0
            r16 = 0
        L_0x0099:
            if (r5 >= r6) goto L_0x00df
            r2 = r7[r5]
            com.itextpdf.tool.xml.css.CssUtils r3 = r0.f27524a
            java.lang.String r3 = r3.z(r2)
            com.itextpdf.text.FontProvider r2 = r0.f27525b
            boolean r2 = r2.b(r3)
            if (r2 == 0) goto L_0x00d2
            com.itextpdf.text.FontProvider r2 = r0.f27525b
            r17 = 1
            r4 = r15
            r18 = r5
            r5 = r17
            r17 = r6
            r6 = r1
            r10 = r7
            r7 = r11
            r14 = r8
            r8 = r12
            com.itextpdf.text.Font r2 = r2.a(r3, r4, r5, r6, r7, r8)
            if (r2 == 0) goto L_0x00cd
            if (r11 == 0) goto L_0x00cc
            if (r11 == r9) goto L_0x00cc
            int r3 = r2.n()
            r3 = r3 & r11
            if (r3 != 0) goto L_0x00cd
        L_0x00cc:
            return r2
        L_0x00cd:
            if (r16 != 0) goto L_0x00d8
            r16 = r2
            goto L_0x00d8
        L_0x00d2:
            r18 = r5
            r17 = r6
            r10 = r7
            r14 = r8
        L_0x00d8:
            int r5 = r18 + 1
            r7 = r10
            r8 = r14
            r6 = r17
            goto L_0x0099
        L_0x00df:
            r10 = r7
            r14 = r8
            if (r16 == 0) goto L_0x00e4
            return r16
        L_0x00e4:
            int r2 = r10.length
            if (r2 <= 0) goto L_0x00f5
            com.itextpdf.tool.xml.css.CssUtils r2 = r0.f27524a
            java.lang.String[] r3 = r13.split(r14)
            r4 = 0
            r3 = r3[r4]
            java.lang.String r10 = r2.z(r3)
            goto L_0x00f6
        L_0x00f5:
            r10 = 0
        L_0x00f6:
            r3 = r10
            goto L_0x0101
        L_0x00f8:
            com.itextpdf.tool.xml.css.CssUtils r2 = r0.f27524a
            java.lang.String r2 = r2.z(r13)
            r3 = r2
            goto L_0x0101
        L_0x0100:
            r3 = r13
        L_0x0101:
            com.itextpdf.text.FontProvider r2 = r0.f27525b
            r5 = 1
            r4 = r15
            r6 = r1
            r7 = r11
            r8 = r12
            com.itextpdf.text.Font r1 = r2.a(r3, r4, r5, r6, r7, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.tool.xml.css.apply.ChunkCssApplier.d(com.itextpdf.tool.xml.Tag):com.itextpdf.text.Font");
    }

    public void e(Chunk chunk, Chunk chunk2) {
        chunk2.O(chunk.k());
        chunk2.J(chunk.h());
        chunk2.N(chunk.i());
        chunk2.Q(chunk.l());
        chunk2.Q(chunk.l());
    }

    public FontProvider f() {
        return this.f27525b;
    }

    public float g(Chunk chunk) {
        String[] split = chunk.j().split("\\s");
        float f2 = 0.0f;
        for (String chunk2 : split) {
            Chunk chunk3 = new Chunk(chunk2);
            e(chunk, chunk3);
            if (chunk3.u() > f2) {
                f2 = chunk3.u();
            }
        }
        return f2;
    }

    /* access modifiers changed from: protected */
    public boolean h(String str) {
        String trim = str.trim();
        return "bold".contains(trim) || (trim.length() == 3 && trim.endsWith("00") && trim.charAt(0) >= '6' && trim.charAt(0) <= '9');
    }

    public void i(FontProvider fontProvider) {
        this.f27525b = fontProvider;
    }

    public ChunkCssApplier(FontProvider fontProvider) {
        this.f27524a = CssUtils.g();
        this.f27525b = fontProvider == null ? new FontFactoryImp() : fontProvider;
    }
}
