package com.itextpdf.text;

import com.itextpdf.text.api.WriterOperation;
import java.util.ArrayList;
import java.util.List;

public abstract class WritableDirectElement implements Element, WriterOperation {
    public static final int X = 0;
    public static final int Y = 1;
    protected int s;

    public WritableDirectElement() {
        this.s = 0;
    }

    public boolean V() {
        return false;
    }

    public List<Chunk> Y() {
        return new ArrayList(0);
    }

    public int c() {
        return this.s;
    }

    public boolean t(ElementListener elementListener) {
        throw new UnsupportedOperationException();
    }

    public int type() {
        return Element.N0;
    }

    public boolean x() {
        throw new UnsupportedOperationException();
    }

    public WritableDirectElement(int i2) {
        this.s = i2;
    }
}
