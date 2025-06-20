package com.itextpdf.text.pdf;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.ElementListener;
import com.itextpdf.text.Rectangle;
import java.util.List;

public class PdfBody extends Rectangle implements Element {
    public PdfBody(Rectangle rectangle) {
        super(rectangle);
    }

    public boolean V() {
        return false;
    }

    public List<Chunk> Y() {
        return null;
    }

    public boolean t(ElementListener elementListener) {
        return false;
    }

    public int type() {
        return 38;
    }

    public boolean x() {
        return false;
    }
}
