package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import com.itextpdf.tool.xml.html.pdfelement.TabbedChunk;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class ParaGraph extends AbstractTagProcessor {
    private void u(WorkerContext workerContext, Tag tag, List<Element> list, Paragraph paragraph, String str) {
        float f2 = 0.0f;
        for (Element next : list) {
            if (next instanceof TabbedChunk) {
                TabbedChunk tabbedChunk = (TabbedChunk) next;
                f2 += ((float) tabbedChunk.l0()) * CssUtils.g().p(str);
                paragraph.add(new Chunk((Chunk) new TabbedChunk(new VerticalPositionMark(), f2, false)));
                paragraph.add(new Chunk((Chunk) tabbedChunk));
            } else {
                if (next instanceof LineSeparator) {
                    try {
                        paragraph.add((Chunk) b().b(new Chunk(Chunk.b3), tag, m(workerContext)));
                    } catch (NoCustomContextException e2) {
                        throw new RuntimeWorkerException(LocaleMessages.a().b(LocaleMessages.f27573d), e2);
                    }
                }
                paragraph.add(next);
            }
        }
    }

    private void v(List<Element> list, Paragraph paragraph, String str) {
        ArrayList arrayList = new ArrayList();
        String[] split = str.split(StringUtils.SPACE);
        float f2 = 0.0f;
        int i2 = 0;
        for (int i3 = 1; i3 < split.length; i3 += 2) {
            f2 += CssUtils.g().p(split[i3]);
            arrayList.add(new TabbedChunk(new VerticalPositionMark(), f2, true, split[i2]));
            i2 += 2;
        }
        int size = arrayList.size();
        int i4 = 0;
        for (Element next : list) {
            if (next instanceof TabbedChunk) {
                if (i4 == size) {
                    i4 = 0;
                }
                TabbedChunk tabbedChunk = (TabbedChunk) next;
                if (tabbedChunk.l0() != 0) {
                    paragraph.add(new Chunk((Chunk) arrayList.get(i4)));
                    paragraph.add(new Chunk((Chunk) tabbedChunk));
                    i4++;
                }
            } else {
                paragraph.add(next);
            }
        }
    }

    private Tag w(Tag tag) {
        if (tag.k().size() != 0) {
            return tag.k().get(tag.k().size() - 1);
        }
        return null;
    }

    public boolean a() {
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0048, code lost:
        if (w(r7).g().get(com.itextpdf.tool.xml.css.CSS.Property.Z) != null) goto L_0x0074;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.itextpdf.text.Element> f(com.itextpdf.tool.xml.WorkerContext r6, com.itextpdf.tool.xml.Tag r7, java.lang.String r8) {
        /*
            r5 = this;
            r0 = 0
            java.util.List r8 = com.itextpdf.tool.xml.html.HTMLUtils.a(r8, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 1
            r0.<init>(r1)
            java.util.Iterator r8 = r8.iterator()
        L_0x000f:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x009a
            java.lang.Object r1 = r8.next()
            com.itextpdf.text.Chunk r1 = (com.itextpdf.text.Chunk) r1
            com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext r2 = r5.m(r6)     // Catch:{ NoCustomContextException -> 0x0093 }
            java.util.Map r3 = r7.g()
            java.lang.String r4 = "tab-interval"
            java.lang.Object r3 = r3.get(r4)
            java.lang.String r4 = "xfa-tab-count"
            if (r3 == 0) goto L_0x0057
            com.itextpdf.tool.xml.html.pdfelement.TabbedChunk r3 = new com.itextpdf.tool.xml.html.pdfelement.TabbedChunk
            java.lang.String r1 = r1.j()
            r3.<init>(r1)
            com.itextpdf.tool.xml.Tag r1 = r5.w(r7)
            if (r1 == 0) goto L_0x004b
            com.itextpdf.tool.xml.Tag r1 = r5.w(r7)
            java.util.Map r1 = r1.g()
            java.lang.Object r1 = r1.get(r4)
            if (r1 == 0) goto L_0x004b
            goto L_0x0074
        L_0x004b:
            com.itextpdf.tool.xml.html.CssAppliers r1 = r5.b()
            com.itextpdf.text.Element r1 = r1.b(r3, r7, r2)
        L_0x0053:
            r0.add(r1)
            goto L_0x000f
        L_0x0057:
            com.itextpdf.tool.xml.Tag r3 = r5.w(r7)
            if (r3 == 0) goto L_0x008a
            com.itextpdf.tool.xml.Tag r3 = r5.w(r7)
            java.util.Map r3 = r3.g()
            java.lang.Object r3 = r3.get(r4)
            if (r3 == 0) goto L_0x008a
            com.itextpdf.tool.xml.html.pdfelement.TabbedChunk r3 = new com.itextpdf.tool.xml.html.pdfelement.TabbedChunk
            java.lang.String r1 = r1.j()
            r3.<init>(r1)
        L_0x0074:
            com.itextpdf.tool.xml.Tag r1 = r5.w(r7)
            java.util.Map r1 = r1.g()
            java.lang.Object r1 = r1.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            int r1 = java.lang.Integer.parseInt(r1)
            r3.n0(r1)
            goto L_0x004b
        L_0x008a:
            com.itextpdf.tool.xml.html.CssAppliers r3 = r5.b()
            com.itextpdf.text.Element r1 = r3.b(r1, r7, r2)
            goto L_0x0053
        L_0x0093:
            r6 = move-exception
            com.itextpdf.tool.xml.exceptions.RuntimeWorkerException r7 = new com.itextpdf.tool.xml.exceptions.RuntimeWorkerException
            r7.<init>((java.lang.Throwable) r6)
            throw r7
        L_0x009a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.tool.xml.html.ParaGraph.f(com.itextpdf.tool.xml.WorkerContext, com.itextpdf.tool.xml.Tag, java.lang.String):java.util.List");
    }

    public List<Element> k(WorkerContext workerContext, Tag tag, List<Element> list) {
        ArrayList arrayList = new ArrayList(1);
        if (list.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (Element next : list) {
                if (next instanceof ListItem) {
                    if (!arrayList2.isEmpty()) {
                        y(workerContext, tag, arrayList2, arrayList);
                        arrayList2.clear();
                    }
                    arrayList3.add((ListItem) next);
                } else {
                    if (!arrayList3.isEmpty()) {
                        x(workerContext, tag, arrayList3, arrayList);
                        arrayList3.clear();
                    }
                    arrayList2.add(next);
                }
            }
            if (!arrayList2.isEmpty()) {
                y(workerContext, tag, arrayList2, arrayList);
                arrayList2.clear();
            } else if (!arrayList3.isEmpty()) {
                x(workerContext, tag, arrayList3, arrayList);
                arrayList3.clear();
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void x(WorkerContext workerContext, Tag tag, List<ListItem> list, List<Element> list2) {
        try {
            com.itextpdf.text.List list3 = new com.itextpdf.text.List();
            int i2 = 0;
            list3.G(false);
            com.itextpdf.text.List list4 = (com.itextpdf.text.List) b().b(list3, tag, m(workerContext));
            list4.g(0.0f);
            for (ListItem b2 : list) {
                ListItem listItem = (ListItem) b().b(b2, tag, m(workerContext));
                if (i2 != list.size() - 1) {
                    listItem.c(0.0f);
                }
                if (i2 != 0) {
                    listItem.h(0.0f);
                }
                i2++;
                listItem.g1(1.2f);
                list4.b(listItem);
            }
            if (!list2.isEmpty()) {
                Element element = list2.get(list2.size() - 1);
                if (element instanceof Paragraph) {
                    ((Paragraph) element).c(0.0f);
                }
            }
            list2.add(list4);
        } catch (NoCustomContextException e2) {
            throw new RuntimeWorkerException(LocaleMessages.a().b(LocaleMessages.f27573d), e2);
        }
    }

    /* access modifiers changed from: protected */
    public void y(WorkerContext workerContext, Tag tag, List<Element> list, List<Element> list2) {
        Paragraph paragraph = new Paragraph();
        paragraph.g1(1.2f);
        Map<String, String> g2 = tag.g();
        if (g2.get(CSS.Property.Y) != null) {
            u(workerContext, tag, list, paragraph, g2.get(CSS.Property.Y));
        } else {
            String str = CSS.Property.u0;
            if (g2.get(str) == null) {
                str = CSS.Property.v0;
                if (g2.get(str) == null) {
                    List<Element> i2 = i(list, true, true, tag, workerContext);
                    if (!list2.isEmpty() && !i2.isEmpty()) {
                        Element element = i2.get(0);
                        if (element instanceof Paragraph) {
                            ((Paragraph) element).h(0.0f);
                        }
                    }
                    for (Element add : i2) {
                        list2.add(add);
                    }
                    return;
                }
            }
            v(list, paragraph, g2.get(str));
        }
        list2.add(paragraph);
    }
}
