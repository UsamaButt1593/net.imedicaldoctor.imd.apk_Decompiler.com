package com.itextpdf.text.pdf.fonts.cmaps;

import com.h6ah4i.android.widget.advrecyclerview.swipeable.RecyclerViewSwipeManager;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.pdf.IntHashtable;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfString;

public class CMapCidUni extends AbstractCMap {

    /* renamed from: e  reason: collision with root package name */
    private IntHashtable f26810e = new IntHashtable(RecyclerViewSwipeManager.H);

    /* access modifiers changed from: package-private */
    public void a(PdfString pdfString, PdfObject pdfObject) {
        if (pdfObject instanceof PdfNumber) {
            String e2 = e(pdfString);
            this.f26810e.l(((PdfNumber) pdfObject).e0(), Utilities.n(e2, 0) ? Utilities.f(e2, 0) : e2.charAt(0));
        }
    }

    public int o(int i2) {
        return this.f26810e.e(i2);
    }
}
