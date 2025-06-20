package org.jsoup.nodes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.SerializationException;
import org.jsoup.helper.ChangeNotifyingArrayList;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

public abstract class Node implements Cloneable {
    private static final List<Node> Y2 = Collections.emptyList();
    List<Node> X;
    int X2;
    Attributes Y;
    String Z;
    Node s;

    private final class NodeList extends ChangeNotifyingArrayList<Node> {
        NodeList(int i2) {
            super(i2);
        }

        public void b() {
            Node.this.G();
        }
    }

    private static class OuterHtmlVisitor implements NodeVisitor {

        /* renamed from: a  reason: collision with root package name */
        private Appendable f31620a;

        /* renamed from: b  reason: collision with root package name */
        private Document.OutputSettings f31621b;

        OuterHtmlVisitor(Appendable appendable, Document.OutputSettings outputSettings) {
            this.f31620a = appendable;
            this.f31621b = outputSettings;
        }

        public void a(Node node, int i2) {
            try {
                node.L(this.f31620a, i2, this.f31621b);
            } catch (IOException e2) {
                throw new SerializationException((Throwable) e2);
            }
        }

        public void b(Node node, int i2) {
            if (!node.F().equals("#text")) {
                try {
                    node.M(this.f31620a, i2, this.f31621b);
                } catch (IOException e2) {
                    throw new SerializationException((Throwable) e2);
                }
            }
        }
    }

    protected Node() {
        this.X = Y2;
        this.Y = null;
    }

    private void X(int i2) {
        while (i2 < this.X.size()) {
            this.X.get(i2).o0(i2);
            i2++;
        }
    }

    private void d(int i2, String str) {
        Validate.j(str);
        Validate.j(this.s);
        List<Node> h2 = Parser.h(str, S() instanceof Element ? (Element) S() : null, l());
        this.s.b(i2, (Node[]) h2.toArray(new Node[h2.size()]));
    }

    private Element x(Element element) {
        Elements b1 = element.b1();
        return b1.size() > 0 ? x((Element) b1.get(0)) : element;
    }

    public boolean A(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return J().equals(((Node) obj).J());
    }

    public <T extends Appendable> T B(T t) {
        K(t);
        return t;
    }

    /* access modifiers changed from: protected */
    public void D(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        appendable.append(StringUtils.LF).append(StringUtil.j(i2 * outputSettings.h()));
    }

    public Node E() {
        Node node = this.s;
        if (node == null) {
            return null;
        }
        List<Node> list = node.X;
        int i2 = this.X2 + 1;
        if (list.size() > i2) {
            return list.get(i2);
        }
        return null;
    }

    public abstract String F();

    /* access modifiers changed from: package-private */
    public void G() {
    }

    public String J() {
        StringBuilder sb = new StringBuilder(128);
        K(sb);
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void K(Appendable appendable) {
        new NodeTraversor(new OuterHtmlVisitor(appendable, y())).a(this);
    }

    /* access modifiers changed from: package-private */
    public abstract void L(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void M(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException;

    public Document Q() {
        Node k0 = k0();
        if (k0 instanceof Document) {
            return (Document) k0;
        }
        return null;
    }

    public Node S() {
        return this.s;
    }

    public final Node U() {
        return this.s;
    }

    public Node V() {
        int i2;
        Node node = this.s;
        if (node != null && (i2 = this.X2) > 0) {
            return node.X.get(i2 - 1);
        }
        return null;
    }

    public void Y() {
        Validate.j(this.s);
        this.s.c0(this);
    }

    public String a(String str) {
        Validate.h(str);
        return !z(str) ? "" : StringUtil.k(this.Z, g(str));
    }

    /* access modifiers changed from: protected */
    public void b(int i2, Node... nodeArr) {
        Validate.f(nodeArr);
        w();
        for (int length = nodeArr.length - 1; length >= 0; length--) {
            Node node = nodeArr[length];
            f0(node);
            this.X.add(i2, node);
            X(i2);
        }
    }

    public Node b0(String str) {
        Validate.j(str);
        this.Y.L(str);
        return this;
    }

    /* access modifiers changed from: protected */
    public void c(Node... nodeArr) {
        for (Node node : nodeArr) {
            f0(node);
            w();
            this.X.add(node);
            node.o0(this.X.size() - 1);
        }
    }

    /* access modifiers changed from: protected */
    public void c0(Node node) {
        Validate.d(node.s == this);
        int i2 = node.X2;
        this.X.remove(i2);
        X(i2);
        node.s = null;
    }

    public Node e(String str) {
        d(this.X2 + 1, str);
        return this;
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public Node f(Node node) {
        Validate.j(node);
        Validate.j(this.s);
        this.s.b(this.X2 + 1, node);
        return this;
    }

    /* access modifiers changed from: protected */
    public void f0(Node node) {
        Node node2 = node.s;
        if (node2 != null) {
            node2.c0(node);
        }
        node.n0(this);
    }

    public String g(String str) {
        Validate.j(str);
        String r = this.Y.r(str);
        if (r.length() > 0) {
            return r;
        }
        return Normalizer.a(str).startsWith("abs:") ? a(str.substring(4)) : "";
    }

    /* access modifiers changed from: protected */
    public void g0(Node node, Node node2) {
        Validate.d(node.s == this);
        Validate.j(node2);
        Node node3 = node2.s;
        if (node3 != null) {
            node3.c0(node2);
        }
        int i2 = node.X2;
        this.X.set(i2, node2);
        node2.s = this;
        node2.o0(i2);
        node.s = null;
    }

    public Node h(String str, String str2) {
        this.Y.D(str, str2);
        return this;
    }

    public void h0(Node node) {
        Validate.j(node);
        Validate.j(this.s);
        this.s.g0(this, node);
    }

    public Attributes i() {
        return this.Y;
    }

    public Node k0() {
        Node node = this;
        while (true) {
            Node node2 = node.s;
            if (node2 == null) {
                return node;
            }
            node = node2;
        }
    }

    public String l() {
        return this.Z;
    }

    public void l0(final String str) {
        Validate.j(str);
        s0(new NodeVisitor() {
            public void a(Node node, int i2) {
                node.Z = str;
            }

            public void b(Node node, int i2) {
            }
        });
    }

    public Node m(String str) {
        d(this.X2, str);
        return this;
    }

    public Node n(Node node) {
        Validate.j(node);
        Validate.j(this.s);
        this.s.b(this.X2, node);
        return this;
    }

    /* access modifiers changed from: protected */
    public void n0(Node node) {
        Validate.j(node);
        Node node2 = this.s;
        if (node2 != null) {
            node2.c0(this);
        }
        this.s = node;
    }

    public Node o(int i2) {
        return this.X.get(i2);
    }

    /* access modifiers changed from: protected */
    public void o0(int i2) {
        this.X2 = i2;
    }

    public final int p() {
        return this.X.size();
    }

    public List<Node> q() {
        return Collections.unmodifiableList(this.X);
    }

    public int q0() {
        return this.X2;
    }

    /* access modifiers changed from: protected */
    public Node[] r() {
        return (Node[]) this.X.toArray(new Node[p()]);
    }

    public List<Node> r0() {
        Node node = this.s;
        if (node == null) {
            return Collections.emptyList();
        }
        List<Node> list = node.X;
        ArrayList arrayList = new ArrayList(list.size() - 1);
        for (Node next : list) {
            if (next != this) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public List<Node> s() {
        ArrayList arrayList = new ArrayList(this.X.size());
        for (Node u : this.X) {
            arrayList.add(u.clone());
        }
        return arrayList;
    }

    public Node s0(NodeVisitor nodeVisitor) {
        Validate.j(nodeVisitor);
        new NodeTraversor(nodeVisitor).a(this);
        return this;
    }

    public Node t() {
        Iterator<Attribute> it2 = this.Y.iterator();
        while (it2.hasNext()) {
            it2.next();
            it2.remove();
        }
        return this;
    }

    public Node t0() {
        Validate.j(this.s);
        Node node = this.X.size() > 0 ? this.X.get(0) : null;
        this.s.b(this.X2, r());
        Y();
        return node;
    }

    public String toString() {
        return J();
    }

    /* renamed from: u */
    public Node clone() {
        Node v = v((Node) null);
        LinkedList linkedList = new LinkedList();
        linkedList.add(v);
        while (!linkedList.isEmpty()) {
            Node node = (Node) linkedList.remove();
            for (int i2 = 0; i2 < node.X.size(); i2++) {
                Node v2 = node.X.get(i2).v(node);
                node.X.set(i2, v2);
                linkedList.add(v2);
            }
        }
        return v;
    }

    public Node u0(String str) {
        Validate.h(str);
        List<Node> h2 = Parser.h(str, S() instanceof Element ? (Element) S() : null, l());
        Node node = h2.get(0);
        if (node == null || !(node instanceof Element)) {
            return null;
        }
        Element element = (Element) node;
        Element x = x(element);
        this.s.g0(this, element);
        x.c(this);
        if (h2.size() > 0) {
            for (int i2 = 0; i2 < h2.size(); i2++) {
                Node node2 = h2.get(i2);
                node2.s.c0(node2);
                element.F0(node2);
            }
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public Node v(Node node) {
        try {
            Node node2 = (Node) super.clone();
            node2.s = node;
            node2.X2 = node == null ? 0 : this.X2;
            Attributes attributes = this.Y;
            node2.Y = attributes != null ? attributes.clone() : null;
            node2.Z = this.Z;
            node2.X = new NodeList(this.X.size());
            for (Node add : this.X) {
                node2.X.add(add);
            }
            return node2;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* access modifiers changed from: protected */
    public void w() {
        if (this.X == Y2) {
            this.X = new NodeList(4);
        }
    }

    /* access modifiers changed from: package-private */
    public Document.OutputSettings y() {
        Document Q = Q();
        if (Q == null) {
            Q = new Document("");
        }
        return Q.z3();
    }

    public boolean z(String str) {
        Validate.j(str);
        if (str.startsWith("abs:")) {
            String substring = str.substring(4);
            if (this.Y.x(substring) && !a(substring).equals("")) {
                return true;
            }
        }
        return this.Y.x(str);
    }

    protected Node(String str) {
        this(str, new Attributes());
    }

    protected Node(String str, Attributes attributes) {
        Validate.j(str);
        Validate.j(attributes);
        this.X = Y2;
        this.Z = str.trim();
        this.Y = attributes;
    }
}
