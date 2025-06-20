package com.itextpdf.tool.xml.html.table;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.html.HtmlUtilities;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.PdfDiv;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.tool.xml.NoCustomContextException;
import com.itextpdf.tool.xml.Tag;
import com.itextpdf.tool.xml.WorkerContext;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.css.CssUtils;
import com.itextpdf.tool.xml.css.FontSizeTranslator;
import com.itextpdf.tool.xml.css.WidthCalculator;
import com.itextpdf.tool.xml.html.AbstractTagProcessor;
import com.itextpdf.tool.xml.html.HTML;
import com.itextpdf.tool.xml.html.pdfelement.HtmlCell;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class Table extends AbstractTagProcessor {
    public static final float X2 = 0.75f;
    private static final Logger Y2 = LoggerFactory.b(Table.class);
    private static final CssUtils Z2 = CssUtils.g();
    private static final FontSizeTranslator a3 = FontSizeTranslator.b();

    private final class NormalRowComparator implements Comparator<TableRowElement> {
        private NormalRowComparator() {
        }

        /* renamed from: a */
        public int compare(TableRowElement tableRowElement, TableRowElement tableRowElement2) {
            return tableRowElement.c().a().compareTo(tableRowElement2.c().a());
        }
    }

    private final class RepeatedRowComparator implements Comparator<TableRowElement> {
        private RepeatedRowComparator() {
        }

        /* renamed from: a */
        public int compare(TableRowElement tableRowElement, TableRowElement tableRowElement2) {
            return tableRowElement.c().b().compareTo(tableRowElement2.c().b());
        }
    }

    public static TableStyleValues B(Tag tag) {
        TableStyleValues tableStyleValues = new TableStyleValues();
        if (tag == null) {
            return tableStyleValues;
        }
        Map<String, String> d2 = tag.d();
        Map<String, String> g2 = tag.g();
        String str = d2.get("border");
        if (str != null && (str.trim().length() == 0 || Z2.p(d2.get("border")) > 0.0f)) {
            tableStyleValues.r(BaseColor.f25677f);
            tableStyleValues.w(0.75f);
        }
        tableStyleValues.B(w(true, g2, d2));
        tableStyleValues.D(w(false, g2, d2));
        return tableStyleValues;
    }

    private float[] C(HtmlCell htmlCell) {
        Iterator<Element> it2;
        float floatValue;
        Iterator<Element> it3;
        int i2 = 1;
        ArrayList<Float> arrayList = new ArrayList<>();
        float x = x(htmlCell);
        List<Element> L0 = htmlCell.L0();
        float f2 = 0.0f;
        if (L0 != null) {
            Iterator<Element> it4 = L0.iterator();
            while (it4.hasNext()) {
                Element next = it4.next();
                if (next instanceof Phrase) {
                    float f3 = Float.NaN;
                    int i3 = 0;
                    while (true) {
                        Phrase phrase = (Phrase) next;
                        if (i3 >= phrase.size()) {
                            break;
                        }
                        Element element = (Element) phrase.get(i3);
                        if (element instanceof Chunk) {
                            if (Float.isNaN(f3)) {
                                f3 = x + 0.001f;
                            }
                            Chunk chunk = (Chunk) element;
                            f3 += chunk.u();
                            float g2 = x + 0.001f + b().c().g(chunk);
                            if (g2 > f2) {
                                f2 = g2;
                            }
                        }
                        i3 += i2;
                    }
                    if (!Float.isNaN(f3)) {
                        arrayList.add(Float.valueOf(f3));
                    }
                } else if (next instanceof com.itextpdf.text.List) {
                    Iterator<Element> it5 = ((com.itextpdf.text.List) next).h().iterator();
                    while (it5.hasNext()) {
                        Element next2 = it5.next();
                        float f4 = x + 0.001f;
                        float m2 = ((ListItem) next2).m() + f4;
                        for (Chunk next3 : next2.Y()) {
                            m2 += next3.u();
                            float g3 = b().c().g(next3) + f4;
                            if (g3 > f2) {
                                f2 = g3;
                            }
                        }
                        arrayList.add(Float.valueOf(m2));
                    }
                } else {
                    if (next instanceof PdfPTable) {
                        PdfPTable pdfPTable = (PdfPTable) next;
                        floatValue = 0.001f + x + pdfPTable.m0();
                        Iterator<PdfPRow> it6 = pdfPTable.e0().iterator();
                        while (it6.hasNext()) {
                            PdfPRow next4 = it6.next();
                            int length = next4.c().length;
                            TableStyleValues d2 = ((TableBorderEvent) pdfPTable.j0()).d();
                            float h2 = d2.h() + (((float) (length + 1)) * d2.n()) + d2.j();
                            PdfPCell[] c2 = next4.c();
                            int length2 = c2.length;
                            int i4 = 0;
                            int i5 = 0;
                            while (i4 < length2) {
                                PdfPCell pdfPCell = c2[i4];
                                i5 += i2;
                                if (pdfPCell != null) {
                                    it3 = it4;
                                    i2 = 1;
                                    h2 += C(new HtmlCell(pdfPCell, i5 == length))[1];
                                } else {
                                    it3 = it4;
                                }
                                i4 += i2;
                                it4 = it3;
                            }
                            Iterator<Element> it7 = it4;
                            if (h2 > f2) {
                                f2 = h2;
                            }
                            it4 = it7;
                            i2 = 1;
                        }
                        it2 = it4;
                    } else {
                        it2 = it4;
                        if (next instanceof PdfDiv) {
                            PdfDiv pdfDiv = (PdfDiv) next;
                            floatValue = 0.001f + x + (pdfDiv.N() != null ? pdfDiv.N().floatValue() : u(pdfDiv.k()));
                        } else {
                            it4 = it2;
                            i2 = 1;
                        }
                    }
                    arrayList.add(Float.valueOf(floatValue));
                    it4 = it2;
                    i2 = 1;
                }
                it2 = it4;
                it4 = it2;
                i2 = 1;
            }
        }
        for (Float f5 : arrayList) {
            if (f5.floatValue() > x) {
                x = f5.floatValue();
            }
        }
        return new float[]{x, f2};
    }

    public static TableStyleValues D(Tag tag) {
        TableStyleValues tableStyleValues = new TableStyleValues();
        Map<String, String> g2 = tag.g();
        Map<String, String> d2 = tag.d();
        if (d2.containsKey("border")) {
            tableStyleValues.r(BaseColor.f25677f);
            String str = d2.get("border");
            if ("".equals(str)) {
                tableStyleValues.w(0.75f);
            } else {
                tableStyleValues.w(Z2.p(str));
            }
        } else {
            for (Map.Entry next : g2.entrySet()) {
                String str2 = (String) next.getKey();
                String str3 = (String) next.getValue();
                if (str2.equalsIgnoreCase(CSS.Property.K) && CSS.Value.f27479h.equalsIgnoreCase(str3)) {
                    tableStyleValues.t(BaseColor.f25677f);
                    tableStyleValues.y(0.75f);
                } else if (str2.equalsIgnoreCase(CSS.Property.L) && CSS.Value.f27479h.equalsIgnoreCase(str3)) {
                    tableStyleValues.u(BaseColor.f25677f);
                    tableStyleValues.z(0.75f);
                } else if (str2.equalsIgnoreCase(CSS.Property.I) && CSS.Value.f27479h.equalsIgnoreCase(str3)) {
                    tableStyleValues.v(BaseColor.f25677f);
                    tableStyleValues.A(0.75f);
                } else if (str2.equalsIgnoreCase(CSS.Property.J) && CSS.Value.f27479h.equalsIgnoreCase(str3)) {
                    tableStyleValues.s(BaseColor.f25677f);
                    tableStyleValues.x(0.75f);
                }
            }
            String str4 = g2.get(CSS.Property.F);
            if (str4 != null) {
                tableStyleValues.s(HtmlUtilities.b(str4));
            }
            String str5 = g2.get(CSS.Property.E);
            if (str5 != null) {
                tableStyleValues.v(HtmlUtilities.b(str5));
            }
            String str6 = g2.get(CSS.Property.G);
            if (str6 != null) {
                tableStyleValues.t(HtmlUtilities.b(str6));
            }
            String str7 = g2.get(CSS.Property.H);
            if (str7 != null) {
                tableStyleValues.u(HtmlUtilities.b(str7));
            }
            CssUtils cssUtils = Z2;
            Float d3 = cssUtils.d(g2, CSS.Property.B);
            if (d3 != null) {
                tableStyleValues.x(d3.floatValue());
            }
            Float d4 = cssUtils.d(g2, CSS.Property.A);
            if (d4 != null) {
                tableStyleValues.A(d4.floatValue());
            }
            Float d5 = cssUtils.d(g2, CSS.Property.D);
            if (d5 != null) {
                tableStyleValues.z(d5.floatValue());
            }
            Float d6 = cssUtils.d(g2, CSS.Property.C);
            if (d6 != null) {
                tableStyleValues.y(d6.floatValue());
            }
        }
        tableStyleValues.q(HtmlUtilities.b(g2.get(CSS.Property.f27463f)));
        tableStyleValues.B(w(true, g2, d2));
        tableStyleValues.D(w(false, g2, d2));
        return tableStyleValues;
    }

    private void E(PdfPTable pdfPTable, Tag tag, TableStyleValues tableStyleValues, WorkerContext workerContext) throws NoCustomContextException {
        float l2 = tableStyleValues.l();
        float o = tableStyleValues.o() + tableStyleValues.f();
        for (Map.Entry next : tag.g().entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) next.getValue();
            if (CSS.Property.o.equalsIgnoreCase(str)) {
                l2 += CssUtils.g().b(str2, a3.a(tag), m(workerContext));
            } else if (CSS.Property.p.equalsIgnoreCase(str)) {
                float s = Z2.s(str2, a3.a(tag));
                o += s;
                m(workerContext).r().put(HtmlPipelineContext.h3, Float.valueOf(s));
            } else if (CSS.Property.N.equalsIgnoreCase(str)) {
                pdfPTable.M(Z2.s(str2, a3.a(tag)));
            }
        }
        pdfPTable.h(l2);
        pdfPTable.c(o);
    }

    private void F(List<TableRowElement> list, float f2) {
        for (TableRowElement a2 : list) {
            List<HtmlCell> a4 = a2.a();
            if (a4.size() >= 1) {
                HtmlCell htmlCell = a4.get(a4.size() - 1);
                htmlCell.V1().C(true);
                htmlCell.K1(htmlCell.d1() + f2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0037 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private float u(java.util.ArrayList<com.itextpdf.text.Element> r9) {
        /*
            r8 = this;
            java.util.Iterator r9 = r9.iterator()
            r0 = 0
            r1 = 0
        L_0x0006:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L_0x008d
            java.lang.Object r2 = r9.next()
            com.itextpdf.text.Element r2 = (com.itextpdf.text.Element) r2
            boolean r3 = r2 instanceof com.itextpdf.text.pdf.PdfDiv
            if (r3 == 0) goto L_0x0021
            com.itextpdf.text.pdf.PdfDiv r2 = (com.itextpdf.text.pdf.PdfDiv) r2
            java.util.ArrayList r2 = r2.k()
            float r2 = r8.u(r2)
            goto L_0x0086
        L_0x0021:
            boolean r3 = r2 instanceof com.itextpdf.text.pdf.PdfPTable
            if (r3 == 0) goto L_0x002c
            com.itextpdf.text.pdf.PdfPTable r2 = (com.itextpdf.text.pdf.PdfPTable) r2
            float r2 = r2.m0()
            goto L_0x0086
        L_0x002c:
            boolean r3 = r2 instanceof com.itextpdf.text.Paragraph
            if (r3 == 0) goto L_0x0085
            com.itextpdf.text.Paragraph r2 = (com.itextpdf.text.Paragraph) r2
            java.util.Iterator r2 = r2.iterator()
            r3 = 0
        L_0x0037:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0083
            java.lang.Object r4 = r2.next()
            com.itextpdf.text.Element r4 = (com.itextpdf.text.Element) r4
            boolean r5 = r4 instanceof com.itextpdf.text.Chunk
            if (r5 == 0) goto L_0x007c
            com.itextpdf.text.Chunk r4 = (com.itextpdf.text.Chunk) r4
            java.util.HashMap r5 = r4.h()
            if (r5 == 0) goto L_0x006f
            java.lang.String r6 = "IMAGE"
            boolean r7 = r5.containsKey(r6)
            if (r7 == 0) goto L_0x006f
            java.lang.Object r4 = r5.get(r6)
            boolean r5 = r4 instanceof java.lang.Object[]
            if (r5 == 0) goto L_0x007c
            java.lang.Object[] r4 = (java.lang.Object[]) r4
            r5 = 0
            r4 = r4[r5]
            boolean r5 = r4 instanceof com.itextpdf.text.Image
            if (r5 == 0) goto L_0x007c
            com.itextpdf.text.Image r4 = (com.itextpdf.text.Image) r4
            float r4 = r4.a0()
            goto L_0x007d
        L_0x006f:
            com.itextpdf.tool.xml.html.CssAppliers r5 = r8.b()
            com.itextpdf.tool.xml.css.apply.ChunkCssApplier r5 = r5.c()
            float r4 = r5.g(r4)
            goto L_0x007d
        L_0x007c:
            r4 = 0
        L_0x007d:
            int r5 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0037
            r3 = r4
            goto L_0x0037
        L_0x0083:
            r2 = r3
            goto L_0x0086
        L_0x0085:
            r2 = 0
        L_0x0086:
            int r3 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0006
            r1 = r2
            goto L_0x0006
        L_0x008d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.tool.xml.html.table.Table.u(java.util.ArrayList):float");
    }

    private float v(Tag tag, float[] fArr, float f2, WorkerContext workerContext) throws NoCustomContextException {
        HtmlPipelineContext m2 = m(workerContext);
        float a0 = m2.getPageSize().a0() - f2;
        float z = z(fArr, 0.0f);
        if (tag.d().get("width") != null || tag.g().get("width") != null) {
            float a2 = new WidthCalculator().a(tag, m2.a(), m2.getPageSize().a0());
            return a2 > a0 ? a0 : a2;
        } else if (z <= a0) {
            return z;
        } else {
            if (tag.r() != null) {
                return (tag.r() == null || !m2.a().contains(tag.r().o())) ? z(fArr, f2) : a0;
            }
            return a0;
        }
    }

    public static float w(boolean z, Map<String, String> map, Map<String, String> map2) {
        CssUtils cssUtils;
        String str = map.get(CSS.Property.y);
        if (str == null || str.equals(CSS.Value.w0)) {
            String str2 = map.get(CSS.Property.z);
            String str3 = map2.get(HTML.Attribute.f27592c);
            if (str2 != null) {
                if (!str2.contains(StringUtils.SPACE)) {
                    cssUtils = Z2;
                } else if (z) {
                    cssUtils = Z2;
                    str2 = str2.split(StringUtils.SPACE)[0];
                } else {
                    cssUtils = Z2;
                    str2 = str2.split(StringUtils.SPACE)[1];
                }
                return cssUtils.p(str2);
            } else if (str3 != null) {
                return Z2.p(str3);
            } else {
                return 1.5f;
            }
        } else {
            str.equals(CSS.Value.x0);
            return 0.0f;
        }
    }

    private float x(HtmlCell htmlCell) {
        return (((float) (htmlCell.J0() - 1)) * htmlCell.V1().n()) + htmlCell.c1() + htmlCell.d1();
    }

    private float y(Tag tag, float f2, WorkerContext workerContext) throws NoCustomContextException {
        CssUtils cssUtils = Z2;
        float h2 = cssUtils.h(tag, m(workerContext).getPageSize().a0()) + cssUtils.c(tag, CSS.Property.C) + cssUtils.c(tag, CSS.Property.D) + f2;
        Tag r = tag.r();
        return r != null ? h2 + cssUtils.h(r, m(workerContext).getPageSize().a0()) : h2;
    }

    private float z(float[] fArr, float f2) throws NoCustomContextException {
        float f3 = 0.0f;
        for (float f4 : fArr) {
            f3 += f4;
        }
        return f3 + f2;
    }

    /* access modifiers changed from: protected */
    public PdfPTable A(int i2) {
        PdfPTable pdfPTable = new PdfPTable(i2);
        pdfPTable.M0(0);
        pdfPTable.T0(false);
        return pdfPTable;
    }

    public boolean a() {
        return true;
    }

    /* JADX WARNING: type inference failed for: r17v0, types: [boolean] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0308 A[Catch:{ NoCustomContextException -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x031a A[Catch:{ NoCustomContextException -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0340 A[Catch:{ NoCustomContextException -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0392 A[Catch:{ NoCustomContextException -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0393 A[Catch:{ NoCustomContextException -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x03a0 A[Catch:{ NoCustomContextException -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x03cb A[Catch:{ NoCustomContextException -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x0448 A[Catch:{ NoCustomContextException -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x04a9 A[Catch:{ NoCustomContextException -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x04b8 A[Catch:{ NoCustomContextException -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x04c4 A[Catch:{ NoCustomContextException -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x05c5 A[Catch:{ NoCustomContextException -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x05df A[Catch:{ NoCustomContextException -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x011c A[Catch:{ NoCustomContextException -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0146 A[Catch:{ NoCustomContextException -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x019f A[Catch:{ NoCustomContextException -> 0x009f }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.itextpdf.text.Element> k(com.itextpdf.tool.xml.WorkerContext r37, com.itextpdf.tool.xml.Tag r38, java.util.List<com.itextpdf.text.Element> r39) {
        /*
            r36 = this;
            r1 = r36
            r0 = r37
            r2 = r38
            r4 = 1
            java.lang.String r5 = "customcontext.404"
            java.lang.String r6 = "align"
            java.lang.String r7 = "width"
            java.util.Map r8 = r38.g()     // Catch:{ NoCustomContextException -> 0x0024 }
            java.lang.Object r8 = r8.get(r7)     // Catch:{ NoCustomContextException -> 0x0024 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ NoCustomContextException -> 0x0024 }
            if (r8 != 0) goto L_0x0028
            java.util.Map r8 = r38.d()     // Catch:{ NoCustomContextException -> 0x0024 }
            java.lang.Object r8 = r8.get(r7)     // Catch:{ NoCustomContextException -> 0x0024 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ NoCustomContextException -> 0x0024 }
            goto L_0x0028
        L_0x0024:
            r0 = move-exception
            r4 = r5
            goto L_0x0648
        L_0x0028:
            if (r8 == 0) goto L_0x0038
            java.lang.String r9 = r8.trim()     // Catch:{ NoCustomContextException -> 0x0024 }
            java.lang.String r10 = "%"
            boolean r9 = r9.endsWith(r10)     // Catch:{ NoCustomContextException -> 0x0024 }
            if (r9 == 0) goto L_0x0038
            r9 = 1
            goto L_0x0039
        L_0x0038:
            r9 = 0
        L_0x0039:
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ NoCustomContextException -> 0x0024 }
            int r11 = r39.size()     // Catch:{ NoCustomContextException -> 0x0024 }
            r10.<init>(r11)     // Catch:{ NoCustomContextException -> 0x0024 }
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ NoCustomContextException -> 0x0024 }
            r11.<init>(r4)     // Catch:{ NoCustomContextException -> 0x0024 }
            java.util.Map r12 = r38.g()     // Catch:{ NoCustomContextException -> 0x0024 }
            java.lang.String r13 = "repeat-header"
            java.lang.Object r12 = r12.get(r13)     // Catch:{ NoCustomContextException -> 0x0024 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ NoCustomContextException -> 0x0024 }
            java.util.Map r13 = r38.g()     // Catch:{ NoCustomContextException -> 0x0024 }
            java.lang.String r14 = "repeat-footer"
            java.lang.Object r13 = r13.get(r14)     // Catch:{ NoCustomContextException -> 0x0024 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ NoCustomContextException -> 0x0024 }
            java.util.Iterator r14 = r39.iterator()     // Catch:{ NoCustomContextException -> 0x0024 }
            r3 = 0
            r15 = 0
            r16 = 0
        L_0x0067:
            boolean r17 = r14.hasNext()     // Catch:{ NoCustomContextException -> 0x0024 }
            java.lang.String r4 = "yes"
            if (r17 == 0) goto L_0x00e9
            java.lang.Object r17 = r14.next()     // Catch:{ NoCustomContextException -> 0x00e5 }
            r39 = r14
            r14 = r17
            com.itextpdf.text.Element r14 = (com.itextpdf.text.Element) r14     // Catch:{ NoCustomContextException -> 0x00e5 }
            r17 = r5
            boolean r5 = r14 instanceof com.itextpdf.tool.xml.html.table.TableRowElement     // Catch:{ NoCustomContextException -> 0x009f }
            if (r5 == 0) goto L_0x00d8
            com.itextpdf.tool.xml.html.table.TableRowElement r14 = (com.itextpdf.tool.xml.html.table.TableRowElement) r14     // Catch:{ NoCustomContextException -> 0x009f }
            java.util.List r5 = r14.a()     // Catch:{ NoCustomContextException -> 0x009f }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ NoCustomContextException -> 0x009f }
            r19 = r8
            r8 = 0
        L_0x008c:
            boolean r20 = r5.hasNext()     // Catch:{ NoCustomContextException -> 0x009f }
            if (r20 == 0) goto L_0x00a4
            java.lang.Object r20 = r5.next()     // Catch:{ NoCustomContextException -> 0x009f }
            com.itextpdf.tool.xml.html.pdfelement.HtmlCell r20 = (com.itextpdf.tool.xml.html.pdfelement.HtmlCell) r20     // Catch:{ NoCustomContextException -> 0x009f }
            int r20 = r20.J0()     // Catch:{ NoCustomContextException -> 0x009f }
            int r8 = r8 + r20
            goto L_0x008c
        L_0x009f:
            r0 = move-exception
        L_0x00a0:
            r4 = r17
            goto L_0x0648
        L_0x00a4:
            if (r8 <= r15) goto L_0x00a7
            r15 = r8
        L_0x00a7:
            r10.add(r14)     // Catch:{ NoCustomContextException -> 0x009f }
            if (r12 == 0) goto L_0x00c1
            boolean r5 = r12.equalsIgnoreCase(r4)     // Catch:{ NoCustomContextException -> 0x009f }
            if (r5 == 0) goto L_0x00c1
            com.itextpdf.tool.xml.html.table.TableRowElement$Place r5 = r14.c()     // Catch:{ NoCustomContextException -> 0x009f }
            com.itextpdf.tool.xml.html.table.TableRowElement$Place r8 = com.itextpdf.tool.xml.html.table.TableRowElement.Place.HEADER     // Catch:{ NoCustomContextException -> 0x009f }
            boolean r5 = r5.equals(r8)     // Catch:{ NoCustomContextException -> 0x009f }
            if (r5 == 0) goto L_0x00c1
            r5 = 1
            int r16 = r16 + 1
        L_0x00c1:
            if (r13 == 0) goto L_0x00dd
            boolean r4 = r13.equalsIgnoreCase(r4)     // Catch:{ NoCustomContextException -> 0x009f }
            if (r4 == 0) goto L_0x00dd
            com.itextpdf.tool.xml.html.table.TableRowElement$Place r4 = r14.c()     // Catch:{ NoCustomContextException -> 0x009f }
            com.itextpdf.tool.xml.html.table.TableRowElement$Place r5 = com.itextpdf.tool.xml.html.table.TableRowElement.Place.FOOTER     // Catch:{ NoCustomContextException -> 0x009f }
            boolean r4 = r4.equals(r5)     // Catch:{ NoCustomContextException -> 0x009f }
            if (r4 == 0) goto L_0x00dd
            r4 = 1
            int r3 = r3 + r4
            goto L_0x00dd
        L_0x00d8:
            r19 = r8
            r11.add(r14)     // Catch:{ NoCustomContextException -> 0x009f }
        L_0x00dd:
            r14 = r39
            r5 = r17
            r8 = r19
            r4 = 1
            goto L_0x0067
        L_0x00e5:
            r0 = move-exception
            r17 = r5
            goto L_0x00a0
        L_0x00e9:
            r17 = r5
            r19 = r8
            r5 = 0
            if (r13 == 0) goto L_0x0100
            boolean r4 = r13.equalsIgnoreCase(r4)     // Catch:{ NoCustomContextException -> 0x009f }
            if (r4 != 0) goto L_0x00f7
            goto L_0x0100
        L_0x00f7:
            com.itextpdf.tool.xml.html.table.Table$RepeatedRowComparator r4 = new com.itextpdf.tool.xml.html.table.Table$RepeatedRowComparator     // Catch:{ NoCustomContextException -> 0x009f }
            r4.<init>()     // Catch:{ NoCustomContextException -> 0x009f }
        L_0x00fc:
            java.util.Collections.sort(r10, r4)     // Catch:{ NoCustomContextException -> 0x009f }
            goto L_0x0106
        L_0x0100:
            com.itextpdf.tool.xml.html.table.Table$NormalRowComparator r4 = new com.itextpdf.tool.xml.html.table.Table$NormalRowComparator     // Catch:{ NoCustomContextException -> 0x009f }
            r4.<init>()     // Catch:{ NoCustomContextException -> 0x009f }
            goto L_0x00fc
        L_0x0106:
            com.itextpdf.text.pdf.PdfPTable r4 = r1.A(r15)     // Catch:{ NoCustomContextException -> 0x009f }
            int r8 = r16 + r3
            r4.K0(r8)     // Catch:{ NoCustomContextException -> 0x009f }
            r4.J0(r3)     // Catch:{ NoCustomContextException -> 0x009f }
            java.util.Map r3 = r38.d()     // Catch:{ NoCustomContextException -> 0x009f }
            boolean r3 = r3.containsKey(r6)     // Catch:{ NoCustomContextException -> 0x009f }
            if (r3 == 0) goto L_0x012d
            java.util.Map r3 = r38.d()     // Catch:{ NoCustomContextException -> 0x009f }
            java.lang.Object r3 = r3.get(r6)     // Catch:{ NoCustomContextException -> 0x009f }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ NoCustomContextException -> 0x009f }
            int r3 = com.itextpdf.tool.xml.css.CSS.a(r3)     // Catch:{ NoCustomContextException -> 0x009f }
            r4.M0(r3)     // Catch:{ NoCustomContextException -> 0x009f }
        L_0x012d:
            int r3 = r1.o(r2)     // Catch:{ NoCustomContextException -> 0x009f }
            r4.Q0(r3)     // Catch:{ NoCustomContextException -> 0x009f }
            java.util.Map r3 = r38.g()     // Catch:{ NoCustomContextException -> 0x009f }
            java.util.Set r3 = r3.entrySet()     // Catch:{ NoCustomContextException -> 0x009f }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ NoCustomContextException -> 0x009f }
        L_0x0140:
            boolean r6 = r3.hasNext()     // Catch:{ NoCustomContextException -> 0x009f }
            if (r6 == 0) goto L_0x016d
            java.lang.Object r6 = r3.next()     // Catch:{ NoCustomContextException -> 0x009f }
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch:{ NoCustomContextException -> 0x009f }
            java.lang.Object r8 = r6.getKey()     // Catch:{ NoCustomContextException -> 0x009f }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ NoCustomContextException -> 0x009f }
            java.lang.String r12 = "page-break-inside"
            boolean r8 = r8.equalsIgnoreCase(r12)     // Catch:{ NoCustomContextException -> 0x009f }
            if (r8 == 0) goto L_0x0140
            java.lang.Object r6 = r6.getValue()     // Catch:{ NoCustomContextException -> 0x009f }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ NoCustomContextException -> 0x009f }
            java.lang.String r8 = "avoid"
            boolean r6 = r6.equalsIgnoreCase(r8)     // Catch:{ NoCustomContextException -> 0x009f }
            if (r6 == 0) goto L_0x0140
            r6 = 1
            r4.N0(r6)     // Catch:{ NoCustomContextException -> 0x009f }
            goto L_0x0140
        L_0x016d:
            com.itextpdf.tool.xml.html.table.TableStyleValues r3 = D(r38)     // Catch:{ NoCustomContextException -> 0x009f }
            com.itextpdf.tool.xml.html.table.TableBorderEvent r6 = new com.itextpdf.tool.xml.html.table.TableBorderEvent     // Catch:{ NoCustomContextException -> 0x009f }
            r6.<init>(r3)     // Catch:{ NoCustomContextException -> 0x009f }
            r4.W0(r6)     // Catch:{ NoCustomContextException -> 0x009f }
            r1.E(r4, r2, r3, r0)     // Catch:{ NoCustomContextException -> 0x009f }
            float r6 = r3.n()     // Catch:{ NoCustomContextException -> 0x009f }
            r1.F(r10, r6)     // Catch:{ NoCustomContextException -> 0x009f }
            float[] r6 = new float[r15]     // Catch:{ NoCustomContextException -> 0x009f }
            float[] r8 = new float[r15]     // Catch:{ NoCustomContextException -> 0x009f }
            float[] r12 = new float[r15]     // Catch:{ NoCustomContextException -> 0x009f }
            float[] r13 = new float[r15]     // Catch:{ NoCustomContextException -> 0x009f }
            int[] r14 = new int[r15]     // Catch:{ NoCustomContextException -> 0x009f }
            java.util.Iterator r16 = r10.iterator()     // Catch:{ NoCustomContextException -> 0x009f }
            r21 = -1
            r22 = -1
            r23 = 0
            r24 = 0
        L_0x0199:
            boolean r25 = r16.hasNext()     // Catch:{ NoCustomContextException -> 0x009f }
            if (r25 == 0) goto L_0x02f9
            java.lang.Object r25 = r16.next()     // Catch:{ NoCustomContextException -> 0x009f }
            com.itextpdf.tool.xml.html.table.TableRowElement r25 = (com.itextpdf.tool.xml.html.table.TableRowElement) r25     // Catch:{ NoCustomContextException -> 0x009f }
            java.util.List r25 = r25.a()     // Catch:{ NoCustomContextException -> 0x009f }
            java.util.Iterator r25 = r25.iterator()     // Catch:{ NoCustomContextException -> 0x009f }
            r26 = r24
            r24 = r23
            r23 = r22
            r22 = r21
            r21 = 0
        L_0x01b7:
            boolean r27 = r25.hasNext()     // Catch:{ NoCustomContextException -> 0x009f }
            if (r27 == 0) goto L_0x02ef
            java.lang.Object r27 = r25.next()     // Catch:{ NoCustomContextException -> 0x009f }
            r5 = r27
            com.itextpdf.tool.xml.html.pdfelement.HtmlCell r5 = (com.itextpdf.tool.xml.html.pdfelement.HtmlCell) r5     // Catch:{ NoCustomContextException -> 0x009f }
            r27 = r11
            r11 = r21
        L_0x01c9:
            if (r11 >= r15) goto L_0x01da
            r21 = r14[r11]     // Catch:{ NoCustomContextException -> 0x009f }
            if (r21 <= 0) goto L_0x01da
            r29 = r9
            r9 = 1
            int r21 = r21 + -1
            r14[r11] = r21     // Catch:{ NoCustomContextException -> 0x009f }
            int r11 = r11 + r9
            r9 = r29
            goto L_0x01c9
        L_0x01da:
            r29 = r9
            r9 = 1
            r30 = r10
            int r10 = r5.g1()     // Catch:{ NoCustomContextException -> 0x009f }
            if (r10 <= r9) goto L_0x01f2
            int r10 = r15 + -1
            if (r11 == r10) goto L_0x01f2
            if (r11 >= r15) goto L_0x01f2
            int r10 = r5.g1()     // Catch:{ NoCustomContextException -> 0x009f }
            int r10 = r10 - r9
            r14[r11] = r10     // Catch:{ NoCustomContextException -> 0x009f }
        L_0x01f2:
            int r9 = r5.J0()     // Catch:{ NoCustomContextException -> 0x009f }
            float r10 = r5.W1()     // Catch:{ NoCustomContextException -> 0x009f }
            r21 = 0
            int r10 = (r10 > r21 ? 1 : (r10 == r21 ? 0 : -1))
            if (r10 == 0) goto L_0x024d
            float r10 = r5.W1()     // Catch:{ NoCustomContextException -> 0x009f }
            float r21 = r1.x(r5)     // Catch:{ NoCustomContextException -> 0x009f }
            float r10 = r10 + r21
            r33 = r4
            r32 = r14
            r21 = 0
            r31 = 0
            r14 = r11
        L_0x0213:
            int r4 = r11 + r9
            if (r14 >= r4) goto L_0x022a
            if (r14 >= r15) goto L_0x022a
            r4 = r12[r14]     // Catch:{ NoCustomContextException -> 0x009f }
            float r31 = r31 + r4
            r28 = 0
            int r4 = (r4 > r28 ? 1 : (r4 == r28 ? 0 : -1))
            if (r4 == 0) goto L_0x0227
            r4 = 1
            int r21 = r21 + 1
            goto L_0x0228
        L_0x0227:
            r4 = 1
        L_0x0228:
            int r14 = r14 + r4
            goto L_0x0213
        L_0x022a:
            r14 = r11
        L_0x022b:
            if (r14 >= r4) goto L_0x0251
            if (r14 >= r15) goto L_0x0251
            r34 = r12[r14]     // Catch:{ NoCustomContextException -> 0x009f }
            r28 = 0
            int r34 = (r34 > r28 ? 1 : (r34 == r28 ? 0 : -1))
            if (r34 != 0) goto L_0x0246
            float r34 = r10 - r31
            r35 = r4
            int r4 = r9 - r21
            float r4 = (float) r4     // Catch:{ NoCustomContextException -> 0x009f }
            float r34 = r34 / r4
            r12[r14] = r34     // Catch:{ NoCustomContextException -> 0x009f }
            r6[r14] = r34     // Catch:{ NoCustomContextException -> 0x009f }
        L_0x0244:
            r4 = 1
            goto L_0x0249
        L_0x0246:
            r35 = r4
            goto L_0x0244
        L_0x0249:
            int r14 = r14 + r4
            r4 = r35
            goto L_0x022b
        L_0x024d:
            r33 = r4
            r32 = r14
        L_0x0251:
            java.util.List r4 = r5.L0()     // Catch:{ NoCustomContextException -> 0x009f }
            if (r4 == 0) goto L_0x02b2
            float[] r4 = r1.C(r5)     // Catch:{ NoCustomContextException -> 0x009f }
            r5 = 0
            r10 = r4[r5]     // Catch:{ NoCustomContextException -> 0x009f }
            float r5 = (float) r9     // Catch:{ NoCustomContextException -> 0x009f }
            float r10 = r10 / r5
            r14 = 1
            r4 = r4[r14]     // Catch:{ NoCustomContextException -> 0x009f }
            float r4 = r4 / r5
            r5 = 0
        L_0x0265:
            if (r5 >= r9) goto L_0x02b2
            int r14 = r11 + r5
            if (r14 < r15) goto L_0x026f
            r31 = r12
        L_0x026d:
            r12 = 1
            goto L_0x02ae
        L_0x026f:
            r21 = r12[r14]     // Catch:{ NoCustomContextException -> 0x009f }
            r28 = 0
            int r21 = (r21 > r28 ? 1 : (r21 == r28 ? 0 : -1))
            if (r21 != 0) goto L_0x0297
            r21 = r6[r14]     // Catch:{ NoCustomContextException -> 0x009f }
            int r21 = (r10 > r21 ? 1 : (r10 == r21 ? 0 : -1))
            if (r21 <= 0) goto L_0x0297
            r6[r14] = r10     // Catch:{ NoCustomContextException -> 0x009f }
            r31 = r12
            r12 = 1
            if (r9 != r12) goto L_0x028e
            int r12 = (r10 > r26 ? 1 : (r10 == r26 ? 0 : -1))
            if (r12 <= 0) goto L_0x028c
            r26 = r10
            r23 = r14
        L_0x028c:
            r12 = 1
            goto L_0x029a
        L_0x028e:
            int r12 = (r10 > r24 ? 1 : (r10 == r24 ? 0 : -1))
            if (r12 <= 0) goto L_0x028c
            r24 = r10
            r22 = r14
            goto L_0x028c
        L_0x0297:
            r31 = r12
            goto L_0x028c
        L_0x029a:
            if (r9 != r12) goto L_0x02a5
            r12 = r8[r14]     // Catch:{ NoCustomContextException -> 0x009f }
            int r12 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r12 <= 0) goto L_0x026d
            r8[r14] = r4     // Catch:{ NoCustomContextException -> 0x009f }
            goto L_0x026d
        L_0x02a5:
            r12 = r13[r14]     // Catch:{ NoCustomContextException -> 0x009f }
            int r12 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r12 <= 0) goto L_0x026d
            r13[r14] = r4     // Catch:{ NoCustomContextException -> 0x009f }
            goto L_0x026d
        L_0x02ae:
            int r5 = r5 + r12
            r12 = r31
            goto L_0x0265
        L_0x02b2:
            r31 = r12
            r4 = 1
            if (r9 <= r4) goto L_0x02df
            com.itextpdf.text.log.Logger r4 = Y2     // Catch:{ NoCustomContextException -> 0x009f }
            com.itextpdf.text.log.Level r5 = com.itextpdf.text.log.Level.TRACE     // Catch:{ NoCustomContextException -> 0x009f }
            boolean r5 = r4.b(r5)     // Catch:{ NoCustomContextException -> 0x009f }
            if (r5 == 0) goto L_0x02dc
            com.itextpdf.tool.xml.exceptions.LocaleMessages r5 = com.itextpdf.tool.xml.exceptions.LocaleMessages.a()     // Catch:{ NoCustomContextException -> 0x009f }
            java.lang.String r10 = "html.tag.table.colspan"
            java.lang.String r5 = r5.b(r10)     // Catch:{ NoCustomContextException -> 0x009f }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r9)     // Catch:{ NoCustomContextException -> 0x009f }
            r12 = 1
            java.lang.Object[] r14 = new java.lang.Object[r12]     // Catch:{ NoCustomContextException -> 0x009f }
            r12 = 0
            r14[r12] = r10     // Catch:{ NoCustomContextException -> 0x009f }
            java.lang.String r5 = java.lang.String.format(r5, r14)     // Catch:{ NoCustomContextException -> 0x009f }
            r4.h(r5)     // Catch:{ NoCustomContextException -> 0x009f }
        L_0x02dc:
            r4 = 1
            int r9 = r9 - r4
            int r11 = r11 + r9
        L_0x02df:
            int r21 = r11 + 1
            r11 = r27
            r9 = r29
            r10 = r30
            r12 = r31
            r14 = r32
            r4 = r33
            goto L_0x01b7
        L_0x02ef:
            r21 = r22
            r22 = r23
            r23 = r24
            r24 = r26
            goto L_0x0199
        L_0x02f9:
            r33 = r4
            r29 = r9
            r30 = r10
            r27 = r11
            r31 = r12
            r4 = r22
            r5 = -1
            if (r4 != r5) goto L_0x031a
            r9 = r21
            if (r9 != r5) goto L_0x030d
            r9 = 0
        L_0x030d:
            r4 = 0
        L_0x030e:
            if (r4 >= r15) goto L_0x0317
            r10 = r13[r4]     // Catch:{ NoCustomContextException -> 0x009f }
            r8[r4] = r10     // Catch:{ NoCustomContextException -> 0x009f }
            r10 = 1
            int r4 = r4 + r10
            goto L_0x030e
        L_0x0317:
            r22 = r9
            goto L_0x031c
        L_0x031a:
            r22 = r4
        L_0x031c:
            float r4 = r3.n()     // Catch:{ NoCustomContextException -> 0x009f }
            float r4 = r1.y(r2, r4, r0)     // Catch:{ NoCustomContextException -> 0x009f }
            r9 = 0
            float r10 = r1.z(r6, r9)     // Catch:{ NoCustomContextException -> 0x009f }
            com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext r9 = r36.m(r37)     // Catch:{ NoCustomContextException -> 0x009f }
            com.itextpdf.text.Rectangle r11 = r9.getPageSize()     // Catch:{ NoCustomContextException -> 0x009f }
            float r11 = r11.a0()     // Catch:{ NoCustomContextException -> 0x009f }
            float r11 = r11 - r4
            java.util.Map r12 = r38.d()     // Catch:{ NoCustomContextException -> 0x009f }
            java.lang.Object r12 = r12.get(r7)     // Catch:{ NoCustomContextException -> 0x009f }
            if (r12 != 0) goto L_0x0379
            java.util.Map r12 = r38.g()     // Catch:{ NoCustomContextException -> 0x009f }
            java.lang.Object r7 = r12.get(r7)     // Catch:{ NoCustomContextException -> 0x009f }
            if (r7 == 0) goto L_0x034b
            goto L_0x0379
        L_0x034b:
            int r7 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r7 > 0) goto L_0x0355
            r11 = r10
        L_0x0350:
            r9 = r31
            r7 = 0
        L_0x0353:
            r12 = 0
            goto L_0x0398
        L_0x0355:
            com.itextpdf.tool.xml.Tag r7 = r38.r()     // Catch:{ NoCustomContextException -> 0x009f }
            if (r7 == 0) goto L_0x0350
            com.itextpdf.tool.xml.Tag r7 = r38.r()     // Catch:{ NoCustomContextException -> 0x009f }
            if (r7 == 0) goto L_0x0374
            java.util.List r7 = r9.a()     // Catch:{ NoCustomContextException -> 0x009f }
            com.itextpdf.tool.xml.Tag r9 = r38.r()     // Catch:{ NoCustomContextException -> 0x009f }
            java.lang.String r9 = r9.o()     // Catch:{ NoCustomContextException -> 0x009f }
            boolean r7 = r7.contains(r9)     // Catch:{ NoCustomContextException -> 0x009f }
            if (r7 == 0) goto L_0x0374
            goto L_0x0350
        L_0x0374:
            float r11 = r1.z(r6, r4)     // Catch:{ NoCustomContextException -> 0x009f }
            goto L_0x0350
        L_0x0379:
            com.itextpdf.tool.xml.css.WidthCalculator r7 = new com.itextpdf.tool.xml.css.WidthCalculator     // Catch:{ NoCustomContextException -> 0x009f }
            r7.<init>()     // Catch:{ NoCustomContextException -> 0x009f }
            java.util.List r12 = r9.a()     // Catch:{ NoCustomContextException -> 0x009f }
            com.itextpdf.text.Rectangle r9 = r9.getPageSize()     // Catch:{ NoCustomContextException -> 0x009f }
            float r9 = r9.a0()     // Catch:{ NoCustomContextException -> 0x009f }
            float r7 = r7.b(r2, r12, r9, r10)     // Catch:{ NoCustomContextException -> 0x009f }
            int r9 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r9 <= 0) goto L_0x0393
            goto L_0x0394
        L_0x0393:
            r11 = r7
        L_0x0394:
            r9 = r31
            r7 = 1
            goto L_0x0353
        L_0x0398:
            float r13 = r1.z(r9, r12)     // Catch:{ NoCustomContextException -> 0x009f }
            int r12 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x03cb
            float r4 = r11 / r10
            int r8 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r8 <= 0) goto L_0x03b7
            r7 = 0
        L_0x03a7:
            if (r7 >= r15) goto L_0x03b2
            r8 = r6[r7]     // Catch:{ NoCustomContextException -> 0x009f }
            float r8 = r8 * r4
            r6[r7] = r8     // Catch:{ NoCustomContextException -> 0x009f }
            r8 = 1
            int r7 = r7 + r8
            goto L_0x03a7
        L_0x03b2:
            r4 = r33
            r8 = 1
            goto L_0x047b
        L_0x03b7:
            if (r7 == 0) goto L_0x03b2
            r7 = 1065353216(0x3f800000, float:1.0)
            int r7 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x03b2
            r7 = 0
        L_0x03c0:
            if (r7 >= r15) goto L_0x03b2
            r8 = r6[r7]     // Catch:{ NoCustomContextException -> 0x009f }
            float r8 = r8 * r4
            r6[r7] = r8     // Catch:{ NoCustomContextException -> 0x009f }
            r8 = 1
            int r7 = r7 + r8
            goto L_0x03c0
        L_0x03cb:
            float r7 = r11 - r13
            float r12 = r10 - r13
            float r7 = r7 / r12
            int r12 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r12 <= 0) goto L_0x0461
            r10 = 0
            r11 = 0
        L_0x03d6:
            if (r10 >= r15) goto L_0x0409
            r12 = r9[r10]     // Catch:{ NoCustomContextException -> 0x009f }
            r13 = 0
            int r14 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            if (r14 != 0) goto L_0x03f8
            r12 = r8[r10]     // Catch:{ NoCustomContextException -> 0x009f }
            r13 = r6[r10]     // Catch:{ NoCustomContextException -> 0x009f }
            float r14 = r13 * r7
            int r14 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r14 > 0) goto L_0x03ee
            float r13 = r13 * r7
            r6[r10] = r13     // Catch:{ NoCustomContextException -> 0x009f }
            goto L_0x03f6
        L_0x03ee:
            r6[r10] = r12     // Catch:{ NoCustomContextException -> 0x009f }
            r13 = r8[r10]     // Catch:{ NoCustomContextException -> 0x009f }
            float r12 = r12 * r7
            float r13 = r13 - r12
            float r11 = r11 + r13
        L_0x03f6:
            r12 = 1
            goto L_0x0407
        L_0x03f8:
            r13 = r8[r10]     // Catch:{ NoCustomContextException -> 0x009f }
            int r12 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            if (r12 >= 0) goto L_0x03f6
            r6[r10] = r13     // Catch:{ NoCustomContextException -> 0x009f }
            r12 = r8[r10]     // Catch:{ NoCustomContextException -> 0x009f }
            r13 = r9[r10]     // Catch:{ NoCustomContextException -> 0x009f }
            float r12 = r12 - r13
            float r11 = r11 + r12
            goto L_0x03f6
        L_0x0407:
            int r10 = r10 + r12
            goto L_0x03d6
        L_0x0409:
            r7 = 0
            int r10 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r10 == 0) goto L_0x03b2
            r7 = r8[r22]     // Catch:{ NoCustomContextException -> 0x009f }
            r10 = r6[r22]     // Catch:{ NoCustomContextException -> 0x009f }
            float r12 = r10 - r11
            int r7 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r7 > 0) goto L_0x041c
            float r10 = r10 - r11
            r6[r22] = r10     // Catch:{ NoCustomContextException -> 0x009f }
            goto L_0x03b2
        L_0x041c:
            r7 = 0
        L_0x041d:
            r10 = 0
            int r12 = (r11 > r10 ? 1 : (r11 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x0446
            if (r7 >= r15) goto L_0x0446
            r12 = r9[r7]     // Catch:{ NoCustomContextException -> 0x009f }
            int r12 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x043d
            r10 = r6[r7]     // Catch:{ NoCustomContextException -> 0x009f }
            r12 = r8[r7]     // Catch:{ NoCustomContextException -> 0x009f }
            int r13 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r13 <= 0) goto L_0x043d
            float r13 = r10 - r12
            int r14 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r14 > 0) goto L_0x043f
            float r10 = r11 - r13
            r6[r7] = r12     // Catch:{ NoCustomContextException -> 0x009f }
            r11 = r10
        L_0x043d:
            r10 = 1
            goto L_0x0444
        L_0x043f:
            float r10 = r10 - r11
            r6[r7] = r10     // Catch:{ NoCustomContextException -> 0x009f }
            r10 = 1
            r11 = 0
        L_0x0444:
            int r7 = r7 + r10
            goto L_0x041d
        L_0x0446:
            if (r12 == 0) goto L_0x03b2
            com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext r7 = r36.m(r37)     // Catch:{ NoCustomContextException -> 0x009f }
            com.itextpdf.text.Rectangle r7 = r7.getPageSize()     // Catch:{ NoCustomContextException -> 0x009f }
            float r7 = r7.a0()     // Catch:{ NoCustomContextException -> 0x009f }
            float r9 = r1.z(r8, r4)     // Catch:{ NoCustomContextException -> 0x009f }
            int r7 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r7 >= 0) goto L_0x03b2
            r1.z(r8, r4)     // Catch:{ NoCustomContextException -> 0x009f }
            goto L_0x03b2
        L_0x0461:
            int r4 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r4 >= 0) goto L_0x0478
            r4 = 0
        L_0x0466:
            if (r4 >= r15) goto L_0x0478
            r8 = r9[r4]     // Catch:{ NoCustomContextException -> 0x009f }
            r10 = 0
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 != 0) goto L_0x0475
            r8 = r6[r4]     // Catch:{ NoCustomContextException -> 0x009f }
            float r8 = r8 * r7
            r6[r4] = r8     // Catch:{ NoCustomContextException -> 0x009f }
        L_0x0475:
            r8 = 1
            int r4 = r4 + r8
            goto L_0x0466
        L_0x0478:
            r8 = 1
            r4 = r33
        L_0x047b:
            r4.Y0(r6)     // Catch:{ DocumentException -> 0x0636 }
            r4.O0(r8)     // Catch:{ DocumentException -> 0x0636 }
            com.itextpdf.text.pdf.PdfPCell r7 = r4.H()     // Catch:{ DocumentException -> 0x0636 }
            r8 = 0
            r7.i0(r8)     // Catch:{ DocumentException -> 0x0636 }
            com.itextpdf.tool.xml.css.HeightCalculator r7 = new com.itextpdf.tool.xml.css.HeightCalculator     // Catch:{ NoCustomContextException -> 0x009f }
            r7.<init>()     // Catch:{ NoCustomContextException -> 0x009f }
            com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext r0 = r36.m(r37)     // Catch:{ NoCustomContextException -> 0x009f }
            com.itextpdf.text.Rectangle r0 = r0.getPageSize()     // Catch:{ NoCustomContextException -> 0x009f }
            float r0 = r0.N()     // Catch:{ NoCustomContextException -> 0x009f }
            java.lang.Float r0 = r7.a(r2, r0)     // Catch:{ NoCustomContextException -> 0x009f }
            if (r0 == 0) goto L_0x04b8
            float r7 = r0.floatValue()     // Catch:{ NoCustomContextException -> 0x009f }
            r8 = 0
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 <= 0) goto L_0x04b8
            float r7 = r0.floatValue()     // Catch:{ NoCustomContextException -> 0x009f }
            int r8 = r30.size()     // Catch:{ NoCustomContextException -> 0x009f }
            float r8 = (float) r8     // Catch:{ NoCustomContextException -> 0x009f }
            float r7 = r7 / r8
            java.lang.Float r7 = java.lang.Float.valueOf(r7)     // Catch:{ NoCustomContextException -> 0x009f }
            goto L_0x04b9
        L_0x04b8:
            r7 = 0
        L_0x04b9:
            java.util.Iterator r8 = r30.iterator()     // Catch:{ NoCustomContextException -> 0x009f }
            r9 = 0
        L_0x04be:
            boolean r10 = r8.hasNext()     // Catch:{ NoCustomContextException -> 0x009f }
            if (r10 == 0) goto L_0x05c3
            java.lang.Object r10 = r8.next()     // Catch:{ NoCustomContextException -> 0x009f }
            com.itextpdf.tool.xml.html.table.TableRowElement r10 = (com.itextpdf.tool.xml.html.table.TableRowElement) r10     // Catch:{ NoCustomContextException -> 0x009f }
            java.util.List r10 = r10.a()     // Catch:{ NoCustomContextException -> 0x009f }
            int r11 = r10.size()     // Catch:{ NoCustomContextException -> 0x009f }
            r12 = 1
            if (r11 >= r12) goto L_0x04d6
            goto L_0x04be
        L_0x04d6:
            java.util.Iterator r10 = r10.iterator()     // Catch:{ NoCustomContextException -> 0x009f }
            r11 = -1
        L_0x04db:
            boolean r12 = r10.hasNext()     // Catch:{ NoCustomContextException -> 0x009f }
            if (r12 == 0) goto L_0x0567
            java.lang.Object r12 = r10.next()     // Catch:{ NoCustomContextException -> 0x009f }
            com.itextpdf.tool.xml.html.pdfelement.HtmlCell r12 = (com.itextpdf.tool.xml.html.pdfelement.HtmlCell) r12     // Catch:{ NoCustomContextException -> 0x009f }
            java.util.List r13 = r12.L0()     // Catch:{ NoCustomContextException -> 0x009f }
            if (r13 == 0) goto L_0x055c
            java.util.Iterator r13 = r13.iterator()     // Catch:{ NoCustomContextException -> 0x009f }
        L_0x04f1:
            boolean r14 = r13.hasNext()     // Catch:{ NoCustomContextException -> 0x009f }
            if (r14 == 0) goto L_0x055c
            java.lang.Object r14 = r13.next()     // Catch:{ NoCustomContextException -> 0x009f }
            com.itextpdf.text.Element r14 = (com.itextpdf.text.Element) r14     // Catch:{ NoCustomContextException -> 0x009f }
            boolean r15 = r14 instanceof com.itextpdf.text.pdf.PdfPTable     // Catch:{ NoCustomContextException -> 0x009f }
            if (r15 == 0) goto L_0x055a
            com.itextpdf.tool.xml.html.table.TableStyleValues r15 = r12.V1()     // Catch:{ NoCustomContextException -> 0x009f }
            boolean r16 = r15.p()     // Catch:{ NoCustomContextException -> 0x009f }
            if (r16 == 0) goto L_0x0514
            float r16 = r3.n()     // Catch:{ NoCustomContextException -> 0x009f }
            r20 = 1073741824(0x40000000, float:2.0)
            float r16 = r16 * r20
            goto L_0x0518
        L_0x0514:
            float r16 = r3.n()     // Catch:{ NoCustomContextException -> 0x009f }
        L_0x0518:
            float r20 = r15.h()     // Catch:{ NoCustomContextException -> 0x009f }
            float r15 = r15.j()     // Catch:{ NoCustomContextException -> 0x009f }
            float r20 = r20 + r15
            float r16 = r16 + r20
            r15 = 1
            int r18 = r11 + 1
            r5 = r18
            r21 = 0
        L_0x052b:
            int r18 = r12.J0()     // Catch:{ NoCustomContextException -> 0x009f }
            int r15 = r11 + r18
            if (r5 > r15) goto L_0x053a
            r15 = r6[r5]     // Catch:{ NoCustomContextException -> 0x009f }
            float r21 = r21 + r15
            r15 = 1
            int r5 = r5 + r15
            goto L_0x052b
        L_0x053a:
            r5 = r14
            com.itextpdf.text.pdf.PdfPTable r5 = (com.itextpdf.text.pdf.PdfPTable) r5     // Catch:{ NoCustomContextException -> 0x009f }
            com.itextpdf.text.pdf.PdfPTableEvent r5 = r5.j0()     // Catch:{ NoCustomContextException -> 0x009f }
            com.itextpdf.tool.xml.html.table.TableBorderEvent r5 = (com.itextpdf.tool.xml.html.table.TableBorderEvent) r5     // Catch:{ NoCustomContextException -> 0x009f }
            com.itextpdf.tool.xml.html.table.TableStyleValues r5 = r5.d()     // Catch:{ NoCustomContextException -> 0x009f }
            float r15 = r5.h()     // Catch:{ NoCustomContextException -> 0x009f }
            float r16 = r16 + r15
            float r5 = r5.j()     // Catch:{ NoCustomContextException -> 0x009f }
            float r16 = r16 + r5
            com.itextpdf.text.pdf.PdfPTable r14 = (com.itextpdf.text.pdf.PdfPTable) r14     // Catch:{ NoCustomContextException -> 0x009f }
            float r5 = r21 - r16
            r14.X0(r5)     // Catch:{ NoCustomContextException -> 0x009f }
        L_0x055a:
            r5 = -1
            goto L_0x04f1
        L_0x055c:
            int r5 = r12.J0()     // Catch:{ NoCustomContextException -> 0x009f }
            int r11 = r11 + r5
            r4.a(r12)     // Catch:{ NoCustomContextException -> 0x009f }
            r5 = -1
            goto L_0x04db
        L_0x0567:
            r4.u()     // Catch:{ NoCustomContextException -> 0x009f }
            if (r7 == 0) goto L_0x056e
            r5 = r7
            goto L_0x056f
        L_0x056e:
            r5 = 0
        L_0x056f:
            if (r5 == 0) goto L_0x05bd
            float r10 = r5.floatValue()     // Catch:{ NoCustomContextException -> 0x009f }
            r11 = 0
            int r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r10 <= 0) goto L_0x05bb
            com.itextpdf.text.pdf.PdfPRow r10 = r4.b0(r9)     // Catch:{ NoCustomContextException -> 0x009f }
            float r10 = r10.e()     // Catch:{ NoCustomContextException -> 0x009f }
            float r12 = r5.floatValue()     // Catch:{ NoCustomContextException -> 0x009f }
            int r12 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r12 >= 0) goto L_0x0596
            com.itextpdf.text.pdf.PdfPRow r10 = r4.b0(r9)     // Catch:{ NoCustomContextException -> 0x009f }
            float r5 = r5.floatValue()     // Catch:{ NoCustomContextException -> 0x009f }
            r10.v(r5)     // Catch:{ NoCustomContextException -> 0x009f }
            goto L_0x05bb
        L_0x0596:
            if (r7 == 0) goto L_0x05bb
            float r5 = r7.floatValue()     // Catch:{ NoCustomContextException -> 0x009f }
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 >= 0) goto L_0x05bb
            float r5 = r0.floatValue()     // Catch:{ NoCustomContextException -> 0x009f }
            float r5 = r5 - r10
            float r10 = (float) r9     // Catch:{ NoCustomContextException -> 0x009f }
            float r7 = r7.floatValue()     // Catch:{ NoCustomContextException -> 0x009f }
            float r10 = r10 * r7
            float r5 = r5 - r10
            int r7 = r30.size()     // Catch:{ NoCustomContextException -> 0x009f }
            int r7 = r7 - r9
            r10 = 1
            int r7 = r7 - r10
            float r7 = (float) r7     // Catch:{ NoCustomContextException -> 0x009f }
            float r5 = r5 / r7
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ NoCustomContextException -> 0x009f }
            r7 = r5
        L_0x05bb:
            r5 = 1
            goto L_0x05bf
        L_0x05bd:
            r11 = 0
            goto L_0x05bb
        L_0x05bf:
            int r9 = r9 + r5
            r5 = -1
            goto L_0x04be
        L_0x05c3:
            if (r29 == 0) goto L_0x05d4
            com.itextpdf.tool.xml.css.CssUtils r0 = Z2     // Catch:{ NoCustomContextException -> 0x009f }
            r8 = r19
            float r0 = r0.p(r8)     // Catch:{ NoCustomContextException -> 0x009f }
            r4.Z0(r0)     // Catch:{ NoCustomContextException -> 0x009f }
            r0 = 0
            r4.O0(r0)     // Catch:{ NoCustomContextException -> 0x009f }
        L_0x05d4:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ NoCustomContextException -> 0x009f }
            r0.<init>()     // Catch:{ NoCustomContextException -> 0x009f }
            int r3 = r27.size()     // Catch:{ NoCustomContextException -> 0x009f }
            if (r3 <= 0) goto L_0x0632
            java.util.List r3 = r38.k()     // Catch:{ NoCustomContextException -> 0x009f }
            r5 = 0
            java.lang.Object r3 = r3.get(r5)     // Catch:{ NoCustomContextException -> 0x009f }
            com.itextpdf.tool.xml.Tag r3 = (com.itextpdf.tool.xml.Tag) r3     // Catch:{ NoCustomContextException -> 0x009f }
            r5 = 1
        L_0x05eb:
            java.lang.String r6 = r3.o()     // Catch:{ NoCustomContextException -> 0x009f }
            java.lang.String r7 = "caption"
            boolean r6 = r6.equalsIgnoreCase(r7)     // Catch:{ NoCustomContextException -> 0x009f }
            if (r6 != 0) goto L_0x060e
            java.util.List r6 = r38.k()     // Catch:{ NoCustomContextException -> 0x009f }
            int r6 = r6.size()     // Catch:{ NoCustomContextException -> 0x009f }
            if (r5 >= r6) goto L_0x060e
            java.util.List r3 = r38.k()     // Catch:{ NoCustomContextException -> 0x009f }
            java.lang.Object r3 = r3.get(r5)     // Catch:{ NoCustomContextException -> 0x009f }
            com.itextpdf.tool.xml.Tag r3 = (com.itextpdf.tool.xml.Tag) r3     // Catch:{ NoCustomContextException -> 0x009f }
            r6 = 1
            int r5 = r5 + r6
            goto L_0x05eb
        L_0x060e:
            java.util.Map r2 = r3.g()     // Catch:{ NoCustomContextException -> 0x009f }
            java.lang.String r3 = "caption-side"
            java.lang.Object r2 = r2.get(r3)     // Catch:{ NoCustomContextException -> 0x009f }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ NoCustomContextException -> 0x009f }
            if (r2 == 0) goto L_0x062d
            java.lang.String r3 = "bottom"
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ NoCustomContextException -> 0x009f }
            if (r2 == 0) goto L_0x062d
            r0.add(r4)     // Catch:{ NoCustomContextException -> 0x009f }
            r2 = r27
            r0.addAll(r2)     // Catch:{ NoCustomContextException -> 0x009f }
            goto L_0x0635
        L_0x062d:
            r2 = r27
            r0.addAll(r2)     // Catch:{ NoCustomContextException -> 0x009f }
        L_0x0632:
            r0.add(r4)     // Catch:{ NoCustomContextException -> 0x009f }
        L_0x0635:
            return r0
        L_0x0636:
            r0 = move-exception
            com.itextpdf.tool.xml.exceptions.RuntimeWorkerException r2 = new com.itextpdf.tool.xml.exceptions.RuntimeWorkerException     // Catch:{ NoCustomContextException -> 0x009f }
            com.itextpdf.tool.xml.exceptions.LocaleMessages r3 = com.itextpdf.tool.xml.exceptions.LocaleMessages.a()     // Catch:{ NoCustomContextException -> 0x009f }
            r4 = r17
            java.lang.String r3 = r3.b(r4)     // Catch:{ NoCustomContextException -> 0x0647 }
            r2.<init>(r3, r0)     // Catch:{ NoCustomContextException -> 0x0647 }
            throw r2     // Catch:{ NoCustomContextException -> 0x0647 }
        L_0x0647:
            r0 = move-exception
        L_0x0648:
            com.itextpdf.tool.xml.exceptions.RuntimeWorkerException r2 = new com.itextpdf.tool.xml.exceptions.RuntimeWorkerException
            com.itextpdf.tool.xml.exceptions.LocaleMessages r3 = com.itextpdf.tool.xml.exceptions.LocaleMessages.a()
            java.lang.String r3 = r3.b(r4)
            r2.<init>(r3, r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.tool.xml.html.table.Table.k(com.itextpdf.tool.xml.WorkerContext, com.itextpdf.tool.xml.Tag, java.util.List):java.util.List");
    }
}
