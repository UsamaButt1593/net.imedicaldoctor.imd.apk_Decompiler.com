package com.itextpdf.text.pdf.hyphenation;

public class Hyphenation {

    /* renamed from: a  reason: collision with root package name */
    private int[] f26846a;

    /* renamed from: b  reason: collision with root package name */
    private String f26847b;

    /* renamed from: c  reason: collision with root package name */
    private int f26848c;

    Hyphenation(String str, int[] iArr) {
        this.f26847b = str;
        this.f26846a = iArr;
        this.f26848c = iArr.length;
    }

    public int[] a() {
        return this.f26846a;
    }

    public String b(int i2) {
        return this.f26847b.substring(this.f26846a[i2]);
    }

    public String c(int i2) {
        return this.f26847b.substring(0, this.f26846a[i2]);
    }

    public int d() {
        return this.f26848c;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        for (int i3 = 0; i3 < this.f26848c; i3++) {
            stringBuffer.append(this.f26847b.substring(i2, this.f26846a[i3]));
            stringBuffer.append('-');
            i2 = this.f26846a[i3];
        }
        stringBuffer.append(this.f26847b.substring(i2));
        return stringBuffer.toString();
    }
}
