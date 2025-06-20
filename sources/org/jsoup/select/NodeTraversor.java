package org.jsoup.select;

import org.jsoup.nodes.Node;

public class NodeTraversor {

    /* renamed from: a  reason: collision with root package name */
    private NodeVisitor f31755a;

    public NodeTraversor(NodeVisitor nodeVisitor) {
        this.f31755a = nodeVisitor;
    }

    public void a(Node node) {
        Node node2 = node;
        int i2 = 0;
        while (node2 != null) {
            this.f31755a.a(node2, i2);
            if (node2.p() > 0) {
                node2 = node2.o(0);
                i2++;
            } else {
                while (node2.E() == null && i2 > 0) {
                    this.f31755a.b(node2, i2);
                    node2 = node2.U();
                    i2--;
                }
                this.f31755a.b(node2, i2);
                if (node2 != node) {
                    node2 = node2.E();
                } else {
                    return;
                }
            }
        }
    }
}
