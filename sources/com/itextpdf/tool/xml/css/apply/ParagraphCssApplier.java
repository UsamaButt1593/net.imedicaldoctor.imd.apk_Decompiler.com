package com.itextpdf.tool.xml.css.apply;

import com.itextpdf.text.Paragraph;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.css.FontSizeTranslator;
import com.itextpdf.tool.xml.html.CssApplier;
import com.itextpdf.tool.xml.html.CssAppliers;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import java.util.Map;

public class ParagraphCssApplier implements CssApplier<Paragraph> {

    /* renamed from: a  reason: collision with root package name */
    private final CssAppliers f27536a;

    public ParagraphCssApplier(CssAppliers cssAppliers) {
        this.f27536a = cssAppliers;
    }

    public Paragraph b(Paragraph paragraph, Tag tag, MarginMemory marginMemory) {
        return a(paragraph, tag, marginMemory, (PageSizeContainable) null, (HtmlPipelineContext) null);
    }

    /* renamed from: c */
    public Paragraph a(Paragraph paragraph, Tag tag, MarginMemory marginMemory, PageSizeContainable pageSizeContainable, HtmlPipelineContext htmlPipelineContext) {
        String str;
        float p;
        CssUtils g2 = CssUtils.g();
        float a2 = FontSizeTranslator.b().a(tag);
        float f2 = 0.0f;
        if (a2 == -1.0f) {
            a2 = 0.0f;
        }
        boolean z = false;
        for (Map.Entry next : tag.g().entrySet()) {
            String str2 = (String) next.getKey();
            String str3 = (String) next.getValue();
            if (CSS.Property.o.equalsIgnoreCase(str2)) {
                paragraph.h(paragraph.E() + g2.b(str3, a2, marginMemory));
            } else if (CSS.Property.N.equalsIgnoreCase(str2)) {
                paragraph.h(paragraph.E() + g2.s(str3, a2));
                paragraph.M(g2.s(str3, a2));
            } else if (CSS.Property.p.equalsIgnoreCase(str2)) {
                f2 = g2.s(str3, a2);
                paragraph.c(paragraph.K() + f2);
                z = true;
            } else if (CSS.Property.O.equalsIgnoreCase(str2)) {
                paragraph.c(paragraph.K() + g2.s(str3, a2));
            } else {
                if (!CSS.Property.f27470m.equalsIgnoreCase(str2)) {
                    if (!CSS.Property.f27471n.equalsIgnoreCase(str2)) {
                        if (!"padding-left".equalsIgnoreCase(str2)) {
                            if (!CSS.Property.Q.equalsIgnoreCase(str2)) {
                                if ("text-align".equalsIgnoreCase(str2)) {
                                    paragraph.O1(CSS.a(str3));
                                } else if (CSS.Property.l0.equalsIgnoreCase(str2)) {
                                    paragraph.S1(g2.s(str3, a2));
                                } else if ("line-height".equalsIgnoreCase(str2)) {
                                    if (g2.j(str3)) {
                                        p = Float.parseFloat(str3) * a2;
                                    } else if (g2.k(str3)) {
                                        p = g2.r(str3, a2);
                                    } else if (g2.i(str3)) {
                                        p = g2.p(str3);
                                    }
                                    paragraph.W0(p);
                                }
                            }
                        }
                    }
                    paragraph.B(paragraph.q() + g2.s(str3, a2));
                }
                paragraph.g(paragraph.m() + g2.s(str3, a2));
            }
        }
        if (tag.d().containsKey("align") && (str = tag.d().get("align")) != null) {
            paragraph.O1(CSS.a(str));
        }
        if (z) {
            marginMemory.e(Float.valueOf(f2));
        }
        paragraph.M0(this.f27536a.c().d(tag));
        return paragraph;
    }
}
