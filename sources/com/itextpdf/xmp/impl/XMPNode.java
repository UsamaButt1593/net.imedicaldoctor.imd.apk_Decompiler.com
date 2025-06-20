package com.itextpdf.xmp.impl;

import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.xmp.XMPConst;
import com.itextpdf.xmp.XMPException;
import com.itextpdf.xmp.options.PropertyOptions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class XMPNode implements Comparable {
    static final /* synthetic */ boolean d3 = false;
    private String X;
    private List X2;
    private XMPNode Y;
    private PropertyOptions Y2;
    private List Z;
    private boolean Z2;
    private boolean a3;
    private boolean b3;
    private boolean c3;
    private String s;

    public XMPNode(String str, PropertyOptions propertyOptions) {
        this(str, (String) null, propertyOptions);
    }

    private boolean H() {
        return XMPConst.q2.equals(this.s);
    }

    private boolean I() {
        return XMPConst.r2.equals(this.s);
    }

    private void e(String str) throws XMPException {
        if (!XMPConst.o2.equals(str) && m(str) != null) {
            throw new XMPException("Duplicate property or field node '" + str + "'", 203);
        }
    }

    private void f(String str) throws XMPException {
        if (!XMPConst.o2.equals(str) && n(str) != null) {
            throw new XMPException("Duplicate '" + str + "' qualifier", 203);
        }
    }

    private void k(StringBuffer stringBuffer, boolean z, int i2, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            stringBuffer.append(9);
        }
        if (this.Y != null) {
            if (v().z()) {
                stringBuffer.append('?');
            } else if (w().v().t()) {
                stringBuffer.append('[');
                stringBuffer.append(i3);
                stringBuffer.append(']');
            }
            stringBuffer.append(this.s);
        } else {
            stringBuffer.append("ROOT NODE");
            String str = this.s;
            if (str != null && str.length() > 0) {
                stringBuffer.append(" (");
                stringBuffer.append(this.s);
                stringBuffer.append(ASCIIPropertyListParser.f18650h);
            }
        }
        String str2 = this.X;
        if (str2 != null && str2.length() > 0) {
            stringBuffer.append(" = \"");
            stringBuffer.append(this.X);
            stringBuffer.append('\"');
        }
        if (v().e(-1)) {
            stringBuffer.append("\t(");
            stringBuffer.append(v().toString());
            stringBuffer.append(" : ");
            stringBuffer.append(v().j());
            stringBuffer.append(ASCIIPropertyListParser.f18650h);
        }
        stringBuffer.append(10);
        if (z && E()) {
            XMPNode[] xMPNodeArr = (XMPNode[]) y().toArray(new XMPNode[z()]);
            int i6 = 0;
            while (xMPNodeArr.length > i6 && (XMPConst.q2.equals(xMPNodeArr[i6].u()) || XMPConst.r2.equals(xMPNodeArr[i6].u()))) {
                i6++;
            }
            Arrays.sort(xMPNodeArr, i6, xMPNodeArr.length);
            int i7 = 0;
            while (i7 < xMPNodeArr.length) {
                i7++;
                xMPNodeArr[i7].k(stringBuffer, z, i2 + 2, i7);
            }
        }
        if (z && D()) {
            XMPNode[] xMPNodeArr2 = (XMPNode[]) p().toArray(new XMPNode[q()]);
            if (!v().t()) {
                Arrays.sort(xMPNodeArr2);
            }
            while (i4 < xMPNodeArr2.length) {
                i4++;
                xMPNodeArr2[i4].k(stringBuffer, z, i2 + 1, i4);
            }
        }
    }

    private XMPNode l(List list, String str) {
        if (list == null) {
            return null;
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            XMPNode xMPNode = (XMPNode) it2.next();
            if (xMPNode.u().equals(str)) {
                return xMPNode;
            }
        }
        return null;
    }

    private List p() {
        if (this.Z == null) {
            this.Z = new ArrayList(0);
        }
        return this.Z;
    }

    private List y() {
        if (this.X2 == null) {
            this.X2 = new ArrayList(0);
        }
        return this.X2;
    }

    public List A() {
        return Collections.unmodifiableList(new ArrayList(p()));
    }

    public String C() {
        return this.X;
    }

    public boolean D() {
        List list = this.Z;
        return list != null && list.size() > 0;
    }

    public boolean E() {
        List list = this.X2;
        return list != null && list.size() > 0;
    }

    public boolean F() {
        return this.b3;
    }

    public boolean G() {
        return this.Z2;
    }

    public Iterator J() {
        return this.Z != null ? p().iterator() : Collections.EMPTY_LIST.listIterator();
    }

    public Iterator K() {
        if (this.X2 == null) {
            return Collections.EMPTY_LIST.iterator();
        }
        final Iterator it2 = y().iterator();
        return new Iterator() {
            public boolean hasNext() {
                return it2.hasNext();
            }

            public Object next() {
                return it2.next();
            }

            public void remove() {
                throw new UnsupportedOperationException("remove() is not allowed due to the internal contraints");
            }
        };
    }

    public void L(int i2) {
        p().remove(i2 - 1);
        g();
    }

    public void N(XMPNode xMPNode) {
        p().remove(xMPNode);
        g();
    }

    public void O() {
        this.Z = null;
    }

    public void P(XMPNode xMPNode) {
        PropertyOptions v = v();
        if (xMPNode.H()) {
            v.J(false);
        } else if (xMPNode.I()) {
            v.L(false);
        }
        y().remove(xMPNode);
        if (this.X2.isEmpty()) {
            v.K(false);
            this.X2 = null;
        }
    }

    public void Q() {
        PropertyOptions v = v();
        v.K(false);
        v.J(false);
        v.L(false);
        this.X2 = null;
    }

    public void R(int i2, XMPNode xMPNode) {
        xMPNode.c0(this);
        p().set(i2 - 1, xMPNode);
    }

    public void S(boolean z) {
        this.b3 = z;
    }

    public void T(boolean z) {
        this.a3 = z;
    }

    public void U(boolean z) {
        this.c3 = z;
    }

    public void W(boolean z) {
        this.Z2 = z;
    }

    public void Z(String str) {
        this.s = str;
    }

    public void a(int i2, XMPNode xMPNode) throws XMPException {
        e(xMPNode.u());
        xMPNode.c0(this);
        p().add(i2 - 1, xMPNode);
    }

    public void a0(PropertyOptions propertyOptions) {
        this.Y2 = propertyOptions;
    }

    public void b(XMPNode xMPNode) throws XMPException {
        e(xMPNode.u());
        xMPNode.c0(this);
        p().add(xMPNode);
    }

    public void c(XMPNode xMPNode) throws XMPException {
        List y;
        boolean q;
        f(xMPNode.u());
        xMPNode.c0(this);
        xMPNode.v().M(true);
        v().K(true);
        if (xMPNode.H()) {
            this.Y2.J(true);
            y = y();
            q = false;
        } else if (xMPNode.I()) {
            this.Y2.L(true);
            y = y();
            q = this.Y2.q();
        } else {
            y().add(xMPNode);
            return;
        }
        y.add(q ? 1 : 0, xMPNode);
    }

    /* access modifiers changed from: protected */
    public void c0(XMPNode xMPNode) {
        this.Y = xMPNode;
    }

    public Object clone() {
        PropertyOptions propertyOptions;
        try {
            propertyOptions = new PropertyOptions(v().i());
        } catch (XMPException unused) {
            propertyOptions = new PropertyOptions();
        }
        XMPNode xMPNode = new XMPNode(this.s, this.X, propertyOptions);
        i(xMPNode);
        return xMPNode;
    }

    public int compareTo(Object obj) {
        String str;
        String u;
        if (v().A()) {
            str = this.X;
            u = ((XMPNode) obj).C();
        } else {
            str = this.s;
            u = ((XMPNode) obj).u();
        }
        return str.compareTo(u);
    }

    public void d0(String str) {
        this.X = str;
    }

    public void e0() {
        if (E()) {
            XMPNode[] xMPNodeArr = (XMPNode[]) y().toArray(new XMPNode[z()]);
            int i2 = 0;
            while (xMPNodeArr.length > i2 && (XMPConst.q2.equals(xMPNodeArr[i2].u()) || XMPConst.r2.equals(xMPNodeArr[i2].u()))) {
                xMPNodeArr[i2].e0();
                i2++;
            }
            Arrays.sort(xMPNodeArr, i2, xMPNodeArr.length);
            ListIterator listIterator = this.X2.listIterator();
            for (int i3 = 0; i3 < xMPNodeArr.length; i3++) {
                listIterator.next();
                listIterator.set(xMPNodeArr[i3]);
                xMPNodeArr[i3].e0();
            }
        }
        if (D()) {
            if (!v().t()) {
                Collections.sort(this.Z);
            }
            Iterator J = J();
            while (J.hasNext()) {
                ((XMPNode) J.next()).e0();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void g() {
        if (this.Z.isEmpty()) {
            this.Z = null;
        }
    }

    public void h() {
        this.Y2 = null;
        this.s = null;
        this.X = null;
        this.Z = null;
        this.X2 = null;
    }

    public void i(XMPNode xMPNode) {
        try {
            Iterator J = J();
            while (J.hasNext()) {
                xMPNode.b((XMPNode) ((XMPNode) J.next()).clone());
            }
            Iterator K = K();
            while (K.hasNext()) {
                xMPNode.c((XMPNode) ((XMPNode) K.next()).clone());
            }
        } catch (XMPException unused) {
        }
    }

    public String j(boolean z) {
        StringBuffer stringBuffer = new StringBuffer(512);
        k(stringBuffer, z, 0, 0);
        return stringBuffer.toString();
    }

    public XMPNode m(String str) {
        return l(p(), str);
    }

    public XMPNode n(String str) {
        return l(this.X2, str);
    }

    public XMPNode o(int i2) {
        return (XMPNode) p().get(i2 - 1);
    }

    public int q() {
        List list = this.Z;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public boolean r() {
        return this.a3;
    }

    public boolean s() {
        return this.c3;
    }

    public String u() {
        return this.s;
    }

    public PropertyOptions v() {
        if (this.Y2 == null) {
            this.Y2 = new PropertyOptions();
        }
        return this.Y2;
    }

    public XMPNode w() {
        return this.Y;
    }

    public XMPNode x(int i2) {
        return (XMPNode) y().get(i2 - 1);
    }

    public int z() {
        List list = this.X2;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public XMPNode(String str, String str2, PropertyOptions propertyOptions) {
        this.Z = null;
        this.X2 = null;
        this.s = str;
        this.X = str2;
        this.Y2 = propertyOptions;
    }
}
