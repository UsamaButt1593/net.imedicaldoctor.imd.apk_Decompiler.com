package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.api.Indentable;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.css.FontSizeTranslator;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import com.itextpdf.tool.xml.html.HTML;
import com.itextpdf.tool.xml.html.pdfelement.NoNewLineParagraph;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.ctx.ObjectContext;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import com.itextpdf.tool.xml.util.ParentTreeUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class AbstractTagProcessor implements TagProcessor, CssAppliersAware {
    private CssAppliers X;
    private Set<String> Y = new HashSet<String>() {
        {
            add("p");
            add("span");
        }
    };
    private List<Tag> Z;
    private final FontSizeTranslator s = FontSizeTranslator.b();

    private String n() {
        String str = null;
        for (Tag next : this.Z) {
            if (!this.Y.contains(next.o().toLowerCase()) && ((str = next.d().get(HTML.Attribute.u)) != null || (str = next.g().get(CSS.Property.K0)) != null)) {
                break;
            }
        }
        return str;
    }

    public boolean a() {
        return false;
    }

    public CssAppliers b() {
        return this.X;
    }

    public final List<Element> c(WorkerContext workerContext, Tag tag) {
        float c2 = this.s.c(tag);
        if (c2 != -1.0f) {
            Map<String, String> g2 = tag.g();
            g2.put("font-size", c2 + CSS.Value.l0);
        }
        String str = tag.g().get(CSS.Property.w0);
        if (str == null || !CSS.Value.q0.equalsIgnoreCase(str)) {
            return r(workerContext, tag);
        }
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(Chunk.c3);
        arrayList.addAll(r(workerContext, tag));
        return arrayList;
    }

    public void d(CssAppliers cssAppliers) {
        this.X = cssAppliers;
    }

    public final List<Element> e(WorkerContext workerContext, Tag tag, List<Element> list) {
        List<Element> arrayList = new ArrayList<>();
        if (list.isEmpty()) {
            arrayList = k(workerContext, tag, list);
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (Element next : list) {
                if (next instanceof Chunk) {
                    Chunk chunk = (Chunk) next;
                    if (chunk.y() && chunk.h().containsKey(Chunk.x3)) {
                        if (arrayList2.size() > 0) {
                            arrayList.addAll(k(workerContext, tag, arrayList2));
                            arrayList2.clear();
                        }
                        arrayList.add(next);
                    }
                }
                arrayList2.add(next);
            }
            if (arrayList2.size() > 0) {
                arrayList.addAll(k(workerContext, tag, arrayList2));
                arrayList2.clear();
            }
        }
        String str = tag.g().get(CSS.Property.y0);
        if (str != null && CSS.Value.q0.equalsIgnoreCase(str)) {
            arrayList.add(Chunk.c3);
        }
        return arrayList;
    }

    public List<Element> f(WorkerContext workerContext, Tag tag, String str) {
        return new ArrayList(0);
    }

    /* access modifiers changed from: protected */
    public Paragraph g() {
        return new Paragraph(Float.NaN);
    }

    public final List<Element> h(List<Element> list, boolean z) {
        return i(list, z, false, (Tag) null, (WorkerContext) null);
    }

    /* JADX WARNING: type inference failed for: r10v9, types: [com.itextpdf.text.Element] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.itextpdf.text.Element> i(java.util.List<com.itextpdf.text.Element> r10, boolean r11, boolean r12, com.itextpdf.tool.xml.Tag r13, com.itextpdf.tool.xml.WorkerContext r14) {
        /*
            r9 = this;
            java.lang.String r0 = "customcontext.404"
            int r1 = r9.o(r13)     // Catch:{ NoCustomContextException -> 0x005a }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ NoCustomContextException -> 0x005a }
            r2.<init>()     // Catch:{ NoCustomContextException -> 0x005a }
            int r3 = r10.size()     // Catch:{ NoCustomContextException -> 0x005a }
            if (r3 <= 0) goto L_0x00bd
            r3 = 3
            r4 = 1067030938(0x3f99999a, float:1.2)
            if (r11 == 0) goto L_0x0083
            com.itextpdf.text.Paragraph r11 = r9.g()     // Catch:{ NoCustomContextException -> 0x005a }
            r11.g1(r4)     // Catch:{ NoCustomContextException -> 0x005a }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ NoCustomContextException -> 0x005a }
        L_0x0022:
            boolean r4 = r10.hasNext()     // Catch:{ NoCustomContextException -> 0x005a }
            if (r4 == 0) goto L_0x0060
            java.lang.Object r4 = r10.next()     // Catch:{ NoCustomContextException -> 0x005a }
            com.itextpdf.text.Element r4 = (com.itextpdf.text.Element) r4     // Catch:{ NoCustomContextException -> 0x005a }
            boolean r5 = r4 instanceof com.itextpdf.text.pdf.draw.LineSeparator     // Catch:{ NoCustomContextException -> 0x005a }
            if (r5 == 0) goto L_0x005c
            com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext r5 = r9.m(r14)     // Catch:{ NoCustomContextException -> 0x004b }
            com.itextpdf.tool.xml.html.CssAppliers r6 = r9.b()     // Catch:{ NoCustomContextException -> 0x004b }
            com.itextpdf.text.Chunk r7 = new com.itextpdf.text.Chunk     // Catch:{ NoCustomContextException -> 0x004b }
            com.itextpdf.text.Chunk r8 = com.itextpdf.text.Chunk.b3     // Catch:{ NoCustomContextException -> 0x004b }
            r7.<init>((com.itextpdf.text.Chunk) r8)     // Catch:{ NoCustomContextException -> 0x004b }
            com.itextpdf.text.Element r5 = r6.b(r7, r13, r5)     // Catch:{ NoCustomContextException -> 0x004b }
            com.itextpdf.text.Chunk r5 = (com.itextpdf.text.Chunk) r5     // Catch:{ NoCustomContextException -> 0x004b }
            r11.add(r5)     // Catch:{ NoCustomContextException -> 0x004b }
            goto L_0x005c
        L_0x004b:
            r10 = move-exception
            com.itextpdf.tool.xml.exceptions.RuntimeWorkerException r11 = new com.itextpdf.tool.xml.exceptions.RuntimeWorkerException     // Catch:{ NoCustomContextException -> 0x005a }
            com.itextpdf.tool.xml.exceptions.LocaleMessages r12 = com.itextpdf.tool.xml.exceptions.LocaleMessages.a()     // Catch:{ NoCustomContextException -> 0x005a }
            java.lang.String r12 = r12.b(r0)     // Catch:{ NoCustomContextException -> 0x005a }
            r11.<init>(r12, r10)     // Catch:{ NoCustomContextException -> 0x005a }
            throw r11     // Catch:{ NoCustomContextException -> 0x005a }
        L_0x005a:
            r10 = move-exception
            goto L_0x00be
        L_0x005c:
            r11.add(r4)     // Catch:{ NoCustomContextException -> 0x005a }
            goto L_0x0022
        L_0x0060:
            boolean r10 = r11.t1()     // Catch:{ NoCustomContextException -> 0x005a }
            if (r10 == 0) goto L_0x00bd
            if (r12 == 0) goto L_0x0077
            com.itextpdf.tool.xml.html.CssAppliers r10 = r9.b()     // Catch:{ NoCustomContextException -> 0x005a }
            com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext r12 = r9.m(r14)     // Catch:{ NoCustomContextException -> 0x005a }
            com.itextpdf.text.Element r10 = r10.b(r11, r13, r12)     // Catch:{ NoCustomContextException -> 0x005a }
            r11 = r10
            com.itextpdf.text.Paragraph r11 = (com.itextpdf.text.Paragraph) r11     // Catch:{ NoCustomContextException -> 0x005a }
        L_0x0077:
            if (r1 != r3) goto L_0x007f
            r9.j(r11)     // Catch:{ NoCustomContextException -> 0x005a }
            r9.p(r11)     // Catch:{ NoCustomContextException -> 0x005a }
        L_0x007f:
            r2.add(r11)     // Catch:{ NoCustomContextException -> 0x005a }
            goto L_0x00bd
        L_0x0083:
            com.itextpdf.tool.xml.html.pdfelement.NoNewLineParagraph r11 = new com.itextpdf.tool.xml.html.pdfelement.NoNewLineParagraph     // Catch:{ NoCustomContextException -> 0x005a }
            r12 = 2143289344(0x7fc00000, float:NaN)
            r11.<init>((float) r12)     // Catch:{ NoCustomContextException -> 0x005a }
            r11.g1(r4)     // Catch:{ NoCustomContextException -> 0x005a }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ NoCustomContextException -> 0x005a }
        L_0x0091:
            boolean r12 = r10.hasNext()     // Catch:{ NoCustomContextException -> 0x005a }
            if (r12 == 0) goto L_0x00a4
            java.lang.Object r12 = r10.next()     // Catch:{ NoCustomContextException -> 0x005a }
            com.itextpdf.text.Element r12 = (com.itextpdf.text.Element) r12     // Catch:{ NoCustomContextException -> 0x005a }
            r9.t(r11, r12)     // Catch:{ NoCustomContextException -> 0x005a }
            r11.add(r12)     // Catch:{ NoCustomContextException -> 0x005a }
            goto L_0x0091
        L_0x00a4:
            com.itextpdf.tool.xml.html.CssAppliers r10 = r9.b()     // Catch:{ NoCustomContextException -> 0x005a }
            com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext r12 = r9.m(r14)     // Catch:{ NoCustomContextException -> 0x005a }
            com.itextpdf.text.Element r10 = r10.b(r11, r13, r12)     // Catch:{ NoCustomContextException -> 0x005a }
            com.itextpdf.tool.xml.html.pdfelement.NoNewLineParagraph r10 = (com.itextpdf.tool.xml.html.pdfelement.NoNewLineParagraph) r10     // Catch:{ NoCustomContextException -> 0x005a }
            if (r1 != r3) goto L_0x00ba
            r9.j(r10)     // Catch:{ NoCustomContextException -> 0x005a }
            r9.q(r10)     // Catch:{ NoCustomContextException -> 0x005a }
        L_0x00ba:
            r2.add(r10)     // Catch:{ NoCustomContextException -> 0x005a }
        L_0x00bd:
            return r2
        L_0x00be:
            com.itextpdf.tool.xml.exceptions.RuntimeWorkerException r11 = new com.itextpdf.tool.xml.exceptions.RuntimeWorkerException
            com.itextpdf.tool.xml.exceptions.LocaleMessages r12 = com.itextpdf.tool.xml.exceptions.LocaleMessages.a()
            java.lang.String r12 = r12.b(r0)
            r11.<init>(r12, r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.tool.xml.html.AbstractTagProcessor.i(java.util.List, boolean, boolean, com.itextpdf.tool.xml.Tag, com.itextpdf.tool.xml.WorkerContext):java.util.List");
    }

    /* access modifiers changed from: protected */
    public void j(Indentable indentable) {
        float q = indentable.q();
        indentable.B(indentable.m());
        indentable.g(q);
    }

    public List<Element> k(WorkerContext workerContext, Tag tag, List<Element> list) {
        return new ArrayList(list);
    }

    public CSSResolver l(WorkerContext workerContext) throws NoCustomContextException {
        return (CSSResolver) ((ObjectContext) workerContext.i(CssResolverPipeline.class.getName())).a();
    }

    public HtmlPipelineContext m(WorkerContext workerContext) throws NoCustomContextException {
        return (HtmlPipelineContext) workerContext.i(HtmlPipeline.class.getName());
    }

    /* access modifiers changed from: protected */
    public int o(Tag tag) {
        boolean z = tag.o() != null && !this.Y.contains(tag.o().toLowerCase());
        String str = z ? tag.d().get(HTML.Attribute.u) : null;
        if (str == null) {
            if (z) {
                str = tag.g().get(CSS.Property.K0);
            }
            if (str == null) {
                this.Z = new ParentTreeUtil().a(tag, this.Z);
                str = n();
            }
        }
        if (CSS.Value.y0.equalsIgnoreCase(str)) {
            return 3;
        }
        if (CSS.Value.z0.equalsIgnoreCase(str)) {
            return 2;
        }
        return "auto".equalsIgnoreCase(str) ? 0 : 1;
    }

    /* access modifiers changed from: protected */
    public void p(Paragraph paragraph) {
        int y1 = paragraph.y1();
        if (y1 != -1 && y1 != 8 && y1 != 1) {
            if (y1 == 2) {
                paragraph.O1(0);
            } else if (y1 != 3) {
                paragraph.O1(2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void q(NoNewLineParagraph noNewLineParagraph) {
        int u1 = noNewLineParagraph.u1();
        if (u1 != -1 && u1 != 8 && u1 != 1) {
            if (u1 == 2) {
                noNewLineParagraph.A1(0);
            } else if (u1 != 3) {
                noNewLineParagraph.A1(2);
            }
        }
    }

    public List<Element> r(WorkerContext workerContext, Tag tag) {
        return new ArrayList(0);
    }

    /* access modifiers changed from: protected */
    public List<Element> s(WorkerContext workerContext, Tag tag, String str) {
        List<Chunk> a2 = HTMLUtils.a(str, false);
        ArrayList arrayList = new ArrayList(1);
        for (Chunk b2 : a2) {
            try {
                arrayList.add(b().b(b2, tag, m(workerContext)));
            } catch (NoCustomContextException e2) {
                throw new RuntimeWorkerException((Throwable) e2);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void t(Phrase phrase, Element element) {
        Font k2 = element instanceof Chunk ? ((Chunk) element).k() : element instanceof Phrase ? ((Phrase) element).q0() : null;
        float m2 = phrase.q0() != null ? phrase.q0().m() : 12.0f;
        if (k2 != null && k2.m() > m2) {
            phrase.M0(k2);
        }
    }
}
