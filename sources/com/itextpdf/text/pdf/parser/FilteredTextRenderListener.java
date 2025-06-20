package com.itextpdf.text.pdf.parser;

public class FilteredTextRenderListener extends FilteredRenderListener implements TextExtractionStrategy {

    /* renamed from: c  reason: collision with root package name */
    private final TextExtractionStrategy f26924c;

    public FilteredTextRenderListener(TextExtractionStrategy textExtractionStrategy, RenderFilter... renderFilterArr) {
        super(textExtractionStrategy, renderFilterArr);
        this.f26924c = textExtractionStrategy;
    }

    public String g() {
        return this.f26924c.g();
    }
}
