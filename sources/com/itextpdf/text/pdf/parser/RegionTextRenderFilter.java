package com.itextpdf.text.pdf.parser;

import com.itextpdf.awt.geom.Rectangle2D;
import com.itextpdf.text.Rectangle;

public class RegionTextRenderFilter extends RenderFilter {

    /* renamed from: a  reason: collision with root package name */
    private final Rectangle2D f27043a;

    public RegionTextRenderFilter(Rectangle2D rectangle2D) {
        this.f27043a = rectangle2D;
    }

    public boolean b(TextRenderInfo textRenderInfo) {
        LineSegment e2 = textRenderInfo.e();
        Vector d2 = e2.d();
        Vector b2 = e2.b();
        return this.f27043a.S((double) d2.d(0), (double) d2.d(1), (double) b2.d(0), (double) b2.d(1));
    }

    public RegionTextRenderFilter(Rectangle rectangle) {
        this.f27043a = new com.itextpdf.awt.geom.Rectangle(rectangle);
    }
}
