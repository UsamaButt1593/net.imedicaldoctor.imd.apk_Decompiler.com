package com.itextpdf.text.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.TabStop;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

public class PdfLine {

    /* renamed from: a  reason: collision with root package name */
    protected ArrayList<PdfChunk> f26237a;

    /* renamed from: b  reason: collision with root package name */
    protected float f26238b;

    /* renamed from: c  reason: collision with root package name */
    protected float f26239c;

    /* renamed from: d  reason: collision with root package name */
    protected int f26240d;

    /* renamed from: e  reason: collision with root package name */
    protected float f26241e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f26242f;

    /* renamed from: g  reason: collision with root package name */
    protected float f26243g;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f26244h;

    /* renamed from: i  reason: collision with root package name */
    protected ListItem f26245i;

    /* renamed from: j  reason: collision with root package name */
    protected TabStop f26246j;

    /* renamed from: k  reason: collision with root package name */
    protected float f26247k;

    /* renamed from: l  reason: collision with root package name */
    protected float f26248l;

    PdfLine(float f2, float f3, float f4, int i2, boolean z, ArrayList<PdfChunk> arrayList, boolean z2) {
        this.f26245i = null;
        this.f26246j = null;
        this.f26247k = Float.NaN;
        this.f26248l = Float.NaN;
        this.f26238b = f2;
        this.f26243g = f3;
        this.f26239c = f4;
        this.f26240d = i2;
        this.f26237a = arrayList;
        this.f26242f = z;
        this.f26244h = z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
        r0 = r4.toString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(com.itextpdf.text.pdf.PdfChunk r4) {
        /*
            r3 = this;
            boolean r0 = r4.f26142m
            if (r0 == 0) goto L_0x002e
            boolean r0 = r4.y()
            if (r0 == 0) goto L_0x0022
            com.itextpdf.text.Image r0 = r4.h()
            float r1 = r4.i()
            float r2 = r4.k()
            float r1 = r1 + r2
            float r2 = r0.G()
            float r1 = r1 + r2
            float r0 = r0.E()
            float r1 = r1 + r0
            goto L_0x0026
        L_0x0022:
            float r1 = r4.n()
        L_0x0026:
            float r0 = r3.f26241e
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x002e
            r3.f26241e = r1
        L_0x002e:
            com.itextpdf.text.TabStop r0 = r3.f26246j
            if (r0 == 0) goto L_0x0067
            com.itextpdf.text.TabStop$Alignment r0 = r0.a()
            com.itextpdf.text.TabStop$Alignment r1 = com.itextpdf.text.TabStop.Alignment.ANCHOR
            if (r0 != r1) goto L_0x0067
            float r0 = r3.f26247k
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 == 0) goto L_0x0067
            java.lang.String r0 = r4.toString()
            com.itextpdf.text.TabStop r1 = r3.f26246j
            char r1 = r1.b()
            int r1 = r0.indexOf(r1)
            r2 = -1
            if (r1 == r2) goto L_0x0067
            int r2 = r0.length()
            java.lang.String r0 = r0.substring(r1, r2)
            float r0 = r4.S(r0)
            float r1 = r3.f26243g
            float r2 = r3.f26239c
            float r1 = r1 - r2
            float r1 = r1 - r0
            r3.f26247k = r1
        L_0x0067:
            java.util.ArrayList<com.itextpdf.text.pdf.PdfChunk> r0 = r3.f26237a
            r0.add(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.pdf.PdfLine.c(com.itextpdf.text.pdf.PdfChunk):void");
    }

    public int A() {
        return this.f26237a.size();
    }

    /* access modifiers changed from: package-private */
    public float B() {
        return this.f26239c;
    }

    /* access modifiers changed from: package-private */
    public PdfChunk a(PdfChunk pdfChunk) {
        if (pdfChunk == null || pdfChunk.toString().equals("")) {
            return null;
        }
        PdfChunk M = pdfChunk.M(this.f26239c);
        this.f26242f = pdfChunk.z() || M == null;
        if (pdfChunk.D()) {
            Object[] objArr = (Object[]) pdfChunk.e(Chunk.g3);
            if (pdfChunk.v(Chunk.h3)) {
                boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
                if (booleanValue && this.f26237a.isEmpty()) {
                    return null;
                }
                d();
                this.f26247k = Float.NaN;
                TabStop p = PdfChunk.p(pdfChunk, this.f26243g - this.f26239c);
                this.f26246j = p;
                float d2 = p.d();
                float f2 = this.f26243g;
                if (d2 > f2) {
                    if (!booleanValue) {
                        if (((double) Math.abs(f2 - this.f26239c)) < 0.001d) {
                            c(pdfChunk);
                        }
                        this.f26239c = 0.0f;
                        return pdfChunk;
                    }
                    pdfChunk = null;
                    this.f26239c = 0.0f;
                    return pdfChunk;
                }
                pdfChunk.K(this.f26246j);
                if (this.f26244h || this.f26246j.a() != TabStop.Alignment.LEFT) {
                    this.f26248l = this.f26243g - this.f26239c;
                } else {
                    this.f26239c = this.f26243g - this.f26246j.d();
                    this.f26246j = null;
                    this.f26248l = Float.NaN;
                }
            } else {
                Float f3 = (Float) objArr[1];
                f3.floatValue();
                if (((Boolean) objArr[2]).booleanValue() && f3.floatValue() < this.f26243g - this.f26239c) {
                    return pdfChunk;
                }
                pdfChunk.a(this.f26238b);
                this.f26239c = this.f26243g - f3.floatValue();
            }
        } else if (pdfChunk.E() > 0 || pdfChunk.y()) {
            if (M != null) {
                pdfChunk.P();
            }
            this.f26239c -= pdfChunk.R();
        } else if (this.f26237a.size() < 1) {
            PdfChunk Q = M.Q(this.f26239c);
            this.f26239c -= M.R();
            if (M.E() > 0) {
                c(M);
                return Q;
            }
            if (Q != null) {
                c(Q);
            }
            return null;
        } else {
            float f4 = this.f26239c;
            ArrayList<PdfChunk> arrayList = this.f26237a;
            this.f26239c = f4 + arrayList.get(arrayList.size() - 1).P();
            return M;
        }
        c(pdfChunk);
        return M;
    }

    /* access modifiers changed from: package-private */
    public PdfChunk b(PdfChunk pdfChunk, float f2) {
        if (pdfChunk != null && !pdfChunk.toString().equals("") && !pdfChunk.toString().equals(StringUtils.SPACE) && (this.f26241e < f2 || this.f26237a.isEmpty())) {
            this.f26241e = f2;
        }
        return a(pdfChunk);
    }

    public void d() {
        TabStop tabStop = this.f26246j;
        if (tabStop != null) {
            float f2 = this.f26243g;
            float f3 = this.f26239c;
            float f4 = this.f26248l;
            float e2 = tabStop.e(f4, f2 - f3, this.f26247k);
            float f5 = this.f26243g;
            float f6 = (f5 - e2) - ((f2 - f3) - f4);
            this.f26239c = f6;
            if (f6 < 0.0f) {
                e2 += f6;
            }
            if (!this.f26244h) {
                this.f26246j.j(e2);
            } else {
                this.f26246j.j((f5 - f6) - this.f26248l);
            }
            this.f26246j = null;
            this.f26248l = Float.NaN;
        }
    }

    public float e() {
        float f2 = 0.0f;
        for (int i2 = 0; i2 < this.f26237a.size(); i2++) {
            PdfChunk pdfChunk = this.f26237a.get(i2);
            if (pdfChunk.y()) {
                f2 = Math.max(f2, pdfChunk.i() + pdfChunk.k());
            } else {
                PdfFont d2 = pdfChunk.d();
                float q = pdfChunk.q();
                if (q <= 0.0f) {
                    q = 0.0f;
                }
                f2 = Math.max(f2, q + d2.c().I(1, d2.g()));
            }
        }
        return f2;
    }

    public PdfChunk f(int i2) {
        if (i2 < 0 || i2 >= this.f26237a.size()) {
            return null;
        }
        return this.f26237a.get(i2);
    }

    public float g() {
        float I;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < this.f26237a.size(); i2++) {
            PdfChunk pdfChunk = this.f26237a.get(i2);
            if (pdfChunk.y()) {
                I = pdfChunk.k();
            } else {
                PdfFont d2 = pdfChunk.d();
                float q = pdfChunk.q();
                if (q >= 0.0f) {
                    q = 0.0f;
                }
                I = q + d2.c().I(3, d2.g());
            }
            f2 = Math.min(f2, I);
        }
        return f2;
    }

    public int h() {
        int size = this.f26237a.size() - 1;
        while (size >= 0 && !this.f26237a.get(size).C()) {
            size--;
        }
        return size;
    }

    public int i() {
        Iterator<PdfChunk> it2 = this.f26237a.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            i2 += it2.next().F();
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public float[] j(float f2, float f3) {
        float f4 = -10000.0f;
        float f5 = 0.0f;
        for (int i2 = 0; i2 < this.f26237a.size(); i2++) {
            PdfChunk pdfChunk = this.f26237a.get(i2);
            if (pdfChunk.y()) {
                Image h2 = pdfChunk.h();
                if (pdfChunk.b()) {
                    f4 = Math.max(pdfChunk.i() + pdfChunk.k() + h2.E(), f4);
                }
            } else {
                f5 = Math.max(pdfChunk.b() ? pdfChunk.n() : (pdfChunk.d().g() * f3) + f2, f5);
            }
        }
        if (f5 > 0.0f) {
            f2 = f5;
        }
        return new float[]{f2, f4};
    }

    public float k() {
        return this.f26243g;
    }

    /* access modifiers changed from: package-private */
    public int l() {
        Iterator<PdfChunk> it2 = this.f26237a.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            PdfChunk next = it2.next();
            if (next.D()) {
                if (!next.v(Chunk.h3)) {
                    return -1;
                }
            } else if (next.x()) {
                i2++;
            }
        }
        return i2;
    }

    public float m(float f2, float f3) {
        float f4 = 0.0f;
        for (int i2 = 0; i2 < this.f26237a.size(); i2++) {
            f4 += this.f26237a.get(i2).s(f2, f3);
        }
        return f4;
    }

    public boolean n() {
        int i2 = this.f26240d;
        return ((i2 == 3 && !this.f26242f) || i2 == 8) && this.f26239c != 0.0f;
    }

    /* access modifiers changed from: package-private */
    public float o() {
        return this.f26241e;
    }

    /* access modifiers changed from: package-private */
    public float p() {
        if (this.f26244h) {
            int i2 = this.f26240d;
            if (i2 == 1) {
                return this.f26238b + (this.f26239c / 2.0f);
            }
            if (i2 == 2) {
                return this.f26238b;
            }
            if (i2 != 3) {
                return this.f26238b + this.f26239c;
            }
            return this.f26238b + (n() ? 0.0f : this.f26239c);
        }
        if (l() <= 0) {
            int i3 = this.f26240d;
            if (i3 == 1) {
                return this.f26238b + (this.f26239c / 2.0f);
            }
            if (i3 == 2) {
                return this.f26238b + this.f26239c;
            }
        }
        return this.f26238b;
    }

    public boolean q() {
        return this.f26242f && this.f26240d != 8;
    }

    /* access modifiers changed from: package-private */
    public boolean r() {
        return this.f26244h;
    }

    public Iterator<PdfChunk> s() {
        return this.f26237a.iterator();
    }

    public float t() {
        ListItem listItem = this.f26245i;
        if (listItem != null) {
            return listItem.m();
        }
        return 0.0f;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<PdfChunk> it2 = this.f26237a.iterator();
        while (it2.hasNext()) {
            stringBuffer.append(it2.next().toString());
        }
        return stringBuffer.toString();
    }

    public ListItem u() {
        return this.f26245i;
    }

    public Chunk v() {
        ListItem listItem = this.f26245i;
        if (listItem != null) {
            return listItem.j2();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int w() {
        Iterator<PdfChunk> it2 = this.f26237a.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            String pdfChunk = it2.next().toString();
            int length = pdfChunk.length();
            for (int i3 = 0; i3 < length; i3++) {
                if (pdfChunk.charAt(i3) == ' ') {
                    i2++;
                }
            }
        }
        return i2;
    }

    public void x() {
        if (this.f26240d == 3) {
            this.f26240d = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public void y(float f2) {
        this.f26238b += f2;
        this.f26239c -= f2;
        this.f26243g -= f2;
    }

    public void z(ListItem listItem) {
        this.f26245i = listItem;
    }

    PdfLine(float f2, float f3, int i2, float f4) {
        this.f26242f = false;
        this.f26244h = false;
        this.f26245i = null;
        this.f26246j = null;
        this.f26247k = Float.NaN;
        this.f26248l = Float.NaN;
        this.f26238b = f2;
        float f5 = f3 - f2;
        this.f26239c = f5;
        this.f26243g = f5;
        this.f26240d = i2;
        this.f26241e = f4;
        this.f26237a = new ArrayList<>();
    }
}
