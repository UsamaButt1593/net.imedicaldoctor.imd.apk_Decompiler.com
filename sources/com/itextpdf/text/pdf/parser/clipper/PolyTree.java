package com.itextpdf.text.pdf.parser.clipper;

import java.util.ArrayList;
import java.util.List;

public class PolyTree extends PolyNode {

    /* renamed from: h  reason: collision with root package name */
    private final List<PolyNode> f27156h = new ArrayList();

    public void r() {
        this.f27156h.clear();
        this.f27154f.clear();
    }

    public List<PolyNode> s() {
        return this.f27156h;
    }

    public PolyNode t() {
        if (!this.f27154f.isEmpty()) {
            return this.f27154f.get(0);
        }
        return null;
    }

    public int u() {
        int size = this.f27156h.size();
        return (size <= 0 || this.f27154f.get(0) == this.f27156h.get(0)) ? size : size - 1;
    }
}
