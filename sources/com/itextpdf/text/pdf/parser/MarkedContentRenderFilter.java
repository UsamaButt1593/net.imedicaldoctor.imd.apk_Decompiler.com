package com.itextpdf.text.pdf.parser;

public class MarkedContentRenderFilter extends RenderFilter {

    /* renamed from: a  reason: collision with root package name */
    private int f26969a;

    public MarkedContentRenderFilter(int i2) {
        this.f26969a = i2;
    }

    public boolean b(TextRenderInfo textRenderInfo) {
        return textRenderInfo.y(this.f26969a);
    }
}
