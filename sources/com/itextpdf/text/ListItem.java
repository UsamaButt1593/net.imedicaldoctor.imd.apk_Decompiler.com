package com.itextpdf.text;

import com.itextpdf.text.pdf.PdfName;
import java.util.List;

public class ListItem extends Paragraph {
    private static final long p3 = 1970670787169329006L;
    protected Chunk m3;
    private ListBody n3 = null;
    private ListLabel o3 = null;

    public ListItem() {
        o(PdfName.xa);
    }

    public void d2() {
        Chunk chunk;
        List<Chunk> Y = Y();
        if (!Y.isEmpty() && (chunk = this.m3) != null) {
            chunk.O(Y.get(0).k());
        }
    }

    public ListBody g2() {
        if (this.n3 == null) {
            this.n3 = new ListBody(this);
        }
        return this.n3;
    }

    public ListLabel i2() {
        if (this.o3 == null) {
            this.o3 = new ListLabel(this);
        }
        return this.o3;
    }

    public Chunk j2() {
        return this.m3;
    }

    public void m2(float f2, boolean z) {
        if (z) {
            f2 = j2().u();
        }
        g(f2);
    }

    public void n2(Chunk chunk) {
        if (this.m3 == null) {
            this.m3 = chunk;
            if (chunk.k().r()) {
                this.m3.O(this.Y);
            }
        }
    }

    public int type() {
        return 15;
    }

    public Paragraph w1(boolean z) {
        ListItem listItem = new ListItem();
        H1(listItem, z);
        return listItem;
    }

    public ListItem(float f2) {
        super(f2);
        o(PdfName.xa);
    }

    public ListItem(float f2, Chunk chunk) {
        super(f2, chunk);
        o(PdfName.xa);
    }

    public ListItem(float f2, String str) {
        super(f2, str);
        o(PdfName.xa);
    }

    public ListItem(float f2, String str, Font font) {
        super(f2, str, font);
        o(PdfName.xa);
    }

    public ListItem(Chunk chunk) {
        super(chunk);
        o(PdfName.xa);
    }

    public ListItem(Phrase phrase) {
        super(phrase);
        o(PdfName.xa);
    }

    public ListItem(String str) {
        super(str);
        o(PdfName.xa);
    }

    public ListItem(String str, Font font) {
        super(str, font);
        o(PdfName.xa);
    }
}
