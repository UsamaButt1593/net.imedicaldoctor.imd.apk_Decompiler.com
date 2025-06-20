package com.itextpdf.tool.xml.css.apply;

import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.css.FontSizeTranslator;
import com.itextpdf.tool.xml.html.CssApplier;
import com.itextpdf.tool.xml.html.pdfelement.NoNewLineParagraph;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import java.util.Map;

public class NoNewLineParagraphCssApplier implements CssApplier<NoNewLineParagraph> {

    /* renamed from: a  reason: collision with root package name */
    private final CssUtils f27535a = CssUtils.g();

    public NoNewLineParagraph b(NoNewLineParagraph noNewLineParagraph, Tag tag, MarginMemory marginMemory) {
        return a(noNewLineParagraph, tag, marginMemory, (PageSizeContainable) null, (HtmlPipelineContext) null);
    }

    /* renamed from: c */
    public NoNewLineParagraph a(NoNewLineParagraph noNewLineParagraph, Tag tag, MarginMemory marginMemory, PageSizeContainable pageSizeContainable, HtmlPipelineContext htmlPipelineContext) {
        float E;
        float s;
        float a2 = FontSizeTranslator.b().a(tag);
        Map<String, String> g2 = tag.g();
        float f2 = 0.0f;
        boolean z = false;
        for (Map.Entry next : g2.entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) next.getValue();
            if (CSS.Property.o.equalsIgnoreCase(str)) {
                E = noNewLineParagraph.E();
                s = this.f27535a.b(str2, a2, marginMemory);
            } else if (CSS.Property.N.equalsIgnoreCase(str)) {
                E = noNewLineParagraph.E();
                s = this.f27535a.s(str2, a2);
            } else if (CSS.Property.p.equalsIgnoreCase(str)) {
                f2 = this.f27535a.s(str2, a2);
                noNewLineParagraph.c(noNewLineParagraph.K() + f2);
                z = true;
            } else if (CSS.Property.O.equalsIgnoreCase(str)) {
                noNewLineParagraph.c(noNewLineParagraph.K() + this.f27535a.s(str2, a2));
            } else {
                if (!CSS.Property.f27470m.equalsIgnoreCase(str)) {
                    if (!CSS.Property.f27471n.equalsIgnoreCase(str)) {
                        if (!"padding-left".equalsIgnoreCase(str)) {
                            if (!CSS.Property.Q.equalsIgnoreCase(str)) {
                                if ("text-align".equalsIgnoreCase(str)) {
                                    noNewLineParagraph.A1(CSS.a(str2));
                                } else if (CSS.Property.l0.equalsIgnoreCase(str)) {
                                    noNewLineParagraph.H1(this.f27535a.s(str2, a2));
                                }
                            }
                        }
                    }
                    noNewLineParagraph.B(noNewLineParagraph.q() + this.f27535a.s(str2, a2));
                }
                noNewLineParagraph.g(noNewLineParagraph.m() + this.f27535a.s(str2, a2));
            }
            noNewLineParagraph.h(E + s);
        }
        if (tag.r() != null) {
            String o = tag.r().o();
            if (g2.get(CSS.Property.o) == null && marginMemory.a().contains(o)) {
                float E2 = noNewLineParagraph.E();
                CssUtils cssUtils = this.f27535a;
                noNewLineParagraph.h(E2 + cssUtils.b(a2 + CSS.Value.l0, 0.0f, marginMemory));
            }
            if (g2.get(CSS.Property.p) != null || !marginMemory.a().contains(o)) {
                a2 = f2;
            } else {
                noNewLineParagraph.c(noNewLineParagraph.K() + a2);
                g2.put(CSS.Property.p, a2 + CSS.Value.l0);
                z = true;
            }
            if (noNewLineParagraph.u1() == -1) {
                noNewLineParagraph.A1(0);
            }
            f2 = a2;
        }
        if (z) {
            marginMemory.e(Float.valueOf(f2));
        }
        return noNewLineParagraph;
    }
}
