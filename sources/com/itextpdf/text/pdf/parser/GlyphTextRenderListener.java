package com.itextpdf.text.pdf.parser;

public class GlyphTextRenderListener extends GlyphRenderListener implements TextExtractionStrategy {

    /* renamed from: b  reason: collision with root package name */
    private final TextExtractionStrategy f26926b;

    public GlyphTextRenderListener(TextExtractionStrategy textExtractionStrategy) {
        super(textExtractionStrategy);
        this.f26926b = textExtractionStrategy;
    }

    public String g() {
        return this.f26926b.g();
    }
}
