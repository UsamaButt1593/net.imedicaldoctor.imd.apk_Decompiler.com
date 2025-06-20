package com.itextpdf.tool.xml.html.pdfelement;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.api.Indentable;

public class NoNewLineParagraph extends Phrase implements Indentable {
    private static final long h3 = -8392940968188620772L;
    protected int Z2 = -1;
    protected float a3;
    protected float b3;
    private float c3 = 0.0f;
    protected float d3;
    protected float e3;
    private float f3 = 0.0f;
    protected boolean g3 = false;

    public NoNewLineParagraph() {
    }

    public void A1(int i2) {
        this.Z2 = i2;
    }

    public void B(float f2) {
        this.b3 = f2;
    }

    public void C1(float f2) {
        this.f3 = f2;
    }

    public float E() {
        return this.d3;
    }

    public void H1(float f2) {
        this.c3 = f2;
    }

    public float K() {
        return this.e3;
    }

    public void O1(boolean z) {
        this.g3 = z;
    }

    @Deprecated
    public float R1() {
        return this.e3;
    }

    @Deprecated
    public float S1() {
        return E();
    }

    /* renamed from: b */
    public boolean add(Element element) {
        if (element instanceof List) {
            List list = (List) element;
            list.g(list.m() + this.a3);
            list.B(this.b3);
            return super.add(list);
        } else if (!(element instanceof Image)) {
            return super.add(element);
        } else {
            super.n0(element);
            return true;
        }
    }

    public void c(float f2) {
        this.e3 = f2;
    }

    public void g(float f2) {
        this.a3 = f2;
    }

    public void h(float f2) {
        this.d3 = f2;
    }

    public float m() {
        return this.a3;
    }

    public float q() {
        return this.b3;
    }

    public int u1() {
        return this.Z2;
    }

    public float w1() {
        return this.f3;
    }

    public float y1() {
        return this.c3;
    }

    public boolean z1() {
        return this.g3;
    }

    public NoNewLineParagraph(float f2) {
        super(f2);
    }

    public NoNewLineParagraph(float f2, Chunk chunk) {
        super(f2, chunk);
    }

    public NoNewLineParagraph(float f2, String str) {
        super(f2, str);
    }

    public NoNewLineParagraph(float f2, String str, Font font) {
        super(f2, str, font);
    }

    public NoNewLineParagraph(Chunk chunk) {
        super(chunk);
    }

    public NoNewLineParagraph(Phrase phrase) {
        super(phrase);
        if (phrase instanceof NoNewLineParagraph) {
            NoNewLineParagraph noNewLineParagraph = (NoNewLineParagraph) phrase;
            this.Z2 = noNewLineParagraph.u1();
            this.a3 = noNewLineParagraph.m();
            this.b3 = noNewLineParagraph.q();
            this.c3 = noNewLineParagraph.y1();
            this.e3 = noNewLineParagraph.K();
            this.d3 = noNewLineParagraph.E();
            this.f3 = noNewLineParagraph.w1();
        }
        if (phrase instanceof Paragraph) {
            Paragraph paragraph = (Paragraph) phrase;
            A1(paragraph.y1());
            g(paragraph.m());
            B(paragraph.q());
            H1(paragraph.A1());
            c(paragraph.K());
            h(paragraph.E());
            C1(paragraph.z1());
        }
    }

    public NoNewLineParagraph(String str) {
        super(str);
    }

    public NoNewLineParagraph(String str, Font font) {
        super(str, font);
    }
}
