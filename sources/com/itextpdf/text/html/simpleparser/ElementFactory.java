package com.itextpdf.text.html.simpleparser;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.FontProvider;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.html.HtmlUtilities;
import com.itextpdf.text.pdf.HyphenationAuto;
import com.itextpdf.text.pdf.HyphenationEvent;
import java.util.StringTokenizer;

@Deprecated
public class ElementFactory {

    /* renamed from: a  reason: collision with root package name */
    private FontProvider f25766a = FontFactory.p();

    protected static void k(Paragraph paragraph, String str) {
        if (str == null) {
            paragraph.b1(0.0f, 1.5f);
            return;
        }
        try {
            StringTokenizer stringTokenizer = new StringTokenizer(str, " ,");
            float parseFloat = Float.parseFloat(stringTokenizer.nextToken());
            if (!stringTokenizer.hasMoreTokens()) {
                paragraph.b1(parseFloat, 0.0f);
            } else {
                paragraph.b1(parseFloat, Float.parseFloat(stringTokenizer.nextToken()));
            }
        } catch (Exception unused) {
            paragraph.b1(0.0f, 1.5f);
        }
    }

    public Chunk a(String str, ChainedProperties chainedProperties) {
        float m2;
        Font g2 = g(chainedProperties);
        Chunk chunk = new Chunk(str, g2);
        if (chainedProperties.d("sub")) {
            m2 = -g2.m();
        } else {
            if (chainedProperties.d("sup")) {
                m2 = g2.m();
            }
            chunk.R(i(chainedProperties));
            return chunk;
        }
        chunk.f0(m2 / 2.0f);
        chunk.R(i(chainedProperties));
        return chunk;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.Image b(java.lang.String r2, java.util.Map<java.lang.String, java.lang.String> r3, com.itextpdf.text.html.simpleparser.ChainedProperties r4, com.itextpdf.text.DocListener r5, com.itextpdf.text.html.simpleparser.ImageProvider r6, java.util.HashMap<java.lang.String, com.itextpdf.text.Image> r7, java.lang.String r8) throws com.itextpdf.text.DocumentException, java.io.IOException {
        /*
            r1 = this;
            r0 = 0
            if (r6 == 0) goto L_0x0008
            com.itextpdf.text.Image r5 = r6.a(r2, r3, r4, r5)
            goto L_0x0009
        L_0x0008:
            r5 = r0
        L_0x0009:
            if (r5 != 0) goto L_0x0019
            if (r7 == 0) goto L_0x0019
            java.lang.Object r6 = r7.get(r2)
            com.itextpdf.text.Image r6 = (com.itextpdf.text.Image) r6
            if (r6 == 0) goto L_0x0019
            com.itextpdf.text.Image r5 = com.itextpdf.text.Image.Y0(r6)
        L_0x0019:
            if (r5 == 0) goto L_0x001c
            return r5
        L_0x001c:
            java.lang.String r6 = "http"
            boolean r7 = r2.startsWith(r6)
            if (r7 != 0) goto L_0x0036
            if (r8 == 0) goto L_0x0036
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r8)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            goto L_0x0051
        L_0x0036:
            if (r5 != 0) goto L_0x0051
            boolean r5 = r2.startsWith(r6)
            if (r5 != 0) goto L_0x0051
            java.lang.String r5 = "image_path"
            java.lang.String r5 = r4.c(r5)
            if (r5 != 0) goto L_0x0048
            java.lang.String r5 = ""
        L_0x0048:
            java.io.File r6 = new java.io.File
            r6.<init>(r5, r2)
            java.lang.String r2 = r6.getPath()
        L_0x0051:
            com.itextpdf.text.Image r2 = com.itextpdf.text.Image.b1(r2)
            if (r2 != 0) goto L_0x0058
            return r0
        L_0x0058:
            java.lang.String r5 = "size"
            java.lang.String r5 = r4.c(r5)
            r6 = 1094713344(0x41400000, float:12.0)
            float r5 = com.itextpdf.text.html.HtmlUtilities.g(r5, r6)
            r7 = 0
            int r8 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r8 > 0) goto L_0x006a
            goto L_0x006b
        L_0x006a:
            r6 = r5
        L_0x006b:
            java.lang.String r5 = "width"
            java.lang.Object r5 = r3.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            float r5 = com.itextpdf.text.html.HtmlUtilities.g(r5, r6)
            java.lang.String r8 = "height"
            java.lang.Object r3 = r3.get(r8)
            java.lang.String r3 = (java.lang.String) r3
            float r3 = com.itextpdf.text.html.HtmlUtilities.g(r3, r6)
            int r6 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r6 <= 0) goto L_0x008f
            int r8 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r8 <= 0) goto L_0x008f
        L_0x008b:
            r2.N1(r5, r3)
            goto L_0x00ad
        L_0x008f:
            if (r6 <= 0) goto L_0x009d
            float r3 = r2.N()
            float r3 = r3 * r5
            float r6 = r2.a0()
            float r3 = r3 / r6
            goto L_0x008b
        L_0x009d:
            int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x00ad
            float r5 = r2.a0()
            float r5 = r5 * r3
            float r6 = r2.N()
            float r5 = r5 / r6
            goto L_0x008b
        L_0x00ad:
            java.lang.String r3 = "before"
            java.lang.String r3 = r4.c(r3)
            if (r3 == 0) goto L_0x00bc
            float r3 = java.lang.Float.parseFloat(r3)
            r2.h(r3)
        L_0x00bc:
            java.lang.String r3 = "after"
            java.lang.String r3 = r4.c(r3)
            if (r3 == 0) goto L_0x00cb
            float r3 = java.lang.Float.parseFloat(r3)
            r2.c(r3)
        L_0x00cb:
            r2.t2(r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.html.simpleparser.ElementFactory.b(java.lang.String, java.util.Map, com.itextpdf.text.html.simpleparser.ChainedProperties, com.itextpdf.text.DocListener, com.itextpdf.text.html.simpleparser.ImageProvider, java.util.HashMap, java.lang.String):com.itextpdf.text.Image");
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.itextpdf.text.pdf.draw.LineSeparator c(java.util.Map<java.lang.String, java.lang.String> r10, float r11) {
        /*
            r9 = this;
            java.lang.String r0 = "size"
            java.lang.Object r0 = r10.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r1 = 0
            r2 = 1094713344(0x41400000, float:12.0)
            if (r0 == 0) goto L_0x0017
            float r0 = com.itextpdf.text.html.HtmlUtilities.g(r0, r2)
            int r3 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0017
            r4 = r0
            goto L_0x001b
        L_0x0017:
            r0 = 1065353216(0x3f800000, float:1.0)
            r4 = 1065353216(0x3f800000, float:1.0)
        L_0x001b:
            java.lang.String r0 = "width"
            java.lang.Object r0 = r10.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r3 = 1120403456(0x42c80000, float:100.0)
            if (r0 == 0) goto L_0x003a
            float r2 = com.itextpdf.text.html.HtmlUtilities.g(r0, r2)
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            r2 = 1120403456(0x42c80000, float:100.0)
        L_0x0032:
            java.lang.String r1 = "%"
            boolean r0 = r0.endsWith(r1)
            if (r0 != 0) goto L_0x003d
        L_0x003a:
            r5 = 1120403456(0x42c80000, float:100.0)
            goto L_0x003e
        L_0x003d:
            r5 = r2
        L_0x003e:
            java.lang.String r0 = "align"
            java.lang.Object r10 = r10.get(r0)
            java.lang.String r10 = (java.lang.String) r10
            int r7 = com.itextpdf.text.html.HtmlUtilities.a(r10)
            com.itextpdf.text.pdf.draw.LineSeparator r10 = new com.itextpdf.text.pdf.draw.LineSeparator
            r6 = 0
            r3 = r10
            r8 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.html.simpleparser.ElementFactory.c(java.util.Map, float):com.itextpdf.text.pdf.draw.LineSeparator");
    }

    public List d(String str, ChainedProperties chainedProperties) {
        List list;
        if ("ul".equalsIgnoreCase(str)) {
            list = new List(false);
            list.M("• ");
        } else {
            list = new List(true);
        }
        try {
            list.g(new Float(chainedProperties.c("indent")).floatValue());
        } catch (Exception unused) {
            list.H(true);
        }
        return list;
    }

    public ListItem e(ChainedProperties chainedProperties) {
        ListItem listItem = new ListItem();
        l(listItem, chainedProperties);
        return listItem;
    }

    public Paragraph f(ChainedProperties chainedProperties) {
        Paragraph paragraph = new Paragraph();
        l(paragraph, chainedProperties);
        return paragraph;
    }

    public Font g(ChainedProperties chainedProperties) {
        String str;
        String c2 = chainedProperties.c("face");
        if (c2 == null || c2.trim().length() == 0) {
            c2 = chainedProperties.c("font-family");
        }
        int i2 = 0;
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
            while (stringTokenizer.hasMoreTokens()) {
                str = stringTokenizer.nextToken().trim();
                if (str.startsWith("\"")) {
                    str = str.substring(1);
                }
                if (str.endsWith("\"")) {
                    str = str.substring(0, str.length() - 1);
                }
                if (this.f25766a.b(str)) {
                    break;
                }
            }
        }
        String str2 = str;
        String c3 = chainedProperties.c("encoding");
        if (c3 == null) {
            c3 = "Cp1252";
        }
        String str3 = c3;
        String c4 = chainedProperties.c("size");
        float parseFloat = c4 != null ? Float.parseFloat(c4) : 12.0f;
        String c5 = chainedProperties.c("text-decoration");
        if (!(c5 == null || c5.trim().length() == 0)) {
            if ("underline".equals(c5)) {
                i2 = 4;
            } else if ("line-through".equals(c5)) {
                i2 = 8;
            }
        }
        if (chainedProperties.d("i")) {
            i2 |= 2;
        }
        if (chainedProperties.d("b")) {
            i2 |= 1;
        }
        if (chainedProperties.d("u")) {
            i2 |= 4;
        }
        return this.f25766a.a(str2, str3, true, parseFloat, chainedProperties.d("s") ? i2 | 8 : i2, HtmlUtilities.b(chainedProperties.c("color")));
    }

    public FontProvider h() {
        return this.f25766a;
    }

    public HyphenationEvent i(ChainedProperties chainedProperties) {
        int i2;
        String c2 = chainedProperties.c(HtmlTags.R);
        if (c2 == null || c2.length() == 0) {
            return null;
        }
        int indexOf = c2.indexOf(95);
        int i3 = 2;
        if (indexOf == -1) {
            return new HyphenationAuto(c2, (String) null, 2, 2);
        }
        String substring = c2.substring(0, indexOf);
        String substring2 = c2.substring(indexOf + 1);
        int indexOf2 = substring2.indexOf(44);
        if (indexOf2 == -1) {
            return new HyphenationAuto(substring, substring2, 2, 2);
        }
        String substring3 = substring2.substring(indexOf2 + 1);
        String substring4 = substring2.substring(0, indexOf2);
        int indexOf3 = substring3.indexOf(44);
        if (indexOf3 == -1) {
            i2 = Integer.parseInt(substring3);
        } else {
            i2 = Integer.parseInt(substring3.substring(0, indexOf3));
            i3 = Integer.parseInt(substring3.substring(indexOf3 + 1));
        }
        return new HyphenationAuto(substring, substring4, i2, i3);
    }

    public void j(FontProvider fontProvider) {
        this.f25766a = fontProvider;
    }

    /* access modifiers changed from: protected */
    public void l(Paragraph paragraph, ChainedProperties chainedProperties) {
        paragraph.O1(HtmlUtilities.a(chainedProperties.c("align")));
        paragraph.O0(i(chainedProperties));
        k(paragraph, chainedProperties.c(HtmlTags.U));
        String c2 = chainedProperties.c("after");
        if (c2 != null) {
            try {
                paragraph.h(Float.parseFloat(c2));
            } catch (Exception unused) {
            }
        }
        String c3 = chainedProperties.c("after");
        if (c3 != null) {
            try {
                paragraph.c(Float.parseFloat(c3));
            } catch (Exception unused2) {
            }
        }
        String c4 = chainedProperties.c(HtmlTags.M);
        if (c4 != null) {
            try {
                paragraph.R1(Float.parseFloat(c4));
            } catch (Exception unused3) {
            }
        }
        String c5 = chainedProperties.c("indent");
        if (c5 != null) {
            try {
                paragraph.g(Float.parseFloat(c5));
            } catch (Exception unused4) {
            }
        }
    }
}
