package com.itextpdf.text.pdf;

import java.util.ArrayList;

public class PdfTextArray {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<Object> f26348a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private String f26349b;

    /* renamed from: c  reason: collision with root package name */
    private Float f26350c;

    public PdfTextArray() {
    }

    private void e(Object obj) {
        ArrayList<Object> arrayList = this.f26348a;
        arrayList.set(arrayList.size() - 1, obj);
    }

    public void a(float f2) {
        if (f2 != 0.0f) {
            Float f3 = this.f26350c;
            if (f3 != null) {
                Float f4 = new Float(f2 + f3.floatValue());
                this.f26350c = f4;
                if (f4.floatValue() != 0.0f) {
                    e(this.f26350c);
                } else {
                    ArrayList<Object> arrayList = this.f26348a;
                    arrayList.remove(arrayList.size() - 1);
                }
            } else {
                Float f5 = new Float(f2);
                this.f26350c = f5;
                this.f26348a.add(f5);
            }
            this.f26349b = null;
        }
    }

    public void b(PdfNumber pdfNumber) {
        a((float) pdfNumber.Z());
    }

    public void c(String str) {
        if (str.length() > 0) {
            if (this.f26349b != null) {
                String str2 = this.f26349b + str;
                this.f26349b = str2;
                e(str2);
            } else {
                this.f26349b = str;
                this.f26348a.add(str);
            }
            this.f26350c = null;
        }
    }

    /* access modifiers changed from: package-private */
    public ArrayList<Object> d() {
        return this.f26348a;
    }

    public PdfTextArray(String str) {
        c(str);
    }
}
