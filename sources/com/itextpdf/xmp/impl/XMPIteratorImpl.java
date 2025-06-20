package com.itextpdf.xmp.impl;

import com.itextpdf.xmp.XMPException;
import com.itextpdf.xmp.XMPIterator;
import com.itextpdf.xmp.XMPMetaFactory;
import com.itextpdf.xmp.impl.xpath.XMPPath;
import com.itextpdf.xmp.impl.xpath.XMPPathParser;
import com.itextpdf.xmp.options.IteratorOptions;
import com.itextpdf.xmp.options.PropertyOptions;
import com.itextpdf.xmp.properties.XMPPropertyInfo;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class XMPIteratorImpl implements XMPIterator {
    private String X = null;
    private Iterator X2 = null;
    protected boolean Y = false;
    protected boolean Z = false;
    private IteratorOptions s;

    private class NodeIterator implements Iterator {
        protected static final int b3 = 0;
        protected static final int c3 = 1;
        protected static final int d3 = 2;
        private XMPNode X;
        private int X2 = 0;
        private String Y;
        private Iterator Y2 = Collections.EMPTY_LIST.iterator();
        private Iterator Z = null;
        private XMPPropertyInfo Z2 = null;
        private int s = 0;

        public NodeIterator() {
        }

        private boolean e(Iterator it2) {
            XMPIteratorImpl xMPIteratorImpl = XMPIteratorImpl.this;
            if (xMPIteratorImpl.Y) {
                xMPIteratorImpl.Y = false;
                this.Y2 = Collections.EMPTY_LIST.iterator();
            }
            if (!this.Y2.hasNext() && it2.hasNext()) {
                int i2 = this.X2 + 1;
                this.X2 = i2;
                this.Y2 = new NodeIterator((XMPNode) it2.next(), this.Y, i2);
            }
            if (!this.Y2.hasNext()) {
                return false;
            }
            this.Z2 = (XMPPropertyInfo) this.Y2.next();
            return true;
        }

        /* access modifiers changed from: protected */
        public String a(XMPNode xMPNode, String str, int i2) {
            String str2;
            String str3;
            if (xMPNode.w() == null || xMPNode.v().A()) {
                return null;
            }
            if (xMPNode.w().v().t()) {
                str3 = "[" + String.valueOf(i2) + "]";
                str2 = "";
            } else {
                str3 = xMPNode.u();
                str2 = "/";
            }
            if (str == null || str.length() == 0) {
                return str3;
            }
            if (XMPIteratorImpl.this.b().q()) {
                return !str3.startsWith("?") ? str3 : str3.substring(1);
            }
            return str + str2 + str3;
        }

        /* access modifiers changed from: protected */
        public XMPPropertyInfo b(XMPNode xMPNode, String str, String str2) {
            final String C = xMPNode.v().A() ? null : xMPNode.C();
            final XMPNode xMPNode2 = xMPNode;
            final String str3 = str;
            final String str4 = str2;
            return new XMPPropertyInfo() {
                public String a() {
                    if (xMPNode2.v().A()) {
                        return str3;
                    }
                    return XMPMetaFactory.c().c(new QName(xMPNode2.u()).b());
                }

                public PropertyOptions b() {
                    return xMPNode2.v();
                }

                public String c() {
                    return null;
                }

                public String getPath() {
                    return str4;
                }

                public String getValue() {
                    return C;
                }
            };
        }

        /* access modifiers changed from: protected */
        public Iterator c() {
            return this.Z;
        }

        /* access modifiers changed from: protected */
        public XMPPropertyInfo d() {
            return this.Z2;
        }

        /* access modifiers changed from: protected */
        public boolean f() {
            this.s = 1;
            if (this.X.w() == null || (XMPIteratorImpl.this.b().r() && this.X.D())) {
                return hasNext();
            }
            this.Z2 = b(this.X, XMPIteratorImpl.this.a(), this.Y);
            return true;
        }

        /* access modifiers changed from: protected */
        public void g(Iterator it2) {
            this.Z = it2;
        }

        /* access modifiers changed from: protected */
        public void h(XMPPropertyInfo xMPPropertyInfo) {
            this.Z2 = xMPPropertyInfo;
        }

        public boolean hasNext() {
            if (this.Z2 != null) {
                return true;
            }
            int i2 = this.s;
            if (i2 == 0) {
                return f();
            }
            if (i2 == 1) {
                if (this.Z == null) {
                    this.Z = this.X.J();
                }
                boolean e2 = e(this.Z);
                if (e2 || !this.X.E() || XMPIteratorImpl.this.b().s()) {
                    return e2;
                }
                this.s = 2;
                this.Z = null;
                return hasNext();
            }
            if (this.Z == null) {
                this.Z = this.X.K();
            }
            return e(this.Z);
        }

        public Object next() {
            if (hasNext()) {
                XMPPropertyInfo xMPPropertyInfo = this.Z2;
                this.Z2 = null;
                return xMPPropertyInfo;
            }
            throw new NoSuchElementException("There are no more nodes to return");
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public NodeIterator(XMPNode xMPNode, String str, int i2) {
            this.X = xMPNode;
            this.s = 0;
            if (xMPNode.v().A()) {
                XMPIteratorImpl.this.c(xMPNode.u());
            }
            this.Y = a(xMPNode, str, i2);
        }
    }

    private class NodeIteratorChildren extends NodeIterator {
        private String e3;
        private Iterator f3;
        private int g3 = 0;

        public NodeIteratorChildren(XMPNode xMPNode, String str) {
            super();
            if (xMPNode.v().A()) {
                XMPIteratorImpl.this.c(xMPNode.u());
            }
            this.e3 = a(xMPNode, str, 1);
            this.f3 = xMPNode.J();
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0061  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean hasNext() {
            /*
                r4 = this;
                com.itextpdf.xmp.properties.XMPPropertyInfo r0 = r4.d()
                r1 = 1
                if (r0 == 0) goto L_0x0008
                return r1
            L_0x0008:
                com.itextpdf.xmp.impl.XMPIteratorImpl r0 = com.itextpdf.xmp.impl.XMPIteratorImpl.this
                boolean r0 = r0.Y
                r2 = 0
                if (r0 == 0) goto L_0x0010
                return r2
            L_0x0010:
                java.util.Iterator r0 = r4.f3
                boolean r0 = r0.hasNext()
                if (r0 == 0) goto L_0x006f
                java.util.Iterator r0 = r4.f3
                java.lang.Object r0 = r0.next()
                com.itextpdf.xmp.impl.XMPNode r0 = (com.itextpdf.xmp.impl.XMPNode) r0
                int r2 = r4.g3
                int r2 = r2 + r1
                r4.g3 = r2
                com.itextpdf.xmp.options.PropertyOptions r2 = r0.v()
                boolean r2 = r2.A()
                if (r2 == 0) goto L_0x0039
                com.itextpdf.xmp.impl.XMPIteratorImpl r2 = com.itextpdf.xmp.impl.XMPIteratorImpl.this
                java.lang.String r3 = r0.u()
                r2.c(r3)
                goto L_0x0048
            L_0x0039:
                com.itextpdf.xmp.impl.XMPNode r2 = r0.w()
                if (r2 == 0) goto L_0x0048
                java.lang.String r2 = r4.e3
                int r3 = r4.g3
                java.lang.String r2 = r4.a(r0, r2, r3)
                goto L_0x0049
            L_0x0048:
                r2 = 0
            L_0x0049:
                com.itextpdf.xmp.impl.XMPIteratorImpl r3 = com.itextpdf.xmp.impl.XMPIteratorImpl.this
                com.itextpdf.xmp.options.IteratorOptions r3 = r3.b()
                boolean r3 = r3.r()
                if (r3 == 0) goto L_0x0061
                boolean r3 = r0.D()
                if (r3 != 0) goto L_0x005c
                goto L_0x0061
            L_0x005c:
                boolean r0 = r4.hasNext()
                return r0
            L_0x0061:
                com.itextpdf.xmp.impl.XMPIteratorImpl r3 = com.itextpdf.xmp.impl.XMPIteratorImpl.this
                java.lang.String r3 = r3.a()
                com.itextpdf.xmp.properties.XMPPropertyInfo r0 = r4.b(r0, r3, r2)
                r4.h(r0)
                return r1
            L_0x006f:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.itextpdf.xmp.impl.XMPIteratorImpl.NodeIteratorChildren.hasNext():boolean");
        }
    }

    public XMPIteratorImpl(XMPMetaImpl xMPMetaImpl, String str, String str2, IteratorOptions iteratorOptions) throws XMPException {
        XMPNode xMPNode;
        String str3 = null;
        this.s = iteratorOptions == null ? new IteratorOptions() : iteratorOptions;
        boolean z = str != null && str.length() > 0;
        boolean z2 = str2 != null && str2.length() > 0;
        if (!z && !z2) {
            xMPNode = xMPMetaImpl.e();
        } else if (z && z2) {
            XMPPath a2 = XMPPathParser.a(str, str2);
            XMPPath xMPPath = new XMPPath();
            for (int i2 = 0; i2 < a2.c() - 1; i2++) {
                xMPPath.a(a2.b(i2));
            }
            xMPNode = XMPNodeUtils.g(xMPMetaImpl.e(), a2, false, (PropertyOptions) null);
            this.X = str;
            str3 = xMPPath.toString();
        } else if (!z || z2) {
            throw new XMPException("Schema namespace URI is required", 101);
        } else {
            xMPNode = XMPNodeUtils.j(xMPMetaImpl.e(), str, false);
        }
        if (xMPNode != null) {
            this.X2 = !this.s.p() ? new NodeIterator(xMPNode, str3, 1) : new NodeIteratorChildren(xMPNode, str3);
        } else {
            this.X2 = Collections.EMPTY_LIST.iterator();
        }
    }

    public void U() {
        w1();
        this.Y = true;
    }

    /* access modifiers changed from: protected */
    public String a() {
        return this.X;
    }

    /* access modifiers changed from: protected */
    public IteratorOptions b() {
        return this.s;
    }

    /* access modifiers changed from: protected */
    public void c(String str) {
        this.X = str;
    }

    public boolean hasNext() {
        return this.X2.hasNext();
    }

    public Object next() {
        return this.X2.next();
    }

    public void remove() {
        throw new UnsupportedOperationException("The XMPIterator does not support remove().");
    }

    public void w1() {
        this.Z = true;
    }
}
