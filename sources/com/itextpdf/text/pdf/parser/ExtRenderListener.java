package com.itextpdf.text.pdf.parser;

public interface ExtRenderListener extends RenderListener {
    void b(int i2);

    void d(PathConstructionRenderInfo pathConstructionRenderInfo);

    Path f(PathPaintingRenderInfo pathPaintingRenderInfo);
}
