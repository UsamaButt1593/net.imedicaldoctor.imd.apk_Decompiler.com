package com.itextpdf.text.pdf.parser;

import com.itextpdf.awt.geom.Rectangle2D;

public class TextMarginFinder implements RenderListener {

    /* renamed from: a  reason: collision with root package name */
    private Rectangle2D.Float f27052a = null;

    public void a() {
    }

    public void c(ImageRenderInfo imageRenderInfo) {
    }

    public void e(TextRenderInfo textRenderInfo) {
        Rectangle2D.Float floatR = this.f27052a;
        if (floatR == null) {
            this.f27052a = textRenderInfo.h().a();
        } else {
            floatR.K(textRenderInfo.h().a());
        }
        this.f27052a.K(textRenderInfo.d().a());
    }

    public void h() {
    }

    public float i() {
        return this.f27052a.a3;
    }

    public float j() {
        return this.f27052a.X2;
    }

    public float k() {
        return this.f27052a.Y2;
    }

    public float l() {
        Rectangle2D.Float floatR = this.f27052a;
        return floatR.X2 + floatR.Z2;
    }

    public float m() {
        Rectangle2D.Float floatR = this.f27052a;
        return floatR.Y2 + floatR.a3;
    }

    public float n() {
        return this.f27052a.Z2;
    }
}
