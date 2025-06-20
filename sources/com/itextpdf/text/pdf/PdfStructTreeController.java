package com.itextpdf.text.pdf;

import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class PdfStructTreeController {

    /* renamed from: a  reason: collision with root package name */
    private PdfDictionary f26338a;

    /* renamed from: b  reason: collision with root package name */
    private PdfCopy f26339b;

    /* renamed from: c  reason: collision with root package name */
    private PdfStructureTreeRoot f26340c;

    /* renamed from: d  reason: collision with root package name */
    private PdfDictionary f26341d;

    /* renamed from: e  reason: collision with root package name */
    protected PdfReader f26342e;

    /* renamed from: f  reason: collision with root package name */
    private PdfDictionary f26343f = null;

    /* renamed from: g  reason: collision with root package name */
    private PdfDictionary f26344g = null;

    /* renamed from: h  reason: collision with root package name */
    private PdfDictionary f26345h = null;

    /* renamed from: i  reason: collision with root package name */
    private PdfIndirectReference f26346i = null;

    /* renamed from: com.itextpdf.text.pdf.PdfStructTreeController$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f26347a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.itextpdf.text.pdf.PdfStructTreeController$returnType[] r0 = com.itextpdf.text.pdf.PdfStructTreeController.returnType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f26347a = r0
                com.itextpdf.text.pdf.PdfStructTreeController$returnType r1 = com.itextpdf.text.pdf.PdfStructTreeController.returnType.FOUND     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f26347a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.itextpdf.text.pdf.PdfStructTreeController$returnType r1 = com.itextpdf.text.pdf.PdfStructTreeController.returnType.ABOVE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f26347a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.itextpdf.text.pdf.PdfStructTreeController$returnType r1 = com.itextpdf.text.pdf.PdfStructTreeController.returnType.BELOW     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfStructTreeController.AnonymousClass1.<clinit>():void");
        }
    }

    public enum returnType {
        BELOW,
        FOUND,
        ABOVE,
        NOTFOUND
    }

    protected PdfStructTreeController(PdfReader pdfReader, PdfCopy pdfCopy) throws BadPdfFormatException {
        if (pdfCopy.X1()) {
            this.f26339b = pdfCopy;
            PdfStructureTreeRoot L1 = pdfCopy.L1();
            this.f26340c = L1;
            L1.V0(PdfName.Ec, new PdfDictionary(PdfName.uf));
            o(pdfReader);
            return;
        }
        throw new BadPdfFormatException(MessageLocalization.b("no.structtreeroot.found", new Object[0]));
    }

    private void c(PdfObject pdfObject) throws IOException, BadPdfFormatException {
        if (pdfObject.C()) {
            PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
            RefKey refKey = new RefKey(pRIndirectReference);
            if (!this.f26339b.V5.containsKey(refKey)) {
                this.f26339b.k3(pRIndirectReference, true, false);
            }
            PdfIndirectReference b2 = this.f26339b.V5.get(refKey).b();
            if (this.f26339b.k6) {
                b(this.f26340c, b2);
                this.f26339b.T3(this.f26342e);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r2 = m(((com.itextpdf.text.pdf.PdfDictionary) r2).d0(com.itextpdf.text.pdf.PdfName.Ec));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean f(com.itextpdf.text.pdf.PdfReader r2) {
        /*
            com.itextpdf.text.pdf.PdfDictionary r2 = r2.F()
            com.itextpdf.text.pdf.PdfName r0 = com.itextpdf.text.pdf.PdfName.xf
            com.itextpdf.text.pdf.PdfObject r2 = r2.d0(r0)
            com.itextpdf.text.pdf.PdfObject r2 = m(r2)
            r0 = 0
            if (r2 == 0) goto L_0x002f
            boolean r1 = r2.z()
            if (r1 != 0) goto L_0x0018
            goto L_0x002f
        L_0x0018:
            com.itextpdf.text.pdf.PdfDictionary r2 = (com.itextpdf.text.pdf.PdfDictionary) r2
            com.itextpdf.text.pdf.PdfName r1 = com.itextpdf.text.pdf.PdfName.Ec
            com.itextpdf.text.pdf.PdfObject r2 = r2.d0(r1)
            com.itextpdf.text.pdf.PdfObject r2 = m(r2)
            if (r2 == 0) goto L_0x002f
            boolean r2 = r2.z()
            if (r2 != 0) goto L_0x002d
            goto L_0x002f
        L_0x002d:
            r2 = 1
            return r2
        L_0x002f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfStructTreeController.f(com.itextpdf.text.pdf.PdfReader):boolean");
    }

    public static boolean g(PdfObject pdfObject, PdfObject pdfObject2) {
        String str;
        PdfObject m2 = m(pdfObject2);
        if (m2 == null || pdfObject.W() != m2.W()) {
            return false;
        }
        if (pdfObject.x()) {
            if (pdfObject == m2) {
                return true;
            }
            return (m2 instanceof PdfBoolean) && ((PdfBoolean) pdfObject).Z() == ((PdfBoolean) m2).Z();
        } else if (pdfObject.E()) {
            return pdfObject.equals(m2);
        } else {
            if (pdfObject.I()) {
                if (pdfObject == m2) {
                    return true;
                }
                return (m2 instanceof PdfNumber) && ((PdfNumber) pdfObject).Z() == ((PdfNumber) m2).Z();
            } else if (pdfObject.H()) {
                return pdfObject == m2 || (m2 instanceof PdfNull);
            } else {
                if (pdfObject.N()) {
                    if (pdfObject == m2) {
                        return true;
                    }
                    if (!(m2 instanceof PdfString)) {
                        return false;
                    }
                    String str2 = ((PdfString) m2).i3;
                    return (str2 == null && ((PdfString) pdfObject).i3 == null) || ((str = ((PdfString) pdfObject).i3) != null && str.equals(str2));
                } else if (pdfObject.q()) {
                    PdfArray pdfArray = (PdfArray) pdfObject;
                    PdfArray pdfArray2 = (PdfArray) m2;
                    if (pdfArray.size() != pdfArray2.size()) {
                        return false;
                    }
                    for (int i2 = 0; i2 < pdfArray.size(); i2++) {
                        if (!g(pdfArray.T0(i2), pdfArray2.T0(i2))) {
                            return false;
                        }
                    }
                    return true;
                } else if (!pdfObject.z()) {
                    return false;
                } else {
                    PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
                    PdfDictionary pdfDictionary2 = (PdfDictionary) m2;
                    if (pdfDictionary.size() != pdfDictionary2.size()) {
                        return false;
                    }
                    for (PdfName next : pdfDictionary.j3.keySet()) {
                        if (!g(pdfDictionary.d0(next), pdfDictionary2.d0(next))) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
    }

    private returnType h(PdfDictionary pdfDictionary, PdfNumber pdfNumber, int i2) throws BadPdfFormatException, IOException {
        PdfArray pdfArray = (PdfArray) m(pdfDictionary.d0(PdfName.Kb));
        if (pdfArray != null) {
            return pdfArray.size() == 0 ? returnType.NOTFOUND : j(pdfArray, pdfNumber.e0(), i2);
        }
        PdfArray pdfArray2 = (PdfArray) m(pdfDictionary.d0(PdfName.ia));
        if (pdfArray2 == null) {
            return returnType.NOTFOUND;
        }
        int size = pdfArray2.size() / 2;
        int i3 = 0;
        while (true) {
            int i4 = size + i3;
            int i5 = AnonymousClass1.f26347a[h((PdfDictionary) m(pdfArray2.T0(i4)), pdfNumber, i2).ordinal()];
            int i6 = 1;
            if (i5 == 1) {
                return returnType.FOUND;
            }
            if (i5 == 2) {
                int i7 = size / 2;
                if (i7 != 0) {
                    i6 = i7;
                }
                if (i6 + i4 == pdfArray2.size()) {
                    return returnType.ABOVE;
                }
                i3 = i4;
                size = i6;
            } else if (i5 != 3) {
                return returnType.NOTFOUND;
            } else {
                if (i4 == 0) {
                    return returnType.BELOW;
                }
                if (size == 0) {
                    return returnType.NOTFOUND;
                }
                size /= 2;
            }
        }
    }

    private returnType j(PdfArray pdfArray, int i2, int i3) throws BadPdfFormatException, IOException {
        if (pdfArray.J0(0).e0() > i2) {
            return returnType.BELOW;
        }
        if (pdfArray.J0(pdfArray.size() - 2).e0() < i2) {
            return returnType.ABOVE;
        }
        int size = pdfArray.size() / 4;
        int i4 = 0;
        while (true) {
            int i5 = i4 + size;
            int i6 = i5 * 2;
            int e0 = pdfArray.J0(i6).e0();
            if (e0 == i2) {
                PdfObject T0 = pdfArray.T0(i6 + 1);
                PdfObject pdfObject = T0;
                while (pdfObject.C()) {
                    pdfObject = PdfReader.w0(pdfObject);
                }
                if (pdfObject.q()) {
                    Iterator<PdfObject> it2 = ((PdfArray) pdfObject).iterator();
                    PdfObject pdfObject2 = null;
                    while (it2.hasNext()) {
                        PdfObject next = it2.next();
                        if (next.H()) {
                            if (this.f26346i == null) {
                                this.f26346i = this.f26339b.v0(new PdfNull()).a();
                            }
                            this.f26340c.x1(i3, this.f26346i);
                        } else {
                            PdfObject m3 = this.f26339b.m3(next, true, false);
                            if (pdfObject2 == null) {
                                pdfObject2 = m3;
                            }
                            this.f26340c.x1(i3, (PdfIndirectReference) m3);
                        }
                    }
                    e(pdfObject2);
                } else if (!pdfObject.z()) {
                    return returnType.NOTFOUND;
                } else {
                    if (n((PdfDictionary) pdfObject) == null) {
                        return returnType.NOTFOUND;
                    }
                    this.f26340c.w1(i3, (PdfIndirectReference) this.f26339b.m3(T0, true, false));
                }
                return returnType.FOUND;
            } else if (e0 < i2) {
                if (size == 0) {
                    return returnType.NOTFOUND;
                }
                if (size != 1) {
                    size /= 2;
                }
                if (size + i5 == pdfArray.size()) {
                    return returnType.NOTFOUND;
                }
                i4 = i5;
            } else if (i5 == 0) {
                return returnType.BELOW;
            } else {
                if (size == 0) {
                    return returnType.NOTFOUND;
                }
                size /= 2;
            }
        }
    }

    private static PdfArray k(PdfArray pdfArray) {
        PdfArray pdfArray2 = new PdfArray();
        for (int i2 = 0; i2 < pdfArray.size(); i2++) {
            PdfObject m2 = m(pdfArray.T0(i2));
            if (m2 != null) {
                if (m2.q()) {
                    m2 = k((PdfArray) m2);
                } else if (m2.z()) {
                    m2 = l((PdfDictionary) m2);
                }
                pdfArray2.a0(m2);
            }
        }
        return pdfArray2;
    }

    private static PdfDictionary l(PdfDictionary pdfDictionary) {
        PdfName pdfName;
        PdfDictionary pdfDictionary2 = new PdfDictionary();
        for (Map.Entry next : pdfDictionary.j3.entrySet()) {
            PdfObject m2 = m((PdfObject) next.getValue());
            if (m2 != null) {
                if (m2.q()) {
                    pdfName = (PdfName) next.getKey();
                    m2 = k((PdfArray) m2);
                } else {
                    boolean z = m2.z();
                    pdfName = (PdfName) next.getKey();
                    if (z) {
                        m2 = l((PdfDictionary) m2);
                    }
                }
                pdfDictionary2.V0(pdfName, m2);
            }
        }
        return pdfDictionary2;
    }

    public static PdfObject m(PdfObject pdfObject) {
        if (pdfObject == null) {
            return null;
        }
        while (pdfObject.C()) {
            pdfObject = PdfReader.w0(pdfObject);
        }
        return pdfObject;
    }

    static PdfDictionary n(PdfDictionary pdfDictionary) {
        PdfName pdfName = PdfName.ga;
        PdfDictionary j0 = pdfDictionary.j0(pdfName);
        if (j0 == null) {
            PdfArray e0 = pdfDictionary.e0(pdfName);
            if (e0 == null) {
                return null;
            }
            for (int i2 = 0; i2 < e0.size(); i2++) {
                PdfDictionary B0 = e0.B0(i2);
                if (B0 != null && PdfName.Nb.equals(B0.p0(PdfName.Kg))) {
                    return B0;
                }
            }
        } else if (PdfName.Nb.equals(j0.p0(PdfName.Kg))) {
            return j0;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void a(PdfObject pdfObject) throws BadPdfFormatException {
        PdfStructureTreeRoot pdfStructureTreeRoot;
        PdfObject k2;
        PdfObject m2 = m(pdfObject);
        if (m2.z()) {
            PdfObject d0 = ((PdfDictionary) m2).d0(PdfName.K4);
            if (d0 != null) {
                if (d0.q()) {
                    PdfArray pdfArray = (PdfArray) d0;
                    for (int i2 = 0; i2 < pdfArray.size(); i2++) {
                        a(pdfArray.T0(i2));
                    }
                } else if (d0.E()) {
                    a(d0);
                }
            }
        } else if (m2.E()) {
            PdfName pdfName = (PdfName) m2;
            if (this.f26345h == null) {
                PdfObject m3 = m(this.f26338a.d0(PdfName.o5));
                if (m3 != null && m3.z()) {
                    this.f26345h = (PdfDictionary) m3;
                } else {
                    return;
                }
            }
            PdfObject m4 = m(this.f26345h.d0(pdfName));
            if (m4 != null) {
                PdfObject m1 = this.f26340c.m1(pdfName);
                if (m1 == null) {
                    if (m4.z()) {
                        pdfStructureTreeRoot = this.f26340c;
                        k2 = l((PdfDictionary) m4);
                    } else if (m4.q()) {
                        pdfStructureTreeRoot = this.f26340c;
                        k2 = k((PdfArray) m4);
                    } else {
                        return;
                    }
                    pdfStructureTreeRoot.q1(pdfName, k2);
                } else if (!g(m1, m4)) {
                    throw new BadPdfFormatException(MessageLocalization.b("conflict.in.classmap", pdfName));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void b(PdfDictionary pdfDictionary, PdfObject pdfObject) {
        PdfArray pdfArray;
        PdfName pdfName = PdfName.ga;
        PdfObject d0 = pdfDictionary.d0(pdfName);
        if (d0 instanceof PdfArray) {
            pdfArray = (PdfArray) d0;
        } else {
            PdfArray pdfArray2 = new PdfArray();
            if (d0 != null) {
                pdfArray2.a0(d0);
            }
            pdfArray = pdfArray2;
        }
        pdfArray.a0(pdfObject);
        pdfDictionary.V0(pdfName, pdfArray);
    }

    /* access modifiers changed from: protected */
    public void d(PdfName pdfName) throws BadPdfFormatException {
        if (pdfName != null) {
            for (PdfName equals : this.f26339b.K1()) {
                if (equals.equals(pdfName)) {
                    return;
                }
            }
            if (this.f26344g == null) {
                PdfObject m2 = m(this.f26338a.d0(PdfName.re));
                if (m2 != null && m2.z()) {
                    this.f26344g = (PdfDictionary) m2;
                } else {
                    return;
                }
            }
            PdfObject d0 = this.f26344g.d0(pdfName);
            if (d0 != null && d0.E()) {
                PdfDictionary pdfDictionary = this.f26343f;
                if (pdfDictionary == null) {
                    PdfDictionary pdfDictionary2 = new PdfDictionary();
                    this.f26343f = pdfDictionary2;
                    this.f26340c.V0(PdfName.re, pdfDictionary2);
                } else {
                    PdfObject d02 = pdfDictionary.d0(pdfName);
                    if (d02 != null) {
                        if (!d02.equals(d0)) {
                            throw new BadPdfFormatException(MessageLocalization.b("conflict.in.rolemap", d0));
                        }
                        return;
                    }
                }
                this.f26343f.V0(pdfName, d0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void e(PdfObject pdfObject) throws IOException, BadPdfFormatException {
        PdfObject d0 = this.f26338a.d0(PdfName.ga);
        if (d0 == null || (!d0.q() && !d0.C())) {
            b(this.f26340c, pdfObject);
        } else if (d0.C()) {
            c(d0);
        } else {
            Iterator<PdfObject> it2 = ((PdfArray) d0).iterator();
            while (it2.hasNext()) {
                c(it2.next());
            }
        }
    }

    public void i(PdfNumber pdfNumber, int i2) throws BadPdfFormatException, IOException {
        if (h(this.f26341d, pdfNumber, i2) == returnType.NOTFOUND) {
            throw new BadPdfFormatException(MessageLocalization.b("invalid.structparent", new Object[0]));
        }
    }

    /* access modifiers changed from: protected */
    public void o(PdfReader pdfReader) throws BadPdfFormatException {
        this.f26342e = pdfReader;
        PdfObject m2 = m(pdfReader.F().d0(PdfName.xf));
        if (m2 == null || !m2.z()) {
            throw new BadPdfFormatException(MessageLocalization.b("no.structtreeroot.found", new Object[0]));
        }
        PdfDictionary pdfDictionary = (PdfDictionary) m2;
        this.f26338a = pdfDictionary;
        PdfObject m3 = m(pdfDictionary.d0(PdfName.Ec));
        if (m3 == null || !m3.z()) {
            throw new BadPdfFormatException(MessageLocalization.b("the.document.does.not.contain.parenttree", new Object[0]));
        }
        this.f26341d = (PdfDictionary) m3;
        this.f26344g = null;
        this.f26345h = null;
        this.f26346i = null;
    }
}
