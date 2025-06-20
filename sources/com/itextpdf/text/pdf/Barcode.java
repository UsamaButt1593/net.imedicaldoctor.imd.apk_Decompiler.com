package com.itextpdf.text.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;

public abstract class Barcode {
    public static final int A = 11;
    public static final int B = 12;
    public static final int q = 1;
    public static final int r = 2;
    public static final int s = 3;
    public static final int t = 4;
    public static final int u = 5;
    public static final int v = 6;
    public static final int w = 7;
    public static final int x = 8;
    public static final int y = 9;
    public static final int z = 10;

    /* renamed from: a  reason: collision with root package name */
    protected float f25851a;

    /* renamed from: b  reason: collision with root package name */
    protected float f25852b;

    /* renamed from: c  reason: collision with root package name */
    protected BaseFont f25853c;

    /* renamed from: d  reason: collision with root package name */
    protected float f25854d;

    /* renamed from: e  reason: collision with root package name */
    protected float f25855e;

    /* renamed from: f  reason: collision with root package name */
    protected float f25856f;

    /* renamed from: g  reason: collision with root package name */
    protected int f25857g;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f25858h;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f25859i;

    /* renamed from: j  reason: collision with root package name */
    protected boolean f25860j;

    /* renamed from: k  reason: collision with root package name */
    protected boolean f25861k;

    /* renamed from: l  reason: collision with root package name */
    protected String f25862l = "";

    /* renamed from: m  reason: collision with root package name */
    protected boolean f25863m;

    /* renamed from: n  reason: collision with root package name */
    protected int f25864n;
    protected float o = 0.0f;
    protected String p;

    public void A(boolean z2) {
        this.f25861k = z2;
    }

    public void B(BaseFont baseFont) {
        this.f25853c = baseFont;
    }

    public void C(boolean z2) {
        this.f25858h = z2;
    }

    public void D(boolean z2) {
        this.f25863m = z2;
    }

    public void E(float f2) {
        this.o = f2;
    }

    public void F(float f2) {
        this.f25852b = f2;
    }

    public void G(float f2) {
        this.f25854d = f2;
    }

    public void H(boolean z2) {
        this.f25860j = z2;
    }

    public void I(int i2) {
        this.f25857g = i2;
    }

    public void J(float f2) {
        this.f25851a = f2;
    }

    public Image a(PdfContentByte pdfContentByte, BaseColor baseColor, BaseColor baseColor2) {
        try {
            return Image.a1(b(pdfContentByte, baseColor, baseColor2));
        } catch (Exception e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public PdfTemplate b(PdfContentByte pdfContentByte, BaseColor baseColor, BaseColor baseColor2) {
        PdfTemplate t0 = pdfContentByte.t0(0.0f, 0.0f);
        t0.S3(t(t0, baseColor, baseColor2));
        return t0;
    }

    public String c() {
        return this.p;
    }

    public float d() {
        return this.f25856f;
    }

    public abstract Rectangle e();

    public float f() {
        return this.f25855e;
    }

    public String g() {
        return this.f25862l;
    }

    public int h() {
        return this.f25864n;
    }

    public BaseFont i() {
        return this.f25853c;
    }

    public float j() {
        return this.o;
    }

    public float k() {
        return this.f25852b;
    }

    public float l() {
        return this.f25854d;
    }

    public int m() {
        return this.f25857g;
    }

    public float n() {
        return this.f25851a;
    }

    public boolean o() {
        return this.f25859i;
    }

    public boolean p() {
        return this.f25861k;
    }

    public boolean q() {
        return this.f25858h;
    }

    public boolean r() {
        return this.f25863m;
    }

    public boolean s() {
        return this.f25860j;
    }

    public abstract Rectangle t(PdfContentByte pdfContentByte, BaseColor baseColor, BaseColor baseColor2);

    public void u(String str) {
        this.p = str;
    }

    public void v(float f2) {
        this.f25856f = f2;
    }

    public void w(float f2) {
        this.f25855e = f2;
    }

    public void x(boolean z2) {
        this.f25859i = z2;
    }

    public void y(String str) {
        this.f25862l = str;
    }

    public void z(int i2) {
        this.f25864n = i2;
    }
}
