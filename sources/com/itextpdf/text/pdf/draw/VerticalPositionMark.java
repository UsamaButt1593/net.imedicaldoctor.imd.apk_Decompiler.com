package com.itextpdf.text.pdf.draw;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.pdf.PdfContentByte;
import java.util.ArrayList;
import java.util.List;

public class VerticalPositionMark implements DrawInterface, Element {
    protected float X;
    protected DrawInterface s;

    public VerticalPositionMark() {
        this.s = null;
        this.X = 0.0f;
    }

    public boolean V() {
        return true;
    }

    public List<Chunk> Y() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Chunk((DrawInterface) this, true));
        return arrayList;
    }

    public void a(PdfContentByte pdfContentByte, float f2, float f3, float f4, float f5, float f6) {
        DrawInterface drawInterface = this.s;
        if (drawInterface != null) {
            drawInterface.a(pdfContentByte, f2, f3, f4, f5, f6 + this.X);
        }
    }

    public DrawInterface c() {
        return this.s;
    }

    public float e() {
        return this.X;
    }

    public void f(DrawInterface drawInterface) {
        this.s = drawInterface;
    }

    public void g(float f2) {
        this.X = f2;
    }

    public boolean t(ElementListener elementListener) {
        try {
            return elementListener.b(this);
        } catch (DocumentException unused) {
            return false;
        }
    }

    public int type() {
        return 55;
    }

    public boolean x() {
        return false;
    }

    public VerticalPositionMark(DrawInterface drawInterface, float f2) {
        this.s = drawInterface;
        this.X = f2;
    }
}
