package com.itextpdf.text.pdf.parser;

public class FilteredRenderListener implements RenderListener {

    /* renamed from: a  reason: collision with root package name */
    private final RenderListener f26922a;

    /* renamed from: b  reason: collision with root package name */
    private final RenderFilter[] f26923b;

    public FilteredRenderListener(RenderListener renderListener, RenderFilter... renderFilterArr) {
        this.f26922a = renderListener;
        this.f26923b = renderFilterArr;
    }

    public void a() {
        this.f26922a.a();
    }

    public void c(ImageRenderInfo imageRenderInfo) {
        RenderFilter[] renderFilterArr = this.f26923b;
        int length = renderFilterArr.length;
        int i2 = 0;
        while (i2 < length) {
            if (renderFilterArr[i2].a(imageRenderInfo)) {
                i2++;
            } else {
                return;
            }
        }
        this.f26922a.c(imageRenderInfo);
    }

    public void e(TextRenderInfo textRenderInfo) {
        RenderFilter[] renderFilterArr = this.f26923b;
        int length = renderFilterArr.length;
        int i2 = 0;
        while (i2 < length) {
            if (renderFilterArr[i2].b(textRenderInfo)) {
                i2++;
            } else {
                return;
            }
        }
        this.f26922a.e(textRenderInfo);
    }

    public void h() {
        this.f26922a.h();
    }
}
