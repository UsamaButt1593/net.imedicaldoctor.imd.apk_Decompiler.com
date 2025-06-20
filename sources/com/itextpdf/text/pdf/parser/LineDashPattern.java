package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.pdf.PdfArray;

public class LineDashPattern {

    /* renamed from: a  reason: collision with root package name */
    private PdfArray f26954a;

    /* renamed from: b  reason: collision with root package name */
    private float f26955b;

    /* renamed from: c  reason: collision with root package name */
    private int f26956c;

    /* renamed from: d  reason: collision with root package name */
    private int f26957d = 1;

    /* renamed from: e  reason: collision with root package name */
    private DashArrayElem f26958e;

    public class DashArrayElem {

        /* renamed from: a  reason: collision with root package name */
        private float f26959a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f26960b;

        public DashArrayElem(float f2, boolean z) {
            this.f26959a = f2;
            this.f26960b = z;
        }

        public float a() {
            return this.f26959a;
        }

        public boolean b() {
            return this.f26960b;
        }

        public void c(boolean z) {
            this.f26960b = z;
        }

        public void d(float f2) {
            this.f26959a = f2;
        }
    }

    public LineDashPattern(PdfArray pdfArray, float f2) {
        this.f26954a = new PdfArray(pdfArray);
        this.f26955b = f2;
        c(f2);
    }

    private void c(float f2) {
        if (this.f26954a.size() > 0) {
            while (f2 > 0.0f) {
                f2 -= this.f26954a.J0(this.f26956c).a0();
                this.f26956c = (this.f26956c + 1) % this.f26954a.size();
                this.f26957d++;
            }
            if (f2 < 0.0f) {
                int i2 = this.f26957d - 1;
                this.f26957d = i2;
                this.f26956c--;
                this.f26958e = new DashArrayElem(-f2, d(i2));
                return;
            }
            this.f26958e = new DashArrayElem(this.f26954a.J0(this.f26956c).a0(), d(this.f26957d));
        }
    }

    private boolean d(int i2) {
        return i2 % 2 == 0;
    }

    public PdfArray a() {
        return this.f26954a;
    }

    public float b() {
        return this.f26955b;
    }

    public boolean e() {
        if (this.f26954a.size() % 2 != 0) {
            return false;
        }
        float f2 = 0.0f;
        for (int i2 = 1; i2 < this.f26954a.size(); i2 += 2) {
            f2 += this.f26954a.J0(i2).a0();
        }
        return Float.compare(f2, 0.0f) == 0;
    }

    public DashArrayElem f() {
        DashArrayElem dashArrayElem = this.f26958e;
        if (this.f26954a.size() > 0) {
            int size = (this.f26956c + 1) % this.f26954a.size();
            this.f26956c = size;
            float a0 = this.f26954a.J0(size).a0();
            int i2 = this.f26957d + 1;
            this.f26957d = i2;
            this.f26958e = new DashArrayElem(a0, d(i2));
        }
        return dashArrayElem;
    }

    public void g() {
        this.f26956c = 0;
        this.f26957d = 1;
        c(this.f26955b);
    }

    public void h(PdfArray pdfArray) {
        this.f26954a = pdfArray;
    }

    public void i(float f2) {
        this.f26955b = f2;
    }
}
