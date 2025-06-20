package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfDiv;
import java.util.ArrayList;
import java.util.List;

public class FloatLayout {

    /* renamed from: a  reason: collision with root package name */
    protected float f26039a;

    /* renamed from: b  reason: collision with root package name */
    protected float f26040b;

    /* renamed from: c  reason: collision with root package name */
    protected float f26041c;

    /* renamed from: d  reason: collision with root package name */
    protected float f26042d;

    /* renamed from: e  reason: collision with root package name */
    protected float f26043e;

    /* renamed from: f  reason: collision with root package name */
    protected float f26044f;

    /* renamed from: g  reason: collision with root package name */
    protected float f26045g;

    /* renamed from: h  reason: collision with root package name */
    protected float f26046h;

    /* renamed from: i  reason: collision with root package name */
    protected final ColumnText f26047i;

    /* renamed from: j  reason: collision with root package name */
    protected final List<Element> f26048j;

    /* renamed from: k  reason: collision with root package name */
    protected final boolean f26049k;

    public FloatLayout(List<Element> list, boolean z) {
        ColumnText columnText = new ColumnText((PdfContentByte) null);
        this.f26047i = columnText;
        columnText.s0(z);
        this.f26049k = z;
        this.f26048j = list;
    }

    /* JADX WARNING: Removed duplicated region for block: B:140:0x0262 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x027e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(java.util.List<com.itextpdf.text.Element> r26, boolean r27) throws com.itextpdf.text.DocumentException {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            r10 = r27
            float r2 = r0.f26043e
            com.itextpdf.text.pdf.ColumnText r3 = r0.f26047i
            if (r10 == 0) goto L_0x0010
            com.itextpdf.text.pdf.ColumnText r3 = com.itextpdf.text.pdf.ColumnText.g(r3)
        L_0x0010:
            r11 = r3
            float r3 = r0.f26039a
            float r4 = r0.f26043e
            r12 = 0
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x001c
            r3 = 1
            goto L_0x001d
        L_0x001c:
            r3 = 0
        L_0x001d:
            r15 = r2
            r16 = r3
            r2 = 1
            r8 = 0
            r9 = 0
        L_0x0023:
            boolean r3 = r26.isEmpty()
            if (r3 != 0) goto L_0x030b
            java.lang.Object r2 = r1.get(r12)
            r7 = r2
            com.itextpdf.text.Element r7 = (com.itextpdf.text.Element) r7
            r1.remove(r12)
            boolean r2 = r7 instanceof com.itextpdf.text.pdf.PdfDiv
            if (r2 == 0) goto L_0x0127
            r6 = r7
            com.itextpdf.text.pdf.PdfDiv r6 = (com.itextpdf.text.pdf.PdfDiv) r6
            com.itextpdf.text.pdf.ColumnText r2 = r0.f26047i
            com.itextpdf.text.pdf.PdfContentByte r18 = r2.n()
            boolean r2 = r0.f26049k
            float r3 = r0.f26044f
            float r4 = r0.f26040b
            float r5 = r0.f26045g
            float r13 = r0.f26043e
            r20 = 1
            r17 = r6
            r19 = r2
            r21 = r3
            r22 = r4
            r23 = r5
            r24 = r13
            int r2 = r17.P(r18, r19, r20, r21, r22, r23, r24)
            r3 = r2 & 1
            if (r3 != 0) goto L_0x0096
            r0.f26043e = r15
            float r2 = r0.f26041c
            r0.f26044f = r2
            float r2 = r0.f26042d
            r0.f26045g = r2
            com.itextpdf.text.pdf.ColumnText r2 = r0.f26047i
            com.itextpdf.text.pdf.PdfContentByte r18 = r2.n()
            boolean r2 = r0.f26049k
            float r3 = r0.f26044f
            float r4 = r0.f26040b
            float r5 = r0.f26045g
            float r13 = r0.f26043e
            r20 = 1
            r17 = r6
            r19 = r2
            r21 = r3
            r22 = r4
            r23 = r5
            r24 = r13
            int r2 = r17.P(r18, r19, r20, r21, r22, r23, r24)
            r3 = r2 & 1
            if (r3 != 0) goto L_0x0096
            r1.add(r12, r6)
        L_0x0093:
            r1 = 0
            goto L_0x030f
        L_0x0096:
            com.itextpdf.text.pdf.PdfDiv$FloatType r3 = r6.q()
            com.itextpdf.text.pdf.PdfDiv$FloatType r4 = com.itextpdf.text.pdf.PdfDiv.FloatType.LEFT
            if (r3 != r4) goto L_0x00d5
            com.itextpdf.text.pdf.ColumnText r2 = r0.f26047i
            com.itextpdf.text.pdf.PdfContentByte r3 = r2.n()
            boolean r4 = r0.f26049k
            float r13 = r0.f26044f
            float r5 = r0.f26040b
            float r2 = r0.f26045g
            float r14 = r0.f26043e
            r18 = r2
            r2 = r6
            r19 = r5
            r5 = r27
            r20 = r6
            r6 = r13
            r13 = r7
            r7 = r19
            r12 = r8
            r8 = r18
            r10 = r9
            r9 = r14
            int r2 = r2.P(r3, r4, r5, r6, r7, r8, r9)
            float r3 = r0.f26044f
            float r4 = r20.f()
            float r3 = r3 + r4
            r0.f26044f = r3
            float r3 = r20.f()
            float r9 = r10 + r3
        L_0x00d3:
            r8 = r12
            goto L_0x0117
        L_0x00d5:
            r20 = r6
            r13 = r7
            r12 = r8
            r10 = r9
            com.itextpdf.text.pdf.PdfDiv$FloatType r3 = r20.q()
            com.itextpdf.text.pdf.PdfDiv$FloatType r4 = com.itextpdf.text.pdf.PdfDiv.FloatType.RIGHT
            if (r3 != r4) goto L_0x0115
            com.itextpdf.text.pdf.ColumnText r2 = r0.f26047i
            com.itextpdf.text.pdf.PdfContentByte r3 = r2.n()
            boolean r4 = r0.f26049k
            float r2 = r0.f26045g
            float r5 = r20.f()
            float r2 = r2 - r5
            r5 = 1008981770(0x3c23d70a, float:0.01)
            float r6 = r2 - r5
            float r7 = r0.f26040b
            float r8 = r0.f26045g
            float r9 = r0.f26043e
            r2 = r20
            r5 = r27
            int r2 = r2.P(r3, r4, r5, r6, r7, r8, r9)
            float r3 = r0.f26045g
            float r4 = r20.f()
            float r3 = r3 - r4
            r0.f26045g = r3
            float r3 = r20.f()
            float r8 = r12 + r3
            r9 = r10
            goto L_0x0117
        L_0x0115:
            r9 = r10
            goto L_0x00d3
        L_0x0117:
            float r3 = r0.f26043e
            float r4 = r20.e()
            float r3 = r3 - r4
            float r3 = java.lang.Math.min(r15, r3)
            r4 = r27
            r15 = r3
            goto L_0x0281
        L_0x0127:
            r13 = r7
            r12 = r8
            r10 = r9
            float r2 = r0.f26040b
            r3 = 0
            int r2 = (r2 > r15 ? 1 : (r2 == r15 ? 0 : -1))
            if (r2 <= 0) goto L_0x013f
            r2 = 0
            r1.add(r2, r13)
            if (r11 == 0) goto L_0x013a
            r11.r0(r3)
        L_0x013a:
            r2 = 2
            r9 = r10
            r8 = r12
            goto L_0x0093
        L_0x013f:
            boolean r2 = r13 instanceof com.itextpdf.text.api.Spaceable
            if (r2 == 0) goto L_0x0158
            if (r16 == 0) goto L_0x015c
            boolean r2 = r11.P()
            if (r2 == 0) goto L_0x015c
            r7 = r13
            com.itextpdf.text.api.Spaceable r7 = (com.itextpdf.text.api.Spaceable) r7
            float r2 = r7.X()
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0158
            goto L_0x015c
        L_0x0158:
            r4 = r27
            r14 = r10
            goto L_0x0169
        L_0x015c:
            float r2 = r0.f26043e
            r7 = r13
            com.itextpdf.text.api.Spaceable r7 = (com.itextpdf.text.api.Spaceable) r7
            float r4 = r7.E()
            float r2 = r2 - r4
            r0.f26043e = r2
            goto L_0x0158
        L_0x0169:
            if (r4 == 0) goto L_0x017b
            boolean r2 = r13 instanceof com.itextpdf.text.pdf.PdfPTable
            if (r2 == 0) goto L_0x017b
            com.itextpdf.text.pdf.PdfPTable r2 = new com.itextpdf.text.pdf.PdfPTable
            r7 = r13
            com.itextpdf.text.pdf.PdfPTable r7 = (com.itextpdf.text.pdf.PdfPTable) r7
            r2.<init>((com.itextpdf.text.pdf.PdfPTable) r7)
            r11.a(r2)
            goto L_0x017e
        L_0x017b:
            r11.a(r13)
        L_0x017e:
            float r2 = r0.f26043e
            int r5 = (r2 > r15 ? 1 : (r2 == r15 ? 0 : -1))
            if (r5 <= 0) goto L_0x018d
            float r5 = r0.f26044f
            float r6 = r0.f26045g
            r11.l0(r5, r2, r6, r15)
        L_0x018b:
            r2 = 0
            goto L_0x0197
        L_0x018d:
            float r5 = r0.f26044f
            float r6 = r0.f26045g
            float r7 = r0.f26040b
            r11.l0(r5, r2, r6, r7)
            goto L_0x018b
        L_0x0197:
            r11.b0(r2)
            int r2 = r11.J(r4)
            float r5 = r0.f26043e
            int r5 = (r5 > r15 ? 1 : (r5 == r15 ? 0 : -1))
            if (r5 <= 0) goto L_0x01b5
            float r5 = r0.f26044f
            float r6 = r0.f26041c
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 > 0) goto L_0x01b7
            float r5 = r0.f26045g
            float r7 = r0.f26042d
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 >= 0) goto L_0x01b5
            goto L_0x01b7
        L_0x01b5:
            r5 = 0
            goto L_0x021f
        L_0x01b7:
            r5 = r2 & 1
            if (r5 != 0) goto L_0x01b5
            r0.f26043e = r15
            r0.f26044f = r6
            float r2 = r0.f26042d
            r0.f26045g = r2
            r5 = 0
            int r7 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x01d0
            int r7 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x01d0
            float r2 = r2 - r6
            r0.f26046h = r2
            goto L_0x01e0
        L_0x01d0:
            float r2 = r0.f26046h
            int r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x01d8
            r0.f26046h = r14
        L_0x01d8:
            float r2 = r0.f26046h
            int r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x01e0
            r0.f26046h = r12
        L_0x01e0:
            if (r4 == 0) goto L_0x01f1
            boolean r2 = r13 instanceof com.itextpdf.text.pdf.PdfPTable
            if (r2 == 0) goto L_0x01f1
            com.itextpdf.text.pdf.PdfPTable r2 = new com.itextpdf.text.pdf.PdfPTable
            r7 = r13
            com.itextpdf.text.pdf.PdfPTable r7 = (com.itextpdf.text.pdf.PdfPTable) r7
            r2.<init>((com.itextpdf.text.pdf.PdfPTable) r7)
            r11.a(r2)
        L_0x01f1:
            float r2 = r0.f26044f
            float r5 = r0.f26043e
            float r6 = r0.f26045g
            float r7 = r0.f26040b
            r11.l0(r2, r5, r6, r7)
            int r2 = r11.J(r4)
            float r5 = r11.H()
            float r6 = r11.r()
            float r5 = r5 + r6
            r0.f26043e = r5
            float r6 = r11.t()
            float r7 = r0.f26046h
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 <= 0) goto L_0x021b
            float r6 = r11.t()
            r0.f26046h = r6
        L_0x021b:
            r15 = r5
            r8 = 0
            r9 = 0
            goto L_0x025e
        L_0x021f:
            int r6 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r6 <= 0) goto L_0x022b
            float r6 = r11.t()
            float r8 = r12 + r6
        L_0x0229:
            r9 = r14
            goto L_0x0245
        L_0x022b:
            int r6 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            float r5 = r11.t()
            if (r6 <= 0) goto L_0x0237
            float r9 = r14 + r5
            r8 = r12
            goto L_0x0245
        L_0x0237:
            float r6 = r0.f26046h
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x0243
            float r5 = r11.t()
            r0.f26046h = r5
        L_0x0243:
            r8 = r12
            goto L_0x0229
        L_0x0245:
            float r5 = r11.H()
            float r6 = r11.r()
            float r5 = r5 + r6
            float r5 = java.lang.Math.min(r5, r15)
            float r6 = r11.H()
            float r7 = r11.r()
            float r6 = r6 + r7
            r0.f26043e = r6
            r15 = r5
        L_0x025e:
            r5 = r2 & 1
            if (r5 != 0) goto L_0x027e
            if (r4 != 0) goto L_0x0275
            java.util.List r3 = r11.p()
            r4 = 0
            r1.addAll(r4, r3)
            java.util.List r1 = r11.p()
            r1.clear()
            goto L_0x0093
        L_0x0275:
            r4 = 0
            r1.add(r4, r13)
            r11.r0(r3)
            goto L_0x0093
        L_0x027e:
            r11.r0(r3)
        L_0x0281:
            boolean r3 = r13 instanceof com.itextpdf.text.Paragraph
            if (r3 == 0) goto L_0x02d1
            r7 = r13
            com.itextpdf.text.Paragraph r7 = (com.itextpdf.text.Paragraph) r7
            java.util.Iterator r3 = r7.iterator()
        L_0x028c:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x02d1
            java.lang.Object r5 = r3.next()
            com.itextpdf.text.Element r5 = (com.itextpdf.text.Element) r5
            boolean r6 = r5 instanceof com.itextpdf.text.WritableDirectElement
            if (r6 == 0) goto L_0x028c
            com.itextpdf.text.WritableDirectElement r5 = (com.itextpdf.text.WritableDirectElement) r5
            int r6 = r5.c()
            r7 = 1
            if (r6 != r7) goto L_0x028c
            if (r4 != 0) goto L_0x028c
            com.itextpdf.text.pdf.ColumnText r6 = r0.f26047i
            com.itextpdf.text.pdf.PdfContentByte r6 = r6.n()
            com.itextpdf.text.pdf.PdfWriter r6 = r6.i1()
            com.itextpdf.text.pdf.ColumnText r7 = r0.f26047i
            com.itextpdf.text.pdf.PdfContentByte r7 = r7.n()
            com.itextpdf.text.pdf.PdfDocument r7 = r7.h1()
            float r10 = r7.B3
            float r12 = r7.R()
            float r14 = r0.f26043e
            float r12 = r12 - r14
            com.itextpdf.text.pdf.PdfDocument$Indentation r14 = r7.Q3
            float r14 = r14.f26194h
            float r12 = r12 - r14
            r7.B3 = r12
            r5.a(r6, r7)
            r7.B3 = r10
            goto L_0x028c
        L_0x02d1:
            if (r16 == 0) goto L_0x0304
            java.util.List r3 = r13.Y()
            int r3 = r3.size()
            if (r3 != 0) goto L_0x0304
            boolean r3 = r13 instanceof com.itextpdf.text.Paragraph
            if (r3 == 0) goto L_0x02fb
            r7 = r13
            com.itextpdf.text.Paragraph r7 = (com.itextpdf.text.Paragraph) r7
            r3 = 0
            java.lang.Object r5 = r7.get(r3)
            com.itextpdf.text.Element r5 = (com.itextpdf.text.Element) r5
            boolean r6 = r5 instanceof com.itextpdf.text.WritableDirectElement
            if (r6 == 0) goto L_0x02f9
            com.itextpdf.text.WritableDirectElement r5 = (com.itextpdf.text.WritableDirectElement) r5
            int r5 = r5.c()
            r6 = 1
            if (r5 == r6) goto L_0x0307
            goto L_0x0301
        L_0x02f9:
            r6 = 1
            goto L_0x0307
        L_0x02fb:
            r3 = 0
            r6 = 1
            boolean r5 = r13 instanceof com.itextpdf.text.api.Spaceable
            if (r5 == 0) goto L_0x0307
        L_0x0301:
            r16 = 0
            goto L_0x0307
        L_0x0304:
            r3 = 0
            r6 = 1
            goto L_0x0301
        L_0x0307:
            r10 = r4
            r12 = 0
            goto L_0x0023
        L_0x030b:
            r12 = r8
            r14 = r9
            goto L_0x0093
        L_0x030f:
            int r3 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x031f
            int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x031f
            float r1 = r0.f26042d
            float r3 = r0.f26041c
            float r1 = r1 - r3
            r0.f26046h = r1
            goto L_0x032f
        L_0x031f:
            float r1 = r0.f26046h
            int r1 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x0327
            r0.f26046h = r9
        L_0x0327:
            float r1 = r0.f26046h
            int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x032f
            r0.f26046h = r8
        L_0x032f:
            r0.f26043e = r15
            float r1 = r0.f26041c
            r0.f26044f = r1
            float r1 = r0.f26042d
            r0.f26045g = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.FloatLayout.a(java.util.List, boolean):int");
    }

    public float b() {
        return this.f26046h;
    }

    public int c() {
        return this.f26047i.D();
    }

    public float d() {
        return this.f26043e;
    }

    public int e(PdfContentByte pdfContentByte, boolean z) throws DocumentException {
        PdfDiv pdfDiv;
        PdfDiv pdfDiv2;
        this.f26047i.X(pdfContentByte);
        ArrayList arrayList = new ArrayList();
        List arrayList2 = z ? new ArrayList(this.f26048j) : this.f26048j;
        int i2 = 1;
        while (true) {
            if (arrayList2.isEmpty()) {
                break;
            }
            if (arrayList2.get(0) instanceof PdfDiv) {
                pdfDiv2 = (PdfDiv) arrayList2.get(0);
                PdfDiv.FloatType q = pdfDiv2.q();
                pdfDiv = pdfDiv2;
                if (q != PdfDiv.FloatType.LEFT) {
                    PdfDiv.FloatType q2 = pdfDiv2.q();
                    pdfDiv = pdfDiv2;
                    if (q2 != PdfDiv.FloatType.RIGHT) {
                        if (!arrayList.isEmpty()) {
                            i2 = a(arrayList, z);
                            if ((i2 & 1) == 0) {
                                break;
                            }
                        }
                        arrayList2.remove(0);
                        i2 = pdfDiv2.P(pdfContentByte, this.f26049k, true, this.f26044f, this.f26040b, this.f26045g, this.f26043e);
                        if (!pdfDiv2.u() || (i2 & 1) != 0 || (this.f26047i.n().h1().B3 <= 0.0f && this.f26043e == this.f26039a)) {
                            if (!z) {
                                pdfContentByte.B1(pdfDiv2);
                                i2 = pdfDiv2.P(pdfContentByte, this.f26049k, z, this.f26044f, this.f26040b, this.f26045g, this.f26043e);
                                pdfContentByte.c0(pdfDiv2);
                            }
                            if (pdfDiv2.f() > this.f26046h) {
                                this.f26046h = pdfDiv2.f();
                            }
                            if ((i2 & 1) == 0) {
                                arrayList2.add(0, pdfDiv2);
                                this.f26043e = pdfDiv2.O();
                                break;
                            }
                            this.f26043e -= pdfDiv2.e();
                        }
                    }
                }
            } else {
                pdfDiv = arrayList2.get(0);
            }
            arrayList.add(pdfDiv);
            arrayList2.remove(0);
        }
        arrayList2.add(0, pdfDiv2);
        if ((i2 & 1) != 0 && !arrayList.isEmpty()) {
            i2 = a(arrayList, z);
        }
        arrayList2.addAll(0, arrayList);
        return i2;
    }

    public void f(float f2) {
        this.f26046h = f2;
    }

    public void g(int i2) {
        this.f26047i.k0(i2);
    }

    public void h(float f2, float f3, float f4, float f5) {
        this.f26041c = Math.min(f2, f4);
        this.f26039a = Math.max(f3, f5);
        this.f26040b = Math.min(f3, f5);
        float max = Math.max(f2, f4);
        this.f26042d = max;
        this.f26044f = this.f26041c;
        this.f26045g = max;
        this.f26043e = this.f26039a;
        this.f26046h = 0.0f;
    }

    public void i(float f2) {
        this.f26043e = f2;
    }
}
