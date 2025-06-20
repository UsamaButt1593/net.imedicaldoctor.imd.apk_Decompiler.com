package com.itextpdf.text;

import com.itextpdf.text.api.Indentable;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.interfaces.IAccessibleElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class List implements TextElementArray, Indentable, IAccessibleElement {
    public static final boolean j3 = true;
    public static final boolean k3 = false;
    public static final boolean l3 = false;
    public static final boolean m3 = true;
    public static final boolean n3 = false;
    public static final boolean o3 = true;
    protected boolean X;
    protected boolean X2;
    protected boolean Y;
    protected boolean Y2;
    protected boolean Z;
    protected int Z2;
    protected Chunk a3;
    protected String b3;
    protected String c3;
    protected float d3;
    protected float e3;
    protected float f3;
    protected PdfName g3;
    protected HashMap<PdfName, PdfObject> h3;
    private AccessibleElementId i3;
    protected ArrayList<Element> s;

    public List() {
        this(false, false);
    }

    public boolean A() {
        return this.Z;
    }

    public void B(float f2) {
        this.e3 = f2;
    }

    public boolean C() {
        return this.X;
    }

    public void D(AccessibleElementId accessibleElementId) {
        this.i3 = accessibleElementId;
    }

    public void E() {
        Iterator<Element> it2 = this.s.iterator();
        float f2 = 0.0f;
        while (it2.hasNext()) {
            Element next = it2.next();
            if (next instanceof ListItem) {
                f2 = Math.max(f2, ((ListItem) next).m());
            }
        }
        Iterator<Element> it3 = this.s.iterator();
        while (it3.hasNext()) {
            Element next2 = it3.next();
            if (next2 instanceof ListItem) {
                ((ListItem) next2).g(f2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void F(List list) {
        list.d3 = this.d3;
        list.e3 = this.e3;
        list.X2 = this.X2;
        list.Y2 = this.Y2;
        list.f3 = this.f3;
        list.a3 = this.a3;
    }

    public void G(boolean z) {
        this.Y2 = z;
    }

    public void H(boolean z) {
        this.X2 = z;
    }

    public void I(int i2) {
        this.Z2 = i2;
    }

    public void J(boolean z) {
        this.Y = z;
    }

    public void K(Chunk chunk) {
        this.a3 = chunk;
    }

    public PdfName L() {
        return this.g3;
    }

    public void M(String str) {
        this.a3 = new Chunk(str);
    }

    public void N(boolean z) {
        this.Z = z;
    }

    public void O(boolean z) {
        this.X = z;
    }

    public void P(String str) {
        this.c3 = str;
    }

    public void Q(String str) {
        this.b3 = str;
    }

    public void R(float f2) {
        this.f3 = f2;
    }

    public int S() {
        return this.s.size();
    }

    public void U(PdfName pdfName, PdfObject pdfObject) {
        if (this.h3 == null) {
            this.h3 = new HashMap<>();
        }
        this.h3.put(pdfName, pdfObject);
    }

    public boolean V() {
        return true;
    }

    public java.util.List<Chunk> Y() {
        ArrayList arrayList = new ArrayList();
        Iterator<Element> it2 = this.s.iterator();
        while (it2.hasNext()) {
            arrayList.addAll(it2.next().Y());
        }
        return arrayList;
    }

    public boolean a(String str) {
        if (str != null) {
            return b(new ListItem(str));
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.itextpdf.text.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: com.itextpdf.text.ListItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: com.itextpdf.text.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: com.itextpdf.text.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(com.itextpdf.text.Element r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof com.itextpdf.text.ListItem
            if (r0 == 0) goto L_0x005f
            com.itextpdf.text.ListItem r4 = (com.itextpdf.text.ListItem) r4
            boolean r0 = r3.X
            if (r0 != 0) goto L_0x0015
            boolean r0 = r3.Y
            if (r0 == 0) goto L_0x000f
            goto L_0x0015
        L_0x000f:
            com.itextpdf.text.Chunk r0 = r3.a3
        L_0x0011:
            r4.n2(r0)
            goto L_0x004d
        L_0x0015:
            com.itextpdf.text.Chunk r0 = new com.itextpdf.text.Chunk
            java.lang.String r1 = r3.b3
            com.itextpdf.text.Chunk r2 = r3.a3
            com.itextpdf.text.Font r2 = r2.k()
            r0.<init>((java.lang.String) r1, (com.itextpdf.text.Font) r2)
            com.itextpdf.text.Chunk r1 = r3.a3
            java.util.HashMap r1 = r1.h()
            r0.J(r1)
            int r1 = r3.Z2
            java.util.ArrayList<com.itextpdf.text.Element> r2 = r3.s
            int r2 = r2.size()
            int r1 = r1 + r2
            boolean r2 = r3.Y
            if (r2 == 0) goto L_0x0042
            boolean r2 = r3.Z
            java.lang.String r1 = com.itextpdf.text.factories.RomanAlphabetFactory.c(r1, r2)
        L_0x003e:
            r0.a(r1)
            goto L_0x0047
        L_0x0042:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            goto L_0x003e
        L_0x0047:
            java.lang.String r1 = r3.c3
            r0.a(r1)
            goto L_0x0011
        L_0x004d:
            float r0 = r3.f3
            boolean r1 = r3.X2
            r4.m2(r0, r1)
            r0 = 0
            r4.B(r0)
        L_0x0058:
            java.util.ArrayList<com.itextpdf.text.Element> r0 = r3.s
            boolean r4 = r0.add(r4)
            return r4
        L_0x005f:
            boolean r0 = r4 instanceof com.itextpdf.text.List
            if (r0 == 0) goto L_0x0076
            com.itextpdf.text.List r4 = (com.itextpdf.text.List) r4
            float r0 = r4.m()
            float r1 = r3.f3
            float r0 = r0 + r1
            r4.g(r0)
            int r0 = r3.Z2
            int r0 = r0 + -1
            r3.Z2 = r0
            goto L_0x0058
        L_0x0076:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.text.List.b(com.itextpdf.text.Element):boolean");
    }

    public List c() {
        List list = new List();
        F(list);
        return list;
    }

    public int e() {
        return this.Z2;
    }

    public ListItem f() {
        Element element = this.s.size() > 0 ? this.s.get(0) : null;
        if (element != null) {
            if (element instanceof ListItem) {
                return (ListItem) element;
            }
            if (element instanceof List) {
                return ((List) element).f();
            }
        }
        return null;
    }

    public void g(float f2) {
        this.d3 = f2;
    }

    public AccessibleElementId getId() {
        if (this.i3 == null) {
            this.i3 = new AccessibleElementId();
        }
        return this.i3;
    }

    public ArrayList<Element> h() {
        return this.s;
    }

    public ListItem i() {
        Element element;
        if (this.s.size() > 0) {
            ArrayList<Element> arrayList = this.s;
            element = arrayList.get(arrayList.size() - 1);
        } else {
            element = null;
        }
        if (element != null) {
            if (element instanceof ListItem) {
                return (ListItem) element;
            }
            if (element instanceof List) {
                return ((List) element).i();
            }
        }
        return null;
    }

    public String j() {
        return this.c3;
    }

    public String k() {
        return this.b3;
    }

    public HashMap<PdfName, PdfObject> k0() {
        return this.h3;
    }

    public Chunk l() {
        return this.a3;
    }

    public float m() {
        return this.d3;
    }

    public boolean n() {
        return false;
    }

    public void o(PdfName pdfName) {
        this.g3 = pdfName;
    }

    public float p() {
        return this.f3;
    }

    public float q() {
        return this.e3;
    }

    public PdfObject r(PdfName pdfName) {
        HashMap<PdfName, PdfObject> hashMap = this.h3;
        if (hashMap != null) {
            return hashMap.get(pdfName);
        }
        return null;
    }

    public float s() {
        if (this.s.size() < 1) {
            return -1.0f;
        }
        return ((ListItem) this.s.get(0)).G0();
    }

    public boolean t(ElementListener elementListener) {
        try {
            Iterator<Element> it2 = this.s.iterator();
            while (it2.hasNext()) {
                elementListener.b(it2.next());
            }
            return true;
        } catch (DocumentException unused) {
            return false;
        }
    }

    public int type() {
        return 14;
    }

    public boolean u() {
        return this.Y2;
    }

    public boolean v() {
        return this.X2;
    }

    public boolean w() {
        return this.s.isEmpty();
    }

    public boolean x() {
        return true;
    }

    public boolean y() {
        return this.Y;
    }

    public List(float f2) {
        this.s = new ArrayList<>();
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.X2 = false;
        this.Y2 = false;
        this.Z2 = 1;
        this.a3 = new Chunk("- ");
        this.b3 = "";
        this.c3 = ". ";
        this.d3 = 0.0f;
        this.e3 = 0.0f;
        this.f3 = 0.0f;
        this.g3 = PdfName.ja;
        this.h3 = null;
        this.i3 = null;
        this.f3 = f2;
    }

    public List(boolean z) {
        this(z, false);
    }

    public List(boolean z, float f2) {
        this(z, false, f2);
    }

    public List(boolean z, boolean z2) {
        this.s = new ArrayList<>();
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.X2 = false;
        this.Y2 = false;
        this.Z2 = 1;
        this.a3 = new Chunk("- ");
        this.b3 = "";
        this.c3 = ". ";
        this.d3 = 0.0f;
        this.e3 = 0.0f;
        this.f3 = 0.0f;
        this.g3 = PdfName.ja;
        this.h3 = null;
        this.i3 = null;
        this.X = z;
        this.Y = z2;
        this.X2 = true;
        this.Y2 = true;
    }

    public List(boolean z, boolean z2, float f2) {
        this.s = new ArrayList<>();
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.X2 = false;
        this.Y2 = false;
        this.Z2 = 1;
        this.a3 = new Chunk("- ");
        this.b3 = "";
        this.c3 = ". ";
        this.d3 = 0.0f;
        this.e3 = 0.0f;
        this.f3 = 0.0f;
        this.g3 = PdfName.ja;
        this.h3 = null;
        this.i3 = null;
        this.X = z;
        this.Y = z2;
        this.f3 = f2;
    }
}
