package com.itextpdf.text.pdf.parser;

public class GlyphRenderListener implements RenderListener {

    /* renamed from: a  reason: collision with root package name */
    private final RenderListener f26925a;

    public GlyphRenderListener(RenderListener renderListener) {
        this.f26925a = renderListener;
    }

    public void a() {
        this.f26925a.a();
    }

    public void c(ImageRenderInfo imageRenderInfo) {
        this.f26925a.c(imageRenderInfo);
    }

    public void e(TextRenderInfo textRenderInfo) {
        for (TextRenderInfo e2 : textRenderInfo.g()) {
            this.f26925a.e(e2);
        }
    }

    public void h() {
        this.f26925a.h();
    }
}
