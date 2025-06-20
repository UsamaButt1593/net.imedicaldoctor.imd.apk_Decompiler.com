package com.itextpdf.tool.xml.html;

import com.itextpdf.text.Element;
import com.itextpdf.text.ListItem;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.css.FontSizeTranslator;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderedUnorderedList extends AbstractTagProcessor {
    private static final FontSizeTranslator X2 = FontSizeTranslator.b();
    private static final CssUtils Y2 = CssUtils.g();

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00e9, code lost:
        if (r14 >= r13) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00f2, code lost:
        if (r13 != 0.0f) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f4, code lost:
        r7 = r13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private float u(boolean r10, boolean r11, com.itextpdf.tool.xml.Tag r12, com.itextpdf.tool.xml.Tag r13, com.itextpdf.tool.xml.WorkerContext r14) {
        /*
            r9 = this;
            java.lang.String r0 = "padding"
            java.lang.String r1 = "margin"
            com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext r2 = r9.m(r14)     // Catch:{ NoCustomContextException -> 0x000d }
            if (r10 == 0) goto L_0x0010
            java.lang.String r3 = "-top"
            goto L_0x0012
        L_0x000d:
            r10 = move-exception
            goto L_0x0116
        L_0x0010:
            java.lang.String r3 = "-bottom"
        L_0x0012:
            com.itextpdf.tool.xml.css.FontSizeTranslator r4 = X2     // Catch:{ NoCustomContextException -> 0x000d }
            float r5 = r4.a(r12)     // Catch:{ NoCustomContextException -> 0x000d }
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r7 = 0
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 != 0) goto L_0x0020
            r5 = 0
        L_0x0020:
            java.util.Map r6 = r12.g()     // Catch:{ NoCustomContextException -> 0x000d }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ NoCustomContextException -> 0x000d }
            r8.<init>()     // Catch:{ NoCustomContextException -> 0x000d }
            r8.append(r1)     // Catch:{ NoCustomContextException -> 0x000d }
            r8.append(r3)     // Catch:{ NoCustomContextException -> 0x000d }
            java.lang.String r8 = r8.toString()     // Catch:{ NoCustomContextException -> 0x000d }
            java.lang.Object r6 = r6.get(r8)     // Catch:{ NoCustomContextException -> 0x000d }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ NoCustomContextException -> 0x000d }
            if (r6 != 0) goto L_0x005b
            com.itextpdf.tool.xml.Tag r6 = r12.r()     // Catch:{ NoCustomContextException -> 0x000d }
            if (r6 == 0) goto L_0x0059
            com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext r14 = r9.m(r14)     // Catch:{ NoCustomContextException -> 0x000d }
            java.util.List r14 = r14.a()     // Catch:{ NoCustomContextException -> 0x000d }
            com.itextpdf.tool.xml.Tag r6 = r12.r()     // Catch:{ NoCustomContextException -> 0x000d }
            java.lang.String r6 = r6.o()     // Catch:{ NoCustomContextException -> 0x000d }
            boolean r14 = r14.contains(r6)     // Catch:{ NoCustomContextException -> 0x000d }
            if (r14 == 0) goto L_0x0059
            r14 = r5
            goto L_0x0061
        L_0x0059:
            r14 = 0
            goto L_0x0061
        L_0x005b:
            com.itextpdf.tool.xml.css.CssUtils r14 = Y2     // Catch:{ NoCustomContextException -> 0x000d }
            float r14 = r14.s(r6, r5)     // Catch:{ NoCustomContextException -> 0x000d }
        L_0x0061:
            java.util.Map r6 = r12.g()     // Catch:{ NoCustomContextException -> 0x000d }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ NoCustomContextException -> 0x000d }
            r8.<init>()     // Catch:{ NoCustomContextException -> 0x000d }
            r8.append(r0)     // Catch:{ NoCustomContextException -> 0x000d }
            r8.append(r3)     // Catch:{ NoCustomContextException -> 0x000d }
            java.lang.String r8 = r8.toString()     // Catch:{ NoCustomContextException -> 0x000d }
            java.lang.Object r6 = r6.get(r8)     // Catch:{ NoCustomContextException -> 0x000d }
            if (r6 == 0) goto L_0x009a
            com.itextpdf.tool.xml.css.CssUtils r6 = Y2     // Catch:{ NoCustomContextException -> 0x000d }
            java.util.Map r12 = r12.g()     // Catch:{ NoCustomContextException -> 0x000d }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ NoCustomContextException -> 0x000d }
            r8.<init>()     // Catch:{ NoCustomContextException -> 0x000d }
            r8.append(r0)     // Catch:{ NoCustomContextException -> 0x000d }
            r8.append(r3)     // Catch:{ NoCustomContextException -> 0x000d }
            java.lang.String r0 = r8.toString()     // Catch:{ NoCustomContextException -> 0x000d }
            java.lang.Object r12 = r12.get(r0)     // Catch:{ NoCustomContextException -> 0x000d }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ NoCustomContextException -> 0x000d }
            float r12 = r6.s(r12, r5)     // Catch:{ NoCustomContextException -> 0x000d }
            goto L_0x009b
        L_0x009a:
            r12 = 0
        L_0x009b:
            float r0 = r4.a(r13)     // Catch:{ NoCustomContextException -> 0x000d }
            java.util.Map r4 = r13.g()     // Catch:{ NoCustomContextException -> 0x000d }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ NoCustomContextException -> 0x000d }
            r5.<init>()     // Catch:{ NoCustomContextException -> 0x000d }
            r5.append(r1)     // Catch:{ NoCustomContextException -> 0x000d }
            r5.append(r3)     // Catch:{ NoCustomContextException -> 0x000d }
            java.lang.String r5 = r5.toString()     // Catch:{ NoCustomContextException -> 0x000d }
            java.lang.Object r4 = r4.get(r5)     // Catch:{ NoCustomContextException -> 0x000d }
            if (r4 == 0) goto L_0x00d8
            com.itextpdf.tool.xml.css.CssUtils r4 = Y2     // Catch:{ NoCustomContextException -> 0x000d }
            java.util.Map r13 = r13.g()     // Catch:{ NoCustomContextException -> 0x000d }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ NoCustomContextException -> 0x000d }
            r5.<init>()     // Catch:{ NoCustomContextException -> 0x000d }
            r5.append(r1)     // Catch:{ NoCustomContextException -> 0x000d }
            r5.append(r3)     // Catch:{ NoCustomContextException -> 0x000d }
            java.lang.String r1 = r5.toString()     // Catch:{ NoCustomContextException -> 0x000d }
            java.lang.Object r13 = r13.get(r1)     // Catch:{ NoCustomContextException -> 0x000d }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ NoCustomContextException -> 0x000d }
            float r13 = r4.s(r13, r0)     // Catch:{ NoCustomContextException -> 0x000d }
            goto L_0x00d9
        L_0x00d8:
            r13 = 0
        L_0x00d9:
            java.lang.String r0 = "lastMarginBottom"
            int r1 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r1 != 0) goto L_0x0105
            int r12 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r12 == 0) goto L_0x00ec
            int r1 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x00ec
            int r12 = (r14 > r13 ? 1 : (r14 == r13 ? 0 : -1))
            if (r12 < 0) goto L_0x00f4
            goto L_0x00ee
        L_0x00ec:
            if (r12 == 0) goto L_0x00f0
        L_0x00ee:
            r7 = r14
            goto L_0x00f5
        L_0x00f0:
            int r12 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r12 == 0) goto L_0x00f5
        L_0x00f4:
            r7 = r13
        L_0x00f5:
            if (r10 != 0) goto L_0x0115
            if (r11 == 0) goto L_0x0115
            java.util.Map r10 = r2.r()     // Catch:{ NoCustomContextException -> 0x000d }
            java.lang.Float r11 = java.lang.Float.valueOf(r7)     // Catch:{ NoCustomContextException -> 0x000d }
        L_0x0101:
            r10.put(r0, r11)     // Catch:{ NoCustomContextException -> 0x000d }
            goto L_0x0115
        L_0x0105:
            float r12 = r12 + r14
            float r7 = r12 + r13
            if (r10 != 0) goto L_0x0115
            if (r11 == 0) goto L_0x0115
            java.util.Map r10 = r2.r()     // Catch:{ NoCustomContextException -> 0x000d }
            java.lang.Float r11 = java.lang.Float.valueOf(r14)     // Catch:{ NoCustomContextException -> 0x000d }
            goto L_0x0101
        L_0x0115:
            return r7
        L_0x0116:
            com.itextpdf.tool.xml.exceptions.RuntimeWorkerException r11 = new com.itextpdf.tool.xml.exceptions.RuntimeWorkerException
            com.itextpdf.tool.xml.exceptions.LocaleMessages r12 = com.itextpdf.tool.xml.exceptions.LocaleMessages.a()
            java.lang.String r13 = "customcontext.404"
            java.lang.String r12 = r12.b(r13)
            r11.<init>(r12, r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.tool.xml.html.OrderedUnorderedList.u(boolean, boolean, com.itextpdf.tool.xml.Tag, com.itextpdf.tool.xml.Tag, com.itextpdf.tool.xml.WorkerContext):float");
    }

    private List<Element> v(List<Element> list) {
        ArrayList arrayList = new ArrayList();
        for (Element next : list) {
            if ((next instanceof ListItem) || (next instanceof com.itextpdf.text.List)) {
                arrayList.add(next);
            } else {
                ListItem listItem = new ListItem();
                listItem.add(next);
                arrayList.add(listItem);
            }
        }
        return arrayList;
    }

    public boolean a() {
        return true;
    }

    public List<Element> k(WorkerContext workerContext, Tag tag, List<Element> list) {
        com.itextpdf.text.List list2;
        String str;
        Tag tag2 = tag;
        List<Element> v = v(list);
        int size = v.size();
        ArrayList arrayList = new ArrayList();
        if (size > 0) {
            try {
                list2 = (com.itextpdf.text.List) b().b(new com.itextpdf.text.List(), tag2, m(workerContext));
            } catch (NoCustomContextException unused) {
                list2 = (com.itextpdf.text.List) b().b(new com.itextpdf.text.List(), tag2, (HtmlPipelineContext) null);
            }
            com.itextpdf.text.List list3 = list2;
            int i2 = 0;
            for (Element next : v) {
                if (next instanceof ListItem) {
                    Tag tag3 = tag.k().get(i2);
                    if (size == 1) {
                        Map<String, String> g2 = tag3.g();
                        Tag tag4 = tag;
                        String str2 = CSS.Value.l0;
                        Tag tag5 = tag3;
                        Object obj = CSS.Property.o;
                        StringBuilder sb = new StringBuilder();
                        sb.append(u(true, false, tag4, tag5, workerContext));
                        String str3 = str2;
                        sb.append(str3);
                        g2.put(obj, sb.toString());
                        float u = u(false, false, tag4, tag5, workerContext);
                        Map<String, String> g3 = tag3.g();
                        g3.put(CSS.Property.p, u + str3);
                    } else {
                        Object obj2 = CSS.Property.o;
                        String str4 = CSS.Value.l0;
                        if (i2 == 0) {
                            Map<String, String> g4 = tag3.g();
                            str = str4;
                            g4.put(obj2, u(true, false, tag, tag3, workerContext) + str);
                        } else {
                            str = str4;
                        }
                        if (i2 == size - 1) {
                            float u2 = u(false, true, tag, tag3, workerContext);
                            Map<String, String> g5 = tag3.g();
                            g5.put(CSS.Property.p, u2 + str);
                        }
                    }
                    try {
                        list3.b(b().b(next, tag3, m(workerContext)));
                    } catch (NoCustomContextException e2) {
                        throw new RuntimeWorkerException(LocaleMessages.a().b(LocaleMessages.f27573d), e2);
                    }
                } else {
                    list3.b(next);
                }
                i2++;
                Tag tag6 = tag;
            }
            arrayList.add(list3);
        }
        return arrayList;
    }
}
