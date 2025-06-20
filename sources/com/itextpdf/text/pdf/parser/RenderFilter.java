package com.itextpdf.text.pdf.parser;

public abstract class RenderFilter {
    public boolean a(ImageRenderInfo imageRenderInfo) {
        return true;
    }

    public boolean b(TextRenderInfo textRenderInfo) {
        return true;
    }
}
