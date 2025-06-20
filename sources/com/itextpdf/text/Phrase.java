package com.itextpdf.text;

import com.itextpdf.text.Font;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.HyphenationEvent;
import com.itextpdf.text.pdf.PdfName;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Phrase extends ArrayList<Element> implements TextElementArray {
    private static final long Y2 = 2643594602455068231L;
    protected float X;
    protected TabSettings X2;
    protected Font Y;
    protected HyphenationEvent Z;
    protected float s;

    public Phrase() {
        this(16.0f);
    }

    public static final Phrase u0(int i2, String str) {
        return w0(i2, str, new Font());
    }

    public static final Phrase w0(int i2, String str, Font font) {
        Phrase phrase = new Phrase(true);
        phrase.W0((float) i2);
        phrase.Y = font;
        if (font.j() != Font.FontFamily.SYMBOL && font.j() != Font.FontFamily.ZAPFDINGBATS && font.c() == null) {
            while (true) {
                int c2 = SpecialSymbol.c(str);
                if (c2 <= -1) {
                    break;
                }
                if (c2 > 0) {
                    phrase.add(new Chunk(str.substring(0, c2), font));
                    str = str.substring(c2);
                }
                Font font2 = new Font(Font.FontFamily.SYMBOL, font.m(), font.n(), font.i());
                StringBuffer stringBuffer = new StringBuffer();
                do {
                    stringBuffer.append(SpecialSymbol.b(str.charAt(0)));
                    str = str.substring(1);
                } while (SpecialSymbol.c(str) == 0);
                phrase.add(new Chunk(stringBuffer.toString(), font2));
            }
        }
        if (!(str == null || str.length() == 0)) {
            phrase.add(new Chunk(str, font));
        }
        return phrase;
    }

    public static final Phrase y0(String str) {
        return w0(16, str, new Font());
    }

    public float E0() {
        return this.X;
    }

    public TabSettings F0() {
        return this.X2;
    }

    public float G0() {
        Font font = this.Y;
        float f2 = font == null ? this.X * 12.0f : font.f(this.X);
        return (f2 <= 0.0f || H0()) ? z0() + f2 : f2;
    }

    public boolean H0() {
        return !Float.isNaN(this.s);
    }

    public void M0(Font font) {
        this.Y = font;
    }

    public void O0(HyphenationEvent hyphenationEvent) {
        this.Z = hyphenationEvent;
    }

    public boolean V() {
        return true;
    }

    public void W0(float f2) {
        this.s = f2;
        this.X = 0.0f;
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
        for (Element b2 : collection) {
            add(b2);
        }
        return true;
    }

    /* renamed from: b */
    public boolean add(Element element) {
        if (element == null) {
            return false;
        }
        try {
            int type = element.type();
            if (type == 14 || type == 17 || type == 23 || type == 29 || type == 37 || type == 50 || type == 55 || type == 666) {
                return super.add(element);
            }
            switch (type) {
                case 10:
                    return l0((Chunk) element);
                case 11:
                case 12:
                    Iterator it2 = ((Phrase) element).iterator();
                    boolean z = true;
                    while (it2.hasNext()) {
                        Element element2 = (Element) it2.next();
                        z &= element2 instanceof Chunk ? l0((Chunk) element2) : add(element2);
                    }
                    return z;
                default:
                    throw new ClassCastException(String.valueOf(element.type()));
            }
        } catch (ClassCastException e2) {
            throw new ClassCastException(MessageLocalization.b("insertion.of.illegal.element.1", e2.getMessage()));
        }
    }

    /* renamed from: b0 */
    public void add(int i2, Element element) {
        if (element != null) {
            int type = element.type();
            if (!(type == 14 || type == 17 || type == 23 || type == 29 || type == 37 || type == 50 || type == 55 || type == 666)) {
                switch (type) {
                    case 10:
                        Chunk chunk = (Chunk) element;
                        if (!this.Y.r()) {
                            chunk.O(this.Y.b(chunk.k()));
                        }
                        if (this.Z != null && chunk.m() == null && !chunk.A()) {
                            chunk.R(this.Z);
                        }
                        super.add(i2, chunk);
                        return;
                    case 11:
                    case 12:
                        break;
                    default:
                        throw new ClassCastException(MessageLocalization.b("insertion.of.illegal.element.1", element.getClass().getName()));
                }
            }
            super.add(i2, element);
        }
    }

    public void b1(float f2, float f3) {
        this.s = f2;
        this.X = f3;
    }

    public boolean f0(String str) {
        if (str == null) {
            return false;
        }
        return super.add(new Chunk(str, this.Y));
    }

    public void g1(float f2) {
        this.s = 0.0f;
        this.X = f2;
    }

    public boolean isEmpty() {
        int size = size();
        if (size == 0) {
            return true;
        }
        if (size != 1) {
            return false;
        }
        Element element = (Element) get(0);
        return element.type() == 10 && ((Chunk) element).A();
    }

    /* access modifiers changed from: protected */
    public boolean l0(Chunk chunk) {
        boolean z;
        Font k2 = chunk.k();
        String j2 = chunk.j();
        Font font = this.Y;
        if (font != null && !font.r()) {
            k2 = this.Y.b(chunk.k());
        }
        if (size() > 0 && !chunk.y()) {
            try {
                Chunk chunk2 = (Chunk) get(size() - 1);
                PdfName L = chunk2.L();
                PdfName L2 = chunk.L();
                if (L != null) {
                    if (L2 != null) {
                        z = L.equals(L2);
                        if (z && !chunk2.y() && !chunk.w() && !chunk2.w() && ((k2 == null || k2.compareTo(chunk2.k()) == 0) && !"".equals(chunk2.j().trim()) && !"".equals(j2.trim()))) {
                            chunk2.a(j2);
                            return true;
                        }
                    }
                }
                z = true;
                chunk2.a(j2);
                return true;
            } catch (ClassCastException unused) {
            }
        }
        Chunk chunk3 = new Chunk(j2, k2);
        chunk3.J(chunk.h());
        chunk3.Z = chunk.L();
        chunk3.X2 = chunk.k0();
        if (this.Z != null && chunk3.m() == null && !chunk3.A()) {
            chunk3.R(this.Z);
        }
        return super.add(chunk3);
    }

    /* access modifiers changed from: protected */
    public void n0(Element element) {
        super.add(element);
    }

    public String o0() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Chunk chunk : Y()) {
            stringBuffer.append(chunk.toString());
        }
        return stringBuffer.toString();
    }

    public Font q0() {
        return this.Y;
    }

    public void r1(TabSettings tabSettings) {
        this.X2 = tabSettings;
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

    public HyphenationEvent t0() {
        return this.Z;
    }

    public boolean t1() {
        while (size() > 0) {
            Element element = (Element) get(0);
            if (!(element instanceof Chunk) || !((Chunk) element).C()) {
                break;
            }
            remove(element);
        }
        while (size() > 0) {
            Element element2 = (Element) get(size() - 1);
            if (!(element2 instanceof Chunk) || !((Chunk) element2).C()) {
                break;
            }
            remove(element2);
        }
        return size() > 0;
    }

    public int type() {
        return 11;
    }

    public boolean x() {
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r2.Y;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public float z0() {
        /*
            r2 = this;
            float r0 = r2.s
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 == 0) goto L_0x0013
            com.itextpdf.text.Font r0 = r2.Y
            if (r0 == 0) goto L_0x0013
            r1 = 1069547520(0x3fc00000, float:1.5)
            float r0 = r0.f(r1)
            return r0
        L_0x0013:
            float r0 = r2.s
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.Phrase.z0():float");
    }

    public Phrase(float f2) {
        this.X = 0.0f;
        this.Z = null;
        this.X2 = null;
        this.s = f2;
        this.Y = new Font();
    }

    public Phrase(float f2, Chunk chunk) {
        this.X = 0.0f;
        this.Z = null;
        this.X2 = null;
        this.s = f2;
        super.add(chunk);
        this.Y = chunk.k();
        O0(chunk.m());
    }

    public Phrase(float f2, String str) {
        this(f2, str, new Font());
    }

    public Phrase(float f2, String str, Font font) {
        this.X = 0.0f;
        this.Z = null;
        this.X2 = null;
        this.s = f2;
        this.Y = font;
        if (str != null && str.length() != 0) {
            super.add(new Chunk(str, font));
        }
    }

    public Phrase(Chunk chunk) {
        this.s = Float.NaN;
        this.X = 0.0f;
        this.Z = null;
        this.X2 = null;
        super.add(chunk);
        this.Y = chunk.k();
        O0(chunk.m());
    }

    public Phrase(Phrase phrase) {
        this.s = Float.NaN;
        this.X = 0.0f;
        this.Z = null;
        this.X2 = null;
        addAll(phrase);
        b1(phrase.z0(), phrase.E0());
        this.Y = phrase.q0();
        this.X2 = phrase.F0();
        O0(phrase.t0());
    }

    public Phrase(String str) {
        this(Float.NaN, str, new Font());
    }

    public Phrase(String str, Font font) {
        this(Float.NaN, str, font);
    }

    private Phrase(boolean z) {
        this.s = Float.NaN;
        this.X = 0.0f;
        this.Z = null;
        this.X2 = null;
    }
}
