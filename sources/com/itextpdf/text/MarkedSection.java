package com.itextpdf.text;

import com.itextpdf.text.api.Indentable;
import java.util.Collection;
import java.util.Iterator;

@Deprecated
public class MarkedSection extends MarkedObject implements Indentable {
    protected MarkedObject Y = null;

    public MarkedSection(Section section) {
        Paragraph paragraph = section.s;
        if (paragraph != null) {
            this.Y = new MarkedObject(paragraph);
            section.C1((Paragraph) null);
        }
        this.s = section;
    }

    public void B(float f2) {
        ((Section) this.s).B(f2);
    }

    public boolean b(Element element) {
        return ((Section) this.s).add(element);
    }

    public void e(int i2, Element element) {
        ((Section) this.s).add(i2, element);
    }

    public boolean f(Collection<? extends Element> collection) {
        return ((Section) this.s).addAll(collection);
    }

    public void g(float f2) {
        ((Section) this.s).g(f2);
    }

    public MarkedSection h() {
        return ((Section) this.s).h();
    }

    public MarkedSection i(float f2) {
        MarkedSection h2 = ((Section) this.s).h();
        h2.r(f2);
        return h2;
    }

    public MarkedSection j(float f2, int i2) {
        MarkedSection h2 = ((Section) this.s).h();
        h2.r(f2);
        h2.s(i2);
        return h2;
    }

    public MarkedSection k(int i2) {
        MarkedSection h2 = ((Section) this.s).h();
        h2.s(i2);
        return h2;
    }

    public MarkedObject l() {
        Element element = this.s;
        MarkedObject markedObject = new MarkedObject(Section.o0((Paragraph) this.Y.s, ((Section) element).d3, ((Section) element).Y, ((Section) element).Z));
        markedObject.X = this.Y.X;
        return markedObject;
    }

    public float m() {
        return ((Section) this.s).m();
    }

    public void n() {
        ((Section) this.s).W0();
    }

    public void o(boolean z) {
        ((Section) this.s).g1(z);
    }

    public void p(String str) {
        ((Section) this.s).r1(str);
    }

    public float q() {
        return ((Section) this.s).q();
    }

    public void r(float f2) {
        ((Section) this.s).u1(f2);
    }

    public void s(int i2) {
        ((Section) this.s).y1(i2);
    }

    public boolean t(ElementListener elementListener) {
        try {
            Iterator it2 = ((Section) this.s).iterator();
            while (it2.hasNext()) {
                elementListener.b((Element) it2.next());
            }
            return true;
        } catch (DocumentException unused) {
            return false;
        }
    }

    public void u(MarkedObject markedObject) {
        if (markedObject.s instanceof Paragraph) {
            this.Y = markedObject;
        }
    }

    public void v(boolean z) {
        ((Section) this.s).H1(z);
    }
}
