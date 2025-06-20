package com.itextpdf.text.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import java.io.IOException;
import java.util.ArrayList;

public class PdfPages {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<PdfIndirectReference> f26274a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<PdfIndirectReference> f26275b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private int f26276c = 10;

    /* renamed from: d  reason: collision with root package name */
    private PdfWriter f26277d;

    /* renamed from: e  reason: collision with root package name */
    private PdfIndirectReference f26278e;

    PdfPages(PdfWriter pdfWriter) {
        this.f26277d = pdfWriter;
    }

    /* access modifiers changed from: package-private */
    public void a(PdfDictionary pdfDictionary) {
        try {
            if (this.f26274a.size() % this.f26276c == 0) {
                this.f26275b.add(this.f26277d.D1());
            }
            ArrayList<PdfIndirectReference> arrayList = this.f26275b;
            pdfDictionary.V0(PdfName.Dc, arrayList.get(arrayList.size() - 1));
            PdfIndirectReference d1 = this.f26277d.d1();
            this.f26277d.y0(pdfDictionary, d1);
            this.f26274a.add(d1);
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(PdfIndirectReference pdfIndirectReference) {
        this.f26274a.add(pdfIndirectReference);
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference c(PdfIndirectReference pdfIndirectReference) {
        try {
            if (this.f26274a.size() % this.f26276c == 0) {
                this.f26275b.add(this.f26277d.D1());
            }
            this.f26274a.add(pdfIndirectReference);
            ArrayList<PdfIndirectReference> arrayList = this.f26275b;
            return arrayList.get(arrayList.size() - 1);
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference d() {
        return this.f26278e;
    }

    /* access modifiers changed from: package-private */
    public int e(int[] iArr) throws DocumentException {
        if (iArr == null) {
            return this.f26274a.size();
        }
        if (this.f26275b.size() > 1) {
            throw new DocumentException(MessageLocalization.b("page.reordering.requires.a.single.parent.in.the.page.tree.call.pdfwriter.setlinearmode.after.open", new Object[0]));
        } else if (iArr.length == this.f26274a.size()) {
            int size = this.f26274a.size();
            boolean[] zArr = new boolean[size];
            int i2 = 0;
            while (i2 < size) {
                int i3 = iArr[i2];
                if (i3 < 1 || i3 > size) {
                    throw new DocumentException(MessageLocalization.b("page.reordering.requires.pages.between.1.and.1.found.2", String.valueOf(size), String.valueOf(i3)));
                }
                int i4 = i3 - 1;
                if (!zArr[i4]) {
                    zArr[i4] = true;
                    i2++;
                } else {
                    throw new DocumentException(MessageLocalization.a("page.reordering.requires.no.page.repetition.page.1.is.repeated", i3));
                }
            }
            ArrayList<PdfIndirectReference> arrayList = this.f26274a;
            PdfIndirectReference[] pdfIndirectReferenceArr = (PdfIndirectReference[]) arrayList.toArray(new PdfIndirectReference[arrayList.size()]);
            for (int i5 = 0; i5 < size; i5++) {
                this.f26274a.set(i5, pdfIndirectReferenceArr[iArr[i5] - 1]);
            }
            return size;
        } else {
            throw new DocumentException(MessageLocalization.b("page.reordering.requires.an.array.with.the.same.size.as.the.number.of.pages", new Object[0]));
        }
    }

    /* access modifiers changed from: package-private */
    public void f(PdfIndirectReference pdfIndirectReference) {
        if (this.f26275b.size() <= 1) {
            if (pdfIndirectReference != null) {
                this.f26278e = pdfIndirectReference;
                this.f26275b.clear();
                this.f26275b.add(pdfIndirectReference);
            }
            this.f26276c = 10000000;
            return;
        }
        throw new RuntimeException(MessageLocalization.b("linear.page.mode.can.only.be.called.with.a.single.parent", new Object[0]));
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference g() throws IOException {
        int i2;
        int i3;
        if (!this.f26274a.isEmpty()) {
            ArrayList<PdfIndirectReference> arrayList = this.f26275b;
            ArrayList<PdfIndirectReference> arrayList2 = this.f26274a;
            ArrayList<PdfIndirectReference> arrayList3 = new ArrayList<>();
            int i4 = 1;
            while (true) {
                int i5 = this.f26276c;
                i4 *= i5;
                int size = arrayList2.size();
                int i6 = this.f26276c;
                int i7 = size % i6;
                if (i7 != 0) {
                    i6 = i7;
                }
                for (int i8 = 0; i8 < arrayList.size(); i8++) {
                    if (i8 == arrayList.size() - 1) {
                        i3 = this.f26274a.size() % i4;
                        if (i3 == 0) {
                            i3 = i4;
                        }
                        i2 = i6;
                    } else {
                        i3 = i4;
                        i2 = i5;
                    }
                    PdfDictionary pdfDictionary = new PdfDictionary(PdfName.zc);
                    pdfDictionary.V0(PdfName.P5, new PdfNumber(i3));
                    PdfArray pdfArray = new PdfArray();
                    int i9 = i8 * i5;
                    pdfArray.q0().addAll(arrayList2.subList(i9, i2 + i9));
                    pdfDictionary.V0(PdfName.ia, pdfArray);
                    if (arrayList.size() > 1) {
                        if (i8 % this.f26276c == 0) {
                            arrayList3.add(this.f26277d.D1());
                        }
                        pdfDictionary.V0(PdfName.Dc, arrayList3.get(i8 / this.f26276c));
                    }
                    this.f26277d.y0(pdfDictionary, arrayList.get(i8));
                }
                if (arrayList.size() == 1) {
                    PdfIndirectReference pdfIndirectReference = arrayList.get(0);
                    this.f26278e = pdfIndirectReference;
                    return pdfIndirectReference;
                }
                arrayList2 = arrayList;
                arrayList = arrayList3;
                arrayList3 = new ArrayList<>();
            }
        } else {
            throw new IOException(MessageLocalization.b("the.document.has.no.pages", new Object[0]));
        }
    }
}
