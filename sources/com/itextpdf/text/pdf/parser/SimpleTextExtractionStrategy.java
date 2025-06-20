package com.itextpdf.text.pdf.parser;

import org.apache.commons.lang3.StringUtils;

public class SimpleTextExtractionStrategy implements TextExtractionStrategy {

    /* renamed from: a  reason: collision with root package name */
    private Vector f27044a;

    /* renamed from: b  reason: collision with root package name */
    private Vector f27045b;

    /* renamed from: c  reason: collision with root package name */
    private final StringBuffer f27046c = new StringBuffer();

    public void a() {
    }

    public void c(ImageRenderInfo imageRenderInfo) {
    }

    public void e(TextRenderInfo textRenderInfo) {
        String str;
        boolean z = this.f27046c.length() == 0;
        LineSegment e2 = textRenderInfo.e();
        Vector d2 = e2.d();
        Vector b2 = e2.b();
        if (!z) {
            Vector vector = this.f27044a;
            Vector vector2 = this.f27045b;
            if (vector2.i(vector).b(vector.i(d2)).f() / vector2.i(vector).f() > 1.0f) {
                str = StringUtils.LF;
                i(str);
                i(textRenderInfo.r());
                this.f27044a = d2;
                this.f27045b = b2;
            }
        }
        if (!z) {
            StringBuffer stringBuffer = this.f27046c;
            if (stringBuffer.charAt(stringBuffer.length() - 1) != ' ' && textRenderInfo.r().length() > 0 && textRenderInfo.r().charAt(0) != ' ' && this.f27045b.i(d2).e() > textRenderInfo.o() / 2.0f) {
                str = StringUtils.SPACE;
                i(str);
            }
        }
        i(textRenderInfo.r());
        this.f27044a = d2;
        this.f27045b = b2;
    }

    public String g() {
        return this.f27046c.toString();
    }

    public void h() {
    }

    /* access modifiers changed from: protected */
    public final void i(CharSequence charSequence) {
        this.f27046c.append(charSequence);
    }
}
