package com.itextpdf.text.pdf;

import java.util.HashMap;
import java.util.HashSet;

class PageResources {

    /* renamed from: a  reason: collision with root package name */
    protected PdfDictionary f26110a = new PdfDictionary();

    /* renamed from: b  reason: collision with root package name */
    protected PdfDictionary f26111b = new PdfDictionary();

    /* renamed from: c  reason: collision with root package name */
    protected PdfDictionary f26112c = new PdfDictionary();

    /* renamed from: d  reason: collision with root package name */
    protected PdfDictionary f26113d = new PdfDictionary();

    /* renamed from: e  reason: collision with root package name */
    protected PdfDictionary f26114e = new PdfDictionary();

    /* renamed from: f  reason: collision with root package name */
    protected PdfDictionary f26115f = new PdfDictionary();

    /* renamed from: g  reason: collision with root package name */
    protected PdfDictionary f26116g = new PdfDictionary();

    /* renamed from: h  reason: collision with root package name */
    protected HashSet<PdfName> f26117h;

    /* renamed from: i  reason: collision with root package name */
    protected PdfDictionary f26118i;

    /* renamed from: j  reason: collision with root package name */
    protected int[] f26119j = {0};

    /* renamed from: k  reason: collision with root package name */
    protected HashMap<PdfName, PdfName> f26120k;

    PageResources() {
    }

    /* access modifiers changed from: package-private */
    public PdfName a(PdfName pdfName, PdfIndirectReference pdfIndirectReference) {
        PdfName n2 = n(pdfName);
        this.f26112c.V0(n2, pdfIndirectReference);
        return n2;
    }

    /* access modifiers changed from: package-private */
    public void b(PdfDictionary pdfDictionary) {
        this.f26112c.T0(pdfDictionary);
    }

    /* access modifiers changed from: package-private */
    public void c(PdfName pdfName, PdfObject pdfObject) {
        if (pdfObject == null || pdfObject.H()) {
            this.f26112c.a1(pdfName);
        } else {
            this.f26112c.V0(pdfName, pdfObject);
        }
    }

    /* access modifiers changed from: package-private */
    public void d(PdfDictionary pdfDictionary) {
        this.f26112c.U0(pdfDictionary);
    }

    /* access modifiers changed from: package-private */
    public PdfName e(PdfName pdfName, PdfIndirectReference pdfIndirectReference) {
        PdfName n2 = n(pdfName);
        this.f26115f.V0(n2, pdfIndirectReference);
        return n2;
    }

    /* access modifiers changed from: package-private */
    public PdfName f(PdfName pdfName, PdfIndirectReference pdfIndirectReference) {
        PdfName n2 = n(pdfName);
        this.f26110a.V0(n2, pdfIndirectReference);
        return n2;
    }

    /* access modifiers changed from: package-private */
    public PdfName g(PdfName pdfName, PdfIndirectReference pdfIndirectReference) {
        PdfName n2 = n(pdfName);
        this.f26113d.V0(n2, pdfIndirectReference);
        return n2;
    }

    /* access modifiers changed from: package-private */
    public PdfName h(PdfName pdfName, PdfIndirectReference pdfIndirectReference) {
        PdfName n2 = n(pdfName);
        this.f26116g.V0(n2, pdfIndirectReference);
        return n2;
    }

    /* access modifiers changed from: package-private */
    public PdfName i(PdfName pdfName, PdfIndirectReference pdfIndirectReference) {
        PdfName n2 = n(pdfName);
        this.f26114e.V0(n2, pdfIndirectReference);
        return n2;
    }

    /* access modifiers changed from: package-private */
    public PdfName j(PdfName pdfName, PdfIndirectReference pdfIndirectReference) {
        PdfName n2 = n(pdfName);
        this.f26111b.V0(n2, pdfIndirectReference);
        return n2;
    }

    /* access modifiers changed from: package-private */
    public PdfDictionary k() {
        PdfResources pdfResources = new PdfResources();
        PdfDictionary pdfDictionary = this.f26118i;
        if (pdfDictionary != null) {
            pdfResources.X0(pdfDictionary);
        }
        pdfResources.f1(PdfName.l8, this.f26110a);
        pdfResources.f1(PdfName.ai, this.f26111b);
        pdfResources.f1(PdfName.w5, this.f26112c);
        pdfResources.f1(PdfName.Ic, this.f26113d);
        pdfResources.f1(PdfName.Me, this.f26114e);
        pdfResources.f1(PdfName.B7, this.f26115f);
        pdfResources.f1(PdfName.vd, this.f26116g);
        return pdfResources;
    }

    /* access modifiers changed from: package-private */
    public boolean l() {
        return this.f26110a.size() > 0 || this.f26111b.size() > 0 || this.f26112c.size() > 0 || this.f26113d.size() > 0 || this.f26114e.size() > 0 || this.f26115f.size() > 0 || this.f26116g.size() > 0;
    }

    /* access modifiers changed from: package-private */
    public void m(PdfDictionary pdfDictionary, int[] iArr) {
        if (iArr != null) {
            this.f26119j = iArr;
        }
        this.f26117h = new HashSet<>();
        this.f26120k = new HashMap<>();
        if (pdfDictionary != null) {
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            this.f26118i = pdfDictionary2;
            pdfDictionary2.T0(pdfDictionary);
            for (PdfName next : pdfDictionary.G0()) {
                PdfObject t0 = PdfReader.t0(pdfDictionary.d0(next));
                if (t0 != null && t0.z()) {
                    PdfDictionary pdfDictionary3 = (PdfDictionary) t0;
                    for (PdfName add : pdfDictionary3.G0()) {
                        this.f26117h.add(add);
                    }
                    PdfDictionary pdfDictionary4 = new PdfDictionary();
                    pdfDictionary4.T0(pdfDictionary3);
                    this.f26118i.V0(next, pdfDictionary4);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public PdfName n(PdfName pdfName) {
        if (this.f26117h == null) {
            return pdfName;
        }
        PdfName pdfName2 = this.f26120k.get(pdfName);
        if (pdfName2 == null) {
            do {
                StringBuilder sb = new StringBuilder();
                sb.append("Xi");
                int[] iArr = this.f26119j;
                int i2 = iArr[0];
                iArr[0] = i2 + 1;
                sb.append(i2);
                pdfName2 = new PdfName(sb.toString());
            } while (this.f26117h.contains(pdfName2));
            this.f26120k.put(pdfName, pdfName2);
        }
        return pdfName2;
    }
}
