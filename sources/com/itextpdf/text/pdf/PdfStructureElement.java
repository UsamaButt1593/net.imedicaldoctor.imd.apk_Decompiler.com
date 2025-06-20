package com.itextpdf.text.pdf;

import com.itextpdf.text.AccessibleElementId;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListBody;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.ListLabel;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import com.itextpdf.text.pdf.interfaces.IPdfStructureElement;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;

public class PdfStructureElement extends PdfDictionary implements IPdfStructureElement {
    private transient PdfStructureElement p3;
    private transient PdfStructureTreeRoot q3;
    private AccessibleElementId r3;
    private PdfIndirectReference s3;
    private PdfName t3;

    protected PdfStructureElement(PdfDictionary pdfDictionary, PdfName pdfName, AccessibleElementId accessibleElementId) {
        PdfName pdfName2;
        PdfIndirectReference o1;
        this.r3 = accessibleElementId;
        if (pdfDictionary instanceof PdfStructureElement) {
            PdfStructureElement pdfStructureElement = (PdfStructureElement) pdfDictionary;
            this.q3 = pdfStructureElement.q3;
            s1(pdfDictionary, pdfName);
            this.p3 = pdfStructureElement;
            pdfName2 = PdfName.tc;
            o1 = pdfStructureElement.s3;
        } else if (pdfDictionary instanceof PdfStructureTreeRoot) {
            PdfStructureTreeRoot pdfStructureTreeRoot = (PdfStructureTreeRoot) pdfDictionary;
            this.q3 = pdfStructureTreeRoot;
            s1(pdfDictionary, pdfName);
            pdfName2 = PdfName.tc;
            o1 = pdfStructureTreeRoot.o1();
        } else {
            return;
        }
        V0(pdfName2, o1);
        V0(PdfName.Kg, PdfName.uf);
    }

    private void G1(int i2) {
        PdfName pdfName = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? null : PdfName.fa : PdfName.p7 : PdfName.Y4 : PdfName.mf;
        PdfStructureElement pdfStructureElement = this.p3;
        PdfName pdfName2 = PdfName.Rf;
        PdfObject o1 = o1(pdfStructureElement, pdfName2);
        if (o1 instanceof PdfName) {
            PdfName pdfName3 = (PdfName) o1;
            if (pdfName == null || pdfName3.equals(pdfName)) {
                return;
            }
        } else if (pdfName == null || PdfName.mf.equals(pdfName)) {
            return;
        }
        h(pdfName2, pdfName);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void I1(com.itextpdf.text.Chunk r11) {
        /*
            r10 = this;
            r0 = 1
            r1 = 0
            if (r11 == 0) goto L_0x010f
            com.itextpdf.text.Image r2 = r11.p()
            if (r2 == 0) goto L_0x0013
            com.itextpdf.text.Image r11 = r11.p()
            r10.K1(r11)
            goto L_0x010f
        L_0x0013:
            java.util.HashMap r2 = r11.h()
            if (r2 == 0) goto L_0x010f
            com.itextpdf.text.pdf.PdfName r3 = com.itextpdf.text.pdf.PdfName.Lb
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.sa
            r10.h(r3, r4)
            java.lang.String r3 = "UNDERLINE"
            boolean r4 = r2.containsKey(r3)
            if (r4 == 0) goto L_0x002f
            com.itextpdf.text.pdf.PdfName r4 = com.itextpdf.text.pdf.PdfName.Uf
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.Sg
            r10.h(r4, r5)
        L_0x002f:
            java.lang.String r4 = "BACKGROUND"
            boolean r5 = r2.containsKey(r4)
            if (r5 == 0) goto L_0x0069
            java.lang.Object r4 = r2.get(r4)
            java.lang.Object[] r4 = (java.lang.Object[]) r4
            r4 = r4[r1]
            com.itextpdf.text.BaseColor r4 = (com.itextpdf.text.BaseColor) r4
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.j4
            com.itextpdf.text.pdf.PdfArray r6 = new com.itextpdf.text.pdf.PdfArray
            int r7 = r4.g()
            float r7 = (float) r7
            r8 = 1132396544(0x437f0000, float:255.0)
            float r7 = r7 / r8
            int r9 = r4.e()
            float r9 = (float) r9
            float r9 = r9 / r8
            int r4 = r4.d()
            float r4 = (float) r4
            float r4 = r4 / r8
            r8 = 3
            float[] r8 = new float[r8]
            r8[r1] = r7
            r8[r0] = r9
            r7 = 2
            r8[r7] = r4
            r6.<init>((float[]) r8)
            r10.h(r5, r6)
        L_0x0069:
            com.itextpdf.text.pdf.PdfDictionary r4 = r10.n1(r0)
            com.itextpdf.text.pdf.interfaces.IPdfStructureElement r4 = (com.itextpdf.text.pdf.interfaces.IPdfStructureElement) r4
            com.itextpdf.text.pdf.PdfName r5 = com.itextpdf.text.pdf.PdfName.t5
            com.itextpdf.text.pdf.PdfObject r6 = r10.o1(r4, r5)
            com.itextpdf.text.Font r7 = r11.k()
            if (r7 == 0) goto L_0x0090
            com.itextpdf.text.Font r7 = r11.k()
            com.itextpdf.text.BaseColor r7 = r7.i()
            if (r7 == 0) goto L_0x0090
            com.itextpdf.text.Font r11 = r11.k()
            com.itextpdf.text.BaseColor r11 = r11.i()
            r10.w1(r11, r6, r5)
        L_0x0090:
            com.itextpdf.text.pdf.PdfName r11 = com.itextpdf.text.pdf.PdfName.Tf
            com.itextpdf.text.pdf.PdfObject r5 = r10.o1(r4, r11)
            com.itextpdf.text.pdf.PdfName r6 = com.itextpdf.text.pdf.PdfName.Sf
            com.itextpdf.text.pdf.PdfObject r7 = r10.o1(r4, r6)
            boolean r8 = r2.containsKey(r3)
            if (r8 == 0) goto L_0x00d9
            java.lang.Object r3 = r2.get(r3)
            java.lang.Object[][] r3 = (java.lang.Object[][]) r3
            int r8 = r3.length
            int r8 = r8 - r0
            r3 = r3[r8]
            r8 = r3[r1]
            com.itextpdf.text.BaseColor r8 = (com.itextpdf.text.BaseColor) r8
            r0 = r3[r0]
            float[] r0 = (float[]) r0
            r0 = r0[r1]
            boolean r1 = r5 instanceof com.itextpdf.text.pdf.PdfNumber
            if (r1 == 0) goto L_0x00cc
            com.itextpdf.text.pdf.PdfNumber r5 = (com.itextpdf.text.pdf.PdfNumber) r5
            float r1 = r5.a0()
            int r1 = java.lang.Float.compare(r0, r1)
            if (r1 == 0) goto L_0x00d4
            com.itextpdf.text.pdf.PdfNumber r1 = new com.itextpdf.text.pdf.PdfNumber
            r1.<init>((float) r0)
            goto L_0x00d1
        L_0x00cc:
            com.itextpdf.text.pdf.PdfNumber r1 = new com.itextpdf.text.pdf.PdfNumber
            r1.<init>((float) r0)
        L_0x00d1:
            r10.h(r11, r1)
        L_0x00d4:
            if (r8 == 0) goto L_0x00d9
            r10.w1(r8, r7, r6)
        L_0x00d9:
            java.lang.String r11 = "LINEHEIGHT"
            boolean r0 = r2.containsKey(r11)
            if (r0 == 0) goto L_0x010f
            java.lang.Object r11 = r2.get(r11)
            java.lang.Float r11 = (java.lang.Float) r11
            float r11 = r11.floatValue()
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.Ba
            com.itextpdf.text.pdf.PdfObject r1 = r10.o1(r4, r0)
            boolean r2 = r1 instanceof com.itextpdf.text.pdf.PdfNumber
            if (r2 == 0) goto L_0x0107
            com.itextpdf.text.pdf.PdfNumber r1 = (com.itextpdf.text.pdf.PdfNumber) r1
            float r1 = r1.a0()
            int r1 = java.lang.Float.compare(r1, r11)
            if (r1 == 0) goto L_0x010f
            com.itextpdf.text.pdf.PdfNumber r1 = new com.itextpdf.text.pdf.PdfNumber
            r1.<init>((float) r11)
            goto L_0x010c
        L_0x0107:
            com.itextpdf.text.pdf.PdfNumber r1 = new com.itextpdf.text.pdf.PdfNumber
            r1.<init>((float) r11)
        L_0x010c:
            r10.h(r0, r1)
        L_0x010f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfStructureElement.I1(com.itextpdf.text.Chunk):void");
    }

    private void J1(Document document) {
    }

    private void K1(Image image) {
        if (image != null) {
            h(PdfName.Lb, PdfName.sa);
            if (image.a0() > 0.0f) {
                h(PdfName.Jh, new PdfNumber(image.a0()));
            }
            if (image.N() > 0.0f) {
                h(PdfName.h9, new PdfNumber(image.N()));
            }
            h(PdfName.n4, new PdfRectangle((Rectangle) image, image.S()));
            if (image.k() != null) {
                BaseColor k2 = image.k();
                h(PdfName.j4, new PdfArray(new float[]{((float) k2.g()) / 255.0f, ((float) k2.e()) / 255.0f, ((float) k2.d()) / 255.0f}));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void L1(com.itextpdf.text.List r4) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x00c5
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.Lb
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Da
            r3.h(r0, r1)
            boolean r0 = r4.v()
            if (r0 == 0) goto L_0x0049
            boolean r0 = r4.C()
            if (r0 == 0) goto L_0x0033
            boolean r0 = r4.y()
            if (r0 == 0) goto L_0x002e
            boolean r0 = r4.A()
            if (r0 == 0) goto L_0x0029
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.Fa
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Ka
        L_0x0025:
            r3.h(r0, r1)
            goto L_0x0049
        L_0x0029:
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.Fa
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Vg
            goto L_0x0025
        L_0x002e:
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.Fa
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.l6
            goto L_0x0025
        L_0x0033:
            boolean r0 = r4.y()
            if (r0 == 0) goto L_0x0049
            boolean r0 = r4.A()
            if (r0 == 0) goto L_0x0044
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.Fa
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Ja
            goto L_0x0025
        L_0x0044:
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.Fa
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Ug
            goto L_0x0025
        L_0x0049:
            com.itextpdf.text.pdf.PdfStructureElement r0 = r3.p3
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.nf
            com.itextpdf.text.pdf.PdfObject r0 = r3.o1(r0, r1)
            boolean r2 = r0 instanceof com.itextpdf.text.pdf.PdfNumber
            if (r2 == 0) goto L_0x006f
            com.itextpdf.text.pdf.PdfNumber r0 = (com.itextpdf.text.pdf.PdfNumber) r0
            float r0 = r0.a0()
            float r2 = r4.m()
            int r0 = java.lang.Float.compare(r0, r2)
            if (r0 == 0) goto L_0x0088
            com.itextpdf.text.pdf.PdfNumber r0 = new com.itextpdf.text.pdf.PdfNumber
            float r2 = r4.m()
            r0.<init>((float) r2)
            goto L_0x0085
        L_0x006f:
            float r0 = r4.m()
            float r0 = java.lang.Math.abs(r0)
            r2 = 1
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0088
            com.itextpdf.text.pdf.PdfNumber r0 = new com.itextpdf.text.pdf.PdfNumber
            float r2 = r4.m()
            r0.<init>((float) r2)
        L_0x0085:
            r3.h(r1, r0)
        L_0x0088:
            com.itextpdf.text.pdf.PdfStructureElement r0 = r3.p3
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.q7
            com.itextpdf.text.pdf.PdfObject r0 = r3.o1(r0, r1)
            boolean r2 = r0 instanceof com.itextpdf.text.pdf.PdfNumber
            if (r2 == 0) goto L_0x00ae
            com.itextpdf.text.pdf.PdfNumber r0 = (com.itextpdf.text.pdf.PdfNumber) r0
            float r0 = r0.a0()
            float r2 = r4.q()
            int r0 = java.lang.Float.compare(r0, r2)
            if (r0 == 0) goto L_0x00c5
            com.itextpdf.text.pdf.PdfNumber r0 = new com.itextpdf.text.pdf.PdfNumber
            float r4 = r4.q()
            r0.<init>((float) r4)
            goto L_0x00c2
        L_0x00ae:
            float r0 = r4.q()
            r2 = 0
            int r0 = java.lang.Float.compare(r0, r2)
            if (r0 == 0) goto L_0x00c5
            com.itextpdf.text.pdf.PdfNumber r0 = new com.itextpdf.text.pdf.PdfNumber
            float r4 = r4.q()
            r0.<init>((float) r4)
        L_0x00c2:
            r3.h(r1, r0)
        L_0x00c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfStructureElement.L1(com.itextpdf.text.List):void");
    }

    private void M1(ListBody listBody) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void N1(com.itextpdf.text.ListItem r4) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x007e
            com.itextpdf.text.pdf.PdfStructureElement r0 = r3.p3
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.nf
            com.itextpdf.text.pdf.PdfObject r0 = r3.o1(r0, r1)
            boolean r2 = r0 instanceof com.itextpdf.text.pdf.PdfNumber
            if (r2 == 0) goto L_0x0028
            com.itextpdf.text.pdf.PdfNumber r0 = (com.itextpdf.text.pdf.PdfNumber) r0
            float r0 = r0.a0()
            float r2 = r4.m()
            int r0 = java.lang.Float.compare(r0, r2)
            if (r0 == 0) goto L_0x0041
            com.itextpdf.text.pdf.PdfNumber r0 = new com.itextpdf.text.pdf.PdfNumber
            float r2 = r4.m()
            r0.<init>((float) r2)
            goto L_0x003e
        L_0x0028:
            float r0 = r4.m()
            float r0 = java.lang.Math.abs(r0)
            r2 = 1
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0041
            com.itextpdf.text.pdf.PdfNumber r0 = new com.itextpdf.text.pdf.PdfNumber
            float r2 = r4.m()
            r0.<init>((float) r2)
        L_0x003e:
            r3.h(r1, r0)
        L_0x0041:
            com.itextpdf.text.pdf.PdfStructureElement r0 = r3.p3
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.q7
            com.itextpdf.text.pdf.PdfObject r0 = r3.o1(r0, r1)
            boolean r2 = r0 instanceof com.itextpdf.text.pdf.PdfNumber
            if (r2 == 0) goto L_0x0067
            com.itextpdf.text.pdf.PdfNumber r0 = (com.itextpdf.text.pdf.PdfNumber) r0
            float r0 = r0.a0()
            float r2 = r4.q()
            int r0 = java.lang.Float.compare(r0, r2)
            if (r0 == 0) goto L_0x007e
            com.itextpdf.text.pdf.PdfNumber r0 = new com.itextpdf.text.pdf.PdfNumber
            float r4 = r4.q()
            r0.<init>((float) r4)
            goto L_0x007b
        L_0x0067:
            float r0 = r4.q()
            r2 = 0
            int r0 = java.lang.Float.compare(r0, r2)
            if (r0 == 0) goto L_0x007e
            com.itextpdf.text.pdf.PdfNumber r0 = new com.itextpdf.text.pdf.PdfNumber
            float r4 = r4.q()
            r0.<init>((float) r4)
        L_0x007b:
            r3.h(r1, r0)
        L_0x007e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfStructureElement.N1(com.itextpdf.text.ListItem):void");
    }

    private void P1(ListLabel listLabel) {
        PdfNumber pdfNumber;
        if (listLabel != null) {
            PdfStructureElement pdfStructureElement = this.p3;
            PdfName pdfName = PdfName.nf;
            PdfObject o1 = o1(pdfStructureElement, pdfName);
            if (o1 instanceof PdfNumber) {
                if (Float.compare(((PdfNumber) o1).a0(), listLabel.a()) != 0) {
                    pdfNumber = new PdfNumber(listLabel.a());
                } else {
                    return;
                }
            } else if (Math.abs(listLabel.a()) > Float.MIN_VALUE) {
                pdfNumber = new PdfNumber(listLabel.a());
            } else {
                return;
            }
            h(pdfName, pdfNumber);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00fd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void Q1(com.itextpdf.text.Paragraph r7) {
        /*
            r6 = this;
            if (r7 == 0) goto L_0x011a
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.Lb
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.sa
            r6.h(r0, r1)
            float r0 = r7.E()
            r1 = 0
            int r0 = java.lang.Float.compare(r0, r1)
            if (r0 == 0) goto L_0x0022
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.bf
            com.itextpdf.text.pdf.PdfNumber r2 = new com.itextpdf.text.pdf.PdfNumber
            float r3 = r7.E()
            r2.<init>((float) r3)
            r6.h(r0, r2)
        L_0x0022:
            float r0 = r7.K()
            int r0 = java.lang.Float.compare(r0, r1)
            if (r0 == 0) goto L_0x003a
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.af
            com.itextpdf.text.pdf.PdfNumber r2 = new com.itextpdf.text.pdf.PdfNumber
            float r3 = r7.K()
            r2.<init>((float) r3)
            r6.h(r0, r2)
        L_0x003a:
            r0 = 1
            com.itextpdf.text.pdf.PdfDictionary r0 = r6.n1(r0)
            com.itextpdf.text.pdf.interfaces.IPdfStructureElement r0 = (com.itextpdf.text.pdf.interfaces.IPdfStructureElement) r0
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.t5
            com.itextpdf.text.pdf.PdfObject r3 = r6.o1(r0, r2)
            com.itextpdf.text.Font r4 = r7.q0()
            if (r4 == 0) goto L_0x0062
            com.itextpdf.text.Font r4 = r7.q0()
            com.itextpdf.text.BaseColor r4 = r4.i()
            if (r4 == 0) goto L_0x0062
            com.itextpdf.text.Font r4 = r7.q0()
            com.itextpdf.text.BaseColor r4 = r4.i()
            r6.w1(r4, r3, r2)
        L_0x0062:
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.Vf
            com.itextpdf.text.pdf.PdfObject r3 = r6.o1(r0, r2)
            float r4 = r7.A1()
            int r4 = java.lang.Float.compare(r4, r1)
            if (r4 == 0) goto L_0x009c
            boolean r4 = r3 instanceof com.itextpdf.text.pdf.PdfNumber
            if (r4 == 0) goto L_0x0090
            com.itextpdf.text.pdf.PdfNumber r3 = (com.itextpdf.text.pdf.PdfNumber) r3
            float r3 = r3.a0()
            java.lang.Float r4 = new java.lang.Float
            float r5 = r7.A1()
            r4.<init>(r5)
            float r4 = r4.floatValue()
            int r3 = java.lang.Float.compare(r3, r4)
            if (r3 != 0) goto L_0x0090
            goto L_0x009c
        L_0x0090:
            com.itextpdf.text.pdf.PdfNumber r3 = new com.itextpdf.text.pdf.PdfNumber
            float r4 = r7.A1()
            r3.<init>((float) r4)
            r6.h(r2, r3)
        L_0x009c:
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.nf
            com.itextpdf.text.pdf.PdfObject r3 = r6.o1(r0, r2)
            boolean r4 = r3 instanceof com.itextpdf.text.pdf.PdfNumber
            if (r4 == 0) goto L_0x00c0
            com.itextpdf.text.pdf.PdfNumber r3 = (com.itextpdf.text.pdf.PdfNumber) r3
            float r3 = r3.a0()
            float r4 = r7.m()
            int r3 = java.lang.Float.compare(r3, r4)
            if (r3 == 0) goto L_0x00d9
            com.itextpdf.text.pdf.PdfNumber r3 = new com.itextpdf.text.pdf.PdfNumber
            float r4 = r7.m()
            r3.<init>((float) r4)
            goto L_0x00d6
        L_0x00c0:
            float r3 = r7.m()
            float r3 = java.lang.Math.abs(r3)
            r4 = 1
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x00d9
            com.itextpdf.text.pdf.PdfNumber r3 = new com.itextpdf.text.pdf.PdfNumber
            float r4 = r7.m()
            r3.<init>((float) r4)
        L_0x00d6:
            r6.h(r2, r3)
        L_0x00d9:
            com.itextpdf.text.pdf.PdfName r2 = com.itextpdf.text.pdf.PdfName.q7
            com.itextpdf.text.pdf.PdfObject r0 = r6.o1(r0, r2)
            boolean r3 = r0 instanceof com.itextpdf.text.pdf.PdfNumber
            if (r3 == 0) goto L_0x00fd
            com.itextpdf.text.pdf.PdfNumber r0 = (com.itextpdf.text.pdf.PdfNumber) r0
            float r0 = r0.a0()
            float r1 = r7.q()
            int r0 = java.lang.Float.compare(r0, r1)
            if (r0 == 0) goto L_0x0113
            com.itextpdf.text.pdf.PdfNumber r0 = new com.itextpdf.text.pdf.PdfNumber
            float r1 = r7.q()
            r0.<init>((float) r1)
            goto L_0x0110
        L_0x00fd:
            float r0 = r7.q()
            int r0 = java.lang.Float.compare(r0, r1)
            if (r0 == 0) goto L_0x0113
            com.itextpdf.text.pdf.PdfNumber r0 = new com.itextpdf.text.pdf.PdfNumber
            float r1 = r7.q()
            r0.<init>((float) r1)
        L_0x0110:
            r6.h(r2, r0)
        L_0x0113:
            int r7 = r7.y1()
            r6.G1(r7)
        L_0x011a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfStructureElement.Q1(com.itextpdf.text.Paragraph):void");
    }

    private void V1(PdfDiv pdfDiv) {
        if (pdfDiv != null) {
            if (pdfDiv.g() != null) {
                w1(pdfDiv.g(), (PdfObject) null, PdfName.j4);
            }
            G1(pdfDiv.I());
        }
    }

    private void W1(PdfPCell pdfPCell) {
        if (pdfPCell != null) {
            h(PdfName.Lb, PdfName.Kf);
            if (pdfPCell.J0() != 1) {
                h(PdfName.E5, new PdfNumber(pdfPCell.J0()));
            }
            if (pdfPCell.g1() != 1) {
                h(PdfName.we, new PdfNumber(pdfPCell.g1()));
            }
            if (pdfPCell.T0() != null) {
                PdfArray pdfArray = new PdfArray();
                Iterator<PdfPHeaderCell> it2 = pdfPCell.T0().iterator();
                while (it2.hasNext()) {
                    PdfPHeaderCell next = it2.next();
                    if (next.V1() != null) {
                        pdfArray.a0(new PdfString(next.V1()));
                    }
                }
                if (!pdfArray.isEmpty()) {
                    h(PdfName.g9, pdfArray);
                }
            }
            if (pdfPCell.H0() > 0.0f) {
                h(PdfName.h9, new PdfNumber(pdfPCell.H0()));
            }
            if (pdfPCell.a0() > 0.0f) {
                h(PdfName.Jh, new PdfNumber(pdfPCell.a0()));
            }
            if (pdfPCell.k() != null) {
                BaseColor k2 = pdfPCell.k();
                h(PdfName.j4, new PdfArray(new float[]{((float) k2.g()) / 255.0f, ((float) k2.e()) / 255.0f, ((float) k2.d()) / 255.0f}));
            }
        }
    }

    private void X1(PdfPHeaderCell pdfPHeaderCell) {
        PdfName pdfName;
        PdfName pdfName2;
        if (pdfPHeaderCell != null) {
            if (pdfPHeaderCell.W1() != 0) {
                int W1 = pdfPHeaderCell.W1();
                if (W1 == 1) {
                    pdfName = PdfName.Fe;
                    pdfName2 = PdfName.ue;
                } else if (W1 == 2) {
                    pdfName = PdfName.Fe;
                    pdfName2 = PdfName.F5;
                } else if (W1 == 3) {
                    pdfName = PdfName.Fe;
                    pdfName2 = PdfName.E4;
                }
                h(pdfName, pdfName2);
            }
            if (pdfPHeaderCell.V1() != null) {
                h(PdfName.qb, new PdfName(pdfPHeaderCell.V1()));
            }
            W1(pdfPHeaderCell);
        }
    }

    private void Y1(PdfPRow pdfPRow) {
        if (pdfPRow != null) {
            h(PdfName.Lb, PdfName.Kf);
        }
    }

    private void Z1(PdfPTable pdfPTable) {
        if (pdfPTable != null) {
            h(PdfName.Lb, PdfName.Kf);
            if (Float.compare(pdfPTable.E(), 0.0f) != 0) {
                h(PdfName.bf, new PdfNumber(pdfPTable.E()));
            }
            if (Float.compare(pdfPTable.K(), 0.0f) != 0) {
                h(PdfName.af, new PdfNumber(pdfPTable.K()));
            }
            if (pdfPTable.l0() > 0.0f) {
                h(PdfName.h9, new PdfNumber(pdfPTable.l0()));
            }
            if (pdfPTable.m0() > 0.0f) {
                h(PdfName.Jh, new PdfNumber(pdfPTable.m0()));
            }
        }
    }

    private void c2(PdfPTableBody pdfPTableBody) {
    }

    private boolean f1(PdfArray pdfArray, float[] fArr) {
        return Float.compare(fArr[0], pdfArray.J0(0).a0()) == 0 && Float.compare(fArr[1], pdfArray.J0(1).a0()) == 0 && Float.compare(fArr[2], pdfArray.J0(2).a0()) == 0;
    }

    private void h2(PdfPTableFooter pdfPTableFooter) {
    }

    private void i2(PdfPTableHeader pdfPTableHeader) {
        if (pdfPTableHeader != null) {
            h(PdfName.Lb, PdfName.Kf);
        }
    }

    private void j2(PdfTemplate pdfTemplate) {
        if (pdfTemplate != null) {
            h(PdfName.Lb, PdfName.sa);
            if (pdfTemplate.P3() > 0.0f) {
                h(PdfName.Jh, new PdfNumber(pdfTemplate.P3()));
            }
            if (pdfTemplate.I3() > 0.0f) {
                h(PdfName.h9, new PdfNumber(pdfTemplate.I3()));
            }
            h(PdfName.n4, new PdfRectangle(pdfTemplate.F3()));
        }
    }

    private PdfObject o1(IPdfStructureElement iPdfStructureElement, PdfName pdfName) {
        if (iPdfStructureElement == null) {
            return null;
        }
        return iPdfStructureElement.b(pdfName);
    }

    private void s1(PdfDictionary pdfDictionary, PdfName pdfName) {
        PdfArray pdfArray;
        PdfDictionary B0;
        if (!this.q3.p1().K1().contains(pdfName)) {
            PdfDictionary j0 = this.q3.j0(PdfName.re);
            if (j0 == null || !j0.a0(pdfName)) {
                throw new ExceptionConverter(new DocumentException(MessageLocalization.b("unknown.structure.element.role.1", pdfName.toString())));
            }
            this.t3 = j0.p0(pdfName);
        } else {
            this.t3 = pdfName;
        }
        PdfName pdfName2 = PdfName.ga;
        PdfObject d0 = pdfDictionary.d0(pdfName2);
        if (d0 == null) {
            pdfArray = new PdfArray();
            pdfDictionary.V0(pdfName2, pdfArray);
        } else if (d0 instanceof PdfArray) {
            pdfArray = (PdfArray) d0;
        } else {
            PdfArray pdfArray2 = new PdfArray();
            pdfArray2.a0(d0);
            pdfDictionary.V0(pdfName2, pdfArray2);
            pdfArray = pdfArray2;
        }
        if (pdfArray.size() > 0) {
            if (pdfArray.J0(0) != null) {
                pdfArray.U0(0);
            }
            if (pdfArray.size() > 0 && (B0 = pdfArray.B0(0)) != null && PdfName.bb.equals(B0.p0(PdfName.Kg))) {
                pdfArray.U0(0);
            }
        }
        V0(PdfName.Ce, pdfName);
        PdfIndirectReference D1 = this.q3.p1().D1();
        this.s3 = D1;
        pdfArray.a0(D1);
    }

    private void w1(BaseColor baseColor, PdfObject pdfObject, PdfName pdfName) {
        float[] fArr = {((float) baseColor.g()) / 255.0f, ((float) baseColor.e()) / 255.0f, ((float) baseColor.d()) / 255.0f};
        h(pdfName, (pdfObject == null || !(pdfObject instanceof PdfArray)) ? new PdfArray(fArr) : f1((PdfArray) pdfObject, fArr) ? new PdfArray(fArr) : new PdfArray(fArr));
    }

    /* access modifiers changed from: protected */
    public void B1(PdfStructureElement pdfStructureElement) {
        this.p3 = pdfStructureElement;
    }

    /* access modifiers changed from: protected */
    public void E1(PdfStructureTreeRoot pdfStructureTreeRoot) {
        this.q3 = pdfStructureTreeRoot;
    }

    public void T(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        PdfWriter.G0(pdfWriter, 16, this);
        super.T(pdfWriter, outputStream);
    }

    public PdfObject b(PdfName pdfName) {
        PdfDictionary j0 = j0(PdfName.k3);
        if (j0 != null && j0.a0(pdfName)) {
            return j0.d0(pdfName);
        }
        PdfDictionary m1 = m1();
        if (m1 instanceof PdfStructureElement) {
            return ((PdfStructureElement) m1).b(pdfName);
        }
        return m1 instanceof PdfStructureTreeRoot ? ((PdfStructureTreeRoot) m1).b(pdfName) : new PdfNull();
    }

    public void h(PdfName pdfName, PdfObject pdfObject) {
        PdfName pdfName2 = PdfName.k3;
        PdfDictionary j0 = j0(pdfName2);
        if (j0 == null) {
            j0 = new PdfDictionary();
            V0(pdfName2, j0);
        }
        j0.V0(pdfName, pdfObject);
    }

    /* access modifiers changed from: protected */
    public AccessibleElementId i1() {
        return this.r3;
    }

    public void k2(IAccessibleElement iAccessibleElement) {
        if (iAccessibleElement instanceof ListItem) {
            N1((ListItem) iAccessibleElement);
        } else if (iAccessibleElement instanceof Paragraph) {
            Q1((Paragraph) iAccessibleElement);
        } else if (iAccessibleElement instanceof Chunk) {
            I1((Chunk) iAccessibleElement);
        } else if (iAccessibleElement instanceof Image) {
            K1((Image) iAccessibleElement);
        } else if (iAccessibleElement instanceof List) {
            L1((List) iAccessibleElement);
        } else if (iAccessibleElement instanceof ListLabel) {
            P1((ListLabel) iAccessibleElement);
        } else if (iAccessibleElement instanceof ListBody) {
            M1((ListBody) iAccessibleElement);
        } else if (iAccessibleElement instanceof PdfPTable) {
            Z1((PdfPTable) iAccessibleElement);
        } else if (iAccessibleElement instanceof PdfPRow) {
            Y1((PdfPRow) iAccessibleElement);
        } else if (iAccessibleElement instanceof PdfPHeaderCell) {
            X1((PdfPHeaderCell) iAccessibleElement);
        } else if (iAccessibleElement instanceof PdfPCell) {
            W1((PdfPCell) iAccessibleElement);
        } else if (iAccessibleElement instanceof PdfPTableHeader) {
            i2((PdfPTableHeader) iAccessibleElement);
        } else if (iAccessibleElement instanceof PdfPTableFooter) {
            h2((PdfPTableFooter) iAccessibleElement);
        } else if (iAccessibleElement instanceof PdfPTableBody) {
            c2((PdfPTableBody) iAccessibleElement);
        } else if (iAccessibleElement instanceof PdfDiv) {
            V1((PdfDiv) iAccessibleElement);
        } else if (iAccessibleElement instanceof PdfTemplate) {
            j2((PdfTemplate) iAccessibleElement);
        } else if (iAccessibleElement instanceof Document) {
            J1((Document) iAccessibleElement);
        }
        if (iAccessibleElement.k0() != null) {
            for (PdfName next : iAccessibleElement.k0().keySet()) {
                if (next.equals(PdfName.A9)) {
                    PdfObject r = iAccessibleElement.r(next);
                    V0(next, r);
                    this.q3.v1(r.toString(), p1());
                } else if (next.equals(PdfName.ma) || next.equals(PdfName.J3) || next.equals(PdfName.t3) || next.equals(PdfName.c7) || next.equals(PdfName.If)) {
                    V0(next, iAccessibleElement.r(next));
                } else {
                    h(next, iAccessibleElement.r(next));
                }
            }
        }
    }

    public PdfDictionary m1() {
        return n1(false);
    }

    public PdfDictionary n1(boolean z) {
        PdfStructureElement pdfStructureElement = this.p3;
        return (pdfStructureElement != null || !z) ? pdfStructureElement : this.q3;
    }

    public PdfIndirectReference p1() {
        return this.s3;
    }

    public PdfName q1() {
        return this.t3;
    }

    /* access modifiers changed from: package-private */
    public void v1(PdfAnnotation pdfAnnotation, PdfIndirectReference pdfIndirectReference) {
        PdfName pdfName = PdfName.ga;
        PdfArray e0 = e0(pdfName);
        if (e0 == null) {
            e0 = new PdfArray();
            PdfObject d0 = d0(pdfName);
            if (d0 != null) {
                e0.a0(d0);
            }
            V0(pdfName, e0);
        }
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.V0(PdfName.Kg, PdfName.Nb);
        pdfDictionary.V0(PdfName.Mb, pdfAnnotation.L1());
        if (pdfAnnotation.L() == PdfName.w8) {
            pdfDictionary.V0(PdfName.Rc, pdfIndirectReference);
        }
        e0.a0(pdfDictionary);
    }

    /* access modifiers changed from: package-private */
    public void x1(int i2, int i3) {
        if (i3 >= 0) {
            V0(PdfName.ga, new PdfNumber(i3));
        }
        this.q3.x1(i2, this.s3);
    }

    public PdfStructureElement(PdfStructureElement pdfStructureElement, PdfName pdfName) {
        this.q3 = pdfStructureElement.q3;
        s1(pdfStructureElement, pdfName);
        this.p3 = pdfStructureElement;
        V0(PdfName.tc, pdfStructureElement.s3);
        V0(PdfName.Kg, PdfName.uf);
    }

    public PdfStructureElement(PdfStructureTreeRoot pdfStructureTreeRoot, PdfName pdfName) {
        this.q3 = pdfStructureTreeRoot;
        s1(pdfStructureTreeRoot, pdfName);
        V0(PdfName.tc, pdfStructureTreeRoot.o1());
        V0(PdfName.Kg, PdfName.uf);
    }
}
