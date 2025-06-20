package com.itextpdf.text;

import com.itextpdf.text.api.Indentable;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class Section extends ArrayList<Element> implements TextElementArray, LargeElement, Indentable, IAccessibleElement {
    public static final int h3 = 0;
    public static final int i3 = 1;
    private static final long j3 = 3324172577544748043L;
    protected String X;
    protected float X2;
    protected int Y;
    protected float Y2;
    protected int Z = 0;
    protected float Z2;
    protected boolean a3 = true;
    protected boolean b3 = false;
    protected int c3 = 0;
    protected ArrayList<Integer> d3 = null;
    protected boolean e3 = true;
    protected boolean f3 = false;
    protected boolean g3 = true;
    protected Paragraph s;

    protected Section() {
        Paragraph paragraph = new Paragraph();
        this.s = paragraph;
        this.Y = 1;
        paragraph.o(new PdfName("H" + this.Y));
    }

    private void A1(int i2, ArrayList<Integer> arrayList) {
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        this.d3 = arrayList2;
        arrayList2.add(Integer.valueOf(i2));
        this.d3.addAll(arrayList);
    }

    public static Paragraph o0(Paragraph paragraph, ArrayList<Integer> arrayList, int i2, int i4) {
        if (paragraph == null) {
            return null;
        }
        int min = Math.min(arrayList.size(), i2);
        if (min < 1) {
            return paragraph;
        }
        StringBuffer stringBuffer = new StringBuffer(StringUtils.SPACE);
        for (int i5 = 0; i5 < min; i5++) {
            stringBuffer.insert(0, ".");
            stringBuffer.insert(0, arrayList.get(i5).intValue());
        }
        if (i4 == 1) {
            stringBuffer.deleteCharAt(stringBuffer.length() - 2);
        }
        Paragraph paragraph2 = new Paragraph((Phrase) paragraph);
        paragraph2.add(0, new Chunk(stringBuffer.toString(), paragraph.q0()));
        return paragraph2;
    }

    public void B(float f2) {
        this.Y2 = f2;
    }

    public void C1(Paragraph paragraph) {
        this.s = paragraph;
    }

    public void D(AccessibleElementId accessibleElementId) {
        this.s.D(accessibleElementId);
    }

    public Section E(float f2, Paragraph paragraph) {
        return K(f2, paragraph, this.Y + 1);
    }

    /* access modifiers changed from: protected */
    public boolean E0() {
        return this.f3;
    }

    public boolean F0() {
        return this.a3;
    }

    public boolean G0() {
        return type() == 16;
    }

    public boolean H0() {
        return this.g3;
    }

    public void H1(boolean z) {
        this.b3 = z;
    }

    public Section K(float f2, Paragraph paragraph, int i2) {
        if (!E0()) {
            Section section = new Section(paragraph, i2);
            section.u1(f2);
            add(section);
            return section;
        }
        throw new IllegalStateException(MessageLocalization.b("this.largeelement.has.already.been.added.to.the.document", new Object[0]));
    }

    public PdfName L() {
        return this.s.L();
    }

    public Section M(float f2, String str) {
        return E(f2, new Paragraph(str));
    }

    public boolean M0() {
        return type() == 13;
    }

    public boolean O0() {
        return this.b3 && this.g3;
    }

    public void U(PdfName pdfName, PdfObject pdfObject) {
        this.s.U(pdfName, pdfObject);
    }

    public boolean V() {
        return true;
    }

    public void W0() {
        add(Chunk.c3);
    }

    public Section X(float f2, String str, int i2) {
        return K(f2, new Paragraph(str), i2);
    }

    public List<Chunk> Y() {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            arrayList.addAll(((Element) it2.next()).Y());
        }
        return arrayList;
    }

    public boolean addAll(Collection<? extends Element> collection) {
        if (collection.size() == 0) {
            return false;
        }
        for (Element b2 : collection) {
            add(b2);
        }
        return true;
    }

    /* renamed from: b */
    public boolean add(Element element) {
        if (!E0()) {
            try {
                if (element.type() == 13) {
                    Section section = (Section) element;
                    int i2 = this.c3 + 1;
                    this.c3 = i2;
                    section.A1(i2, this.d3);
                    return super.add(section);
                } else if ((element instanceof MarkedSection) && ((MarkedObject) element).s.type() == 13) {
                    MarkedSection markedSection = (MarkedSection) element;
                    int i4 = this.c3 + 1;
                    this.c3 = i4;
                    ((Section) markedSection.s).A1(i4, this.d3);
                    return super.add(markedSection);
                } else if (element.x()) {
                    return super.add(element);
                } else {
                    throw new ClassCastException(MessageLocalization.b("you.can.t.add.a.1.to.a.section", element.getClass().getName()));
                }
            } catch (ClassCastException e2) {
                throw new ClassCastException(MessageLocalization.b("insertion.of.illegal.element.1", e2.getMessage()));
            }
        } else {
            throw new IllegalStateException(MessageLocalization.b("this.largeelement.has.already.been.added.to.the.document", new Object[0]));
        }
    }

    public Section b0(Paragraph paragraph) {
        return K(0.0f, paragraph, this.Y + 1);
    }

    /* access modifiers changed from: protected */
    public void b1(boolean z) {
        this.f3 = z;
    }

    /* renamed from: c */
    public void add(int i2, Element element) {
        if (!E0()) {
            try {
                if (element.x()) {
                    super.add(i2, element);
                } else {
                    throw new ClassCastException(MessageLocalization.b("you.can.t.add.a.1.to.a.section", element.getClass().getName()));
                }
            } catch (ClassCastException e2) {
                throw new ClassCastException(MessageLocalization.b("insertion.of.illegal.element.1", e2.getMessage()));
            }
        } else {
            throw new IllegalStateException(MessageLocalization.b("this.largeelement.has.already.been.added.to.the.document", new Object[0]));
        }
    }

    public void d() {
        w1(false);
        this.s = null;
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            if (element instanceof Section) {
                Section section = (Section) element;
                if (section.isComplete() || size() != 1) {
                    section.b1(true);
                } else {
                    section.d();
                    return;
                }
            }
            it2.remove();
        }
    }

    public Section f0(Paragraph paragraph, int i2) {
        return K(0.0f, paragraph, i2);
    }

    public void g(float f2) {
        this.X2 = f2;
    }

    public void g1(boolean z) {
        this.a3 = z;
    }

    public AccessibleElementId getId() {
        return this.s.getId();
    }

    /* access modifiers changed from: protected */
    public MarkedSection h() {
        MarkedSection markedSection = new MarkedSection(new Section((Paragraph) null, this.Y + 1));
        add(markedSection);
        return markedSection;
    }

    public boolean isComplete() {
        return this.e3;
    }

    public HashMap<PdfName, PdfObject> k0() {
        return this.s.k0();
    }

    public Section l0(String str) {
        return b0(new Paragraph(str));
    }

    public float m() {
        return this.X2;
    }

    public boolean n() {
        return false;
    }

    public Section n0(String str, int i2) {
        return f0(new Paragraph(str), i2);
    }

    public void o(PdfName pdfName) {
        this.s.o(pdfName);
    }

    public float q() {
        return this.Y2;
    }

    public Paragraph q0() {
        String str = this.X;
        return str == null ? z0() : new Paragraph(str);
    }

    public PdfObject r(PdfName pdfName) {
        return this.s.r(pdfName);
    }

    public void r1(String str) {
        this.X = str;
    }

    public boolean t(ElementListener elementListener) {
        try {
            Iterator it2 = iterator();
            while (it2.hasNext()) {
                elementListener.b((Element) it2.next());
            }
            return true;
        } catch (DocumentException unused) {
            return false;
        }
    }

    public int t0() {
        return this.d3.size();
    }

    public void t1(int i2) {
        ArrayList<Integer> arrayList = this.d3;
        arrayList.set(arrayList.size() - 1, Integer.valueOf(i2));
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            if (next instanceof Section) {
                ((Section) next).t1(i2);
            }
        }
    }

    public int type() {
        return 13;
    }

    public float u0() {
        return this.Z2;
    }

    public void u1(float f2) {
        this.Z2 = f2;
    }

    public int w0() {
        return this.Y;
    }

    public void w1(boolean z) {
        this.g3 = z;
    }

    public boolean x() {
        return false;
    }

    public int y0() {
        return this.Z;
    }

    public void y1(int i2) {
        this.Y = i2;
    }

    public void z(boolean z) {
        this.e3 = z;
    }

    public Paragraph z0() {
        return o0(this.s, this.d3, this.Y, this.Z);
    }

    public void z1(int i2) {
        this.Z = i2;
    }

    protected Section(Paragraph paragraph, int i2) {
        this.Y = i2;
        this.s = paragraph;
        if (paragraph != null) {
            paragraph.o(new PdfName("H" + i2));
        }
    }
}
